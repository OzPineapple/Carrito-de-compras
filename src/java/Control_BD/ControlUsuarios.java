/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control_BD;

import Entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Zush18
 */
public class ControlUsuarios extends Conector{
    
    public int agregarUsuario(Usuario usu, int rango){
        return this.Update("CALL anadirUsuario('"+usu.getNombre()+"','"+usu.getContraseña()+"',"+rango+");");
    }
    
    public int eleminarUsuario(Usuario usu){
        throw new RuntimeException("no programado aun");
    }
    
    public int actulizarUsuario(Usuario usu){
        throw new RuntimeException("no programado aun");
    }    

    public Usuario getUsuarioSesion(Usuario usu) throws SQLException{
        Connection con = this.getConnection();
        PreparedStatement ps = con.prepareStatement("CALL getUsuarioSesion('"+usu.getNombre()+"','"+usu.getContraseña()+"');");
        ResultSet rs = ps.executeQuery();
        
        if(rs.next()){
            if (rs.getString("Contrasena").equals(usu.getContraseña())) {
                return new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }else{
                throw new RuntimeException("Contraseña incorrecta");
            }
        }else{
            throw new RuntimeException("No existe ese usuario");
        }
    }    
}
