<%@ include file="/WEB-INF/partials/taglibs.jsp"%>
<head>
<title>Reset Password</title>
<link href="<%=request.getContextPath()%>/resources/css/html5reset-1.6.1.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/error.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/flextable/css/normalize.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/flextable/css/style.css" rel="stylesheet" type="text/css" />
 <link href='http://fonts.googleapis.com/css?family=Monoton' rel='stylesheet' type='text/css'>
<link href="<%=request.getContextPath()%>/resources/css/flexlayout.css" rel="stylesheet" type="text/css" />
<!--     <script src="http://code.jquery.com/jquery-2.0.3.min.js"></script> -->
<!--     <script src="http://code.jquery.com/jquery-migrate-2.0.3.min.js"></script> -->
    <script src="<%=request.getContextPath()%>/resources/js/jquery.novacancy.js"></script>
    <script src="<%=request.getContextPath()%>/resources/css/flextable/js/prefixfree.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/jquery-1.9.1.js"></script>
    <script src="<%=request.getContextPath()%>/resources/css/flipClock/flip.js"></script>
<link href="<%=request.getContextPath()%>/resources/css/flipClock/flip.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/timeline/timeline.css" rel="stylesheet" type="text/css" />
<%-- <link href="<%=request.getContextPath()%>/resources/css/buttons/buttons.css" rel="stylesheet" type="text/css" /> --%>
  </head>
<style type="text/css">
body { font-family: Arial, Helvetica, Sans-serif; font-size:13px;}
#sampleForm label { display:block; margin-top:10px;}
#sampleForm input[type="text"] { width:200px; border:solid 1px #000; padding:3px 0px;}
#sampleForm img { vertical-align:middle; cursor:pointer; }
.imageInputWrapper{ width:200px; border:solid 1px #000;  }
#sampleForm input.inputWithImge { width:175px; border:none; margin-right:5px;}

/* method 2*/
#funkystyling {
     background:  url(resources/formImages/calendar.png) right no-repeat;
     padding-right: 30px;
     background-color:white;
}

#userImage{
background:  url(resources/formImages/bank.png) right no-repeat;
     padding-right: 30px;
     background-color:white;
}

.div{width:240px;margin:30px auto; text-align:left;}
.lable{display:block;}
.input{display:block; margin:3px 0px 10px;}
.form{margin: 0px 0px 150px}

/* .field { width:190px; border:1px solid #b3b3a9; background:#FFF; padding:6px 6px 6px 24px; } */
/* .username { background:url(resources/formImages/user.png) no-repeat #fff 8px 8px; } */
/* .email { background:url(resources/formImages/email.png) no-repeat #fff 8px 8px; } */
/* .password { background:url(resources/formImages/password.png) no-repeat #fff 8px 8px; } */
    </style>
<script type="text/javascript">
        $(document).ready(function() {
            $(".inputWithImge").each(function(){
                $(this).add($(this).next()).wrapAll('<div class="imageInputWrapper"></div>');
            });
        });
    </script>
    
  <body>
 <header>Example on 'Image into input '</header>
 <div id='main'>
    <article>
   <fieldset id="sampleForm">
        <label for="txtName">Full name</label>
        <input id="txtName" type="text" />
        <label for ="txtDOB">Date of birth</label>
        <input id="txtDOB" type="text" class="inputWithImge" />
        <img src="resources/formImages/calendar.png" alt="Click to popup the clendar!" onclick="alert('Popup some calendar here!');" />
        <label for="txtCity">City</label>
        <input id="txtCity" type="text" />
        <label for="txtPostCode">Post code</label>
        <input id="txtPostCode" type="text" />
        <label for="txtCountry">Country</label>
        <input id="txtCountry" type="text" />
        <label for="txtBank">Bank</label>
        <input id="txtBank" type="text" class="inputWithImge" />
        <img src="resources/formImages/bank.png" alt="Click to popup the bank window!" onclick="alert('Popup some window here!');" />
    </fieldset>
    <button id="btnNothingToDo">Do nothing</button>
<!-- method 2 -->
<br/>
    <input type="text" name="whatever" id="funkystyling" />
    <input type="text" name="whatever" id="userImage" />
    <br/>
    <br/>
    <br/>
<!-- <h2>what's your ...?</h2> -->
<!--   <form action="#" method="post"> -->
<!--     <label>username -->
<!--       <input name="username" value="" type="input" class="field username" /> -->
<!--     </label> -->
<!--     <label>email address -->
<!--       <input name="email" value="" type="input" class="field email" /> -->
<!--     </label> -->
<!--     <label>password -->
<!--       <input name="password" value="" type="password" class="field password" /> -->
<!--     </label> -->
<!--     <input name="submit" type="button" value="Submit Form" /> -->
<!--   </form>     -->
  
  
  <!-- Based on http://codepen.io/martingrand/pen/pqxtc-->
<!-- <div class="clock">                             -->
<!--   <h1>Current time is:<br/>                                 -->
<!--         <div class="counter hours"> -->
<!--             <span class="decor top"></span> -->
<!--             <span class="decor bottom"></span> -->
<!--             <span class="from top"><span></span><span class="shadow"></span></span> -->
<!--             <span class="from bottom"><span></span><span class="shadow"></span></span> -->
<!--             <span class="to top"><span></span><span class="shadow"></span></span> -->
<!--             <span class="to bottom"><span></span><span class="shadow"></span></span> -->
<!--         </div> -->
<!--         <span>:</span> -->
<!--         <div class="counter minutes"> -->
<!--             <span class="decor top"></span> -->
<!--             <span class="decor bottom"></span> -->
<!--             <span class="from top"><span></span><span class="shadow"></span></span> -->
<!--             <span class="from bottom"><span></span><span class="shadow"></span></span> -->
<!--             <span class="to top"><span></span><span class="shadow"></span></span> -->
<!--             <span class="to bottom"><span></span><span class="shadow"></span></span> -->
<!--         </div> -->
<!--         <span>:</span> -->
<!--         <div class="counter seconds"> -->
<!--             <span class="decor top"></span> -->
<!--             <span class="decor bottom"></span> -->
<!--             <span class="from top"><span></span><span class="shadow"></span></span> -->
<!--             <span class="from bottom"><span></span><span class="shadow"></span></span> -->
<!--             <span class="to top"><span></span><span class="shadow"></span></span> -->
<!--             <span class="to bottom"><span></span><span class="shadow"></span></span> -->
<!--         </div>                                 -->
<!--     </h1>                             -->
<!-- </div> -->

<!-- <table> -->
<!--     <thead> -->
<!--     <tr> -->
<!--         <th>User Id</th> -->
<!--         <th>First Name</th> -->
<!--         <th>Last Name</th> -->
<!--         <th>User Name</th> -->
<!--         <th>Email</th> -->
<!--         <th>Street</th> -->
<!--         <th>Zip Code</th> -->
<!--         <th>City</th> -->
<!--         <th>Update User</th> -->
<!--         <th>Delete User</th> -->
<!--         <th>Add New User</th> -->

<!--     </tr> -->
<!--     </thead> -->
<!--     <tbody> -->
<%--     <c:forEach var="user" items="${allUsers}"> --%>
<!--     <tr> -->
<%--         <td>${user.userid}</td> --%>
<%-- 							<td>${user.firstname}</td> --%>
<%-- 							<td>${user.lastname}</td> --%>
<%-- 							<td>${user.username}</td> --%>
<%-- 							<td><a href="mailto:${user.email}">${user.email}</a></td> --%>
<%-- 							<td>${user.address.street}</td> --%>
<%-- 							<td>${user.address.zipcode}</td> --%>
<%-- 							<td>${user.address.city}</td> --%>
<!-- 							<td><button class="button small blue " type="submit" -->
<%-- 									onClick="window.location='getuser?userid=${user.userid}';"> --%>
<!-- 									Update User</button></td> -->
<!-- 							<td> -->
<%-- 							<button class="button small blue " type="submit" onClick="window.location='deleteuser?userid=${user.userid}';"> --%>
<!-- 									Delete User</button></td> -->
<!-- 							<td><button class="button small blue " type="submit" -->
<!-- 									onClick="window.location='addnewuser';" value='Add new User'> -->
<!-- 									Add New User</button></td> -->
<!-- 						</tr> -->
<%-- 					</c:forEach> --%>
<!-- 				</tbody> -->
<!-- </table>        -->


<section id="timeline">
  <article>
    <div class="inner">
      <span class="date">
        <span class="day">30<sup>th</sup></span>
        <span class="month">Jan</span>
        <span class="year">2014</span>
      </span>
      <h2>The Title</h2>
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean quis rutrum nunc, eget dictum massa. Nam faucibus felis nec augue adipiscing, eget commodo libero mattis.</p>
    </div>
  </article>
  <article>
    <div class="inner">
      <span class="date">
        <span class="day">26<sup>th</sup></span>
        <span class="month">Jan</span>
        <span class="year">2014</span>
      </span>
      <h2>The Title</h2>
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean quis rutrum nunc, eget dictum massa. Nam faucibus felis nec augue adipiscing, eget commodo libero mattis.</p>
    </div>
  </article>
  <article>
    <div class="inner">
      <span class="date">
        <span class="day">26<sup>th</sup></span>
        <span class="month">Jan</span>
        <span class="year">2014</span>
      </span>
      <h2>The Title</h2>
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean quis rutrum nunc, eget dictum massa. Nam faucibus felis nec augue adipiscing, eget commodo libero mattis.</p>
    </div>
  </article>
  <article>
    <div class="inner">
      <span class="date">
        <span class="day">26<sup>th</sup></span>
        <span class="month">Jan</span>
        <span class="year">2014</span>
      </span>
      <h2>The Title</h2>
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean quis rutrum nunc, eget dictum massa. Nam faucibus felis nec augue adipiscing, eget commodo libero mattis.</p>
    </div>
  </article>
  <article>
    <div class="inner">
      <span class="date">
        <span class="day">26<sup>th</sup></span>
        <span class="month">Jan</span>
        <span class="year">2014</span>
      </span>
      <h2>The Title</h2>
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean quis rutrum nunc, eget dictum massa. Nam faucibus felis nec augue adipiscing, eget commodo libero mattis.</p>
    </div>
  </article>
</section>
    </article>  
<nav>left</nav>
<aside>wright</aside>
</div>
<footer>footer</footer>
