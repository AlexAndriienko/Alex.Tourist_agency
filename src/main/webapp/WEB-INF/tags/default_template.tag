<%@ tag language="java" pageEncoding="UTF-8"%>
<%@attribute name="title" required="true" rtexprvalue="true"%>
<%@attribute name="head" fragment = "true"%>
<%@attribute name="content" fragment = "true"%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="css/index.css" rel="stylesheet" type="text/css" />
		<title>${title}</title>
		<jsp:invoke fragment="head"></jsp:invoke>
	</head>

	<div class="wrapper">
		<div class="header">	
			<div class="fl">	
				<div class="logo">
					<a href="/touristAgency/"> <img class="img_logo" src="images/logo.png" alt="lorem"></a>
				</div>				
				<span class="tagline">Over 5 million tours and excursions in 80 countries of the world from 50 tour operators</span>
				<div class="localisation"></div>				
			</div>
			<div class=clear></div>
		</div>
		
		<div class="main_menu">
			<ul>
				<li class=menu_item><a class = "switch" href="/touristAgency/">Main</a></li>
				<li class=menu_item><a class = "switch" href="/touristAgency/">Our tours</a></li>
				<li class=menu_item><a class = "switch" href="/touristAgency/">Account</a></li>
				<li class=menu_item><a class = "switch"href="/touristAgency/">Contacts</a></li>
				<li class=clear></li>
			</ul>
		</div>
				
		<div class="main">
			<div class="page">
				<div class="article">
					<jsp:invoke fragment="content"></jsp:invoke>
				</div>
			</div>						
			<div class="secondary">
				<div class="login_form">
					<form action="index" method="POST">
						<input class = "login_item" type="text" name="userLogin" required placeholder="login"> <br>
						<input class = "login_item" type="password" name="userPass" required placeholder="password"> <br>
						<input type="submit" value="Login"/>
					</form>
					<span class="login_text">Not member yet? <a href="${pageContext.request.contextPath}/signup">Sign up</a></span>
				</div>
			</div>
			<div class=clear></div>	
		</div>
		
		<div class="footer">
		<%=new java.util.Date()%>
		</div>
	</div>
</html>
