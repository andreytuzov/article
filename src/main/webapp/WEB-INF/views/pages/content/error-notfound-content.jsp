<%@ page pageEncoding="UTF-8" isELIgnored="false"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="page-header">	
	<!-- Jumbotron -->
  	<div class="jumbotron">
    	<h1><fmt:message key="prop.error.name"/></h1>
    	<p><fmt:message key="prop.error.description"/></p>
		<p><a href="/motordepot/page?action=view_car_list" class="btn btn-default btn-lg"><span class="green"><fmt:message key="prop.error.button"/></span></a></p>
	</div>
</div>


