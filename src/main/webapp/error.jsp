<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tourist Agency</title>
</head>
<body>
	<h3>Welcome to the tourist agency!</h3>
	<p>	Login or password is incorrect! Please enter a valid login and
		password or <a href="${pageContext.request.contextPath}/signup">Sign up</a></p>
	<form action="login" method="POST">
		Login:<br> <input type="text" name="userLogin"><br>
		<input type="password" name="userPass"><br> <input
			type="submit" value="login" /><br>
	</form>

	<p>
		Not member yet? <a href="${pageContext.request.contextPath}/signup">Sign up</a>
	</p>
	<br>
	<%=new java.util.Date()%>

</body>
</html>
