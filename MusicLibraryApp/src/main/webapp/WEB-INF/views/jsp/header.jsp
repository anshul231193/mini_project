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
        <link href="css/search.css" rel="stylesheet" type="text/css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="js/search.js" type="text/javascript"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <script src="js/playlist.js" type="text/javascript"></script>
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="css/demo.css">
	<link rel="stylesheet" href="css/header-user-dropdown.css">
        <link href='http://fonts.googleapis.com/css?family=Cookie' rel='stylesheet' type='text/css'>

    </head>
    <body>
        
        <header class="header-user-dropdown">

            <div class="header-limiter">
                    <h1><a href="#">Company<span>logo</span></a></h1>

                    <nav>
                            <a href="home">Home</a>
                            <a href="#">About</a>
                            <a href="#">Contact</a>
                    </nav>


                    <div class="header-user-menu">
                        <a href="#">Hi, ${pageContext.request.userPrincipal.name}</a>
                            <ul>
                                    <li><a href="#">Settings</a></li>
        		            <li><a href="#">Change Password</a></li>
                                    <li><a href="logout" class="highlight">Logout</a></li>
                            </ul>
                    </div>

            </div>

        </header>
    </body>
</html>
