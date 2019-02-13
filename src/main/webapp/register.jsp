<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags"%>

<template:default_template title="Signup">
	<jsp:attribute name="head">
		<script src="${pageContext.request.contextPath}/js/ajaxvalidate.js" type="text/javascript"></script>
	</jsp:attribute>

	<jsp:attribute name="content">
		<p>Please fill this form to create an account or fill the login form if you are a registered user.</p>
	
	<div class="register">
		<form id = register_form>							
			<input id = "login" type="text" placeholder="Enter Login" name="login" required><span id="msgLogin"></span> <br>				
			<input id = "email" type="text" placeholder="Enter Email" name="email" required><span id="msgEmail"></span> <br>			
			<input id = "pass" type="password" placeholder="Enter Password" name="pass" required><span id="msgPass"></span><br>				
			<input id = "passRpt" type="password" placeholder="Repeat Password" name="passRpt" required> <span id="msgPassRpt"></span><br><br>	
			<button type="submit" class="registerbtn">Register</button>			
		</form>
	</div>
			
	</jsp:attribute>
	
	<jsp:attribute name="sec_content">
		<template:loginForm></template:loginForm>			
		<div class="sec_article">
   			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit , sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>			
		</div>	
	</jsp:attribute>

</template:default_template>

</html>