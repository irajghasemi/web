<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8" />
<title>Single Image</title>
<link href="<%=request.getContextPath()%>/resources/css/layout.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/menu.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/styles.css"
	rel="stylesheet" type="text/css" />
<link
	href="<%=request.getContextPath()%>/resources/css/buttons/buttons.css"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/imagetable.css"
	type="text/css" media="screen, projection" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/texttable.css"
	type="text/css" media="screen, projection" />
<title>Single User Image</title>
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
			<li><a
				href="<c:url value="http://localhost:8080/guard_weblayer/addnewuser/" />">SIGN
					UP</a></li>
			<li><a href="<c:url value="/j_spring_security_logout" />">
					<p class="fontstyle">Log Out</p>
			</a></li>
			<li><a style="font-size: 20px; color: #19BCFF;">${currentUser}</a></li>
			<div id="lavalamp"></div>
		</ul>
		<br /> <br /> <br />
		<table border="1" class="fontstyle" bordercolor="#19BCFF">
			<tr valign="baseline" align="left">
				<th>Picture</th>
				<th>User Name</th>
				<th>Last Name</th>
				<th>Image Id</th>
				<th>User id</th>
				<th>Email</th>
				<th>Street</th>
				<th>Zip Code</th>
				<th>City</th>
			</tr>
			<tbody>
				<tr>
					<td><img alt="picture"
						src="<c:url value='${request.contextPath}/image/${founduserimage}'/>" /></td>
					<td>${user.username}</td>
					<td>${user.lastname}</td>
					<td>${founduserimage}</td>
					<td>${user.userid}</td>
					<td>${user.email}</td>
					<td>${user.address.street}</td>
					<td>${user.address.zipcode}</td>
					<td>${user.address.city}</td>
				</tr>

			</tbody>
		</table>
		<div id="content">

			<ul class="image_gallery">

				<li><img alt="picture"
					src="<c:url value='${request.contextPath}/image/${founduserimage}'/>"></li>

				<%-- 				<li style="text-align: left">${user.username} ${user.lastname} --%>
				<%-- 					<br /> Email: ${user.email}<br /> Address: ${user.address.street}<br /> --%>
				<%-- 					${user.address.zipcode} ${user.address.city}<br /> --%>

				<!-- 				</li> -->

			</ul>
		</div>

		<!-- 		<div id="text_content"> -->

		<!-- 			<ul class="text_gallery"> -->


		<%-- 				<li> First Name: ${user.username}<br />Last Name:  ${user.lastname} --%>
		<%-- 					<br /> Email: ${user.email}<br /> Address: ${user.address.street}<br /> --%>
		<%-- 					${user.address.zipcode} ${user.address.city}<br /> --%>
		<%-- 					User Name: ${user.username}<br /> --%>
		<%-- 					Password: ${user.password} --%>

		<!-- 				</li> -->
		<!-- 			</ul> -->
	</div>


	<!-- JavaScript includes -->
	<script src="<%=request.getContextPath()%>/resources/js/script.js"></script>

	</div>

</body>
</html>

