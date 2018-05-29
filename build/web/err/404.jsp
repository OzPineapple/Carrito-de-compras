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
        <title>404</title>
        <style>
            body{
                background: #ff6666;
                color: white;
                padding: 5rem;
                overflow-y: hidden;
                overflow-x: hidden;
            }
            img{
                width: 40rem;
            }
        </style>
    </head>
    <body>
        <h1>
            404
        </h1>
        <br>
        <h2>
            La pagina que buscas no existe
        </h2>
        <br>
        <img src="img/404.gif">
        <br>
        <button onclick="history.back(1)" class="button">Volver</button>
    </body>
</html>
