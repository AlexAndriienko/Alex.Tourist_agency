<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/index.css" rel="stylesheet" type="text/css" />
<title>Tourist Agency</title>
</head>
<body>
	<header>
		<div id="logo">
			<a href=""> <img src="images/logo.png" alt="lorem">
			</a>
		</div>


		<h1>Welcome to the tourist agency!</h1>

		<div id="login_form">
			<form action="login" method="POST">
				Login: <br> <input type="text" name="userLogin"> <br>
				<input type="password" name="userPass"> <br> <input
					type="submit" value="login" /> <br>
			</form>
			<p>
				Not member yet? <a href="${pageContext.request.contextPath}/signup">Sign
					up</a>
			</p>
		</div>
	</header>
	<div id="main_menu">
		<nav id="nav">

			<ul>
				<li>Menu1</li>
				<li>Menu2</li>
			</ul>
		</nav>
	</div>
	<article>
	
	</article>
	
	<footer><%=new java.util.Date()%>
	</footer>







</body>
</html>
