<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="dto.UserData"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Travel agency</title>
</head>
<body>
<p>Welcome <%= request.getAttribute("loggedUserLogin") %>!</p>


</body>
</html>