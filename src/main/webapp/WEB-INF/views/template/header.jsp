<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<nav class="navbar navbar-inverse navbar-static-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#"><fmt:message key="prop.header.title"/></a>
		</div>
		<ul class="nav navbar-nav">
			<li><a href="/motordepot/page?action=view_car_list"><fmt:message key="prop.header.button.carlist"/></a></li>
			<li><a href="/motordepot/page?action=view_deal_list"><fmt:message key="prop.header.button.deallist"/></a></li>
			<li><a href="/motordepot/page?action=view_user_list">Users</a></li>
		</ul>
		<c:if test="${admin}">
			<a class="btn btn-danger navbar-btn" href="/motordepot/page?action=view_modify_car"><fmt:message key="prop.header.button.addcar"/></a>
		</c:if>
		<ul class="nav navbar-nav navbar-right">
			<c:choose>
				<c:when test="${empty user}">
					<li><a href="#" data-toggle="modal" data-target="#signupModal"><span class="glyphicon glyphicon-user"></span> <fmt:message key="prop.header.authentication.signup"/></a></li>
					<li><a href="#" data-toggle="modal" data-target="#loginModal"><span class="glyphicon glyphicon-log-in"></span> <fmt:message key="prop.header.authentication.login"/></a></li>
				</c:when>
				<c:otherwise>
					<li><a href="/motordepot/page?action=view_modify_user_room&nickname=${user}"><span class="glyphicon glyphicon-home"></span> ${user}</a></li>
					<li><a href="/motordepot/page?action=log_out"><span class="glyphicon glyphicon-log-out"></span> <fmt:message key="prop.header.authentication.logout"/></a></li>
				</c:otherwise>
			</c:choose>
			<li class="dropdown">
				<a class="dropdown-toggle" data-toggle="dropdown" href="#"><fmt:message key="prop.header.language"/>
				<span class="caret"></span></a>
				
				<ul class="dropdown-menu">
					<li><a href="page/changelanguage?lang=en"><fmt:message key="prop.header.language.english"/></a></li>
					<li><a href="page/changelanguage?lang=ru"><fmt:message key="prop.header.language.russian"/></a></li>
				</ul>
			</li>
		</ul>
	</div>
</nav>
