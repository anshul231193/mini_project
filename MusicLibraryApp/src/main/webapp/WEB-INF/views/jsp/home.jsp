<%-- 
    Document   : home
    Created on : 21 Jul, 2016, 1:46:37 PM
    Author     : anshul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello ${pageContext.request.userPrincipal.name}!</h1>
    </body>
</html>
