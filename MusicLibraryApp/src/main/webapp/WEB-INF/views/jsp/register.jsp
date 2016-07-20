<%-- 
    Document   : register
    Created on : 20 Jul, 2016, 3:17:27 PM
    Author     : anshul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="js/registerationValidation.js" type="text/javascript"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <div class = "container">
        
        
        <div class="wrapper">
            <c:if test="${not empty message}">
            <div style= "width:420px;margin:10px auto;" class="alert alert-<c:out value="${flashKind}" /> alert-dismissible"
            role="alert">
                <strong>${message}!</strong>
            </div>
            </c:if>
		<form action="" method="post" onsubmit=" return myFunction()" name="Register_Form"  class="form-signin" onsubmit="return validateform()">       
		    <h3 class="form-signin-heading"> Please Sign Up !!</h3>
			  <hr class="colorgraph"><br>
			  
			  <div class="form-group">
			      <label for="name">Name:</label>
                              <input type="text" class="form-control" id="name" name="name" maxlength="30" required>
			    </div>
                          <p id="nameError" style="color:red;"></p>
                             <div class="form-group">
			      <label for="username">User Name:</label>
			      <input type="text" class="form-control" id="usrname" name="username" maxlength="30" required>
			    </div>
                          <p id="usrError" style="color:red;"></p>
			    <div class="form-group">
			      <label for="pwd">Password:</label>
			      <input type="password" class="form-control" id="pwd" name="pwd" required>
			    </div>
                          <p id="pswdError" style="color:red;"></p>
                            <div class="form-group">
                                <label for="email">E-mail:</label>
                                <input type="email" class="form-control" id="email" name="email" maxlength="50" required>
             			    </div>
                            <div class="form-group">
			      <label for="age">Age:</label>
			      <input type="number" class="form-control" id="age" name="age" min="5" max="9999999999" required>
			    </div>
                            <div class="form-group">
			      <label for="address">Address:</label>
			      <textarea class="form-control" rows="5" id="comment" name="address" required></textarea>
			    </div>
			  <button class="btn btn-lg btn-primary btn-block" name="Submit" value="Register" type="Submit">Register</button>  
                          <h5>Go back to <a href="index"><span style="color:blue;">Login</span></a></h5>
                </form>
	</div>
</div>

        
    </body>
</html>
