<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Search User By Id</title>
<%--   <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/js/jquery-ui-1.8.16/themes/base/jquery-ui.css"  />  --%>
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/inputForm/fancyInput.css"  /> 
  <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-ui-1.8.16/jquery-1.6.2.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-ui-1.8.16/ui/jquery-ui.js"></script> 
  <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-ui-1.8.16/ui/jquery.ui.core.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-ui-1.8.16/ui/jquery.ui.position.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-ui-1.8.16/ui/jquery.ui.widget.js"></script>
  <link href="<%=request.getContextPath()%>/resources/css/fontstyle.css" rel='stylesheet' type='text/css' />

</head>

<body>

<div id="contact_form">
<form action="#">
  <fieldset>
    <label for="id" id="name_label">Search User By ID:</label>
    <input type="text" name="id" id="id" size="30" value="" />
    <input type="button" name="submit_btn" class="button" id="submit_btn" value="Search" />

  </fieldset>
</form>
<div id="resp"> 

</div>
</div>


<script type="text/javascript">
$(function() {
$("#submit_btn").click(function() {

console.log("value " + $("#id").val());

var url = 'http://localhost:8080/guard_restfullayer/user/' + $("#id").val();
$.ajax({
            type: "GET",
            url: url,
            data: {},
            async:true,
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function(data) {
             showResponse(data);
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert('There is not such a user ');
            },
            beforeSend: function (XMLHttpRequest) {
//show loading
            },
            complete: function (XMLHttpRequest, textStatus) {
//hide loading
            }
});
});
});

function showResponse (data) {
$("#resp").empty();
    $("#resp").append('<h4> Id : ' +data.userid+"</br>"+"First Name : " +data.firstname+"</br>"+"Last Name : "+data.lastname+"</br>"+  " Email : "+data.email+'</h4>');
}	
</script>

</body>
</html>