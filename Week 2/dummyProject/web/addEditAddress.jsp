<%-- 
    Document   : addEditAddress
    Created on : 30 Jun, 2016, 12:20:37 PM
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Or Edit Page</title>
    </head>
    <body>
        <div class = "container">
        <div class="alert alert-success" id="address">
            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
            <strong>Success!</strong> Successfully added, You will be soon redirected to login page.
        </div>         
	<div class="wrapper">
		<form action="" method="post" name="Address_Form"  class="form-signin" onsubmit="return validateform()">       
		    <h3 class="form-signin-heading"> Address Form !!</h3>
			  <hr class="colorgraph"><br>
			  
			  <div class="form-group">
			      <label for="street">House No.:</label>
                              <input type="text" class="form-control" id="street" name="street" required>
			    </div>
         		     <div class="form-group">
			      <label for="city">City:</label>
			      <input type="text" class="form-control" id="city" name="city" required>
			    </div>
			    <div class="form-group">
			      <label for="state">State:</label>
			      <input type="text" class="form-control" id="state" name="state" required>
			    </div>
                          <div class="form-group">
			      <label for="country">Country:</label>
			      <input type="text" class="form-control" id="country" name="country" required>
			    </div>
			  <button class="btn btn-lg btn-primary btn-block"  name="Submit" value="Submit" type="Submit">Submit</button>  
                          <h5>Go back to <a href="home"><span style="color:blue;">Home</span></a></h5>
                </form>
	</div>
</div>
    <script src="js/AddressFormValidation.js" type="text/javascript"></script>
        </body>
</html>
