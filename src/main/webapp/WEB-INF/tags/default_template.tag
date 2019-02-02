<%@ tag language="java" pageEncoding="UTF-8"%>
<%@attribute name="title" required="true" rtexprvalue="true"%>
<%@attribute name="head" fragment="true"%>
<%@attribute name="content" fragment="true"%>
<%@attribute name="sec_content" fragment="true"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/index.css" rel="stylesheet" type="text/css" />
<title>${title}</title>
<jsp:invoke fragment="head"></jsp:invoke>
</head>
<body>

	<div class="wrapper">
		<div class="header">
			<div class="fl">
				<div class="logo">
					<a href="/touristAgency/"> <img class="img_logo"
						src="images/logo.png" alt="lorem"></a>
				</div>
				<span class="tagline">Over 5 million tours and excursions in
					80 countries of the world from 50 tour operators</span>
				<div class="localisation"></div>
			</div>
			<div class=clear></div>
		</div>

		<div class="main_menu">
			<ul>
				<li class=menu_item><a class="switch a1" href="${pageContext.request.contextPath}/">Main</a></li>
				<li class=menu_item><a class="switch a2" href="${pageContext.request.contextPath}/our_tours">Our tours</a></li>
				<li class=menu_item><a class="switch a3" href="${pageContext.request.contextPath}/account">Account</a></li>
				<li class=menu_item><a class="switch a4" href="${pageContext.request.contextPath}/contacts.jsp">Contacts</a></li>
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
				<jsp:invoke fragment="sec_content"></jsp:invoke>
			</div>
			<div class=clear></div>
		</div>

		<div class="footer">
			<%=new java.util.Date()%>
			<p>Site design © 2019 Alex Andrienko</p>
		</div>
	</div>
</body>
</html>
