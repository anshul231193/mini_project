<%-- 
    Document   : home
    Created on : 30 Jun, 2016, 12:31:34 AM
    Author     : anshul
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/reset.css" type="text/css" />
        <link rel="stylesheet" href="css/styles.css" type="text/css" />
        <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">


        <!--[if lt IE 9]>
        <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/slider.js"></script>
        <script type="text/javascript" src="js/superfish.js"></script>

        <script type="text/javascript" src="js/custom.js"></script>
        <title>Home Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <div id="container"  class="width">

    <header> 
	<div>
    		

		<h1><a href="home">Hi, <strong>${user.name}</strong></a></h1>

		<nav>
	
    			<ul class="sf-menu dropdown">

			
        			<li><a href="home">Home</a></li>

            	

	     			<li><a href="#">Contact</a></li>
            
                                <li><a href="#">Logout</a></li>

       			</ul>

			
			<div class="clear"></div>
    		</nav>
       	</div>

	<div class="clear"></div>

       
    </header>
                <p>&nbsp;&nbsp;</p>
                <h3>List of Addresses</h3>

            <table cellspacing="0">
                <tr>
                    <th>Address</th>
                    <th>Delete</th>
                </tr>
                <c:forEach items="${user.address}" var="listAddress">
                    <tr>
                        <td><c:out value="${listAddress.street}"></c:out>,<c:out value="${listAddress.city}"></c:out>, <c:out value="${listAddress.state}"></c:out>,<c:out value="${listAddress.country}"></c:out> &nbsp;<button type="button" class="btn btn-default btn-sm">
                        <span class="glyphicon glyphicon-edit"></span>   Edit
                      </button></td>
                        <td><c:out value="${listAddress.id}"></c:out></td>
                    </tr>
                </c:forEach>
                

            </table><br>
            <a href="addEditAddress"><button type="button" class="btn btn-primary">Add Address</button></a> 
            <button type="button" class="btn btn-primary">Delete Addresses</button>
        </div>
    </body>
</html>
