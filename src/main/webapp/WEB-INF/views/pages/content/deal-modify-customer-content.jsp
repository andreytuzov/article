<%@ page pageEncoding="UTF-8" isELIgnored="false"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="page-header">
	<h3><fmt:message key="prop.deal.header"/></h3>
	
	<c:choose>
		<c:when test="${deal.state eq 'CREATED'}">
			<i><fmt:message key="prop.deal.header.placeholder.customer.created"/></i>
		</c:when>
		<c:when test="${deal.state eq 'CONFIRMED'}">
			<i><fmt:message key="prop.deal.header.placeholder.customer.confirmed"/></i>
		</c:when>
		<c:when test="${deal.state eq 'PAID'}">
			<i><fmt:message key="prop.deal.header.placeholder.customer.paid"/></i>
		</c:when>
		<c:when test="${deal.state eq 'CANCELED'}">
			<i><fmt:message key="prop.deal.header.placeholder.customer.canceled"/></i>
		</c:when>
		<c:when test="${deal.state eq 'DAMAGED'}">
			<i><fmt:message key="prop.deal.header.placeholder.customer.damaged"/></i>
		</c:when>
		<c:when test="${$deal.state eq 'COMPLETED_DAMAGE' || deal.state eq 'COMPLETED_SUCCESS'}">
			<i><fmt:message key="prop.deal.header.placeholder.customer.completed"/></i>
		</c:when>
		<c:otherwise>
			<i><fmt:message key="prop.deal.header.placeholder.customer.other"/></i>
		</c:otherwise>
	</c:choose>
</div>

<div class="col-sm-10"> 
	<ul class="nav nav-tabs">
		<li class="active"><a href="#main-tab" data-toggle="tab"><fmt:message key="prop.deal.tab.booking"/></a>	
		<c:if test="${deal.state eq 'CANCELED'}">	
			<li><a href="#cancel-tab" data-toggle="tab"><fmt:message key="prop.deal.tab.cancel"/></a></li>		
		</c:if>
		<c:if test="${not empty deal.damage.description}">	
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
				<input type="hidden" id="locale" value="${language}"/>

				<c:if test="${not empty carSchedule && carSchedule.size() ne 0}">
					<div class="form-group">
						<label class="control-label col-sm-2" for="dateFrom"><fmt:message key="prop.deal.column.busydate"/></label>
						<div class="col-sm-10">
							<div class="alert alert-info">
								<c:forEach var="item" items="${carSchedule}">
									<i><fmt:formatDate pattern="yyyy/MM/dd HH:mm" value="${item.dateFrom}"/> - <fmt:formatDate pattern="yyyy/MM/dd HH:mm" value="${item.dateFrom}"/></i>
									<br/>
								</c:forEach>
							</div>
						</div>
					</div>
				</c:if>
				 
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
							<c:choose>
								<c:when test="${empty deal.state || deal.state eq 'CREATED'}">
									<input type="datetime" required class="form-control" name="dateFrom" 
										value='<fmt:formatDate pattern="yyyy/MM/dd HH:mm" value="${deal.dateFrom}"/>'
										placeholder="<fmt:message key="prop.deal.column.datefrom.placeholder"/>"
										required data-bv-notempty-message="<fmt:message key="prop.deal.column.datefrom.notempty"/>">
								</c:when>
								<c:otherwise>
									<input type="datetime" readonly class="form-control" name="dateFrom" 
										value='<fmt:formatDate pattern="yyyy/MM/dd HH:mm" value="${deal.dateFrom}"/>'/>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="dateTo"><fmt:message key="prop.deal.column.dateto"/></label>
					<div class="col-sm-10">
						<div class="input-group date" id="dateToPicker">
							<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
							<c:choose>
								<c:when test="${empty deal.state || deal.state eq 'CREATED'}">
									<input type="datetime" required class="form-control" name="dateTo" 
										value="<fmt:formatDate pattern="yyyy/MM/dd HH:mm" value="${deal.dateTo}"/>"
										placeholder="<fmt:message key="prop.deal.column.dateto.placeholder"/>"
										required data-bv-notempty-message="<fmt:message key="prop.deal.column.dateto.notempty"/>">			
								</c:when>
								<c:otherwise>
									<input type="datetime" readonly class="form-control" name="dateTo" 
										value="<fmt:formatDate pattern="yyyy/MM/dd HH:mm" value="${deal.dateTo}"/>"/>
								</c:otherwise>
							</c:choose>
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
							<c:choose>
								<c:when test="${empty deal.state || deal.state eq 'CREATED'}">
									<input type="text" class="form-control" name="passportNumber" 
										placeholder="<fmt:message key="prop.deal.column.passportNumber.placeholder"/>"
										required data-bv-notempty-message="<fmt:message key="prop.deal.column.passportNumber.notempty"/>"
										pattern="^[A-Za-zА-Яа-яЁё]{2,}\s?\d{6,}$" data-bv-regexp-message="<fmt:message key="prop.deal.column.passportNumber.regexp"/>"
										value="${deal.passportNumber}"/>
								</c:when>
								<c:otherwise>
									<input type="text" class="form-control" name="passportNumber" readonly value="${deal.passportNumber}"/>
								</c:otherwise>
							</c:choose>
						</div>				
					</div>
				</div>
				<c:if test="${empty deal.state || deal.state eq 'CREATED' || not empty deal.comment}">
					<div class="form-group">
						<label class="control-label col-sm-2" for="comment"><fmt:message key="prop.deal.column.comment"/></label>
						<div class="col-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
								<c:choose>
									<c:when test="${empty deal.state || deal.state eq 'CREATED'}">
										<textarea rows="5" class="form-control" name="comment"
											placeholder="<fmt:message key="prop.deal.column.comment.placeholder"/>"
											maxlength="200" data-bv-stringlength-message="<fmt:message key="prop.deal.column.comment.stringlength"/>">${deal.comment}</textarea>
									</c:when>
									<c:otherwise>
										<textarea rows="5" readonly class="form-control" name="comment">${deal.comment}</textarea>
									</c:otherwise>
								</c:choose>
							</div>
						</div>
					</div>
				</c:if>		
				
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						
						<c:if test="${deal.state eq 'CREATED' || empty deal.state}">
							<button class="btn btn-primary"><fmt:message key="prop.common.button.save"/></button>
						</c:if>
						<c:if test="${deal.state eq 'CREATED'}">
							<button class="btn btn-primary" onclick="deleteDeal(${deal.id}); return false;"><fmt:message key="prop.common.button.delete"/></button>
						</c:if>
						<c:if test="${deal.state eq 'CONFIRMED'}">
							<button class="btn btn-primary" onclick="payDeal(${deal.id}); return false;"><fmt:message key="prop.common.button.pay"/></button>
						</c:if>
					</div>
				</div>
			</form>
		</div>
				
		<c:if test="${deal.state eq 'CANCELED'}">
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
								<textarea rows="5" class="form-control" name="cancelReason" readonly>${deal.cancelReason}</textarea>
							</div>
						</div>
					</div>
				</form>
			</div>
		</c:if>
			
		<c:if test="${not empty deal.damage.description}">
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
								<input readonly type="text" class="form-control" name="damage_cost" 
									value="${deal.damage.cost}"/>
							</div>				
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="damage_description"><fmt:message key="prop.deal.column.damage.description"/></label>
						<div class="col-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
								<textarea rows="5" readonly class="form-control" name="damage_description">${deal.damage.description}</textarea>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<c:if test="${deal.state eq 'DAMAGED'}">
								<button class="btn btn-primary" onclick="payDeal(${deal.id}); return false;"><fmt:message key="prop.common.button.pay"/></button>
							</c:if>
						</div>
					</div>			
				</form>		
			</div>
		</c:if>
	</div> 
</div>	


