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
	<link href="<%=request.getContextPath()%>/resources/css/buttons/buttons.css"
	rel="stylesheet" type="text/css" />
<%-- <script  src="<%=request.getContextPath()%>/resources/js/script.js"  type="text/javascript"/> --%>
<title>Find All Users</title>
</head>

<body>
<div class="font2">

<h1>Logged in as  ROLE_ADMIN RED</h1>
${test}
<br/>
<br/>
<br/>
<br/>
<br/>
<a href="<c:url value="/j_spring_security_logout" />">Log Out</a>
</div>
</body>
</html>