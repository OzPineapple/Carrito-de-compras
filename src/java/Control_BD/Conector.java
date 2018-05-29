/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control_BD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Provee de todos los metodos necesarios para extraer datos de MYSQL.
 * @author Zush18
 */
public class Conector implements DataType{

    //<editor-fold desc="Credenciales">
    /**
     * Usuario de la base de datos
     */
    String username = "CajeroDeepWeb";
    /**
     * Contrasaña para conectar
     */
    String password = "d33pw33b";
    /**
     * Ruta de la base de datos
     */
    String url = "jdbc:mysql://localhost:3306/TiendaDeepWeb";
    /**
     * Driver de MYSQL para conectar
     */
    String driver = "com.mysql.jdbc.Driver";
    //</editor-fold>

    //<editor-fold desc="Metodos de conexion">
    /**
     * Imprime el error en consola
     * @param e 
     */
    protected void printErr(Exception e){
        System.out.println("E R R O R :"+e.getMessage());
        StackTraceElement[] errores = e.getStackTrace();
        for(StackTraceElement err : errores){
            System.out.println(err.getMethodName()+"  :  "+err.getLineNumber() +" < F I L E > "+err.getFileName());
        }
        System.out.println("E R R O R :"+e.getMessage());
    }
    /**
     * Se conecta a la base de datos de MYSQL
     * @return Connection Objeto de conexion MYSQL 
     */
    protected Connection getConnection(){
        Connection con = null;
        try{
            Class.forName(driver);
            con=DriverManager.getConnection(url, username, password);
        }catch(Exception e){
            this.printErr(e);
        }
        return con;
    }
    /**
     * Actuliza  la base de datos atrvez de una base de datos a travez de una
     * sentencia SQL
     * @param sql
     * @return 
     */
    protected int Update(String sql){
        try(Connection con = this.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)){
            return ps.executeUpdate();
        }catch(Exception e){
            this.printErr(e);
            return -1;
        }
    }
    //</editor-fold>    

}

