<%@ page pageEncoding="UTF-8" isELIgnored="false"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="mytags" uri="http://epam.by/jsp/tlds/mytags" %>

<div class="container-fluid">

	<div class="page-header">
		<h3><fmt:message key="prop.car.header.list"/></h3> 
		<c:if test="${empty su_nickname}">
			<i><fmt:message key="prop.car.header.list.placeholder"/></i>
		</c:if>
	</div>

	<div class="alert" style="display: none">
		<a href="#" onclick="hiddenAlert()" class="close">×</a>
		<span></span>
	</div>

	<table class="table table-striped table-hover table-bordered searchTable" id="carTable"> 
		<thead>
			<tr>
				<th class="col-sm-2"><fmt:message key="prop.car.column.model"/></th>
				<th><fmt:message key="prop.car.column.year"/></th>
				<th><fmt:message key="prop.car.column.volume"/></th>
				<th><fmt:message key="prop.car.column.prise"/></th>
				<th><fmt:message key="prop.car.column.description"/></th>
				<c:choose>
					<c:when test="${sr_is_admin}">
						<th><fmt:message key="prop.car.column.edit"/></th>
						<th><fmt:message key="prop.car.column.delete"/></th>
					</c:when>
					<c:when test="${not empty su_nickname}">
						<th><fmt:message key="prop.car.column.order"/></th>
					</c:when>
				</c:choose>
			</tr>
		</thead>
		<tbody id="searchTable">
			<c:forEach var="car" items="${rc_list}">
				<tr>
					<td><a href="/motordepot/page?action=view_car&rc_id=${car.id}">${car.model}</a></td>
					<td>${car.year}</td>
					<td>${car.volume}</td>
					<td>${car.prise} $</td>
					<td><mytags:trim text="${car.description}"/></td>
					<c:choose>
						<c:when test="${sr_is_admin}">
							<td><a href="/motordepot/page?action=view_modify_car&rc_id=${car.id}"><span class="glyphicon glyphicon-pencil"></span></a></td>
							<td><a onclick="deleteCar(${car.id})" href="#"><span class="glyphicon glyphicon-trash"></span></a></td>
						</c:when>
						<c:when test="${not empty su_nickname}">
							<td><a href="/motordepot/page?action=view_modify_deal&rc_id=${car.id}"><span class="glyphicon glyphicon-edit"></span></a></td>
						</c:when>
					</c:choose>
				</tr>
			</c:forEach>	
		</tbody>
	</table> 
</div>