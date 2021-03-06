<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<nav class="navbar navbar-inverse navbar-static-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="/motordepot/page?action=view_car_list"><img src="http://arendovat-avto.ru/uploads/vybrat-avtomobil.png"/></a>
		</div>
		<ul class="nav navbar-nav">
			<li><a href="/motordepot/page?action=view_car_list"><fmt:message key="prop.header.button.carlist"/></a></li>
			<c:if test="${sr_is_admin}">
				<li><a href="/motordepot/page?action=view_deal_list&rds_name=CREATED"><span class="glyphicon glyphicon-list-alt"></span> <fmt:message key="prop.header.button.deallist"/></a></li>
				<li><a href="/motordepot/page?action=view_user_list"><span class="glyphicon glyphicon-user"></span> <fmt:message key="prop.header.button.userlist"/></a></li>
			</c:if>
		</ul>
		<c:if test="${sr_is_admin}">
			<a class="btn btn-danger navbar-btn" href="/motordepot/page?action=view_modify_car"><fmt:message key="prop.header.button.addcar"/></a>
		</c:if>
		<ul class="nav navbar-nav navbar-right">
			<c:choose>
				<c:when test="${empty su_nickname}">
					<li><a href="#" data-toggle="modal" data-target="#signupModal" data-backdrop="static" data-keyboard="false"><span class="glyphicon glyphicon-user"></span> <fmt:message key="prop.header.authentication.signup"/></a></li>
					<li><a href="#" data-toggle="modal" data-target="#loginModal" data-backdrop="static" data-keyboard="false"><span class="glyphicon glyphicon-log-in"></span> <fmt:message key="prop.header.authentication.login"/></a></li>
				</c:when>
				<c:otherwise>
					<li><a href="/motordepot/page?action=view_modify_user_room&ru_nickname=${su_nickname}"><span class="glyphicon glyphicon-home"></span> ${su_nickname}</a></li>
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
