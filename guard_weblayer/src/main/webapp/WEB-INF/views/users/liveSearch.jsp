<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/searchTable.css"  /> 
  <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/searchTable.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/searchtable_blocked.js"></script>
  <link href="<%=request.getContextPath()%>/resources/css/fontstyle.css" rel='stylesheet' type='text/css' />
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/inputForm/fancyInput.css"  /> 
</head>

<!-- Placing the tables in div side by side  -->
<style type="text/css">
.halfDiv {
padding: 1em;
width: 45%;
float: left;
} 
</style>


<script type="text/javascript">


</script>

</head>
<body>
   
    <div class="halfDiv">
    
    <section class="container">

	<h2>Blocker User</h2>

	<input type="search" class="light-table-filter" data-table="blue" placeholder="Blocker User">

	<table class="blue">
		<thead>
			<tr>
			
				<th>User Id</th>
				<th>Picture</th>
				<th>Name</th>
				<th>Email</th>
				<th>Address</th>
			</tr>
		</thead>
<c:forEach items="${imageList}" var="images">
		<tbody>
			<tr>
				<td>${images.user.userid }</td>
				<td><img alt="pictures" src="<c:url value='${request.contextPath}/image/${images.imageid}'/>" /><br /></td>
				<td >${images.user.firstname }  ${images.user.lastname}</td>
				<td>${images.user.email }</td>
				<td>${images.user.address.street } ${images.user.address.city } ${images.user.address.zipcode}</td>
			</tr>
			
		</tbody>
</c:forEach>
	</table>
</section>
    </div>
    
    
    <div class="halfDiv">
    <section class="container">

	<h2>Blocked User</h2>

	<input type="search_blocked" class="blocked_light-table-filter" blocked_data-table="blue" placeholder="Blocker User">

	<table class="blue">
		<thead>
			<tr>
			
				<th>User Id</th>
				<th>Picture</th>
				<th>Name</th>
				<th>Email</th>
				<th>Address</th>
			</tr>
		</thead>
<c:forEach items="${imageList}" var="blocked_images">
		<tbody>
			<tr>
				<td>${blocked_images.user.userid }</td>
				<td><img alt="pictures" src="<c:url value='${request.contextPath}/image/${blocked_images.imageid}'/>" /><br /></td>
				<td >${blocked_images.user.firstname }  ${blocked_images.user.lastname}</td>
				<td>${blocked_images.user.email }</td>
				<td>${blocked_images.user.address.street } ${blocked_images.user.address.city } ${blocked_images.user.address.zipcode}</td>
			</tr>
			
		</tbody>
</c:forEach>
	</table>
</section>
    </div>

</body>
</html>