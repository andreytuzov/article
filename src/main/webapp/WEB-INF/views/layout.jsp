<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="language" value="${not empty param.lang ? param.lang : not empty language ? language : pageContext.request.locale}" scope="session"/>
<fmt:setLocale value="${language}" scope="session"/>
<fmt:setBundle basename="l10n.prop" scope="session"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>${param.title}</title> 
	<link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet"></link>
	<link href="${pageContext.request.contextPath}/static/css/dataTables.bootstrap.min.css" rel="stylesheet"></link>
	<link href="${pageContext.request.contextPath}/static/css/datepicker.min.css" rel="stylesheet"></link>
	<link href="${pageContext.request.contextPath}/static/css/datepicker3.min.css" rel="stylesheet"></link>
	<link href="${pageContext.request.contextPath}/static/css/bootstrapValidator.min.css" rel="stylesheet"></link>
	<link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet"></link>
</head>
   
<body> 	
	<header id="header">
		<jsp:include page="/WEB-INF/views/template/header.jsp"/> 
	</header>

	<div class="container">
		<div class="row">
			<section>
				<jsp:include page="/WEB-INF/views/pages/content/${param.content}.jsp"/>
			</section>
		</div>
	</div>
	
	<footer>
		<jsp:include page="/WEB-INF/views/template/footer.jsp"/>
	</footer>
	
	<script src="${pageContext.request.contextPath}/static/js/jquery-1.11.1.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/jquery.dataTables.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/dataTables.bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/bootstrap-datepicker.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/bootstrap-validator.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/bootstrapValidator.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/dynamic.js"></script>
</body>	
</html>