<%-- 
    Document   : register
    Created on : Oct 6, 2023, 10:58:39 PM
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
            <br/><br/>
            Password <input type="password" name="password"/><!-- comment -->
            <br/><br/>


            Gender <input type="radio" name="gender" value="male"/>nam
            <input type="radio" name="gender" value="female"/>nu
            <br/><br/>


            Role <select name="role">
                <!-- <option value="admin">Admin</option>
                                <option value="user">User</option>-->
                
                <!--hien thi tung Role cho nguoi dung chon-->
                <c:forEach items="${listRole}" var="hau">
                    <option value="${hau.id}">${hau.username}</option>
                </c:forEach>
            </select>
            <br/><br/>

            <input type="submit" value="login"/>


        </form>
    </body>
</html>
