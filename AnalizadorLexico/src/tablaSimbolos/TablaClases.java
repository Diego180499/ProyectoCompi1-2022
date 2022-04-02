package tablaSimbolos;

import codigo.Clase;
import codigo.Variable;
import java.util.ArrayList;

public class TablaClases {

    private ArrayList<Clase> clases;

    public TablaClases() {
        clases = new ArrayList<>();
    }

    public ArrayList<Clase> getClases() {
        return clases;
    }

    public void agregarClase(Clase clase) {

        if (!seRepite(clase)) {
            clases.add(clase);
        }

    }

    public boolean seRepite(Clase clase) {
        if (clases.isEmpty()) {
            return false;
        }
        for (int i = 0; i < clases.size(); i++) {
            if (clase.getNombreClase().equals(clases.get(i).getNombreClase())) {
                if (seRepitenVariables(clases.get(i).getVariables(), clase.getVariables())) {
                    int aparicionActual = clases.get(i).getAparicion();
                    clases.get(i).setAparicion(aparicionActual + 1);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean seRepitenVariables(ArrayList<Variable> variables1, ArrayList<Variable> variables2) {
        if (variables1.isEmpty() || variables2.isEmpty()) {
            return false;
        }

        if (variables1.size() != variables2.size()) {
            return false;
        }

        int cantidadRepetidas = 0;
        for (int i = 0; i < variables1.size(); i++) {
            if (variables1.get(i).getNombre().equals(variables2.get(i).getNombre())) {
                cantidadRepetidas++;
            }
        }

        if (cantidadRepetidas == variables1.size()) {
            return true;
        }

        return false;
    }

}
