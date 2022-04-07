package tablaSimbolos;

import codigo.Funcion;
import java.util.ArrayList;

public class TablaMetodos {

    private ArrayList<Funcion> metodos;

    public TablaMetodos() {
        metodos = new ArrayList<>();
    }

    public ArrayList<Funcion> getMetodos() {
        return metodos;
    }

    public void agregarMetodo(Funcion metodo) {

        if (!seRepite(metodo)) {
            this.metodos.add(metodo);
        }

    }

    public boolean seRepite(Funcion metodo) {

        if (this.metodos.isEmpty()) {
            return false;
        }

        for (int i = 0; i < metodos.size(); i++) {
            if (this.metodos.get(i).getNombre().equals(metodo.getNombre())) {
                if (seRepitenParametros(metodo, this.metodos.get(i))) {
                    int aparicionActual = this.metodos.get(i).getAparicion();
                    int aparicionActualizada = aparicionActual + 1;
                    this.metodos.get(i).setAparicion(aparicionActualizada);
                    return true;
                }
            }
        }

        return false;
    }

    public boolean seRepitenParametros(Funcion metodo1, Funcion metodo2) {
        if (metodo1.getParametros().isEmpty() | metodo2.getParametros().isEmpty()) {
            return false;
        }
        int totalParametros = metodo1.getParametros().size();
        int parametrosRepetidos = 0;

        for (int i = 0; i < metodo1.getParametros().size(); i++) {
            for (int j = 0; j < metodo2.getParametros().size(); j++) {
                if (metodo1.getParametros().get(i).getNombre().equals(metodo2.getParametros().get(j).getNombre())) {
                    parametrosRepetidos++;
                }
            }

        }

        if (parametrosRepetidos == totalParametros) {
            return true;
        }

        return false;

    }
    
    
    

}
