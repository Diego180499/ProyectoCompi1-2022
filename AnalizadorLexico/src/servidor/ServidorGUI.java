package servidor;

import codigo.Sintax;
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
import javax.swing.JOptionPane;
import reporte.ReporteJSON;
import tablaSimbolos.TablaClases;
import tablaSimbolos.TablaMetodos;
import tablaSimbolos.TablaVariables;

public class ServidorGUI extends javax.swing.JFrame implements Runnable {

    private TablaClases tablaClases;
    private TablaVariables tablaVariables;
    private TablaMetodos tablaMetodos;
    //private SocketServidor socketServidor;

    public ServidorGUI() {
        initComponents();
        tablaClases = new TablaClases();
        tablaMetodos = new TablaMetodos();
        tablaVariables = new TablaVariables();
        Thread miHilo = new Thread(this);
        miHilo.start();
        // socketServidor = new SocketServidor();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelEstadoAnalisis = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labelEstadoReportes = new javax.swing.JLabel();
        botonEnviarReporte = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ANALIZADOR DE PROYECTOS JAVA");

        jLabel2.setText("ESTADO DE ANÁLISIS:");

        labelEstadoAnalisis.setText("--");

        jLabel4.setText("ESTADO DE REPORTES");

        labelEstadoReportes.setText("NO ENVIADOS");

        botonEnviarReporte.setText("ENVIAR REPORTE JSON");
        botonEnviarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEnviarReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelEstadoAnalisis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelEstadoReportes, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))
                        .addGap(0, 258, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(botonEnviarReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(labelEstadoAnalisis))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(labelEstadoReportes))
                .addGap(53, 53, 53)
                .addComponent(botonEnviarReporte)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonEnviarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEnviarReporteActionPerformed

        enviarReporte();

    }//GEN-LAST:event_botonEnviarReporteActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServidorGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonEnviarReporte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelEstadoAnalisis;
    private javax.swing.JLabel labelEstadoReportes;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {

        try {
            ServerSocket servidor = new ServerSocket(7777);
            while (true) {
                Socket miSocket = servidor.accept();
                ObjectInputStream flujoEntrada = new ObjectInputStream(miSocket.getInputStream());
                ArrayList<String> archivosTotales = (ArrayList<String>) flujoEntrada.readObject();
                System.out.println("Se recibieron los archivos java");

                for (int j = 0; j < archivosTotales.size(); j++) {
                    String textoJava = archivosTotales.get(j);
                    LexerCup lexerCup = new LexerCup(new StringReader(textoJava));
                    Sintax s = new Sintax(lexerCup);
                    try {
                        s.parse();
                        labelEstadoAnalisis.setText("Análisis Correcto");
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
                        System.out.println("Analisis Exitoso");

                        //*************************
                        miSocket.close();

                    } catch (Exception ex) {
                        Logger.getLogger(ServidorGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        } catch (IOException ex) {
            Logger.getLogger(ServidorGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServidorGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void enviarReporte() {

        ReporteJSON reporte = new ReporteJSON();

        reporte.agregarReporteClase(tablaClases.getClases());
        reporte.reporteVariables(tablaVariables.getVariables());
        reporte.generarReporteMetodos(tablaMetodos.getMetodos());
        reporte.generarReporteTotal();
        String reporteTotal = reporte.getReporteTotal();

        try {
            Socket socket = new Socket("192.168.1.16", 6666);
            System.out.println("Conectados!");
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream flujo = new ObjectOutputStream(outputStream);
            System.out.println("ENVIANDO...");
            flujo.writeObject(reporteTotal);
            System.out.println("ENVIADO...CERRANDO SOCKET");
            labelEstadoReportes.setText("REPORTES ENVIADOS");
            flujo.close();
        } catch (IOException ex) {
            Logger.getLogger(ServidorGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
