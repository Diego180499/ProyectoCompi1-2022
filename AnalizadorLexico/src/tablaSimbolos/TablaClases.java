package tablaSimbolos;

import codigo.Clase;
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
        if(clases.isEmpty()){
            return false;
        }
        for (int i = 0; i < clases.size(); i++) {
            if (clase.getNombreClase().equals(clases.get(i).getNombreClase())) {
                int aparicionActual = clases.get(i).getAparicion();
                clases.get(i).setAparicion(aparicionActual+1);
                return true;
            }
        }
        return false;
    }

}
