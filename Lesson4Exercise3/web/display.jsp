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
            Search <input type="text" name="keyword" value=""/>
            <input type="submit" value="Submit"/>

        </form>

        <button id="addButton">Add</button>
        <div id="registerForm" style="display: none;">
            <form action="home?action=add" method="POST">
                Username <input type="text" name="username" autocomplete="off"/>
                <br/><br/>
                Password <input type="password" name="password" autocomplete="off"/><!-- comment -->
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

        </div>
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
<script>
    // JavaScript code to toggle the registration form's visibility
    document.getElementById("addButton").addEventListener("click", function () {
        var registerForm = document.getElementById("registerForm");
        if (registerForm.style.display === "none" || registerForm.style.display === "") {
            registerForm.style.display = "block";
        } else {
            registerForm.style.display = "none";
        }
    });
</script>
</html>
