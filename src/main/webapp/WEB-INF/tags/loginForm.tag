<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
	<c:when test="${sessionScope.loggedUser != null}">
		<div class="logged">
			<p>Your login: ${loggedUser.getUserLogin()}</p>
			<p>Your email: ${loggedUser.getUserEmail()}</p> 
			<form action="logout" method="POST">
				<input type="submit" value="Logout" />
			</form>				
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
				

