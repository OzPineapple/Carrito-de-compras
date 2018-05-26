package Entidades;

/**
 *
 * @author Zush18
 */
public class Usuario {
    //<editor-fold desc="Atributos">
    private String nombre;
    private String contraseña;
    private int rango;
    private String[] datos;
    private int[] dataType;
    //</editor-fold>
    //<editor-fold desc="Constructor">
    public Usuario(){
        
    }
    //</editor-fold>
    //<editor-fold desc="Get & Set">
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getRango() {
        return rango;
    }

    public void setRango(int rango) {
        this.rango = rango;
    }
    
    //</editor-fold>

    public String[] getDatos() {
        return datos;
    }

    public void setDatos(String[] datos) {
        this.datos = datos;
    }

    public int[] getDataType() {
        return dataType;
    }

    public void setDataType(int[] dataType) {
        this.dataType = dataType;
    }
}
