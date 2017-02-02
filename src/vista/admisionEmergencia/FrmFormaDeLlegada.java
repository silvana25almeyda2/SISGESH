/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.admisionEmergencia;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelos.admisionEmergencia.AdmisionEmergenciaCabecera;
import modelos.admisionEmergencia.AdmisionEmergenciaFormaDeLlegada;
import static vista.admisionEmergencia.FrmFormatoEmergencia.lblPestana;

/**
 *
 * @author PC02
 */
public class FrmFormaDeLlegada extends javax.swing.JFrame {

    AdmisionEmergenciaFormaDeLlegada adEmerFL = new AdmisionEmergenciaFormaDeLlegada();
    AdmisionEmergenciaCabecera adEmerCab = new AdmisionEmergenciaCabecera();
    public FrmFormaDeLlegada() {
        initComponents();
        this.getContentPane().setBackground(Color.WHITE);//fondo blanco
        setLocationRelativeTo(null);//en el centro
        txtaDescripcion.setWrapStyleWord(true);
        txtaDescripcion.setLineWrap(true); 
        btnModificar4.setEnabled(false);
        // BOTON ESCAPE (ESC)
        getRootPane().getActionMap().put("Cancel", new javax.swing.AbstractAction(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e)
            {
                dispose();
            }
        });
    }
    
    public void limpiarDatos(boolean opcion){
        txtNombre.setText("");
        txtaDescripcion.setText("");
        txtNombre.setEnabled(opcion);
        txtaDescripcion.setEnabled(opcion);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlgBuscar = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbBuscar = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        titulo9 = new javax.swing.JLabel();
        lblHora4 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        lblFecha4 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        btnNuevo4 = new javax.swing.JButton();
        btnGuardar4 = new javax.swing.JButton();
        btnModificar4 = new javax.swing.JButton();
        btnEliminar4 = new javax.swing.JButton();
        btnBuscar4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtIDFormaLlegada = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtaDescripcion = new javax.swing.JTextArea();
        lblOp = new javax.swing.JLabel();

        dlgBuscar.setMinimumSize(new java.awt.Dimension(400, 300));

        tbBuscar = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tbBuscar.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        tbBuscar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbBuscar.setSelectionBackground(new java.awt.Color(0, 118, 168));
        tbBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbBuscarKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbBuscar);

        javax.swing.GroupLayout dlgBuscarLayout = new javax.swing.GroupLayout(dlgBuscar.getContentPane());
        dlgBuscar.getContentPane().setLayout(dlgBuscarLayout);
        dlgBuscarLayout.setHorizontalGroup(
            dlgBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        dlgBuscarLayout.setVerticalGroup(
            dlgBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgBuscarLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(465, 370));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel12.setBackground(new java.awt.Color(0, 118, 168));
        jPanel12.setPreferredSize(new java.awt.Dimension(500, 65));
        jPanel12.setLayout(null);

        titulo9.setBackground(new java.awt.Color(153, 0, 51));
        titulo9.setFont(new java.awt.Font("Segoe UI Light", 0, 30)); // NOI18N
        titulo9.setForeground(new java.awt.Color(255, 255, 255));
        titulo9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo9.setText("Admision Emergencia");
        titulo9.setToolTipText("");
        titulo9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel12.add(titulo9);
        titulo9.setBounds(0, 11, 275, 41);

        lblHora4.setFont(new java.awt.Font("Palatino Linotype", 1, 12)); // NOI18N
        lblHora4.setForeground(new java.awt.Color(255, 255, 255));
        lblHora4.setText("00:00:00");
        jPanel12.add(lblHora4);
        lblHora4.setBounds(380, 20, 42, 17);

        jLabel26.setFont(new java.awt.Font("Palatino Linotype", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Hora:");
        jPanel12.add(jLabel26);
        jLabel26.setBounds(337, 20, 31, 17);

        jLabel27.setFont(new java.awt.Font("Palatino Linotype", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Fecha:");
        jPanel12.add(jLabel27);
        jLabel27.setBounds(337, 43, 34, 17);

        lblFecha4.setFont(new java.awt.Font("Palatino Linotype", 1, 12)); // NOI18N
        lblFecha4.setForeground(new java.awt.Color(255, 255, 255));
        lblFecha4.setText("00/00/00");
        jPanel12.add(lblFecha4);
        lblFecha4.setBounds(380, 40, 44, 20);

        lblUsuario.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario.setText("Nombre");
        jPanel12.add(lblUsuario);
        lblUsuario.setBounds(375, 75, 85, 20);

        jLabel28.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(51, 51, 51));
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/User-32.png"))); // NOI18N
        jPanel12.add(jLabel28);
        jLabel28.setBounds(337, 71, 32, 24);

        btnNuevo4.setBackground(new java.awt.Color(204, 204, 204));
        btnNuevo4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnNuevo4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Documento-32.png"))); // NOI18N
        btnNuevo4.setMnemonic('N');
        btnNuevo4.setToolTipText("Nuevo (Alt + N)");
        btnNuevo4.setContentAreaFilled(false);
        btnNuevo4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo4.setFocusable(false);
        btnNuevo4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo4ActionPerformed(evt);
            }
        });
        jPanel12.add(btnNuevo4);
        btnNuevo4.setBounds(20, 60, 24, 30);

        btnGuardar4.setBackground(new java.awt.Color(204, 204, 204));
        btnGuardar4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnGuardar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Guardar-32.png"))); // NOI18N
        btnGuardar4.setMnemonic('G');
        btnGuardar4.setToolTipText("Guardar (Alt + G)");
        btnGuardar4.setContentAreaFilled(false);
        btnGuardar4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar4.setEnabled(false);
        btnGuardar4.setFocusable(false);
        btnGuardar4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar4ActionPerformed(evt);
            }
        });
        jPanel12.add(btnGuardar4);
        btnGuardar4.setBounds(50, 60, 28, 30);

        btnModificar4.setBackground(new java.awt.Color(204, 204, 204));
        btnModificar4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnModificar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Editar-32.png"))); // NOI18N
        btnModificar4.setMnemonic('M');
        btnModificar4.setToolTipText("Modificar (Alt + M)");
        btnModificar4.setContentAreaFilled(false);
        btnModificar4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar4.setFocusable(false);
        btnModificar4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificar4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnModificar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar4ActionPerformed(evt);
            }
        });
        jPanel12.add(btnModificar4);
        btnModificar4.setBounds(90, 60, 28, 30);

        btnEliminar4.setBackground(new java.awt.Color(204, 204, 204));
        btnEliminar4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEliminar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Basura-32.png"))); // NOI18N
        btnEliminar4.setMnemonic('E');
        btnEliminar4.setToolTipText("Eliminar (Alt + E)");
        btnEliminar4.setContentAreaFilled(false);
        btnEliminar4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar4.setEnabled(false);
        btnEliminar4.setFocusable(false);
        btnEliminar4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar4ActionPerformed(evt);
            }
        });
        jPanel12.add(btnEliminar4);
        btnEliminar4.setBounds(120, 60, 28, 30);

        btnBuscar4.setBackground(new java.awt.Color(204, 204, 204));
        btnBuscar4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnBuscar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Buscararchivo-32.png"))); // NOI18N
        btnBuscar4.setMnemonic('B');
        btnBuscar4.setToolTipText("Buscar (Alt + B)");
        btnBuscar4.setContentAreaFilled(false);
        btnBuscar4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar4.setFocusable(false);
        btnBuscar4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscar4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBuscar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar4ActionPerformed(evt);
            }
        });
        jPanel12.add(btnBuscar4);
        btnBuscar4.setBounds(150, 60, 44, 32);

        getContentPane().add(jPanel12);
        jPanel12.setBounds(0, 0, 470, 110);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        txtIDFormaLlegada.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtIDFormaLlegada.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtIDFormaLlegada.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("ID Forma de Llegada:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Descripción:");

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNombre.setEnabled(false);

        txtaDescripcion.setColumns(20);
        txtaDescripcion.setRows(5);
        txtaDescripcion.setEnabled(false);
        jScrollPane2.setViewportView(txtaDescripcion);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtIDFormaLlegada, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                    .addComponent(txtNombre)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIDFormaLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(40, 130, 380, 200);

        lblOp.setForeground(new java.awt.Color(255, 255, 255));
        lblOp.setText("jLabel4");
        getContentPane().add(lblOp);
        lblOp.setBounds(0, 120, 34, 14);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevo4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo4ActionPerformed
        txtIDFormaLlegada.setText(adEmerFL.idAdmisionEmergenciaFormaDeLlegada());
        limpiarDatos(true);
        btnGuardar4.setEnabled(true);
        lblOp.setText("N");
    }//GEN-LAST:event_btnNuevo4ActionPerformed

    private void btnModificar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar4ActionPerformed
        limpiarDatos(true);
        lblOp.setText("M");
        btnGuardar4.setEnabled(true);
    }//GEN-LAST:event_btnModificar4ActionPerformed

    private void btnGuardar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar4ActionPerformed
        try {
            if(lblOp.getText().equals("N")){// NUEVA FORMA DE LLEGADA
                AdmisionEmergenciaFormaDeLlegada f2 = new AdmisionEmergenciaFormaDeLlegada();
                f2.setLlegada_id(txtIDFormaLlegada.getText());
                f2.setLlegada_nombre(txtNombre.getText());
                f2.setLlegada_Descripcion(txtaDescripcion.getText());
                f2.setCod_usu(adEmerCab.codUsuario(lblUsuario.getText()));
                if(txtNombre.getText().equals(""))
                    JOptionPane.showMessageDialog(this, "Ingrese un nombre");
                else{
                    if(f2.admisionFormaDeLlegadaMantenimiento("I")){
                        JOptionPane.showMessageDialog(this, "Registro guardado");
                        btnGuardar4.setEnabled(false);
                        limpiarDatos(false);
                        txtIDFormaLlegada.setText("");
                    }else{
                        JOptionPane.showMessageDialog(this, "Error al guardar");
                        btnGuardar4.setEnabled(false);
                        limpiarDatos(false);
                    }
                }
            } else { // MODIFICAR FORMA DE LLEGADA
                AdmisionEmergenciaFormaDeLlegada f2 = new AdmisionEmergenciaFormaDeLlegada();
                f2.setLlegada_id(txtIDFormaLlegada.getText());
                f2.setLlegada_nombre(txtNombre.getText());
                f2.setLlegada_Descripcion(txtaDescripcion.getText());
                if(txtNombre.getText().equals(""))
                    JOptionPane.showMessageDialog(this, "Ingrese un nombre");
                else{
                    if(f2.admisionFormaDeLlegadaMantenimiento("A")){
                        JOptionPane.showMessageDialog(this, "Registro modificado");
                        limpiarDatos(false);
                        txtIDFormaLlegada.setText("");
                        btnGuardar4.setEnabled(false);
                        btnModificar4.setEnabled(false);
                        btnEliminar4.setEnabled(false);
                    }else{
                        JOptionPane.showMessageDialog(this, "Error al modificar");
                        btnGuardar4.setEnabled(false);
                        limpiarDatos(false);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error: bttnGuardar4ActionPerformed" + e.getMessage());
        }
    }//GEN-LAST:event_btnGuardar4ActionPerformed

    private void btnEliminar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar4ActionPerformed
        ImageIcon i=new ImageIcon(this.getClass().getResource("/imagenes/iconos/alerta32x32.png")); 
        int eliminar = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea ELIMINAR los datos?",
                                    "Atención", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,i);
        if(eliminar == 0 ){
            AdmisionEmergenciaFormaDeLlegada f2 = new AdmisionEmergenciaFormaDeLlegada();
            f2.setLlegada_id(txtIDFormaLlegada.getText());
            if(f2.admisionFormaDeLlegadaMantenimiento("E")){
                JOptionPane.showMessageDialog(this, "Registro eliminado");
                btnModificar4.setEnabled(false);
                btnEliminar4.setEnabled(false);
                limpiarDatos(false);
                txtIDFormaLlegada.setText("");
            } else 
                JOptionPane.showMessageDialog(this, "error al eliminar registro");
        }
    }//GEN-LAST:event_btnEliminar4ActionPerformed

    private void btnBuscar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar4ActionPerformed
        dlgBuscar.setVisible(true);
        dlgBuscar.setLocationRelativeTo(null);//en el centro
        dlgBuscar.setResizable(false);
        dlgBuscar.getContentPane().setBackground(Color.WHITE);
        adEmerFL.cargarFormatEmer(tbBuscar);
        tbBuscar.requestFocus();
        tbBuscar.getSelectionModel().setSelectionInterval(0,0);
        tbBuscar.setRowHeight(25);
        btnGuardar4.setEnabled(false);
    }//GEN-LAST:event_btnBuscar4ActionPerformed

    private void tbBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbBuscarKeyPressed
        int fila = tbBuscar.getSelectedRow();
        dlgBuscar.dispose();
        FrmFormaDeLlegada.txtIDFormaLlegada.setText(String.valueOf(tbBuscar.getValueAt(fila, 0)));
        FrmFormaDeLlegada.txtNombre.setText(String.valueOf(tbBuscar.getValueAt(fila, 1)));
        FrmFormaDeLlegada.txtaDescripcion.setText(String.valueOf(tbBuscar.getValueAt(fila, 2)));
        btnModificar4.setEnabled(true);
        txtNombre.setEnabled(false);
        txtaDescripcion.setEnabled(false);
        btnEliminar4.setEnabled(true);
    }//GEN-LAST:event_tbBuscarKeyPressed

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
            java.util.logging.Logger.getLogger(FrmFormaDeLlegada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmFormaDeLlegada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmFormaDeLlegada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmFormaDeLlegada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmFormaDeLlegada().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar4;
    private javax.swing.JButton btnEliminar4;
    private javax.swing.JButton btnGuardar4;
    private javax.swing.JButton btnModificar4;
    private javax.swing.JButton btnNuevo4;
    private javax.swing.JDialog dlgBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFecha4;
    private javax.swing.JLabel lblHora4;
    private javax.swing.JLabel lblOp;
    public static javax.swing.JLabel lblUsuario;
    private javax.swing.JTable tbBuscar;
    private javax.swing.JLabel titulo9;
    public static javax.swing.JTextField txtIDFormaLlegada;
    public static javax.swing.JTextField txtNombre;
    public static javax.swing.JTextArea txtaDescripcion;
    // End of variables declaration//GEN-END:variables
}
