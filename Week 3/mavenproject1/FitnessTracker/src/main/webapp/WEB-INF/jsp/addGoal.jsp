<%-- 
    Document   : addGoal
    Created on : 15 Jul, 2016, 3:09:31 AM
    Author     : anshul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Goal</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form:form commandName="goal">
            <table>
                <tr>
                    <td> Enter Minutes:</td>
                    <td><form:input path="minutes" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Enter Goal minutes" />
                    </td>
                </tr>
            </table>
        </form:form>
    </body>
</html>
