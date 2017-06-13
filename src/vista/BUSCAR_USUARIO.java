/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import modelos.Usuario;
import servicios.Conexion;
import vista.*;

/**
 *
 * @author silvana
 */
public class BUSCAR_USUARIO extends javax.swing.JFrame {
DefaultTableModel m;
Conexion cn=new Conexion();
    /**
     * Creates new form listarUsuario
     */
    public BUSCAR_USUARIO() {
        initComponents();
        tb_Usuario.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.getContentPane().setBackground(Color.WHITE);
        tb_Usuario.doLayout();
                setLocationRelativeTo(null);//en el centro
        setResizable(false);//para que no funcione el boton maximizar
        cargarUsuario();
        formatoUsuario();
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/iconos/hospital32x32.png")).getImage());
        //para limpiar el txt al darle click
 txtBuscar.addFocusListener(new FocusListener() {
    @Override
    public void focusGained(FocusEvent e) {
  txtBuscar.setText("");
    }

    @Override
    public void focusLost(FocusEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
} );
    }
public void cargarUsuario(){
    try {
             String titulos[]={"Nº","Codigo","Apellido_Paterno","Apellido_Materno","Nombres","Tipo de Usuario","Nombre de Usuario","Contrasena","Pregunta de Recuperación","Respuesta","Fecha_Creacion","Hora de Creacion"};
            m=new DefaultTableModel(null,titulos);
            JTable p=new JTable(m);
            String fila[]=new String[12];

        String consulta="exec SP_USUARIO_Listar";
        ResultSet r;
        r=cn.Listar(consulta);
        int c=1;
        while(r.next()){
            fila[0]=String.valueOf(c)+"º";
            fila[1]=r.getString(1);
            fila[2]=r.getString(2);
            fila[3]=r.getString(3);
            fila[4]=r.getString(4);
            fila[5]=r.getString(5);
            fila[6]=r.getString(6);
            fila[7]=r.getString(7);
            fila[8]=r.getString(8);
            fila[9]=r.getString(9);
            fila[10]=r.getString(10);
            fila[11]=r.getString(11);
                m.addRow(fila);
                c++;
            }
            tb_Usuario.setModel(m);
            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m);
            tb_Usuario.setRowSorter(elQueOrdena);
            this.tb_Usuario.setModel(m);
    } catch (Exception e) {
    }
}
    public void formatoUsuario(){
    tb_Usuario.getColumnModel().getColumn(0).setPreferredWidth(50);
    tb_Usuario.getColumnModel().getColumn(1).setPreferredWidth(100);
    tb_Usuario.getColumnModel().getColumn(2).setPreferredWidth(150);
    tb_Usuario.getColumnModel().getColumn(3).setPreferredWidth(150);
    tb_Usuario.getColumnModel().getColumn(4).setPreferredWidth(150);
    tb_Usuario.getColumnModel().getColumn(5).setPreferredWidth(150);
    tb_Usuario.getColumnModel().getColumn(6).setPreferredWidth(150);
    tb_Usuario.getColumnModel().getColumn(7).setPreferredWidth(150);
    tb_Usuario.getColumnModel().getColumn(8).setPreferredWidth(150);
    tb_Usuario.getColumnModel().getColumn(9).setPreferredWidth(150);
    tb_Usuario.getColumnModel().getColumn(10).setPreferredWidth(150);
    tb_Usuario.getColumnModel().getColumn(11).setPreferredWidth(150);
        tb_Usuario.getColumnModel().getColumn(10).setMinWidth(0);
    tb_Usuario.getColumnModel().getColumn(10).setMaxWidth(0);
            tb_Usuario.getColumnModel().getColumn(11).setMinWidth(0);
    tb_Usuario.getColumnModel().getColumn(11).setMaxWidth(0);
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tb_Usuario = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false; //Disallow the editing of any cell
            }};
            jLabel1 = new javax.swing.JLabel();
            cbxUsuario = new javax.swing.JComboBox();
            jLabel2 = new javax.swing.JLabel();
            txtBuscar = new javax.swing.JTextField();
            btnBuscar = new javax.swing.JButton();

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

            tb_Usuario.setModel(new javax.swing.table.DefaultTableModel(
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
            tb_Usuario.setRowHeight(25);
            tb_Usuario.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    tb_UsuarioMouseClicked(evt);
                }
            });
            tb_Usuario.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    tb_UsuarioKeyPressed(evt);
                }
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    tb_UsuarioKeyReleased(evt);
                }
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    tb_UsuarioKeyTyped(evt);
                }
            });
            jScrollPane1.setViewportView(tb_Usuario);

            jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
            jLabel1.setText("Búsqueda de Usuario");

            cbxUsuario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar...", "Usuario", "Nombre", "Apellido Paterno", "Apellido Materno" }));
            cbxUsuario.addItemListener(new java.awt.event.ItemListener() {
                public void itemStateChanged(java.awt.event.ItemEvent evt) {
                    cbxUsuarioItemStateChanged(evt);
                }
            });

            jLabel2.setText("Búsqueda por:");

            txtBuscar.setForeground(new java.awt.Color(0, 51, 51));
            txtBuscar.setText("Buscar Usuario");
            txtBuscar.setEnabled(false);
            txtBuscar.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    txtBuscarActionPerformed(evt);
                }
            });
            txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    txtBuscarKeyPressed(evt);
                }
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    txtBuscarKeyTyped(evt);
                }
            });

            btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/view.gif"))); // NOI18N
            btnBuscar.setBorder(null);
            btnBuscar.setEnabled(false);
            btnBuscar.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnBuscarActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(56, 56, 56)
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cbxUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(70, 70, 70)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(235, 235, 235)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addGap(17, 17, 17)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGap(29, 29, 29)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                    .addContainerGap())
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped

    }//GEN-LAST:event_txtBuscarKeyTyped

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
String consulta="";
        try {
            tb_Usuario.setModel(new DefaultTableModel());
            String titulos[]={"Nº","Codigo","Apellido Paterno","Apellido Materno","Nombres","Tipo de Usuario","Nombre de Usuario","Contrasena","Pregunta de Recuperación","Respuesta "};
            m=new DefaultTableModel(null,titulos);
            JTable p=new JTable(m);
            String fila[]=new String[12];

            Usuario obj=new Usuario();
            if(cbxUsuario.getSelectedItem()=="Usuario"){
                consulta="exec SP_USUARIO_BuscarUsuario ?";
            }
            else if(cbxUsuario.getSelectedItem()=="Nombre"){
                consulta="exec SP_USUARIO_BuscarUsuNombre ?";
            }
            else if(cbxUsuario.getSelectedItem()=="Apellido Paterno"){
                consulta="exec SP_USUARIO_BuscarUsuApePat ?";
        }
            else{
                    consulta="exec SP_USUARIO_BuscarUsuApeMat ?";
                    }
            PreparedStatement cmd = obj.getCn().prepareStatement(consulta);
            cmd.setString(1, txtBuscar.getText());
            ResultSet r= cmd.executeQuery();
            int c=1;
            while(r.next()){
                fila[0]=String.valueOf(c)+"º";
                fila[1]=r.getString(1);
                fila[2]=r.getString(2);
                fila[3]=r.getString(3);
                fila[4]=r.getString(4);
                fila[5]=r.getString(5);
                fila[6]=r.getString(6);
                fila[7]=r.getString(7);
                fila[8]=r.getString(8);
                fila[9]=r.getString(9);
                fila[10]=r.getString(10);
                fila[11]=r.getString(11);
                m.addRow(fila);
                c++;
            }
            tb_Usuario.setModel(m);
            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m);
            tb_Usuario.setRowSorter(elQueOrdena);
            this.tb_Usuario.setModel(m);
            
            tb_Usuario.getSelectionModel().setSelectionInterval(0, 0);
            tb_Usuario.requestFocus();
            formatoUsuario();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void cbxUsuarioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxUsuarioItemStateChanged
        // TODO add your handling code here:
        try
        {
            if(evt.getStateChange()==ItemEvent.SELECTED){
                if(this.cbxUsuario.getSelectedIndex()>0){
                    txtBuscar.setEnabled(true);
                    btnBuscar.setEnabled(true);
                    }

                }
        else{
                txtBuscar.setEnabled(false);
                btnBuscar.setEnabled(false);
                }}
                catch(Exception ex)
                {
                    System.out.println("Error: " + ex.getMessage());
                }
    }//GEN-LAST:event_cbxUsuarioItemStateChanged

    private void tb_UsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_UsuarioMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tb_UsuarioMouseClicked

    private void tb_UsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_UsuarioKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_UsuarioKeyTyped

    private void tb_UsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_UsuarioKeyPressed
        // TODO add your handling code here:
        char tecla= evt.getKeyChar();
                if(tecla==KeyEvent.VK_ENTER){
                      try{
                        dispose();
                        int filaselec=tb_Usuario.getSelectedRow();
                        RegistroUsuario ru= new RegistroUsuario();   
                        ru.setVisible(true);
                        RegistroUsuario.txtCodigo.setText(tb_Usuario.getValueAt(filaselec, 1).toString());
                        String nombreCompleto=tb_Usuario.getValueAt(filaselec, 4).toString()+" "+tb_Usuario.getValueAt(filaselec, 2).toString()
                                +" "+tb_Usuario.getValueAt(filaselec, 3).toString();
RegistroUsuario.txtPersonal.setText(nombreCompleto);
                        RegistroUsuario.txtUsuario.setText(tb_Usuario.getValueAt(filaselec, 6).toString());
RegistroUsuario.cbxTipo.setSelectedItem(tb_Usuario.getValueAt(filaselec, 5).toString());
                        RegistroUsuario.txtContra.setText(tb_Usuario.getValueAt(filaselec, 7).toString());
                        RegistroUsuario.txtConfirmar.setText(tb_Usuario.getValueAt(filaselec, 7).toString());
RegistroUsuario.cbxPregunta.setSelectedItem(tb_Usuario.getValueAt(filaselec, 8).toString());
                        RegistroUsuario.txtRespuesta.setText(tb_Usuario.getValueAt(filaselec, 9).toString());
                        
                       
RegistroUsuario.txtPersonal.setEnabled(false);
                        RegistroUsuario.txtUsuario.setEnabled(false);
RegistroUsuario.cbxTipo.setEnabled(false);
                        RegistroUsuario.txtContra.setEnabled(false);
                        RegistroUsuario.txtConfirmar.setEnabled(false);
RegistroUsuario.cbxPregunta.setEnabled(false);
                        RegistroUsuario.txtRespuesta.setEnabled(false);
                        
                        RegistroUsuario.btnBuscarPersonal.setEnabled(false);
                        RegistroUsuario.btnguardar.setEnabled(false);
                         RegistroUsuario.btnmodificar.setEnabled(true);
                         RegistroUsuario.btneliminar.setEnabled(true);
                         String u=Principal.lblUsu.getText();
                            RegistroUsuario.lblUsuUsuario.setText(u);
                                                 
                    }
                    catch(Exception ex)
                    {
                        System.out.println("Error: " + ex.getMessage());
                    }
                }
    }//GEN-LAST:event_tb_UsuarioKeyPressed

    private void tb_UsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_UsuarioKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_UsuarioKeyReleased

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        // TODO add your handling code here:
        char tecla= evt.getKeyChar();
                if(tecla==KeyEvent.VK_ENTER){
                    btnBuscar.doClick();
                }
    }//GEN-LAST:event_txtBuscarKeyPressed

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
            java.util.logging.Logger.getLogger(BUSCAR_USUARIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BUSCAR_USUARIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BUSCAR_USUARIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BUSCAR_USUARIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BUSCAR_USUARIO().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox cbxUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tb_Usuario;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
