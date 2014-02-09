<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<script src="<%=request.getContextPath()%>/resources/js/jquery-1.9.1.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery-ui-1.10.2.custom.js" type="text/javascript"></script>
<link  href="<%=request.getContextPath()%>/resources/css/jquery-ui-1.10.2.custom.css"  rel="stylesheet" type="text/css"/>
  <link href="<%=request.getContextPath()%>/resources/css/fontstyle.css" rel='stylesheet' type='text/css' />
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/inputForm/fancyInput.css"  />
  
<style>
#search {
width: 25em;
}
 .ui-autocomplete-loading {
background: white url('images/ui-anim_basic_16x16.gif') right center no-repeat;
}
</style>

<script>
$(function() {
  $("[autofocus]").on("focus", function() {
    if (this.setSelectionRange) {
      var len = this.value.length * 2;
      this.setSelectionRange(len, len);
    } else {
      this.value = this.value;
    }
    this.scrollTop = 999999;
  }).focus();
});
</script>

<script>
document.onload = function() {  
	  document.getElementById("serach").focus();
	}

</script>
<script>
//                 url:  "http://localhost:8080/guard_restfullayer/user/jsonp",

$(function() {
    function log(message) {
        $("<div>").text(message).prependTo("#input");
        $("#input").scrollTop(0);
    }
    
    $(function() {
        function split( val ) {
        return val.split( /,\s*/ );
        }
        function extractLast( term ) {
        return split( term ).pop();
        }
$(document).ready(function() {
    $("#search").autocomplete({
    	effect: 'fade',
    	effectSpeed: 'fast',
    	autoFocus: true,
    	matchContains: true,
    	remote: true,
    	cach:true,
    	separator: ", ",
//     	var param = request.term; 
        source: function( request, response ) {
            $.ajax({
                type: "GET",
                url:  "http://localhost:8080/guard_restfullayer/user/jsonp",
                dataType: "jsonp",
                jsonpCallback: 'callback',
                json:true,
                async:true,
                cach:true,
                contentType: "application/json; charset=utf-8",
                data: {
                	featureClass: "P",
                    style : "full",
                    maxRows : 5,
                    cacheLength: 1,
                    scroll: true,
                    highlight: true,
                    start:1,
                    name_startsWith : function () { return $("#search").val() }
                         },
                success: function( data ) {
                	
                    response( $.map( data.user, function( item ) {
                        return {
                            label: item.firstname + " "+item.lastname+ " "+item.email, 
                            value: item.firstname + " "+ item.lastname+ " "+item.email,
                        };
                    }));
                    self._cache[request.term] = items;
                },
                error: function (result) {
                    alert("Error");
                }
            
                	
            });
        },
        minLength : 1,
        select: function( event, ui ) {
        	log(ui.item ? "Selected User: " + ui.item.label : "Nothing selected, input was " + this.value);
        }, 
        
        open: function() {
        	$(this).removeClass("ui-corner-all").addClass("ui-corner-top");
        },
        
        
        change: function(event, ui) { 
            event.preventDefault();
        },
        close: function() {
        	$(this).removeClass("ui-corner-top").addClass("ui-corner-all");
        }
    
    });
    
    });
    
    
}); 
}); 

</script>
</head>
<body>
        <div class="ui-widget">
            <label for="search">Search User: </label>
            <input id="search" autofocus />
           
        </div>
        <div class="ui-widget" style="margin-top: 2em; font-family: Arial;">
            Result:
            <div id="input" style="height: 200px; width: 300px; overflow: auto;" class="ui-widget-content"></div>
        </div>
</body>
</html>    