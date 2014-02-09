<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta charset="utf-8" />
<title>Admin Page</title>
<link href="<%=request.getContextPath()%>/resources/css/layout.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/menu.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/styles.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/buttons/buttons.css" rel="stylesheet" type="text/css" />
<%-- <link href="<%=request.getContextPath()%>/resources/css/ical/ical.css" rel='stylesheet' type='text/css' /> --%>
<link href="<%=request.getContextPath()%>/resources/css/macical.css" rel='stylesheet' type='text/css' />
<link href="<%=request.getContextPath()%>/resources/css/fontstyle.css" rel='stylesheet' type='text/css' />
</head>

<body>
	<header>
	<h2 align="right">Welcome To Rapid Larm Central Menu</h2>
	<a href="<c:url value="http://localhost:8080/guard_weblayer/" />"
		class="stuts"></a>
		
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
			<li><a style="font-size: 18px; color: #19BCFF;">${username}</a></li>

			<div id="lavalamp"></div>
		</ul>
		<br /> <br />
		<div class="fontstyle">

			<button class="button blue medium " type="submit"
				onClick="location.href='getAllUsers'">Get All Users</button>
			<button class="button blue medium " type="submit"
				onClick="location.href='searchform'">Search User By Any
				Parameter</button>
			<button class="button blue medium " type="submit"
				onClick="location.href='findSingelUser'">Search User By Id
			</button>
			<button class="button blue medium " type="submit"
				onClick="location.href='addnewadmin'">Add New Admin</button>
				<div style="clear:left; height:15px;"></div>
			<button class="button blue medium " type="submit"
				onClick="location.href='manageAllImages'">Users With Images</button>
			<button class="button blue medium " type="submit"
				onClick="location.href='availableCalendar'">Show Available Services</button>
			<button class="button blue medium " type="submit"
				onClick="location.href='showBlockee'">Show All Blocked Users</button>
			<button class="button blue medium " type="submit"
				onClick="location.href='autocomplete'">Add users To Block</button>
		</div>
		
	
		<div style="height:50px"></div>
		<p style="text-decoration:none" class="fontstyle" align="center" > Admin Calendar</p>  

<a style="text-decoration: none; cursor: pointer;" onclick="location.href='adminCalendar'">
<div class="calendar-icon">
  <div class="calendar-weekday">
  </div>
  <div class="calendar-icon-body">
    <div class="calendar-monthday">
    </div>
    <div class="calendar-month">
    </div>
  </div>
  <div style="clear:left; height:6px;"></div>
<!-- <div class="calendar-year"></div>  -->
<div class="fontstyle">${year }</div>
</div>
</a>

  <script src="<%=request.getContextPath()%>/resources/js/codepen.js"></script>   
  <script src="<%=request.getContextPath()%>/resources/js/macical.js"></script>   

	</div>
</body>
</html>