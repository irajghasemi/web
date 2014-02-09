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
<title>Single Image</title>
<link href="<%=request.getContextPath()%>/resources/css/layout.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/menu.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/styles.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/buttons/buttons.css" rel="stylesheet" type="text/css" />
<%-- <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/imagetable.css" type="text/css" media="screen, projection" /> --%>
<%-- <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/texttable.css" type="text/css" media="screen, projection" /> --%>
<link href="<%=request.getContextPath()%>/resources/css/fontstyle.css" rel='stylesheet' type='text/css' />
<link href="<%=request.getContextPath()%>/resources/css/flextable/css/csstable.css" rel="stylesheet" type="text/css" /> 
</head>
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
				href="<c:url value="http://localhost:8080/guard_weblayer/addnewuser/" />"><p
						class="fontstyle">SIGN UP</p></a></li>
			<li><a href="<c:url value="/j_spring_security_logout" />">
					<p class="fontstyle">Log Out</p>
			</a></li>
			<li><a style="font-size: 20px; color: #19BCFF;">${currentUser}</a></li> 

			<div id="lavalamp"></div>
		</ul>
<div style="clear:left; height:50px;"></div>
		<div class="caption">Singel image for user</div>	
<div id="table">
	<div class="header-row row">
    <span class="cell primary">Picture</span>
     <span class="cell primary">First Name</span>
    <span class="cell primary">Surname</span>
    <span class="cell primary">Image Id</span>
    <span class="cell primary">User Id</span>
     <span class="cell primary">Email</span>
     <span class="cell primary">Street</span>
     <span class="cell primary">Zip Code</span>
     <span class="cell primary">City</span>
     <span class="cell primary">Update</span>
     <span class="cell primary">Delete</span>
  </div>
  <div class="row">
    <span class="cell primary" data-label="picture"><img alt="picture" src="<c:url value='${request.contextPath}/image/${founduserimage}'/>" /></span>
    <span class="cell primary" data-label="userid">${user.firstname}</span>
     <span class="cell primary" data-label="firstname">${user.lastname}</span>
     <span class="cell primary" data-label="surname">${founduserimage}</span>
     <span class="cell primary" data-label="email">${user.userid}</span>
     <span class="cell primary" data-label="email"><a href="mailto:${user.email}">${user.email}</a></span>
     <span class="cell primary" data-label="email">${user.address.street}</span>
     <span class="cell primary" data-label="email">${user.address.zipcode}</span>
     <span class="cell primary" data-label="email">${user.address.city}</span>
     
     <span class="cell primary" data-label="Trans">
     <button class="button small blue " type="submit" onClick="window.location='getuser?userid=${user.userid}';"> Update User</button>
     </span>
     
     <span class="cell primary" data-label="Trans">
     <button class="button small blue " type="submit" onClick="window.location='deleteuser?userid=${user.userid}';"> Delete User</button>
     </span>
    
  </div>  
	</div>
		<!-- JavaScript includes -->
		<script src="<%=request.getContextPath()%>/resources/js/script.js"></script>

</body>
</html>

