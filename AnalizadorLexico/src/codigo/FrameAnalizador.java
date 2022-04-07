/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import json.LexerJson;
import reporte.ReporteJSON;
import tablaSimbolos.TablaClases;
import tablaSimbolos.TablaMetodos;
import tablaSimbolos.TablaVariables;
import json.SintaxJ;
import utils.LectorArchivos;

/**
 *
 * @author HP
 */
public class FrameAnalizador extends javax.swing.JFrame implements Runnable {

    private TablaClases tablaClases;
    private TablaVariables tablaVariables;
    private TablaMetodos tablaMetodos;
    private String rutaCarpeta1;
    private String rutaCarpeta2;
    private ArrayList<Clase> clasesJSON;
    private ArrayList<Variable> variablesJSON;
    private ArrayList<Funcion> funcionesJSON;
    private ArrayList<String> erroresJson;

    /**
     * Creates new form FrameAnalizador
     */
    public FrameAnalizador() {
        initComponents();
        tablaClases = new TablaClases();
        tablaMetodos = new TablaMetodos();
        tablaVariables = new TablaVariables();
        rutaCarpeta1 = "";
        rutaCarpeta2 = "";
        clasesJSON = new ArrayList<>();
        variablesJSON = new ArrayList<>();
        funcionesJSON = new ArrayList<>();
        erroresJson = new ArrayList<>();
        Thread miHilo = new Thread(this);
        miHilo.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        botonAnalizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        reporteJSON = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        pathCarpeta1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        botonExaminarCarpeta1 = new javax.swing.JButton();
        pathCarpeta2 = new javax.swing.JTextField();
        botonExaminarCarpeta2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        botonVerClases = new javax.swing.JButton();
        botonVerVariables = new javax.swing.JButton();
        botonVerMetodos = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        resultadosJSON = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        botonVerErrores = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        guardarJSON = new javax.swing.JMenuItem();
        abrirJSON = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        botonAnalizar.setBackground(new java.awt.Color(0, 153, 51));
        botonAnalizar.setForeground(new java.awt.Color(0, 0, 0));
        botonAnalizar.setText("ENVIAR ARCHIVOS");
        botonAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAnalizarActionPerformed(evt);
            }
        });

        reporteJSON.setBackground(new java.awt.Color(51, 51, 51));
        reporteJSON.setColumns(20);
        reporteJSON.setForeground(new java.awt.Color(255, 255, 255));
        reporteJSON.setRows(5);
        jScrollPane1.setViewportView(reporteJSON);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("VISTA  DE  REPORTE  JSON");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CARPETA 1");

        botonExaminarCarpeta1.setBackground(new java.awt.Color(0, 51, 153));
        botonExaminarCarpeta1.setForeground(new java.awt.Color(255, 255, 255));
        botonExaminarCarpeta1.setText("CARGAR CARPETA");
        botonExaminarCarpeta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonExaminarCarpeta1ActionPerformed(evt);
            }
        });

        botonExaminarCarpeta2.setBackground(new java.awt.Color(0, 51, 153));
        botonExaminarCarpeta2.setForeground(new java.awt.Color(255, 255, 255));
        botonExaminarCarpeta2.setText("CARGAR CARPETA");
        botonExaminarCarpeta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonExaminarCarpeta2ActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("CARPETA 2");

        botonVerClases.setBackground(new java.awt.Color(204, 0, 51));
        botonVerClases.setText("Ver Clases");
        botonVerClases.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVerClasesActionPerformed(evt);
            }
        });

        botonVerVariables.setBackground(new java.awt.Color(204, 0, 51));
        botonVerVariables.setText("Ver Variables");
        botonVerVariables.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVerVariablesActionPerformed(evt);
            }
        });

        botonVerMetodos.setBackground(new java.awt.Color(204, 0, 51));
        botonVerMetodos.setText("Ver Métodos");
        botonVerMetodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVerMetodosActionPerformed(evt);
            }
        });

        resultadosJSON.setBackground(new java.awt.Color(51, 51, 51));
        resultadosJSON.setColumns(20);
        resultadosJSON.setForeground(new java.awt.Color(255, 255, 255));
        resultadosJSON.setRows(5);
        jScrollPane2.setViewportView(resultadosJSON);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("RESULTADOS     DEL     JSON");

        botonVerErrores.setBackground(new java.awt.Color(255, 153, 51));
        botonVerErrores.setForeground(new java.awt.Color(0, 0, 0));
        botonVerErrores.setText("ERRORES JSON");
        botonVerErrores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVerErroresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(botonAnalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pathCarpeta1, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botonExaminarCarpeta1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(pathCarpeta2, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(botonExaminarCarpeta2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(128, 128, 128))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botonVerMetodos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonVerVariables, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonVerClases, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonVerErrores, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pathCarpeta2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(pathCarpeta1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botonExaminarCarpeta1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botonExaminarCarpeta2)))
                .addGap(30, 30, 30)
                .addComponent(botonAnalizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(botonVerClases)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonVerVariables)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonVerMetodos)
                        .addGap(18, 18, 18)
                        .addComponent(botonVerErrores)))
                .addContainerGap())
        );

        jMenu1.setText("File");

        guardarJSON.setText("Guardar Archivo JSON");
        guardarJSON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarJSONActionPerformed(evt);
            }
        });
        jMenu1.add(guardarJSON);

        abrirJSON.setText("Abrir Archivo JSON");
        abrirJSON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirJSONActionPerformed(evt);
            }
        });
        jMenu1.add(abrirJSON);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnalizarActionPerformed

        /*
            ANALIZAMOS LAS CARPETAS CON SUS RESPECTIVOS ARCHIVOS.JAVA
         */
        ArrayList<String> archivos1 = new ArrayList<>();
        ArrayList<String> archivos2 = new ArrayList<>();
        ArrayList<String> archivosTotales = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                archivos1 = analizarCarpeta(rutaCarpeta1);
            } else if (i == 1) {
                archivos2 = analizarCarpeta(rutaCarpeta2);
            }
        }

        for (int i = 0; i < archivos1.size(); i++) {
            archivosTotales.add(archivos1.get(i));
        }

        for (int i = 0; i < archivos2.size(); i++) {
            archivosTotales.add(archivos2.get(i));
        }

        generarSocket(archivosTotales);

        JOptionPane.showMessageDialog(null, "Archivos Enviados");


    }//GEN-LAST:event_botonAnalizarActionPerformed

    private void botonExaminarCarpeta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonExaminarCarpeta1ActionPerformed

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.showOpenDialog(this);
        pathCarpeta1.setText(fileChooser.getSelectedFile().getAbsolutePath());
        rutaCarpeta1 = pathCarpeta1.getText();


    }//GEN-LAST:event_botonExaminarCarpeta1ActionPerformed

    private void botonExaminarCarpeta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonExaminarCarpeta2ActionPerformed

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.showOpenDialog(this);
        pathCarpeta2.setText(fileChooser.getSelectedFile().getAbsolutePath());
        rutaCarpeta2 = pathCarpeta2.getText();


    }//GEN-LAST:event_botonExaminarCarpeta2ActionPerformed

    private void guardarJSONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarJSONActionPerformed
        LexerJson lexerJson = new LexerJson(new StringReader(reporteJSON.getText()));
        SintaxJ sintax = new SintaxJ(lexerJson);

        try {
            String nombre = JOptionPane.showInputDialog(null, "Guardar como: ");
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            fileChooser.showOpenDialog(this);
            String directorio = fileChooser.getSelectedFile().getAbsolutePath();
            String ubicacionFinal = directorio + "\\" + nombre + ".txt";
            sintax.parse();
            utils.ManejoArchivos.anexarArchivo(ubicacionFinal, reporteJSON.getText());
            JOptionPane.showMessageDialog(null, "Reporte Generado Correctamente");
            clasesJSON = sintax.getClases();
            variablesJSON = sintax.getVariables();
            funcionesJSON = sintax.getFunciones();
            erroresJson = sintax.getErrores();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_guardarJSONActionPerformed

    private void abrirJSONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirJSONActionPerformed

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(this);
        String nombre = fileChooser.getSelectedFile().getAbsolutePath();
        String contenido = utils.ManejoArchivos.leerArchivo(nombre);
        reporteJSON.setText(contenido);

    }//GEN-LAST:event_abrirJSONActionPerformed

    private void botonVerClasesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVerClasesActionPerformed

        String vistaClases = "";

        for (int i = 0; i < clasesJSON.size(); i++) {
            vistaClases += "Clase " + (i + 1) + ": " + clasesJSON.get(i).getNombreClase() + "\n";
        }
        resultadosJSON.setText(vistaClases);
    }//GEN-LAST:event_botonVerClasesActionPerformed

    private void botonVerVariablesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVerVariablesActionPerformed

        String vistaVariables = "";

        for (int i = 0; i < variablesJSON.size(); i++) {
            vistaVariables += "Variable " + (i + 1) + ": Nombre:" + variablesJSON.get(i).getNombre() + "  Tipo: " + variablesJSON.get(i).getTipo() + "\n";
        }

        resultadosJSON.setText(vistaVariables);
    }//GEN-LAST:event_botonVerVariablesActionPerformed

    private void botonVerMetodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVerMetodosActionPerformed

        String vistaMetodos = "";

        for (int i = 0; i < funcionesJSON.size(); i++) {
            vistaMetodos += "Funcion " + (i + 1) + ":  Nombre: " + funcionesJSON.get(i).getNombre() + "   Tipo: " + funcionesJSON.get(i).getTipo()
                    + "   Parametros: " + funcionesJSON.get(i).getCantidad_parametros() + "\n";
        }

        resultadosJSON.setText(vistaMetodos);
    }//GEN-LAST:event_botonVerMetodosActionPerformed

    private void botonVerErroresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVerErroresActionPerformed
    
        String errores = "";

        for (int i = 0; i < erroresJson.size(); i++) {
            errores += erroresJson.get(i) + "\n";
        }
        resultadosJSON.setText(errores);
    }//GEN-LAST:event_botonVerErroresActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameAnalizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameAnalizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameAnalizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameAnalizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameAnalizador().setVisible(true);
            }
        });
    }

    public ArrayList<String> analizarCarpeta(String rutaCarpeta) {

        LectorArchivos lector = new LectorArchivos(rutaCarpeta);
        lector.run();
        ArrayList<String> archivosJava = lector.getArchivosJava();
        return archivosJava;
        /*
        
        for (int j = 0; j < lector.getArchivosJava().size(); j++) {
            String textoJava = lector.getArchivosJava().get(j);
            LexerCup lexerCup = new LexerCup(new StringReader(textoJava));
            Sintax s = new Sintax(lexerCup);
            try {
                s.parse();
                // ******LLENAMOS LOS DATOS DEL SINTAX A LAS TABLAS DE SIMBOLOS*********
                //mandamos las clases capturadas a la tabla de simbolos de clases
                for (int i = 0; i < s.getClases().size(); i++) {
                    tablaClases.agregarClase(s.getClases().get(i));
                }

                //mandamos los metodos capturados a la tabla de simbolos de metodos/funciones
                for (int i = 0; i < s.getFunciones().size(); i++) {
                    tablaMetodos.agregarMetodo(s.getFunciones().get(i));
                }

                //mandamos las variables capturadas a la tabla de simbolos de variables
                for (int i = 0; i < s.getVariables().size(); i++) {
                    tablaVariables.agregarVariable(s.getVariables().get(i));
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
         */

    }

    public void generarSocket(ArrayList<String> archivos) {

        try {
            Socket socket = new Socket("192.168.1.16", 7777);
            System.out.println("Connected!");
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream flujo = new ObjectOutputStream(outputStream);
            System.out.println("ENVIANDO...");
            flujo.writeObject(archivos);
            System.out.println("ENVIADO...CERRANDO SOCKET");
            flujo.close();
            //socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void run() {

        try {
            ServerSocket servidor = new ServerSocket(6666);
            while (true) {
                Socket miSocket = servidor.accept();
                ObjectInputStream flujoEntrada = new ObjectInputStream(miSocket.getInputStream());
                String textoRecibido = String.valueOf(flujoEntrada.readObject());
                //System.out.println("El texto recibido es: " + textoRecibido);
                reporteJSON.setText(textoRecibido);
                miSocket.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(FrameAnalizador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrameAnalizador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem abrirJSON;
    private javax.swing.JButton botonAnalizar;
    private javax.swing.JButton botonExaminarCarpeta1;
    private javax.swing.JButton botonExaminarCarpeta2;
    private javax.swing.JButton botonVerClases;
    private javax.swing.JButton botonVerErrores;
    private javax.swing.JButton botonVerMetodos;
    private javax.swing.JButton botonVerVariables;
    private javax.swing.JMenuItem guardarJSON;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField pathCarpeta1;
    private javax.swing.JTextField pathCarpeta2;
    private javax.swing.JTextArea reporteJSON;
    private javax.swing.JTextArea resultadosJSON;
    // End of variables declaration//GEN-END:variables

}
