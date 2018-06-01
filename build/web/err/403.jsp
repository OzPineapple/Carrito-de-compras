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
        <link rel="stylesheet" href="/Carrito-de-compras/css/normalize.css">
        <link rel="stylesheet" href="/Carrito-de-compras/css/skeleton.css">
        <link rel="stylesheet" href="/Carrito-de-compras/css/err.css"/>
        <title>403</title>
    </head>
    <body class="403">
        <h1>
            <b>403</b> ¡WOW WOW! ¿Quien eres tú?
        </h1>
        <br>
        <h3>
            <%= (request.getAttribute("Mensaje")==null)? "":request.getAttribute("Mensaje") %>
        </h3>
        <br>
        <img src="/Carrito-de-compras/img/403.gif">
        <br>
        <button onclick="history.back(1)" class="button">Volver</button>
    </body>
</html>

