/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.CRED;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import modelos.ConsultorioEx.ConsultorioExtRsSuplementacionVitaminaA;


/**
 *
 * @author MYS1
 */
public class RSAISCVA extends javax.swing.JInternalFrame {
private JComponent Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
private Dimension DimensionBarra = null; 
byte tg;
byte tge;
JDateChooser fecha;
JTextField fua;
JLabel cie10;
ConsultorioExtRsSuplementacionVitaminaA SVA01 = new ConsultorioExtRsSuplementacionVitaminaA();
    /**
     * Creates new form RSAITAPTG
     */
    public RSAISCVA() {
        initComponents();
        QuitarLaBarraTitulo();
        habilitarDatos(false);
        RDD3.setEnabled(false);
        mensaje.setVisible(false);
    }
public void QuitarLaBarraTitulo()
    { 
    Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane(); 
    DimensionBarra = Barra.getPreferredSize(); 
    Barra.setSize(0,0); 
    Barra.setPreferredSize(new Dimension(0,0)); 
    repaint(); 
    }

    public void habilitarRadio(boolean opcion){
          RDD2.setEnabled(opcion);   
          RDD7.setEnabled(opcion);  
          RDD8.setEnabled(opcion);  
          RDD12.setEnabled(opcion);  
          RDD13.setEnabled(opcion);  
          RDD15.setEnabled(opcion);  
          RDD14.setEnabled(opcion);  
          RDD16.setEnabled(opcion);  
          RDD17.setEnabled(opcion); 
    }
    
    public void habilitarDatos(boolean opcion){
        TNFA2.setEnabled(opcion);
        TNFP1.setEnabled(opcion);
        TNFP2.setEnabled(opcion);
        TNFT1.setEnabled(opcion);
        TNFT2.setEnabled(opcion);
        TNFT4.setEnabled(opcion);
        TNFT3.setEnabled(opcion);
        TNFT5.setEnabled(opcion);
        TNFT6.setEnabled(opcion);
        
        TNFUAA2.setEnabled(opcion);
        TNFUAP1.setEnabled(opcion);
        TNFUAP2.setEnabled(opcion);
        TNFUAT1.setEnabled(opcion);
        TNFUAT2.setEnabled(opcion);
        TNFUAT4.setEnabled(opcion);
        TNFUAT3.setEnabled(opcion);
        TNFUAT6.setEnabled(opcion);
        TNFUAT5.setEnabled(opcion);
    }
    public void Botones(boolean opcion){
        btnGuardar.setEnabled(opcion);
        btnEditar.setEnabled(opcion);
        btnCancelar.setEnabled(opcion);
    }
    public void validaRegistro(int rs_id){
        try {
            PreparedStatement cmd = SVA01.getCn().prepareStatement("SELECT RS_ID FROM CONSULTORIO_EXT_RS_SUPLEMENTACION_VITAMINA_A WHERE RS_ID ='"+rs_id+"'");
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
        ConsultorioExtRsSuplementacionVitaminaA CXRsSVA = new ConsultorioExtRsSuplementacionVitaminaA();
        ConsultorioExtRsSuplementacionVitaminaA CXRsSVA2 = new ConsultorioExtRsSuplementacionVitaminaA();
        try {
    
            CXRsSVA.setRs_id(Integer.parseInt(lblId.getText()));
            //6 MESES
            if(TNFA2.getDate()!=null){
                CXRsSVA.setM61Fecha(determinarFecha(TNFA2));  
                CXRsSVA.setM61Fua(TNFUAA2.getText());
            }
            
            if(TNFA3.getDate()!=null){
                CXRsSVA.setM62Fecha("03/06/1994");  
                CXRsSVA.setM62Fua(TNFUAA3.getText());
            }
            //1 AÑO
            if(TNFP1.getDate()!=null){
                CXRsSVA.setM11Fecha(determinarFecha(TNFP1));  
                CXRsSVA.setM11Fua(TNFUAP1.getText());
            }
            
            if(TNFP2.getDate()!=null){
                CXRsSVA.setM12Fecha(determinarFecha(TNFP2));  
                CXRsSVA.setM12Fua(TNFUAP2.getText());
            }
            // 2 AÑOS
            if(TNFT1.getDate()!=null){
                CXRsSVA.setM21Fecha(determinarFecha(TNFT1));  
                CXRsSVA.setM21Fua(TNFUAT1.getText());
            }
            
            if(TNFT2.getDate()!=null){
                CXRsSVA.setM22Fecha(determinarFecha(TNFT2));  
                CXRsSVA.setM22Fua(TNFUAT2.getText());
            }
            // 3 AÑOS
            if(TNFT4.getDate()!=null){
                CXRsSVA.setM31Fecha(determinarFecha(TNFT4));  
                CXRsSVA.setM31Fua(TNFUAT4.getText());
            }
            
            if(TNFT3.getDate()!=null){
                CXRsSVA.setM32Fecha(determinarFecha(TNFT3));  
                CXRsSVA.setM32Fua(TNFUAT3.getText());
            }
            //4 AÑOS
            if(TNFT5.getDate()!=null){
                CXRsSVA.setM41Fecha(determinarFecha(TNFT5));  
                CXRsSVA.setM41Fua(TNFUAT6.getText());
            }
            
            if(TNFT6.getDate()!=null){
                CXRsSVA.setM42Fecha(determinarFecha(TNFT6));  
                CXRsSVA.setM42Fua(TNFUAT5.getText());
            }
            
            if(CXRsSVA.mantenimientoRSAISVA("U")==true){
                mensaje.setVisible(true);
                mensaje.setBackground(new Color(33,115,70)); 
                men.setText("Datos Actualizados de forma correcta");
                b.setText("OK");
                b.setVisible(true);
                b1.setVisible(false);
                btnGuardar.setEnabled(false);
                tge=1;
                CXRsSVA2.ConsultoriosExtSVAListar(Integer.parseInt(lblId.getText()));
                CXRsSVA2.porcentajeSVA(Integer.parseInt(lblId.getText()));
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
            ConsultorioExtRsSuplementacionVitaminaA CXRsSVA = new ConsultorioExtRsSuplementacionVitaminaA();
        ConsultorioExtRsSuplementacionVitaminaA CXRsSVA2 = new ConsultorioExtRsSuplementacionVitaminaA();
        try {
    
            CXRsSVA.setRs_id(Integer.parseInt(lblId.getText()));
            //6 MESES
            if(TNFA2.getDate()!=null){
                CXRsSVA.setM61Fecha(determinarFecha(TNFA2));  
                CXRsSVA.setM61Fua(TNFUAA2.getText());
            }
            
            if(TNFA3.getDate()!=null){
                CXRsSVA.setM62Fecha("03/06/1994");  
                CXRsSVA.setM62Fua(TNFUAA3.getText());
            }
            //1 AÑO
            if(TNFP1.getDate()!=null){
                CXRsSVA.setM11Fecha(determinarFecha(TNFP1));  
                CXRsSVA.setM11Fua(TNFUAP1.getText());
            }
            
            if(TNFP2.getDate()!=null){
                CXRsSVA.setM12Fecha(determinarFecha(TNFP2));  
                CXRsSVA.setM12Fua(TNFUAP2.getText());
            }
            // 2 AÑOS
            if(TNFT1.getDate()!=null){
                CXRsSVA.setM21Fecha(determinarFecha(TNFT1));  
                CXRsSVA.setM21Fua(TNFUAT1.getText());
            }
            
            if(TNFT2.getDate()!=null){
                CXRsSVA.setM22Fecha(determinarFecha(TNFT2));  
                CXRsSVA.setM22Fua(TNFUAT2.getText());
            }
            // 3 AÑOS
            if(TNFT4.getDate()!=null){
                CXRsSVA.setM31Fecha(determinarFecha(TNFT4));  
                CXRsSVA.setM31Fua(TNFUAT4.getText());
            }
            
            if(TNFT3.getDate()!=null){
                CXRsSVA.setM32Fecha(determinarFecha(TNFT3));  
                CXRsSVA.setM32Fua(TNFUAT3.getText());
            }
            //4 AÑOS
            if(TNFT5.getDate()!=null){
                CXRsSVA.setM41Fecha(determinarFecha(TNFT5));  
                CXRsSVA.setM41Fua(TNFUAT6.getText());
            }
            
            if(TNFT6.getDate()!=null){
                CXRsSVA.setM42Fecha(determinarFecha(TNFT6));  
                CXRsSVA.setM42Fua(TNFUAT5.getText());
            }
        if(CXRsSVA.mantenimientoRSAISVA("I")==true){
                mensaje.setVisible(true);
                mensaje.setBackground(new Color(33,115,70)); 
                men.setText("Datos Guardados de forma correcta");
                b.setText("OK");
                b.setVisible(true);
                b1.setVisible(false);

                btnGuardar.setEnabled(false);
                tge=1;

                CXRsSVA2.ConsultoriosExtSVAListar(Integer.parseInt(lblId.getText()));
                CXRsSVA2.porcentajeSVA(Integer.parseInt(lblId.getText()));
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


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        CCD = new javax.swing.JPanel();
        LEYENDA = new javax.swing.JPanel();
        jPanel72 = new javax.swing.JPanel();
        jPanel73 = new javax.swing.JPanel();
        jPanel74 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        CCDM12 = new javax.swing.JPanel();
        jPanel81 = new javax.swing.JPanel();
        jPanel83 = new javax.swing.JPanel();
        TNFA2 = new com.toedter.calendar.JDateChooser();
        RDD2 = new javax.swing.JRadioButton();
        jPanel84 = new javax.swing.JPanel();
        TNFA3 = new com.toedter.calendar.JDateChooser();
        RDD3 = new javax.swing.JRadioButton();
        TNFUAA3 = new javax.swing.JTextField();
        TNFUAA2 = new javax.swing.JTextField();
        jPanel75 = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        jPanel76 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        CCDM15 = new javax.swing.JPanel();
        jPanel99 = new javax.swing.JPanel();
        TNFP1 = new com.toedter.calendar.JDateChooser();
        RDD7 = new javax.swing.JRadioButton();
        jPanel100 = new javax.swing.JPanel();
        TNFP2 = new com.toedter.calendar.JDateChooser();
        RDD8 = new javax.swing.JRadioButton();
        TNFUAP1 = new javax.swing.JTextField();
        TNFUAP2 = new javax.swing.JTextField();
        CCDM16 = new javax.swing.JPanel();
        jPanel104 = new javax.swing.JPanel();
        TNFT1 = new com.toedter.calendar.JDateChooser();
        RDD12 = new javax.swing.JRadioButton();
        jPanel105 = new javax.swing.JPanel();
        TNFT2 = new com.toedter.calendar.JDateChooser();
        RDD13 = new javax.swing.JRadioButton();
        TNFUAT1 = new javax.swing.JTextField();
        TNFUAT2 = new javax.swing.JTextField();
        lblId = new javax.swing.JLabel();
        Opciones = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        btnEditar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        mensaje = new javax.swing.JPanel();
        men = new javax.swing.JLabel();
        b = new javax.swing.JButton();
        b1 = new javax.swing.JButton();
        jPanel77 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        jPanel106 = new javax.swing.JPanel();
        TNFT3 = new com.toedter.calendar.JDateChooser();
        RDD14 = new javax.swing.JRadioButton();
        jPanel107 = new javax.swing.JPanel();
        TNFT4 = new com.toedter.calendar.JDateChooser();
        RDD15 = new javax.swing.JRadioButton();
        TNFUAT3 = new javax.swing.JTextField();
        TNFUAT4 = new javax.swing.JTextField();
        jPanel78 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        jPanel108 = new javax.swing.JPanel();
        TNFT5 = new com.toedter.calendar.JDateChooser();
        RDD16 = new javax.swing.JRadioButton();
        jPanel109 = new javax.swing.JPanel();
        TNFT6 = new com.toedter.calendar.JDateChooser();
        RDD17 = new javax.swing.JRadioButton();
        TNFUAT5 = new javax.swing.JTextField();
        TNFUAT6 = new javax.swing.JTextField();
        jPanel26 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        lblPorcentajeV = new javax.swing.JLabel();
        lblNina = new javax.swing.JLabel();
        lblNino = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createCompoundBorder());
        setVisible(true);

        CCD.setBackground(new java.awt.Color(255, 255, 255));

        LEYENDA.setBackground(new java.awt.Color(204, 204, 204));

        jPanel72.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel72Layout = new javax.swing.GroupLayout(jPanel72);
        jPanel72.setLayout(jPanel72Layout);
        jPanel72Layout.setHorizontalGroup(
            jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel72Layout.setVerticalGroup(
            jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel73.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel73Layout = new javax.swing.GroupLayout(jPanel73);
        jPanel73.setLayout(jPanel73Layout);
        jPanel73Layout.setHorizontalGroup(
            jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel73Layout.setVerticalGroup(
            jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 33, Short.MAX_VALUE)
        );

        jPanel74.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel74Layout = new javax.swing.GroupLayout(jPanel74);
        jPanel74.setLayout(jPanel74Layout);
        jPanel74Layout.setHorizontalGroup(
            jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 107, Short.MAX_VALUE)
        );
        jPanel74Layout.setVerticalGroup(
            jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        jLabel63.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jLabel63.setText("6 MESES");

        javax.swing.GroupLayout LEYENDALayout = new javax.swing.GroupLayout(LEYENDA);
        LEYENDA.setLayout(LEYENDALayout);
        LEYENDALayout.setHorizontalGroup(
            LEYENDALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel72, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(LEYENDALayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel74, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel73, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        LEYENDALayout.setVerticalGroup(
            LEYENDALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LEYENDALayout.createSequentialGroup()
                .addComponent(jPanel72, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel73, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LEYENDALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel74, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        CCDM12.setBackground(new java.awt.Color(255, 255, 255));

        jPanel81.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel81Layout = new javax.swing.GroupLayout(jPanel81);
        jPanel81.setLayout(jPanel81Layout);
        jPanel81Layout.setHorizontalGroup(
            jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel81Layout.setVerticalGroup(
            jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel83.setBackground(new java.awt.Color(153, 153, 153));

        TNFA2.setBackground(new java.awt.Color(255, 255, 255));
        TNFA2.setDateFormatString("dd/MM/yyyy");
        TNFA2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        RDD2.setBackground(new java.awt.Color(153, 153, 153));
        buttonGroup1.add(RDD2);
        RDD2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RDD2.setForeground(new java.awt.Color(255, 255, 255));
        RDD2.setText("1era Dosis");
        RDD2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RDD2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel83Layout = new javax.swing.GroupLayout(jPanel83);
        jPanel83.setLayout(jPanel83Layout);
        jPanel83Layout.setHorizontalGroup(
            jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel83Layout.createSequentialGroup()
                .addComponent(TNFA2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel83Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(RDD2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel83Layout.setVerticalGroup(
            jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel83Layout.createSequentialGroup()
                .addComponent(RDD2)
                .addGap(3, 3, 3)
                .addComponent(TNFA2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel84.setBackground(new java.awt.Color(153, 153, 153));

        TNFA3.setBackground(new java.awt.Color(255, 255, 255));
        TNFA3.setDateFormatString("dd/MM/yyyy");
        TNFA3.setEnabled(false);
        TNFA3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        RDD3.setBackground(new java.awt.Color(153, 153, 153));
        buttonGroup1.add(RDD3);
        RDD3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RDD3.setForeground(new java.awt.Color(255, 255, 255));
        RDD3.setText("2da Dosis");
        RDD3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RDD3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RDD3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel84Layout = new javax.swing.GroupLayout(jPanel84);
        jPanel84.setLayout(jPanel84Layout);
        jPanel84Layout.setHorizontalGroup(
            jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TNFA3, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
            .addComponent(RDD3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel84Layout.setVerticalGroup(
            jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel84Layout.createSequentialGroup()
                .addComponent(RDD3)
                .addGap(3, 3, 3)
                .addComponent(TNFA3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        TNFUAA3.setEnabled(false);
        TNFUAA3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TNFUAA3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CCDM12Layout = new javax.swing.GroupLayout(CCDM12);
        CCDM12.setLayout(CCDM12Layout);
        CCDM12Layout.setHorizontalGroup(
            CCDM12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CCDM12Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(CCDM12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel81, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(CCDM12Layout.createSequentialGroup()
                        .addGroup(CCDM12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel83, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TNFUAA2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(CCDM12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel84, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TNFUAA3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(1, 1, 1))
        );
        CCDM12Layout.setVerticalGroup(
            CCDM12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CCDM12Layout.createSequentialGroup()
                .addComponent(jPanel81, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(CCDM12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel84, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel83, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(CCDM12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TNFUAA3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TNFUAA2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel75.setBackground(new java.awt.Color(153, 153, 153));

        jLabel66.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(255, 255, 255));
        jLabel66.setText("1a(12 y 18m)");

        javax.swing.GroupLayout jPanel75Layout = new javax.swing.GroupLayout(jPanel75);
        jPanel75.setLayout(jPanel75Layout);
        jPanel75Layout.setHorizontalGroup(
            jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel75Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(149, Short.MAX_VALUE))
        );
        jPanel75Layout.setVerticalGroup(
            jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel75Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel66)
                .addGap(22, 22, 22))
        );

        jPanel76.setBackground(new java.awt.Color(204, 204, 204));

        jLabel67.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setText("2a(24 y 30m)");

        javax.swing.GroupLayout jPanel76Layout = new javax.swing.GroupLayout(jPanel76);
        jPanel76.setLayout(jPanel76Layout);
        jPanel76Layout.setHorizontalGroup(
            jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel76Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );
        jPanel76Layout.setVerticalGroup(
            jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel76Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel67)
                .addGap(20, 20, 20))
        );

        CCDM15.setBackground(new java.awt.Color(255, 255, 255));

        jPanel99.setBackground(new java.awt.Color(153, 153, 153));

        TNFP1.setBackground(new java.awt.Color(255, 255, 255));
        TNFP1.setDateFormatString("dd/MM/yyyy");
        TNFP1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        RDD7.setBackground(new java.awt.Color(153, 153, 153));
        buttonGroup1.add(RDD7);
        RDD7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RDD7.setForeground(new java.awt.Color(255, 255, 255));
        RDD7.setText("1era Dosis");
        RDD7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RDD7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel99Layout = new javax.swing.GroupLayout(jPanel99);
        jPanel99.setLayout(jPanel99Layout);
        jPanel99Layout.setHorizontalGroup(
            jPanel99Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TNFP1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
            .addGroup(jPanel99Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(RDD7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel99Layout.setVerticalGroup(
            jPanel99Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel99Layout.createSequentialGroup()
                .addComponent(RDD7)
                .addGap(3, 3, 3)
                .addComponent(TNFP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel100.setBackground(new java.awt.Color(153, 153, 153));

        TNFP2.setBackground(new java.awt.Color(255, 255, 255));
        TNFP2.setDateFormatString("dd/MM/yyyy");
        TNFP2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        RDD8.setBackground(new java.awt.Color(153, 153, 153));
        buttonGroup1.add(RDD8);
        RDD8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RDD8.setForeground(new java.awt.Color(255, 255, 255));
        RDD8.setText("2da Dosis");
        RDD8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RDD8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel100Layout = new javax.swing.GroupLayout(jPanel100);
        jPanel100.setLayout(jPanel100Layout);
        jPanel100Layout.setHorizontalGroup(
            jPanel100Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel100Layout.createSequentialGroup()
                .addComponent(TNFP2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel100Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(RDD8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel100Layout.setVerticalGroup(
            jPanel100Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel100Layout.createSequentialGroup()
                .addComponent(RDD8)
                .addGap(3, 3, 3)
                .addComponent(TNFP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout CCDM15Layout = new javax.swing.GroupLayout(CCDM15);
        CCDM15.setLayout(CCDM15Layout);
        CCDM15Layout.setHorizontalGroup(
            CCDM15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CCDM15Layout.createSequentialGroup()
                .addGroup(CCDM15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel99, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TNFUAP1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(CCDM15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel100, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TNFUAP2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        CCDM15Layout.setVerticalGroup(
            CCDM15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CCDM15Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(CCDM15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel100, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel99, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(CCDM15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TNFUAP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TNFUAP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        CCDM16.setBackground(new java.awt.Color(255, 255, 255));

        jPanel104.setBackground(new java.awt.Color(153, 153, 153));

        TNFT1.setBackground(new java.awt.Color(255, 255, 255));
        TNFT1.setDateFormatString("dd/MM/yyyy");
        TNFT1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        RDD12.setBackground(new java.awt.Color(153, 153, 153));
        buttonGroup1.add(RDD12);
        RDD12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RDD12.setForeground(new java.awt.Color(255, 255, 255));
        RDD12.setText("1era Dosis");
        RDD12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RDD12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel104Layout = new javax.swing.GroupLayout(jPanel104);
        jPanel104.setLayout(jPanel104Layout);
        jPanel104Layout.setHorizontalGroup(
            jPanel104Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TNFT1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
            .addGroup(jPanel104Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(RDD12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel104Layout.setVerticalGroup(
            jPanel104Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel104Layout.createSequentialGroup()
                .addComponent(RDD12)
                .addGap(3, 3, 3)
                .addComponent(TNFT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel105.setBackground(new java.awt.Color(153, 153, 153));

        TNFT2.setBackground(new java.awt.Color(255, 255, 255));
        TNFT2.setDateFormatString("dd/MM/yyyy");
        TNFT2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        RDD13.setBackground(new java.awt.Color(153, 153, 153));
        buttonGroup1.add(RDD13);
        RDD13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RDD13.setForeground(new java.awt.Color(255, 255, 255));
        RDD13.setText("2da Dosis");
        RDD13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RDD13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel105Layout = new javax.swing.GroupLayout(jPanel105);
        jPanel105.setLayout(jPanel105Layout);
        jPanel105Layout.setHorizontalGroup(
            jPanel105Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel105Layout.createSequentialGroup()
                .addComponent(TNFT2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel105Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(RDD13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel105Layout.setVerticalGroup(
            jPanel105Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel105Layout.createSequentialGroup()
                .addComponent(RDD13)
                .addGap(3, 3, 3)
                .addComponent(TNFT2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout CCDM16Layout = new javax.swing.GroupLayout(CCDM16);
        CCDM16.setLayout(CCDM16Layout);
        CCDM16Layout.setHorizontalGroup(
            CCDM16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CCDM16Layout.createSequentialGroup()
                .addGroup(CCDM16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel104, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TNFUAT1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(CCDM16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel105, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TNFUAT2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        CCDM16Layout.setVerticalGroup(
            CCDM16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CCDM16Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(CCDM16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel105, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel104, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(CCDM16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TNFUAT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TNFUAT2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        lblId.setForeground(new java.awt.Color(255, 255, 255));
        lblId.setText("jLabel1");

        Opciones.setBackground(new java.awt.Color(102, 102, 102));

        jPanel30.setBackground(new java.awt.Color(51, 51, 51));

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

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                .addContainerGap(129, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel30Layout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(69, Short.MAX_VALUE)))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel30Layout.createSequentialGroup()
                    .addGap(1, 1, 1)
                    .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        OpcionesLayout.setVerticalGroup(
            OpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(OpcionesLayout.createSequentialGroup()
                .addComponent(mensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel77.setBackground(new java.awt.Color(153, 153, 153));

        jLabel68.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setText("3a(36 y 42m)");

        javax.swing.GroupLayout jPanel77Layout = new javax.swing.GroupLayout(jPanel77);
        jPanel77.setLayout(jPanel77Layout);
        jPanel77Layout.setHorizontalGroup(
            jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel77Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );
        jPanel77Layout.setVerticalGroup(
            jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel77Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel68)
                .addGap(20, 20, 20))
        );

        jPanel106.setBackground(new java.awt.Color(153, 153, 153));

        TNFT3.setBackground(new java.awt.Color(255, 255, 255));
        TNFT3.setDateFormatString("dd/MM/yyyy");
        TNFT3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        RDD14.setBackground(new java.awt.Color(153, 153, 153));
        buttonGroup1.add(RDD14);
        RDD14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RDD14.setForeground(new java.awt.Color(255, 255, 255));
        RDD14.setText("2da Dosis");
        RDD14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RDD14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel106Layout = new javax.swing.GroupLayout(jPanel106);
        jPanel106.setLayout(jPanel106Layout);
        jPanel106Layout.setHorizontalGroup(
            jPanel106Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel106Layout.createSequentialGroup()
                .addComponent(TNFT3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel106Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(RDD14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel106Layout.setVerticalGroup(
            jPanel106Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel106Layout.createSequentialGroup()
                .addComponent(RDD14)
                .addGap(3, 3, 3)
                .addComponent(TNFT3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel107.setBackground(new java.awt.Color(153, 153, 153));

        TNFT4.setBackground(new java.awt.Color(255, 255, 255));
        TNFT4.setDateFormatString("dd/MM/yyyy");
        TNFT4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        RDD15.setBackground(new java.awt.Color(153, 153, 153));
        buttonGroup1.add(RDD15);
        RDD15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RDD15.setForeground(new java.awt.Color(255, 255, 255));
        RDD15.setText("1era Dosis");
        RDD15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RDD15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel107Layout = new javax.swing.GroupLayout(jPanel107);
        jPanel107.setLayout(jPanel107Layout);
        jPanel107Layout.setHorizontalGroup(
            jPanel107Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TNFT4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
            .addGroup(jPanel107Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(RDD15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel107Layout.setVerticalGroup(
            jPanel107Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel107Layout.createSequentialGroup()
                .addComponent(RDD15)
                .addGap(3, 3, 3)
                .addComponent(TNFT4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel78.setBackground(new java.awt.Color(204, 204, 204));

        jLabel69.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 255, 255));
        jLabel69.setText("4a(36 y 42m)");

        javax.swing.GroupLayout jPanel78Layout = new javax.swing.GroupLayout(jPanel78);
        jPanel78.setLayout(jPanel78Layout);
        jPanel78Layout.setHorizontalGroup(
            jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel78Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );
        jPanel78Layout.setVerticalGroup(
            jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel78Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel69)
                .addGap(20, 20, 20))
        );

        jPanel108.setBackground(new java.awt.Color(153, 153, 153));

        TNFT5.setBackground(new java.awt.Color(255, 255, 255));
        TNFT5.setDateFormatString("dd/MM/yyyy");
        TNFT5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        RDD16.setBackground(new java.awt.Color(153, 153, 153));
        buttonGroup1.add(RDD16);
        RDD16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RDD16.setForeground(new java.awt.Color(255, 255, 255));
        RDD16.setText("1era Dosis");
        RDD16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RDD16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel108Layout = new javax.swing.GroupLayout(jPanel108);
        jPanel108.setLayout(jPanel108Layout);
        jPanel108Layout.setHorizontalGroup(
            jPanel108Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TNFT5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel108Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(RDD16)
                .addGap(15, 15, 15))
        );
        jPanel108Layout.setVerticalGroup(
            jPanel108Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel108Layout.createSequentialGroup()
                .addComponent(RDD16)
                .addGap(3, 3, 3)
                .addComponent(TNFT5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel109.setBackground(new java.awt.Color(153, 153, 153));

        TNFT6.setBackground(new java.awt.Color(255, 255, 255));
        TNFT6.setDateFormatString("dd/MM/yyyy");
        TNFT6.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        RDD17.setBackground(new java.awt.Color(153, 153, 153));
        buttonGroup1.add(RDD17);
        RDD17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RDD17.setForeground(new java.awt.Color(255, 255, 255));
        RDD17.setText("2da Dosis");
        RDD17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RDD17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel109Layout = new javax.swing.GroupLayout(jPanel109);
        jPanel109.setLayout(jPanel109Layout);
        jPanel109Layout.setHorizontalGroup(
            jPanel109Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel109Layout.createSequentialGroup()
                .addComponent(TNFT6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel109Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(RDD17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel109Layout.setVerticalGroup(
            jPanel109Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel109Layout.createSequentialGroup()
                .addComponent(RDD17)
                .addGap(3, 3, 3)
                .addComponent(TNFT6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel26.setBackground(new java.awt.Color(243, 156, 17));
        jPanel26.setPreferredSize(new java.awt.Dimension(83, 45));

        jLabel10.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Suplementación Con Vitamina A");

        jPanel27.setBackground(new java.awt.Color(210, 84, 0));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Izquierda Filled-30.png"))); // NOI18N
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        lblPorcentajeV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblPorcentajeV.setForeground(new java.awt.Color(255, 255, 255));
        lblPorcentajeV.setText("100 %  Completado");
        lblPorcentajeV.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblNina.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        lblNina.setForeground(new java.awt.Color(255, 255, 255));
        lblNina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Niña-50.png"))); // NOI18N
        lblNina.setText("NIÑOS");
        lblNina.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblNina.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        lblNino.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        lblNino.setForeground(new java.awt.Color(255, 255, 255));
        lblNino.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Niño-50.png"))); // NOI18N
        lblNino.setText("NIÑOS");
        lblNino.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblNino.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPorcentajeV)
                    .addComponent(jLabel10))
                .addGap(63, 63, 63)
                .addComponent(lblNina, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNino, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(338, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblPorcentajeV, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNina)
                    .addComponent(lblNino))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout CCDLayout = new javax.swing.GroupLayout(CCD);
        CCD.setLayout(CCDLayout);
        CCDLayout.setHorizontalGroup(
            CCDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Opciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(CCDLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CCDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblId)
                    .addGroup(CCDLayout.createSequentialGroup()
                        .addGroup(CCDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LEYENDA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel75, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel76, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(CCDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CCDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(CCDM16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CCDM15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(CCDM12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(CCDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CCDLayout.createSequentialGroup()
                                .addComponent(jPanel77, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addGroup(CCDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel107, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TNFUAT4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addGroup(CCDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel106, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TNFUAT3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(CCDLayout.createSequentialGroup()
                                .addComponent(jPanel78, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addGroup(CCDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel108, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TNFUAT6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addGroup(CCDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel109, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TNFUAT5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(749, Short.MAX_VALUE))
            .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, 1769, Short.MAX_VALUE)
        );
        CCDLayout.setVerticalGroup(
            CCDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CCDLayout.createSequentialGroup()
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(CCDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CCDLayout.createSequentialGroup()
                        .addGroup(CCDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CCDM12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LEYENDA, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGroup(CCDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CCDM15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel75, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, 0)
                        .addGroup(CCDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CCDM16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel76, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                        .addComponent(lblId))
                    .addGroup(CCDLayout.createSequentialGroup()
                        .addGroup(CCDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel77, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, CCDLayout.createSequentialGroup()
                                .addGroup(CCDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jPanel106, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel107, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(CCDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TNFUAT4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TNFUAT3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, 0)
                        .addGroup(CCDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel78, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, CCDLayout.createSequentialGroup()
                                .addGroup(CCDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jPanel109, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel108, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(CCDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TNFUAT6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TNFUAT5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 187, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(Opciones, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1769, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(CCD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(CCD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RDD2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RDD2ActionPerformed
        if(TNFA2.getDate()==null){
            if(RDD2.isSelected()){
                habilitarDatos(false);
                habilitarRadio(false);
                Botones(true);
                TNFUAA2.setEnabled(true);
                TNFA2.setEnabled(true);
                TNFUAA2.setEditable(false); 
                fecha=TNFA2;
                fua = TNFUAA2;
                fua.setText(RegistroSeguimiento.lblFua.getText());
            }
        } else {
            RDD2.setEnabled(false);
        }
    }//GEN-LAST:event_RDD2ActionPerformed

    private void RDD3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RDD3ActionPerformed
        if(TNFA3.getDate()==null){
            if(RDD3.isSelected()){
                habilitarDatos(false);
                habilitarRadio(false);
                Botones(true);
                TNFUAA3.setEnabled(true);
                TNFA3.setEnabled(true);
                TNFUAA3.setEditable(false); 
                fecha=TNFA3;
                fua = TNFUAA3;
                fua.setText(RegistroSeguimiento.lblFua.getText());
            }
        } else {
            RDD3.setEnabled(false);
        }
    }//GEN-LAST:event_RDD3ActionPerformed

    private void RDD7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RDD7ActionPerformed
        if(TNFP1.getDate()==null){
            if(RDD7.isSelected()){
                habilitarDatos(false);
                habilitarRadio(false);
                Botones(true);
                TNFUAP1.setEnabled(true);
                TNFP1.setEnabled(true);
                TNFUAP1.setEditable(false); 
                fecha=TNFP1;
                fua = TNFUAP1;
                fua.setText(RegistroSeguimiento.lblFua.getText());
            }
        } else {
            RDD7.setEnabled(false);
        }
    }//GEN-LAST:event_RDD7ActionPerformed

    private void RDD8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RDD8ActionPerformed
        if(TNFP2.getDate()==null){
            if(RDD8.isSelected()){
                habilitarDatos(false);
                habilitarRadio(false);
                Botones(true);
                TNFUAP2.setEnabled(true);
                TNFP2.setEnabled(true);
                TNFUAP2.setEditable(false); 
                fecha=TNFP1;
                fua = TNFUAP2;
                fua.setText(RegistroSeguimiento.lblFua.getText());
            }
        } else {
            RDD8.setEnabled(false);
        }
    }//GEN-LAST:event_RDD8ActionPerformed

    private void RDD12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RDD12ActionPerformed
        if(TNFT1.getDate()==null){
            if(RDD12.isSelected()){
                habilitarDatos(false);
                habilitarRadio(false);
                Botones(true);
                TNFUAT1.setEnabled(true);
                TNFT1.setEnabled(true);
                TNFUAT1.setEditable(false); 
                fecha=TNFT1;
                fua = TNFUAT1;
                fua.setText(RegistroSeguimiento.lblFua.getText());
            }
        } else {
            RDD12.setEnabled(false);
        }
    }//GEN-LAST:event_RDD12ActionPerformed

    private void RDD13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RDD13ActionPerformed
        if(TNFT2.getDate()==null){
            if(RDD13.isSelected()){
                habilitarDatos(false);
                habilitarRadio(false);
                Botones(true);
                TNFUAT2.setEnabled(true);
                TNFT2.setEnabled(true);
                TNFUAT2.setEditable(false); 
                fecha=TNFT2;
                fua = TNFUAT2;
                fua.setText(RegistroSeguimiento.lblFua.getText());
            }
        } else {
            RDD13.setEnabled(false);
        }
    }//GEN-LAST:event_RDD13ActionPerformed

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

    private void TNFUAA3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TNFUAA3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TNFUAA3ActionPerformed

    private void RDD14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RDD14ActionPerformed
        if(TNFT3.getDate()==null){
            if(RDD14.isSelected()){
                habilitarDatos(false);
                habilitarRadio(false);
                Botones(true);
                TNFUAT3.setEnabled(true);
                TNFT3.setEnabled(true);
                TNFUAT3.setEditable(false); 
                fecha=TNFT3;
                fua = TNFUAT3;
                fua.setText(RegistroSeguimiento.lblFua.getText());
            }
        } else {
            RDD14.setEnabled(false);
        }
    }//GEN-LAST:event_RDD14ActionPerformed

    private void RDD15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RDD15ActionPerformed
        if(TNFT4.getDate()==null){
            if(RDD15.isSelected()){
                habilitarDatos(false);
                habilitarRadio(false);
                Botones(true);
                TNFUAT4.setEnabled(true);
                TNFT4.setEnabled(true);
                TNFUAT4.setEditable(false); 
                fecha=TNFT4;
                fua = TNFUAT4;
                fua.setText(RegistroSeguimiento.lblFua.getText());
            }
        } else {
            RDD15.setEnabled(false);
        }
    }//GEN-LAST:event_RDD15ActionPerformed

    private void RDD16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RDD16ActionPerformed
        if(TNFT5.getDate()==null){
            if(RDD16.isSelected()){
                habilitarDatos(false);
                habilitarRadio(false);
                Botones(true);
                TNFUAT6.setEnabled(true);
                TNFT5.setEnabled(true);
                TNFUAT6.setEditable(false); 
                fecha=TNFT5;
                fua = TNFUAT6;
                fua.setText(RegistroSeguimiento.lblFua.getText());
            }
        } else {
            RDD16.setEnabled(false);
        }
    }//GEN-LAST:event_RDD16ActionPerformed

    private void RDD17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RDD17ActionPerformed
        if(TNFT6.getDate()==null){
            if(RDD17.isSelected()){
                habilitarDatos(false);
                habilitarRadio(false);
                Botones(true);
                TNFUAT5.setEnabled(true);
                TNFT6.setEnabled(true);
                TNFUAT5.setEditable(false); 
                fecha=TNFT6;
                fua = TNFUAT5;
                fua.setText(RegistroSeguimiento.lblFua.getText());
            }
        } else {
            RDD17.setEnabled(false);
        }
    }//GEN-LAST:event_RDD17ActionPerformed

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        RegistroSeguimiento.jTabbedPane1.setSelectedIndex(2);
        this.dispose();
    }//GEN-LAST:event_jLabel13MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CCD;
    private javax.swing.JPanel CCDM12;
    private javax.swing.JPanel CCDM15;
    private javax.swing.JPanel CCDM16;
    private javax.swing.JPanel LEYENDA;
    private javax.swing.JPanel Opciones;
    private javax.swing.JRadioButton RDD12;
    private javax.swing.JRadioButton RDD13;
    private javax.swing.JRadioButton RDD14;
    private javax.swing.JRadioButton RDD15;
    private javax.swing.JRadioButton RDD16;
    private javax.swing.JRadioButton RDD17;
    private javax.swing.JRadioButton RDD2;
    private javax.swing.JRadioButton RDD3;
    private javax.swing.JRadioButton RDD7;
    private javax.swing.JRadioButton RDD8;
    public static com.toedter.calendar.JDateChooser TNFA2;
    public static com.toedter.calendar.JDateChooser TNFA3;
    public static com.toedter.calendar.JDateChooser TNFP1;
    public static com.toedter.calendar.JDateChooser TNFP2;
    public static com.toedter.calendar.JDateChooser TNFT1;
    public static com.toedter.calendar.JDateChooser TNFT2;
    public static com.toedter.calendar.JDateChooser TNFT3;
    public static com.toedter.calendar.JDateChooser TNFT4;
    public static com.toedter.calendar.JDateChooser TNFT5;
    public static com.toedter.calendar.JDateChooser TNFT6;
    public static javax.swing.JTextField TNFUAA2;
    public static javax.swing.JTextField TNFUAA3;
    public static javax.swing.JTextField TNFUAP1;
    public static javax.swing.JTextField TNFUAP2;
    public static javax.swing.JTextField TNFUAT1;
    public static javax.swing.JTextField TNFUAT2;
    public static javax.swing.JTextField TNFUAT3;
    public static javax.swing.JTextField TNFUAT4;
    public static javax.swing.JTextField TNFUAT5;
    public static javax.swing.JTextField TNFUAT6;
    private javax.swing.JButton b;
    private javax.swing.JButton b1;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JPanel jPanel100;
    private javax.swing.JPanel jPanel104;
    private javax.swing.JPanel jPanel105;
    private javax.swing.JPanel jPanel106;
    private javax.swing.JPanel jPanel107;
    private javax.swing.JPanel jPanel108;
    private javax.swing.JPanel jPanel109;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel72;
    private javax.swing.JPanel jPanel73;
    private javax.swing.JPanel jPanel74;
    private javax.swing.JPanel jPanel75;
    private javax.swing.JPanel jPanel76;
    private javax.swing.JPanel jPanel77;
    private javax.swing.JPanel jPanel78;
    private javax.swing.JPanel jPanel81;
    private javax.swing.JPanel jPanel83;
    private javax.swing.JPanel jPanel84;
    private javax.swing.JPanel jPanel99;
    public static javax.swing.JLabel lblId;
    public static javax.swing.JLabel lblNina;
    public static javax.swing.JLabel lblNino;
    public static javax.swing.JLabel lblPorcentajeV;
    private javax.swing.JLabel men;
    private javax.swing.JPanel mensaje;
    // End of variables declaration//GEN-END:variables
}
