<%@ page pageEncoding="UTF-8" isELIgnored="false"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="container-fluid">

	<div class="page-header">
		<h3><fmt:message key="prop.car.header.list"/></h3> 
		<c:if test="${empty user}">
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
				<th><fmt:message key="prop.car.column.model"/></th>
				<th><fmt:message key="prop.car.column.year"/></th>
				<th><fmt:message key="prop.car.column.volume"/></th>
				<th><fmt:message key="prop.car.column.prise"/></th>
				<c:choose>
					<c:when test="${admin}">
						<th><fmt:message key="prop.car.column.edit"/></th>
						<th><fmt:message key="prop.car.column.delete"/></th>
					</c:when>
					<c:when test="${not empty user}">
						<th><fmt:message key="prop.car.column.order"/></th>
					</c:when>
				</c:choose>
			</tr>
		</thead>
		<tbody id="searchTable">
			<c:forEach var="car" items="${listCar}">
				<tr>
					<td><a href="/motordepot/page?action=view_car&id=${car.id}">${car.model}</a></td>
					<td>${car.year}</td>
					<td>${car.volume}</td>
					<td>${car.prise} $</td>
					<c:choose>
						<c:when test="${admin}">
							<td><a href="/motordepot/page?action=view_modify_car&id=${car.id}"><span class="glyphicon glyphicon-pencil"></span></a></td>
							<td><a onclick="deleteCar(${car.id})" href="#"><span class="glyphicon glyphicon-trash"></span></a></td>
						</c:when>
						<c:when test="${not empty user}">
							<td><a href="/motordepot/page?action=view_modify_deal&carId=${car.id}"><span class="glyphicon glyphicon-edit"></span></a></td>
						</c:when>
					</c:choose>
					
				</tr>
			</c:forEach>	
		</tbody>
	</table> 
</div>