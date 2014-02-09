<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<html lang="en">
<head>
<title>Find User By Name</title>
<link href="<%=request.getContextPath()%>/resources/css/layout.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/menu.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/styles.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/buttons/buttons.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/fontstyle.css" rel='stylesheet' type='text/css' />
<script src="<%=request.getContextPath()%>/resources/css/flextable/js/prefixfree.min.js"></script>
<link href="<%=request.getContextPath()%>/resources/css/inputForm/fancyInput.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/flextable/css/style.css" rel="stylesheet" type="text/css" />  
</head>
<div style="clear:left; height:50px;"></div>
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
	
		<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Civic Number</th>
        <th>Username</th>
        <th>Email</th>
        <th>Street</th>
        <th>ZipCode</th>
        <th>City</th>
        <th>Update User</th>
        <th>Delete User</th>
        <th>Add New User</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${allUsers}">
    <tr>
        <td>${user.userid}</td>
							<td>${user.firstname}</td>
							<td>${user.lastname}</td>
							<td>${user.civicregnumber}</td>
							<td>${user.username}</td>
							<td><a href="mailto:${user.email}">${user.email}</a></td>
							<td>${user.address.street}</td>
							<td>${user.address.zipcode}</td>
							<td>${user.address.city}</td>
							<td><button class="button small blue " type="submit"
									onClick="window.location='getuser?userid=${user.userid}';">
									Update User</button></td>
							<td>
							<button class="button small blue " type="submit" onClick="window.location='deleteuser?userid=${user.userid}';">
									Delete User</button></td>
							<td><button class="button small blue " type="submit"
									onClick="window.location='addnewuser';" value='Add new User'>
									Add New User</button></td>
						</tr>
					</c:forEach>
				</tbody>
</table>   

  <script src="<%=request.getContextPath()%>/resources/js/codepen.js"></script>   
  <script src="<%=request.getContextPath()%>/resources/js/macical.js"></script>   

	</div>
</body>
</html>