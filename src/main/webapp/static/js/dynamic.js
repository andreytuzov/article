$(document).ready(function() {
	$("#searchInput").on("keyup", function() {
		var value = $(this).val().toLowerCase();
		$("#searchTable tr").filter(function() {
			$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		});
	});
	
	$("#main-tab").find("input").attr("readonly");
	
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
					$(".alert > span").html(messages["script.car.add.success"] 
						+ " <a href='/motordepot/page?action=view_car&id=" + data + "'>" 
						+ messages["script.car.add.view"] + "</a>");
				}, "json")
				.error(function() {
					$(".alert").attr("class", "alert alert-danger").show();
					$(".alert > span").html(messages["script.car.add.error"]);
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
					showAccessAlert();
				})
				.error(function() {
					showErrorAlert();
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
					showAccessAlert();
				})
				.error(function() {
					showErrorAlert();
				})
		});
	
	formValidation("#damageDealForm", messages["script.car.add.success"], messages["script.car.add.error"]);
});


function formValidation(formId, successMsg, errorMsg) {
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
					showAccessAlert();
				})
				.error(function() {
					showErrorAlert();
				})
		});
}

function showAccessAlert() {
	$(".alert").attr("class", "alert alert-success").show();
	$(".alert > span").html(messages["script.car.add.success"]);
}
function showErrorAlert() {
	$(".alert").attr("class", "alert alert-danger").show();
	$(".alert > span").html(messages["script.car.add.error"]);
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
			$(".alert").attr("class", "alert alert-success").show();
			$(".alert > span").html(messages["script.car.add.success"]);
		},
		error: function() {
			showErrorAlert();
		}
	})
}

function completeDeal(dealID) {	
	$.ajax({
		type: "post",
		url: "/motordepot/page?action=complete_deal",
		data: {id : dealID},
		success: function() {
			showAccessAlert();
		},
		error: function() {
			showErrorAlert();
		}
	})
}


function payDeal(dealID) {	
	$.ajax({
		type: "post",
		url: "/motordepot/page?action=pay_deal",
		data: {id : dealID},
		success: function() {
			showAccessAlert();
		},
		error: function() {
			showErrorAlert();
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
	var result = confirm("Вы уверены ?");
	if (result) {
		$.ajax({
			type: "post",
			url: "/motordepot/page?action=delete_deal",
			data: {id : dealId},
			success: function() {
				showAccessAlert();
			},
			error: function() {
				showErrorAlert();
			}
		});
	}
}

function deleteCar(carId) {	
	var result = confirm("Вы уверены ?");
	if (result) {
		$.ajax({
			type: "post",
			url: "/motordepot/page?action=delete_car",
			data: {id : carId},
			success: function() {
				alert("Запись была успешно удалена");
				location.href="/motordepot/page?action=view_car_list";
			},
			error: function() {
				alert("Ошибка при удалении записи");
			}
		});
	}
}

function goback() {
	location.href = document.referrer;
}