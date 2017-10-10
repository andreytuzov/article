<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div>   
	<c:url value="" var="link">
		<c:param name="action" value="${param.action}"/>
	</c:url> 
	<h2 class="header__title">
		<fmt:message key="prop.header.title"/>
	</h2> 
	<div class="header__language">  
		<a href="${link}&lang=en"><fmt:message key="prop.header.language.english"/></a>
		<a href="${link}&lang=ru"><fmt:message key="prop.header.language.russian"/></a>
	</div>
</div>
