$(document).ready(function() {
	$("#searchInput").on("keyup", function() {
		var value = $(this).val().toLowerCase();
		$("#searchTable tr").filter(function() {
			$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		});
	});
	$("#carTable").DataTable();
	
	$("#dateFromPicker")
		.datepicker({
			format: "mm/dd/yyyy"
		})
		.on("changeDate", function(e) {
			$("#dealForm").formValidation("revalidateField", "dateFrom");
		});
	
	$("#dateToPicker")
		.datepicker({
			format: "mm/dd/yyyy"
		});
	
	
	$("#carForm")
		.bootstrapValidator({
			feedbackIcons: {
				valid: "glyphicon glyphicon-ok",
				invalid: "glyphicon glyphicon-error",
				validating: "glyphicon glyphicon-refresh"
			},
			fields: {
				model: {
					validators: {
						stringLength: {
							min: 10,
							max: 70,
							message: "The model must be more than 10 and less than 70 characters long"
						},
						notEmpty: {
							message: "Please supply a model of the car"
						}
					}
				},
				year: {
					validators: {
						notEmpty: {
							message: "The year is requeired and can't be empty"
						},
						regexp: {
							regexp: /^(19|20)\d\d$/,
							message: "The year must match 19xx or 20xx"
						}
					}
				},
				volume: {
					validators: {
						notEmpty: {
							message: "Please supply a volume of the car"
						},
						regexp: {
							regexp: /^\d\.\d$/,
							message: "The volume must match: x.x"
						}
					}
				},
				power: {
					validators: {
						notEmpty: {
							message: "Please supply a power of the car"
						},
						regexp: {
							regexp: /^\d*$/,
							message: "The power must be integer"
						}
					}
				},
				prise: {
					validators: {
						notEmpty: {
							message: "Please supply a prise of the car"
						},
						regexp: {
							regexp: /^\d+(\.\d)?$/,
							message: "The prise must match (X).X"
						}
					}
				},
				discount: {
					validators: {
						notEmpty: {
							message: "Please supply a discount of the car"
						}
					}
				},
				description: {
					validators: {
						stringLength: {
							min: 10,
							message: "Please enter at least 10 characters"
						},
						notEmpty: {
							message: "Please supply a description of the car"
						}
					}
				}
			}
		});
		
	
	
	
});

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