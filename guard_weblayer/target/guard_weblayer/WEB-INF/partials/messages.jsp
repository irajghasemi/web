<%@ include file="/WEB-INF/partials/taglibs.jsp" %>
<%-- Success Messages --%>
<c:if test="${not empty message}">
    <div id="messages" class="messageBox"><c:out value="${message}"/></div>
    <script type="text/javascript">
        $(document).ready(function(){
            $("#messages").fadeOut(3000, function(){
                $(this).remove();
            });
        });
    </script>
</c:if>
