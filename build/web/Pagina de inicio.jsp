<%-- 
    Document   : Pagina de inicio
    Created on : 22/05/2018, 05:12:22 PM
    Author     : Alumno
--%>

<%@page import="Control_validaciones.Checador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
        
        Checador validar = new Checador();
        
        if(validar.usuario("vnsdi")){
           out.printl("h"+validar.getMensaje()); 
        }
        %>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
