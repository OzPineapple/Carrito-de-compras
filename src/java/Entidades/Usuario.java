package Entidades;

/**
 *
 * @author Zush18
 */
public class Usuario{
    
    //<editor-fold desc="Atributos">
    private int id;
    private String nombre;
    private String contraseña;
    private int rango;
    private String[] datos;
    private int[] dataType;
    //</editor-fold>
    
    //<editor-fold desc="Constructor">
    public Usuario(int id, String nombre, String contraseña, int rango) {
        this.id = id;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.rango = rango;
    }

    public Usuario(String nombre, String contraseña, int rango) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.rango = rango;
    }

    public Usuario(String nombre, String contraseña) {
        this.nombre = nombre;
        this.contraseña = contraseña;
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

    public String[] getDatos() {
        return datos;
    }

    public void setDatos(String[] datos) {
        this.datos = datos;
    }

    public int[] getDataType() {
        return dataType;
    }

   public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    //</editor-fold>

}
