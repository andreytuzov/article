<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div>
	<div class="page-name">
		<span class="page-name-base"><fmt:message key="prop.page.name.base"/></span> 
		<span class="page-name-arrows">>></span><fmt:message key="prop.page.name.list"/>
	</div> 
	<ul> 
		<c:forEach var="article" items="${articles}">
			<li class="article" data-id="${article.id}">
				<div>
					<span class="article__date"><fmt:formatDate pattern="MM/dd/yyyy" value="${article.changeTime}"/></span> 
					<span class="article__title">${article.title}</span> 
				</div>
				<div class="article__brief">${article.content}</div>
				<div class="article__management">
					<a href="/article/view/${article.id}"><fmt:message key="prop.form.button.view"/></a>
					<a href="/article/modify/${article.id}"><fmt:message key="prop.form.button.edit"/></a>
					<input class="article__checkbox" type="checkbox"/>
				</div>
			</li> 
		</c:forEach> 
	</ul> 

	<div class="view__buttons">
		<button class="view__button" id="delete-list-article" onclick="deleteListArticle()"><fmt:message key="prop.form.button.delete"/> </button>
	</div>
</div>