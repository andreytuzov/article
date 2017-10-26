<%@ page pageEncoding="UTF-8" isELIgnored="false"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="page-header">
	<h3><fmt:message key="prop.deal.header"/></h3>
</div>

<div class="col-sm-10"> 
	<ul class="nav nav-tabs">
		<li class="active"><a href="#user-tab" data-toggle="tab">Пользователь</a></li>		
		<li><a href="#booking-tab" data-toggle="tab">Заказы</a></li>		
	</ul>

 
 	<div class="tab-content" style="margin-top: 20px;">
 	
 		<div class="alert" id="alert-message" style="display: none">
			<a href="#" onclick="hidden_message()" class="close">×</a>
			<span></span>
		</div>
 	
		<div class="tab-pane active" id="user-tab">
 			<form id="modifyDealForm" class="form-horizontal" action="/motordepot/page?action=modify_deal" method="post"
				data-bv-trigger="blur"
				data-bv-feedbackicons-valid="glyphicon glyphicon-ok"
				data-bv-feedbackicons-invalid="glyphicon glyphicon-remove"
				data-bv-feedbackicons-validating="glyphicon glyphicon-refresh">
				
				<div class="form-group">
					<label class="control-label col-sm-2" for="name">Имя</label>
					<div class="col-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-road"></i></span>
							<input type="text" class="form-control" name="name" value="${userObject.name}">				
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-2" for="lastname">Фамилия</label>
					<div class="col-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-road"></i></span>
							<input type="text" class="form-control" name="lastname" value="${userObject.lastname}">				
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-2" for="drivenExperience">Опыт вождения</label>
					<div class="col-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-road"></i></span>
							<input type="text" class="form-control" name="drivenExperience" value="${userObject.drivenExperience}">				
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-2" for="phone">Телефон</label>
					<div class="col-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-road"></i></span>
							<input type="text" class="form-control" name="phone" value="${userObject.phone}">				
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-2" for="email">Электронный адрес</label>
					<div class="col-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-road"></i></span>
							<input type="text" class="form-control" name="email" value="${userObject.email}">				
						</div>
					</div>
				</div>
				
			
				
				
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button class="btn btn-primary"><fmt:message key="prop.form.button.save"/></button>
						<button class="btn btn-default" onclick="goback(); return false;"><fmt:message key="prop.form.button.back"/></button>
					</div>
				</div>
			</form>
		</div>
				
		<div class="tab-pane" id="booking-tab">
			<table class="table table-striped table-hover table-bordered" id="userDealTable"> 
				<thead>
					<tr>
						<th>Статус</th>
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
							<td><a href="/motordepot/page?action=view_car&id=${deal.car.id}">${deal.car.model}</a></td>
							<td><fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${deal.dateFrom}"/></td>
							<td><fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${deal.dateTo}"/></td>
							<td>${deal.cost} $</td>
						</tr>
					</c:forEach>	
				</tbody>
			</table> 
			
		</div>
			
	</div> 
</div>	


