<!DOCTYPE html>
<html>
<head>
<title>Example</title>
<script src="<%=request.getContextPath()%>/resources/js/jquery-1.9.1.js"
	type="text/javascript"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/jquery-ui-1.10.2.custom.js"
	type="text/javascript"></script>
<link
	href="<%=request.getContextPath()%>/resources/css/jquery-ui-1.10.2.custom.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"> 
 	$(document).ready(
 			function() {
 				var flowers = "${json}"";
//  				var flowers = [ "Astor", "Daffodil", "Rose", "Peony",
//  						"Primula", "Snowdrop", "Poppy", "Primrose", "Petuna",
//  						"Pansy","iraj ghasemi","iraj" ];
 				$('#acInput').autocomplete({
 					source : flowers,
 					focus : displayItem,
 					select : displayItem,
 					change : displayItem
 				})
 				function displayItem(event, ui) {
 					$('#itemLabel').text(ui.item.label)
 				}
 			});
 </script>
<script type="text/javascript"> 
 	$(document).ready(
 			function() {
 				var flowers = "${users}"";
//  				var flowers = [ "Astor", "Daffodil", "Rose", "Peony",
//  						"Primula", "Snowdrop", "Poppy", "Primrose", "Petuna",
//  						"Pansy","iraj ghasemi","iraj" ];
 				$('#acInput1').autocomplete({
 					source : flowers,
 					focus : displayItem,
 					select : displayItem,
 					change : displayItem
 				})
 				function displayItem(event, ui) {
 					$('#itemLabel1').text(ui.item.label)
 				}
 			});
 </script>

<!-- function loadEmployes(officeId){ -->
<!-- 	$.ajax({ -->
<!-- 		type: "GET", -->
<!-- 		url: employee_service + "/byofficeid", -->
<!-- 		data: { -->
<!-- 			"officeId": officeId -->
<!-- 		}, -->
<!-- 		dataType: "json", -->
<!-- 		success: function(result){ -->
<!-- 			var r = "<div>"; -->

<!-- 			var nEmp = result.length; -->
<!-- 			for(var i=0; i<nEmp; i++){ -->
<%-- 				r += "<p>" + result[i].firstName + " " + result[i].surname + "</p>"; --%>
<!-- 			} -->

<!-- 			r += "</div>"; -->

<!-- 			$("#result").fadeOut('slow', function(){ -->
<!-- 				$(this).html(r); -->
<!-- 				$(this).fadeIn('slow'); -->
<!-- 			}); -->
<!-- 		}, -->
<!-- 		error: function() { alert("ERROR"); } -->
<!-- 	}); -->
<!-- }; -->


</head>


<body>
	<form>
		<div class="ui-widget">
			<label for="acInput">Find User: </label> <input id="acInput" />
			User: <span id="itemLabel"></span>
		</div>
	</form>
	<br />
	<br />
	<form>
		<div class="ui-widget">
			<label for="acInput1">Find User: </label> <input id="acInput1" />
			User: <span id="itemLabel1"></span>
		</div>
	</form>

	<br />
	<br />
	<br />
	<br />

	<div>${json}</div>

</body>
</html>