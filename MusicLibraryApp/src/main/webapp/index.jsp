<%-- 
    Document   : index
    Created on : 19 Jul, 2016, 3:27:14 PM
    Author     : anshul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page buffer="none"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>  
    <head>
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <title>Login Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <%  
            if (session.getAttribute("user") != null) {  
                 String site = new String("home");
                 response.setStatus(response.SC_MOVED_TEMPORARILY);
                 response.setHeader("Location", site);
            }
         %>
    <div class = "container">
	<div class="wrapper">
            <c:if test="${not empty message}">
            <div style= "width:420px;margin:10px auto;" class="alert alert-<c:out value="${flashKind}" /> alert-dismissible"
            role="alert">
                <strong>${message}!</strong>
            </div>
            </c:if>
		<form action="j_spring_security_check" method="post" name="Login_Form" class="form-signin">       
		    <h3 class="form-signin-heading">Welcome Back! Please Sign In</h3>
			  <hr class="colorgraph"><br>
			  
			  <input type="text" class="form-control" name="username" placeholder="Username" required="" autofocus="" />
			  <input type="password" class="form-control" name="password" placeholder="Password" required=""/>     		  
			  <input type="hidden" 
                               name="${_csrf.parameterName}" value="${_csrf.token}" />
			  <button class="btn btn-lg btn-primary btn-block"  name="Submit" value="Login" type="Submit">Login</button>  
                          <h5>New User? <a href="register"><span style="color:blue;">Register</span></a></h5>
                </form>
	</div>
    </div>
    </body>
</html>
