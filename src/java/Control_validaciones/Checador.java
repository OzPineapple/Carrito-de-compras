
package Control_validaciones;

/**
 *
 * @author Zush18
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Checador {
    
    //<editor-fold desc="Atrubutos">
    private String mensaje;
    private Pattern p;
    private Matcher m;
    //</editor-fold>
    
    //<editor-fold desc="REGEX">
    private String vocalesEspañol = "ÁÉÚÍÓáéúíóÄËÏÜÖäëüïö";
    private String numInt = "[\\d]+";
    private String numFloat = "[0-9]+([\\.][0-9]+)?";
    private String texto = "[\\w"+this.vocalesEspañol+" ]+";
    private String alfabeto = "[A-Za-z"+this.vocalesEspañol+" ]+";
    private String correo = "("+texto+"\\.?)+\\@("+texto+"\\.?)+\\."+texto+"";
    //</editor-fold>
    
    //<editor-fold desc="Metodos publicos">
    public boolean usuario(String var){
        if(this.estaMalLongitud(var, 2, 15))return false;
        if(this.noEsAlfabetico(var))return false;
        return true;
    }
    public boolean contraseña(String var){
        if(this.estaMalLongitud(var, 8, 30)) return false;
        if(this.noEsAlfanumerico(var)) return false;
        return true;
    }
    //</editor-fold>
    
    //<editor-fold desc="Metodos privados">
    private boolean noEsAlfanumerico(String var){
        if(!this.RegexMatch(texto, var)){
            this.mensaje = "no es alfanumerico";
            return true;
        }
        return false;
    }
    private boolean noEsUnCorreo(String var){
        if(!this.RegexMatch(correo, var)){
            this.mensaje = "no es un correo";
            return true;
        }
        return false;
    }
    private boolean estaVacio(String var){
        if(var.trim()!=null || var != null){
            this.mensaje = "esta vacio";
            return true;
        }
        return false;
    }
    private boolean estaMalLongitud(String var,int min,int max){
        if(!this.RegexMatch(".{"+min+","+max+"}", var)){
            this.mensaje = "no puede tener longitud menor a "+min+" o mayor a "+max;
            return true;
        }
        return true;
    }
    private boolean noEsUnNumeroEntero(String var){
        if(!this.RegexMatch(this.numInt, var)){
            this.mensaje = "no es un número entero";
            return true;
        }
        return false;
    }
    private boolean noEsUnNumeroDecimal(String var){
        if(!this.RegexMatch(this.numFloat, var)){
            this.mensaje = "no es un número decimal";
            return true;
        }
        return false;
    }
    private boolean noEsAlfabetico(String var){
        if(!this.RegexMatch(this.alfabeto, var)){
            this.mensaje = "no contiene solamente caracteres alfabeticos";
            return true;
        }
        return false;
    }
    //</editor-fold>

    //<editor-fold desc="REGEXmethod">
    private boolean RegexMatch(String regex, String var){
        p = Pattern.compile(regex);
        m = p.matcher(var);
        return m.matches();
    }
    private boolean RegexFind(String regex, String var){
        p = Pattern.compile(regex);
        m = p.matcher(var);
        return m.find();
    }
    //</editor-fold>
    
    //<editor-fold desc="Get & Set">
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    //</editor-fold>
}
