<%-- 
    Document   : Error
    Created on : 28/05/2018, 10:43:43 AM
    Author     : Zush18
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="//fonts.googleapis.com/css?family=Raleway:400,300,600" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="css/normalize.css">
        <link rel="stylesheet" href="css/skeleton.css">
        <title>ERROR</title>
        <style>
            body{
                background: #ff6666;
                color: white;
            }
        </style>
    </head>
    <body>
        <%
            int status = (int) request.getAttribute("status");
            switch(status){
                case 400:
                    %>
                    <h1>Campos no validos</h1>
                    <%
                break;
            }
        %>
    </body>
</html>
