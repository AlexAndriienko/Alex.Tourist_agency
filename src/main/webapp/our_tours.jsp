<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags"%>


<template:default_template title="Our tours">
	<jsp:attribute name="head">
	
	</jsp:attribute>

	<jsp:attribute name="content">
	
			<h2>Our tours</h2>
			<br>
			<p>To order a tour please log in to your <a href="${pageContext.request.contextPath}/account">account</a>. If you are not registered, please register <a href="${pageContext.request.contextPath}/signup">here</a>.</p>
			<br>
			
			<br>
			<div class=table_tour>
						<div class = "table_row">
							<div class = "titlebox box1"><p>Tour type</p></div>
							<div class = "titlebox box2"><p>Location</p></div>
							<div class = "titlebox box3"><p>Country</p></div>	
							<div class = "titlebox box4"><p>City</p></div>
							<div class = "titlebox box5"><p>Hotel</p></div>
							<div class = "titlebox box6"><p>Duration</p></div>
							<div class = "titlebox box7"><p>Price</p></div>
						</div>	
						<c:forEach items="${tours}" var="tour">					
							<div class = "table_row">
								<div class = "box box1">${tour.getTourType()}</div>
								<div class = "box box2">${tour.getTourLocation()}</div>
								<div class = "box box3">${tour.getTourCountry()}</div>	
								<div class = "box box4">${tour.getTourCity()}</div>
								<div class = "box box5">${tour.getTourHotel()}</div>
								<div class = "box box6">${tour.getTourDuration()} days</div>
								<div class = "box box7">${tour.getTourPrice()}$</div>
							</div>					
						</c:forEach>
			</div>
	
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
