<%@ page pageEncoding="UTF-8" isELIgnored="false"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="container-fluid">

	<h2>Список пользователей</h2>

	<table class="table table-striped table-hover table-bordered" id="userTable"> 
		<thead>
			<tr>
				<th>Ник</th>
				<th>Имя</th>
				<th>Фамилия</th>
				<th>Телефон</th>
				<th>Почта</th>
			</tr> 
		</thead>
		<tbody id="searchTable">
			<c:forEach var="userObject" items="${listUser}">
				<tr>
					<td><a href="/motordepot/page?action=view_modify_user_room&nickname=${userObject.nickname}">${userObject.nickname}</a></td>
					<td>${userObject.name}</td>
					<td>${userObject.lastname}</td>
					<td>${userObject.phone}</td>
					<td>${userObject.email}</td>
				</tr>
			</c:forEach>	
		</tbody>
	</table> 
</div>