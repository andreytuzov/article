<%@ page pageEncoding="UTF-8" isELIgnored="false"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="page-header">
	<h3><fmt:message key="prop.deal.header"/></h3>
</div>

<div class="col-sm-10"> 
	<ul class="nav nav-tabs">
		<li class="active"><a href="#main-tab" data-toggle="tab"><fmt:message key="prop.deal.tab.booking"/></a>		
		<c:if test="${admin}">
			<c:if test="${deal.state eq CREATED}">
				<li><a href="#cancel-tab" data-toggle="tab"><fmt:message key="prop.deal.tab.cancel"/></a></li>		
			</c:if>
			<c:if test="${deal.state eq PAID}">
				<li><a href="#damage-tab" data-toggle="tab"><fmt:message key="prop.deal.tab.damage"/></a></li>
			</c:if>
		</c:if>
	</ul>
 
 	<div class="tab-content" style="margin-top: 20px;">
		<div class="tab-pane active" id="main-tab">
 			<form id="modifyDealForm" class="form-horizontal" action="/motordepot/page?action=modify_deal" method="post"
				data-bv-trigger="blur"
				data-bv-feedbackicons-valid="glyphicon glyphicon-ok"
				data-bv-feedbackicons-invalid="glyphicon glyphicon-remove"
				data-bv-feedbackicons-validating="glyphicon glyphicon-refresh">
				
				<input type="hidden" name="id" value="${deal.id}"/>
				<input type="hidden" name="carId" value="${car.id}"/>
				
				<input type="hidden" id="carPrise" value="${car.prise}"/>
				<input type="hidden" id="isAdmin" value="${admin}"/> 
				 
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
						<c:choose>
							<c:when test="${admin}">
								<button class="btn btn-primary"><fmt:message key="prop.form.button.confirm"/></button>
							</c:when>
							<c:otherwise>
								<button class="btn btn-primary"><fmt:message key="prop.form.button.save"/></button>
							</c:otherwise>
						</c:choose>
						<button class="btn btn-default" onclick="goback(); return false;"><fmt:message key="prop.form.button.back"/></button>
					</div>
				</div>
			</form>
		</div>
				
		<div class="tab-pane" id="cancel-tab">
			<form id="cancelDealForm" class="form-horizontal" action="/motordepot/page?action=modify_deal" method="post"
				data-bv-trigger="blur"
				data-bv-feedbackicons-valid="glyphicon glyphicon-ok"
				data-bv-feedbackicons-invalid="glyphicon glyphicon-remove"
				data-bv-feedbackicons-validating="glyphicon glyphicon-refresh">
		
				<div class="form-group">
					<label class="control-label col-sm-2" for="reason">REASON</label>
					<div class="col-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
							<textarea rows="5" class="form-control" name="reason"
								required data-bv-notempty-message="Reason can't be empty"></textarea>
						</div>
					</div>
				</div>
				
				
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button class="btn btn-primary">cancel</button>
						<button class="btn btn-default" onclick="goback(); return false;">back</button>
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


