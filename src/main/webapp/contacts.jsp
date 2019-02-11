<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags"%>


<template:default_template title="Contacts">
	<jsp:attribute name="head">
	
	</jsp:attribute>

	<jsp:attribute name="content">
			<h2>Our contacts</h2>
			<br>	
		<p>Tel:</p>
		<p>Fax:</p>
		<p>Email:</p>
		<p>Skype:</p>
	
	</jsp:attribute>
	
	<jsp:attribute name="sec_content">
		<template:loginForm></template:loginForm>			
		<div class="sec_article">
   			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit , sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>			
		</div>	
	</jsp:attribute>

</template:default_template>


</html>
