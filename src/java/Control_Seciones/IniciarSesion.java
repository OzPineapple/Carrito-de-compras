/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control_Seciones;

import Control_BD.ControlUsuarios;
import Control_validaciones.Checador;
import Entidades.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alumno
 */
public class IniciarSesion extends HttpServlet {
/**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        String usuario = null;
        String contraseña = null;
        try{
            usuario =  request.getParameter("usuario");
            contraseña = request.getParameter("contra");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        Checador validar =  new Checador();
        ControlUsuarios cu = new ControlUsuarios();
        Usuario usu = new Usuario(usuario, contraseña);
        if(validar.usuario(usuario)){
            response.sendError(401, "Usuario "+validar.getMensaje());
        }
        if(validar.contraseña(contraseña)){
            response.sendError(401,"Contraseña "+validar.getMensaje());
        }
        try {
            usu = cu.getUsuarioSesion(usu);
        } catch (SQLException | RuntimeException ex) {
            response.sendError(502, "MYSQL error revisar consola");
        }


    }
}
