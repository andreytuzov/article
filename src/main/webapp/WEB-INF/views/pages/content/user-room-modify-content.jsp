<%@ page pageEncoding="UTF-8" isELIgnored="false"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="page-header">
	<h3><fmt:message key="prop.user.header.room"/>, ${userObject.nickname}</h3>
</div>

<div class="col-sm-10"> 
	<ul class="nav nav-tabs">
		<li class="active"><a href="#user-tab" data-toggle="tab"><fmt:message key="prop.user.tab.info"/></a></li>	
		<c:if test="${not (admin && user eq userObject.nickname)}">
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
				
				<input type="hidden" name="nickname" value="${userObject.nickname}"/>
				
				<div class="form-group">
					<label class="control-label col-sm-2" for="name"><fmt:message key="prop.user.column.name"/></label>
					<div class="col-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
							<c:choose>
								<c:when test="${user eq userObject.nickname}">
									<input type="text" name="name" class="form-control" 
										value="${userObject.name}"
										required data-bv-notempty-message="<fmt:message key="prop.user.column.name.notempty"/>"
										placeholder="<fmt:message key="prop.user.column.name.placeholder"/>"/>
								</c:when>
								<c:otherwise>
									<input type="text" readonly name="name" class="form-control" value="${userObject.name}"/>
								</c:otherwise>
							</c:choose>
							
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-2" for="lastname"><fmt:message key="prop.user.column.lastname"/></label>
					<div class="col-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
							<c:choose>
								<c:when test="${user eq userObject.nickname}">
									<input type="text" name="lastname" class="form-control"
										value="${userObject.lastname}"
										required data-bv-notempty-message="<fmt:message key="prop.user.column.lastname.notempty"/>" 
										placeholder="<fmt:message key="prop.user.column.lastname.placeholder"/>"/>
								</c:when>
								<c:otherwise>
									<input type="text" readonly name="lastname" class="form-control" value="${userObject.lastname}"/>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-2" for="drivenExperience"><fmt:message key="prop.user.column.drivenExperience"/></label>
					<div class="col-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-road"></i></span>
							<c:choose>
								<c:when test="${user eq userObject.nickname}">
									<input type="text" name="drivenExperience" class="form-control"
										value="${userObject.drivenExperience}"
										required data-bv-notempty-message="<fmt:message key="prop.user.column.drivenExperience.notempty"/>"
										pattern="^\d+$" data-bv-regexp-message="<fmt:message key="prop.user.column.drivenExperience.regexp"/>"
										placeholder="<fmt:message key="prop.user.column.drivenExperience.placeholder"/>"/>
								</c:when>
								<c:otherwise>
									<input type="text" readonly name="drivenExperience" class="form-control" value="${userObject.drivenExperience}"/>
								</c:otherwise>
							</c:choose>
							
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-2" for="phone"><fmt:message key="prop.user.column.phone"/></label>
					<div class="col-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span>
							<c:choose>
								<c:when test="${user eq userObject.nickname}">
									<input type="text" name="phone" class="form-control" 
										value="${userObject.phone}"
										required data-bv-notempty-message="<fmt:message key="prop.user.column.phone.notempty"/>"
										pattern="^(\+[0-9]+)?\s?(\([0-9]{2,}\))?\s?[0-9]{2,}-[0-9]{2}-[0-9]{2}$" data-bv-regexp-message="<fmt:message key="prop.user.column.phone.regexp"/>"
										placeholder="<fmt:message key="prop.user.column.phone.placeholder"/>"/>
								</c:when>
								<c:otherwise>
									<input type="text" readonly name="phone" class="form-control" value="${userObject.phone}"/>
								</c:otherwise>
							</c:choose>
							
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-2" for="email"><fmt:message key="prop.user.column.email"/></label>
					<div class="col-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
							<c:choose>
								<c:when test="${user eq userObject.nickname}">
									<input type="text" name="email" class="form-control"
										value="${userObject.email}"
										required data-bv-notempty-message="<fmt:message key="prop.user.column.email.notempty"/>"
										pattern="^[^@\s]+@[^@\s]+\.[^@\s]+$" data-bv-regexp-message="<fmt:message key="prop.user.column.email.regexp"/>" 
										placeholder="<fmt:message key="prop.user.column.email.placeholder"/>"/>
								</c:when>
								<c:otherwise>
									<input type="text" readonly name="email" class="form-control" value="${userObject.email}"/>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
				
				<c:if test="${user eq userObject.nickname}">
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button class="btn btn-primary"><fmt:message key="prop.common.button.save"/></button>
						</div>
					</div>
				</c:if>
			</form>
		</div>
				
		<c:if test="${not (admin && user eq userObject.nickname)}">
			<div class="tab-pane" id="booking-tab">
				<table class="table table-striped table-hover table-bordered searchTable" id="dealTable"> 
					<thead>
						<tr>
							<th><fmt:message key="prop.deal.column.state"/></th>
							<th><fmt:message key="prop.car.column.model"/></th>
							<th><fmt:message key="prop.deal.column.datefrom"/></th>
							<th><fmt:message key="prop.deal.column.dateto"/></th>
							<th><fmt:message key="prop.deal.column.cost"/></th>
						</tr> 
					</thead>
					<tbody id="searchTable">
						<c:forEach var="deal" items="${listDeal}">
							<tr>
								<td><a href="/motordepot/page?action=view_modify_deal&id=${deal.id}">${deal.state}</a></td>
								<td><a href="/motordepot/page?action=view_car&id=${deal.car.id}">${deal.car.model}</a></td>
								<td><fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${deal.dateFrom}"/></td>
								<td><fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${deal.dateTo}"/></td>
								<td>${deal.cost} $</td>
							</tr>
						</c:forEach>	
					</tbody>
				</table> 
			</div>
		</c:if>
			
	</div> 
</div>	


