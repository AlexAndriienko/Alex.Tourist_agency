<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags"%>


<template:default_template title="Our tours">
	<jsp:attribute name="head">
		<script src="js/ajaxourtours.js" type="text/javascript"></script>
	</jsp:attribute>

	<jsp:attribute name="content">
	
			<h2>Our tours</h2>
			<br>
			<p>To order a tour please log in. If you are not registered, please register <a href="${pageContext.request.contextPath}/signup">here</a>.</p>
			<br>
			<div class=seach_form>
				<form action="our_tours" method="POST">
					<input class="seach_tours" type="text" name="seach" required placeholder="Country, city, hotel...">
					<input type="submit" value="Search"/>
				</form>						
			</div>
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
								<c:choose>
   									<c:when test="${sessionScope.loggedUser != null}">
   										<div class = "btn_cont">
											<button class = "addTourBtn" id = "${tour.getTourID()}">To cart</button>
										</div>
									</c:when>										
								</c:choose>
							</div>					
						</c:forEach>					
			</div>
	
	</jsp:attribute>
	<jsp:attribute name="sec_content">
		<template:loginForm></template:loginForm>			
		<div class="sec_article">
   			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit , sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>			
		</div>	
	</jsp:attribute>
</template:default_template>


</html>
