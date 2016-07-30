<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <title>Forget Password Page</title>
</head>
<body onload='document.loginForm.username.focus();'>


	        <div class = "container">
	<div class="wrapper">
                <c:if test="${not empty msg}">
                    <div style= "width:420px;margin:10px auto;" class="alert alert-<c:out value="${flashKind}" /> alert-dismissible"
                    role="alert">
                        <strong>${msg}!!</strong>
                    </div>
                </c:if>
		<form action=""  
                      method="post" name="Login_Form" class="form-signin">       
		    <h3 class="form-signin-heading">Reset Password!!</h3>
			  <hr class="colorgraph"><br>
			  
			  <input type="password" class="form-control" name="pswd" placeholder="Password" required="true" autofocus="true" />		  
                          <input type="password" class="form-control" name="confirmpswd" placeholder="Re enter your password" required="true" autofocus="true" />		  
                          <input type="hidden" name="${_csrf.parameterName}"
                                 value="${_csrf.token}" /><br>
			  <button class="btn btn-lg btn-primary btn-block"  name="Submit" value="SUBMIT" type="Submit">SUBMIT</button>                        
                </form>
	</div>
</div>

</body>
</html>
