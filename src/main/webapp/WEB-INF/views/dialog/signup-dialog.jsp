<%@ page pageEncoding="UTF-8" isELIgnored="false"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div id="signupModal" class="modal fade"> 
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4><fmt:message key="prop.user.header.registration"/></h4>
			</div>
			<div class="modal-body">
				<form class="form-dialog" action="/motordepot/page?action=sign_up" method="post" id="signUpForm"
					data-bv-feedbackicons-valid="glyphicon glyphicon-ok"
					data-bv-feedbackicons-invalid="glyphicon glyphicon-remove"
					data-bv-feedbackicons-validating="glyphicon glyphicon-refresh"> 
					<div class="alert" style="padding: 8px; display: none" id="signup-message">
						<a href="#" onclick="hiddenSignUpAlertMessage()" class="close">×</a>
						<span></span>
					</div>
					<fieldset>
						<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>	
								<input type="text" autocomplete="false" name="nickname" class="form-control"  
									placeholder="<fmt:message key="prop.user.column.nickname.placeholder"/>"
									required data-bv-notempty-message="<fmt:message key="prop.user.column.nickname.notempty"/>"
									minLength="5" maxLength="25" data-bv-stringlength-message="<fmt:message key="prop.user.column.nickname.stringlength"/>"/>
							</div>
						</div>
						<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
								<input type="password" autocomplete="false" name="password" class="form-control" 
									placeholder="<fmt:message key="prop.user.column.password.placeholder"/>"
									required data-bv-notempty-message="<fmt:message key="prop.user.column.password.notempty"/>"
									minLength="5" maxLength="25" data-bv-stringlength-message="<fmt:message key="prop.user.column.password.stringlength"/>"/>
							</div>
						</div>
						<br/>
						<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
								<input type="text" name="name" class="form-control" 
									required data-bv-notempty-message="<fmt:message key="prop.user.column.name.notempty"/>"
									placeholder="<fmt:message key="prop.user.column.name.placeholder"/>"/>
							</div>
						</div>
						<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
								<input type="text" name="lastname" class="form-control"
									required data-bv-notempty-message="<fmt:message key="prop.user.column.lastname.notempty"/>" 
									placeholder="<fmt:message key="prop.user.column.lastname.placeholder"/>"/>
							</div>
						</div>
						<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon"><i class="glyphicon glyphicon-road"></i></span>
								<input type="text" name="drivenExperience" class="form-control"
									required data-bv-notempty-message="<fmt:message key="prop.user.column.drivenExperience.notempty"/>"
									pattern="^\d+$" data-bv-regexp-message="<fmt:message key="prop.user.column.drivenExperience.regexp"/>"
									placeholder="<fmt:message key="prop.user.column.drivenExperience.placeholder"/>"/>
							</div>
						</div>
						<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span>
								<input type="text" name="phone" class="form-control" 
									required data-bv-notempty-message="<fmt:message key="prop.user.column.phone.notempty"/>"
									pattern="^(\+[0-9]+)?\s?(\([0-9]{2,}\))?\s?[0-9]{2,}-[0-9]{2}-[0-9]{2}$" data-bv-regexp-message="<fmt:message key="prop.user.column.phone.regexp"/>"
									placeholder="<fmt:message key="prop.user.column.phone.placeholder"/>"/>
							</div>
						</div>
						<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
								<input type="text" name="email" class="form-control"
									required data-bv-notempty-message="<fmt:message key="prop.user.column.email.notempty"/>"
									pattern="^[^@\s]+@[^@\s]+\.[^@\s]+$" data-bv-regexp-message="<fmt:message key="prop.user.column.email.regexp"/>" 
									placeholder="<fmt:message key="prop.user.column.email.placeholder"/>"/>
							</div>
						</div>
						<input type="submit" class="btn btn-success btn-block" value="<fmt:message key="prop.user.button.signup"/>"/>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</div>	


