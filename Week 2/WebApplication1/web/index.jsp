<%-- 
    Document   : index
    Created on : 28 Jun, 2016, 3:05:18 PM
    Author     : anshul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.dummy.jsp.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title></title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="styles/app.css">
</head>
<body>
	<header class="container-fluid"> 
		<h2>Registration Form</h2>
	</header><br>
            
                    
        
	<div class="container-fluid">
		<div class="row">
                    <h2>Welcome ${user.name} </h2>
			<form action="home" method="POST" role="form" class="col-md-5" id="signUpForm">
			    <div class="form-group">
			      <label for="name">Name:</label>
			      <input type="text" class="form-control" id="name" name="name" maxlength="30">
			    </div>
			     <div class="form-group">
			      <label for="usrname">User Name:</label>
			      <input type="text" class="form-control" id="usrname" name="usrname" maxlength="30" required>
			    </div>
			    <div class="form-group">
			      <label for="pwd">Password:</label>
			      <input type="password" class="form-control" id="pwd" name="pwd" required>
			    </div>
			    <div class = "form-group">
      				<label for = "address">Address:</label>
      				<textarea class = "form-control" id="address" name="address" rows = "3" required></textarea>
			   </div>
			    <div class="form-group">
			      <label for="phone">Cell Phone:</label>
			      <input type="number" class="form-control" id="phone" name="phone" min="1000000000" max="9999999999" required>
			    </div>
			    <button type = "submit" class = "btn btn-default">Submit</button>
			  	</form>
		</div>
	</div>
            
</body>
</html>
