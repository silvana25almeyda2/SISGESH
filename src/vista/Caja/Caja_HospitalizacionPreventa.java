/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Caja;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.Caja.Caja_NuevaVenta;
import modelos.Caja.Caja_Preventa;
import modelos.admisionCentral.HistoriaClinica;
import modelos.admisionEmergencia.AdmisionEmergenciaCabecera;
import modelos.hospitalizacion.HospitalizacionArticuloDetalle;
import modelos.hospitalizacion.HospitalizacionAsignacionCamas;
import modelos.hospitalizacion.HospitalizacionPapeletas;
import modelos.hospitalizacion.HospitalizacionPisos;
import servicios.Conexion;
import vista.admisionEmergencia.FrmFormatoEmergencia;
import vista.Caja.Caja_Pagos;
import static vista.admisionEmergencia.FrmFormatoEmergencia.lblPestana;
import static vista.admisionEmergencia.FrmFormatoEmergencia.lblPestanaMod;
import static vista.admisionEmergencia.FrmFormatoEmergencia.pnlEObservación;
import static vista.admisionEmergencia.FrmFormatoEmergencia.txtNHC;

/**
 *
 * @author PC02
 */
public class Caja_HospitalizacionPreventa extends javax.swing.JFrame {

    DefaultTableModel m;
    Connection conexion=null;
    Conexion c = new Conexion();
    ResultSet r;
    HospitalizacionPapeletas hosP = new HospitalizacionPapeletas();
    public Caja_HospitalizacionPreventa() {
        initComponents();
        this.setLocationRelativeTo(null);//en el centro
        this.setResizable(false);//deshabilita boton maximizar
        this.getContentPane().setBackground(Color.WHITE);//color blanco del formulario
        conexion = c.conectar();
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/iconos/icons8-Tarea del sistema-24.png")).getImage());
        cbxServicio.setModel(servicios());
        cbxServicio.setBackground(Color.white);
        cbxAreas.setBackground(Color.white);
        cbxCama.setBackground(Color.white);
        btnModificar.setVisible(false);
        btnEliminar.setVisible(false);
        cargareliminar.setVisible(false);
        btnGuardar.setEnabled(false);
        Genero.setLocationRelativeTo(null);
        cbxGenero.setBackground(Color.WHITE);
        habilitarCampos(true);
        //BOTON CERRAR
        getRootPane().getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW).put(
        javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0), "Cancel");
        // BOTON ESCAPE (ESC)
        getRootPane().getActionMap().put("Cancel", new javax.swing.AbstractAction(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e)
            {
                dispose();
            }
        });
        cerrar();
//        lblMant.setVisible(false);
//        lblID.setVisible(false);
//        lblGenero.setVisible(false);
    }
    
    public void cerrar (){
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
    
    
    
    public void habilitarCampos(boolean opcion){
        cbxServicio.setEnabled(opcion);
        cbxAreas.setEnabled(opcion);
        cbxCama.setEnabled(opcion);
        btnAgregar.setEnabled(opcion);
        txtIndicaciones.setEnabled(opcion);
        chkAislado.setEnabled(opcion);
        txtArea.setEnabled(opcion);
    }
    public String formatoNHC(String nhc){
        String codigo = String.valueOf(nhc.charAt(0)) + 
                        String.valueOf(nhc.charAt(1)) + 
                        String.valueOf(nhc.charAt(2)) + 
                        String.valueOf(nhc.charAt(3)) + 
                        String.valueOf(nhc.charAt(5)) +
                        String.valueOf(nhc.charAt(6));
        return codigo;
    }
    
    public void limpiarDatosNHC(){
        lblIDHC.setText("");
        lblEstado.setText("");
        lblGenero.setText("");
    }
    
    public void limpiarDatosServicio(){
        txtMedico.setText("");
        txtArea.setText("");
    }
    
    public void limpiar(){
        lblIDHC.setText("");
        lblEstado.setText("");
        lblGenero.setText("");
        cbxServicio.setSelectedIndex(0);
        cbxAreas.setSelectedIndex(0);
        txtMedico.setText("");
        txtIndicaciones.setText("");
        txtArea.setText("");
        cbxCama.setSelectedIndex(0);
        chkAislado.setSelected(false);
        m = (DefaultTableModel)tbSelecArticulos.getModel();
        int filas = tbSelecArticulos.getRowCount();
        for(int i =0;i<filas;i++){
            m.removeRow(0);
        }
    }
    
    public DefaultComboBoxModel servicios(){
           DefaultComboBoxModel  listmodelS = new DefaultComboBoxModel ();        
           String   sql = null;
           ResultSet rs = null;
           Statement  st = null;   
            try {
                  st = conexion.createStatement();
                  r = st.executeQuery ("EXEC CAJA_SERVICIOS_LISTAR"); 
                  listmodelS.addElement("Seleccionar...");
                while( r.next() ){
                    listmodelS.addElement( r.getString( "SE_DESC" ) );                
                 }
                r.close();
                
            } catch (SQLException ex) {            
                System.err.println( "FrmHospitalizacionPapelete Error: servicios: EXEC HOSPITALIZACION_MOSTRAR_SERVICIOS :" + ex.getMessage() );
            }        
        return listmodelS;
    }
        public DefaultComboBoxModel areas(){
           DefaultComboBoxModel  listmodel = new DefaultComboBoxModel ();        
           String   sql = null;
           ResultSet rs = null;
           Statement  st = null;   
            try {
                  st = conexion.createStatement();
                  r = st.executeQuery ("EXEC SERVICIO_AREAS_LISTAR ?"); 
                  listmodel.addElement("Seleccionar...");
                while( r.next() ){
                    listmodel.addElement( r.getString( "AR_DESC" ) );                
                 }
                r.close();
                
            } catch (SQLException ex) {            
                System.err.println( "FrmHospitalizacionPapelete Error: servicios: EXEC HOSPITALIZACION_MOSTRAR_AREAS :" + ex.getMessage() );
            }        
        return listmodel;
    }
    public boolean repiteArticulos(){
        int filaselec=tbArticulos.getSelectedRow();
        boolean c=false;
        for (int i = 0; i < tbSelecArticulos.getRowCount(); i++){    
            if(tbSelecArticulos.getValueAt(i, 0).toString().equalsIgnoreCase(tbArticulos.getValueAt(filaselec, 0).toString())){
                c=true;
            }
        }
            return c;
     }
     public void AsignarCamas(){
  
                        Caja_Preventa cnoac = new Caja_Preventa();
                        int cama = Integer.parseInt(cnoac.codCama(cbxCama.getSelectedItem().toString()));
                        cnoac.setCA_ID(cama);
                      
                        if(cnoac.camas()==true){
                                   System.out.println("cama asignada");
                                 
                        } else {
                           
                                System.out.println("cama NO asignada");
                         
                        }
                       
    }
    
    public void enviarArticulos(){
        try {
        m = (DefaultTableModel) tbSelecArticulos.getModel();
        int fila = tbArticulos.getSelectedRow();
        if(tbSelecArticulos.getColumnCount()==0){
            dlgArticulos.dispose();
            //PASAR DATOS A TABLA
            String articulos[] = {
            String.valueOf(tbArticulos.getValueAt(fila, 0)),String.valueOf(tbArticulos.getValueAt(fila, 1))};
            m.addRow(articulos);
            //formatotbExamenAux(tbSelecArticulos);
        } else 
        if(repiteArticulos()==true)
            JOptionPane.showMessageDialog(dlgArticulos, "Este artículo ya se encuentra registrado");
        else{
            dlgArticulos.dispose();
            //PASAR DATOS A TABLA
            String articulos[] = {
            String.valueOf(tbArticulos.getValueAt(fila, 0)),String.valueOf(tbArticulos.getValueAt(fila, 1))};
            m.addRow(articulos);
            //formatotbExamenAux(tbSelecArticulos);
        }
        } catch (Exception e) {
            System.out.println("error: enviar" + e.getMessage());
        }
    }
    
     public void Modificar(){
  
                        Caja_Preventa cno = new Caja_Preventa();
                        cno.setId_hc(lblIDHC.getText());//
                        if (cbxGenero.getSelectedIndex()==0){
                            cno.setSexo("F");
                        } else if(cbxGenero.getSelectedIndex()==1){
                            cno.setSexo("M");  
                        }
                        
                        if(cno.ActualizarGenero()==true){
                            System.out.println("GENERO ACTUALIZADO");
                            
                            if (cbxGenero.getSelectedIndex()==0){
                            lblGenero.setText("F");

                            
                            } else if(cbxGenero.getSelectedIndex()==1){
                            lblGenero.setText("M");
//                            cbxServicio.removeAll();
                            }
                            
//                            lblGenero.setText(cbxGenero.getSelectedItem().toString());
                            Genero.dispose();
                           
 
         
                        } else {
                            System.out.println("No se actualizo el DNI");
                            Genero.dispose();
                        }
              
    }
    
    public boolean guardarDatosHospitalizacion(){
        boolean retorna = false;
   
            int id_preventa = 0;
  


                Caja_Preventa cp = new Caja_Preventa();
                Caja_Preventa cp2 = new Caja_Preventa();
                HospitalizacionAsignacionCamas hc = new HospitalizacionAsignacionCamas();
                AdmisionEmergenciaCabecera ademer = new AdmisionEmergenciaCabecera();
                String id_hc = lblIDHC.getText();
                int area = Integer.parseInt(cp.codArea(cbxAreas.getSelectedItem().toString()));
                int cama = Integer.parseInt(cp.codCama(cbxCama.getSelectedItem().toString()));
                String indicaciones = txtIndicaciones.getText();
                String usuario = ademer.codUsuario(lblUsuUsuario.getText());
                int AM = Integer.parseInt(lblActoMedico.getText());
                String FP= lblJerarFP.getText();
                String Medic = lblIdMedic.getText();
                
                    cp.setId_hc(id_hc);
                    cp.setCA_ID(cama);
                    cp.sethOS_Indicaciones(indicaciones);
                    cp.setCod_usu(usuario);
                    cp.setAR_ID(area);
                    cp.setACTO_MEDICO(AM);
                    cp.setCod_jerar_forma_pago(FP);
                    cp.setCod_medico(Medic);
                    cp.setId_documento(jLabel7.getText());
                    
                    
                    if(cp.CAJA_mantenimientoPreventaHospitalizacion()==true){ 
                        System.out.println("PAPELETA DE HOSPITALKIZACION GENERADA");
                        AsignarCamas();
                        Caja_Pagos.lblIdMedico.setText(txtMedico.getText());
                        Caja_Pagos.GuardarPapeleta.setUndecorated(true);
                        Caja_Pagos.GuardarPapeleta.setVisible(true);
                        dispose();
//                        cp.setCA_ID(cama);
//                        cp.setCOD_USU(usuario);
//                        cp.setID_PREVENTA(cp.CajaPreventaID());
//                       if(cp.CAJA_mantenimientoPreventaHospitalizacion()==true){
//                        retorna = true;
//                        }
                    }
                
            

       
        return retorna;
    }
    
    public boolean guardarDatos(){
        boolean retorna = false;
        if(guardarDatosHospitalizacion()==true){
            if(tbSelecArticulos.getRowCount()==0){
                retorna = true;
            } else{
                Caja_Preventa cp = new Caja_Preventa();
                for (int i = 0; i < tbSelecArticulos.getRowCount(); i++){      
                    HospitalizacionArticuloDetalle hopsArt=new HospitalizacionArticuloDetalle();
                    hopsArt.setId_preventa(cp.CajaPreventaID());
                    hopsArt.setDescripcion(tbSelecArticulos.getValueAt(i, 1).toString());
                    hopsArt.setCod_usu(cp.codUsuario(lblUsuUsuario.getText()));
                    if(hopsArt.insertarArticuloDetalle()==true)
                        retorna = true;
                }
            }
        } else 
            return retorna;
        return retorna;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlgArticulos = new javax.swing.JDialog();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbArticulos = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        txtBuscarArt = new javax.swing.JTextField();
        btnBuscarPaciente3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        Genero = new javax.swing.JDialog();
        jPanel55 = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel54 = new javax.swing.JPanel();
        btnNuevo4 = new javax.swing.JButton();
        cbxGenero = new javax.swing.JComboBox();
        jPanel8 = new javax.swing.JPanel();
        lblUsuUsuario = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        lblID = new javax.swing.JLabel();
        lblMant = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        lblIDHC = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtIndicaciones = new javax.swing.JEditorPane();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtArea = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cbxCama = new javax.swing.JComboBox();
        lblEstado = new javax.swing.JLabel();
        cbxServicio = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        cbxAreas = new javax.swing.JComboBox();
        chkAislado = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        lblNomPaciente = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblGenero = new javax.swing.JLabel();
        panelCPT1 = new javax.swing.JPanel();
        txtMedico1 = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbSelecArticulos = new javax.swing.JTable();
        panelCPT = new javax.swing.JPanel();
        txtMedico = new javax.swing.JTextField();
        btnBuscarCPT = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblIdMedic = new javax.swing.JLabel();
        lblActoMedico = new javax.swing.JLabel();
        lblJerarFP = new javax.swing.JLabel();
        lblArea = new javax.swing.JLabel();
        lblCPT = new javax.swing.JLabel();
        cargareliminar = new javax.swing.JPanel();
        Mensaje = new javax.swing.JLabel();
        eli = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();

        dlgArticulos.setAlwaysOnTop(true);
        dlgArticulos.setMinimumSize(new java.awt.Dimension(400, 300));
        dlgArticulos.setResizable(false);

        jScrollPane4.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jScrollPane4.setForeground(new java.awt.Color(51, 51, 51));
        jScrollPane4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        tbArticulos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tbArticulos.setModel(new javax.swing.table.DefaultTableModel(
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
        tbArticulos.setRowHeight(30);
        tbArticulos.setSelectionBackground(new java.awt.Color(102, 102, 102));
        tbArticulos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbArticulosMouseClicked(evt);
            }
        });
        tbArticulos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbArticulosKeyPressed(evt);
            }
        });
        jScrollPane4.setViewportView(tbArticulos);

        jPanel11.setBackground(new java.awt.Color(235, 105, 57));
        jPanel11.setMinimumSize(new java.awt.Dimension(310, 441));

        jLabel21.setFont(new java.awt.Font("Segoe UI Light", 0, 30)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Articulos");

        jPanel28.setBackground(new java.awt.Color(255, 255, 255));

        txtBuscarArt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtBuscarArt.setForeground(new java.awt.Color(98, 98, 98));
        txtBuscarArt.setBorder(null);
        txtBuscarArt.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtBuscarArtCaretUpdate(evt);
            }
        });
        txtBuscarArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarArtActionPerformed(evt);
            }
        });
        txtBuscarArt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarArtKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(txtBuscarArt, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtBuscarArt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnBuscarPaciente3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Búsqueda-27.png"))); // NOI18N
        btnBuscarPaciente3.setContentAreaFilled(false);
        btnBuscarPaciente3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarPaciente3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPaciente3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarPaciente3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(135, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBuscarPaciente3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(353, 353, 353))
        );

        javax.swing.GroupLayout dlgArticulosLayout = new javax.swing.GroupLayout(dlgArticulos.getContentPane());
        dlgArticulos.getContentPane().setLayout(dlgArticulosLayout);
        dlgArticulosLayout.setHorizontalGroup(
            dlgArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dlgArticulosLayout.setVerticalGroup(
            dlgArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgArticulosLayout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        Genero.setAlwaysOnTop(true);
        Genero.setMinimumSize(new java.awt.Dimension(612, 282));
        Genero.setResizable(false);

        jPanel55.setBackground(new java.awt.Color(235, 105, 57));
        jPanel55.setMinimumSize(new java.awt.Dimension(310, 441));

        jLabel75.setFont(new java.awt.Font("Segoe UI Light", 0, 30)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(255, 255, 255));
        jLabel75.setText("No existen Camas ?");

        jLabel76.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 255, 255));
        jLabel76.setText("<HTML>Esto puede deberse a que no haya camas libres  <BR>o el sexo de la persona no es el correcto.</HTML>");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Genero");

        jPanel54.setBackground(new java.awt.Color(43, 43, 43));

        btnNuevo4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnNuevo4.setForeground(new java.awt.Color(240, 240, 240));
        btnNuevo4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/icons8-Género-50.png"))); // NOI18N
        btnNuevo4.setText("Actualizar");
        btnNuevo4.setContentAreaFilled(false);
        btnNuevo4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNuevo4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnNuevo4.setIconTextGap(30);
        btnNuevo4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnNuevo4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel54Layout = new javax.swing.GroupLayout(jPanel54);
        jPanel54.setLayout(jPanel54Layout);
        jPanel54Layout.setHorizontalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNuevo4, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
        );
        jPanel54Layout.setVerticalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addComponent(btnNuevo4)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        cbxGenero.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxGenero.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Femenino", "Masculino" }));

        javax.swing.GroupLayout jPanel55Layout = new javax.swing.GroupLayout(jPanel55);
        jPanel55.setLayout(jPanel55Layout);
        jPanel55Layout.setHorizontalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel55Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(cbxGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel75))
                .addContainerGap(226, Short.MAX_VALUE))
            .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel54, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel55Layout.setVerticalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel75)
                .addGap(18, 18, 18)
                .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbxGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel55Layout.createSequentialGroup()
                    .addGap(191, 191, 191)
                    .addComponent(jPanel54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(157, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout GeneroLayout = new javax.swing.GroupLayout(Genero.getContentPane());
        Genero.getContentPane().setLayout(GeneroLayout);
        GeneroLayout.setHorizontalGroup(
            GeneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        GeneroLayout.setVerticalGroup(
            GeneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel55, javax.swing.GroupLayout.PREFERRED_SIZE, 282, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1060, 495));
        setResizable(false);

        jPanel8.setBackground(new java.awt.Color(235, 105, 57));

        lblUsuUsuario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblUsuUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuUsuario.setText("Silvana");

        btnModificar.setBackground(new java.awt.Color(204, 204, 204));
        btnModificar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Editar-32.png"))); // NOI18N
        btnModificar.setText("Editar");
        btnModificar.setContentAreaFilled(false);
        btnModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar.setEnabled(false);
        btnModificar.setFocusable(false);
        btnModificar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnModificar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnModificar.setIconTextGap(30);
        btnModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(204, 204, 204));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Basura-32.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setContentAreaFilled(false);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.setEnabled(false);
        btnEliminar.setFocusable(false);
        btnEliminar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnEliminar.setIconTextGap(30);
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        lblID.setForeground(new java.awt.Color(235, 105, 57));
        lblID.setText("jLabel14");

        lblMant.setForeground(new java.awt.Color(235, 105, 57));
        lblMant.setText("jLabel14");

        jLabel57.setFont(new java.awt.Font("Segoe UI Light", 0, 36)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setText("<html>Papeleta<span style=\"font-size:'14px'\"><br>Hospitalización</br></span></html>");

        lblIDHC.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblIDHC.setForeground(new java.awt.Color(235, 105, 57));

        jLabel7.setForeground(new java.awt.Color(235, 105, 57));
        jLabel7.setText("jLabel7");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(lblMant)
                                    .addComponent(lblID)
                                    .addComponent(lblUsuUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblIDHC, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(161, 161, 161)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIDHC, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(lblMant)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblUsuUsuario)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Servicio");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Indicaciones para la enfermera");

        txtIndicaciones.setEnabled(false);
        jScrollPane1.setViewportView(txtIndicaciones);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Nota de Admisión");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("El paciente se interna en el Servicio de");

        txtArea.setEditable(false);
        txtArea.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtArea.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Cama");

        cbxCama.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxCama.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione..." }));
        cbxCama.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbxCama.setEnabled(false);

        lblEstado.setForeground(new java.awt.Color(255, 255, 255));

        cbxServicio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxServicio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar..." }));
        cbxServicio.setEnabled(false);
        cbxServicio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxServicioItemStateChanged(evt);
            }
        });
        cbxServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxServicioActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Area");

        cbxAreas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxAreas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar..." }));
        cbxAreas.setEnabled(false);
        cbxAreas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxAreasItemStateChanged(evt);
            }
        });
        cbxAreas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxAreasActionPerformed(evt);
            }
        });

        chkAislado.setFont(new java.awt.Font("Segoe UI Light", 1, 13)); // NOI18N
        chkAislado.setText("Aislado");
        chkAislado.setEnabled(false);
        chkAislado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkAisladoItemStateChanged(evt);
            }
        });
        chkAislado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkAisladoActionPerformed(evt);
            }
        });

        jPanel5.setPreferredSize(new java.awt.Dimension(929, 115));

        lblNomPaciente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNomPaciente.setForeground(new java.awt.Color(51, 51, 51));
        lblNomPaciente.setText("jLabel1");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Género");

        lblGenero.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblGenero.setForeground(new java.awt.Color(51, 51, 51));
        lblGenero.setText("jLabel14");

        panelCPT1.setBackground(new java.awt.Color(255, 255, 255));
        panelCPT1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        txtMedico1.setEditable(false);
        txtMedico1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtMedico1.setForeground(new java.awt.Color(51, 51, 51));
        txtMedico1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtMedico1.setBorder(null);
        txtMedico1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtMedico1CaretUpdate(evt);
            }
        });

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Búsqueda-25.png"))); // NOI18N
        btnAgregar.setContentAreaFilled(false);
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCPT1Layout = new javax.swing.GroupLayout(panelCPT1);
        panelCPT1.setLayout(panelCPT1Layout);
        panelCPT1Layout.setHorizontalGroup(
            panelCPT1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCPT1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtMedico1, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );
        panelCPT1Layout.setVerticalGroup(
            panelCPT1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCPT1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(panelCPT1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMedico1, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Artículos que debe traer el Paciente");

        jScrollPane2.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        tbSelecArticulos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbSelecArticulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Artículo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbSelecArticulos.setRowHeight(40);
        tbSelecArticulos.setSelectionBackground(new java.awt.Color(102, 102, 102));
        tbSelecArticulos.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tbSelecArticulos);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNomPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelCPT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(10, 10, 10)
                                .addComponent(lblGenero)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lblNomPaciente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblGenero))
                .addGap(28, 28, 28)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelCPT1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
        );

        panelCPT.setBackground(new java.awt.Color(255, 255, 255));
        panelCPT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        txtMedico.setEditable(false);
        txtMedico.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtMedico.setForeground(new java.awt.Color(51, 51, 51));
        txtMedico.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtMedico.setBorder(null);
        txtMedico.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtMedicoCaretUpdate(evt);
            }
        });

        btnBuscarCPT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Búsqueda-25.png"))); // NOI18N
        btnBuscarCPT.setContentAreaFilled(false);
        btnBuscarCPT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarCPT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCPTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCPTLayout = new javax.swing.GroupLayout(panelCPT);
        panelCPT.setLayout(panelCPTLayout);
        panelCPTLayout.setHorizontalGroup(
            panelCPTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCPTLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtMedico, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarCPT, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );
        panelCPTLayout.setVerticalGroup(
            panelCPTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCPTLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(panelCPTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMedico, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(btnBuscarCPT, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Médico");

        lblIdMedic.setForeground(new java.awt.Color(255, 255, 255));
        lblIdMedic.setText("jLabel2");

        lblActoMedico.setForeground(new java.awt.Color(255, 255, 255));
        lblActoMedico.setText("jLabel2");

        lblJerarFP.setForeground(new java.awt.Color(255, 255, 255));
        lblJerarFP.setText("jLabel2");

        lblArea.setForeground(new java.awt.Color(255, 255, 255));
        lblArea.setText("jLabel2");

        lblCPT.setForeground(new java.awt.Color(255, 255, 255));
        lblCPT.setText("jLabel2");

        cargareliminar.setBackground(new java.awt.Color(0, 153, 102));

        Mensaje.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Mensaje.setForeground(new java.awt.Color(255, 255, 255));
        Mensaje.setText("Datos Guardados Correctamente");

        eli.setForeground(new java.awt.Color(240, 240, 240));
        eli.setText("OK");
        eli.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        eli.setContentAreaFilled(false);
        eli.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eli.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eli.setIconTextGap(30);
        eli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cargareliminarLayout = new javax.swing.GroupLayout(cargareliminar);
        cargareliminar.setLayout(cargareliminarLayout);
        cargareliminarLayout.setHorizontalGroup(
            cargareliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cargareliminarLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(Mensaje)
                .addGap(46, 46, 46)
                .addComponent(eli, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cargareliminarLayout.setVerticalGroup(
            cargareliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cargareliminarLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(cargareliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Mensaje)
                    .addComponent(eli, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/icons8-Ayuda Filled-25.png"))); // NOI18N
        jLabel3.setText("Ayuda");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(43, 43, 43));

        btnGuardar.setBackground(new java.awt.Color(204, 204, 204));
        btnGuardar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Guardar-32.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnGuardar.setIconTextGap(30);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(cargareliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbxServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbxAreas, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(chkAislado)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbxCama, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel3))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(76, 76, 76)
                                        .addComponent(panelCPT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 28, Short.MAX_VALUE))
                            .addComponent(jScrollPane1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(lblIdMedic)
                                .addGap(18, 18, 18)
                                .addComponent(lblActoMedico)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblJerarFP)
                                .addGap(18, 18, 18)
                                .addComponent(lblArea)
                                .addGap(18, 18, 18)
                                .addComponent(lblCPT))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(256, 256, 256)
                                .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(cbxServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbxAreas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(chkAislado)
                            .addComponent(jLabel10)
                            .addComponent(cbxCama, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(panelCPT, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cargareliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99)
                .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdMedic)
                    .addComponent(lblActoMedico)
                    .addComponent(lblJerarFP)
                    .addComponent(lblArea)
                    .addComponent(lblCPT))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(guardarDatos()==true){
            cargareliminar.setVisible(true);
            limpiar();
            habilitarCampos(false);
            btnGuardar.setEnabled(false);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
       
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void cbxAreasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxAreasItemStateChanged
        Caja_Preventa cp = new Caja_Preventa();
        if(cbxAreas.getSelectedIndex()>0){
            txtArea.setText(cbxAreas.getSelectedItem().toString());
            lblArea.setText((cp.codArea(cbxAreas.getSelectedItem().toString()))); 
            
             String tipo = "";
        if(chkAislado.isSelected())
            tipo = "aislado";
        else
            tipo = "";
        try{  
            HospitalizacionPisos hos = new HospitalizacionPisos();
                    if(this.cbxServicio.getSelectedIndex()>0){
                        this.cbxCama.removeAllItems(); 
                    Statement sta=conexion.createStatement();
                    //int servicio = Integer.parseInt(hos.codServicio(cbxServicio.getSelectedItem().toString()));
                    String genero = lblGenero.getText();
                    
                    ResultSet rs=sta.executeQuery("EXEC CAJA_CAMAS_LISTAR_LIBRES '"+genero+"','" + cbxServicio.getSelectedItem() +"','" + tipo+"'");
                    this.cbxCama.addItem("Seleccionar...");
                    while(rs.next()){
                     this.cbxCama.addItem(rs.getString("CA_DESC"));
//                    this.cbxCama.setModel(null);
                    }
                     }else{
                            this.cbxCama.removeAllItems();

                        this.cbxCama.addItem("Seleccionar...");
                            }

            }
            catch(Exception ex) 
            {
                System.out.println("Error: " + ex.getMessage());
            }
        if(cbxCama.getItemCount()==1){
            cbxCama.setEnabled(false);
        }else
            cbxCama.setEnabled(true);
        }
        else
            txtArea.setText("");
    }//GEN-LAST:event_cbxAreasItemStateChanged

    private void tbArticulosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbArticulosKeyPressed
        char teclaPresionada = evt.getKeyChar(); 
        if(teclaPresionada==KeyEvent.VK_ENTER)
            enviarArticulos();
    }//GEN-LAST:event_tbArticulosKeyPressed

    private void chkAisladoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkAisladoItemStateChanged
        
    }//GEN-LAST:event_chkAisladoItemStateChanged

    private void chkAisladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkAisladoActionPerformed
        String tipo = "";
        if(chkAislado.isSelected())
            tipo = "aislado";
        else
            tipo = "";
        try{  
            HospitalizacionPisos hos = new HospitalizacionPisos();
                    if(this.cbxServicio.getSelectedIndex()>0){
                        this.cbxCama.removeAllItems(); 
                    Statement sta=conexion.createStatement();
                    //int servicio = Integer.parseInt(hos.codServicio(cbxServicio.getSelectedItem().toString()));
                    String genero = lblGenero.getText();
                    
                    ResultSet rs=sta.executeQuery("EXEC CAJA_CAMAS_LISTAR_LIBRES '"+genero+"','" + cbxServicio.getSelectedItem() +"','" + tipo+"'");
                    this.cbxCama.addItem("Seleccionar...");
                    while(rs.next()){
                     this.cbxCama.addItem(rs.getString("CA_DESC"));
                  //  this.cbxProvincia.setModel(null);
                    }
                     }else{
                            this.cbxCama.removeAllItems();

                        this.cbxCama.addItem("Seleccionar...");
                            }

            }
            catch(Exception ex) 
            {
                System.out.println("Error: " + ex.getMessage());
            }
        if(cbxCama.getItemCount()==1){
            cbxCama.setEnabled(false);
        }else
            cbxCama.setEnabled(true);
    }//GEN-LAST:event_chkAisladoActionPerformed

    private void cbxAreasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxAreasActionPerformed
        
    }//GEN-LAST:event_cbxAreasActionPerformed

    private void cbxServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxServicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxServicioActionPerformed

    private void cbxServicioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxServicioItemStateChanged
          try{  
                if(evt.getStateChange()==ItemEvent.SELECTED){
                    if(this.cbxServicio.getSelectedIndex()>0){
                        this.cbxAreas.removeAllItems(); 
                    Statement sta=conexion.createStatement();
                    String dpto=cbxServicio.getSelectedItem().toString();
                    ResultSet rs=sta.executeQuery("EXEC CAJA_SERVICIO_AREAS_LISTAR '"+dpto+"'");
                    this.cbxAreas.addItem("Seleccionar...");
                    while(rs.next()){
                     this.cbxAreas.addItem(rs.getString("AR_DESC"));
                  //  this.cbxAreas.setModel(null);
                    }
                     }else{
                            this.cbxAreas.removeAllItems();

                        this.cbxAreas.addItem("Seleccionar...");
                            }
                    
            }
     
            HospitalizacionPisos hos = new HospitalizacionPisos();
            if(this.cbxServicio.getSelectedIndex()==1){
                this.cbxCama.removeAllItems();
                Statement sta=conexion.createStatement();
                //int servicio = Integer.parseInt(hos.codServicio(cbxServicio.getSelectedItem().toString()));
                String genero = lblGenero.getText();

                ResultSet rs=sta.executeQuery("EXEC CAJA_CAMAS_LISTAR_LIBRES '"+genero+"','" +cbxServicio.getSelectedItem()+"','" + "" +"'");
                this.cbxCama.addItem("Seleccionar...");
                while(rs.next()){
                    this.cbxCama.addItem(rs.getString("CA_DESC"));
                    //  this.cbxProvincia.setModel(null);
                }
            }else{
                this.cbxCama.removeAllItems();

                this.cbxCama.addItem("Seleccionar...");
            }

        }
        
        catch(Exception ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }
        if(cbxCama.getItemCount()==1){
            cbxCama.setEnabled(false);
        }else
        cbxCama.setEnabled(true);

    }//GEN-LAST:event_cbxServicioItemStateChanged

    private void tbArticulosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbArticulosMouseClicked
        if(evt.getClickCount()==2){
            enviarArticulos();
        }
    }//GEN-LAST:event_tbArticulosMouseClicked

    private void txtBuscarArtCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtBuscarArtCaretUpdate
        HospitalizacionPapeletas hosP = new HospitalizacionPapeletas();
        hosP.hospitalizacionArticulosListar(tbArticulos,txtBuscarArt.getText());
        
    }//GEN-LAST:event_txtBuscarArtCaretUpdate

    private void txtBuscarArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarArtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarArtActionPerformed

    private void txtBuscarArtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarArtKeyPressed
       if(evt.getExtendedKeyCode()==KeyEvent.VK_DOWN){
            tbArticulos.getSelectionModel().setSelectionInterval(0,0);
            tbArticulos.requestFocus();
        }
    }//GEN-LAST:event_txtBuscarArtKeyPressed

    private void btnBuscarPaciente3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPaciente3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarPaciente3ActionPerformed

    private void txtMedicoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtMedicoCaretUpdate

    }//GEN-LAST:event_txtMedicoCaretUpdate

    private void btnBuscarCPTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCPTActionPerformed
            Caja_NuevaVenta CNV = new Caja_NuevaVenta();
            Caja_Pagos.MedicosPepeleta.setVisible(true);
            CNV.listarMedicosPapeleta(lblArea.getText(),Caja_Pagos.tb_medicosPapeleta);
            Caja_Pagos.BMedicosPapeleta.setText(null);
            Caja_Pagos.BMedicosPapeleta.requestFocus();    
            btnGuardar.setEnabled(true);
    }//GEN-LAST:event_btnBuscarCPTActionPerformed

    private void eliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliActionPerformed

            cargareliminar.setVisible(false);
    }//GEN-LAST:event_eliActionPerformed

    private void btnNuevo4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo4ActionPerformed
        Modificar();
        cbxServicio.setVisible(true);    
        cbxServicio.showPopup();
        cbxServicio.requestFocus(true);
    }//GEN-LAST:event_btnNuevo4ActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        Genero.setVisible(true);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void txtMedico1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtMedico1CaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMedico1CaretUpdate

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
         dlgArticulos.setVisible(true);
        dlgArticulos.setLocationRelativeTo(null);//en el centro
        dlgArticulos.setResizable(false);
        dlgArticulos.getContentPane().setBackground(Color.WHITE);
        HospitalizacionPapeletas hosP = new HospitalizacionPapeletas();
        hosP.hospitalizacionArticulosListar(tbArticulos,txtBuscarArt.getText());
        tbArticulos.getSelectionModel().setSelectionInterval(0,0);
        txtBuscarArt.requestFocus();
    }//GEN-LAST:event_btnAgregarActionPerformed

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
            java.util.logging.Logger.getLogger(Caja_HospitalizacionPreventa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Caja_HospitalizacionPreventa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Caja_HospitalizacionPreventa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Caja_HospitalizacionPreventa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Caja_HospitalizacionPreventa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDialog Genero;
    private javax.swing.JLabel Mensaje;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscarCPT;
    private javax.swing.JButton btnBuscarPaciente3;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    public static javax.swing.JButton btnNuevo4;
    private javax.swing.JPanel cargareliminar;
    private javax.swing.JComboBox cbxAreas;
    public static javax.swing.JComboBox cbxCama;
    private javax.swing.JComboBox cbxGenero;
    public static javax.swing.JComboBox cbxServicio;
    private javax.swing.JCheckBox chkAislado;
    private javax.swing.JDialog dlgArticulos;
    private javax.swing.JButton eli;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel6;
    public static javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    public static javax.swing.JLabel lblActoMedico;
    private javax.swing.JLabel lblArea;
    private javax.swing.JLabel lblCPT;
    public static javax.swing.JLabel lblEstado;
    public static javax.swing.JLabel lblGenero;
    public static javax.swing.JLabel lblID;
    public static javax.swing.JLabel lblIDHC;
    public static javax.swing.JLabel lblIdMedic;
    public static javax.swing.JLabel lblJerarFP;
    private javax.swing.JLabel lblMant;
    public static javax.swing.JLabel lblNomPaciente;
    public static javax.swing.JLabel lblUsuUsuario;
    private javax.swing.JPanel panelCPT;
    private javax.swing.JPanel panelCPT1;
    private javax.swing.JTable tbArticulos;
    public static javax.swing.JTable tbSelecArticulos;
    public static javax.swing.JTextField txtArea;
    private javax.swing.JTextField txtBuscarArt;
    public static javax.swing.JEditorPane txtIndicaciones;
    public static javax.swing.JTextField txtMedico;
    public static javax.swing.JTextField txtMedico1;
    // End of variables declaration//GEN-END:variables
}
