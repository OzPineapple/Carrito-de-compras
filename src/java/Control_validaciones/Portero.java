/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control_validaciones;

import Entidades.Usuario;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Zush18
 */
public class Portero {

    public Portero(HttpServletRequest request, HttpServletResponse response, int rango) throws IOException {
        try{    
            Usuario usu = (Usuario) request.getAttribute("usuario");
            if(usu == null){
                response.sendRedirect("index.jsp");
                return;
            }
            if(usu.getRango() < rango){
                response.sendError(403);
            }
        }catch(Exception e){
            System.out.println("E R R O R");
            System.out.println(e.getMessage());
            response.sendError(500);
        }
    }
    
}
