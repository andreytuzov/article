<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<nav>
	<h1 class="menu__title"><fmt:message key="prop.menu.header"/></h1>
	<ul class="menu__link">
		<li><a href="/article/page?action=GET_ARTICLE_LIST"><fmt:message key="prop.menu.link.list"/></a></li>
		<li><a href="/article/modify/0"><fmt:message key="prop.menu.link.create"/></a></li>
	</ul>
</nav>