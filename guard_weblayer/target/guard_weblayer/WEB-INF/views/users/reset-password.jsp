<%@ include file="/WEB-INF/partials/taglibs.jsp" %>
<head>
    <title>Reset Password</title>
      <link href="<%=request.getContextPath()%>/resources/css/flexlayout.css" rel="stylesheet" type="text/css" />
      <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/inputForm/fancyInput.css"  /> 
</head>
<div class="info">
 <header>
    <h3>Reset Password</h3>
  <p>Use the form below to reset your password.</p>
  </header>
</div>
<div id ="main">
<article>
<div id="form-wrapper" style="width:50%;">
    <form:form modelAttribute="form" cssClass="wufoo topLabel clearfix">
        <form:errors path="*" cssClass="errorBox" element="div" />
        <ul>
            <li>
                <div>Resetting password for: ${userEmail.username}</div>
            </li>
            <li class="leftHalf">
                <form:label path="password" cssClass="desc">Choose a new password <span class="req">*</span></form:label>
                <div>
                    <form:password path="password" id="password" cssClass="field text medium" maxlength="255" tabindex="2" />
                    <form:label path="password">Must be at least 6 characters long.</form:label>
                </div>
            </li>
            <li class="rightHalf">
                <form:label path="confirm" cssClass="desc">Verify your new password <span class="req">*</span></form:label>
                <div>
                    <form:password path="confirm" id="confirm" cssClass="field text medium" maxlength="255" tabindex="3" />
                    <form:label path="confirm"></form:label>
                </div>
            </li>
            <li class="buttons">
                <input id="saveForm" class="btTxt" type="submit" tabindex="4" value="Reset Password"/>
            </li>
            <li class="cancel">
                <a href="<c:url value='/index'/>">Or, go sign in.</a>
            </li>
        </ul>
    </form:form>
    <script type="text/javascript">
        $(function(){
            $("#password").focus();
        });
    </script>
</div>
</article>
	<nav>left</nav>
    <aside>wright</aside>
</div>
<footer>footer</footer>
