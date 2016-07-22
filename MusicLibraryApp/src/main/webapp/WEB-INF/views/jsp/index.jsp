<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <title>Login Page</title>
</head>
<body onload='document.loginForm.username.focus();'>


	        <div class = "container">
	<div class="wrapper">
                <c:if test="${param.error == 'true'}">
                    <div style= "width:420px;margin:10px auto;" class="alert alert-<c:out value="${flashKind}" /> alert-dismissible"
                    role="alert">
                        <strong>${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}!Invalid Username or Password</strong>
                    </div>
                </c:if>
		<form action="${pageContext.request.contextPath}/j_spring_security_check"  
                      method="post" name="Login_Form" class="form-signin">       
		    <h3 class="form-signin-heading">Welcome Back! Please Sign In</h3>
			  <hr class="colorgraph"><br>
			  
			  <input type="text" class="form-control" name="username" placeholder="Username" required="" autofocus="" />
			  <input type="password" class="form-control" name="password" placeholder="Password" required=""/>     		  
                          <input type="hidden" name="${_csrf.parameterName}"
                            value="${_csrf.token}" />
			  <button class="btn btn-lg btn-primary btn-block"  name="Submit" value="Login" type="Submit">Login</button>  
                          <h5>New User? <a href="register"><span style="color:blue;">Register</span></a></h5>
                </form>
	</div>
</div>

</body>
</html>
