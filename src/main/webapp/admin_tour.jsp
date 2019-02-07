<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags"%>


<template:default_template title="Admin">

	<jsp:attribute name="head">	
	</jsp:attribute>

	<jsp:attribute name="content">
		
	   <h3>Create new tour</h3>
		<div class = addNewTours>
			<form action="admin" method="POST">
				<input type="hidden" name="formParam" value="1"/>
				<input type="text" name="tour_Type" required placeholder="type"><br>
				<input type="text" name="tour_Location" placeholder="location"><br>
				<input type="text" name="tour_Country" required placeholder="country"><br>
				<input type="text" name="tour_City" required placeholder="city"><br>
				<input type="text" name="tour_Hotel" required placeholder="hotel"><br>
				<input type="text" name="tour_Duration" required placeholder="Duration"><br>
				<input type="text" name="tour_Price" required placeholder="Price"><br>
				<input type="submit" value="Create tour" />
			</form>
		</div>
		<br>
		<div class=table_tour>
			<c:forEach items="${tours}" var="tour">					
				<div class="table_row">
					<div class="box box1">${tour.getTourType()}</div>
					<div class="box box2">${tour.getTourLocation()}</div>
					<div class="box box3">${tour.getTourCountry()}</div>	
					<div class="box box4">${tour.getTourCity()}</div>
					<div class="box box5">${tour.getTourHotel()}</div>
					<div class="box box6">${tour.getTourDuration()} days</div>
					<div class="box box7">${tour.getTourPrice()}$</div>
					<button>Delete tour</button>								
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
