<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags"%>


<template:default_template title="Account">
	<jsp:attribute name="head">
	
	</jsp:attribute>

	<jsp:attribute name="content">
			<div class="accMenu">
	  			<input type="radio" name="odin" checked="checked" id="vkl1"/>
	  				<label class = "itemAccMenu" for="vkl1">Shopping cart</label>
	  			<input type="radio" name="odin" id="vkl2"/>	  			
	  				<label class = "itemAccMenu" for="vkl2">Ordered Tours</label>
	  			<input type="radio" name="odin" id="vkl3"/>
	  				<label class = "itemAccMenu" for="vkl3">Account management</label>
	  			<div>
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
					<c:forEach items="${cart}" var="tour">					
						<div class = "table_row">
							<div class = "box box1">${tour.getTourType()}</div>
							<div class = "box box2">${tour.getTourLocation()}</div>
							<div class = "box box3">${tour.getTourCountry()}</div>	
							<div class = "box box4">${tour.getTourCity()}</div>
							<div class = "box box5">${tour.getTourHotel()}</div>
							<div class = "box box6">${tour.getTourDuration()} days</div>
							<div class = "box box7">${tour.getTourPrice()}$</div>							
							<button>X</button>											
						</div>					
					</c:forEach>					
				</div>
				</div>
	  			<div>
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
							<c:forEach items="${loggedUser.getUserTours()}" var="tour">					
								<div class = "table_row">
									<div class = "box box1">${tour.getTourType()}</div>
									<div class = "box box2">${tour.getTourLocation()}</div>
									<div class = "box box3">${tour.getTourCountry()}</div>	
									<div class = "box box4">${tour.getTourCity()}</div>
									<div class = "box box5">${tour.getTourHotel()}</div>
									<div class = "box box6">${tour.getTourDuration()} days</div>
									<div class = "box box7">${tour.getTourPrice()}$</div>							
									<button>X</button>											
								</div>					
							</c:forEach>					
				</div>
	  			
	  			</div>
	  			<div>
	  				<p>Your login: ${loggedUser.getUserLogin()}</p>
		   			<p>Your email: ${loggedUser.getUserEmail()}</p>			
		   			<c:choose>
		   				<c:when test="${loggedUser.getUser_Access() == 1}">
		   					<p><a href="${pageContext.request.contextPath}/admin_area">You have access to admin management!</a></p>   					  				
		   				</c:when>  				
		   			</c:choose>
		   			<br>
		   			<form action="account" method="POST">
		   				<input type="hidden" name="formParam" value="1"/>
						<div class="container">
							<p>Change password:</p>
							
							<div class=alert_message>
								<c:forEach items="${passValidationList}" var="message"> ${message} <br>
								</c:forEach>
							</div>
							
							<label for="psw"><b>Password</b></label> 
							<input type="password" placeholder="Enter Password" name="password" required><br>
							<label for="password-repeat"><b>Repeat Password</b></label> 
							<input type="password" placeholder="Repeat Password" name="password-repeat" required><br>	
							<input type="submit" value="Change password"/>
						</div>			
					</form>
					
		   			<br>
		   			
		   			<form action="account" method="POST">
		   				<input type="hidden" name="formParam" value="2"/>
						<div class="container">
							<p>Change email:</p>
							
							<div class=alert_message>
								<c:forEach items="${emailValidationList}" var="message"> ${message} <br>
								</c:forEach>
							</div>
							
							<label for="email"><b>Email</b></label> 
							<input type="text" placeholder="Enter Email" name="email" required><br>
							<input type="submit" value="Change email"/>
						</div>			
					</form>
					
					<br>
					
					<form action="account" method="POST">
						<input type="hidden" name="formParam" value="3"/>
						<input type="submit" value="Remove account"/> 			
					</form>
	  				  			
	  			</div>
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