/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.ConsultorioEx;

import java.awt.Color;
import java.awt.Dimension;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import modelos.ConsultorioEx.ConsultorioExtCarnetPerinatalAO;
import modelos.ConsultorioEx.ConsultorioExtCarnetPerinatalAf;

import modelos.ConsultorioEx.ConsultorioExtCarnetPerinatalGa;

import modelos.ConsultorioEx.ConsultorioExtCarnetPerinatalAn;
import modelos.ConsultorioEx.ConsultorioExtCarnetPerinatalAp;
import modelos.ConsultorioEx.ConsultorioExtCarnetPerinatalAtencionPrenatal;
import modelos.ConsultorioEx.ConsultorioExtCarnetPerinatalCabecera;
import modelos.ConsultorioEx.ConsultorioExtCarnetPerinatalEm;
import modelos.ConsultorioEx.ConsultorioExtCarnetPerinatalEf;
import modelos.ConsultorioEx.ConsultorioExtCarnetPerinatalFd;

import modelos.ConsultorioEx.ConsultorioExtCarnetPerinatalFu;
import modelos.ConsultorioEx.ConsultorioExtCarnetPerinatalHo;

import modelos.ConsultorioEx.ConsultorioExtCarnetPerinatalPt;
import modelos.ConsultorioEx.ConsultorioExtCarnetPerinatalTs;
import modelos.ConsultorioEx.ConsultorioExtCarnetPerinatalVg;
import modelos.ConsultorioEx.ConsultorioExtCarnetPerinatalVp;
import static vista.ConsultorioEx.RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.lblCpId;
import static vista.ConsultorioEx.RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.lblIdPeso;



/**
 *
 * @author MYS1
 */
public class RegistroEmbarazoPrincipal extends javax.swing.JInternalFrame {
private JComponent Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
    private Dimension DimensionBarra = null; 
    public static String CpId = "";
    public RegistroEmbarazoPrincipal() {
        initComponents();
        QuitarLaBarraTitulo();
        this.getContentPane().setBackground(new Color(248,245,245)); 
        OP1.setVisible(true);  
        OP2.setVisible(false);
        OP3.setVisible(false);
        DBEA1.setVisible(false);
        DBEA2.setVisible(false);
        FA.setVisible(true);
        lblId.setVisible(false);
        
    }
 public void QuitarLaBarraTitulo(){ 
        Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane(); 
        DimensionBarra = Barra.getPreferredSize(); 
        Barra.setSize(0,0); 
        Barra.setPreferredSize(new Dimension(0,0)); 
        repaint(); 
    }
   
 
    public void antecedentesObtetricos(){
        RegistroEmbarazoAO AO =new RegistroEmbarazoAO();
        RegistroEmbarazo.ContenedorTablas.add(AO);
         
        try {
            AO.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(RegistroSeguimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConsultorioExtCarnetPerinatalAO AO1 = new ConsultorioExtCarnetPerinatalAO();
        AO1.ConsultoriosExtAOListar(lblId.getText());  
        RegistroEmbarazoAO.lbMadreAO.setText(lblMadre.getText());

        RegistroEmbarazo.jTabbedPane1.setSelectedIndex(2);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        OP1 = new javax.swing.JPanel();
        OP2 = new javax.swing.JPanel();
        lblMadre = new javax.swing.JLabel();
        btnbuscar = new javax.swing.JButton();
        btnbuscar1 = new javax.swing.JButton();
        btnbuscar2 = new javax.swing.JButton();
        OP3 = new javax.swing.JPanel();
        lblId = new javax.swing.JTextField();
        btnTerminaConsulta = new javax.swing.JButton();
        LblTitulo = new javax.swing.JLabel();
        FA = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblAO = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btnNuevo1 = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        btnNuevo2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnAO = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        btnNuevo3 = new javax.swing.JButton();
        jPanel22 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        btnNuevo8 = new javax.swing.JButton();
        jPanel32 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        DBEA1 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        btnNuevo4 = new javax.swing.JButton();
        jPanel28 = new javax.swing.JPanel();
        btnNuevo5 = new javax.swing.JButton();
        jPanel29 = new javax.swing.JPanel();
        btnNuevo6 = new javax.swing.JButton();
        jPanel30 = new javax.swing.JPanel();
        btnNuevo7 = new javax.swing.JButton();
        jPanel31 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanel47 = new javax.swing.JPanel();
        btnNuevo14 = new javax.swing.JButton();
        jPanel43 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        DBEA2 = new javax.swing.JPanel();
        jPanel42 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jPanel44 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jPanel45 = new javax.swing.JPanel();
        btnNuevo12 = new javax.swing.JButton();
        jPanel46 = new javax.swing.JPanel();
        btnNuevo13 = new javax.swing.JButton();
        jPanel48 = new javax.swing.JPanel();
        btnNuevo15 = new javax.swing.JButton();
        jPanel49 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jPanel50 = new javax.swing.JPanel();
        btnNuevo16 = new javax.swing.JButton();
        jPanel51 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jPanel52 = new javax.swing.JPanel();
        btnNuevo17 = new javax.swing.JButton();
        jPanel53 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        lblActoMedico = new javax.swing.JLabel();
        lblFP = new javax.swing.JLabel();
        lblFua = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createCompoundBorder());
        setVisible(true);

        jPanel1.setBackground(new java.awt.Color(31, 31, 31));

        OP1.setBackground(new java.awt.Color(243, 156, 17));

        javax.swing.GroupLayout OP1Layout = new javax.swing.GroupLayout(OP1);
        OP1.setLayout(OP1Layout);
        OP1Layout.setHorizontalGroup(
            OP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        OP1Layout.setVerticalGroup(
            OP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        OP2.setBackground(new java.awt.Color(243, 156, 17));

        javax.swing.GroupLayout OP2Layout = new javax.swing.GroupLayout(OP2);
        OP2.setLayout(OP2Layout);
        OP2Layout.setHorizontalGroup(
            OP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        OP2Layout.setVerticalGroup(
            OP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        lblMadre.setBackground(new java.awt.Color(0, 153, 0));
        lblMadre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblMadre.setForeground(new java.awt.Color(255, 255, 255));
        lblMadre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMadre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Embarazada-80.png"))); // NOI18N
        lblMadre.setText("Martha Arias Torres");
        lblMadre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMadre.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblMadre.setIconTextGap(10);
        lblMadre.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnbuscar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnbuscar.setForeground(new java.awt.Color(240, 240, 240));
        btnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Calificaciones-32.png"))); // NOI18N
        btnbuscar.setText("Filiación y antecedentes");
        btnbuscar.setContentAreaFilled(false);
        btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnbuscar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnbuscar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnbuscar.setIconTextGap(30);
        btnbuscar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        btnbuscar1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnbuscar1.setForeground(new java.awt.Color(240, 240, 240));
        btnbuscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Jeringa-32.png"))); // NOI18N
        btnbuscar1.setText("<html>Datos Basales del <br>Embarazo Actual</html>");
        btnbuscar1.setContentAreaFilled(false);
        btnbuscar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnbuscar1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnbuscar1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnbuscar1.setIconTextGap(30);
        btnbuscar1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnbuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscar1ActionPerformed(evt);
            }
        });

        btnbuscar2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnbuscar2.setForeground(new java.awt.Color(240, 240, 240));
        btnbuscar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Bebé-32.png"))); // NOI18N
        btnbuscar2.setText("Atenciones Prenatales");
        btnbuscar2.setContentAreaFilled(false);
        btnbuscar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnbuscar2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnbuscar2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnbuscar2.setIconTextGap(30);
        btnbuscar2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnbuscar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscar2ActionPerformed(evt);
            }
        });

        OP3.setBackground(new java.awt.Color(243, 156, 17));

        javax.swing.GroupLayout OP3Layout = new javax.swing.GroupLayout(OP3);
        OP3.setLayout(OP3Layout);
        OP3Layout.setHorizontalGroup(
            OP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        OP3Layout.setVerticalGroup(
            OP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        lblId.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                lblIdCaretUpdate(evt);
            }
        });

        btnTerminaConsulta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnTerminaConsulta.setForeground(new java.awt.Color(240, 240, 240));
        btnTerminaConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Bebé-32.png"))); // NOI18N
        btnTerminaConsulta.setText("Terminar Consulta");
        btnTerminaConsulta.setContentAreaFilled(false);
        btnTerminaConsulta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTerminaConsulta.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnTerminaConsulta.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnTerminaConsulta.setIconTextGap(30);
        btnTerminaConsulta.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnTerminaConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminaConsultaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnbuscar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMadre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(OP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnbuscar1)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnbuscar2)
                        .addGap(6, 6, 6)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(OP3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(OP2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnTerminaConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblMadre)
                        .addGap(88, 88, 88))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(OP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnbuscar)))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnbuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnbuscar2)
                    .addComponent(OP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnTerminaConsulta)
                .addGap(137, 137, 137)
                .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(582, Short.MAX_VALUE))
        );

        LblTitulo.setFont(new java.awt.Font("Segoe UI Light", 0, 40)); // NOI18N
        LblTitulo.setForeground(new java.awt.Color(51, 51, 51));
        LblTitulo.setText("Filiación y antecedentes");

        FA.setBackground(new java.awt.Color(248, 245, 245));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(102, 102, 102));
        jLabel22.setText("Antecedentes Familiares");
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(327, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lblAO.setBackground(new java.awt.Color(255, 255, 255));
        lblAO.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblAO.setForeground(new java.awt.Color(102, 102, 102));
        lblAO.setText("Antecedentes Obstétricos");
        lblAO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAOMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAO, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Gestación anterior");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(327, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(141, 68, 173));

        btnNuevo1.setForeground(new java.awt.Color(240, 240, 240));
        btnNuevo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Coche de niño-50.png"))); // NOI18N
        btnNuevo1.setContentAreaFilled(false);
        btnNuevo1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo1.setIconTextGap(30);
        btnNuevo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNuevo1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNuevo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel15.setBackground(new java.awt.Color(248, 26, 70));
        jPanel15.setPreferredSize(new java.awt.Dimension(78, 85));

        btnNuevo2.setForeground(new java.awt.Color(240, 240, 240));
        btnNuevo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Familia hombre mujer-50.png"))); // NOI18N
        btnNuevo2.setContentAreaFilled(false);
        btnNuevo2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo2.setIconTextGap(30);
        btnNuevo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNuevo2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNuevo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(154, 89, 181));

        btnAO.setForeground(new java.awt.Color(240, 240, 240));
        btnAO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Hojas-50.png"))); // NOI18N
        btnAO.setContentAreaFilled(false);
        btnAO.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAO.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAO.setIconTextGap(30);
        btnAO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAOActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAO, javax.swing.GroupLayout.PREFERRED_SIZE, 78, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(255, 102, 102));

        btnNuevo3.setForeground(new java.awt.Color(240, 240, 240));
        btnNuevo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Mujer de pie-50.png"))); // NOI18N
        btnNuevo3.setContentAreaFilled(false);
        btnNuevo3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo3.setIconTextGap(30);
        btnNuevo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNuevo3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNuevo3, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
        );

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(102, 102, 102));
        jLabel23.setText("Antecedentes Personales");
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(255, 153, 102));

        btnNuevo8.setForeground(new java.awt.Color(240, 240, 240));
        btnNuevo8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Jeringa-50.png"))); // NOI18N
        btnNuevo8.setContentAreaFilled(false);
        btnNuevo8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo8.setIconTextGap(30);
        btnNuevo8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNuevo8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNuevo8, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
        );

        jPanel32.setBackground(new java.awt.Color(255, 255, 255));

        jLabel27.setBackground(new java.awt.Color(255, 255, 255));
        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(102, 102, 102));
        jLabel27.setText("Vacunas Previas");
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel27MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout FALayout = new javax.swing.GroupLayout(FA);
        FA.setLayout(FALayout);
        FALayout.setHorizontalGroup(
            FALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FALayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(FALayout.createSequentialGroup()
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(FALayout.createSequentialGroup()
                            .addGroup(FALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 0, 0)
                            .addGroup(FALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(FALayout.createSequentialGroup()
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(FALayout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11))
        );
        FALayout.setVerticalGroup(
            FALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FALayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FALayout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6))
                    .addGroup(FALayout.createSequentialGroup()
                        .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        DBEA1.setBackground(new java.awt.Color(248, 245, 245));

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(102, 102, 102));
        jLabel24.setText("Tipo de Sangre");
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
        );

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Peso y Talla");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
        );

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(102, 102, 102));
        jLabel25.setText("Antitetánica");
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
        );

        jPanel26.setBackground(new java.awt.Color(232, 76, 61));

        btnNuevo4.setForeground(new java.awt.Color(240, 240, 240));
        btnNuevo4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Jeringa-50.png"))); // NOI18N
        btnNuevo4.setContentAreaFilled(false);
        btnNuevo4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo4.setIconTextGap(30);
        btnNuevo4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNuevo4, javax.swing.GroupLayout.PREFERRED_SIZE, 78, Short.MAX_VALUE)
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNuevo4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel28.setBackground(new java.awt.Color(243, 156, 17));
        jPanel28.setPreferredSize(new java.awt.Dimension(78, 85));

        btnNuevo5.setForeground(new java.awt.Color(240, 240, 240));
        btnNuevo5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Agua Filled-50.png"))); // NOI18N
        btnNuevo5.setContentAreaFilled(false);
        btnNuevo5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo5.setIconTextGap(30);
        btnNuevo5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNuevo5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, Short.MAX_VALUE)
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNuevo5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel29.setBackground(new java.awt.Color(193, 57, 45));

        btnNuevo6.setForeground(new java.awt.Color(240, 240, 240));
        btnNuevo6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Balanza-50.png"))); // NOI18N
        btnNuevo6.setContentAreaFilled(false);
        btnNuevo6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo6.setIconTextGap(30);
        btnNuevo6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNuevo6, javax.swing.GroupLayout.PREFERRED_SIZE, 78, Short.MAX_VALUE)
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNuevo6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel30.setBackground(new java.awt.Color(241, 197, 14));

        btnNuevo7.setForeground(new java.awt.Color(240, 240, 240));
        btnNuevo7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Fumador-50.png"))); // NOI18N
        btnNuevo7.setContentAreaFilled(false);
        btnNuevo7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo7.setIconTextGap(30);
        btnNuevo7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNuevo7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, Short.MAX_VALUE)
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addComponent(btnNuevo7, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        jPanel31.setBackground(new java.awt.Color(255, 255, 255));

        jLabel26.setBackground(new java.awt.Color(255, 255, 255));
        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(102, 102, 102));
        jLabel26.setText("Fuma - Droga");
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel26MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel47.setBackground(new java.awt.Color(45, 204, 112));

        btnNuevo14.setForeground(new java.awt.Color(240, 240, 240));
        btnNuevo14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Calendario-50.png"))); // NOI18N
        btnNuevo14.setContentAreaFilled(false);
        btnNuevo14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo14.setIconTextGap(30);
        btnNuevo14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNuevo14, javax.swing.GroupLayout.PREFERRED_SIZE, 78, Short.MAX_VALUE)
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNuevo14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel43.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Fecha Ultima de Menstruación");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel43Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout DBEA1Layout = new javax.swing.GroupLayout(DBEA1);
        DBEA1.setLayout(DBEA1Layout);
        DBEA1Layout.setHorizontalGroup(
            DBEA1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DBEA1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DBEA1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DBEA1Layout.createSequentialGroup()
                        .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DBEA1Layout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(DBEA1Layout.createSequentialGroup()
                        .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(DBEA1Layout.createSequentialGroup()
                        .addGroup(DBEA1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(DBEA1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        DBEA1Layout.setVerticalGroup(
            DBEA1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DBEA1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(DBEA1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DBEA1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DBEA1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DBEA1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DBEA1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        DBEA2.setBackground(new java.awt.Color(248, 245, 245));

        jPanel42.setBackground(new java.awt.Color(255, 255, 255));

        jLabel30.setBackground(new java.awt.Color(255, 255, 255));
        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(102, 102, 102));
        jLabel30.setText("Emergencia");
        jLabel30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel30MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
        );

        jPanel44.setBackground(new java.awt.Color(255, 255, 255));

        jLabel31.setBackground(new java.awt.Color(255, 255, 255));
        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(102, 102, 102));
        jLabel31.setText("Hospitalización");
        jLabel31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel31MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
        );

        jPanel45.setBackground(new java.awt.Color(39, 174, 97));

        btnNuevo12.setForeground(new java.awt.Color(240, 240, 240));
        btnNuevo12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Hospital-50.png"))); // NOI18N
        btnNuevo12.setContentAreaFilled(false);
        btnNuevo12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo12.setIconTextGap(30);
        btnNuevo12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNuevo12, javax.swing.GroupLayout.PREFERRED_SIZE, 78, Short.MAX_VALUE)
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNuevo12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel46.setBackground(new java.awt.Color(23, 160, 134));
        jPanel46.setPreferredSize(new java.awt.Dimension(78, 85));

        btnNuevo13.setForeground(new java.awt.Color(240, 240, 240));
        btnNuevo13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Ambulancia-50.png"))); // NOI18N
        btnNuevo13.setContentAreaFilled(false);
        btnNuevo13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo13.setIconTextGap(30);
        btnNuevo13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNuevo13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, Short.MAX_VALUE)
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNuevo13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel48.setBackground(new java.awt.Color(25, 188, 157));

        btnNuevo15.setForeground(new java.awt.Color(240, 240, 240));
        btnNuevo15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Género-50.png"))); // NOI18N
        btnNuevo15.setContentAreaFilled(false);
        btnNuevo15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo15.setIconTextGap(30);
        btnNuevo15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNuevo15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, Short.MAX_VALUE)
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNuevo15, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
        );

        jPanel49.setBackground(new java.awt.Color(255, 255, 255));

        jLabel32.setBackground(new java.awt.Color(255, 255, 255));
        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(102, 102, 102));
        jLabel32.setText("Violencia / Género");
        jLabel32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel32MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel50.setBackground(new java.awt.Color(50, 151, 219));

        btnNuevo16.setForeground(new java.awt.Color(240, 240, 240));
        btnNuevo16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Escaneo cuerpo-50.png"))); // NOI18N
        btnNuevo16.setContentAreaFilled(false);
        btnNuevo16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo16.setIconTextGap(30);
        btnNuevo16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNuevo16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, Short.MAX_VALUE)
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNuevo16, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
        );

        jPanel51.setBackground(new java.awt.Color(255, 255, 255));

        jLabel33.setBackground(new java.awt.Color(255, 255, 255));
        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(102, 102, 102));
        jLabel33.setText("Examen Fisico");
        jLabel33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel33MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel51Layout = new javax.swing.GroupLayout(jPanel51);
        jPanel51.setLayout(jPanel51Layout);
        jPanel51Layout.setHorizontalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel51Layout.setVerticalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel52.setBackground(new java.awt.Color(41, 127, 184));

        btnNuevo17.setForeground(new java.awt.Color(240, 240, 240));
        btnNuevo17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Tubo de ensayo-50.png"))); // NOI18N
        btnNuevo17.setContentAreaFilled(false);
        btnNuevo17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo17.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo17.setIconTextGap(30);
        btnNuevo17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel52Layout = new javax.swing.GroupLayout(jPanel52);
        jPanel52.setLayout(jPanel52Layout);
        jPanel52Layout.setHorizontalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNuevo17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, Short.MAX_VALUE)
        );
        jPanel52Layout.setVerticalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNuevo17, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
        );

        jPanel53.setBackground(new java.awt.Color(255, 255, 255));

        jLabel34.setBackground(new java.awt.Color(255, 255, 255));
        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(102, 102, 102));
        jLabel34.setText("Exámenes  de Laboratorio");
        jLabel34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel34MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel53Layout = new javax.swing.GroupLayout(jPanel53);
        jPanel53.setLayout(jPanel53Layout);
        jPanel53Layout.setHorizontalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel53Layout.setVerticalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout DBEA2Layout = new javax.swing.GroupLayout(DBEA2);
        DBEA2.setLayout(DBEA2Layout);
        DBEA2Layout.setHorizontalGroup(
            DBEA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DBEA2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DBEA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DBEA2Layout.createSequentialGroup()
                        .addGroup(DBEA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(DBEA2Layout.createSequentialGroup()
                                .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jPanel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(DBEA2Layout.createSequentialGroup()
                                .addGroup(DBEA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addGroup(DBEA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(DBEA2Layout.createSequentialGroup()
                        .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(DBEA2Layout.createSequentialGroup()
                        .addComponent(jPanel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        DBEA2Layout.setVerticalGroup(
            DBEA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DBEA2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(DBEA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DBEA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DBEA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DBEA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DBEA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        lblActoMedico.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblActoMedico.setForeground(new java.awt.Color(243, 156, 17));
        lblActoMedico.setText("jLabel1");

        lblFP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFP.setForeground(new java.awt.Color(243, 156, 17));
        lblFP.setText("jLabel1");

        lblFua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFua.setForeground(new java.awt.Color(243, 156, 17));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblFP)
                                .addGap(18, 18, 18)
                                .addComponent(lblFua, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblActoMedico))
                        .addContainerGap(704, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(DBEA1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(DBEA2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblTitulo)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblActoMedico)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFP)
                            .addComponent(lblFua, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(44, 44, 44)
                .addComponent(FA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DBEA2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DBEA1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblAOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAOMouseClicked
        antecedentesObtetricos();
    }//GEN-LAST:event_lblAOMouseClicked

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        OP1.setVisible(true);
        OP2.setVisible(false);
        OP3.setVisible(false);
        FA.setVisible(true);
        DBEA1.setVisible(false);
        DBEA2.setVisible(false);
        LblTitulo.setText("Filiación y antecedentes");
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btnbuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscar1ActionPerformed
        OP1.setVisible(false);
        OP2.setVisible(true);
        OP3.setVisible(false);
        DBEA1.setVisible(true);
        DBEA2.setVisible(true);
        FA.setVisible(false);
        LblTitulo.setText("Datos Basales del Embarazo Actual");
    }//GEN-LAST:event_btnbuscar1ActionPerformed

    private void btnAOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAOActionPerformed
        antecedentesObtetricos();
    }//GEN-LAST:event_btnAOActionPerformed

    private void btnNuevo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo1ActionPerformed
        RegistroEmbarazoGA GA =new RegistroEmbarazoGA();
        RegistroEmbarazo.ContenedorTablas.add(GA);
        try {
            GA.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(RegistroSeguimiento.class.getName()).log(Level.SEVERE, null, ex);
        }

        ConsultorioExtCarnetPerinatalGa GA1 = new ConsultorioExtCarnetPerinatalGa();
        GA1.ConsultoriosExtGAListar(lblId.getText()); 
        
        RegistroEmbarazoGA.lblMadreGA.setText(lblMadre.getText());
        if (RegistroEmbarazoGA.lblIdGA.getText().equals("") ){
                    RegistroEmbarazoGA.btnGuardar.setEnabled(true);
                    RegistroEmbarazoGA.btneditar.setEnabled(false);
        }

        RegistroEmbarazoGA.lblMadreGA.setText(lblMadre.getText());

        RegistroEmbarazo.jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_btnNuevo1ActionPerformed

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel22MouseClicked

    private void btnNuevo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo2ActionPerformed
        RegistroEmbarazoAF AF =new RegistroEmbarazoAF();
        RegistroEmbarazo.ContenedorTablas.add(AF);
        try {
            AF.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(RegistroSeguimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ConsultorioExtCarnetPerinatalAf AF1 = new ConsultorioExtCarnetPerinatalAf();
        AF1.ConsultoriosExtAFListar(lblId.getText()); 
        
        RegistroEmbarazoAF.lblMadreAf.setText(lblMadre.getText());
        if (RegistroEmbarazoAF.lblIdAF.getText().equals("") ){
                    RegistroEmbarazoAF.btnGuardar.setEnabled(true);
                    RegistroEmbarazoAF.btneditar.setEnabled(false);
        }
        
        
        RegistroEmbarazo.jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_btnNuevo2ActionPerformed

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel23MouseClicked

    private void btnNuevo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo3ActionPerformed
       
  RegistroEmbarazoAP AP =new RegistroEmbarazoAP();
        RegistroEmbarazo.ContenedorTablas.add(AP);
        try {
            AP.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(RegistroSeguimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ConsultorioExtCarnetPerinatalAp AP1 = new ConsultorioExtCarnetPerinatalAp();
        AP1.ConsultoriosExtAPListar(lblId.getText()); 
        
        RegistroEmbarazoAP.lblMadre.setText(lblMadre.getText());
        if (RegistroEmbarazoAP.lblIdAP.getText().equals("") ){
                    RegistroEmbarazoAP.btnGuardar.setEnabled(true);
                    RegistroEmbarazoAP.btneditar.setEnabled(false);
        }
        
        
        RegistroEmbarazo.jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_btnNuevo3ActionPerformed

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel24MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel25MouseClicked

    private void btnNuevo4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo4ActionPerformed
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V PT_A_TS_F_D_FUM_H_E_V =new RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V();
        RegistroEmbarazo.ContenedorTablas.add(PT_A_TS_F_D_FUM_H_E_V);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.LblTitulo.setText("Antitetánica");
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P1.setVisible(false);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P2.setVisible(false);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P3.setVisible(true);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P4.setVisible(false);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P5.setVisible(false);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P6.setVisible(false);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.PEmergencia.setVisible(false);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P8.setVisible(false);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P9.setVisible(false);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.opcionGuardar = "antitetanica";
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.lblCpId.setText(lblId.getText());
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.lblMadre.setText(lblMadre.getText());
        ConsultorioExtCarnetPerinatalAn AN = new ConsultorioExtCarnetPerinatalAn();
        AN.ConsultoriosExtANListar(RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.lblCpId.getText());
        if(RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.lblIdAn.getText().equals("")){
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.lblMantAn.setText("I");
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.btnGuardar.setEnabled(true);
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.btnModificar.setEnabled(false);
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.txtNDosisPrevia.setEditable(true);
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.txtDosis1.setEditable(true);
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.txtDosis2.setEditable(true);
        }else{
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.btnGuardar.setEnabled(false);
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.btnModificar.setEnabled(true);
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.txtNDosisPrevia.setEditable(false);
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.txtDosis1.setEditable(false);
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.txtDosis2.setEditable(false);
        }
        try {
            PT_A_TS_F_D_FUM_H_E_V.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(RegistroSeguimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
        RegistroEmbarazo.jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_btnNuevo4ActionPerformed

    private void btnNuevo5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo5ActionPerformed
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V PT_A_TS_F_D_FUM_H_E_V =new RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V();
        try {
            RegistroEmbarazo.ContenedorTablas.add(PT_A_TS_F_D_FUM_H_E_V);
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.LblTitulo.setText("Tipo de Sangre");
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P1.setVisible(false);
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P2.setVisible(true);
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P3.setVisible(false);
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P4.setVisible(false);
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P5.setVisible(false);
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P6.setVisible(false);
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.PEmergencia.setVisible(false);
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P8.setVisible(false);
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P9.setVisible(false);
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.opcionGuardar = "tipoSangre";//
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.lblMadre.setText(lblMadre.getText());
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.lblCpId.setText(lblId.getText());
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.lblMadre.setText(lblMadre.getText());
            ConsultorioExtCarnetPerinatalTs TS = new ConsultorioExtCarnetPerinatalTs();
            TS.ConsultoriosExtTsListar(RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.lblCpId.getText());
        if(RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.lblIdGs.getText().equals("")){
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.lblMantGs.setText("I");
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.btnGuardar.setEnabled(true);
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.btnModificar.setEnabled(false);
        }else{
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.btnGuardar.setEnabled(false);
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.btnModificar.setEnabled(true);
        }
        } catch (Exception e) {
        }//
        try {
            PT_A_TS_F_D_FUM_H_E_V.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(RegistroSeguimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
        RegistroEmbarazo.jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_btnNuevo5ActionPerformed

    private void btnNuevo6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo6ActionPerformed
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V PT_A_TS_F_D_FUM_H_E_V =new RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V();
        RegistroEmbarazo.ContenedorTablas.add(PT_A_TS_F_D_FUM_H_E_V);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.LblTitulo.setText("<html>Peso y <br>talla</html>");
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P1.setVisible(true);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P2.setVisible(false);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P3.setVisible(false);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P4.setVisible(false);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P5.setVisible(false);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P6.setVisible(false);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.PEmergencia.setVisible(false);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P8.setVisible(false);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P9.setVisible(false);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.opcionGuardar = "peso";
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.lblCpId.setText(lblId.getText());
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.lblMadre.setText(lblMadre.getText());
        ConsultorioExtCarnetPerinatalPt PT = new ConsultorioExtCarnetPerinatalPt();
        PT.ConsultoriosExtPTListar(RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.lblCpId.getText());
        if(RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.lblIdPeso.getText().equals("")){
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.lblMant.setText("I");
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.btnGuardar.setEnabled(true);
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.btnModificar.setEnabled(false);
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.txtPeso.setEditable(true);
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.txtTalla.setEditable(true);
        }else{
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.lblMant.setText("U");
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.btnGuardar.setEnabled(false);
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.btnModificar.setEnabled(true);
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.txtPeso.setEditable(false);
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.txtTalla.setEditable(false);
        }
        try {
            PT_A_TS_F_D_FUM_H_E_V.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(RegistroSeguimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
        RegistroEmbarazo.jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_btnNuevo6ActionPerformed

    private void btnNuevo7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo7ActionPerformed
       RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V PT_A_TS_F_D_FUM_H_E_V =new RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V();
        RegistroEmbarazo.ContenedorTablas.add(PT_A_TS_F_D_FUM_H_E_V);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.LblTitulo.setText("Fuma / Droga");
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P1.setVisible(false);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P2.setVisible(false);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P3.setVisible(false);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P4.setVisible(false);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P5.setVisible(false);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P6.setVisible(false);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.PEmergencia.setVisible(false);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P8.setVisible(true);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P9.setVisible(true);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.opcionGuardar = "fumaDroga";
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.lblCpId.setText(lblId.getText());
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.lblMadre.setText(lblMadre.getText());
        ConsultorioExtCarnetPerinatalFd FD = new ConsultorioExtCarnetPerinatalFd();
        FD.ConsultoriosExtFdListar(RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.lblCpId.getText());
        if(RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.lblIdFd.getText().equals("")){
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.lblMantFd.setText("I");
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.btnGuardar.setEnabled(true);
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.btnModificar.setEnabled(false);
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.txtNCigarros.setEditable(true);
        }else{
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.btnGuardar.setEnabled(false);
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.btnModificar.setEnabled(true);
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.txtNCigarros.setEditable(false);
        }
        try {
            PT_A_TS_F_D_FUM_H_E_V.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(RegistroSeguimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
        RegistroEmbarazo.jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_btnNuevo7ActionPerformed

    private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel26MouseClicked

    private void jLabel30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel30MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel31MouseClicked

    private void btnNuevo12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo12ActionPerformed
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V PT_A_TS_F_D_FUM_H_E_V =new RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V();
        RegistroEmbarazo.ContenedorTablas.add(PT_A_TS_F_D_FUM_H_E_V);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.LblTitulo.setText("Hospitalización");
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P1.setVisible(false);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P2.setVisible(false);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P3.setVisible(false);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P4.setVisible(false);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P5.setVisible(true);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P6.setVisible(false);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.PEmergencia.setVisible(false);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P8.setVisible(false);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P9.setVisible(false);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.opcionGuardar = "hos";
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.lblCpId.setText(lblId.getText());
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.lblMadre.setText(lblMadre.getText());
        ConsultorioExtCarnetPerinatalHo HO = new ConsultorioExtCarnetPerinatalHo();
        HO.ConsultoriosExtHoListar(RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.lblCpId.getText());
        if(RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.lblIdHos.getText().equals("")){
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.lblMantHo.setText("I");
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.btnGuardar.setEnabled(true);
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.btnModificar.setEnabled(false);
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.txtEcografia.setEditable(true);
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.fechaf3.setEnabled(true);
        }else{

            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.btnGuardar.setEnabled(false);
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.btnModificar.setEnabled(true);
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.txtEcografia.setEditable(false);
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.fechaf3.setEnabled(false);

        }
        try {
            PT_A_TS_F_D_FUM_H_E_V.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(RegistroSeguimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
        RegistroEmbarazo.jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_btnNuevo12ActionPerformed

    private void btnNuevo13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo13ActionPerformed
       RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V PT_A_TS_F_D_FUM_H_E_V =new RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V();
        RegistroEmbarazo.ContenedorTablas.add(PT_A_TS_F_D_FUM_H_E_V);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.LblTitulo.setText("Emergencia");
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P1.setVisible(false);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P2.setVisible(false);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P3.setVisible(false);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P4.setVisible(false);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P5.setVisible(false);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P6.setVisible(false);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.PEmergencia.setVisible(true);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P8.setVisible(false);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P9.setVisible(false);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.opcionGuardar = "eme";
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.lblCpId.setText(lblId.getText());
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.lblMadre.setText(lblMadre.getText());
        ConsultorioExtCarnetPerinatalEm EM = new ConsultorioExtCarnetPerinatalEm();
        EM.ConsultoriosExtEmListar(RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.lblCpId.getText());
        if(RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.lblIdEme.getText().equals("")){
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.lblMantEme.setText("I");
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.btnGuardar.setEnabled(true);
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.btnModificar.setEnabled(false);

            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.fechaEmer.setEnabled(true);
        }else{
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.btnGuardar.setEnabled(false);
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.btnModificar.setEnabled(true);

            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.fechaEmer.setEnabled(false);

        }
        try {
            PT_A_TS_F_D_FUM_H_E_V.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(RegistroSeguimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
        RegistroEmbarazo.jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_btnNuevo13ActionPerformed

    private void btnNuevo14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo14ActionPerformed
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V PT_A_TS_F_D_FUM_H_E_V =new RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V();
        RegistroEmbarazo.ContenedorTablas.add(PT_A_TS_F_D_FUM_H_E_V);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.LblTitulo.setText("<html>Fecha Ultima <br>de Menstruación</html>");
        
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P1.setVisible(false);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P2.setVisible(false);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P3.setVisible(false);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P4.setVisible(true);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P5.setVisible(false);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P6.setVisible(false);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.PEmergencia.setVisible(false);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P8.setVisible(false);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P9.setVisible(false);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.opcionGuardar = "fum";
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.lblCpId.setText(lblId.getText());
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.lblMadre.setText(lblMadre.getText());
        ConsultorioExtCarnetPerinatalFu FU = new ConsultorioExtCarnetPerinatalFu();
        FU.ConsultoriosExtFuListar(RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.lblCpId.getText());
        if(RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.lblIdFum.getText().equals("")){
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.lblMantFum.setText("I");
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.btnGuardar.setEnabled(true);
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.btnModificar.setEnabled(false);
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.txtEcografia.setEditable(true);
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.dtFUM.setEnabled(true);
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.dtFechaEco.setEnabled(true);
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.dtFechaProbableParto.setEnabled(true);
        }else{
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.btnGuardar.setEnabled(false);
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.btnModificar.setEnabled(true);
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.txtEcografia.setEditable(false);
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.dtFUM.setEnabled(false);
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.dtFechaEco.setEnabled(false);
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.dtFechaProbableParto.setEnabled(false);
        }
        try {
            PT_A_TS_F_D_FUM_H_E_V.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(RegistroSeguimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
        RegistroEmbarazo.jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_btnNuevo14ActionPerformed

    private void btnNuevo15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo15ActionPerformed
       RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V PT_A_TS_F_D_FUM_H_E_V =new RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V();
        RegistroEmbarazo.ContenedorTablas.add(PT_A_TS_F_D_FUM_H_E_V);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.LblTitulo.setText("Violencia / Género");
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P1.setVisible(false);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P2.setVisible(false);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P3.setVisible(false);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P4.setVisible(false);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P5.setVisible(false);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P6.setVisible(true);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.PEmergencia.setVisible(false);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P8.setVisible(false);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.P9.setVisible(false);
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.opcionGuardar = "vg";
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.lblCpId.setText(lblId.getText());
        RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.lblMadre.setText(lblMadre.getText());
        ConsultorioExtCarnetPerinatalVg VG = new ConsultorioExtCarnetPerinatalVg();
        VG.ConsultoriosExtVgListar(RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.lblCpId.getText());
        if(RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.lblIdVG.getText().equals("")){
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.lblMantVG.setText("I");
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.btnGuardar.setEnabled(true);
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.btnModificar.setEnabled(false);

            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.FechaVG.setEnabled(true);
        }else{
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.btnGuardar.setEnabled(false);
            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.btnModificar.setEnabled(true);

            RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.FechaVG.setEnabled(false);

        }
        try {
            PT_A_TS_F_D_FUM_H_E_V.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(RegistroSeguimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
        RegistroEmbarazo.jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_btnNuevo15ActionPerformed

    private void jLabel32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel32MouseClicked

    private void btnNuevo16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo16ActionPerformed
         RegistroEmbarazoEXF EXF =new RegistroEmbarazoEXF();
        RegistroEmbarazo.ContenedorTablas.add(EXF);
        RegistroEmbarazoEXF.lblCpId.setText(lblId.getText());
        RegistroEmbarazoEXF.lblMadre.setText(lblMadre.getText());
        ConsultorioExtCarnetPerinatalEf EF = new ConsultorioExtCarnetPerinatalEf();
        EF.ConsultoriosExtEfListar(RegistroEmbarazoEXF.lblCpId.getText());
        if(RegistroEmbarazoEXF.lblId.getText().equals("")){
            RegistroEmbarazoEXF.lblMant.setText("I");
            RegistroEmbarazoEXF.btnGuardar.setEnabled(true);
            RegistroEmbarazoEXF.btnModificar.setEnabled(false);
        }else{
            RegistroEmbarazoEXF.btnGuardar.setEnabled(false);
            RegistroEmbarazoEXF.btnModificar.setEnabled(true);
        }
        try {
            EXF.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(RegistroSeguimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
        RegistroEmbarazo.jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_btnNuevo16ActionPerformed

    private void jLabel33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel33MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel33MouseClicked

    private void btnNuevo17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo17ActionPerformed
        RegistroEmbarazoEXL EXL =new RegistroEmbarazoEXL();
        RegistroEmbarazo.ContenedorTablas.add(EXL);
        try {
            EXL.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(RegistroSeguimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
        RegistroEmbarazo.jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_btnNuevo17ActionPerformed

    private void jLabel34MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel34MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel34MouseClicked

    private void btnbuscar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscar2ActionPerformed
        OP1.setVisible(false);
        OP2.setVisible(false);
        OP3.setVisible(true);
        RegistroEmbarazoAtencionesP AP =new RegistroEmbarazoAtencionesP();
        RegistroEmbarazo.ContenedorTablas.add(AP);
        RegistroEmbarazoAtencionesP.lblIdCp.setText(lblId.getText());
        RegistroEmbarazoAtencionesP.lblMadre.setText(lblMadre.getText());
        ConsultorioExtCarnetPerinatalAtencionPrenatal consultorio1 = new ConsultorioExtCarnetPerinatalAtencionPrenatal();
        RegistroEmbarazoAtencionesP.validaAtencionPrenatal(RegistroEmbarazoAtencionesP.lblIdCp.getText(), "1");

        try {
            AP.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(RegistroSeguimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
        RegistroEmbarazo.jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_btnbuscar2ActionPerformed

    private void btnNuevo8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo8ActionPerformed
        RegistroEmbarazoVP VP =new RegistroEmbarazoVP();
        RegistroEmbarazo.ContenedorTablas.add(VP);
        try {
            VP.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(RegistroSeguimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ConsultorioExtCarnetPerinatalVp VP1 = new ConsultorioExtCarnetPerinatalVp();
        VP1.ConsultoriosExtVPListar(lblId.getText()); 
        
        RegistroEmbarazoVP.lblMadreVP.setText(lblMadre.getText());
        if (RegistroEmbarazoVP.lblIdVP.getText().equals("") ){
                    RegistroEmbarazoVP.btnGuardar.setEnabled(true);
                    RegistroEmbarazoVP.btneditar.setEnabled(false);
        }
        
        
        RegistroEmbarazo.jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_btnNuevo8ActionPerformed

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel27MouseClicked

    private void lblIdCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_lblIdCaretUpdate
        ConsultorioExtCarnetPerinatalCabecera consultorio1 = new ConsultorioExtCarnetPerinatalCabecera();
        consultorio1.mostrarDatosCabecera(lblId.getText());
    }//GEN-LAST:event_lblIdCaretUpdate

    private void btnTerminaConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminaConsultaActionPerformed
        
        RegistroEmbarazo.jTabbedPane1.setSelectedIndex(0);
        lblId.setText("");
        this.dispose();
    }//GEN-LAST:event_btnTerminaConsultaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DBEA1;
    private javax.swing.JPanel DBEA2;
    private javax.swing.JPanel FA;
    private javax.swing.JLabel LblTitulo;
    private javax.swing.JPanel OP1;
    private javax.swing.JPanel OP2;
    private javax.swing.JPanel OP3;
    private javax.swing.JButton btnAO;
    private javax.swing.JButton btnNuevo1;
    private javax.swing.JButton btnNuevo12;
    private javax.swing.JButton btnNuevo13;
    private javax.swing.JButton btnNuevo14;
    private javax.swing.JButton btnNuevo15;
    private javax.swing.JButton btnNuevo16;
    private javax.swing.JButton btnNuevo17;
    private javax.swing.JButton btnNuevo2;
    private javax.swing.JButton btnNuevo3;
    private javax.swing.JButton btnNuevo4;
    private javax.swing.JButton btnNuevo5;
    private javax.swing.JButton btnNuevo6;
    private javax.swing.JButton btnNuevo7;
    private javax.swing.JButton btnNuevo8;
    private javax.swing.JButton btnTerminaConsulta;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btnbuscar1;
    private javax.swing.JButton btnbuscar2;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel lblAO;
    public static javax.swing.JLabel lblActoMedico;
    public static javax.swing.JLabel lblFP;
    public static javax.swing.JLabel lblFua;
    public static javax.swing.JTextField lblId;
    public static javax.swing.JLabel lblMadre;
    // End of variables declaration//GEN-END:variables
}
