package codigo;

import java.util.ArrayList;

public class Variable {

    private String visibilidad;
    private String tipo;
    private String nombre;
    private String funcionPadre;
    private String rol;
    private int aparicion;
    private ArrayList<String> funcionesAparecidas;

    public Variable(String tipo, String nombre) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.aparicion = 1;
        this.funcionesAparecidas = new ArrayList<>();
    }

    public Variable(String tipo, String nombre, String funcionPadre, String rol) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.funcionPadre = funcionPadre;
        this.rol = rol;
        this.aparicion = 1;
        this.funcionesAparecidas = new ArrayList<>();
    }

    public Variable(String visibilidad, String tipo, String nombre, String funcionPadre, String rol) {
        this.visibilidad = visibilidad;
        this.tipo = tipo;
        this.nombre = nombre;
        this.funcionPadre = funcionPadre;
        this.rol = rol;
        this.aparicion = 1;
        this.funcionesAparecidas = new ArrayList<>();
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFuncionPadre() {
        return funcionPadre;
    }

    public void setFuncionPadre(String funcionPadre) {
        this.funcionPadre = funcionPadre;
    }

    public String getVisibilidad() {
        return visibilidad;
    }

    public void setVisibilidad(String visibilidad) {
        this.visibilidad = visibilidad;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getAparicion() {
        return aparicion;
    }

    public void setAparicion(int aparicion) {
        this.aparicion = aparicion;
    }

    public ArrayList<String> getFuncionesAparecidas() {
        return funcionesAparecidas;
    }

    public void setFuncionesAparecidas(ArrayList<String> funcionesAparecidas) {
        this.funcionesAparecidas = funcionesAparecidas;
    }

    public void agregarFuncion(String metodo) {
        this.funcionesAparecidas.add(metodo);
    }

}
