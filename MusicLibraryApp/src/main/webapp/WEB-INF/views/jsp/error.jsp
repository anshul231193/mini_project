<%-- 
    Document   : error
    Created on : 29 Jul, 2016, 9:42:08 PM
    Author     : anshul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Inscription</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
   <script src="http://code.jquery.com/jquery-2.1.4.js"
        th:src="@{/webjars/jquery/2.1.4/jquery.min.js}"></script>
    
      <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.96.0/js/materialize.min.js"
      		  th:src="@{/webjars/materializecss/0.96.0/js/materialize.min.js}"></script>
      		  
     <link href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.96.0/css/materialize.min.css"
               th:href="@{/webjars/materializecss/0.96.0/css/materialize.min.css}" rel="stylesheet"/> 		
               
         <link href="../static/css/template_default.css"
               th:href="@{/css/template_default.css}" rel="stylesheet"/>
</head>
<body class="body_wrapper">
<header>
<nav>
    <div class="nav-wrapper">
      <a href="#" class="brand-logo"><img th:src="@{http://www.javaenthusiasm.com}"/></a>
    </div>
  </nav>
</header>
<div class="section center">

<p> this url is invalid or has expired </p>
</div>
</body>
</html>
