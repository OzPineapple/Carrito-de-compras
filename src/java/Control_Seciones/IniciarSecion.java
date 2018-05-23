package Control_Seciones;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Control_validaciones.Checador;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alumno
 */
public class IniciarSecion extends HttpServlet {
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

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
        String usuario =  request.getParameter("usuario");
        String contraseña = request.getParameter("contra");

        Checador validar =  new Checador();

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            if(validar.usuario(usuario)){
                out.println("<h1>Usuario "+validar.getMensaje()+"</h1>");
            }
            if(validar.contraseña(contraseña)){
                out.println("<h1>Contraseña "+validar.getMensaje()+"</h1>");
            }
            if(!validar.usuario(usuario) && !validar.contraseña(contraseña)){
                out.println("<h1>Campos validos</h1>");
            }
            out.println("</body>");
            out.println("</html>");

        }

    }
}