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
<title>Pure CSS3 LavaLamp Menu | Script Tutorials</title>
<link href="<%=request.getContextPath()%>/resources/css/layout.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/menu.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/styles.css"
	rel="stylesheet" type="text/css" />
<link
	href="<%=request.getContextPath()%>/resources/css/buttons/bonbon-buttons.css"
	rel="stylesheet" type="text/css" />

<!-- <link -->
<%-- 	href="<%=request.getContextPath()%>/resources/css/buttons/reset-min.css" --%>
<!-- 	rel="stylesheet" type="text/css" /> -->
<%-- <script  src="<%=request.getContextPath()%>/resources/js/script.js"  type="text/javascript"/> --%>
<title>Buttons</title>
<style type="text/css">
html {
	background-color: #ddd;
	font: 62.5%/1 "Lucida Sans Unicode", "Lucida Grande", Verdana, Arial,
		Helvetica, sans-serif;
}

body {
	padding: 100px;
}

#wrapper {
	text-align: center;
}

/*It appears that the Pictos Font resets the line-height of the icon.. so if you are using them, delete the line below. */
/* .icon:before { */
/* 	line-height: .7em; */
/* } */
</style>
</head>
<style type="text/css">
<!--
.fontstyle {
	font-family: Arial, Helvetica, sans-serif;
	color: #19BCFF;
	font-weight: normal;
	font-style: italic;
	font-size: 16px;
}

.font2 {
	font-family: Arial, Helvetica, sans-serif;
	color: #E3055E;
	font-weight: normal;
	font-style: italic;
	font-size: 16px;
}

.font3 {
	font-family: Arial, Helvetica, sans-serif;
	color: #0505F2;
	font-weight: normal;
	font-style: italic;
	font-size: 16px;
}
</style>
<body>
	<header>
	<h2 align="right">Welcome To Rapid Larm Central Menu</h2>
	<a href="<c:url value="http://localhost:8080/guard_weblayer/" />"
		class="stuts"></a></header>
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
			<li><a href="#">Menu 6</a></li>
			<li><a
				href="<c:url value="http://localhost:8080/guard_weblayer/addnewuser/" />">SIGN
					UP</a></li>
			<li><a href="<c:url value="/j_spring_security_logout" />">
					<p class="fontstyle">Log Out</p>
			</a></li>
			<div id="lavalamp"></div>
		</ul>
		<br /> <br /> <br />

		<div id="wrapper">

<!-- 			<a href="#" class="button">SIGN UP</a> <a href="#" -->
<!-- 				class="button blue">UPDATE USER</a> <a href="#" -->
<!-- 				class="button orange">DELETE</a> <a href="#" class="button pink ">Button</a> -->
<!-- 			<a href="#" class="button green">Button</a> <br /> <a href="#" -->
<!-- 				data-icon="" class="button orange shield glossy">King</a> <a -->
<!-- 				href="#" data-icon="" class="button orange shield glossy">King</a> <a -->
<!-- 				href="#" data-icon="" class="button blue shield glossy">King</a> <a -->
<!-- 				href="#" data-icon="" class="button pink serif round glass">Queen</a> -->
<!-- 			<br /> <a href="#" data-icon="" class="button blue serif round glass">Queen</a> -->
<!-- 			<a href="#" data-icon="" class="button blue skew">Horse</a> <a -->
<!-- 				href="#" data-icon="" class="button green icon">Flower</a> <br /> <a -->
<!-- 				href="#accessibility" role="button" tabindex="1" -->
<!-- 				class="button green">Tab1</a> <a href="#accessibility" role="button" -->
<!-- 				tabindex="2" class="button green">Tab2</a> -->
<!-- 			<button disabled class="button green glossy">Disabled</button> -->
<a class="button green"> 1</a>
<a class="button blue"> 2</a>
<a class="button orange"> 3</a>
<a class="button pink"> 4</a>
<a class="button green"> 5</a>
<a class="button green"> 6</a>
<a class="button green"> 7</a>
<a class="button green"> 8</a>
<a class="button green"> 9</a>
<a class="button green"> 10</a>
<br/>
<a class="button green"> 1</a>
<a class="button green"> 2</a>
<a class="button green"> 3</a>
<a class="button green"> 4</a>
<a class="button green"> 5</a>
<a class="button green"> 6</a>
<a class="button green"> 7</a>
<a class="button green"> 8</a>
<a class="button green"> 9</a>
<a class="button green"> 10</a>

		</div>

		<br /> <br />
		<div>
			<button class="button blue medium " type="submit"
				onClick="location.href='getAllUsers'">Back To Users</button>
		</div>
<br/>
<br/>
<br/>
<br/>

		<!-- JavaScript includes -->
		<script src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
		<script src="<%=request.getContextPath()%>/resources/js/script.js"></script>
		<!-- 		<script src="resources/js/script.js"></script> -->

	</div>

</body>
</html>