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
<!-- <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> -->

<!-- Import Google Font - Yanone Kaffeesatz  -->

<link href="<%=request.getContextPath()%>/resources/css/forms.css"
	rel='stylesheet' type='text/css' />
<link href="<%=request.getContextPath()%>/resources/css/layout.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/menu.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/styles.css"
	rel="stylesheet" type="text/css" />
<%-- <link href="<%=request.getContextPath()%>/resources/css/buttons.css" --%>
<!-- 	rel="stylesheet" type="text/css" /> -->
<link href="<%=request.getContextPath()%>/resources/buttons/buttons.css"
	rel="stylesheet" type="text/css" />

</head>
<body>
<body>
	<header>
	<h2>Welcome To Rapid Larm Central Menu</h2>
	<a href="http://www.script-tutorials.com/pure-css3-lavalamp-menu/"
		class="stuts">Back To <span>Rapid Larm Central</span></a> </header>
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
				href="http://www.script-tutorials.com/pure-css3-lavalamp-menu/">Back</a></li>
			<div id="lavalamp"></div>
		</ul>

		</br> </br>
		</br> </br> <font color="blue" size="14">
			<div id="buttonContainer">
				<form action="register" method="post" modelAttribute="user"
					style="font-family: verdana, helvetica, arial, sans-serif; width: 300px; 
					font-size: 12px; line-height: 20px; margin-left: 
					auto; margin-right: auto; border: 2px solid #1C1C1C; 
					outline: 2px solid #1C1C1C; outline-offset: 10px;">

					<label for="Name">User Name </label> </br> <input name="username"
						style="" required="required" maxlength="45" placeholder="username" />
					<span class="form_hint">Proper format "name@something.com"</span>
					<br/> <label for="Password">Password</label> </br> <input name="password"
						style="" required="required" maxlength="45" placeholder="password" />
<!-- 					</br> <label for="Email">Email</label> </br> <input name="email" -->
<!-- 						style="" required="required" maxlength="45" placeholder="email" /> -->
					<br/> <label for="Street">Street</label> </br> <input name="address.street"
						style="" required="required" maxlength="45" placeholder="address.street" />
					<br/> <label for="Zipcode">Zip Code</label> </br> <input name="address.zipcode"
						style="" required="required" maxlength="45" placeholder="address.zipcode" />
					<br/><label for="City">City</label> </br> <input name="address.city"
						style="" required="required" maxlength="45" placeholder="city" />
					<br/><br/>
					<button class="button blue medium " type="submit">   Register / Save      </button>
					<br/><br/>
				</form>
			</div>
		</font>

		<footer> </footer>

		<!-- JavaScript includes -->
		<script src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
		<script src="<%=request.getContextPath()%>/resources/js/script.js"></script>
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js"></script>

	</div>

</body>
</html>