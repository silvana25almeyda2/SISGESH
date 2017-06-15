/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelos.hospitalizacion.HospitalizacionPapeletas;
import servicios.Conexion;
import vista.ALMACEN.frm_Asig_Catalogo_Producto;
import vista.COSTOS.BUSCAR_ESTIMACION_COSTOS;
import vista.COSTOS.BUSCAR_NOMENCLATURA;
import vista.COSTOS.COSTOS_PRODUCTO_REFERENCIAL;
import vista.COSTOS.COSTOS_SERVICIOS_VARIOS;
import vista.COSTOS.Costos_Depreciacion;
import vista.COSTOS.TipoSustentacion;
import vista.Caja.Caja_Empresa_jerarquia;
import vista.Caja.Caja_Nomenclaturas;
import vista.Caja.Caja_Pagos;
import vista.ConsultorioEx.ConsultorioExt;
import vista.ConsultorioEx.RegistroEmbarazo;
import vista.ConsultorioEx.RegistroSeguimiento;
import vista.ConsultorioEx.Triaje;
import vista.EC.EC_BUSCAR_EXAMEN_CAJA;
import vista.LABORATORIO.frm_LAB_ESQUEMA_RESULTADO_INGRESO;
import vista.LABORATORIO.frm_LAB_MUESTRA_EXAMEN;
import vista.LABORATORIO.frm_LAB_VALORES_REFERENCIALES_INGRESO;
import vista.admisionCentral.FrmMovimientoHC;
import vista.admisionCentral.FrmNuevaHistoriaC;
import vista.admisionCentral.FrmSeguimientoHC;
import vista.admisionEmergencia.FrmFormaDeLlegada;
import vista.admisionEmergencia.FrmFormatoEmergencia;
import vista.admisionEmergencia.FrmListFormatoEmergencia;
import vista.hospitalizacion.FrmHospitalizacionCamas;
import vista.hospitalizacion.FrmHospitalizacionHabitaciones;
import vista.hospitalizacion.FrmHospitalizacionCajaPreventa;
import vista.hospitalizacion.FrmHospitalizacionPisos;
import vista.sectorizacion.FrmSector;
import vista.LABORATORIO.*;
import vista.Programas.frm_SOLICITUD_INVESTIGACION_BACT;
import vista.RX.RX_EC_BUSCAR_EXAMEN_C;
import vista.hospitalizacion.FrmHospitalizacionEpicrisis;
import vista.hospitalizacion.FrmHospitalizacionExClinico;
import vista.hospitalizacion.FrmHospitalizacionFormatoHC;
import vista.hospitalizacion.FrmHospitalizacionListarCajaPreventa;
import vista.hospitalizacion.FrmHospitalizacionNotaEnfermeria;
import vista.RX.RX_EC_BUSCAR_EXAMEN_RESULTADO;
import vista.RX.RX_EC_BUSCAR_RESULTADOS;

/**
 *
 * @author USUARIO
 */
public class PrincipalMDI extends javax.swing.JFrame {

    Conexion con = new Conexion();
    public PrincipalMDI() {
        initComponents();
//        lblServicio.setText(mostrarServicioHosp());
        jTabbedPane1.setBackgroundAt(0, Color.white);
         this.getContentPane().setBackground(Color.WHITE);
         
         p1.setVisible(false);
         p2.setVisible(false);
         p3.setVisible(false);
         p4.setVisible(false);
         p9.setVisible(false);
         p10.setVisible(false); 
         p11.setVisible(false);
         p12.setVisible(false);     
         p13.setVisible(false);  
         p14.setVisible(false); 
         p15.setVisible(false); 
         p16.setVisible(false); 
         p17.setVisible(false);

//        cerrartodo();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        //ICONO DE FORMULARIO
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/iconos/icons8-Tarea del sistema-24.png")).getImage());
    }
    
    public void mostrarServicioHosp(){
        String desc = "";
        String id = "";
        try {
            String consulta = "EXEC HOSPITALIZACION_MOSTRAR_SERVICIO";
            ResultSet r;
            r=con.Listar(consulta);
        while(r.next()){
               lblSe_ID.setText(r.getString(1));
               lblServicio.setText(r.getString(2));
        }
        }catch(Exception ex){
            System.out.println("Error: PrincipalMDI - mostrarServicioHosp: " + ex.getMessage());
        }
    }
    
//    public void cerrar(){
//        Object [] opciones ={"SI","NO"};
//        int eleccion = JOptionPane.showOptionDialog(rootPane,"¿Desea realmente salir del modulo?","Mensaje de Confirmacion",
//        JOptionPane.YES_NO_OPTION,
//        JOptionPane.QUESTION_MESSAGE,null,opciones,"Aceptar");
//        if (eleccion == JOptionPane.YES_OPTION)
//        {
//            dispose();   
//            Principal pr= new Principal();
//            pr.setVisible(true);  
//        }else{
//        }
//    }
    
        //cerrar
//    public void cerrartodo (){
//        try {
//            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//            addWindowListener(new WindowAdapter() {
//                public void windowClosing(WindowEvent e){
//                    cerrar();
//                }
//});
//            this.setVisible(true);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnAdmCentral = new javax.swing.JButton();
        btnCaja = new javax.swing.JButton();
        btnLaboratorio = new javax.swing.JButton();
        p2 = new javax.swing.JPanel();
        p1 = new javax.swing.JPanel();
        p3 = new javax.swing.JPanel();
        btnCostos = new javax.swing.JButton();
        btnRayosX = new javax.swing.JButton();
        btnHospitalizacion = new javax.swing.JButton();
        p9 = new javax.swing.JPanel();
        p10 = new javax.swing.JPanel();
        p11 = new javax.swing.JPanel();
        btnInvBact = new javax.swing.JButton();
        p12 = new javax.swing.JPanel();
        btnAdmEme = new javax.swing.JButton();
        p4 = new javax.swing.JPanel();
        btnConfiguracion = new javax.swing.JButton();
        p13 = new javax.swing.JPanel();
        btnConExt = new javax.swing.JButton();
        p14 = new javax.swing.JPanel();
        btnAlmacen = new javax.swing.JButton();
        p15 = new javax.swing.JPanel();
        btnPersonal = new javax.swing.JButton();
        p16 = new javax.swing.JPanel();
        btnEcografia = new javax.swing.JButton();
        p17 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btneditar1 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btnguardar1 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        btnguardar4 = new javax.swing.JButton();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        btneditar5 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        btneditar6 = new javax.swing.JButton();
        jPanel77 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        btneditar8 = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        btneditar9 = new javax.swing.JButton();
        jPanel76 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        btnguardar8 = new javax.swing.JButton();
        jPanel20 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        btnguardar9 = new javax.swing.JButton();
        jPanel68 = new javax.swing.JPanel();
        btneditar4 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jPanel72 = new javax.swing.JPanel();
        btneditar7 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jPanel59 = new javax.swing.JPanel();
        jPanel61 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        btnPaciente = new javax.swing.JButton();
        jPanel64 = new javax.swing.JPanel();
        btnSectorizacion = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jPanel103 = new javax.swing.JPanel();
        btnReporteAdmiCentral = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        btnReportMovinientoHC = new javax.swing.JButton();
        jPanel26 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        btnReportSeguimientoHC = new javax.swing.JButton();
        jPanel23 = new javax.swing.JPanel();
        lblusu3 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        lblusu5 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        btneditar11 = new javax.swing.JButton();
        jPanel39 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        btnMuestras = new javax.swing.JButton();
        jPanel41 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        btnEsquema = new javax.swing.JButton();
        jPanel43 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        btnValores = new javax.swing.JButton();
        jPanel32 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        btnUnidadMedi = new javax.swing.JButton();
        jPanel40 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        btnAnalisis = new javax.swing.JButton();
        jPanel42 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        btnClasificacion = new javax.swing.JButton();
        jPanel44 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        btnContenedor = new javax.swing.JButton();
        jPanel75 = new javax.swing.JPanel();
        jLabel88 = new javax.swing.JLabel();
        jPanel78 = new javax.swing.JPanel();
        jLabel89 = new javax.swing.JLabel();
        btnTM = new javax.swing.JButton();
        jPanel79 = new javax.swing.JPanel();
        jLabel94 = new javax.swing.JLabel();
        btnTMBusqueda = new javax.swing.JButton();
        jPanel80 = new javax.swing.JPanel();
        jLabel95 = new javax.swing.JLabel();
        jPanel81 = new javax.swing.JPanel();
        jLabel96 = new javax.swing.JLabel();
        btnResultado = new javax.swing.JButton();
        jPanel82 = new javax.swing.JPanel();
        jLabel97 = new javax.swing.JLabel();
        btnResultadoBusq = new javax.swing.JButton();
        jPanel83 = new javax.swing.JPanel();
        jLabel98 = new javax.swing.JLabel();
        btnEntrega = new javax.swing.JButton();
        jPanel84 = new javax.swing.JPanel();
        jLabel99 = new javax.swing.JLabel();
        btnConversion = new javax.swing.JButton();
        jPanel85 = new javax.swing.JPanel();
        jLabel100 = new javax.swing.JLabel();
        btnSolicitudRecep = new javax.swing.JButton();
        jPanel46 = new javax.swing.JPanel();
        jPanel47 = new javax.swing.JPanel();
        btneditar14 = new javax.swing.JButton();
        jPanel48 = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        btneditar15 = new javax.swing.JButton();
        jPanel55 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        jPanel56 = new javax.swing.JPanel();
        btneditar17 = new javax.swing.JButton();
        jPanel89 = new javax.swing.JPanel();
        jLabel101 = new javax.swing.JLabel();
        jPanel54 = new javax.swing.JPanel();
        jPanel49 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jPanel50 = new javax.swing.JPanel();
        jPanel51 = new javax.swing.JPanel();
        jPanel52 = new javax.swing.JPanel();
        jPanel53 = new javax.swing.JPanel();
        jPanel94 = new javax.swing.JPanel();
        btneditar16 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel57 = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        jPanel60 = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        btnguardar24 = new javax.swing.JButton();
        jPanel62 = new javax.swing.JPanel();
        jLabel83 = new javax.swing.JLabel();
        btnguardar26 = new javax.swing.JButton();
        jPanel63 = new javax.swing.JPanel();
        jLabel84 = new javax.swing.JLabel();
        btnguardar27 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lblServicio = new javax.swing.JLabel();
        lblSe_ID = new javax.swing.JLabel();
        jPanel65 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jPanel88 = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
        jPanel95 = new javax.swing.JPanel();
        jLabel102 = new javax.swing.JLabel();
        jPanel96 = new javax.swing.JPanel();
        jPanel58 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jPanel67 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jPanel97 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jPanel98 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel99 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel100 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jPanel101 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jPanel102 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jPanel66 = new javax.swing.JPanel();
        jPanel73 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        btnMantLlegada1 = new javax.swing.JButton();
        jPanel74 = new javax.swing.JPanel();
        jLabel86 = new javax.swing.JLabel();
        btnFormatEmergencia1 = new javax.swing.JButton();
        jLabel87 = new javax.swing.JLabel();
        jPanel104 = new javax.swing.JPanel();
        jPanel105 = new javax.swing.JPanel();
        jLabel90 = new javax.swing.JLabel();
        btnFormatEmergencia3 = new javax.swing.JButton();
        jPanel24 = new javax.swing.JPanel();
        lblusu7 = new javax.swing.JLabel();
        jPanel106 = new javax.swing.JPanel();
        btnMantLlegada2 = new javax.swing.JButton();
        jLabel92 = new javax.swing.JLabel();
        jPanel107 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        btnReporteFEmer1 = new javax.swing.JButton();
        jPanel69 = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        btnReportCabecera1 = new javax.swing.JButton();
        jPanel70 = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        btnReporTopico1 = new javax.swing.JButton();
        jPanel71 = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        btnReportTriaje1 = new javax.swing.JButton();
        jPanel29 = new javax.swing.JPanel();
        lblusu8 = new javax.swing.JLabel();
        jPanel45 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        btnSolicitudInv = new javax.swing.JButton();
        jPanel86 = new javax.swing.JPanel();
        jPanel87 = new javax.swing.JPanel();
        jPanel90 = new javax.swing.JPanel();
        jLabel104 = new javax.swing.JLabel();
        btnConsultorio = new javax.swing.JButton();
        jPanel91 = new javax.swing.JPanel();
        jLabel105 = new javax.swing.JLabel();
        btnTriaje = new javax.swing.JButton();
        jPanel92 = new javax.swing.JPanel();
        jLabel106 = new javax.swing.JLabel();
        btnValores3 = new javax.swing.JButton();
        jPanel93 = new javax.swing.JPanel();
        jLabel107 = new javax.swing.JLabel();
        btnCarnetPerinatal = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jPanel108 = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        lblusu9 = new javax.swing.JLabel();
        jPanel109 = new javax.swing.JPanel();
        jButton13 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jButton14 = new javax.swing.JButton();
        jPanel110 = new javax.swing.JPanel();
        jButton15 = new javax.swing.JButton();
        jPanel27 = new javax.swing.JPanel();
        jButton17 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        lblusu10 = new javax.swing.JLabel();
        jPanel111 = new javax.swing.JPanel();
        jButton16 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jPanel112 = new javax.swing.JPanel();
        jButton19 = new javax.swing.JButton();
        jPanel31 = new javax.swing.JPanel();
        jButton20 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        lblUsu = new javax.swing.JLabel();
        btnguardar3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Gestion Hospitalaria - Modulo Administracion del Sistema");
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(43, 43, 43));

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/icons8-Tarea del sistema-60.png"))); // NOI18N
        jLabel1.setText("HIMS");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel1.setIconTextGap(15);

        btnAdmCentral.setBackground(new java.awt.Color(102, 102, 102));
        btnAdmCentral.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        btnAdmCentral.setForeground(new java.awt.Color(255, 255, 255));
        btnAdmCentral.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Recepción-30.png"))); // NOI18N
        btnAdmCentral.setText("Admisión Central");
        btnAdmCentral.setToolTipText("");
        btnAdmCentral.setContentAreaFilled(false);
        btnAdmCentral.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdmCentral.setFocusPainted(false);
        btnAdmCentral.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAdmCentral.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAdmCentral.setIconTextGap(30);
        btnAdmCentral.setVerifyInputWhenFocusTarget(false);
        btnAdmCentral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdmCentralActionPerformed(evt);
            }
        });

        btnCaja.setBackground(new java.awt.Color(102, 102, 102));
        btnCaja.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        btnCaja.setForeground(new java.awt.Color(255, 255, 255));
        btnCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Caja fuerte-30.png"))); // NOI18N
        btnCaja.setMnemonic('N');
        btnCaja.setText("Caja");
        btnCaja.setContentAreaFilled(false);
        btnCaja.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCaja.setFocusPainted(false);
        btnCaja.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCaja.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCaja.setIconTextGap(30);
        btnCaja.setVerifyInputWhenFocusTarget(false);
        btnCaja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCajaMouseEntered(evt);
            }
        });
        btnCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCajaActionPerformed(evt);
            }
        });

        btnLaboratorio.setBackground(new java.awt.Color(102, 102, 102));
        btnLaboratorio.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        btnLaboratorio.setForeground(new java.awt.Color(255, 255, 255));
        btnLaboratorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Tubo de ensayo-30.png"))); // NOI18N
        btnLaboratorio.setMnemonic('N');
        btnLaboratorio.setText("Laboratorio");
        btnLaboratorio.setContentAreaFilled(false);
        btnLaboratorio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLaboratorio.setFocusPainted(false);
        btnLaboratorio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnLaboratorio.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnLaboratorio.setIconTextGap(30);
        btnLaboratorio.setVerifyInputWhenFocusTarget(false);
        btnLaboratorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaboratorioActionPerformed(evt);
            }
        });

        p2.setBackground(new java.awt.Color(25, 188, 157));

        javax.swing.GroupLayout p2Layout = new javax.swing.GroupLayout(p2);
        p2.setLayout(p2Layout);
        p2Layout.setHorizontalGroup(
            p2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );
        p2Layout.setVerticalGroup(
            p2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );

        p1.setBackground(new java.awt.Color(25, 188, 157));

        javax.swing.GroupLayout p1Layout = new javax.swing.GroupLayout(p1);
        p1.setLayout(p1Layout);
        p1Layout.setHorizontalGroup(
            p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );
        p1Layout.setVerticalGroup(
            p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );

        p3.setBackground(new java.awt.Color(25, 188, 157));

        javax.swing.GroupLayout p3Layout = new javax.swing.GroupLayout(p3);
        p3.setLayout(p3Layout);
        p3Layout.setHorizontalGroup(
            p3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );
        p3Layout.setVerticalGroup(
            p3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );

        btnCostos.setBackground(new java.awt.Color(102, 102, 102));
        btnCostos.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        btnCostos.setForeground(new java.awt.Color(255, 255, 255));
        btnCostos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Dinero-30.png"))); // NOI18N
        btnCostos.setMnemonic('N');
        btnCostos.setText("Costos");
        btnCostos.setContentAreaFilled(false);
        btnCostos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCostos.setFocusPainted(false);
        btnCostos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCostos.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCostos.setIconTextGap(30);
        btnCostos.setVerifyInputWhenFocusTarget(false);
        btnCostos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCostosActionPerformed(evt);
            }
        });

        btnRayosX.setBackground(new java.awt.Color(102, 102, 102));
        btnRayosX.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        btnRayosX.setForeground(new java.awt.Color(255, 255, 255));
        btnRayosX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/X-ray-30.png"))); // NOI18N
        btnRayosX.setText("Rayos X ");
        btnRayosX.setContentAreaFilled(false);
        btnRayosX.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRayosX.setFocusPainted(false);
        btnRayosX.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnRayosX.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnRayosX.setIconTextGap(30);
        btnRayosX.setVerifyInputWhenFocusTarget(false);
        btnRayosX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRayosXActionPerformed(evt);
            }
        });

        btnHospitalizacion.setBackground(new java.awt.Color(102, 102, 102));
        btnHospitalizacion.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        btnHospitalizacion.setForeground(new java.awt.Color(255, 255, 255));
        btnHospitalizacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Hospital-30.png"))); // NOI18N
        btnHospitalizacion.setText("Hospitalización");
        btnHospitalizacion.setContentAreaFilled(false);
        btnHospitalizacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHospitalizacion.setFocusPainted(false);
        btnHospitalizacion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnHospitalizacion.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnHospitalizacion.setIconTextGap(30);
        btnHospitalizacion.setVerifyInputWhenFocusTarget(false);
        btnHospitalizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHospitalizacionActionPerformed(evt);
            }
        });

        p9.setBackground(new java.awt.Color(25, 188, 157));

        javax.swing.GroupLayout p9Layout = new javax.swing.GroupLayout(p9);
        p9.setLayout(p9Layout);
        p9Layout.setHorizontalGroup(
            p9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );
        p9Layout.setVerticalGroup(
            p9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );

        p10.setBackground(new java.awt.Color(25, 188, 157));

        javax.swing.GroupLayout p10Layout = new javax.swing.GroupLayout(p10);
        p10.setLayout(p10Layout);
        p10Layout.setHorizontalGroup(
            p10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );
        p10Layout.setVerticalGroup(
            p10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );

        p11.setBackground(new java.awt.Color(25, 188, 157));

        javax.swing.GroupLayout p11Layout = new javax.swing.GroupLayout(p11);
        p11.setLayout(p11Layout);
        p11Layout.setHorizontalGroup(
            p11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );
        p11Layout.setVerticalGroup(
            p11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );

        btnInvBact.setBackground(new java.awt.Color(102, 102, 102));
        btnInvBact.setFont(new java.awt.Font("Segoe UI Light", 0, 17)); // NOI18N
        btnInvBact.setForeground(new java.awt.Color(255, 255, 255));
        btnInvBact.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Péptido-30.png"))); // NOI18N
        btnInvBact.setText("<html>Investigación Bactereológica");
        btnInvBact.setContentAreaFilled(false);
        btnInvBact.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInvBact.setFocusPainted(false);
        btnInvBact.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnInvBact.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnInvBact.setIconTextGap(30);
        btnInvBact.setVerifyInputWhenFocusTarget(false);
        btnInvBact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInvBactActionPerformed(evt);
            }
        });

        p12.setBackground(new java.awt.Color(25, 188, 157));

        javax.swing.GroupLayout p12Layout = new javax.swing.GroupLayout(p12);
        p12.setLayout(p12Layout);
        p12Layout.setHorizontalGroup(
            p12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );
        p12Layout.setVerticalGroup(
            p12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );

        btnAdmEme.setBackground(new java.awt.Color(102, 102, 102));
        btnAdmEme.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        btnAdmEme.setForeground(new java.awt.Color(255, 255, 255));
        btnAdmEme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Ambulancia-30.png"))); // NOI18N
        btnAdmEme.setMnemonic('N');
        btnAdmEme.setText("Admisión Emergencia");
        btnAdmEme.setContentAreaFilled(false);
        btnAdmEme.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdmEme.setFocusPainted(false);
        btnAdmEme.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAdmEme.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAdmEme.setIconTextGap(30);
        btnAdmEme.setVerifyInputWhenFocusTarget(false);
        btnAdmEme.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAdmEmeMouseEntered(evt);
            }
        });
        btnAdmEme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdmEmeActionPerformed(evt);
            }
        });

        p4.setBackground(new java.awt.Color(25, 188, 157));

        javax.swing.GroupLayout p4Layout = new javax.swing.GroupLayout(p4);
        p4.setLayout(p4Layout);
        p4Layout.setHorizontalGroup(
            p4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );
        p4Layout.setVerticalGroup(
            p4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );

        btnConfiguracion.setBackground(new java.awt.Color(102, 102, 102));
        btnConfiguracion.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        btnConfiguracion.setForeground(new java.awt.Color(255, 255, 255));
        btnConfiguracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Ajustes-30.png"))); // NOI18N
        btnConfiguracion.setText("Configuracion");
        btnConfiguracion.setContentAreaFilled(false);
        btnConfiguracion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfiguracion.setFocusPainted(false);
        btnConfiguracion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnConfiguracion.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnConfiguracion.setIconTextGap(30);
        btnConfiguracion.setVerifyInputWhenFocusTarget(false);
        btnConfiguracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfiguracionActionPerformed(evt);
            }
        });

        p13.setBackground(new java.awt.Color(25, 188, 157));

        javax.swing.GroupLayout p13Layout = new javax.swing.GroupLayout(p13);
        p13.setLayout(p13Layout);
        p13Layout.setHorizontalGroup(
            p13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );
        p13Layout.setVerticalGroup(
            p13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );

        btnConExt.setBackground(new java.awt.Color(102, 102, 102));
        btnConExt.setFont(new java.awt.Font("Segoe UI Light", 0, 17)); // NOI18N
        btnConExt.setForeground(new java.awt.Color(255, 255, 255));
        btnConExt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Termómetro médico-30.png"))); // NOI18N
        btnConExt.setText("Consultorios Externos");
        btnConExt.setContentAreaFilled(false);
        btnConExt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConExt.setFocusPainted(false);
        btnConExt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnConExt.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnConExt.setIconTextGap(30);
        btnConExt.setVerifyInputWhenFocusTarget(false);
        btnConExt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConExtActionPerformed(evt);
            }
        });

        p14.setBackground(new java.awt.Color(25, 188, 157));

        javax.swing.GroupLayout p14Layout = new javax.swing.GroupLayout(p14);
        p14.setLayout(p14Layout);
        p14Layout.setHorizontalGroup(
            p14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );
        p14Layout.setVerticalGroup(
            p14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );

        btnAlmacen.setBackground(new java.awt.Color(102, 102, 102));
        btnAlmacen.setFont(new java.awt.Font("Segoe UI Light", 0, 17)); // NOI18N
        btnAlmacen.setForeground(new java.awt.Color(255, 255, 255));
        btnAlmacen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Péptido-30.png"))); // NOI18N
        btnAlmacen.setText("<html>Almacén");
        btnAlmacen.setContentAreaFilled(false);
        btnAlmacen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAlmacen.setFocusPainted(false);
        btnAlmacen.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAlmacen.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAlmacen.setIconTextGap(30);
        btnAlmacen.setVerifyInputWhenFocusTarget(false);
        btnAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlmacenActionPerformed(evt);
            }
        });

        p15.setBackground(new java.awt.Color(25, 188, 157));

        javax.swing.GroupLayout p15Layout = new javax.swing.GroupLayout(p15);
        p15.setLayout(p15Layout);
        p15Layout.setHorizontalGroup(
            p15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );
        p15Layout.setVerticalGroup(
            p15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );

        btnPersonal.setBackground(new java.awt.Color(102, 102, 102));
        btnPersonal.setFont(new java.awt.Font("Segoe UI Light", 0, 17)); // NOI18N
        btnPersonal.setForeground(new java.awt.Color(255, 255, 255));
        btnPersonal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Péptido-30.png"))); // NOI18N
        btnPersonal.setText("<html>Personal");
        btnPersonal.setContentAreaFilled(false);
        btnPersonal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPersonal.setFocusPainted(false);
        btnPersonal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPersonal.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnPersonal.setIconTextGap(30);
        btnPersonal.setVerifyInputWhenFocusTarget(false);
        btnPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPersonalActionPerformed(evt);
            }
        });

        p16.setBackground(new java.awt.Color(25, 188, 157));

        javax.swing.GroupLayout p16Layout = new javax.swing.GroupLayout(p16);
        p16.setLayout(p16Layout);
        p16Layout.setHorizontalGroup(
            p16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );
        p16Layout.setVerticalGroup(
            p16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );

        btnEcografia.setBackground(new java.awt.Color(102, 102, 102));
        btnEcografia.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        btnEcografia.setForeground(new java.awt.Color(255, 255, 255));
        btnEcografia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/ultrasonido.png"))); // NOI18N
        btnEcografia.setText("Ecografia");
        btnEcografia.setContentAreaFilled(false);
        btnEcografia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEcografia.setFocusPainted(false);
        btnEcografia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEcografia.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnEcografia.setIconTextGap(30);
        btnEcografia.setVerifyInputWhenFocusTarget(false);
        btnEcografia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEcografiaActionPerformed(evt);
            }
        });

        p17.setBackground(new java.awt.Color(25, 188, 157));

        javax.swing.GroupLayout p17Layout = new javax.swing.GroupLayout(p17);
        p17.setLayout(p17Layout);
        p17Layout.setHorizontalGroup(
            p17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );
        p17Layout.setVerticalGroup(
            p17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAdmCentral, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCaja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHospitalizacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCostos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLaboratorio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRayosX, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(p2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnAdmEme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(btnInvBact, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(btnConfiguracion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnConExt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnAlmacen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnPersonal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(btnEcografia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAdmCentral)
                    .addComponent(p1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAdmEme)
                    .addComponent(p4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnCaja)
                                    .addComponent(p2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(p3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCostos))
                                .addGap(8, 8, 8)
                                .addComponent(btnHospitalizacion))
                            .addComponent(p9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addComponent(btnLaboratorio))
                    .addComponent(p10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(p11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRayosX))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(p17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEcografia))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(p14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConExt))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(p12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInvBact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(p15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(p16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(p13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConfiguracion, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(386, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 318, 1060);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(43, 43, 43));
        jPanel6.setForeground(new java.awt.Color(255, 102, 0));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));

        btneditar1.setForeground(new java.awt.Color(240, 240, 240));
        btneditar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Doctor de sexo masculino-96.png"))); // NOI18N
        btneditar1.setMnemonic('N');
        btneditar1.setToolTipText("");
        btneditar1.setContentAreaFilled(false);
        btneditar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btneditar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btneditar1.setIconTextGap(30);
        btneditar1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btneditar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditar1ActionPerformed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(25, 188, 157));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Cambiar mi contraseña");

        btnguardar1.setForeground(new java.awt.Color(240, 240, 240));
        btnguardar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Llave 2-100.png"))); // NOI18N
        btnguardar1.setMnemonic('N');
        btnguardar1.setToolTipText("");
        btnguardar1.setContentAreaFilled(false);
        btnguardar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnguardar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnguardar1.setIconTextGap(30);
        btnguardar1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnguardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnguardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel8)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnguardar1))
        );

        jPanel13.setBackground(new java.awt.Color(25, 188, 157));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Pregunta de seguridad");

        btnguardar4.setForeground(new java.awt.Color(240, 240, 240));
        btnguardar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Ayuda-100.png"))); // NOI18N
        btnguardar4.setMnemonic('N');
        btnguardar4.setToolTipText("");
        btnguardar4.setContentAreaFilled(false);
        btnguardar4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnguardar4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnguardar4.setIconTextGap(30);
        btnguardar4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnguardar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardar4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel14)
                .addContainerGap(60, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnguardar4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnguardar4))
        );

        jLabel73.setBackground(new java.awt.Color(255, 255, 255));
        jLabel73.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setText("Informacion de mi");

        jLabel74.setBackground(new java.awt.Color(255, 255, 255));
        jLabel74.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(255, 255, 255));
        jLabel74.setText("CUENTA");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel5))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(btneditar1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel73)
                            .addComponent(jLabel74))))
                .addGap(133, 133, 133)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel73)
                .addGap(13, 13, 13)
                .addComponent(jLabel74)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btneditar1)
                .addContainerGap(41, Short.MAX_VALUE))
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(577, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1186, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Inicio", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(43, 43, 43));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Depreciacion");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        btneditar5.setForeground(new java.awt.Color(240, 240, 240));
        btneditar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Dinámica negativa-100.png"))); // NOI18N
        btneditar5.setContentAreaFilled(false);
        btneditar5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btneditar5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btneditar5.setIconTextGap(30);
        btneditar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditar5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btneditar5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btneditar5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(43, 43, 43));
        jPanel12.setForeground(new java.awt.Color(255, 153, 0));

        btneditar6.setForeground(new java.awt.Color(240, 240, 240));
        btneditar6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/icons8-Servicios-100.png"))); // NOI18N
        btneditar6.setContentAreaFilled(false);
        btneditar6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btneditar6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btneditar6.setIconTextGap(30);
        btneditar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditar6ActionPerformed(evt);
            }
        });

        jPanel77.setBackground(new java.awt.Color(243, 156, 17));

        javax.swing.GroupLayout jPanel77Layout = new javax.swing.GroupLayout(jPanel77);
        jPanel77.setLayout(jPanel77Layout);
        jPanel77Layout.setHorizontalGroup(
            jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );
        jPanel77Layout.setVerticalGroup(
            jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel33.setBackground(new java.awt.Color(255, 255, 255));
        jLabel33.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Subservicios");
        jLabel33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel33MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel77, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btneditar6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btneditar6, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
            .addComponent(jPanel77, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel18.setBackground(new java.awt.Color(43, 43, 43));
        jPanel18.setForeground(new java.awt.Color(255, 102, 0));

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Estimacion de costos");

        btneditar8.setForeground(new java.awt.Color(240, 240, 240));
        btneditar8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/icons8-Dinero-100.png"))); // NOI18N
        btneditar8.setContentAreaFilled(false);
        btneditar8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btneditar8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btneditar8.setIconTextGap(30);
        btneditar8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditar8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
            .addComponent(btneditar8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btneditar8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel21.setBackground(new java.awt.Color(43, 43, 43));
        jPanel21.setForeground(new java.awt.Color(255, 153, 0));

        jLabel27.setBackground(new java.awt.Color(255, 255, 255));
        jLabel27.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Fatores de Produccion");
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel27MouseClicked(evt);
            }
        });

        btneditar9.setBackground(new java.awt.Color(255, 255, 153));
        btneditar9.setForeground(new java.awt.Color(255, 255, 102));
        btneditar9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/icons8-Fábrica-100.png"))); // NOI18N
        btneditar9.setContentAreaFilled(false);
        btneditar9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btneditar9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btneditar9.setIconTextGap(30);
        btneditar9.setVerifyInputWhenFocusTarget(false);
        btneditar9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditar9ActionPerformed(evt);
            }
        });

        jPanel76.setBackground(new java.awt.Color(243, 156, 17));

        javax.swing.GroupLayout jPanel76Layout = new javax.swing.GroupLayout(jPanel76);
        jPanel76.setLayout(jPanel76Layout);
        jPanel76Layout.setHorizontalGroup(
            jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );
        jPanel76Layout.setVerticalGroup(
            jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Sub Servicios");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel76, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btneditar9, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btneditar9, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel76, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel19.setBackground(new java.awt.Color(243, 156, 17));

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("<html>Buscar estimacion de costos</html>");
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });

        btnguardar8.setForeground(new java.awt.Color(240, 240, 240));
        btnguardar8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Buscar-47.png"))); // NOI18N
        btnguardar8.setContentAreaFilled(false);
        btnguardar8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnguardar8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnguardar8.setIconTextGap(30);
        btnguardar8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardar8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(btnguardar8, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnguardar8, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jPanel20.setBackground(new java.awt.Color(243, 156, 17));

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Costos de Nomenclaturas");
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
        });

        btnguardar9.setForeground(new java.awt.Color(240, 240, 240));
        btnguardar9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Ahorro de libro-50.png"))); // NOI18N
        btnguardar9.setContentAreaFilled(false);
        btnguardar9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnguardar9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnguardar9.setIconTextGap(30);
        btnguardar9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardar9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addComponent(btnguardar9, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnguardar9, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel68.setBackground(new java.awt.Color(43, 43, 43));
        jPanel68.setForeground(new java.awt.Color(255, 153, 0));

        btneditar4.setForeground(new java.awt.Color(240, 240, 240));
        btneditar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Producto-100.png"))); // NOI18N
        btneditar4.setContentAreaFilled(false);
        btneditar4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btneditar4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btneditar4.setIconTextGap(30);
        btneditar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditar4ActionPerformed(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Producto Referencial");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel68Layout = new javax.swing.GroupLayout(jPanel68);
        jPanel68.setLayout(jPanel68Layout);
        jPanel68Layout.setHorizontalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel68Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btneditar4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel68Layout.setVerticalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btneditar4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel72.setBackground(new java.awt.Color(43, 43, 43));
        jPanel72.setForeground(new java.awt.Color(255, 153, 0));

        btneditar7.setForeground(new java.awt.Color(240, 240, 240));
        btneditar7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/icons8-Regla-100.png"))); // NOI18N
        btneditar7.setContentAreaFilled(false);
        btneditar7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btneditar7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btneditar7.setIconTextGap(30);
        btneditar7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditar7ActionPerformed(evt);
            }
        });

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Unidad de Medida");
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel72Layout = new javax.swing.GroupLayout(jPanel72);
        jPanel72.setLayout(jPanel72Layout);
        jPanel72Layout.setHorizontalGroup(
            jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel72Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(btneditar7, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE))
        );
        jPanel72Layout.setVerticalGroup(
            jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btneditar7, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel31.setBackground(new java.awt.Color(255, 255, 255));
        jLabel31.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Fatores de Produccion");
        jLabel31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel31MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 645, Short.MAX_VALUE)
                            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 645, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel68, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(4, 4, 4)
                        .addComponent(jPanel72, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel72, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel68, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(908, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Costos", jPanel3);

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));

        jPanel59.setBackground(new java.awt.Color(43, 43, 43));
        jPanel59.setForeground(new java.awt.Color(255, 153, 0));

        jPanel61.setBackground(new java.awt.Color(23, 160, 134));

        javax.swing.GroupLayout jPanel61Layout = new javax.swing.GroupLayout(jPanel61);
        jPanel61.setLayout(jPanel61Layout);
        jPanel61Layout.setHorizontalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );
        jPanel61Layout.setVerticalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 134, Short.MAX_VALUE)
        );

        jLabel40.setBackground(new java.awt.Color(255, 255, 255));
        jLabel40.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Pacientes");
        jLabel40.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel40.setIconTextGap(2);
        jLabel40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel40MouseClicked(evt);
            }
        });

        btnPaciente.setBackground(new java.awt.Color(255, 255, 153));
        btnPaciente.setForeground(new java.awt.Color(255, 255, 102));
        btnPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Silla de ruedas-100.png"))); // NOI18N
        btnPaciente.setMnemonic('N');
        btnPaciente.setToolTipText("");
        btnPaciente.setContentAreaFilled(false);
        btnPaciente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPaciente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPaciente.setIconTextGap(30);
        btnPaciente.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPacienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel59Layout = new javax.swing.GroupLayout(jPanel59);
        jPanel59.setLayout(jPanel59Layout);
        jPanel59Layout.setHorizontalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(btnPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel59Layout.createSequentialGroup()
                    .addComponent(jPanel61, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 952, Short.MAX_VALUE)))
        );
        jPanel59Layout.setVerticalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
            .addComponent(btnPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel64.setBackground(new java.awt.Color(43, 43, 43));
        jPanel64.setForeground(new java.awt.Color(255, 153, 0));

        btnSectorizacion.setForeground(new java.awt.Color(240, 240, 240));
        btnSectorizacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/icons8-Marcador de mapa-100.png"))); // NOI18N
        btnSectorizacion.setMnemonic('N');
        btnSectorizacion.setToolTipText("");
        btnSectorizacion.setContentAreaFilled(false);
        btnSectorizacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSectorizacion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSectorizacion.setIconTextGap(30);
        btnSectorizacion.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnSectorizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSectorizacionActionPerformed(evt);
            }
        });

        jLabel28.setBackground(new java.awt.Color(255, 255, 255));
        jLabel28.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel28.setText("Sectorización");
        jLabel28.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel64Layout = new javax.swing.GroupLayout(jPanel64);
        jPanel64.setLayout(jPanel64Layout);
        jPanel64Layout.setHorizontalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel64Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(btnSectorizacion, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 822, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel64Layout.setVerticalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSectorizacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel103.setBackground(new java.awt.Color(43, 43, 43));
        jPanel103.setForeground(new java.awt.Color(255, 102, 0));

        btnReporteAdmiCentral.setForeground(new java.awt.Color(240, 240, 240));
        btnReporteAdmiCentral.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/icons8-Boleta de calificaciones-100.png"))); // NOI18N
        btnReporteAdmiCentral.setMnemonic('N');
        btnReporteAdmiCentral.setContentAreaFilled(false);
        btnReporteAdmiCentral.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReporteAdmiCentral.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnReporteAdmiCentral.setIconTextGap(30);
        btnReporteAdmiCentral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteAdmiCentralActionPerformed(evt);
            }
        });

        jLabel29.setBackground(new java.awt.Color(255, 255, 255));
        jLabel29.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Reportes");

        javax.swing.GroupLayout jPanel103Layout = new javax.swing.GroupLayout(jPanel103);
        jPanel103.setLayout(jPanel103Layout);
        jPanel103Layout.setHorizontalGroup(
            jPanel103Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnReporteAdmiCentral, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
        );
        jPanel103Layout.setVerticalGroup(
            jPanel103Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel103Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReporteAdmiCentral, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel25.setBackground(new java.awt.Color(23, 160, 134));

        jLabel30.setBackground(new java.awt.Color(255, 255, 255));
        jLabel30.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("<html>Movimiento de Historias Clínicas</html>");
        jLabel30.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel30.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel30MouseClicked(evt);
            }
        });

        btnReportMovinientoHC.setForeground(new java.awt.Color(240, 240, 240));
        btnReportMovinientoHC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Vista general 2-50.png"))); // NOI18N
        btnReportMovinientoHC.setMnemonic('N');
        btnReportMovinientoHC.setContentAreaFilled(false);
        btnReportMovinientoHC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReportMovinientoHC.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnReportMovinientoHC.setIconTextGap(30);
        btnReportMovinientoHC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportMovinientoHCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addComponent(btnReportMovinientoHC, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel30)
                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnReportMovinientoHC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jPanel26.setBackground(new java.awt.Color(23, 160, 134));

        jLabel32.setBackground(new java.awt.Color(255, 255, 255));
        jLabel32.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("<html>Seguimiento de Historias Clínicas</html>");
        jLabel32.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel32MouseClicked(evt);
            }
        });

        btnReportSeguimientoHC.setForeground(new java.awt.Color(240, 240, 240));
        btnReportSeguimientoHC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Información general Página 4-50.png"))); // NOI18N
        btnReportSeguimientoHC.setMnemonic('N');
        btnReportSeguimientoHC.setContentAreaFilled(false);
        btnReportSeguimientoHC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReportSeguimientoHC.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnReportSeguimientoHC.setIconTextGap(30);
        btnReportSeguimientoHC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportSeguimientoHCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addComponent(btnReportSeguimientoHC, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel32)
                .addContainerGap())
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnReportSeguimientoHC, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
            .addComponent(jLabel32)
        );

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));

        lblusu3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblusu3.setForeground(new java.awt.Color(51, 51, 51));
        lblusu3.setText("Admisión Central");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblusu3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblusu3)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jPanel103, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel59, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jPanel64, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel103, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(935, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Adm", jPanel22);

        jPanel28.setBackground(new java.awt.Color(255, 255, 255));

        lblusu5.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        lblusu5.setForeground(new java.awt.Color(102, 102, 102));
        lblusu5.setText("Bienvenido al módulo de laboratorio");

        jPanel30.setBackground(new java.awt.Color(153, 153, 153));
        jPanel30.setForeground(new java.awt.Color(255, 102, 0));

        btneditar11.setFont(new java.awt.Font("Segoe UI Light", 0, 26)); // NOI18N
        btneditar11.setForeground(new java.awt.Color(240, 240, 240));
        btneditar11.setMnemonic('N');
        btneditar11.setText("Mantenimientos");
        btneditar11.setToolTipText("");
        btneditar11.setContentAreaFilled(false);
        btneditar11.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btneditar11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btneditar11.setIconTextGap(30);
        btneditar11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditar11ActionPerformed(evt);
            }
        });

        jPanel39.setBackground(new java.awt.Color(0, 119, 178));

        jLabel41.setBackground(new java.awt.Color(255, 255, 255));
        jLabel41.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText(" Muestras");
        jLabel41.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel41.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel41MouseClicked(evt);
            }
        });

        btnMuestras.setForeground(new java.awt.Color(240, 240, 240));
        btnMuestras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/probeta (2).png"))); // NOI18N
        btnMuestras.setMnemonic('N');
        btnMuestras.setToolTipText("");
        btnMuestras.setContentAreaFilled(false);
        btnMuestras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMuestras.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnMuestras.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnMuestras.setIconTextGap(30);
        btnMuestras.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnMuestras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMuestrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnMuestras, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
            .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnMuestras, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        jPanel41.setBackground(new java.awt.Color(0, 119, 178));

        jLabel52.setBackground(new java.awt.Color(255, 255, 255));
        jLabel52.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("Esquema de");
        jLabel52.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel52.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel52MouseClicked(evt);
            }
        });

        jLabel53.setBackground(new java.awt.Color(255, 255, 255));
        jLabel53.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("Resultados");
        jLabel53.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel53.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel53MouseClicked(evt);
            }
        });

        btnEsquema.setForeground(new java.awt.Color(240, 240, 240));
        btnEsquema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Vista general 3-50.png"))); // NOI18N
        btnEsquema.setMnemonic('N');
        btnEsquema.setToolTipText("");
        btnEsquema.setContentAreaFilled(false);
        btnEsquema.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEsquema.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnEsquema.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEsquema.setIconTextGap(30);
        btnEsquema.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnEsquema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEsquemaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEsquema, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel53)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEsquema, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel43.setBackground(new java.awt.Color(0, 119, 178));

        jLabel55.setBackground(new java.awt.Color(255, 255, 255));
        jLabel55.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("Valores");
        jLabel55.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel55.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel55MouseClicked(evt);
            }
        });

        jLabel56.setBackground(new java.awt.Color(255, 255, 255));
        jLabel56.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText("Referenciales");
        jLabel56.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel56.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel56MouseClicked(evt);
            }
        });

        btnValores.setForeground(new java.awt.Color(240, 240, 240));
        btnValores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Alinear a la derecha-50.png"))); // NOI18N
        btnValores.setMnemonic('N');
        btnValores.setToolTipText("");
        btnValores.setContentAreaFilled(false);
        btnValores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnValores.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnValores.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnValores.setIconTextGap(30);
        btnValores.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnValores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValoresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnValores, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel56)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnValores))
        );

        jPanel32.setBackground(new java.awt.Color(0, 119, 178));

        jLabel38.setBackground(new java.awt.Color(255, 255, 255));
        jLabel38.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText(" Unidad de Medida");
        jLabel38.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel38MouseClicked(evt);
            }
        });

        btnUnidadMedi.setForeground(new java.awt.Color(240, 240, 240));
        btnUnidadMedi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Vista general 2-50.png"))); // NOI18N
        btnUnidadMedi.setMnemonic('N');
        btnUnidadMedi.setToolTipText("");
        btnUnidadMedi.setContentAreaFilled(false);
        btnUnidadMedi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUnidadMedi.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnUnidadMedi.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnUnidadMedi.setIconTextGap(30);
        btnUnidadMedi.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnUnidadMedi.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnUnidadMedi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnidadMediActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
            .addComponent(btnUnidadMedi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUnidadMedi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel40.setBackground(new java.awt.Color(0, 119, 178));

        jLabel46.setBackground(new java.awt.Color(255, 255, 255));
        jLabel46.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText(" Análisis - Examen");
        jLabel46.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel46.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel46MouseClicked(evt);
            }
        });

        btnAnalisis.setForeground(new java.awt.Color(240, 240, 240));
        btnAnalisis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Tipo de archivo de libro genérico-50.png"))); // NOI18N
        btnAnalisis.setMnemonic('N');
        btnAnalisis.setToolTipText("");
        btnAnalisis.setContentAreaFilled(false);
        btnAnalisis.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAnalisis.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnAnalisis.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAnalisis.setIconTextGap(30);
        btnAnalisis.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnAnalisis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalisisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAnalisis, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnAnalisis, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel42.setBackground(new java.awt.Color(0, 119, 178));

        jLabel54.setBackground(new java.awt.Color(255, 255, 255));
        jLabel54.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText(" Clasificación");
        jLabel54.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel54.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel54MouseClicked(evt);
            }
        });

        btnClasificacion.setForeground(new java.awt.Color(240, 240, 240));
        btnClasificacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Documentos-50.png"))); // NOI18N
        btnClasificacion.setMnemonic('N');
        btnClasificacion.setToolTipText("");
        btnClasificacion.setContentAreaFilled(false);
        btnClasificacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClasificacion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnClasificacion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnClasificacion.setIconTextGap(30);
        btnClasificacion.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnClasificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClasificacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnClasificacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnClasificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel44.setBackground(new java.awt.Color(0, 119, 178));

        jLabel57.setBackground(new java.awt.Color(255, 255, 255));
        jLabel57.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setText(" Contenedor");
        jLabel57.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel57.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel57MouseClicked(evt);
            }
        });

        btnContenedor.setForeground(new java.awt.Color(240, 240, 240));
        btnContenedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/contenedor.png"))); // NOI18N
        btnContenedor.setMnemonic('N');
        btnContenedor.setToolTipText("");
        btnContenedor.setContentAreaFilled(false);
        btnContenedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnContenedor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnContenedor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnContenedor.setIconTextGap(30);
        btnContenedor.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnContenedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContenedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnContenedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
            .addComponent(jLabel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btneditar11, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)))
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel39, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btneditar11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel41, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel75.setBackground(new java.awt.Color(153, 153, 153));
        jPanel75.setForeground(new java.awt.Color(255, 153, 0));

        jLabel88.setBackground(new java.awt.Color(255, 255, 255));
        jLabel88.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(255, 255, 255));
        jLabel88.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel88.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Bacteria Filled-100.png"))); // NOI18N
        jLabel88.setText("Toma de Muestra");
        jLabel88.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel88.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel88.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jPanel78.setBackground(new java.awt.Color(0, 119, 178));

        jLabel89.setBackground(new java.awt.Color(255, 255, 255));
        jLabel89.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(255, 255, 255));
        jLabel89.setText(" Toma de Muestra");
        jLabel89.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel89.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel89MouseClicked(evt);
            }
        });

        btnTM.setForeground(new java.awt.Color(240, 240, 240));
        btnTM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/probeta (2).png"))); // NOI18N
        btnTM.setMnemonic('N');
        btnTM.setToolTipText("");
        btnTM.setContentAreaFilled(false);
        btnTM.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTM.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnTM.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTM.setIconTextGap(30);
        btnTM.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnTM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel78Layout = new javax.swing.GroupLayout(jPanel78);
        jPanel78.setLayout(jPanel78Layout);
        jPanel78Layout.setHorizontalGroup(
            jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnTM, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel89, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel78Layout.setVerticalGroup(
            jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel78Layout.createSequentialGroup()
                .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnTM, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel79.setBackground(new java.awt.Color(0, 119, 178));

        jLabel94.setBackground(new java.awt.Color(255, 255, 255));
        jLabel94.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(255, 255, 255));
        jLabel94.setText(" Búsqueda de Toma de M.");
        jLabel94.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel94.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel94MouseClicked(evt);
            }
        });

        btnTMBusqueda.setForeground(new java.awt.Color(240, 240, 240));
        btnTMBusqueda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Buscar-47.png"))); // NOI18N
        btnTMBusqueda.setMnemonic('N');
        btnTMBusqueda.setToolTipText("");
        btnTMBusqueda.setContentAreaFilled(false);
        btnTMBusqueda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTMBusqueda.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnTMBusqueda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTMBusqueda.setIconTextGap(30);
        btnTMBusqueda.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnTMBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTMBusquedaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel79Layout = new javax.swing.GroupLayout(jPanel79);
        jPanel79.setLayout(jPanel79Layout);
        jPanel79Layout.setHorizontalGroup(
            jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnTMBusqueda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel94, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
        );
        jPanel79Layout.setVerticalGroup(
            jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel79Layout.createSequentialGroup()
                .addComponent(jLabel94, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnTMBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel75Layout = new javax.swing.GroupLayout(jPanel75);
        jPanel75.setLayout(jPanel75Layout);
        jPanel75Layout.setHorizontalGroup(
            jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel75Layout.createSequentialGroup()
                .addComponent(jLabel88, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel78, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel79, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel75Layout.setVerticalGroup(
            jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel88, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
            .addGroup(jPanel75Layout.createSequentialGroup()
                .addComponent(jPanel78, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel79, javax.swing.GroupLayout.PREFERRED_SIZE, 109, Short.MAX_VALUE))
        );

        jPanel80.setBackground(new java.awt.Color(153, 153, 153));
        jPanel80.setForeground(new java.awt.Color(255, 153, 0));

        jLabel95.setBackground(new java.awt.Color(255, 255, 255));
        jLabel95.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel95.setForeground(new java.awt.Color(255, 255, 255));
        jLabel95.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel95.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Microscopio-100.png"))); // NOI18N
        jLabel95.setText("Resultados");
        jLabel95.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel95.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jPanel81.setBackground(new java.awt.Color(0, 119, 178));

        jLabel96.setBackground(new java.awt.Color(255, 255, 255));
        jLabel96.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(255, 255, 255));
        jLabel96.setText(" Resultados");
        jLabel96.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel96.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel96MouseClicked(evt);
            }
        });

        btnResultado.setForeground(new java.awt.Color(240, 240, 240));
        btnResultado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/ExamenFisico-50.png"))); // NOI18N
        btnResultado.setMnemonic('N');
        btnResultado.setToolTipText("");
        btnResultado.setContentAreaFilled(false);
        btnResultado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnResultado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnResultado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnResultado.setIconTextGap(30);
        btnResultado.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResultadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel81Layout = new javax.swing.GroupLayout(jPanel81);
        jPanel81.setLayout(jPanel81Layout);
        jPanel81Layout.setHorizontalGroup(
            jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnResultado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel96, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
        );
        jPanel81Layout.setVerticalGroup(
            jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel81Layout.createSequentialGroup()
                .addComponent(jLabel96, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel82.setBackground(new java.awt.Color(0, 119, 178));

        jLabel97.setBackground(new java.awt.Color(255, 255, 255));
        jLabel97.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel97.setForeground(new java.awt.Color(255, 255, 255));
        jLabel97.setText(" Búsqueda de Resultados");
        jLabel97.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel97.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel97MouseClicked(evt);
            }
        });

        btnResultadoBusq.setForeground(new java.awt.Color(240, 240, 240));
        btnResultadoBusq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Buscar-47.png"))); // NOI18N
        btnResultadoBusq.setMnemonic('N');
        btnResultadoBusq.setToolTipText("");
        btnResultadoBusq.setContentAreaFilled(false);
        btnResultadoBusq.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnResultadoBusq.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnResultadoBusq.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnResultadoBusq.setIconTextGap(30);
        btnResultadoBusq.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnResultadoBusq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResultadoBusqActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel82Layout = new javax.swing.GroupLayout(jPanel82);
        jPanel82.setLayout(jPanel82Layout);
        jPanel82Layout.setHorizontalGroup(
            jPanel82Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnResultadoBusq, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel97, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel82Layout.setVerticalGroup(
            jPanel82Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel82Layout.createSequentialGroup()
                .addComponent(jLabel97, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnResultadoBusq, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel83.setBackground(new java.awt.Color(0, 119, 178));

        jLabel98.setBackground(new java.awt.Color(255, 255, 255));
        jLabel98.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(255, 255, 255));
        jLabel98.setText(" Entrega de Resultados");
        jLabel98.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel98.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel98MouseClicked(evt);
            }
        });

        btnEntrega.setForeground(new java.awt.Color(240, 240, 240));
        btnEntrega.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Vista general 2-50.png"))); // NOI18N
        btnEntrega.setMnemonic('N');
        btnEntrega.setToolTipText("");
        btnEntrega.setContentAreaFilled(false);
        btnEntrega.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEntrega.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnEntrega.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEntrega.setIconTextGap(30);
        btnEntrega.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntregaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel83Layout = new javax.swing.GroupLayout(jPanel83);
        jPanel83.setLayout(jPanel83Layout);
        jPanel83Layout.setHorizontalGroup(
            jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEntrega, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel98, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel83Layout.setVerticalGroup(
            jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel83Layout.createSequentialGroup()
                .addComponent(jLabel98, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel80Layout = new javax.swing.GroupLayout(jPanel80);
        jPanel80.setLayout(jPanel80Layout);
        jPanel80Layout.setHorizontalGroup(
            jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel80Layout.createSequentialGroup()
                .addComponent(jLabel95, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel82, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel83, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel81, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel80Layout.setVerticalGroup(
            jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel80Layout.createSequentialGroup()
                .addComponent(jPanel81, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel82, javax.swing.GroupLayout.PREFERRED_SIZE, 112, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel83, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel95, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel84.setBackground(new java.awt.Color(153, 153, 153));
        jPanel84.setForeground(new java.awt.Color(255, 153, 0));

        jLabel99.setBackground(new java.awt.Color(255, 255, 255));
        jLabel99.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(255, 255, 255));
        jLabel99.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel99.setText("Conversión");
        jLabel99.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel99MouseClicked(evt);
            }
        });

        btnConversion.setForeground(new java.awt.Color(240, 240, 240));
        btnConversion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Tubo de ensayo-100.png"))); // NOI18N
        btnConversion.setMnemonic('N');
        btnConversion.setToolTipText("");
        btnConversion.setContentAreaFilled(false);
        btnConversion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConversion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnConversion.setIconTextGap(30);
        btnConversion.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnConversion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConversionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel84Layout = new javax.swing.GroupLayout(jPanel84);
        jPanel84.setLayout(jPanel84Layout);
        jPanel84Layout.setHorizontalGroup(
            jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel84Layout.createSequentialGroup()
                .addComponent(jLabel99, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConversion, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel84Layout.setVerticalGroup(
            jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel84Layout.createSequentialGroup()
                .addGroup(jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnConversion, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                    .addComponent(jLabel99, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel85.setBackground(new java.awt.Color(153, 153, 153));
        jPanel85.setForeground(new java.awt.Color(255, 153, 0));

        jLabel100.setBackground(new java.awt.Color(255, 255, 255));
        jLabel100.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel100.setForeground(new java.awt.Color(255, 255, 255));
        jLabel100.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel100.setText("<html><br>Solicitud de<br>Investigación<br>Bacteriológica</html>");
        jLabel100.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel100.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jLabel100.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel100MouseClicked(evt);
            }
        });

        btnSolicitudRecep.setForeground(new java.awt.Color(240, 240, 240));
        btnSolicitudRecep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/recepcion.png"))); // NOI18N
        btnSolicitudRecep.setMnemonic('N');
        btnSolicitudRecep.setToolTipText("");
        btnSolicitudRecep.setContentAreaFilled(false);
        btnSolicitudRecep.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSolicitudRecep.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSolicitudRecep.setIconTextGap(30);
        btnSolicitudRecep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolicitudRecepActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel85Layout = new javax.swing.GroupLayout(jPanel85);
        jPanel85.setLayout(jPanel85Layout);
        jPanel85Layout.setHorizontalGroup(
            jPanel85Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel85Layout.createSequentialGroup()
                .addComponent(jLabel100, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSolicitudRecep, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel85Layout.setVerticalGroup(
            jPanel85Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel100)
            .addComponent(btnSolicitudRecep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblusu5)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                                .addComponent(jPanel84, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel85, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel75, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel80, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(524, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblusu5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(jPanel75, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel84, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel85, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel80, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(918, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Lab", jPanel28);

        jPanel46.setBackground(new java.awt.Color(255, 255, 255));

        jPanel47.setBackground(new java.awt.Color(43, 43, 43));
        jPanel47.setForeground(new java.awt.Color(255, 153, 0));

        btneditar14.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        btneditar14.setForeground(new java.awt.Color(240, 240, 240));
        btneditar14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/icons8-Editar propiedad-80.png"))); // NOI18N
        btneditar14.setText("CPT ");
        btneditar14.setContentAreaFilled(false);
        btneditar14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btneditar14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btneditar14.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btneditar14.setIconTextGap(30);
        btneditar14.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btneditar14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btneditar14MouseClicked(evt);
            }
        });
        btneditar14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditar14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btneditar14, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel47Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btneditar14, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel48.setBackground(new java.awt.Color(43, 43, 43));
        jPanel48.setForeground(new java.awt.Color(255, 102, 0));

        jLabel60.setBackground(new java.awt.Color(255, 255, 255));
        jLabel60.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setText("Cuentas contables");

        btneditar15.setForeground(new java.awt.Color(240, 240, 240));
        btneditar15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/icons8-Contabilidad-80.png"))); // NOI18N
        btneditar15.setContentAreaFilled(false);
        btneditar15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btneditar15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btneditar15.setIconTextGap(30);
        btneditar15.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btneditar15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditar15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel48Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel60))
                    .addGroup(jPanel48Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(btneditar15, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel60)
                .addGap(42, 42, 42)
                .addComponent(btneditar15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel55.setBackground(new java.awt.Color(43, 43, 43));
        jPanel55.setForeground(new java.awt.Color(255, 153, 0));

        jLabel71.setBackground(new java.awt.Color(255, 255, 255));
        jLabel71.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(255, 255, 255));
        jLabel71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/icons8-Comentarios-80.png"))); // NOI18N
        jLabel71.setText("Grupos");

        javax.swing.GroupLayout jPanel55Layout = new javax.swing.GroupLayout(jPanel55);
        jPanel55.setLayout(jPanel55Layout);
        jPanel55Layout.setHorizontalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel71, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel55Layout.setVerticalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel71, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel56.setBackground(new java.awt.Color(43, 43, 43));
        jPanel56.setForeground(new java.awt.Color(255, 153, 0));

        btneditar17.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        btneditar17.setForeground(new java.awt.Color(240, 240, 240));
        btneditar17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/icons8-Etiqueta de precio-80.png"))); // NOI18N
        btneditar17.setText("Precio");
        btneditar17.setContentAreaFilled(false);
        btneditar17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btneditar17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btneditar17.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btneditar17.setIconTextGap(30);
        btneditar17.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btneditar17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditar17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel56Layout = new javax.swing.GroupLayout(jPanel56);
        jPanel56.setLayout(jPanel56Layout);
        jPanel56Layout.setHorizontalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel56Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btneditar17, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE))
        );
        jPanel56Layout.setVerticalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel56Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btneditar17, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel89.setBackground(new java.awt.Color(41, 127, 184));
        jPanel89.setForeground(new java.awt.Color(255, 153, 0));

        jLabel101.setBackground(new java.awt.Color(255, 255, 255));
        jLabel101.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel101.setForeground(new java.awt.Color(255, 255, 255));
        jLabel101.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/icons8-Monedas-80.png"))); // NOI18N
        jLabel101.setText("Ventas");
        jLabel101.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel101.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel101MouseClicked(evt);
            }
        });
        jLabel101.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel101KeyPressed(evt);
            }
        });

        jPanel54.setBackground(new java.awt.Color(50, 151, 219));

        javax.swing.GroupLayout jPanel54Layout = new javax.swing.GroupLayout(jPanel54);
        jPanel54.setLayout(jPanel54Layout);
        jPanel54Layout.setHorizontalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );
        jPanel54Layout.setVerticalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel89Layout = new javax.swing.GroupLayout(jPanel89);
        jPanel89.setLayout(jPanel89Layout);
        jPanel89Layout.setHorizontalGroup(
            jPanel89Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel89Layout.createSequentialGroup()
                .addComponent(jPanel54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel101, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel89Layout.setVerticalGroup(
            jPanel89Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel101, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
            .addComponent(jPanel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel49.setBackground(new java.awt.Color(41, 127, 184));

        jLabel61.setBackground(new java.awt.Color(255, 255, 255));
        jLabel61.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setText("Especifica de Detalle");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tipo de Transacción");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Genérica");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Sub Genérica");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Sub Genérica Detalle");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Especifica");

        jPanel15.setBackground(new java.awt.Color(50, 151, 219));
        jPanel15.setPreferredSize(new java.awt.Dimension(0, 1));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        jPanel50.setBackground(new java.awt.Color(50, 151, 219));
        jPanel50.setPreferredSize(new java.awt.Dimension(0, 1));

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        jPanel51.setBackground(new java.awt.Color(50, 151, 219));
        jPanel51.setPreferredSize(new java.awt.Dimension(0, 1));

        javax.swing.GroupLayout jPanel51Layout = new javax.swing.GroupLayout(jPanel51);
        jPanel51.setLayout(jPanel51Layout);
        jPanel51Layout.setHorizontalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel51Layout.setVerticalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        jPanel52.setBackground(new java.awt.Color(50, 151, 219));
        jPanel52.setPreferredSize(new java.awt.Dimension(0, 1));

        javax.swing.GroupLayout jPanel52Layout = new javax.swing.GroupLayout(jPanel52);
        jPanel52.setLayout(jPanel52Layout);
        jPanel52Layout.setHorizontalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel52Layout.setVerticalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        jPanel53.setBackground(new java.awt.Color(50, 151, 219));
        jPanel53.setPreferredSize(new java.awt.Dimension(0, 1));

        javax.swing.GroupLayout jPanel53Layout = new javax.swing.GroupLayout(jPanel53);
        jPanel53.setLayout(jPanel53Layout);
        jPanel53Layout.setHorizontalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel53Layout.setVerticalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, 1156, Short.MAX_VALUE)
            .addComponent(jPanel50, javax.swing.GroupLayout.DEFAULT_SIZE, 1156, Short.MAX_VALUE)
            .addComponent(jPanel51, javax.swing.GroupLayout.DEFAULT_SIZE, 1156, Short.MAX_VALUE)
            .addComponent(jPanel52, javax.swing.GroupLayout.DEFAULT_SIZE, 1156, Short.MAX_VALUE)
            .addComponent(jPanel53, javax.swing.GroupLayout.DEFAULT_SIZE, 1156, Short.MAX_VALUE)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel49Layout.createSequentialGroup()
                        .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel49Layout.createSequentialGroup()
                        .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(632, Short.MAX_VALUE))))
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel49Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel61)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel94.setBackground(new java.awt.Color(43, 43, 43));
        jPanel94.setForeground(new java.awt.Color(255, 153, 0));

        btneditar16.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        btneditar16.setForeground(new java.awt.Color(240, 240, 240));
        btneditar16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/icons8-Negocio-80.png"))); // NOI18N
        btneditar16.setText("<html>Empresa<span style=\"font-size:'14px'\"><br>Forma de pago</br></span></html>");
        btneditar16.setContentAreaFilled(false);
        btneditar16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btneditar16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btneditar16.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btneditar16.setIconTextGap(30);
        btneditar16.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btneditar16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btneditar16MouseClicked(evt);
            }
        });
        btneditar16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditar16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel94Layout = new javax.swing.GroupLayout(jPanel94);
        jPanel94.setLayout(jPanel94Layout);
        jPanel94Layout.setHorizontalGroup(
            jPanel94Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel94Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btneditar16))
        );
        jPanel94Layout.setVerticalGroup(
            jPanel94Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel94Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(btneditar16, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel89, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel46Layout.createSequentialGroup()
                        .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel94, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel46Layout.createSequentialGroup()
                                .addComponent(jPanel56, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(jPanel55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jPanel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(20, 20, 20))
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel46Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel89, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel56, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4)
                .addComponent(jPanel94, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(915, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Caja", jPanel46);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jPanel57.setBackground(new java.awt.Color(43, 43, 43));
        jPanel57.setForeground(new java.awt.Color(255, 102, 0));

        jLabel75.setBackground(new java.awt.Color(255, 255, 255));
        jLabel75.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(255, 255, 255));
        jLabel75.setText("Mantenimientos");

        jPanel60.setBackground(new java.awt.Color(255, 119, 0));
        jPanel60.setPreferredSize(new java.awt.Dimension(160, 95));
        jPanel60.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel60MouseClicked(evt);
            }
        });

        jLabel80.setBackground(new java.awt.Color(255, 255, 255));
        jLabel80.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(255, 255, 255));
        jLabel80.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel80.setText("Camas");

        btnguardar24.setForeground(new java.awt.Color(240, 240, 240));
        btnguardar24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Cama-50.png"))); // NOI18N
        btnguardar24.setMnemonic('N');
        btnguardar24.setToolTipText("");
        btnguardar24.setContentAreaFilled(false);
        btnguardar24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnguardar24.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnguardar24.setIconTextGap(30);
        btnguardar24.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnguardar24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardar24ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel60Layout = new javax.swing.GroupLayout(jPanel60);
        jPanel60.setLayout(jPanel60Layout);
        jPanel60Layout.setHorizontalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel80, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnguardar24, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        jPanel60Layout.setVerticalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel60Layout.createSequentialGroup()
                .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnguardar24, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel62.setBackground(new java.awt.Color(255, 119, 0));
        jPanel62.setPreferredSize(new java.awt.Dimension(160, 95));
        jPanel62.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel62MouseClicked(evt);
            }
        });

        jLabel83.setBackground(new java.awt.Color(255, 255, 255));
        jLabel83.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(255, 255, 255));
        jLabel83.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel83.setText("Pisos");
        jLabel83.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel83MouseClicked(evt);
            }
        });

        btnguardar26.setForeground(new java.awt.Color(240, 240, 240));
        btnguardar26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Edificio-50.png"))); // NOI18N
        btnguardar26.setMnemonic('N');
        btnguardar26.setToolTipText("");
        btnguardar26.setContentAreaFilled(false);
        btnguardar26.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnguardar26.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnguardar26.setIconTextGap(30);
        btnguardar26.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnguardar26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardar26ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel62Layout = new javax.swing.GroupLayout(jPanel62);
        jPanel62.setLayout(jPanel62Layout);
        jPanel62Layout.setHorizontalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnguardar26, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
            .addComponent(jLabel83, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel62Layout.setVerticalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel62Layout.createSequentialGroup()
                .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnguardar26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel63.setBackground(new java.awt.Color(255, 119, 0));
        jPanel63.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel63MouseClicked(evt);
            }
        });

        jLabel84.setBackground(new java.awt.Color(255, 255, 255));
        jLabel84.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(255, 255, 255));
        jLabel84.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel84.setText("Habitaciones");

        btnguardar27.setForeground(new java.awt.Color(240, 240, 240));
        btnguardar27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Habitacion-50.png"))); // NOI18N
        btnguardar27.setMnemonic('N');
        btnguardar27.setToolTipText("");
        btnguardar27.setContentAreaFilled(false);
        btnguardar27.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnguardar27.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnguardar27.setIconTextGap(30);
        btnguardar27.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnguardar27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardar27ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel63Layout = new javax.swing.GroupLayout(jPanel63);
        jPanel63.setLayout(jPanel63Layout);
        jPanel63Layout.setHorizontalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnguardar27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel84, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        jPanel63Layout.setVerticalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel63Layout.createSequentialGroup()
                .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnguardar27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel57Layout = new javax.swing.GroupLayout(jPanel57);
        jPanel57.setLayout(jPanel57Layout);
        jPanel57Layout.setHorizontalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel63, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jPanel60, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jPanel62, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel57Layout.setVerticalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel60, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
            .addComponent(jPanel62, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel75)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel6.setText("Servicio de:");

        lblServicio.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        lblServicio.setText("jLabel7");

        lblSe_ID.setForeground(new java.awt.Color(255, 255, 255));
        lblSe_ID.setText("jLabel7");

        jPanel65.setBackground(new java.awt.Color(61, 57, 57));

        jButton9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("<html>Examenes <br>Complementarios</html>");
        jButton9.setBorderPainted(false);
        jButton9.setContentAreaFilled(false);
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton9.setIconTextGap(6);

        javax.swing.GroupLayout jPanel65Layout = new javax.swing.GroupLayout(jPanel65);
        jPanel65.setLayout(jPanel65Layout);
        jPanel65Layout.setHorizontalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel65Layout.createSequentialGroup()
                .addComponent(jButton9)
                .addContainerGap())
        );
        jPanel65Layout.setVerticalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
        );

        jPanel88.setBackground(new java.awt.Color(255, 119, 0));

        jButton10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Subir-32.png"))); // NOI18N
        jButton10.setText("Epicrisis");
        jButton10.setBorderPainted(false);
        jButton10.setContentAreaFilled(false);
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton10.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton10.setIconTextGap(30);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel88Layout = new javax.swing.GroupLayout(jPanel88);
        jPanel88.setLayout(jPanel88Layout);
        jPanel88Layout.setHorizontalGroup(
            jPanel88Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel88Layout.createSequentialGroup()
                .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                .addGap(113, 113, 113))
        );
        jPanel88Layout.setVerticalGroup(
            jPanel88Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel95.setBackground(new java.awt.Color(255, 119, 0));
        jPanel95.setForeground(new java.awt.Color(255, 153, 0));

        jLabel102.setBackground(new java.awt.Color(255, 255, 255));
        jLabel102.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel102.setForeground(new java.awt.Color(255, 255, 255));
        jLabel102.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/icons8-Monedas-80.png"))); // NOI18N
        jLabel102.setText("<html>Papeleta de<br>Hospitalización</html>");
        jLabel102.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel102MouseClicked(evt);
            }
        });
        jLabel102.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel102KeyPressed(evt);
            }
        });

        jPanel96.setBackground(new java.awt.Color(255, 73, 7));

        javax.swing.GroupLayout jPanel96Layout = new javax.swing.GroupLayout(jPanel96);
        jPanel96.setLayout(jPanel96Layout);
        jPanel96Layout.setHorizontalGroup(
            jPanel96Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );
        jPanel96Layout.setVerticalGroup(
            jPanel96Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel95Layout = new javax.swing.GroupLayout(jPanel95);
        jPanel95.setLayout(jPanel95Layout);
        jPanel95Layout.setHorizontalGroup(
            jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel95Layout.createSequentialGroup()
                .addComponent(jPanel96, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel102, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 26, Short.MAX_VALUE))
        );
        jPanel95Layout.setVerticalGroup(
            jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel102, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
            .addComponent(jPanel96, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel58.setBackground(new java.awt.Color(43, 43, 43));
        jPanel58.setForeground(new java.awt.Color(255, 153, 0));

        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Vista general 2-50.png"))); // NOI18N
        jButton4.setText("<html>Examen <br>Clínico</html>");
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton4.setIconTextGap(30);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel58Layout = new javax.swing.GroupLayout(jPanel58);
        jPanel58.setLayout(jPanel58Layout);
        jPanel58Layout.setHorizontalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel58Layout.setVerticalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton4)
        );

        jPanel67.setBackground(new java.awt.Color(43, 43, 43));
        jPanel67.setForeground(new java.awt.Color(255, 153, 0));

        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Jeringa-40 (2).png"))); // NOI18N
        jButton5.setText("<html>Controles <br>Vitales</html>");
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton5.setIconTextGap(30);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel67Layout = new javax.swing.GroupLayout(jPanel67);
        jPanel67.setLayout(jPanel67Layout);
        jPanel67Layout.setHorizontalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel67Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(534, Short.MAX_VALUE))
        );
        jPanel67Layout.setVerticalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton5)
        );

        jPanel97.setBackground(new java.awt.Color(43, 43, 43));
        jPanel97.setForeground(new java.awt.Color(255, 153, 0));

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/FormatoHC-80.png"))); // NOI18N
        jButton3.setText("<html>Formato de <br>Historia Clínica</html>");
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setHideActionText(true);
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton3.setIconTextGap(35);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel97Layout = new javax.swing.GroupLayout(jPanel97);
        jPanel97.setLayout(jPanel97Layout);
        jPanel97Layout.setHorizontalGroup(
            jPanel97Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel97Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel97Layout.setVerticalGroup(
            jPanel97Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
        );

        jPanel98.setBackground(new java.awt.Color(43, 43, 43));
        jPanel98.setForeground(new java.awt.Color(255, 153, 0));

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Time-30.png"))); // NOI18N
        jButton1.setText("Pendientes");
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton1.setIconTextGap(10);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel98Layout = new javax.swing.GroupLayout(jPanel98);
        jPanel98.setLayout(jPanel98Layout);
        jPanel98Layout.setHorizontalGroup(
            jPanel98Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel98Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel98Layout.setVerticalGroup(
            jPanel98Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel98Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel99.setBackground(new java.awt.Color(43, 43, 43));
        jPanel99.setForeground(new java.awt.Color(255, 153, 0));

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Cama-30.png"))); // NOI18N
        jButton2.setText("Hospitalizados");
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel99Layout = new javax.swing.GroupLayout(jPanel99);
        jPanel99.setLayout(jPanel99Layout);
        jPanel99Layout.setHorizontalGroup(
            jPanel99Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel99Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel99Layout.setVerticalGroup(
            jPanel99Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel99Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(28, 28, 28))
        );

        jPanel100.setBackground(new java.awt.Color(43, 43, 43));
        jPanel100.setForeground(new java.awt.Color(255, 153, 0));

        jButton6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("<html>Hoja de Evolucion</html>");
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton6.setIconTextGap(45);

        javax.swing.GroupLayout jPanel100Layout = new javax.swing.GroupLayout(jPanel100);
        jPanel100.setLayout(jPanel100Layout);
        jPanel100Layout.setHorizontalGroup(
            jPanel100Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel100Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                .addGap(124, 124, 124))
        );
        jPanel100Layout.setVerticalGroup(
            jPanel100Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel100Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jButton6)
                .addGap(23, 23, 23))
        );

        jPanel101.setBackground(new java.awt.Color(43, 43, 43));
        jPanel101.setForeground(new java.awt.Color(255, 153, 0));

        jButton7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("<html>Notas de <br>Enfermeria</html>");
        jButton7.setToolTipText("");
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton7.setIconTextGap(35);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel101Layout = new javax.swing.GroupLayout(jPanel101);
        jPanel101.setLayout(jPanel101Layout);
        jPanel101Layout.setHorizontalGroup(
            jPanel101Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel101Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton7)
                .addGap(104, 104, 104))
        );
        jPanel101Layout.setVerticalGroup(
            jPanel101Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel101Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jPanel102.setBackground(new java.awt.Color(43, 43, 43));
        jPanel102.setForeground(new java.awt.Color(255, 153, 0));

        jButton8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("<html>Formato de <br>Interconsulta</html>");
        jButton8.setBorderPainted(false);
        jButton8.setContentAreaFilled(false);
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton8.setIconTextGap(30);

        javax.swing.GroupLayout jPanel102Layout = new javax.swing.GroupLayout(jPanel102);
        jPanel102.setLayout(jPanel102Layout);
        jPanel102Layout.setHorizontalGroup(
            jPanel102Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel102Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
                .addGap(140, 140, 140))
        );
        jPanel102Layout.setVerticalGroup(
            jPanel102Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel102Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton8)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel95, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jPanel98, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel99, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGap(13, 13, 13)
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(lblSe_ID))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(jPanel97, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(4, 4, 4)
                                    .addComponent(jPanel58, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel100, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel88, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(4, 4, 4)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel101, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel67, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel102, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblServicio)
                    .addComponent(lblSe_ID))
                .addGap(8, 8, 8)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel99, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel98, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel95, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4)
                .addComponent(jPanel57, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel97, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel67, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel101, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel100, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel102, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel88, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Hosp", jPanel5);

        jPanel66.setBackground(new java.awt.Color(255, 255, 255));

        jPanel73.setBackground(new java.awt.Color(153, 153, 153));
        jPanel73.setForeground(new java.awt.Color(255, 153, 0));

        jLabel37.setBackground(new java.awt.Color(255, 255, 255));
        jLabel37.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Mantenimiento ");

        jLabel85.setBackground(new java.awt.Color(255, 255, 255));
        jLabel85.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(255, 255, 255));
        jLabel85.setText("Forma de llegada");

        btnMantLlegada1.setForeground(new java.awt.Color(240, 240, 240));
        btnMantLlegada1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Cola-96.png"))); // NOI18N
        btnMantLlegada1.setMnemonic('N');
        btnMantLlegada1.setToolTipText("");
        btnMantLlegada1.setContentAreaFilled(false);
        btnMantLlegada1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMantLlegada1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMantLlegada1.setIconTextGap(30);
        btnMantLlegada1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnMantLlegada1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMantLlegada1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel73Layout = new javax.swing.GroupLayout(jPanel73);
        jPanel73.setLayout(jPanel73Layout);
        jPanel73Layout.setHorizontalGroup(
            jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel73Layout.createSequentialGroup()
                .addGap(0, 54, Short.MAX_VALUE)
                .addComponent(jLabel85)
                .addGap(33, 33, 33))
            .addGroup(jPanel73Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel73Layout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addGap(0, 83, Short.MAX_VALUE))
                    .addGroup(jPanel73Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnMantLlegada1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel73Layout.setVerticalGroup(
            jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel73Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel85)
                .addGap(18, 18, 18)
                .addComponent(btnMantLlegada1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel74.setBackground(new java.awt.Color(153, 153, 153));
        jPanel74.setForeground(new java.awt.Color(255, 153, 0));

        jLabel86.setBackground(new java.awt.Color(255, 255, 255));
        jLabel86.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(255, 255, 255));
        jLabel86.setText("Formato de ");

        btnFormatEmergencia1.setBackground(new java.awt.Color(255, 255, 153));
        btnFormatEmergencia1.setForeground(new java.awt.Color(255, 255, 102));
        btnFormatEmergencia1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Vista general 2-100.png"))); // NOI18N
        btnFormatEmergencia1.setMnemonic('N');
        btnFormatEmergencia1.setToolTipText("");
        btnFormatEmergencia1.setContentAreaFilled(false);
        btnFormatEmergencia1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFormatEmergencia1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFormatEmergencia1.setIconTextGap(30);
        btnFormatEmergencia1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnFormatEmergencia1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFormatEmergencia1ActionPerformed(evt);
            }
        });

        jLabel87.setBackground(new java.awt.Color(255, 255, 255));
        jLabel87.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(255, 255, 255));
        jLabel87.setText("Emergencia");

        javax.swing.GroupLayout jPanel74Layout = new javax.swing.GroupLayout(jPanel74);
        jPanel74.setLayout(jPanel74Layout);
        jPanel74Layout.setHorizontalGroup(
            jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel74Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel74Layout.createSequentialGroup()
                        .addComponent(jLabel86)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel74Layout.createSequentialGroup()
                        .addComponent(jLabel87)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFormatEmergencia1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel74Layout.setVerticalGroup(
            jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel74Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel86)
                .addGroup(jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel74Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel87))
                    .addGroup(jPanel74Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnFormatEmergencia1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel104.setBackground(new java.awt.Color(43, 43, 43));
        jPanel104.setForeground(new java.awt.Color(255, 153, 0));

        jPanel105.setBackground(new java.awt.Color(0, 118, 168));

        javax.swing.GroupLayout jPanel105Layout = new javax.swing.GroupLayout(jPanel105);
        jPanel105.setLayout(jPanel105Layout);
        jPanel105Layout.setHorizontalGroup(
            jPanel105Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );
        jPanel105Layout.setVerticalGroup(
            jPanel105Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 134, Short.MAX_VALUE)
        );

        jLabel90.setBackground(new java.awt.Color(255, 255, 255));
        jLabel90.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(255, 255, 255));
        jLabel90.setText("<html>Formato de Emergencia</html>");
        jLabel90.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel90.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel90MouseClicked(evt);
            }
        });

        btnFormatEmergencia3.setBackground(new java.awt.Color(255, 255, 153));
        btnFormatEmergencia3.setForeground(new java.awt.Color(255, 255, 102));
        btnFormatEmergencia3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Vista general 2-100.png"))); // NOI18N
        btnFormatEmergencia3.setMnemonic('N');
        btnFormatEmergencia3.setToolTipText("");
        btnFormatEmergencia3.setContentAreaFilled(false);
        btnFormatEmergencia3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFormatEmergencia3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFormatEmergencia3.setIconTextGap(30);
        btnFormatEmergencia3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnFormatEmergencia3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFormatEmergencia3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel104Layout = new javax.swing.GroupLayout(jPanel104);
        jPanel104.setLayout(jPanel104Layout);
        jPanel104Layout.setHorizontalGroup(
            jPanel104Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel104Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btnFormatEmergencia3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel90))
            .addGroup(jPanel104Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel104Layout.createSequentialGroup()
                    .addComponent(jPanel105, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 962, Short.MAX_VALUE)))
        );
        jPanel104Layout.setVerticalGroup(
            jPanel104Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel90, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
            .addComponent(btnFormatEmergencia3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel104Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel105, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));

        lblusu7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblusu7.setForeground(new java.awt.Color(102, 102, 102));
        lblusu7.setText("Admisión Emergencia");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblusu7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblusu7)
                .addContainerGap())
        );

        jPanel106.setBackground(new java.awt.Color(43, 43, 43));
        jPanel106.setForeground(new java.awt.Color(255, 153, 0));

        btnMantLlegada2.setForeground(new java.awt.Color(240, 240, 240));
        btnMantLlegada2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/icons8-People-100.png"))); // NOI18N
        btnMantLlegada2.setMnemonic('N');
        btnMantLlegada2.setContentAreaFilled(false);
        btnMantLlegada2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMantLlegada2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMantLlegada2.setIconTextGap(30);
        btnMantLlegada2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnMantLlegada2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMantLlegada2ActionPerformed(evt);
            }
        });

        jLabel92.setBackground(new java.awt.Color(255, 255, 255));
        jLabel92.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(255, 255, 255));
        jLabel92.setText("<html>Mantenimiento Forma de Llegada</html>");
        jLabel92.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel92.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel92MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel106Layout = new javax.swing.GroupLayout(jPanel106);
        jPanel106.setLayout(jPanel106Layout);
        jPanel106Layout.setHorizontalGroup(
            jPanel106Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel106Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(btnMantLlegada2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel92))
        );
        jPanel106Layout.setVerticalGroup(
            jPanel106Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel92, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
            .addComponent(btnMantLlegada2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel107.setBackground(new java.awt.Color(43, 43, 43));
        jPanel107.setForeground(new java.awt.Color(255, 102, 0));

        jLabel44.setBackground(new java.awt.Color(255, 255, 255));
        jLabel44.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("Reportes");

        btnReporteFEmer1.setForeground(new java.awt.Color(240, 240, 240));
        btnReporteFEmer1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Boleta de calificaciones-100.png"))); // NOI18N
        btnReporteFEmer1.setMnemonic('N');
        btnReporteFEmer1.setContentAreaFilled(false);
        btnReporteFEmer1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReporteFEmer1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnReporteFEmer1.setIconTextGap(30);
        btnReporteFEmer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteFEmer1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel107Layout = new javax.swing.GroupLayout(jPanel107);
        jPanel107.setLayout(jPanel107Layout);
        jPanel107Layout.setHorizontalGroup(
            jPanel107Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnReporteFEmer1, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
        );
        jPanel107Layout.setVerticalGroup(
            jPanel107Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel107Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReporteFEmer1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel69.setBackground(new java.awt.Color(0, 118, 168));

        jLabel77.setBackground(new java.awt.Color(255, 255, 255));
        jLabel77.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(255, 255, 255));
        jLabel77.setText("Cabecera");
        jLabel77.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel77.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel77MouseClicked(evt);
            }
        });

        btnReportCabecera1.setForeground(new java.awt.Color(240, 240, 240));
        btnReportCabecera1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Vista general 2-50.png"))); // NOI18N
        btnReportCabecera1.setMnemonic('N');
        btnReportCabecera1.setContentAreaFilled(false);
        btnReportCabecera1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReportCabecera1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnReportCabecera1.setIconTextGap(30);
        btnReportCabecera1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportCabecera1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel69Layout = new javax.swing.GroupLayout(jPanel69);
        jPanel69.setLayout(jPanel69Layout);
        jPanel69Layout.setHorizontalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel69Layout.createSequentialGroup()
                .addComponent(btnReportCabecera1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel77, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel69Layout.setVerticalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnReportCabecera1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel77, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel70.setBackground(new java.awt.Color(0, 118, 168));

        jLabel78.setBackground(new java.awt.Color(255, 255, 255));
        jLabel78.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(255, 255, 255));
        jLabel78.setText("Topico");
        jLabel78.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel78.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel78MouseClicked(evt);
            }
        });

        btnReporTopico1.setForeground(new java.awt.Color(240, 240, 240));
        btnReporTopico1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Información general Página 4-50.png"))); // NOI18N
        btnReporTopico1.setMnemonic('N');
        btnReporTopico1.setContentAreaFilled(false);
        btnReporTopico1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReporTopico1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnReporTopico1.setIconTextGap(30);
        btnReporTopico1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporTopico1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel70Layout = new javax.swing.GroupLayout(jPanel70);
        jPanel70.setLayout(jPanel70Layout);
        jPanel70Layout.setHorizontalGroup(
            jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel70Layout.createSequentialGroup()
                .addComponent(btnReporTopico1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel78, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE))
        );
        jPanel70Layout.setVerticalGroup(
            jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnReporTopico1, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
            .addComponent(jLabel78, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel71.setBackground(new java.awt.Color(0, 118, 168));

        jLabel79.setBackground(new java.awt.Color(255, 255, 255));
        jLabel79.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(255, 255, 255));
        jLabel79.setText("Triaje");
        jLabel79.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel79.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel79MouseClicked(evt);
            }
        });

        btnReportTriaje1.setForeground(new java.awt.Color(240, 240, 240));
        btnReportTriaje1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Tipo de archivo de libro genérico-50.png"))); // NOI18N
        btnReportTriaje1.setMnemonic('N');
        btnReportTriaje1.setContentAreaFilled(false);
        btnReportTriaje1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReportTriaje1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnReportTriaje1.setIconTextGap(30);
        btnReportTriaje1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportTriaje1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel71Layout = new javax.swing.GroupLayout(jPanel71);
        jPanel71.setLayout(jPanel71Layout);
        jPanel71Layout.setHorizontalGroup(
            jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel71Layout.createSequentialGroup()
                .addComponent(btnReportTriaje1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel79, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE))
        );
        jPanel71Layout.setVerticalGroup(
            jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnReportTriaje1, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
            .addComponent(jLabel79, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel66Layout = new javax.swing.GroupLayout(jPanel66);
        jPanel66.setLayout(jPanel66Layout);
        jPanel66Layout.setHorizontalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel66Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel106, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel104, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel66Layout.createSequentialGroup()
                        .addComponent(jPanel74, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jPanel73, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel66Layout.createSequentialGroup()
                        .addComponent(jPanel107, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel66Layout.createSequentialGroup()
                                .addComponent(jPanel70, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel71, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jPanel69, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel66Layout.setVerticalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel66Layout.createSequentialGroup()
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel73, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel74, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(jPanel104, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel106, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel107, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel66Layout.createSequentialGroup()
                        .addComponent(jPanel69, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel70, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel71, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(923, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("AdEM", jPanel66);

        jPanel29.setBackground(new java.awt.Color(255, 255, 255));

        lblusu8.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        lblusu8.setForeground(new java.awt.Color(102, 102, 102));
        lblusu8.setText("Investigación Bacteriológica");

        jPanel45.setBackground(new java.awt.Color(153, 153, 153));
        jPanel45.setForeground(new java.awt.Color(255, 153, 0));

        jLabel58.setBackground(new java.awt.Color(255, 255, 255));
        jLabel58.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("<html>Solicitud de<br> Investigación<br>Bacteriológica</html>");
        jLabel58.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel58.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel58MouseClicked(evt);
            }
        });

        btnSolicitudInv.setBackground(new java.awt.Color(255, 255, 153));
        btnSolicitudInv.setForeground(new java.awt.Color(255, 255, 102));
        btnSolicitudInv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/solicitud.png"))); // NOI18N
        btnSolicitudInv.setMnemonic('N');
        btnSolicitudInv.setToolTipText("");
        btnSolicitudInv.setContentAreaFilled(false);
        btnSolicitudInv.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSolicitudInv.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSolicitudInv.setIconTextGap(30);
        btnSolicitudInv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolicitudInvActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnSolicitudInv, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSolicitudInv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel58, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblusu8))
                .addContainerGap(1131, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblusu8)
                .addGap(38, 38, 38)
                .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1301, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("InvBac", jPanel29);

        jPanel86.setBackground(new java.awt.Color(255, 255, 255));

        jPanel87.setBackground(new java.awt.Color(153, 153, 153));
        jPanel87.setForeground(new java.awt.Color(255, 102, 0));

        jPanel90.setBackground(new java.awt.Color(0, 153, 102));

        jLabel104.setBackground(new java.awt.Color(255, 255, 255));
        jLabel104.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel104.setForeground(new java.awt.Color(255, 255, 255));
        jLabel104.setText("Consultorio");
        jLabel104.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel104.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel104MouseClicked(evt);
            }
        });

        btnConsultorio.setForeground(new java.awt.Color(240, 240, 240));
        btnConsultorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Alinear a la derecha-50.png"))); // NOI18N
        btnConsultorio.setMnemonic('N');
        btnConsultorio.setToolTipText("");
        btnConsultorio.setContentAreaFilled(false);
        btnConsultorio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConsultorio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnConsultorio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnConsultorio.setIconTextGap(30);
        btnConsultorio.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnConsultorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel90Layout = new javax.swing.GroupLayout(jPanel90);
        jPanel90.setLayout(jPanel90Layout);
        jPanel90Layout.setHorizontalGroup(
            jPanel90Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnConsultorio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel104, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
        );
        jPanel90Layout.setVerticalGroup(
            jPanel90Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel90Layout.createSequentialGroup()
                .addComponent(jLabel104, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnConsultorio, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
        );

        jPanel91.setBackground(new java.awt.Color(0, 153, 102));

        jLabel105.setBackground(new java.awt.Color(255, 255, 255));
        jLabel105.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel105.setForeground(new java.awt.Color(255, 255, 255));
        jLabel105.setText("Triaje");
        jLabel105.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel105.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel105MouseClicked(evt);
            }
        });

        btnTriaje.setForeground(new java.awt.Color(240, 240, 240));
        btnTriaje.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Alinear a la derecha-50.png"))); // NOI18N
        btnTriaje.setMnemonic('N');
        btnTriaje.setToolTipText("");
        btnTriaje.setContentAreaFilled(false);
        btnTriaje.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTriaje.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnTriaje.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTriaje.setIconTextGap(30);
        btnTriaje.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnTriaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTriajeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel91Layout = new javax.swing.GroupLayout(jPanel91);
        jPanel91.setLayout(jPanel91Layout);
        jPanel91Layout.setHorizontalGroup(
            jPanel91Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnTriaje, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
            .addComponent(jLabel105, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel91Layout.setVerticalGroup(
            jPanel91Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel91Layout.createSequentialGroup()
                .addComponent(jLabel105, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnTriaje, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel87Layout = new javax.swing.GroupLayout(jPanel87);
        jPanel87.setLayout(jPanel87Layout);
        jPanel87Layout.setHorizontalGroup(
            jPanel87Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel87Layout.createSequentialGroup()
                .addComponent(jPanel91, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(jPanel90, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(418, Short.MAX_VALUE))
        );
        jPanel87Layout.setVerticalGroup(
            jPanel87Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel90, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel91, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel92.setBackground(new java.awt.Color(0, 153, 102));

        jLabel106.setBackground(new java.awt.Color(255, 255, 255));
        jLabel106.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel106.setForeground(new java.awt.Color(255, 255, 255));
        jLabel106.setText("Registro Seguimiento");
        jLabel106.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel106.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel106MouseClicked(evt);
            }
        });

        btnValores3.setForeground(new java.awt.Color(240, 240, 240));
        btnValores3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Alinear a la derecha-50.png"))); // NOI18N
        btnValores3.setMnemonic('N');
        btnValores3.setToolTipText("");
        btnValores3.setContentAreaFilled(false);
        btnValores3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnValores3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnValores3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnValores3.setIconTextGap(30);
        btnValores3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnValores3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValores3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel92Layout = new javax.swing.GroupLayout(jPanel92);
        jPanel92.setLayout(jPanel92Layout);
        jPanel92Layout.setHorizontalGroup(
            jPanel92Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnValores3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel106, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel92Layout.setVerticalGroup(
            jPanel92Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel92Layout.createSequentialGroup()
                .addComponent(jLabel106, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnValores3, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
        );

        jPanel93.setBackground(new java.awt.Color(0, 153, 102));

        jLabel107.setBackground(new java.awt.Color(255, 255, 255));
        jLabel107.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel107.setForeground(new java.awt.Color(255, 255, 255));
        jLabel107.setText("Carnet Perinatal");
        jLabel107.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel107.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel107MouseClicked(evt);
            }
        });

        btnCarnetPerinatal.setForeground(new java.awt.Color(240, 240, 240));
        btnCarnetPerinatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Alinear a la derecha-50.png"))); // NOI18N
        btnCarnetPerinatal.setMnemonic('N');
        btnCarnetPerinatal.setToolTipText("");
        btnCarnetPerinatal.setContentAreaFilled(false);
        btnCarnetPerinatal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCarnetPerinatal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnCarnetPerinatal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCarnetPerinatal.setIconTextGap(30);
        btnCarnetPerinatal.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnCarnetPerinatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarnetPerinatalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel93Layout = new javax.swing.GroupLayout(jPanel93);
        jPanel93.setLayout(jPanel93Layout);
        jPanel93Layout.setHorizontalGroup(
            jPanel93Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCarnetPerinatal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel107, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
        );
        jPanel93Layout.setVerticalGroup(
            jPanel93Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel93Layout.createSequentialGroup()
                .addComponent(jLabel107, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnCarnetPerinatal, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel86Layout = new javax.swing.GroupLayout(jPanel86);
        jPanel86.setLayout(jPanel86Layout);
        jPanel86Layout.setHorizontalGroup(
            jPanel86Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel86Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel86Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel87, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel86Layout.createSequentialGroup()
                        .addComponent(jPanel92, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel93, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(564, Short.MAX_VALUE))
        );
        jPanel86Layout.setVerticalGroup(
            jPanel86Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel86Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel87, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel86Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel92, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel93, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(1197, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("CEX", jPanel86);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        jPanel108.setBackground(new java.awt.Color(102, 102, 102));

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/file 64.png"))); // NOI18N
        jButton11.setContentAreaFilled(false);
        jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("Busqueda de Examenes a Realizar");
        jButton12.setContentAreaFilled(false);
        jButton12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton12.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel108Layout = new javax.swing.GroupLayout(jPanel108);
        jPanel108.setLayout(jPanel108Layout);
        jPanel108Layout.setHorizontalGroup(
            jPanel108Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel108Layout.createSequentialGroup()
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel108Layout.setVerticalGroup(
            jPanel108Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
            .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        lblusu9.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        lblusu9.setForeground(new java.awt.Color(102, 102, 102));
        lblusu9.setText("Diagnóstico por Imágenes RX");

        jPanel109.setBackground(new java.awt.Color(102, 102, 102));

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/file 64.png"))); // NOI18N
        jButton13.setContentAreaFilled(false);
        jButton13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jPanel11.setBackground(new java.awt.Color(34, 133, 179));

        jButton14.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jButton14.setForeground(new java.awt.Color(255, 255, 255));
        jButton14.setText("<html>Busqueda de <br>Examenes Realizados</html>");
        jButton14.setContentAreaFilled(false);
        jButton14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton14.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel109Layout = new javax.swing.GroupLayout(jPanel109);
        jPanel109.setLayout(jPanel109Layout);
        jPanel109Layout.setHorizontalGroup(
            jPanel109Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel109Layout.createSequentialGroup()
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel109Layout.setVerticalGroup(
            jPanel109Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel110.setBackground(new java.awt.Color(102, 102, 102));

        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/file 64.png"))); // NOI18N
        jButton15.setContentAreaFilled(false);
        jButton15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jPanel27.setBackground(new java.awt.Color(34, 133, 179));

        jButton17.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jButton17.setForeground(new java.awt.Color(255, 255, 255));
        jButton17.setText("Busqueda de Resultados");
        jButton17.setContentAreaFilled(false);
        jButton17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton17.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton17, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel110Layout = new javax.swing.GroupLayout(jPanel110);
        jPanel110.setLayout(jPanel110Layout);
        jPanel110Layout.setHorizontalGroup(
            jPanel110Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel110Layout.createSequentialGroup()
                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel110Layout.setVerticalGroup(
            jPanel110Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
            .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblusu9)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jPanel109, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel110, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel108, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel110, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(lblusu9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel108, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel109, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
<<<<<<< HEAD
                .addContainerGap(1210, Short.MAX_VALUE))
=======
                .addContainerGap(1235, Short.MAX_VALUE))
>>>>>>> e8145f716c806bc6b727ba07563c3e44f26f6308
        );

        jTabbedPane1.addTab("Rx", jPanel14);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1479, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1547, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Almac", jPanel8);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1479, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1547, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Person", jPanel10);

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1479, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1547, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Conf", jPanel16);

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));

        lblusu10.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        lblusu10.setForeground(new java.awt.Color(102, 102, 102));
        lblusu10.setText("Diagnóstico por Imágenes EC");

        jPanel111.setBackground(new java.awt.Color(102, 102, 102));

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/file 64.png"))); // NOI18N
        jButton16.setContentAreaFilled(false);
        jButton16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton18.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jButton18.setForeground(new java.awt.Color(255, 255, 255));
        jButton18.setText("Busqueda de Examenes a Realizar");
        jButton18.setContentAreaFilled(false);
        jButton18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton18.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel111Layout = new javax.swing.GroupLayout(jPanel111);
        jPanel111.setLayout(jPanel111Layout);
        jPanel111Layout.setHorizontalGroup(
            jPanel111Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel111Layout.createSequentialGroup()
                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, 1090, Short.MAX_VALUE))
        );
        jPanel111Layout.setVerticalGroup(
            jPanel111Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
            .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel112.setBackground(new java.awt.Color(102, 102, 102));

        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/file 64.png"))); // NOI18N
        jButton19.setContentAreaFilled(false);
        jButton19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jPanel31.setBackground(new java.awt.Color(34, 133, 179));

        jButton20.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jButton20.setForeground(new java.awt.Color(255, 255, 255));
        jButton20.setText("Busqueda de Resultados");
        jButton20.setContentAreaFilled(false);
        jButton20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton20.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel112Layout = new javax.swing.GroupLayout(jPanel112);
        jPanel112.setLayout(jPanel112Layout);
        jPanel112Layout.setHorizontalGroup(
            jPanel112Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel112Layout.createSequentialGroup()
                .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel112Layout.setVerticalGroup(
            jPanel112Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton19, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
            .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel111, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblusu10)
                    .addComponent(jPanel112, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lblusu10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel111, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel112, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
<<<<<<< HEAD
                .addContainerGap(1189, Short.MAX_VALUE))
=======
                .addContainerGap(1216, Short.MAX_VALUE))
>>>>>>> e8145f716c806bc6b727ba07563c3e44f26f6308
        );

        jTabbedPane1.addTab("EC", jPanel17);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(255, 71, 1040, 710);

        jPanel9.setBackground(new java.awt.Color(61, 57, 57));

        lblUsu.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        lblUsu.setForeground(new java.awt.Color(204, 204, 204));
        lblUsu.setText("ADMIN");
        lblUsu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblUsu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUsuMouseClicked(evt);
            }
        });

        btnguardar3.setForeground(new java.awt.Color(240, 240, 240));
        btnguardar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Apagar-32.png"))); // NOI18N
        btnguardar3.setContentAreaFilled(false);
        btnguardar3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnguardar3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnguardar3.setIconTextGap(30);
        btnguardar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardar3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lblUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(751, 751, 751)
                .addComponent(btnguardar3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(229, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblUsu)
                .addContainerGap(20, Short.MAX_VALUE))
            .addComponent(btnguardar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel9);
        jPanel9.setBounds(313, 0, 1190, 70);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnguardar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardar4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnguardar4ActionPerformed

    private void btnguardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnguardar1ActionPerformed

    private void btneditar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btneditar1ActionPerformed

    private void btnAdmCentralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmCentralActionPerformed
         p1.setVisible(true);
         p2.setVisible(false);
         p3.setVisible(false);        // TODO add your handling code here:
         p4.setVisible(false);
         p9.setVisible(false);
         p10.setVisible(false); 
         p11.setVisible(false);
         p12.setVisible(false);  
         p13.setVisible(false);  
         p14.setVisible(false);  
         p15.setVisible(false);
         p16.setVisible(false);
         p17.setVisible(false);
         jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_btnAdmCentralActionPerformed

    private void btnCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCajaActionPerformed
         p1.setVisible(false);
         p2.setVisible(true);
         p3.setVisible(false);        // TODO add your handling code here:
         p4.setVisible(false);
         p9.setVisible(false);
         p10.setVisible(false); 
         p11.setVisible(false);
         p12.setVisible(false);   
         p13.setVisible(false);
         p14.setVisible(false);  
         p15.setVisible(false);
         p16.setVisible(false);
         p17.setVisible(false);
         jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_btnCajaActionPerformed

    private void btnLaboratorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaboratorioActionPerformed
     p1.setVisible(false);
         p2.setVisible(false);
         p3.setVisible(false);        // TODO add your handling code here:
         p4.setVisible(false);
         p9.setVisible(false);
         p10.setVisible(true); 
         p11.setVisible(false);
         p12.setVisible(false);  
         p13.setVisible(false);
         p14.setVisible(false);  
         p15.setVisible(false);
         p16.setVisible(false);
         p17.setVisible(false);
         jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_btnLaboratorioActionPerformed

    private void btnCajaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCajaMouseEntered
      
    }//GEN-LAST:event_btnCajaMouseEntered

    private void btneditar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditar5ActionPerformed
        Costos_Depreciacion frm = new Costos_Depreciacion();
        frm.setVisible(true);
        String u=PrincipalMDI.lblUsu.getText();
        frm.lblUsu.setText(u);
    }//GEN-LAST:event_btneditar5ActionPerformed

    private void btneditar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditar4ActionPerformed
        COSTOS_PRODUCTO_REFERENCIAL frm = new COSTOS_PRODUCTO_REFERENCIAL();
        frm.setVisible(true);
        String u=PrincipalMDI.lblUsu.getText();
        frm.lblUsu.setText(u);
    }//GEN-LAST:event_btneditar4ActionPerformed

    private void btneditar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditar6ActionPerformed
        COSTOS_SERVICIOS_VARIOS frm = new COSTOS_SERVICIOS_VARIOS();
        frm.setVisible(true);
        String u=PrincipalMDI.lblUsu.getText();
        frm.lblUsu.setText(u);
    }//GEN-LAST:event_btneditar6ActionPerformed

    private void btneditar8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditar8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btneditar8ActionPerformed

    private void btnguardar8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardar8ActionPerformed
        BUSCAR_ESTIMACION_COSTOS frm = new BUSCAR_ESTIMACION_COSTOS();
        frm.setVisible(true);
        BUSCAR_ESTIMACION_COSTOS.tb_Buscar_Estimacion.getSelectionModel().setSelectionInterval(0, 0);
        BUSCAR_ESTIMACION_COSTOS.tb_Buscar_Estimacion.requestFocus();
    }//GEN-LAST:event_btnguardar8ActionPerformed

    private void btnguardar9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardar9ActionPerformed
        BUSCAR_NOMENCLATURA frm = new BUSCAR_NOMENCLATURA();
        frm.setVisible(true);
        
    }//GEN-LAST:event_btnguardar9ActionPerformed

    private void btneditar9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditar9ActionPerformed
        TipoSustentacion frm = new TipoSustentacion();
        frm.setVisible(true);
        String u=PrincipalMDI.lblUsu.getText();
        frm.lblUsu.setText(u);
    }//GEN-LAST:event_btneditar9ActionPerformed

    private void btnSectorizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSectorizacionActionPerformed
        FrmSector frmSector = new FrmSector();
        frmSector.setVisible(true);
        String u=PrincipalMDI.lblUsu.getText();
        frmSector.lblUsuUsuario.setText(u);
    }//GEN-LAST:event_btnSectorizacionActionPerformed

    private void btnReporteAdmiCentralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteAdmiCentralActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReporteAdmiCentralActionPerformed

    private void btnReportMovinientoHCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportMovinientoHCActionPerformed
        FrmMovimientoHC frmMov = new FrmMovimientoHC();
        frmMov.setVisible(true);
        String u=PrincipalMDI.lblUsu.getText();
        frmMov.lblUsuUsuario.setText(u);
    }//GEN-LAST:event_btnReportMovinientoHCActionPerformed

    private void btnReportSeguimientoHCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportSeguimientoHCActionPerformed
        FrmSeguimientoHC frmSeg = new FrmSeguimientoHC();
        frmSeg.setVisible(true);
        String u=PrincipalMDI.lblUsu.getText();
        frmSeg.lblUsuUsuario.setText(u);
    }//GEN-LAST:event_btnReportSeguimientoHCActionPerformed

    private void btnPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPacienteActionPerformed
        FrmNuevaHistoriaC frmNuevaHC = new FrmNuevaHistoriaC();
        frmNuevaHC.setVisible(true);
        String u=PrincipalMDI.lblUsu.getText();
        frmNuevaHC.lblUsuUsuario.setText(u);
    }//GEN-LAST:event_btnPacienteActionPerformed

    private void btnCostosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCostosActionPerformed
         p1.setVisible(false);
         p2.setVisible(false);
         p3.setVisible(true);        // TODO add your handling code here:
         p9.setVisible(false);
         p10.setVisible(false); 
         p11.setVisible(false);
         p12.setVisible(false);    
         p13.setVisible(false); 
         p14.setVisible(false);  
         p15.setVisible(false);
         p16.setVisible(false);
         p17.setVisible(false);
         jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_btnCostosActionPerformed

    private void btnRayosXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRayosXActionPerformed
         p1.setVisible(false);
         p2.setVisible(false);
         p3.setVisible(false);        // TODO add your handling code here:
         p9.setVisible(false);
         p10.setVisible(false); 
         p11.setVisible(true);
         p12.setVisible(false);    
         p13.setVisible(false); 
         p14.setVisible(false);  
         p15.setVisible(false);
         p16.setVisible(false);
         p17.setVisible(false);
         jTabbedPane1.setSelectedIndex(9);
    }//GEN-LAST:event_btnRayosXActionPerformed

    private void btnHospitalizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHospitalizacionActionPerformed
        
        mostrarServicioHosp();
        p1.setVisible(false);
         p2.setVisible(false);
         p3.setVisible(false);        // TODO add your handling code here:
         p9.setVisible(true);
         p10.setVisible(false); 
         p11.setVisible(false);
         p12.setVisible(false);    
         p13.setVisible(false); 
         p14.setVisible(false);  
         p15.setVisible(false);
         p16.setVisible(false);
         p17.setVisible(false);
        jTabbedPane1.setSelectedIndex(5);
    }//GEN-LAST:event_btnHospitalizacionActionPerformed

    private void btneditar14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditar14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btneditar14ActionPerformed

    private void btneditar15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditar15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btneditar15ActionPerformed

    private void btneditar17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditar17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btneditar17ActionPerformed

    private void btnInvBactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInvBactActionPerformed
        p1.setVisible(false);
         p2.setVisible(false);
         p3.setVisible(false);        // TODO add your handling code here:
         p9.setVisible(false);
         p10.setVisible(false); 
         p11.setVisible(false);
         p12.setVisible(true);    
         p13.setVisible(false); 
         p14.setVisible(false);  
         p15.setVisible(false);
         p16.setVisible(false);
         p17.setVisible(false);
        jTabbedPane1.setSelectedIndex(7);
    }//GEN-LAST:event_btnInvBactActionPerformed

    private void btnguardar24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardar24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnguardar24ActionPerformed

    private void btnguardar26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardar26ActionPerformed
        FrmHospitalizacionPisos frmHosp = new FrmHospitalizacionPisos();
        frmHosp.setVisible(true);
        String u=PrincipalMDI.lblUsu.getText();
        frmHosp.lblUsuUsuario.setText(u);
    }//GEN-LAST:event_btnguardar26ActionPerformed

    private void btnguardar27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardar27ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnguardar27ActionPerformed

    private void jPanel63MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel63MouseClicked
        if(evt.getClickCount()==1){
            FrmHospitalizacionHabitaciones frmHosp = new FrmHospitalizacionHabitaciones();
            frmHosp.setVisible(true);
            String u=PrincipalMDI.lblUsu.getText();
            frmHosp.lblUsuUsuario.setText(u);
        }
    }//GEN-LAST:event_jPanel63MouseClicked

    private void jPanel60MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel60MouseClicked
        if(evt.getClickCount()==1){
            FrmHospitalizacionCamas frmHosp = new FrmHospitalizacionCamas();
            frmHosp.setVisible(true);
            String u=PrincipalMDI.lblUsu.getText();
            frmHosp.lblUsuUsuario.setText(u);
        }
    }//GEN-LAST:event_jPanel60MouseClicked

    private void jPanel62MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel62MouseClicked
        if(evt.getClickCount()==1){
            FrmHospitalizacionPisos frmHosp = new FrmHospitalizacionPisos();
            frmHosp.setVisible(true);
            String u=PrincipalMDI.lblUsu.getText();
            frmHosp.lblUsuUsuario.setText(u);
        }
    }//GEN-LAST:event_jPanel62MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        FrmHospitalizacionListarCajaPreventa frmHospCP=new  FrmHospitalizacionListarCajaPreventa();
        frmHospCP.setVisible(true);
        String u=lblUsu.getText();
        FrmHospitalizacionListarCajaPreventa.lblUsuUsuario.setText(u);
        FrmHospitalizacionListarCajaPreventa.rbtP.setSelected(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        FrmHospitalizacionListarCajaPreventa frmHospCP=new  FrmHospitalizacionListarCajaPreventa();
        HospitalizacionPapeletas hosP = new HospitalizacionPapeletas();
        frmHospCP.setVisible(true);
        String u=lblUsu.getText();
        FrmHospitalizacionListarCajaPreventa.lblUsuUsuario.setText(u);
        FrmHospitalizacionListarCajaPreventa.rbtH.setSelected(true);
        hosP.listarPapeleta("C", FrmHospitalizacionListarCajaPreventa.txtBuscarr.getText(), FrmHospitalizacionListarCajaPreventa.tbListarPapeleta,"C");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        FrmHospitalizacionFormatoHC frmFormat =new  FrmHospitalizacionFormatoHC();
        frmFormat.setVisible(true);
        String u=lblUsu.getText();
        FrmHospitalizacionFormatoHC.lblUsuUsuario.setText(u);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnReporteFEmer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteFEmer1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReporteFEmer1ActionPerformed

    private void btnReportCabecera1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportCabecera1ActionPerformed
        FrmListFormatoEmergencia frmEmerList = new FrmListFormatoEmergencia();
        frmEmerList.setVisible(true);
        String u=PrincipalMDI.lblUsu.getText();
        frmEmerList.lblUsuUsuario.setText(u);
        FrmListFormatoEmergencia.tbpReporteEmergencia.setSelectedIndex(0);
    }//GEN-LAST:event_btnReportCabecera1ActionPerformed

    private void btnReporTopico1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporTopico1ActionPerformed
        FrmListFormatoEmergencia frmEmerList = new FrmListFormatoEmergencia();
        frmEmerList.setVisible(true);
        String u=PrincipalMDI.lblUsu.getText();
        frmEmerList.lblUsuUsuario.setText(u);
        FrmListFormatoEmergencia.tbpReporteEmergencia.setSelectedIndex(2);
    }//GEN-LAST:event_btnReporTopico1ActionPerformed

    private void btnReportTriaje1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportTriaje1ActionPerformed
        FrmListFormatoEmergencia frmEmerList = new FrmListFormatoEmergencia();
        frmEmerList.setVisible(true);
        String u=PrincipalMDI.lblUsu.getText();
        frmEmerList.lblUsuUsuario.setText(u);
        FrmListFormatoEmergencia.tbpReporteEmergencia.setSelectedIndex(1);
    }//GEN-LAST:event_btnReportTriaje1ActionPerformed

    private void btnMantLlegada1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMantLlegada1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMantLlegada1ActionPerformed

    private void btnFormatEmergencia1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFormatEmergencia1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFormatEmergencia1ActionPerformed

    private void btnFormatEmergencia3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFormatEmergencia3ActionPerformed
        FrmFormatoEmergencia frmEmer = new FrmFormatoEmergencia();
        frmEmer.setVisible(true);
        String u=PrincipalMDI.lblUsu.getText();
        frmEmer.lblusu.setText(u);
    }//GEN-LAST:event_btnFormatEmergencia3ActionPerformed

    private void btnMantLlegada2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMantLlegada2ActionPerformed
        FrmFormaDeLlegada frmEmerFL = new FrmFormaDeLlegada();
        frmEmerFL.setVisible(true);
        String u=PrincipalMDI.lblUsu.getText();
        frmEmerFL.lblUsuario.setText(u);
    }//GEN-LAST:event_btnMantLlegada2ActionPerformed

    private void btnAdmEmeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdmEmeMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdmEmeMouseEntered

    private void btnAdmEmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmEmeActionPerformed
        p1.setVisible(false);
         p2.setVisible(false);
         p3.setVisible(false);       
         p4.setVisible(true);
         p9.setVisible(false);
         p10.setVisible(false); 
         p11.setVisible(false);
         p12.setVisible(false);  
         p13.setVisible(false);  
         p14.setVisible(false);  
         p15.setVisible(false);
         p16.setVisible(false);
         p17.setVisible(false);
        jTabbedPane1.setSelectedIndex(6);
    }//GEN-LAST:event_btnAdmEmeActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        FrmHospitalizacionExClinico frmExamen =new  FrmHospitalizacionExClinico();
        frmExamen.setVisible(true);
        String u=lblUsu.getText();
        FrmHospitalizacionExClinico.lblUsuUsuario.setText(u);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btneditar11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditar11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btneditar11ActionPerformed

    private void jLabel41MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel41MouseClicked
        btnMuestras.doClick();
    }//GEN-LAST:event_jLabel41MouseClicked

    private void btnMuestrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMuestrasActionPerformed
        frm_LAB_MUESTRA_EXAMEN lme=new  frm_LAB_MUESTRA_EXAMEN();
        lme.setVisible(true);
        String u=lblUsu.getText();
        frm_LAB_MUESTRA_EXAMEN.lblUsu.setText(u);
    }//GEN-LAST:event_btnMuestrasActionPerformed

    private void jLabel52MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel52MouseClicked
        btnEsquema.doClick();
    }//GEN-LAST:event_jLabel52MouseClicked

    private void jLabel53MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel53MouseClicked
        btnEsquema.doClick();
    }//GEN-LAST:event_jLabel53MouseClicked

    private void btnEsquemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEsquemaActionPerformed
        frm_LAB_ESQUEMA_RESULTADO_INGRESO lme=new  frm_LAB_ESQUEMA_RESULTADO_INGRESO();
        lme.setVisible(true);
        String u=lblUsu.getText();
        frm_LAB_ESQUEMA_RESULTADO_INGRESO.lblUsu.setText(u);
    }//GEN-LAST:event_btnEsquemaActionPerformed

    private void jLabel55MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel55MouseClicked
        btnValores.doClick();
    }//GEN-LAST:event_jLabel55MouseClicked

    private void jLabel56MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel56MouseClicked
        btnValores.doClick();
    }//GEN-LAST:event_jLabel56MouseClicked

    private void btnValoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValoresActionPerformed
        frm_LAB_VALORES_REFERENCIALES_INGRESO lme=new   frm_LAB_VALORES_REFERENCIALES_INGRESO();
        lme.setVisible(true);
        String u=lblUsu.getText();
        frm_LAB_VALORES_REFERENCIALES_INGRESO.lblUsu.setText(u);
    }//GEN-LAST:event_btnValoresActionPerformed

    private void jLabel38MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel38MouseClicked
        btnUnidadMedi.doClick();
    }//GEN-LAST:event_jLabel38MouseClicked

    private void btnUnidadMediActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnidadMediActionPerformed
        frm_LAB_UNIDAD_MEDIDA_RESULTADO lme=new  frm_LAB_UNIDAD_MEDIDA_RESULTADO();
        lme.setVisible(true);
        String u=lblUsu.getText();
        frm_LAB_UNIDAD_MEDIDA_RESULTADO.lblUsu.setText(u);
    }//GEN-LAST:event_btnUnidadMediActionPerformed

    private void jLabel46MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel46MouseClicked
        btnAnalisis.doClick();
    }//GEN-LAST:event_jLabel46MouseClicked

    private void btnAnalisisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalisisActionPerformed
        frm_LAB_ANALISIS_EXAMEN lme=new  frm_LAB_ANALISIS_EXAMEN();
        lme.setVisible(true);
        String u=lblUsu.getText();
        frm_LAB_ANALISIS_EXAMEN.lblUsu.setText(u);
    }//GEN-LAST:event_btnAnalisisActionPerformed

    private void jLabel54MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel54MouseClicked
        btnClasificacion.doClick();
    }//GEN-LAST:event_jLabel54MouseClicked

    private void btnClasificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClasificacionActionPerformed
        frm_LAB_CLASIFICACION_EXAMEN lme=new  frm_LAB_CLASIFICACION_EXAMEN();
        lme.setVisible(true);
        String u=lblUsu.getText();
        frm_LAB_CLASIFICACION_EXAMEN.lblUsu.setText(u);
    }//GEN-LAST:event_btnClasificacionActionPerformed

    private void jLabel89MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel89MouseClicked
        btnTM.doClick();
    }//GEN-LAST:event_jLabel89MouseClicked

    private void btnTMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTMActionPerformed
        frm_LAB_TOMA_MUESTRA_INGRESO lme=new  frm_LAB_TOMA_MUESTRA_INGRESO();
        lme.setVisible(true);
        String u=lblUsu.getText();
        frm_LAB_TOMA_MUESTRA_INGRESO.lblUsu.setText(u);
    }//GEN-LAST:event_btnTMActionPerformed

    private void jLabel94MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel94MouseClicked
        btnTMBusqueda.doClick();
    }//GEN-LAST:event_jLabel94MouseClicked

    private void btnTMBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTMBusquedaActionPerformed
       frm_LAB_BUSCAR_TOMA_MUESTRA lme=new  frm_LAB_BUSCAR_TOMA_MUESTRA();
        lme.setVisible(true);
        String u=lblUsu.getText();
        frm_LAB_BUSCAR_TOMA_MUESTRA.lblUsu.setText(u);
    }//GEN-LAST:event_btnTMBusquedaActionPerformed

    private void jLabel96MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel96MouseClicked
        btnResultado.doClick();
    }//GEN-LAST:event_jLabel96MouseClicked

    private void btnResultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResultadoActionPerformed
       frm_LAB_RESULTADOS_MUESTRA_INGRESO lme=new  frm_LAB_RESULTADOS_MUESTRA_INGRESO();
        lme.setVisible(true);
        String u=lblUsu.getText();
        frm_LAB_RESULTADOS_MUESTRA_INGRESO.lblUsu.setText(u);
    }//GEN-LAST:event_btnResultadoActionPerformed

    private void jLabel97MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel97MouseClicked
        btnResultadoBusq.doClick();
    }//GEN-LAST:event_jLabel97MouseClicked

    private void btnResultadoBusqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResultadoBusqActionPerformed
        frm_LAB_BUSCAR_RESULTADO lme=new  frm_LAB_BUSCAR_RESULTADO();
        lme.setVisible(true);
        String u=lblUsu.getText();
        frm_LAB_BUSCAR_RESULTADO.lblUsu.setText(u);
    }//GEN-LAST:event_btnResultadoBusqActionPerformed

    private void jLabel98MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel98MouseClicked
        btnEntrega.doClick();
    }//GEN-LAST:event_jLabel98MouseClicked

    private void btnEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntregaActionPerformed
       frm_LAB_ENTREGA_RESULTADO lme=new  frm_LAB_ENTREGA_RESULTADO();
        lme.setVisible(true);
        String u=lblUsu.getText();
        frm_LAB_ENTREGA_RESULTADO.lblUsu.setText(u);
    }//GEN-LAST:event_btnEntregaActionPerformed

    private void btnConversionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConversionActionPerformed
        frm_LAB_CONVERSION lme=new  frm_LAB_CONVERSION();
        lme.setVisible(true);
        String u=lblUsu.getText();
        frm_LAB_CONVERSION.lblUsu.setText(u);
    }//GEN-LAST:event_btnConversionActionPerformed

    private void btnSolicitudRecepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolicitudRecepActionPerformed
        frm_RECEP_SOLICITUDES lme=new  frm_RECEP_SOLICITUDES();
        lme.setVisible(true);
        
    }//GEN-LAST:event_btnSolicitudRecepActionPerformed

    private void jLabel99MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel99MouseClicked
        btnConversion.doClick();
    }//GEN-LAST:event_jLabel99MouseClicked

    private void jLabel100MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel100MouseClicked
        btnSolicitudRecep.doClick();
    }//GEN-LAST:event_jLabel100MouseClicked

    private void jLabel57MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel57MouseClicked
        btnContenedor.doClick();
    }//GEN-LAST:event_jLabel57MouseClicked

    private void btnContenedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContenedorActionPerformed
        frm_LAB_CONTENEDOR_MUESTRA lme=new  frm_LAB_CONTENEDOR_MUESTRA();
        lme.setVisible(true);
        String u=lblUsu.getText();
        frm_LAB_CONTENEDOR_MUESTRA.lblUsu.setText(u);
    }//GEN-LAST:event_btnContenedorActionPerformed

    private void jLabel83MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel83MouseClicked
        if(evt.getClickCount()==1){
            FrmHospitalizacionPisos frmHosp = new FrmHospitalizacionPisos();
            frmHosp.setVisible(true);
            String u=PrincipalMDI.lblUsu.getText();
            frmHosp.lblUsuUsuario.setText(u);
        }
    }//GEN-LAST:event_jLabel83MouseClicked

    private void btnConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfiguracionActionPerformed
        p1.setVisible(false);
         p2.setVisible(false);
         p3.setVisible(false);        // TODO add your handling code here:
         p9.setVisible(false);
         p10.setVisible(false); 
         p11.setVisible(false);
         p12.setVisible(false);    
         p13.setVisible(true);  
         p14.setVisible(false); 
         p15.setVisible(false);
         p16.setVisible(false);
         p17.setVisible(false);
        jTabbedPane1.setSelectedIndex(12);
    }//GEN-LAST:event_btnConfiguracionActionPerformed

    private void btnSolicitudInvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolicitudInvActionPerformed
       frm_SOLICITUD_INVESTIGACION_BACT sol=new frm_SOLICITUD_INVESTIGACION_BACT();
       sol.setVisible(true);
       String u=lblUsu.getText();
       frm_SOLICITUD_INVESTIGACION_BACT.lblUsu.setText(u);
    }//GEN-LAST:event_btnSolicitudInvActionPerformed

    private void jLabel58MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel58MouseClicked
        btnSolicitudInv.doClick();
    }//GEN-LAST:event_jLabel58MouseClicked

    private void jLabel104MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel104MouseClicked
        btnConsultorio.doClick();
    }//GEN-LAST:event_jLabel104MouseClicked

    private void btnConsultorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultorioActionPerformed
        ConsultorioExt consultorio = new ConsultorioExt();
        consultorio.setVisible(true);
        String u=lblUsu.getText();
        ConsultorioExt.lblUsu.setText(u);
    }//GEN-LAST:event_btnConsultorioActionPerformed

    private void jLabel105MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel105MouseClicked
        btnTriaje.doClick();
    }//GEN-LAST:event_jLabel105MouseClicked

    private void btnTriajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTriajeActionPerformed
        Triaje triaje = new Triaje();
        triaje.setVisible(true);
        String u=lblUsu.getText();
        Triaje.lblUsu.setText(u);
    }//GEN-LAST:event_btnTriajeActionPerformed

    private void btnConExtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConExtActionPerformed
         p1.setVisible(false);
         p2.setVisible(false);
         p3.setVisible(false);        // TODO add your handling code here:
         p9.setVisible(false);
         p10.setVisible(false); 
         p11.setVisible(false);
         p12.setVisible(false);    
         p13.setVisible(false);  
         p14.setVisible(true); 
         p15.setVisible(false);
         p16.setVisible(false);
         p17.setVisible(false);
        jTabbedPane1.setSelectedIndex(8);
    }//GEN-LAST:event_btnConExtActionPerformed

    private void jLabel106MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel106MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel106MouseClicked

    private void btnValores3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValores3ActionPerformed
        RegistroSeguimiento seguimiento = new RegistroSeguimiento();
        seguimiento.setVisible(true);
        String u=lblUsu.getText();
        RegistroSeguimiento.lblUsu.setText(u);
    }//GEN-LAST:event_btnValores3ActionPerformed

    private void jLabel107MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel107MouseClicked
        btnCarnetPerinatal.doClick();
    }//GEN-LAST:event_jLabel107MouseClicked

    private void btnCarnetPerinatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarnetPerinatalActionPerformed
        RegistroEmbarazo embarazo = new RegistroEmbarazo();
        embarazo.setVisible(true);
        String u=lblUsu.getText();
        RegistroEmbarazo.lblUsu.setText(u);
    }//GEN-LAST:event_btnCarnetPerinatalActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        FrmHospitalizacionNotaEnfermeria notaEnfermeria = new FrmHospitalizacionNotaEnfermeria();
        notaEnfermeria.setVisible(true);
        String u=lblUsu.getText();
        FrmHospitalizacionNotaEnfermeria.lblUsu.setText(u);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        FrmHospitalizacionEpicrisis epicrisis = new FrmHospitalizacionEpicrisis();
        epicrisis.setVisible(true);
        String u=lblUsu.getText();
        FrmHospitalizacionEpicrisis.lblUsu.setText(u);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnguardar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardar3ActionPerformed
     dispose();
        inicioSesion i=new inicioSesion();
      i.setVisible(true);
    }//GEN-LAST:event_btnguardar3ActionPerformed

    private void jLabel101KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel101KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel101KeyPressed

    private void jLabel101MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel101MouseClicked
        Caja_Pagos CP = new Caja_Pagos();
        CP.setVisible(true);
        String u=PrincipalMDI.lblUsu.getText();
        CP.lblusu.setText(u);
    }//GEN-LAST:event_jLabel101MouseClicked

    private void lblUsuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUsuMouseClicked
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_lblUsuMouseClicked

    private void btneditar16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditar16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btneditar16ActionPerformed

    private void btneditar16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btneditar16MouseClicked
        Caja_Empresa_jerarquia CEJFP = new Caja_Empresa_jerarquia();
        CEJFP.setVisible(true);
        String u=PrincipalMDI.lblUsu.getText();
        CEJFP.lblusu.setText(u);
    }//GEN-LAST:event_btneditar16MouseClicked

    private void btneditar14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btneditar14MouseClicked
        Caja_Nomenclaturas CCPT = new Caja_Nomenclaturas();
        CCPT.setVisible(true);
        String u=PrincipalMDI.lblUsu.getText();
        CCPT.lblusu.setText(u);
    }//GEN-LAST:event_btneditar14MouseClicked

    private void jLabel102MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel102MouseClicked
         FrmHospitalizacionCajaPreventa frmHosp = new FrmHospitalizacionCajaPreventa();
            frmHosp.setVisible(true);
            String u=PrincipalMDI.lblUsu.getText();
            String servicio = PrincipalMDI.lblServicio.getText();
            frmHosp.lblUsuUsuario.setText(u);
            //DefaultComboBoxModel  listmodel = new DefaultComboBoxModel ();
            frmHosp.cbxServicio.addItem(servicio);
            frmHosp.cbxServicio.setSelectedItem(servicio);
            frmHosp.lblServicio.setText(servicio);
    }//GEN-LAST:event_jLabel102MouseClicked

    private void jLabel102KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel102KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel102KeyPressed

    private void jLabel40MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MouseClicked
        if(evt.getClickCount()==1){
            btnPaciente.doClick();
        }
    }//GEN-LAST:event_jLabel40MouseClicked

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
        if(evt.getClickCount()==1){
            btnSectorizacion.doClick();
        }
    }//GEN-LAST:event_jLabel28MouseClicked

    private void jLabel30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseClicked
        if(evt.getClickCount()==1){
            btnReportMovinientoHC.doClick();
        }
    }//GEN-LAST:event_jLabel30MouseClicked

    private void jLabel90MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel90MouseClicked
        if(evt.getClickCount()==1){    
            btnFormatEmergencia3.doClick();
        }
    }//GEN-LAST:event_jLabel90MouseClicked

    private void jLabel92MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel92MouseClicked
        if(evt.getClickCount()==1){
            btnMantLlegada2.doClick();
        }
    }//GEN-LAST:event_jLabel92MouseClicked

    private void jLabel77MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel77MouseClicked
        if(evt.getClickCount()==1){
            btnReportCabecera1.doClick();
        }
    }//GEN-LAST:event_jLabel77MouseClicked

    private void btnAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlmacenActionPerformed
         p1.setVisible(false);
         p2.setVisible(false);
         p3.setVisible(false);        // TODO add your handling code here:
         p9.setVisible(false);
         p10.setVisible(false); 
         p11.setVisible(false);
         p12.setVisible(false);    
         p13.setVisible(false);  
         p14.setVisible(false); 
         p15.setVisible(true);
         p16.setVisible(false);
         p17.setVisible(false);
        jTabbedPane1.setSelectedIndex(10);
    }//GEN-LAST:event_btnAlmacenActionPerformed

    private void btnPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPersonalActionPerformed
        p1.setVisible(false);
         p2.setVisible(false);
         p3.setVisible(false);        // TODO add your handling code here:
         p9.setVisible(false);
         p10.setVisible(false); 
         p11.setVisible(false);
         p12.setVisible(false);    
         p13.setVisible(false);  
         p14.setVisible(false); 
         p15.setVisible(false);
         p16.setVisible(true);
         p17.setVisible(false);
        jTabbedPane1.setSelectedIndex(11);
    }//GEN-LAST:event_btnPersonalActionPerformed

    private void btnEcografiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEcografiaActionPerformed
         p1.setVisible(false);
         p2.setVisible(false);
         p3.setVisible(false);        // TODO add your handling code here:
         p9.setVisible(false);
         p10.setVisible(false); 
         p11.setVisible(false);
         p12.setVisible(false);    
         p13.setVisible(false); 
         p14.setVisible(false);  
         p15.setVisible(false);
         p16.setVisible(false);
         p17.setVisible(true);
         
         jTabbedPane1.setSelectedIndex(13);
    }//GEN-LAST:event_btnEcografiaActionPerformed

    private void jLabel32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MouseClicked
        if(evt.getClickCount()==1){
            btnReportSeguimientoHC.doClick();
        }
    }//GEN-LAST:event_jLabel32MouseClicked

    private void jLabel79MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel79MouseClicked
        if(evt.getClickCount()==1){
            btnReportTriaje1.doClick();
        }
    }//GEN-LAST:event_jLabel79MouseClicked

    private void jLabel78MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel78MouseClicked
        if(evt.getClickCount()==1){
            btnReporTopico1.doClick();
        }
    }//GEN-LAST:event_jLabel78MouseClicked

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        if(evt.getClickCount()==1){
            btnguardar8.doClick();
        }
    }//GEN-LAST:event_jLabel23MouseClicked

    private void btneditar7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditar7ActionPerformed
          frm_Asig_Catalogo_Producto m=new frm_Asig_Catalogo_Producto();
        m.setVisible(true);
    }//GEN-LAST:event_btneditar7ActionPerformed

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
        if(evt.getClickCount()==1){
            btnguardar9.doClick();
        }
    }//GEN-LAST:event_jLabel25MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        if(evt.getClickCount()==1){
            btneditar4.doClick();
        }
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        if(evt.getClickCount()==1){
            btneditar7.doClick();
        }
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        if(evt.getClickCount()==1){
            btneditar5.doClick();
        }
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked
        if(evt.getClickCount()==1){
            btneditar9.doClick();
        }
    }//GEN-LAST:event_jLabel27MouseClicked

    private void jLabel31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel31MouseClicked

    private void jLabel33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel33MouseClicked
        if(evt.getClickCount()==1){
            btneditar6.doClick();
        }
    }//GEN-LAST:event_jLabel33MouseClicked

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        try {
            RX_EC_BUSCAR_EXAMEN_C A = new RX_EC_BUSCAR_EXAMEN_C();
            A.setVisible(true);
            String u=lblUsu.getText();
            RX_EC_BUSCAR_EXAMEN_C.lblUsu.setText(u);
        } catch (UnknownHostException ex) {
            Logger.getLogger(PrincipalMDI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        try {
            RX_EC_BUSCAR_EXAMEN_RESULTADO examenRX1 = new RX_EC_BUSCAR_EXAMEN_RESULTADO();
            examenRX1.setVisible(true);
            String u=lblUsu.getText();
            RX_EC_BUSCAR_EXAMEN_RESULTADO.lblUsu.setText(u);
        } catch (UnknownHostException ex) {
            Logger.getLogger(PrincipalMDI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        RX_EC_BUSCAR_RESULTADOS resultadoRX1 = new RX_EC_BUSCAR_RESULTADOS();
        resultadoRX1.setVisible(true);
        String u=lblUsu.getText();
        RX_EC_BUSCAR_RESULTADOS.lblUsu.setText(u);
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        try {
            RX_EC_BUSCAR_EXAMEN_C G = new RX_EC_BUSCAR_EXAMEN_C();
            G.setVisible(true);
            String u=lblUsu.getText();
            RX_EC_BUSCAR_EXAMEN_C.lblUsu.setText(u);
        } catch (UnknownHostException ex) {
            Logger.getLogger(PrincipalMDI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        try {
            RX_EC_BUSCAR_EXAMEN_RESULTADO examenRX = new RX_EC_BUSCAR_EXAMEN_RESULTADO();
            examenRX.setVisible(true);
            String u=lblUsu.getText();
            RX_EC_BUSCAR_EXAMEN_RESULTADO.lblUsu.setText(u);
        } catch (UnknownHostException ex) {
            Logger.getLogger(PrincipalMDI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        RX_EC_BUSCAR_RESULTADOS resultadoRX = new RX_EC_BUSCAR_RESULTADOS();
        resultadoRX.setVisible(true);
        String u=lblUsu.getText();
        RX_EC_BUSCAR_RESULTADOS.lblUsu.setText(u);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        EC_BUSCAR_EXAMEN_CAJA examenEC = new EC_BUSCAR_EXAMEN_CAJA();
        examenEC.setVisible(true);
        String u = lblUsu.getText();
        EC_BUSCAR_EXAMEN_CAJA.lblUsu.setText(u);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton20ActionPerformed


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
            java.util.logging.Logger.getLogger(PrincipalMDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalMDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalMDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalMDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalMDI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnAdmCentral;
    public static javax.swing.JButton btnAdmEme;
    public static javax.swing.JButton btnAlmacen;
    private javax.swing.JButton btnAnalisis;
    public static javax.swing.JButton btnCaja;
    private javax.swing.JButton btnCarnetPerinatal;
    private javax.swing.JButton btnClasificacion;
    public static javax.swing.JButton btnConExt;
    public static javax.swing.JButton btnConfiguracion;
    private javax.swing.JButton btnConsultorio;
    private javax.swing.JButton btnContenedor;
    private javax.swing.JButton btnConversion;
    public static javax.swing.JButton btnCostos;
    public static javax.swing.JButton btnEcografia;
    private javax.swing.JButton btnEntrega;
    private javax.swing.JButton btnEsquema;
    private javax.swing.JButton btnFormatEmergencia1;
    private javax.swing.JButton btnFormatEmergencia3;
    public static javax.swing.JButton btnHospitalizacion;
    public static javax.swing.JButton btnInvBact;
    public static javax.swing.JButton btnLaboratorio;
    private javax.swing.JButton btnMantLlegada1;
    private javax.swing.JButton btnMantLlegada2;
    private javax.swing.JButton btnMuestras;
    private javax.swing.JButton btnPaciente;
    public static javax.swing.JButton btnPersonal;
    public static javax.swing.JButton btnRayosX;
    private javax.swing.JButton btnReporTopico1;
    private javax.swing.JButton btnReportCabecera1;
    private javax.swing.JButton btnReportMovinientoHC;
    private javax.swing.JButton btnReportSeguimientoHC;
    private javax.swing.JButton btnReportTriaje1;
    private javax.swing.JButton btnReporteAdmiCentral;
    private javax.swing.JButton btnReporteFEmer1;
    private javax.swing.JButton btnResultado;
    private javax.swing.JButton btnResultadoBusq;
    private javax.swing.JButton btnSectorizacion;
    private javax.swing.JButton btnSolicitudInv;
    private javax.swing.JButton btnSolicitudRecep;
    private javax.swing.JButton btnTM;
    private javax.swing.JButton btnTMBusqueda;
    private javax.swing.JButton btnTriaje;
    private javax.swing.JButton btnUnidadMedi;
    private javax.swing.JButton btnValores;
    private javax.swing.JButton btnValores3;
    private javax.swing.JButton btneditar1;
    private javax.swing.JButton btneditar11;
    private javax.swing.JButton btneditar14;
    private javax.swing.JButton btneditar15;
    private javax.swing.JButton btneditar16;
    private javax.swing.JButton btneditar17;
    private javax.swing.JButton btneditar4;
    private javax.swing.JButton btneditar5;
    private javax.swing.JButton btneditar6;
    private javax.swing.JButton btneditar7;
    private javax.swing.JButton btneditar8;
    private javax.swing.JButton btneditar9;
    private javax.swing.JButton btnguardar1;
    private javax.swing.JButton btnguardar24;
    private javax.swing.JButton btnguardar26;
    private javax.swing.JButton btnguardar27;
    private javax.swing.JButton btnguardar3;
    private javax.swing.JButton btnguardar4;
    private javax.swing.JButton btnguardar8;
    private javax.swing.JButton btnguardar9;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel100;
    private javax.swing.JPanel jPanel101;
    private javax.swing.JPanel jPanel102;
    private javax.swing.JPanel jPanel103;
    private javax.swing.JPanel jPanel104;
    private javax.swing.JPanel jPanel105;
    private javax.swing.JPanel jPanel106;
    private javax.swing.JPanel jPanel107;
    private javax.swing.JPanel jPanel108;
    private javax.swing.JPanel jPanel109;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel110;
    private javax.swing.JPanel jPanel111;
    private javax.swing.JPanel jPanel112;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
<<<<<<< HEAD
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel35;
=======
>>>>>>> e8145f716c806bc6b727ba07563c3e44f26f6308
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
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
    private javax.swing.JPanel jPanel71;
    private javax.swing.JPanel jPanel72;
    private javax.swing.JPanel jPanel73;
    private javax.swing.JPanel jPanel74;
    private javax.swing.JPanel jPanel75;
    private javax.swing.JPanel jPanel76;
    private javax.swing.JPanel jPanel77;
    private javax.swing.JPanel jPanel78;
    private javax.swing.JPanel jPanel79;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel80;
    private javax.swing.JPanel jPanel81;
    private javax.swing.JPanel jPanel82;
    private javax.swing.JPanel jPanel83;
    private javax.swing.JPanel jPanel84;
    private javax.swing.JPanel jPanel85;
    private javax.swing.JPanel jPanel86;
    private javax.swing.JPanel jPanel87;
    private javax.swing.JPanel jPanel88;
    private javax.swing.JPanel jPanel89;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanel90;
    private javax.swing.JPanel jPanel91;
    private javax.swing.JPanel jPanel92;
    private javax.swing.JPanel jPanel93;
    private javax.swing.JPanel jPanel94;
    private javax.swing.JPanel jPanel95;
    private javax.swing.JPanel jPanel96;
    private javax.swing.JPanel jPanel97;
    private javax.swing.JPanel jPanel98;
    private javax.swing.JPanel jPanel99;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JLabel lblSe_ID;
    public static javax.swing.JLabel lblServicio;
    public static javax.swing.JLabel lblUsu;
    private javax.swing.JLabel lblusu10;
    private javax.swing.JLabel lblusu3;
    private javax.swing.JLabel lblusu5;
    private javax.swing.JLabel lblusu7;
    private javax.swing.JLabel lblusu8;
    private javax.swing.JLabel lblusu9;
    private javax.swing.JPanel p1;
    private javax.swing.JPanel p10;
    private javax.swing.JPanel p11;
    private javax.swing.JPanel p12;
    private javax.swing.JPanel p13;
    private javax.swing.JPanel p14;
    private javax.swing.JPanel p15;
    private javax.swing.JPanel p16;
    private javax.swing.JPanel p17;
    private javax.swing.JPanel p2;
    private javax.swing.JPanel p3;
    private javax.swing.JPanel p4;
    private javax.swing.JPanel p9;
    // End of variables declaration//GEN-END:variables
}
