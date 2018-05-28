/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control_BD;

import Entidades.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Zush18
 */
public class ControlUsuarios extends Conector{
    
    public int agregarUsuario(Usuario usu, int rango){
        return this.Update("CALL anadirUsuario(?,?,?)", usu.getNewData(), usu.getAlldataType());
    }
    
    public int eleminarUsuario(Usuario usu){
        return this.Update("CALL eleminarUsuario(?)", usu.getJustData("id"), usu.getJustDataType("id"));
    }
    
    public int actulizarUsuario(Usuario usu){
        return this.Update("CALL actualizarUsuario(?,?,?,?)", usu.getAllData(), usu.getAlldataType());
    }    

    public Usuario getUsuarioSesion(Usuario usu) throws SQLException, RuntimeException{
        ResultSet rs =  this.Query("CALL getUsuarioSesion(?,?)", usu.getSesionData(), usu.getAlldataType());
        if (rs.next()) {
            usu = new Usuario(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
        }else{
            throw new RuntimeException("No hay informacion sobre usuario "+usu.getNombre());
        }
        
        return usu;
    }    
}
