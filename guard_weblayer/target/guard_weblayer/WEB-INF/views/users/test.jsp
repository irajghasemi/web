<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<!DOCTYPE html>
<html>
<head>
<title>Example</title>
<%-- <script src="<%=request.getContextPath()%>/resources/js/jquery-1.9.1.js" type="text/javascript"></script> --%>
<%-- <script src="<%=request.getContextPath()%>/resources/js/jquery-ui-1.10.2.custom.js" type="text/javascript"></script> --%>
<%-- <link  href="<%=request.getContextPath()%>/resources/css/jquery-ui-1.10.2.custom.css"  rel="stylesheet" type="text/css"/> --%>
<%--  <link href="<%=request.getContextPath()%>/resources/css/fontstyle.css" rel='stylesheet' type='text/css' /> --%>
<%--  <link href="<%=request.getContextPath()%>/resources/css/test/sideLine.css" rel='stylesheet' type='text/css' /> --%>
<%--  <link href="<%=request.getContextPath()%>/resources/css/test/blockLine.css" rel='stylesheet' type='text/css' /> --%>
 
<!--  <script src="http://yui.yahooapis.com/3.14.1/build/yui/yui-min.js"></script> -->
<!-- <link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/2.9.0/build/resize/assets/skins/sam/resize.css" /> -->
<!-- <link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/2.9.0/build/autocomplete/assets/skins/sam/autocomplete.css" /> -->
<!-- <link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/2.9.0/build/assets/skins/sam/layout.css"> -->
<script src="<%=request.getContextPath()%>/resources/css/yui/js/yui-min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/resources/css/yui/js/tab.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/resources/css/yui/js/tabview-base.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/resources/css/yui/js/tabview-plugin.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/resources/css/yui/js/tabview.js" type="text/javascript"></script>

 <link href="<%=request.getContextPath()%>/resources/css/yui/tabview-core.css" rel='stylesheet' type='text/css' />
 <link href="<%=request.getContextPath()%>/resources/css/yui/sam/tabview-skin.css" rel='stylesheet' type='text/css' />
 <link href="<%=request.getContextPath()%>/resources/css/yui/night/tabview-skin.css" rel='stylesheet' type='text/css' />
<script type="text/javascript">
YUI().use("autocomplete", "autocomplete-highlighters", function (Y) {
	  Y.one('#ac-input').plug(Y.Plugin.AutoComplete, {
	    resultHighlighter: 'phraseMatch',
	    resultListLocator: 'user',
// 	    resultTextLocator: 'civicregnumber',
	    resultTextLocator: function (result) {
	        return result.firstname+ ' ' + result.lastname+ ' ' + result.email+' '+result.civicregnumber;
	      },
	    source: 'http://localhost:8080/guard_restfullayer/user/jsonp?callback={callback}'
	  });
	});

</script>
</head>


<body>
 
        
<div id="demo" class="yui3-skin-sam">
<span class="yui3-tabview"></span>
  <label for="ac-input">Enter Search:</label><br>
  <input id="ac-input" type="text">
</div>
	
</body>
</html>