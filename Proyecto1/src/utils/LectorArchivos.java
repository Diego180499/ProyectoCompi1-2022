package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LectorArchivos extends Thread {

    private final String EXTENSION_A_BUSCAR = ".java";
    private final int DELAY = 1500;

    private String directorioCarpetaAExaminar = "";
    private boolean encendido = true;
    private ArrayList<String> archivosJava;

    public LectorArchivos(String dir) {
        directorioCarpetaAExaminar = dir;
        archivosJava = new ArrayList<>();
    }

    @Override
    public void run() {

        File dir = new File(directorioCarpetaAExaminar);
        while (encendido) {

            File[] files = dir.listFiles(new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    return name.toLowerCase().endsWith(".java");
                }
            });
            System.out.println("se encontraron" + files.length + " archivos java");
            for (int i = 0; i < files.length; i++) {
                File file = files[i];
                System.out.println(file);
                System.out.println("***CONTENIDO***");
                archivosJava.add(leerArchivo(file));
                System.out.println("***FIN DE LECTURA***");
                if ((i + 1) == files.length) {
                    encendido = false;
                }
            }
            if (files.length == 0) {
                System.out.println("El directorio no contiene extensiones de tipo '" + EXTENSION_A_BUSCAR + "'");
            }

            System.out.println("--");

            try {
                sleep(DELAY);
            } catch (InterruptedException ex) {
                Logger.getLogger(LectorArchivos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public String leerArchivo(File archivo) {

        String contenido = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea = br.readLine();

            while (linea != null) {
                contenido += linea + "\n";
                linea = br.readLine();
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return contenido;
    }

    public void setDirectorioABuscar(String dir) {

        this.directorioCarpetaAExaminar = dir;
    }

    public void apagar_encender_thread() {
        this.encendido = !encendido;
    }

    public ArrayList<String> getArchivosJava() {
        return archivosJava;
    }
    
    

}
