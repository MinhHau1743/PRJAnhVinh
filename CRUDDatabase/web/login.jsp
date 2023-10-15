<%-- 
    Document   : login
    Created on : Oct 15, 2023, 10:42:21 PM
    Author     : minhh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="home" method ="GET">
            <input type="text" name="action" value="login" style="display: none"/>
            Username <input type="text" name="username"/>
            Password <input type ="password" name="password"/>
            <input type="submit" value="Login"/>
        </form>
        <p>${error}</p>
    </body>
</html>
