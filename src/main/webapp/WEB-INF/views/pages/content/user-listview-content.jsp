<%@ page pageEncoding="UTF-8" isELIgnored="false"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="container-fluid">

	<div class="page-header">
		<h3><fmt:message key="prop.user.header.list"/></h3>
	</div>

	<table class="table table-striped table-hover table-bordered searchTable" id="userTable"> 
		<thead>
			<tr>
				<th class="col-sm-2"><fmt:message key="prop.user.column.nickname"/></th>
				<th class="col-sm-2"><fmt:message key="prop.user.column.name"/></th>
				<th class="col-sm-2"><fmt:message key="prop.user.column.lastname"/></th>
				<th class="col-sm-3"><fmt:message key="prop.user.column.phone"/></th>
				<th class="col-sm-3"><fmt:message key="prop.user.column.email"/></th>
			</tr> 
		</thead>
		<tbody id="searchTable">
			<c:forEach var="user" items="${ru_list}">
				<tr>
					<td><a href="/motordepot/page?action=view_modify_user_room&ru_nickname=${user.nickname}">${user.nickname}</a></td>
					<td>${user.name}</td>
					<td>${user.lastname}</td>
					<td>${user.phone}</td>
					<td>${user.email}</td>
				</tr>
			</c:forEach>	
		</tbody>
	</table> 
</div>