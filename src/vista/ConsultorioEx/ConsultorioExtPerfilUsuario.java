/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.ConsultorioEx;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JFrame;
import modelos.ConsultorioEx.CONSULTORIOEXTCONSULTORIOOrden;
import modelos.ConsultorioEx.ConsultorioExtConsultorioAntecedentesExf;
import modelos.ConsultorioEx.ConsultorioExtConsultorioDiagnostico;
import modelos.ConsultorioEx.ConsultorioExtConsultorioMotivo;
import modelos.ConsultorioEx.ConsultorioExtConsultorioTratamiento;

/**
 *
 * @author MYS1
 */
public class ConsultorioExtPerfilUsuario extends javax.swing.JInternalFrame {

    static void HIDE_ON_CLOSE(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
private JComponent Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
    private Dimension DimensionBarra = null; 
    /**
     * Creates new form ConsultorioExtPerfilUsuario
     */
    public ConsultorioExtPerfilUsuario() {
        initComponents();
        QuitarLaBarraTitulo();
        lblTerminarConsulta.setVisible(false);
        btnSi1.setVisible(false);
        btnNo1.setVisible(false);
    }
    
    public void QuitarLaBarraTitulo(){ 
        Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane(); 
        DimensionBarra = Barra.getPreferredSize(); 
        Barra.setSize(0,0); 
        Barra.setPreferredSize(new Dimension(0,0)); 
        repaint();   
    }
    public void ventanas(){
    
        ConsultoriosExtAntecedentes antecedente =new ConsultoriosExtAntecedentes();
        ConsultorioExt.panelOpciones.add(antecedente);
        ConsultoriosExtAntecedentes.lblID.setText(lblIdCabecera.getText());
        try {
            antecedente.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(RegistroSeguimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ConsultorioExtConsultorioAntecedentesExf AF1 = new ConsultorioExtConsultorioAntecedentesExf();
        AF1.ConsultoriosExtAntecedentesListar(lblIdCabecera.getText()); 

        if (ConsultoriosExtAntecedentes.var.getText().equals("") ){
            ConsultoriosExtAntecedentes.btnGuardar.setEnabled(true);
            ConsultoriosExtAntecedentes.btneditar.setEnabled(false);
        }
    }
    
    public  void cerrar (){
        try {
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e){
                    dispose();
                }
        });
            this.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        jPanel4 = new javax.swing.JPanel();
        lblPaciente = new javax.swing.JLabel();
        lblDNI = new javax.swing.JLabel();
        lblTerminarConsulta = new javax.swing.JLabel();
        btnSi1 = new javax.swing.JButton();
        btnNo1 = new javax.swing.JButton();
        lblIdCabecera = new javax.swing.JLabel();
        lblHC = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createCompoundBorder());
        setVisible(true);

        jPanel1.setBackground(new java.awt.Color(39, 174, 97));

        jPanel4.setBackground(new java.awt.Color(0, 130, 87));
        jPanel4.setPreferredSize(new java.awt.Dimension(935, 114));

        lblPaciente.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        lblPaciente.setForeground(new java.awt.Color(255, 255, 255));
        lblPaciente.setText("Rocca Ruiz ");

        lblDNI.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        lblDNI.setForeground(new java.awt.Color(255, 255, 255));
        lblDNI.setText("Rocca Ruiz ");

        lblTerminarConsulta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTerminarConsulta.setForeground(new java.awt.Color(255, 255, 255));
        lblTerminarConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Apagar-32.png"))); // NOI18N
        lblTerminarConsulta.setText("Terminar Consulta ?");
        lblTerminarConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTerminarConsultaMouseClicked(evt);
            }
        });

        btnSi1.setForeground(new java.awt.Color(240, 240, 240));
        btnSi1.setText("Si");
        btnSi1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnSi1.setContentAreaFilled(false);
        btnSi1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSi1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSi1.setIconTextGap(30);
        btnSi1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSi1MouseClicked(evt);
            }
        });
        btnSi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSi1ActionPerformed(evt);
            }
        });

        btnNo1.setForeground(new java.awt.Color(240, 240, 240));
        btnNo1.setText("No");
        btnNo1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnNo1.setContentAreaFilled(false);
        btnNo1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNo1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNo1.setIconTextGap(30);
        btnNo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNo1MouseClicked(evt);
            }
        });
        btnNo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNo1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPaciente)
                    .addComponent(lblDNI)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lblIdCabecera, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblHC, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTerminarConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnSi1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNo1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(49, 49, 49))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPaciente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDNI)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIdCabecera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblHC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(lblTerminarConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSi1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNo1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 17, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Orden de compra-50 (1).png"))); // NOI18N
        jLabel5.setText("<html>&nbsp;&nbsp;Motivo de Consulta");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Mensaje_50.png"))); // NOI18N
        jLabel10.setText("<html>&nbsp;&nbsp;Diagnóstico ");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Usuario-50.png"))); // NOI18N
        jLabel11.setText("<html>&nbsp;&nbsp;Antecedentes Personales");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Doctor en medicina-50.png"))); // NOI18N
        jLabel12.setText("<html>&nbsp;&nbsp;Ordenes Médicas");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Maletín médico-50.png"))); // NOI18N
        jLabel13.setText("<html>&nbsp;&nbsp;Tratamiento");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Calendario-50 (1).png"))); // NOI18N
        jLabel14.setText("<html>&nbsp;&nbsp;Proxima Cita");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 713, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        
        ventanas();
        ConsultorioExt.jTabbedPane1.setSelectedIndex(2);
        
        
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        ConsultorioExtMotivo motivo =new ConsultorioExtMotivo();
        ConsultorioExt.panelOpciones.add(motivo);
        ConsultorioExtMotivo.lblID.setText(lblIdCabecera.getText());
        try {
            motivo.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(RegistroSeguimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ConsultorioExtConsultorioMotivo Mot = new ConsultorioExtConsultorioMotivo();
        Mot.ConsultoriosExtMotivoListar(lblIdCabecera.getText()); 

        if (ConsultorioExtMotivo.lblIDM.getText().equals("") ){
            ConsultorioExtMotivo.btnGuardar.setEnabled(true);
            ConsultorioExtMotivo.btneditar.setEnabled(false);
            
        }
        if (!ConsultorioExtMotivo.lblIDM.getText().equals("") ){
            
            ConsultorioExtMotivo.txtMotivo.setEditable(false);
            ConsultorioExtMotivo.txtResultado.setEditable(false);
            ConsultorioExtMotivo.txtAntecedentes.setEditable(false);
        }
        
        ConsultorioExt.jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        ConsultorioExtDiagnostico diag =new ConsultorioExtDiagnostico();
        ConsultorioExt.panelOpciones.add(diag);
        ConsultorioExtDiagnostico.lblID.setText(lblIdCabecera.getText());
        try {
            diag.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(RegistroSeguimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ConsultorioExtConsultorioDiagnostico Diag = new ConsultorioExtConsultorioDiagnostico();
        Diag.ConsultoriosExtDiagnosticoListar(lblIdCabecera.getText()); 

        if (ConsultorioExtDiagnostico.lblIDDX.getText().equals("") ){
            ConsultorioExtDiagnostico.btnGuardar.setEnabled(true);
            ConsultorioExtDiagnostico.btneditar.setEnabled(false);
            
        }
        if (!ConsultorioExtDiagnostico.lblIDDX.getText().equals("") ){
            
            ConsultorioExtDiagnostico.btnBuscarCIE10.setEnabled(false);
            ConsultorioExtDiagnostico.cbxTipod.setEnabled(false);
            ConsultorioExtDiagnostico.txtInfo.setEditable(false);
        }
        ConsultorioExt.jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        ConsultorioExtOrdenes orden =new ConsultorioExtOrdenes();
        ConsultorioExt.panelOpciones.add(orden);
        ConsultorioExtOrdenes.lblID.setText(lblIdCabecera.getText());
        ConsultorioExtOrdenes.lblid_hc.setText(lblHC.getText());
        try {
            orden.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(RegistroSeguimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        CONSULTORIOEXTCONSULTORIOOrden OR = new CONSULTORIOEXTCONSULTORIOOrden();
        OR.CONSULTORIO_EXT_LISTAR_CONSULTORIO_ORDEN_RECETADEAS(lblIdCabecera.getText(),ConsultorioExtOrdenes.tbPatologias1); 

        if (ConsultorioExtOrdenes.lblIDO.getText().equals("") ){
            ConsultorioExtOrdenes.btnGuardar.setEnabled(true);
            ConsultorioExtOrdenes.btneditar.setEnabled(false);
            
        }
       
        
        
        ConsultorioExt.jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        ConsultorioExtTratamiento trata =new ConsultorioExtTratamiento();
        ConsultorioExt.panelOpciones.add(trata);
        ConsultorioExtTratamiento.lblID.setText(lblIdCabecera.getText());
        try {
            trata.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(RegistroSeguimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConsultorioExtConsultorioTratamiento trat = new ConsultorioExtConsultorioTratamiento();
        trat.ConsultoriosExtTratamientoListar(lblIdCabecera.getText()); 

        if (ConsultorioExtTratamiento.lblIDT.getText().equals("") ){
            ConsultorioExtTratamiento.btnGuardar.setEnabled(true);
            ConsultorioExtTratamiento.btneditar.setEnabled(false);
            
        }
        if (!ConsultorioExtTratamiento.lblIDT.getText().equals("") ){
            
            ConsultorioExtTratamiento.txtIndicaciones.setEditable(false);
            ConsultorioExtTratamiento.txtOtras.setEditable(false);
        }
        ConsultorioExt.jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        ConsultorioExtProxima prox =new ConsultorioExtProxima();
        ConsultorioExt.panelOpciones.add(prox);
        ConsultorioExtProxima.lblID.setText(lblIdCabecera.getText());
        ConsultorioExtProxima.lblid_hc.setText(lblHC.getText());
        try {
            prox.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(RegistroSeguimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConsultorioExt.jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_jLabel14MouseClicked

    private void lblTerminarConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTerminarConsultaMouseClicked
        
    }//GEN-LAST:event_lblTerminarConsultaMouseClicked

    private void btnSi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSi1ActionPerformed
       this.dispose();
        ConsultorioExtLista.jPanel3.setBackground(new Color(43,43,43));  
        ConsultorioExtLista.panelTriaje.setVisible(false);
        ConsultorioExt.lblHC.setText("");
        ConsultorioExt.btnActualizar.setVisible(true); 
        ConsultorioExt.btnLista.setVisible(false);
        ConsultorioExt.btnVer.setVisible(false);
        ConsultorioExt.btnCerrar.setVisible(false);
        ConsultorioExt.jPanel7.setVisible(false);
        
        ConsultorioExt.jTabbedPane1.setSelectedIndex(0);
        ConsultorioExt.jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_btnSi1ActionPerformed

    private void btnNo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNo1ActionPerformed
       
    }//GEN-LAST:event_btnNo1ActionPerformed

    private void btnNo1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNo1MouseClicked
        jPanel4.setBackground(new Color(0,130,87)); 
        lblTerminarConsulta.setVisible(false);
        btnSi1.setVisible(false);
        btnNo1.setVisible(false);
        
    }//GEN-LAST:event_btnNo1MouseClicked

    private void btnSi1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSi1MouseClicked
        
    }//GEN-LAST:event_btnSi1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnNo1;
    public static javax.swing.JButton btnSi1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel4;
    public static javax.swing.JLabel lblDNI;
    public static javax.swing.JLabel lblHC;
    public static javax.swing.JLabel lblIdCabecera;
    public static javax.swing.JLabel lblPaciente;
    public static javax.swing.JLabel lblTerminarConsulta;
    // End of variables declaration//GEN-END:variables
}
