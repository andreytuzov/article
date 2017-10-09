<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div>   
	<c:url value="?${pageContext.request.queryString}" var="link_en">
		<c:param name="lang" value="en"/>
	</c:url>
	<c:url value="?${pageContext.request.queryString}" var="link_ru"> 
		<c:param name="lang" value="ru"/>
	</c:url>
	<h2 class="header__title">
		<fmt:message key="prop.header.title"/>
	</h2> 
	<div class="header__language">  
		<a href="${link_en}"><fmt:message key="prop.header.language.english"/></a>
		<a href="${link_ru}"><fmt:message key="prop.header.language.russian"/></a>
	</div>
</div>
