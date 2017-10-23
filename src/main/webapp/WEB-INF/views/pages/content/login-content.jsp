<%@ page pageEncoding="UTF-8" isELIgnored="false"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container col-sm-offset-1 col-sm-3"> 
	
	<h3>Вход пользователя</h3>
	
	<form role="form" method="post" action="/motordepot/page?action=log_in">
		<fieldset>
			<div class="input-group">
				<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>	
				<input type="text" name="nickname" class="form-control"  placeholder="Nickname"/>
			</div>
			<div class="input-group">
			<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
				<input type="password" name="password" class="form-control" placeholder="Password"/>
			</div>
			<hr class="colorgraph"/>
			<input type="submit" class="btn btn-success btn-block" value="Login"/>
		</fieldset>
	</form>
</div>	


