<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page
	import="org.springframework.security.core.context.SecurityContextHolder"%>
<!DOCTYPE HTML>
<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<title>Calendar</title>
<%-- <script src="<%=request.getContextPath()%>/resources/calendar/sv.js"></script> --%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/calendar/jscal2.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/calendar/border-radius.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/calendar/steel/steel.css" />
<link href="<%=request.getContextPath()%>/resources/css/layout.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/menu.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/styles.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/buttons/buttons.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/fontstyle.css" rel='stylesheet' type='text/css' />
<link href="<%=request.getContextPath()%>/resources/css/timeline/timeline.css" rel="stylesheet" type="text/css" />

</head>
<div style="clear:left; height:50px;"></div>
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
					<p class="fontstyle">Log Out</p>
			</a></li>
			<li><a style="font-size: 20px; color: #19BCFF;">${currentUser}</a></li>
			<div id="lavalamp"></div>
		</ul>
	<div style="clear:left; height:50px;"></div>
	
			<section id="timeline" >
		<c:forEach items="${availableServices}" var="dates">
				<article>
					<div class="inner">
				 <a  style="text-decoration: none ;cursor: pointer;" onclick="location.href='singleService?dateAndTime_id=${dates.dateAndTime_id}'" >
						<span class="date"> 
						<span class="day">${dates.startDayNumber}<sup>th</sup></span>
							<span class="month">${dates.startMontName}</span> 
							<span class="year">${dates.startYearOnly}</span>
						</span>

						<c:choose>
							<c:when test="${dates.serviceAvailable eq true}">
								<h2>${ dates.numberOfGuards} Services Are Available</h2>
						<p>
							Need ${ dates.numberOfGuards} guards.<br /> 
							Start At : ${dates.startWeekDay} ${dates.startDate} ${dates.startTime}.<br />
							End   At : ${dates.endWeekDay}   ${dates.endDate}   ${dates.endTime}.<br />
							Available : ${ dates.serviceAvailable}
						</p>
							</c:when>
							<c:otherwise>
								<h2>No Services Are Available</h2>
								<p>All Services Are Already Booked</p>
							</c:otherwise>
						</c:choose>

				</a>
					</div>
				</article>

		</c:forEach>
			</section>

		<!-- JavaScript includes -->
		<script src="<%=request.getContextPath()%>/resources/calendar/jscal2.js"></script>
        <script src="<%=request.getContextPath()%>/resources/calendar/en.js"></script>
		<script src="<%=request.getContextPath()%>/resources/js/script.js"></script>
		<script src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
	</div>
</body>
</html>
