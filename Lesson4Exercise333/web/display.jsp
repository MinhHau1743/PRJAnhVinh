<%-- 
    Document   : display
    Created on : Oct 9, 2023, 9:58:11 AM
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
            <tr>
                <th>Username</th>
                <th>Password</th>
                <th>Gender</th>
                <th>Role</th>
            </tr>

            <!--hien thi tat ca cac Account-->
            <c:forEach items="${listAccount}" var="account">
                </tr>
                <td>${account.username}</td>
                <td>${account.password}</td>
                <td>${account.gender ? 'Male' : 'Female'}</td>
                <td>${account.role.username}</td>  

                </tr>
            </c:forEach>
        </table>
    </body>
</html>
