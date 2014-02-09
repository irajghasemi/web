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
	 <div style="color:#19BCFF"> 
	<c:choose>
	    <c:when test="${not empty error}">
	     <h1><fmt:message key="no.add.twice"/></h1>     
	     <div style="clear:left; height:10px;"></div>
	              <button class="button blue medium " type="submit" onclick="location.href='availableCalendar'">Back To Service</button> 
	    </c:when>
	   
	    <c:otherwise>
	                	<form action="singleService?dateAndTime_id=${singleService.dateAndTime_id}" method="post" modelAttribute="date">
					<section id="timeline" >
						<article>
							<div class="inner">
								<span class="date"> 
								<span class="day">${singleService.startDayNumber}<sup>th</sup></span>
									<span class="month">${singleService.startMontName}</span> 
									<span class="year">${singleService.startYearOnly}</span>
								</span>
										<h2>${ singleService.numberOfGuards} Services Are Available</h2>
								<p>
									Need ${singleService.numberOfGuards} guards.<br /> 
									Start At : ${singleService.startWeekDay} ${singleService.startDate} ${singleService.startTime}.<br />
									End   At : ${singleService.endWeekDay}   ${dates.endDate}   ${singleService.endTime}.<br />
									Available : ${ singleService.serviceAvailable}
								</p>
							</div>
						</article>

		      <button class="button blue medium " type="submit" >Add To Service</button> 
		  	</section>  
			</form>
	    </c:otherwise>
	</c:choose>   	
	</div>          


		<!-- JavaScript includes -->
		<script src="<%=request.getContextPath()%>/resources/calendar/jscal2.js"></script>
        <script src="<%=request.getContextPath()%>/resources/calendar/en.js"></script>
		<script src="<%=request.getContextPath()%>/resources/js/script.js"></script>
		<script src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
	</div>
</body>
</html>
