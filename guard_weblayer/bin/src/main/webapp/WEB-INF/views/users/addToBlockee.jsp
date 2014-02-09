<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Founded User</title>
<meta charset="utf-8" />
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
	<h2>Find User By Name</h2>
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
			<li><a href="<c:url value="/j_spring_security_logout" />">
					<p class="fontstyle">Log ut</p>
			</a></li>
			<li><a style="font-size: 20px; color: #19BCFF;">${userlogin}</a></li>
			<div id="lavalamp"></div>
		</ul>
		<br /> <br /> <br />

		<div id="buttonContainer" class="fontstyle">
			<form action="" method="get">

				<label for="userOne">Serach User One </label> <br /> <input
					name="anyvalue" style="" required="required" maxlength="45"
					placeholder="anyvalue" size="45" /><br />
				<!-- 					<label for="userTwo">Search User Two </label> <br/> -->
				<!-- 					<input name="anyvalue" style="" required="required" maxlength="45" placeholder="anyvalue" size="45" /> -->

				<br />
				<br />
				<button class="button small blue " type="submit">Search</button>
				<br />
				<br />
			</form>
		</div>

		<div style="overflow: auto; height: 1000px; width: 1150px">
			<table class="font2" align="left" width="100%" style="height: 50%">
				<thead>
					<tr valign="baseline" align="left">
						<td>User Id</td>
						<td>First Name</td>
						<td>Last Name</td>
						<td>User Name</td>
						<td>Password</td>
						<td>Email</td>
						<td>Street</td>
						<td>Zip Code</td>
						<td>City</td>
						<td>Update User</td>
						<td>Delete User</td>
						<td>Add New User</td>
					</tr>
				</thead>
				<tbody class="fontstyle">
					<tr valign="baseline" align="left">
						<td>${userOne.userid}</td>
						<td>${userOne.firstname}</td>
						<td>${userOne.lastname}</td>
						<td>${userOne.username}</td>
						<td>${userOne.password}</td>
						<td>${userOne.email}</td>
						<td>${userOne.address.street}</td>
						<td>${userOne.address.zipcode}</td>
						<td>${userOne.address.city}</td>

					</tr>
				</tbody>
				<tbody class="fontstyle">
					<tr valign="baseline" align="left">
						<td>${userTow.userid}</td>
						<td>${userTow.firstname}</td>
						<td>${userTow.lastname}</td>
						<td>${userTow.username}</td>
						<td>${userTow.password}</td>
						<td>${userTow.email}</td>
						<td>${userTow.address.street}</td>
						<td>${userTow.address.zipcode}</td>
						<td>${userTow.address.city}</td>

					</tr>
				</tbody>
			</table>
		</div>
</body>
</html>