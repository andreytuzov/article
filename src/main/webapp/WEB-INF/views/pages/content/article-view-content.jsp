<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="page-name">
	<span class="page-name-base"><fmt:message key="prop.page.name.base"/></span> 
	<span class="page-name-arrows">>></span><fmt:message key="prop.page.name.view"/>
</div> 

<div class="view">
	<table>
		<tr class="view__field">
			<td class="view__label"><fmt:message key="prop.form.label.title"/></td>
			<td class="view__data">${article.title}</td> 
		</tr>
		<tr class="view__field">
			<td class="view__label"><fmt:message key="prop.form.label.date"/></td>
			<td class="view__data">
				<fmt:formatDate pattern="MM/dd/yyyy" value="${article.change_time}"/>
			</td>
		</tr>
		<tr class="view__field">
			<td class="view__label"><fmt:message key="prop.form.label.content"/></td>
			<td class="view__data">${article.content}</td>
		</tr>
	</table>
	<div class="view__buttons">
		<button class="view__button" onclick="editArticle(${article.id})"><fmt:message key="prop.form.button.edit"/></button>
		<button class="view__button" onclick="deleteArticle(${article.id})"><fmt:message key="prop.form.button.delete"/></button>
	</div>
	<div class="comments">
		<h3><fmt:message key="prop.comments.header"/> <span class="comments__count">${comments.size()}</span></h3> 
		<c:forEach var="comment" items="${comments}">
			<div class="comments__item" data-id="${comment.id}">
				<hr/>
				<p>
					<span class="comments__user">${comment.user.username}</span> 
					<span class="comments__date">
						<fmt:formatDate pattern="MM/dd/yyyy в HH:mm" value="${comment.date}"/> 
					</span> 
					<button class="button-right" onclick="deleteComment(${comment.id}, ${article.id})"><fmt:message key="prop.form.button.delete"/></button>
				</p>
				<p class="comments__text">${comment.text}</p> 
			</div>
		</c:forEach>
		<div>
			<form action="/news/view/${article.id}" method="post">
				<input type="hidden"/> 
				<textarea name="text" rows="10" style="width: 100%; margin: 10px 0 10px 0;"></textarea> 
				<button><fmt:message key="prop.comments.button"/></button>
			</form>
		</div>
		<p><fmt:message key="prop.comments.login"/></p>  
	</div> 
</div>



