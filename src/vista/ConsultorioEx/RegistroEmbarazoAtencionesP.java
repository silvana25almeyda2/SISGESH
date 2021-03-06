/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.ConsultorioEx;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.beans.PropertyVetoException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import modelos.ConsultorioEx.ConsultorioExtCarnetPerinatalAtencionPrenatal;
import modelos.admisionEmergencia.AdmisionEmergenciaCabecera;
import static vista.ConsultorioEx.RegistroEmbarazoPrincipal.lblActoMedico;
import static vista.ConsultorioEx.RegistroEmbarazoPrincipal.lblFua;
import static vista.ConsultorioEx.RegistroEmbarazoPrincipal.lblIdActoMedico;

public class RegistroEmbarazoAtencionesP extends javax.swing.JInternalFrame {
private JComponent Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
    private Dimension DimensionBarra = null; 
    
    public RegistroEmbarazoAtencionesP() {
        initComponents();
        QuitarLaBarraTitulo();
        this.getContentPane().setBackground(Color.WHITE);
        A2.setVisible(false);
        A3.setVisible(false);
        A4.setVisible(false);
        A5.setVisible(false);
        A6.setVisible(false);
        A7.setVisible(false);
        A8.setVisible(false);
        A9.setVisible(false);
        pnlMensaje.setVisible(false);
        pnlMensaje.setVisible(false);
        lblFecha.setVisible(false);
        lblIdActoMedico.setVisible(false);
        lblId.setVisible(false);
        lblMant.setVisible(false);
    }
    
    public void QuitarLaBarraTitulo(){ 
        Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane(); 
        DimensionBarra = Barra.getPreferredSize(); 
        Barra.setSize(0,0); 
        Barra.setPreferredSize(new Dimension(0,0)); 
        repaint(); 
    }
    
    public static void limpiar(){
        txtEdad.setText("");
        txtPesoMadre.setText("");
        txtTemp.setText("");
        txtPA.setText("");
        txtPm.setText("");
        txtAu.setText("");
        txtSituacion.setText("");
        txtPresentacion.setText("");
        txtPosicion.setText("");
        txtFcf.setText("");
        txtMovFetal.setText("");
        txtProteinuria.setText("");
        txtEdema.setText("");
        txtReflejo.setText("");
        txtExamenP.setText("");
        txtIndicFierro.setText("");
        txtIndicCalcio.setText("");
        txtIndicFolico.setText("");
        txtOrient.setText("");
        txtEco.setText("");
        txtPerfilBiofisico.setText("");
        dtCita.setDate(null);
        txtVisitDomic.setText("");
        txtPlanParto.setText("");
        txtEstabAtencion.setText("");
        txtResponAtencion.setText("");
        txtFUA.setText("");
    }
    
    public String determinarFecha(JDateChooser calendario){
         
        String fecha = "";
        try {
        int dia = calendario.getCalendar().get(Calendar.DAY_OF_MONTH);
        int mes = calendario.getCalendar().get(Calendar.MONTH)+1;
        int anio = calendario.getCalendar().get(Calendar.YEAR); 
        
            if(dia < 10 && mes < 10){
            fecha = String.valueOf("0" + dia + "/" + "0" + mes + "/" + anio);
        }else 
            if(dia < 10 || mes < 10){
                if(dia < 10 && mes >=10){
                    fecha = String.valueOf("0" + dia + "/" + mes + "/" + anio);
                } else 
                    if(dia >= 10 && mes < 10){
                        fecha = String.valueOf(dia + "/" + "0" + mes + "/" + anio);
                    } 
            } else 
                fecha = String.valueOf(dia + "/" + mes + "/" + anio); 
         } catch (Exception e) {
                           pnlMensaje.setVisible(true);
                           pnlMensaje.setBackground(new Color(255,91,70)); 
                           lblMensaje.setText("Ingrese una fecha correcta");
                           btnSi.setVisible(false);
                           btnNo.setVisible(false); 
         }
        
        return fecha;
    }
    
    public static String fechaActual(){
        java.sql.Date now = new java.sql.Date(System.currentTimeMillis());
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        return date.format(now);
    }
    
    public boolean mantenimientoAtencionPrenatal(){
        boolean retorna = false;
        try {
            ConsultorioExtCarnetPerinatalAtencionPrenatal consultorio1 = new ConsultorioExtCarnetPerinatalAtencionPrenatal();
            AdmisionEmergenciaCabecera adEmerCab = new AdmisionEmergenciaCabecera();
            if(lblMant.getText().equals("U") || lblMant.getText().equals("E"))
                consultorio1.setApId(Integer.parseInt(lblId.getText()));
            consultorio1.setCpId(Integer.parseInt(lblIdCp.getText()));
            consultorio1.setApEdadSem(txtEdad.getText());
            consultorio1.setApPesoMadre(txtPesoMadre.getText());
            consultorio1.setApTemp(txtTemp.getText());
            consultorio1.setApPa(txtPA.getText());
            consultorio1.setApPm(txtPm.getText());
            consultorio1.setApAu(txtAu.getText());
            consultorio1.setApSit(txtSituacion.getText());
            consultorio1.setApPres(txtPresentacion.getText());
            consultorio1.setApPosicion(txtPosicion.getText());
            consultorio1.setApFcf(txtFcf.getText());
            consultorio1.setApMovFet(txtMovFetal.getText());
            consultorio1.setApProtei(txtProteinuria.getText());
            consultorio1.setApEdema(txtEdema.getText());
            consultorio1.setApRo(txtReflejo.getText());
            consultorio1.setApExPezon(txtExamenP.getText());
            consultorio1.setApIndicFierro(txtIndicFierro.getText());
            consultorio1.setApIndicCalcio(txtIndicCalcio.getText());
            consultorio1.setApIndicAcFolico(txtIndicFolico.getText());
            consultorio1.setApOrientConsej(txtOrient.getText());
            consultorio1.setApEgEco(txtEco.getText());
            consultorio1.setApPerfilBio(txtPerfilBiofisico.getText());
            consultorio1.setApCita(determinarFecha(dtCita));
            consultorio1.setApVisitDomic(txtVisitDomic.getText());
            consultorio1.setApPlanParto(txtPlanParto.getText());
            consultorio1.setApEstabAtencion(txtEstabAtencion.getText());
            consultorio1.setApRespAtencion(txtResponAtencion.getText());
            consultorio1.setApSis(txtFUA.getText());
            consultorio1.setCodUsu(adEmerCab.codUsuario(lblusu.getText()));
            consultorio1.setApAtencion(lblAtencion.getText());
            consultorio1.setIdActoMedico(Integer.parseInt(lblIdActoMedico.getText()));
            if(consultorio1.mantenimientoConsultorioExtCarnetPerinatalAtencionPrenatal(lblMant.getText())==true){
                if(lblMant.getText().equals("I")){
                    lblId.setText(consultorio1.perinatalAtencionPrenatalID());
                    lblMant.setText("U");
                }
                pnlMensaje.setVisible(true);
                lblMensaje.setText("Datos guardados de forma correcta");
//                btnGuardar.setEnabled(false);
//                btnModificar.setEnabled(true);
                pnlMensaje.setBackground(new Color(33,115,70));
                btnSi.setVisible(true);
                btnSi.setText("OK");
                btnNo.setVisible(false);
            } else {
                pnlMensaje.setVisible(true);
                lblMensaje.setText("Ocurrió un error, verifique");
                pnlMensaje.setBackground(new Color(255,91,70));
                btnSi.setVisible(false);
                btnNo.setVisible(false);
            }
        } catch (Exception e) {
            System.out.println("Error: mantenimientoAtencionPrenatal" + e.getMessage());
        }
        return retorna;
    }
 
    public static void validaAtencionPrenatal(String cp_id,String atencion){
        try {
            ConsultorioExtCarnetPerinatalAtencionPrenatal consultorio1 = new ConsultorioExtCarnetPerinatalAtencionPrenatal();
            PreparedStatement cmd = consultorio1.getCn().prepareStatement("SELECT * \n" +
                    "FROM CONSULTORIO_EXT_CARNET_PERINATAL_ATENCION_PRENATAL\n" +
                    "WHERE CP_ID = "+cp_id+"\n" +
                    "AND AP_ATENCION = "+atencion+"\n" +
                    "AND ESTADO = 'A'");
            ResultSet res = cmd.executeQuery();
            if(res.next()){
                consultorio1.ConsultoriosExtAtencionPrenatalListar(cp_id, atencion);
                lblMant.setText("U");
            }else {
                lblMant.setText("I");
                limpiar();
                lblId.setText("");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: validaAtencionPrenatal: " + e.toString());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel11 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        txtPesoMadre = new javax.swing.JTextField();
        T7 = new javax.swing.JButton();
        jPanel27 = new javax.swing.JPanel();
        txtPA = new javax.swing.JTextField();
        T8 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        txtTemp = new javax.swing.JTextField();
        jPanel29 = new javax.swing.JPanel();
        txtAu = new javax.swing.JTextField();
        T9 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        txtPresentacion = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        txtPm = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        txtSituacion = new javax.swing.JTextField();
        jPanel36 = new javax.swing.JPanel();
        txtEdad = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        txtPosicion = new javax.swing.JTextField();
        jPanel53 = new javax.swing.JPanel();
        txtFcf = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jPanel54 = new javax.swing.JPanel();
        txtMovFetal = new javax.swing.JTextField();
        T10 = new javax.swing.JButton();
        jLabel51 = new javax.swing.JLabel();
        jPanel52 = new javax.swing.JPanel();
        txtProteinuria = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jPanel51 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jPanel55 = new javax.swing.JPanel();
        txtEdema = new javax.swing.JTextField();
        jPanel56 = new javax.swing.JPanel();
        txtReflejo = new javax.swing.JTextField();
        jPanel57 = new javax.swing.JPanel();
        txtExamenP = new javax.swing.JTextField();
        jPanel58 = new javax.swing.JPanel();
        txtIndicFierro = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jPanel59 = new javax.swing.JPanel();
        txtIndicCalcio = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        jPanel60 = new javax.swing.JPanel();
        txtIndicFolico = new javax.swing.JTextField();
        jPanel67 = new javax.swing.JPanel();
        txtOrient = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jPanel62 = new javax.swing.JPanel();
        txtEco = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        jPanel63 = new javax.swing.JPanel();
        txtPerfilBiofisico = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        jPanel64 = new javax.swing.JPanel();
        dtCita = new com.toedter.calendar.JDateChooser();
        jLabel62 = new javax.swing.JLabel();
        jPanel65 = new javax.swing.JPanel();
        txtVisitDomic = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jPanel66 = new javax.swing.JPanel();
        txtPlanParto = new javax.swing.JTextField();
        jPanel61 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        jPanel68 = new javax.swing.JPanel();
        txtEstabAtencion = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        jPanel69 = new javax.swing.JPanel();
        txtResponAtencion = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        jPanel70 = new javax.swing.JPanel();
        txtFUA = new javax.swing.JTextField();
        lblMant = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        lblusu = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        A3 = new javax.swing.JPanel();
        lblAtencion3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        A4 = new javax.swing.JPanel();
        lblAtencion4 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        A5 = new javax.swing.JPanel();
        lblAtencion5 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        lblAtencion6 = new javax.swing.JLabel();
        A6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        lblAtencion7 = new javax.swing.JLabel();
        A7 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        lblAtencion8 = new javax.swing.JLabel();
        A8 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        lblAtencion9 = new javax.swing.JLabel();
        A9 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        A1 = new javax.swing.JPanel();
        lblAtencion1 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        A2 = new javax.swing.JPanel();
        lblAtencion2 = new javax.swing.JLabel();
        txtPadre16 = new javax.swing.JTextField();
        txtPadre17 = new javax.swing.JTextField();
        txtPadre15 = new javax.swing.JTextField();
        txtPadre18 = new javax.swing.JTextField();
        txtPadre19 = new javax.swing.JTextField();
        txtPadre20 = new javax.swing.JTextField();
        txtPadre21 = new javax.swing.JTextField();
        txtPadre22 = new javax.swing.JTextField();
        txtPadre23 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtPadre24 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        lblIdCp = new javax.swing.JLabel();
        pnlMensaje = new javax.swing.JPanel();
        lblMensaje = new javax.swing.JLabel();
        btnSi = new javax.swing.JButton();
        btnNo = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        lblActoMedico = new javax.swing.JLabel();
        lblFP = new javax.swing.JLabel();
        lblActoMedico2 = new javax.swing.JLabel();
        lblActoMedico3 = new javax.swing.JLabel();
        lblMadre = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        lblIdActoMedico = new javax.swing.JLabel();
        LblAtencion = new javax.swing.JLabel();
        lblAtencion = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createCompoundBorder());
        setVisible(true);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jPanel33.setBackground(new java.awt.Color(255, 255, 255));

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        txtPesoMadre.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtPesoMadre.setForeground(new java.awt.Color(51, 51, 51));
        txtPesoMadre.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtPesoMadre.setToolTipText("");
        txtPesoMadre.setBorder(null);
        txtPesoMadre.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtPesoMadreCaretUpdate(evt);
            }
        });

        T7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/triangulo.png"))); // NOI18N
        T7.setToolTipText("");
        T7.setContentAreaFilled(false);
        T7.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        T7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                T7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(txtPesoMadre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(T7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPesoMadre, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(T7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));
        jPanel27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        txtPA.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtPA.setForeground(new java.awt.Color(51, 51, 51));
        txtPA.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtPA.setToolTipText("");
        txtPA.setBorder(null);
        txtPA.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtPACaretUpdate(evt);
            }
        });

        T8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/triangulo.png"))); // NOI18N
        T8.setToolTipText("");
        T8.setContentAreaFilled(false);
        T8.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        T8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                T8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(txtPA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(T8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPA, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(T8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(51, 51, 51));
        jLabel23.setText("Altura Uterina (cm)");

        jPanel28.setBackground(new java.awt.Color(255, 255, 255));
        jPanel28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        txtTemp.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtTemp.setForeground(new java.awt.Color(51, 51, 51));
        txtTemp.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtTemp.setToolTipText("");
        txtTemp.setBorder(null);
        txtTemp.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTempCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(txtTemp)
                .addContainerGap())
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(txtTemp, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel29.setBackground(new java.awt.Color(255, 255, 255));
        jPanel29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        txtAu.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtAu.setForeground(new java.awt.Color(51, 51, 51));
        txtAu.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtAu.setToolTipText("");
        txtAu.setBorder(null);
        txtAu.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtAuCaretUpdate(evt);
            }
        });

        T9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/triangulo.png"))); // NOI18N
        T9.setToolTipText("");
        T9.setContentAreaFilled(false);
        T9.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        T9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                T9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(txtAu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(T9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtAu, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(T9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(51, 51, 51));
        jLabel24.setText("Edad Gest. (Semanas)");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(51, 51, 51));
        jLabel25.setText("Situación (L/T/NA)");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(51, 51, 51));
        jLabel26.setText("Peso Madre (Kg)");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(51, 51, 51));
        jLabel28.setText("Presentación (C/P/NA)");

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(51, 51, 51));
        jLabel31.setText("Pulso Materno (por min.) ");

        jPanel30.setBackground(new java.awt.Color(255, 255, 255));
        jPanel30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        txtPresentacion.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtPresentacion.setForeground(new java.awt.Color(51, 51, 51));
        txtPresentacion.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtPresentacion.setToolTipText("");
        txtPresentacion.setBorder(null);
        txtPresentacion.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtPresentacionCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(txtPresentacion, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(txtPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel46.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(51, 51, 51));
        jLabel46.setText("Temperatura (ºC)");

        jPanel34.setBackground(new java.awt.Color(255, 255, 255));
        jPanel34.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        txtPm.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtPm.setForeground(new java.awt.Color(51, 51, 51));
        txtPm.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtPm.setToolTipText("");
        txtPm.setBorder(null);
        txtPm.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtPmCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(txtPm)
                .addContainerGap())
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(txtPm, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel47.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(51, 51, 51));
        jLabel47.setText("Presión Arterial (mm.Hg)");

        jPanel35.setBackground(new java.awt.Color(255, 255, 255));
        jPanel35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        txtSituacion.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtSituacion.setForeground(new java.awt.Color(51, 51, 51));
        txtSituacion.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtSituacion.setToolTipText("");
        txtSituacion.setBorder(null);
        txtSituacion.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtSituacionCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(txtSituacion)
                .addContainerGap())
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(txtSituacion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel36.setBackground(new java.awt.Color(255, 255, 255));
        jPanel36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        txtEdad.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtEdad.setForeground(new java.awt.Color(51, 51, 51));
        txtEdad.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtEdad.setToolTipText("");
        txtEdad.setBorder(null);
        txtEdad.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtEdadCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(txtEdad)
                .addContainerGap())
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel48.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(51, 51, 51));
        jLabel48.setText("Posición (D/I/NA)");

        jPanel38.setBackground(new java.awt.Color(255, 255, 255));
        jPanel38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        txtPosicion.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtPosicion.setForeground(new java.awt.Color(51, 51, 51));
        txtPosicion.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtPosicion.setToolTipText("");
        txtPosicion.setBorder(null);
        txtPosicion.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtPosicionCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(txtPosicion)
                .addContainerGap())
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(txtPosicion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel53.setBackground(new java.awt.Color(255, 255, 255));
        jPanel53.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        txtFcf.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtFcf.setForeground(new java.awt.Color(51, 51, 51));
        txtFcf.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtFcf.setToolTipText("");
        txtFcf.setBorder(null);
        txtFcf.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtFcfCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel53Layout = new javax.swing.GroupLayout(jPanel53);
        jPanel53.setLayout(jPanel53Layout);
        jPanel53Layout.setHorizontalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(txtFcf)
                .addContainerGap())
        );
        jPanel53Layout.setVerticalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(txtFcf, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel50.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(51, 51, 51));
        jLabel50.setText("F.C.F. (por min/NA)");

        jPanel54.setBackground(new java.awt.Color(255, 255, 255));
        jPanel54.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        txtMovFetal.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtMovFetal.setForeground(new java.awt.Color(51, 51, 51));
        txtMovFetal.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtMovFetal.setToolTipText("");
        txtMovFetal.setBorder(null);
        txtMovFetal.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtMovFetalCaretUpdate(evt);
            }
        });

        T10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/triangulo.png"))); // NOI18N
        T10.setToolTipText("");
        T10.setContentAreaFilled(false);
        T10.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        T10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                T10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel54Layout = new javax.swing.GroupLayout(jPanel54);
        jPanel54.setLayout(jPanel54Layout);
        jPanel54Layout.setHorizontalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(txtMovFetal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(T10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel54Layout.setVerticalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMovFetal, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(T10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel51.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(51, 51, 51));
        jLabel51.setText("Mov. fetal (+/++/+++/SM/NA)");

        jPanel52.setBackground(new java.awt.Color(255, 255, 255));
        jPanel52.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        txtProteinuria.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtProteinuria.setForeground(new java.awt.Color(51, 51, 51));
        txtProteinuria.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtProteinuria.setToolTipText("");
        txtProteinuria.setBorder(null);
        txtProteinuria.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtProteinuriaCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel52Layout = new javax.swing.GroupLayout(jPanel52);
        jPanel52.setLayout(jPanel52Layout);
        jPanel52Layout.setHorizontalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(txtProteinuria, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel52Layout.setVerticalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(txtProteinuria, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel52.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(51, 51, 51));
        jLabel52.setText("<html>Proteinuria Cualitativa<br>(+/++/+++/NSH)</br></html>");

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                        .addComponent(jPanel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel33Layout.createSequentialGroup()
                        .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel50)
                            .addComponent(jLabel51))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel33Layout.createSequentialGroup()
                        .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel26)
                            .addComponent(jLabel46)
                            .addComponent(jLabel47)
                            .addComponent(jLabel31)
                            .addComponent(jLabel23)
                            .addComponent(jLabel25)
                            .addComponent(jLabel28)
                            .addComponent(jLabel48))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel25)
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel24)
                            .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel46))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel47))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addGap(18, 18, 18)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel48)
                    .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel50)
                    .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel51)
                    .addComponent(jPanel54, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel52, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel51.setBackground(new java.awt.Color(255, 255, 255));

        jLabel49.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(51, 51, 51));
        jLabel49.setText("<html>Indic. Fierro / Ac. Fólico<br>(mayor  o igual a 16 sem)</br></html>");

        jLabel53.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(51, 51, 51));
        jLabel53.setText("Edema (+/++/+++/SE)");

        jLabel54.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(51, 51, 51));
        jLabel54.setText("<html>Reflejo Osteotendinoso<br>(0,+/++/+++)</br></html>");

        jLabel55.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(51, 51, 51));
        jLabel55.setText("<html>Examen de Pezón<br>(Formado/No Form/Sin Exam)</br></html>");

        jPanel55.setBackground(new java.awt.Color(255, 255, 255));
        jPanel55.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        txtEdema.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtEdema.setForeground(new java.awt.Color(51, 51, 51));
        txtEdema.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtEdema.setToolTipText("");
        txtEdema.setBorder(null);
        txtEdema.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtEdemaCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel55Layout = new javax.swing.GroupLayout(jPanel55);
        jPanel55.setLayout(jPanel55Layout);
        jPanel55Layout.setHorizontalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(txtEdema)
                .addContainerGap())
        );
        jPanel55Layout.setVerticalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(txtEdema, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel56.setBackground(new java.awt.Color(255, 255, 255));
        jPanel56.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        txtReflejo.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtReflejo.setForeground(new java.awt.Color(51, 51, 51));
        txtReflejo.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtReflejo.setToolTipText("");
        txtReflejo.setBorder(null);
        txtReflejo.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtReflejoCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel56Layout = new javax.swing.GroupLayout(jPanel56);
        jPanel56.setLayout(jPanel56Layout);
        jPanel56Layout.setHorizontalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel56Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(txtReflejo)
                .addContainerGap())
        );
        jPanel56Layout.setVerticalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel56Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(txtReflejo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel57.setBackground(new java.awt.Color(255, 255, 255));
        jPanel57.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        txtExamenP.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtExamenP.setForeground(new java.awt.Color(51, 51, 51));
        txtExamenP.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtExamenP.setToolTipText("");
        txtExamenP.setBorder(null);
        txtExamenP.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtExamenPCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel57Layout = new javax.swing.GroupLayout(jPanel57);
        jPanel57.setLayout(jPanel57Layout);
        jPanel57Layout.setHorizontalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(txtExamenP)
                .addContainerGap())
        );
        jPanel57Layout.setVerticalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(txtExamenP, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel58.setBackground(new java.awt.Color(255, 255, 255));
        jPanel58.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        txtIndicFierro.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtIndicFierro.setForeground(new java.awt.Color(51, 51, 51));
        txtIndicFierro.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtIndicFierro.setToolTipText("");
        txtIndicFierro.setBorder(null);
        txtIndicFierro.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtIndicFierroCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel58Layout = new javax.swing.GroupLayout(jPanel58);
        jPanel58.setLayout(jPanel58Layout);
        jPanel58Layout.setHorizontalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(txtIndicFierro)
                .addContainerGap())
        );
        jPanel58Layout.setVerticalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(txtIndicFierro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel56.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(51, 51, 51));
        jLabel56.setText("<html>Indicador Calcio<br>(mayor o igual a 20 sem</br></html>)");

        jPanel59.setBackground(new java.awt.Color(255, 255, 255));
        jPanel59.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        txtIndicCalcio.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtIndicCalcio.setForeground(new java.awt.Color(51, 51, 51));
        txtIndicCalcio.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtIndicCalcio.setToolTipText("");
        txtIndicCalcio.setBorder(null);
        txtIndicCalcio.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtIndicCalcioCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel59Layout = new javax.swing.GroupLayout(jPanel59);
        jPanel59.setLayout(jPanel59Layout);
        jPanel59Layout.setHorizontalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(txtIndicCalcio)
                .addContainerGap())
        );
        jPanel59Layout.setVerticalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(txtIndicCalcio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel57.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(51, 51, 51));
        jLabel57.setText("Indic. Ac. Fólico");

        jPanel60.setBackground(new java.awt.Color(255, 255, 255));
        jPanel60.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        txtIndicFolico.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtIndicFolico.setForeground(new java.awt.Color(51, 51, 51));
        txtIndicFolico.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtIndicFolico.setToolTipText("");
        txtIndicFolico.setBorder(null);
        txtIndicFolico.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtIndicFolicoCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel60Layout = new javax.swing.GroupLayout(jPanel60);
        jPanel60.setLayout(jPanel60Layout);
        jPanel60Layout.setHorizontalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel60Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(txtIndicFolico)
                .addContainerGap())
        );
        jPanel60Layout.setVerticalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel60Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(txtIndicFolico, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel67.setBackground(new java.awt.Color(255, 255, 255));
        jPanel67.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        txtOrient.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtOrient.setForeground(new java.awt.Color(51, 51, 51));
        txtOrient.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtOrient.setToolTipText("");
        txtOrient.setBorder(null);
        txtOrient.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtOrientCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel67Layout = new javax.swing.GroupLayout(jPanel67);
        jPanel67.setLayout(jPanel67Layout);
        jPanel67Layout.setHorizontalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel67Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(txtOrient)
                .addContainerGap())
        );
        jPanel67Layout.setVerticalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel67Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(txtOrient, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel63.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(51, 51, 51));
        jLabel63.setText("<html>Orient. Consej. (PF/ITS/Nut/)<br>inm/VIH/TBC/No se hizo/NA</br></html>");

        jLabel59.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(51, 51, 51));
        jLabel59.setText("<html>EG. de ECO. Control<br>(Sem/ No se hizo/NA)</br></html>");

        jPanel62.setBackground(new java.awt.Color(255, 255, 255));
        jPanel62.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        txtEco.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtEco.setForeground(new java.awt.Color(51, 51, 51));
        txtEco.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtEco.setToolTipText("");
        txtEco.setBorder(null);
        txtEco.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtEcoCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel62Layout = new javax.swing.GroupLayout(jPanel62);
        jPanel62.setLayout(jPanel62Layout);
        jPanel62Layout.setHorizontalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel62Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(txtEco)
                .addContainerGap())
        );
        jPanel62Layout.setVerticalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel62Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(txtEco, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel60.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(51, 51, 51));
        jLabel60.setText("<HTML>Perfil Biofisico (4,6,8,10<br>de 10/NSH/NA)");

        jPanel63.setBackground(new java.awt.Color(255, 255, 255));
        jPanel63.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        txtPerfilBiofisico.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtPerfilBiofisico.setForeground(new java.awt.Color(51, 51, 51));
        txtPerfilBiofisico.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtPerfilBiofisico.setToolTipText("");
        txtPerfilBiofisico.setBorder(null);
        txtPerfilBiofisico.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtPerfilBiofisicoCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel63Layout = new javax.swing.GroupLayout(jPanel63);
        jPanel63.setLayout(jPanel63Layout);
        jPanel63Layout.setHorizontalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel63Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(txtPerfilBiofisico)
                .addContainerGap())
        );
        jPanel63Layout.setVerticalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel63Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(txtPerfilBiofisico, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel61.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(51, 51, 51));
        jLabel61.setText("Cita (a/m/d)");

        jPanel64.setBackground(new java.awt.Color(255, 255, 255));
        jPanel64.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        dtCita.setBackground(new java.awt.Color(255, 255, 255));
        dtCita.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout jPanel64Layout = new javax.swing.GroupLayout(jPanel64);
        jPanel64.setLayout(jPanel64Layout);
        jPanel64Layout.setHorizontalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dtCita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel64Layout.setVerticalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dtCita, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        jLabel62.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(51, 51, 51));
        jLabel62.setText("Visita domicil. (Si/No/NA)");

        jPanel65.setBackground(new java.awt.Color(255, 255, 255));
        jPanel65.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        txtVisitDomic.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtVisitDomic.setForeground(new java.awt.Color(51, 51, 51));
        txtVisitDomic.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtVisitDomic.setToolTipText("");
        txtVisitDomic.setBorder(null);
        txtVisitDomic.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtVisitDomicCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel65Layout = new javax.swing.GroupLayout(jPanel65);
        jPanel65.setLayout(jPanel65Layout);
        jPanel65Layout.setHorizontalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel65Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(txtVisitDomic)
                .addContainerGap())
        );
        jPanel65Layout.setVerticalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel65Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(txtVisitDomic, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel58.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(51, 51, 51));
        jLabel58.setText("<html>Plan Parto<br>(Control/Visita/No se Hizo/NA)</br></html>");

        jPanel66.setBackground(new java.awt.Color(255, 255, 255));
        jPanel66.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        txtPlanParto.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtPlanParto.setForeground(new java.awt.Color(51, 51, 51));
        txtPlanParto.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtPlanParto.setToolTipText("");
        txtPlanParto.setBorder(null);
        txtPlanParto.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtPlanPartoCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel66Layout = new javax.swing.GroupLayout(jPanel66);
        jPanel66.setLayout(jPanel66Layout);
        jPanel66Layout.setHorizontalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel66Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(txtPlanParto, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel66Layout.setVerticalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel66Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(txtPlanParto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel51Layout = new javax.swing.GroupLayout(jPanel51);
        jPanel51.setLayout(jPanel51Layout);
        jPanel51Layout.setHorizontalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel53)
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel62)
                    .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel66, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel67, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel51Layout.setVerticalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel53, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel55, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel56, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel57, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel51Layout.createSequentialGroup()
                        .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel57))
                    .addGroup(jPanel51Layout.createSequentialGroup()
                        .addComponent(jPanel58, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel59, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel60, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel67, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel62, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel63, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel64, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel61))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel65, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel62))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel66, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jPanel61.setBackground(new java.awt.Color(255, 255, 255));

        jLabel64.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(51, 51, 51));
        jLabel64.setText("Estab. de la atención");

        jPanel68.setBackground(new java.awt.Color(255, 255, 255));
        jPanel68.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        txtEstabAtencion.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtEstabAtencion.setForeground(new java.awt.Color(51, 51, 51));
        txtEstabAtencion.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtEstabAtencion.setToolTipText("");
        txtEstabAtencion.setBorder(null);
        txtEstabAtencion.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtEstabAtencionCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel68Layout = new javax.swing.GroupLayout(jPanel68);
        jPanel68.setLayout(jPanel68Layout);
        jPanel68Layout.setHorizontalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel68Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(txtEstabAtencion, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel68Layout.setVerticalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel68Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(txtEstabAtencion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel65.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(51, 51, 51));
        jLabel65.setText("Responsable atención");

        jPanel69.setBackground(new java.awt.Color(255, 255, 255));
        jPanel69.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        txtResponAtencion.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtResponAtencion.setForeground(new java.awt.Color(51, 51, 51));
        txtResponAtencion.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtResponAtencion.setToolTipText("");
        txtResponAtencion.setBorder(null);
        txtResponAtencion.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtResponAtencionCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel69Layout = new javax.swing.GroupLayout(jPanel69);
        jPanel69.setLayout(jPanel69Layout);
        jPanel69Layout.setHorizontalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel69Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(txtResponAtencion)
                .addContainerGap())
        );
        jPanel69Layout.setVerticalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel69Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(txtResponAtencion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel66.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(51, 51, 51));
        jLabel66.setText("Nº Formato SIS");

        jPanel70.setBackground(new java.awt.Color(255, 255, 255));
        jPanel70.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        txtFUA.setEditable(false);
        txtFUA.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtFUA.setForeground(new java.awt.Color(51, 51, 51));
        txtFUA.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtFUA.setToolTipText("");
        txtFUA.setBorder(null);
        txtFUA.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtFUACaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel70Layout = new javax.swing.GroupLayout(jPanel70);
        jPanel70.setLayout(jPanel70Layout);
        jPanel70Layout.setHorizontalGroup(
            jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel70Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(txtFUA)
                .addContainerGap())
        );
        jPanel70Layout.setVerticalGroup(
            jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel70Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(txtFUA, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel61Layout = new javax.swing.GroupLayout(jPanel61);
        jPanel61.setLayout(jPanel61Layout);
        jPanel61Layout.setHorizontalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel61Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel66, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                    .addComponent(jLabel65, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                    .addComponent(jLabel64, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel68, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel69, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel70, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel61Layout.setVerticalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel61Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel64)
                    .addComponent(jPanel68, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel65)
                    .addComponent(jPanel69, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel66)
                    .addComponent(jPanel70, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblMant.setForeground(new java.awt.Color(255, 255, 255));
        lblMant.setText("I");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel61, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(lblMant)
                        .addGap(31, 31, 31)
                        .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jPanel61, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblMant)
                                    .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jPanel13.setBackground(new java.awt.Color(102, 102, 102));

        jLabel10.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Atenciones Prenatales");

        lblusu.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        lblusu.setForeground(new java.awt.Color(255, 255, 255));
        lblusu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Usuario-40.png"))); // NOI18N
        lblusu.setText("Silvana");
        lblusu.setFocusable(false);
        lblusu.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(240, 240, 240));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Icon/Guardar-32.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnGuardar.setIconTextGap(30);
        btnGuardar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));

        A3.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout A3Layout = new javax.swing.GroupLayout(A3);
        A3.setLayout(A3Layout);
        A3Layout.setHorizontalGroup(
            A3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        A3Layout.setVerticalGroup(
            A3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lblAtencion3.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        lblAtencion3.setForeground(new java.awt.Color(204, 204, 204));
        lblAtencion3.setText("Atención 3");
        lblAtencion3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAtencion3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAtencion3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblAtencion3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(A3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblAtencion3, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(A3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        jPanel5.setBackground(new java.awt.Color(102, 102, 102));

        A4.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout A4Layout = new javax.swing.GroupLayout(A4);
        A4.setLayout(A4Layout);
        A4Layout.setHorizontalGroup(
            A4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        A4Layout.setVerticalGroup(
            A4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lblAtencion4.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        lblAtencion4.setForeground(new java.awt.Color(204, 204, 204));
        lblAtencion4.setText("Atención 4");
        lblAtencion4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAtencion4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAtencion4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblAtencion4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(A4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblAtencion4, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(A4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        jPanel7.setBackground(new java.awt.Color(102, 102, 102));

        A5.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout A5Layout = new javax.swing.GroupLayout(A5);
        A5.setLayout(A5Layout);
        A5Layout.setHorizontalGroup(
            A5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        A5Layout.setVerticalGroup(
            A5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lblAtencion5.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        lblAtencion5.setForeground(new java.awt.Color(204, 204, 204));
        lblAtencion5.setText("Atención 5");
        lblAtencion5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAtencion5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAtencion5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblAtencion5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(A5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblAtencion5, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(A5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        jPanel8.setBackground(new java.awt.Color(102, 102, 102));

        lblAtencion6.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        lblAtencion6.setForeground(new java.awt.Color(204, 204, 204));
        lblAtencion6.setText("Atención 6");
        lblAtencion6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAtencion6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAtencion6MouseClicked(evt);
            }
        });

        A6.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout A6Layout = new javax.swing.GroupLayout(A6);
        A6.setLayout(A6Layout);
        A6Layout.setHorizontalGroup(
            A6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        A6Layout.setVerticalGroup(
            A6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblAtencion6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(A6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblAtencion6, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(A6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        jPanel9.setBackground(new java.awt.Color(102, 102, 102));

        lblAtencion7.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        lblAtencion7.setForeground(new java.awt.Color(204, 204, 204));
        lblAtencion7.setText("Atención 7");
        lblAtencion7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAtencion7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAtencion7MouseClicked(evt);
            }
        });

        A7.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout A7Layout = new javax.swing.GroupLayout(A7);
        A7.setLayout(A7Layout);
        A7Layout.setHorizontalGroup(
            A7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        A7Layout.setVerticalGroup(
            A7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblAtencion7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(A7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblAtencion7, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(A7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        jPanel10.setBackground(new java.awt.Color(102, 102, 102));

        lblAtencion8.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        lblAtencion8.setForeground(new java.awt.Color(204, 204, 204));
        lblAtencion8.setText("Atención 8");
        lblAtencion8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAtencion8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAtencion8MouseClicked(evt);
            }
        });

        A8.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout A8Layout = new javax.swing.GroupLayout(A8);
        A8.setLayout(A8Layout);
        A8Layout.setHorizontalGroup(
            A8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        A8Layout.setVerticalGroup(
            A8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblAtencion8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(A8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblAtencion8, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(A8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        jPanel12.setBackground(new java.awt.Color(102, 102, 102));

        lblAtencion9.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        lblAtencion9.setForeground(new java.awt.Color(204, 204, 204));
        lblAtencion9.setText("Atención 9");
        lblAtencion9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAtencion9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAtencion9MouseClicked(evt);
            }
        });

        A9.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout A9Layout = new javax.swing.GroupLayout(A9);
        A9.setLayout(A9Layout);
        A9Layout.setHorizontalGroup(
            A9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        A9Layout.setVerticalGroup(
            A9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblAtencion9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(A9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblAtencion9, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(A9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        jPanel6.setBackground(new java.awt.Color(102, 102, 102));

        A1.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout A1Layout = new javax.swing.GroupLayout(A1);
        A1.setLayout(A1Layout);
        A1Layout.setHorizontalGroup(
            A1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        A1Layout.setVerticalGroup(
            A1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lblAtencion1.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        lblAtencion1.setForeground(new java.awt.Color(204, 204, 204));
        lblAtencion1.setText("Atención 1");
        lblAtencion1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAtencion1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAtencion1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblAtencion1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(A1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblAtencion1, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(A1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        jPanel14.setBackground(new java.awt.Color(102, 102, 102));

        A2.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout A2Layout = new javax.swing.GroupLayout(A2);
        A2.setLayout(A2Layout);
        A2Layout.setHorizontalGroup(
            A2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        A2Layout.setVerticalGroup(
            A2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lblAtencion2.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        lblAtencion2.setForeground(new java.awt.Color(204, 204, 204));
        lblAtencion2.setText("Atención 2");
        lblAtencion2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAtencion2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAtencion2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblAtencion2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(A2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblAtencion2, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(A2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        txtPadre16.setEditable(false);
        txtPadre16.setBackground(new java.awt.Color(243, 156, 17));
        txtPadre16.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txtPadre16.setForeground(new java.awt.Color(255, 255, 255));
        txtPadre16.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPadre16.setBorder(null);
        txtPadre16.setPreferredSize(new java.awt.Dimension(18, 18));
        txtPadre16.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtPadre16CaretUpdate(evt);
            }
        });

        txtPadre17.setEditable(false);
        txtPadre17.setBackground(new java.awt.Color(232, 76, 61));
        txtPadre17.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txtPadre17.setForeground(new java.awt.Color(102, 102, 102));
        txtPadre17.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPadre17.setBorder(null);
        txtPadre17.setPreferredSize(new java.awt.Dimension(18, 18));
        txtPadre17.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtPadre17CaretUpdate(evt);
            }
        });

        txtPadre15.setEditable(false);
        txtPadre15.setBackground(new java.awt.Color(241, 197, 14));
        txtPadre15.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txtPadre15.setForeground(new java.awt.Color(241, 197, 14));
        txtPadre15.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPadre15.setBorder(null);
        txtPadre15.setPreferredSize(new java.awt.Dimension(18, 18));
        txtPadre15.setSelectionColor(new java.awt.Color(255, 204, 51));
        txtPadre15.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtPadre15CaretUpdate(evt);
            }
        });

        txtPadre18.setEditable(false);
        txtPadre18.setBackground(new java.awt.Color(50, 151, 219));
        txtPadre18.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txtPadre18.setForeground(new java.awt.Color(102, 102, 102));
        txtPadre18.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPadre18.setBorder(null);
        txtPadre18.setPreferredSize(new java.awt.Dimension(18, 18));
        txtPadre18.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtPadre18CaretUpdate(evt);
            }
        });

        txtPadre19.setEditable(false);
        txtPadre19.setBackground(new java.awt.Color(41, 127, 184));
        txtPadre19.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txtPadre19.setForeground(new java.awt.Color(255, 255, 255));
        txtPadre19.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPadre19.setBorder(null);
        txtPadre19.setPreferredSize(new java.awt.Dimension(18, 18));
        txtPadre19.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtPadre19CaretUpdate(evt);
            }
        });

        txtPadre20.setEditable(false);
        txtPadre20.setBackground(new java.awt.Color(148, 91, 172));
        txtPadre20.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txtPadre20.setForeground(new java.awt.Color(102, 102, 102));
        txtPadre20.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPadre20.setBorder(null);
        txtPadre20.setPreferredSize(new java.awt.Dimension(18, 18));
        txtPadre20.setSelectionColor(new java.awt.Color(255, 204, 51));
        txtPadre20.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtPadre20CaretUpdate(evt);
            }
        });

        txtPadre21.setEditable(false);
        txtPadre21.setBackground(new java.awt.Color(23, 160, 134));
        txtPadre21.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txtPadre21.setForeground(new java.awt.Color(102, 102, 102));
        txtPadre21.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPadre21.setBorder(null);
        txtPadre21.setPreferredSize(new java.awt.Dimension(18, 18));
        txtPadre21.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtPadre21CaretUpdate(evt);
            }
        });

        txtPadre22.setEditable(false);
        txtPadre22.setBackground(new java.awt.Color(39, 174, 97));
        txtPadre22.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txtPadre22.setForeground(new java.awt.Color(255, 255, 255));
        txtPadre22.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPadre22.setBorder(null);
        txtPadre22.setPreferredSize(new java.awt.Dimension(18, 18));
        txtPadre22.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtPadre22CaretUpdate(evt);
            }
        });

        txtPadre23.setEditable(false);
        txtPadre23.setBackground(new java.awt.Color(45, 204, 112));
        txtPadre23.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txtPadre23.setForeground(new java.awt.Color(102, 102, 102));
        txtPadre23.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPadre23.setBorder(null);
        txtPadre23.setPreferredSize(new java.awt.Dimension(18, 18));
        txtPadre23.setSelectionColor(new java.awt.Color(255, 204, 51));
        txtPadre23.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtPadre23CaretUpdate(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("L = Longitudinal");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("T = Transverso");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("C = Cefalica");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setText("P = Pélvica");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 204, 204));
        jLabel14.setText("D = Derecha");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 204, 204));
        jLabel18.setText("I= Izquierda ");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 204, 204));
        jLabel19.setText("SM = Sin Movimiento  ");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(204, 204, 204));
        jLabel20.setText("SE = Sin Edema");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(204, 204, 204));
        jLabel22.setText("SE = Sin Edema");

        txtPadre24.setEditable(false);
        txtPadre24.setBackground(new java.awt.Color(25, 188, 157));
        txtPadre24.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txtPadre24.setForeground(new java.awt.Color(102, 102, 102));
        txtPadre24.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPadre24.setBorder(null);
        txtPadre24.setPreferredSize(new java.awt.Dimension(18, 18));
        txtPadre24.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtPadre24CaretUpdate(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(204, 204, 204));
        jLabel27.setText("NSH = No se Hizo");

        lblIdCp.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblusu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                        .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(txtPadre19, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel14))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(txtPadre18, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel18))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(txtPadre23, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel19))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtPadre15, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtPadre16, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtPadre17, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3)))
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addComponent(txtPadre20, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel12)))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addComponent(txtPadre21, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel22))
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addComponent(txtPadre22, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel20))
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addComponent(txtPadre24, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel27))
                                    .addComponent(lblIdCp, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel10))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPadre15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPadre16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPadre17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPadre22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPadre21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPadre24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIdCp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPadre20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)))
                .addGap(5, 5, 5)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPadre19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(5, 5, 5)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPadre18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(5, 5, 5)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPadre23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblusu)
                .addContainerGap())
        );

        pnlMensaje.setBackground(new java.awt.Color(33, 115, 70));

        lblMensaje.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblMensaje.setForeground(new java.awt.Color(255, 255, 255));
        lblMensaje.setText("Desea Actualizar el Registro ?");

        btnSi.setForeground(new java.awt.Color(240, 240, 240));
        btnSi.setText("Si");
        btnSi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnSi.setContentAreaFilled(false);
        btnSi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSi.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSi.setIconTextGap(30);
        btnSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiActionPerformed(evt);
            }
        });

        btnNo.setForeground(new java.awt.Color(240, 240, 240));
        btnNo.setText("No");
        btnNo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnNo.setContentAreaFilled(false);
        btnNo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNo.setIconTextGap(30);
        btnNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMensajeLayout = new javax.swing.GroupLayout(pnlMensaje);
        pnlMensaje.setLayout(pnlMensajeLayout);
        pnlMensajeLayout.setHorizontalGroup(
            pnlMensajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMensajeLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblMensaje)
                .addGap(46, 46, 46)
                .addComponent(btnSi, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlMensajeLayout.setVerticalGroup(
            pnlMensajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMensajeLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(pnlMensajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMensaje)
                    .addComponent(btnSi, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel16.setBackground(new java.awt.Color(43, 43, 43));
        jPanel16.setPreferredSize(new java.awt.Dimension(1574, 113));

        lblActoMedico.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblActoMedico.setForeground(new java.awt.Color(204, 204, 204));
        lblActoMedico.setText("jLabel1");

        lblFP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFP.setForeground(new java.awt.Color(204, 204, 204));
        lblFP.setText("jLabel1");

        lblActoMedico2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblActoMedico2.setForeground(new java.awt.Color(204, 204, 204));
        lblActoMedico2.setText("Acto Médico");

        lblActoMedico3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblActoMedico3.setForeground(new java.awt.Color(204, 204, 204));
        lblActoMedico3.setText("Forma de Pago");

        lblMadre.setBackground(new java.awt.Color(0, 153, 0));
        lblMadre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblMadre.setForeground(new java.awt.Color(255, 255, 255));
        lblMadre.setText("Martha Arias Torres");
        lblMadre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMadre.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblMadre.setIconTextGap(10);
        lblMadre.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jPanel39.setBackground(new java.awt.Color(39, 174, 97));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Izquierda Filled-30.png"))); // NOI18N
        jLabel32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel32MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel32)
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addContainerGap())
        );

        lblIdActoMedico.setForeground(new java.awt.Color(43, 43, 43));
        lblIdActoMedico.setText("jLabel4");

        LblAtencion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LblAtencion.setForeground(new java.awt.Color(204, 204, 204));
        LblAtencion.setText("Atención");

        lblAtencion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblAtencion.setForeground(new java.awt.Color(204, 204, 204));
        lblAtencion.setText("jLabel1");

        lblFecha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(204, 204, 204));
        lblFecha.setText("Fecha y Hora de Atención");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblMadre, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblActoMedico2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblActoMedico3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LblAtencion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(lblActoMedico)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblIdActoMedico))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblFP)
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addComponent(lblAtencion)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblFecha)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblMadre)
                .addGap(2, 2, 2)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblActoMedico2)
                    .addComponent(lblActoMedico)
                    .addComponent(lblIdActoMedico))
                .addGap(1, 1, 1)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFP)
                    .addComponent(lblActoMedico3))
                .addGap(2, 2, 2)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblAtencion)
                    .addComponent(lblAtencion)
                    .addComponent(lblFecha)))
            .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, 1186, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(pnlMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblAtencion3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAtencion3MouseClicked
        A1.setVisible(false);
        A2.setVisible(false);
        A3.setVisible(true);
        A4.setVisible(false);
        A5.setVisible(false);
        A6.setVisible(false);
        A7.setVisible(false);
        A8.setVisible(false);
        A9.setVisible(false);
        lblAtencion.setText("3");
        validaAtencionPrenatal(lblIdCp.getText(), lblAtencion.getText());
        if(lblId.getText().equals("")){
            lblActoMedico.setText(RegistroEmbarazoPrincipal.lblActoMedico.getText());
            lblIdActoMedico.setText(RegistroEmbarazoPrincipal.lblIdActoMedico.getText());
            RegistroEmbarazoAtencionesP.txtFUA.setText(lblFua.getText());
        }
        dtCita.setEnabled(true);
    }//GEN-LAST:event_lblAtencion3MouseClicked

    private void lblAtencion4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAtencion4MouseClicked
        A1.setVisible(false);
        A2.setVisible(false);
        A3.setVisible(false);
        A4.setVisible(true);
        A5.setVisible(false);
        A6.setVisible(false);
        A7.setVisible(false);
        A8.setVisible(false);
        A9.setVisible(false);
        lblAtencion.setText("4");
        validaAtencionPrenatal(lblIdCp.getText(), lblAtencion.getText());
        if(lblId.getText().equals("")){
            lblActoMedico.setText(RegistroEmbarazoPrincipal.lblActoMedico.getText());
            lblIdActoMedico.setText(RegistroEmbarazoPrincipal.lblIdActoMedico.getText());
            RegistroEmbarazoAtencionesP.txtFUA.setText(lblFua.getText());
        }
        dtCita.setEnabled(true);
        pnlMensaje.setVisible(false);
    }//GEN-LAST:event_lblAtencion4MouseClicked

    private void lblAtencion5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAtencion5MouseClicked
        A1.setVisible(false);
        A2.setVisible(false);
        A3.setVisible(false);
        A4.setVisible(false);
        A5.setVisible(true);
        A6.setVisible(false);
        A7.setVisible(false);
        A8.setVisible(false);
        A9.setVisible(false);
        lblAtencion.setText("5");
        validaAtencionPrenatal(lblIdCp.getText(), lblAtencion.getText());
        if(lblId.getText().equals("")){
            lblActoMedico.setText(RegistroEmbarazoPrincipal.lblActoMedico.getText());
            lblIdActoMedico.setText(RegistroEmbarazoPrincipal.lblIdActoMedico.getText());
            RegistroEmbarazoAtencionesP.txtFUA.setText(lblFua.getText());
        }
        dtCita.setEnabled(true);
        pnlMensaje.setVisible(false);
    }//GEN-LAST:event_lblAtencion5MouseClicked

    private void lblAtencion6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAtencion6MouseClicked
        A1.setVisible(false);
        A2.setVisible(false);
        A3.setVisible(false);
        A4.setVisible(false);
        A5.setVisible(false);
        A6.setVisible(true);
        A7.setVisible(false);
        A8.setVisible(false);
        A9.setVisible(false);
        lblAtencion.setText("6");
        validaAtencionPrenatal(lblIdCp.getText(), lblAtencion.getText());
        if(lblId.getText().equals("")){
            lblActoMedico.setText(RegistroEmbarazoPrincipal.lblActoMedico.getText());
            lblIdActoMedico.setText(RegistroEmbarazoPrincipal.lblIdActoMedico.getText());
            RegistroEmbarazoAtencionesP.txtFUA.setText(lblFua.getText());
        }
        dtCita.setEnabled(true);
        pnlMensaje.setVisible(false);
    }//GEN-LAST:event_lblAtencion6MouseClicked

    private void lblAtencion7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAtencion7MouseClicked
        A1.setVisible(false);
        A2.setVisible(false);
        A3.setVisible(false);
        A4.setVisible(false);
        A5.setVisible(false);
        A6.setVisible(false);
        A7.setVisible(true );
        A8.setVisible(false);
        A9.setVisible(false);
        lblAtencion.setText("7");
        validaAtencionPrenatal(lblIdCp.getText(), lblAtencion.getText());
        if(lblId.getText().equals("")){
            lblActoMedico.setText(RegistroEmbarazoPrincipal.lblActoMedico.getText());
            lblIdActoMedico.setText(RegistroEmbarazoPrincipal.lblIdActoMedico.getText());
            RegistroEmbarazoAtencionesP.txtFUA.setText(lblFua.getText());
        }
        dtCita.setEnabled(true);
        pnlMensaje.setVisible(false);
    }//GEN-LAST:event_lblAtencion7MouseClicked

    private void lblAtencion8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAtencion8MouseClicked
        A1.setVisible(false);
        A2.setVisible(false);
        A3.setVisible(false);
        A4.setVisible(false);
        A5.setVisible(false);
        A6.setVisible(false);
        A7.setVisible(false);
        A8.setVisible(true);
        A9.setVisible(false);
        lblAtencion.setText("8");
        validaAtencionPrenatal(lblIdCp.getText(), lblAtencion.getText());
        if(lblId.getText().equals("")){
            lblActoMedico.setText(RegistroEmbarazoPrincipal.lblActoMedico.getText());
            lblIdActoMedico.setText(RegistroEmbarazoPrincipal.lblIdActoMedico.getText());
            RegistroEmbarazoAtencionesP.txtFUA.setText(lblFua.getText());
        }
        dtCita.setEnabled(true);
        pnlMensaje.setVisible(false);
    }//GEN-LAST:event_lblAtencion8MouseClicked

    private void lblAtencion9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAtencion9MouseClicked
        A1.setVisible(false);
        A2.setVisible(false);
        A3.setVisible(false);
        A4.setVisible(false);
        A5.setVisible(false);
        A6.setVisible(false);
        A7.setVisible(false);
        A8.setVisible(false);
        A9.setVisible(true);
        lblAtencion.setText("9");
        validaAtencionPrenatal(lblIdCp.getText(), lblAtencion.getText());
        if(lblId.getText().equals("")){
            lblActoMedico.setText(RegistroEmbarazoPrincipal.lblActoMedico.getText());
            lblIdActoMedico.setText(RegistroEmbarazoPrincipal.lblIdActoMedico.getText());
            RegistroEmbarazoAtencionesP.txtFUA.setText(lblFua.getText());
        }
        dtCita.setEnabled(false);
        pnlMensaje.setVisible(false);
    }//GEN-LAST:event_lblAtencion9MouseClicked

    private void txtPesoMadreCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtPesoMadreCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesoMadreCaretUpdate

    private void T7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_T7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_T7ActionPerformed

    private void txtPACaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtPACaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPACaretUpdate

    private void T8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_T8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_T8ActionPerformed

    private void txtTempCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTempCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTempCaretUpdate

    private void txtAuCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtAuCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAuCaretUpdate

    private void T9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_T9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_T9ActionPerformed

    private void txtPresentacionCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtPresentacionCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPresentacionCaretUpdate

    private void txtPmCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtPmCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPmCaretUpdate

    private void txtSituacionCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtSituacionCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSituacionCaretUpdate

    private void txtEdadCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtEdadCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdadCaretUpdate

    private void txtPosicionCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtPosicionCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPosicionCaretUpdate

    private void txtProteinuriaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtProteinuriaCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProteinuriaCaretUpdate

    private void txtFcfCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtFcfCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFcfCaretUpdate

    private void txtMovFetalCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtMovFetalCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMovFetalCaretUpdate

    private void T10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_T10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_T10ActionPerformed

    private void txtEdemaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtEdemaCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdemaCaretUpdate

    private void txtReflejoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtReflejoCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtReflejoCaretUpdate

    private void txtExamenPCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtExamenPCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtExamenPCaretUpdate

    private void txtIndicFierroCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtIndicFierroCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIndicFierroCaretUpdate

    private void txtIndicCalcioCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtIndicCalcioCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIndicCalcioCaretUpdate

    private void txtIndicFolicoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtIndicFolicoCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIndicFolicoCaretUpdate

    private void txtEcoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtEcoCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEcoCaretUpdate

    private void txtPerfilBiofisicoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtPerfilBiofisicoCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPerfilBiofisicoCaretUpdate

    private void txtVisitDomicCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtVisitDomicCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVisitDomicCaretUpdate

    private void txtPlanPartoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtPlanPartoCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPlanPartoCaretUpdate

    private void txtOrientCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtOrientCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOrientCaretUpdate

    private void txtEstabAtencionCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtEstabAtencionCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstabAtencionCaretUpdate

    private void txtResponAtencionCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtResponAtencionCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtResponAtencionCaretUpdate

    private void txtFUACaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtFUACaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFUACaretUpdate

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(lblAtencion.getText().equals("1") || lblAtencion.getText().equals("2") ||
           lblAtencion.getText().equals("3") || lblAtencion.getText().equals("4") ||
           lblAtencion.getText().equals("5") || lblAtencion.getText().equals("6") ||
           lblAtencion.getText().equals("7") || lblAtencion.getText().equals("8")){
            if(determinarFecha(dtCita).equals(fechaActual())){
                pnlMensaje.setVisible(true);
                lblMensaje.setText("Seleccione una fecha correcta");
                btnSi.setVisible(false);
                btnNo.setVisible(false);
                pnlMensaje.setBackground(new Color(255,91,70));
            } else
            if(txtPesoMadre.getText().equals("")){
                pnlMensaje.setVisible(true);
                lblMensaje.setText("Ingrese el peso de la madre");
                btnSi.setVisible(false);
                btnNo.setVisible(false);
                pnlMensaje.setBackground(new Color(255,91,70));
            } else 
            if(txtPA.getText().equals("")){
                pnlMensaje.setVisible(true);
                lblMensaje.setText("Ingrese la presión arterial");
                btnSi.setVisible(false);
                btnNo.setVisible(false);
                pnlMensaje.setBackground(new Color(255,91,70));
            } else 
            if(txtAu.getText().equals("")){
                pnlMensaje.setVisible(true);
                lblMensaje.setText("Ingrese la altura uterina");
                btnSi.setVisible(false);
                btnNo.setVisible(false);
                pnlMensaje.setBackground(new Color(255,91,70));
            } else 
            if(txtMovFetal.getText().equals("")){
                pnlMensaje.setVisible(true);
                lblMensaje.setText("Ingrese el movimiento fetal");
                btnSi.setVisible(false);
                btnNo.setVisible(false);
                pnlMensaje.setBackground(new Color(255,91,70));
            } else 
            if(dtCita.getDate()==null){
                    pnlMensaje.setVisible(true);
                    lblMensaje.setText("Ingrese la fecha de la siguiente cita");
                    btnSi.setVisible(false);
                    btnNo.setVisible(false);
                    pnlMensaje.setBackground(new Color(255,91,70));
            } else
            if(lblMant.getText().equals("I")){
//                lblMensaje.setText("¿Guardar los datos?");
//                pnlMensaje.setVisible(true);
//                btnSi.setText("Si");
//                btnSi.setVisible(true);
//                btnNo.setVisible(true);
//                pnlMensaje.setBackground(new Color(255,153,51));
                mantenimientoAtencionPrenatal();
            } else
            if(lblMant.getText().equals("U")){
//                lblMensaje.setText("¿Modificar los datos?");
//                pnlMensaje.setVisible(true);
//                btnSi.setText("Si");
//                btnSi.setVisible(true);
//                btnNo.setVisible(true);
//                pnlMensaje.setBackground(new Color(255,153,51));
                mantenimientoAtencionPrenatal();
            }
        }else{
            if(determinarFecha(dtCita).equals(fechaActual())){
                pnlMensaje.setVisible(true);
                lblMensaje.setText("Seleccione una fecha correcta");
                btnSi.setVisible(false);
                btnNo.setVisible(false);
                pnlMensaje.setBackground(new Color(255,91,70));
            } else
            if(txtPesoMadre.getText().equals("")){
                pnlMensaje.setVisible(true);
                lblMensaje.setText("Ingrese el peso de la madre");
                btnSi.setVisible(false);
                btnNo.setVisible(false);
                pnlMensaje.setBackground(new Color(255,91,70));
            } else 
            if(txtPA.getText().equals("")){
                pnlMensaje.setVisible(true);
                lblMensaje.setText("Ingrese la presión arterial");
                btnSi.setVisible(false);
                btnNo.setVisible(false);
                pnlMensaje.setBackground(new Color(255,91,70));
            } else 
            if(txtAu.getText().equals("")){
                pnlMensaje.setVisible(true);
                lblMensaje.setText("Ingrese la altura uterina");
                btnSi.setVisible(false);
                btnNo.setVisible(false);
                pnlMensaje.setBackground(new Color(255,91,70));
            } else 
            if(txtMovFetal.getText().equals("")){
                pnlMensaje.setVisible(true);
                lblMensaje.setText("Ingrese el movimiento fetal");
                btnSi.setVisible(false);
                btnNo.setVisible(false);
                pnlMensaje.setBackground(new Color(255,91,70));
            } else 
            if(dtCita.getDate()==null){
                    pnlMensaje.setVisible(true);
                    lblMensaje.setText("Ingrese la fecha de la siguiente cita");
                    btnSi.setVisible(false);
                    btnNo.setVisible(false);
                    pnlMensaje.setBackground(new Color(255,91,70));
            } else
            if(lblMant.getText().equals("I")){
                lblMensaje.setText("¿Guardar los datos?");
                pnlMensaje.setVisible(true);
                btnSi.setText("Si");
                btnSi.setVisible(true);
                btnNo.setVisible(true);
                pnlMensaje.setBackground(new Color(255,153,51));
            } else
            if(lblMant.getText().equals("U")){
                lblMensaje.setText("¿Modificar los datos?");
                pnlMensaje.setVisible(true);
                btnSi.setText("Si");
                btnSi.setVisible(true);
                btnNo.setVisible(true);
                pnlMensaje.setBackground(new Color(255,153,51));
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void lblAtencion1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAtencion1MouseClicked
        A1.setVisible(true);
        A2.setVisible(false);
        A3.setVisible(false);
        A4.setVisible(false);
        A5.setVisible(false);
        A6.setVisible(false);
        A7.setVisible(false);
        A8.setVisible(false);
        A9.setVisible(false);
        lblAtencion.setText("1");
        validaAtencionPrenatal(lblIdCp.getText(), "1");
        if(lblId.getText().equals("")){
            lblActoMedico.setText(RegistroEmbarazoPrincipal.lblActoMedico.getText());
            lblIdActoMedico.setText(RegistroEmbarazoPrincipal.lblIdActoMedico.getText());
            RegistroEmbarazoAtencionesP.txtFUA.setText(lblFua.getText());
        }
        dtCita.setEnabled(true);
        pnlMensaje.setVisible(false);
    }//GEN-LAST:event_lblAtencion1MouseClicked

    private void lblAtencion2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAtencion2MouseClicked
        A1.setVisible(false);
        A2.setVisible(true);
        A3.setVisible(false);
        A4.setVisible(false);
        A5.setVisible(false);
        A6.setVisible(false);
        A7.setVisible(false);
        A8.setVisible(false);
        A9.setVisible(false);
        lblAtencion.setText("2");
        validaAtencionPrenatal(lblIdCp.getText(), "2");
        if(lblId.getText().equals("")){
            lblActoMedico.setText(RegistroEmbarazoPrincipal.lblActoMedico.getText());
            lblIdActoMedico.setText(RegistroEmbarazoPrincipal.lblIdActoMedico.getText());
            RegistroEmbarazoAtencionesP.txtFUA.setText(lblFua.getText());
        }
        dtCita.setEnabled(true);
        pnlMensaje.setVisible(false);
    }//GEN-LAST:event_lblAtencion2MouseClicked

    private void txtPadre16CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtPadre16CaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPadre16CaretUpdate

    private void txtPadre17CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtPadre17CaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPadre17CaretUpdate

    private void txtPadre15CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtPadre15CaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPadre15CaretUpdate

    private void txtPadre18CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtPadre18CaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPadre18CaretUpdate

    private void txtPadre19CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtPadre19CaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPadre19CaretUpdate

    private void txtPadre20CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtPadre20CaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPadre20CaretUpdate

    private void txtPadre21CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtPadre21CaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPadre21CaretUpdate

    private void txtPadre22CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtPadre22CaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPadre22CaretUpdate

    private void txtPadre23CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtPadre23CaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPadre23CaretUpdate

    private void txtPadre24CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtPadre24CaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPadre24CaretUpdate

    private void btnSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiActionPerformed
//        if(btnSi.getText().equals("Si")){ // Al guardar
//            mantenimientoAtencionPrenatal();
//        } else
        if(btnSi.getText().equals("OK")){ // Al hacer OK hacerloinvisible
            pnlMensaje.setVisible(false);
        }
    }//GEN-LAST:event_btnSiActionPerformed

    private void btnNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoActionPerformed
        pnlMensaje.setVisible(false);
    }//GEN-LAST:event_btnNoActionPerformed

    private void jLabel32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MouseClicked
        RegistroEmbarazo.jTabbedPane1.setSelectedIndex(1);
        this.dispose();
    }//GEN-LAST:event_jLabel32MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel A1;
    private javax.swing.JPanel A2;
    private javax.swing.JPanel A3;
    private javax.swing.JPanel A4;
    private javax.swing.JPanel A5;
    private javax.swing.JPanel A6;
    private javax.swing.JPanel A7;
    private javax.swing.JPanel A8;
    private javax.swing.JPanel A9;
    public static javax.swing.JLabel LblAtencion;
    private javax.swing.JButton T10;
    private javax.swing.JButton T7;
    private javax.swing.JButton T8;
    private javax.swing.JButton T9;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNo;
    private javax.swing.JButton btnSi;
    public static com.toedter.calendar.JDateChooser dtCita;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel64;
    private javax.swing.JPanel jPanel65;
    private javax.swing.JPanel jPanel66;
    private javax.swing.JPanel jPanel67;
    private javax.swing.JPanel jPanel68;
    private javax.swing.JPanel jPanel69;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel70;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    public static javax.swing.JLabel lblActoMedico;
    public static javax.swing.JLabel lblActoMedico2;
    public static javax.swing.JLabel lblActoMedico3;
    public static javax.swing.JLabel lblAtencion;
    private javax.swing.JLabel lblAtencion1;
    private javax.swing.JLabel lblAtencion2;
    private javax.swing.JLabel lblAtencion3;
    private javax.swing.JLabel lblAtencion4;
    private javax.swing.JLabel lblAtencion5;
    private javax.swing.JLabel lblAtencion6;
    private javax.swing.JLabel lblAtencion7;
    private javax.swing.JLabel lblAtencion8;
    private javax.swing.JLabel lblAtencion9;
    public static javax.swing.JLabel lblFP;
    private javax.swing.JLabel lblFecha;
    public static javax.swing.JLabel lblId;
    public static javax.swing.JLabel lblIdActoMedico;
    public static javax.swing.JLabel lblIdCp;
    public static javax.swing.JLabel lblMadre;
    public static javax.swing.JLabel lblMant;
    private javax.swing.JLabel lblMensaje;
    public static javax.swing.JLabel lblusu;
    private javax.swing.JPanel pnlMensaje;
    public static javax.swing.JTextField txtAu;
    public static javax.swing.JTextField txtEco;
    public static javax.swing.JTextField txtEdad;
    public static javax.swing.JTextField txtEdema;
    public static javax.swing.JTextField txtEstabAtencion;
    public static javax.swing.JTextField txtExamenP;
    public static javax.swing.JTextField txtFUA;
    public static javax.swing.JTextField txtFcf;
    public static javax.swing.JTextField txtIndicCalcio;
    public static javax.swing.JTextField txtIndicFierro;
    public static javax.swing.JTextField txtIndicFolico;
    public static javax.swing.JTextField txtMovFetal;
    public static javax.swing.JTextField txtOrient;
    public static javax.swing.JTextField txtPA;
    public static javax.swing.JTextField txtPadre15;
    public static javax.swing.JTextField txtPadre16;
    public static javax.swing.JTextField txtPadre17;
    public static javax.swing.JTextField txtPadre18;
    public static javax.swing.JTextField txtPadre19;
    public static javax.swing.JTextField txtPadre20;
    public static javax.swing.JTextField txtPadre21;
    public static javax.swing.JTextField txtPadre22;
    public static javax.swing.JTextField txtPadre23;
    public static javax.swing.JTextField txtPadre24;
    public static javax.swing.JTextField txtPerfilBiofisico;
    public static javax.swing.JTextField txtPesoMadre;
    public static javax.swing.JTextField txtPlanParto;
    public static javax.swing.JTextField txtPm;
    public static javax.swing.JTextField txtPosicion;
    public static javax.swing.JTextField txtPresentacion;
    public static javax.swing.JTextField txtProteinuria;
    public static javax.swing.JTextField txtReflejo;
    public static javax.swing.JTextField txtResponAtencion;
    public static javax.swing.JTextField txtSituacion;
    public static javax.swing.JTextField txtTemp;
    public static javax.swing.JTextField txtVisitDomic;
    // End of variables declaration//GEN-END:variables
}
