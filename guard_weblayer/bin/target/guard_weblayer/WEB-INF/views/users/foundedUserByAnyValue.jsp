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
		<div>
			<c:if test="${empty list}">
				<p class="fontstyle">User dosen't exist</p>
			</c:if>
		</div>
		<div>
			<c:if test="${empty tokenValues}">
				<p class="fontstyle">User dosen't exist</p>
			</c:if>
		</div>
		<div style="overflow: auto; height: 1000px; width: 1150px">
			<table class="fontstyle" border="1">
				<thead>
					<tr>
						<td>Picture</td>
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
				<c:forEach var="userlist" items="${list}">
					<tbody>
						<tr>
							<td><img alt="picture"
								src="<c:url value='${request.contextPath}/image/${image}'/>" /></td>
							<td>${userlist.userid}</td>
							<td>${userlist.firstname}</td>
							<td>${userlist.lastname}</td>
							<td>${userlist.username}</td>
							<td>${userlist.password}</td>
							<td>${userlist.email}</td>
							<td>${userlist.address.street}</td>
							<td>${userlist.address.zipcode}</td>
							<td>${userlist.address.city}</td>
							<td><button class="button small blue " type="submit"
									onClick="window.location='getuser?userid=${userlist.userid}';">
									Update</button></td>
							<td><button class="button small blue " type="submit"
									onClick="window.location='deleteuser?userid=${userlist.userid}';">
									Delete</button></td>
							<td><button class="button small blue " type="submit"
									onClick="window.location='addnewuser';" value='Add new User'>
									Add New User</button></td>
						</tr>
					</tbody>
				</c:forEach>

			</table>
		</div>
</body>
</html>