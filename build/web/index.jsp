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
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="//fonts.googleapis.com/css?family=Raleway:400,300,600" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="css/normalize.css">
        <link rel="stylesheet" href="css/skeleton.css">
        <style>
            body{
                background-image: url("img/back.jpg");
            }
            header{
                background: white;
                padding: 3rem;
            }
            h1,h2{
                text-align: center;
            }
            form{
                width: 50%;
                margin: auto;
            }
        </style>
    </head>
    <body>
        <header>
            <h1>Bienvenido a la DEEPWEB</h1>
        </header>
        <br>
        <form action="IniciarSesion" method="POST">
            <div class="row">
                <div class="ten columns">
                    <h2>Inicar secion</h2>
                </div>
            </div>
            <div class="row">
                <div class="six columns">
                    <label>Nombre:</label>
                    <input type="text" title="Solo caracteres alfanumericos" 
                        minlength="2" maxlength="15" name="usuarioIn" required
                        pattern="[A-Za-zÁÉÚÍÓáéúíóÄËÏÜÖäëüïö\s]+">
                </div>
                <div class="six columns">
                        <label>Contraseña:</label>
                        <input type="password" title="Solo caracteres alfanumericos"
                            minlength="8" maxlength="30" name="contraIn" required
                            pattern="[0-9A-Za-zÁÉÚÍÓáéúíóÄËÏÜÖäëüïö\s]+">
                </div>
            </div>
            <br>
            <input type="submit" class="button-primary" value="Iniciar secion">
        </form>
        <form action="Registrar" method="POST">
            <div class="row">
                <div class="ten columns">
                    <h2>Registrate</h2>
                </div>
            </div>
            <div class="row">
                <div class="six columns">
                    <label>Nombre:</label>
                    <input type="text" title="Solo caracteres alfanumericos" 
                        minlength="2" maxlength="15" name="usuarioNew" required
                        pattern="[A-Za-zÁÉÚÍÓáéúíóÄËÏÜÖäëüïö\s]+">
                </div>
                <div class="six columns">
                        <label>Contraseña:</label>
                        <input type="password" title="Solo caracteres alfanumericos"
                            minlength="8" maxlength="30" name="contraNew" required
                            pattern="[0-9A-Za-zÁÉÚÍÓáéúíóÄËÏÜÖäëüïö\s]+">
                </div>
            </div>
            <br>
            <input type="submit" class="button-primary" value="Registrarte">
        </form>
    </body>
</html>
