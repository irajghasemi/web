<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML>
<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<title>Calendar</title>
<script src="<%=request.getContextPath()%>/resources/calendar/jscal2.js"></script>
<script src="<%=request.getContextPath()%>/resources/calendar/en.js"></script>
<%-- <script src="<%=request.getContextPath()%>/resources/calendar/sv.js"></script> --%>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/calendar/jscal2.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/calendar/border-radius.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/calendar/steel/steel.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/imagetable.css"
	type="text/css" media="screen, projection" />

<link href="<%=request.getContextPath()%>/resources/css/layout.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/menu.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/styles.css"
	rel="stylesheet" type="text/css" />
<link
	href="<%=request.getContextPath()%>/resources/css/buttons/bonbon-buttons.css"
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
			<li><a href="<c:url value="/j_spring_security_logout" />">
					<p class="fontstyle">Log ut</p>
			</a></li>
			<li><a style="font-size: 20px; color: #19BCFF;">${currentUser}</a></li>
			<div id="lavalamp"></div>
		</ul>
		<br /> <br /> <br />


		<table border="1" align="left" width="50%" style="height: 50%">
			<c:forEach items="${allDates}" var="dates">
				<tr class="fontstyle">
					<!-- 					<td><button class="button big blue">Service Start Date <br/> Service End Date</button></td> -->
					<td><button class="button big blue">
							Start: ${dates.startWeekDay} <br /> End: ${dates.endWeekDay}
						</button></td>
					<td><button class="button big blue">${dates.startDate}
							${dates.startTime} <br /> ${dates.endDate} ${dates.endTime}
						</button></td>
					<%-- 					<td><button class="button big blue">${dates.startWeekDay} </button></td> --%>
					<td><button class="button big blue ">Delete</button></td>
				</tr>
			</c:forEach>
		</table>
		<!-- JavaScript includes -->
		<script src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
		<script src="<%=request.getContextPath()%>/resources/js/script.js"></script>
	</div>
</body>
</html>
