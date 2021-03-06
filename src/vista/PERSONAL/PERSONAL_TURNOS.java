/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.PERSONAL;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import modelos.PERSONAL.CLS_PERSONAL_HORARIOS;
import modelos.PERSONAL.CLS_PERSONAL_TURNOS;
import modelos.PERSONAL.CLS_PERSONAL_TURNO_GT;
import modelos.Usuario;
import servicios.Conexion;
import static vista.PERSONAL.PERSONAL_ROL.TB_TURNOS_UO;
import static vista.PERSONAL.PERSONAL_ROL.txtAR_ID;
import vista.PrincipalMDI;
import vista.PERSONAL.PERSONAL_TURNOS;

/**
 *
 * @author MYS3
 */
public class PERSONAL_TURNOS extends javax.swing.JFrame {
Conexion conectar=new Conexion();
Connection con;
String hora, minutos, segundos, ampm;
Calendar calendario;
Thread h1;
ResultSet r;
CallableStatement cst;
DefaultTableModel m, m1, m2, m3, m4, msb, m5, m6, m7, m8;
    /**
     * Creates new form PERSONAL_TURNOS
     */
    public PERSONAL_TURNOS() {
        initComponents();
        con=conectar.conectar();
        this.getContentPane().setBackground(Color.white);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        UNIDAD_ORGANICA.setLocationRelativeTo(null);
        UNIDAD_ORGANICA.getContentPane().setBackground(Color.white);
        HORARIOS.setLocationRelativeTo(null);
        HORARIOS.getContentPane().setBackground(Color.white);
        TURNOS.setLocationRelativeTo(null);
        TURNOS.getContentPane().setBackground(Color.white);
        
        addEscapeListenerWindowDialog(HORARIOS);
        addEscapeListenerWindowDialog(TURNOS);
        addEscapeListenerWindowDialog(UNIDAD_ORGANICA);
        
        btnguardar.setEnabled(false);
        btneliminar.setEnabled(false);
        
        inicializar_tabla_TURNOS_UNIDAD_ORGANICA();
       
        jTabbedPane1.setEnabledAt(0,false);
        jTabbedPane1.setEnabledAt(1, false);
        
        //GENERAR ID
        CLS_PERSONAL_TURNOS num=new CLS_PERSONAL_TURNOS();
        TXT_COD_TURNO_UO.setText(num.PERSONAL_TURNOS_UO_GENERAR_ID());
        if(TXT_COD_TURNO_UO.getText().equalsIgnoreCase("")){
        TXT_COD_TURNO_UO.setText("TU0000000000001");
        } 
        
        //GENERAR ID HORARIOS
        CLS_PERSONAL_HORARIOS numH=new CLS_PERSONAL_HORARIOS();
        TXT_COD_HORARIO.setText(numH.PERSONAL_HORARIOS_GENERAR_ID());
        if(TXT_COD_HORARIO.getText().equalsIgnoreCase("")){
        TXT_COD_HORARIO.setText("PH00001");
        } 
        
        //GENERAR ID TURNOS
        CLS_PERSONAL_TURNO_GT GT=new CLS_PERSONAL_TURNO_GT();
        TXT_COD_TURNOS_GT.setText(GT.PERSONAL_TURNOS_GT_GENERAR_ID());
        if(TXT_COD_TURNOS_GT.getText().equalsIgnoreCase("")){
        TXT_COD_TURNOS_GT.setText("T000000001");
        } 
        
        jTabbedPane2.setEnabledAt(0,false);
        jTabbedPane2.setEnabledAt(1, false);
        
        jTabbedPane2.setSelectedIndex(1);
        
        jTabbedPane3.setEnabledAt(0,false);
        jTabbedPane3.setEnabledAt(1, false);
        
        jTabbedPane3.setSelectedIndex(1);
        
        cargar_cbx();
        CARGAR_HORAS_CBX();
        
        Mostrar_HORARIOS();
        
        jLabel5.setVisible(false);
        TXT_TURNOS_POR_HORARIO_TIPO_NOMEN.setVisible(false);
//        TXT_TURNOS_POR_HORARIO_TIPO_DESCRIP.setVisible(false);
        jScrollPane3.setVisible(false);
        
        jLabel6.setVisible(false);
        TXT_SISTEMA_UNIDAD_ORGANICA.setVisible(false);
        BTN_BUSCAR_UO.setVisible(false);
        
        CBX_TIPO_TURNO.setEnabled(false);
        TXT_HORARIO.setEnabled(false);
        TB_HORARIOS.setEnabled(false);
        TB_HORARIOS.setBackground(Color.lightGray);
        
        BTN_INICIO.requestFocus();
        
        deshabilitar_horario();
        
        //OCULTAR BTN FRM HORARIO
        btneditar_HORARIO.setVisible(false);
        btneliminar_HORARIO.setVisible(false);
        btnLista_HORARIO.setVisible(false);
        
        //OCULTAR BTN FRM TURNOS
        btneditar_TURNO.setVisible(false);
        btneliminar_TURNO.setVisible(false);
        btnLista_TURNO.setVisible(false);
        
        BTN_AGREGAR_HORARIOS.setEnabled(false);
        BTN_AGREGAR_TURNOS.setVisible(false);
        
        //OCULTAR JLABEL
        LBL_COD_TIPO_TURNOS.setVisible(false);
        LBL_ESTADO.setVisible(false);
        LBL_COD_TURNO.setVisible(false);
        LBL_COD_UO.setVisible(false);
        LBL_GM.setVisible(false);
        
        //CERRAR CON ESCAPE
        getRootPane().getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW).put(
        javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0), "Cancel");
        
        getRootPane().getActionMap().put("Cancel", new javax.swing.AbstractAction(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e)
            {
                
                cerrar();
                                
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        UNIDAD_ORGANICA = new javax.swing.JDialog();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TB_UNIDAD_ORGANICA = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        TXT_BUSCAR_UNIDAD_ORGANICA = new javax.swing.JTextField();
        btnBuscarPersonal_rol3 = new javax.swing.JButton();
        HORARIOS = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        btnNuevo_HORARIO = new javax.swing.JButton();
        btneditar_HORARIO = new javax.swing.JButton();
        btneliminar_HORARIO = new javax.swing.JButton();
        btnLista_HORARIO = new javax.swing.JButton();
        btnguardar_HORARIO = new javax.swing.JButton();
        LBL_COD_UO_ACTIVIDADES = new javax.swing.JLabel();
        LBL_GM1 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        TXT_COD_HORARIO = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        CBX_HORA_INICIO = new javax.swing.JComboBox();
        jLabel20 = new javax.swing.JLabel();
        CBX_HORA_FIN = new javax.swing.JComboBox();
        jLabel21 = new javax.swing.JLabel();
        TXT_HORA_COMPLETA = new javax.swing.JTextField();
        CB_PASAR_DIA = new javax.swing.JCheckBox();
        jLabel22 = new javax.swing.JLabel();
        TXT_TOTAL_HORA = new javax.swing.JTextField();
        TURNOS = new javax.swing.JDialog();
        jPanel9 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        btnNuevo_TURNO = new javax.swing.JButton();
        btneditar_TURNO = new javax.swing.JButton();
        btneliminar_TURNO = new javax.swing.JButton();
        btnLista_TURNO = new javax.swing.JButton();
        btnguardar_TURNO_GT = new javax.swing.JButton();
        LBL_COD_UO_ACTIVIDADES1 = new javax.swing.JLabel();
        LBL_GM2 = new javax.swing.JLabel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        TXT_COD_TURNOS_GT = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        TXT_COD_HORARIO_GT = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        TB_HORARIO_TURNOS_GT = new javax.swing.JTable();
        jLabel28 = new javax.swing.JLabel();
        TXT_HORA_COMPLETA_GT = new javax.swing.JTextField();
        TXT_TOTAL_HORAS_GT = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        CBX_TIPO_TURNO_GT = new javax.swing.JComboBox();
        jLabel29 = new javax.swing.JLabel();
        TXT_NOMENCLATURA_GT = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        TXT_DESCRIPCION_GT = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        TXT_PRECIO_NORMAL = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        TXT_PRECIO_SABADO = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        TXT_PRECIO_FERIADO = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        TXT_PRECIO_DOMINGO = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnLista = new javax.swing.JButton();
        lblusu = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        TXT_BUSCAR_TURNOS_UNIDAD_ORGANICA = new javax.swing.JTextField();
        btnBuscarPersonal_rol1 = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        CBX_TIPO_TURNO = new javax.swing.JComboBox();
        P_HORARIOS = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TB_HORARIOS = new javax.swing.JTable();
        TXT_HORARIO = new javax.swing.JTextField();
        BTN_AGREGAR_HORARIOS = new javax.swing.JButton();
        LBL_COD_HORARIO = new javax.swing.JLabel();
        LBL_COD_TIPO_TURNOS = new javax.swing.JLabel();
        P_TURNOS = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        TXT_TURNOS_POR_HORARIO_TIPO_NOMEN = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        TB_TURNOS = new javax.swing.JTable();
        BTN_AGREGAR_TURNOS = new javax.swing.JButton();
        LBL_ESTADO = new javax.swing.JLabel();
        LBL_COD_TURNO = new javax.swing.JLabel();
        LBL_COD_UO = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        TXT_COD_TURNO_UO = new javax.swing.JTextField();
        P_UO = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        TXT_SISTEMA_UNIDAD_ORGANICA = new javax.swing.JTextField();
        BTN_BUSCAR_UO = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TB_TURNOS_UNIDAD_ORGANICA = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        lblListado_Edicion = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        BTN_INICIO = new javax.swing.JButton();
        LBL_GM = new javax.swing.JLabel();

        UNIDAD_ORGANICA.setAlwaysOnTop(true);
        UNIDAD_ORGANICA.setMinimumSize(new java.awt.Dimension(500, 430));

        jLabel7.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("UNIDAD ORGANICA");

        jScrollPane4.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        TB_UNIDAD_ORGANICA.setModel(new javax.swing.table.DefaultTableModel(
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
        TB_UNIDAD_ORGANICA.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        TB_UNIDAD_ORGANICA.setRowHeight(35);
        TB_UNIDAD_ORGANICA.setSelectionBackground(new java.awt.Color(102, 102, 102));
        TB_UNIDAD_ORGANICA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TB_UNIDAD_ORGANICAKeyPressed(evt);
            }
        });
        jScrollPane4.setViewportView(TB_UNIDAD_ORGANICA);

        jLabel8.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        jLabel8.setText("Cod. Unidad Organica, Nombre Unidad Organica, Cod. Area");

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        TXT_BUSCAR_UNIDAD_ORGANICA.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        TXT_BUSCAR_UNIDAD_ORGANICA.setForeground(new java.awt.Color(51, 51, 51));
        TXT_BUSCAR_UNIDAD_ORGANICA.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        TXT_BUSCAR_UNIDAD_ORGANICA.setToolTipText("");
        TXT_BUSCAR_UNIDAD_ORGANICA.setBorder(null);
        TXT_BUSCAR_UNIDAD_ORGANICA.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                TXT_BUSCAR_UNIDAD_ORGANICACaretUpdate(evt);
            }
        });
        TXT_BUSCAR_UNIDAD_ORGANICA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_BUSCAR_UNIDAD_ORGANICAActionPerformed(evt);
            }
        });
        TXT_BUSCAR_UNIDAD_ORGANICA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TXT_BUSCAR_UNIDAD_ORGANICAKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXT_BUSCAR_UNIDAD_ORGANICAKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TXT_BUSCAR_UNIDAD_ORGANICAKeyTyped(evt);
            }
        });

        btnBuscarPersonal_rol3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Búsqueda-25.png"))); // NOI18N
        btnBuscarPersonal_rol3.setToolTipText("");
        btnBuscarPersonal_rol3.setContentAreaFilled(false);
        btnBuscarPersonal_rol3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarPersonal_rol3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPersonal_rol3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(TXT_BUSCAR_UNIDAD_ORGANICA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarPersonal_rol3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TXT_BUSCAR_UNIDAD_ORGANICA, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(btnBuscarPersonal_rol3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout UNIDAD_ORGANICALayout = new javax.swing.GroupLayout(UNIDAD_ORGANICA.getContentPane());
        UNIDAD_ORGANICA.getContentPane().setLayout(UNIDAD_ORGANICALayout);
        UNIDAD_ORGANICALayout.setHorizontalGroup(
            UNIDAD_ORGANICALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
            .addGroup(UNIDAD_ORGANICALayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(UNIDAD_ORGANICALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(UNIDAD_ORGANICALayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(32, 32, 32)))
                .addContainerGap(130, Short.MAX_VALUE))
        );
        UNIDAD_ORGANICALayout.setVerticalGroup(
            UNIDAD_ORGANICALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UNIDAD_ORGANICALayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel7)
                .addGap(20, 20, 20)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );

        HORARIOS.setAlwaysOnTop(true);
        HORARIOS.setMinimumSize(new java.awt.Dimension(660, 405));

        jPanel5.setBackground(new java.awt.Color(122, 77, 135));
        jPanel5.setPreferredSize(new java.awt.Dimension(300, 70));

        jLabel10.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Horarios");

        btnNuevo_HORARIO.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnNuevo_HORARIO.setForeground(new java.awt.Color(240, 240, 240));
        btnNuevo_HORARIO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Icon/Documento-32.png"))); // NOI18N
        btnNuevo_HORARIO.setContentAreaFilled(false);
        btnNuevo_HORARIO.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo_HORARIO.setIconTextGap(30);
        btnNuevo_HORARIO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo_HORARIOActionPerformed(evt);
            }
        });

        btneditar_HORARIO.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btneditar_HORARIO.setForeground(new java.awt.Color(240, 240, 240));
        btneditar_HORARIO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Icon/Editar-32.png"))); // NOI18N
        btneditar_HORARIO.setContentAreaFilled(false);
        btneditar_HORARIO.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btneditar_HORARIO.setIconTextGap(30);
        btneditar_HORARIO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditar_HORARIOActionPerformed(evt);
            }
        });

        btneliminar_HORARIO.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btneliminar_HORARIO.setForeground(new java.awt.Color(240, 240, 240));
        btneliminar_HORARIO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Icon/Basura-32.png"))); // NOI18N
        btneliminar_HORARIO.setContentAreaFilled(false);
        btneliminar_HORARIO.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btneliminar_HORARIO.setIconTextGap(30);
        btneliminar_HORARIO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminar_HORARIOActionPerformed(evt);
            }
        });

        btnLista_HORARIO.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnLista_HORARIO.setForeground(new java.awt.Color(240, 240, 240));
        btnLista_HORARIO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Orden de compra-32.png"))); // NOI18N
        btnLista_HORARIO.setContentAreaFilled(false);
        btnLista_HORARIO.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLista_HORARIO.setIconTextGap(30);
        btnLista_HORARIO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLista_HORARIOActionPerformed(evt);
            }
        });

        btnguardar_HORARIO.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnguardar_HORARIO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Guardar-32.png"))); // NOI18N
        btnguardar_HORARIO.setMnemonic('G');
        btnguardar_HORARIO.setToolTipText("Guardar (Alt-G)");
        btnguardar_HORARIO.setContentAreaFilled(false);
        btnguardar_HORARIO.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnguardar_HORARIO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardar_HORARIOActionPerformed(evt);
            }
        });

        LBL_COD_UO_ACTIVIDADES.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LBL_COD_UO_ACTIVIDADES.setForeground(new java.awt.Color(122, 77, 135));
        LBL_COD_UO_ACTIVIDADES.setText("jLabel4");

        LBL_GM1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LBL_GM1.setForeground(new java.awt.Color(122, 77, 135));
        LBL_GM1.setText("G");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LBL_GM1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(LBL_COD_UO_ACTIVIDADES, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(138, 138, 138))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnNuevo_HORARIO, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnguardar_HORARIO, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btneditar_HORARIO, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btneliminar_HORARIO, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLista_HORARIO, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LBL_COD_UO_ACTIVIDADES)
                            .addComponent(LBL_GM1)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNuevo_HORARIO)
                    .addComponent(btneditar_HORARIO)
                    .addComponent(btneliminar_HORARIO)
                    .addComponent(btnguardar_HORARIO)
                    .addComponent(btnLista_HORARIO))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 655, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 289, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("tab1", jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel18.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel18.setText("Código de Horario    :");

        TXT_COD_HORARIO.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        TXT_COD_HORARIO.setEnabled(false);

        jLabel19.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel19.setText("Hora de Inicio           :");

        CBX_HORA_INICIO.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        CBX_HORA_INICIO.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CBX_HORA_INICIO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CBX_HORA_INICIOKeyPressed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel20.setText("Hora de Fin              :");

        CBX_HORA_FIN.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        CBX_HORA_FIN.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CBX_HORA_FIN.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CBX_HORA_FINItemStateChanged(evt);
            }
        });
        CBX_HORA_FIN.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                CBX_HORA_FINPropertyChange(evt);
            }
        });
        CBX_HORA_FIN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CBX_HORA_FINKeyPressed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel21.setText("Hora Completa         :");

        TXT_HORA_COMPLETA.setEditable(false);
        TXT_HORA_COMPLETA.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        TXT_HORA_COMPLETA.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        CB_PASAR_DIA.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        CB_PASAR_DIA.setText("Pasar Día");
        CB_PASAR_DIA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CB_PASAR_DIAMouseClicked(evt);
            }
        });
        CB_PASAR_DIA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CB_PASAR_DIAKeyPressed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel22.setText("Total de Horas          :");

        TXT_TOTAL_HORA.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(18, 18, 18)
                        .addComponent(TXT_TOTAL_HORA, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addGap(18, 18, 18)
                                        .addComponent(CBX_HORA_INICIO, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addGap(18, 18, 18)
                                        .addComponent(TXT_COD_HORARIO, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20)
                                    .addComponent(CB_PASAR_DIA))
                                .addGap(18, 18, 18)
                                .addComponent(CBX_HORA_FIN, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(18, 18, 18)
                                .addComponent(TXT_HORA_COMPLETA, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(30, Short.MAX_VALUE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TXT_COD_HORARIO, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                        .addComponent(CB_PASAR_DIA))
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CBX_HORA_INICIO, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CBX_HORA_FIN, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(TXT_HORA_COMPLETA, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TXT_TOTAL_HORA)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        jTabbedPane2.addTab("tab2", jPanel7);

        javax.swing.GroupLayout HORARIOSLayout = new javax.swing.GroupLayout(HORARIOS.getContentPane());
        HORARIOS.getContentPane().setLayout(HORARIOSLayout);
        HORARIOSLayout.setHorizontalGroup(
            HORARIOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
            .addComponent(jTabbedPane2)
        );
        HORARIOSLayout.setVerticalGroup(
            HORARIOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HORARIOSLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        TURNOS.setAlwaysOnTop(true);
        TURNOS.setMinimumSize(new java.awt.Dimension(724, 631));

        jPanel9.setBackground(new java.awt.Color(122, 77, 135));
        jPanel9.setPreferredSize(new java.awt.Dimension(300, 70));

        jLabel11.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Turnos");

        btnNuevo_TURNO.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnNuevo_TURNO.setForeground(new java.awt.Color(240, 240, 240));
        btnNuevo_TURNO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Icon/Documento-32.png"))); // NOI18N
        btnNuevo_TURNO.setContentAreaFilled(false);
        btnNuevo_TURNO.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo_TURNO.setIconTextGap(30);
        btnNuevo_TURNO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo_TURNOActionPerformed(evt);
            }
        });

        btneditar_TURNO.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btneditar_TURNO.setForeground(new java.awt.Color(240, 240, 240));
        btneditar_TURNO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Icon/Editar-32.png"))); // NOI18N
        btneditar_TURNO.setContentAreaFilled(false);
        btneditar_TURNO.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btneditar_TURNO.setIconTextGap(30);
        btneditar_TURNO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditar_TURNOActionPerformed(evt);
            }
        });

        btneliminar_TURNO.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btneliminar_TURNO.setForeground(new java.awt.Color(240, 240, 240));
        btneliminar_TURNO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Icon/Basura-32.png"))); // NOI18N
        btneliminar_TURNO.setContentAreaFilled(false);
        btneliminar_TURNO.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btneliminar_TURNO.setIconTextGap(30);
        btneliminar_TURNO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminar_TURNOActionPerformed(evt);
            }
        });

        btnLista_TURNO.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnLista_TURNO.setForeground(new java.awt.Color(240, 240, 240));
        btnLista_TURNO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Orden de compra-32.png"))); // NOI18N
        btnLista_TURNO.setContentAreaFilled(false);
        btnLista_TURNO.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLista_TURNO.setIconTextGap(30);
        btnLista_TURNO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLista_TURNOActionPerformed(evt);
            }
        });

        btnguardar_TURNO_GT.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnguardar_TURNO_GT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Guardar-32.png"))); // NOI18N
        btnguardar_TURNO_GT.setMnemonic('G');
        btnguardar_TURNO_GT.setToolTipText("Guardar (Alt-G)");
        btnguardar_TURNO_GT.setContentAreaFilled(false);
        btnguardar_TURNO_GT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnguardar_TURNO_GT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardar_TURNO_GTActionPerformed(evt);
            }
        });

        LBL_COD_UO_ACTIVIDADES1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LBL_COD_UO_ACTIVIDADES1.setForeground(new java.awt.Color(122, 77, 135));
        LBL_COD_UO_ACTIVIDADES1.setText("jLabel4");

        LBL_GM2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LBL_GM2.setForeground(new java.awt.Color(122, 77, 135));
        LBL_GM2.setText("G");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LBL_GM2, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(LBL_COD_UO_ACTIVIDADES1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(174, 174, 174))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(btnNuevo_TURNO, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnguardar_TURNO_GT, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btneditar_TURNO, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btneliminar_TURNO, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLista_TURNO, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LBL_COD_UO_ACTIVIDADES1)
                            .addComponent(LBL_GM2)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNuevo_TURNO)
                    .addComponent(btneditar_TURNO)
                    .addComponent(btneliminar_TURNO)
                    .addComponent(btnguardar_TURNO_GT)
                    .addComponent(btnLista_TURNO))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane3.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane3.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 719, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 502, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("tab1", jPanel10);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        jLabel23.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel23.setText("Código de Horario    :");

        TXT_COD_TURNOS_GT.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        TXT_COD_TURNOS_GT.setEnabled(false);

        jLabel24.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel24.setText("Código de Horario    :");

        jLabel27.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel27.setText("Total de Horas          :");

        TXT_COD_HORARIO_GT.setEditable(false);
        TXT_COD_HORARIO_GT.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N

        jScrollPane6.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        TB_HORARIO_TURNOS_GT = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        TB_HORARIO_TURNOS_GT.setModel(new javax.swing.table.DefaultTableModel(
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
        TB_HORARIO_TURNOS_GT.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        TB_HORARIO_TURNOS_GT.setRowHeight(30);
        TB_HORARIO_TURNOS_GT.setSelectionBackground(new java.awt.Color(102, 102, 102));
        TB_HORARIO_TURNOS_GT.getTableHeader().setReorderingAllowed(false);
        TB_HORARIO_TURNOS_GT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TB_HORARIO_TURNOS_GTMouseClicked(evt);
            }
        });
        TB_HORARIO_TURNOS_GT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TB_HORARIO_TURNOS_GTKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TB_HORARIO_TURNOS_GTKeyReleased(evt);
            }
        });
        jScrollPane6.setViewportView(TB_HORARIO_TURNOS_GT);

        jLabel28.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel28.setText("Hora Completa  :");

        TXT_HORA_COMPLETA_GT.setEditable(false);
        TXT_HORA_COMPLETA_GT.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        TXT_HORA_COMPLETA_GT.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        TXT_TOTAL_HORAS_GT.setEditable(false);
        TXT_TOTAL_HORAS_GT.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel12.setText("Tipo de Turno          :");

        CBX_TIPO_TURNO_GT.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CBX_TIPO_TURNO_GT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CBX_TIPO_TURNO_GTKeyPressed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel29.setText("Nomenclatura    :");

        TXT_NOMENCLATURA_GT.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        TXT_NOMENCLATURA_GT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TXT_NOMENCLATURA_GTKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXT_NOMENCLATURA_GTKeyReleased(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel30.setText("Descripción        :");

        TXT_DESCRIPCION_GT.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        TXT_DESCRIPCION_GT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TXT_DESCRIPCION_GTKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXT_DESCRIPCION_GTKeyReleased(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel31.setText("Precio Normal          :");

        TXT_PRECIO_NORMAL.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        TXT_PRECIO_NORMAL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TXT_PRECIO_NORMALKeyPressed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel32.setText("Precio Sábado          :");

        TXT_PRECIO_SABADO.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        TXT_PRECIO_SABADO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TXT_PRECIO_SABADOKeyPressed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel33.setText("Precio Feriado    :");

        TXT_PRECIO_FERIADO.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        TXT_PRECIO_FERIADO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TXT_PRECIO_FERIADOKeyPressed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel34.setText("Precio Domingo :");

        TXT_PRECIO_DOMINGO.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        TXT_PRECIO_DOMINGO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TXT_PRECIO_DOMINGOKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TXT_COD_HORARIO_GT, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TXT_HORA_COMPLETA_GT))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TXT_COD_TURNOS_GT, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TXT_TOTAL_HORAS_GT, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                    .addComponent(CBX_TIPO_TURNO_GT, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel31)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TXT_PRECIO_NORMAL))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TXT_PRECIO_SABADO)))
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addComponent(jLabel30)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addComponent(jLabel29)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(TXT_NOMENCLATURA_GT))))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addGap(55, 55, 55)
                                        .addComponent(jLabel33))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel34)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TXT_DESCRIPCION_GT)
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(TXT_PRECIO_DOMINGO, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(TXT_PRECIO_FERIADO, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TXT_PRECIO_FERIADO, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57))
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TXT_PRECIO_DOMINGO, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TXT_COD_TURNOS_GT, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TXT_COD_HORARIO_GT, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TXT_HORA_COMPLETA_GT, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TXT_TOTAL_HORAS_GT, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TXT_NOMENCLATURA_GT, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CBX_TIPO_TURNO_GT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TXT_DESCRIPCION_GT, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TXT_PRECIO_NORMAL, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TXT_PRECIO_SABADO, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("tab2", jPanel12);

        javax.swing.GroupLayout TURNOSLayout = new javax.swing.GroupLayout(TURNOS.getContentPane());
        TURNOS.getContentPane().setLayout(TURNOSLayout);
        TURNOSLayout.setHorizontalGroup(
            TURNOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
            .addComponent(jTabbedPane3)
        );
        TURNOSLayout.setVerticalGroup(
            TURNOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TURNOSLayout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(122, 77, 135));
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 70));

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("<html>Personal<span style=\"font-size:'14px'\"><br>TURNOS</br></span></html>");

        btnNuevo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(240, 240, 240));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Icon/Documento-32.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setContentAreaFilled(false);
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnNuevo.setIconTextGap(30);
        btnNuevo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        btnNuevo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnNuevoKeyPressed(evt);
            }
        });

        btneliminar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btneliminar.setForeground(new java.awt.Color(240, 240, 240));
        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Icon/Basura-32.png"))); // NOI18N
        btneliminar.setText("Eliminar");
        btneliminar.setContentAreaFilled(false);
        btneliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btneliminar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btneliminar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btneliminar.setIconTextGap(30);
        btneliminar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btnLista.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnLista.setForeground(new java.awt.Color(240, 240, 240));
        btnLista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Orden de compra-32.png"))); // NOI18N
        btnLista.setText("Listado");
        btnLista.setContentAreaFilled(false);
        btnLista.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLista.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnLista.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnLista.setIconTextGap(30);
        btnLista.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaActionPerformed(evt);
            }
        });

        lblusu.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        lblusu.setForeground(new java.awt.Color(255, 255, 255));
        lblusu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Usuario-40.png"))); // NOI18N
        lblusu.setText("Usuario");
        lblusu.setFocusable(false);
        lblusu.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));

        TXT_BUSCAR_TURNOS_UNIDAD_ORGANICA.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        TXT_BUSCAR_TURNOS_UNIDAD_ORGANICA.setForeground(new java.awt.Color(51, 51, 51));
        TXT_BUSCAR_TURNOS_UNIDAD_ORGANICA.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        TXT_BUSCAR_TURNOS_UNIDAD_ORGANICA.setBorder(null);
        TXT_BUSCAR_TURNOS_UNIDAD_ORGANICA.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                TXT_BUSCAR_TURNOS_UNIDAD_ORGANICACaretUpdate(evt);
            }
        });
        TXT_BUSCAR_TURNOS_UNIDAD_ORGANICA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TXT_BUSCAR_TURNOS_UNIDAD_ORGANICAMouseClicked(evt);
            }
        });
        TXT_BUSCAR_TURNOS_UNIDAD_ORGANICA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_BUSCAR_TURNOS_UNIDAD_ORGANICAActionPerformed(evt);
            }
        });
        TXT_BUSCAR_TURNOS_UNIDAD_ORGANICA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TXT_BUSCAR_TURNOS_UNIDAD_ORGANICAKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXT_BUSCAR_TURNOS_UNIDAD_ORGANICAKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TXT_BUSCAR_TURNOS_UNIDAD_ORGANICAKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addComponent(TXT_BUSCAR_TURNOS_UNIDAD_ORGANICA, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(TXT_BUSCAR_TURNOS_UNIDAD_ORGANICA, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnBuscarPersonal_rol1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Búsqueda-27.png"))); // NOI18N
        btnBuscarPersonal_rol1.setContentAreaFilled(false);
        btnBuscarPersonal_rol1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarPersonal_rol1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarPersonal_rol1MouseClicked(evt);
            }
        });
        btnBuscarPersonal_rol1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPersonal_rol1ActionPerformed(evt);
            }
        });

        btnguardar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnguardar.setForeground(new java.awt.Color(240, 240, 240));
        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Guardar-32.png"))); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.setContentAreaFilled(false);
        btnguardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnguardar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnguardar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnguardar.setIconTextGap(30);
        btnguardar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        btnguardar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnguardarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblusu, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarPersonal_rol1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btneliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLista, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnguardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarPersonal_rol1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(btnNuevo)
                .addGap(19, 19, 19)
                .addComponent(btnguardar)
                .addGap(18, 18, 18)
                .addComponent(btneliminar)
                .addGap(18, 18, 18)
                .addComponent(btnLista)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblusu, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel2.setText("Nuevo Turno");

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel3.setText("Tipo de Turno:");

        CBX_TIPO_TURNO.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CBX_TIPO_TURNO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CBX_TIPO_TURNOMouseClicked(evt);
            }
        });
        CBX_TIPO_TURNO.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CBX_TIPO_TURNOItemStateChanged(evt);
            }
        });
        CBX_TIPO_TURNO.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                CBX_TIPO_TURNOPropertyChange(evt);
            }
        });
        CBX_TIPO_TURNO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CBX_TIPO_TURNOKeyPressed(evt);
            }
        });

        P_HORARIOS.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel4.setText("Horario:");

        jScrollPane2.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        TB_HORARIOS = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        TB_HORARIOS.setModel(new javax.swing.table.DefaultTableModel(
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
        TB_HORARIOS.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        TB_HORARIOS.setRowHeight(30);
        TB_HORARIOS.setSelectionBackground(new java.awt.Color(102, 102, 102));
        TB_HORARIOS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TB_HORARIOSMouseClicked(evt);
            }
        });
        TB_HORARIOS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TB_HORARIOSKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(TB_HORARIOS);

        TXT_HORARIO.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TXT_HORARIO.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                TXT_HORARIOCaretUpdate(evt);
            }
        });
        TXT_HORARIO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXT_HORARIOKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TXT_HORARIOKeyTyped(evt);
            }
        });

        BTN_AGREGAR_HORARIOS.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        BTN_AGREGAR_HORARIOS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Agregar propiedad-30.png"))); // NOI18N
        BTN_AGREGAR_HORARIOS.setText("Agregar Horarios");
        BTN_AGREGAR_HORARIOS.setContentAreaFilled(false);
        BTN_AGREGAR_HORARIOS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_AGREGAR_HORARIOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_AGREGAR_HORARIOSActionPerformed(evt);
            }
        });

        LBL_COD_HORARIO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LBL_COD_HORARIO.setText("HORARIO");

        javax.swing.GroupLayout P_HORARIOSLayout = new javax.swing.GroupLayout(P_HORARIOS);
        P_HORARIOS.setLayout(P_HORARIOSLayout);
        P_HORARIOSLayout.setHorizontalGroup(
            P_HORARIOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P_HORARIOSLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(96, 96, 96)
                .addComponent(TXT_HORARIO, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LBL_COD_HORARIO, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(375, 375, 375)
                .addComponent(BTN_AGREGAR_HORARIOS)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
        );
        P_HORARIOSLayout.setVerticalGroup(
            P_HORARIOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P_HORARIOSLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(P_HORARIOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(P_HORARIOSLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(P_HORARIOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LBL_COD_HORARIO, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(P_HORARIOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(TXT_HORARIO, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(BTN_AGREGAR_HORARIOS))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(319, 319, 319))
        );

        LBL_COD_TIPO_TURNOS.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LBL_COD_TIPO_TURNOS.setText("COD_TIPO_TURNO");

        P_TURNOS.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel5.setText("Turnos:");

        TXT_TURNOS_POR_HORARIO_TIPO_NOMEN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TXT_TURNOS_POR_HORARIO_TIPO_NOMEN.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                TXT_TURNOS_POR_HORARIO_TIPO_NOMENCaretUpdate(evt);
            }
        });
        TXT_TURNOS_POR_HORARIO_TIPO_NOMEN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXT_TURNOS_POR_HORARIO_TIPO_NOMENKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TXT_TURNOS_POR_HORARIO_TIPO_NOMENKeyTyped(evt);
            }
        });

        jScrollPane3.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        TB_TURNOS = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        TB_TURNOS.setModel(new javax.swing.table.DefaultTableModel(
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
        TB_TURNOS.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        TB_TURNOS.setRowHeight(35);
        TB_TURNOS.setSelectionBackground(new java.awt.Color(102, 102, 102));
        TB_TURNOS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TB_TURNOSMouseClicked(evt);
            }
        });
        TB_TURNOS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TB_TURNOSKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(TB_TURNOS);

        BTN_AGREGAR_TURNOS.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        BTN_AGREGAR_TURNOS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Agregar propiedad-30.png"))); // NOI18N
        BTN_AGREGAR_TURNOS.setText("Agregar Turnos");
        BTN_AGREGAR_TURNOS.setContentAreaFilled(false);
        BTN_AGREGAR_TURNOS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_AGREGAR_TURNOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_AGREGAR_TURNOSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout P_TURNOSLayout = new javax.swing.GroupLayout(P_TURNOS);
        P_TURNOS.setLayout(P_TURNOSLayout);
        P_TURNOSLayout.setHorizontalGroup(
            P_TURNOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P_TURNOSLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(99, 99, 99)
                .addComponent(TXT_TURNOS_POR_HORARIO_TIPO_NOMEN, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(292, 292, 292)
                .addComponent(BTN_AGREGAR_TURNOS)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane3)
        );
        P_TURNOSLayout.setVerticalGroup(
            P_TURNOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P_TURNOSLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(P_TURNOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXT_TURNOS_POR_HORARIO_TIPO_NOMEN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTN_AGREGAR_TURNOS))
                .addGap(2, 2, 2)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
        );

        LBL_ESTADO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LBL_ESTADO.setText("ENTER");

        LBL_COD_TURNO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LBL_COD_TURNO.setText("COD_TURNO");

        LBL_COD_UO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LBL_COD_UO.setText("COD_UO");

        jLabel9.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel9.setText("Cod. Turno UO:");

        TXT_COD_TURNO_UO.setEditable(false);
        TXT_COD_TURNO_UO.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TXT_COD_TURNO_UO.setEnabled(false);
        TXT_COD_TURNO_UO.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                TXT_COD_TURNO_UOCaretUpdate(evt);
            }
        });
        TXT_COD_TURNO_UO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXT_COD_TURNO_UOKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TXT_COD_TURNO_UOKeyTyped(evt);
            }
        });

        P_UO.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel6.setText("Unidad Orgánica:");

        TXT_SISTEMA_UNIDAD_ORGANICA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TXT_SISTEMA_UNIDAD_ORGANICA.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                TXT_SISTEMA_UNIDAD_ORGANICACaretUpdate(evt);
            }
        });
        TXT_SISTEMA_UNIDAD_ORGANICA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXT_SISTEMA_UNIDAD_ORGANICAKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TXT_SISTEMA_UNIDAD_ORGANICAKeyTyped(evt);
            }
        });

        BTN_BUSCAR_UO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Búsqueda-30.png"))); // NOI18N
        BTN_BUSCAR_UO.setContentAreaFilled(false);
        BTN_BUSCAR_UO.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_BUSCAR_UO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_BUSCAR_UOActionPerformed(evt);
            }
        });
        BTN_BUSCAR_UO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BTN_BUSCAR_UOKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                BTN_BUSCAR_UOKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout P_UOLayout = new javax.swing.GroupLayout(P_UO);
        P_UO.setLayout(P_UOLayout);
        P_UOLayout.setHorizontalGroup(
            P_UOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P_UOLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(45, 45, 45)
                .addComponent(TXT_SISTEMA_UNIDAD_ORGANICA, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTN_BUSCAR_UO, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        P_UOLayout.setVerticalGroup(
            P_UOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P_UOLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(P_UOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(P_UOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TXT_SISTEMA_UNIDAD_ORGANICA, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BTN_BUSCAR_UO, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(P_HORARIOS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(P_TURNOS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel9))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LBL_COD_TIPO_TURNOS, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(151, 151, 151)
                        .addComponent(LBL_ESTADO, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(LBL_COD_TURNO, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(LBL_COD_UO, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(TXT_COD_TURNO_UO, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(CBX_TIPO_TURNO, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(P_UO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LBL_COD_TIPO_TURNOS)
                            .addComponent(LBL_ESTADO)
                            .addComponent(LBL_COD_TURNO)
                            .addComponent(LBL_COD_UO)))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(CBX_TIPO_TURNO, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(TXT_COD_TURNO_UO, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(P_HORARIOS, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(P_TURNOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(P_UO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        TB_TURNOS_UNIDAD_ORGANICA.setModel(new javax.swing.table.DefaultTableModel(
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
        TB_TURNOS_UNIDAD_ORGANICA.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        TB_TURNOS_UNIDAD_ORGANICA.setRowHeight(35);
        TB_TURNOS_UNIDAD_ORGANICA.setSelectionBackground(new java.awt.Color(102, 102, 102));
        TB_TURNOS_UNIDAD_ORGANICA.getTableHeader().setReorderingAllowed(false);
        TB_TURNOS_UNIDAD_ORGANICA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TB_TURNOS_UNIDAD_ORGANICAKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(TB_TURNOS_UNIDAD_ORGANICA);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1061, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("", jPanel3);

        jPanel4.setBackground(new java.awt.Color(43, 43, 43));
        jPanel4.setForeground(new java.awt.Color(102, 102, 102));

        lblListado_Edicion.setFont(new java.awt.Font("Segoe UI Light", 0, 26)); // NOI18N
        lblListado_Edicion.setForeground(new java.awt.Color(255, 255, 255));
        lblListado_Edicion.setText("Edición");

        jPanel8.setBackground(new java.awt.Color(43, 43, 43));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(43, 43, 43)));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        BTN_INICIO.setForeground(new java.awt.Color(43, 43, 43));
        BTN_INICIO.setText("jButton1");
        BTN_INICIO.setContentAreaFilled(false);
        BTN_INICIO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BTN_INICIOKeyPressed(evt);
            }
        });

        LBL_GM.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LBL_GM.setForeground(new java.awt.Color(255, 255, 255));
        LBL_GM.setText("G");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(576, 576, 576)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lblListado_Edicion)
                        .addGap(221, 221, 221)
                        .addComponent(BTN_INICIO)
                        .addGap(218, 218, 218)
                        .addComponent(LBL_GM)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblListado_Edicion)
                    .addComponent(BTN_INICIO)
                    .addComponent(LBL_GM))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        jTabbedPane1.setSelectedIndex(0);
        
        CBX_TIPO_TURNO.setEnabled(true);
        CBX_TIPO_TURNO.showPopup();
        CBX_TIPO_TURNO.requestFocus(true);
        
        TXT_HORARIO.setEnabled(true);
        TB_HORARIOS.setEnabled(true);
        TB_HORARIOS.setBackground(Color.white);
        
        BTN_AGREGAR_HORARIOS.setEnabled(true);
        
        jLabel5.setVisible(false);
        TXT_TURNOS_POR_HORARIO_TIPO_NOMEN.setVisible(false);
//        TXT_TURNOS_POR_HORARIO_TIPO_DESCRIP.setVisible(false);
        jScrollPane3.setVisible(false);
        
        jLabel6.setVisible(false);
        TXT_SISTEMA_UNIDAD_ORGANICA.setVisible(false);
        BTN_BUSCAR_UO.setVisible(false);
        BTN_AGREGAR_TURNOS.setVisible(false);
//        P_TURNOS.setVisible(false);
//        P_UO.setVisible(false);
        
        TXT_HORARIO.setText("");
        TXT_TURNOS_POR_HORARIO_TIPO_NOMEN.setText("");
        TXT_SISTEMA_UNIDAD_ORGANICA.setText("");
        
        btnguardar.setEnabled(true);
        TXT_HORARIO.setEnabled(true);
        CBX_TIPO_TURNO.setEnabled(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        ImageIcon ieli=new ImageIcon(this.getClass().getResource("/imagenes/iconos/eliminar16x16.png"));
        int eliminar = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea ELIMINAR?",
            "Atención", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,ieli );
        try{
            if(eliminar == 0 )
            {
                int filaselec=TB_TURNOS_UNIDAD_ORGANICA.getSelectedRow();
                CLS_PERSONAL_TURNOS el=new CLS_PERSONAL_TURNOS();
                el.setCOD_TUR_UO(String.valueOf(TB_TURNOS_UNIDAD_ORGANICA.getValueAt(filaselec, 1)));
                if(el.PERSONAL_TURNOS_UNIDAD_ORGANICA_ELIMINAR())
                {
                    JOptionPane.showMessageDialog(this, "Datos Eliminados");
                    mostrar_TURNOS_UNIDAD_ORGANICA();
//                    btneliminar.setEnabled(false);
//                    btneditar.setEnabled(false);
//                    Mostrar_ACTIVIDADES();
//                    LIMPIAR_GUARDAR();
//                    CLS_PERSONAL_UO_ACTIVIDADES num=new CLS_PERSONAL_UO_ACTIVIDADES();
//                    TXT_UNIDAD_ORGANICA.setText(num.PERSONAL_ACTIVIDADES_GENERAR_ID());
                }
            }
        }catch(Exception e){

        } 
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaActionPerformed
        TXT_BUSCAR_TURNOS_UNIDAD_ORGANICA.setText("");
        jTabbedPane1.setSelectedIndex(1);
        mostrar_TURNOS_UNIDAD_ORGANICA();
        TXT_BUSCAR_TURNOS_UNIDAD_ORGANICA.requestFocus();
        
        
        jLabel5.setVisible(true);
        TXT_TURNOS_POR_HORARIO_TIPO_NOMEN.setVisible(true);
        jScrollPane3.setVisible(true);
        
        jLabel6.setVisible(true);
        TXT_SISTEMA_UNIDAD_ORGANICA.setVisible(true);
        BTN_BUSCAR_UO.setVisible(true);
        
        
        btnguardar.setEnabled(false);
        btneliminar.setEnabled(true);
    }//GEN-LAST:event_btnListaActionPerformed

    private void TXT_BUSCAR_TURNOS_UNIDAD_ORGANICACaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_TXT_BUSCAR_TURNOS_UNIDAD_ORGANICACaretUpdate
        BUSCAR_TURNOS_UNIDAD_ORGANICA();
    }//GEN-LAST:event_TXT_BUSCAR_TURNOS_UNIDAD_ORGANICACaretUpdate

    private void TXT_BUSCAR_TURNOS_UNIDAD_ORGANICAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_BUSCAR_TURNOS_UNIDAD_ORGANICAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXT_BUSCAR_TURNOS_UNIDAD_ORGANICAActionPerformed

    private void TXT_BUSCAR_TURNOS_UNIDAD_ORGANICAKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BUSCAR_TURNOS_UNIDAD_ORGANICAKeyPressed
     
    }//GEN-LAST:event_TXT_BUSCAR_TURNOS_UNIDAD_ORGANICAKeyPressed

    private void TXT_BUSCAR_TURNOS_UNIDAD_ORGANICAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BUSCAR_TURNOS_UNIDAD_ORGANICAKeyReleased
        TXT_BUSCAR_TURNOS_UNIDAD_ORGANICA.setText(TXT_BUSCAR_TURNOS_UNIDAD_ORGANICA.getText().toUpperCase());
    }//GEN-LAST:event_TXT_BUSCAR_TURNOS_UNIDAD_ORGANICAKeyReleased

    private void TXT_BUSCAR_TURNOS_UNIDAD_ORGANICAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BUSCAR_TURNOS_UNIDAD_ORGANICAKeyTyped
        char tecla= evt.getKeyChar();
        if(tecla==KeyEvent.VK_ENTER){
            TB_TURNOS_UNIDAD_ORGANICA.getSelectionModel().setSelectionInterval(0, 0);
            TB_TURNOS_UNIDAD_ORGANICA.requestFocus();
            
        }
    }//GEN-LAST:event_TXT_BUSCAR_TURNOS_UNIDAD_ORGANICAKeyTyped

    private void btnBuscarPersonal_rol1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarPersonal_rol1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarPersonal_rol1MouseClicked

    private void btnBuscarPersonal_rol1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPersonal_rol1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarPersonal_rol1ActionPerformed

    private void TXT_HORARIOCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_TXT_HORARIOCaretUpdate
        if(LBL_ESTADO.getText().equalsIgnoreCase("ENTER")){
            Buscar_PERSONAL_HORARIOS();
            
            TB_HORARIOS.setEnabled(true);
            TB_HORARIOS.setBackground(Color.white);
            
        }else{
            if(LBL_ESTADO.getText().equalsIgnoreCase("CLICK")){
                System.out.println("horario cargado");
            }
        }
        
        if(TXT_HORARIO.getText().equalsIgnoreCase("")){
            jLabel5.setVisible(false);
            TXT_TURNOS_POR_HORARIO_TIPO_NOMEN.setVisible(false);
            jScrollPane3.setVisible(false);
            
            jLabel6.setVisible(false);
            TXT_SISTEMA_UNIDAD_ORGANICA.setVisible(false);
            BTN_BUSCAR_UO.setVisible(false);
            BTN_AGREGAR_TURNOS.setVisible(false);
            
//            LBL_COD_HORARIO.setText("HORARIO");
        }
//        
//        if(TB_HORARIOS.getRowCount()==0){
//            BTN_AGREGAR_HORARIOS.setVisible(true);
//        }else{
//            BTN_AGREGAR_HORARIOS.setVisible(false);
//        }
        
    }//GEN-LAST:event_TXT_HORARIOCaretUpdate

    private void TXT_HORARIOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_HORARIOKeyTyped
        char tecla= evt.getKeyChar();
        if(tecla==KeyEvent.VK_ENTER){
            TB_HORARIOS.getSelectionModel().setSelectionInterval(0, 0);
            TB_HORARIOS.requestFocus();
        }
    }//GEN-LAST:event_TXT_HORARIOKeyTyped

    private void TB_HORARIOSKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TB_HORARIOSKeyPressed
        int filaselec=TB_HORARIOS.getSelectedRow();
        char teclaPresionada = evt.getKeyChar();
       if(teclaPresionada==KeyEvent.VK_ENTER){
            if(filaselec<0){
                   JOptionPane.showMessageDialog(rootPane, "Seleccione un Registro");
            }else{
                    LBL_ESTADO.setText("ENTER");
                
                    LBL_COD_HORARIO.setText(String.valueOf(TB_HORARIOS.getValueAt(filaselec, 1)));
                    TXT_HORARIO.setText(String.valueOf(TB_HORARIOS.getValueAt(filaselec, 2)));

                    TB_HORARIOS.setEnabled(false);
                    TB_HORARIOS.setBackground(Color.lightGray);
                    
                    Mostrar_HORARIOS();
                    
                    String TIPO_TURNO=this.CBX_TIPO_TURNO.getSelectedItem().toString();
                    
                    CLS_PERSONAL_TURNOS PT = new CLS_PERSONAL_TURNOS();
                    LBL_COD_TIPO_TURNOS.setText(String.valueOf(PT.PERSONAL_COD_TIPO_TURNOS(TIPO_TURNO)));
                    
                    
                    Mostrar_TB_TURNOS_POR_HORARIO_TIPO();
                    
//                    P_TURNOS.setVisible(true);
                    jLabel5.setVisible(true);
                    TXT_TURNOS_POR_HORARIO_TIPO_NOMEN.setVisible(true);
//                    TXT_TURNOS_POR_HORARIO_TIPO_DESCRIP.setVisible(true);
                    jScrollPane3.setVisible(true);
                    BTN_AGREGAR_TURNOS.setVisible(true);
                    
                    TXT_TURNOS_POR_HORARIO_TIPO_NOMEN.requestFocus();
            }
        }
    }//GEN-LAST:event_TB_HORARIOSKeyPressed

    private void TXT_TURNOS_POR_HORARIO_TIPO_NOMENCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_TXT_TURNOS_POR_HORARIO_TIPO_NOMENCaretUpdate
        Buscar_TB_TURNOS_HORARIO_TIPO();
        TB_TURNOS.setEnabled(true);
        TB_TURNOS.setBackground(Color.white);
        
        if(TXT_TURNOS_POR_HORARIO_TIPO_NOMEN.getText().equalsIgnoreCase("")){

                jLabel6.setVisible(false);
                TXT_SISTEMA_UNIDAD_ORGANICA.setVisible(false);
                BTN_BUSCAR_UO.setVisible(false);
        
        }
    }//GEN-LAST:event_TXT_TURNOS_POR_HORARIO_TIPO_NOMENCaretUpdate

    private void TXT_TURNOS_POR_HORARIO_TIPO_NOMENKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_TURNOS_POR_HORARIO_TIPO_NOMENKeyTyped
        char tecla= evt.getKeyChar();
        if(tecla==KeyEvent.VK_ENTER){
            TB_TURNOS.getSelectionModel().setSelectionInterval(0, 0);
            TB_TURNOS.requestFocus();
        }
    }//GEN-LAST:event_TXT_TURNOS_POR_HORARIO_TIPO_NOMENKeyTyped

    private void TB_TURNOSKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TB_TURNOSKeyPressed
        int filaselec=TB_TURNOS.getSelectedRow();
        char teclaPresionada = evt.getKeyChar();
       if(teclaPresionada==KeyEvent.VK_ENTER){
            if(filaselec<0){
                   JOptionPane.showMessageDialog(rootPane, "Seleccione un Registro");
            }else{
//                    LBL_ESTADO.setText("ENTER");
                
                    LBL_COD_TURNO.setText(String.valueOf(TB_TURNOS.getValueAt(filaselec, 1)));
                    TXT_TURNOS_POR_HORARIO_TIPO_NOMEN.setText(String.valueOf(TB_TURNOS.getValueAt(filaselec, 4) + 
                            "             |             " + TB_TURNOS.getValueAt(filaselec, 5)));
//                    TXT_TURNOS_POR_HORARIO_TIPO_DESCRIP.setText(String.valueOf());

                    TB_TURNOS.setEnabled(false);
                    TB_TURNOS.setBackground(Color.lightGray);
                    
//                    Mostrar_HORARIOS();      
                    
                    Mostrar_TB_TURNOS_POR_HORARIO_TIPO();
//                    TXT_TURNOS_POR_HORARIO_TIPO_NOMEN.requestFocus();
                    
                    jLabel6.setVisible(true);
                    TXT_SISTEMA_UNIDAD_ORGANICA.setVisible(true);
                    BTN_BUSCAR_UO.setVisible(true);
                    BTN_BUSCAR_UO.requestFocus();
                    
            }
        }
    }//GEN-LAST:event_TB_TURNOSKeyPressed

    private void TB_HORARIOSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TB_HORARIOSMouseClicked
        int filaselec=TB_HORARIOS.getSelectedRow();
        if(evt.getClickCount()==1){
            if(filaselec<0){
                   JOptionPane.showMessageDialog(rootPane, "Seleccione un Registro");
            }else{
                    LBL_ESTADO.setText("CLICK");
        
                    LBL_COD_HORARIO.setText(String.valueOf(TB_HORARIOS.getValueAt(filaselec, 1)));
                    TXT_HORARIO.setText(String.valueOf(TB_HORARIOS.getValueAt(filaselec, 2)));
                                        
//                    Mostrar_HORARIOS();
                    
                    String TIPO_TURNO=this.CBX_TIPO_TURNO.getSelectedItem().toString();
                    
                    CLS_PERSONAL_TURNOS PT = new CLS_PERSONAL_TURNOS();
                    LBL_COD_TIPO_TURNOS.setText(String.valueOf(PT.PERSONAL_COD_TIPO_TURNOS(TIPO_TURNO)));
                    
                    
                    Mostrar_TB_TURNOS_POR_HORARIO_TIPO();
                    TXT_TURNOS_POR_HORARIO_TIPO_NOMEN.requestFocus();
                    
                    jLabel5.setVisible(true);
                    TXT_TURNOS_POR_HORARIO_TIPO_NOMEN.setVisible(true);
//                    TXT_TURNOS_POR_HORARIO_TIPO_DESCRIP.setVisible(true);
                    jScrollPane3.setVisible(true);
                    BTN_AGREGAR_TURNOS.setVisible(true);
                    
                    
            }
        }
    }//GEN-LAST:event_TB_HORARIOSMouseClicked

    private void TXT_HORARIOKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_HORARIOKeyReleased
        TXT_HORARIO.setText(TXT_HORARIO.getText().toUpperCase());
    }//GEN-LAST:event_TXT_HORARIOKeyReleased

    private void TXT_TURNOS_POR_HORARIO_TIPO_NOMENKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_TURNOS_POR_HORARIO_TIPO_NOMENKeyReleased
        TXT_TURNOS_POR_HORARIO_TIPO_NOMEN.setText(TXT_TURNOS_POR_HORARIO_TIPO_NOMEN.getText().toUpperCase());
    }//GEN-LAST:event_TXT_TURNOS_POR_HORARIO_TIPO_NOMENKeyReleased

    private void TXT_SISTEMA_UNIDAD_ORGANICACaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_TXT_SISTEMA_UNIDAD_ORGANICACaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_TXT_SISTEMA_UNIDAD_ORGANICACaretUpdate

    private void TXT_SISTEMA_UNIDAD_ORGANICAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_SISTEMA_UNIDAD_ORGANICAKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_TXT_SISTEMA_UNIDAD_ORGANICAKeyReleased

    private void TXT_SISTEMA_UNIDAD_ORGANICAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_SISTEMA_UNIDAD_ORGANICAKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_TXT_SISTEMA_UNIDAD_ORGANICAKeyTyped

    private void BTN_BUSCAR_UOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_BUSCAR_UOActionPerformed
        UNIDAD_ORGANICA.setVisible(true);
        Mostrar_UNIDAD_ORGANICA();
    }//GEN-LAST:event_BTN_BUSCAR_UOActionPerformed

    private void BTN_BUSCAR_UOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BTN_BUSCAR_UOKeyTyped
        char tecla= evt.getKeyChar();
        if(tecla==KeyEvent.VK_ENTER){
            BTN_BUSCAR_UO.doClick();
        }
    }//GEN-LAST:event_BTN_BUSCAR_UOKeyTyped

    private void TB_TURNOSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TB_TURNOSMouseClicked
        int filaselec=TB_TURNOS.getSelectedRow();
        if(evt.getClickCount()==1){
            if(filaselec<0){
                   JOptionPane.showMessageDialog(rootPane, "Seleccione un Registro");
            }else{
                    LBL_COD_TURNO.setText(String.valueOf(TB_TURNOS.getValueAt(filaselec, 1)));
                    TXT_TURNOS_POR_HORARIO_TIPO_NOMEN.setText(String.valueOf(TB_TURNOS.getValueAt(filaselec, 4) + 
                            "             |             " + TB_TURNOS.getValueAt(filaselec, 5)));
//                    TXT_TURNOS_POR_HORARIO_TIPO_DESCRIP.setText(String.valueOf(TB_TURNOS.getValueAt(filaselec, 5)));

                    TB_TURNOS.setEnabled(false);
                    TB_TURNOS.setBackground(Color.lightGray);
                    
                    Mostrar_TB_TURNOS_POR_HORARIO_TIPO();
                    
                    jLabel6.setVisible(true);
                    TXT_SISTEMA_UNIDAD_ORGANICA.setVisible(true);
                    BTN_BUSCAR_UO.setVisible(true);
            }
        }
    }//GEN-LAST:event_TB_TURNOSMouseClicked

    private void TB_UNIDAD_ORGANICAKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TB_UNIDAD_ORGANICAKeyPressed
        int filaselec=TB_UNIDAD_ORGANICA.getSelectedRow();
        char teclaPresionada = evt.getKeyChar();
        if(teclaPresionada==KeyEvent.VK_ENTER){
            if(filaselec<0){
                JOptionPane.showMessageDialog(rootPane, "Seleccione un Registro");
            }else{
                LBL_COD_UO.setText(String.valueOf(TB_UNIDAD_ORGANICA.getValueAt(filaselec, 1)));
                TXT_SISTEMA_UNIDAD_ORGANICA.setText(String.valueOf(TB_UNIDAD_ORGANICA.getValueAt(filaselec, 2)));

                UNIDAD_ORGANICA.dispose();

                TXT_BUSCAR_UNIDAD_ORGANICA.setText("");
                
                btnguardar.requestFocus();
                
            }
        }

    }//GEN-LAST:event_TB_UNIDAD_ORGANICAKeyPressed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        ImageIcon i=new ImageIcon(this.getClass().getResource("/imagenes/iconos/guardar16x16.png"));
        if(LBL_GM.getText().equalsIgnoreCase("G")){
            if(TXT_COD_TURNO_UO.getText().equalsIgnoreCase("") || LBL_COD_TURNO.getText().equalsIgnoreCase("")
                    || LBL_COD_UO.getText().equalsIgnoreCase("") || TXT_HORARIO.getText().equalsIgnoreCase("")
                    || TXT_TURNOS_POR_HORARIO_TIPO_NOMEN.getText().equalsIgnoreCase("") 
                    || TXT_SISTEMA_UNIDAD_ORGANICA.getText().equalsIgnoreCase("")){
                            JOptionPane.showMessageDialog(this, "Verifique si ha ingresado todos los campos");
                
            }else{
                    int guardar = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea GUARDAR los datos?",
                        "Atención", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,i);
           
                    if(guardar == 0 ){
                         GUARDAR_TURNOS_UNIDAD_ORGANICA();
                         JOptionPane.showMessageDialog(this, "Datos Guardados Correctamente");
                         
                         btnguardar.setEnabled(false);
                         TXT_HORARIO.setEnabled(false);
                         CBX_TIPO_TURNO.setEnabled(false);
                         
                         mostrar_TURNOS_UO();
                         
                         CLS_PERSONAL_TURNOS num=new CLS_PERSONAL_TURNOS();
                         TXT_COD_TURNO_UO.setText(num.PERSONAL_TURNOS_UO_GENERAR_ID());
                         if(TXT_COD_TURNO_UO.getText().equalsIgnoreCase("")){
                            TXT_COD_TURNO_UO.setText("TU0000000000001");
                         }
                         LIMPIAR_GUARDAR_UNIDAD_ORGANICA();
                         btnNuevo.requestFocus();
//                         PERSONAL_ROL PR = new PERSONAL_ROL();
//                         PR.mostrar_ACTIVIDADES();
                    }else{
                         System.out.println("error guardar TURNOS UO");
                     }
            }
           
           }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void TXT_COD_TURNO_UOCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_TXT_COD_TURNO_UOCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_TXT_COD_TURNO_UOCaretUpdate

    private void TXT_COD_TURNO_UOKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_COD_TURNO_UOKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_TXT_COD_TURNO_UOKeyReleased

    private void TXT_COD_TURNO_UOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_COD_TURNO_UOKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_TXT_COD_TURNO_UOKeyTyped

    private void CBX_TIPO_TURNOKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CBX_TIPO_TURNOKeyPressed
       char teclaPresionada = evt.getKeyChar();
       if(teclaPresionada==KeyEvent.VK_ENTER){
         if(CBX_TIPO_TURNO.getSelectedIndex()==0 || CBX_TIPO_TURNO.getSelectedIndex()==1){
             TXT_HORARIO.setText("");
             TXT_HORARIO.requestFocus();
             
             jLabel5.setVisible(false);
             TXT_TURNOS_POR_HORARIO_TIPO_NOMEN.setVisible(false);
             jScrollPane3.setVisible(false);
            
             jLabel6.setVisible(false);
             TXT_SISTEMA_UNIDAD_ORGANICA.setVisible(false);
             BTN_BUSCAR_UO.setVisible(false);
             BTN_AGREGAR_TURNOS.setVisible(false);
             
             TXT_TURNOS_POR_HORARIO_TIPO_NOMEN.setText("");
             TXT_SISTEMA_UNIDAD_ORGANICA.setText("");
         
         }
             
       }
    }//GEN-LAST:event_CBX_TIPO_TURNOKeyPressed

    private void BTN_BUSCAR_UOKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BTN_BUSCAR_UOKeyPressed
        char tecla= evt.getKeyChar();
        if(tecla==KeyEvent.VK_ENTER){
            BTN_BUSCAR_UO.doClick();
        }
    }//GEN-LAST:event_BTN_BUSCAR_UOKeyPressed

    private void BTN_INICIOKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BTN_INICIOKeyPressed
       char teclaPresionada = evt.getKeyChar();
       if(teclaPresionada==KeyEvent.VK_ENTER){
             btnNuevo.doClick();
       }
    }//GEN-LAST:event_BTN_INICIOKeyPressed

    private void TXT_BUSCAR_UNIDAD_ORGANICACaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_TXT_BUSCAR_UNIDAD_ORGANICACaretUpdate
        BUSCAR_UNIDAD_ORGANICA();
    }//GEN-LAST:event_TXT_BUSCAR_UNIDAD_ORGANICACaretUpdate

    private void TXT_BUSCAR_UNIDAD_ORGANICAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_BUSCAR_UNIDAD_ORGANICAActionPerformed

    }//GEN-LAST:event_TXT_BUSCAR_UNIDAD_ORGANICAActionPerformed

    private void TXT_BUSCAR_UNIDAD_ORGANICAKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BUSCAR_UNIDAD_ORGANICAKeyPressed
        if(evt.getExtendedKeyCode()==KeyEvent.VK_DOWN){
            TB_UNIDAD_ORGANICA.getSelectionModel().setSelectionInterval(0, 0);
            TB_UNIDAD_ORGANICA.requestFocus();
        }
    }//GEN-LAST:event_TXT_BUSCAR_UNIDAD_ORGANICAKeyPressed

    private void TXT_BUSCAR_UNIDAD_ORGANICAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BUSCAR_UNIDAD_ORGANICAKeyReleased
        TXT_BUSCAR_UNIDAD_ORGANICA.setText(TXT_BUSCAR_UNIDAD_ORGANICA.getText().toUpperCase());

    }//GEN-LAST:event_TXT_BUSCAR_UNIDAD_ORGANICAKeyReleased

    private void TXT_BUSCAR_UNIDAD_ORGANICAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BUSCAR_UNIDAD_ORGANICAKeyTyped
        char tecla= evt.getKeyChar();
        if(tecla==KeyEvent.VK_ENTER){
            TB_UNIDAD_ORGANICA.getSelectionModel().setSelectionInterval(0, 0);
            TB_UNIDAD_ORGANICA.requestFocus();
        }

    }//GEN-LAST:event_TXT_BUSCAR_UNIDAD_ORGANICAKeyTyped

    private void btnBuscarPersonal_rol3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPersonal_rol3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarPersonal_rol3ActionPerformed

    private void btnguardarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnguardarKeyPressed
        int filaselec=TB_UNIDAD_ORGANICA.getSelectedRow();
        char teclaPresionada = evt.getKeyChar();
        if(teclaPresionada==KeyEvent.VK_ENTER){
            btnguardar.doClick();
        }
    }//GEN-LAST:event_btnguardarKeyPressed

    private void TXT_BUSCAR_TURNOS_UNIDAD_ORGANICAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TXT_BUSCAR_TURNOS_UNIDAD_ORGANICAMouseClicked
        if(evt.getClickCount()==1){
            jTabbedPane1.setSelectedIndex(1);
        }
    }//GEN-LAST:event_TXT_BUSCAR_TURNOS_UNIDAD_ORGANICAMouseClicked

    private void BTN_AGREGAR_HORARIOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_AGREGAR_HORARIOSActionPerformed
        HORARIOS.setVisible(true);
//        lblusu1.setText(lblusu.getText());
        
    }//GEN-LAST:event_BTN_AGREGAR_HORARIOSActionPerformed

    private void btnNuevo_HORARIOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo_HORARIOActionPerformed
        habilitar_horario();
        CB_PASAR_DIA.requestFocus();
    }//GEN-LAST:event_btnNuevo_HORARIOActionPerformed

    private void btneditar_HORARIOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditar_HORARIOActionPerformed
       
    }//GEN-LAST:event_btneditar_HORARIOActionPerformed

    private void btneliminar_HORARIOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminar_HORARIOActionPerformed
       
    }//GEN-LAST:event_btneliminar_HORARIOActionPerformed

    private void btnLista_HORARIOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLista_HORARIOActionPerformed
      
    }//GEN-LAST:event_btnLista_HORARIOActionPerformed

    private void btnguardar_HORARIOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardar_HORARIOActionPerformed
        ImageIcon i=new ImageIcon(this.getClass().getResource("/imagenes/iconos/guardar16x16.png"));
        
            if(TXT_HORA_COMPLETA.getText().equalsIgnoreCase("") || TXT_TOTAL_HORA.getText().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(this, "Verifique si ha ingresado todos los campos");
                
            }else{
                    int guardar = JOptionPane.showConfirmDialog(HORARIOS, "¿Está seguro que desea GUARDAR los datos?",
                        "Atención", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,i);
           
                    if(guardar == 0 ){
                         PERSONAL_HORARIO_GUARDAR();
                         JOptionPane.showMessageDialog(HORARIOS, "Datos Guardados Correctamente");
                         LIMPIAR_HORARIO_GUARDAR();
                         deshabilitar_horario();
                         HORARIOS.dispose();
                         Mostrar_HORARIOS();
//                         PERSONAL_ROL PR = new PERSONAL_ROL();
//                         PR.mostrar_ACTIVIDADES();
                    }else{
                         System.out.println("error guardar HORARIOS");
                     }
            }
           
           
    }//GEN-LAST:event_btnguardar_HORARIOActionPerformed

    private void CBX_HORA_FINItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CBX_HORA_FINItemStateChanged
          
    }//GEN-LAST:event_CBX_HORA_FINItemStateChanged

    private void CBX_HORA_FINPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_CBX_HORA_FINPropertyChange
        
    }//GEN-LAST:event_CBX_HORA_FINPropertyChange

    private void CBX_HORA_FINKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CBX_HORA_FINKeyPressed
        char teclaPresionada = evt.getKeyChar();
        if(teclaPresionada==KeyEvent.VK_ENTER){
            String hora_inicio="", hora_fin="", hora_completa="";
        
            hora_inicio = CBX_HORA_INICIO.getSelectedItem().toString();
            hora_fin = CBX_HORA_FIN.getSelectedItem().toString();

            hora_completa = hora_inicio + " - " + hora_fin;

            TXT_HORA_COMPLETA.setText(hora_completa);
             
            restar_horas();
        }
    }//GEN-LAST:event_CBX_HORA_FINKeyPressed

    private void btnNuevoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnNuevoKeyPressed
        char teclaPresionada = evt.getKeyChar();
        if(teclaPresionada==KeyEvent.VK_ENTER){
              btnNuevo.doClick();
        }
    }//GEN-LAST:event_btnNuevoKeyPressed

    private void CB_PASAR_DIAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CB_PASAR_DIAMouseClicked
        if(evt.getClickCount()==1){
                CBX_HORA_INICIO.setVisible(true);    
                CBX_HORA_INICIO.showPopup();
                CBX_HORA_INICIO.requestFocus(true);
 
       }
    }//GEN-LAST:event_CB_PASAR_DIAMouseClicked

    private void CBX_HORA_INICIOKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CBX_HORA_INICIOKeyPressed
        char teclaPresionada = evt.getKeyChar();
       if(teclaPresionada==KeyEvent.VK_ENTER){
           if(CBX_HORA_FIN.getSelectedIndex()==0){
                CBX_HORA_FIN.setVisible(true);    
                CBX_HORA_FIN.showPopup();
                CBX_HORA_FIN.requestFocus(true);
           }
       }
    }//GEN-LAST:event_CBX_HORA_INICIOKeyPressed

    private void CB_PASAR_DIAKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CB_PASAR_DIAKeyPressed
        char teclaPresionada = evt.getKeyChar();
       if(teclaPresionada==KeyEvent.VK_ENTER){
           if(CBX_HORA_INICIO.getSelectedIndex()==0){
                CBX_HORA_INICIO.setVisible(true);    
                CBX_HORA_INICIO.showPopup();
                CBX_HORA_INICIO.requestFocus(true);
           }else{
                restar_horas();
           }

       }
    }//GEN-LAST:event_CB_PASAR_DIAKeyPressed

    private void BTN_AGREGAR_TURNOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_AGREGAR_TURNOSActionPerformed
        TURNOS.setVisible(true);
        Mostrar_HORARIOS_TURNOS_GT();
//        lblusu2.setText(lblusu.getText());
        
        
        DESHABILITAR_TURNOS_GT();
    }//GEN-LAST:event_BTN_AGREGAR_TURNOSActionPerformed

    private void btnNuevo_TURNOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo_TURNOActionPerformed
        HABILITAR_TURNOS_GT();
        TB_HORARIO_TURNOS_GT.getSelectionModel().setSelectionInterval(0, 0);
        TB_HORARIO_TURNOS_GT.requestFocus();
        
        int filaselec = TB_HORARIO_TURNOS_GT.getSelectedRow();
        TXT_COD_HORARIO_GT.setText(String.valueOf(TB_HORARIO_TURNOS_GT.getValueAt(filaselec, 1)));
        TXT_HORA_COMPLETA_GT.setText(String.valueOf(TB_HORARIO_TURNOS_GT.getValueAt(filaselec, 2)));
        TXT_TOTAL_HORAS_GT.setText(String.valueOf(TB_HORARIO_TURNOS_GT.getValueAt(filaselec, 3)));
       
        
    }//GEN-LAST:event_btnNuevo_TURNOActionPerformed

    private void btneditar_TURNOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditar_TURNOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btneditar_TURNOActionPerformed

    private void btneliminar_TURNOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminar_TURNOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btneliminar_TURNOActionPerformed

    private void btnLista_TURNOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLista_TURNOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLista_TURNOActionPerformed

    private void btnguardar_TURNO_GTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardar_TURNO_GTActionPerformed
        ImageIcon i=new ImageIcon(this.getClass().getResource("/imagenes/iconos/guardar16x16.png"));
        
            if(TXT_COD_HORARIO_GT.getText().equalsIgnoreCase("") || TXT_HORA_COMPLETA_GT.getText().equalsIgnoreCase("")
               || TXT_TOTAL_HORAS_GT.getText().equalsIgnoreCase("") || TXT_NOMENCLATURA_GT.getText().equalsIgnoreCase("")
                    || TXT_DESCRIPCION_GT.getText().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(this, "Verifique si ha ingresado todos los campos");
                
            }else{
                    int guardar = JOptionPane.showConfirmDialog(TURNOS, "¿Está seguro que desea GUARDAR los datos?",
                        "Atención", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,i);
           
                    if(guardar == 0 ){
                         PERSONAL_TURNOS_GT_INSERTAR();
                         JOptionPane.showMessageDialog(TURNOS, "Datos Guardados Correctamente");
                         LIMPIAR_TURNOS_GT_GUARDAR();
                         TURNOS.dispose();
                         Mostrar_TB_TURNOS_POR_HORARIO_TIPO();
                         TB_TURNOS.getSelectionModel().setSelectionInterval(0, 0);
                         TB_TURNOS.requestFocus();
//                         PERSONAL_ROL PR = new PERSONAL_ROL();
//                         PR.mostrar_ACTIVIDADES();
                    }else{
                         System.out.println("error guardar HORARIOS");
                     }
            }
           
    }//GEN-LAST:event_btnguardar_TURNO_GTActionPerformed

    private void CBX_TIPO_TURNO_GTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CBX_TIPO_TURNO_GTKeyPressed
        char teclaPresionada = evt.getKeyChar();
        if(teclaPresionada==KeyEvent.VK_ENTER){
            TXT_NOMENCLATURA_GT.requestFocus();
        }
    }//GEN-LAST:event_CBX_TIPO_TURNO_GTKeyPressed

    private void TB_HORARIO_TURNOS_GTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TB_HORARIO_TURNOS_GTMouseClicked
        int filaselec=TB_HORARIO_TURNOS_GT.getSelectedRow();
        if(evt.getClickCount()==1){
            if(filaselec<0){
                   JOptionPane.showMessageDialog(rootPane, "Seleccione un Registro");
            }else{
                    
                TXT_COD_HORARIO_GT.setText(String.valueOf(TB_HORARIO_TURNOS_GT.getValueAt(filaselec, 1)));
                TXT_HORA_COMPLETA_GT.setText(String.valueOf(TB_HORARIO_TURNOS_GT.getValueAt(filaselec, 2)));
                TXT_TOTAL_HORAS_GT.setText(String.valueOf(TB_HORARIO_TURNOS_GT.getValueAt(filaselec, 3)));
       
            }
        }
    }//GEN-LAST:event_TB_HORARIO_TURNOS_GTMouseClicked

    private void TB_HORARIO_TURNOS_GTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TB_HORARIO_TURNOS_GTKeyReleased
        if(evt.getExtendedKeyCode()==KeyEvent.VK_DOWN || evt.getExtendedKeyCode()==KeyEvent.VK_UP){
            
                int filaselec=TB_HORARIO_TURNOS_GT.getSelectedRow();
                
                TXT_COD_HORARIO_GT.setText(String.valueOf(TB_HORARIO_TURNOS_GT.getValueAt(filaselec, 1)));
                TXT_HORA_COMPLETA_GT.setText(String.valueOf(TB_HORARIO_TURNOS_GT.getValueAt(filaselec, 2)));
                TXT_TOTAL_HORAS_GT.setText(String.valueOf(TB_HORARIO_TURNOS_GT.getValueAt(filaselec, 3)));
       
                            
        }
    }//GEN-LAST:event_TB_HORARIO_TURNOS_GTKeyReleased

    private void TXT_NOMENCLATURA_GTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_NOMENCLATURA_GTKeyReleased
        TXT_NOMENCLATURA_GT.setText(TXT_NOMENCLATURA_GT.getText().toUpperCase());
    }//GEN-LAST:event_TXT_NOMENCLATURA_GTKeyReleased

    private void TXT_DESCRIPCION_GTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_DESCRIPCION_GTKeyReleased
        TXT_DESCRIPCION_GT.setText(TXT_DESCRIPCION_GT.getText().toUpperCase());
    }//GEN-LAST:event_TXT_DESCRIPCION_GTKeyReleased

    private void TB_HORARIO_TURNOS_GTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TB_HORARIO_TURNOS_GTKeyPressed
         int filaselec=TB_HORARIOS.getSelectedRow();
        char teclaPresionada = evt.getKeyChar();
       if(teclaPresionada==KeyEvent.VK_ENTER){
            if(CBX_HORA_FIN.getSelectedIndex()==0){
                CBX_TIPO_TURNO_GT.setVisible(true);    
                CBX_TIPO_TURNO_GT.showPopup();
                CBX_TIPO_TURNO_GT.requestFocus(true);
           }
        }
    }//GEN-LAST:event_TB_HORARIO_TURNOS_GTKeyPressed

    private void TXT_NOMENCLATURA_GTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_NOMENCLATURA_GTKeyPressed
        char teclaPresionada = evt.getKeyChar();
        if(teclaPresionada==KeyEvent.VK_ENTER){
            TXT_DESCRIPCION_GT.requestFocus();
        }
    }//GEN-LAST:event_TXT_NOMENCLATURA_GTKeyPressed

    private void TB_TURNOS_UNIDAD_ORGANICAKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TB_TURNOS_UNIDAD_ORGANICAKeyPressed
//        int filaselec=TB_TURNOS_UNIDAD_ORGANICA.getSelectedRow();
//        char teclaPresionada = evt.getKeyChar();
//        if(teclaPresionada==KeyEvent.VK_ENTER){
//           jTabbedPane1.setSelectedIndex(0);
//           
//           TXT_COD_TURNO_UO.setText(String.valueOf(TB_TURNOS_UNIDAD_ORGANICA.getValueAt(filaselec, 1)));
//           
//           String tipo_turno = String.valueOf(TB_TURNOS_UNIDAD_ORGANICA.getValueAt(filaselec, 5));
//           if(tipo_turno.equalsIgnoreCase("Asistencial")){
//               CBX_TIPO_TURNO.setSelectedIndex(0);
//           }else{
//               if(tipo_turno.equalsIgnoreCase("Administrativo")){
//                   CBX_TIPO_TURNO.setSelectedIndex(1);
//               }
//           }
//           
//           //CODIGO TIPO DE TURNO
//           
//           LBL_COD_TIPO_TURNOS.setText(String.valueOf(TB_TURNOS_UNIDAD_ORGANICA.getValueAt(filaselec, 4)));
//           //////////
//           
//           String hora_i ="", hora_f ="";
//           hora_i = String.valueOf(TB_TURNOS_UNIDAD_ORGANICA.getValueAt(filaselec, 9));
//           hora_f = String.valueOf(TB_TURNOS_UNIDAD_ORGANICA.getValueAt(filaselec, 10));
//           
//           TXT_HORARIO.setText(hora_i + " - " + hora_f);
//           TB_HORARIOS.setEnabled(false);
//           TB_HORARIOS.setBackground(Color.lightGray);
//           
//           LBL_COD_HORARIO.setText(String.valueOf(TB_TURNOS_UNIDAD_ORGANICA.getValueAt(filaselec, 3)));
//           
//           String nomen = "", descripcion = "";
//           nomen = String.valueOf(TB_TURNOS_UNIDAD_ORGANICA.getValueAt(filaselec, 6));
//           descripcion = String.valueOf(TB_TURNOS_UNIDAD_ORGANICA.getValueAt(filaselec, 7));
//           TXT_TURNOS_POR_HORARIO_TIPO_NOMEN.setText(nomen + "             |             " + descripcion);
//           
//           //CARGAR TABLA TURNOS GT
//           Mostrar_TB_TURNOS_POR_HORARIO_TIPO();
//           
//        }
    }//GEN-LAST:event_TB_TURNOS_UNIDAD_ORGANICAKeyPressed

    private void TXT_DESCRIPCION_GTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_DESCRIPCION_GTKeyPressed
        char teclaPresionada = evt.getKeyChar();
        if(teclaPresionada==KeyEvent.VK_ENTER){
            TXT_PRECIO_NORMAL.requestFocus();
        }
    }//GEN-LAST:event_TXT_DESCRIPCION_GTKeyPressed

    private void TXT_PRECIO_NORMALKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_PRECIO_NORMALKeyPressed
        char teclaPresionada = evt.getKeyChar();
        if(teclaPresionada==KeyEvent.VK_ENTER){
            TXT_PRECIO_FERIADO.requestFocus();
        }
    }//GEN-LAST:event_TXT_PRECIO_NORMALKeyPressed

    private void TXT_PRECIO_FERIADOKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_PRECIO_FERIADOKeyPressed
        char teclaPresionada = evt.getKeyChar();
        if(teclaPresionada==KeyEvent.VK_ENTER){
            TXT_PRECIO_SABADO.requestFocus();
        }
    }//GEN-LAST:event_TXT_PRECIO_FERIADOKeyPressed

    private void TXT_PRECIO_SABADOKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_PRECIO_SABADOKeyPressed
        char teclaPresionada = evt.getKeyChar();
        if(teclaPresionada==KeyEvent.VK_ENTER){
            TXT_PRECIO_DOMINGO.requestFocus();
        }
    }//GEN-LAST:event_TXT_PRECIO_SABADOKeyPressed

    private void TXT_PRECIO_DOMINGOKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_PRECIO_DOMINGOKeyPressed
        char teclaPresionada = evt.getKeyChar();
        if(teclaPresionada==KeyEvent.VK_ENTER){
            btnguardar_TURNO_GT.doClick();
        }
    }//GEN-LAST:event_TXT_PRECIO_DOMINGOKeyPressed

    private void CBX_TIPO_TURNOItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CBX_TIPO_TURNOItemStateChanged
        
    }//GEN-LAST:event_CBX_TIPO_TURNOItemStateChanged

    private void CBX_TIPO_TURNOPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_CBX_TIPO_TURNOPropertyChange
        
    }//GEN-LAST:event_CBX_TIPO_TURNOPropertyChange

    private void CBX_TIPO_TURNOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CBX_TIPO_TURNOMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_CBX_TIPO_TURNOMouseClicked
    
    public void cargar_cbx(){
        try {
            
                    this.CBX_TIPO_TURNO.removeAllItems(); 
                    CBX_TIPO_TURNO_GT.removeAllItems();
                    Statement sta=con.createStatement();
                                       
                        ResultSet rs=sta.executeQuery("SELECT * FROM PERSONAL_TIPO_TURNOS");
//                        this.cb_HORA_INICIO.addItem("Seleccionar...");
//                        this.cb_HORA_FIN.addItem("Seleccionar...");
                        while(rs.next()){
                        this.CBX_TIPO_TURNO.addItem(rs.getString("nom_tipo_turno"));
                        CBX_TIPO_TURNO_GT.addItem(rs.getString("nom_tipo_turno"));
                    } 
            } catch (Exception e) {
            }
    }
    
    public void Mostrar_HORARIOS(){
        try {
                     
            String consulta="";
            
            TB_HORARIOS.setModel(new DefaultTableModel());
            String titulos[]={"Nº","Cod. Horarios","Hora Completa","Total de Horas","Pasar Día"};
            m=new DefaultTableModel(null,titulos);
            JTable p=new JTable(m);
            String fila[]=new String[5];
            Usuario obj=new Usuario();
            consulta="exec PERSONAL_HORARIOS_LISTAR";
            PreparedStatement cmd = obj.getCn().prepareStatement(consulta);
            
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
            TB_HORARIOS.setModel(m);
            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m);
            TB_HORARIOS.setRowSorter(elQueOrdena);
            TB_HORARIOS.setModel(m);
                       
            formato_TB_HORARIOS();
            
        } catch (Exception e) {
            System.out.println("Error mostrar actividades: " + e.getMessage());
        }     
    }
    
    public void formato_TB_HORARIOS(){        
            TB_HORARIOS.getColumnModel().getColumn(0).setPreferredWidth(70);
            TB_HORARIOS.getColumnModel().getColumn(1).setPreferredWidth(249); 
            TB_HORARIOS.getColumnModel().getColumn(2).setPreferredWidth(250);
            TB_HORARIOS.getColumnModel().getColumn(3).setPreferredWidth(249);
            TB_HORARIOS.getColumnModel().getColumn(4).setPreferredWidth(249);                
                        
            //Ocultar
//            TB_UO_ACTIVIDADES.getColumnModel().getColumn(2).setMinWidth(0);
//            TB_UO_ACTIVIDADES.getColumnModel().getColumn(2).setMaxWidth(0);    
//            TB_UO_ACTIVIDADES.getColumnModel().getColumn(3).setMinWidth(0);
//            TB_UO_ACTIVIDADES.getColumnModel().getColumn(3).setMaxWidth(0);      
    }
    
    public void Buscar_PERSONAL_HORARIOS(){
        try {
                     
            String consulta="";
            
            TB_HORARIOS.setModel(new DefaultTableModel());
            String titulos[]={"Nº","Cod. Horarios","Hora Completa","Total de Horas","Pasar Día"};
            m1=new DefaultTableModel(null,titulos);
            JTable p=new JTable(m1);
            String fila[]=new String[11];
            Usuario obj=new Usuario();
            consulta="exec PERSONAL_HORARIOS_BUSCAR ?";
            PreparedStatement cmd = obj.getCn().prepareStatement(consulta);            
            cmd.setString(1, TXT_HORARIO.getText());
            
            ResultSet r= cmd.executeQuery();
            int c = 1;
            while(r.next()){
                          
                fila[0]=String.valueOf(c)+"º";
                fila[1]=r.getString(1);
                fila[2]=r.getString(2);
                fila[3]=r.getString(3);
                fila[4]=r.getString(4);
                
                m1.addRow(fila);
                c++;
            }
            TB_HORARIOS.setModel(m1);
            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m1);
            TB_HORARIOS.setRowSorter(elQueOrdena);
            TB_HORARIOS.setModel(m1);
                       
            formato_TB_HORARIOS();
            
  
        }catch (Exception e) {
            System.out.println("Error buscar horarios: " + e.getMessage());
        }
        
    }
    
    public void Mostrar_TB_TURNOS_POR_HORARIO_TIPO(){
        try {
            String consulta="";
            
            TB_TURNOS.setModel(new DefaultTableModel());
            String titulos[]={"Nº","Cod. Turno","Cod. Horarios","Cod. Tipo Turno","Nomenclatura", "Descripción", "Total Hora"};
            m2=new DefaultTableModel(null,titulos);
            JTable p=new JTable(m2);
            String fila[]=new String[7];
            Usuario obj=new Usuario();
            consulta="exec PERSONAL_TURNOS_POR_HORARIO_Y_TIPO_TURNO_LISTA ?,?";
            PreparedStatement cmd = obj.getCn().prepareStatement(consulta);
            cmd.setString(1, LBL_COD_HORARIO.getText());
            cmd.setString(2, LBL_COD_TIPO_TURNOS.getText());
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
                      
                m2.addRow(fila);
                c++;
 
            }
            TB_TURNOS.setModel(m2);
            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m2);
            TB_TURNOS.setRowSorter(elQueOrdena);
            TB_TURNOS.setModel(m2);
                       
            formato_TB_TURNOS_HORARIO_TIPO();
            
        } catch (Exception e) {
            System.out.println("Error mostrar turnos horario tipo: " + e.getMessage());
        }     
    }
    
    public void formato_TB_TURNOS_HORARIO_TIPO(){        
            TB_TURNOS.getColumnModel().getColumn(0).setPreferredWidth(50);
            TB_TURNOS.getColumnModel().getColumn(1).setPreferredWidth(170); 
            TB_TURNOS.getColumnModel().getColumn(2).setPreferredWidth(170);
            TB_TURNOS.getColumnModel().getColumn(3).setPreferredWidth(170);
            TB_TURNOS.getColumnModel().getColumn(4).setPreferredWidth(170);                
            TB_TURNOS.getColumnModel().getColumn(5).setPreferredWidth(170);
            TB_TURNOS.getColumnModel().getColumn(6).setPreferredWidth(170);             
            //Ocultar
//            TB_UO_ACTIVIDADES.getColumnModel().getColumn(2).setMinWidth(0);
//            TB_UO_ACTIVIDADES.getColumnModel().getColumn(2).setMaxWidth(0);    
//            TB_UO_ACTIVIDADES.getColumnModel().getColumn(3).setMinWidth(0);
//            TB_UO_ACTIVIDADES.getColumnModel().getColumn(3).setMaxWidth(0);      
    }
    
    public void Buscar_TB_TURNOS_HORARIO_TIPO(){
        try {
                     
            String consulta="";
            
            TB_TURNOS.setModel(new DefaultTableModel());
            String titulos[]={"Nº","Cod. Turno","Cod. Horarios","Cod. Tipo Turno","Nomenclatura", "Descripción", "Total Hora"};
            m3=new DefaultTableModel(null,titulos);
            JTable p=new JTable(m3);
            String fila[]=new String[7];
            Usuario obj=new Usuario();
            consulta="exec PERSONAL_TURNOS_POR_HORARIO_Y_TIPO_TURNO_BUSCAR ?,?,?";
            PreparedStatement cmd = obj.getCn().prepareStatement(consulta);  
            cmd.setString(1, LBL_COD_HORARIO.getText());
            cmd.setString(2, LBL_COD_TIPO_TURNOS.getText());
            cmd.setString(3, TXT_TURNOS_POR_HORARIO_TIPO_NOMEN.getText());
            
            ResultSet r= cmd.executeQuery();
            int c = 1;
            while(r.next()){
                          
                fila[0]=String.valueOf(c)+"º";
                fila[1]=r.getString(1);
                fila[2]=r.getString(2);
                fila[3]=r.getString(3);
                fila[4]=r.getString(4);
                fila[5]=r.getString(5);
                fila[6]=r.getString(6);
                
                m3.addRow(fila);
                c++;
            }
            TB_TURNOS.setModel(m3);
            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m3);
            TB_TURNOS.setRowSorter(elQueOrdena);
            TB_TURNOS.setModel(m3);
                       
            formato_TB_TURNOS_HORARIO_TIPO();
   
        }catch (Exception e) {
            System.out.println("Error buscar horarios: " + e.getMessage());
        }
        
    }
    
        public void Mostrar_UNIDAD_ORGANICA(){
        try {
                     
            String consulta="";
            
            TB_UNIDAD_ORGANICA.setModel(new DefaultTableModel());
            String titulos[]={"Nº","Cod. UO Jerar","Nombre. UO Jerar", "AR_ID"};
            m3=new DefaultTableModel(null,titulos);
            JTable p=new JTable(m3);
            String fila[]=new String[4];
            Usuario obj=new Usuario();
            consulta="exec PERSONAL_SISTEMA_UNIDAD_ORGANICA_LISTAR";
            PreparedStatement cmd = obj.getCn().prepareStatement(consulta);
            
            ResultSet r= cmd.executeQuery();
            int c=1;
            while(r.next()){

                fila[0]=String.valueOf(c)+"º";
                fila[1]=r.getString(1);
                fila[2]=r.getString(2);
                fila[3]=r.getString(3);
                                
                m3.addRow(fila);
                c++;
 
            }
            TB_UNIDAD_ORGANICA.setModel(m3);
            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m3);
            TB_UNIDAD_ORGANICA.setRowSorter(elQueOrdena);
            TB_UNIDAD_ORGANICA.setModel(m3);
                       
            formato_TB_UNIDAD_ORGANICA();
            
        } catch (Exception e) {
            System.out.println("Error mostrar unidad organica: " + e.getMessage());
        }     
    }
      
    public void BUSCAR_UNIDAD_ORGANICA(){
           
            String buscar="";
            buscar = TXT_BUSCAR_UNIDAD_ORGANICA.getText();

        String consulta="";
        
        try {
       
            TB_UNIDAD_ORGANICA.setModel(new DefaultTableModel());
            String titulos[]={"Nº","Cod. UO Jerar","Nombre. UO Jerar", "AR_ID"};
            m4=new DefaultTableModel(null,titulos);
            JTable p=new JTable(m4);
            String fila[]=new String[4];

            CLS_PERSONAL_TURNOS obj=new CLS_PERSONAL_TURNOS();
            consulta="exec PERSONAL_SISTEMA_UNIDAD_ORGANICA_BUSCAR ?";
            PreparedStatement cmd = obj.getCn().prepareStatement(consulta);
            cmd.setString(1, buscar);
            
            ResultSet r= cmd.executeQuery();
            int c=1;
            while(r.next()){   
                
                fila[0]=String.valueOf(c)+"º";
                fila[1]=r.getString(1);
                fila[2]=r.getString(2);
                fila[3]=r.getString(3);
                
                m4.addRow(fila);
                c++;
            }
            TB_UNIDAD_ORGANICA.setModel(m4);
            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m4);
            TB_UNIDAD_ORGANICA.setRowSorter(elQueOrdena);
            this.TB_UNIDAD_ORGANICA.setModel(m4);
            
            formato_TB_UNIDAD_ORGANICA();
            
        } catch (Exception e) {
            System.out.println("Error buscar unidad organica: " + e.getMessage());
        }
    }
        
    public void formato_TB_UNIDAD_ORGANICA(){        
            TB_UNIDAD_ORGANICA.getColumnModel().getColumn(0).setPreferredWidth(40);
            TB_UNIDAD_ORGANICA.getColumnModel().getColumn(1).setPreferredWidth(100); 
            TB_UNIDAD_ORGANICA.getColumnModel().getColumn(2).setPreferredWidth(300);
            TB_UNIDAD_ORGANICA.getColumnModel().getColumn(3).setPreferredWidth(80);
               
    }
    
    public void GUARDAR_TURNOS_UNIDAD_ORGANICA(){  
        CLS_PERSONAL_TURNOS UO = new CLS_PERSONAL_TURNOS();
        UO.setCOD_TURNO(LBL_COD_TURNO.getText());             
        UO.setCOD_UNI_ORGANICA_JERAR(LBL_COD_UO.getText());
        UO.setNOM_USU(lblusu.getText());
               
        UO.PERSONAL_TURNOS_UO_GUARDAR();
               
        
    }
    
    public void inicializar_tabla_TURNOS_UNIDAD_ORGANICA(){       
        try {
            
            String titulosb[]={"Nº","Cod. Turno UO","Cod. Turno","Cod. Horarios","Cod. T Turno",
                "Turno","Nomenclatura","Descripción","Servicio","Hora Inicio", "Hora Fin", "AR_ID","Hora Total","Pasar Día",
                "Precio Normal","Precio Sabado", "Precio Domingo", "Precio Feriado"};
            msb=new DefaultTableModel(null,titulosb);
            JTable psb=new JTable(msb);
            String filasb[]=new String[18];
            TB_TURNOS_UNIDAD_ORGANICA.setModel(msb);
            TableRowSorter<TableModel> elQueOrdenasb=new TableRowSorter<TableModel>(msb);
            TB_TURNOS_UNIDAD_ORGANICA.setRowSorter(elQueOrdenasb);
            TB_TURNOS_UNIDAD_ORGANICA.setModel(msb);
            
            formatoPersonal_TURNOS_UNIDAD_ORGANICA();
            
        } catch (Exception e) {
            System.out.println("error inicializar tabla_turnos_unidad_-organica: " + e);
        }      
    }
    
    public void formatoPersonal_TURNOS_UNIDAD_ORGANICA(){        
            TB_TURNOS_UNIDAD_ORGANICA.getColumnModel().getColumn(0).setPreferredWidth(50);
            TB_TURNOS_UNIDAD_ORGANICA.getColumnModel().getColumn(1).setPreferredWidth(144); 
            TB_TURNOS_UNIDAD_ORGANICA.getColumnModel().getColumn(2).setPreferredWidth(110);
            TB_TURNOS_UNIDAD_ORGANICA.getColumnModel().getColumn(3).setPreferredWidth(130);
            TB_TURNOS_UNIDAD_ORGANICA.getColumnModel().getColumn(4).setPreferredWidth(110);                
            TB_TURNOS_UNIDAD_ORGANICA.getColumnModel().getColumn(5).setPreferredWidth(110); 
            TB_TURNOS_UNIDAD_ORGANICA.getColumnModel().getColumn(6).setPreferredWidth(100);
            TB_TURNOS_UNIDAD_ORGANICA.getColumnModel().getColumn(7).setPreferredWidth(200); 
            TB_TURNOS_UNIDAD_ORGANICA.getColumnModel().getColumn(8).setPreferredWidth(160);
            TB_TURNOS_UNIDAD_ORGANICA.getColumnModel().getColumn(9).setPreferredWidth(150);
            TB_TURNOS_UNIDAD_ORGANICA.getColumnModel().getColumn(10).setPreferredWidth(100);
            TB_TURNOS_UNIDAD_ORGANICA.getColumnModel().getColumn(11).setPreferredWidth(100);
            TB_TURNOS_UNIDAD_ORGANICA.getColumnModel().getColumn(12).setPreferredWidth(100);
            TB_TURNOS_UNIDAD_ORGANICA.getColumnModel().getColumn(13).setPreferredWidth(100);
            TB_TURNOS_UNIDAD_ORGANICA.getColumnModel().getColumn(14).setPreferredWidth(100);
            TB_TURNOS_UNIDAD_ORGANICA.getColumnModel().getColumn(15).setPreferredWidth(100);
            TB_TURNOS_UNIDAD_ORGANICA.getColumnModel().getColumn(16).setPreferredWidth(100);
            TB_TURNOS_UNIDAD_ORGANICA.getColumnModel().getColumn(17).setPreferredWidth(100);
            //Ocultar
//            TB_TURNOS_UNIDAD_ORGANICA.getColumnModel().getColumn(1).setMinWidth(0);
//            TB_TURNOS_UNIDAD_ORGANICA.getColumnModel().getColumn(1).setMaxWidth(0);
//            TB_TURNOS_UNIDAD_ORGANICA.getColumnModel().getColumn(2).setMinWidth(0);
//            TB_TURNOS_UNIDAD_ORGANICA.getColumnModel().getColumn(2).setMaxWidth(0);    
//            TB_TURNOS_UNIDAD_ORGANICA.getColumnModel().getColumn(3).setMinWidth(0);
//            TB_TURNOS_UNIDAD_ORGANICA.getColumnModel().getColumn(3).setMaxWidth(0);
//            TB_TURNOS_UNIDAD_ORGANICA.getColumnModel().getColumn(4).setMinWidth(0);
//            TB_TURNOS_UNIDAD_ORGANICA.getColumnModel().getColumn(4).setMaxWidth(0); 
//            TB_TURNOS_UNIDAD_ORGANICA.getColumnModel().getColumn(11).setMinWidth(0);
//            TB_TURNOS_UNIDAD_ORGANICA.getColumnModel().getColumn(11).setMaxWidth(0);
            
    }
    
    public void mostrar_TURNOS_UNIDAD_ORGANICA(){
        try {                   
                        //detalle
                        String consulta="";
                        TB_TURNOS_UNIDAD_ORGANICA.setModel(new DefaultTableModel());
                        String titulos[]={"Nº","Cod. Turno UO","Cod. Turno","Cod. Horarios","Cod. T Turno",
                        "Turno","Nomenclatura","Descripción","Servicio","Hora Inicio", "Hora Fin", "AR_ID","Hora Total","Pasar Día",
                        "Precio Normal","Precio Sabado", "Precio Domingo", "Precio Feriado"};
                        m5=new DefaultTableModel(null,titulos);
                        JTable p=new JTable(m5);
                        String fila[]=new String[18];
                        Usuario obj=new Usuario();
                        consulta="exec PERSONAL_TURNOS_UNIDAD_ORGANICA_LISTAR";
                        PreparedStatement cmd = obj.getCn().prepareStatement(consulta);
                        
                        ResultSet r= cmd.executeQuery();
                        int i=0, c=1;
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
                            fila[14]=r.getString(14);
                            fila[15]=r.getString(15);
                            fila[16]=r.getString(16);
                            fila[17]=r.getString(17);  
                            
                            m5.addRow(fila);
                            c++;
                        }
                            TB_TURNOS_UNIDAD_ORGANICA.setModel(m5);
                            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m5);
                            TB_TURNOS_UNIDAD_ORGANICA.setRowSorter(elQueOrdena);
                            TB_TURNOS_UNIDAD_ORGANICA.setModel(m5);

                            formatoPersonal_TURNOS_UNIDAD_ORGANICA();
                      
        } catch (Exception e) {
            System.out.println("Error MOSTRAR turnos unidad organica: " + e.getMessage());
        }  
    }
    
    public void LIMPIAR_GUARDAR_UNIDAD_ORGANICA(){
        jLabel5.setVisible(false);
        TXT_TURNOS_POR_HORARIO_TIPO_NOMEN.setVisible(false);
//        TXT_TURNOS_POR_HORARIO_TIPO_DESCRIP.setVisible(false);
        jScrollPane3.setVisible(false);
        
        jLabel6.setVisible(false);
        TXT_SISTEMA_UNIDAD_ORGANICA.setVisible(false);
        BTN_BUSCAR_UO.setVisible(false);
        
        TXT_HORARIO.setText("");
        TXT_TURNOS_POR_HORARIO_TIPO_NOMEN.setText("");
        TXT_SISTEMA_UNIDAD_ORGANICA.setText("");
        
        TB_HORARIOS.setEnabled(false);
        TB_HORARIOS.setBackground(Color.lightGray);
    }
    
    public void BUSCAR_TURNOS_UNIDAD_ORGANICA(){
        try {
                     
            String consulta="";
            
            TB_TURNOS_UNIDAD_ORGANICA.setModel(new DefaultTableModel());
            String titulos[]={"Nº","Cod. Turno UO","Cod. Turno","Cod. Horarios","Cod. T Turno",
                "Turno","Nomenclatura","Descripción","Servicio","Hora Inicio", "Hora Fin", "AR_ID","Hora Total","Pasar Día",
                "Precio Normal","Precio Sabado", "Precio Domingo", "Precio Feriado"};
            m6=new DefaultTableModel(null,titulos);
            JTable p=new JTable(m6);
            String fila[]=new String[18];
            Usuario obj=new Usuario();
            consulta="exec PERSONAL_TURNOS_UNIDAD_ORGANICA_BUSCAR ?";
            PreparedStatement cmd = obj.getCn().prepareStatement(consulta);            
            cmd.setString(1, TXT_BUSCAR_TURNOS_UNIDAD_ORGANICA.getText());
            
            ResultSet r= cmd.executeQuery();
            int c = 1;
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
                            fila[14]=r.getString(14);
                            fila[15]=r.getString(15);
                            fila[16]=r.getString(16);
                            fila[17]=r.getString(17);
                
                m6.addRow(fila);
                c++;
            }
            TB_TURNOS_UNIDAD_ORGANICA.setModel(m6);
            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m6);
            TB_TURNOS_UNIDAD_ORGANICA.setRowSorter(elQueOrdena);
            TB_TURNOS_UNIDAD_ORGANICA.setModel(m6);
                       
            formatoPersonal_TURNOS_UNIDAD_ORGANICA();            
  
        }catch (Exception e) {
            System.out.println("Error buscar turnos unidad organica: " + e.getMessage());
        }
        
    }
    
    public void CARGAR_HORAS_CBX(){
        ////////cargar combos
                try {
               
                    this.CBX_HORA_INICIO.removeAllItems(); 
                    this.CBX_HORA_FIN.removeAllItems(); 
                    Statement sta=con.createStatement();
                                        
                        ResultSet rs=sta.executeQuery("SELECT hora_completa FROM PERSONAL_HORA ");
//                        this.cb_HORA_INICIO.addItem("Seleccionar...");
//                        this.cb_HORA_FIN.addItem("Seleccionar...");
                        while(rs.next()){
                        this.CBX_HORA_INICIO.addItem(rs.getString("hora_completa"));
                        this.CBX_HORA_FIN.addItem(rs.getString("hora_completa"));
                  
                    }
                    
   
                } catch (Exception e) {
                    System.out.println("error cargar horas cbx: " + e.getMessage());
                    
                }
    }
    
    public void restar_horas(){
        
        String h = CBX_HORA_INICIO.getSelectedItem().toString();
        String h2 = CBX_HORA_FIN.getSelectedItem().toString();
        
        int a = Integer.parseInt(h.substring(0, 2));
        int b = Integer.parseInt(h.substring(3, 5));
        int c = Integer.parseInt(h.substring(6, 8));
        
        int a1 = Integer.parseInt(h2.substring(0, 2));
        int b1 = Integer.parseInt(h2.substring(3, 5));
        int c1 = Integer.parseInt(h2.substring(6, 8));
        
        int hora =0, minuto=0, segundo =0;
        
        if(a < a1 && b < b1){
            hora = a1 - a;
            minuto = b1 - b;
        }
        
        if(a == a1 && b < b1){
            hora = 00;
            minuto = b1 - b;
        }
        
        if(a < a1 && b == b1){
            hora = a1 - a;
            minuto = 00;
        }
        
        if(a < a1 && b > b1){
            hora = (a1 - a) - 1;
            int m=0;
            m = 60 - b;
            minuto = m + b1;
        }
        
        
        
        if(a1==00 && b1==00 && a!=00 && b!=00){
            hora = (24 - a) - 1;
            minuto = 60 - b;
        }
        
        if(a1==00 && b1==00 && a!=00 && b==00){
            hora = (24 - a);
            minuto = 00;
        }
        
        if(a > a1 && b!=00){
            int q=0,w=0,e=0,r=0;
            q = (24 - a) - 1;
            w =  60 - b;
            
            e = a1;
            r = b1;
            
            hora = q + e;
            minuto = w + r;
            
            if(minuto >= 60){
                hora = hora + 1;
                minuto = minuto - 60;
            }            
        }
        
        if(a > a1 && b==00 ){
            int d=0, f=0, g=0, j=0;
            d = (24 - a);
            f = 00;
            
            g = a1;
            j = b1;
            
            hora = d + g;
            minuto = f + j;
            
            if(minuto >= 60){
                hora = hora + 1;
                minuto = minuto - 60;
            }  
        }
        
        String horaf = "", minutof ="";
        
        if(hora < 10){
            horaf = ("0" + hora);
        }else{
            horaf = String.valueOf(hora);
        }
        
        if(minuto < 10){
            minutof = ("0" + minuto);
        }else{
            minutof = String.valueOf(minuto);
        }
                
        TXT_TOTAL_HORA.setText(horaf + ":" + minutof + ":" + segundo + "0");
//        System.out.println("hora: " + hora + " " + minuto + " " + segundo);
    }
    
    public void deshabilitar_horario(){
        CB_PASAR_DIA.setEnabled(false);
        CBX_HORA_INICIO.setEnabled(false);
        CBX_HORA_FIN.setEnabled(false);
        TXT_HORA_COMPLETA.setEnabled(false);
        TXT_TOTAL_HORA.setEnabled(false);
        btnguardar_HORARIO.setEnabled(false);
    }
    
    public void habilitar_horario(){
        CB_PASAR_DIA.setEnabled(true);
        CBX_HORA_INICIO.setEnabled(true);
        CBX_HORA_FIN.setEnabled(true);
        TXT_HORA_COMPLETA.setEnabled(true);
        TXT_TOTAL_HORA.setEnabled(true);
        btnguardar_HORARIO.setEnabled(true);
    }
    
    public void PERSONAL_HORARIO_GUARDAR(){ 
        CLS_PERSONAL_HORARIOS PH = new CLS_PERSONAL_HORARIOS();
        CLS_PERSONAL_HORARIOS PHC = new CLS_PERSONAL_HORARIOS();
        
        String COD_USUARIO="";
        COD_USUARIO = lblusu.getText();
        
        PH.setHORA_INICIO(this.CBX_HORA_INICIO.getSelectedItem().toString());
        PH.setHORA_FIN(this.CBX_HORA_FIN.getSelectedItem().toString());
        PH.setHORA_COMPLETO(TXT_HORA_COMPLETA.getText());
        PH.setHORA_TOTAL(TXT_TOTAL_HORA.getText());
        
        if(CB_PASAR_DIA.isSelected()==true){
            PH.setPASAR_DIA("S");
        }else{
            if(CB_PASAR_DIA.isSelected()==false){
                PH.setPASAR_DIA("N");
            }
        }
        
        PH.setCOD_USU(PHC.PERSONAL_HORARIO_COD_USUARIO(COD_USUARIO));
        
        PH.PERSONAL_HORARIO_INSERTAR();
               
        CLS_PERSONAL_HORARIOS PHC1=new CLS_PERSONAL_HORARIOS();
        TXT_COD_HORARIO.setText(PHC1.PERSONAL_HORARIOS_GENERAR_ID());
    
    }
    
    public void LIMPIAR_HORARIO_GUARDAR(){
        CBX_HORA_INICIO.setSelectedIndex(0);
        CBX_HORA_FIN.setSelectedIndex(0);
        TXT_HORA_COMPLETA.setText("");
        TXT_TOTAL_HORA.setText("");
        CB_PASAR_DIA.setSelected(false);
//        CB_PASAR_DIA.requestFocus();
    }
    
    public void Mostrar_HORARIOS_TURNOS_GT(){
        try {
                     
            String consulta="";
            
            TB_HORARIO_TURNOS_GT.setModel(new DefaultTableModel());
            String titulos[]={"Nº","Cod. Horarios","Hora Completa","Total de Horas","Pasar Día"};
            m7=new DefaultTableModel(null,titulos);
            JTable p=new JTable(m7);
            String fila[]=new String[5];
            Usuario obj=new Usuario();
            consulta="exec PERSONAL_HORARIOS_LISTAR";
            PreparedStatement cmd = obj.getCn().prepareStatement(consulta);
            
            ResultSet r= cmd.executeQuery();
            int c=1;
            while(r.next()){

                fila[0]=String.valueOf(c)+"º";
                fila[1]=r.getString(1);
                fila[2]=r.getString(2);
                fila[3]=r.getString(3);
                fila[4]=r.getString(4);
                                
                m7.addRow(fila);
                c++;
 
            }
            TB_HORARIO_TURNOS_GT.setModel(m7);
            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m7);
            TB_HORARIO_TURNOS_GT.setRowSorter(elQueOrdena);
            TB_HORARIO_TURNOS_GT.setModel(m7);
                       
            formato_TB_HORARIOS_TURNOS_GT();
            
        } catch (Exception e) {
            System.out.println("Error mostrar HORARIOS GT: " + e.getMessage());
        }     
    }
    
    public void formato_TB_HORARIOS_TURNOS_GT(){        
            TB_HORARIO_TURNOS_GT.getColumnModel().getColumn(0).setPreferredWidth(50);
            TB_HORARIO_TURNOS_GT.getColumnModel().getColumn(1).setPreferredWidth(150); 
            TB_HORARIO_TURNOS_GT.getColumnModel().getColumn(2).setPreferredWidth(200);
            TB_HORARIO_TURNOS_GT.getColumnModel().getColumn(3).setPreferredWidth(145);
            TB_HORARIO_TURNOS_GT.getColumnModel().getColumn(4).setPreferredWidth(145);                
                        
            //Ocultar
//            TB_UO_ACTIVIDADES.getColumnModel().getColumn(2).setMinWidth(0);
//            TB_UO_ACTIVIDADES.getColumnModel().getColumn(2).setMaxWidth(0);    
//            TB_UO_ACTIVIDADES.getColumnModel().getColumn(3).setMinWidth(0);
//            TB_UO_ACTIVIDADES.getColumnModel().getColumn(3).setMaxWidth(0);      
    }
    
    public void PERSONAL_TURNOS_GT_INSERTAR(){
        CLS_PERSONAL_TURNO_GT PTGT = new CLS_PERSONAL_TURNO_GT();
        CLS_PERSONAL_TURNO_GT PTGT1 = new CLS_PERSONAL_TURNO_GT();
        CLS_PERSONAL_TURNO_GT PTGT2 = new CLS_PERSONAL_TURNO_GT();
        
        String COD_USUARIO="", COD_TIPO_TURNO ="";
        COD_TIPO_TURNO = CBX_TIPO_TURNO_GT.getSelectedItem().toString();
        COD_USUARIO = lblusu.getText();
        
        PTGT.setCOD_HORARIO(TXT_COD_HORARIO_GT.getText());
        PTGT.setCOD_TIPO_TURNO(PTGT1.PERSONAL_COD_TIPO_TURNOS_GT(COD_TIPO_TURNO));
        PTGT.setNOMENCLATURA(TXT_NOMENCLATURA_GT.getText());
        PTGT.setDESCRIPCION(TXT_DESCRIPCION_GT.getText());
        PTGT.setHORA_TOTAL(TXT_TOTAL_HORAS_GT.getText());
        PTGT.setCOD_TUR("");
        PTGT.setPRECIO_NORMAL(Double.parseDouble(TXT_PRECIO_NORMAL.getText()));
        PTGT.setPRECIO_SABADO(Double.parseDouble(TXT_PRECIO_SABADO.getText()));
        PTGT.setPRECIO_DOMINGO(Double.parseDouble(TXT_PRECIO_DOMINGO.getText()));
        PTGT.setPRECIO_FERIADO(Double.parseDouble(TXT_PRECIO_FERIADO.getText()));
        PTGT.setCOD_USU(PTGT2.PERSONAL_TURNO_GT_COD_USUARIO(COD_USUARIO));
        PTGT.setNOM_USU(lblusu.getText());
        
        PTGT.PERSONAL_TURNO_GT_INSERTAR();
               
        CLS_PERSONAL_TURNO_GT PTGT4=new CLS_PERSONAL_TURNO_GT();
        TXT_COD_TURNOS_GT.setText(PTGT4.PERSONAL_TURNOS_GT_GENERAR_ID());
    }
    
    public void LIMPIAR_TURNOS_GT_GUARDAR(){
        TXT_COD_HORARIO_GT.setText("");
        TXT_HORA_COMPLETA_GT.setText("");
        TXT_TOTAL_HORAS_GT.setText("");
        CBX_TIPO_TURNO_GT.setSelectedIndex(0);
        TXT_NOMENCLATURA_GT.setText("");
        TXT_DESCRIPCION_GT.setText("");
        TB_HORARIO_TURNOS_GT.getSelectionModel().setSelectionInterval(0, 0);
        TB_HORARIO_TURNOS_GT.requestFocus();
        TXT_PRECIO_NORMAL.setText("");
        TXT_PRECIO_SABADO.setText("");
        TXT_PRECIO_DOMINGO.setText("");
        TXT_PRECIO_FERIADO.setText("");
    }
    
    public void DESHABILITAR_TURNOS_GT(){
        TXT_COD_HORARIO_GT.setEnabled(false);
        TXT_HORA_COMPLETA_GT.setEnabled(false);
        TB_HORARIO_TURNOS_GT.setEnabled(false);
        TB_HORARIO_TURNOS_GT.setBackground(Color.lightGray);
        TXT_TOTAL_HORAS_GT.setEnabled(false);
        CBX_TIPO_TURNO_GT.setEnabled(false);
        TXT_NOMENCLATURA_GT.setEnabled(false);
        TXT_DESCRIPCION_GT.setEnabled(false);
        btnguardar_TURNO_GT.setEnabled(false);
        TXT_PRECIO_DOMINGO.setEnabled(false);
        TXT_PRECIO_FERIADO.setEnabled(false);
        TXT_PRECIO_NORMAL.setEnabled(false);
        TXT_PRECIO_SABADO.setEnabled(false);
        
    }
    
    public void HABILITAR_TURNOS_GT(){
        TXT_COD_HORARIO_GT.setEnabled(true);
        TXT_HORA_COMPLETA_GT.setEnabled(true);
        TB_HORARIO_TURNOS_GT.setEnabled(true);
        TB_HORARIO_TURNOS_GT.setBackground(Color.white);
        TXT_TOTAL_HORAS_GT.setEnabled(true);
        CBX_TIPO_TURNO_GT.setEnabled(true);
        TXT_NOMENCLATURA_GT.setEnabled(true);
        TXT_DESCRIPCION_GT.setEnabled(true);
        btnguardar_TURNO_GT.setEnabled(true);
        TXT_PRECIO_DOMINGO.setEnabled(true);
        TXT_PRECIO_FERIADO.setEnabled(true);
        TXT_PRECIO_NORMAL.setEnabled(true);
        TXT_PRECIO_SABADO.setEnabled(true);
    }
    
    public static void addEscapeListenerWindowDialog( final JDialog windowDialog) {
       ActionListener escAction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        windowDialog.dispose();
        }
        };
        windowDialog.getRootPane().registerKeyboardAction(escAction,
        KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
        JComponent.WHEN_IN_FOCUSED_WINDOW);
   }
    
    public void cerrar(){
        int eleccion = JOptionPane.showConfirmDialog(rootPane,"¿Desea realmente salir del formulario?","Mensaje de Confirmación",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE);
        if (eleccion == JOptionPane.YES_OPTION)
        {
            dispose();   
//            PrincipalMDI MDI= new PrincipalMDI();
//            MDI.setVisible(true);  
        }else{
        }
    }
    
    public void mostrar_TURNOS_UO(){
        try {                   
                        //detalle
                        String consulta="";
                        TB_TURNOS_UO.setModel(new DefaultTableModel());
                        String titulos[]={"Nº","Cod. Turno UO","Cod. Turno","Cod. Horarios","Cod. T Turno",
                        "Turno","Nomenclatura","Hora Inicio", "Hora Fin", "AR_ID","Total Hora","Pasar Día",
                        "Precio Normal", "Precio Sabado", "Precio Domingo","Precio Feriado"};
                        m8=new DefaultTableModel(null,titulos);
                        JTable p=new JTable(m8);
                        String fila[]=new String[16];
                        Usuario obj=new Usuario();
                        consulta="exec PERSONAL_TURNOS_UO_AR ?";
                        PreparedStatement cmd = obj.getCn().prepareStatement(consulta);
                        cmd.setString(1, txtAR_ID.getText());
                        ResultSet r= cmd.executeQuery();
                        int i=0, c=1;
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
                            fila[14]=r.getString(14);
                            fila[15]=r.getString(15);
                            
                            m8.addRow(fila);
                            c++;
                        }
                            TB_TURNOS_UO.setModel(m8);
                            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m8);
                            TB_TURNOS_UO.setRowSorter(elQueOrdena);
                            TB_TURNOS_UO.setModel(m8);

                            formatoPersonal_TURNOS_UO();
                      
        } catch (Exception e) {
            System.out.println("Error MOSTRAR VER DETALLE: " + e.getMessage());
        }  
    }
    
    public void formatoPersonal_TURNOS_UO(){        
            TB_TURNOS_UO.getColumnModel().getColumn(0).setPreferredWidth(50);
            TB_TURNOS_UO.getColumnModel().getColumn(1).setPreferredWidth(144); 
            TB_TURNOS_UO.getColumnModel().getColumn(2).setPreferredWidth(110);
            TB_TURNOS_UO.getColumnModel().getColumn(3).setPreferredWidth(130);
            TB_TURNOS_UO.getColumnModel().getColumn(4).setPreferredWidth(110);                
            TB_TURNOS_UO.getColumnModel().getColumn(5).setPreferredWidth(110); 
            TB_TURNOS_UO.getColumnModel().getColumn(6).setPreferredWidth(150);
            TB_TURNOS_UO.getColumnModel().getColumn(7).setPreferredWidth(111); 
            TB_TURNOS_UO.getColumnModel().getColumn(8).setPreferredWidth(111);
            TB_TURNOS_UO.getColumnModel().getColumn(9).setPreferredWidth(150);
            TB_TURNOS_UO.getColumnModel().getColumn(10).setPreferredWidth(100);
            TB_TURNOS_UO.getColumnModel().getColumn(11).setPreferredWidth(100);
            TB_TURNOS_UO.getColumnModel().getColumn(12).setPreferredWidth(100);
            TB_TURNOS_UO.getColumnModel().getColumn(13).setPreferredWidth(100);
            TB_TURNOS_UO.getColumnModel().getColumn(14).setPreferredWidth(100);
            TB_TURNOS_UO.getColumnModel().getColumn(15).setPreferredWidth(100);
            //Ocultar
            TB_TURNOS_UO.getColumnModel().getColumn(2).setMinWidth(0);
            TB_TURNOS_UO.getColumnModel().getColumn(2).setMaxWidth(0);    
            TB_TURNOS_UO.getColumnModel().getColumn(3).setMinWidth(0);
            TB_TURNOS_UO.getColumnModel().getColumn(3).setMaxWidth(0);
            TB_TURNOS_UO.getColumnModel().getColumn(4).setMinWidth(0);
            TB_TURNOS_UO.getColumnModel().getColumn(4).setMaxWidth(0); 
            TB_TURNOS_UO.getColumnModel().getColumn(9).setMinWidth(0);
            TB_TURNOS_UO.getColumnModel().getColumn(9).setMaxWidth(0);
//            TB_TURNOS_UO.getColumnModel().getColumn(10).setMinWidth(0);
//            TB_TURNOS_UO.getColumnModel().getColumn(10).setMaxWidth(0);
            
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
            java.util.logging.Logger.getLogger(PERSONAL_TURNOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PERSONAL_TURNOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PERSONAL_TURNOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PERSONAL_TURNOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PERSONAL_TURNOS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_AGREGAR_HORARIOS;
    private javax.swing.JButton BTN_AGREGAR_TURNOS;
    private javax.swing.JButton BTN_BUSCAR_UO;
    private javax.swing.JButton BTN_INICIO;
    private javax.swing.JComboBox CBX_HORA_FIN;
    private javax.swing.JComboBox CBX_HORA_INICIO;
    private javax.swing.JComboBox CBX_TIPO_TURNO;
    private javax.swing.JComboBox CBX_TIPO_TURNO_GT;
    private javax.swing.JCheckBox CB_PASAR_DIA;
    private javax.swing.JDialog HORARIOS;
    private javax.swing.JLabel LBL_COD_HORARIO;
    private javax.swing.JLabel LBL_COD_TIPO_TURNOS;
    private javax.swing.JLabel LBL_COD_TURNO;
    private javax.swing.JLabel LBL_COD_UO;
    private javax.swing.JLabel LBL_COD_UO_ACTIVIDADES;
    private javax.swing.JLabel LBL_COD_UO_ACTIVIDADES1;
    private javax.swing.JLabel LBL_ESTADO;
    private javax.swing.JLabel LBL_GM;
    private javax.swing.JLabel LBL_GM1;
    private javax.swing.JLabel LBL_GM2;
    private javax.swing.JPanel P_HORARIOS;
    private javax.swing.JPanel P_TURNOS;
    private javax.swing.JPanel P_UO;
    private javax.swing.JTable TB_HORARIOS;
    private javax.swing.JTable TB_HORARIO_TURNOS_GT;
    private javax.swing.JTable TB_TURNOS;
    private javax.swing.JTable TB_TURNOS_UNIDAD_ORGANICA;
    private javax.swing.JTable TB_UNIDAD_ORGANICA;
    private javax.swing.JDialog TURNOS;
    public static javax.swing.JTextField TXT_BUSCAR_TURNOS_UNIDAD_ORGANICA;
    public static javax.swing.JTextField TXT_BUSCAR_UNIDAD_ORGANICA;
    public static javax.swing.JTextField TXT_COD_HORARIO;
    public static javax.swing.JTextField TXT_COD_HORARIO_GT;
    public static javax.swing.JTextField TXT_COD_TURNOS_GT;
    private javax.swing.JTextField TXT_COD_TURNO_UO;
    public static javax.swing.JTextField TXT_DESCRIPCION_GT;
    private javax.swing.JTextField TXT_HORARIO;
    public static javax.swing.JTextField TXT_HORA_COMPLETA;
    public static javax.swing.JTextField TXT_HORA_COMPLETA_GT;
    public static javax.swing.JTextField TXT_NOMENCLATURA_GT;
    public static javax.swing.JTextField TXT_PRECIO_DOMINGO;
    public static javax.swing.JTextField TXT_PRECIO_FERIADO;
    public static javax.swing.JTextField TXT_PRECIO_NORMAL;
    public static javax.swing.JTextField TXT_PRECIO_SABADO;
    private javax.swing.JTextField TXT_SISTEMA_UNIDAD_ORGANICA;
    public static javax.swing.JTextField TXT_TOTAL_HORA;
    public static javax.swing.JTextField TXT_TOTAL_HORAS_GT;
    private javax.swing.JTextField TXT_TURNOS_POR_HORARIO_TIPO_NOMEN;
    private javax.swing.JDialog UNIDAD_ORGANICA;
    private javax.swing.JButton btnBuscarPersonal_rol1;
    private javax.swing.JButton btnBuscarPersonal_rol3;
    public static javax.swing.JButton btnLista;
    public static javax.swing.JButton btnLista_HORARIO;
    public static javax.swing.JButton btnLista_TURNO;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnNuevo_HORARIO;
    private javax.swing.JButton btnNuevo_TURNO;
    private javax.swing.JButton btneditar_HORARIO;
    private javax.swing.JButton btneditar_TURNO;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btneliminar_HORARIO;
    private javax.swing.JButton btneliminar_TURNO;
    private javax.swing.JButton btnguardar;
    public static javax.swing.JButton btnguardar_HORARIO;
    public static javax.swing.JButton btnguardar_TURNO_GT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JLabel lblListado_Edicion;
    public static javax.swing.JLabel lblusu;
    // End of variables declaration//GEN-END:variables
}
