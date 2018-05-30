<%-- 
    Document   : 401
    Created on : 29/05/2018, 10:23:53 AM
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
        <title>201</title>
        <style>
            body{
                background: #3399ff;
                color: white;
                padding: 5rem;
                overflow-y: hidden;
                overflow-x: hidden;
            }
        </style>
    </head>
    <body>
        <h1>
            <b>201</b> <%= request.getAttribute("Mensaje") %>
        </h1>
        <br>
        <img src="img/201.gif">
        <br>
        <button onclick="history.back(1)" class="button">Volver</button>
    </body>
</html>