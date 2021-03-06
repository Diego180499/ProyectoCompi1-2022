package codigo;

import java.util.ArrayList;

public class Funcion {

    private String tipo;
    private String nombre;
    private int cantidadParametros;
    private ArrayList<Variable> parametros;
    private ArrayList<Variable> variables;
    private String funciones;
    private String cantidad_parametros;
    private int aparicion;

    public Funcion(String tipo, String nombre, ArrayList<Variable> parametros) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.aparicion = 1;
        this.parametros = parametros;
    }

    public Funcion(String tipo, String nombre, String funciones) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.funciones = funciones;
    }

    public Funcion(String tipo, String nombre) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.aparicion = 1;
        this.parametros = new ArrayList<>();
        this.cantidad_parametros = "";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Variable> getVariables() {
        return variables;
    }

    public void setVariables(ArrayList<Variable> variables) {
        this.variables = variables;
    }

    public int getCantidadParametros() {
        return cantidadParametros;
    }

    public void setCantidadParametros(int cantidadParametros) {
        this.cantidadParametros = cantidadParametros;
    }

    public ArrayList<Variable> getParametros() {
        return parametros;
    }

    public void setParametros(ArrayList<Variable> parametros) {
        this.parametros = parametros;
    }

    public int getAparicion() {
        return aparicion;
    }

    public void setAparicion(int aparicion) {
        this.aparicion = aparicion;
    }

    public String getTipo() {
        return tipo;
    }

    public String getCantidad_parametros() {
        return cantidad_parametros;
    }

    public void setCantidad_parametros(String cantidad_parametros) {
        this.cantidad_parametros = cantidad_parametros;
    }
    
    

}
