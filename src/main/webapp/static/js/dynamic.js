$(document).ready(function() {
	$("#searchInput").on("keyup", function() {
		var value = $(this).val().toLowerCase();
		$("#searchTable tr").filter(function() {
			$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		});
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
			
			// Get the bootstrapValidator instance
			var bv = $form.data("bootstrapValidator");
			
			// Use ajax to submit form data
			$.post($form.attr("action"), $form.serialize())
				.success(function(data) { 
					$form.find(".alert").attr("class", "alert alert-success").show();
					$form.find(".alert > span").html(messages["script.car.add.success"] 
						+ " <a href='/motordepot/page?action=view_car&id=" + data + "'>" 
						+ messages["script.car.add.view"] + "</a>");
				}, "json")
				.error(function() {
					$form.find(".alert").attr("class", "alert alert-danger").show();
					$form.find(".alert > span").html(messages["script.car.add.error"]);
				});
		});
	
	$("#dealForm")
		.bootstrapValidator()
		on("status.field.bv", function(e, data) {
			var $form = $(e.target),
				
			
			
		});
});


function changeCarPrise() {	
	var sDate = $("#dateFromPicker").data("DateTimePicker").date();
	var eDate = $("#dateToPicker").data("DateTimePicker").date();
	var countHours = (eDate - sDate) / 3600000;
	if (countHours > 0) {
		var carPrise = $("#carPrise").attr("value");
		$("#totalBill").attr("value", (carPrise * countHours).toFixed(1));
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


function hidden_message() {
	$("#alert-message").css("display", "none");
}

function goback() {
	location.href = document.referrer;
}