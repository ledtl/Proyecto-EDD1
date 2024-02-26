/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanas;

import Proyecto1.CargarGrafoTxt;
import Proyecto1.MostrarInterfaz;
import Proyecto1.Simulacion;

/**
 *
 * @author Edgar Torres
 */
public class Cargar extends javax.swing.JFrame {
    
    MostrarInterfaz mostrar = new MostrarInterfaz();
    CargarGrafoTxt cargargrafo = new CargarGrafoTxt();
    Simulacion simulacion = new Simulacion();

    /**
     * Creates new form Cargar
     */
    public Cargar() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Volver = new javax.swing.JButton();
        CargarGrafo = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        AñadirTXT = new javax.swing.JButton();
        cargar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Volver.setBackground(new java.awt.Color(255, 204, 51));
        Volver.setFont(new java.awt.Font("Swis721 Blk BT", 1, 14)); // NOI18N
        Volver.setText("Volver a menú");
        Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverActionPerformed(evt);
            }
        });
        getContentPane().add(Volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 530, 160, 50));

        CargarGrafo.setBackground(new java.awt.Color(51, 255, 204));
        CargarGrafo.setFont(new java.awt.Font("Swis721 Blk BT", 1, 14)); // NOI18N
        CargarGrafo.setText("Cargar");
        CargarGrafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarGrafoActionPerformed(evt);
            }
        });
        getContentPane().add(CargarGrafo, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 450, 160, 50));

        jLabel2.setFont(new java.awt.Font("Swis721 Blk BT", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Inserte el grafo que quiere cargar");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, -1, 40));

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 380, 180));

        AñadirTXT.setBackground(new java.awt.Color(51, 255, 204));
        AñadirTXT.setFont(new java.awt.Font("Swis721 Blk BT", 1, 14)); // NOI18N
        AñadirTXT.setText("Añadir TXT");
        AñadirTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AñadirTXTActionPerformed(evt);
            }
        });
        getContentPane().add(AñadirTXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 450, 160, 50));

        cargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/7.png"))); // NOI18N
        getContentPane().add(cargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 743, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
        Menu a = new Menu ();
        a.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_VolverActionPerformed

    private void CargarGrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarGrafoActionPerformed
        String textociudad = jTextArea3.getText();
        cargargrafo.leerArchivo(mostrar.Grafo(), textociudad);
        mostrar.Grafo().display();
        simulacion.iniciarSimulacion();
    }//GEN-LAST:event_CargarGrafoActionPerformed

    private void AñadirTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AñadirTXTActionPerformed
        jTextArea3.setText(cargargrafo.abrirArchivo());
    }//GEN-LAST:event_AñadirTXTActionPerformed

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
            java.util.logging.Logger.getLogger(Cargar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cargar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cargar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cargar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cargar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AñadirTXT;
    private javax.swing.JButton CargarGrafo;
    private javax.swing.JButton Volver;
    private javax.swing.JLabel cargar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea3;
    // End of variables declaration//GEN-END:variables
}
