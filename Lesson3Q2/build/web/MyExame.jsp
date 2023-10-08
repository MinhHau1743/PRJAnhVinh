<%-- 
    Document   : MyExame
    Created on : Oct 5, 2023, 11:38:18 PM
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
        <form action="count" method="POST">
            Enter an integer <input type="text" name="number"/>
            <br/>
            
            Result <input type="text" value="${num}"/>
            <br/>
            <input type="submit" value="Count"/>
            <!<!-- hien thi ra loi -->
            <h1>${error}</h1>
        </form>
    </body>
</html>
