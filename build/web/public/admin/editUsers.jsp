<%-- 
    Document   : editUsers
    Created on : 30/05/2018, 08:22:58 PM
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
        <%response.sendError(418);%>
        <%--<%
        Portero por = new Portero(request,response,1);
        Usuario usu = (Usuario) request.getAttribute("usuario");
        %>
        <title>DEEPWEB</title>
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
                %><a href="/public/admin/editUsers.jsp">
                            <button class="button-primary">Administrar usuarios</button>
                        </a><%
                    }
                %>
                <button class="button-primary">Salir</button>
            </div>
        </header>
        
    </body>
</html>
--%>