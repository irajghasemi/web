<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<%-- <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/calendar/gold/gold.css" /> --%>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/calendar/steel/steel.css" />

<link href="<%=request.getContextPath()%>/resources/css/layout.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/menu.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/styles.css"
	rel="stylesheet" type="text/css" />
<link
	href="<%=request.getContextPath()%>/resources/css/buttons/bonbon-buttons.css"
	rel="stylesheet" type="text/css" />

</head>
<body>
	<h1>Test</h1>
	<div>${output}</div>

</body>
</html>
