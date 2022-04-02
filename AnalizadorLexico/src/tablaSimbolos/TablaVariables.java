package tablaSimbolos;

import codigo.Variable;
import java.util.ArrayList;

public class TablaVariables {

    private ArrayList<Variable> variables;

    public TablaVariables() {

        this.variables = new ArrayList<>();
    }

    public ArrayList<Variable> getVariables() {
        return variables;
    }

    public void agregarVariable(Variable variable) {

        if (!seRepite(variable)) {
            variables.add(variable);
        }

    }

    public boolean seRepite(Variable variable) {

        if (variables.isEmpty()) {
            return false;
        }

        for (int i = 0; i < variables.size(); i++) {
            if (variables.get(i).getNombre().equals(variable.getNombre())) {
                if (variables.get(i).getTipo().equals(variable.getTipo())) {
                    int aparicionActual = variables.get(i).getAparicion();
                    int aparicionActualizada = aparicionActual + 1;
                    variables.get(i).getFuncionesAparecidas().add(variable.getFuncionPadre());
                    variables.get(i).setAparicion(aparicionActualizada);
                    return true;
                }
            }
        }

        return false;
    }

}
