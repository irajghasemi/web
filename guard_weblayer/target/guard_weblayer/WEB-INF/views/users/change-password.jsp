<%@ include file="/WEB-INF/partials/taglibs.jsp" %>
<link href="<%=request.getContextPath()%>/resources/css/fontstyle.css" rel='stylesheet' type='text/css' />
<head>
<title>Change Password</title>
<link href="<%=request.getContextPath()%>/resources/css/flexlayout.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/buttons/buttons.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/fontstyle.css" rel='stylesheet' type='text/css' />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/inputForm/fancyInput.css"  /> 
</head>
    
  <body>
 <header>Change Password</header>
 <div id='main'>
    <article>

          	<div class="info">
	    <h3>Change Password</h3>
	    <p>Use the form below to update your password.</p>
	</div>
	<div id="form-wrapper" style="width:50%;">
	    <form:form modelAttribute="form" cssClass="wufoo topLabel clearfix">
	        <form:errors path="*" cssClass="errorBox" element="div" />
	        <ul>
	            <li>
	                <form:label path="original" cssClass="desc">Enter your original password <span class="req">*</span></form:label>
	                <div>
	                    <form:password path="original" id="original" cssClass="field text large" maxlength="32" tabindex="1" />
	                    <form:label path="original">Note: Your password is case sensative.</form:label>
						<div style="height:14px"></div>
	                </div>
	            </li>
	            <li class="leftHalf">
	                <form:label path="password" cssClass="desc">Choose a new password <span class="req">*</span></form:label>
	                <div>
	                    <form:password path="password" id="password" cssClass="field text medium" maxlength="255" tabindex="2" />
	                    <form:label path="password">Must be at least 6 characters long.</form:label>
						<div style="height:14px"></div>
	                </div>
	            </li>
	            <li class="rightHalf">
						<div style="height:4px"></div>
	                <form:label path="confirm" cssClass="desc">Verify your new password <span class="req">*</span></form:label>
	                <div>
	                    <form:password path="confirm" id="confirm" cssClass="field text medium" maxlength="255" tabindex="3" />
	                    <form:label path="confirm"></form:label>
	                </div>
	            </li>
	            <li class="buttons">
	            <li><a href="<c:url value="/j_spring_security_logout" />">
<!-- 	                <input id="saveForm" class="btTxt" type="submit" tabindex="4" value="Change Password"/> -->
	                <button class="button blue medium " type="submit" >Change Password</button>
				</a></li>
	            <li class="cancel">
				<div style="height:50px"></div>
	                <a href="<c:url value='/index'/>">Or, return to the home page.</a>
	            </li>
	        </ul>
	    </form:form>
	    <script type="text/javascript">
	        $(function(){
	            $("#original").focus();
	        });
	    </script>
	</div>


    </article>  
<nav></nav>
<aside></aside>
</div>
<footer>footer</footer>


