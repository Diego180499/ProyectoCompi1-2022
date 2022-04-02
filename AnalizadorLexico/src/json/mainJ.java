/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 *
 * @author HP
 */
public class mainJ {
    
    public static void main(String[] args) throws Exception {

        String ruta2 = "C:/Users/HP/Desktop/Universidad/1r semestre 2022/Archivos Varios/AnalizadorLexico-Jflex1/AnalizadorLexico/src/json/LexerJson.flex";
        String[] rutaS = {"-parser", "SintaxJ", "C:/Users/HP/Desktop/Universidad/1r semestre 2022/Archivos Varios/AnalizadorLexico-Jflex1/AnalizadorLexico/src/json/SintaxJ.cup"};
        generar(ruta2, rutaS);

    }
    
    
    public static void generar(String ruta2, String[] rutaS) throws IOException, Exception {
        File archivo;
        archivo = new File(ruta2);
        JFlex.Main.generate(archivo);
        java_cup.Main.main(rutaS);

        Path rutaSym = Paths.get("C:/Users/HP/Desktop/Universidad/1r semestre 2022/Archivos Varios/AnalizadorLexico-Jflex1/AnalizadorLexico/src/json/sym.java");
        if (Files.exists(rutaSym)) {
            Files.delete(rutaSym);
        }

        Files.move(
                Paths.get("C:/Users/HP/Desktop/Universidad/1r semestre 2022/Archivos Varios/AnalizadorLexico-Jflex1/AnalizadorLexico/sym.java"),
                Paths.get("C:/Users/HP/Desktop/Universidad/1r semestre 2022/Archivos Varios/AnalizadorLexico-Jflex1/AnalizadorLexico/src/json/sym.java")
        );

        Path rutaSin = Paths.get("C:/Users/HP/Desktop/Universidad/1r semestre 2022/Archivos Varios/AnalizadorLexico-Jflex1/AnalizadorLexico/src/json/SintaxJ.java");
        if (Files.exists(rutaSin)) {
            Files.delete(rutaSin);
        }

        Files.move(
                Paths.get("C:/Users/HP/Desktop/Universidad/1r semestre 2022/Archivos Varios/AnalizadorLexico-Jflex1/AnalizadorLexico/SintaxJ.java"),
                Paths.get("C:/Users/HP/Desktop/Universidad/1r semestre 2022/Archivos Varios/AnalizadorLexico-Jflex1/AnalizadorLexico/src/json/SintaxJ.java")
        );
    }
    
}
