package reporte;

import codigo.Clase;
import codigo.Funcion;
import codigo.Variable;
import java.util.ArrayList;

public class ReporteJSON {

    String reporteTotal;
    String reporteClases;
    String reporteVariables;
    String reporteMetodos;

    public ReporteJSON() {
        reporteTotal = "";
        reporteClases = "";
        reporteVariables = "";
        reporteMetodos = "";
    }

    public void agregarReporteClase(ArrayList<Clase> clases) {

        int cantidadRepetidas = 0;
        ArrayList<Clase> clasesRepetidas = new ArrayList<>();

        for (int i = 0; i < clases.size(); i++) {
            if (clases.get(i).getAparicion() > 1) {
                clasesRepetidas.add(clases.get(i));
                cantidadRepetidas++;
            }
        }

        reporteClases = "Clases:[\n";

        for (int i = 0; i < clasesRepetidas.size(); i++) {
            if (i == clasesRepetidas.size() - 1) {
                reporteClases += "{Nombre: \"" + clasesRepetidas.get(i).getNombreClase() + "\"}\n";
            } else {
                reporteClases += "{Nombre: \"" + clasesRepetidas.get(i).getNombreClase() + "\" },\n";
            }

        }

        reporteClases += "],\n";

    }

    public void reporteVariables(ArrayList<Variable> variables) {

        reporteVariables += "Variables:[\n";

        for (int i = 0; i < variables.size(); i++) {

            if (variables.get(i).getAparicion() > 1) {
                String funciones = "\"" + variables.get(i).getFuncionPadre() + ",";
                for (int j = 0; j < variables.get(i).getFuncionesAparecidas().size(); j++) {
                    if (j == variables.get(i).getFuncionesAparecidas().size() - 1) {
                        funciones += variables.get(i).getFuncionesAparecidas().get(j) + "\"}";
                    } else {
                        funciones += variables.get(i).getFuncionesAparecidas().get(j) + ",";
                    }
                }
                reporteVariables += "{Nombre: \"" + variables.get(i).getNombre() + "\" , Tipo: \"" + variables.get(i).getTipo()
                        + "\" , Funcion: " + funciones;
            }

            if (i == variables.size() - 1) {
                reporteVariables += "\n ],\n";
            } else if (variables.get(i + 1).getAparicion() > 1) {
                reporteVariables += ",\n";
            }
        }

    }

    public void generarReporteMetodos(ArrayList<Funcion> metodos) {

        reporteMetodos += "Metodos:[\n";

        for (int i = 0; i < metodos.size(); i++) {
            if (metodos.get(i).getAparicion() > 1) {
                reporteMetodos += "{Nombre: \"" + metodos.get(i).getNombre()
                        + "\", Tipo: \"" + metodos.get(i).getTipo()
                        + "\", Parametros: \"" + metodos.get(i).getParametros().size() + "\" }";
            }

            if (i == metodos.size() - 1) {
                reporteMetodos += "\n ]";
            } else if (metodos.get(i + 1).getAparicion() > 1) {
                reporteMetodos += ",\n";
            }

        }

    }

    public void generarReporteTotal() {

        reporteTotal += "{\n" + this.reporteClases + this.reporteVariables + this.reporteMetodos + "\n }";

    }

    public String getReporteTotal() {
        return reporteTotal;
    }

}
