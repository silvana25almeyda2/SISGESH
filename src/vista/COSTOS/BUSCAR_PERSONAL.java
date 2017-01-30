/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.COSTOS;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import modelos.Usuario;
import modelos.COSTOS.referencialCabecera;
import modelos.COSTOS.referencialDetalle;
import servicios.Conexion;
import static vista.BUSCAR_USUARIO.tb_Usuario;
import static vista.COSTOS.Costos_Sustentacion_Detalle_Personal.txtHora;
import static vista.COSTOS.Costos_Sustentacion_Detalle_Personal.txtHorasMes;
import static vista.COSTOS.Costos_Sustentacion_Detalle_Personal.txtSueldo;
import static vista.COSTOS.Costos_Sustentacion_Detalle_Personal.txtMin;
import static vista.COSTOS.Costos_Sustentacion_Detalle_Personal.txtTotal;

/**
 *
 * @author silvana
 */
public class BUSCAR_PERSONAL extends javax.swing.JFrame {
DefaultTableModel m;
Conexion cn=new Conexion();
    /**
     * Creates new form listarUsuario
     */
    public BUSCAR_PERSONAL() {
        initComponents();
        tbPersonalSueldo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.getContentPane().setBackground(Color.WHITE);
        tbPersonalSueldo.doLayout();
        setLocationRelativeTo(null);//en el centro
        setResizable(false);//para que no funcione el boton maximizar
        cargarPersonal();
        formatoPersonal();
        tbPersonalSueldo.getSelectionModel().setSelectionInterval(0, 0);
        tbPersonalSueldo.requestFocus();
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
    public void cargarPersonal(){
    try {
            String titulos[]={"Nº","Codigo","Cod_Sueldo","Dni","Nivel","Cargo","Sueldo","Apellido Paterno","Apellido Materno","Nombres","Fecha de Nacimiento","Sexo","Direccion","Correo"};
            m=new DefaultTableModel(null,titulos);
            JTable p=new JTable(m);
            String fila[]=new String[14];

            String consulta="exec COSTOS_COSTOS_SUSTENTACION_DET_PERSONAL_Listar";
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
            fila[12]=r.getString(12);
            fila[13]=r.getString(13);
                m.addRow(fila);
                c++;
            }
            tbPersonalSueldo.setModel(m);
            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m);
            tbPersonalSueldo.setRowSorter(elQueOrdena);
            this.tbPersonalSueldo.setModel(m);
            } catch (Exception e) {
            }
    }
    public void formatoPersonal(){
    tbPersonalSueldo.getColumnModel().getColumn(0).setPreferredWidth(50);
    tbPersonalSueldo.getColumnModel().getColumn(1).setPreferredWidth(80);
    
    tbPersonalSueldo.getColumnModel().getColumn(3).setPreferredWidth(120); 
    tbPersonalSueldo.getColumnModel().getColumn(4).setPreferredWidth(120);
    tbPersonalSueldo.getColumnModel().getColumn(5).setPreferredWidth(120);
    tbPersonalSueldo.getColumnModel().getColumn(6).setPreferredWidth(120);
    tbPersonalSueldo.getColumnModel().getColumn(7).setPreferredWidth(120);
    tbPersonalSueldo.getColumnModel().getColumn(8).setPreferredWidth(120);
    tbPersonalSueldo.getColumnModel().getColumn(9).setPreferredWidth(120);
    tbPersonalSueldo.getColumnModel().getColumn(10).setPreferredWidth(50);
    tbPersonalSueldo.getColumnModel().getColumn(11).setPreferredWidth(180);
    tbPersonalSueldo.getColumnModel().getColumn(12).setPreferredWidth(200);
    tbPersonalSueldo.getColumnModel().getColumn(13).setPreferredWidth(200);
    
    //ocultar
    tbPersonalSueldo.getColumnModel().getColumn(2).setMinWidth(0);
    tbPersonalSueldo.getColumnModel().getColumn(2).setMaxWidth(0);
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
        tbPersonalSueldo = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false; //Disallow the editing of any cell
            }};
            jLabel1 = new javax.swing.JLabel();
            cbxBuscar = new javax.swing.JComboBox();
            jLabel2 = new javax.swing.JLabel();
            txtBuscar = new javax.swing.JTextField();
            btnBuscar = new javax.swing.JButton();

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            setTitle("SISGESH .::. Búsqueda de Personal");
            setAlwaysOnTop(true);

            tbPersonalSueldo.setModel(new javax.swing.table.DefaultTableModel(
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
            tbPersonalSueldo.setRowHeight(25);
            tbPersonalSueldo.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    tbPersonalSueldoMouseClicked(evt);
                }
            });
            tbPersonalSueldo.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    tbPersonalSueldoKeyPressed(evt);
                }
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    tbPersonalSueldoKeyReleased(evt);
                }
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    tbPersonalSueldoKeyTyped(evt);
                }
            });
            jScrollPane1.setViewportView(tbPersonalSueldo);

            jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
            jLabel1.setText("Personal");

            cbxBuscar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar...", "Nombres", "Apellido Paterno", "Apellido Materno", "Cargo" }));
            cbxBuscar.addItemListener(new java.awt.event.ItemListener() {
                public void itemStateChanged(java.awt.event.ItemEvent evt) {
                    cbxBuscarItemStateChanged(evt);
                }
            });

            jLabel2.setText("Búsqueda por:");

            txtBuscar.setForeground(new java.awt.Color(0, 51, 51));
            txtBuscar.setText("Buscar ");
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
                            .addGap(414, 414, 414)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(133, 133, 133)
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cbxBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(158, 158, 158)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 904, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGap(28, 28, 28)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                    .addContainerGap())
            );

            getAccessibleContext().setAccessibleName("BÚSQUEDA DE PERSONAL");

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void tbPersonalSueldoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPersonalSueldoMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tbPersonalSueldoMouseClicked

    private void tbPersonalSueldoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbPersonalSueldoKeyPressed
        // TODO add your handling code here:     
        char tecla= evt.getKeyChar();
                if(tecla==KeyEvent.VK_ENTER){ 
                    try{ 
                        dispose();
                        int filaselec=tbPersonalSueldo.getSelectedRow();

                        Costos_Sustentacion_Detalle_Personal.txtCodSueldo.setText(tbPersonalSueldo.getValueAt(filaselec, 2).toString());  
                        Costos_Sustentacion_Detalle_Personal.txtPersonal.setText(tbPersonalSueldo.getValueAt(filaselec, 5).toString());  
                        
                        Costos_Sustentacion_Detalle_Personal.txtSueldo.setText(tbPersonalSueldo.getValueAt(filaselec, 6).toString());        
                    
                        if(Costos_Sustentacion_Detalle_Personal.txtSueldo.getText().equalsIgnoreCase("") || Costos_Sustentacion_Detalle_Personal.txtHorasMes.getText().equalsIgnoreCase("")){
                        Costos_Sustentacion_Detalle_Personal.txtTotal.setText("");
                        }
                        else{
                        int h=Integer.parseInt(txtHorasMes.getText()); 
                        int tiempo=Integer.parseInt(txtHora.getText())*60+Integer.parseInt(txtMin.getText());
                        double t=(Double.parseDouble(txtSueldo.getText())/(h*60))*tiempo;
                        BigDecimal total = new BigDecimal(t);
                        total = total.setScale(2, BigDecimal.ROUND_HALF_UP);
                        Costos_Sustentacion_Detalle_Personal.txtTotal.setText(String.valueOf(total));
                        }
                    }
                    catch(Exception ex){
                        System.out.println("Error: " + ex.getMessage());
                    }
                }
    }//GEN-LAST:event_tbPersonalSueldoKeyPressed

    private void tbPersonalSueldoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbPersonalSueldoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tbPersonalSueldoKeyTyped

    private void cbxBuscarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxBuscarItemStateChanged
        // TODO add your handling code here:
        try
        {
            if(evt.getStateChange()==ItemEvent.SELECTED){
                if(this.cbxBuscar.getSelectedIndex()>0){
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
    }//GEN-LAST:event_cbxBuscarItemStateChanged

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped

    }//GEN-LAST:event_txtBuscarKeyTyped

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        String consulta="";
        try {
            tbPersonalSueldo.setModel(new DefaultTableModel());
            String titulos[]={"Nº","Codigo","Cod_Sueldo","Dni","Nivel","Cargo","Sueldo","Apellido Paterno","Apellido Materno","Nombres","Fecha de Nacimiento","Sexo","Direccion","Correo"};
            m=new DefaultTableModel(null,titulos);
            JTable p=new JTable(m);
            String fila[]=new String[14];

            Usuario obj=new Usuario();
            if(cbxBuscar.getSelectedItem()=="Nombres"){
                consulta="exec COSTOS_COSTOS_SUSTENTACION_DET_PERSONAL_BuscarNombre ?";
            }
            else if(cbxBuscar.getSelectedItem()=="Apellido Paterno"){
                consulta="exec COSTOS_COSTOS_SUSTENTACION_DET_PERSONAL_BuscarApePat ?";
            }
            else if(cbxBuscar.getSelectedItem()=="Apellido Materno"){
                consulta="exec COSTOS_COSTOS_SUSTENTACION_DET_PERSONAL_BuscarApeMat ?";
            }
            else {
                consulta="exec COSTOS_COSTOS_SUSTENTACION_DET_PERSONAL_BuscarCargo ?";
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
                fila[12]=r.getString(12);
                fila[13]=r.getString(13);
                m.addRow(fila);
                c++;
            }
            tbPersonalSueldo.setModel(m);
            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m);
            tbPersonalSueldo.setRowSorter(elQueOrdena);
            this.tbPersonalSueldo.setModel(m);
            formatoPersonal();
            tbPersonalSueldo.getSelectionModel().setSelectionInterval(0, 0);
            tbPersonalSueldo.requestFocus();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tbPersonalSueldoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbPersonalSueldoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tbPersonalSueldoKeyReleased

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
            java.util.logging.Logger.getLogger(BUSCAR_PERSONAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BUSCAR_PERSONAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BUSCAR_PERSONAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BUSCAR_PERSONAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BUSCAR_PERSONAL().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox cbxBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tbPersonalSueldo;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
