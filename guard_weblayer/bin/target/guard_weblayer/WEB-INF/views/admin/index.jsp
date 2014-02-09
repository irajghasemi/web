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

<style>
.errorblock {
	color: #FFCCCC;
	background-color: #003333;
	border: 3px solid #FFCCCC;
	padding: 8px;
	margin: 16px;
}
</style>
</head>
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

				</ul></li>
			<li><a class="hsubs" href="#">Menu 2</a>
				<ul class="subs">
					<li><a href="#">Submenu 2-1</a></li>
					<li><a href="#">Submenu 2-2</a></li>
					<li><a href="#">Submenu 2-3</a></li>

				</ul></li>
			<li><a class="hsubs" href="#">Menu 3</a>
				<ul class="subs">
					<li><a href="#">Submenu 3-1</a></li>
					<li><a href="#">Submenu 3-2</a></li>

				</ul></li>
			<li><a href="#">Menu 4</a></li>
			<li><a
				href="<c:url value="http://localhost:8080/guard_weblayer/newuser/" />">Register</a></li>
			<li><a href="<c:url value="/j_spring_security_logout" />">Log
					Out</a></li>
			<!-- 			<li><a href="#">Menu 6</a></li> -->
			<li><a
				href="http://www.script-tutorials.com/pure-css3-lavalamp-menu/">Back</a></li>
			<div id="lavalamp"></div>
		</ul>
		</br> </br>

		<c:if test="${not empty error}">
			<div class="errorblock">

				Your login attempt was not successful, try again.<br /> Caused :
				${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
			</div>
		</c:if>

		<div id="formContainer">
			<form id="login" method="post"
				action="<c:url value='j_spring_security_check' />">
				<a href="#" id="flipToRecover" class="flipLink">Forgot?</a> <input
					type="text" name="j_username" id="loginUsername"
					required="required" maxlength="45" placeholder="username" />
				<!-- 					<input type="text" name="j_username" id="loginEmail" value="Email" /> -->
				<!-- 					<input type="password" name="j_password" id="loginPass" value="pass" />  -->
				<input type="password" name="j_password" id="loginPass"
					required="required" maxlength="45" placeholder="pass" /> <input
					type="submit" name="submit" value="Login" />
			</form>
			<form id="recover" method="post"
				action="<c:url value='j_spring_security_check' />">
				<a href="#" id="flipToLogin" class="flipLink">Forgot?</a> <input
					type="text" name="recoverEmail" id="recoverEmail" value="Email" />
				<input type="submit" name="submit" value="Recover" />
			</form>
		</div>

		<footer> </footer>

		<!-- JavaScript includes -->
		<script src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
		<script src="<%=request.getContextPath()%>/resources/js/script.js"></script>
	</div>
</body>
</html>