<%@ page pageEncoding="UTF-8" isELIgnored="false"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container"> 
	
	<h3>ПРОСМОТР АВТОМОБИЛЯ</h3>

	<form class="form-horizontal" action="/motordepot/page?action=modify_car" method="post">
		<input type="hidden" name="id" value="${car.id}"/>
		<div class="form-group">
			<label class="control-label col-sm-2 "><fmt:message key="prop.table.car.column.model"/></label>
			<div class="col-sm-10">
				<input type="text" readonly class="form-control" name="model" value="${car.model}">
			</div>  
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="year"><fmt:message key="prop.table.car.column.year"/></label>
			<div class="col-sm-10">
				<input type="text" readonly class="form-control" name="model" value="${car.year}">				
			</div>  
		</div>    
		<div class="form-group">
			<label class="control-label col-sm-2" for="volume"><fmt:message key="prop.table.car.column.volume"/></label>
			<div class="col-sm-10">
				<input type="text" readonly class="form-control" name="model" value="${car.volume}">
			</div>  
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="power"><fmt:message key="prop.table.car.column.power"/></label>
			<div class="col-sm-10">
				<input type="text" readonly class="form-control" name="model" value="${car.power}">
			</div>  
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="prise"><fmt:message key="prop.table.car.column.prise"/></label>
			<div class="col-sm-10">
				<input type="text" readonly class="form-control" name="model" value="${car.prise}">
			</div>  
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="discount"><fmt:message key="prop.table.car.column.discount"/></label>
			<div class="col-sm-10">
				<input type="text" readonly class="form-control" name="model" value="${car.discount.name}">
			</div>  
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="description"><fmt:message key="prop.table.car.column.description"/></label>
			<div class="col-sm-10">
				<textarea rows="10" readonly name="description" class="form-control">${car.description}</textarea>				
			</div>  
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<a class="btn btn-primary" href="/motordepot/page?action=view_modify_car&id=${car.id}"><fmt:message key="prop.form.button.edit"/></a>
				<a class="btn btn-default" onclick="deleteCar(${car.id})" href="#"><fmt:message key="prop.form.button.delete"/></a>
			</div>
		</div> 
	</form>
</div>	


