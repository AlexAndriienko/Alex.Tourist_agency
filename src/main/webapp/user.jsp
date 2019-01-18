<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>User</title>
</head>
<body>
	<section>
		<h3>User info</h3>
		<jsp:useBean id="user" scope="request" type="dto.UserData" />
		<table border="1">
			<tr>
				<td>ID: ${user.userID} | Login: ${user.userLogin}</td>
			</tr>
		</table>

	</section>
</body>
</html>