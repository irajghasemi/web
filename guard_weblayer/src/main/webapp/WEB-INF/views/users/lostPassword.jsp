<%@ include file="/WEB-INF/partials/taglibs.jsp" %>
<!DOCTYPE head PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Forgot your password?</title>
    <link href="<%=request.getContextPath()%>/resources/css/form.css" rel='stylesheet' type='text/css' />
    <link href="<%=request.getContextPath()%>/resources/css/fontstyle.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/resources/css/fontstyle.css" rel='stylesheet' type='text/css' />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/inputForm/fancyInput.css"  /> 
</head>
<body>
<h1>Hej Lost password</h1>
<div class="info">
    <h3>Forgot your password?</h3>
    <p>Simply enter your username and we'll email instructions to you on how to reset your password.</p>
</div>

<div id="form-wrapper" style="width:50%;">
    <form:form modelAttribute="form" cssClass="wufoo topLabel clearfix">
        <form:errors path="*" cssClass="errorBox" element="div" />
        <ul>
            <li>
                <label for="username" class="desc">Username <span class="req">*</span></label>
                <div>
                    <form:input path="username" id="username" cssClass="field text medium" maxlength="32" tabindex="1" />
                    <form:label path="username">Example: john123</form:label>
                </div>
            </li>
            <li class="buttons">
                <input id="saveForm" class="btTxt" type="submit" tabindex="2" value="Submit"/>
            </li>
            <li class="cancel">
                <a href="<c:url value='/index'/>">Or, return to the sign in page.</a>
            </li>
        </ul>
    </form:form>
    <script type="text/javascript">
        $(function(){
            $("#username").focus();
        });
    </script>
</div>
</body>
</html>