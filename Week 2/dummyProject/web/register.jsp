<%-- 
    Document   : register
    Created on : 29 Jun, 2016, 12:13:09 PM
    Author     : anshul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <title>Login Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div class = "container">
        <div class="alert alert-success" id="register">
            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
            <strong>Success!</strong> Successfully registered, You will be soon redirected to login page.
        </div>
	<div class="wrapper">
		<form action="" method="post" name="Register_Form"  class="form-signin" onsubmit="return validateform()">       
		    <h3 class="form-signin-heading"> Please Sign Up !!</h3>
			  <hr class="colorgraph"><br>
			  
			  <div class="form-group">
			      <label for="name">Name:</label>
                              <input type="text" class="form-control" id="name" name="name" maxlength="30" required>
			    </div>
                          <div class="alert alert-warning" id="invalidName">
                              <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                            <strong>Warning!</strong> Please Enter Valid Name.
                          </div>
			     <div class="form-group">
			      <label for="usrname">User Name:</label>
			      <input type="text" class="form-control" id="usrname" name="usrname" maxlength="30" required>
			    </div>
			    <div class="form-group">
			      <label for="pwd">Password:</label>
			      <input type="password" class="form-control" id="pwd" name="pwd" required>
			    </div>
                            <div class="form-group">
                                <label for="email">E-mail:</label>
                                <input type="email" class="form-control" id="email" name="email" maxlength="50" required>
             			    </div>
                          <div class="form-group">
			      <label for="phone">Cell Phone:</label>
			      <input type="number" class="form-control" id="phone" name="phone" min="1000000000" max="9999999999" required>
			    </div>
			  <button class="btn btn-lg btn-primary btn-block"  name="Submit" value="Register" type="Submit">Register</button>  
                          <h5>Go back to <a href="index"><span style="color:blue;">Login</span></a></h5>
                </form>
	</div>
</div>
        <script src="js/registerationValidation.js" type="text/javascript"></script>
    </body>
</html>

