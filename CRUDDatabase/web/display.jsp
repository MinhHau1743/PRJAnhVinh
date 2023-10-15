<%-- 
    Document   : display
    Created on : Oct 15, 2023, 10:02:50 PM
    Author     : minhh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Username</th>
                    <th>Password</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${listAccount}" var="account">
                <tr>
                    <td>${account.getId()}</td>
                    <td>${account.getUsername()}</td>
                    <td>${account.getPassword()}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </body>
</html>
