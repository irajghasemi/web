<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<html lang="en">
<head>
<link href="<%=request.getContextPath()%>/resources/css/layout.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/menu.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/styles.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/buttons/buttons.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/fontstyle.css" rel='stylesheet' type='text/css' />
<link href="<%=request.getContextPath()%>/resources/css/inputForm/fancyInput.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/flextable/css/style.css" rel="stylesheet" type="text/css" />  
<link href="<%=request.getContextPath()%>/resources/css/flextable/css/csstable.css" rel="stylesheet" type="text/css" />  
</head>

	<div style="clear:left; height:50px;"></div>

<body>
	<header>
	<h2 align="right">Welcome To Rapid Larm Central Menu</h2>
		
		</header>
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
	<div id="buttonContainer">
				<form action="findUserByAnyValue?anyvalue=${anyvalue}" method="get" >

		<p class="fontstyle">
					<label for="Name">Write Any Search Value </label> <br/> 
					<input name="anyvalue" style="" required="required" maxlength="45" placeholder="anyvalue" size="45" />
					
		</p>
		<br/><br/>
					<button class="button small blue " type="submit" onClick="window.location='foundedUserByName';"> Search</button>
					<br/><br/>
				</form>
			</div>
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
<div class="caption">Search User Result</div>	
<div id="table">
	<div class="header-row row">
    <span class="cell primary">Picture</span>
    <span class="cell primary">User Id</span>
     <span class="cell primary">First Name</span>
    <span class="cell primary">Surname</span>
     <span class="cell primary">Email</span>
     <span class="cell primary">Update</span>
     <span class="cell primary">Delete</span>
  </div>
  <div class="row">
  <c:forEach var="userlist" items="${list}">
	<input type="radio" name="expand">
    <span class="cell primary" data-label="picture"><img alt="picture" src="<c:url value='${request.contextPath}/image/${image}'/>" /></span>
    <span class="cell primary" data-label="userid">${userlist.userid}</span>
     <span class="cell primary" data-label="firstname">${userlist.firstname}</span>
     <span class="cell primary" data-label="surname">${userlist.lastname}</span>
     <span class="cell primary" data-label="email">${userlist.email}</span>
     
     <span class="cell primary" data-label="Trans">
     <button class="button small blue " type="submit" onClick="window.location='getuser?userid=${user.userid}';"> Update User</button>
     </span>
     
     <span class="cell primary" data-label="Trans">
     <button class="button small blue " type="submit" onClick="window.location='deleteuser?userid=${user.userid}';"> Delete User</button>
     </span>
    
     </c:forEach>
  </div>  
</div>
     

  <script src="<%=request.getContextPath()%>/resources/js/codepen.js"></script>   
  <script src="<%=request.getContextPath()%>/resources/js/macical.js"></script>
  <script src="<%=request.getContextPath()%>/resources/css/flextable/js/prefixfree.min.js"></script>
  <script src='http://codepen.io/assets/libs/fullpage/none.js'></script>      

	</div>
</body>
</html>