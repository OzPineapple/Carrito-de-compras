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
    String url = "jdbc:mysql:3306//localhost/TiendaDeepWeb";
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
    private void printErr(Exception e){
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
    private Connection getConnection(){
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
     * Hace una consulta a la base de datos atravez de una sentencia SQL
     * @param sql
     * @return ResultSet Resultado
     */
    protected ResultSet Query(String sql, String[] datos, int[] dataType){
        try(Connection con = this.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)){
            this.insertData(ps, datos, dataType);
            return ps.executeQuery();
        }catch(Exception e){
            this.printErr(e);
            return null;
        }
    }
    /**
     * Actuliza  la base de datos atrvez de una base de datos a travez de una
     * sentencia SQL
     * @param sql
     * @return 
     */
    protected int Update(String sql, String[] datos, int[] dataType){
        try(Connection con = this.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)){
            this.insertData(ps, datos, dataType);
            return ps.executeUpdate();
        }catch(Exception e){
            this.printErr(e);
            return -1;
        }
    }
    /**
     * Inserta los datos en el PS para ahorrar lineas
     * @param ps
     * @param datos
     * @param dataType
     * @throws SQLException 
     */
    private void insertData(PreparedStatement ps, String[] datos, int[] dataType) throws SQLException{
        for (int i = 0; i < datos.length; i++) {
            switch(dataType[i]){
                case DataString:
                    ps.setString(i, datos[i]);
                break;
                case DataInt:
                    ps.setInt(i, Integer.parseInt(datos[i]));
                break;
                case DataDouble:
                    ps.setDouble(i, Double.parseDouble(datos[i]));
                break;
                case DataFloat:
                    ps.setFloat(i, Float.parseFloat(datos[i]));
                break;
                case DataDate:
                    ps.setDate(i, Date.valueOf(datos[i]));
                break;
            }
        }
    }
    //</editor-fold>    

}

