<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="language" value="${not empty param.lang ? param.lang : not empty lang ? lang : pageContext.request.locale}" scope="session"/>
<fmt:setLocale value="${language}" scope="session"/>
<fmt:setBundle basename="l10n.prop" scope="session"/>

<html>
<head>
	<title>${param.title}</title> 
	<link href="${pageContext.request.contextPath}/static/css/app.css" rel="stylesheet"></link>
</head>
   
<body> 	
	<header id="header">
		<jsp:include page="/WEB-INF/views/template/header.jsp"/> 
	</header>

	<section id="sidemenu">
		<jsp:include page="/WEB-INF/views/template/menu.jsp"/>
	</section>

	<section id="site-content">
		<jsp:include page="/WEB-INF/views/pages/content/${param.content}.jsp"/>
	</section>
	
	<footer id="footer">
		<jsp:include page="/WEB-INF/views/template/footer.jsp"/>
	</footer>
	
	<script src="${pageContext.request.contextPath}/static/js/jquery-1.11.1.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/dynamic.js"></script>
</body>	
</html>