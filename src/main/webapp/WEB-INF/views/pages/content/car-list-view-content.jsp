<%@ page pageEncoding="UTF-8" isELIgnored="false"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="container-fluid">

	<h2>Каталог автомобилей</h2>

	<table class="table table-striped table-hover table-bordered" id="carTable"> 
		<thead>
			<tr>
				<th><fmt:message key="prop.table.car.column.model"/></th>
				<th><fmt:message key="prop.table.car.column.year"/></th>
				<th><fmt:message key="prop.table.car.column.volume"/></th>
				<th>Цена за час</th>
				<th>Больше 1 дня</th>
				<th>От 2 до 7 дней</th>
				<th>От 8 до 15 дней</th>
				<th>От 16 до 30 дней</th>
				<th></th>
			</tr>
		</thead>
		<tbody id="searchTable">
			<c:forEach var="car" items="${listCar}">
				<tr>
					<td>
						<c:if test="${admin}"> 
							<div class="btn-group dropdown"> 
								<a class="btn" data-toggle="dropdown"><span class="glyphicon glyphicon-option-vertical"></span></a>
								<ul class="dropdown-menu">
									<li class="dropdown-header">ADMIN</li>
									<li><a href="/motordepot/page?action=view_modify_car&id=${car.id}">
										<span class="glyphicon glyphicon-pencil"></span> Edit
									</a></li>
									<li><a onclick="deleteCar(${car.id})" href="#">
										<span class="glyphicon glyphicon-trash"></span> Delete
									</a></li>									
								</ul>
							</div>
						</c:if>
						<a href="/motordepot/page?action=view_car&id=${car.id}">${car.model}</a>
					</td>
					<td>${car.year}</td>
					<td>${car.volume} $</td>
					<td>${car.prise} $</td>
					<td>${(100 - car.discount.only1day) * car.prise / 100} $</td>
					<td>${(100 - car.discount.between2and7days) * car.prise / 100} $</td>
					<td>${(100 - car.discount.between8and15days) * car.prise / 100} $</td>
					<td>${(100 - car.discount.between16and30days) * car.prise / 100} $</td>
					<td><a href="/motordepot/page?action=view_modify_deal&carId=${car.id}">Арендовать</a></td>
				</tr>
			</c:forEach>	
		</tbody>
	</table> 
</div>