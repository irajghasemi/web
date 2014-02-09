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
<title>Log In</title>
<link href="<%=request.getContextPath()%>/resources/css/layout.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/menu.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/styles.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/fontstyle.css" rel="stylesheet" type="text/css" />

<style>
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

</style>

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
				href="<c:url value="http://localhost:8080/guard_weblayer/addnewuser/" />">
					<p class="fontstyle">SIGN UP</p>
			</a></li>
			<div id="lavalamp"></div>
		</ul>
		<br/>
		<br/>

		<c:if test="${not empty error}">
			<div class="errorblock">
				Your login attempt was not successful, try again.<br /> Caused :
				${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
			</div>
		</c:if>



		<div id="formContainer">
			<form id="login" method="post"
				action="<c:url value='j_spring_security_check' />">
				<a href="<c:url value="http://localhost:8080/guard_weblayer/" /> id=" flipToRecover" class="flipLink">Forgot?</a> 
					<input type="text" name="j_username" id="loginUsername" required="required" maxlength="45" placeholder="username" /> 
					<input type="password" name="j_password" id="loginPass" required="required" maxlength="45" placeholder="password" /> 
					<input type="submit" name="submit" value="Login" />
			</form>
<%-- 			<form modelAttribute="form" id="recover" method="post" action="sendemail?email=${userModel.email}"> --%>
<%-- 				<a href="<c:url value="http://localhost:8080/guard_weblayer/recover/" /> id="flipToLogin" class="flipLink">Forgot?</a>  --%>
<!-- 					<input type="text" name="email" id="recoverEmail" required="required" maxlength="45" placeholder="email" />  -->
<%-- 					<input type="submit" name="submit" value="Recover" onClick="window.location='sendEmail?email=${userModel.email}';" /> --%>
<%-- 			</form> --%>
			
			
			<form modelAttribute="form" id="recover" method="post" action="sendemail?email=${userModel.email}">
				<a href="<c:url value="http://localhost:8080/guard_weblayer/recover/" /> id=" flipToLogin" class="flipLink">Forgot?</a>
					 <input type="text" name="email" id="recoverEmail" required="required" maxlength="45" placeholder="email" /> 
					<input type="submit" name="submit" value="Recover" onClick="window.location='sendEmail?email=${user.email}';" />
			</form> 
		</div>

		<footer> </footer>

		<!-- JavaScript includes -->
		<script src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
		<script src="<%=request.getContextPath()%>/resources/js/script.js"></script>
	</div>
</body>
</html>