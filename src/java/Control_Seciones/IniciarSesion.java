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
import java.sql.SQLException;
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
            usuario =  request.getParameter("usuarioIn");
            contraseña = request.getParameter("contraIn");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        Checador validar =  new Checador();
        ControlUsuarios cu = new ControlUsuarios();
        Usuario usu = new Usuario(usuario, contraseña);
        if(validar.usuario(usuario)){
            request.setAttribute("Mensaje", "Usuario "+validar.getMensaje());
            request.getRequestDispatcher("err/401.jsp").forward(request, response);
            return;
        }
        if(validar.contraseña(contraseña)){
            request.setAttribute("Mensaje", "Usuario "+validar.getMensaje());
            request.getRequestDispatcher("err/401.jsp").forward(request, response);
            return;
        }
        
        try {
            usu = cu.getUsuarioSesion(usu);
        } catch (SQLException e) {
            response.sendError(502, "MYSQL error revisar consola "+e.getMessage());
            return;
        } catch(RuntimeException e){
            System.out.println(e.getMessage());
            request.setAttribute("Mensaje", e.getMessage());
            request.getRequestDispatcher("err/401.jsp").forward(request, response);
            return;
        }
        request.setAttribute("Mensaje", "Todo ok"+usu.getNombre()+usu.getContraseña());
        request.getRequestDispatcher("public/200.jsp").forward(request, response);

    }
}
