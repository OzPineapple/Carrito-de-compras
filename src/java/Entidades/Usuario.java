package Entidades;

/**
 *
 * @author Zush18
 */
public class Usuario implements Control_BD.DataType{
    
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
    
    //</editor-fold>
    
    //<editor-fold desc="Metedos de datos">
    public String[] getAllData(){
        datos = new String[3];
        datos[0] = String.valueOf(this.id);
        datos[1] = this.nombre; 
        datos[2] = this.contraseña; 
        datos[3] = String.valueOf(this.rango); 
        return datos;
    }
    public int[] getAlldataType(){
        dataType = new int[3];
        dataType[0] = DataInt;
        dataType[1] = DataString;
        dataType[2] = DataString;
        dataType[3] = DataInt;
        return dataType;
    }
    public String[] getNewData(){
        datos = new String[3];
        datos[0] = nombre; 
        datos[1] = contraseña; 
        datos[2] = String.valueOf(rango); 
        return datos;
    }
    public int[] getNewdataType(){
        dataType = new int[3];
        dataType[0] = DataString;
        dataType[1] = DataString;
        dataType[2] = DataInt;
        return dataType;
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

    public void setDataType(int[] dataType) {
        this.dataType = dataType;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    //</editor-fold>

}
