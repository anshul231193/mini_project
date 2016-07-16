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
    <style>
        .error {
            color:#ff0000;
        }
        .errorblock {
            color:#000;
            background-color: #ffEEEE;
            border:3px solid #ff0000;
            padding: 8px;
            margin: 16px;
        }
    </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Goal</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form:form commandName="goal">
            <form:errors path="*" cssClass="errorblock" element="div"></form:errors>
            <table>
                <tr>
                    <td> Enter Minutes:</td>
                    <td><form:input path="minutes" /></td>
                <td><form:errors path="minutes" cssClass="error"/></td>
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
