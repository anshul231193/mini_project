<%-- 
    Document   : addMinutes
    Created on : 14 Jul, 2016, 1:14:11 PM
    Author     : anshul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix ="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix ="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add Minutes Exercised</h1>
        
        Language: <a href="?Language=en">English</a> | <a href="?Language=es">Spanish</a>
        <form:form commandName="exercise">
            <table>
                <tr>
                    <td><spring:message code="goal.text" /></td>
                    <td><form:input path="minutes" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Enter Exercise">
                    </td>
                </tr>
            </table>
        </form:form>
    </body>
</html>
