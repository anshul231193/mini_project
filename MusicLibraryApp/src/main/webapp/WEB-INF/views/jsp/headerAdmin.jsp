<%-- 
    Document   : header
    Created on : 24 Jul, 2016, 4:07:57 PM
    Author     : anshul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <link href="../css/search.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" 
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
	<script type="text/javascript" 
		src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <link href="../css/login.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="../css/demo.css">
	<link rel="stylesheet" href="../css/header-user-dropdown.css">
        <link href='http://fonts.googleapis.com/css?family=Cookie' rel='stylesheet' type='text/css'>

    </head>
    <body>
        
        <header class="header-user-dropdown">

            <div class="header-limiter">
                    <h1><a href="#">Company<span>logo</span></a></h1>

                    <nav>
                            <a href="../home">Home</a>
                            <a href="#">About</a>
                            <a href="#">Contact</a>
                    </nav>


                    <div class="header-user-menu">
                        <a href="#">Hi, ${pageContext.request.userPrincipal.name}</a>
                            <ul>
                                    <li><a href="#">Settings</a></li>
        		            <li><a href="../changePassword">Change Password</a></li>
                                    <li><a href="../logout" class="highlight">Logout</a></li>
                            </ul>
                    </div>

            </div>

        </header>
    </body>
</html>
