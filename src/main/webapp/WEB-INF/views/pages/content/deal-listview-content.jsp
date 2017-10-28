<%@ page pageEncoding="UTF-8" isELIgnored="false"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="container-fluid">

	<div class="page-header">
		<h3><fmt:message key="prop.deal.header.list"/></h3>
	</div>

	<table class="table table-striped table-hover table-bordered searchTable" id="dealTable"> 
		<thead>
			<tr>
				<th><fmt:message key="prop.deal.column.state"/></th>
				<th><fmt:message key="prop.user.column.nickname"/></th>
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
					<td><a href="/motordepot/page?action=view_modify_user_room&nickname=${deal.user.nickname}">${deal.user.nickname}</a></td>
					<td><a href="/motordepot/page?action=view_car&id=${deal.car.id}">${deal.car.model}</a></td>
					<td><fmt:formatDate pattern="yyyy/MM/dd HH:mm" value="${deal.dateFrom}"/></td>
					<td><fmt:formatDate pattern="yyyy/MM/dd HH:mm" value="${deal.dateTo}"/></td>
					<td>${deal.cost} $</td>
				</tr>
			</c:forEach>	
		</tbody>
	</table> 
</div>