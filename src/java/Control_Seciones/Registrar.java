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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Zush18
 */
public class Registrar extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        try(PrintWriter out = response.getWriter()){
            
        }
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
            Checador validar = new Checador();
            ControlUsuarios cu = new ControlUsuarios();
            String nom = null;
            String contra = null;
            try{
                nom = request.getParameter("usuarioNew");
                contra = request.getParameter("contraNew");
            }catch(Exception e){
                System.out.println("Error "+e.getMessage());
            }
            if(validar.usuario(nom)){
                request.setAttribute("Mensaje", "Usuario "+validar.getMensaje());
                request.getRequestDispatcher("err/401.jsp").forward(request, response);
                return;
            }
            if(validar.contraseña(contra)){
                request.setAttribute("Mensaje", "Usuario "+validar.getMensaje());
                request.getRequestDispatcher("err/401.jsp").forward(request, response);
                return;
            }
            Usuario usu = new Usuario(nom, contra);
            int agregarUsuario = 0;
            try{
                agregarUsuario = cu.agregarUsuario(usu, 0);

            }catch(Exception e){
                request.setAttribute("Mensaje", e.getMessage());
                request.getRequestDispatcher("/err/401.jsp").forward(request, response);
                return;
            }
            if(agregarUsuario > 0){
                request.setAttribute("Mensaje", "Usuario registrado");
                request.getRequestDispatcher("/public/201.jsp").forward(request, response);
            }else{
                response.sendError(502,"No rows afected");
            }
        }
    }

