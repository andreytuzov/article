<%@ page pageEncoding="UTF-8" isELIgnored="false"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<div class="page-header">	
	<h3><fmt:message key="prop.car.header.view"/></h3>
</div>

<div class="col-sm-10"> 
	<form id="carForm" class="form-horizontal" action="/motordepot/page?action=modify_car" method="post">
		<fieldset>
			<div class="form-group">
				<label class="control-label col-sm-2" for="rc_prise"><fmt:message key="prop.car.column.prise"/></label>
				<div class="col-sm-5">
					<div class="input-group">
						<span class="input-group-addon"><i class="glyphicon glyphicon-usd"></i></span>
						<input readonly type="text" class="form-control" name="rc_prise" value="${rc_object.prise}"/>				
					</div>
				</div>  
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="rc_model"><fmt:message key="prop.car.column.model"/></label>
				<div class="col-sm-10">
					<div class="input-group">
						<span class="input-group-addon"><i class="glyphicon glyphicon-road"></i></span>
						<input readonly type="text" class="form-control" name="rc_model" value="${rc_object.model}"/>				
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="rc_year"><fmt:message key="prop.car.column.year"/></label>
				<div class="col-sm-10">
					<div class="input-group">
						<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
						<input readonly type="text" class="form-control" name="rc_year" value="${rc_object.year}"/>				
					</div>
				</div>  
			</div>    
			<div class="form-group">
				<label class="control-label col-sm-2" for="rc_volume"><fmt:message key="prop.car.column.volume"/></label>
				<div class="col-sm-10">
					<div class="input-group">
						<span class="input-group-addon"><i class="glyphicon glyphicon-stats"></i></span>
						<input readonly class="form-control" name="rc_volume" value="${rc_object.volume}"/>				
					</div>
				</div>  
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="rc_power"><fmt:message key="prop.car.column.power"/></label>
				<div class="col-sm-10">
					<div class="input-group"> 
						<span class="input-group-addon"><i class="glyphicon glyphicon-dashboard"></i></span>
						<input readonly type="text" class="form-control" name="rc_power" value="${rc_object.power}"/>				
					</div>
				</div>  
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="rc_description"><fmt:message key="prop.car.column.description"/></label>
				<div class="col-sm-10">
					<div class="input-group">
						<span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
						<textarea readonly rows="7" name="rc_description" class="form-control">${rc_object.description}</textarea>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<c:choose>
						<c:when test="${sr_is_admin}">
							<a class="btn btn-primary" href="/motordepot/page?action=view_modify_car&rc_id=${rc_object.id}"><fmt:message key="prop.common.button.edit"/></a>
							<a class="btn btn-default" href="#" onclick="deleteCar(${rc_object.id})"><fmt:message key="prop.common.button.delete"/></a>
						</c:when>
						<c:when test="${not empty su_nickname}">
							<a class="btn btn-primary" href="/motordepot/page?action=view_modify_deal&rc_id=${rc_object.id}"><fmt:message key="prop.common.button.booking"/></a>
						</c:when>
					</c:choose>
				</div>
			</div>
		</fieldset>
	</form>
</div>	


