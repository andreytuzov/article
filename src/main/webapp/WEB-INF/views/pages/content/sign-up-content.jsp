<%@ page pageEncoding="UTF-8" isELIgnored="false"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container col-sm-offset-1 col-sm-3"> 
	
	<h3>Регистрация пользователя</h3>
	
	<form action="/motordepot/page?action=sign_up" method="post" role="form"> 
		<fieldset>
			<div class="input-group">
				<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>	
				<input type="text" name="nickname" class="form-control"  placeholder="Nickname"/>
			</div>
			<div class="input-group">
				<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
				<input type="password" name="password" class="form-control" placeholder="Password"/>
			</div>
			<br/>
			<div class="input-group">
				<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
				<input type="text" name="name" class="form-control" placeholder="Name"/>
			</div>
			<div class="input-group">
				<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
				<input type="text" name="lastname" class="form-control" placeholder="Lastname"/>
			</div>
			<div class="input-group">
				<span class="input-group-addon"><i class="glyphicon glyphicon-road"></i></span>
				<input type="number" name="drivenExperience" class="form-control" placeholder="Driven experience, years"/>
			</div>
			<div class="input-group">
				<span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span>
				<input type="text" name="phone" class="form-control" placeholder="Phone"/>
			</div>
			<div class="input-group">
				<span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
				<input type="text" name="email" class="form-control" placeholder="Email"/>
			</div>
			<hr/>
			<input type="submit" class="btn btn-success btn-block" value="Sign Up"/>
		</fieldset>
	</form>
</div>	


