/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.admisionCentral;

import vista.admisionCentral.FrmSeguimientoHC;
import vista.admisionCentral.FrmMovimientoHC;
import vista.admisionCentral.FrmNuevaHistoriaC;
import vista.admisionEmergencia.FrmFormatoEmergencia;
import vista.admisionEmergencia.FrmListFormatoEmergencia;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import vista.sectorizacion.FrmSector;
import vista.Principal;
import vista.admisionEmergencia.FrmFormaDeLlegada;

/**
 *
 * @author Yamila
 */
public class FrmAdmision extends javax.swing.JFrame {

    /**
     * Creates new form FrmAdmision
     */
    public FrmAdmision() {
        initComponents();
        cerrarTodo();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/iconos/iconAdmision24x24.png")).getImage());
        }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu5 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        mnuNuevo = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        mnuCabecera = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        mnuAnadir = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        mnuMovimientoHC = new javax.swing.JMenuItem();
        mnuSeguimientoHC = new javax.swing.JMenuItem();
        mnuFormatEmergencia = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();

        jMenu5.setText("jMenu5");

        jMenu8.setText("jMenu8");

        jMenu9.setText("jMenu9");

        jMenu10.setText("jMenu10");

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admisión");
        setResizable(false);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/paciente16x16.png"))); // NOI18N
        jMenu1.setText("Paciente");
        jMenu1.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N

        jMenu3.setText("Nuevo Paciente");

        mnuNuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        mnuNuevo.setText("Nuevo");
        mnuNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuNuevoActionPerformed(evt);
            }
        });
        jMenu3.add(mnuNuevo);

        jMenu1.add(jMenu3);

        jMenuBar1.add(jMenu1);

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/iconEmergencia24x24.png"))); // NOI18N
        jMenu7.setText("Admision Emergencia");
        jMenu7.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N

        mnuCabecera.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        mnuCabecera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/iconFormatEmer24x24.png"))); // NOI18N
        mnuCabecera.setText("Formato de Emergencia");
        mnuCabecera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCabeceraActionPerformed(evt);
            }
        });
        jMenu7.add(mnuCabecera);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/fllegada24x24.png"))); // NOI18N
        jMenuItem1.setText("Mantenimiento F. de Llegada");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem1);

        jMenuBar1.add(jMenu7);
        jMenuBar1.add(jMenu2);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/sectorizacion16x16.png"))); // NOI18N
        jMenu4.setText("Sectorización");
        jMenu4.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N

        mnuAnadir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_MASK));
        mnuAnadir.setText("Añadir");
        mnuAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAnadirActionPerformed(evt);
            }
        });
        jMenu4.add(mnuAnadir);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem2.setText("Listado");
        jMenu4.add(jMenuItem2);

        jMenuBar1.add(jMenu4);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/reporte16x16.png"))); // NOI18N
        jMenu6.setText("Reportes");
        jMenu6.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N

        mnuMovimientoHC.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        mnuMovimientoHC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/iconMHC24x24.png"))); // NOI18N
        mnuMovimientoHC.setText("Movimiento de H.C.");
        mnuMovimientoHC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMovimientoHCActionPerformed(evt);
            }
        });
        jMenu6.add(mnuMovimientoHC);

        mnuSeguimientoHC.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        mnuSeguimientoHC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/iconSegHC24x24.png"))); // NOI18N
        mnuSeguimientoHC.setText("Seguimiento de H.C.");
        mnuSeguimientoHC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSeguimientoHCActionPerformed(evt);
            }
        });
        jMenu6.add(mnuSeguimientoHC);

        mnuFormatEmergencia.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        mnuFormatEmergencia.setText("Formato Emergencia");
        mnuFormatEmergencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuFormatEmergenciaActionPerformed(evt);
            }
        });
        jMenu6.add(mnuFormatEmergencia);
        jMenu6.add(jSeparator1);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);
        jMenuBar1.getAccessibleContext().setAccessibleName("");
        jMenuBar1.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 541, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 404, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void cerrar(){
        Object [] opciones ={"SI","NO"};
        int eleccion = JOptionPane.showOptionDialog(rootPane,"¿Desea realmente salir del modulo?","Mensaje de Confirmacion",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE,null,opciones,"Aceptar");
        if (eleccion == JOptionPane.YES_OPTION)
        {
            dispose();   
            Principal pr= new Principal();
            pr.setVisible(true);  
        }else{
        }
    }
    
    public void cerrarTodo (){
        try {
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e){
                    cerrar();
                }
});
            this.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void close(){
        if (JOptionPane.showConfirmDialog(rootPane, "¿Desea realmente salir del sistema?",
                "Salir del sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            System.exit(0);
    }
    
    private void mnuNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuNuevoActionPerformed
        FrmNuevaHistoriaC frmNuevaHC = new FrmNuevaHistoriaC();
        frmNuevaHC.setVisible(true);
        dispose();
        String u=Principal.lblUsu.getText();
        frmNuevaHC.lblUsuUsuario.setText(u);
    }//GEN-LAST:event_mnuNuevoActionPerformed

    private void mnuAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAnadirActionPerformed
        FrmSector frmSector = new FrmSector();
        frmSector.setVisible(true);
        dispose();
        String u=Principal.lblUsu.getText();
        frmSector.lblUsuUsuario.setText(u);
    }//GEN-LAST:event_mnuAnadirActionPerformed

    private void mnuMovimientoHCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMovimientoHCActionPerformed
        FrmMovimientoHC frmMov = new FrmMovimientoHC();
        frmMov.setVisible(true);
        this.dispose();
        String u=Principal.lblUsu.getText();
    }//GEN-LAST:event_mnuMovimientoHCActionPerformed

    private void mnuSeguimientoHCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSeguimientoHCActionPerformed
        FrmSeguimientoHC frmSeg = new FrmSeguimientoHC();
        frmSeg.setVisible(true);
        this.dispose();
        String u=Principal.lblUsu.getText();
        frmSeg.lblUsuUsuario.setText(u);
    }//GEN-LAST:event_mnuSeguimientoHCActionPerformed

    private void mnuCabeceraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCabeceraActionPerformed
        FrmFormatoEmergencia frmEmer = new FrmFormatoEmergencia();
        frmEmer.setVisible(true);
        this.dispose();
        String u=Principal.lblUsu.getText();
        frmEmer.lblusu.setText(u);
    }//GEN-LAST:event_mnuCabeceraActionPerformed

    private void mnuFormatEmergenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuFormatEmergenciaActionPerformed
        FrmListFormatoEmergencia frmEmerList = new FrmListFormatoEmergencia();
        frmEmerList.setVisible(true);
        this.dispose();
        String u=Principal.lblUsu.getText();
        frmEmerList.lblUsuUsuario.setText(u);
    }//GEN-LAST:event_mnuFormatEmergenciaActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        FrmFormaDeLlegada frmEmerFL = new FrmFormaDeLlegada();
        frmEmerFL.setVisible(true);
        this.dispose();
        String u=Principal.lblUsu.getText();
        frmEmerFL.lblUsuario.setText(u);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmAdmision.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAdmision.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAdmision.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAdmision.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAdmision().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem mnuAnadir;
    private javax.swing.JMenuItem mnuCabecera;
    private javax.swing.JMenuItem mnuFormatEmergencia;
    private javax.swing.JMenuItem mnuMovimientoHC;
    private javax.swing.JMenuItem mnuNuevo;
    private javax.swing.JMenuItem mnuSeguimientoHC;
    // End of variables declaration//GEN-END:variables
}
