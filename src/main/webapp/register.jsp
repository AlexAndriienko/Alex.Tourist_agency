<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags"%>

<template:default_template title="Signup">
	<jsp:attribute name="head">
	
	</jsp:attribute>

	<jsp:attribute name="content">
	
		<form action="signup" method="POST">
			<div class="container">
				<p>Please fill in this form to create an account or fill the login form if you are a registered user.</p>
				<div class=alert_message>
					<c:forEach items="${resultValidationList}" var="message"> ${message} <br>
					</c:forEach>
				</div>
				
				<label for="login"><b>Login</b></label> 
				<input type="text" placeholder="Enter Login" name="login" required><br>
				<label for="email"><b>Email</b></label> 
				<input type="text" placeholder="Enter Email" name="email" required><br>
				<label for="psw"><b>Password</b></label> 
				<input type="password" placeholder="Enter Password" name="password" required><br>
				<label for="password-repeat"><b>Repeat Password</b></label> 
				<input type="password" placeholder="Repeat Password" name="password-repeat" required> <br><br>	
				<button type="submit" class="registerbtn">Register</button>
			</div>
			
		</form>
	
	</jsp:attribute>
	
	<jsp:attribute name="sec_content">
		<template:loginForm></template:loginForm>			
		<div class="sec_article">
   			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit , sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>			
		</div>	
	</jsp:attribute>

</template:default_template>

</html>