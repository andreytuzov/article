<%@ page pageEncoding="UTF-8" isELIgnored="false"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<div class="page-header">	
	<h3><fmt:message key="prop.car.header.add"/></h3>
</div>

<div class="col-sm-10"> 
	<form id="carForm" class="form-horizontal" action="/motordepot/page?action=modify_car" method="post"
			data-bv-trigger="blur"
			data-bv-feedbackicons-valid="glyphicon glyphicon-ok"
			data-bv-feedbackicons-invalid="glyphicon glyphicon-remove"
			data-bv-feedbackicons-validating="glyphicon glyphicon-refresh">
		<input type="hidden" name="id" value="${car.id}"/>
		<div class="alert" id="alert-message" style="display: none">
			<a href="#" onclick="hidden_message()" class="close">×</a>
			<span>Автомобиль был успешно добавлен. Перейти в окно просмотра</span>
		</div>
		<fieldset>
			<div class="form-group">
				<label class="control-label col-sm-2" for="prise"><fmt:message key="prop.car.column.prise"/></label>
				<div class="col-sm-5">
					<div class="input-group">
						<span class="input-group-addon"><i class="glyphicon glyphicon-usd"></i></span>
						<input type="text" class="form-control" autocomplete="off" name="prise" value="${car.prise}"
							placeholder="<fmt:message key="prop.car.column.prise.placeholder"/>"
							required data-bv-notempty-message="<fmt:message key="prop.car.column.prise.notempty"/>"
							pattern="^\d+(\.\d)?$" data-bv-regexp-message="<fmt:message key="prop.car.column.prise.regexp"/>">				
					</div>
				</div>  
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="model"><fmt:message key="prop.car.column.model"/></label>
				<div class="col-sm-10">
					<div class="input-group">
						<span class="input-group-addon"><i class="glyphicon glyphicon-road"></i></span>
						<input type="text" class="form-control" name="model" value="${car.model}" autocomplete="off"
							placeholder="<fmt:message key="prop.car.column.model.placeholder"/>" 
							required data-bv-notempty-message="<fmt:message key="prop.car.column.model.notempty"/>"
							minlength="10" maxlength="70" data-bv-stringlength-message="<fmt:message key="prop.car.column.model.regexp"/>">				
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="year"><fmt:message key="prop.car.column.year"/></label>
				<div class="col-sm-10">
					<div class="input-group">
						<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
						<input type="text" class="form-control" autocomplete="off" name="year" value="${car.year}"
							placeholder="<fmt:message key="prop.car.column.year.placeholder"/>" 
							required data-bv-notempty-message="<fmt:message key="prop.car.column.year.notempty"/>"
							pattern="^(19|20)\d\d$" data-bv-regexp-message="<fmt:message key="prop.car.column.year.regexp"/>">				
					</div>
				</div>  
			</div>    
			<div class="form-group">
				<label class="control-label col-sm-2" for="volume"><fmt:message key="prop.car.column.volume"/></label>
				<div class="col-sm-10">
					<div class="input-group">
						<span class="input-group-addon"><i class="glyphicon glyphicon-stats"></i></span>
						<input class="form-control" autocomplete="off" name="volume" value="${car.volume}"
							placeholder="<fmt:message key="prop.car.column.volume.placeholder"/>"
							required data-bv-notempty-message="<fmt:message key="prop.car.column.volume.notempty"/>"
							pattern="^\d(\.\d)?$" data-bv-regexp-message="<fmt:message key="prop.car.column.volume.regexp"/>">				
					</div>
				</div>  
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="power"><fmt:message key="prop.car.column.power"/></label>
				<div class="col-sm-10">
					<div class="input-group"> 
						<span class="input-group-addon"><i class="glyphicon glyphicon-dashboard"></i></span>
						<input type="text" class="form-control" autocomplete="off" name="power" value="${car.power}"
							placeholder="<fmt:message key="prop.car.column.power.placeholder"/>" 
							required data-bv-notempty-message="<fmt:message key="prop.car.column.power.notempty"/>"
							pattern="^\d*$" data-bv-regexp-message="<fmt:message key="prop.car.column.power.regexp"/>">				
					</div>
				</div>  
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="description"><fmt:message key="prop.car.column.description"/></label>
				<div class="col-sm-10">
					<div class="input-group">
						<span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
						<textarea rows="7" name="description" class="form-control"
							placeholder="<fmt:message key="prop.car.column.description.placeholder"/>" 
							required data-bv-notempty-message="<fmt:message key="prop.car.column.description.notempty"/>"
							minlength="10" data-bv-stringlength-message="<fmt:message key="prop.car.column.description.stringlength"/>">${car.description}</textarea>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button class="btn btn-primary"><fmt:message key="prop.form.button.save"/></button>
					<button class="btn btn-default" onclick="goback(); return false;"><fmt:message key="prop.form.button.cancel"/></button>
				</div>
			</div>
		</fieldset>
	</form>
</div>	


