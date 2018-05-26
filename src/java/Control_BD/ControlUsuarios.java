/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control_BD;

import Entidades.Usuario;

/**
 *
 * @author Zush18
 */
public class ControlUsuarios extends Conector{
    
    public void agregarUsuario(Usuario usu, int rango){
        this.Update("CALL añadirUsuario(?,?,?)", usu.getNewData(), usu.getAlldataType());
    }
    
    public void eleminarUsuario(int id){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void actulizarUsuario(int id){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    

    public void getUsuario(int id){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
}
