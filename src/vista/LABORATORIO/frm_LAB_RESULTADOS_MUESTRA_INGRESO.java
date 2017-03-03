
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.LABORATORIO;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import modelos.LABORATORIO.Celda_Checkox;
import modelos.LABORATORIO.LAB_Analisis_Detalle;
import modelos.LABORATORIO.LAB_Analisis_Examen;
import modelos.LABORATORIO.LAB_Clasificacion_Examen;
import modelos.LABORATORIO.LAB_Muestra_Examen;
import modelos.LABORATORIO.LAB_PC_AREA;
import modelos.LABORATORIO.Render_Checkbox;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import servicios.Conexion;
import static vista.LABORATORIO.frm_LAB_TOMA_MUESTRA_CABECERA.lblDocumento;
import static vista.Principal.fechaActual;
import vista.frmlaboratorioClinico;

/**
 *
 * @author PC-SISTEMA
 */
public class frm_LAB_RESULTADOS_MUESTRA_INGRESO extends javax.swing.JFrame implements Runnable{
String hora, minutos, segundos, ampm;
    Calendar calendario;
    Thread h1;
    Connection conexion=null;
Conexion c=new Conexion();
DefaultTableModel m,n,muestra;
    /**
     * Creates new form LAB_MUESTRA_EXAMEN
     */
    public frm_LAB_RESULTADOS_MUESTRA_INGRESO() {
        initComponents();
        c.conectar();
     
        h1 = new Thread(this);
        h1.start();
        buscar_HC.getContentPane().setBackground(Color.white); 
        buscar_HC.setLocationRelativeTo(null);
     
        panelPacientes.setBackground(Color.white);
         chPacientes.setVisible(false);
        txtPacientes.setVisible(false);
            btnPacientes.setVisible(false);
            chNToma.setVisible(false);
            txtNToma.setVisible(false);
            btnNToma.setVisible(false);

//        lblServicio.setVisible(false);
//        lblArea.setVisible(false);
        this.getContentPane().setBackground(Color.white); 
      formato();
        setLocationRelativeTo(null);//en el centro
        setResizable(false);//para que no funcione el boton maximizar
        buscar_HC.setResizable(false);
        dateDesde.setBackground(Color.white);
        dateHasta.setBackground(Color.white);
        //fecha
       Calendar cal=Calendar.getInstance(); 
        String hora=cal.get(cal.HOUR_OF_DAY)+":"+cal.get(cal.MINUTE)+":"+cal.get(cal.SECOND); 
        lblFecha.setText(fechaActual());
       
    dateDesde.requestFocus();
  
 
    //Servicio-Area
        LAB_PC_AREA pa=new LAB_PC_AREA();
        lblServicio.setText(pa.LAB_PC_AREA_SERVICIO());
        lblArea.setText(pa.LAB_PC_AREA_AREA());
      
   //salir presionando escape
        getRootPane().getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW).put(
        javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0), "Cancel");
        getRootPane().getActionMap().put("Cancel", new javax.swing.AbstractAction(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e){
                dispose();
            } });
    }
    
    public void formato(){
    tb_TomasRealizadas.getColumnModel().getColumn(4).setPreferredWidth(180);
    tb_TomasRealizadas.getColumnModel().getColumn(5).setPreferredWidth(100);
    tb_TomasRealizadas.getColumnModel().getColumn(6).setPreferredWidth(250);
    tb_TomasRealizadas.getColumnModel().getColumn(7).setPreferredWidth(250);
    tb_TomasRealizadas.getColumnModel().getColumn(8).setPreferredWidth(140);
    tb_TomasRealizadas.getColumnModel().getColumn(9).setPreferredWidth(90);
    tb_TomasRealizadas.getColumnModel().getColumn(10).setPreferredWidth(250);
    tb_TomasRealizadas.getColumnModel().getColumn(11).setPreferredWidth(85);
    tb_TomasRealizadas.getColumnModel().getColumn(12).setPreferredWidth(140);
    tb_TomasRealizadas.getColumnModel().getColumn(13).setPreferredWidth(50);
    tb_TomasRealizadas.getColumnModel().getColumn(14).setPreferredWidth(50);
    tb_TomasRealizadas.getColumnModel().getColumn(15).setPreferredWidth(130);
    //Ocultar    
//    tb_TomasRealizadas.getColumnModel().getColumn(0).setMinWidth(0);
//    tb_TomasRealizadas.getColumnModel().getColumn(0).setMaxWidth(0);
//    tb_TomasRealizadas.getColumnModel().getColumn(8).setMinWidth(0);
//    tb_TomasRealizadas.getColumnModel().getColumn(8).setMaxWidth(0);
//    tb_TomasRealizadas.getColumnModel().getColumn(9).setMinWidth(0);
//    tb_TomasRealizadas.getColumnModel().getColumn(9).setMaxWidth(0);
//    tb_TomasRealizadas.getSelectionModel().setSelectionInterval(0, 0);
//            tb_TomasRealizadas.requestFocus();
}
    public void LAB_HC_cargar(){
    try {
             String titulos[]={"N°","N° H.C.","Paciente","Dirección","DNI","Sexo","Fecha de Nac.","Edad","COdigo"};
            m=new DefaultTableModel(null,titulos);
            JTable p=new JTable(m);
            String fila[]=new String[9];

            LAB_Clasificacion_Examen obj=new LAB_Clasificacion_Examen();
        String consulta="exec Caja_BuscarHC ?";
        
        PreparedStatement cmd = obj.getCn().prepareStatement(consulta);
            cmd.setString(1, "");
        ResultSet r=cmd.executeQuery();
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
                m.addRow(fila);
                c++;
            }
            tb_HC.setModel(m);
            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m);
            tb_HC.setRowSorter(elQueOrdena);
            this.tb_HC.setModel(m);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(rootPane, "Error en la tabla");
    }
}
    public void LAB_HC_formato(){
    tb_HC.getColumnModel().getColumn(0).setPreferredWidth(40);
    tb_HC.getColumnModel().getColumn(1).setPreferredWidth(100);
    tb_HC.getColumnModel().getColumn(2).setPreferredWidth(230);
    tb_HC.getColumnModel().getColumn(3).setPreferredWidth(180);
    tb_HC.getColumnModel().getColumn(4).setPreferredWidth(100);
    tb_HC.getColumnModel().getColumn(5).setPreferredWidth(80);
    tb_HC.getColumnModel().getColumn(6).setPreferredWidth(150);
    tb_HC.getColumnModel().getColumn(7).setPreferredWidth(100);
    
            //Ocultar    
    tb_HC.getColumnModel().getColumn(8).setMinWidth(0);
    tb_HC.getColumnModel().getColumn(8).setMaxWidth(0);
    tb_HC.getSelectionModel().setSelectionInterval(0, 0);
            tb_HC.requestFocus();
}
    
//    public void LAB_Unidad_Organica_cargar(){
//    try {
//             String titulos[]={"Nº","Código","Código","Área"};
//            m=new DefaultTableModel(null,titulos);
//            JTable p=new JTable(m);
//            String fila[]=new String[6];
//
//            Conexion obj=new Conexion();
//        String consulta="exec sp_LAB_CLASIFICACION_EXAMEN_UNIDAD_ORGAN_listar";
//        ResultSet r;
//        r=obj.Listar(consulta);
//        int c=1;
//        while(r.next()){
//            fila[0]=String.valueOf(c)+"º";
//            fila[1]=r.getString(1);
//            fila[2]=r.getString(2);
//            fila[3]=r.getString(3);
//                m.addRow(fila);
//                c++;
//            }
//            tb_Unidad_Organica.setModel(m);
//            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m);
//            tb_Unidad_Organica.setRowSorter(elQueOrdena);
//            this.tb_Unidad_Organica.setModel(m);
//    } catch (Exception e) {
//        JOptionPane.showMessageDialog(rootPane, "Error en la tabla");
//    }
//}
//    public void LAB_Unidad_Organica_formato(){
//    tb_Unidad_Organica.getColumnModel().getColumn(0).setPreferredWidth(50);
//    tb_Unidad_Organica.getColumnModel().getColumn(2).setPreferredWidth(70);
//    tb_Unidad_Organica.getColumnModel().getColumn(3).setPreferredWidth(180);
//        tb_Unidad_Organica.getColumnModel().getColumn(1).setMinWidth(0);
//    tb_Unidad_Organica.getColumnModel().getColumn(1).setMaxWidth(0);
//    tb_Unidad_Organica.getSelectionModel().setSelectionInterval(0, 0);
//            tb_Unidad_Organica.requestFocus();
//}
    
    
  

    
public void calcula() {
        Calendar calendario = new GregorianCalendar();
        java.util.Date fechaHoraActual = new java.util.Date();

        calendario.setTime(fechaHoraActual);
        ampm = calendario.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";

        if (ampm.equals("PM")) {
            int h = calendario.get(Calendar.HOUR_OF_DAY) - 12;
            hora = h > 9 ? "" + h : "0" + h;
        } else {
            hora = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY) : "0" + calendario.get(Calendar.HOUR_OF_DAY);
        }
        minutos = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE) : "0" + calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND) : "0" + calendario.get(Calendar.SECOND);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buscar_HC = new javax.swing.JDialog();
        btnBuscar1 = new javax.swing.JButton();
        txtbuscarHC = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_HC = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false; //Disallow the editing of any cell
            }};
            jpanel = new javax.swing.JPanel();
            titulo5 = new javax.swing.JLabel();
            jLabel14 = new javax.swing.JLabel();
            lblFecha = new javax.swing.JLabel();
            jLabel15 = new javax.swing.JLabel();
            lblHora = new javax.swing.JLabel();
            lblUsu = new javax.swing.JLabel();
            jPanel1 = new javax.swing.JPanel();
            jLabel3 = new javax.swing.JLabel();
            jLabel10 = new javax.swing.JLabel();
            jScrollPane5 = new javax.swing.JScrollPane();
            tb_TomasRealizadas = new javax.swing.JTable(){
                public boolean isCellEditable(int rowIndex, int colIndex){
                    if(colIndex==0){
                        return true;
                    }else{
                        return false; //Disallow the editing of any cell
                    }}};
                    btnGuardar = new javax.swing.JButton();
                    lblServicio = new javax.swing.JLabel();
                    lblArea = new javax.swing.JLabel();
                    panelPacientes = new javax.swing.JPanel();
                    chPacientes = new javax.swing.JCheckBox();
                    txtPacientes = new javax.swing.JTextField();
                    btnPacientes = new javax.swing.JButton();
                    chNToma = new javax.swing.JCheckBox();
                    txtNToma = new javax.swing.JTextField();
                    btnNToma = new javax.swing.JButton();
                    dateDesde = new com.toedter.calendar.JDateChooser();
                    dateHasta = new com.toedter.calendar.JDateChooser();
                    jLabel20 = new javax.swing.JLabel();
                    jLabel21 = new javax.swing.JLabel();
                    cbx = new javax.swing.JComboBox();
                    jLabel19 = new javax.swing.JLabel();

                    buscar_HC.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                    buscar_HC.setTitle("SISGESH.::.Clasificación Examen");
                    buscar_HC.setMinimumSize(new java.awt.Dimension(876, 692));

                    btnBuscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/view.gif"))); // NOI18N
                    btnBuscar1.setBorder(null);
                    btnBuscar1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            btnBuscar1ActionPerformed(evt);
                        }
                    });

                    txtbuscarHC.setForeground(new java.awt.Color(0, 51, 51));
                    txtbuscarHC.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            txtbuscarHCActionPerformed(evt);
                        }
                    });
                    txtbuscarHC.addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyPressed(java.awt.event.KeyEvent evt) {
                            txtbuscarHCKeyPressed(evt);
                        }
                        public void keyTyped(java.awt.event.KeyEvent evt) {
                            txtbuscarHCKeyTyped(evt);
                        }
                    });

                    jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
                    jLabel1.setText("Búsqueda de H.C");

                    tb_HC.setModel(new javax.swing.table.DefaultTableModel(
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
                    tb_HC.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
                    tb_HC.setRowHeight(25);
                    tb_HC.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                            tb_HCMouseClicked(evt);
                        }
                    });
                    tb_HC.addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyPressed(java.awt.event.KeyEvent evt) {
                            tb_HCKeyPressed(evt);
                        }
                    });
                    jScrollPane1.setViewportView(tb_HC);

                    javax.swing.GroupLayout buscar_HCLayout = new javax.swing.GroupLayout(buscar_HC.getContentPane());
                    buscar_HC.getContentPane().setLayout(buscar_HCLayout);
                    buscar_HCLayout.setHorizontalGroup(
                        buscar_HCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(buscar_HCLayout.createSequentialGroup()
                            .addGap(300, 300, 300)
                            .addComponent(txtbuscarHC, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buscar_HCLayout.createSequentialGroup()
                            .addGap(0, 345, Short.MAX_VALUE)
                            .addComponent(jLabel1)
                            .addGap(330, 330, 330))
                        .addGroup(buscar_HCLayout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addComponent(jScrollPane1)
                            .addGap(19, 19, 19))
                    );
                    buscar_HCLayout.setVerticalGroup(
                        buscar_HCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buscar_HCLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addGroup(buscar_HCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtbuscarHC, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(38, Short.MAX_VALUE))
                    );

                    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                    setTitle("SISGESH .::. Análisis Examen");

                    jpanel.setBackground(new java.awt.Color(2, 67, 115));

                    titulo5.setBackground(new java.awt.Color(0, 102, 102));
                    titulo5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
                    titulo5.setForeground(new java.awt.Color(255, 255, 255));
                    titulo5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    titulo5.setText("Tomas de Muestras Realizadas");
                    titulo5.setToolTipText("");
                    titulo5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

                    jLabel14.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
                    jLabel14.setForeground(new java.awt.Color(255, 255, 255));
                    jLabel14.setText("Fecha:");

                    lblFecha.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
                    lblFecha.setForeground(new java.awt.Color(255, 255, 255));
                    lblFecha.setText("00/00/00");

                    jLabel15.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
                    jLabel15.setForeground(new java.awt.Color(255, 255, 255));
                    jLabel15.setText("Hora:");

                    lblHora.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
                    lblHora.setForeground(new java.awt.Color(255, 255, 255));
                    lblHora.setText("00:00:00");

                    lblUsu.setFont(new java.awt.Font("Palatino Linotype", 1, 12)); // NOI18N
                    lblUsu.setForeground(new java.awt.Color(255, 255, 255));
                    lblUsu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/User-32.png"))); // NOI18N
                    lblUsu.setText("Usuario");

                    javax.swing.GroupLayout jpanelLayout = new javax.swing.GroupLayout(jpanel);
                    jpanel.setLayout(jpanelLayout);
                    jpanelLayout.setHorizontalGroup(
                        jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelLayout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addComponent(titulo5)
                            .addGap(147, 147, 147)
                            .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jpanelLayout.createSequentialGroup()
                                    .addComponent(jLabel15)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lblHora))
                                .addGroup(jpanelLayout.createSequentialGroup()
                                    .addComponent(jLabel14)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblFecha))
                                .addComponent(lblUsu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    );
                    jpanelLayout.setVerticalGroup(
                        jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpanelLayout.createSequentialGroup()
                            .addComponent(titulo5)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(jpanelLayout.createSequentialGroup()
                            .addGap(4, 4, 4)
                            .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel14)
                                .addComponent(lblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel15)
                                .addComponent(lblHora))
                            .addGap(3, 3, 3)
                            .addComponent(lblUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                    );

                    jPanel1.setBackground(new java.awt.Color(204, 204, 204));
                    jPanel1.setPreferredSize(new java.awt.Dimension(721, 25));

                    jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/salir16x16.png"))); // NOI18N
                    jLabel3.setText("Salir (Esc)");

                    jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Search-16.png"))); // NOI18N
                    jLabel10.setText("Buscar (Alt+B)");

                    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                    jPanel1.setLayout(jPanel1Layout);
                    jPanel1Layout.setHorizontalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGap(550, 550, 550)
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3)
                            .addGap(8, 8, 8))
                    );
                    jPanel1Layout.setVerticalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGap(5, 5, 5)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    );

                    tb_TomasRealizadas.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {

                        },
                        new String [] {
                            "cod_cab_toma_mu_exa", "cod_det_toma_mu_ana", "cod_exa_ana", "id_hc", "Servicio/Área", "Código CPT", "Nomenclatura", "Analisis Examen", "N° de Toma de Muestra", "N° de H.C", "Datos del Paciente", "DNI", "Fecha de Nacimiento", "Edad", "Sexo", "Forma de Pago", "Acto Medico", "Nombre Per Toma Muestra", "fecha_toma_mu_de", "hora_toma_mu_de", "nom_per_solicita", "hab_nom", "cama", "fecha_orden", "hora_orden", "Documento"
                        }
                    ) {
                        boolean[] canEdit = new boolean [] {
                            true, false, true, true, false, true, true, false, true, false, false, false, false, false, false, false, false, true, true, true, true, true, true, true, true, false
                        };

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                            return canEdit [columnIndex];
                        }
                    });
                    tb_TomasRealizadas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
                    tb_TomasRealizadas.setRowHeight(20);
                    tb_TomasRealizadas.setSelectionBackground(new java.awt.Color(2, 67, 115));
                    tb_TomasRealizadas.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                            tb_TomasRealizadasMouseClicked(evt);
                        }
                        public void mouseReleased(java.awt.event.MouseEvent evt) {
                            tb_TomasRealizadasMouseReleased(evt);
                        }
                    });
                    tb_TomasRealizadas.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
                        public void propertyChange(java.beans.PropertyChangeEvent evt) {
                            tb_TomasRealizadasPropertyChange(evt);
                        }
                    });
                    tb_TomasRealizadas.addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyPressed(java.awt.event.KeyEvent evt) {
                            tb_TomasRealizadasKeyPressed(evt);
                        }
                        public void keyTyped(java.awt.event.KeyEvent evt) {
                            tb_TomasRealizadasKeyTyped(evt);
                        }
                    });
                    jScrollPane5.setViewportView(tb_TomasRealizadas);
                    if (tb_TomasRealizadas.getColumnModel().getColumnCount() > 0) {
                        tb_TomasRealizadas.getColumnModel().getColumn(13).setResizable(false);
                        tb_TomasRealizadas.getColumnModel().getColumn(14).setResizable(false);
                    }

                    btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/guardar16x16.png"))); // NOI18N
                    btnGuardar.setMnemonic('B');
                    btnGuardar.setText("Buscar");
                    btnGuardar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            btnGuardarActionPerformed(evt);
                        }
                    });

                    lblServicio.setText("servicio");

                    lblArea.setText("area");

                    chPacientes.setText("Todos los Pacientes");
                    chPacientes.addItemListener(new java.awt.event.ItemListener() {
                        public void itemStateChanged(java.awt.event.ItemEvent evt) {
                            chPacientesItemStateChanged(evt);
                        }
                    });

                    txtPacientes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
                    txtPacientes.setForeground(new java.awt.Color(0, 51, 51));

                    btnPacientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Search-16.png"))); // NOI18N
                    btnPacientes.setBorder(null);
                    btnPacientes.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            btnPacientesActionPerformed(evt);
                        }
                    });

                    chNToma.setText("Todos los N° de Toma de M.");
                    chNToma.addItemListener(new java.awt.event.ItemListener() {
                        public void itemStateChanged(java.awt.event.ItemEvent evt) {
                            chNTomaItemStateChanged(evt);
                        }
                    });

                    txtNToma.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
                    txtNToma.setForeground(new java.awt.Color(0, 51, 51));

                    btnNToma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Search-16.png"))); // NOI18N
                    btnNToma.setBorder(null);
                    btnNToma.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            btnNTomaActionPerformed(evt);
                        }
                    });

                    javax.swing.GroupLayout panelPacientesLayout = new javax.swing.GroupLayout(panelPacientes);
                    panelPacientes.setLayout(panelPacientesLayout);
                    panelPacientesLayout.setHorizontalGroup(
                        panelPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelPacientesLayout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addGroup(panelPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(chPacientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(chNToma, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panelPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtPacientes)
                                .addComponent(txtNToma))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panelPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnPacientes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnNToma, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(22, 22, 22))
                    );
                    panelPacientesLayout.setVerticalGroup(
                        panelPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelPacientesLayout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addGroup(panelPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(chPacientes))
                                .addComponent(btnPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panelPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNToma, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(chNToma))
                                .addComponent(btnNToma, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(3, 3, 3))
                    );

                    dateDesde.setDateFormatString("dd-MM-yyyy");

                    dateHasta.setDateFormatString("dd-MM-yyyy");

                    jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    jLabel20.setText("Hasta");

                    jLabel21.setText("Búsqueda por:");

                    cbx.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar...", "N° de H.C", "N° de Toma de Muestra" }));
                    cbx.addItemListener(new java.awt.event.ItemListener() {
                        public void itemStateChanged(java.awt.event.ItemEvent evt) {
                            cbxItemStateChanged(evt);
                        }
                    });

                    jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    jLabel19.setText("Desde");

                    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                    getContentPane().setLayout(layout);
                    layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cbx, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(dateDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblServicio)
                                                .addComponent(lblArea))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(10, 10, 10)
                                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(499, 499, 499))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(dateHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addGap(45, 45, 45)
                                                            .addComponent(panelPacientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(btnGuardar)
                                                            .addGap(51, 51, 51))))))))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(13, 13, 13)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane5)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE))))
                            .addGap(13, 13, 13))
                    );
                    layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(24, 24, 24)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(panelPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(11, 11, 11)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(dateDesde, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                                        .addComponent(dateHasta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel21))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lblServicio)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblArea)
                                    .addGap(10, 10, 10)))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    );

                    pack();
                }// </editor-fold>//GEN-END:initComponents

    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed
        // TODO add your handling code here:
        String consulta="";
        try {
            tb_HC.setModel(new DefaultTableModel());
            String titulos[]={"N°","N° H.C.","Paciente","Dirección","DNI","Sexo","Fecha de Nac.","Edad","COdigo"};
           m=new DefaultTableModel(null,titulos);
            JTable p=new JTable(m);
            String fila[]=new String[9];

            LAB_Clasificacion_Examen obj=new LAB_Clasificacion_Examen();
            consulta="exec Caja_BuscarHC ?";

            PreparedStatement cmd = obj.getCn().prepareStatement(consulta);
            cmd.setString(1, txtbuscarHC.getText());
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
                m.addRow(fila);
                c++;
            }
            tb_HC.setModel(m);
            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m);
            tb_HC.setRowSorter(elQueOrdena);
            this.tb_HC.setModel(m);

            LAB_HC_formato();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnBuscar1ActionPerformed

    private void txtbuscarHCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarHCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarHCActionPerformed

    private void txtbuscarHCKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarHCKeyPressed
        if(evt.getExtendedKeyCode()==KeyEvent.VK_DOWN){
            tb_HC.getSelectionModel().setSelectionInterval(0, 0);
            tb_HC.requestFocus();
        }
    }//GEN-LAST:event_txtbuscarHCKeyPressed

    private void txtbuscarHCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarHCKeyTyped
        char tecla= evt.getKeyChar();
        if(tecla==KeyEvent.VK_ENTER){
            btnBuscar1.doClick();
        }

    }//GEN-LAST:event_txtbuscarHCKeyTyped

    private void tb_HCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_HCMouseClicked

    }//GEN-LAST:event_tb_HCMouseClicked

    private void tb_HCKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_HCKeyPressed
        char tecla= evt.getKeyChar();
        if(tecla==KeyEvent.VK_ENTER){
            try{
                buscar_HC.setVisible(false);
                int filaselec=tb_HC.getSelectedRow();
             
                
                txtPacientes.setText(tb_HC.getValueAt(filaselec, 1).toString());
            }
            catch(Exception ex)
            {
                System.out.println("Error: " + ex.getMessage());
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_HCKeyPressed

    private void tb_TomasRealizadasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_TomasRealizadasMouseClicked

    }//GEN-LAST:event_tb_TomasRealizadasMouseClicked

    private void tb_TomasRealizadasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_TomasRealizadasMouseReleased
 
    }//GEN-LAST:event_tb_TomasRealizadasMouseReleased

    private void tb_TomasRealizadasPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tb_TomasRealizadasPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_TomasRealizadasPropertyChange

    private void tb_TomasRealizadasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_TomasRealizadasKeyTyped

    }//GEN-LAST:event_tb_TomasRealizadasKeyTyped

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
 try{
          
            if(dateDesde.getDate()==null || dateHasta.getDate()==null){
              JOptionPane.showMessageDialog(rootPane, "Seleccione un rango de Fechas.");
          } else if(cbx.getSelectedIndex()==0){
              JOptionPane.showMessageDialog(rootPane, "Seleccione un tipo de búsqueda");
          }  else if(txtPacientes.getText().isEmpty()&&chPacientes.isSelected()==false&& txtNToma.getText().isEmpty()
                  && chNToma.isSelected()==false){
              JOptionPane.showMessageDialog(rootPane, "Seleccione y/o ingrese un " +cbx.getSelectedItem());
          }  else {
              buscar_examenes();
           
          }  
          }catch(Exception e) {
              JOptionPane.showMessageDialog(this, e.getMessage());
              
          }
    }//GEN-LAST:event_btnGuardarActionPerformed
public void buscar_examenes(){
    DecimalFormat df = new DecimalFormat("00");
        int dia,mes,anio,diah,mesh,anioh;
        dia = dateDesde.getCalendar().get(Calendar.DAY_OF_MONTH);
        mes = dateDesde.getCalendar().get(Calendar.MONTH) + 1;
        anio = dateDesde.getCalendar().get(Calendar.YEAR);
        diah = dateHasta.getCalendar().get(Calendar.DAY_OF_MONTH);
        mesh = dateHasta.getCalendar().get(Calendar.MONTH) + 1;
        anioh = dateHasta.getCalendar().get(Calendar.YEAR);
        
        int desde=Integer.parseInt(anio+df.format(mes)+df.format(dia));
        int hasta=Integer.parseInt(anioh+df.format(mesh)+df.format(diah));
        String buscar="",tipo="1",servicioArea="";
        
        
        if((chPacientes.isSelected()==true ||chNToma.isSelected()==true) &&lblArea.getText().equalsIgnoreCase("")){
        tipo="1";
        servicioArea=lblServicio.getText();
        }
        else if(txtPacientes.getText().length()>0 &&lblArea.getText().equalsIgnoreCase("")){
        tipo="2";
         buscar=txtPacientes.getText();
        servicioArea=lblServicio.getText();
        }
        else if(txtNToma.getText().length()>0 &&lblArea.getText().equalsIgnoreCase("")){
        tipo="3";
         buscar=txtNToma.getText();
        servicioArea=lblServicio.getText();
        }
        else if((chPacientes.isSelected()==true ||chNToma.isSelected()==true) &&lblArea.getText().length()>0 ){
            tipo="4";
            servicioArea=lblArea.getText();        
        }
         else if(txtPacientes.getText().length()>0 &&lblArea.getText().length()>0 ){
             tipo="5";
              buscar=txtPacientes.getText();
            servicioArea=lblArea.getText();        
        }
         else if(txtNToma.getText().length()>0 &&lblArea.getText().length()>0 ){
             tipo="6";
              buscar=txtNToma.getText();
            servicioArea=lblArea.getText();        
        }
    String consulta="";
        try {
            tb_TomasRealizadas.setModel(new DefaultTableModel());
            String titulos[]={"cod_cab_toma_mu_exa","cod_det_toma_mu_ana","cod_exa_ana","id_hc","Servicio/Área","Código CPT",
                "Nomenclatura" ,"Análisis Examen","Número de Toma de Muestra","N° de H.C.","Datos del Paciente",
                "DNI","Fecha de Nacimiento","Edad","Sexo","Forma de Pago","Acto Médico","Personal TMuestra",
                "Fecha TM","Hora TM","Personal Solicita","Habitacion","Cama","Fecha Orden","Hora Orden","idDocumento"};
            m=new DefaultTableModel(null,titulos);
            JTable p=new JTable(m);
//            m=(DefaultTableModel)tb_TomasRealizadas.getModel(); Cuando se va agregando
            String fila[]=new String[27];

            LAB_Analisis_Examen obj=new LAB_Analisis_Examen();
                    consulta="exec sp_LAB_RESULTADO_TOMA_MUESTRA ?,?,?,?,?";
            PreparedStatement cmd = obj.getCn().prepareStatement(consulta);
            cmd.setInt(1,desde);
            cmd.setInt(2, hasta);
            cmd.setString(3, buscar);
            cmd.setString(4, servicioArea);
            cmd.setString(5, tipo);
            ResultSet r= cmd.executeQuery();
            int c=1;
            while(r.next()){
                fila[0]=r.getString(1);
                fila[1]=r.getString(2);
                fila[2]=r.getString(3);
                fila[3]=r.getString(4);
                fila[4]=r.getString(5);
                fila[5]=r.getString(6);
                fila[6]=r.getString(7);
                fila[7]=r.getString(8);
                fila[8]=r.getString(9);
                fila[9]=r.getString(10);
                fila[10]=r.getString(11);
                fila[11]=r.getString(12);
                fila[12]=r.getString(13);
                fila[13]=r.getString(14);
                fila[14]=r.getString(15);
                fila[15]=r.getString(16);
                fila[16]=r.getString(17);
                fila[17]=r.getString(18);
                fila[18]=r.getString(19);
                fila[19]=r.getString(20);
                fila[20]=r.getString(21);
                fila[21]=r.getString(22);
                fila[22]=r.getString(23);
                fila[23]=r.getString(24);
                fila[24]=r.getString(25);
                fila[25]=r.getString(26);

                m.addRow(fila);
                c++;
            }
            tb_TomasRealizadas.setModel(m);
            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m);
            tb_TomasRealizadas.setRowSorter(elQueOrdena);
            this.tb_TomasRealizadas.setModel(m);
            
            formato();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
}
    private void tb_TomasRealizadasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_TomasRealizadasKeyPressed
        // TODO add your handling code here:
        char tecla= evt.getKeyChar();
                if(tecla==KeyEvent.VK_ENTER){  
                    try{
                        dispose();
                        int filaselec=tb_TomasRealizadas.getSelectedRow();
                        
                    frm_LAB_RESULTADO_MUESTRA vr=new frm_LAB_RESULTADO_MUESTRA();
                    vr.setVisible(true);
                    
                    //codigos
                    frm_LAB_RESULTADO_MUESTRA.lblcod_cab_toma.setText(tb_TomasRealizadas.getValueAt(filaselec, 0).toString());
                    frm_LAB_RESULTADO_MUESTRA.lblcod_det_toma.setText(tb_TomasRealizadas.getValueAt(filaselec, 1).toString());
                    frm_LAB_RESULTADO_MUESTRA.lblcod_exa_ana.setText(tb_TomasRealizadas.getValueAt(filaselec, 2).toString());
                    frm_LAB_RESULTADO_MUESTRA.lblDocumento.setText(tb_TomasRealizadas.getValueAt(filaselec, 25).toString());
                   
                    //Datos del Paciente
                    frm_LAB_RESULTADO_MUESTRA.lblHc.setText(tb_TomasRealizadas.getValueAt(filaselec, 3).toString());
                    frm_LAB_RESULTADO_MUESTRA.txtHc.setText(tb_TomasRealizadas.getValueAt(filaselec, 9).toString());
                    frm_LAB_RESULTADO_MUESTRA.txtPacientes.setText(tb_TomasRealizadas.getValueAt(filaselec, 10).toString());
                    frm_LAB_RESULTADO_MUESTRA.txtDni.setText(tb_TomasRealizadas.getValueAt(filaselec, 11).toString());
                    frm_LAB_RESULTADO_MUESTRA.txtFecha.setText(tb_TomasRealizadas.getValueAt(filaselec, 12).toString());
                    frm_LAB_RESULTADO_MUESTRA.txtEdad.setText(tb_TomasRealizadas.getValueAt(filaselec, 13).toString());
                    frm_LAB_RESULTADO_MUESTRA.txtSexo.setText(tb_TomasRealizadas.getValueAt(filaselec, 14).toString());
                    //Toma de Muestra
                    frm_LAB_RESULTADO_MUESTRA.txtActoMedico.setText(tb_TomasRealizadas.getValueAt(filaselec, 16).toString());
                    frm_LAB_RESULTADO_MUESTRA.txtFormaPago.setText(tb_TomasRealizadas.getValueAt(filaselec, 15).toString());
                    frm_LAB_RESULTADO_MUESTRA.txtNToma.setText(tb_TomasRealizadas.getValueAt(filaselec, 8).toString());
                    frm_LAB_RESULTADO_MUESTRA.txtPersonalTomaMuestra.setText(tb_TomasRealizadas.getValueAt(filaselec, 17).toString());
                    frm_LAB_RESULTADO_MUESTRA.txtFechaTM.setText(tb_TomasRealizadas.getValueAt(filaselec, 18).toString());
                    frm_LAB_RESULTADO_MUESTRA.txtHoraTM.setText(tb_TomasRealizadas.getValueAt(filaselec, 19).toString());
                    frm_LAB_RESULTADO_MUESTRA.txtPersonalSolicita.setText(tb_TomasRealizadas.getValueAt(filaselec, 20).toString());
                    if(tb_TomasRealizadas.getValueAt(filaselec,21).toString().isEmpty()){
                    frm_LAB_RESULTADO_MUESTRA.txtPiso.setText("--");
                    frm_LAB_RESULTADO_MUESTRA.txtCama.setText("--");
                    }else{
                       frm_LAB_RESULTADO_MUESTRA.txtPiso.setText(tb_TomasRealizadas.getValueAt(filaselec, 21).toString());
                    frm_LAB_RESULTADO_MUESTRA.txtCama.setText(tb_TomasRealizadas.getValueAt(filaselec, 22).toString()); 
                    }
                    
                    frm_LAB_RESULTADO_MUESTRA.txtFechaOrden.setText(tb_TomasRealizadas.getValueAt(filaselec, 23).toString());
                    frm_LAB_RESULTADO_MUESTRA.txtHoraOrden.setText(tb_TomasRealizadas.getValueAt(filaselec, 24).toString());
                    
                    //Servicio
                    frm_LAB_RESULTADO_MUESTRA.txtServArea.setText(tb_TomasRealizadas.getValueAt(filaselec, 4).toString());
                    frm_LAB_RESULTADO_MUESTRA.txtCPT.setText(tb_TomasRealizadas.getValueAt(filaselec, 5).toString());
                    frm_LAB_RESULTADO_MUESTRA.txtNomenclatura.setText(tb_TomasRealizadas.getValueAt(filaselec, 7).toString());
                    
                    
                    frm_LAB_RESULTADO_MUESTRA.lblServicio.setText(lblServicio.getText());
                    frm_LAB_RESULTADO_MUESTRA.lblArea.setText(lblArea.getText());
                    
                    
                    String u=lblUsu.getText();
                             frm_LAB_RESULTADO_MUESTRA.lblUsu.setText(u);
                             
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "ingreso "+e.getMessage());
        }
        }
    }//GEN-LAST:event_tb_TomasRealizadasKeyPressed

    private void chPacientesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chPacientesItemStateChanged
        if(chPacientes.isSelected()){
            txtPacientes.setEnabled(false);
            btnPacientes.setEnabled(false);
            txtPacientes.setText("");
            txtNToma.setText("");
        }else{
            txtPacientes.setEnabled(true);
            btnPacientes.setEnabled(true);
            txtPacientes.setText("");
            txtNToma.setText("");
        }
    }//GEN-LAST:event_chPacientesItemStateChanged

    private void btnPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPacientesActionPerformed
        buscar_HC.setVisible(true);
        LAB_HC_cargar();
        LAB_HC_formato();
    }//GEN-LAST:event_btnPacientesActionPerformed

    private void chNTomaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chNTomaItemStateChanged
        if(chNToma.isSelected()){
            txtNToma.setEnabled(false);
            btnNToma.setEnabled(false);
            txtNToma.setText("");
        }else{
            txtNToma.setEnabled(true);
            btnNToma.setEnabled(true);
        }
    }//GEN-LAST:event_chNTomaItemStateChanged

    private void btnNTomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNTomaActionPerformed
//        Buscar_Unidad_Organica.setVisible(true);
//        LAB_Unidad_Organica_cargar();
//        LAB_Unidad_Organica_formato();
    }//GEN-LAST:event_btnNTomaActionPerformed

    private void cbxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxItemStateChanged
        if(cbx.getSelectedIndex()==0){
            chPacientes.setVisible(false);
            txtPacientes.setVisible(false);
            btnPacientes.setVisible(false);
            chNToma.setVisible(false);
            txtNToma.setVisible(false);
            btnNToma.setVisible(false);
            txtPacientes.setText("");
            txtNToma.setText("");
        }
        else if(cbx.getSelectedIndex()==1){
            chPacientes.setVisible(true);
            txtPacientes.setVisible(true);
            btnPacientes.setVisible(true);
            chNToma.setVisible(false);
            txtNToma.setVisible(false);
            btnNToma.setVisible(false);
            txtPacientes.setText("");
            txtNToma.setText("");
        }else if(cbx.getSelectedIndex()==2){
            chPacientes.setVisible(false);
            txtPacientes.setVisible(false);
            btnPacientes.setVisible(false);
            chNToma.setVisible(true);
            txtNToma.setVisible(true);
            btnNToma.setVisible(true);
            txtPacientes.setText("");
            txtNToma.setText("");
        }
    }//GEN-LAST:event_cbxItemStateChanged
    public void enableDatos(){
    tb_TomasRealizadas.setEnabled(true);
    tb_TomasRealizadas.setBackground(Color.white);
}
    public void limpiar(){
  
   DefaultTableModel modelo = (DefaultTableModel)tb_TomasRealizadas.getModel(); 
   int filas=tb_TomasRealizadas.getRowCount();
   for(int i=0;i<filas;i++){
                    modelo.removeRow(0);
   }
}
   
  
    public void run() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.       
        Thread ct = Thread.currentThread();
        while (ct == h1) {
            calcula();
            lblHora.setText(hora + ":" + minutos + ":" + segundos + " " + ampm);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
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
            java.util.logging.Logger.getLogger(frm_LAB_RESULTADOS_MUESTRA_INGRESO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_LAB_RESULTADOS_MUESTRA_INGRESO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_LAB_RESULTADOS_MUESTRA_INGRESO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_LAB_RESULTADOS_MUESTRA_INGRESO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new frm_LAB_RESULTADOS_MUESTRA_INGRESO().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JButton btnGuardar;
    public static javax.swing.JButton btnNToma;
    public static javax.swing.JButton btnPacientes;
    private javax.swing.JDialog buscar_HC;
    private javax.swing.JComboBox cbx;
    private javax.swing.JCheckBox chNToma;
    private javax.swing.JCheckBox chPacientes;
    private com.toedter.calendar.JDateChooser dateDesde;
    private com.toedter.calendar.JDateChooser dateHasta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPanel jpanel;
    private javax.swing.JLabel lblArea;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblServicio;
    public static javax.swing.JLabel lblUsu;
    private javax.swing.JPanel panelPacientes;
    public static javax.swing.JTable tb_HC;
    public static javax.swing.JTable tb_TomasRealizadas;
    private javax.swing.JLabel titulo5;
    public static javax.swing.JTextField txtNToma;
    public static javax.swing.JTextField txtPacientes;
    private javax.swing.JTextField txtbuscarHC;
    // End of variables declaration//GEN-END:variables
}
