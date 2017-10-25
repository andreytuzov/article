<%@ page pageEncoding="UTF-8" isELIgnored="false"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="page-header">
	<h3>Добавление заказа аренды</h3>
</div>

<div class="col-sm-10"> 
	<form id="dealForm" class="form-horizontal" action="/motordepot/page?action=modify_deal" method="post"
			data-bv-trigger="blur"
			data-bv-feedbackicons-valid="glyphicon glyphicon-ok"
			data-bv-feedbackicons-invalid="glyphicon glyphicon-error"
			data-bv-feedbackicons-validating="glyphicon glyphicon-refresh">
		<input type="hidden" name="id" value="${deal.id}"/>
		<div class="form-group">
			<label class="control-label col-sm-2" for="bill">CAR MODEL</label>
			<div class="col-sm-10">
				<input type="text" readonly class="form-control" 
					name="model" value="${car.model}">				
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="dateFrom">DATE FROM</label>
			<div class="col-sm-10">
				<div class="input-group date" id="dateFromPicker">
					<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
					<input type="text" autofocus class="form-control" name="dateFrom" value="${deal.dateFrom}"
						required data-bv-notempty-message="Start date can't be empty">			
				</div>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="dateTo">DATE TO</label>
			<div class="col-sm-10">
				<div class="input-group date" id="dateToPicker">
					<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
					<input type="text" autofocus required class="form-control" name="dateTo" value="${deal.dateTo}">				
				</div>
			</div>
		</div>
		
		<div class="form-group">
			<label class="control-label col-sm-2" for="bill">BILL</label>
			<div class="col-sm-10">
				<input type="text" id="bill" readonly class="form-control" 
					name="bill" value="${deal.bill}" value="0">				
			</div>
		</div>
					
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button class="btn btn-primary"><fmt:message key="prop.form.button.save"/></button>
				<button class="btn btn-default" onclick="goback(); return false;"><fmt:message key="prop.form.button.cancel"/></button>
			</div>
		</div> 
	</form>
</div>	


