$(document).ready(function() {
	$("#searchInput").on("keyup", function() {
		var value = $(this).val().toLowerCase();
		$(".searchTable tbody tr").filter(function() {
			$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		});
	});
	
	$(".searchTable").DataTable({
		language: {
			"decimal":        "",
		    "emptyTable":     "No data available in table",
		    "info":           "Showing _START_ to _END_ of _TOTAL_ entries",
		    "infoEmpty":      "Showing 0 to 0 of 0 entries",
		    "infoFiltered":   "(filtered from _MAX_ total entries)",
		    "infoPostFix":    "",
		    "thousands":      ",",
		    "lengthMenu":     "Show _MENU_ entries",
		    "loadingRecords": "Loading...",
		    "processing":     "Processing...",
		    "search":         "Search:",
		    "zeroRecords":    "No matching records found",
		    "paginate": {
		        "first":      "First",
		        "last":       "Last",
		        "next":       "Next",
		        "previous":   "Previous"
		    },
		    "aria": {
		        "sortAscending":  ": activate to sort column ascending",
		        "sortDescending": ": activate to sort column descending"
		    }
		}
	});
	
	$("#dateFromPicker")
		.datetimepicker({
			format: "DD/MM/YYYY HH:00",
			locale: "ru"
		})
		.on("dp.change", function(e) {
			$("#dateToPicker").data("DateTimePicker").minDate(e.date);
			changeCarPrise();
		});
	
	$("#dateToPicker")
		.datetimepicker({
			format: "DD/MM/YYYY HH:00",
			useCurrent: false,
			locale: "ru"
		})
		.on("dp.change", function(e) {
			$("#dateFromPicker").data("DateTimePicker").maxDate(e.date);
			changeCarPrise();
		});
	
	$("#carForm") 
		.bootstrapValidator()
		.on("success.form.bv", function(e) {
			// Prevent form submission
			e.preventDefault();			
			// Get the form instance
			var $form = $(e.target); 
			// Use ajax to submit form data
			$.post($form.attr("action"), $form.serialize())
				.success(function(data) { 
					$(".alert").attr("class", "alert alert-success").show();
					$(".alert > span").html(messages["script.car.success.add"] 
						+ " <a href='/motordepot/page?action=view_car&id=" + data + "'>" 
						+ messages["script.car.other.view"] + "</a>");
				}, "json")
				.error(function() {
					showErrorAlert(messages["script.car.error.modify"]);
				});
		});
	$("#modifyDealForm")
		.bootstrapValidator()
		.on("success.form.bv", function(e) {
			// Prevent form submission
			e.preventDefault();
			// Get the form instance
			var $form = $(e.target)
			// Use ajax to submit form data
			$.post($form.attr("action"), $form.serialize())
				.success(function(data) {
					alert(messages["script.deal.success.modify"]); 
					location.href = "/motordepot/page?action=view_modify_deal&id=" + data;
				})
				.error(function() {
					showErrorAlert(messages["script.deal.error.modify"]);
				})
		});
	$("#cancelDealForm")
		.bootstrapValidator()
		.on("success.form.bv", function(e) {
			// Prevent form submission
			e.preventDefault();
			// Get the form instance
			var $form = $(e.target)
			// Use ajax to submit form data
			$.post($form.attr("action"), $form.serialize())
				.success(function(data) {
					location.reload();
				})
				.error(function() {
					showErrorAlert(messages["script.deal.error.cancel"]);
				})
		});
	
	$("#damageDealForm")
		.bootstrapValidator()
		.on("success.form.bv", function(e) {
			// Prevent form submission
			e.preventDefault();
			// Get the form instance
			var $form = $(e.target)
			// Use ajax to submit form data
			$.post($form.attr("action"), $form.serialize())
				.success(function(data) {
					location.reload();
				})
				.error(function() {
					showErrorAlert(messages["script.deal.error.damage"]);
				})
		});
	
});

function showErrorAlert(errorMsg) {
	$(".alert").attr("class", "alert alert-danger").show();
	$(".alert > span").html(errorMsg);
}
function hiddenAlert() {
	$(".alert").css("display", "none");
}

function confirmDeal(dealID) {
	$.ajax({
		type: "post",
		url: "/motordepot/page?action=confirm_deal",
		data: {id : dealID},
		success: function() {
			location.reload();
		},
		error: function() {
			showErrorAlert(messages["script.deal.error.confirm"]);
		}
	})
}

function completeDeal(dealID) {	
	$.ajax({
		type: "post",
		url: "/motordepot/page?action=complete_deal",
		data: {id : dealID},
		success: function() {
			location.reload();
		},
		error: function() {
			showErrorAlert(messages["script.deal.error.complete"]);
		}
	})
}


function payDeal(dealID) {	
	$.ajax({
		type: "post",
		url: "/motordepot/page?action=pay_deal",
		data: {id : dealID},
		success: function() {
			location.reload();
		},
		error: function() {
			showErrorAlert(messages["script.deal.error.pay"]);
		}
	})
}


function changeCarPrise() {	
	var sDate = $("#dateFromPicker").data("DateTimePicker").date();
	var eDate = $("#dateToPicker").data("DateTimePicker").date();
	var countHours = (eDate - sDate) / 3600000;
	if (countHours > 0) {
		var carPrise = $("#carPrise").attr("value");
		$("#totalCost").attr("value", (carPrise * countHours).toFixed(1));
	}
}

function deleteDeal(dealId) {	
	var result = confirm(messages["script.deal.confirm.delete"]);
	if (result) {
		$.ajax({
			type: "post",
			url: "/motordepot/page?action=delete_deal",
			data: {id : dealId},
			success: function() {
				alert(messages["script.deal.succes.delete"]);
				location.href="/motordepot/page?action=view_car_list";
			},
			error: function() {
				showErrorAlert(messages["script.deal.error.delete"]);
			}
		});
	}
}

function deleteCar(carId) {	
	var result = confirm(messages["script.deal.confirm.delete"]);
	if (result) {
		$.ajax({
			type: "post",
			url: "/motordepot/page?action=delete_car",
			data: {id : carId},
			success: function() {
				alert(messages["script.deal.success.delete"]);
				location.href="/motordepot/page?action=view_car_list";
			},
			error: function() {
				alert(messages["script.deal.error.delete"]);
			}
		});
	}
}

function goback() {
	location.href = document.referrer;
}