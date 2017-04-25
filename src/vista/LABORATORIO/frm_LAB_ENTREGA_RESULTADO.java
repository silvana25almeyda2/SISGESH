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
import modelos.LABORATORIO.LAB_Entrega_Resultado;
import modelos.LABORATORIO.LAB_Muestra_Examen;
import modelos.LABORATORIO.LAB_PC_AREA;
import modelos.LABORATORIO.LAB_Resultado_Muestra_Cabecera;
import modelos.LABORATORIO.LAB_Toma_Muestra_Cabecera;
import modelos.LABORATORIO.Render_Checkbox;
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
public class frm_LAB_ENTREGA_RESULTADO extends javax.swing.JFrame implements Runnable{
String hora, minutos, segundos, ampm;
    Calendar calendario;
    Thread h1;
    Connection conexion=null;
Conexion c=new Conexion();
    DefaultTableModel m,n,resultado;
    /**
     * Creates new form LAB_MUESTRA_EXAMEN
     */
    public frm_LAB_ENTREGA_RESULTADO() {
        initComponents();
        c.conectar();
     
        h1 = new Thread(this);
        h1.start();
        buscar_HC.getContentPane().setBackground(Color.white); 
        buscar_HC.setLocationRelativeTo(null);
        personal.getContentPane().setBackground(Color.white);
        personal.setLocationRelativeTo(null);
        analisis.getContentPane().setBackground(Color.white);
        analisis.setLocationRelativeTo(null);
        personal_rol.getContentPane().setBackground(Color.white);
        personal_rol.setLocationRelativeTo(null);
        entregaResultado.getContentPane().setBackground(Color.white);
        entregaResultado.setLocationRelativeTo(null);
       panelPaciente.setBackground(Color.white); 
        panelTM.setBackground(Color.white); 
         panelAnalisis.setBackground(Color.white); 
        panelResultado.setBackground(Color.white);
        panelPacientes.setBackground(Color.white);
        panelEntrega.setBackground(Color.white);
        panelRecepcion.setBackground(Color.white);

        
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
//        lblEstado.setVisible(false);
            
            //ocultar entrega
            lblCodPerEntrega.setVisible(false);
            lblCod_cab_resul.setVisible(false);
            lblar_idRecep.setVisible(false);
           lblcodPerRecep.setVisible(false);
           lblid_hc.setVisible(false);
           
        lblServicio.setVisible(false);
        lblArea.setVisible(false);
//            lbltipo.setVisible(false);
        this.getContentPane().setBackground(Color.white); 
       
        setLocationRelativeTo(null);//en el centro
        setResizable(false);//para que no funcione el boton maximizar
        buscar_HC.setResizable(false);
        dateDesde.setBackground(Color.white);
        dateHasta.setBackground(Color.white);
        date.setBackground(Color.white);
      spHora.setBackground(Color.white);
        //fecha
       Calendar cal=Calendar.getInstance(); 
        String hora=cal.get(cal.HOUR_OF_DAY)+":"+cal.get(cal.MINUTE)+":"+cal.get(cal.SECOND); 
        lblFecha.setText(fechaActual());
       
    dateDesde.requestFocus();
  
 
    //inicio
    txtPacientes.setEnabled(false);
            btnPacientes.setEnabled(false);
            txtAnalisis.setEnabled(false);
            btnAnalisis.setEnabled(false);
            txtPersonal.setEnabled(false);
            btnPersonal.setEnabled(false);
            txtActoM.setEnabled(false);
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
    
    public void formato(){
    tb_Resultado.getColumnModel().getColumn(3).setPreferredWidth(210);
    tb_Resultado.getColumnModel().getColumn(4).setPreferredWidth(90);
    tb_Resultado.getColumnModel().getColumn(5).setPreferredWidth(250);
    tb_Resultado.getColumnModel().getColumn(6).setPreferredWidth(240);
    tb_Resultado.getColumnModel().getColumn(7).setPreferredWidth(100);
    tb_Resultado.getColumnModel().getColumn(8).setPreferredWidth(200);
    tb_Resultado.getColumnModel().getColumn(9).setPreferredWidth(90);
    tb_Resultado.getColumnModel().getColumn(10).setPreferredWidth(100);
    tb_Resultado.getColumnModel().getColumn(11).setPreferredWidth(50);
    tb_Resultado.getColumnModel().getColumn(12).setPreferredWidth(50);
    tb_Resultado.getColumnModel().getColumn(13).setPreferredWidth(100);
    tb_Resultado.getColumnModel().getColumn(14).setPreferredWidth(100);
    tb_Resultado.getColumnModel().getColumn(15).setPreferredWidth(130);
    tb_Resultado.getColumnModel().getColumn(16).setPreferredWidth(100);
    tb_Resultado.getColumnModel().getColumn(17).setPreferredWidth(100);
    tb_Resultado.getColumnModel().getColumn(19).setPreferredWidth(130);
    tb_Resultado.getColumnModel().getColumn(20).setPreferredWidth(130);
    tb_Resultado.getColumnModel().getColumn(25).setPreferredWidth(110);
    //Ocultar    
    tb_Resultado.getColumnModel().getColumn(0).setMinWidth(0);
    tb_Resultado.getColumnModel().getColumn(0).setMaxWidth(0);
    tb_Resultado.getColumnModel().getColumn(1).setMinWidth(0);
    tb_Resultado.getColumnModel().getColumn(1).setMaxWidth(0);
    tb_Resultado.getColumnModel().getColumn(2).setMinWidth(0);
    tb_Resultado.getColumnModel().getColumn(2).setMaxWidth(0);
//    tb_TomasRealizadas.getColumnModel().getColumn(3).setMinWidth(0);
//    tb_TomasRealizadas.getColumnModel().getColumn(3).setMaxWidth(0);
    tb_Resultado.getColumnModel().getColumn(14).setMinWidth(0);
    tb_Resultado.getColumnModel().getColumn(14).setMaxWidth(0);
    tb_Resultado.getColumnModel().getColumn(19).setMinWidth(0);
    tb_Resultado.getColumnModel().getColumn(19).setMaxWidth(0);
    tb_Resultado.getColumnModel().getColumn(20).setMinWidth(0);
    tb_Resultado.getColumnModel().getColumn(20).setMaxWidth(0);
    tb_Resultado.getColumnModel().getColumn(16).setMinWidth(0);
    tb_Resultado.getColumnModel().getColumn(16).setMaxWidth(0);
    tb_Resultado.getColumnModel().getColumn(17).setMinWidth(0);
    tb_Resultado.getColumnModel().getColumn(17).setMaxWidth(0);
    tb_Resultado.getColumnModel().getColumn(18).setMinWidth(0);
    tb_Resultado.getColumnModel().getColumn(18).setMaxWidth(0);
    tb_Resultado.getColumnModel().getColumn(21).setMinWidth(0);
    tb_Resultado.getColumnModel().getColumn(21).setMaxWidth(0);
    tb_Resultado.getColumnModel().getColumn(22).setMinWidth(0);
    tb_Resultado.getColumnModel().getColumn(22).setMaxWidth(0);
    tb_Resultado.getColumnModel().getColumn(23).setMinWidth(0);
    tb_Resultado.getColumnModel().getColumn(23).setMaxWidth(0);
    tb_Resultado.getColumnModel().getColumn(24).setMinWidth(0);
    tb_Resultado.getColumnModel().getColumn(24).setMaxWidth(0);
    tb_Resultado.getColumnModel().getColumn(26).setMinWidth(0);
    tb_Resultado.getColumnModel().getColumn(26).setMaxWidth(0);
    tb_Resultado.getColumnModel().getColumn(27).setMinWidth(0);
    tb_Resultado.getColumnModel().getColumn(27).setMaxWidth(0);
    tb_Resultado.getSelectionModel().setSelectionInterval(0, 0);
            tb_Resultado.requestFocus();
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
            tb_Resultado.setModel(new DefaultTableModel());
            String titulos[]={"cod_cab_resultado_mu_ana","cod_exa_ana","id_hc","Servicio/Área","Código CPT",
                "Nomenclatura" ,"Análisis Examen","N° de H.C.","Datos del Paciente",
                "DNI","Fecha de Nacimiento","Edad","Sexo","Acto Médico","N° de TM","Forma de Pago"
                ,"Fecha Orden","Hora Orden","Personal Solicita","Serv-Hosp","Habitacion","Cama",
                "N° de Resultado","Personal Resultado","Personal Registra Resultado",
                "Fecha Resultado","Hora Resultado","id_cod_doc_det"};
            m=new DefaultTableModel(null,titulos);
            JTable p=new JTable(m);
//            m=(DefaultTableModel)tb_TomasRealizadas.getModel(); Cuando se va agregando
            String fila[]=new String[28];

            LAB_Analisis_Examen obj=new LAB_Analisis_Examen();
                    consulta="exec sp_LAB_ENTREGA_RESULTADO_buscar ?,?,?,?,?";
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
                fila[27]=r.getString(28);
                m.addRow(fila);
                c++;
            }
            tb_Resultado.setModel(m);
            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m);
            tb_Resultado.setRowSorter(elQueOrdena);
            this.tb_Resultado.setModel(m);
            
            formato();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
}
    
    public void LAB_HC_cargar(){
    try {
             String titulos[]={"N°","N° H.C.","Paciente","Dirección","DNI","Sexo","Fecha de Nac.","Edad","Código"};
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
            fila[0]=String.valueOf(c)+"°";
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
            fila[0]=String.valueOf(c)+"°";
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

     public void PersonalRol_cargar(){
         String tipo="",serArea="";
         if(lblArea.getText().equalsIgnoreCase("")){
             tipo="1";
             serArea=lblServicio.getText();
         }else{
             tipo="2";
             serArea=lblArea.getText();
         }
    try {
             String titulos[]={"N°","Código","Apellido Paterno","Apellido Materno","Nombres","Cargo","Servicio","Área","Codigo"};
            m=new DefaultTableModel(null,titulos);
            JTable p=new JTable(m);
            String fila[]=new String[9];
            LAB_Toma_Muestra_Cabecera obj=new LAB_Toma_Muestra_Cabecera();
            
        String consulta="exec sp_PERSONAL_ROL ?,?,?";
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
            fila[6]=r.getString(6);
            fila[7]=r.getString(7);
            fila[8]=r.getString(8);
                m.addRow(fila);
                c++;
            }
            tbPersonalRol.setModel(m);
            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m);
            tbPersonalRol.setRowSorter(elQueOrdena);
            this.tbPersonalRol.setModel(m);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(rootPane, e.getMessage());
    }
}
    public void PersonalRol_formato(){
    tbPersonalRol.getColumnModel().getColumn(0).setPreferredWidth(40);
    tbPersonalRol.getColumnModel().getColumn(1).setPreferredWidth(100);
    tbPersonalRol.getColumnModel().getColumn(2).setPreferredWidth(120);
    tbPersonalRol.getColumnModel().getColumn(3).setPreferredWidth(120);
    tbPersonalRol.getColumnModel().getColumn(4).setPreferredWidth(200);
    tbPersonalRol.getColumnModel().getColumn(5).setPreferredWidth(240);
    tbPersonalRol.getColumnModel().getColumn(6).setPreferredWidth(120);
    tbPersonalRol.getColumnModel().getColumn(7).setPreferredWidth(120);
    tbPersonalRol.getSelectionModel().setSelectionInterval(0, 0);
            tbPersonalRol.requestFocus();
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
            String titulos[]={"NO","Código","C�digo CPT","Análisis","Servicio","Área"};
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
                fila[0]=String.valueOf(c)+"°";
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
            jLabel25 = new javax.swing.JLabel();
            lblEstado = new javax.swing.JLabel();
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
                entregaResultado = new javax.swing.JDialog();
                jpanel4 = new javax.swing.JPanel();
                titulo9 = new javax.swing.JLabel();
                panelPaciente = new javax.swing.JPanel();
                jLabel23 = new javax.swing.JLabel();
                txtDni = new javax.swing.JTextField();
                jLabel22 = new javax.swing.JLabel();
                txtHc = new javax.swing.JTextField();
                txtPacientes2 = new javax.swing.JTextField();
                jLabel7 = new javax.swing.JLabel();
                jLabel17 = new javax.swing.JLabel();
                txtFecha = new javax.swing.JTextField();
                jLabel18 = new javax.swing.JLabel();
                txtSexo = new javax.swing.JTextField();
                jLabel24 = new javax.swing.JLabel();
                txtEdad = new javax.swing.JTextField();
                panelAnalisis = new javax.swing.JPanel();
                txtNomenclatura = new javax.swing.JTextField();
                jLabel35 = new javax.swing.JLabel();
                jLabel38 = new javax.swing.JLabel();
                txtCPT = new javax.swing.JTextField();
                jLabel39 = new javax.swing.JLabel();
                txtServArea = new javax.swing.JTextField();
                panelResultado = new javax.swing.JPanel();
                jLabel40 = new javax.swing.JLabel();
                txtPersonalResponR = new javax.swing.JTextField();
                txtPersonalRegistraR = new javax.swing.JTextField();
                jLabel43 = new javax.swing.JLabel();
                jLabel44 = new javax.swing.JLabel();
                jLabel45 = new javax.swing.JLabel();
                lblFecha1 = new javax.swing.JLabel();
                lblHora1 = new javax.swing.JLabel();
                panelTM = new javax.swing.JPanel();
                jLabel31 = new javax.swing.JLabel();
                txtActoMedico = new javax.swing.JTextField();
                txtFormaPago = new javax.swing.JTextField();
                jLabel30 = new javax.swing.JLabel();
                jLabel29 = new javax.swing.JLabel();
                txtNToma = new javax.swing.JTextField();
                jLabel26 = new javax.swing.JLabel();
                txtPersonalSolicita = new javax.swing.JTextField();
                jLabel32 = new javax.swing.JLabel();
                txtPiso = new javax.swing.JTextField();
                jLabel33 = new javax.swing.JLabel();
                txtCama = new javax.swing.JTextField();
                jLabel34 = new javax.swing.JLabel();
                jLabel37 = new javax.swing.JLabel();
                txtFechaOrden = new javax.swing.JTextField();
                txtHoraOrden = new javax.swing.JTextField();
                txthospiServ = new javax.swing.JTextField();
                jLabel36 = new javax.swing.JLabel();
                panelEntrega = new javax.swing.JPanel();
                date = new com.toedter.calendar.JDateChooser();
                jLabel27 = new javax.swing.JLabel();
                jLabel28 = new javax.swing.JLabel();
                spHora = new javax.swing.JSpinner();
                spMin = new javax.swing.JSpinner();
                jLabel11 = new javax.swing.JLabel();
                jLabel12 = new javax.swing.JLabel();
                txtPersonalEntreg = new javax.swing.JTextField();
                jLabel41 = new javax.swing.JLabel();
                lblCodPerEntrega = new javax.swing.JLabel();
                lblCod_cab_resul = new javax.swing.JLabel();
                panelRecepcion = new javax.swing.JPanel();
                rbPersonal = new javax.swing.JRadioButton();
                jRadioButton2 = new javax.swing.JRadioButton();
                jLabel1 = new javax.swing.JLabel();
                jLabel8 = new javax.swing.JLabel();
                txtPacienteRecep = new javax.swing.JTextField();
                jLabel4 = new javax.swing.JLabel();
                txtServRecep = new javax.swing.JTextField();
                txtAreaRecep = new javax.swing.JTextField();
                jLabel5 = new javax.swing.JLabel();
                txtPersonalRecep = new javax.swing.JTextField();
                lblar_idRecep = new javax.swing.JLabel();
                lblcodPerRecep = new javax.swing.JLabel();
                lblid_hc = new javax.swing.JLabel();
                btnGenerar = new javax.swing.JButton();
                jButton1 = new javax.swing.JButton();
                buttonGroup1 = new javax.swing.ButtonGroup();
                personal_rol = new javax.swing.JDialog();
                txtBuscarRol = new javax.swing.JTextField();
                jLabel9 = new javax.swing.JLabel();
                btnBuscaRol = new javax.swing.JButton();
                jScrollPane4 = new javax.swing.JScrollPane();
                tbPersonalRol = new javax.swing.JTable(){
                    public boolean isCellEditable(int rowIndex, int colIndex){
                        return false; //Disallow the editing of any cell
                    }};
                    cbxBuscarRol = new javax.swing.JComboBox();
                    jpanel5 = new javax.swing.JPanel();
                    titulo10 = new javax.swing.JLabel();
                    lbltipo = new javax.swing.JLabel();
                    jpanel = new javax.swing.JPanel();
                    titulo5 = new javax.swing.JLabel();
                    jLabel14 = new javax.swing.JLabel();
                    lblFecha = new javax.swing.JLabel();
                    jLabel15 = new javax.swing.JLabel();
                    lblHora = new javax.swing.JLabel();
                    lblUsu = new javax.swing.JLabel();
                    jScrollPane5 = new javax.swing.JScrollPane();
                    tb_Resultado = new javax.swing.JTable(){
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
                            buscar_HC.setTitle("SISGESH.::.Clasificación Examen");
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

                            jLabel25.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
                            jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                            jLabel25.setText("Búsqueda por H.C / Paciente / DNI");

                            lblEstado.setBackground(new java.awt.Color(255, 255, 255));
                            lblEstado.setForeground(new java.awt.Color(255, 255, 255));
                            lblEstado.setText("jLabel9");

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
                                        .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtbuscarHC, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 178, Short.MAX_VALUE)
                                    .addComponent(lblEstado)
                                    .addGap(46, 46, 46))
                                .addGroup(buscar_HCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jpanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            );
                            buscar_HCLayout.setVerticalGroup(
                                buscar_HCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buscar_HCLayout.createSequentialGroup()
                                    .addGap(58, 58, 58)
                                    .addGroup(buscar_HCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(buscar_HCLayout.createSequentialGroup()
                                            .addGroup(buscar_HCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtbuscarHC, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(2, 2, 2)
                                            .addComponent(jLabel25))
                                        .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(3, 3, 3)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(38, Short.MAX_VALUE))
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

                            entregaResultado.setAlwaysOnTop(true);
                            entregaResultado.setMinimumSize(new java.awt.Dimension(891, 712));
                            entregaResultado.setResizable(false);

                            jpanel4.setBackground(new java.awt.Color(2, 67, 115));

                            titulo9.setBackground(new java.awt.Color(0, 102, 102));
                            titulo9.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
                            titulo9.setForeground(new java.awt.Color(255, 255, 255));
                            titulo9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                            titulo9.setText("Entrega de Resultados");
                            titulo9.setToolTipText("");
                            titulo9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

                            javax.swing.GroupLayout jpanel4Layout = new javax.swing.GroupLayout(jpanel4);
                            jpanel4.setLayout(jpanel4Layout);
                            jpanel4Layout.setHorizontalGroup(
                                jpanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jpanel4Layout.createSequentialGroup()
                                    .addGap(16, 16, 16)
                                    .addComponent(titulo9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addContainerGap())
                            );
                            jpanel4Layout.setVerticalGroup(
                                jpanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jpanel4Layout.createSequentialGroup()
                                    .addComponent(titulo9, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
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

                            txtPacientes2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                            txtPacientes2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                            txtPacientes2.setEnabled(false);

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
                                    .addContainerGap()
                                    .addGroup(panelPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtDni)
                                        .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                                        .addComponent(txtHc, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addGroup(panelPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelPacienteLayout.createSequentialGroup()
                                            .addGap(12, 12, 12)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(panelPacienteLayout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(panelPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtPacientes2, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(panelPacienteLayout.createSequentialGroup()
                                                    .addGroup(panelPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(txtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                                                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addGroup(panelPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(txtEdad)
                                                        .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addGroup(panelPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(txtSexo)
                                                        .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))))))
                                    .addContainerGap())
                            );
                            panelPacienteLayout.setVerticalGroup(
                                panelPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelPacienteLayout.createSequentialGroup()
                                    .addGap(0, 0, 0)
                                    .addGroup(panelPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel22)
                                        .addComponent(jLabel7))
                                    .addGap(0, 0, 0)
                                    .addGroup(panelPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtHc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtPacientes2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 0, 0)
                                    .addGroup(panelPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel23)
                                        .addGroup(panelPacienteLayout.createSequentialGroup()
                                            .addGroup(panelPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel17)
                                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel18))
                                            .addGap(0, 0, 0)
                                            .addGroup(panelPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtSexo))))
                                    .addGap(0, 0, Short.MAX_VALUE))
                            );

                            panelAnalisis.setBorder(javax.swing.BorderFactory.createTitledBorder("Análisis"));

                            txtNomenclatura.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
                            txtNomenclatura.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                            txtNomenclatura.setEnabled(false);
                            txtNomenclatura.addActionListener(new java.awt.event.ActionListener() {
                                public void actionPerformed(java.awt.event.ActionEvent evt) {
                                    txtNomenclaturaActionPerformed(evt);
                                }
                            });
                            txtNomenclatura.addKeyListener(new java.awt.event.KeyAdapter() {
                                public void keyPressed(java.awt.event.KeyEvent evt) {
                                    txtNomenclaturaKeyPressed(evt);
                                }
                                public void keyReleased(java.awt.event.KeyEvent evt) {
                                    txtNomenclaturaKeyReleased(evt);
                                }
                            });

                            jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                            jLabel35.setText("Ánalisis / Examen");

                            jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                            jLabel38.setText("Código CPT");

                            txtCPT.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
                            txtCPT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                            txtCPT.setEnabled(false);
                            txtCPT.addActionListener(new java.awt.event.ActionListener() {
                                public void actionPerformed(java.awt.event.ActionEvent evt) {
                                    txtCPTActionPerformed(evt);
                                }
                            });
                            txtCPT.addKeyListener(new java.awt.event.KeyAdapter() {
                                public void keyPressed(java.awt.event.KeyEvent evt) {
                                    txtCPTKeyPressed(evt);
                                }
                                public void keyReleased(java.awt.event.KeyEvent evt) {
                                    txtCPTKeyReleased(evt);
                                }
                            });

                            jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                            jLabel39.setText("Servicio/Área");

                            txtServArea.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                            txtServArea.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                            txtServArea.setEnabled(false);
                            txtServArea.addKeyListener(new java.awt.event.KeyAdapter() {
                                public void keyPressed(java.awt.event.KeyEvent evt) {
                                    txtServAreaKeyPressed(evt);
                                }
                                public void keyReleased(java.awt.event.KeyEvent evt) {
                                    txtServAreaKeyReleased(evt);
                                }
                            });

                            javax.swing.GroupLayout panelAnalisisLayout = new javax.swing.GroupLayout(panelAnalisis);
                            panelAnalisis.setLayout(panelAnalisisLayout);
                            panelAnalisisLayout.setHorizontalGroup(
                                panelAnalisisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelAnalisisLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(panelAnalisisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(panelAnalisisLayout.createSequentialGroup()
                                            .addGroup(panelAnalisisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtCPT, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(panelAnalisisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                                                .addComponent(txtNomenclatura)))
                                        .addComponent(txtServArea)
                                        .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            );
                            panelAnalisisLayout.setVerticalGroup(
                                panelAnalisisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelAnalisisLayout.createSequentialGroup()
                                    .addGap(0, 0, 0)
                                    .addComponent(jLabel39)
                                    .addGap(0, 0, 0)
                                    .addComponent(txtServArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panelAnalisisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelAnalisisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel38)
                                            .addGroup(panelAnalisisLayout.createSequentialGroup()
                                                .addGap(14, 14, 14)
                                                .addGroup(panelAnalisisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(txtNomenclatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtCPT))))
                                        .addGroup(panelAnalisisLayout.createSequentialGroup()
                                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(21, 21, 21))))
                            );

                            panelResultado.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultado"));

                            jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                            jLabel40.setText("Personal - Responsable Resultado");

                            txtPersonalResponR.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
                            txtPersonalResponR.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                            txtPersonalResponR.setEnabled(false);
                            txtPersonalResponR.addActionListener(new java.awt.event.ActionListener() {
                                public void actionPerformed(java.awt.event.ActionEvent evt) {
                                    txtPersonalResponRActionPerformed(evt);
                                }
                            });
                            txtPersonalResponR.addKeyListener(new java.awt.event.KeyAdapter() {
                                public void keyPressed(java.awt.event.KeyEvent evt) {
                                    txtPersonalResponRKeyPressed(evt);
                                }
                                public void keyReleased(java.awt.event.KeyEvent evt) {
                                    txtPersonalResponRKeyReleased(evt);
                                }
                            });

                            txtPersonalRegistraR.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
                            txtPersonalRegistraR.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                            txtPersonalRegistraR.setEnabled(false);
                            txtPersonalRegistraR.addActionListener(new java.awt.event.ActionListener() {
                                public void actionPerformed(java.awt.event.ActionEvent evt) {
                                    txtPersonalRegistraRActionPerformed(evt);
                                }
                            });
                            txtPersonalRegistraR.addKeyListener(new java.awt.event.KeyAdapter() {
                                public void keyPressed(java.awt.event.KeyEvent evt) {
                                    txtPersonalRegistraRKeyPressed(evt);
                                }
                                public void keyReleased(java.awt.event.KeyEvent evt) {
                                    txtPersonalRegistraRKeyReleased(evt);
                                }
                            });

                            jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                            jLabel43.setText("Personal - Registra Resultado");

                            jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                            jLabel44.setText("Fecha Registro Resul.");

                            jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                            jLabel45.setText("Hora Registro Resul.");

                            lblFecha1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
                            lblFecha1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                            lblFecha1.setText("00/00/00");

                            lblHora1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
                            lblHora1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                            lblHora1.setText("00:00:00");

                            javax.swing.GroupLayout panelResultadoLayout = new javax.swing.GroupLayout(panelResultado);
                            panelResultado.setLayout(panelResultadoLayout);
                            panelResultadoLayout.setHorizontalGroup(
                                panelResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelResultadoLayout.createSequentialGroup()
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(panelResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtPersonalResponR)
                                        .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(panelResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                                        .addComponent(txtPersonalRegistraR))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panelResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblFecha1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(panelResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblHora1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)))
                            );
                            panelResultadoLayout.setVerticalGroup(
                                panelResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelResultadoLayout.createSequentialGroup()
                                    .addGap(0, 0, 0)
                                    .addGroup(panelResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelResultadoLayout.createSequentialGroup()
                                            .addGap(14, 14, 14)
                                            .addGroup(panelResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(txtPersonalResponR)
                                                .addComponent(txtPersonalRegistraR)
                                                .addComponent(lblFecha1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblHora1))
                                            .addGap(3, 3, 3))
                                        .addGroup(panelResultadoLayout.createSequentialGroup()
                                            .addGroup(panelResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel44)
                                                .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE))
                                            .addGap(17, 17, 17))))
                            );

                            panelTM.setBorder(javax.swing.BorderFactory.createTitledBorder("Toma de Muestra"));

                            jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                            jLabel31.setText("Acto Médico");

                            txtActoMedico.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                            txtActoMedico.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                            txtActoMedico.setEnabled(false);

                            txtFormaPago.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
                            txtFormaPago.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                            txtFormaPago.setEnabled(false);
                            txtFormaPago.addActionListener(new java.awt.event.ActionListener() {
                                public void actionPerformed(java.awt.event.ActionEvent evt) {
                                    txtFormaPagoActionPerformed(evt);
                                }
                            });
                            txtFormaPago.addKeyListener(new java.awt.event.KeyAdapter() {
                                public void keyPressed(java.awt.event.KeyEvent evt) {
                                    txtFormaPagoKeyPressed(evt);
                                }
                                public void keyReleased(java.awt.event.KeyEvent evt) {
                                    txtFormaPagoKeyReleased(evt);
                                }
                            });

                            jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                            jLabel30.setText("Forma de Pago");

                            jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                            jLabel29.setText("N° de Toma de Muestra");

                            txtNToma.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
                            txtNToma.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                            txtNToma.setEnabled(false);
                            txtNToma.addKeyListener(new java.awt.event.KeyAdapter() {
                                public void keyPressed(java.awt.event.KeyEvent evt) {
                                    txtNTomaKeyPressed(evt);
                                }
                                public void keyReleased(java.awt.event.KeyEvent evt) {
                                    txtNTomaKeyReleased(evt);
                                }
                            });

                            jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                            jLabel26.setText("Personal - Solicita Muestra");

                            txtPersonalSolicita.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
                            txtPersonalSolicita.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                            txtPersonalSolicita.setEnabled(false);
                            txtPersonalSolicita.addActionListener(new java.awt.event.ActionListener() {
                                public void actionPerformed(java.awt.event.ActionEvent evt) {
                                    txtPersonalSolicitaActionPerformed(evt);
                                }
                            });
                            txtPersonalSolicita.addKeyListener(new java.awt.event.KeyAdapter() {
                                public void keyPressed(java.awt.event.KeyEvent evt) {
                                    txtPersonalSolicitaKeyPressed(evt);
                                }
                                public void keyReleased(java.awt.event.KeyEvent evt) {
                                    txtPersonalSolicitaKeyReleased(evt);
                                }
                            });

                            jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                            jLabel32.setText("Piso");

                            txtPiso.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
                            txtPiso.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                            txtPiso.setEnabled(false);
                            txtPiso.addActionListener(new java.awt.event.ActionListener() {
                                public void actionPerformed(java.awt.event.ActionEvent evt) {
                                    txtPisoActionPerformed(evt);
                                }
                            });
                            txtPiso.addKeyListener(new java.awt.event.KeyAdapter() {
                                public void keyPressed(java.awt.event.KeyEvent evt) {
                                    txtPisoKeyPressed(evt);
                                }
                                public void keyReleased(java.awt.event.KeyEvent evt) {
                                    txtPisoKeyReleased(evt);
                                }
                            });

                            jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                            jLabel33.setText("Cama");

                            txtCama.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
                            txtCama.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                            txtCama.setEnabled(false);
                            txtCama.addActionListener(new java.awt.event.ActionListener() {
                                public void actionPerformed(java.awt.event.ActionEvent evt) {
                                    txtCamaActionPerformed(evt);
                                }
                            });
                            txtCama.addKeyListener(new java.awt.event.KeyAdapter() {
                                public void keyPressed(java.awt.event.KeyEvent evt) {
                                    txtCamaKeyPressed(evt);
                                }
                                public void keyReleased(java.awt.event.KeyEvent evt) {
                                    txtCamaKeyReleased(evt);
                                }
                            });

                            jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                            jLabel34.setText("Fecha Orden");

                            jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                            jLabel37.setText("Hora Orden");

                            txtFechaOrden.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
                            txtFechaOrden.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                            txtFechaOrden.setEnabled(false);
                            txtFechaOrden.addActionListener(new java.awt.event.ActionListener() {
                                public void actionPerformed(java.awt.event.ActionEvent evt) {
                                    txtFechaOrdenActionPerformed(evt);
                                }
                            });
                            txtFechaOrden.addKeyListener(new java.awt.event.KeyAdapter() {
                                public void keyPressed(java.awt.event.KeyEvent evt) {
                                    txtFechaOrdenKeyPressed(evt);
                                }
                                public void keyReleased(java.awt.event.KeyEvent evt) {
                                    txtFechaOrdenKeyReleased(evt);
                                }
                            });

                            txtHoraOrden.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
                            txtHoraOrden.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                            txtHoraOrden.setEnabled(false);
                            txtHoraOrden.addActionListener(new java.awt.event.ActionListener() {
                                public void actionPerformed(java.awt.event.ActionEvent evt) {
                                    txtHoraOrdenActionPerformed(evt);
                                }
                            });
                            txtHoraOrden.addKeyListener(new java.awt.event.KeyAdapter() {
                                public void keyPressed(java.awt.event.KeyEvent evt) {
                                    txtHoraOrdenKeyPressed(evt);
                                }
                                public void keyReleased(java.awt.event.KeyEvent evt) {
                                    txtHoraOrdenKeyReleased(evt);
                                }
                            });

                            txthospiServ.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
                            txthospiServ.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                            txthospiServ.setEnabled(false);
                            txthospiServ.addActionListener(new java.awt.event.ActionListener() {
                                public void actionPerformed(java.awt.event.ActionEvent evt) {
                                    txthospiServActionPerformed(evt);
                                }
                            });
                            txthospiServ.addKeyListener(new java.awt.event.KeyAdapter() {
                                public void keyPressed(java.awt.event.KeyEvent evt) {
                                    txthospiServKeyPressed(evt);
                                }
                                public void keyReleased(java.awt.event.KeyEvent evt) {
                                    txthospiServKeyReleased(evt);
                                }
                            });

                            jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                            jLabel36.setText("Hospitalización-Servicio");

                            javax.swing.GroupLayout panelTMLayout = new javax.swing.GroupLayout(panelTM);
                            panelTM.setLayout(panelTMLayout);
                            panelTMLayout.setHorizontalGroup(
                                panelTMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelTMLayout.createSequentialGroup()
                                    .addGroup(panelTMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTMLayout.createSequentialGroup()
                                            .addGroup(panelTMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(txtActoMedico)
                                                .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(panelTMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                                                .addComponent(txtNToma)))
                                        .addGroup(panelTMLayout.createSequentialGroup()
                                            .addGap(20, 20, 20)
                                            .addGroup(panelTMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtPersonalSolicita, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGap(18, 18, 18)
                                    .addGroup(panelTMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtFormaPago)
                                        .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                        .addComponent(txthospiServ))
                                    .addGap(21, 21, 21)
                                    .addGroup(panelTMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelTMLayout.createSequentialGroup()
                                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(panelTMLayout.createSequentialGroup()
                                            .addComponent(txtFechaOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtHoraOrden))
                                        .addGroup(panelTMLayout.createSequentialGroup()
                                            .addGroup(panelTMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(txtPiso, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(panelTMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtCama))))
                                    .addGap(35, 35, 35))
                            );
                            panelTMLayout.setVerticalGroup(
                                panelTMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelTMLayout.createSequentialGroup()
                                    .addGroup(panelTMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel29)
                                        .addComponent(jLabel30)
                                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel37))
                                    .addGap(0, 0, 0)
                                    .addGroup(panelTMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtNToma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtActoMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtFechaOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtHoraOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 0, 0)
                                    .addGroup(panelTMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel33)
                                        .addComponent(jLabel36)
                                        .addComponent(jLabel32))
                                    .addGroup(panelTMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtPersonalSolicita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txthospiServ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtPiso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtCama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 0, 0))
                            );

                            panelEntrega.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultado"));

                            date.setDateFormatString("dd-MM-yyyy");

                            jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                            jLabel27.setText("Fecha de Entrega");

                            jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                            jLabel28.setText("Hora de Entrega");

                            spHora.setModel(new javax.swing.SpinnerNumberModel(0, 0, 24, 1));
                            spHora.addChangeListener(new javax.swing.event.ChangeListener() {
                                public void stateChanged(javax.swing.event.ChangeEvent evt) {
                                    spHoraStateChanged(evt);
                                }
                            });

                            spMin.setModel(new javax.swing.SpinnerNumberModel(0, 0, 60, 1));
                            spMin.addChangeListener(new javax.swing.event.ChangeListener() {
                                public void stateChanged(javax.swing.event.ChangeEvent evt) {
                                    spMinStateChanged(evt);
                                }
                            });
                            spMin.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
                                public void propertyChange(java.beans.PropertyChangeEvent evt) {
                                    spMinPropertyChange(evt);
                                }
                            });

                            jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
                            jLabel11.setText("h");

                            jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
                            jLabel12.setText("min");

                            txtPersonalEntreg.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
                            txtPersonalEntreg.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                            txtPersonalEntreg.addKeyListener(new java.awt.event.KeyAdapter() {
                                public void keyPressed(java.awt.event.KeyEvent evt) {
                                    txtPersonalEntregKeyPressed(evt);
                                }
                            });

                            jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                            jLabel41.setText("Personal - Entrega Resultado");

                            javax.swing.GroupLayout panelEntregaLayout = new javax.swing.GroupLayout(panelEntrega);
                            panelEntrega.setLayout(panelEntregaLayout);
                            panelEntregaLayout.setHorizontalGroup(
                                panelEntregaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelEntregaLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(panelEntregaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelEntregaLayout.createSequentialGroup()
                                            .addGroup(panelEntregaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(37, 37, 37)
                                            .addGroup(panelEntregaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(panelEntregaLayout.createSequentialGroup()
                                                    .addComponent(spHora, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel11)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(spMin, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel12))
                                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addContainerGap(30, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEntregaLayout.createSequentialGroup()
                                            .addGroup(panelEntregaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel41, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtPersonalEntreg, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelEntregaLayout.createSequentialGroup()
                                                    .addComponent(lblCodPerEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(67, 67, 67)
                                                    .addComponent(lblCod_cab_resul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                            .addGap(18, 18, 18))))
                            );
                            panelEntregaLayout.setVerticalGroup(
                                panelEntregaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelEntregaLayout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addGroup(panelEntregaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel27)
                                        .addComponent(jLabel28))
                                    .addGap(0, 0, 0)
                                    .addGroup(panelEntregaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel11)
                                        .addComponent(spHora)
                                        .addComponent(spMin)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtPersonalEntreg, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(21, 21, 21)
                                    .addGroup(panelEntregaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblCod_cab_resul, javax.swing.GroupLayout.DEFAULT_SIZE, 3, Short.MAX_VALUE)
                                        .addComponent(lblCodPerEntrega, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addContainerGap())
                            );

                            panelRecepcion.setBorder(javax.swing.BorderFactory.createTitledBorder("Recepción"));

                            buttonGroup1.add(rbPersonal);
                            rbPersonal.setSelected(true);
                            rbPersonal.setText("Usuario Interno");
                            rbPersonal.addItemListener(new java.awt.event.ItemListener() {
                                public void itemStateChanged(java.awt.event.ItemEvent evt) {
                                    rbPersonalItemStateChanged(evt);
                                }
                            });

                            buttonGroup1.add(jRadioButton2);
                            jRadioButton2.setText("Usuario Externo");
                            jRadioButton2.addItemListener(new java.awt.event.ItemListener() {
                                public void itemStateChanged(java.awt.event.ItemEvent evt) {
                                    jRadioButton2ItemStateChanged(evt);
                                }
                            });

                            jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                            jLabel1.setText("Servicio");

                            jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                            jLabel8.setText("Paciente");

                            txtPacienteRecep.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
                            txtPacienteRecep.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                            txtPacienteRecep.setEnabled(false);
                            txtPacienteRecep.addKeyListener(new java.awt.event.KeyAdapter() {
                                public void keyPressed(java.awt.event.KeyEvent evt) {
                                    txtPacienteRecepKeyPressed(evt);
                                }
                            });

                            jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                            jLabel4.setText("Área");

                            txtServRecep.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
                            txtServRecep.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                            txtServRecep.setEnabled(false);

                            txtAreaRecep.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
                            txtAreaRecep.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                            txtAreaRecep.setEnabled(false);

                            jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                            jLabel5.setText("Personal");

                            txtPersonalRecep.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
                            txtPersonalRecep.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                            txtPersonalRecep.addKeyListener(new java.awt.event.KeyAdapter() {
                                public void keyPressed(java.awt.event.KeyEvent evt) {
                                    txtPersonalRecepKeyPressed(evt);
                                }
                            });

                            javax.swing.GroupLayout panelRecepcionLayout = new javax.swing.GroupLayout(panelRecepcion);
                            panelRecepcion.setLayout(panelRecepcionLayout);
                            panelRecepcionLayout.setHorizontalGroup(
                                panelRecepcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelRecepcionLayout.createSequentialGroup()
                                    .addGroup(panelRecepcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelRecepcionLayout.createSequentialGroup()
                                            .addContainerGap()
                                            .addGroup(panelRecepcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(panelRecepcionLayout.createSequentialGroup()
                                                    .addComponent(jRadioButton2)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(lblid_hc, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(panelRecepcionLayout.createSequentialGroup()
                                                    .addComponent(rbPersonal)
                                                    .addGap(29, 29, 29)
                                                    .addComponent(lblar_idRecep, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(32, 32, 32)
                                                    .addComponent(lblcodPerRecep, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(panelRecepcionLayout.createSequentialGroup()
                                            .addGap(29, 29, 29)
                                            .addGroup(panelRecepcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtPersonalRecep)
                                                .addGroup(panelRecepcionLayout.createSequentialGroup()
                                                    .addGroup(panelRecepcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(txtServRecep)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
                                                    .addGap(10, 10, 10)
                                                    .addGroup(panelRecepcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(txtAreaRecep)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)))))
                                        .addGroup(panelRecepcionLayout.createSequentialGroup()
                                            .addGap(55, 55, 55)
                                            .addGroup(panelRecepcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtPacienteRecep)
                                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE))))
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            );
                            panelRecepcionLayout.setVerticalGroup(
                                panelRecepcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelRecepcionLayout.createSequentialGroup()
                                    .addGap(0, 0, 0)
                                    .addGroup(panelRecepcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(rbPersonal)
                                        .addComponent(lblar_idRecep, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblcodPerRecep, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelRecepcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel4))
                                    .addGap(0, 0, 0)
                                    .addGroup(panelRecepcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtServRecep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtAreaRecep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 0, 0)
                                    .addComponent(jLabel5)
                                    .addGap(0, 0, 0)
                                    .addComponent(txtPersonalRecep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addGroup(panelRecepcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jRadioButton2)
                                        .addComponent(lblid_hc, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 0, 0)
                                    .addComponent(jLabel8)
                                    .addGap(0, 0, 0)
                                    .addComponent(txtPacienteRecep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0))
                            );

                            btnGenerar.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
                            btnGenerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/guardar16x16.png"))); // NOI18N
                            btnGenerar.setMnemonic('G');
                            btnGenerar.setText("Guardar");
                            btnGenerar.setToolTipText("Guardar(Alt + G)");
                            btnGenerar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                            btnGenerar.addActionListener(new java.awt.event.ActionListener() {
                                public void actionPerformed(java.awt.event.ActionEvent evt) {
                                    btnGenerarActionPerformed(evt);
                                }
                            });

                            jButton1.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
                            jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/salir16x16.png"))); // NOI18N
                            jButton1.setText("Regresar");
                            jButton1.setToolTipText("Regresar(Esc)");
                            jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                            jButton1.addActionListener(new java.awt.event.ActionListener() {
                                public void actionPerformed(java.awt.event.ActionEvent evt) {
                                    jButton1ActionPerformed(evt);
                                }
                            });

                            javax.swing.GroupLayout entregaResultadoLayout = new javax.swing.GroupLayout(entregaResultado.getContentPane());
                            entregaResultado.getContentPane().setLayout(entregaResultadoLayout);
                            entregaResultadoLayout.setHorizontalGroup(
                                entregaResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jpanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(entregaResultadoLayout.createSequentialGroup()
                                    .addGap(16, 16, 16)
                                    .addGroup(entregaResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(panelResultado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(panelTM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(entregaResultadoLayout.createSequentialGroup()
                                            .addComponent(panelPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(panelAnalisis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(entregaResultadoLayout.createSequentialGroup()
                                            .addGroup(entregaResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(entregaResultadoLayout.createSequentialGroup()
                                                    .addComponent(panelEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, entregaResultadoLayout.createSequentialGroup()
                                                    .addComponent(btnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(81, 81, 81)))
                                            .addGroup(entregaResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(panelRecepcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(entregaResultadoLayout.createSequentialGroup()
                                                    .addGap(101, 101, 101)
                                                    .addComponent(jButton1)
                                                    .addGap(0, 0, Short.MAX_VALUE)))))
                                    .addGap(67, 67, 67))
                            );
                            entregaResultadoLayout.setVerticalGroup(
                                entregaResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, entregaResultadoLayout.createSequentialGroup()
                                    .addComponent(jpanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(entregaResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(panelPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(panelAnalisis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(0, 0, 0)
                                    .addComponent(panelTM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(panelResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(entregaResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(panelRecepcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(panelEntrega, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(entregaResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addContainerGap(171, Short.MAX_VALUE))
                            );

                            personal_rol.setAlwaysOnTop(true);
                            personal_rol.setMinimumSize(new java.awt.Dimension(852, 504));

                            txtBuscarRol.setForeground(new java.awt.Color(0, 51, 51));
                            txtBuscarRol.setEnabled(false);
                            txtBuscarRol.addActionListener(new java.awt.event.ActionListener() {
                                public void actionPerformed(java.awt.event.ActionEvent evt) {
                                    txtBuscarRolActionPerformed(evt);
                                }
                            });
                            txtBuscarRol.addKeyListener(new java.awt.event.KeyAdapter() {
                                public void keyPressed(java.awt.event.KeyEvent evt) {
                                    txtBuscarRolKeyPressed(evt);
                                }
                                public void keyTyped(java.awt.event.KeyEvent evt) {
                                    txtBuscarRolKeyTyped(evt);
                                }
                            });

                            jLabel9.setText("Búsqueda por:");

                            btnBuscaRol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/view.gif"))); // NOI18N
                            btnBuscaRol.setBorder(null);
                            btnBuscaRol.setEnabled(false);
                            btnBuscaRol.addActionListener(new java.awt.event.ActionListener() {
                                public void actionPerformed(java.awt.event.ActionEvent evt) {
                                    btnBuscaRolActionPerformed(evt);
                                }
                            });

                            tbPersonalRol.setModel(new javax.swing.table.DefaultTableModel(
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
                            tbPersonalRol.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
                            tbPersonalRol.setRowHeight(25);
                            tbPersonalRol.getTableHeader().setReorderingAllowed(false);
                            tbPersonalRol.addMouseListener(new java.awt.event.MouseAdapter() {
                                public void mouseClicked(java.awt.event.MouseEvent evt) {
                                    tbPersonalRolMouseClicked(evt);
                                }
                            });
                            tbPersonalRol.addKeyListener(new java.awt.event.KeyAdapter() {
                                public void keyPressed(java.awt.event.KeyEvent evt) {
                                    tbPersonalRolKeyPressed(evt);
                                }
                                public void keyTyped(java.awt.event.KeyEvent evt) {
                                    tbPersonalRolKeyTyped(evt);
                                }
                            });
                            jScrollPane4.setViewportView(tbPersonalRol);

                            cbxBuscarRol.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar...", "Cargo", "Apellidos y Nombres" }));
                            cbxBuscarRol.addItemListener(new java.awt.event.ItemListener() {
                                public void itemStateChanged(java.awt.event.ItemEvent evt) {
                                    cbxBuscarRolItemStateChanged(evt);
                                }
                            });

                            jpanel5.setBackground(new java.awt.Color(2, 67, 115));

                            titulo10.setBackground(new java.awt.Color(0, 102, 102));
                            titulo10.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
                            titulo10.setForeground(new java.awt.Color(255, 255, 255));
                            titulo10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                            titulo10.setText("Personal");
                            titulo10.setToolTipText("");
                            titulo10.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

                            javax.swing.GroupLayout jpanel5Layout = new javax.swing.GroupLayout(jpanel5);
                            jpanel5.setLayout(jpanel5Layout);
                            jpanel5Layout.setHorizontalGroup(
                                jpanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(titulo10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            );
                            jpanel5Layout.setVerticalGroup(
                                jpanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(titulo10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            );

                            lbltipo.setBackground(new java.awt.Color(255, 255, 255));
                            lbltipo.setForeground(new java.awt.Color(255, 255, 255));
                            lbltipo.setText("jLabel1");

                            javax.swing.GroupLayout personal_rolLayout = new javax.swing.GroupLayout(personal_rol.getContentPane());
                            personal_rol.getContentPane().setLayout(personal_rolLayout);
                            personal_rolLayout.setHorizontalGroup(
                                personal_rolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(personal_rolLayout.createSequentialGroup()
                                    .addGroup(personal_rolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(personal_rolLayout.createSequentialGroup()
                                            .addGap(19, 19, 19)
                                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(personal_rolLayout.createSequentialGroup()
                                            .addGap(97, 97, 97)
                                            .addComponent(jLabel9)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cbxBuscarRol, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(158, 158, 158)
                                            .addComponent(txtBuscarRol, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(btnBuscaRol, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(lbltipo)))
                                    .addContainerGap(32, Short.MAX_VALUE))
                                .addComponent(jpanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            );
                            personal_rolLayout.setVerticalGroup(
                                personal_rolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, personal_rolLayout.createSequentialGroup()
                                    .addComponent(jpanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(personal_rolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(personal_rolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtBuscarRol, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnBuscaRol, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, personal_rolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(cbxBuscarRol, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel9)))
                                        .addComponent(lbltipo))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(47, Short.MAX_VALUE))
                            );

                            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                            setTitle("SISGESH .::. Análisis Examen");
                            setPreferredSize(new java.awt.Dimension(1067, 665));

                            jpanel.setBackground(new java.awt.Color(2, 67, 115));

                            titulo5.setBackground(new java.awt.Color(0, 102, 102));
                            titulo5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
                            titulo5.setForeground(new java.awt.Color(255, 255, 255));
                            titulo5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                            titulo5.setText("Exámenes Realizados");
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
                                    .addComponent(titulo5, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(568, 568, 568)
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
                                    .addContainerGap(40, Short.MAX_VALUE))
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

                            tb_Resultado.setModel(new javax.swing.table.DefaultTableModel(
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
                            tb_Resultado.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
                            tb_Resultado.setRowHeight(24);
                            tb_Resultado.setSelectionBackground(new java.awt.Color(2, 67, 115));
                            tb_Resultado.getTableHeader().setReorderingAllowed(false);
                            tb_Resultado.addMouseListener(new java.awt.event.MouseAdapter() {
                                public void mouseClicked(java.awt.event.MouseEvent evt) {
                                    tb_ResultadoMouseClicked(evt);
                                }
                                public void mouseReleased(java.awt.event.MouseEvent evt) {
                                    tb_ResultadoMouseReleased(evt);
                                }
                            });
                            tb_Resultado.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
                                public void propertyChange(java.beans.PropertyChangeEvent evt) {
                                    tb_ResultadoPropertyChange(evt);
                                }
                            });
                            tb_Resultado.addKeyListener(new java.awt.event.KeyAdapter() {
                                public void keyPressed(java.awt.event.KeyEvent evt) {
                                    tb_ResultadoKeyPressed(evt);
                                }
                                public void keyTyped(java.awt.event.KeyEvent evt) {
                                    tb_ResultadoKeyTyped(evt);
                                }
                            });
                            jScrollPane5.setViewportView(tb_Resultado);
                            if (tb_Resultado.getColumnModel().getColumnCount() > 0) {
                                tb_Resultado.getColumnModel().getColumn(13).setResizable(false);
                                tb_Resultado.getColumnModel().getColumn(14).setResizable(false);
                            }

                            lblServicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                            lblServicio.setText("servicio");

                            lblArea.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                            lblArea.setText("area");

                            chPacientes.setText("Todos los Pacientes");
                            chPacientes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                            chPacientes.addItemListener(new java.awt.event.ItemListener() {
                                public void itemStateChanged(java.awt.event.ItemEvent evt) {
                                    chPacientesItemStateChanged(evt);
                                }
                            });

                            txtPacientes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
                            txtPacientes.setForeground(new java.awt.Color(0, 51, 51));
                            txtPacientes.addActionListener(new java.awt.event.ActionListener() {
                                public void actionPerformed(java.awt.event.ActionEvent evt) {
                                    txtPacientesActionPerformed(evt);
                                }
                            });
                            txtPacientes.addKeyListener(new java.awt.event.KeyAdapter() {
                                public void keyPressed(java.awt.event.KeyEvent evt) {
                                    txtPacientesKeyPressed(evt);
                                }
                            });

                            btnPacientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/Search-16.png"))); // NOI18N
                            btnPacientes.setBorder(null);
                            btnPacientes.addActionListener(new java.awt.event.ActionListener() {
                                public void actionPerformed(java.awt.event.ActionEvent evt) {
                                    btnPacientesActionPerformed(evt);
                                }
                            });

                            chAnalisis.setText("Todos los Análisis");
                            chAnalisis.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                            chAnalisis.addItemListener(new java.awt.event.ItemListener() {
                                public void itemStateChanged(java.awt.event.ItemEvent evt) {
                                    chAnalisisItemStateChanged(evt);
                                }
                            });

                            txtAnalisis.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
                            txtAnalisis.setForeground(new java.awt.Color(0, 51, 51));
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

                            chPersonal.setText("Todo el Personal");
                            chPersonal.setHideActionText(true);
                            chPersonal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                            chPersonal.addItemListener(new java.awt.event.ItemListener() {
                                public void itemStateChanged(java.awt.event.ItemEvent evt) {
                                    chPersonalItemStateChanged(evt);
                                }
                            });

                            txtPersonal.setForeground(new java.awt.Color(0, 51, 51));
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

                            chActoMedico.setText("Todos los Actos Médicos");
                            chActoMedico.setHideActionText(true);
                            chActoMedico.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                            chActoMedico.addItemListener(new java.awt.event.ItemListener() {
                                public void itemStateChanged(java.awt.event.ItemEvent evt) {
                                    chActoMedicoItemStateChanged(evt);
                                }
                            });

                            txtActoM.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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
                                        .addComponent(chPersonal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                                        .addComponent(chAnalisis, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                                        .addComponent(chPacientes, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
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

                            dateHasta.setDateFormatString("dd-MM-yyyy");

                            jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                            jLabel20.setText("Hasta");

                            jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                            jLabel21.setText("Búsqueda por:");

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

                            jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                            jLabel19.setText("Desde");

                            lbldia.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
                            lbldia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                            lbldia.setText("Exámenes con Toma de Muestras del Día");

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
                                    .addComponent(jpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(11, 11, 11)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(dateDesde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            fila[0]=String.valueOf(c)+"°";
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
                    if(lblEstado.getText().equalsIgnoreCase("B")){
                        txtPacientes.setText(tb_HC.getValueAt(filaselec, 1).toString());
                    }else{
                        txtPacienteRecep.setText(tb_HC.getValueAt(filaselec, 2).toString());
                        lblid_hc.setText(tb_HC.getValueAt(filaselec, 8).toString());
                    }
                
                
            }
            catch(Exception ex)
            {
                System.out.println("Error: " + ex.getMessage());
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_HCKeyPressed

    private void tb_ResultadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_ResultadoMouseClicked

    }//GEN-LAST:event_tb_ResultadoMouseClicked

    private void tb_ResultadoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_ResultadoMouseReleased
 
    }//GEN-LAST:event_tb_ResultadoMouseReleased

    private void tb_ResultadoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tb_ResultadoPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_ResultadoPropertyChange

    private void tb_ResultadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_ResultadoKeyTyped

    }//GEN-LAST:event_tb_ResultadoKeyTyped

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
            tb_Resultado.setModel(new DefaultTableModel());
            String titulos[]={"cod_cab_resultado_mu_ana","cod_exa_ana","id_hc","Servicio/Área","Código CPT",
                "Nomenclatura" ,"Análisis Examen","N° de H.C.","Datos del Paciente",
                "DNI","Fecha de Nacimiento","Edad","Sexo","Acto Médico","N° de TM","Forma de Pago"
                ,"Fecha Orden","Hora Orden","Personal Solicita","Serv-Hosp","Habitacion","Cama",
                "N° de Resultado","Personal Resultado","Personal Registra Resultado",
                "Fecha Resultado","Hora Resultado","id_cod_doc_det"};
            m=new DefaultTableModel(null,titulos);
            JTable p=new JTable(m);
//            m=(DefaultTableModel)tb_TomasRealizadas.getModel(); Cuando se va agregando
            String fila[]=new String[30];

            LAB_Analisis_Examen obj=new LAB_Analisis_Examen();
                    consulta="exec sp_LAB_ENTREGA_RESULTADO_buscar ?,?,?,?,?";
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
                fila[27]=r.getString(28);
                m.addRow(fila);
                c++;
            }
            tb_Resultado.setModel(m);
            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m);
            tb_Resultado.setRowSorter(elQueOrdena);
            this.tb_Resultado.setModel(m);
            
            formato();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
}
    private void tb_ResultadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_ResultadoKeyPressed
        // TODO add your handling code here:
        char tecla= evt.getKeyChar();
                if(tecla==KeyEvent.VK_ENTER){  
                    try{
                        if( tb_Resultado.getRowCount()>0){
                        int filaselec=tb_Resultado.getSelectedRow();
                        
                      entregaResultado.setVisible(true);
                    
                      
                    //codigos
//                    frm_LAB_RESULTADO_MUESTRA.lblcod_cab_toma.setText(tb_Resultado.getValueAt(filaselec, 0).toString());
//                    frm_LAB_RESULTADO_MUESTRA.lblcod_det_toma.setText(tb_Resultado.getValueAt(filaselec, 1).toString());
//                    frm_LAB_RESULTADO_MUESTRA.lblcod_exa_ana.setText(tb_Resultado.getValueAt(filaselec, 2).toString());
//                    frm_LAB_RESULTADO_MUESTRA.lblid_cod_doc_det.setText(tb_Resultado.getValueAt(filaselec, 25).toString());
                   
                    //Datos del Paciente
                    txtHc.setText(tb_Resultado.getValueAt(filaselec, 7).toString());
                    txtPacientes2.setText(tb_Resultado.getValueAt(filaselec, 8).toString());
                    txtDni.setText(tb_Resultado.getValueAt(filaselec, 9).toString());
                    txtFecha.setText(tb_Resultado.getValueAt(filaselec, 10).toString());
                    txtEdad.setText(tb_Resultado.getValueAt(filaselec, 11).toString());
                    txtSexo.setText(tb_Resultado.getValueAt(filaselec, 12).toString());
                    //Toma de Muestra
                    txtActoMedico.setText(tb_Resultado.getValueAt(filaselec, 13).toString());
                    txtFormaPago.setText(tb_Resultado.getValueAt(filaselec, 15).toString());
                    txtNToma.setText(tb_Resultado.getValueAt(filaselec, 14).toString());
                    txtFechaOrden.setText(tb_Resultado.getValueAt(filaselec, 16).toString());
                    txtHoraOrden.setText(tb_Resultado.getValueAt(filaselec, 17).toString());
                    
                    if(tb_Resultado.getValueAt(filaselec,18).toString().isEmpty()){
                    txtPersonalSolicita.setText("--");
                    }else{
                    txtPersonalSolicita.setText(tb_Resultado.getValueAt(filaselec, 18).toString());
                        
                    }
                    if(tb_Resultado.getValueAt(filaselec,19).toString().isEmpty()){
                    txthospiServ.setText("--");
                    txtPiso.setText("--");
                    txtCama.setText("--");
                    }else{
                        txthospiServ.setText(tb_Resultado.getValueAt(filaselec,19).toString());
                       txtPiso.setText(tb_Resultado.getValueAt(filaselec, 20).toString());
                    txtCama.setText(tb_Resultado.getValueAt(filaselec, 21).toString()); 
                    }
                    
                    //Resultado
                    txtPersonalResponR.setText(tb_Resultado.getValueAt(filaselec, 23).toString());
                    txtPersonalRegistraR.setText(tb_Resultado.getValueAt(filaselec, 24).toString());
                    lblFecha1.setText(tb_Resultado.getValueAt(filaselec, 25).toString());
                    lblHora1.setText(tb_Resultado.getValueAt(filaselec, 26).toString());
                    
                    lblCod_cab_resul.setText(tb_Resultado.getValueAt(filaselec, 0).toString());
                    //Servicio
                    txtServArea.setText(tb_Resultado.getValueAt(filaselec, 3).toString());
                    txtCPT.setText(tb_Resultado.getValueAt(filaselec, 4).toString());
                    txtNomenclatura.setText(tb_Resultado.getValueAt(filaselec, 6).toString());
                    
                  
                       }        
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "ingreso "+e.getMessage());
        }
        }
    }//GEN-LAST:event_tb_ResultadoKeyPressed

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
            
    private void btnPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPacientesActionPerformed
        buscar_HC.setVisible(true);
        txtbuscarHC.setText("");
        LAB_HC_cargar();
        LAB_HC_formato();
        lblEstado.setText("B");
    }//GEN-LAST:event_btnPacientesActionPerformed

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

    private void btnAnalisisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalisisActionPerformed
                 analisis.setVisible(true);
                    txtBuscarAnalisis.setText("");
                    Analisis_cargar();
                    Analisis_formato();
               
    }//GEN-LAST:event_btnAnalisisActionPerformed

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

    private void btnPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPersonalActionPerformed
       
                    personal.setVisible(true);
                    txtBuscarPersonal.setText("");
                    Personal_cargar();
                    Personal_formato();
               
    }//GEN-LAST:event_btnPersonalActionPerformed

    private void cbxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxKeyPressed

    private void txtPacientesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPacientesKeyPressed
        char tecla= evt.getKeyChar();
                if(tecla==KeyEvent.VK_ENTER){
                    btnPacientes.doClick();
                }
    }//GEN-LAST:event_txtPacientesKeyPressed

    private void txtAnalisisKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnalisisKeyPressed
         char tecla= evt.getKeyChar();
                if(tecla==KeyEvent.VK_ENTER){
                    btnAnalisis.doClick();
                }
    }//GEN-LAST:event_txtAnalisisKeyPressed

    private void txtPersonalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPersonalKeyPressed
        char tecla= evt.getKeyChar();
                if(tecla==KeyEvent.VK_ENTER){
                    btnPersonal.doClick();
                }
    }//GEN-LAST:event_txtPersonalKeyPressed

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
            String titulos[]={"Nº","Código","Apellido Paterno","Apellido Materno","Nombres","Cargo","Servicio","Área"};
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
            String titulos[]={"N�","C�digo","C�digo CPT","An�lisis","Servicio","�rea"};
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
                fila[0]=String.valueOf(c)+"�";
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

    private void txtPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPacientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPacientesActionPerformed

    private void txtNomenclaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomenclaturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomenclaturaActionPerformed

    private void txtNomenclaturaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomenclaturaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomenclaturaKeyPressed

    private void txtNomenclaturaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomenclaturaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomenclaturaKeyReleased

    private void txtCPTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCPTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCPTActionPerformed

    private void txtCPTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCPTKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCPTKeyPressed

    private void txtCPTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCPTKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCPTKeyReleased

    private void txtServAreaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtServAreaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtServAreaKeyPressed

    private void txtServAreaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtServAreaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtServAreaKeyReleased

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

    private void txtPersonalResponRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPersonalResponRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPersonalResponRActionPerformed

    private void txtPersonalResponRKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPersonalResponRKeyPressed
     
    }//GEN-LAST:event_txtPersonalResponRKeyPressed

    private void txtPersonalResponRKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPersonalResponRKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPersonalResponRKeyReleased

    private void txtPersonalRegistraRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPersonalRegistraRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPersonalRegistraRActionPerformed

    private void txtPersonalRegistraRKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPersonalRegistraRKeyPressed
       
    }//GEN-LAST:event_txtPersonalRegistraRKeyPressed

    private void txtPersonalRegistraRKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPersonalRegistraRKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPersonalRegistraRKeyReleased

    private void txtFormaPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFormaPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFormaPagoActionPerformed

    private void txtFormaPagoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFormaPagoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFormaPagoKeyPressed

    private void txtFormaPagoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFormaPagoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFormaPagoKeyReleased

    private void txtNTomaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNTomaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNTomaKeyPressed

    private void txtNTomaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNTomaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNTomaKeyReleased

    private void txtPersonalSolicitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPersonalSolicitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPersonalSolicitaActionPerformed

    private void txtPersonalSolicitaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPersonalSolicitaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPersonalSolicitaKeyPressed

    private void txtPersonalSolicitaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPersonalSolicitaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPersonalSolicitaKeyReleased

    private void txtPisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPisoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPisoActionPerformed

    private void txtPisoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPisoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPisoKeyPressed

    private void txtPisoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPisoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPisoKeyReleased

    private void txtCamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCamaActionPerformed

    private void txtCamaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCamaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCamaKeyPressed

    private void txtCamaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCamaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCamaKeyReleased

    private void txtFechaOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaOrdenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaOrdenActionPerformed

    private void txtFechaOrdenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaOrdenKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaOrdenKeyPressed

    private void txtFechaOrdenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaOrdenKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaOrdenKeyReleased

    private void txtHoraOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoraOrdenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoraOrdenActionPerformed

    private void txtHoraOrdenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHoraOrdenKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoraOrdenKeyPressed

    private void txtHoraOrdenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHoraOrdenKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoraOrdenKeyReleased

    private void txthospiServActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthospiServActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthospiServActionPerformed

    private void txthospiServKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txthospiServKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthospiServKeyPressed

    private void txthospiServKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txthospiServKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txthospiServKeyReleased

    private void spHoraStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spHoraStateChanged

    }//GEN-LAST:event_spHoraStateChanged

    private void spMinStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spMinStateChanged

    }//GEN-LAST:event_spMinStateChanged

    private void spMinPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_spMinPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_spMinPropertyChange

    private void txtPersonalEntregKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPersonalEntregKeyPressed
               char tecla= evt.getKeyChar();
                if(tecla==KeyEvent.VK_ENTER){
                    personal_rol.setVisible(true);
                    PersonalRol_cargar();
                    PersonalRol_formato();
                    txtBuscarRol.setText("");
                    lbltipo.setText("1");
                    cbxBuscarRol.setSelectedIndex(0);
                }
    }//GEN-LAST:event_txtPersonalEntregKeyPressed

    private void txtPacienteRecepKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPacienteRecepKeyPressed
  char tecla= evt.getKeyChar();
                if(tecla==KeyEvent.VK_ENTER){
             buscar_HC.setVisible(true);
//             titulo8.setVisible(true);
            txtbuscarHC.setText("");
            LAB_HC_cargar();
            LAB_HC_formato();
            lblEstado.setText("R");
                }
    }//GEN-LAST:event_txtPacienteRecepKeyPressed

    private void jRadioButton2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton2ItemStateChanged
        
        txtPersonalRecep.setEnabled(false);
        
        txtPacienteRecep.setEnabled(true);
        lblar_idRecep.setText("");
        lblid_hc.setText("");
        txtServRecep.setText("");
        txtAreaRecep.setText("");
        lblcodPerRecep.setText("");
        txtPersonalRecep.setText("");
    }//GEN-LAST:event_jRadioButton2ItemStateChanged

    private void rbPersonalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbPersonalItemStateChanged
        txtPersonalRecep.setEnabled(true);
        
        txtPacienteRecep.setEnabled(false);
        lblid_hc.setText("");
        txtPacienteRecep.setText("");
    }//GEN-LAST:event_rbPersonalItemStateChanged

    private void txtBuscarRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarRolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarRolActionPerformed

    private void txtBuscarRolKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarRolKeyPressed
        char tecla= evt.getKeyChar();
        if(tecla==KeyEvent.VK_ENTER){
            btnBuscaRol.doClick();
        }
    }//GEN-LAST:event_txtBuscarRolKeyPressed

    private void txtBuscarRolKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarRolKeyTyped

    }//GEN-LAST:event_txtBuscarRolKeyTyped

    private void btnBuscaRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaRolActionPerformed
        // TODO add your handling code here:
        try {
            String tipo="",serArea="",buscar="";
            buscar=txtBuscarRol.getText();

            if(lblArea.getText().equalsIgnoreCase("") && cbxBuscarRol.getSelectedIndex()==1){
                tipo="3";
                serArea=lblServicio.getText();
            }else if(lblArea.getText().equalsIgnoreCase("") && cbxBuscarRol.getSelectedIndex()==2){
                tipo="4";
                serArea=lblServicio.getText();

            }else if(lblArea.getText().length()>0 && cbxBuscarRol.getSelectedIndex()==1){
                
                tipo="5";
                serArea=lblArea.getText();
            }else if(lblArea.getText().length()>0 && cbxBuscarRol.getSelectedIndex()==2){
                tipo="6";
                serArea=lblArea.getText();
            }
            String titulos[]={"N°","Código","Apellido Paterno","Apellido Materno","Nombres","Cargo","Servicio","Área","Codigo"};
            m=new DefaultTableModel(null,titulos);
            JTable p=new JTable(m);
            String fila[]=new String[9];
            LAB_Toma_Muestra_Cabecera obj=new LAB_Toma_Muestra_Cabecera();

            String consulta="exec sp_PERSONAL_ROL ?,?,?";
            PreparedStatement cmd = obj.getCn().prepareStatement(consulta);
            cmd.setString(1, buscar);
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
                fila[6]=r.getString(6);
                fila[7]=r.getString(7);
                fila[8]=r.getString(8);
                m.addRow(fila);
                c++;
            }
            tbPersonalRol.setModel(m);
            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m);
            tbPersonalRol.setRowSorter(elQueOrdena);
            this.tbPersonalRol.setModel(m);
            PersonalRol_formato();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }//GEN-LAST:event_btnBuscaRolActionPerformed

    private void tbPersonalRolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPersonalRolMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbPersonalRolMouseClicked

    private void tbPersonalRolKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbPersonalRolKeyPressed
        // TODO add your handling code here:
        char tecla= evt.getKeyChar();
        if(tecla==KeyEvent.VK_ENTER){
            try{
                 if( tbPersonalRol.getRowCount()>0){
                if(lbltipo.getText().equalsIgnoreCase("1")){
                    personal_rol.setVisible(false);
                    int filaselec=tbPersonalRol.getSelectedRow();
                    String nombreCompleto=tbPersonalRol.getValueAt(filaselec, 2).toString()+" "+
                    tbPersonalRol.getValueAt(filaselec, 3).toString()
                    +" "+tbPersonalRol.getValueAt(filaselec, 4).toString();
                    txtPersonalEntreg.setText(nombreCompleto);
                    lblCodPerEntrega.setText(tbPersonalRol.getValueAt(filaselec, 1).toString());
                }
                else if(lbltipo.getText().equalsIgnoreCase("2")){
                    personal_rol.setVisible(false);
                    int filaselec=tbPersonalRol.getSelectedRow();
                    String nombreCompleto=tbPersonalRol.getValueAt(filaselec, 2).toString()+" "+
                    tbPersonalRol.getValueAt(filaselec, 3).toString()
                    +" "+tbPersonalRol.getValueAt(filaselec, 4).toString();
                    txtPersonalRecep.setText(nombreCompleto);
                    lblcodPerRecep.setText(tbPersonalRol.getValueAt(filaselec, 1).toString());
                    
                    lblar_idRecep.setText(tbPersonalRol.getValueAt(filaselec, 8).toString());
                    txtAreaRecep.setText(tbPersonalRol.getValueAt(filaselec, 7).toString());
                    txtServRecep.setText(tbPersonalRol.getValueAt(filaselec, 6).toString());
                }
            }}
            catch(Exception ex)
            {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_tbPersonalRolKeyPressed

    private void tbPersonalRolKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbPersonalRolKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tbPersonalRolKeyTyped

    private void cbxBuscarRolItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxBuscarRolItemStateChanged
        // TODO add your handling code here:
        try
        {
            if(evt.getStateChange()==ItemEvent.SELECTED){
                if(cbxBuscarRol.getSelectedIndex()>0){
                    txtBuscarRol.setEnabled(true);
                    btnBuscaRol.setEnabled(true);
                }

            }
            else{
                txtBuscarRol.setEnabled(false);
                btnBuscaRol.setEnabled(false);
            }}
            catch(Exception ex)
            {
                System.out.println("Error: " + ex.getMessage());
            }
    }//GEN-LAST:event_cbxBuscarRolItemStateChanged

    private void txtPersonalRecepKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPersonalRecepKeyPressed
               char tecla= evt.getKeyChar();
                if(tecla==KeyEvent.VK_ENTER){
                    personal_rol.setVisible(true);
                    PersonalRol_cargar();
                    PersonalRol_formato();
                    txtBuscarRol.setText("");
                    lbltipo.setText("2");
                    cbxBuscarRol.setSelectedIndex(0);
                }
    }//GEN-LAST:event_txtPersonalRecepKeyPressed

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        ImageIcon i=new ImageIcon(this.getClass().getResource("/imagenes/iconos/guardar16x16.png"));
      
        try{
            if(date.getDate()==null){
                JOptionPane.showMessageDialog(entregaResultado, "Seleccione la Fecha de Entrega del Examen");
            }else if(spHora.getValue().equals(0) && spMin.getValue().equals(0)){
                JOptionPane.showMessageDialog(entregaResultado, "Ingrese la Hora de Entrega del Examen");
            }else if(lblCodPerEntrega.getText().equalsIgnoreCase("")||txtPersonalEntreg.getText().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(entregaResultado, "Seleccione un Personal Responsable "
                        + "de la Entrega del Resultado");
            } else if(lblcodPerRecep.getText().equalsIgnoreCase("")&&
                txtPersonalRecep.getText().equalsIgnoreCase("")&&lblid_hc.getText().equalsIgnoreCase("")&&
                    txtPacienteRecep.getText().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(entregaResultado, "Registre al Usuario que Recepcionará el Resultado");
            }else {
              
                    int guardar = JOptionPane.showConfirmDialog(entregaResultado, "¿Está seguro que desea GUARDAR los datos?",
                        "Atención", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,i);
                    if(guardar ==0){
                        LAB_Entrega_Resultado meGuardar = new LAB_Entrega_Resultado();

                        LAB_Entrega_Resultado id=new LAB_Entrega_Resultado();
                        String cod="";
                        cod=id.LAB_Entrega_Resultado_generarid();
                        if(cod.equalsIgnoreCase("")){
                            cod="ER000000000000000001";
                        }
                        meGuardar.setCod_entrega_resul_exa(cod);
                        meGuardar.setCod_cab_resultado_mu_ana(lblCod_cab_resul.getText());
                        meGuardar.setCod_per_entrega(lblCodPerEntrega.getText());
                        meGuardar.setNombre_per_entrega(txtPersonalEntreg.getText());
                        if(rbPersonal.isSelected()){
                            meGuardar.setTipo_per_recepcion("I");
                            meGuardar.setCod_per_recepcion(lblcodPerRecep.getText());
                            meGuardar.setNombre_per_recepcion(txtPersonalRecep.getText());
                            meGuardar.setAr_id(lblar_idRecep.getText());
                            meGuardar.setAr_desc(txtAreaRecep.getText());
                            meGuardar.setId_hc("");
                            meGuardar.setPaciente_hc("");
                        }else{
                            meGuardar.setTipo_per_recepcion("E");
                            meGuardar.setCod_per_recepcion("");
                            meGuardar.setNombre_per_recepcion("");
                            meGuardar.setAr_id("");
                            meGuardar.setAr_desc("");
                            meGuardar.setId_hc(lblid_hc.getText());
                            meGuardar.setPaciente_hc(txtPacienteRecep.getText());
                        }
                    int dia,mes,anio;
                    dia = date.getCalendar().get(Calendar.DAY_OF_MONTH);
                    mes = date.getCalendar().get(Calendar.MONTH) + 1;
                     anio = date.getCalendar().get(Calendar.YEAR);
        
                     DecimalFormat df = new DecimalFormat("00");
                     String fecha=df.format(dia)+"/"+df.format(mes)+"/"+anio;
        
                        meGuardar.setFecha_entrega_exa(fecha);
                        meGuardar.setHora_entrega_exa(df.format(spHora.getValue())+":"+df.format(spMin.getValue())+":00");
                        meGuardar.setNom_usu(lblUsu.getText());

                        if(meGuardar.LAB_Entrega_Resultado_guardar()){
                            LAB_Entrega_Resultado es=new LAB_Entrega_Resultado();
                            es.LAB_Entrega_Resultado_Estado( lblCod_cab_resul.getText());

                            JOptionPane.showMessageDialog(entregaResultado, "Datos Guardados");
                            limpiar();
                           
                            entregaResultado.setVisible(false);
                            
                        }
                        else{
                            JOptionPane.showMessageDialog(entregaResultado, "El Registro ya ha sido ingresado\nIntente nuevamente");
                        }}}
                    }catch(Exception e) {
                        JOptionPane.showMessageDialog(entregaResultado, e.getMessage());
                    }
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       entregaResultado.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed
    public void enableDatos(){
    tb_Resultado.setEnabled(true);
    tb_Resultado.setBackground(Color.white);
}
    public void limpiar(){
   LAB_BUSCAR_TM_DIA();
     lbldia.setText("Exámenes con Toma de Muestras del Día");
//   DefaultTableModel modelo = (DefaultTableModel)tb_Resultado.getModel(); 
//   int filas=tb_Resultado.getRowCount();
//   for(int i=0;i<filas;i++){
//                    modelo.removeRow(0);
//   }
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
            java.util.logging.Logger.getLogger(frm_LAB_ENTREGA_RESULTADO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_LAB_ENTREGA_RESULTADO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_LAB_ENTREGA_RESULTADO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_LAB_ENTREGA_RESULTADO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new frm_LAB_ENTREGA_RESULTADO().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog analisis;
    public static javax.swing.JButton btnAnalisis;
    private javax.swing.JButton btnBuscaRol;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JButton btnBuscarAnalisis;
    private javax.swing.JButton btnBuscarPersonal;
    private javax.swing.JButton btnGenerar;
    public static javax.swing.JButton btnPacientes;
    public static javax.swing.JButton btnPersonal;
    private javax.swing.JDialog buscar_HC;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbx;
    private javax.swing.JComboBox cbxBuscarAnalisis;
    private javax.swing.JComboBox cbxBuscarPersonal;
    private javax.swing.JComboBox cbxBuscarRol;
    private javax.swing.JCheckBox chActoMedico;
    private javax.swing.JCheckBox chAnalisis;
    private javax.swing.JCheckBox chPacientes;
    private javax.swing.JCheckBox chPersonal;
    private com.toedter.calendar.JDateChooser date;
    private com.toedter.calendar.JDateChooser dateDesde;
    private com.toedter.calendar.JDateChooser dateHasta;
    private javax.swing.JDialog entregaResultado;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPanel jpanel;
    private javax.swing.JPanel jpanel1;
    private javax.swing.JPanel jpanel2;
    private javax.swing.JPanel jpanel3;
    private javax.swing.JPanel jpanel4;
    private javax.swing.JPanel jpanel5;
    private javax.swing.JLabel lblArea;
    private javax.swing.JLabel lblCodPerEntrega;
    private javax.swing.JLabel lblCod_cab_resul;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblFecha1;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblHora1;
    private javax.swing.JLabel lblServicio;
    public static javax.swing.JLabel lblUsu;
    private javax.swing.JLabel lblar_idRecep;
    private javax.swing.JLabel lblcodPerRecep;
    private javax.swing.JLabel lbldia;
    private javax.swing.JLabel lblid_hc;
    private javax.swing.JLabel lbltipo;
    private javax.swing.JPanel panelAnalisis;
    private javax.swing.JPanel panelEntrega;
    private javax.swing.JPanel panelPaciente;
    private javax.swing.JPanel panelPacientes;
    private javax.swing.JPanel panelRecepcion;
    private javax.swing.JPanel panelResultado;
    private javax.swing.JPanel panelTM;
    private javax.swing.JDialog personal;
    private javax.swing.JDialog personal_rol;
    private javax.swing.JRadioButton rbPersonal;
    public static javax.swing.JSpinner spHora;
    public static javax.swing.JSpinner spMin;
    public static javax.swing.JTable tbPersonal;
    public static javax.swing.JTable tbPersonalRol;
    private javax.swing.JTable tb_Analisis;
    public static javax.swing.JTable tb_HC;
    public static javax.swing.JTable tb_Resultado;
    private javax.swing.JLabel titulo10;
    private javax.swing.JLabel titulo5;
    private javax.swing.JLabel titulo6;
    private javax.swing.JLabel titulo7;
    private javax.swing.JLabel titulo8;
    private javax.swing.JLabel titulo9;
    public static javax.swing.JTextField txtActoM;
    public static javax.swing.JTextField txtActoMedico;
    public static javax.swing.JTextField txtAnalisis;
    private javax.swing.JTextField txtAreaRecep;
    private javax.swing.JTextField txtBuscarAnalisis;
    private javax.swing.JTextField txtBuscarPersonal;
    private javax.swing.JTextField txtBuscarRol;
    public static javax.swing.JTextField txtCPT;
    public static javax.swing.JTextField txtCama;
    public static javax.swing.JTextField txtDni;
    public static javax.swing.JTextField txtEdad;
    public static javax.swing.JTextField txtFecha;
    public static javax.swing.JTextField txtFechaOrden;
    public static javax.swing.JTextField txtFormaPago;
    public static javax.swing.JTextField txtHc;
    public static javax.swing.JTextField txtHoraOrden;
    public static javax.swing.JTextField txtNToma;
    public static javax.swing.JTextField txtNomenclatura;
    public static javax.swing.JTextField txtPacienteRecep;
    public static javax.swing.JTextField txtPacientes;
    public static javax.swing.JTextField txtPacientes2;
    public static javax.swing.JTextField txtPersonal;
    public static javax.swing.JTextField txtPersonalEntreg;
    private javax.swing.JTextField txtPersonalRecep;
    private javax.swing.JTextField txtPersonalRegistraR;
    private javax.swing.JTextField txtPersonalResponR;
    public static javax.swing.JTextField txtPersonalSolicita;
    public static javax.swing.JTextField txtPiso;
    public static javax.swing.JTextField txtServArea;
    private javax.swing.JTextField txtServRecep;
    public static javax.swing.JTextField txtSexo;
    private javax.swing.JTextField txtbuscarHC;
    public static javax.swing.JTextField txthospiServ;
    // End of variables declaration//GEN-END:variables
}