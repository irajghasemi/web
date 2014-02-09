<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8" />
<title>Founded User</title>
<link href="<%=request.getContextPath()%>/resources/css/layout.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/menu.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/styles.css"
	rel="stylesheet" type="text/css" />
<link
	href="<%=request.getContextPath()%>/resources/css/buttons/buttons.css"
	rel="stylesheet" type="text/css" />
</head>
<style type="text/css">
<!--
.errorblock {
	font-family: Arial, Helvetica, sans-serif;
	color: #E3055E;
	font-weight: normal;
	font-style: italic;
	font-size: 16px;
	border: 3px solid #FFCCCC;
	padding: 8px;
	margin: 16px;
}

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
			<li><a
				href="<c:url value="http://localhost:8080/guard_weblayer/addnewuser/" />">SIGN
					UP</a></li>
			<li><a href="<c:url value="/j_spring_security_logout" />">
					<p class="fontstyle">Log Out</p>
			</a></li>
			<li><a style="font-size: 20px; color: #19BCFF;">${loggedUserById}</a></li>
			<div id="lavalamp"></div>
		</ul>

		<form:errors method="post"></form:errors>

		<img alt="picture"
			src="<c:url value='${request.contextPath}/image/${founduserimage}'/>" />
		<br /> <br /> <br /> <input name="userid"
			value="${userById.userid}" size="45" readonly="readonly" /> <br />
		<br /> <input name="username" value="${userById.username}" size="45"
			readonly="readonly" /> <br /> <br /> <input name="password"
			value="${userById.password}" size="45" readonly="readonly" /> <br />
		<br /> <input name="street" value="${userById.address.street}"
			size="45" readonly="readonly" /> <br /> <br /> <input
			name="zipcode" value="${userById.address.zipcode}" size="45"
			readonly="readonly" /> <br /> <br /> <input name="city"
			value="${userById.address.city}" size="45" readonly="readonly" /> <br />
		<br /> <br /> <br /> <br />

		<button class="button small blue " type="submit"
			onClick="window.location='getuser?userid=${userById.userid}';">
			Update User</button>
		<button class="button small blue " type="submit"
			onClick="window.location='deleteuser?userid=${userById.userid}';">
			Delete User</button>
		<button class="button small blue " type="submit"
			onClick="window.location='addnewuser';" value='Add new User'>
			Add New User</button>

	</div>
	<!-- JavaScript includes -->
	<script src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/script.js"></script>
</body>
</html>