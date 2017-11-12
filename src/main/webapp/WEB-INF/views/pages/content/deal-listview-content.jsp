<%@ page pageEncoding="UTF-8" isELIgnored="false"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="container-fluid">

	<div class="page-header">
		<h3><fmt:message key="prop.deal.header.list"/></h3>
			<c:choose>
				<c:when test="${param.rds_name eq 'CREATED'}">
					<i><fmt:message key="prop.deal.header.placeholder.admin.created"/></i>
				</c:when>
				<c:when test="${param.rds_name eq 'CONFIRMED'}">
					<i><fmt:message key="prop.deal.header.placeholder.admin.confirmed"/></i>
				</c:when>
				<c:when test="${param.rds_name eq 'PAID'}">
					<i><fmt:message key="prop.deal.header.placeholder.admin.paid"/></i>
				</c:when>
				<c:when test="${param.rds_name eq 'CANCELED'}">
					<i><fmt:message key="prop.deal.header.placeholder.admin.canceled"/></i>
				</c:when>
				<c:when test="${param.rds_name eq 'DAMAGED'}">
					<i><fmt:message key="prop.deal.header.placeholder.admin.damaged"/></i>
				</c:when>
				<c:when test="${param.rds_name eq 'COMPLETED_DAMAGE'}">
					<i><fmt:message key="prop.deal.header.placeholder.admin.completed_damage"/></i>
				</c:when>
				<c:when test="${param.rds_name eq 'COMPLETED_SUCCESS'}">
					<i><fmt:message key="prop.deal.header.placeholder.admin.completed"/></i>
				</c:when>
				<c:when test="${param.rds_name eq 'ACTIVE'}">
					<i><fmt:message key="prop.deal.header.placeholder.admin.active"/></i>
				</c:when>
				<c:when test="${param.rds_name eq 'FINISHED'}">
					<i><fmt:message key="prop.deal.header.placeholder.admin.finished"/></i>
				</c:when>
			</c:choose>
	</div>
	
	
	<div class="btn-group">
		<a class="btn btn-primary" href="/motordepot/page?action=view_deal_list&rds_name=CREATED"><fmt:message key="prop.deal.button.new"/></a>
		<a class="btn btn-primary" href="/motordepot/page?action=view_deal_list&rds_name=CONFIRMED"><fmt:message key="prop.deal.button.payment"/></a>
		<div class="btn-group">
			<a class="btn btn-primary dropdown-toggle" data-toggle="dropdown" href="#"><fmt:message key="prop.deal.button.current"/>
				<span class="caret"></span></a>
			<ul class="dropdown-menu">		
				<li><a href="/motordepot/page?action=view_deal_list&rds_name=PAID"><fmt:message key="prop.deal.button.waiting"/></a></li>
				<li><a href="/motordepot/page?action=view_deal_list&rds_name=ACTIVE"><fmt:message key="prop.deal.button.active"/></a></li>
				<li><a href="/motordepot/page?action=view_deal_list&rds_name=FINISHED"><fmt:message key="prop.deal.button.completed"/></a></li>
			</ul>
		</div>
		<div class="btn-group">
			<a class="btn btn-primary dropdown-toggle" data-toggle="dropdown" href="#"><fmt:message key="prop.deal.button.finished"/>
				<span class="caret"></span></a>
			<ul class="dropdown-menu">	
				<li><a href="/motordepot/page?action=view_deal_list&rds_name=COMPLETED_SUCCESS"><fmt:message key="prop.deal.button.success"/></a></li>	
				<li><a href="/motordepot/page?action=view_deal_list&rds_name=CANCELED"><fmt:message key="prop.deal.button.canceled"/></a></li>
				<li><a href="/motordepot/page?action=view_deal_list&rds_name=COMPLETED_DAMAGE"><fmt:message key="prop.deal.button.damage"/></a></li>	
			</ul>
		</div>
	</div>

	<div style="margin-top: 20px;">
		<table class="table table-striped table-hover table-bordered searchTable" id="dealTable"> 
			<thead>
				<tr>
					<th class="col-sm-1">Order</th>
					<th class="col-sm-2"><fmt:message key="prop.user.column.nickname"/></th>
					<th class="col-sm-2"><fmt:message key="prop.deal.column.datefrom"/></th>
					<th class="col-sm-2"><fmt:message key="prop.deal.column.dateto"/></th>
					<th class="col-sm-3"><fmt:message key="prop.car.column.model"/></th>
					<th class="col-sm-2"><fmt:message key="prop.deal.column.cost"/></th>
				</tr> 
			</thead>
			<tbody id="searchTable">
				<c:forEach var="deal" items="${rd_list}">
					<tr>
						<td><a href="/motordepot/page?action=view_modify_deal&rd_id=${deal.id}"><span class="glyphicon glyphicon-edit"></span></a></td>
						<td><a href="/motordepot/page?action=view_modify_user_room&ru_nickname=${deal.user.nickname}">${deal.user.nickname}</a></td>
						<td><fmt:formatDate pattern="yyyy/MM/dd HH:mm" value="${deal.dateFrom}"/></td>
						<td><fmt:formatDate pattern="yyyy/MM/dd HH:mm" value="${deal.dateTo}"/></td>
						<td><a href="/motordepot/page?action=view_car&rc_id=${deal.car.id}">${deal.car.model}</a></td>
						<td>${deal.cost} $</td>
					</tr>
				</c:forEach>	
			</tbody>
		</table> 
	</div>
</div>