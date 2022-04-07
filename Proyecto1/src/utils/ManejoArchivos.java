package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManejoArchivos {

    public static void crearArchivo(String nombre, String contenido) throws FileNotFoundException {
        File archivo = new File(nombre);
        PrintWriter pw = new PrintWriter(archivo);
        pw.print(contenido);
        pw.close();

    }

    public static void anexarArchivo(String nombre, String contenido) {

        File archivo = new File(nombre);
        PrintWriter pw;
        try {
            pw = new PrintWriter(new FileWriter(archivo, true));
            pw.println(contenido);
            pw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ManejoArchivos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManejoArchivos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static String leerArchivo(String nombreArchivo) {

        File archivo = new File(nombreArchivo);
        String contenido = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea = br.readLine();

            while (linea != null) {
                contenido += linea+"\n";
                linea = br.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ManejoArchivos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManejoArchivos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return contenido;
    }
}
