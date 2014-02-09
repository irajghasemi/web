<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/js/jquery-ui-1.8.16/themes/base/jquery-ui.css" /> 
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/userList.css"  />
<link href="<%=request.getContextPath()%>/resources/css/fontstyle.css" rel='stylesheet' type='text/css' />
</head>


<body >

<div id="pageTitle">User List</div>
	<div id="userList"></div>
	
  <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-ui-1.8.16/jquery-1.6.2.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-ui-1.8.16/ui/jquery-ui.js"></script> 
  <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-ui-1.8.16/ui/jquery.ui.core.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-ui-1.8.16/ui/jquery.ui.position.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-ui-1.8.16/ui/jquery.ui.widget.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/autocomplete.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jsonpCallback.js"></script>
	
</body>
</html>
