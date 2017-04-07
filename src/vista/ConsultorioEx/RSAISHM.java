/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.ConsultorioEx;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelos.ConsultorioEx.ConsultorioExtRsSuplementacionHierro;
import static vista.ConsultorioEx.RSAICCD.lblId;

/**
 *
 * @author MYS1
 */
public class RSAISHM extends javax.swing.JInternalFrame {
private JComponent Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
private Dimension DimensionBarra = null;
byte tg;
byte tge;
JDateChooser fecha;
JTextField fua;
JLabel cie10;
ConsultorioExtRsSuplementacionHierro SHM01 = new ConsultorioExtRsSuplementacionHierro();
    /**
     * Creates new form RSAIDN
     */
    public RSAISHM() {
        initComponents();
        QuitarLaBarraTitulo();
        mensaje.setVisible(false);
        habilitarDatos(false);
    }
    public void QuitarLaBarraTitulo() // ocultar borde de fomrulario interno
    { 
        Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane(); 
        DimensionBarra = Barra.getPreferredSize(); 
        Barra.setSize(0,0); 
        Barra.setPreferredSize(new Dimension(0,0)); 
        repaint(); 
    }
    
     public void habilitarRadio(boolean opcion){
        rbt1.setEnabled(opcion);
        rbt2.setEnabled(opcion);
        rbt3.setEnabled(opcion);
        rbt4.setEnabled(opcion);
        rbt5.setEnabled(opcion);
        rbt6.setEnabled(opcion);
        rbt7.setEnabled(opcion);
        rbt8.setEnabled(opcion);
        rbt9.setEnabled(opcion);
        rbt10.setEnabled(opcion);
        rbt13.setEnabled(opcion);
        rbt14.setEnabled(opcion);
      
     }
     
     public void habilitarDatos(boolean opcion){
      FDN1.setEnabled(opcion);  
      FDN2.setEnabled(opcion);  
      FDN3.setEnabled(opcion);  
      FDN4.setEnabled(opcion);  
      FDN5.setEnabled(opcion);  
      FDN6.setEnabled(opcion);  
      FDN7.setEnabled(opcion);  
      FDN8.setEnabled(opcion);  
      FDN9.setEnabled(opcion);  
      FDN10.setEnabled(opcion); 
      FDN11.setEnabled(opcion);
      FDN12.setEnabled(opcion);
      
      FUADN1.setEnabled(opcion);
      FUADN2.setEnabled(opcion);
      FUADN3.setEnabled(opcion);
      FUADN4.setEnabled(opcion);
      FUADN5.setEnabled(opcion);
      FUADN6.setEnabled(opcion);
      FUADN7.setEnabled(opcion);
      FUADN8.setEnabled(opcion);   
      FUADN9.setEnabled(opcion);
      FUADN10.setEnabled(opcion);
      FUADN11.setEnabled(opcion);   
      FUADN12.setEnabled(opcion);
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
                           mensaje.setVisible(true);
                           mensaje.setBackground(new Color(255,91,70)); 
                           men.setText("Ingrese una fecha correcta");
                           b.setVisible(false);
                           b1.setVisible(false); 
         }
        
        return fecha;
    }
    public void Botones(boolean opcion){
        btnGuardar.setEnabled(opcion);
        btnEditar.setEnabled(opcion);
        btnCancelar.setEnabled(opcion);
    }
    public void validaRegistro(int rs_id){
        try {
            PreparedStatement cmd = SHM01.getCn().prepareStatement("SELECT RS_ID FROM CONSULTORIO_EXT_RS_SUPLEMENTACION_HIERRO WHERE RS_ID ='"+rs_id+"'");
            ResultSet res = cmd.executeQuery();
            if(res.next()){ // si existe
                Modificar(fecha);
            }else { // no existe
                Guardar(fecha);
            }
        } catch (Exception e) {
        mensaje.setVisible(true);
        mensaje.setBackground(new Color(255,91,70)); 
        men.setText("Ocurrió un error, Verifique");
        b.setVisible(false);
        b1.setVisible(false);
        }
    }
    public void Modificar(JDateChooser fecha){
    if(fecha.getDate()==null){
        fecha.setEnabled(true);
        //fua.setEnabled(true);
        mensaje.setVisible(true);
        mensaje.setBackground(new Color(255,91,70)); 
        men.setText("Ingrese una fecha valida");
        b.setVisible(false);
        b1.setVisible(false);
    } else {
        ConsultorioExtRsSuplementacionHierro CXRsSHM = new ConsultorioExtRsSuplementacionHierro();
        ConsultorioExtRsSuplementacionHierro CXRsSHM2 = new ConsultorioExtRsSuplementacionHierro();
        try {
    
            CXRsSHM.setRsId(Integer.parseInt(lblId.getText()));
            
            if(FDN1.getDate()!=null){
                CXRsSHM.setM1Fecha(determinarFecha(FDN1));  
                CXRsSHM.setM1Fua(FUADN1.getText());
             }
            
            if(FDN2.getDate()!=null){
                CXRsSHM.setM2Fecha(determinarFecha(FDN2));  
                CXRsSHM.setM2Fua(FUADN2.getText());
             }
            
            if(FDN3.getDate()!=null){
                CXRsSHM.setM3Fecha(determinarFecha(FDN3));  
                CXRsSHM.setM3Fua(FUADN3.getText());
             }
            
            if(FDN4.getDate()!=null){
                CXRsSHM.setM4Fecha(determinarFecha(FDN4));  
                CXRsSHM.setM4Fua(FUADN4.getText());
             }
            
            if(FDN5.getDate()!=null){
                CXRsSHM.setM5Fecha(determinarFecha(FDN5));  
                CXRsSHM.setM5Fua(FUADN5.getText());
             }
            
            if(FDN6.getDate()!=null){
                CXRsSHM.setM6Fecha(determinarFecha(FDN6));  
                CXRsSHM.setM6Fua(FUADN6.getText());
             }
            if(FDN7.getDate()!=null){
                CXRsSHM.setM7Fecha(determinarFecha(FDN7));  
                CXRsSHM.setM7Fua(FUADN7.getText());
             }
            
            if(FDN8.getDate()!=null){
                CXRsSHM.setM8Fecha(determinarFecha(FDN8));  
                CXRsSHM.setM8Fua(FUADN8.getText());
             }
            
            if(FDN9.getDate()!=null){
                CXRsSHM.setM9Fecha(determinarFecha(FDN9));  
                CXRsSHM.setM9Fua(FUADN9.getText());
             }
            
            if(FDN10.getDate()!=null){
                CXRsSHM.setM10Fecha(determinarFecha(FDN10));  
                CXRsSHM.setM10Fua(FUADN10.getText());
             }
            
            if(FDN11.getDate()!=null){
                CXRsSHM.setM11Fecha(determinarFecha(FDN11));  
                CXRsSHM.setM11Fua(FUADN11.getText());
             }
            
            if(FDN12.getDate()!=null){
                CXRsSHM.setM12Fecha(determinarFecha(FDN12));  
                CXRsSHM.setM12Fua(FUADN12.getText());
             }
            
            
            if(CXRsSHM.mantenimientoRSAISHM("U")==true){
                mensaje.setVisible(true);
                mensaje.setBackground(new Color(33,115,70)); 
                men.setText("Datos Actualizados de forma correcta");
                b.setText("OK");
                b.setVisible(true);
                b1.setVisible(false);
                btnGuardar.setEnabled(false);
                tge=1;
                CXRsSHM2.ConsultoriosExtSHMListar(Integer.parseInt(lblId.getText()));

                habilitarDatos(false);
                habilitarRadio(true);
            }else {
                mensaje.setVisible(true);
                mensaje.setBackground(new Color(255,91,70)); 
                men.setText("Ocurrio un error, Verifique");
                b.setVisible(false);
                b1.setVisible(false);
                tge=5;
            }  

            } catch (Exception e) {
               System.out.println("Error: modificar " + e.getMessage());
            }
        }
    }
    public void Guardar(JDateChooser fecha){
        if(fecha.getDate()==null){
            mensaje.setVisible(true);
            mensaje.setBackground(new Color(255,91,70)); 
            men.setText("Ingrese una fecha valida");
            b.setVisible(false);
            b1.setVisible(false);
        } else {
        ConsultorioExtRsSuplementacionHierro CXRsSHM = new ConsultorioExtRsSuplementacionHierro();
        ConsultorioExtRsSuplementacionHierro CXRsSHM2 = new ConsultorioExtRsSuplementacionHierro();
        try {
    
            CXRsSHM.setRsId(Integer.parseInt(lblId.getText()));
            
            if(FDN1.getDate()!=null){
                CXRsSHM.setM1Fecha(determinarFecha(FDN1));  
                CXRsSHM.setM1Fua(FUADN1.getText());
             }
            
            if(FDN2.getDate()!=null){
                CXRsSHM.setM2Fecha(determinarFecha(FDN2));  
                CXRsSHM.setM2Fua(FUADN2.getText());
             }
            
            if(FDN3.getDate()!=null){
                CXRsSHM.setM3Fecha(determinarFecha(FDN3));  
                CXRsSHM.setM3Fua(FUADN3.getText());
             }
            
            if(FDN4.getDate()!=null){
                CXRsSHM.setM4Fecha(determinarFecha(FDN4));  
                CXRsSHM.setM4Fua(FUADN4.getText());
             }
            
            if(FDN5.getDate()!=null){
                CXRsSHM.setM5Fecha(determinarFecha(FDN5));  
                CXRsSHM.setM5Fua(FUADN5.getText());
             }
            
            if(FDN6.getDate()!=null){
                CXRsSHM.setM6Fecha(determinarFecha(FDN6));  
                CXRsSHM.setM6Fua(FUADN6.getText());
             }
            if(FDN7.getDate()!=null){
                CXRsSHM.setM7Fecha(determinarFecha(FDN7));  
                CXRsSHM.setM7Fua(FUADN7.getText());
             }
            
            if(FDN8.getDate()!=null){
                CXRsSHM.setM8Fecha(determinarFecha(FDN8));  
                CXRsSHM.setM8Fua(FUADN8.getText());
             }
            
            if(FDN9.getDate()!=null){
                CXRsSHM.setM9Fecha(determinarFecha(FDN9));  
                CXRsSHM.setM9Fua(FUADN9.getText());
             }
            
            if(FDN10.getDate()!=null){
                CXRsSHM.setM10Fecha(determinarFecha(FDN10));  
                CXRsSHM.setM10Fua(FUADN10.getText());
             }
            
            if(FDN11.getDate()!=null){
                CXRsSHM.setM11Fecha(determinarFecha(FDN11));  
                CXRsSHM.setM11Fua(FUADN11.getText());
             }
            
            if(FDN12.getDate()!=null){
                CXRsSHM.setM12Fecha(determinarFecha(FDN12));  
                CXRsSHM.setM12Fua(FUADN12.getText());
             }    
        if(CXRsSHM.mantenimientoRSAISHM("I")==true){
                mensaje.setVisible(true);
                mensaje.setBackground(new Color(33,115,70)); 
                men.setText("Datos Guardados de forma correcta");
                b.setText("OK");
                b.setVisible(true);
                b1.setVisible(false);

                btnGuardar.setEnabled(false);
                tge=1;

                CXRsSHM.ConsultoriosExtSHMListar(Integer.parseInt(lblId.getText()));


                habilitarDatos(false);
                habilitarRadio(true);
            }else {

                    mensaje.setVisible(true);
                    mensaje.setBackground(new Color(255,91,70)); 
                    men.setText("Ocurrio un error, Verifique");
                    b.setVisible(false);
                    b1.setVisible(false);
                    tge=7;
            }  
         } catch (Exception e) {
            System.out.println("Error: guardar " + e.getMessage());
        }
    }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        DN = new javax.swing.JPanel();
        jPanel202 = new javax.swing.JPanel();
        jLabel126 = new javax.swing.JLabel();
        jPanel203 = new javax.swing.JPanel();
        jLabel127 = new javax.swing.JLabel();
        CCDM13 = new javax.swing.JPanel();
        jPanel134 = new javax.swing.JPanel();
        FDN1 = new com.toedter.calendar.JDateChooser();
        rbt1 = new javax.swing.JRadioButton();
        jPanel135 = new javax.swing.JPanel();
        FDN2 = new com.toedter.calendar.JDateChooser();
        rbt2 = new javax.swing.JRadioButton();
        jPanel136 = new javax.swing.JPanel();
        FDN3 = new com.toedter.calendar.JDateChooser();
        rbt3 = new javax.swing.JRadioButton();
        FUADN3 = new javax.swing.JTextField();
        FUADN1 = new javax.swing.JTextField();
        FUADN2 = new javax.swing.JTextField();
        jPanel137 = new javax.swing.JPanel();
        FDN4 = new com.toedter.calendar.JDateChooser();
        rbt4 = new javax.swing.JRadioButton();
        FUADN4 = new javax.swing.JTextField();
        jPanel138 = new javax.swing.JPanel();
        FDN5 = new com.toedter.calendar.JDateChooser();
        rbt5 = new javax.swing.JRadioButton();
        FUADN5 = new javax.swing.JTextField();
        jPanel139 = new javax.swing.JPanel();
        FDN6 = new com.toedter.calendar.JDateChooser();
        rbt6 = new javax.swing.JRadioButton();
        FUADN6 = new javax.swing.JTextField();
        LEYENDA2 = new javax.swing.JPanel();
        jPanel141 = new javax.swing.JPanel();
        jLabel137 = new javax.swing.JLabel();
        jPanel144 = new javax.swing.JPanel();
        jLabel139 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        CCDR3A2 = new javax.swing.JPanel();
        jPanel130 = new javax.swing.JPanel();
        FDN7 = new com.toedter.calendar.JDateChooser();
        rbt7 = new javax.swing.JRadioButton();
        jPanel131 = new javax.swing.JPanel();
        FDN8 = new com.toedter.calendar.JDateChooser();
        rbt8 = new javax.swing.JRadioButton();
        jPanel132 = new javax.swing.JPanel();
        FDN9 = new com.toedter.calendar.JDateChooser();
        rbt9 = new javax.swing.JRadioButton();
        FUADN9 = new javax.swing.JTextField();
        FUADN7 = new javax.swing.JTextField();
        FUADN8 = new javax.swing.JTextField();
        jPanel140 = new javax.swing.JPanel();
        FDN10 = new com.toedter.calendar.JDateChooser();
        rbt10 = new javax.swing.JRadioButton();
        FUADN10 = new javax.swing.JTextField();
        jPanel145 = new javax.swing.JPanel();
        rbt13 = new javax.swing.JRadioButton();
        FDN11 = new com.toedter.calendar.JDateChooser();
        FUADN11 = new javax.swing.JTextField();
        jPanel146 = new javax.swing.JPanel();
        FDN12 = new com.toedter.calendar.JDateChooser();
        rbt14 = new javax.swing.JRadioButton();
        FUADN12 = new javax.swing.JTextField();
        lblNina = new javax.swing.JLabel();
        lblNino = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        Opciones = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        btnEditar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        mensaje = new javax.swing.JPanel();
        men = new javax.swing.JLabel();
        b = new javax.swing.JButton();
        b1 = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createCompoundBorder());
        setVisible(true);

        DN.setBackground(new java.awt.Color(255, 255, 255));

        jPanel202.setBackground(new java.awt.Color(141, 68, 173));
        jPanel202.setPreferredSize(new java.awt.Dimension(83, 45));

        jLabel126.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel126.setForeground(new java.awt.Color(255, 255, 255));
        jLabel126.setText("Suplementación De Hierro Y/O Micronutrientes");

        jPanel203.setBackground(new java.awt.Color(154, 89, 181));

        jLabel127.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel127.setForeground(new java.awt.Color(255, 255, 255));
        jLabel127.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel127.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Izquierda Filled-30.png"))); // NOI18N
        jLabel127.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel127MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel203Layout = new javax.swing.GroupLayout(jPanel203);
        jPanel203.setLayout(jPanel203Layout);
        jPanel203Layout.setHorizontalGroup(
            jPanel203Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel127, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );
        jPanel203Layout.setVerticalGroup(
            jPanel203Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel127, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel202Layout = new javax.swing.GroupLayout(jPanel202);
        jPanel202.setLayout(jPanel202Layout);
        jPanel202Layout.setHorizontalGroup(
            jPanel202Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel202Layout.createSequentialGroup()
                .addComponent(jPanel203, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel126)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel202Layout.setVerticalGroup(
            jPanel202Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel203, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel126, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
        );

        CCDM13.setBackground(new java.awt.Color(204, 204, 204));

        jPanel134.setBackground(new java.awt.Color(153, 153, 153));

        FDN1.setBackground(new java.awt.Color(255, 255, 255));
        FDN1.setDateFormatString("dd/MM/yyyy");
        FDN1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        buttonGroup1.add(rbt1);
        rbt1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbt1.setForeground(new java.awt.Color(255, 255, 255));
        rbt1.setText("1º");
        rbt1.setContentAreaFilled(false);
        rbt1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbt1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rbt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbt1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel134Layout = new javax.swing.GroupLayout(jPanel134);
        jPanel134.setLayout(jPanel134Layout);
        jPanel134Layout.setHorizontalGroup(
            jPanel134Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FDN1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel134Layout.createSequentialGroup()
                .addComponent(rbt1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel134Layout.setVerticalGroup(
            jPanel134Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel134Layout.createSequentialGroup()
                .addComponent(rbt1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FDN1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel135.setBackground(new java.awt.Color(153, 153, 153));

        FDN2.setBackground(new java.awt.Color(255, 255, 255));
        FDN2.setDateFormatString("dd/MM/yyyy");
        FDN2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        buttonGroup1.add(rbt2);
        rbt2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbt2.setForeground(new java.awt.Color(255, 255, 255));
        rbt2.setText("2º");
        rbt2.setContentAreaFilled(false);
        rbt2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbt2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rbt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbt2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel135Layout = new javax.swing.GroupLayout(jPanel135);
        jPanel135.setLayout(jPanel135Layout);
        jPanel135Layout.setHorizontalGroup(
            jPanel135Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FDN2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel135Layout.createSequentialGroup()
                .addComponent(rbt2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel135Layout.setVerticalGroup(
            jPanel135Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel135Layout.createSequentialGroup()
                .addComponent(rbt2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FDN2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel136.setBackground(new java.awt.Color(153, 153, 153));

        FDN3.setBackground(new java.awt.Color(255, 255, 255));
        FDN3.setDateFormatString("dd/MM/yyyy");
        FDN3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        buttonGroup1.add(rbt3);
        rbt3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbt3.setForeground(new java.awt.Color(255, 255, 255));
        rbt3.setText("3º");
        rbt3.setContentAreaFilled(false);
        rbt3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbt3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rbt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbt3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel136Layout = new javax.swing.GroupLayout(jPanel136);
        jPanel136.setLayout(jPanel136Layout);
        jPanel136Layout.setHorizontalGroup(
            jPanel136Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FDN3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel136Layout.createSequentialGroup()
                .addComponent(rbt3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel136Layout.setVerticalGroup(
            jPanel136Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel136Layout.createSequentialGroup()
                .addComponent(rbt3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FDN3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel137.setBackground(new java.awt.Color(153, 153, 153));

        FDN4.setBackground(new java.awt.Color(255, 255, 255));
        FDN4.setDateFormatString("dd/MM/yyyy");
        FDN4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        buttonGroup1.add(rbt4);
        rbt4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbt4.setForeground(new java.awt.Color(255, 255, 255));
        rbt4.setText("4º");
        rbt4.setContentAreaFilled(false);
        rbt4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbt4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rbt4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbt4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel137Layout = new javax.swing.GroupLayout(jPanel137);
        jPanel137.setLayout(jPanel137Layout);
        jPanel137Layout.setHorizontalGroup(
            jPanel137Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FDN4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel137Layout.createSequentialGroup()
                .addComponent(rbt4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel137Layout.setVerticalGroup(
            jPanel137Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel137Layout.createSequentialGroup()
                .addComponent(rbt4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(FDN4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel138.setBackground(new java.awt.Color(153, 153, 153));

        FDN5.setBackground(new java.awt.Color(255, 255, 255));
        FDN5.setDateFormatString("dd/MM/yyyy");
        FDN5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        buttonGroup1.add(rbt5);
        rbt5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbt5.setForeground(new java.awt.Color(255, 255, 255));
        rbt5.setText("5º");
        rbt5.setContentAreaFilled(false);
        rbt5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbt5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rbt5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbt5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel138Layout = new javax.swing.GroupLayout(jPanel138);
        jPanel138.setLayout(jPanel138Layout);
        jPanel138Layout.setHorizontalGroup(
            jPanel138Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FDN5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel138Layout.createSequentialGroup()
                .addComponent(rbt5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel138Layout.setVerticalGroup(
            jPanel138Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel138Layout.createSequentialGroup()
                .addComponent(rbt5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(FDN5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel139.setBackground(new java.awt.Color(153, 153, 153));

        FDN6.setBackground(new java.awt.Color(255, 255, 255));
        FDN6.setDateFormatString("dd/MM/yyyy");
        FDN6.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        buttonGroup1.add(rbt6);
        rbt6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbt6.setForeground(new java.awt.Color(255, 255, 255));
        rbt6.setText("6º");
        rbt6.setContentAreaFilled(false);
        rbt6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbt6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rbt6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbt6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel139Layout = new javax.swing.GroupLayout(jPanel139);
        jPanel139.setLayout(jPanel139Layout);
        jPanel139Layout.setHorizontalGroup(
            jPanel139Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FDN6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel139Layout.createSequentialGroup()
                .addComponent(rbt6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel139Layout.setVerticalGroup(
            jPanel139Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel139Layout.createSequentialGroup()
                .addComponent(rbt6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(FDN6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout CCDM13Layout = new javax.swing.GroupLayout(CCDM13);
        CCDM13.setLayout(CCDM13Layout);
        CCDM13Layout.setHorizontalGroup(
            CCDM13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CCDM13Layout.createSequentialGroup()
                .addGroup(CCDM13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel134, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(FUADN1, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(1, 1, 1)
                .addGroup(CCDM13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel135, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(FUADN2))
                .addGap(1, 1, 1)
                .addGroup(CCDM13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(FUADN3)
                    .addComponent(jPanel136, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addGroup(CCDM13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(FUADN4)
                    .addComponent(jPanel137, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addGroup(CCDM13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(FUADN5)
                    .addComponent(jPanel138, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addGroup(CCDM13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(FUADN6)
                    .addComponent(jPanel139, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        CCDM13Layout.setVerticalGroup(
            CCDM13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CCDM13Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(CCDM13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CCDM13Layout.createSequentialGroup()
                        .addGroup(CCDM13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CCDM13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel136, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel135, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jPanel134, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(CCDM13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FUADN3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FUADN1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FUADN2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(CCDM13Layout.createSequentialGroup()
                        .addComponent(jPanel138, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(FUADN5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CCDM13Layout.createSequentialGroup()
                        .addComponent(jPanel137, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(FUADN4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CCDM13Layout.createSequentialGroup()
                        .addComponent(jPanel139, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(FUADN6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        LEYENDA2.setBackground(new java.awt.Color(204, 204, 204));

        jPanel141.setBackground(new java.awt.Color(153, 153, 153));

        jLabel137.setBackground(new java.awt.Color(153, 153, 153));
        jLabel137.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel137.setForeground(new java.awt.Color(255, 255, 255));
        jLabel137.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel137.setText("Nº CONRTROL");

        javax.swing.GroupLayout jPanel141Layout = new javax.swing.GroupLayout(jPanel141);
        jPanel141.setLayout(jPanel141Layout);
        jPanel141Layout.setHorizontalGroup(
            jPanel141Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel141Layout.createSequentialGroup()
                .addComponent(jLabel137, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel141Layout.setVerticalGroup(
            jPanel141Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel137, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jPanel144.setBackground(new java.awt.Color(153, 153, 153));

        jLabel139.setForeground(new java.awt.Color(255, 255, 255));
        jLabel139.setText("FUA");

        javax.swing.GroupLayout jPanel144Layout = new javax.swing.GroupLayout(jPanel144);
        jPanel144.setLayout(jPanel144Layout);
        jPanel144Layout.setHorizontalGroup(
            jPanel144Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel144Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel139, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel144Layout.setVerticalGroup(
            jPanel144Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel139, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
        );

        jLabel138.setForeground(new java.awt.Color(255, 255, 255));
        jLabel138.setText("FECHA");

        javax.swing.GroupLayout LEYENDA2Layout = new javax.swing.GroupLayout(LEYENDA2);
        LEYENDA2.setLayout(LEYENDA2Layout);
        LEYENDA2Layout.setHorizontalGroup(
            LEYENDA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel141, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(LEYENDA2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel138, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
            .addComponent(jPanel144, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        LEYENDA2Layout.setVerticalGroup(
            LEYENDA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LEYENDA2Layout.createSequentialGroup()
                .addComponent(jPanel141, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel138)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel144, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        CCDR3A2.setBackground(new java.awt.Color(204, 204, 204));

        jPanel130.setBackground(new java.awt.Color(153, 153, 153));

        FDN7.setBackground(new java.awt.Color(255, 255, 255));
        FDN7.setDateFormatString("dd/MM/yyyy");
        FDN7.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        buttonGroup1.add(rbt7);
        rbt7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbt7.setForeground(new java.awt.Color(255, 255, 255));
        rbt7.setText("7º");
        rbt7.setContentAreaFilled(false);
        rbt7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbt7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rbt7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbt7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel130Layout = new javax.swing.GroupLayout(jPanel130);
        jPanel130.setLayout(jPanel130Layout);
        jPanel130Layout.setHorizontalGroup(
            jPanel130Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FDN7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel130Layout.createSequentialGroup()
                .addComponent(rbt7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel130Layout.setVerticalGroup(
            jPanel130Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel130Layout.createSequentialGroup()
                .addComponent(rbt7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FDN7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel131.setBackground(new java.awt.Color(153, 153, 153));

        FDN8.setBackground(new java.awt.Color(255, 255, 255));
        FDN8.setDateFormatString("dd/MM/yyyy");
        FDN8.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        buttonGroup1.add(rbt8);
        rbt8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbt8.setForeground(new java.awt.Color(255, 255, 255));
        rbt8.setText("8º");
        rbt8.setContentAreaFilled(false);
        rbt8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbt8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rbt8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbt8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel131Layout = new javax.swing.GroupLayout(jPanel131);
        jPanel131.setLayout(jPanel131Layout);
        jPanel131Layout.setHorizontalGroup(
            jPanel131Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FDN8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel131Layout.createSequentialGroup()
                .addComponent(rbt8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel131Layout.setVerticalGroup(
            jPanel131Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel131Layout.createSequentialGroup()
                .addComponent(rbt8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FDN8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel132.setBackground(new java.awt.Color(153, 153, 153));

        FDN9.setBackground(new java.awt.Color(255, 255, 255));
        FDN9.setDateFormatString("dd/MM/yyyy");
        FDN9.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        buttonGroup1.add(rbt9);
        rbt9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbt9.setForeground(new java.awt.Color(255, 255, 255));
        rbt9.setText("9º");
        rbt9.setContentAreaFilled(false);
        rbt9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbt9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rbt9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbt9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel132Layout = new javax.swing.GroupLayout(jPanel132);
        jPanel132.setLayout(jPanel132Layout);
        jPanel132Layout.setHorizontalGroup(
            jPanel132Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FDN9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel132Layout.createSequentialGroup()
                .addComponent(rbt9, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel132Layout.setVerticalGroup(
            jPanel132Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel132Layout.createSequentialGroup()
                .addComponent(rbt9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FDN9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel140.setBackground(new java.awt.Color(153, 153, 153));

        FDN10.setBackground(new java.awt.Color(255, 255, 255));
        FDN10.setDateFormatString("dd/MM/yyyy");
        FDN10.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        buttonGroup1.add(rbt10);
        rbt10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbt10.setForeground(new java.awt.Color(255, 255, 255));
        rbt10.setText("10º");
        rbt10.setContentAreaFilled(false);
        rbt10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbt10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rbt10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbt10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel140Layout = new javax.swing.GroupLayout(jPanel140);
        jPanel140.setLayout(jPanel140Layout);
        jPanel140Layout.setHorizontalGroup(
            jPanel140Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FDN10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(rbt10, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel140Layout.setVerticalGroup(
            jPanel140Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel140Layout.createSequentialGroup()
                .addComponent(rbt10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FDN10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel145.setBackground(new java.awt.Color(153, 153, 153));

        buttonGroup1.add(rbt13);
        rbt13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbt13.setForeground(new java.awt.Color(255, 255, 255));
        rbt13.setText("11º");
        rbt13.setContentAreaFilled(false);
        rbt13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbt13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rbt13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbt13ActionPerformed(evt);
            }
        });

        FDN11.setBackground(new java.awt.Color(255, 255, 255));
        FDN11.setDateFormatString("dd/MM/yyyy");
        FDN11.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel145Layout = new javax.swing.GroupLayout(jPanel145);
        jPanel145.setLayout(jPanel145Layout);
        jPanel145Layout.setHorizontalGroup(
            jPanel145Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel145Layout.createSequentialGroup()
                .addComponent(rbt13, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(FDN11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel145Layout.setVerticalGroup(
            jPanel145Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel145Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbt13, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FDN11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel146.setBackground(new java.awt.Color(153, 153, 153));

        FDN12.setBackground(new java.awt.Color(255, 255, 255));
        FDN12.setDateFormatString("dd/MM/yyyy");
        FDN12.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        buttonGroup1.add(rbt14);
        rbt14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbt14.setForeground(new java.awt.Color(255, 255, 255));
        rbt14.setText("12º");
        rbt14.setContentAreaFilled(false);
        rbt14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbt14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rbt14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbt14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel146Layout = new javax.swing.GroupLayout(jPanel146);
        jPanel146.setLayout(jPanel146Layout);
        jPanel146Layout.setHorizontalGroup(
            jPanel146Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FDN12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel146Layout.createSequentialGroup()
                .addComponent(rbt14, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel146Layout.setVerticalGroup(
            jPanel146Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel146Layout.createSequentialGroup()
                .addComponent(rbt14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FDN12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout CCDR3A2Layout = new javax.swing.GroupLayout(CCDR3A2);
        CCDR3A2.setLayout(CCDR3A2Layout);
        CCDR3A2Layout.setHorizontalGroup(
            CCDR3A2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CCDR3A2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(CCDR3A2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel130, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(FUADN7, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(1, 1, 1)
                .addGroup(CCDR3A2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel131, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(FUADN8))
                .addGap(1, 1, 1)
                .addGroup(CCDR3A2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(FUADN9)
                    .addComponent(jPanel132, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addGroup(CCDR3A2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel140, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(FUADN10))
                .addGap(1, 1, 1)
                .addGroup(CCDR3A2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel145, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(FUADN11))
                .addGap(1, 1, 1)
                .addGroup(CCDR3A2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel146, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(FUADN12)))
        );
        CCDR3A2Layout.setVerticalGroup(
            CCDR3A2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CCDR3A2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(CCDR3A2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel146, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(CCDR3A2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(CCDR3A2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel132, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel131, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel140, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jPanel130, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel145, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(CCDR3A2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FUADN9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FUADN7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FUADN8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FUADN10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FUADN11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FUADN12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        lblNina.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNina.setForeground(new java.awt.Color(102, 102, 102));
        lblNina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Niña-48.png"))); // NOI18N
        lblNina.setText("NIÑOS");
        lblNina.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblNina.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lblNina.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNinaMouseClicked(evt);
            }
        });

        lblNino.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNino.setForeground(new java.awt.Color(102, 102, 102));
        lblNino.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Niño-48.png"))); // NOI18N
        lblNino.setText("NIÑOS");
        lblNino.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblNino.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lblNino.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNinoMouseClicked(evt);
            }
        });

        lblId.setText("jLabel1");

        Opciones.setBackground(new java.awt.Color(102, 102, 102));

        jPanel28.setBackground(new java.awt.Color(51, 51, 51));

        btnEditar.setForeground(new java.awt.Color(240, 240, 240));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Icon/Editar-32.png"))); // NOI18N
        btnEditar.setMnemonic('N');
        btnEditar.setContentAreaFilled(false);
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditar.setIconTextGap(30);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnGuardar.setForeground(new java.awt.Color(240, 240, 240));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Icon/Guardar-32.png"))); // NOI18N
        btnGuardar.setMnemonic('N');
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar.setIconTextGap(30);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setForeground(new java.awt.Color(240, 240, 240));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Deshacer-30.png"))); // NOI18N
        btnCancelar.setMnemonic('N');
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setIconTextGap(30);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addContainerGap(129, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel28Layout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(69, Short.MAX_VALUE)))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel28Layout.createSequentialGroup()
                    .addGap(1, 1, 1)
                    .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        mensaje.setBackground(new java.awt.Color(33, 115, 70));

        men.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        men.setForeground(new java.awt.Color(255, 255, 255));
        men.setText("Desea Actualizar el Registro ?");

        b.setForeground(new java.awt.Color(240, 240, 240));
        b.setText("Si");
        b.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        b.setContentAreaFilled(false);
        b.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        b.setIconTextGap(30);
        b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bActionPerformed(evt);
            }
        });

        b1.setForeground(new java.awt.Color(240, 240, 240));
        b1.setText("No");
        b1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        b1.setContentAreaFilled(false);
        b1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        b1.setIconTextGap(30);
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mensajeLayout = new javax.swing.GroupLayout(mensaje);
        mensaje.setLayout(mensajeLayout);
        mensajeLayout.setHorizontalGroup(
            mensajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mensajeLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(men)
                .addGap(46, 46, 46)
                .addComponent(b, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(895, Short.MAX_VALUE))
        );
        mensajeLayout.setVerticalGroup(
            mensajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mensajeLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(mensajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(men)
                    .addComponent(b, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout OpcionesLayout = new javax.swing.GroupLayout(Opciones);
        Opciones.setLayout(OpcionesLayout);
        OpcionesLayout.setHorizontalGroup(
            OpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OpcionesLayout.createSequentialGroup()
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        OpcionesLayout.setVerticalGroup(
            OpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(OpcionesLayout.createSequentialGroup()
                .addComponent(mensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout DNLayout = new javax.swing.GroupLayout(DN);
        DN.setLayout(DNLayout);
        DNLayout.setHorizontalGroup(
            DNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel202, javax.swing.GroupLayout.DEFAULT_SIZE, 1531, Short.MAX_VALUE)
            .addGroup(DNLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DNLayout.createSequentialGroup()
                        .addComponent(LEYENDA2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(CCDM13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DNLayout.createSequentialGroup()
                        .addComponent(CCDR3A2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(188, 188, 188)
                        .addComponent(lblId))
                    .addGroup(DNLayout.createSequentialGroup()
                        .addComponent(lblNina, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNino, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(574, Short.MAX_VALUE))
            .addComponent(Opciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        DNLayout.setVerticalGroup(
            DNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DNLayout.createSequentialGroup()
                .addComponent(jPanel202, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(DNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNina)
                    .addComponent(lblNino))
                .addGap(18, 18, 18)
                .addGroup(DNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CCDM13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LEYENDA2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(DNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblId)
                    .addComponent(CCDR3A2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addComponent(Opciones, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1531, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(DN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 462, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(DN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel127MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel127MouseClicked
        RegistroSeguimiento.jTabbedPane1.setSelectedIndex(0);
        ConsultorioExtRsSuplementacionHierro SHM1 = new ConsultorioExtRsSuplementacionHierro();
        SHM1.porcentajeSHM(Integer.parseInt(lblId.getText()));
        this.dispose();
    }//GEN-LAST:event_jLabel127MouseClicked

    private void lblNinaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNinaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblNinaMouseClicked

    private void lblNinoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNinoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblNinoMouseClicked

    private void rbt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbt1ActionPerformed
        if(FDN1.getDate()==null){
            if(rbt1.isSelected()){
                habilitarDatos(false);
                habilitarRadio(false);
                Botones(true);
                FUADN1.setEnabled(true);
                FDN1.setEnabled(true);
                FUADN1.setEditable(false); 
                fecha=FDN1;
                fua = FUADN1;
            }
        } else {
            rbt1.setEnabled(false);
        }
    }//GEN-LAST:event_rbt1ActionPerformed

    private void rbt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbt2ActionPerformed
        if(FDN2.getDate()==null){
            if(rbt2.isSelected()){
                habilitarDatos(false);
                habilitarRadio(false);
                Botones(true);
                FUADN2.setEnabled(true);
                FDN2.setEnabled(true);
                FUADN2.setEditable(false); 
                fecha=FDN2;
                fua = FUADN2;
            }
        } else {
            rbt2.setEnabled(false);
        }
    }//GEN-LAST:event_rbt2ActionPerformed

    private void rbt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbt3ActionPerformed
        if(FDN3.getDate()==null){
            if(rbt3.isSelected()){
                habilitarDatos(false);
                habilitarRadio(false);
                Botones(true);
                FUADN3.setEnabled(true);
                FDN3.setEnabled(true);
                FUADN3.setEditable(false); 
                fecha=FDN3;
                fua = FUADN3;
            }
        } else {
            rbt3.setEnabled(false);
        }
    }//GEN-LAST:event_rbt3ActionPerformed

    private void rbt4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbt4ActionPerformed
        if(FDN4.getDate()==null){
            if(rbt4.isSelected()){
                habilitarDatos(false);
                habilitarRadio(false);
                Botones(true);
                FUADN4.setEnabled(true);
                FDN4.setEnabled(true);
                FUADN4.setEditable(false); 
                fecha=FDN4;
                fua = FUADN4;
            }
        } else {
            rbt4.setEnabled(false);
        }
    }//GEN-LAST:event_rbt4ActionPerformed

    private void rbt5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbt5ActionPerformed
        if(FDN5.getDate()==null){
            if(rbt5.isSelected()){
                habilitarDatos(false);
                habilitarRadio(false);
                Botones(true);
                FUADN5.setEnabled(true);
                FDN5.setEnabled(true);
                FUADN5.setEditable(false); 
                fecha=FDN5;
                fua = FUADN5;
            }
        } else {
            rbt5.setEnabled(false);
        }
    }//GEN-LAST:event_rbt5ActionPerformed

    private void rbt6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbt6ActionPerformed
        if(FDN6.getDate()==null){
            if(rbt6.isSelected()){
                habilitarDatos(false);
                habilitarRadio(false);
                Botones(true);
                FUADN6.setEnabled(true);
                FDN6.setEnabled(true);
                FUADN6.setEditable(false); 
                fecha=FDN6;
                fua = FUADN6;
            }
        } else {
            rbt6.setEnabled(false);
        }
    }//GEN-LAST:event_rbt6ActionPerformed

    private void rbt8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbt8ActionPerformed
        if(FDN8.getDate()==null){
            if(rbt8.isSelected()){
                habilitarDatos(false);
                habilitarRadio(false);
                Botones(true);
                FUADN8.setEnabled(true);
                FDN8.setEnabled(true);
                FUADN8.setEditable(false); 
                fecha=FDN8;
                fua = FUADN8;
            }
        } else {
            rbt8.setEnabled(false);
        }
    }//GEN-LAST:event_rbt8ActionPerformed

    private void rbt9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbt9ActionPerformed
        if(FDN9.getDate()==null){
            if(rbt9.isSelected()){
                habilitarDatos(false);
                habilitarRadio(false);
                Botones(true);
                FUADN9.setEnabled(true);
                FDN9.setEnabled(true);
                FUADN9.setEditable(false); 
                fecha=FDN9;
                fua = FUADN9;
            }
        } else {
            rbt9.setEnabled(false);
        }
    }//GEN-LAST:event_rbt9ActionPerformed

    private void rbt10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbt10ActionPerformed
       if(FDN10.getDate()==null){
            if(rbt10.isSelected()){
                habilitarDatos(false);
                habilitarRadio(false);
                Botones(true);
                FUADN10.setEnabled(true);
                FDN10.setEnabled(true);
                FUADN10.setEditable(false); 
                fecha=FDN10;
                fua = FUADN10;
            }
        } else {
            rbt10.setEnabled(false);
        }
    }//GEN-LAST:event_rbt10ActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        validaRegistro(Integer.parseInt(lblId.getText()));
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        habilitarRadio(true);
        habilitarDatos(false);
        Botones(false);
        fua.setText("");
        fecha.setDate(null);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bActionPerformed
        if (tge==3 || tge==1 || tge==9){
            mensaje.setVisible(false);

        }

        if (tge==2){
            //            Modificar();

            btnEditar.setEnabled(false);
            ;

        }

    }//GEN-LAST:event_bActionPerformed

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        mensaje.setVisible(false);
    }//GEN-LAST:event_b1ActionPerformed

    private void rbt7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbt7ActionPerformed
        if(FDN7.getDate()==null){
            if(rbt7.isSelected()){
                habilitarDatos(false);
                habilitarRadio(false);
                Botones(true);
                FUADN7.setEnabled(true);
                FDN7.setEnabled(true);
                FUADN7.setEditable(false); 
                fecha=FDN7;
                fua = FUADN7;
            }
        } else {
            rbt7.setEnabled(false);
        }
    }//GEN-LAST:event_rbt7ActionPerformed

    private void rbt13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbt13ActionPerformed
        if(FDN11.getDate()==null){
            if(rbt13.isSelected()){
                habilitarDatos(false);
                habilitarRadio(false);
                Botones(true);
                FUADN11.setEnabled(true);
                FDN11.setEnabled(true);
                FUADN11.setEditable(false); 
                fecha=FDN11;
                fua = FUADN11;
            }
        } else {
            rbt13.setEnabled(false);
        }
    }//GEN-LAST:event_rbt13ActionPerformed

    private void rbt14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbt14ActionPerformed
        if(FDN12.getDate()==null){
            if(rbt14.isSelected()){
                habilitarDatos(false);
                habilitarRadio(false);
                Botones(true);
                FUADN12.setEnabled(true);
                FDN12.setEnabled(true);
                FUADN12.setEditable(false); 
                fecha=FDN12;
                fua = FUADN12;
            }
        } else {
            rbt14.setEnabled(false);
        }
    }//GEN-LAST:event_rbt14ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CCDM13;
    private javax.swing.JPanel CCDR3A2;
    private javax.swing.JPanel DN;
    public static com.toedter.calendar.JDateChooser FDN1;
    public static com.toedter.calendar.JDateChooser FDN10;
    public static com.toedter.calendar.JDateChooser FDN11;
    public static com.toedter.calendar.JDateChooser FDN12;
    public static com.toedter.calendar.JDateChooser FDN2;
    public static com.toedter.calendar.JDateChooser FDN3;
    public static com.toedter.calendar.JDateChooser FDN4;
    public static com.toedter.calendar.JDateChooser FDN5;
    public static com.toedter.calendar.JDateChooser FDN6;
    public static com.toedter.calendar.JDateChooser FDN7;
    public static com.toedter.calendar.JDateChooser FDN8;
    public static com.toedter.calendar.JDateChooser FDN9;
    public static javax.swing.JTextField FUADN1;
    public static javax.swing.JTextField FUADN10;
    public static javax.swing.JTextField FUADN11;
    public static javax.swing.JTextField FUADN12;
    public static javax.swing.JTextField FUADN2;
    public static javax.swing.JTextField FUADN3;
    public static javax.swing.JTextField FUADN4;
    public static javax.swing.JTextField FUADN5;
    public static javax.swing.JTextField FUADN6;
    public static javax.swing.JTextField FUADN7;
    public static javax.swing.JTextField FUADN8;
    public static javax.swing.JTextField FUADN9;
    private javax.swing.JPanel LEYENDA2;
    private javax.swing.JPanel Opciones;
    private javax.swing.JButton b;
    private javax.swing.JButton b1;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JPanel jPanel130;
    private javax.swing.JPanel jPanel131;
    private javax.swing.JPanel jPanel132;
    private javax.swing.JPanel jPanel134;
    private javax.swing.JPanel jPanel135;
    private javax.swing.JPanel jPanel136;
    private javax.swing.JPanel jPanel137;
    private javax.swing.JPanel jPanel138;
    private javax.swing.JPanel jPanel139;
    private javax.swing.JPanel jPanel140;
    private javax.swing.JPanel jPanel141;
    private javax.swing.JPanel jPanel144;
    private javax.swing.JPanel jPanel145;
    private javax.swing.JPanel jPanel146;
    private javax.swing.JPanel jPanel202;
    private javax.swing.JPanel jPanel203;
    private javax.swing.JPanel jPanel28;
    public static javax.swing.JLabel lblId;
    public static javax.swing.JLabel lblNina;
    public static javax.swing.JLabel lblNino;
    private javax.swing.JLabel men;
    private javax.swing.JPanel mensaje;
    private javax.swing.JRadioButton rbt1;
    private javax.swing.JRadioButton rbt10;
    private javax.swing.JRadioButton rbt13;
    private javax.swing.JRadioButton rbt14;
    private javax.swing.JRadioButton rbt2;
    private javax.swing.JRadioButton rbt3;
    private javax.swing.JRadioButton rbt4;
    private javax.swing.JRadioButton rbt5;
    private javax.swing.JRadioButton rbt6;
    private javax.swing.JRadioButton rbt7;
    private javax.swing.JRadioButton rbt8;
    private javax.swing.JRadioButton rbt9;
    // End of variables declaration//GEN-END:variables
}
