<%@ page pageEncoding="UTF-8" isELIgnored="false"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="page-header">
	<h3><fmt:message key="prop.user.header.room"/>, ${ru_object.nickname}</h3>
</div>

<div> 
	<ul class="nav nav-tabs">
		<li class="active"><a href="#user-tab" data-toggle="tab"><fmt:message key="prop.user.tab.info"/></a></li>	
		<c:if test="${not (sr_is_admin && su_nickname eq ru_object.nickname)}">
			<li><a href="#booking-tab" data-toggle="tab"><fmt:message key="prop.user.tab.order"/></a></li>		
		</c:if>
	</ul>

 
 	<div class="tab-content" style="margin-top: 20px;">
 	
 		<div class="alert" id="alert-message" style="display: none">
			<a href="#" onclick="hiddenAlert()" class="close">×</a>
			<span></span>
		</div>
 	
		<div class="tab-pane active" id="user-tab">
 			<form id="modifyUserForm" class="form-horizontal" action="/motordepot/page?action=modify_user" method="post"
				data-bv-trigger="blur"
				data-bv-feedbackicons-valid="glyphicon glyphicon-ok"
				data-bv-feedbackicons-invalid="glyphicon glyphicon-remove"
				data-bv-feedbackicons-validating="glyphicon glyphicon-refresh">
				
				<input type="hidden" name="ru_nickname" value="${ru_object.nickname}"/>
				
				<div class="form-group">
					<label class="control-label col-sm-2" for="ru_name"><fmt:message key="prop.user.column.name"/></label>
					<div class="col-sm-5">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
							<c:choose>
								<c:when test="${su_nickname eq ru_object.nickname}">
									<input type="text" name="ru_name" class="form-control" 
										value="${ru_object.name}"
										required data-bv-notempty-message="<fmt:message key="prop.user.column.name.notempty"/>"
										placeholder="<fmt:message key="prop.user.column.name.placeholder"/>"/>
								</c:when>
								<c:otherwise>
									<input type="text" readonly name="ru_name" class="form-control" value="${ru_object.name}"/>
								</c:otherwise>
							</c:choose>
							
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-2" for="ru_lastname"><fmt:message key="prop.user.column.lastname"/></label>
					<div class="col-sm-5">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
							<c:choose>
								<c:when test="${su_nickname eq ru_object.nickname}">
									<input type="text" name="ru_lastname" class="form-control"
										value="${ru_object.lastname}"
										required data-bv-notempty-message="<fmt:message key="prop.user.column.lastname.notempty"/>" 
										placeholder="<fmt:message key="prop.user.column.lastname.placeholder"/>"/>
								</c:when>
								<c:otherwise>
									<input type="text" readonly name="ru_lastname" class="form-control" value="${ru_object.lastname}"/>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-2" for="ru_driven_experience"><fmt:message key="prop.user.column.drivenExperience"/></label>
					<div class="col-sm-5">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-road"></i></span>
							<c:choose>
								<c:when test="${su_nickname eq ru_object.nickname}">
									<input type="text" name="ru_driven_experience" class="form-control"
										value="${ru_object.drivenExperience}"
										required data-bv-notempty-message="<fmt:message key="prop.user.column.drivenExperience.notempty"/>"
										pattern="^\d+$" data-bv-regexp-message="<fmt:message key="prop.user.column.drivenExperience.regexp"/>"
										placeholder="<fmt:message key="prop.user.column.drivenExperience.placeholder"/>"/>
								</c:when>
								<c:otherwise>
									<input type="text" readonly name="ru_driven_experience" class="form-control" value="${ru_object.drivenExperience}"/>
								</c:otherwise>
							</c:choose>
							
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-2" for="ru_phone"><fmt:message key="prop.user.column.phone"/></label>
					<div class="col-sm-5">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span>
							<c:choose>
								<c:when test="${su_nickname eq ru_object.nickname}">
									<input type="text" name="ru_phone" class="form-control" 
										value="${ru_object.phone}"
										required data-bv-notempty-message="<fmt:message key="prop.user.column.phone.notempty"/>"
										pattern="^(\+[0-9]+)?\s?(\([0-9]{2,}\))?\s?[0-9]{2,}-[0-9]{2}-[0-9]{2}$" data-bv-regexp-message="<fmt:message key="prop.user.column.phone.regexp"/>"
										placeholder="<fmt:message key="prop.user.column.phone.placeholder"/>"/>
								</c:when>
								<c:otherwise>
									<input type="text" readonly name="ru_phone" class="form-control" value="${ru_object.phone}"/>
								</c:otherwise>
							</c:choose>
							
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-2" for="rc_email"><fmt:message key="prop.user.column.email"/></label>
					<div class="col-sm-5">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
							<c:choose>
								<c:when test="${su_nickname eq ru_object.nickname}">
									<input type="text" name="rc_email" class="form-control"
										value="${ru_object.email}"
										required data-bv-notempty-message="<fmt:message key="prop.user.column.email.notempty"/>"
										pattern="^[^@\s]+@[^@\s]+\.[^@\s]+$" data-bv-regexp-message="<fmt:message key="prop.user.column.email.regexp"/>" 
										placeholder="<fmt:message key="prop.user.column.email.placeholder"/>"/>
								</c:when>
								<c:otherwise>
									<input type="text" readonly name="rc_email" class="form-control" value="${ru_object.email}"/>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
				
				<c:if test="${su_nickname eq ru_object.nickname}">
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button class="btn btn-primary"><fmt:message key="prop.common.button.save"/></button>
						</div>
					</div>
				</c:if>
			</form>
		</div>
				
		<c:if test="${not (sr_is_admin && su_nickname eq ru_object.nickname)}">
			<div class="tab-pane" id="booking-tab">
				<table class="table table-striped table-hover table-bordered searchTable" id="dealTable"> 
					<thead>
						<tr>
							<th class="col-sm-9"><fmt:message key="prop.deal.column.state"/></th>
							<th class="col-sm-2"><fmt:message key="prop.car.column.model"/></th>
							<th class="col-sm-1"><fmt:message key="prop.deal.column.datefrom"/></th>
							<th class="col-sm-1"><fmt:message key="prop.deal.column.dateto"/></th>
							<th class="col-sm-1"><fmt:message key="prop.deal.column.cost"/></th>
						</tr> 
					</thead>
					<tbody id="searchTable">
						<c:forEach var="deal" items="${rd_list}">
							<tr>
								<td>
									<a href="/motordepot/page?action=view_modify_deal&rd_id=${deal.id}">
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
											<c:when test="${deal.state eq 'ACTIVE'}">
												<i><fmt:message key="prop.deal.header.placeholder.customer.active"/></i>
											</c:when>
											<c:when test="${deal.state eq 'FINISHED'}">
												<i><fmt:message key="prop.deal.header.placeholder.customer.finished"/></i>
											</c:when>
											<c:when test="${deal.state eq 'COMPLETED_DAMAGE' || deal.state eq 'COMPLETED_SUCCESS'}">
												<i><fmt:message key="prop.deal.header.placeholder.customer.completed"/></i>
											</c:when>
										</c:choose>									
									</a>
								</td>
								<td><a href="/motordepot/page?action=view_car&rc_id=${deal.car.id}">${deal.car.model}</a></td>
								<td><fmt:formatDate pattern="yyyy/MM/dd HH:mm" value="${deal.dateFrom}"/></td>
								<td><fmt:formatDate pattern="yyyy/MM/dd HH:mm" value="${deal.dateTo}"/></td>
								<td>${deal.cost} $</td>
							</tr>
						</c:forEach>	
					</tbody>
				</table> 
			</div>
		</c:if>
			
	</div> 
</div>	


