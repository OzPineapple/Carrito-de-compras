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
        <title>401</title>
        <style>
            *{
                margin: auto;
            }
            body{
                background: #ff6666;
                color: white;
                padding: 5rem;
                overflow-y: hidden;
                overflow-x: hidden;
            }
        </style>
    </head>
    <body>
        <h1>
            <b>401</b> ¡Ey! ¿Que intentas hacer?
        </h1>
        <br>
        <h3>
            <%= (String) request.getAttribute("Mensaje") %>
        </h3>
        <br>
        <img src="img/401.gif">
        <br>
        <button onclick="history.back(1)" class="button">Volver</button>
    </body>
</html>
