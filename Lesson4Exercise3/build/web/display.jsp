<%-- 
    Document   : display.jsp
    Created on : Oct 7, 2023, 10:44:13 AM
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

        <form action="home?action=search" method="GET">
            Search <input type="text" name="keyword" value="hau hau dau"/>
            <input type="submit" value="Submit"/>

        </form>
        <table border="1">
            <tr>
                <th>Username</th> 
                <th>Password</th>
                <th>Gender</th>
                <th>Role</th>
                <th>Action</th>
            </tr>

            <!--hien thi tat ca cac Account-->
            <c:forEach items="${listAccount}" var="account">
            </tr>
            <td>${account.username}</td>
            <td>${account.password}</td>
            <td>${account.gender ? 'Male' : 'Female'}</td>
            <td>${account.role.username}</td>  
            <td>
                <form action="home?action=delete" method="POST">
                    <input type="text" name="username" value="${account.username}" 
                           style="display: none"/>
                    <input type="submit" value="Delete"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
