<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tourist Agency</title>
</head>
<body>

	<form action="signup" method="POST">
		<div class="container">
			<h1>Sign up</h1>
			<p>Please fill in this form to create an account.</p>
			
			<label for="login"><b>Login</b></label> 
			<input type="text" placeholder="Enter Login" name="login" required>
			<label for="email"><b>Email</b></label> 
			<input type="text" placeholder="Enter Email" name="email" required>
			<label for="psw"><b>Password</b></label> 
			<input type="password"	placeholder="Enter Password" name="psw" required>
			<label for="psw-repeat"><b>Repeat Password</b></label> 
			<input type="password" placeholder="Repeat Password" name="psw-repeat" required> <br><br>	
			<button type="submit" class="registerbtn">Register</button>
		</div>

		<div class="container signin">
			<p>
				Already have an account? <a href="${pageContext.request.contextPath}/">Login</a>.
			</p>
		</div>
	</form>

</body>
</html>