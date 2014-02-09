<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8" />
<title>Upload picture</title>
<link href="<%=request.getContextPath()%>/resources/css/layout.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/menu.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/styles.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/buttons/buttons.css"
	rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath()%>/resources/css/fontstyle.css" rel='stylesheet' type='text/css' />
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/inputForm/fancyInput.css"  />
<title>Update User</title>
</head>

<body>

	<header>
	<h2 align="right">Welcome To Rapid Larm Central Menu</h2>
	<a href="<c:url value="http://localhost:8080/guard_weblayer/" />" class="stuts"></a></header>
	<div class="container">

		<ul id="nav">
			<li><a
				href="<c:url value="http://localhost:8080/guard_weblayer/" />">Home</a></li>
			<li><a class="hsubs" href="#">Menu 1</a>
				<ul class="subs">
					<li><a href="#">Submenu 1</a></li>
					<li><a href="#">Submenu 2</a></li>
					<li><a href="#">Submenu 3</a></li>
					<li><a href="#">Submenu 4</a></li>
					<li><a href="#">Submenu 5</a></li>
				</ul></li>
			<li><a class="hsubs" href="#">Menu 2</a>
				<ul class="subs">
					<li><a href="#">Submenu 2-1</a></li>
					<li><a href="#">Submenu 2-2</a></li>
					<li><a href="#">Submenu 2-3</a></li>
					<li><a href="#">Submenu 2-4</a></li>
					<li><a href="#">Submenu 2-5</a></li>
					<li><a href="#">Submenu 2-6</a></li>
					<li><a href="#">Submenu 2-7</a></li>
					<li><a href="#">Submenu 2-8</a></li>
				</ul></li>
			<li><a class="hsubs" href="#">Menu 3</a>
				<ul class="subs">
					<li><a href="#">Submenu 3-1</a></li>
					<li><a href="#">Submenu 3-2</a></li>
					<li><a href="#">Submenu 3-3</a></li>
					<li><a href="#">Submenu 3-4</a></li>
					<li><a href="#">Submenu 3-5</a></li>
				</ul></li>
			<li><a href="#">Menu 4</a></li>
			<li><a href="#">Menu 5</a></li>
			<li><a href="<c:url value="/j_spring_security_logout" />"> <p class="fontstyle">Log Out</p></a></li>
			<li><a style="font-size: 20px; color: #19BCFF;">${currentUser}</a></li>
			<div id="lavalamp"></div>
		</ul>
		<br />
		<br />
		<br />
		<br />
		<div id="buttonContainer" style="overflow:auto; height: 1000px; width: 1150px">
			<form action="updateuser?userid=${getuserforupdate.userid}" method="post" modelAttribute="user" class="font3" >

				<p style="color: #19BCFF; font-size: 16px; font-style: italic;">
					<label for="firstname">First Name </label> <br /> <input name="firstname"  required="required" value="${getuserforupdate.firstname}" size="45" /> 
					<label for="lastname">Last Name </label> <br /> <input name="lastname"  required="required" value="${getuserforupdate.lastname}" size="45" />
					<label for="lastname">Civic Number </label> <br /> <input name="civicregnumber"  required="required" value="${getuserforupdate.civicregnumber}" size="45" />
					<label for="username">User Name </label> <br /> <input name="username"  required="required" value="${getuserforupdate.username}" size="45" />
					<label for="password">Password </label> <br /> <input name="password"  required="required" value="${getuserforupdate.password}" size="45" /> 
					<label for="email">Email </label> <br /> <input name="email"  required="required" value="${getuserforupdate.email}" size="45" /> 
					 <label for="Street">Street</label> <br/> <input name="street"  required="required" maxlength="45" value="${address.street}" size="45" /> 
					<label for="Zipcode">Zip Code</label><br /> <input name="zipcode"  required="required" maxlength="45" value="${address.zipcode}" size="45" />
					<label for="City">City</label> <br /> <input name="city"  required="required" maxlength="45" value="${address.city}" size="45" />
				</p>
				<br />
				<button class="button blue medium " type="submit">Update</button>
				<br />
			</form>
		</div>
		
	</div>
	<footer> </footer>

	<!-- JavaScript includes -->
	<script src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/script.js"></script>
	<!-- 		<script src="resources/js/script.js"></script> -->

	</div>

</body>
</html>