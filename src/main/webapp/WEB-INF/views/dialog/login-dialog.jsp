<%@ page pageEncoding="UTF-8" isELIgnored="false"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div id="loginModal" class="modal fade"> 
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4><fmt:message key="prop.user.header.login"/></h4>
			</div>
			<div class="modal-body">
				<form id="loginForm" method="post" action="/motordepot/page?action=log_in"
					data-bv-feedbackicons-valid="glyphicon glyphicon-ok"
					data-bv-feedbackicons-invalid="glyphicon glyphicon-remove"
					data-bv-feedbackicons-validating="glyphicon glyphicon-refresh">
					<div class="alert" style="padding: 8px; display: none" id="login-message">
						<a href="#" onclick="hiddenLoginAlertMessage()" class="close">×</a>
						<span></span>
					</div>
					<fieldset>
						<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>	
								<input type="text" name="nickname" class="form-control"  
									placeholder="<fmt:message key="prop.user.column.nickname.placeholder"/>" 
									required data-bv-notempty-message="<fmt:message key="prop.user.column.nickname.notempty"/>"
									minLength="5" maxLength="25" data-bv-stringlength-message="<fmt:message key="prop.user.column.nickname.stringlength"/>"/>
							</div>
						</div>
						<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
								<input type="password" name="password" class="form-control" 
									placeholder="<fmt:message key="prop.user.column.password.placeholder"/>"
									required data-bv-notempty-message="<fmt:message key="prop.user.column.password.notempty"/>"
									minLength="5" maxLength="25" data-bv-stringlength-message="<fmt:message key="prop.user.column.password.stringlength"/>"/> 
							</div>
						</div>
						<input type="submit" class="btn btn-success btn-block" 
							value="<fmt:message key="prop.user.button.login"/>"/>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</div>	


