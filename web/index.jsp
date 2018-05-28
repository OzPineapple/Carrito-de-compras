<%-- 
    Document   : index
    Created on : 26/05/2018, 12:31:59 PM
    Author     : Zush18
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
  <!-- Basic Page Needs
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
  <meta charset="utf-8">
  <title>Your page title here :)</title>
  <meta name="description" content="">
  <meta name="author" content="">

        <!-- Mobile Specific Metas
        –––––––––––––––––––––––––––––––––––––––––––––––––– -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- FONT
        –––––––––––––––––––––––––––––––––––––––––––––––––– -->
        <link href="//fonts.googleapis.com/css?family=Raleway:400,300,600" rel="stylesheet" type="text/css">

        <!-- CSS
        –––––––––––––––––––––––––––––––––––––––––––––––––– -->
        <link rel="stylesheet" href="css/normalize.css">
        <link rel="stylesheet" href="css/skeleton.css">
    </head>
    <body>
        <h1>Inicar secion</h1>
        <br>
        <form action="IniciarSesion" method="POST">
            <div class="row">
                <div class="six colums">
                    <label>Nombre:</label>
                    <input type="text" title="Solo caracteres alfanumericos" 
                        minlength="2" maxlength="15" pattern=/[\wÁÉÚÍÓáéúíóÄËÏÜÖäëüïö ]+/
                        name="usuario" required>
                </div>
                <div class="six colums">
                        <label>Contraseña:</label>
                        <input type="password" title="Solo caracteres alfanumericos"
                            minlength="8" maxlength="30" pattern=/[^']+[^"]/ 
                            name="contra" required>
                </div>
            </div>
            <br>
            <input type="submit" class="button-primary">
        </form>
    </body>
</html>
