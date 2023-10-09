<%-- 
    Document   : register
    Created on : Oct 8, 2023, 11:57:19 PM
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
        <h1>Day la trang dang ky</h1>
        <form action="register" method="POST">
            Username <input type="text" name="username"/>
            <br><br/>
            Password <input type="password" name="password"/>
            <br><br/>


            Gender <input type="radio" name="gender" value="male"/>nam
            <input type="radio" name="gender" value="female"/>nu
            <br><br/>

            Role <select name="role">
                <!--cach 1     <option value="admin">Admin</option>
                                <option value="user">User</option>-->


                <!--hien thi tung Role cho nguoi dung chon-->
<!--                for (Account account : listAccount)-->
                <c:forEach items="${listRole}" var="hau">             
                    <option value="${hau.id}">${hau.username}</option>                
                </c:forEach>
            </select>
            <br><br/>

            <input type="submit" value="login"/>
        </form>
    </body>
</html>
