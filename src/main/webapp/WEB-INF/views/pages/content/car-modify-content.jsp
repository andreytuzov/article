<%@ page pageEncoding="UTF-8" isELIgnored="false"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<div class="page-header" style="margin-top: 0px;">	
	<h3>Добавление автомобиля</h3>
</div>

<div class="col-sm-offset-1 col-sm-10"> 
	<form id="carForm" class="form-horizontal" action="/motordepot/page?action=modify_car" method="post">
		<input type="hidden" name="id" value="${car.id}"/>
		<fieldset>
			<legend>Цена аренды</legend>
			<div class="col-sm-10 col-sm-offset-1">
				<div class="form-group">
					<label class="control-label col-sm-2" for="prise"><fmt:message key="prop.table.car.column.prise"/></label>
					<div class="col-sm-5">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-usd"></i></span>
							<input type="text" class="form-control" autocomplete="off" 
								placeholder="<fmt:message key="prop.table.car.column.prise.placeholder"/>" name="prise" value="${car.prise}">				
						</div>
					</div>  
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="discount"><fmt:message key="prop.table.car.column.discount"/></label>
					<div class="col-sm-5">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-thumbs-up"></i></span>
							<select class="form-control" name="discount">
								<option value>Select a discount</option>
								<option value="1"><fmt:message key="prop.table.car.column.discount.low"/></option> 
								<option value="2"><fmt:message key="prop.table.car.column.discount.middle"/></option>
								<option value="3"><fmt:message key="prop.table.car.column.discount.high"/></option>
							</select>				
						</div>
					</div>  
				</div>
			</div>
		</fieldset>
		<fieldset>
			<legend>Характеристики автомобиля</legend>
			<div class="col-sm-10 col-sm-offset-1">			
				<div class="form-group">
					<label class="control-label col-sm-2" for="model"><fmt:message key="prop.table.car.column.model"/></label>
					<div class="col-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-road"></i></span>
							<input type="text" class="form-control" placeholder="<fmt:message key="prop.table.car.column.model.placeholder"/>" 
								name="model" value="${car.model}" autofocus="autofocus" autocomplete="off">				
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="year"><fmt:message key="prop.table.car.column.year"/></label>
					<div class="col-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
							<input type="text" class="form-control" autocomplete="off"
								placeholder="<fmt:message key="prop.table.car.column.year.placeholder"/>" name="year" value="${car.year}" data-error="Некорректный год">				
						</div>
					</div>  
				</div>    
				<div class="form-group">
					<label class="control-label col-sm-2" for="volume"><fmt:message key="prop.table.car.column.volume"/></label>
					<div class="col-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-stats"></i></span>
							<input class="form-control" autocomplete="off"
								placeholder="<fmt:message key="prop.table.car.column.volume.placeholder"/>" name="volume" value="${car.volume}">				
						</div>
					</div>  
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="power"><fmt:message key="prop.table.car.column.power"/></label>
					<div class="col-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-dashboard"></i></span>
							<input type="text" class="form-control" autocomplete="off"
								placeholder="<fmt:message key="prop.table.car.column.power.placeholder"/>" name="power" value="${car.power}">				
						</div>
					</div>  
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="description"><fmt:message key="prop.table.car.column.description"/></label>
					<div class="col-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
							<textarea rows="7" name="description" 
								placeholder="<fmt:message key="prop.table.car.column.description.placeholder"/>" class="form-control">${car.description}</textarea>				
						</div>
					</div>
				</div>
			</div>
		</fieldset>
		<div class="col-sm-offset-1">
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button class="btn btn-primary"><fmt:message key="prop.form.button.save"/></button>
					<button class="btn btn-default" onclick="goback(); return false;"><fmt:message key="prop.form.button.cancel"/></button>
				</div>
			</div>
		</div> 
	</form>
</div>	


