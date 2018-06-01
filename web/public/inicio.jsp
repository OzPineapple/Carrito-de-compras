<%-- 
    Document   : inicio.jsp
    Created on : 30/05/2018, 04:38:06 PM
    Author     : Zush18
--%>

<%@page import="Entidades.Usuario"%>
<%@page import="Control_validaciones.Portero"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="//fonts.googleapis.com/css?family=Raleway:400,300,600" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="css/normalize.css">
        <link rel="stylesheet" href="css/skeleton.css">
        <link rel="stylesheet" href="css/api.css"/>
        <title>DEEPWEB</title>
        <%
        Portero por = new Portero(request,response,0);
        Usuario usu = (Usuario) request.getAttribute("usuario");
        %>
    </head>
    <body>
        <header class="all columns">
            <h1>Bienvenido <%=usu.getNombre() %></h1> 
            <br>
            <div class="menu">
                <button class="button-primary">Inicio</button>
                <button class="button-primary">Tienda</button>
                <button class="button-primary">Configuración</button>
                <%
                if(usu.getRango() == 1){
                %>
                <a href="/Carrito-de-compras/public/admin/editUsers.jsp" class="button">Admin users</a>
                <%}
                %>
                <a href="cerrar" class="button">Cerrar</a>
            </div>
        </header>
        <div class="navegar">
            <div class="go" style="background: #6699ff; text-align: center">
                I N I C I O
            </div>
            <div class="go" style="background: #66ff66; text-align: center">
                T I E N D A
            </div>
            <div class="go" style="background: #ff66ff; text-align: center">
                C O N F I G U R A C I Ó N
            </div>
            <%
            if(usu.getRango() == 1){
                %><div class="six columns, go" style="background: #ffff66; text-align: center">
                    A D M I N &nbsp; U S U E R S
                </div><%
            }
            %>
        </div>
    </body>
</html>
