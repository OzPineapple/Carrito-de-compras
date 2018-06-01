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
        <title>418</title>
    </head>
    <body style="background: #66ff66">
        <h1>
            <b>418 </b>No programado aún <%= (request.getAttribute("Mensaje")==null)? "":request.getAttribute("Mensaje") %>
        </h1>
        <br>
        <img src="/Carrito-de-compras/img/418.gif">
        <br>
        <button onclick="history.back(1)" class="button">Volver</button>
    </body>
</html>
