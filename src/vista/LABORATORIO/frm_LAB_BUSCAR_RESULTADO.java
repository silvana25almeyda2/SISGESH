
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.LABORATORIO;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;
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
import modelos.LABORATORIO.LAB_Resultado_Muestra_Cabecera;
import modelos.LABORATORIO.Render_Checkbox;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import servicios.Conexion;
import static vista.LABORATORIO.frm_LAB_TOMA_MUESTRA_CABECERA.lblDocumento;
import static vista.Principal.fechaActual;
import vista.frmlaboratorioClinico;
import vista.LABORATORIO.frm_LAB_RESULTADO_MUESTRA;
/**
 *
 * @author PC-SISTEMA
 */
public class frm_LAB_BUSCAR_RESULTADO extends javax.swing.JFrame implements Runnable{
String hora, minutos, segundos, ampm;
    Calendar calendario;
    Thread h1;
    Connection conexion=null;
Conexion c=new Conexion();
DefaultTableModel m,n,resultado;

    /**
     * Creates new form LAB_MUESTRA_EXAMEN
     */
    public frm_LAB_BUSCAR_RESULTADO() {
        initComponents();
        c.conectar();
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/iconos/laboratorio.png")).getImage());
     
        addEscapeListenerWindowDialog(personal);
        addEscapeListenerWindowDialog(buscar_HC);        
        addEscapeListenerWindowDialog(analisis);
        
        h1 = new Thread(this);
        h1.start();
        buscar_HC.getContentPane().setBackground(Color.white); 
        buscar_HC.setLocationRelativeTo(null);
        personal.getContentPane().setBackground(Color.white);
        personal.setLocationRelativeTo(null);
        analisis.getContentPane().setBackground(Color.white);
        analisis.setLocationRelativeTo(null);
     
        panelPacientes.setBackground(Color.white);
         chPacientes.setVisible(false);
        txtPacientes.setVisible(false);
            btnPacientes.setVisible(false);
            chAnalisis.setVisible(false);
            txtAnalisis.setVisible(false);
            btnAnalisis.setVisible(false);
            chPersonal.setVisible(false);
            txtPersonal.setVisible(false);
            btnPersonal.setVisible(false);
            btnBuscar.setVisible(false);
            chActoMedico.setVisible(false);
            txtActoM.setVisible(false);
        lblServicio.setVisible(false);
        lblArea.setVisible(false);
        this.getContentPane().setBackground(Color.white); 
       
        setLocationRelativeTo(null);//en el centro
        setResizable(false);//para que no funcione el boton maximizar
        buscar_HC.setResizable(false);
        dateDesde.setBackground(Color.white);
        dateHasta.setBackground(Color.white);
        //fecha
       Calendar cal=Calendar.getInstance(); 
        String hora=cal.get(cal.HOUR_OF_DAY)+":"+cal.get(cal.MINUTE)+":"+cal.get(cal.SECOND); 
//        lblFecha.setText(fechaActual());
       
    dateDesde.requestFocus();
  
 
    //inicio
    txtPacientes.setEnabled(false);
            btnPacientes.setEnabled(false);
            txtAnalisis.setEnabled(false);
            btnAnalisis.setEnabled(false);
            txtPersonal.setEnabled(false);
            txtActoM.setEnabled(false);
            btnPersonal.setEnabled(false);
    //Servicio-Area
        LAB_PC_AREA pa=new LAB_PC_AREA();
        lblServicio.setText(pa.LAB_PC_AREA_SERVICIO());
        lblArea.setText(pa.LAB_PC_AREA_AREA());
       LAB_BUSCAR_TM_DIA();
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
     
    public void formato(){
    tb_TomasRealizadas.getColumnModel().getColumn(3).setPreferredWidth(200);
    tb_TomasRealizadas.getColumnModel().getColumn(4).setPreferredWidth(90);
    tb_TomasRealizadas.getColumnModel().getColumn(5).setPreferredWidth(250);
    tb_TomasRealizadas.getColumnModel().getColumn(6).setPreferredWidth(240);
    tb_TomasRealizadas.getColumnModel().getColumn(7).setPreferredWidth(140);
    tb_TomasRealizadas.getColumnModel().getColumn(8).setPreferredWidth(140);
    tb_TomasRealizadas.getColumnModel().getColumn(9).setPreferredWidth(90);
    tb_TomasRealizadas.getColumnModel().getColumn(10).setPreferredWidth(250);
    tb_TomasRealizadas.getColumnModel().getColumn(11).setPreferredWidth(85);
    tb_TomasRealizadas.getColumnModel().getColumn(12).setPreferredWidth(140);
    tb_TomasRealizadas.getColumnModel().getColumn(13).setPreferredWidth(50);
    tb_TomasRealizadas.getColumnModel().getColumn(14).setPreferredWidth(50);
    tb_TomasRealizadas.getColumnModel().getColumn(15).setPreferredWidth(130);
    tb_TomasRealizadas.getColumnModel().getColumn(17).setPreferredWidth(180);
    tb_TomasRealizadas.getColumnModel().getColumn(18).setPreferredWidth(180);
    tb_TomasRealizadas.getColumnModel().getColumn(19).setPreferredWidth(130);
    tb_TomasRealizadas.getColumnModel().getColumn(20).setPreferredWidth(130);
    //Ocultar    
    tb_TomasRealizadas.getColumnModel().getColumn(0).setMinWidth(0);
    tb_TomasRealizadas.getColumnModel().getColumn(0).setMaxWidth(0);
    tb_TomasRealizadas.getColumnModel().getColumn(1).setMinWidth(0);
    tb_TomasRealizadas.getColumnModel().getColumn(1).setMaxWidth(0);
    tb_TomasRealizadas.getColumnModel().getColumn(2).setMinWidth(0);
    tb_TomasRealizadas.getColumnModel().getColumn(2).setMaxWidth(0);
//    tb_TomasRealizadas.getColumnModel().getColumn(3).setMinWidth(0);
//    tb_TomasRealizadas.getColumnModel().getColumn(3).setMaxWidth(0);
    tb_TomasRealizadas.getColumnModel().getColumn(16).setMinWidth(0);
    tb_TomasRealizadas.getColumnModel().getColumn(16).setMaxWidth(0);
//    tb_TomasRealizadas.getColumnModel().getColumn(17).setMinWidth(0);
//    tb_TomasRealizadas.getColumnModel().getColumn(17).setMaxWidth(0);
//    tb_TomasRealizadas.getColumnModel().getColumn(18).setMinWidth(0);
//    tb_TomasRealizadas.getColumnModel().getColumn(18).setMaxWidth(0);
    
    tb_TomasRealizadas.getColumnModel().getColumn(21).setMinWidth(0);
    tb_TomasRealizadas.getColumnModel().getColumn(21).setMaxWidth(0);
    tb_TomasRealizadas.getColumnModel().getColumn(22).setMinWidth(0);
    tb_TomasRealizadas.getColumnModel().getColumn(22).setMaxWidth(0);
    tb_TomasRealizadas.getColumnModel().getColumn(23).setMinWidth(0);
    tb_TomasRealizadas.getColumnModel().getColumn(23).setMaxWidth(0);
    tb_TomasRealizadas.getColumnModel().getColumn(24).setMinWidth(0);
    tb_TomasRealizadas.getColumnModel().getColumn(24).setMaxWidth(0);
    tb_TomasRealizadas.getColumnModel().getColumn(25).setMinWidth(0);
    tb_TomasRealizadas.getColumnModel().getColumn(25).setMaxWidth(0);
    tb_TomasRealizadas.getColumnModel().getColumn(26).setMinWidth(0);
    tb_TomasRealizadas.getColumnModel().getColumn(26).setMaxWidth(0);
    tb_TomasRealizadas.getSelectionModel().setSelectionInterval(0, 0);
            tb_TomasRealizadas.requestFocus();
}
    
    public void LAB_BUSCAR_TM_DIA(){
      
        String tipo="",servicioArea="";
        if(lblArea.getText().equalsIgnoreCase("")){
        tipo="9";
        servicioArea=lblServicio.getText();
        }
        else if(lblArea.getText().length()>0 ){
            tipo="0";
            servicioArea=lblArea.getText();        
        }
         
    String consulta="";
        try {
            tb_TomasRealizadas.setModel(new DefaultTableModel());
            String titulos[]={"cod_cab_resultado_mu_ana","cod_exa_ana","id_hc","Servicio/Área","Código CPT",
                "Nomenclatura" ,"Análisis Examen","N° de Resultado","Acto Médico","N° de H.C.","Datos del Paciente",
                "DNI","Fecha de Nacimiento","Edad","Sexo","Forma de Pago","N°de TM","Personal Resultado","Personal Registra Resultado",
                "Fecha Resultado","Hora Resultado","Personal Solicita","Habitacion","Cama","Fecha Orden","Hora Orden","id_cod_doc_det"};
            m=new DefaultTableModel(null,titulos);
            JTable p=new JTable(m);
//            m=(DefaultTableModel)tb_TomasRealizadas.getModel(); Cuando se va agregando
            String fila[]=new String[28];

            LAB_Analisis_Examen obj=new LAB_Analisis_Examen();
                    consulta="exec sp_LAB_BUSQUEDA_RESULTADO ?,?,?,?,?";
            PreparedStatement cmd = obj.getCn().prepareStatement(consulta);
            cmd.setInt(1,0);
            cmd.setInt(2, 0);
            cmd.setString(3, "");
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
                fila[26]=r.getString(27);

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
    
    public void LAB_HC_cargar(){
    try {
             String titulos[]={"N°","N° H.C.","Paciente","Dirección","DNI","Sexo","Fecha de Nac.","Edad","COdigo"};
            m=new DefaultTableModel(null,titulos);
            JTable p=new JTable(m);
//            String fila[]=new String[9];
//
//            LAB_Clasificacion_Examen obj=new LAB_Clasificacion_Examen();
//        String consulta="exec Caja_BuscarHC ?";
//        
//        PreparedStatement cmd = obj.getCn().prepareStatement(consulta);
//            cmd.setString(1, "");
//        ResultSet r=cmd.executeQuery();
//        int c=1;
//        while(r.next()){
//            fila[0]=String.valueOf(c)+"º";
//            fila[1]=r.getString(1);
//            fila[2]=r.getString(2);
//            fila[3]=r.getString(3);
//            fila[4]=r.getString(4);
//            fila[5]=r.getString(5);
//            fila[6]=r.getString(6);
//             fila[7]=r.getString(7);
//              fila[8]=r.getString(8);
//                m.addRow(fila);
//                c++;
//            }
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
    
 public void Personal_cargar(){

    try {
             String titulos[]={"N°","Código","Apellido Paterno","Apellido Materno","Nombres","Cargo","Servicio"};
            m=new DefaultTableModel(null,titulos);
            JTable p=new JTable(m);
            String fila[]=new String[8];
            LAB_Resultado_Muestra_Cabecera obj=new LAB_Resultado_Muestra_Cabecera();
            
        String consulta="exec sp_LAB_PERSONAL ?,?,?";
       PreparedStatement cmd = obj.getCn().prepareStatement(consulta);
            cmd.setString(1, "");
            cmd.setString(2, lblServicio.getText());
            cmd.setString(3, "4");
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
                m.addRow(fila);
                c++;
            }
            tbPersonal.setModel(m);
            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m);
            tbPersonal.setRowSorter(elQueOrdena);
            this.tbPersonal.setModel(m);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(rootPane, e.getMessage());
    }
}
    public void Personal_formato(){
    tbPersonal.getColumnModel().getColumn(0).setPreferredWidth(40);
    tbPersonal.getColumnModel().getColumn(1).setPreferredWidth(100);
    tbPersonal.getColumnModel().getColumn(2).setPreferredWidth(120);
    tbPersonal.getColumnModel().getColumn(3).setPreferredWidth(120);
    tbPersonal.getColumnModel().getColumn(4).setPreferredWidth(200);
    tbPersonal.getColumnModel().getColumn(5).setPreferredWidth(250);
    tbPersonal.getColumnModel().getColumn(6).setPreferredWidth(140);
    
    tbPersonal.getSelectionModel().setSelectionInterval(0, 0);
            tbPersonal.requestFocus();
}

    
    public void Analisis_cargar(){
            String serArea="",tipo="";
            if(lblArea.getText().equalsIgnoreCase("")){
                serArea=lblServicio.getText();
                tipo="1";
            }else{
                serArea=lblArea.getText();
                tipo="4";
            }
            
            
            try {
            String titulos[]={"N°","Código","Código CPT","Análisis","Servicio","Área"};
            m=new DefaultTableModel(null,titulos);
            JTable p=new JTable(m);
            String fila[]=new String[8];
            LAB_Resultado_Muestra_Cabecera obj=new LAB_Resultado_Muestra_Cabecera ();

            String consulta="exec sp_LAB_RESULTADO_TM_ANALISIS ?,?,?";
            PreparedStatement cmd = obj.getCn().prepareStatement(consulta);
            cmd.setString(1, "");
            cmd.setString(2, serArea);
            cmd.setString(3, tipo);
            ResultSet r=cmd.executeQuery();
            int c=1;
            while(r.next()){
                fila[0]=String.valueOf(c)+"º";
                fila[1]=r.getString(1);
                fila[2]=r.getString(2);
                fila[3]=r.getString(3);
                fila[4]=r.getString(4);
                fila[5]=r.getString(5);
                m.addRow(fila);
                c++;
            }
            tb_Analisis.setModel(m);
            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m);
            tb_Analisis.setRowSorter(elQueOrdena);
            this.tb_Analisis.setModel(m);
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }
     public void Analisis_formato(){
    tb_Analisis.getColumnModel().getColumn(0).setPreferredWidth(40);
    tb_Analisis.getColumnModel().getColumn(1).setPreferredWidth(100);
    tb_Analisis.getColumnModel().getColumn(2).setPreferredWidth(100);
    tb_Analisis.getColumnModel().getColumn(3).setPreferredWidth(250);
    tb_Analisis.getColumnModel().getColumn(4).setPreferredWidth(140);
    tb_Analisis.getColumnModel().getColumn(5).setPreferredWidth(130);
  
    tb_Analisis.getColumnModel().getColumn(1).setMinWidth(0);
    tb_Analisis.getColumnModel().getColumn(1).setMaxWidth(0);
    tb_Analisis.getSelectionModel().setSelectionInterval(0, 0);
            tb_Analisis.requestFocus();
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

        buscar_HC = new javax.swing.JDialog();
        btnBuscar1 = new javax.swing.JButton();
        txtbuscarHC = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_HC = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false; //Disallow the editing of any cell
            }};
            jpanel3 = new javax.swing.JPanel();
            titulo8 = new javax.swing.JLabel();
            jLabel40 = new javax.swing.JLabel();
            personal = new javax.swing.JDialog();
            txtBuscarPersonal = new javax.swing.JTextField();
            jLabel2 = new javax.swing.JLabel();
            btnBuscarPersonal = new javax.swing.JButton();
            jScrollPane2 = new javax.swing.JScrollPane();
            tbPersonal = new javax.swing.JTable(){
                public boolean isCellEditable(int rowIndex, int colIndex){
                    return false; //Disallow the editing of any cell
                }};
                cbxBuscarPersonal = new javax.swing.JComboBox();
                jpanel2 = new javax.swing.JPanel();
                titulo7 = new javax.swing.JLabel();
                analisis = new javax.swing.JDialog();
                jScrollPane3 = new javax.swing.JScrollPane();
                tb_Analisis = new javax.swing.JTable();
                jpanel1 = new javax.swing.JPanel();
                titulo6 = new javax.swing.JLabel();
                jLabel6 = new javax.swing.JLabel();
                cbxBuscarAnalisis = new javax.swing.JComboBox();
                txtBuscarAnalisis = new javax.swing.JTextField();
                btnBuscarAnalisis = new javax.swing.JButton();
                jPopupMenu1 = new javax.swing.JPopupMenu();
                VER = new javax.swing.JMenuItem();
                jSeparator1 = new javax.swing.JPopupMenu.Separator();
                VER_RESULTADO = new javax.swing.JMenuItem();
                EXPORTAR_PDF = new javax.swing.JMenuItem();
                jpanel = new javax.swing.JPanel();
                titulo5 = new javax.swing.JLabel();
                lblUsu = new javax.swing.JLabel();
                jScrollPane5 = new javax.swing.JScrollPane();
                tb_TomasRealizadas = new javax.swing.JTable(){
                    public boolean isCellEditable(int rowIndex, int colIndex){
                        if(colIndex==0){
                            return true;
                        }else{
                            return false; //Disallow the editing of any cell
                        }}};
                        lblServicio = new javax.swing.JLabel();
                        lblArea = new javax.swing.JLabel();
                        panelPacientes = new javax.swing.JPanel();
                        chPacientes = new javax.swing.JCheckBox();
                        txtPacientes = new javax.swing.JTextField();
                        btnPacientes = new javax.swing.JButton();
                        chAnalisis = new javax.swing.JCheckBox();
                        txtAnalisis = new javax.swing.JTextField();
                        btnAnalisis = new javax.swing.JButton();
                        chPersonal = new javax.swing.JCheckBox();
                        txtPersonal = new javax.swing.JTextField();
                        btnPersonal = new javax.swing.JButton();
                        btnBuscar = new javax.swing.JButton();
                        chActoMedico = new javax.swing.JCheckBox();
                        txtActoM = new javax.swing.JTextField();
                        dateDesde = new com.toedter.calendar.JDateChooser();
                        dateHasta = new com.toedter.calendar.JDateChooser();
                        jLabel20 = new javax.swing.JLabel();
                        jLabel21 = new javax.swing.JLabel();
                        cbx = new javax.swing.JComboBox();
                        jLabel19 = new javax.swing.JLabel();
                        lbldia = new javax.swing.JLabel();
                        jPanel1 = new javax.swing.JPanel();
                        jLabel3 = new javax.swing.JLabel();
                        jLabel10 = new javax.swing.JLabel();

                        buscar_HC.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                        buscar_HC.setAlwaysOnTop(true);
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
                        tb_HC.getTableHeader().setReorderingAllowed(false);
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

                        jpanel3.setBackground(new java.awt.Color(2, 67, 115));

                        titulo8.setBackground(new java.awt.Color(0, 102, 102));
                        titulo8.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
                        titulo8.setForeground(new java.awt.Color(255, 255, 255));
                        titulo8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        titulo8.setText("Historia Clínica");
                        titulo8.setToolTipText("");
                        titulo8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

                        javax.swing.GroupLayout jpanel3Layout = new javax.swing.GroupLayout(jpanel3);
                        jpanel3.setLayout(jpanel3Layout);
                        jpanel3Layout.setHorizontalGroup(
                            jpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titulo8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE)
                        );
                        jpanel3Layout.setVerticalGroup(
                            jpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titulo8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        );

                        jLabel40.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
                        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        jLabel40.setText("Búsqueda por H.C / Paciente / DNI");

                        javax.swing.GroupLayout buscar_HCLayout = new javax.swing.GroupLayout(buscar_HC.getContentPane());
                        buscar_HC.getContentPane().setLayout(buscar_HCLayout);
                        buscar_HCLayout.setHorizontalGroup(
                            buscar_HCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(buscar_HCLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jScrollPane1)
                                .addGap(19, 19, 19))
                            .addGroup(buscar_HCLayout.createSequentialGroup()
                                .addGap(300, 300, 300)
                                .addGroup(buscar_HCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtbuscarHC, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(258, Short.MAX_VALUE))
                            .addGroup(buscar_HCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jpanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        );
                        buscar_HCLayout.setVerticalGroup(
                            buscar_HCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buscar_HCLayout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addGroup(buscar_HCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtbuscarHC, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addComponent(jLabel40)
                                .addGap(2, 2, 2)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(41, Short.MAX_VALUE))
                            .addGroup(buscar_HCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(buscar_HCLayout.createSequentialGroup()
                                    .addComponent(jpanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 644, Short.MAX_VALUE)))
                        );

                        personal.setAlwaysOnTop(true);
                        personal.setMinimumSize(new java.awt.Dimension(846, 504));

                        txtBuscarPersonal.setForeground(new java.awt.Color(0, 51, 51));
                        txtBuscarPersonal.setEnabled(false);
                        txtBuscarPersonal.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                txtBuscarPersonalActionPerformed(evt);
                            }
                        });
                        txtBuscarPersonal.addKeyListener(new java.awt.event.KeyAdapter() {
                            public void keyPressed(java.awt.event.KeyEvent evt) {
                                txtBuscarPersonalKeyPressed(evt);
                            }
                            public void keyTyped(java.awt.event.KeyEvent evt) {
                                txtBuscarPersonalKeyTyped(evt);
                            }
                        });

                        jLabel2.setText("Búsqueda por:");

                        btnBuscarPersonal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/view.gif"))); // NOI18N
                        btnBuscarPersonal.setBorder(null);
                        btnBuscarPersonal.setEnabled(false);
                        btnBuscarPersonal.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnBuscarPersonalActionPerformed(evt);
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
                        tbPersonal.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
                        tbPersonal.setRowHeight(25);
                        tbPersonal.getTableHeader().setReorderingAllowed(false);
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

                        cbxBuscarPersonal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar...", "Cargo", "Apellidos y Nombres" }));
                        cbxBuscarPersonal.addItemListener(new java.awt.event.ItemListener() {
                            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                                cbxBuscarPersonalItemStateChanged(evt);
                            }
                        });

                        jpanel2.setBackground(new java.awt.Color(2, 67, 115));

                        titulo7.setBackground(new java.awt.Color(0, 102, 102));
                        titulo7.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
                        titulo7.setForeground(new java.awt.Color(255, 255, 255));
                        titulo7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        titulo7.setText("Personal");
                        titulo7.setToolTipText("");
                        titulo7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

                        javax.swing.GroupLayout jpanel2Layout = new javax.swing.GroupLayout(jpanel2);
                        jpanel2.setLayout(jpanel2Layout);
                        jpanel2Layout.setHorizontalGroup(
                            jpanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titulo7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        );
                        jpanel2Layout.setVerticalGroup(
                            jpanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titulo7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        );

                        javax.swing.GroupLayout personalLayout = new javax.swing.GroupLayout(personal.getContentPane());
                        personal.getContentPane().setLayout(personalLayout);
                        personalLayout.setHorizontalGroup(
                            personalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(personalLayout.createSequentialGroup()
                                .addGroup(personalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(personalLayout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(personalLayout.createSequentialGroup()
                                        .addGap(97, 97, 97)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbxBuscarPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(158, 158, 158)
                                        .addComponent(txtBuscarPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnBuscarPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(26, Short.MAX_VALUE))
                            .addComponent(jpanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        );
                        personalLayout.setVerticalGroup(
                            personalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, personalLayout.createSequentialGroup()
                                .addComponent(jpanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(personalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBuscarPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnBuscarPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, personalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cbxBuscarPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(47, Short.MAX_VALUE))
                        );

                        analisis.setAlwaysOnTop(true);
                        analisis.setMinimumSize(new java.awt.Dimension(710, 435));

                        tb_Analisis.setModel(new javax.swing.table.DefaultTableModel(
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
                        tb_Analisis.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
                        tb_Analisis.setRowHeight(21);
                        tb_Analisis.getTableHeader().setReorderingAllowed(false);
                        tb_Analisis.addKeyListener(new java.awt.event.KeyAdapter() {
                            public void keyPressed(java.awt.event.KeyEvent evt) {
                                tb_AnalisisKeyPressed(evt);
                            }
                        });
                        jScrollPane3.setViewportView(tb_Analisis);

                        jpanel1.setBackground(new java.awt.Color(2, 67, 115));

                        titulo6.setBackground(new java.awt.Color(0, 102, 102));
                        titulo6.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
                        titulo6.setForeground(new java.awt.Color(255, 255, 255));
                        titulo6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        titulo6.setText("Análisis");
                        titulo6.setToolTipText("");
                        titulo6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

                        javax.swing.GroupLayout jpanel1Layout = new javax.swing.GroupLayout(jpanel1);
                        jpanel1.setLayout(jpanel1Layout);
                        jpanel1Layout.setHorizontalGroup(
                            jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titulo6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        );
                        jpanel1Layout.setVerticalGroup(
                            jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpanel1Layout.createSequentialGroup()
                                .addComponent(titulo6)
                                .addGap(0, 0, Short.MAX_VALUE))
                        );

                        jLabel6.setText("Búsqueda por:");

                        cbxBuscarAnalisis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar...", "Código CPT", "Análisis" }));
                        cbxBuscarAnalisis.addItemListener(new java.awt.event.ItemListener() {
                            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                                cbxBuscarAnalisisItemStateChanged(evt);
                            }
                        });

                        txtBuscarAnalisis.setForeground(new java.awt.Color(0, 51, 51));
                        txtBuscarAnalisis.setEnabled(false);
                        txtBuscarAnalisis.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                txtBuscarAnalisisActionPerformed(evt);
                            }
                        });
                        txtBuscarAnalisis.addKeyListener(new java.awt.event.KeyAdapter() {
                            public void keyPressed(java.awt.event.KeyEvent evt) {
                                txtBuscarAnalisisKeyPressed(evt);
                            }
                            public void keyTyped(java.awt.event.KeyEvent evt) {
                                txtBuscarAnalisisKeyTyped(evt);
                            }
                        });

                        btnBuscarAnalisis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/view.gif"))); // NOI18N
                        btnBuscarAnalisis.setBorder(null);
                        btnBuscarAnalisis.setEnabled(false);
                        btnBuscarAnalisis.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnBuscarAnalisisActionPerformed(evt);
                            }
                        });

                        javax.swing.GroupLayout analisisLayout = new javax.swing.GroupLayout(analisis.getContentPane());
                        analisis.getContentPane().setLayout(analisisLayout);
                        analisisLayout.setHorizontalGroup(
                            analisisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jpanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(analisisLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(analisisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(analisisLayout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbxBuscarAnalisis, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(131, 131, 131)
                                        .addComponent(txtBuscarAnalisis, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnBuscarAnalisis, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(27, Short.MAX_VALUE))
                        );
                        analisisLayout.setVerticalGroup(
                            analisisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, analisisLayout.createSequentialGroup()
                                .addComponent(jpanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(analisisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBuscarAnalisis, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnBuscarAnalisis, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, analisisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cbxBuscarAnalisis, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46))
                        );

                        jPopupMenu1.setBackground(new java.awt.Color(255, 255, 255));
                        jPopupMenu1.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N

                        VER.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
                        VER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/opciones.png"))); // NOI18N
                        VER.setText("RESULTADO");
                        jPopupMenu1.add(VER);
                        jPopupMenu1.add(jSeparator1);

                        VER_RESULTADO.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
                        VER_RESULTADO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Visualizar-16.png"))); // NOI18N
                        VER_RESULTADO.setText("VISUALIZAR RESULTADO");
                        VER_RESULTADO.setToolTipText("");
                        VER_RESULTADO.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                VER_RESULTADOActionPerformed(evt);
                            }
                        });
                        jPopupMenu1.add(VER_RESULTADO);

                        EXPORTAR_PDF.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
                        EXPORTAR_PDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/pdf.png"))); // NOI18N
                        EXPORTAR_PDF.setText("EXPORTAR A PDF");
                        EXPORTAR_PDF.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                EXPORTAR_PDFActionPerformed(evt);
                            }
                        });
                        jPopupMenu1.add(EXPORTAR_PDF);

                        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                        setPreferredSize(new java.awt.Dimension(1067, 665));

                        jpanel.setBackground(new java.awt.Color(2, 67, 115));

                        titulo5.setBackground(new java.awt.Color(0, 102, 102));
                        titulo5.setFont(new java.awt.Font("Segoe UI Semilight", 0, 36)); // NOI18N
                        titulo5.setForeground(new java.awt.Color(255, 255, 255));
                        titulo5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        titulo5.setText("Exámenes Realizados");
                        titulo5.setToolTipText("");
                        titulo5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

                        lblUsu.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35))
                        );
                        jpanelLayout.setVerticalGroup(
                            jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpanelLayout.createSequentialGroup()
                                .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(titulo5)
                                    .addComponent(lblUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 31, Short.MAX_VALUE))
                        );

                        tb_TomasRealizadas.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
                        tb_TomasRealizadas.setModel(new javax.swing.table.DefaultTableModel(
                            new Object [][] {

                            },
                            new String [] {
                                "cod_cab_toma_mu_exa", "cod_det_toma_mu_ana", "cod_exa_ana", "id_hc", "Servicio/Área", "Código CPT", "Nomenclatura", "Análisis Examen", "N° de Toma de Muestra", "N° de H.C", "Datos del Paciente", "DNI", "Fecha de Nacimiento", "Edad", "Sexo", "Forma de Pago", "Acto Medico", "Nombre Per Toma Muestra", "fecha_toma_mu_de", "hora_toma_mu_de", "nom_per_solicita", "hab_nom", "cama", "id_cod_doc_det"
                            }
                        ) {
                            boolean[] canEdit = new boolean [] {
                                true, false, true, true, false, true, true, false, true, false, false, false, false, false, false, false, false, true, true, true, true, true, true, false
                            };

                            public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit [columnIndex];
                            }
                        });
                        tb_TomasRealizadas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
                        tb_TomasRealizadas.setComponentPopupMenu(jPopupMenu1);
                        tb_TomasRealizadas.setRowHeight(24);
                        tb_TomasRealizadas.setSelectionBackground(new java.awt.Color(2, 67, 115));
                        tb_TomasRealizadas.getTableHeader().setReorderingAllowed(false);
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

                        lblServicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        lblServicio.setText("servicio");

                        lblArea.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        lblArea.setText("area");

                        chPacientes.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
                        chPacientes.setText("Todos los Pacientes");
                        chPacientes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                        chPacientes.addItemListener(new java.awt.event.ItemListener() {
                            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                                chPacientesItemStateChanged(evt);
                            }
                        });

                        txtPacientes.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
                        txtPacientes.setForeground(new java.awt.Color(0, 51, 51));
                        txtPacientes.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                        txtPacientes.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                txtPacientesActionPerformed(evt);
                            }
                        });
                        txtPacientes.addKeyListener(new java.awt.event.KeyAdapter() {
                            public void keyPressed(java.awt.event.KeyEvent evt) {
                                txtPacientesKeyPressed(evt);
                            }
                            public void keyTyped(java.awt.event.KeyEvent evt) {
                                txtPacientesKeyTyped(evt);
                            }
                        });

                        btnPacientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Search-16.png"))); // NOI18N
                        btnPacientes.setBorder(null);
                        btnPacientes.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnPacientesActionPerformed(evt);
                            }
                        });

                        chAnalisis.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
                        chAnalisis.setText("Todos los Análisis");
                        chAnalisis.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                        chAnalisis.addItemListener(new java.awt.event.ItemListener() {
                            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                                chAnalisisItemStateChanged(evt);
                            }
                        });

                        txtAnalisis.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
                        txtAnalisis.setForeground(new java.awt.Color(0, 51, 51));
                        txtAnalisis.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                        txtAnalisis.addKeyListener(new java.awt.event.KeyAdapter() {
                            public void keyPressed(java.awt.event.KeyEvent evt) {
                                txtAnalisisKeyPressed(evt);
                            }
                        });

                        btnAnalisis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Search-16.png"))); // NOI18N
                        btnAnalisis.setBorder(null);
                        btnAnalisis.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnAnalisisActionPerformed(evt);
                            }
                        });

                        chPersonal.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
                        chPersonal.setText("Todo el Personal");
                        chPersonal.setHideActionText(true);
                        chPersonal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                        chPersonal.addItemListener(new java.awt.event.ItemListener() {
                            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                                chPersonalItemStateChanged(evt);
                            }
                        });

                        txtPersonal.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
                        txtPersonal.setForeground(new java.awt.Color(0, 51, 51));
                        txtPersonal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                        txtPersonal.addKeyListener(new java.awt.event.KeyAdapter() {
                            public void keyPressed(java.awt.event.KeyEvent evt) {
                                txtPersonalKeyPressed(evt);
                            }
                        });

                        btnPersonal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Search-16.png"))); // NOI18N
                        btnPersonal.setBorder(null);
                        btnPersonal.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnPersonalActionPerformed(evt);
                            }
                        });

                        btnBuscar.setFont(new java.awt.Font("Segoe UI Light", 1, 11)); // NOI18N
                        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/buscar16x16.png"))); // NOI18N
                        btnBuscar.setMnemonic('B');
                        btnBuscar.setText("Buscar");
                        btnBuscar.setToolTipText("Buscar (Alt-B)");
                        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnBuscarActionPerformed(evt);
                            }
                        });

                        chActoMedico.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
                        chActoMedico.setText("Todos los Actos Médicos");
                        chActoMedico.setHideActionText(true);
                        chActoMedico.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                        chActoMedico.addItemListener(new java.awt.event.ItemListener() {
                            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                                chActoMedicoItemStateChanged(evt);
                            }
                        });

                        txtActoM.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
                        txtActoM.setForeground(new java.awt.Color(0, 51, 51));
                        txtActoM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                        txtActoM.addKeyListener(new java.awt.event.KeyAdapter() {
                            public void keyPressed(java.awt.event.KeyEvent evt) {
                                txtActoMKeyPressed(evt);
                            }
                        });

                        javax.swing.GroupLayout panelPacientesLayout = new javax.swing.GroupLayout(panelPacientes);
                        panelPacientes.setLayout(panelPacientesLayout);
                        panelPacientesLayout.setHorizontalGroup(
                            panelPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelPacientesLayout.createSequentialGroup()
                                .addGroup(panelPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(chActoMedico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(chPersonal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(chAnalisis, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(chPacientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtAnalisis, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                    .addComponent(txtPacientes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                    .addComponent(txtPersonal, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                    .addComponent(txtActoM, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnPacientes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAnalisis, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnPersonal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscar)
                                .addGap(15, 15, 15))
                        );
                        panelPacientesLayout.setVerticalGroup(
                            panelPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelPacientesLayout.createSequentialGroup()
                                .addGroup(panelPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelPacientesLayout.createSequentialGroup()
                                        .addGroup(panelPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panelPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(txtPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(chPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(btnPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, 0)
                                        .addGroup(panelPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnAnalisis, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(panelPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(txtAnalisis, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(chAnalisis, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, 0)
                                        .addGroup(panelPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(chPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, 0)
                                        .addGroup(panelPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(chActoMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtActoM, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))
                        );

                        dateDesde.setDateFormatString("dd-MM-yyyy");
                        dateDesde.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N

                        dateHasta.setDateFormatString("dd-MM-yyyy");
                        dateHasta.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N

                        jLabel20.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
                        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        jLabel20.setText("Hasta");

                        jLabel21.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
                        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        jLabel21.setText("Búsqueda por:");

                        cbx.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
                        cbx.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar...", "N° de H.C / DNI", "Análisis ", "Personal - Resultado", "Acto Médico" }));
                        cbx.addItemListener(new java.awt.event.ItemListener() {
                            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                                cbxItemStateChanged(evt);
                            }
                        });
                        cbx.addKeyListener(new java.awt.event.KeyAdapter() {
                            public void keyPressed(java.awt.event.KeyEvent evt) {
                                cbxKeyPressed(evt);
                            }
                        });

                        jLabel19.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
                        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        jLabel19.setText("Desde");

                        lbldia.setFont(new java.awt.Font("Segoe UI Semilight", 1, 13)); // NOI18N
                        lbldia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        lbldia.setText("Resultados del Día");

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
                                .addGap(850, 850, 850)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
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

                        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                        getContentPane().setLayout(layout);
                        layout.setHorizontalGroup(
                            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dateDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dateHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(405, 405, 405))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1023, Short.MAX_VALUE)
                                    .addComponent(lbldia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(101, 101, 101)
                                        .addComponent(lblServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblArea, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cbx, 0, 173, Short.MAX_VALUE))
                                        .addGap(84, 84, 84)
                                        .addComponent(panelPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jScrollPane5))
                                .addGap(31, 31, 31))
                        );
                        layout.setVerticalGroup(
                            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(dateDesde, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                                    .addComponent(dateHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblArea)
                                        .addComponent(lblServicio))
                                    .addComponent(panelPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(lbldia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        );

                        pack();
                    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed
       buscar_histClinica();
    }//GEN-LAST:event_btnBuscar1ActionPerformed
public void buscar_histClinica(){
     if(txtbuscarHC.getText().equalsIgnoreCase("")){
           
        }else{
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
        }
}
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
public void buscar_examenes(){
    DecimalFormat df = new DecimalFormat("00");
        int dia,mes,anio,diah,mesh,anioh;
        dia = dateDesde.getCalendar().get(Calendar.DAY_OF_MONTH);
        mes = dateDesde.getCalendar().get(Calendar.MONTH) + 1;
        anio = dateDesde.getCalendar().get(Calendar.YEAR);
        diah = dateHasta.getCalendar().get(Calendar.DAY_OF_MONTH);
        mesh = dateHasta.getCalendar().get(Calendar.MONTH) + 1;
        anioh = dateHasta.getCalendar().get(Calendar.YEAR);
        lbldia.setText("Exámenes con Resultados del "+df.format(dia)+"/"+df.format(mes)+"/"+anio+" al " 
                +df.format(diah)+"/"+df.format(mesh)+"/"+anioh);
        int desde=Integer.parseInt(anio+df.format(mes)+df.format(dia));
        int hasta=Integer.parseInt(anioh+df.format(mesh)+df.format(diah));
        String buscar="",tipo="1",servicioArea="";
        
        
        if((chPacientes.isSelected()==true ||chAnalisis.isSelected()==true ||chPersonal.isSelected()==true
                ||chActoMedico.isSelected()==true ) 
                &&lblArea.getText().equalsIgnoreCase("")){
        tipo="1";
        servicioArea=lblServicio.getText();
        }
        else if(txtPacientes.getText().length()>0 &&lblArea.getText().equalsIgnoreCase("")){
        tipo="2";
         buscar=txtPacientes.getText();
        servicioArea=lblServicio.getText();
        }
        else if(txtAnalisis.getText().length()>0 &&lblArea.getText().equalsIgnoreCase("")){
        tipo="3";
         buscar=txtAnalisis.getText();
        servicioArea=lblServicio.getText();
        }
         else if(txtPersonal.getText().length()>0 &&lblArea.getText().equalsIgnoreCase("")){
        tipo="4";
         buscar=txtPersonal.getText();
        servicioArea=lblServicio.getText();
        }
         else if(txtActoM.getText().length()>0 &&lblArea.getText().equalsIgnoreCase("")){
        tipo="5";
         buscar=txtActoM.getText();
        servicioArea=lblServicio.getText();
        }
        else if((chPacientes.isSelected()==true ||chAnalisis.isSelected()==true||chPersonal.isSelected()==true
                ||chActoMedico.isSelected()==true ) 
                &&lblArea.getText().length()>0 ){
            tipo="6";
            servicioArea=lblArea.getText();        
        }
         else if(txtPacientes.getText().length()>0 &&lblArea.getText().length()>0 ){
             tipo="7";
              buscar=txtPacientes.getText();
            servicioArea=lblArea.getText();        
        }
         else if(txtAnalisis.getText().length()>0 &&lblArea.getText().length()>0 ){
             tipo="8";
              buscar=txtAnalisis.getText();
            servicioArea=lblArea.getText();        
        }
        else if(txtPersonal.getText().length()>0 &&lblArea.getText().length()>0 ){
             tipo="10";
              buscar=txtPersonal.getText();
            servicioArea=lblArea.getText();        
        }
        else if(txtActoM.getText().length()>0 &&lblArea.getText().length()>0 ){
             tipo="11";
              buscar=txtActoM.getText();
            servicioArea=lblArea.getText();        
        }
     String consulta="";
        try {
            tb_TomasRealizadas.setModel(new DefaultTableModel());
            String titulos[]={"cod_cab_resultado_mu_ana","cod_exa_ana","id_hc","Servicio/Área","Código CPT",
                "Nomenclatura" ,"Análisis Examen","N° de Resultado","Acto Médico","N° de H.C.","Datos del Paciente",
                "DNI","Fecha de Nacimiento","Edad","Sexo","Forma de Pago","N°de TM","Personal Resultado","Personal Registra Resultado",
                "Fecha Resultado","Hora Resultado","Personal Solicita","Habitacion","Cama","Fecha Orden","Hora Orden","id_cod_doc_det"};
            m=new DefaultTableModel(null,titulos);
            JTable p=new JTable(m);
//            m=(DefaultTableModel)tb_TomasRealizadas.getModel(); Cuando se va agregando
            String fila[]=new String[30];

            LAB_Analisis_Examen obj=new LAB_Analisis_Examen();
                    consulta="exec sp_LAB_BUSQUEDA_RESULTADO ?,?,?,?,?";
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
                fila[26]=r.getString(27);

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
//        char tecla= evt.getKeyChar();
//                if(tecla==KeyEvent.VK_ENTER){  
//                    try{
//                        if( tb_TomasRealizadas.getRowCount()>0){
//                        int filaselec=tb_TomasRealizadas.getSelectedRow();
//                        
//                       
//                           dispose();
//                    frm_LAB_RESULTADO_MUESTRA vr=new frm_LAB_RESULTADO_MUESTRA();
//                    vr.setVisible(true);
//                    
//                    //codigos
//                    frm_LAB_RESULTADO_MUESTRA.lblcod_cab_toma.setText(tb_TomasRealizadas.getValueAt(filaselec, 0).toString());
//                    frm_LAB_RESULTADO_MUESTRA.lblcod_det_toma.setText(tb_TomasRealizadas.getValueAt(filaselec, 1).toString());
//                    frm_LAB_RESULTADO_MUESTRA.lblcod_exa_ana.setText(tb_TomasRealizadas.getValueAt(filaselec, 2).toString());
//                    frm_LAB_RESULTADO_MUESTRA.lblid_cod_doc_det.setText(tb_TomasRealizadas.getValueAt(filaselec, 25).toString());
//                   
//                    //Datos del Paciente
//                    frm_LAB_RESULTADO_MUESTRA.lblHc.setText(tb_TomasRealizadas.getValueAt(filaselec, 3).toString());
//                    frm_LAB_RESULTADO_MUESTRA.txtHc.setText(tb_TomasRealizadas.getValueAt(filaselec, 9).toString());
//                    frm_LAB_RESULTADO_MUESTRA.txtPacientes.setText(tb_TomasRealizadas.getValueAt(filaselec, 10).toString());
//                    frm_LAB_RESULTADO_MUESTRA.txtDni.setText(tb_TomasRealizadas.getValueAt(filaselec, 11).toString());
//                    frm_LAB_RESULTADO_MUESTRA.txtFecha.setText(tb_TomasRealizadas.getValueAt(filaselec, 12).toString());
//                    frm_LAB_RESULTADO_MUESTRA.txtEdad.setText(tb_TomasRealizadas.getValueAt(filaselec, 13).toString());
//                    frm_LAB_RESULTADO_MUESTRA.txtSexo.setText(tb_TomasRealizadas.getValueAt(filaselec, 14).toString());
//                    //Toma de Muestra
//                    frm_LAB_RESULTADO_MUESTRA.txtActoMedico.setText(tb_TomasRealizadas.getValueAt(filaselec, 16).toString());
//                    frm_LAB_RESULTADO_MUESTRA.txtFormaPago.setText(tb_TomasRealizadas.getValueAt(filaselec, 15).toString());
//                    frm_LAB_RESULTADO_MUESTRA.txtNToma.setText(tb_TomasRealizadas.getValueAt(filaselec, 8).toString());
//                    frm_LAB_RESULTADO_MUESTRA.txtPersonalTomaMuestra.setText(tb_TomasRealizadas.getValueAt(filaselec, 17).toString());
//                    frm_LAB_RESULTADO_MUESTRA.txtFechaTM.setText(tb_TomasRealizadas.getValueAt(filaselec, 18).toString());
//                    frm_LAB_RESULTADO_MUESTRA.txtHoraTM.setText(tb_TomasRealizadas.getValueAt(filaselec, 19).toString());
//                    if(tb_TomasRealizadas.getValueAt(filaselec,20).toString().isEmpty()){
//                    frm_LAB_RESULTADO_MUESTRA.txtPersonalSolicita.setText("--");
//                    }else{
//                    frm_LAB_RESULTADO_MUESTRA.txtPersonalSolicita.setText(tb_TomasRealizadas.getValueAt(filaselec, 20).toString());
//                        
//                    }
//                    if(tb_TomasRealizadas.getValueAt(filaselec,21).toString().isEmpty()){
//                    frm_LAB_RESULTADO_MUESTRA.txtPiso.setText("--");
//                    frm_LAB_RESULTADO_MUESTRA.txtCama.setText("--");
//                    }else{
//                       frm_LAB_RESULTADO_MUESTRA.txtPiso.setText(tb_TomasRealizadas.getValueAt(filaselec, 21).toString());
//                    frm_LAB_RESULTADO_MUESTRA.txtCama.setText(tb_TomasRealizadas.getValueAt(filaselec, 22).toString()); 
//                    }
//                    
//                    frm_LAB_RESULTADO_MUESTRA.txtFechaOrden.setText(tb_TomasRealizadas.getValueAt(filaselec, 23).toString());
//                    frm_LAB_RESULTADO_MUESTRA.txtHoraOrden.setText(tb_TomasRealizadas.getValueAt(filaselec, 24).toString());
//                    
//                    //Servicio
//                    frm_LAB_RESULTADO_MUESTRA.txtServArea.setText(tb_TomasRealizadas.getValueAt(filaselec, 4).toString());
//                    frm_LAB_RESULTADO_MUESTRA.txtCPT.setText(tb_TomasRealizadas.getValueAt(filaselec, 5).toString());
//                    frm_LAB_RESULTADO_MUESTRA.txtNomenclatura.setText(tb_TomasRealizadas.getValueAt(filaselec, 7).toString());
//                    
//                    
//                    frm_LAB_RESULTADO_MUESTRA.lblServicio.setText(lblServicio.getText());
//                    frm_LAB_RESULTADO_MUESTRA.lblArea.setText(lblArea.getText());
//                    
//                    LAB_Esquema_cargar(tb_TomasRealizadas.getValueAt(filaselec, 2).toString());
//                    LAB_ValoresRef_cargar(tb_TomasRealizadas.getValueAt(filaselec, 2).toString());
//                    
//                    //como parametro sexo-años-meses-dias del paciente
//                    LAB_Validar_Valores(tb_TomasRealizadas.getValueAt(filaselec, 14).toString(),
//                            Integer.parseInt(tb_TomasRealizadas.getValueAt(filaselec, 26).toString()),
//                            Integer.parseInt(tb_TomasRealizadas.getValueAt(filaselec, 27).toString()),
//                            Integer.parseInt(tb_TomasRealizadas.getValueAt(filaselec, 28).toString()));
//                    String u=lblUsu.getText();
//                             frm_LAB_RESULTADO_MUESTRA.lblUsu.setText(u);
//                       }        
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(this, "ingreso "+e.getMessage());
//        }
//        }
    }//GEN-LAST:event_tb_TomasRealizadasKeyPressed

    
    public  void LAB_Esquema_cargar(String cod_exa_ana){
         try {
             String titulos[]={"Código","Nombre Esquema","Resultado","Tipo","CodUniMedida","UM","Área"};
            m=new DefaultTableModel(null,titulos);
            JTable p=new JTable(m);
            String fila[]=new String[8];
            LAB_Resultado_Muestra_Cabecera obj=new LAB_Resultado_Muestra_Cabecera();
            
        String consulta="exec sp_LAB_RESULTADO_ESQUEMA_VALORES ?,?";
       PreparedStatement cmd = obj.getCn().prepareStatement(consulta);
           cmd.setString(1, cod_exa_ana);
            cmd.setString(2, "1");
        ResultSet r=cmd.executeQuery();
        int c=1;
        while(r.next()){
            fila[0]=r.getString(1);
            fila[1]=r.getString(2);
            fila[2]=r.getString(3);
            fila[3]=r.getString(4);
            fila[4]=r.getString(5);
            fila[5]=r.getString(6);
            fila[6]=r.getString(7);
                m.addRow(fila);
                c++;
            }
            frm_LAB_RESULTADO_MUESTRA.tb_Esquema.setModel(m);
            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m);
            frm_LAB_RESULTADO_MUESTRA.tb_Esquema.setRowSorter(elQueOrdena);
            
    } catch (Exception e) {
        JOptionPane.showMessageDialog(rootPane, e.getMessage());
    }
    }
    
    public void LAB_ValoresRef_cargar(String cod_exa_ana){
         try {
             String titulos[]={"Código","Cod Esquema","Nombre Esquema",
                 "estado_todos_fabricantes","cod_fabricante_producto_mh","ini_anio","ini_mes",
"ini_dia","fin_anio","fin_mes","fin_dia","genero","estado_clinico_ref",
"valor_minimo","valor_maximo","valor_texto_referencia","tipo_valor_referencia","ini_dias","fin_dias"};
            m=new DefaultTableModel(null,titulos);
            JTable p=new JTable(m);
            String fila[]=new String[19];
            LAB_Resultado_Muestra_Cabecera obj=new LAB_Resultado_Muestra_Cabecera();
            
        String consulta="exec sp_LAB_RESULTADO_ESQUEMA_VALORES ?,?";
       PreparedStatement cmd = obj.getCn().prepareStatement(consulta);
           cmd.setString(1, cod_exa_ana);
            cmd.setString(2, "2");
        ResultSet r=cmd.executeQuery();
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
            
                m.addRow(fila);
                c++;
            }
            frm_LAB_RESULTADO_MUESTRA.tb_Valores.setModel(m);
            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m);
            frm_LAB_RESULTADO_MUESTRA.tb_Valores.setRowSorter(elQueOrdena);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(rootPane, e.getMessage());
    }
    }
    public void LAB_Validar_Valores(String sexo,int anio,int meses,int dias){
        
         try {
             int filtro=0,valores=0;
             
            for(int i=0;i<frm_LAB_RESULTADO_MUESTRA.tb_Esquema.getRowCount();i++){
                String cod_esquema="",nombre_resultado_exa="",tipo_esquema_sub_ana=""
                        ,cod_uni_med_exa="",cod_valores_refe_resul="",
                        valor_de_resultado_analisis="",unidad_med="",estado_todos_fabricante="",cod_fabricante_producto=""
                        ,ini_anio_resul="",ini_mes_resul="",ini_dia_resul="",fin_anio_resul="",fin_mes_resul=""
                        ,fin_dia_resul="",genero="",
                        valor_minimo_resul="",valor_maximo_resul="",valor_texto_referencia_resul="",
                        tipo_valor_refencia_resul="", observaciones_resultado_exa=""
                        ,usa_valores_ref="";
                
                cod_esquema=frm_LAB_RESULTADO_MUESTRA.tb_Esquema.getValueAt(i, 0).toString();
                nombre_resultado_exa=frm_LAB_RESULTADO_MUESTRA.tb_Esquema.getValueAt(i, 1).toString();
                tipo_esquema_sub_ana=frm_LAB_RESULTADO_MUESTRA.tb_Esquema.getValueAt(i, 3).toString();
                cod_uni_med_exa=frm_LAB_RESULTADO_MUESTRA.tb_Esquema.getValueAt(i, 4).toString();
                unidad_med=frm_LAB_RESULTADO_MUESTRA.tb_Esquema.getValueAt(i, 5).toString();
                
                for(int va=0;va<frm_LAB_RESULTADO_MUESTRA.tb_Valores.getRowCount();va++){
                filtro = 0;
                
                if (frm_LAB_RESULTADO_MUESTRA.tb_Esquema.getValueAt(i,0).toString().
                    equalsIgnoreCase(frm_LAB_RESULTADO_MUESTRA.tb_Valores.getValueAt(va, 1).toString())){
                    //Verificando el Sexo
                    if(sexo.equalsIgnoreCase(frm_LAB_RESULTADO_MUESTRA.tb_Valores.getValueAt(va, 11).toString())){
                        filtro = filtro + 1;
                    }
                    //Verifica los Fabricantes
                    if(frm_LAB_RESULTADO_MUESTRA.tb_Valores.getValueAt(va, 3).toString().
                    equalsIgnoreCase("S")){
                       filtro = filtro + 1; 
                    }
                    if(frm_LAB_RESULTADO_MUESTRA.tb_Valores.getValueAt(va, 3).toString().
                    equalsIgnoreCase("N")){
                    }
                    
                    String tipo="";
                    int ini_dias=0,fin_dias=0;
//                    int edadD_ini=0,edadD_fin=0,edadM_ini=0,edadM_fin=0,edadA_ini=0,edadA_fin=0;
                    String e=frm_LAB_RESULTADO_MUESTRA.txtEdad.getText();
                    int leng=e.length();
                    
                    tipo=String.valueOf(e.charAt(leng-1));

                    if(sexo.equalsIgnoreCase(frm_LAB_RESULTADO_MUESTRA.tb_Valores.getValueAt(va, 11).toString())){
//                        edadA_ini=Integer.parseInt(frm_LAB_RESULTADO_MUESTRA.tb_Valores.getValueAt(va, 5).toString());
//                        edadA_fin=Integer.parseInt(frm_LAB_RESULTADO_MUESTRA.tb_Valores.getValueAt(va, 8).toString());
//                        edadM_ini=Integer.parseInt(frm_LAB_RESULTADO_MUESTRA.tb_Valores.getValueAt(va, 6).toString());
//                        edadM_fin=Integer.parseInt(frm_LAB_RESULTADO_MUESTRA.tb_Valores.getValueAt(va, 9).toString());
//                        edadD_ini=Integer.parseInt(frm_LAB_RESULTADO_MUESTRA.tb_Valores.getValueAt(va, 7).toString());
//                        edadD_fin=Integer.parseInt(frm_LAB_RESULTADO_MUESTRA.tb_Valores.getValueAt(va, 10).toString());
//                        
                        ini_dias=Integer.parseInt(frm_LAB_RESULTADO_MUESTRA.tb_Valores.getValueAt(va, 17).toString());
                        fin_dias=Integer.parseInt(frm_LAB_RESULTADO_MUESTRA.tb_Valores.getValueAt(va, 18).toString());
                        
                    if(dias>=ini_dias &&dias<=fin_dias ){
                        filtro = filtro + 1; 
                    }
//                    else if(tipo.equalsIgnoreCase("D")){
//                        
//                        if(edad>=edadD_ini &&edad<=edadD_fin && anio>=edadA_ini &&anio<=edadA_fin && 0>=edadM_ini &&0<=edadM_fin){
//                        filtro = filtro + 1; 
//                        }
                    }else{
//                       
//                        if(anio>edadA_ini &&anio<edadA_fin){
//                        filtro = filtro + 1; 
//                        }else if( (anio==edadA_ini ||anio==edadA_fin)&& meses>edadM_ini &meses<edadM_fin){
//                            filtro = filtro + 1; 
//                        }
                    }
                    }
                    if(filtro==3){
                    valores=va;
                    va=frm_LAB_RESULTADO_MUESTRA.tb_Valores.getRowCount();
                    }
                }
                
                if(filtro==3){
//                    "Código","Cod Esquema","Nombre Esquema",
//                 "estado_todos_fabricantes","cod_fabricante_producto_mh","ini_anio","ini_mes",
//"ini_dia","fin_anio","fin_mes","fin_dia","genero","estado_clinico_ref",
//"valor_minimo","valor_maximo","valor_texto_referencia","tipo_valor_referencia"
                  cod_valores_refe_resul=frm_LAB_RESULTADO_MUESTRA.tb_Valores.getValueAt(valores, 0).toString();   
                valor_de_resultado_analisis="";
                estado_todos_fabricante=frm_LAB_RESULTADO_MUESTRA.tb_Valores.getValueAt(valores, 3).toString();  
                cod_fabricante_producto=frm_LAB_RESULTADO_MUESTRA.tb_Valores.getValueAt(valores, 4).toString();  
                ini_anio_resul=frm_LAB_RESULTADO_MUESTRA.tb_Valores.getValueAt(valores, 5).toString();  
                ini_mes_resul=frm_LAB_RESULTADO_MUESTRA.tb_Valores.getValueAt(valores, 6).toString();  
                ini_dia_resul=frm_LAB_RESULTADO_MUESTRA.tb_Valores.getValueAt(valores, 7).toString();  
                fin_anio_resul=frm_LAB_RESULTADO_MUESTRA.tb_Valores.getValueAt(valores, 8).toString();  
                fin_mes_resul=frm_LAB_RESULTADO_MUESTRA.tb_Valores.getValueAt(valores, 9).toString();  
                fin_dia_resul=frm_LAB_RESULTADO_MUESTRA.tb_Valores.getValueAt(valores, 10).toString();  
                genero=frm_LAB_RESULTADO_MUESTRA.tb_Valores.getValueAt(valores, 11).toString();  
//                sexo_femenino_resul="";
                if(frm_LAB_RESULTADO_MUESTRA.tb_Valores.getValueAt(valores, 15).toString().equalsIgnoreCase("")){
                valor_minimo_resul=frm_LAB_RESULTADO_MUESTRA.tb_Valores.getValueAt(valores, 13).toString();  
                valor_maximo_resul=frm_LAB_RESULTADO_MUESTRA.tb_Valores.getValueAt(valores, 14).toString();  
                valor_texto_referencia_resul="--";
                }else{
                 valor_minimo_resul="--";
                valor_maximo_resul="--";
                valor_texto_referencia_resul=frm_LAB_RESULTADO_MUESTRA.tb_Valores.getValueAt(valores, 15).toString();
                }
                tipo_valor_refencia_resul=frm_LAB_RESULTADO_MUESTRA.tb_Valores.getValueAt(valores, 16).toString();  
                observaciones_resultado_exa="";
            
                usa_valores_ref="S";
                
                resultado=(DefaultTableModel)frm_LAB_RESULTADO_MUESTRA.tb_Detalle.getModel();
                String filaelemento[]={cod_esquema,nombre_resultado_exa,tipo_esquema_sub_ana
                        ,cod_uni_med_exa,cod_valores_refe_resul,
                        valor_de_resultado_analisis,unidad_med,estado_todos_fabricante,cod_fabricante_producto
                        ,ini_anio_resul,ini_mes_resul,ini_dia_resul,fin_anio_resul,
                        fin_mes_resul,fin_dia_resul,genero,
                        valor_minimo_resul,valor_maximo_resul,valor_texto_referencia_resul,
                        tipo_valor_refencia_resul, observaciones_resultado_exa
                        ,usa_valores_ref};
                resultado.addRow(filaelemento);     
                }
                else{
                cod_valores_refe_resul="";
                
                valor_de_resultado_analisis="";
                estado_todos_fabricante="";
            cod_fabricante_producto="";
            ini_anio_resul="";
            ini_mes_resul="";
            ini_dia_resul="";
            fin_anio_resul="";
            fin_mes_resul="";
            fin_dia_resul="";
            genero="";
            valor_minimo_resul="--";
            valor_maximo_resul="--";
            valor_texto_referencia_resul="--";
            tipo_valor_refencia_resul="";
            observaciones_resultado_exa="";
            
            usa_valores_ref="N";
                
              resultado=(DefaultTableModel)frm_LAB_RESULTADO_MUESTRA.tb_Detalle.getModel();
              String filaelemento[]={cod_esquema,nombre_resultado_exa,tipo_esquema_sub_ana
                        ,cod_uni_med_exa,cod_valores_refe_resul,
                        valor_de_resultado_analisis,unidad_med,estado_todos_fabricante,cod_fabricante_producto
                        ,ini_anio_resul,ini_mes_resul,ini_dia_resul,fin_anio_resul,fin_mes_resul
                        ,fin_dia_resul,genero,valor_minimo_resul,valor_maximo_resul
                        ,valor_texto_referencia_resul,tipo_valor_refencia_resul
                        ,observaciones_resultado_exa,usa_valores_ref};
               resultado.addRow(filaelemento);   
          }}
    } catch (Exception e) {
        JOptionPane.showMessageDialog(rootPane, e.getMessage());
    }
    }
                
    private void cbxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxItemStateChanged
           if(cbx.getSelectedIndex()==0){
            chPacientes.setSelected(false);
            chAnalisis.setSelected(false);
            chPersonal.setSelected(false);
            chPacientes.setVisible(false);
            txtPacientes.setVisible(false);
            btnPacientes.setVisible(false);
            chAnalisis.setVisible(false);
            txtAnalisis.setVisible(false);
            btnAnalisis.setVisible(false);
            chPersonal.setVisible(false);
            txtPersonal.setVisible(false);
            btnPersonal.setVisible(false);
            chActoMedico.setVisible(false);
            txtActoM.setVisible(false);
            txtPacientes.setText("");
            txtAnalisis.setText("");
            txtPersonal.setText("");
            btnBuscar.setVisible(false);
        }
        else if(cbx.getSelectedIndex()==1){
            chPacientes.setSelected(true);
            chAnalisis.setSelected(false);
            chPersonal.setSelected(false);
            chActoMedico.setSelected(false);
            chPacientes.setVisible(true);
            txtPacientes.setVisible(true);
            btnPacientes.setVisible(true);
            chAnalisis.setVisible(false);
            txtAnalisis.setVisible(false);
            btnAnalisis.setVisible(false);
            chPersonal.setVisible(false);
            txtPersonal.setVisible(false);
            btnPersonal.setVisible(false);
            chActoMedico.setVisible(false);
            txtActoM.setVisible(false);
            txtPacientes.setText("");
            txtAnalisis.setText("");
            txtPersonal.setText("");
            txtActoM.setText("");
            btnBuscar.setVisible(true);
        }else if(cbx.getSelectedIndex()==2){
            chPacientes.setSelected(false);
            chAnalisis.setSelected(true);
            chPersonal.setSelected(false);
            chActoMedico.setSelected(false);
            chPacientes.setVisible(false);
            txtPacientes.setVisible(false);
            btnPacientes.setVisible(false);
            chAnalisis.setVisible(true);
            txtAnalisis.setVisible(true);
            btnAnalisis.setVisible(true);
            chPersonal.setVisible(false);
            txtPersonal.setVisible(false);
            btnPersonal.setVisible(false);
            chActoMedico.setVisible(false);
            txtActoM.setVisible(false);
            txtPacientes.setText("");
            txtAnalisis.setText("");
            txtPersonal.setText("");
            txtActoM.setText("");
            btnBuscar.setVisible(true);
        }else if(cbx.getSelectedIndex()==3){
            chPacientes.setSelected(false);
            chAnalisis.setSelected(false);
            chPersonal.setSelected(true);
            chActoMedico.setSelected(false);
            chPacientes.setVisible(false);
            txtPacientes.setVisible(false);
            btnPacientes.setVisible(false);
            chAnalisis.setVisible(false);
            txtAnalisis.setVisible(false);
            btnAnalisis.setVisible(false);
            chPersonal.setVisible(true);
            txtPersonal.setVisible(true);
            btnPersonal.setVisible(true);
            chActoMedico.setVisible(false);
            txtActoM.setVisible(false);
            txtPacientes.setText("");
            txtAnalisis.setText("");
            txtPersonal.setText("");
            txtActoM.setText("");
            btnBuscar.setVisible(true);
        }else if(cbx.getSelectedIndex()==4){
            chPacientes.setSelected(false);
            chAnalisis.setSelected(false);
            chPersonal.setSelected(false);
            chActoMedico.setSelected(true);
            
            chPacientes.setVisible(false);
            txtPacientes.setVisible(false);
            btnPacientes.setVisible(false);
            chAnalisis.setVisible(false);
            txtAnalisis.setVisible(false);
            btnAnalisis.setVisible(false);
            chPersonal.setVisible(false);
            txtPersonal.setVisible(false);
            btnPersonal.setVisible(false);
            chActoMedico.setVisible(true);
            txtActoM.setVisible(true);
            txtPacientes.setText("");
            txtAnalisis.setText("");
            txtPersonal.setText("");
            txtActoM.setText("");
            btnBuscar.setVisible(true);
        }
                                       
    }//GEN-LAST:event_cbxItemStateChanged

    private void cbxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxKeyPressed

    private void txtBuscarPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarPersonalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarPersonalActionPerformed

    private void txtBuscarPersonalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarPersonalKeyPressed
        char tecla= evt.getKeyChar();
        if(tecla==KeyEvent.VK_ENTER){
            btnBuscarPersonal.doClick();
        }
    }//GEN-LAST:event_txtBuscarPersonalKeyPressed

    private void txtBuscarPersonalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarPersonalKeyTyped

    }//GEN-LAST:event_txtBuscarPersonalKeyTyped

    private void btnBuscarPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPersonalActionPerformed
        // TODO add your handling code here:

        try {
            String tipo="",buscar="";
            

            if(cbxBuscarPersonal.getSelectedIndex()==1){
                tipo="5";
            }else if(cbxBuscarPersonal.getSelectedIndex()==2){
                tipo="6";
            }
            buscar=txtBuscarPersonal.getText();
            String titulos[]={"N°","Código","Apellido Paterno","Apellido Materno","Nombres","Cargo","Servicio","Área"};
            m=new DefaultTableModel(null,titulos);
            JTable p=new JTable(m);
            String fila[]=new String[8];
            LAB_Resultado_Muestra_Cabecera obj=new LAB_Resultado_Muestra_Cabecera ();

            String consulta="exec sp_LAB_PERSONAL ?,?,?";
            PreparedStatement cmd = obj.getCn().prepareStatement(consulta);
            cmd.setString(1, buscar);
            cmd.setString(2, lblServicio.getText());
            cmd.setString(3, tipo);
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
            tbPersonal.setModel(m);
            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m);
            tbPersonal.setRowSorter(elQueOrdena);
            this.tbPersonal.setModel(m);
            Personal_formato();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }//GEN-LAST:event_btnBuscarPersonalActionPerformed

    private void tbPersonalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPersonalMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbPersonalMouseClicked

    private void tbPersonalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbPersonalKeyPressed
        // TODO add your handling code here:
        char tecla= evt.getKeyChar();
        if(tecla==KeyEvent.VK_ENTER){
            try{

                personal.setVisible(false);
                int filaselec=tbPersonal.getSelectedRow();
                String nombreCompleto=tbPersonal.getValueAt(filaselec, 2).toString()+" "+
                tbPersonal.getValueAt(filaselec, 3).toString()
                +" "+tbPersonal.getValueAt(filaselec, 4).toString();
                txtPersonal.setText(nombreCompleto);
                

            }catch(Exception ex)
            {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_tbPersonalKeyPressed

    private void tbPersonalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbPersonalKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tbPersonalKeyTyped

    private void cbxBuscarPersonalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxBuscarPersonalItemStateChanged
        // TODO add your handling code here:
        try
        {
            if(evt.getStateChange()==ItemEvent.SELECTED){
                if(cbxBuscarPersonal.getSelectedIndex()>0){
                    txtBuscarPersonal.setEnabled(true);
                    btnBuscarPersonal.setEnabled(true);
                }
            }
            else{
                txtBuscarPersonal.setEnabled(false);
                btnBuscarPersonal.setEnabled(false);
            }}
            catch(Exception ex)
            {
                System.out.println("Error: " + ex.getMessage());
            }
    }//GEN-LAST:event_cbxBuscarPersonalItemStateChanged

    private void tb_AnalisisKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_AnalisisKeyPressed
      char tecla= evt.getKeyChar();
        if(tecla==KeyEvent.VK_ENTER){
            try{

                analisis.setVisible(false);
                int filaselec=tb_Analisis.getSelectedRow();
                txtAnalisis.setText(tb_Analisis.getValueAt(filaselec, 3).toString());
                

            }catch(Exception ex)
            {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_tb_AnalisisKeyPressed

    private void cbxBuscarAnalisisItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxBuscarAnalisisItemStateChanged
        try
        {
            if(evt.getStateChange()==ItemEvent.SELECTED){
                if(cbxBuscarAnalisis.getSelectedIndex()>0){
                    txtBuscarAnalisis.setEnabled(true);
                    btnBuscarAnalisis.setEnabled(true);
                }
            }
            else{
                txtBuscarAnalisis.setEnabled(false);
                btnBuscarAnalisis.setEnabled(false);
            }}
            catch(Exception ex)
            {
                System.out.println("Error: " + ex.getMessage());
            }
    }//GEN-LAST:event_cbxBuscarAnalisisItemStateChanged

    private void txtBuscarAnalisisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarAnalisisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarAnalisisActionPerformed

    private void txtBuscarAnalisisKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarAnalisisKeyPressed
          char tecla= evt.getKeyChar();
        if(tecla==KeyEvent.VK_ENTER){
            btnBuscarAnalisis.doClick();
        }
    }//GEN-LAST:event_txtBuscarAnalisisKeyPressed

    private void txtBuscarAnalisisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarAnalisisKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarAnalisisKeyTyped

    private void btnBuscarAnalisisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarAnalisisActionPerformed
        try {
            String tipo="",buscar="",servArea="";
            

            if(cbxBuscarAnalisis.getSelectedIndex()==1 && lblArea.getText().isEmpty()){
                tipo="2";
                servArea=lblServicio.getText();
            }else if(cbxBuscarAnalisis.getSelectedIndex()==2 && lblArea.getText().isEmpty()){
                tipo="3";
                servArea=lblServicio.getText();
            }else if(cbxBuscarAnalisis.getSelectedIndex()==1 && lblArea.getText().length()>0){
                tipo="5";
                servArea=lblArea.getText();
            }else if(cbxBuscarAnalisis.getSelectedIndex()==2 && lblArea.getText().length()>0){
                tipo="6";
                servArea=lblArea.getText();
            }
            buscar=txtBuscarAnalisis.getText();
            String titulos[]={"N°","Código","Código CPT","Análisis","Servicio","Área"};
            m=new DefaultTableModel(null,titulos);
            JTable p=new JTable(m);
            String fila[]=new String[8];
            LAB_Resultado_Muestra_Cabecera obj=new LAB_Resultado_Muestra_Cabecera ();

            String consulta="exec sp_LAB_RESULTADO_TM_ANALISIS ?,?,?";
            PreparedStatement cmd = obj.getCn().prepareStatement(consulta);
            cmd.setString(1, buscar);
            cmd.setString(2, servArea);
            cmd.setString(3, tipo);
            ResultSet r=cmd.executeQuery();
            int c=1;
            while(r.next()){
                fila[0]=String.valueOf(c)+"º";
                fila[1]=r.getString(1);
                fila[2]=r.getString(2);
                fila[3]=r.getString(3);
                fila[4]=r.getString(4);
                fila[5]=r.getString(5);
                m.addRow(fila);
                c++;
            }
            tb_Analisis.setModel(m);
            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m);
            tb_Analisis.setRowSorter(elQueOrdena);
            this.tb_Analisis.setModel(m);
            Analisis_formato();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }//GEN-LAST:event_btnBuscarAnalisisActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try{

            if(dateDesde.getDate()==null || dateHasta.getDate()==null){
                JOptionPane.showMessageDialog(rootPane, "Seleccione un rango de Fechas.");
            } else if(cbx.getSelectedIndex()==0){
                JOptionPane.showMessageDialog(rootPane, "Seleccione un tipo de búsqueda");
            }  else if(txtPacientes.getText().isEmpty()&&chPacientes.isSelected()==false&& txtAnalisis.getText().isEmpty()
                  && chAnalisis.isSelected()==false && txtPersonal.getText().isEmpty()&&chPersonal.isSelected()==false
                  &&txtActoM.getText().isEmpty()&&chActoMedico.isSelected()==false){
                JOptionPane.showMessageDialog(rootPane, "Seleccione y/o ingrese un " +cbx.getSelectedItem());
            }  else {
                buscar_examenes();

            }
        }catch(Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());

        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPersonalActionPerformed

        personal.setVisible(true);
        txtBuscarPersonal.setText("");
        Personal_cargar();
        Personal_formato();

    }//GEN-LAST:event_btnPersonalActionPerformed

    private void txtPersonalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPersonalKeyPressed
        char tecla= evt.getKeyChar();
        if(tecla==KeyEvent.VK_ENTER){
            btnPersonal.doClick();
        }
    }//GEN-LAST:event_txtPersonalKeyPressed

    private void chPersonalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chPersonalItemStateChanged
        if(chPersonal.isSelected()){
            txtPersonal.setEnabled(false);
            btnPersonal.setEnabled(false);
            txtPersonal.setText("");
        }else{
            txtPersonal.setEnabled(true);
            btnPersonal.setEnabled(true);
        }
    }//GEN-LAST:event_chPersonalItemStateChanged

    private void btnAnalisisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalisisActionPerformed
        analisis.setVisible(true);
        txtBuscarAnalisis.setText("");
        Analisis_cargar();
        Analisis_formato();

    }//GEN-LAST:event_btnAnalisisActionPerformed

    private void txtAnalisisKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnalisisKeyPressed
        char tecla= evt.getKeyChar();
        if(tecla==KeyEvent.VK_ENTER){
            btnAnalisis.doClick();
        }
    }//GEN-LAST:event_txtAnalisisKeyPressed

    private void chAnalisisItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chAnalisisItemStateChanged
        if(chAnalisis.isSelected()){
            txtAnalisis.setEnabled(false);
            btnAnalisis.setEnabled(false);
            txtAnalisis.setText("");
        }else{
            txtAnalisis.setEnabled(true);
            btnAnalisis.setEnabled(true);
        }
    }//GEN-LAST:event_chAnalisisItemStateChanged

    private void btnPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPacientesActionPerformed
        buscar_HC.setVisible(true);
        txtbuscarHC.setText("");
        LAB_HC_cargar();
        LAB_HC_formato();
    }//GEN-LAST:event_btnPacientesActionPerformed

    private void txtPacientesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPacientesKeyPressed
        char tecla= evt.getKeyChar();
        if(tecla==KeyEvent.VK_ENTER){
            btnPacientes.doClick();
        }
    }//GEN-LAST:event_txtPacientesKeyPressed

    private void txtPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPacientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPacientesActionPerformed

    private void chPacientesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chPacientesItemStateChanged
        if(chPacientes.isSelected()){
            txtPacientes.setEnabled(false);
            btnPacientes.setEnabled(false);
            txtPacientes.setText("");
            txtAnalisis.setText("");
        }else{
            txtPacientes.setEnabled(true);
            btnPacientes.setEnabled(true);
            txtPacientes.setText("");
            txtAnalisis.setText("");
        }
    }//GEN-LAST:event_chPacientesItemStateChanged

    private void chActoMedicoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chActoMedicoItemStateChanged
        if(chActoMedico.isSelected()){
            txtActoM.setEnabled(false);
            txtActoM.setText("");
        }else{
            txtActoM.setEnabled(true);
        }
    }//GEN-LAST:event_chActoMedicoItemStateChanged

    private void txtActoMKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtActoMKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtActoMKeyPressed

    private void VER_RESULTADOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VER_RESULTADOActionPerformed
         try {
           int filaselec=tb_TomasRealizadas.getSelectedRow();
           if(filaselec<0){
               JOptionPane.showMessageDialog(rootPane, "Seleccione un Registro");
           }else{
             String cod=tb_TomasRealizadas.getValueAt(filaselec, 26).toString();
         
            Map parametros=new HashMap();
            parametros.put("ID_COD_DET",cod);
            
                JasperPrint informe=JasperFillManager.fillReport(getClass().
                    getResourceAsStream("/Reportes/LAB/RESULTADOS.jasper"), parametros,c.conectar());

                JasperViewer ventana= new JasperViewer(informe,false);
                ventana.setTitle("RESULTADO - "+tb_TomasRealizadas.getValueAt(filaselec, 10).toString());
                ventana.setVisible(true);
           }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al Cargar el reporte"+e.getMessage());
            }
    }//GEN-LAST:event_VER_RESULTADOActionPerformed

    private void EXPORTAR_PDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EXPORTAR_PDFActionPerformed
         try {
               int filaselec=tb_TomasRealizadas.getSelectedRow();
           if(filaselec<0){
               JOptionPane.showMessageDialog(rootPane, "Seleccione un Registro");
           }else{
//        Reportes re = new Reportes();
        String ruta = "/Reportes/LAB/RESULTADOS.jasper";
        
            String cod=tb_TomasRealizadas.getValueAt(filaselec, 26).toString();
            Map parametros=new HashMap();
            parametros.put("ID_COD_DET",cod);
            
            
        //ABRIR CUADRO DE DIALOGO PARA GUARDAR EL ARCHIVO         
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("todos los archivos *.PDF", "pdf", "PDF"));//filtro para ver solo archivos .pdf
        int seleccion = fileChooser.showSaveDialog(null);
      
            if (seleccion == JFileChooser.APPROVE_OPTION) {//comprueba si ha presionado el boton de aceptar
                File JFC = fileChooser.getSelectedFile();
                String PATH = JFC.getAbsolutePath();//obtenemos la direccion del archivo + el nombre a guardar
                try (PrintWriter printwriter = new PrintWriter(JFC)) {
                    
                    printwriter.print(ruta);
                }
               JasperPrint informe = JasperFillManager.fillReport(getClass().getResourceAsStream(ruta), parametros, c.conectar());
            JasperExportManager.exportReportToPdfFile(informe, PATH);//mandamos como parametros la ruta del archivo a compilar y el nombre y ruta donde se guardaran    
                //comprobamos si a la hora de guardar obtuvo la extension y si no se la asignamos
                if (!(PATH.endsWith(".pdf"))) {
                    File temp = new File(PATH + ".pdf");
                    JFC.renameTo(temp);//renombramos el archivo
                }
               JOptionPane.showMessageDialog(null, "Documento Exportado Exitosamente!", "Guardado exitoso!", JOptionPane.INFORMATION_MESSAGE);
            }
        } }catch (FileNotFoundException | HeadlessException e) {//por alguna excepcion salta un mensaje de error
            JOptionPane.showMessageDialog(null, "Error al Exportar el archivo!"+e.getMessage(), "Oops! Error", JOptionPane.ERROR_MESSAGE);
        } catch (JRException ex) {
         Logger.getLogger(frm_LAB_BUSCAR_RESULTADO.class.getName()).log(Level.SEVERE, null, ex);
     }
    }//GEN-LAST:event_EXPORTAR_PDFActionPerformed

    private void txtPacientesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPacientesKeyTyped
         char tecla;
        tecla = evt.getKeyChar();
        if(!Character.isDigit(tecla)&&tecla !=KeyEvent.VK_SPACE&&tecla!=KeyEvent.VK_BACK_SPACE &&tecla !='-'){
            evt.consume();
            getToolkit().beep();            
        }
        if (txtPacientes.getText().length()>7){
            evt.consume();
        }
        if(tecla =='-' && txtPacientes.getText().contains("-")){
            evt.consume();            
        }
    }//GEN-LAST:event_txtPacientesKeyTyped
    
    public void exportar_pdf_automaticamente(){
         //NUMERO DE DIAS
            int sDias=0;
            Calendar fecha = new GregorianCalendar();
            int dia=fecha.get(Calendar.DAY_OF_MONTH);
            int mes=fecha.get(Calendar.MONTH)+1;
            int anio=fecha.get(Calendar.YEAR);
           
            if(mes>1){
            for(int i=1;i<mes;i++)    {
            switch (i){
                case 1:case 3:case 5:case 7:case 8:case 10:case 12: 
                sDias = sDias+ 31;
                break;
                case 2:	
                    if(anio %4==0){
                        sDias = sDias+ 29;
                    }else{
                        sDias = sDias+ 28;
                    }
                break;			
                case 4:case 6:case 9:case 11:			
                sDias = sDias+ 30;
                break;
                default:
                sDias = 0;
            }}}
            int ndias=sDias+dia;
            DecimalFormat df = new DecimalFormat("000");
            
        try {
               int filaselec=tb_TomasRealizadas.getSelectedRow();
           if(filaselec<0){
               JOptionPane.showMessageDialog(rootPane, "Seleccione un Registro");
           }else{
               
        //para crear directorio
        File directorio =new File("D:\\LABORATORIO-RESULTADOS\\");
        directorio.mkdir();
       
         //para crear archivo
//         File archivo =new File(directorio,"archivo8.txt");
//         archivo.createNewFile();
         
         
//        Reportes re = new Reportes();
        String ruta = "/Reportes/LAB/RESULTADOS.jasper";
        
            String cod=tb_TomasRealizadas.getValueAt(filaselec, 26).toString();
            Map parametros=new HashMap();
            parametros.put("ID_COD_DET",cod);
            
            
        //ABRIR CUADRO DE DIALOGO PARA GUARDAR EL ARCHIVO         
        //dni + numero de dias + cod resultado 
           File JFC =new File("D:\\LABORATORIO-RESULTADOS\\"+tb_TomasRealizadas.getValueAt(filaselec, 11).toString()+
                   df.format(ndias)+
                   tb_TomasRealizadas.getValueAt(filaselec, 0).toString());
                String PATH = JFC.getAbsolutePath();//obtenemos la direccion del archivo + el nombre a guardar
                try (PrintWriter printwriter = new PrintWriter(JFC)) {
                    
                    printwriter.print(ruta);
                }
               JasperPrint informe = JasperFillManager.fillReport(getClass().getResourceAsStream(ruta), parametros, c.conectar());
            JasperExportManager.exportReportToPdfFile(informe, PATH);//mandamos como parametros la ruta del archivo a compilar y el nombre y ruta donde se guardaran    
                //comprobamos si a la hora de guardar obtuvo la extension y si no se la asignamos
                if (!(PATH.endsWith(".pdf"))) {
                    File temp = new File(PATH + ".pdf");
                    JFC.renameTo(temp);//renombramos el archivo
                }
               JOptionPane.showMessageDialog(null, "Documento Exportado Exitosamente!", "Guardado exitoso!", JOptionPane.INFORMATION_MESSAGE);
            
               //Para que lo abra una vez guardado
//               Runtime.getRuntime().exec("cmd /c start "+PATH + ".pdf");
               
        } }catch (FileNotFoundException | HeadlessException e) {//por alguna excepcion salta un mensaje de error
            JOptionPane.showMessageDialog(null, "Error al Exportar el archivo!"+e.getMessage(), "Oops! Error", JOptionPane.ERROR_MESSAGE);
        } catch (JRException ex) {
         Logger.getLogger(frm_LAB_BUSCAR_RESULTADO.class.getName()).log(Level.SEVERE, null, ex);
     } /*catch (IOException ex) {
        Logger.getLogger(frm_LAB_BUSCAR_RESULTADO.class.getName()).log(Level.SEVERE, null, ex);
    }*/
    }
    
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
//            lblHora.setText(hora + ":" + minutos + ":" + segundos + " " + ampm);
            try {

//                 if(lbldia.getText().equalsIgnoreCase("Resultados del Día")){
//                LAB_BUSCAR_TM_DIA();
//                }
                Thread.sleep(16000);

//                 if(lbldia.getText().equalsIgnoreCase("Resultados del Día")){
//                LAB_BUSCAR_TM_DIA();
//                }
                Thread.sleep(9000);
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
            java.util.logging.Logger.getLogger(frm_LAB_BUSCAR_RESULTADO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_LAB_BUSCAR_RESULTADO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_LAB_BUSCAR_RESULTADO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_LAB_BUSCAR_RESULTADO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new frm_LAB_BUSCAR_RESULTADO().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem EXPORTAR_PDF;
    private javax.swing.JMenuItem VER;
    private javax.swing.JMenuItem VER_RESULTADO;
    private javax.swing.JDialog analisis;
    public static javax.swing.JButton btnAnalisis;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JButton btnBuscarAnalisis;
    private javax.swing.JButton btnBuscarPersonal;
    public static javax.swing.JButton btnPacientes;
    public static javax.swing.JButton btnPersonal;
    private javax.swing.JDialog buscar_HC;
    private javax.swing.JComboBox cbx;
    private javax.swing.JComboBox cbxBuscarAnalisis;
    private javax.swing.JComboBox cbxBuscarPersonal;
    private javax.swing.JCheckBox chActoMedico;
    private javax.swing.JCheckBox chAnalisis;
    private javax.swing.JCheckBox chPacientes;
    private javax.swing.JCheckBox chPersonal;
    private com.toedter.calendar.JDateChooser dateDesde;
    private com.toedter.calendar.JDateChooser dateHasta;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPanel jpanel;
    private javax.swing.JPanel jpanel1;
    private javax.swing.JPanel jpanel2;
    private javax.swing.JPanel jpanel3;
    private javax.swing.JLabel lblArea;
    private javax.swing.JLabel lblServicio;
    public static javax.swing.JLabel lblUsu;
    private javax.swing.JLabel lbldia;
    private javax.swing.JPanel panelPacientes;
    private javax.swing.JDialog personal;
    public static javax.swing.JTable tbPersonal;
    private javax.swing.JTable tb_Analisis;
    public static javax.swing.JTable tb_HC;
    public static javax.swing.JTable tb_TomasRealizadas;
    private javax.swing.JLabel titulo5;
    private javax.swing.JLabel titulo6;
    private javax.swing.JLabel titulo7;
    private javax.swing.JLabel titulo8;
    public static javax.swing.JTextField txtActoM;
    public static javax.swing.JTextField txtAnalisis;
    private javax.swing.JTextField txtBuscarAnalisis;
    private javax.swing.JTextField txtBuscarPersonal;
    public static javax.swing.JTextField txtPacientes;
    public static javax.swing.JTextField txtPersonal;
    private javax.swing.JTextField txtbuscarHC;
    // End of variables declaration//GEN-END:variables
}
