<%@ page pageEncoding="UTF-8" isELIgnored="false"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="page-header">
	<h3><fmt:message key="prop.deal.header"/></h3>
	
	<c:choose>
		<c:when test="${deal.state eq 'CREATED'}">
			<i><fmt:message key="prop.deal.header.placeholder.admin.created"/></i>
		</c:when>
		<c:when test="${deal.state eq 'CONFIRMED'}">
			<i><fmt:message key="prop.deal.header.placeholder.admin.confirmed"/></i>
		</c:when>
		<c:when test="${deal.state eq 'PAID'}">
			<i><fmt:message key="prop.deal.header.placeholder.admin.paid"/></i>
		</c:when>
		<c:when test="${deal.state eq 'CANCELED'}">
			<i><fmt:message key="prop.deal.header.placeholder.admin.canceled"/></i>
		</c:when>
		<c:when test="${deal.state eq 'DAMAGED'}">
			<i><fmt:message key="prop.deal.header.placeholder.admin.damaged"/></i>
		</c:when>
		<c:when test="${deal.state eq 'COMPLETED_DAMAGE'}">
			<i><fmt:message key="prop.deal.header.placeholder.admin.completed_damage"/></i>
		</c:when>
		<c:when test="${deal.state eq 'COMPLETED_SUCCESS'}">
			<i><fmt:message key="prop.deal.header.placeholder.admin.completed"/></i>
		</c:when>
		<c:when test="${deal.state eq 'ACTIVE'}">
			<i><fmt:message key="prop.deal.header.placeholder.admin.active"/></i>
		</c:when>
		<c:when test="${deal.state eq 'FINISHED'}">
			<i><fmt:message key="prop.deal.header.placeholder.admin.finished"/></i>
		</c:when>
	</c:choose>
</div>

<div class="col-sm-10"> 
	<ul class="nav nav-tabs">
		<li class="active"><a href="#main-tab" data-toggle="tab"><fmt:message key="prop.deal.tab.booking"/></a>	
		<c:if test="${deal.state eq 'CREATED' || deal.state eq 'CANCELED'}">	
			<li><a href="#cancel-tab" data-toggle="tab"><fmt:message key="prop.deal.tab.cancel"/></a></li>		
		</c:if>
		<c:if test="${deal.state eq 'FINISHED' || not empty deal.damage.description}">	
			<li><a href="#damage-tab" data-toggle="tab"><fmt:message key="prop.deal.tab.damage"/></a></li>
		</c:if>
	</ul>

 
 	<div class="tab-content" style="margin-top: 20px;">
 	
 		<div class="alert" style="display: none">
			<a href="#" onclick="hiddenAlert()" class="close">×</a>
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
							<input type="datetime" readonly class="form-control" name="dateFrom" 
								value='<fmt:formatDate pattern="yyyy/MM/dd HH:mm" value="${deal.dateFrom}"/>'/>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="dateTo"><fmt:message key="prop.deal.column.dateto"/></label>
					<div class="col-sm-10">
						<div class="input-group date" id="dateToPicker">
							<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
							<input type="datetime" readonly class="form-control" name="dateTo" 
								value="<fmt:formatDate pattern="yyyy/MM/dd HH:mm" value="${deal.dateTo}"/>"/>			
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="cost"><fmt:message key="prop.deal.column.cost"/></label>
					<div class="col-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-usd"></i></span>
							<input id="totalCost" type="text" readonly class="form-control" name="cost" value="${deal.cost}"/>
						</div>				
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="passportNumber"><fmt:message key="prop.deal.column.passportNumber"/></label>
					<div class="col-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-barcode"></i></span>
							<input type="text" class="form-control" name="passportNumber" readonly value="${deal.passportNumber}"/>
						</div>				
					</div>
				</div>
				<c:if test="${not empty deal.comment}">
					<div class="form-group">
						<label class="control-label col-sm-2" for="comment"><fmt:message key="prop.deal.column.comment"/></label>
						<div class="col-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
								<textarea rows="5" readonly class="form-control" name="comment">${deal.comment}</textarea>
							</div>
						</div>
					</div>
				</c:if>		
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<c:if test="${deal.state eq 'FINISHED'}">
							<button class="btn btn-primary" onclick="completeDeal(${deal.id}); return false;"><fmt:message key="prop.common.button.complete"/></button>
						</c:if>
						<c:if test="${deal.state eq 'CREATED'}">
							<button class="btn btn-primary" onclick="confirmDeal(${deal.id}); return false;"><fmt:message key="prop.common.button.confirm"/></button>
						</c:if>
					</div>
				</div>
			</form>
		</div>
				
		<c:if test="${deal.state eq 'CREATED' || deal.state eq 'CANCELED'}">
			<div class="tab-pane" id="cancel-tab">
				<form id="cancelDealForm" class="form-horizontal" action="/motordepot/page?action=cancel_deal" method="post"
					data-bv-trigger="blur"
					data-bv-feedbackicons-valid="glyphicon glyphicon-ok"
					data-bv-feedbackicons-invalid="glyphicon glyphicon-remove"
					data-bv-feedbackicons-validating="glyphicon glyphicon-refresh">
					
					<input type="hidden" name="id" value="${deal.id}"/>
					
					<div class="form-group">
						<label class="control-label col-sm-2" for="cancelReason"><fmt:message key="prop.deal.column.cancel.reason"/></label>
						<div class="col-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
								<c:choose>
									<c:when test="${deal.state eq 'CREATED'}">
										<textarea rows="5" class="form-control" name="cancelReason"
											placeholder="<fmt:message key="prop.deal.column.cancel.reason.placeholder"/>"
											minLength="10" maxLength="200" data-bv-stringlength-message="<fmt:message key="prop.deal.column.cancel.reason.stringlength"/>"
											required data-bv-notempty-message="<fmt:message key="prop.deal.column.cancel.reason.notempty"/>">${deal.cancelReason}</textarea>
									</c:when>
									<c:otherwise>
										<textarea rows="5" class="form-control" readonly name="cancelReason">${deal.cancelReason}</textarea>
									</c:otherwise>
								</c:choose>
								
							</div>
						</div>
					</div>
					<c:if test="${deal.state eq 'CREATED'}">
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button class="btn btn-primary"><fmt:message key="prop.common.button.cancel"/></button>
							</div>
						</div>
					</c:if>
				</form>
			</div>
		</c:if>
			
		<c:if test="${deal.state eq 'FINISHED' || not empty deal.damage.description}">
			<div class="tab-pane" id="damage-tab">
				<form id="damageDealForm" class="form-horizontal" action="/motordepot/page?action=damage_car" method="post"
					data-bv-trigger="blur"
					data-bv-feedbackicons-valid="glyphicon glyphicon-ok"
					data-bv-feedbackicons-invalid="glyphicon glyphicon-remove"
					data-bv-feedbackicons-validating="glyphicon glyphicon-refresh">
				
					<input type="hidden" name="id" value="${deal.id}"/>
			
					<div class="form-group">
						<label class="control-label col-sm-2" for="damage_cost"><fmt:message key="prop.deal.column.damage.cost"/></label>
						<div class="col-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="glyphicon glyphicon-usd"></i></span>
								<c:choose>
									<c:when test="${deal.state eq 'FINISHED'}">
										<input id="totalCost" type="text" id="damage_cost" class="form-control" name="damage_cost" 
											placeholder="<fmt:message key="prop.deal.column.damage.cost.placeholder"/>"
											required data-bv-notempty-message="<fmt:message key="prop.deal.column.damage.cost.notempty"/>"
											pattern="^\d+(\.\d)?$" data-bv-regexp-message="<fmt:message key="prop.deal.column.damage.cost.regexp"/>"
											value="${deal.damage.cost}"/>
									</c:when>
									<c:otherwise>
										<input type="text" readonly class="form-control" name="damage_cost" 
											value="${deal.damage.cost}"/>
									</c:otherwise>
								</c:choose>
							</div>				
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="damage_description"><fmt:message key="prop.deal.column.damage.description"/></label>
						<div class="col-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
								<c:choose>
									<c:when test="${deal.state eq 'FINISHED'}">
										<textarea rows="5" class="form-control" name="damage_description"
											placeholder="<fmt:message key="prop.deal.column.damage.description.placeholder"/>"
											required data-bv-notempty-message="<fmt:message key="prop.deal.column.damage.description.notempty"/>"
											minLength="10" maxlength="200" data-bv-stringlength-message="<fmt:message key="prop.deal.column.damage.description.stringlength"/>">${deal.damage.description}</textarea>
									</c:when>
									<c:otherwise>
										<textarea rows="5" class="form-control" readonly name="damage_description">${deal.damage.description}</textarea>
									</c:otherwise>
								</c:choose>
							</div>
						</div>
					</div>
					
					<c:if test="${deal.state eq 'FINISHED'}">
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button class="btn btn-primary"><fmt:message key="prop.common.button.save"/></button>
							</div>
						</div>
					</c:if>
					
				</form>		
			</div>
		</c:if>
	</div> 
</div>	


