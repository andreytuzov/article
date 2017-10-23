<%@ page contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

var messages = new Array();
<fmt:bundle basename="l10n.script">
	<c:forEach var="key" items="${keys}">
		messages["${key}"] = "<fmt:message key='${key}'/>";
	</c:forEach>
</fmt:bundle>