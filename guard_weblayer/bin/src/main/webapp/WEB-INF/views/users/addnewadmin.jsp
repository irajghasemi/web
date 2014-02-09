<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8" />
<head>
<title>Register New User</title>
<link href="<%=request.getContextPath()%>/resources/css/forms.css"
	rel='stylesheet' type='text/css' />
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
			<li><a style="font-size: 20px; color: #19BCFF;">${currentUser.username}</a></li>
			<div id="lavalamp"></div>
		</ul>

		<br />
		<br />
		<br />
		<br />
		<div id="buttonContainer"
			style="overflow: auto; height: 2000px; width: 1000px">
			<form action="" method="post" modelAttribute="admin"
				style="font-family: verdana, helvetica, arial, sans-serif; width: 300px; font-size: 12px; line-height: 20px; margin-left: auto; margin-right: auto; border:">

				<p style="color: #19BCFF; font-size: 16px; font-style: italic;">

					<label for="firstname">First Name </label> <br /> <input
						name="firstname" required="required" maxlength="45"
						placeholder="firstname" size="45" /> <br />
					<br />
					<label for="lastname">Last Name </label> <br /> <input
						name="lastname" required="required" maxlength="45"
						placeholder="lastname" size="45" /> <br />
					<br />
					<label for="username">User Name </label> <br /> <input
						name="username" required="required" maxlength="45"
						placeholder="username" size="45" /> <br />
					<br /> <label for="Password">Password</label> <br /> <input
						name="password" required="required" maxlength="45"
						placeholder="password" size="45" /> <br />
					<br /> <label for="email">Email </label> <br /> <input name="email"
						required="required" maxlength="45" placeholder="email" size="45" />

					<br /> <br />
					<label for="Street">Street</label> </br> <input name="address.street"
						required="required" maxlength="45" placeholder="address.street"
						size="45" /> <br />
					<br />
					<label for="Zipcode">Zip Code</label><br /> <input
						name="address.zipcode" required="required" maxlength="45"
						placeholder="address.zipcode" size="45" /> <br />
					<br />
					<label for="City">City</label> <br /> <input name="address.city"
						required="required" maxlength="45" placeholder="city" size="45" />

					<br />
					<br />
					<button class="button blue medium " type="submit">SIGN UP</button>
					<br />
					<br />
			</form>
		</div>
		<footer> </footer>

		<!-- JavaScript includes -->
		<script src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
		<script src="<%=request.getContextPath()%>/resources/js/script.js"></script>
		<script
			src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js"></script>

	</div>

</body>
</html>