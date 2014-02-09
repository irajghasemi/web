<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" >
    <head>
       <meta charset="utf-8" />
<title>Pure CSS3 LavaLamp Menu | Script Tutorials</title>
<link href="<%=request.getContextPath()%>/resources/css/layout.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/menu.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/styles.css"
	rel="stylesheet" type="text/css" />
    </head>
    <body>
        <header>
            <h2>Pure CSS3 LavaLamp Menu</h2>
            <a href="http://www.script-tutorials.com/pure-css3-lavalamp-menu/" class="stuts">Back to original tutorial on <span>Script Tutorials</span></a>
        </header>
       <div class="container">

            <ul id="nav">
                <li><a href="<c:url value="http://localhost:8080/guard_weblayer/" />">Home</a></li>
                <li><a class="hsubs" href="#">Menu 1</a>
                    <ul class="subs">
                        <li><a href="#">Submenu 1</a></li>
                        <li><a href="#">Submenu 2</a></li>
                        <li><a href="#">Submenu 3</a></li>
                        <li><a href="#">Submenu 4</a></li>
                        <li><a href="#">Submenu 5</a></li>
                    </ul>
                </li>
                <li><a class="hsubs" href="#">Menu 2</a>
                    <ul class="subs">
                        <li><a href="#">Submenu 2-1</a></li>
                        <li><a href="#">Submenu 2-2</a></li>
                        <li><a href="#">Submenu 2-3</a></li>
                        <li><a href="#">Submenu 2-4</a></li>
                        <li><a href="#">Submenu 2-5</a></li>
                        <li><a href="#">Submenu 2-6</a></li>
                        <li><a href="#">Submenu 2-7</a></li>
                        <li><a href="#">Submenu 2-8</a></li>
                    </ul>
                </li>
                <li><a class="hsubs" href="#">Menu 3</a>
                    <ul class="subs">
                        <li><a href="#">Submenu 3-1</a></li>
                        <li><a href="#">Submenu 3-2</a></li>
                        <li><a href="#">Submenu 3-3</a></li>
                        <li><a href="#">Submenu 3-4</a></li>
                        <li><a href="#">Submenu 3-5</a></li>
                    </ul>
                </li>
                <li><a href="#">Menu 4</a></li>
                <li><a href="#">Menu 5</a></li>
                <li><a href="#">Menu 6</a></li>
                <li><a href="http://www.script-tutorials.com/pure-css3-lavalamp-menu/">Back</a></li>
                <div id="lavalamp"></div>
            </ul>
            
            
            <div>
			${user}            
            </div>
            

        </div>
    </body>
</html>