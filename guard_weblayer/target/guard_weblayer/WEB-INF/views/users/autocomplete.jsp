<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<script src='http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js' type='text/javascript'></script>
<script src="http://code.jquery.com/jquery-1.7.1.min.js"></script>

<script src="<%=request.getContextPath()%>/resources/js/jquery.autocomplete.pack.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/resources/js/autocomplete.js" type='text/javascript'></script>
<link href="<%=request.getContextPath()%>/resources/css/jquery.autocomplete.pack.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath()%>/resources/css/layout.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/menu.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/buttons/buttons.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/fontstyle.css" rel='stylesheet' type='text/css' />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/inputForm/fancyInput.css"  /> 
<%-- <link href="<%=request.getContextPath()%>/resources/css/styles.css" rel="stylesheet" type="text/css" /> --%>
</head>


<script type='text/javascript'>
	$().ready(function() {
		$('#search_input').focus()
	});// focus search area
</script>
<script type='text/javascript'>
	$().ready(function() {
		$('#blocked').focus()
	});// focus search area
</script>

<style type="text/css">
.halfDiv {
	padding: 1em;
	width: 42%;
	float: left;
}
.rightDiv {
	padding: 1em;
	width: 7%;
	float: right;
}

</style> 
</head>
<body>
		<br/>
		<br/>
		<br/>
		<h1 class="topWhite" align="center" style="font-size: 20px; color: #FFFFFF;"  >Welcome To Rapid Larm Central Menu</h1>
	<a href="<c:url value="http://localhost:8080/guard_weblayer/" />"
		class="stuts"></a> 
		
		</header>
	<div class="container">
		<ul  id="nav">
			<li><a href="<c:url value="http://localhost:8080/guard_weblayer/" />">Home</a></li>
			<li><a class="hsubs" href="#">Menu 1</a>
				<ul class="subs">
					<li><a href="/index">Home</a></li>
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
			<li><a
				href="<c:url value="/addnewuser" />"><p
						class="fontstyle">SIGN UP</p></a></li>
			<li><a href="<c:url value="/j_spring_security_logout" />">
					<p class="fontstyle">Log ut</p>
			</a></li>
			<li><a style="font-size: 20px; color: #19BCFF;">${currentUser}</a></li>
			<div id="lavalamp"></div>
		</ul>
		<div style="clear:left; height:50px;"></div>
		
		<div class="halfDiv">
			<div id='header'>
				<h1 class="font2">Blocker User</h1>
				 <br /> 
				<form action='javascript:void(0);'>
					<h3>
						<input id='search_input' size="32" style="height:20px" name='search_input' type='text' autocomplete="on" />
					</h3>
				</form>
			</div>
			<div style="clear:left; height:30px;"></div>
<%-- 				<form:form action="autocomplete?userid=${blocker_images.user.userid }" method="post" modelAttribute="user"> --%>
			
			<c:forEach items="${imageList}" var="blocker_images">
					<div id='content'>
						<div class='volcano search_item'>
									
							<h4 class='search_text'>
								<div class=fontstyle >
									
								${blocker_images.user.userid }
								${blocker_images.user.firstname } ${images.user.lastname}
								${blocker_images.user.email }
								</div>
								</h4>
								<div class="infor_div">
							<img alt="pictures" src="<c:url value='${request.contextPath}/image/${blocker_images.imageid}'/>" /><br />
								</div>
								
									<div class="picture_div">
							<p>${blocker_images.user.address.street }<br/>${blocker_images.user.address.zipcode } ${blocker_images.user.address.city }</p>
								</div>
									
						</div>
						<br/>
					</div>

			</c:forEach>
<%-- 	</form:form> --%>
	</div>
	
	
	<div class="halfDiv">
			<div id='header'>
				<h1 class="font2">Blocked User</h1>
				<br/> 
				<form action='javascript:void(0);'>
					<h3>
						<input id='blocked' size="32" style="height:20px" name='blocked' type='text' autocomplete="off" />
					</h3>
				</form>
			</div>
			<br/>
<div style="clear:left; height:30px;"></div>

			<c:forEach items="${imageList}" var="blocked_images">
					<div id='content'>
						<div class='volcano search_item_blocked'>
							<h4 class='search_text_blocked'>
								<div class="fontstyle">
								${blocked_images.user.userid }
								${blocked_images.user.firstname }
								${blocked_images.user.lastname} ${blocked_images.user.email }
								</div>
								</h4>
								<div class="picture_div">
									
							<img alt="pictures" src="<c:url value='${request.contextPath}/image/${blocked_images.imageid}'/>" /><br />
								</div>
							
								<div class="infor_div">
								
								<p>${blocked_images.user.address.street }
								${blocked_images.user.address.city } ${blocked_images.user.address.zipcode }</p>
							</div>
						</div>
								<br /> 	
					</div>

			</c:forEach>
	</div>
		   <br /> <br /> 
	<form:form action="" method="post" modelAttribute="user">
		    <div  class="rightDiv"> <button class="button blue" type="submit">Save</button></div>
			</form:form>
		</div>
		    
		    
		<script src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
		<script src="<%=request.getContextPath()%>/resources/js/script.js"></script>
</body>
</html>