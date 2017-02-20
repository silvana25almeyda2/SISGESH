
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.LABORATORIO;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
import modelos.LABORATORIO.LAB_Toma_Muestra_Cabecera;
import modelos.LABORATORIO.Render_Checkbox;
import modelos.Usuario;
import servicios.Conexion;
import vista.frmlaboratorioClinico;

/**
 *
 * @author
 */
public class frm_LAB_TOMA_MUESTRA_CABECERA extends javax.swing.JFrame implements Runnable{
String hora, minutos, segundos, ampm;
    Calendar calendario;
    Thread h1;
    Connection conexion=null;
Conexion c=new Conexion();
DefaultTableModel m,n,muestra;
    /**
     * Creates new form LAB_MUESTRA_EXAMEN
     */
    public frm_LAB_TOMA_MUESTRA_CABECERA() {
        initComponents();
        c.conectar();
        // this.setExtendedState(MAXIMIZED_BOTH);
                
        h1 = new Thread(this);
        h1.start();
        panelPaciente.setBackground(Color.white); 
        panelCabecera.setBackground(Color.white); 
        jPanel2.setBackground(Color.white); 
        this.getContentPane().setBackground(Color.white); 
        nomenclatura.getContentPane().setBackground(Color.white);
        nomenclatura.setLocationRelativeTo(null);
        setLocationRelativeTo(null);//en el centro
//      setResizable(false);//para que no funcione el boton maximizar
       
        lblCodigo.setText("");
        lblNum_toma_mu_exa.setText("");
//        LAB_Toma_Muestra_Cabecera u=new LAB_Toma_Muestra_Cabecera();
//        lblCodigo.setText(u.LAB_Toma_Muestra_Cab_generarid("1"));
        if(lblCodigo.getText().equalsIgnoreCase("")){
        lblCodigo.setText("TC000000000000000001");
        }
        
//        LAB_Toma_Muestra_Cabecera num=new LAB_Toma_Muestra_Cabecera();
//        lblNum_toma_mu_exa.setText(num.LAB_Toma_Muestra_Cab_generarid("2"));
        if(lblNum_toma_mu_exa.getText().equalsIgnoreCase("")){
        lblNum_toma_mu_exa.setText("000000000001");
        }
        
        
        
        //fecha
        Calendar cal=Calendar.getInstance(); 
        String hora=cal.get(cal.HOUR_OF_DAY)+":"+cal.get(cal.MINUTE)+":"+cal.get(cal.SECOND); 
        lblFecha.setText(fechaActual());
        lblFecha1.setText(fechaActual());
        
        tb_Detalle.setEnabled(false);
        jPanel2.setEnabled(false);
        btnAgregar.setEnabled(false);
        btnQuitar.setEnabled(false);
        formato();
  
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
    tb_Detalle.getColumnModel().getColumn(0).setPreferredWidth(150);
    tb_Detalle.getColumnModel().getColumn(1).setPreferredWidth(150);
    tb_Detalle.getColumnModel().getColumn(2).setPreferredWidth(200);
    tb_Detalle.getColumnModel().getColumn(3).setPreferredWidth(200);
            //Ocultar    
//  tb_Detalle.getColumnModel().getColumn(0).setMinWidth(0);
//  tb_Detalle.getColumnModel().getColumn(0).setMaxWidth(0);
    tb_Detalle.getSelectionModel().setSelectionInterval(0, 0);
            tb_Detalle.requestFocus();
}

    public void Nomenclatura_cargar(){
    try {
             String titulos[]={"N°","codigo venta detalle","Codigo caja","Código CPT","Nomenclatura","Servicio/Área Solicita","Nº de Documento","Fecha de Emitido"};
            m=new DefaultTableModel(null,titulos);
            JTable p=new JTable(m);
            String fila[]=new String[8];

            LAB_Clasificacion_Examen obj=new LAB_Clasificacion_Examen();
        String consulta="exec sp_LAB_TOMA_MUESTRA_NOMENCLATURA ?";
        
        PreparedStatement cmd = obj.getCn().prepareStatement(consulta);
            cmd.setString(1, lblDocumento.getText());
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
                m.addRow(fila);
                c++;
            }
            tb_Nomenclatura.setModel(m);
            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m);
            tb_Nomenclatura.setRowSorter(elQueOrdena);
            this.tb_Nomenclatura.setModel(m);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(rootPane, "Error en la tabla");
    }
}
    public void Nomenclatura_formato(){
    tb_Nomenclatura.getColumnModel().getColumn(0).setPreferredWidth(40);
    tb_Nomenclatura.getColumnModel().getColumn(1).setPreferredWidth(100);
    tb_Nomenclatura.getColumnModel().getColumn(2).setPreferredWidth(100);
    tb_Nomenclatura.getColumnModel().getColumn(3).setPreferredWidth(100);
    tb_Nomenclatura.getColumnModel().getColumn(4).setPreferredWidth(240);
    tb_Nomenclatura.getColumnModel().getColumn(5).setPreferredWidth(240);
    tb_Nomenclatura.getColumnModel().getColumn(6).setPreferredWidth(120);
    tb_Nomenclatura.getColumnModel().getColumn(7).setPreferredWidth(120);
       //Ocultar    
    tb_Nomenclatura.getColumnModel().getColumn(1).setMinWidth(0);
    tb_Nomenclatura.getColumnModel().getColumn(1).setMaxWidth(0);
    tb_Nomenclatura.getColumnModel().getColumn(2).setMinWidth(0);
    tb_Nomenclatura.getColumnModel().getColumn(2).setMaxWidth(0);
    tb_Nomenclatura.getSelectionModel().setSelectionInterval(0, 0);
            tb_Nomenclatura.requestFocus();
}
   public static String fechaActual(){
        Date now = new Date(System.currentTimeMillis());
        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        return date.format(now);
    }
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

        nomenclatura = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_Nomenclatura = new javax.swing.JTable();
        personal = new javax.swing.JDialog();
        txtBuscar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbPersonal = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false; //Disallow the editing of any cell
            }};
            jLabel1 = new javax.swing.JLabel();
            cbxBuscar2 = new javax.swing.JComboBox();
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
            tb_Detalle = new javax.swing.JTable(){
                public boolean isCellEditable(int rowIndex, int colIndex){
                    if(colIndex==0){
                        return true;
                    }else{
                        return false; //Disallow the editing of any cell
                    }}};
                    btnAgregar = new javax.swing.JButton();
                    panelCabecera = new javax.swing.JPanel();
                    jLabel25 = new javax.swing.JLabel();
                    jLabel26 = new javax.swing.JLabel();
                    txtPersonalTomaMuestra = new javax.swing.JTextField();
                    txtPersonalRegistraToma = new javax.swing.JTextField();
                    jLabel27 = new javax.swing.JLabel();
                    jLabel28 = new javax.swing.JLabel();
                    lblHora1 = new javax.swing.JLabel();
                    lblFecha1 = new javax.swing.JLabel();
                    lblHc1 = new javax.swing.JLabel();
                    lblCantidad = new javax.swing.JLabel();
                    btnGenerar = new javax.swing.JButton();
                    lblNum_toma_mu_exa = new javax.swing.JLabel();
                    jLabel29 = new javax.swing.JLabel();
                    panelPaciente = new javax.swing.JPanel();
                    jLabel23 = new javax.swing.JLabel();
                    txtDni = new javax.swing.JTextField();
                    jLabel22 = new javax.swing.JLabel();
                    txtHc = new javax.swing.JTextField();
                    txtPacientes = new javax.swing.JTextField();
                    jLabel7 = new javax.swing.JLabel();
                    jLabel17 = new javax.swing.JLabel();
                    txtFecha = new javax.swing.JTextField();
                    jLabel18 = new javax.swing.JLabel();
                    txtSexo = new javax.swing.JTextField();
                    jLabel24 = new javax.swing.JLabel();
                    txtEdad = new javax.swing.JTextField();
                    lblHc = new javax.swing.JLabel();
                    btnQuitar = new javax.swing.JButton();
                    lblDocumento = new javax.swing.JLabel();
                    jPanel2 = new javax.swing.JPanel();
                    lblCantidad1 = new javax.swing.JLabel();
                    lblHc2 = new javax.swing.JLabel();
                    lblCantidad2 = new javax.swing.JLabel();
                    lblCodigo = new javax.swing.JLabel();
                    lblContador = new javax.swing.JLabel();
                    lblCodPerToma = new javax.swing.JLabel();
                    lblCodPerRegistra = new javax.swing.JLabel();

                    nomenclatura.setMinimumSize(new java.awt.Dimension(518, 344));

                    tb_Nomenclatura.setModel(new javax.swing.table.DefaultTableModel(
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
                    tb_Nomenclatura.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
                    tb_Nomenclatura.addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyPressed(java.awt.event.KeyEvent evt) {
                            tb_NomenclaturaKeyPressed(evt);
                        }
                    });
                    jScrollPane1.setViewportView(tb_Nomenclatura);

                    javax.swing.GroupLayout nomenclaturaLayout = new javax.swing.GroupLayout(nomenclatura.getContentPane());
                    nomenclatura.getContentPane().setLayout(nomenclaturaLayout);
                    nomenclaturaLayout.setHorizontalGroup(
                        nomenclaturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(nomenclaturaLayout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE)
                            .addGap(22, 22, 22))
                    );
                    nomenclaturaLayout.setVerticalGroup(
                        nomenclaturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nomenclaturaLayout.createSequentialGroup()
                            .addContainerGap(58, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(19, 19, 19))
                    );

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

                    jLabel2.setText("Búsqueda por:");

                    btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/view.gif"))); // NOI18N
                    btnBuscar.setBorder(null);
                    btnBuscar.setEnabled(false);
                    btnBuscar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            btnBuscarActionPerformed(evt);
                        }
                    });

                    tbPersonal.setModel(new javax.swing.table.DefaultTableModel(
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
                    tbPersonal.setRowHeight(25);
                    tbPersonal.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                            tbPersonalMouseClicked(evt);
                        }
                    });
                    tbPersonal.addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyPressed(java.awt.event.KeyEvent evt) {
                            tbPersonalKeyPressed(evt);
                        }
                        public void keyTyped(java.awt.event.KeyEvent evt) {
                            tbPersonalKeyTyped(evt);
                        }
                    });
                    jScrollPane2.setViewportView(tbPersonal);

                    jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
                    jLabel1.setText("Personal");

                    cbxBuscar2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar...", "Nombres", "Apellido Paterno", "Apellido Materno", "Cargo" }));
                    cbxBuscar2.addItemListener(new java.awt.event.ItemListener() {
                        public void itemStateChanged(java.awt.event.ItemEvent evt) {
                            cbxBuscar2ItemStateChanged(evt);
                        }
                    });

                    javax.swing.GroupLayout personalLayout = new javax.swing.GroupLayout(personal.getContentPane());
                    personal.getContentPane().setLayout(personalLayout);
                    personalLayout.setHorizontalGroup(
                        personalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(personalLayout.createSequentialGroup()
                            .addGroup(personalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(personalLayout.createSequentialGroup()
                                    .addGap(414, 414, 414)
                                    .addComponent(jLabel1))
                                .addGroup(personalLayout.createSequentialGroup()
                                    .addGap(133, 133, 133)
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbxBuscar2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(158, 158, 158)
                                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(personalLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 904, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    );
                    personalLayout.setVerticalGroup(
                        personalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, personalLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addGroup(personalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, personalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbxBuscar2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)))
                            .addGap(28, 28, 28)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                            .addContainerGap())
                    );

                    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                    setTitle("SISGESH .::. Análisis Examen");

                    jpanel.setBackground(new java.awt.Color(2, 67, 115));

                    titulo5.setBackground(new java.awt.Color(0, 102, 102));
                    titulo5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
                    titulo5.setForeground(new java.awt.Color(255, 255, 255));
                    titulo5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    titulo5.setText("Exámenes por realizar");
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
                            .addGap(603, 603, 603)
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
                            .addContainerGap()
                            .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel14)
                                .addComponent(lblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel15)
                                .addComponent(lblHora))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                    );

                    jPanel1.setBackground(new java.awt.Color(204, 204, 204));

                    jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/salir16x16.png"))); // NOI18N
                    jLabel3.setText("Salir (Esc)");

                    jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Search-16.png"))); // NOI18N
                    jLabel10.setText("Generar (Alt+G)");

                    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                    jPanel1.setLayout(jPanel1Layout);
                    jPanel1Layout.setHorizontalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGap(910, 910, 910)
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
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(5, 5, 5))
                    );

                    tb_Detalle.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {

                        },
                        new String [] {
                            "Código CPT", "Nomenclatura", "Servicio/Área", "Fecha Emitido"
                        }
                    ) {
                        boolean[] canEdit = new boolean [] {
                            false, true, false, true
                        };

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                            return canEdit [columnIndex];
                        }
                    });
                    tb_Detalle.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
                    tb_Detalle.setRowHeight(20);
                    tb_Detalle.setSelectionBackground(new java.awt.Color(2, 67, 115));
                    tb_Detalle.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                            tb_DetalleMouseClicked(evt);
                        }
                        public void mouseReleased(java.awt.event.MouseEvent evt) {
                            tb_DetalleMouseReleased(evt);
                        }
                    });
                    tb_Detalle.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
                        public void propertyChange(java.beans.PropertyChangeEvent evt) {
                            tb_DetallePropertyChange(evt);
                        }
                    });
                    tb_Detalle.addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyTyped(java.awt.event.KeyEvent evt) {
                            tb_DetalleKeyTyped(evt);
                        }
                    });
                    jScrollPane5.setViewportView(tb_Detalle);

                    btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/mas.png"))); // NOI18N
                    btnAgregar.setText("Agregar Toma de Muestra");
                    btnAgregar.setContentAreaFilled(false);
                    btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                    btnAgregar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            btnAgregarActionPerformed(evt);
                        }
                    });

                    panelCabecera.setBorder(javax.swing.BorderFactory.createTitledBorder("Toma de Muestra "));

                    jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    jLabel25.setText("Personal - Toma de Muestra");

                    jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    jLabel26.setText("Personal - Registra Toma de Muestra");

                    jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    jLabel27.setText("Fecha Toma Muestra");

                    jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    jLabel28.setText("Hora Toma Muestra");

                    lblHora1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
                    lblHora1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    lblHora1.setText("00:00:00");

                    lblFecha1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
                    lblFecha1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    lblFecha1.setText("00/00/00");

                    lblHc1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    lblHc1.setText("Cantidad de Exámenes");

                    lblCantidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    lblCantidad.setText("Cantidad de Exámenes");

                    btnGenerar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
                    btnGenerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/modificar16x16.png"))); // NOI18N
                    btnGenerar.setMnemonic('G');
                    btnGenerar.setText("Generar");
                    btnGenerar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            btnGenerarActionPerformed(evt);
                        }
                    });

                    lblNum_toma_mu_exa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    lblNum_toma_mu_exa.setText("Num_toma_mu_exa");

                    jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    jLabel29.setText("N° de Toma de Muestra");

                    javax.swing.GroupLayout panelCabeceraLayout = new javax.swing.GroupLayout(panelCabecera);
                    panelCabecera.setLayout(panelCabeceraLayout);
                    panelCabeceraLayout.setHorizontalGroup(
                        panelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelCabeceraLayout.createSequentialGroup()
                            .addGap(50, 50, 50)
                            .addGroup(panelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblNum_toma_mu_exa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                                .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblFecha1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(93, 93, 93)
                            .addGroup(panelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                                .addComponent(txtPersonalTomaMuestra)
                                .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblHora1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                                .addComponent(txtPersonalRegistraToma, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                                .addComponent(lblHc1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(60, 60, 60)
                            .addComponent(btnGenerar)
                            .addGap(36, 36, 36))
                    );
                    panelCabeceraLayout.setVerticalGroup(
                        panelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelCabeceraLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel29)
                                .addComponent(jLabel25)
                                .addComponent(jLabel26))
                            .addGroup(panelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelCabeceraLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNum_toma_mu_exa)
                                        .addComponent(txtPersonalTomaMuestra, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                                        .addComponent(txtPersonalRegistraToma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(21, 21, 21)
                                    .addGroup(panelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel27)
                                        .addComponent(jLabel28)
                                        .addComponent(lblHc1))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCabeceraLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(13, 13, 13)))
                            .addGroup(panelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelCabeceraLayout.createSequentialGroup()
                                    .addGroup(panelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblFecha1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblHora1))
                                    .addContainerGap())
                                .addGroup(panelCabeceraLayout.createSequentialGroup()
                                    .addComponent(lblCantidad)
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    );

                    panelPaciente.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Paciente"));

                    jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    jLabel23.setText("DNI");

                    txtDni.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                    txtDni.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                    txtDni.setEnabled(false);

                    jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    jLabel22.setText("Nº de H.C.");

                    txtHc.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                    txtHc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                    txtHc.setEnabled(false);

                    txtPacientes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                    txtPacientes.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                    txtPacientes.setEnabled(false);

                    jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    jLabel7.setText("Paciente");

                    jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    jLabel17.setText("Fecha de Nac.");

                    txtFecha.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                    txtFecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                    txtFecha.setEnabled(false);

                    jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    jLabel18.setText("Sexo");

                    txtSexo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                    txtSexo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                    txtSexo.setEnabled(false);

                    jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    jLabel24.setText("Edad");

                    txtEdad.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                    txtEdad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                    txtEdad.setEnabled(false);

                    javax.swing.GroupLayout panelPacienteLayout = new javax.swing.GroupLayout(panelPaciente);
                    panelPaciente.setLayout(panelPacienteLayout);
                    panelPacienteLayout.setHorizontalGroup(
                        panelPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelPacienteLayout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addGroup(panelPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtHc, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(33, 33, 33)
                            .addGroup(panelPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                .addComponent(txtDni))
                            .addGap(33, 33, 33)
                            .addGroup(panelPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(39, 39, 39)
                            .addGroup(panelPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtFecha)
                                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                            .addGap(39, 39, 39)
                            .addGroup(panelPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtEdad)
                                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
                            .addGap(36, 36, 36)
                            .addGroup(panelPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtSexo)
                                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    );
                    panelPacienteLayout.setVerticalGroup(
                        panelPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelPacienteLayout.createSequentialGroup()
                            .addGap(0, 0, 0)
                            .addGroup(panelPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel22)
                                .addComponent(jLabel7)
                                .addComponent(jLabel23)
                                .addComponent(jLabel17)
                                .addComponent(jLabel18)
                                .addComponent(jLabel24))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panelPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtHc, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    );

                    lblHc.setText("lblHc");

                    btnQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/menos16x16.png"))); // NOI18N
                    btnQuitar.setText(" Quitar Toma de Muestra");
                    btnQuitar.setContentAreaFilled(false);
                    btnQuitar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                    btnQuitar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            btnQuitarActionPerformed(evt);
                        }
                    });

                    lblDocumento.setText("lblDocumento");

                    jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Exámenes Pendientes"));

                    lblCantidad1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
                    lblCantidad1.setForeground(new java.awt.Color(204, 0, 0));
                    lblCantidad1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                    lblCantidad1.setText("0");

                    lblHc2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    lblHc2.setText("Falta Agregar Toma de Muestra:");

                    lblCantidad2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
                    lblCantidad2.setForeground(new java.awt.Color(204, 0, 0));
                    lblCantidad2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                    lblCantidad2.setText("Exámenes");

                    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                    jPanel2.setLayout(jPanel2Layout);
                    jPanel2Layout.setHorizontalGroup(
                        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblHc2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(lblCantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblCantidad2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addContainerGap())
                    );
                    jPanel2Layout.setVerticalGroup(
                        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lblHc2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblCantidad1)
                                .addComponent(lblCantidad2))
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    );

                    lblCodigo.setText("lblCodigo");

                    lblContador.setText("0");

                    lblCodPerToma.setText("lblPerTomaMuestra");

                    lblCodPerRegistra.setText("lblPerRegistraTomaMuestra");

                    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                    getContentPane().setLayout(layout);
                    layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(13, 13, 13)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(panelPaciente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(panelCabecera, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(15, 15, 15))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 872, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(13, 13, 13)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnQuitar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(15, 15, 15))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(29, 29, 29)
                                    .addComponent(lblCodPerToma, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(82, 82, 82)
                                    .addComponent(lblCodPerRegistra, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(35, 35, 35)
                                    .addComponent(lblDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(29, 29, 29)
                                    .addComponent(lblHc)
                                    .addGap(43, 43, 43)
                                    .addComponent(lblContador)
                                    .addGap(53, 53, 53))))
                    );
                    layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(panelPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(3, 3, 3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblHc)
                                .addComponent(lblDocumento)
                                .addComponent(lblCodigo)
                                .addComponent(lblContador)
                                .addComponent(lblCodPerToma)
                                .addComponent(lblCodPerRegistra))
                            .addGap(1, 1, 1)
                            .addComponent(panelCabecera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(19, 19, 19)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnAgregar)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnQuitar)
                                    .addGap(76, 76, 76))))
                    );

                    pack();
                }// </editor-fold>//GEN-END:initComponents

    private void tb_DetalleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_DetalleMouseClicked

    }//GEN-LAST:event_tb_DetalleMouseClicked

    private void tb_DetalleMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_DetalleMouseReleased
 
    }//GEN-LAST:event_tb_DetalleMouseReleased

    private void tb_DetallePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tb_DetallePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_DetallePropertyChange

    private void tb_DetalleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_DetalleKeyTyped

    }//GEN-LAST:event_tb_DetalleKeyTyped

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        nomenclatura.setVisible(true);
        Nomenclatura_cargar();
        Nomenclatura_formato();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed

        if(lblContador.getText().equalsIgnoreCase("0")){
            tb_Detalle.setEnabled(true);
        jPanel2.setEnabled(true);
        btnAgregar.setEnabled(true);
        btnQuitar.setEnabled(true);
        
       Lab_guardar_cabecera();
        
        }
        else{
            
        }
    }//GEN-LAST:event_btnGenerarActionPerformed
        
    public void Lab_guardar_cabecera(){
          ImageIcon i=new ImageIcon(this.getClass().getResource("/imagenes/iconos/guardar16x16.png"));
        try{
            if(lblCodPerToma.getText().equalsIgnoreCase("")||txtPersonalTomaMuestra.getText().equalsIgnoreCase("")){
              JOptionPane.showMessageDialog(rootPane, "Seleccione un Personal para la Toma de Muestra");
          }  else if(lblCodPerRegistra.getText().equalsIgnoreCase("")||
                    txtPersonalRegistraToma.getText().equalsIgnoreCase("")){
              JOptionPane.showMessageDialog(rootPane, "Seleccione un Personal para el Registro de Toma de Muestra");
          }  
         else{
              int guardar = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea GUARDAR los datos?",
                      "Atención", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,i);
              if(guardar == 0 ){
                  LAB_Toma_Muestra_Cabecera meGuardar = new LAB_Toma_Muestra_Cabecera();
                  meGuardar.setCod_cab_toma_mu_exa(lblCodigo.getText());
                  meGuardar.setId_documento(lblDocumento.getText());
                  meGuardar.setNum_toma_mu_exa(lblNum_toma_mu_exa.getText());
                  meGuardar.setCod_per_toma_muestra(lblCodPerToma.getText());
                  meGuardar.setNombre_per_toma_muestra(txtPersonalTomaMuestra.getText());
                  meGuardar.setCod_per_regis_toma_muestra(lblCodPerRegistra.getText());
                  meGuardar.setNombre_per_regis_toma_muestra(txtPersonalRegistraToma.getText());
                  meGuardar.setNom_usu(lblUsu.getText());
  
                  if(meGuardar.LAB_Toma_Muestra_Cab_guardar()){
                    JOptionPane.showMessageDialog(null, "Datos Guardados");
                    limpiar();
                    enableDatos();
                    lblContador.setText("1");
                  }
                  else{
                    JOptionPane.showMessageDialog(this, "El Registro ya ha sido ingresado\nIntente nuevamente");
                  }}
          }}catch(Exception e) {
              JOptionPane.showMessageDialog(this, "Ingrese todos los campos");
              
          }
    }
    private void tb_NomenclaturaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_NomenclaturaKeyPressed
      char tecla= evt.getKeyChar();
                if(tecla==KeyEvent.VK_ENTER){  
        try{
           
            int filaselec=tb_Nomenclatura.getSelectedRow();
                nomenclatura.setVisible(false);
            
              frm_LAB_TOMA_MUESTRA_DETALLE vr=new frm_LAB_TOMA_MUESTRA_DETALLE();
                    vr.setVisible(true);
                    frm_LAB_TOMA_MUESTRA_DETALLE.txtidDocumen.setText(lblDocumento.getText());
                    frm_LAB_TOMA_MUESTRA_DETALLE.lblId_cod_doc_det.setText(tb_Nomenclatura.getValueAt(filaselec, 1).toString());
                    
                    frm_LAB_TOMA_MUESTRA_DETALLE.txtNomenclatura.setText(tb_Nomenclatura.getValueAt(filaselec, 3).toString());
                    frm_LAB_TOMA_MUESTRA_DETALLE.txtCodigoCPT.setText(tb_Nomenclatura.getValueAt(filaselec, 4).toString());
                    
                    DefaultTableModel modelo = (DefaultTableModel)tb_Nomenclatura.getModel(); 
                    modelo.removeRow(filaselec);
                    String u=lblUsu.getText();
                             frm_LAB_TOMA_MUESTRA_DETALLE.lblUsu.setText(u);
        }catch(Exception e){
           JOptionPane.showMessageDialog(this, e.getMessage());
        }}
    }//GEN-LAST:event_tb_NomenclaturaKeyPressed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        char tecla= evt.getKeyChar();
        if(tecla==KeyEvent.VK_ENTER){
            btnBuscar.doClick();
        }
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped

    }//GEN-LAST:event_txtBuscarKeyTyped

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        String consulta="";
        try {
            tbPersonal.setModel(new DefaultTableModel());
            String titulos[]={"Nº","Codigo","Dni","Nivel","Cargo","Apellido Paterno","Apellido Materno","Nombres","Fecha de Nacimiento","Sexo","Direccion","Correo"};
            m=new DefaultTableModel(null,titulos);
            JTable p=new JTable(m);
            String fila[]=new String[12];

            Usuario obj=new Usuario();
            if(cbxBuscar.getSelectedItem()=="Nombres"){
                consulta="exec SP_USUARIO_PERSONAL_BuscarNombre ?";
            }
            else if(cbxBuscar.getSelectedItem()=="Apellido Paterno"){
                consulta="exec SP_USUARIO_PERSONAL_BuscarApePat ?";
            }
            else if(cbxBuscar.getSelectedItem()=="Apellido Materno"){
                consulta="exec SP_USUARIO_PERSONAL_BuscarApeMat ?";
            }
            else {
                consulta="exec SP_USUARIO_PERSONAL_BuscarCargo ?";
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
            tbPersonal.setModel(m);
            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m);
            tbPersonal.setRowSorter(elQueOrdena);
            this.tbPersonal.setModel(m);
//            formatoPersonal();
            tbPersonal.getSelectionModel().setSelectionInterval(0, 0);
            tbPersonal.requestFocus();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tbPersonalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPersonalMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbPersonalMouseClicked

    private void tbPersonalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbPersonalKeyPressed
        // TODO add your handling code here:
        char tecla= evt.getKeyChar();
        if(tecla==KeyEvent.VK_ENTER){
            try{
                dispose();
                int filaselec=tbPersonal.getSelectedRow();
                String nombreCompleto=tbPersonal.getValueAt(filaselec, 7).toString()+" "+
                tbPersonal.getValueAt(filaselec, 5).toString()
                +" "+tbPersonal.getValueAt(filaselec, 6).toString();
//                txtPersonal.setText(nombreCompleto);
//                RegistroUsuario.btnguardar.setEnabled(true);
//                RegistroUsuario.btnmodificar.setEnabled(false);
//                RegistroUsuario.btneliminar.setEnabled(false);

            }
            catch(Exception ex)
            {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_tbPersonalKeyPressed

    private void tbPersonalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbPersonalKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tbPersonalKeyTyped

    private void cbxBuscar2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxBuscar2ItemStateChanged
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
    }//GEN-LAST:event_cbxBuscar2ItemStateChanged
    public void enableDatos(){
    tb_Detalle.setEnabled(true);
    tb_Detalle.setBackground(Color.white);
}
    public void limpiar(){
   LAB_Toma_Muestra_Cabecera u=new LAB_Toma_Muestra_Cabecera();
        lblCodigo.setText(u.LAB_Toma_Muestra_Cab_generarid("1"));
        if(lblCodigo.getText().equalsIgnoreCase("")){
        lblCodigo.setText("TC000000000000000001");
        }
     LAB_Toma_Muestra_Cabecera num=new LAB_Toma_Muestra_Cabecera();
        lblNum_toma_mu_exa.setText(num.LAB_Toma_Muestra_Cab_generarid("2"));
        if(lblNum_toma_mu_exa.getText().equalsIgnoreCase("")){
        lblNum_toma_mu_exa.setText("000000000001");
        }   
}
   
  
    public void run() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.       
        Thread ct = Thread.currentThread();
        while (ct == h1) {
            calcula();
            lblHora.setText(hora + ":" + minutos + ":" + segundos + " " + ampm);
            lblHora1.setText(hora + ":" + minutos + ":" + segundos + " " + ampm);
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
            java.util.logging.Logger.getLogger(frm_LAB_TOMA_MUESTRA_CABECERA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_LAB_TOMA_MUESTRA_CABECERA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_LAB_TOMA_MUESTRA_CABECERA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_LAB_TOMA_MUESTRA_CABECERA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new frm_LAB_TOMA_MUESTRA_CABECERA().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGenerar;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JComboBox cbxBuscar;
    private javax.swing.JComboBox cbxBuscar1;
    private javax.swing.JComboBox cbxBuscar2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPanel jpanel;
    public static javax.swing.JLabel lblCantidad;
    public static javax.swing.JLabel lblCantidad1;
    public static javax.swing.JLabel lblCantidad2;
    private javax.swing.JLabel lblCodPerRegistra;
    private javax.swing.JLabel lblCodPerToma;
    public static javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblContador;
    public static javax.swing.JLabel lblDocumento;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblFecha1;
    public static javax.swing.JLabel lblHc;
    public static javax.swing.JLabel lblHc1;
    public static javax.swing.JLabel lblHc2;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblHora1;
    private javax.swing.JLabel lblNum_toma_mu_exa;
    public static javax.swing.JLabel lblUsu;
    private javax.swing.JDialog nomenclatura;
    private javax.swing.JPanel panelCabecera;
    private javax.swing.JPanel panelPaciente;
    private javax.swing.JDialog personal;
    public static javax.swing.JTable tbPersonal;
    public static javax.swing.JTable tb_Detalle;
    private javax.swing.JTable tb_Nomenclatura;
    private javax.swing.JLabel titulo5;
    private javax.swing.JTextField txtBuscar;
    public static javax.swing.JTextField txtDni;
    public static javax.swing.JTextField txtEdad;
    public static javax.swing.JTextField txtFecha;
    public static javax.swing.JTextField txtHc;
    public static javax.swing.JTextField txtPacientes;
    private javax.swing.JTextField txtPersonalRegistraToma;
    private javax.swing.JTextField txtPersonalTomaMuestra;
    public static javax.swing.JTextField txtSexo;
    // End of variables declaration//GEN-END:variables
}
