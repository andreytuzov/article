$(document).ready(function() {
	$("#searchInput").on("keyup", function() {
		var value = $(this).val().toLowerCase();
		$(".searchTable tbody tr").filter(function() {
			$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		});
	});
	
	$(".searchTable").DataTable({
		language: {
		    "emptyTable":     messages["script.table.emptyTable"],
		    "info":           messages["script.table.info"],
		    "infoEmpty":      messages["script.table.infoEmpty"],
		    "infoFiltered":   messages["script.table.infoFiltered"],
		    "lengthMenu":     messages["script.table.lengthMenu"],
		    "loadingRecords": messages["script.table.loadingRecords"],
		    "processing":     messages["script.table.processing"],
		    "search":         messages["script.table.search"],
		    "zeroRecords":    messages["script.table.zeroRecords"],
		    "paginate": {
		        "first":      messages["script.table.paginate.first"],
		        "last":       messages["script.table.paginate.last"],
		        "next":       messages["script.table.paginate.next"],
		        "previous":   messages["script.table.paginate.previous"]
		    },
		    "aria": {
		        "sortAscending":  messages["script.table.aria.sortAscending"],
		        "sortDescending": messages["script.table.aria.sortDescending"]
		    }
		}
	});
	
	$("#dateFromPicker")
		.datetimepicker({
			format: "YYYY/MM/DD HH:00",
			locale: $("#locale").attr("value"),
			minDate: new Date()
		})
		.on("dp.change", function(e) {
			$("#dateToPicker").data("DateTimePicker").minDate(e.date);
			changeCarPrise();
		});
	
	$("#dateToPicker")
		.datetimepicker({
			format: "YYYY/MM/DD HH:00",
			useCurrent: false,
			locale: $("#locale").attr("value"),
			minDate: new Date()
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
						+ " <a href='/motordepot/page?action=view_car&rc_id=" + data + "'>" 
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
					location.href = "/motordepot/page?action=view_modify_deal&rd_id=" + data;
				})
				.error(function() {
					showErrorAlert(messages["script.deal.error.modify"]);
				})
		});
	
	$("#loginForm")
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
					$("#login-message").attr("class", "alert alert-danger").show();
					$("#login-message > span").html(messages["script.user.error.login"]);
				})
		});
	
	$("#modifyUserForm")
		.bootstrapValidator()
		.on("success.form.bv", function(e) {
			// Prevent form submission
			e.preventDefault();
			// Get the form instance
			var $form = $(e.target)
			// Use ajax to submit form data
			$.post($form.attr("action"), $form.serialize())
				.success(function(data) {
					alert(messages["script.user.success.modify"]); 
				})
				.error(function() {
					showErrorAlert(messages["script.user.error.modify"]);
				})
		});
	
	$("#signUpForm")
		.bootstrapValidator()
		.on("success.form.bv", function(e) {
			// Prevent form submission
			e.preventDefault();
			// Get the form instance
			var $form = $(e.target)
			// Use ajax to submit form data
			$.post($form.attr("action"), $form.serialize())
				.success(function(data) {
					alert(messages["script.user.success.signup"]);
					location.reload();
				})
				.error(function() {
					$("#signup-message").attr("class", "alert alert-danger").show();
					$("#signup-message > span").html(messages["script.user.error.signup"]);
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
function hiddenSignUpAlertMessage() {
	$("#signup-message").css("display", "none");
}
function hiddenLoginAlertMessage() {
	$("#login-message").css("display", "none");
}
function hiddenAlert() {
	$(".alert").css("display", "none");
}

function confirmDeal(dealID) {
	$.ajax({
		type: "post",
		url: "/motordepot/page?action=confirm_deal",
		data: {rd_id : dealID},
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
		data: {rd_id : dealID},
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
		data: {rd_id : dealID},
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
			data: {rd_id : dealId},
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
			data: {rc_id : carId},
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