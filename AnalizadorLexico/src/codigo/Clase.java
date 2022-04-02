package codigo;

import java.util.ArrayList;

public class Clase {

    private String visibilidad;
    private String definicion; //class - esta palabra es la definicion de una clase
    private String nombreClase;
    private String[] parametros; //esto es opcional, ya que pueden haber clases sin parametros
    private ArrayList<Variable> variables;
    private int aparicion;

    public Clase() {
    }

    public Clase(String nombreClase) {
        this.nombreClase = nombreClase;
        this.aparicion = 1;
        this.variables = new ArrayList<>();
    }

    public String getVisibilidad() {
        return visibilidad;
    }

    public void setVisibilidad(String visibilidad) {
        this.visibilidad = visibilidad;
    }

    public String getDefinicion() {
        return definicion;
    }

    public void setDefinicion(String definicion) {
        this.definicion = definicion;
    }

    public String getNombreClase() {
        return nombreClase;
    }

    public void setNombreClase(String nombreClase) {
        this.nombreClase = nombreClase;
    }

    public String[] getParametros() {
        return parametros;
    }

    public void setParametros(String[] parametros) {
        this.parametros = parametros;
    }

    public int getAparicion() {
        return aparicion;
    }

    public void setAparicion(int aparicion) {
        this.aparicion = aparicion;
    }

    public ArrayList<Variable> getVariables() {
        return variables;
    }

    public void setVariables(ArrayList<Variable> variables) {
        this.variables = variables;
    }
    
    

}
