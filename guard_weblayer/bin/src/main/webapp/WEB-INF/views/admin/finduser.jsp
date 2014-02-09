<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<%-- <script  src="<%=request.getContextPath()%>/resources/js/script.js"  type="text/javascript"/> --%>
<title>Find All Users</title>
</head>
<style type="text/css">
thead {
	color: green
}

tbody {
	color: white;
	height: 50px
}

tfoot {
	color: red
}
</style>
<body>

	<header>
	<h2>Welcome To Rapid Larm Central Menu</h2>
	<a href="http://www.script-tutorials.com/pure-css3-lavalamp-menu/"
		class="stuts">Back To <span>Rapid Larm Central</span></a> </header>
	<div class="container">

		<ul id="nav">
			<li><a href="http://localhost:8080/guard_weblayer/">Home</a></li>
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
			<li><a href="#">Log ut</a></li>
			<li><a
				href="http://www.script-tutorials.com/pure-css3-lavalamp-menu/">Back</a></li>
			<div id="lavalamp"></div>
		</ul>
		</br> </br> </br> </br>
		<div style="overflow: auto; height: 1000px; width: 1000px">
			<table border="0" bgcolor="121212" align="left" cellpadding="10"
				width="100%" style="height: 10%">
				<tr align="left" valign="baseline">

					<th>User Id</th>
					<th>User Name</th>
					<th>Password</th>
					<th>Street</th>
					<th>Zip Code</th>
					<th>City</th>
					<th>Update User</th>
					<th>Delete User</th>
					<th>Add New User</th>
				</tr>
				<c:forEach var="user" items="${allUsers}">
					<tbody>
						<tr align="left" valign="baseline" align="center">
							<td>${user.userid}</td>
							<td>${user.username}</td>
							<td>${user.password}</td>
							<td>${user.address.street}</td>
							<td>${user.address.zipcode}</td>
							<td>${user.address.city}</td>
							<%-- 						<td><a href="getuser?userid=${user.userid}"> update</a></td> --%>
							<%-- 						<td><a href="deleteuser?userid=${user.userid}"> delete</a></td> --%>
							<!-- 						<td><a href="newuser"> Add</a></td> -->
							<td><input type=button
								onClick="window.location='getuser?userid=${user.userid}';"
								value='Update User'></td>
							<td><input type=button
								onClick="window.location='deleteuser?userid=${user.userid}';"
								value='Delete User'></td>
							<td><input type=button onClick="window.location='newuser';"
								value='Add new User'></td>
							<td></td>
						</tr>
					</tbody>
				</c:forEach>

			</table>
		</div>
		<footer> </footer>

		<!-- JavaScript includes -->
		<script src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
		<script src="<%=request.getContextPath()%>/resources/js/script.js"></script>
		<!-- 		<script src="resources/js/script.js"></script> -->

	</div>

</body>
</html>