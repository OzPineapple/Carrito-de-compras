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

/**
 * Provee de todos los metodos necesarios para extraer datos de MYSQL.
 * @author Zush18
 */
abstract class Conector {
    //<editor-fold desc="Constantes">
    /**
     * <p>Usa esta constanta para indicar que el dato es un:
     * <b>String</b>
     */
    final static int DataString = 0;
    /**
     * <p>Usa esta constanta para indicar que el dato es un:
     * <b>Int</b>
     */
    final static int DataInt = 1;
    /**
     * <p>Usa esta constanta para indicar que el dato es un:
     * <b>Double</b>
     */
    final static int DataDouble = 2;
    /**
     * <p>Usa esta constanta para indicar que el dato es un:
     * <b>Float</b>
     */
    final static int DataFloat = 3;
    /**
     * <p>Usa esta constanta para indicar que el dato es un:
     * <b>Date</b>
     */
    final static int DataDate = 4;
    //</editor-fold>
    //<editor-fold desc="Credenciales">
    /**
     * Usuario de la base de datos
     */
    String username = "root";
    /**
     * Contrasaña para conectar
     */
    String password = "n0m3l0";
    /**
     * Ruta de la base de datos
     */
    String url = "jdbc:mysql:3306//localhost/proyecto";
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
        
        Connection con=null;
        
        try{
            Class.forName(driver);
            url="jdbc:mysql://localhost/proyecto";
            con=DriverManager.getConnection(url, username, password);
            
            System.out.println("Si se conecto a la BD");
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
    protected ResultSet Query(String sql){
        try(Connection con = this.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)){
            String[] datos = this.getDatos();
            int[] dataType = this.getDataType();
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
    protected int Update(String sql){
        try(Connection con = this.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)){
            String[] datos = this.getDatos();
            int[] dataType = this.getDataType();
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
            return ps.executeUpdate();
        }catch(Exception e){
            this.printErr(e);
            return -1;
        }
    }
        
    /**
     * Dentro de este metodo devuelve tus datos en un array, idependientemente 
     * de que tipo de datos sean debes convertirlos a String
     * @return 
     */
    abstract String[] getDatos();
    
    /**
     * <p>En este metodo devuelve que tipo de datos son, usando 
     * como indicador las constantes de la interfaz:
     * <ul>
     *      <li>{@link ObtnerDatos#StringData}
     *      <li>{@link ObtnerDatos#IntData}
     *      <li>{@link ObtnerDatos#DoubleData}
     *      <li>{@link ObtnerDatos#FloatData}
     *      <li>{@link ObtnerDatos#DateData}
     * </ul>
     * <p>por ejemplo
     * <pre>//Dentro de getDtatos en el String[0] colocaste un int
     *      int[0] = IntDate;
     * </pre>
     * @return 
     */
    abstract int[] getDataType();
    //</editor-fold>    

}
