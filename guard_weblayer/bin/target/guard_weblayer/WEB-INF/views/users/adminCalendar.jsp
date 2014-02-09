<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<title>Calendar</title>
<!-- calendar scripts and css  begin -->
<script src="<%=request.getContextPath()%>/resources/calendar/jscal2.js"></script>
<script src="<%=request.getContextPath()%>/resources/calendar/en.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/calendar/jscal2.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/calendar/border-radius.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/calendar/steel/steel.css" />
<%-- <script src="<%=request.getContextPath()%>/resources/calendar/sv.js"></script> --%>
<%-- <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/calendar/gold/gold.css" /> --%>
<!-- calendar scripts and css  end-->

<link href="<%=request.getContextPath()%>/resources/css/layout.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/menu.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/styles.css"
	rel="stylesheet" type="text/css" />
<link
	href="<%=request.getContextPath()%>/resources/css/buttons/bonbon-buttons.css"
	rel="stylesheet" type="text/css" />
<%-- <link href="<%=request.getContextPath()%>/resources/css/buttons/buttons.css" rel="stylesheet" type="text/css" /> --%>
</head>
<style type="text/css">
<!--
.fontstyle {
	font-family: Arial, Helvetica, sans-serif;
	color: #19BCFF;
	font-weight: normal;
	font-style: italic;
	font-size: 16px;
}

.font2 {
	font-family: Arial, Helvetica, sans-serif;
	color: #E3055E;
	font-weight: normal;
	font-style: italic;
	font-size: 16px;
}

.font3 {
	font-family: Arial, Helvetica, sans-serif;
	color: #0505F2;
	font-weight: normal;
	font-style: italic;
	font-size: 16px;
}
</style>
<body>
	<header>
	<h2 align="right">Welcome To Rapid Larm Central Menu</h2>
	<a href="<c:url value="http://localhost:8080/guard_weblayer/" />"
		class="stuts"></a> </header>
	<div class="container">
		<ul id="nav">
			<li><a
				href="<c:url value="http://localhost:8080/guard_weblayer/" />">Home</a></li>
			<li><a class="hsubs" href="#">Menu 1</a>
				<ul class="subs">
					<li><a href="#">Submenu 1</a></li>
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
			<li><a href="<c:url value="/j_spring_security_logout" />">
					<p class="fontstyle">Log ut</p>
			</a></li>
			<li><a style="font-size: 20px; color: #19BCFF;">${currentUser}</a></li>
			<div id="lavalamp"></div>
		</ul>
		<br /> <br /> <br />



		<form:form action="" method="post" modelAttribute="calendar">
			<table border="0" align="left" bordercolor="#00B4FF">
				<tr>

					<td colspan="4" id="cont" align="center"><tt class="fontstyle">Start
							Date And Time</tt> <br /> <br /> <script type="text/javascript">
								//<![CDATA[

								// this handler is designed to work both for onSelect and onTimeChange
								// events.  It updates the input fields according to what's selected in
								// the calendar.
								function updateFields(cal) {
									var date = cal.selection.get();
									if (date) {
										date = Calendar.intToDate(date);
										document.getElementById("startDate").value = Calendar
												.printDate(date, "%Y-%m-%d");
										document.getElementById("startWeekDay").value = Calendar
												.printDate(date, "%A");
									}
									document.getElementById("startHour").value = cal
											.getHours();
									document.getElementById("startMinute").value = cal
											.getMinutes();
								};

								Calendar.setup({
									cont : "cont",
									showTime : 24,
									onSelect : updateFields,
									weekNumbers : true,
									onTimeChange : updateFields
								});

								//]]>
							</script> <br /> <input style="text-align: center" name="startWeekDay"
						id="startWeekDay" size="10" /> <input style="text-align: center"
						name="startDate" id="startDate" size="16" /> <input
						style="text-align: center" name="startHour" id="startHour"
						size="4" /> <input style="text-align: center" name="startMinute"
						id="startMinute" size="4" /></td>
					<td width="30"></td>

					<td colspan="4" id="cont1" align="center"><tt
							class="fontstyle">End Date And Time</tt> <br /> <br /> <script
							type="text/javascript">
								//<![CDATA[

								// this handler is designed to work both for onSelect and onTimeChange
								// events.  It updates the input fields according to what's selected in
								// the calendar.

								function updateFields(cal) {
									var date = cal.selection.get();
									if (date) {
										date = Calendar.intToDate(date);
										document.getElementById("endDate").value = Calendar
												.printDate(date, "%Y-%m-%d");
										document.getElementById("endWeekDay").value = Calendar
										.printDate(date, "%A");
									}
									document.getElementById("endHour").value = cal
											.getHours();
									document.getElementById("endMinute").value = cal
											.getMinutes();
								};

								Calendar.setup({
									cont : "cont1",
									showTime : 24,
									onSelect : updateFields,
									weekNumbers : true,
									onTimeChange : updateFields
								});

								//]]>
						</script> <br /> <input style="text-align: center" name="endWeekDay"
						id="endWeekDay" size="10" /> <input style="text-align: center"
						name="endDate" id="endDate" size="16" /> <input
						style="text-align: center" name="endHour" id="endHour" size="4" />
						<input style="text-align: center" name="endMinute" id="endMinute"
						size="4" /></td>
					<td class="fontstyle" colspan="4" align="center"><tt>Number
							Of Guards </tt> <br /> <br /> <br /> <br /> <br /> <br /> <br />
						<br /> <br /> <br /> <br /> <br /> <input
						style="text-align: center" name="number" size="4" /></td>
				<tr>

					<td style="text-align: right">
						<%-- <button class="button blue  "type="submit" onClick="window.location='ok${calendar}';" >Save</button>   --%>
						<button class="button blue" type="submit">Save</button>
					</td>
				</tr>


			</table>



		</form:form>




		<!-- JavaScript includes -->
		<script src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
		<script src="<%=request.getContextPath()%>/resources/js/script.js"></script>
	</div>
</body>
</html>
