
<%@ include file="/WEB-INF/partials/taglibs.jsp" %>
<c:url var="loginUrl" value="/index"/>
<head>
    <title>Whoops!</title>
</head>
<div class="info">
    <h3>Your password reset request has expired.</h3>
    <p>You'll need to start again. <a href="<c:url value='/index'/>">Click here to reset your password</a>.</p>
</div>