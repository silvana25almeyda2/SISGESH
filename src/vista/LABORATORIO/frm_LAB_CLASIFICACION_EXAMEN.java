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
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import modelos.LABORATORIO.LAB_Clasificacion_Examen;
import modelos.LABORATORIO.LAB_Muestra_Examen;
import servicios.Conexion;
import static vista.Principal.fechaActual;
import vista.frmlaboratorioClinico;

/**
 *
 * @author PC-SISTEMA
 */
public class frm_LAB_CLASIFICACION_EXAMEN extends javax.swing.JFrame implements Runnable{
String hora, minutos, segundos, ampm;
    Calendar calendario;
    Thread h1;
    Connection conexion=null;
Conexion c=new Conexion();
DefaultTableModel m;
    /**
     * Creates new form LAB_MUESTRA_EXAMEN
     */
    public frm_LAB_CLASIFICACION_EXAMEN() {
        initComponents();
        c.conectar();
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/iconos/laboratorio.png")).getImage());
        txtGuarModif.setVisible(false);
        h1 = new Thread(this);
        h1.start();
        Buscar_Unidad_Organica.getContentPane().setBackground(Color.white); 
        Buscar_Unidad_Organica.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.white); 
        this.getContentPane().setBackground(Color.white); 
        btnmodificar.setEnabled(false);
        btneliminar.setEnabled(false);
        //listado de la unidad organica
        
        txtCodUni.setVisible(false);
        setLocationRelativeTo(null);//en el centro
        setResizable(false);//para que no funcione el boton maximizar
        //fecha
        Calendar cal=Calendar.getInstance(); 
        String hora=cal.get(cal.HOUR_OF_DAY)+":"+cal.get(cal.MINUTE)+":"+cal.get(cal.SECOND); 
        lblFecha.setText(fechaActual());
        //codigo
        LAB_Clasificacion_Examen u=new LAB_Clasificacion_Examen();
        txtCodigo.setText(u.LAB_Clasificacion_Examen_generarid());
        if(txtCodigo.getText().equalsIgnoreCase("")){
        txtCodigo.setText("CE00000001");
        }
   //para el text Area
   txtObservacion.setLineWrap(true);
   txtObservacion.setWrapStyleWord(true);
   //para limpiar el txt al darle click
   txtBuscarUni.addFocusListener(new FocusListener() {
   @Override
   public void focusGained(FocusEvent e) {
   txtBuscarUni.setText("");
    }

    @Override
    public void focusLost(FocusEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
} );
   //salir presionando escape
        getRootPane().getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW).put(
        javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0), "Cancel");
        
        getRootPane().getActionMap().put("Cancel", new javax.swing.AbstractAction(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e)
            {
                dispose();

            }
        });
    }
    public void LAB_Unidad_Organica_cargar(){
    try {
             String titulos[]={"Nº","Código","Código","Área","Servicio"};
            m=new DefaultTableModel(null,titulos);
            JTable p=new JTable(m);
            String fila[]=new String[6];

            Conexion obj=new Conexion();
        String consulta="exec sp_LAB_CLASIFICACION_EXAMEN_UNIDAD_ORGAN_listar";
        ResultSet r;
        r=obj.Listar(consulta);
        int c=1;
        while(r.next()){
            fila[0]=String.valueOf(c)+"º";
            fila[1]=r.getString(1);
            fila[2]=r.getString(2);
            fila[3]=r.getString(3);
            fila[4]=r.getString(4);

                m.addRow(fila);
                c++;
            }
            tb_Unidad_Organica.setModel(m);
            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m);
            tb_Unidad_Organica.setRowSorter(elQueOrdena);
            this.tb_Unidad_Organica.setModel(m);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(rootPane, "Error en la tabla");
    }
}
    public void LAB_Unidad_Organica_formato(){
    tb_Unidad_Organica.getColumnModel().getColumn(0).setPreferredWidth(50);
    tb_Unidad_Organica.getColumnModel().getColumn(2).setPreferredWidth(60);
    tb_Unidad_Organica.getColumnModel().getColumn(3).setPreferredWidth(140);
    tb_Unidad_Organica.getColumnModel().getColumn(4).setPreferredWidth(160);
        tb_Unidad_Organica.getColumnModel().getColumn(1).setMinWidth(0);
    tb_Unidad_Organica.getColumnModel().getColumn(1).setMaxWidth(0);
    tb_Unidad_Organica.getSelectionModel().setSelectionInterval(0, 0);
            tb_Unidad_Organica.requestFocus();
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

        Buscar_Unidad_Organica = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_Unidad_Organica = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false; //Disallow the editing of any cell
            }};
            txtBuscarUni = new javax.swing.JTextField();
            btnBuscar1 = new javax.swing.JButton();
            jpanel3 = new javax.swing.JPanel();
            titulo8 = new javax.swing.JLabel();
            jpanel = new javax.swing.JPanel();
            titulo5 = new javax.swing.JLabel();
            jLabel14 = new javax.swing.JLabel();
            lblFecha = new javax.swing.JLabel();
            jLabel15 = new javax.swing.JLabel();
            lblHora = new javax.swing.JLabel();
            lblUsu = new javax.swing.JLabel();
            btnNuevo = new javax.swing.JButton();
            btnguardar = new javax.swing.JButton();
            btneliminar = new javax.swing.JButton();
            btnmodificar = new javax.swing.JButton();
            btnBuscar = new javax.swing.JButton();
            jPanel1 = new javax.swing.JPanel();
            jLabel3 = new javax.swing.JLabel();
            jLabel4 = new javax.swing.JLabel();
            jLabel5 = new javax.swing.JLabel();
            jLabel6 = new javax.swing.JLabel();
            jLabel8 = new javax.swing.JLabel();
            jLabel10 = new javax.swing.JLabel();
            txtCodigo = new javax.swing.JTextField();
            jLabel7 = new javax.swing.JLabel();
            txtClasificacion = new javax.swing.JTextField();
            jLabel18 = new javax.swing.JLabel();
            txtGuarModif = new javax.swing.JTextField();
            jLabel9 = new javax.swing.JLabel();
            txtCodUni = new javax.swing.JTextField();
            btnBuscarUnidad = new javax.swing.JButton();
            jScrollPane2 = new javax.swing.JScrollPane();
            txtObservacion = new javax.swing.JTextArea();
            jLabel2 = new javax.swing.JLabel();
            txtServicio = new javax.swing.JTextField();

            Buscar_Unidad_Organica.setTitle("SISGESH .::. BÚSQUEDA DE UNIDAD ORGÁNICA");
            Buscar_Unidad_Organica.setAlwaysOnTop(true);
            Buscar_Unidad_Organica.setFocusCycleRoot(false);
            Buscar_Unidad_Organica.setMinimumSize(new java.awt.Dimension(461, 503));

            tb_Unidad_Organica.setModel(new javax.swing.table.DefaultTableModel(
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
            tb_Unidad_Organica.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
            tb_Unidad_Organica.setRowHeight(25);
            tb_Unidad_Organica.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    tb_Unidad_OrganicaMouseClicked(evt);
                }
            });
            tb_Unidad_Organica.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    tb_Unidad_OrganicaKeyPressed(evt);
                }
            });
            jScrollPane1.setViewportView(tb_Unidad_Organica);

            txtBuscarUni.setForeground(new java.awt.Color(0, 51, 51));
            txtBuscarUni.setText("Ingresar Unidad Orgánica");
            txtBuscarUni.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    txtBuscarUniActionPerformed(evt);
                }
            });
            txtBuscarUni.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    txtBuscarUniKeyPressed(evt);
                }
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    txtBuscarUniKeyTyped(evt);
                }
            });

            btnBuscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/view.gif"))); // NOI18N
            btnBuscar1.setBorder(null);
            btnBuscar1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnBuscar1ActionPerformed(evt);
                }
            });

            jpanel3.setBackground(new java.awt.Color(2, 67, 115));

            titulo8.setBackground(new java.awt.Color(0, 102, 102));
            titulo8.setFont(new java.awt.Font("Segoe UI", 0, 32)); // NOI18N
            titulo8.setForeground(new java.awt.Color(255, 255, 255));
            titulo8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            titulo8.setText("Búsqueda");
            titulo8.setToolTipText("");
            titulo8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

            javax.swing.GroupLayout jpanel3Layout = new javax.swing.GroupLayout(jpanel3);
            jpanel3.setLayout(jpanel3Layout);
            jpanel3Layout.setHorizontalGroup(
                jpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(titulo8, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
            );
            jpanel3Layout.setVerticalGroup(
                jpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(titulo8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
            );

            javax.swing.GroupLayout Buscar_Unidad_OrganicaLayout = new javax.swing.GroupLayout(Buscar_Unidad_Organica.getContentPane());
            Buscar_Unidad_Organica.getContentPane().setLayout(Buscar_Unidad_OrganicaLayout);
            Buscar_Unidad_OrganicaLayout.setHorizontalGroup(
                Buscar_Unidad_OrganicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Buscar_Unidad_OrganicaLayout.createSequentialGroup()
                    .addGroup(Buscar_Unidad_OrganicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(Buscar_Unidad_OrganicaLayout.createSequentialGroup()
                            .addGap(113, 113, 113)
                            .addComponent(txtBuscarUni, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(Buscar_Unidad_OrganicaLayout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(29, Short.MAX_VALUE))
                .addGroup(Buscar_Unidad_OrganicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            Buscar_Unidad_OrganicaLayout.setVerticalGroup(
                Buscar_Unidad_OrganicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Buscar_Unidad_OrganicaLayout.createSequentialGroup()
                    .addGap(58, 58, 58)
                    .addGroup(Buscar_Unidad_OrganicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtBuscarUni, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(51, Short.MAX_VALUE))
                .addGroup(Buscar_Unidad_OrganicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Buscar_Unidad_OrganicaLayout.createSequentialGroup()
                        .addComponent(jpanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 453, Short.MAX_VALUE)))
            );

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

            jpanel.setBackground(new java.awt.Color(2, 67, 115));

            titulo5.setBackground(new java.awt.Color(0, 102, 102));
            titulo5.setFont(new java.awt.Font("Segoe UI Semilight", 0, 36)); // NOI18N
            titulo5.setForeground(new java.awt.Color(255, 255, 255));
            titulo5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            titulo5.setText("Clasificación Examen");
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

            btnNuevo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
            btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Documento-32.png"))); // NOI18N
            btnNuevo.setMnemonic('N');
            btnNuevo.setToolTipText("Nuevo (Alt+N)");
            btnNuevo.setContentAreaFilled(false);
            btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            btnNuevo.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnNuevoActionPerformed(evt);
                }
            });

            btnguardar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
            btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Guardar-32.png"))); // NOI18N
            btnguardar.setMnemonic('G');
            btnguardar.setToolTipText("Guardar (Alt-G)");
            btnguardar.setContentAreaFilled(false);
            btnguardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            btnguardar.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnguardarActionPerformed(evt);
                }
            });

            btneliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
            btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Basura-32.png"))); // NOI18N
            btneliminar.setMnemonic('E');
            btneliminar.setToolTipText("Eliminar (Alt+E)");
            btneliminar.setContentAreaFilled(false);
            btneliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            btneliminar.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btneliminarActionPerformed(evt);
                }
            });

            btnmodificar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
            btnmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Editar-32.png"))); // NOI18N
            btnmodificar.setMnemonic('M');
            btnmodificar.setToolTipText("Modificar (Alt-M)");
            btnmodificar.setContentAreaFilled(false);
            btnmodificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            btnmodificar.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnmodificarActionPerformed(evt);
                }
            });

            btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
            btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Buscar-32.png"))); // NOI18N
            btnBuscar.setMnemonic('B');
            btnBuscar.setToolTipText("Buscar (Alt+B)");
            btnBuscar.setContentAreaFilled(false);
            btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            btnBuscar.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnBuscarActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jpanelLayout = new javax.swing.GroupLayout(jpanel);
            jpanel.setLayout(jpanelLayout);
            jpanelLayout.setHorizontalGroup(
                jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelLayout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpanelLayout.createSequentialGroup()
                            .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(titulo5))
                    .addGap(138, 138, 138)
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
                    .addGap(0, 0, 0)
                    .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnmodificar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btneliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING))
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

            jLabel3.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
            jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/salir16x16.png"))); // NOI18N
            jLabel3.setText("Salir (Esc)");

            jLabel4.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
            jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Document-16.png"))); // NOI18N
            jLabel4.setText("Nuevo (Alt+N)");

            jLabel5.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
            jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/guardar16x16.png"))); // NOI18N
            jLabel5.setText("Guardar (Alt+G)");

            jLabel6.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
            jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/editar.png"))); // NOI18N
            jLabel6.setText("Modificar (Alt+M)");

            jLabel8.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
            jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/eliminar16x16.png"))); // NOI18N
            jLabel8.setText("Eliminar (Alt+E)");

            jLabel10.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
            jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Search-16.png"))); // NOI18N
            jLabel10.setText("Buscar (Alt+B)");

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jLabel4)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel5)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel6)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel8)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                        .addComponent(jLabel4)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(5, 5, 5))
            );

            txtCodigo.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
            txtCodigo.setEnabled(false);

            jLabel7.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
            jLabel7.setText("Clasificación del Examen:");

            txtClasificacion.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
            txtClasificacion.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    txtClasificacionActionPerformed(evt);
                }
            });

            jLabel18.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
            jLabel18.setText("Código:");

            txtGuarModif.setText("G");
            txtGuarModif.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    txtGuarModifActionPerformed(evt);
                }
            });

            jLabel9.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
            jLabel9.setText("Observación:");

            btnBuscarUnidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Search-16.png"))); // NOI18N
            btnBuscarUnidad.setBorder(null);
            btnBuscarUnidad.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnBuscarUnidadActionPerformed(evt);
                }
            });

            txtObservacion.setColumns(20);
            txtObservacion.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
            txtObservacion.setRows(5);
            jScrollPane2.setViewportView(txtObservacion);

            jLabel2.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
            jLabel2.setText("Servicio:");

            txtServicio.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
            txtServicio.setEnabled(false);

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                    .addGap(85, 85, 85)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel7)
                        .addComponent(jLabel9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel18)))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtGuarModif, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtClasificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnBuscarUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE)))
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCodUni, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 0, Short.MAX_VALUE))))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(24, 24, 24)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18)
                        .addComponent(txtGuarModif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtClasificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(27, 27, 27)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(btnBuscarUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(txtCodUni, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        enableDatos();
        limpiar();
        

    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        ImageIcon i=new ImageIcon(this.getClass().getResource("/imagenes/iconos/guardar16x16.png"));
        LAB_Clasificacion_Examen me=new LAB_Clasificacion_Examen();
        LAB_Clasificacion_Examen me1=new LAB_Clasificacion_Examen();
        LAB_Clasificacion_Examen me2=new LAB_Clasificacion_Examen();
        try{
          if(txtGuarModif.getText().equalsIgnoreCase("G")){
            if(txtClasificacion.getText().equalsIgnoreCase("")||txtCodUni.getText().equalsIgnoreCase("")){
              JOptionPane.showMessageDialog(rootPane, "Busque una Unidad Orgánica");
          }  else if(txtObservacion.getText().equalsIgnoreCase("")){
              JOptionPane.showMessageDialog(rootPane, "Ingrese la Observación");
          }  
          else if(me.LAB_Clasificacion_Examen_ver(txtCodUni.getText())>0){
              JOptionPane.showMessageDialog(rootPane, "El Registro ya ha sido ingresado\nIntente nuevamente");
              txtServicio.setText("");
              txtClasificacion.setText("");
              txtClasificacion.requestFocus();
          }else{
              
              int guardar = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea GUARDAR los datos?",
                      "Atención", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,i);
              if(guardar == 0 ){
                  LAB_Clasificacion_Examen meGuardar = new LAB_Clasificacion_Examen();
                  meGuardar.setCod_clasi_exa(txtCodigo.getText());
                  meGuardar.setNombre_clasi_exa(txtClasificacion.getText());
                  meGuardar.setCod_uni_organica_jerar(txtCodUni.getText());
                  meGuardar.setObservacion_clasi(txtObservacion.getText());
                  meGuardar.setNom_usu(lblUsu.getText());
  
                  if(meGuardar.LAB_Clasificacion_Examen_guardar()){
                      JOptionPane.showMessageDialog(null, "Datos Guardados");
                      limpiar();
                      enableDatos();
                      txtGuarModif.setText("G");
                  }
                  else{
                      JOptionPane.showMessageDialog(this, "El Registro ya ha sido ingresado\nIntente nuevamente");
                      
                  }}
          }}else{
             if(txtClasificacion.getText().equalsIgnoreCase("")||txtCodUni.getText().equalsIgnoreCase("")){
              JOptionPane.showMessageDialog(rootPane, "Busque una Unidad Orgánica");
          }  else if(txtObservacion.getText().equalsIgnoreCase("")){
              JOptionPane.showMessageDialog(rootPane, "Ingrese la Observación");
          } 
              else if(me1.LAB_Clasificacion_Examen_codigo(txtCodUni.getText()).equalsIgnoreCase(txtCodigo.getText())==false && me2.LAB_Clasificacion_Examen_ver(txtCodUni.getText())>0 ){
                  JOptionPane.showMessageDialog(rootPane,"El Registro ya existe\nIntente nuevamente");
              txtServicio.setText("");
                  txtClasificacion.setText("");
              txtClasificacion.requestFocus();
              }else{
              int modificar = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea MODIFICAR los datos?",
                      "Atención", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,i);
              if(modificar == 0 ){
                  LAB_Clasificacion_Examen meMod = new LAB_Clasificacion_Examen();
                  meMod.setCod_clasi_exa(txtCodigo.getText());
                  meMod.setNombre_clasi_exa(txtClasificacion.getText());
                  meMod.setCod_uni_organica_jerar(txtCodUni.getText());
                  meMod.setObservacion_clasi(txtObservacion.getText());
                  meMod.setNom_usu(lblUsu.getText());
                  
                  if(meMod.LAB_Clasificacion_Examen_modificar()){
                      JOptionPane.showMessageDialog(this, "Datos Modificados");
                      limpiar();
                      enableDatos();
                      txtGuarModif.setText("G");
                  }
                  else{
                      JOptionPane.showMessageDialog(this, "El Registro ya ha sido ingresado\nIntente nuevamente");

                      
                  }}
                  }}}catch(Exception e) {
              JOptionPane.showMessageDialog(this, "Ingrese todos los campos");
              
          }

    }//GEN-LAST:event_btnguardarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed

        ImageIcon ieli=new ImageIcon(this.getClass().getResource("/imagenes/iconos/eliminar16x16.png"));
        int eliminar = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea ELIMINAR?",
            "Atención", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,ieli );
        try{
            if(eliminar == 0 )
            {
                LAB_Clasificacion_Examen obj=new LAB_Clasificacion_Examen();
                obj.setCod_clasi_exa(txtCodigo.getText());
                if(obj.LAB_Clasificacion_Examen_eliminar())
                {
                    JOptionPane.showMessageDialog(this, "Datos Eliminados");
                       btnguardar.setEnabled(true);
                       btnmodificar.setEnabled(false);
                       btneliminar.setEnabled(false);
                       enableDatos();
                    limpiar();
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Selecione el Personal a eliminar");
        }

    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
        enableDatos();
        txtGuarModif.setText("M");
        btnguardar.setEnabled(true);
        btneliminar.setEnabled(false);
        txtClasificacion.setEnabled(true);
        btnBuscarUnidad.setEnabled(false);
    }//GEN-LAST:event_btnmodificarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
       dispose();
        frm_LAB_BUSCAR_CLASIFICACION_EXAMEN lu=new frm_LAB_BUSCAR_CLASIFICACION_EXAMEN();
        lu.setVisible(true);
        frm_LAB_BUSCAR_CLASIFICACION_EXAMEN.tb_Clasificacion_Examen.getSelectionModel().setSelectionInterval(0, 0);
         frm_LAB_BUSCAR_CLASIFICACION_EXAMEN.tb_Clasificacion_Examen.requestFocus();


    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtGuarModifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGuarModifActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGuarModifActionPerformed

    private void btnBuscarUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarUnidadActionPerformed
        // TODO add your handling code here:
        Buscar_Unidad_Organica.setVisible(true);
        txtBuscarUni.setText("");
        LAB_Unidad_Organica_cargar();
        LAB_Unidad_Organica_formato();
    }//GEN-LAST:event_btnBuscarUnidadActionPerformed

    private void tb_Unidad_OrganicaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_Unidad_OrganicaMouseClicked

    }//GEN-LAST:event_tb_Unidad_OrganicaMouseClicked

    private void tb_Unidad_OrganicaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_Unidad_OrganicaKeyPressed
        char tecla= evt.getKeyChar();
        if(tecla==KeyEvent.VK_ENTER){
            try{
                Buscar_Unidad_Organica.setVisible(false);
                int filaselec=tb_Unidad_Organica.getSelectedRow();
                
                frm_LAB_CLASIFICACION_EXAMEN.txtCodUni.setText(tb_Unidad_Organica.getValueAt(filaselec, 1).toString());
                frm_LAB_CLASIFICACION_EXAMEN.txtClasificacion.setText(tb_Unidad_Organica.getValueAt(filaselec, 3).toString());
        frm_LAB_CLASIFICACION_EXAMEN.txtServicio.setText(tb_Unidad_Organica.getValueAt(filaselec, 4).toString());

                frm_LAB_CLASIFICACION_EXAMEN.txtCodigo.setEnabled(false);
                String u=frmlaboratorioClinico.lblUsu.getText();
                frm_LAB_CLASIFICACION_EXAMEN.lblUsu.setText(u);

            }
            catch(Exception ex)
            {
                System.out.println("Error: " + ex.getMessage());
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_Unidad_OrganicaKeyPressed

    private void txtBuscarUniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarUniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarUniActionPerformed

    private void txtBuscarUniKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarUniKeyPressed
        if(evt.getExtendedKeyCode()==KeyEvent.VK_DOWN){
            tb_Unidad_Organica.getSelectionModel().setSelectionInterval(0, 0);
            tb_Unidad_Organica.requestFocus();
        }
    }//GEN-LAST:event_txtBuscarUniKeyPressed

    private void txtBuscarUniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarUniKeyTyped
        char tecla= evt.getKeyChar();
        if(tecla==KeyEvent.VK_ENTER){
            btnBuscar1.doClick();
        }

    }//GEN-LAST:event_txtBuscarUniKeyTyped

    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed
        // TODO add your handling code here:
        String consulta="";
        try {
            tb_Unidad_Organica.setModel(new DefaultTableModel());
            String titulos[]={"Nº","Código","Código","Área","Servicio"};
            m=new DefaultTableModel(null,titulos);
            JTable p=new JTable(m);
            String fila[]=new String[6];

            LAB_Clasificacion_Examen obj=new LAB_Clasificacion_Examen();
            consulta="exec sp_LAB_CLASIFICACION_EXAMEN_UNIDAD_ORGAN_buscar ?";

            PreparedStatement cmd = obj.getCn().prepareStatement(consulta);
            cmd.setString(1, txtBuscarUni.getText());
            ResultSet r= cmd.executeQuery();
            int c=1;
            while(r.next()){
                fila[0]=String.valueOf(c)+"º";
                fila[1]=r.getString(1);
                fila[2]=r.getString(2);
                fila[3]=r.getString(3);
                fila[4]=r.getString(4);
                m.addRow(fila);
                c++;
            }
            tb_Unidad_Organica.setModel(m);
            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m);
            tb_Unidad_Organica.setRowSorter(elQueOrdena);
            this.tb_Unidad_Organica.setModel(m);
            LAB_Unidad_Organica_formato();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnBuscar1ActionPerformed

    private void txtClasificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClasificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClasificacionActionPerformed
    public void enableDatos(){
    txtClasificacion.setEnabled(true);
    txtObservacion.setEnabled(true);
    btnBuscarUnidad.setEnabled(true);
}
    public void limpiar(){
    LAB_Clasificacion_Examen u=new LAB_Clasificacion_Examen();
        txtCodigo.setText(u.LAB_Clasificacion_Examen_generarid());
   if(txtCodigo.getText().equalsIgnoreCase("")){
        txtCodigo.setText("CE00000001");
    }
   txtServicio.setText("");
    txtClasificacion.setText("");
    txtCodUni.setText("");
    txtObservacion.setText("");
        txtGuarModif.setText("G");
   btnguardar.setEnabled(true);
   btnmodificar.setEnabled(false);
   btneliminar.setEnabled(false);
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
            java.util.logging.Logger.getLogger(frm_LAB_CLASIFICACION_EXAMEN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_LAB_CLASIFICACION_EXAMEN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_LAB_CLASIFICACION_EXAMEN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_LAB_CLASIFICACION_EXAMEN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new frm_LAB_CLASIFICACION_EXAMEN().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog Buscar_Unidad_Organica;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscar1;
    public static javax.swing.JButton btnBuscarUnidad;
    private javax.swing.JButton btnNuevo;
    public static javax.swing.JButton btneliminar;
    public static javax.swing.JButton btnguardar;
    public static javax.swing.JButton btnmodificar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jpanel;
    private javax.swing.JPanel jpanel3;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblHora;
    public static javax.swing.JLabel lblUsu;
    public static javax.swing.JTable tb_Unidad_Organica;
    private javax.swing.JLabel titulo5;
    private javax.swing.JLabel titulo8;
    private javax.swing.JTextField txtBuscarUni;
    public static javax.swing.JTextField txtClasificacion;
    public static javax.swing.JTextField txtCodUni;
    public static javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtGuarModif;
    public static javax.swing.JTextArea txtObservacion;
    public static javax.swing.JTextField txtServicio;
    // End of variables declaration//GEN-END:variables
}
