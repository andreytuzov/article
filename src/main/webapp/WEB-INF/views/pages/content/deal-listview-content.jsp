<%@ page pageEncoding="UTF-8" isELIgnored="false"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="container-fluid">

	<h2>Каталог сделок</h2>

	<table class="table table-striped table-hover table-bordered searchTable" id="dealTable"> 
		<thead>
			<tr>
				<th>Статус</th>
				<th>Пользователь</th>
				<th>Автомобиль</th>
				<th>Дата от</th>
				<th>Дата до</th>
				<th>Цена</th>
			</tr> 
		</thead>
		<tbody id="searchTable">
			<c:forEach var="deal" items="${listDeal}">
				<tr>
					<td><a href="/motordepot/page?action=view_modify_deal&id=${deal.id}">${deal.state}</a></td>
					<td>${deal.user.nickname}</td>
					<td><a href="/motordepot/page?action=view_car&id=${deal.car.id}">${deal.car.model}</a></td>
					<td><fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${deal.dateFrom}"/></td>
					<td><fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${deal.dateTo}"/></td>
					<td>${deal.cost} $</td>
				</tr>
			</c:forEach>	
		</tbody>
	</table> 
</div>