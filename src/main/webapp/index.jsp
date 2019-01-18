<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tourist Agency</title>
</head>
<body>
	<h2>Welcome to the travel agency</h2>

	<form action="login" method="POST">
		Login:<br> <input type="text" name="userLogin"><br>
		<input type="password" name="userPass"><br> 
		<input type="submit" value="login" /><br>
	</form>

	<%= new java.util.Date() %>

</body>
</html>
