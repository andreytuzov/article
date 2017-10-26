<%@ page pageEncoding="UTF-8" isELIgnored="false"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="page-header">
	<h3><fmt:message key="prop.deal.header"/></h3>
	
	<c:choose>
		<c:when test="${deal.state eq 'CREATED'}">
			<i>Редактирование заказа</i>
		</c:when>
		<c:when test="${deal.state eq 'CONFIRMED'}">
			<i>Заказ подтвержден администратором. Ожидание оплаты</i>
		</c:when>
		<c:when test="${deal.state eq 'PAID'}">
			<i>Заказ оплачен. Можете приезжать за автомобилем</i>
		</c:when>
		<c:when test="${deal.state eq 'CANCELED'}">
			<i>Заказ отказан администратором</i>
		</c:when>
		<c:when test="${deal.state eq 'COMPLETED'}">
			<i>Заказ успешно завершен</i>
		</c:when>
	</c:choose>
</div>

<div class="col-sm-10"> 
	<ul class="nav nav-tabs">
		<li class="active"><a href="#main-tab" data-toggle="tab"><fmt:message key="prop.deal.tab.booking"/></a>		
		<li><a href="#cancel-tab" data-toggle="tab"><fmt:message key="prop.deal.tab.cancel"/></a></li>		
		<li><a href="#damage-tab" data-toggle="tab"><fmt:message key="prop.deal.tab.damage"/></a></li>
	</ul>

 
 	<div class="tab-content" style="margin-top: 20px;">
 	
 		<div class="alert" id="alert-message" style="display: none">
			<a href="#" onclick="hidden_message()" class="close">×</a>
			<span></span>
		</div>
 	
 	
		<div class="tab-pane active" id="main-tab">
 			<form id="modifyDealForm" class="form-horizontal" action="/motordepot/page?action=modify_deal" method="post"
				data-bv-trigger="blur"
				data-bv-feedbackicons-valid="glyphicon glyphicon-ok"
				data-bv-feedbackicons-invalid="glyphicon glyphicon-remove"
				data-bv-feedbackicons-validating="glyphicon glyphicon-refresh">
				
				<input type="hidden" name="id" value="${deal.id}"/>
				<input type="hidden" name="carId" value="${car.id}"/>				
				<input type="hidden" id="carPrise" value="${car.prise}"/>
				 
				<div class="form-group">
					<label class="control-label col-sm-2" for="model"><fmt:message key="prop.deal.column.car"/></label>
					<div class="col-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-road"></i></span>
							<input type="text" readonly class="form-control" 
								name="model" value="${car.model}">				
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="dateFrom"><fmt:message key="prop.deal.column.datefrom"/></label>
					<div class="col-sm-10">
						<div class="input-group date" id="dateFromPicker">
							<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
							<input type="datetime" required class="form-control" name="dateFrom" 
								value='<fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${deal.dateFrom}"/>'
								placeholder="<fmt:message key="prop.deal.column.datefrom.placeholder"/>"
								required data-bv-notempty-message="<fmt:message key="prop.deal.column.datefrom.notempty"/>">
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="dateTo"><fmt:message key="prop.deal.column.dateto"/></label>
					<div class="col-sm-10">
						<div class="input-group date" id="dateToPicker">
							<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
							<input type="datetime" required class="form-control" name="dateTo" 
								value="<fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${deal.dateTo}"/>"
								placeholder="<fmt:message key="prop.deal.column.dateto.placeholder"/>"
								required data-bv-notempty-message="<fmt:message key="prop.deal.column.dateto.notempty"/>">			
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="cost"><fmt:message key="prop.deal.column.cost"/></label>
					<div class="col-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-usd"></i></span>
							<input id="totalCost" type="text" id="cost" readonly class="form-control" name="cost" 
								value="${deal.cost}"/>
						</div>				
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="comment"><fmt:message key="prop.deal.column.comment"/></label>
					<div class="col-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
							<textarea rows="5" class="form-control" name="comment"
								placeholder="<fmt:message key="prop.deal.column.comment.placeholder"/>"
								maxlength="200" data-bv-stringlength-message="<fmt:message key="prop.deal.column.comment.stringlength"/>">${deal.comment}</textarea>
						</div>
					</div>
				</div>		
				
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button class="btn btn-primary"><fmt:message key="prop.form.button.save"/></button>
						<button class="btn btn-primary" onclick="confirmDeal(${deal.id}); return false;"><fmt:message key="prop.form.button.confirm"/></button>
						<button class="btn btn-primary" onclick="payDeal(${deal.id}); return false;"><fmt:message key="prop.form.button.pay"/></button>
						<button class="btn btn-default" onclick="goback(); return false;"><fmt:message key="prop.form.button.back"/></button>
					</div>
				</div>
			</form>
		</div>
				
		<div class="tab-pane" id="cancel-tab">
			<form id="cancelDealForm" class="form-horizontal" action="/motordepot/page?action=cancel_deal" method="post"
				data-bv-trigger="blur"
				data-bv-feedbackicons-valid="glyphicon glyphicon-ok"
				data-bv-feedbackicons-invalid="glyphicon glyphicon-remove"
				data-bv-feedbackicons-validating="glyphicon glyphicon-refresh">
				
				<input type="hidden" name="id" value="${deal.id}"/>
				
				<div class="form-group">
					<label class="control-label col-sm-2" for="cancelReason"><fmt:message key="prop.deal.column.reason"/></label>
					<div class="col-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
							<textarea rows="5" class="form-control" name="cancelReason"
								minLength="10" maxLength="200" data-bv-stringlength-message="<fmt:message key="prop.deal.column.reason.stringlength"/>"
								required data-bv-notempty-message="<fmt:message key="prop.deal.column.reason.notempty"/>">${deal.cancelReason}</textarea>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button class="btn btn-primary"><fmt:message key="prop.form.button.cancel"/></button>
						<button class="btn btn-default" onclick="goback(); return false;"><fmt:message key="prop.form.button.back"/></button>
					</div>
				</div>
			</form>
		</div>
			
		<div class="tab-pane" id="damage-tab">
			<form id="damageDealForm" class="form-horizontal" action="/motordepot/page?action=modify_deal" method="post"
				data-bv-trigger="blur"
				data-bv-feedbackicons-valid="glyphicon glyphicon-ok"
				data-bv-feedbackicons-invalid="glyphicon glyphicon-remove"
				data-bv-feedbackicons-validating="glyphicon glyphicon-refresh">
		
				<div class="form-group">
					<label class="control-label col-sm-2" for="damage_bill">BILL</label>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-usd"></i></span>
							<input id="totalBill" type="text" id="damage_bill" class="form-control" name="damage_bill" 
								value="${deal.damage.cost}"/>
						</div>				
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="damage_description">DESCRIPTION</label>
					<div class="col-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
							<textarea rows="5" class="form-control" name="damage_description"></textarea>
						</div>
					</div>
				</div>
			</form>		
		</div>
	</div> 
</div>	


