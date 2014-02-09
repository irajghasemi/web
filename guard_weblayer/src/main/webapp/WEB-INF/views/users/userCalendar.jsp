<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<title>iCalendar</title>
<!-- calendar scripts and css  begin -->
<link href="<%=request.getContextPath()%>/resources/css/forms.css"
	rel='stylesheet' type='text/css' />
<link href="<%=request.getContextPath()%>/resources/css/layout.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/menu.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/styles.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/buttons/buttons.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/ical/ical.css" rel='stylesheet' type='text/css' />
<link href="<%=request.getContextPath()%>/resources/css/fontstyle.css" rel='stylesheet' type='text/css' />
</head>

<body>
<header>
	<h2 align="right">Welcome To Rapid Larm Central Menu</h2>
	<a href="<c:url value="http://localhost:8080/guard_weblayer/" />"
		class="stuts"></a> </header>
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
		<div style="clear:left; height:10px;"></div>
		<div style="clear:left; height:10px;"></div>
		<h2 class="fontstyle">iCal like icons</h2>

		<div class="calendar calendar-icon-1">
            <div class="calendar-day">
                1
            </div>
        </div>

        <div class="calendar calendar-icon-2">
            <div class="calendar-day">
                3
            </div>
        </div>

        <div class="calendar calendar-icon-3">
            <div class="calendar-day">
                6
            </div>
        </div>

        <div class="calendar calendar-icon-4">
            <div class="calendar-day">
                9
            </div>
        </div>

        <div class="calendar calendar-icon-5">
            <div class="calendar-day">
                12
            </div>
        </div>

        <div class="calendar calendar-icon-6">
            <div class="calendar-day">
                15
            </div>
        </div>

       <div style="clear:left;height:10px;"> </div>

        <div class="calendar calendar-icon-7">
            <div class="calendar-day">
                18
            </div>
        </div>
        <div class="calendar calendar-icon-8">
            <div class="calendar-day">
                21
            </div>
        </div>
        <div class="calendar calendar-icon-9">
            <div class="calendar-day">
                24
            </div>
        </div>
        <div class="calendar calendar-icon-10">
            <div class="calendar-day">
                27
            </div>
        </div>
        <div class="calendar calendar-icon-11">
            <div class="calendar-day">
                30
            </div>
        </div>
        <div class="calendar calendar-icon-12">
            <div class="calendar-day">
                31
            </div>
        </div>
	
</body>
</html>
