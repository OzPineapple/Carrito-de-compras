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
import java.util.ArrayList;

/**
 *
 * @author Zush18
 */
public class ControlUsuarios extends Conector{
    
    public int agregarUsuario(Usuario usu, int rango){
        int i = this.Update("CALL anadirUsuario('"+usu.getNombre()+"','"+usu.getContraseña()+"',"+rango+");");
        if(i == -1){
            throw new RuntimeException("Ese usuario ya existe");
        }
        return i;
    }
    
    public int eleminarUsuario(Usuario usu){
        throw new RuntimeException("no programado aun");
    }
    
    public int actulizarUsuario(Usuario usu){
        throw new RuntimeException("no programado aun");
    }    

    public Usuario getUsuarioSesion(Usuario usu) throws SQLException{
        ResultSet rs = null;
        try{
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement("CALL getUsuarioSesion('"+usu.getNombre()+"','"+usu.getContraseña()+"');");
            rs = ps.executeQuery();
        }catch(Exception e){
            this.printErr(e);
        }
        
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
    public ArrayList<Usuario> getAllUsuarios(){
        ResultSet rs = null;
        ArrayList<Usuario> usu = new ArrayList();
        try{
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement("CALL getAllUsuario();");
            rs = ps.executeQuery();
            while(rs.next()){
                usu.add(new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
            }
        }catch(Exception e){
            this.printErr(e);
        }
        if(rs == null || usu.isEmpty()){
            throw new RuntimeException("No hay registros . . . espera khe? :v");
        }
        return usu;
    }
}
