<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags"%>


<template:default_template title="Account">
	<jsp:attribute name="head">
	
	</jsp:attribute>

	<jsp:attribute name="content">
			<p>Your login: ${loggedUser.getUserLogin()}</p>
   			<p>Your email: ${loggedUser.getUserEmail()}</p>			
   			<c:choose>
   				<c:when test="${loggedUser.getUser_Access() == 1}">
   					<p><a href="${pageContext.request.contextPath}/admin_area">You have access to admin management!</a></p>   					  				
   				</c:when>  				
   			</c:choose>
   			<br>
   			<form action="account" method="POST">
   				<input type="hidden" name="formParam" value="1"/>
				<div class="container">
					<p>Change password:</p>
					
					<div class=alert_message>
						<c:forEach items="${passValidationList}" var="message"> ${message} <br>
						</c:forEach>
					</div>
					
					<label for="psw"><b>Password</b></label> 
					<input type="password" placeholder="Enter Password" name="password" required><br>
					<label for="password-repeat"><b>Repeat Password</b></label> 
					<input type="password" placeholder="Repeat Password" name="password-repeat" required><br>	
					<input type="submit" value="Change password"/>
				</div>			
			</form>
			
   			<br>
   			
   			<form action="account" method="POST">
   				<input type="hidden" name="formParam" value="2"/>
				<div class="container">
					<p>Change email:</p>
					
					<div class=alert_message>
						<c:forEach items="${emailValidationList}" var="message"> ${message} <br>
						</c:forEach>
					</div>
					
					<label for="email"><b>Email</b></label> 
					<input type="text" placeholder="Enter Email" name="email" required><br>
					<input type="submit" value="Change email"/>
				</div>			
			</form>
			
			<br>
			
			<form action="account" method="POST">
				<input type="hidden" name="formParam" value="3"/>
				<input type="submit" value="Remove account"/> 			
			</form>
			
	</jsp:attribute>
	
	<jsp:attribute name="sec_content">
			<c:choose>
   				<c:when test="${sessionScope.loggedUser != null}">
   					<div class="logged">
   						<p>Your login: ${loggedUser.getUserLogin()}</p>
   						<p>Your email: ${loggedUser.getUserEmail()}</p> 				
					</div>	   							
				</c:when>
				
   				<c:otherwise>
	   				<div class="login_form">
						<form action="index" method="POST">
							<input class="login_item" type="text" name="userLogin" required placeholder="login"><br> 
							<input class="login_item" type="password" name="userPass" required placeholder="password"><br> 
							<input type="submit" value="Login" />
						</form>
						<span class="login_text">Not member yet? <a href="${pageContext.request.contextPath}/signup">Sign up</a></span>
					</div>	   				
				</c:otherwise>				
			</c:choose>	
				<div class="sec_article">
   					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit , sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>			
				</div>		
	</jsp:attribute>

</template:default_template>


</html>