 <%-- 
    Document   : display
    Created on : Sep 28, 2023, 8:54:06 PM
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
        <!--Username EL: EXPRESSION LANGUAGE-->
        <h1>Username: ${account.username}</h1>
        <h1>Password: ${account.password}</h1>
        <<form action="action">
            Username <input type="text" name="username"/>
            Password <input type="password" name="password"/>
            <input type="submit" value="HAU"/> 
        </form>
    </body>
</html>
