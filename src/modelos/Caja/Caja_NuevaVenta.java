/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.Caja;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.AttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.HashPrintServiceAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaPrintableArea;
import javax.print.attribute.standard.MediaSize;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.PrinterName;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;
import net.sf.jasperreports.view.JasperViewer;
import servicios.Conexion;
import vista.Caja.Caja_Cierre;
import vista.Caja.Caja_Pagos;
import static vista.Caja.Caja_Pagos.lblTotalDiario;
import vista.Caja.Caja_Reporte_CCTA6;
import vista.Caja.Caja_Reporte_Fechas;
import vista.Caja.Caja_Reportes;
/**
 *
 * @author MYS1
 */
public class Caja_NuevaVenta {
DefaultTableModel m;
private Connection cn;
///////////////////////////////////////////////////////
private String id_documento ;
private String cod_tipo_documento ;
private String cod_jerar_forma_pago ;
private String id_hc ;
private String cod_motiv_anu ;
private String serie_documento ;
private String num_documento ;//////////////VENTA NUEVA
private String dependencia ;
private String cod_usu ;
private String id_liquidacion ;
private int Correlativo ;
private int Id_ActoMedico ;
private int id_Cta_Abono ;
private Double devolucion_doc;
private String cod_usu_anu;
//////////////////////////////////////////////////////
private int ID_ACTOMEDICO1 ;
private int NUM_ACTOMEDICO ;//////////////ACTO MEDICO
private String FECHA_TERMINO ;
private String DURACION ;
private int CA_ID;
private int CONTADOR_CITAS; 
private int CITAS_CAJA ;
private String ESTADOP;
private String cod_empre_jerar;
private String Usu_Exoneracion ;
private String porcentaje_Exoneracion ;
private double DESCUENTO;
private double TOTAL_DOCUUMENTO;
private int IdDetalle;
private int dni;
private String EstadoVisibleAdmision;
private int Id_Cod_det;
private int ID_SESION;
private String FUA;
private double IGV;
private double SUBTOTAL;
private double REDONDEO;    
private String CODRENAESREFE;
private String NUMREF;
//////////////////////////
private String APE_PAT;
private String APE_MAT;
private String NOMBRES;
private String DIRECCION;
private String DPTO;
private String PROV;
private String DIST;
private String FECHA_NAC;
private String DNI_A;

    public String getCODRENAESREFE() {
        return CODRENAESREFE;
    }

    public String getNUMREF() {
        return NUMREF;
    }

    public void setNUMREF(String NUMREF) {
        this.NUMREF = NUMREF;
    }

    public void setCODRENAESREFE(String CODRENAESREFE) {
        this.CODRENAESREFE = CODRENAESREFE;
    }

    public String getAPE_PAT() {
        return APE_PAT;
    }

    public void setAPE_PAT(String APE_PAT) {
        this.APE_PAT = APE_PAT;
    }

    public String getAPE_MAT() {
        return APE_MAT;
    }

    public void setAPE_MAT(String APE_MAT) {
        this.APE_MAT = APE_MAT;
    }

    public String getNOMBRES() {
        return NOMBRES;
    }

    public void setNOMBRES(String NOMBRES) {
        this.NOMBRES = NOMBRES;
    }

    public String getDIRECCION() {
        return DIRECCION;
    }

    public void setDIRECCION(String DIRECCION) {
        this.DIRECCION = DIRECCION;
    }

    public String getDPTO() {
        return DPTO;
    }

    public void setDPTO(String DPTO) {
        this.DPTO = DPTO;
    }

    public String getPROV() {
        return PROV;
    }

    public void setPROV(String PROV) {
        this.PROV = PROV;
    }

    public String getDIST() {
        return DIST;
    }

    public void setDIST(String DIST) {
        this.DIST = DIST;
    }

    public String getFECHA_NAC() {
        return FECHA_NAC;
    }

    public void setFECHA_NAC(String FECHA_NAC) {
        this.FECHA_NAC = FECHA_NAC;
    }

    public String getDNI_A() {
        return DNI_A;
    }

    public void setDNI_A(String DNI_A) {
        this.DNI_A = DNI_A;
    }
    
    
////////////////////////////////////////////////////
Conexion con = new Conexion();

    public boolean ACTUALIZAR_HC(String opc)
        {
        boolean resp = false;
        try
        {
            String sql = "exec CAJA_ACTUALIZAR_HC ?,?,?,?,?,?,?,?,?,?";
            PreparedStatement cmd = getCn().prepareStatement(sql);
            cmd.setString(1, getAPE_PAT());
            cmd.setString(2, getAPE_MAT());
            cmd.setString(3, getNOMBRES());
            cmd.setString(4, getDIRECCION());
            cmd.setString(5, getDPTO());
            cmd.setString(6, getPROV());
            cmd.setString(7, getDIST());
            cmd.setString(8, getDNI_A());
            cmd.setString(9, getFECHA_NAC()); 
            cmd.setString(10, opc);
            if(!cmd.execute())
            {
                resp = true;
            }
            cmd.close();
            getCn().close();
        }
        catch(Exception ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }
        return resp;
    }
    
    
    
public void Caja_Correlativo(String usu){
        try {
            String consulta = "exec CAJA_SERIE_CORRELATIVO ?";
            PreparedStatement cmd = getCn().prepareStatement(consulta);
            cmd.setString(1, usu);
            ResultSet r= cmd.executeQuery();
        if(r.next()){
               Caja_Pagos.lblSerie.setText(r.getString(1));
               Caja_Pagos.lblNumDoc.setText(r.getString(2));
               Caja_Pagos.lblNumeroDoc.setText(r.getString(1)+"-"+r.getString(2));
        }
        }catch(Exception ex){
            System.out.println("Error al generar serie y numero " + ex.getMessage());
        }
    }


public void Caja_Correlativo_FARMACIA(String usu){
        try {
            String consulta = "exec CAJA_SERIE_CORRELATIVO_FARMACIA ?";
            PreparedStatement cmd = getCn().prepareStatement(consulta);
            cmd.setString(1, usu);
            ResultSet r= cmd.executeQuery();
        if(r.next()){
               Caja_Pagos.lblSerie.setText(r.getString(1));
//               Caja_Pagos.lblNumDoc.setText(r.getString(2));
//               Caja_Pagos.lblNumeroDoc.setText(r.getString(1)+"-"+r.getString(2));
        }
        }catch(Exception ex){
            System.out.println("Error al generar serie y numero " + ex.getMessage());
        }
    }

    public void CAJA_CANTIDAD_DIAS(String total){
        String consulta="";
        try {
            consulta="CAJA_DIAS_HOSPITALIZADOS ?";
            PreparedStatement cmd = getCn().prepareStatement(consulta);
            cmd.setString(1, total);
            ResultSet r= cmd.executeQuery();
            int c=1;
            while(r.next()){
                Caja_Pagos.lblCantidad.setText(r.getString(1));     
            }
            //
        } catch (Exception e) {
            System.out.println("Error AL CONTAR DIAS " + e.getMessage());
        }
    }
    

public void SumaTotalReporte(String total,Integer SESION){
        String consulta="";
        try {
            consulta="CAJA_RESUMEN_DIARIO_TOTAL ?,?";
            PreparedStatement cmd = getCn().prepareStatement(consulta);
            cmd.setString(1, total);
            cmd.setInt(2, SESION);
            ResultSet r= cmd.executeQuery();
            int c=1;
            while(r.next()){
                Caja_Pagos.lblTotalDiario.setText(r.getString(1));     
            }
            //
        } catch (Exception e) {
            System.out.println("Error: SUMA TOTAL  " + e.getMessage());
        }
    }

public void SumaCONTADOReporte(String contado,Integer SESION){
        String consulta="";
        try {
            consulta="CAJA_RESUMEN_DIARIO_TOTAL_CONTADO ?,?";
            PreparedStatement cmd = getCn().prepareStatement(consulta);
            cmd.setString(1, contado);
            cmd.setInt(2, SESION);
            ResultSet r= cmd.executeQuery();
            int c=1;
            while(r.next()){
                    
                Caja_Pagos.lblTotalContado.setText(r.getString(1));    
            }
            //
        } catch (Exception e) {
            System.out.println("Error: SUMA CONTADO  " + e.getMessage());
        }
    }
public void SumaCONTADOReporteCIERRE(String contado,Integer SESION){
        String consulta="";
        try {
            consulta="CAJA_RESUMEN_DIARIO_TOTAL_CONTADO ?,?";
            PreparedStatement cmd = getCn().prepareStatement(consulta);
            cmd.setString(1, contado);
            cmd.setInt(2, SESION);
            ResultSet r= cmd.executeQuery();
            int c=1;
            while(r.next()){
                    
                Caja_Cierre.lblVC.setText(r.getString(1));    
            }
            //
        } catch (Exception e) {
            System.out.println("Error: SUMA CONTADO  " + e.getMessage());
        }
    }

public void SumaPENDIENTEReporte(String pendiente, Integer SESION){
        String consulta="";
        try {
            consulta="CAJA_RESUMEN_DIARIO_TOTAL_PENDIENTE ?,?";
            PreparedStatement cmd = getCn().prepareStatement(consulta);
            cmd.setString(1, pendiente);
            cmd.setInt(2, SESION);
            ResultSet r= cmd.executeQuery();
            int c=1;
            while(r.next()){
                    
                Caja_Pagos.lblTotalPendiente.setText(r.getString(1));    
            }
            //
        } catch (Exception e) {
            System.out.println("Error: SUMA PENDIENTE  " + e.getMessage());
        }
    }
public void SumaPENDIENTEReporteCIERRE(String pendiente,Integer SESION){
        String consulta="";
        try {
            consulta="CAJA_RESUMEN_DIARIO_TOTAL_PENDIENTE ?,?";
            PreparedStatement cmd = getCn().prepareStatement(consulta);
            cmd.setString(1, pendiente);
            cmd.setInt(2, SESION);
            ResultSet r= cmd.executeQuery();
            int c=1;
            while(r.next()){
                    
                Caja_Cierre.lblVO.setText(r.getString(1));    
            }
            //
        } catch (Exception e) {
            System.out.println("Error: SUMA PENDIENTE  " + e.getMessage());
        }
    }
//public void SumaANULADOReporte(String anulado, Integer SESION){
//        String consulta="";
//        try {
//            consulta="CAJA_RESUMEN_DIARIO_TOTAL_ANULADO ?,?";
//            PreparedStatement cmd = getCn().prepareStatement(consulta);
//            cmd.setString(1, anulado);
//            cmd.setInt(2, SESION);
//            ResultSet r= cmd.executeQuery();
//            int c=1;
//            while(r.next()){
//                    
//                Caja_Pagos.lblTotalAnulado.setText(r.getString(1));    
//            }
//            //
//        } catch (Exception e) {
//            System.out.println("Error: SUMA ANULADO  " + e.getMessage());
//        }
//    }
public void SumaANULADOReporteCIERRE(String anulado, Integer SESION){
        String consulta="";
        try {
            consulta="CAJA_RESUMEN_DIARIO_TOTAL_ANULADO ?,?";
            PreparedStatement cmd = getCn().prepareStatement(consulta);
            cmd.setString(1, anulado);
            cmd.setInt(2, SESION);
            ResultSet r= cmd.executeQuery();
            int c=1;
            while(r.next()){
                    
                Caja_Cierre.lblVA.setText(r.getString(1));    
            }
            //
        } catch (Exception e) {
            System.out.println("Error: SUMA ANULADO  " + e.getMessage());
        }
    }
public void ReporteDiario(String USUARIO,Integer SESION) {
        try {
            Map parametros = new HashMap();
            parametros.put("USUARIO", USUARIO);
            parametros.put("SESION", SESION);
            JasperPrint informe = JasperFillManager.fillReport(getClass().getResourceAsStream("/Reportes/cajaCentral/ReporteDiario.jasper"), parametros, con.conectar()); 
            JasperViewer ventanavisor = new JasperViewer(informe, false);
            ventanavisor.setTitle("Reporte Diario");
           ventanavisor.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error_reporteDiario:"+e.getMessage());
        }
    }

    public void ReporteDiario_fua(String ID) {
        try {
            Map parametros = new HashMap();
            parametros.put("ID", ID);
            JasperPrint informe = JasperFillManager.fillReport(getClass().getResourceAsStream("/Reportes/cajaCentral/FUA.jasper"), parametros, con.conectar()); 
            JasperViewer ventanavisor = new JasperViewer(informe, false);
            ventanavisor.setTitle("FUA");
            ventanavisor.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error_reporteDiario:"+e.getMessage());
        }
    }

    public void FUA1(String ID) {
        try {
            Map parametros = new HashMap();
            parametros.put("ID", ID);
            JasperPrint informe = JasperFillManager.fillReport(getClass().getResourceAsStream("/Reportes/cajaCentral/FUA.jasper"), parametros, con.conectar()); 
            JasperViewer ventanavisor = new JasperViewer(informe, false);
            ventanavisor.setTitle("FUA");
            ventanavisor.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL IMPRIMIR FUA:"+e.getMessage());
        }
    }

    public void ReporteFechas(String USUARIO,int F1,int F2) {
        try {
            Map parametros = new HashMap();
            parametros.put("USUARIO", USUARIO);
            parametros.put("F1", F1);
            parametros.put("F2", F2);
            JasperPrint informe = JasperFillManager.fillReport(getClass().getResourceAsStream("/Reportes/cajaCentral/ReporteFechas.jasper"), parametros, con.conectar()); 
            JasperViewer ventanavisor = new JasperViewer(informe, false);
            ventanavisor.setTitle("Reporte");
            ventanavisor.setVisible(true);
        } catch (Exception e) {
            Caja_Reporte_Fechas.ErrorPrint.setUndecorated(true);
            Caja_Reporte_Fechas.ErrorPrint.setVisible(true);
        }
    }

    public void ReporteFechasCAJEROS(int F1,int F2) {
        try {
            Map parametros = new HashMap();
            parametros.put("F1", F1);
            parametros.put("F2", F2);
            JasperPrint informe = JasperFillManager.fillReport(getClass().getResourceAsStream("/Reportes/cajaCentral/Comportamiento.jasper"), parametros, con.conectar()); 
            JasperViewer ventanavisor = new JasperViewer(informe, false);
            ventanavisor.setTitle("Reporte");
           ventanavisor.setVisible(true);
        } catch (Exception e) {
            System.out.println("ERRORR");
        }
    }
    
    public void ReporteFechasCC6(String USUARIO,int F1,int F2, String FP,String CC6) {
        try {
            Map parametros = new HashMap();
            parametros.put("USU", USUARIO);
            parametros.put("F1", F1);
            parametros.put("F2", F2);
            parametros.put("FP", FP);
            parametros.put("CC6", CC6);
            JasperPrint informe = JasperFillManager.fillReport(getClass().getResourceAsStream("/Reportes/cajaCentral/ReporteFechasCta6.jasper"), parametros, con.conectar()); 
            JasperViewer ventanavisor = new JasperViewer(informe, false);
            ventanavisor.setTitle("Reporte");
           ventanavisor.setVisible(true);
        } catch (Exception e) {
            Caja_Reporte_CCTA6.ErrorPrint.setUndecorated(true);
            Caja_Reporte_CCTA6.ErrorPrint.setVisible(true);
        }
    }


    public void ConsultoriosExtPREVENTAListar(String ap_id){
        String consulta="";
        try {
            consulta="CAJA_ACTOMEDICO_EXISTENTE ?";
            PreparedStatement cmd = getCn().prepareStatement(consulta);
            cmd.setString(1, ap_id);
            ResultSet r= cmd.executeQuery();
            int c=1;
            while(r.next()){
                    
                Caja_Pagos.lblActoMedico.setText(r.getString(1));   
                Caja_Pagos.lblMantP.setText("PR");
            }
            //
        } catch (Exception e) {
            System.out.println("Error: LISTAR ActoMedico Existente  " + e.getMessage());
        }
    }

    public void ConsultoriosACTOMEDICO_EMERGENCIA(String ap_id){
        String consulta="";
        try {
            consulta="Caja_AM_EMERGENCIA ?";
            PreparedStatement cmd = getCn().prepareStatement(consulta);
            cmd.setString(1, ap_id);
            ResultSet r= cmd.executeQuery();
            int c=1;
            while(r.next()){   
                Caja_Pagos.lblActoMedico.setText(r.getString(1));    
                Caja_Pagos.lblMantP.setText("PR");
            }
            //
        } catch (Exception e) {
            System.out.println("Error: AM DE EMERGENCIA  " + e.getMessage());
        }
    }

    public void VerificarPreventaHOS_OJO_IMPORTANTE_DE_MOMENTO(String ap_id){
        String consulta="";
        try {
            consulta="CAJA_VERIFICAR_PREVENTA_HOS ?";
            PreparedStatement cmd = getCn().prepareStatement(consulta);
            cmd.setString(1, ap_id);
            ResultSet r= cmd.executeQuery();
            int c=1;
            while(r.next()){
                    
                Caja_Pagos.lblActoMedico.setText(r.getString(1));  
                Caja_Pagos.lblIdPreventaAlta.setText(r.getString(2));  
                Caja_Pagos.lblMantP.setText("PR");
            }
            //
        } catch (Exception e) {
            System.out.println("Error Preventa provicional  " + e.getMessage());
        }
    }

    public void ConsultoriosExtPREVENTAListarCEX(String ap_id){
        String consulta="";
        try {
            consulta="CAJA_ACTOMEDICO_EXISTENTE_CEX ?";
            PreparedStatement cmd = getCn().prepareStatement(consulta);
            cmd.setString(1, ap_id);
            ResultSet r= cmd.executeQuery();
            int c=1;
            while(r.next()){
                    
                Caja_Pagos.lblActoMedico.setText(r.getString(1));  
                Caja_Pagos.lblMantP.setText("PR");
            }
            //
        } catch (Exception e) {
            System.out.println("Error: LISTAR ActoMedico Existente  " + e.getMessage());
        }
    }


    public void Caja_Id_Preventa(String ap_id){
        String consulta="";
        try {
            consulta="Caja_Verificar_PreVenta ?";
            PreparedStatement cmd = getCn().prepareStatement(consulta);
            cmd.setString(1, ap_id);
            ResultSet r= cmd.executeQuery();
            int c=1;
            while(r.next()){
                    
                Caja_Pagos.lblIdPreventa.setText(r.getString(1));    
            }
            //
        } catch (Exception e) {
            System.out.println("Error: LISTAR AP  " + e.getMessage());
        }
    }
        
    public boolean ActualizarEstadoPagoCREDITO_HOSPITALARIO()
        {
        boolean resp = false;
        try
        {
            String sql = "exec CAJA_ACTUALIZAR_FP_CREDITOH ?";
            PreparedStatement cmd = getCn().prepareStatement(sql);
            cmd.setString(1, getId_documento());
            
            if(!cmd.execute())
            {
                resp = true;
            }
            cmd.close();
            getCn().close();
        }
        catch(Exception ex)
        {
            System.out.println("Error CRED : " + ex.getMessage());
        }
        return resp;
    }
    public boolean ActualizarEstadoPagoCREDITO_HOSPITALARIO_det()
        {
        boolean resp = false;
        try
        {
            String sql = "exec CAJA_ACTUALIZAR_FP_CREDITOH_DETALLE ?";
            PreparedStatement cmd = getCn().prepareStatement(sql);
            cmd.setInt(1, getId_Cod_det());
            
            if(!cmd.execute())
            {
                resp = true;
            }
            cmd.close();
            getCn().close();
        }
        catch(Exception ex)
        {
            System.out.println("Error CRED : " + ex.getMessage());
        }
        return resp;
    }

    public boolean NuevoActoMedico()
        {
        boolean resp = false;
        try
        {
            String sql = "exec CAJA_ACTO_MEDICO_NUEVO ?,?,?,?";
            PreparedStatement cmd = getCn().prepareStatement(sql);
            cmd.setInt(1, getID_ACTOMEDICO1());
            cmd.setInt(2, getNUM_ACTOMEDICO());
            cmd.setString(3, getFECHA_TERMINO());
            cmd.setString(4, getDURACION());
            
            if(!cmd.execute())
            {
                resp = true;
            }
            cmd.close();
            getCn().close();
        }
        catch(Exception ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }
        return resp;
    }

    public boolean ActualizarVenta()
        {
        boolean resp = false;
        try
        {
            String sql = "exec CAJA_ACTUALIZAR_VENTA_CABECERA ?,?,?,?,?,?,?,?,?,?,?";
            PreparedStatement cmd = getCn().prepareStatement(sql);
            cmd.setString(1, getId_documento());
            cmd.setDouble(2, getDESCUENTO());
            cmd.setDouble(3, getTOTAL_DOCUUMENTO());
            cmd.setString(4, getUsu_Exoneracion());
            cmd.setString(5, getPorcentaje_Exoneracion());
            cmd.setInt(6, getId_ActoMedico());
            cmd.setString(7, getEstadoVisibleAdmision());
            cmd.setString(8,getCod_jerar_forma_pago());
            cmd.setString(9, getId_hc());
            
            cmd.setString(10, getNUMREF());
            cmd.setString(11, getCODRENAESREFE());
            
            if(!cmd.execute())
            {
                resp = true;
            }
            cmd.close();
            getCn().close();
        }
        catch(Exception ex)
        {
            System.out.println("Error ACTUALIZAR CABECERA: " + ex.getMessage());
        }
        return resp;
    }
    
    
    public boolean ActualizarVenta_FR()
        {
        boolean resp = false;
        try
        {
            String sql = "exec CAJA_ACTUALIZAR_VENTA_CABECERA_FR ?,?,?,?,?,?,?,?,?,?,?,?,?";
            PreparedStatement cmd = getCn().prepareStatement(sql);
            cmd.setString(1, getId_documento());
            cmd.setDouble(2, getDESCUENTO());
            cmd.setDouble(3, getTOTAL_DOCUUMENTO());
            
            cmd.setDouble(4, getIGV());
            cmd.setDouble(5, getSUBTOTAL());
            
            cmd.setString(6, getUsu_Exoneracion());
            cmd.setString(7, getPorcentaje_Exoneracion());
            cmd.setInt(8, getId_ActoMedico());
            cmd.setString(9, getEstadoVisibleAdmision());
            cmd.setString(10,getCod_jerar_forma_pago());
            cmd.setString(11, getSerie_documento());
            cmd.setString(12, getNum_documento());
            cmd.setDouble(13, getREDONDEO());
            if(!cmd.execute())
            {
                resp = true;
            }
            cmd.close();
            getCn().close();
        }
        catch(Exception ex)
        {
            System.out.println("Error ACTUALIZAR CABECERA: " + ex.getMessage());
        }
        return resp;
    }
    
    public boolean ActualizarVentaEx()
        {
        boolean resp = false;
        try
        {
            String sql = "exec CAJA_ACTUALIZAR_VENTA_CABECERA_DESCUENTO ?,?,?,?,?,?,?";
            PreparedStatement cmd = getCn().prepareStatement(sql);
            cmd.setString(1, getId_documento());
            cmd.setDouble(2, getDESCUENTO());
            cmd.setDouble(3, getTOTAL_DOCUUMENTO());
            cmd.setString(4, getUsu_Exoneracion());
            cmd.setString(5, getPorcentaje_Exoneracion());
            cmd.setInt(6, getId_ActoMedico());
            cmd.setString(7, getEstadoVisibleAdmision());
            if(!cmd.execute())
            {
                resp = true;
            }
            cmd.close();
            getCn().close();
        }
        catch(Exception ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }
        return resp;
    }

    public boolean NuevaVenta(){
        boolean resp = false;
        try{
            String sql = "EXEC Caja_VENTA_NUEVA_CABEZERA ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
            PreparedStatement cmd = getCn().prepareStatement(sql);
            cmd.setString(1, getId_documento());
            cmd.setString(2, getCod_tipo_documento());
            cmd.setString(3, getCod_jerar_forma_pago());
            cmd.setString(4, getId_hc());
            cmd.setString(5, getCod_motiv_anu());
            cmd.setString(6, getSerie_documento());
            cmd.setString(7, getNum_documento());
            cmd.setString(8, getDependencia());
            cmd.setString(9, getESTADOP());
            cmd.setString(10, getCod_usu());
            cmd.setString(11, getId_liquidacion());
            cmd.setInt(12, getCorrelativo());
            cmd.setInt(13, getId_ActoMedico());
            cmd.setInt(14, getId_Cta_Abono());
            cmd.setString(15, getUsu_Exoneracion());
            cmd.setString(16, getPorcentaje_Exoneracion());
            cmd.setInt(17, getID_SESION());
            cmd.setString(18, getFUA());    
            cmd.setString(19, getCODRENAESREFE());
            cmd.setString(20, getNUMREF());

            if(!cmd.execute())
            {
                resp = true;
            }
            cmd.close();
            getCn().close();
        }
        catch(Exception ex)
        {
            System.out.println("Error NUEVA VENTA: " + ex.getMessage());
        }
        return resp;
    }

    public boolean INICIAR_HOSPITALIZACION_H(){
        boolean resp = false;
        try{
            String sql = "EXEC CAJA_REGISTRAR_DIAS_H ?";
            PreparedStatement cmd = getCn().prepareStatement(sql);
            cmd.setString(1, getId_hc());
            if(!cmd.execute())
            {
                resp = true;
            }
            cmd.close();
            getCn().close();
        }
        catch(Exception ex)
        {
            System.out.println("Error ININCIAR HOSPITALIZACION: " + ex.getMessage());
        }
        return resp;
    }

    public boolean DIAS_HOSPITALIZACION(){
        boolean resp = false;
        try{
            String sql = "EXEC CAJA_CALCULAR_DIAS_H ?";
            PreparedStatement cmd = getCn().prepareStatement(sql);
            cmd.setString(1, getId_hc());
            if(!cmd.execute())
            {
                resp = true;
            }
            cmd.close();
            getCn().close();
        }
        catch(Exception ex)
        {
            System.out.println("Error TERMINAR HOSPITALIZACION: " + ex.getMessage());
        }
        return resp;
    }

    
    public boolean eliminar(){
        boolean resp = false;
        try
        {
            String sql = "EXEC CAJA_ELIMINAR_CABECERA ?";
            PreparedStatement cmd = getCn().prepareStatement(sql);
            cmd.setString(1, getId_documento());
            if(!cmd.execute())
            {
                resp = true;
            }
            cmd.close();
            getCn().close();
          
        }
        catch(Exception ex)
        {
            System.out.println("Error_eliminar: " + ex.getMessage());
        }
        return resp;
    }
    
    public boolean EliminarDetalle(){
        boolean resp = false;
        try
        {
            String sql = "EXEC CAJA_ELIMINAR_DETALLE ?";
            PreparedStatement cmd = getCn().prepareStatement(sql);
            cmd.setInt(1, getIdDetalle());
            if(!cmd.execute())
            {
                resp = true;
            }
            cmd.close();
            getCn().close();
          
        }
        catch(Exception ex)
        {
            System.out.println("Error_eliminar Detalle: " + ex.getMessage());
        }
        return resp;
    }
    
    public boolean CAJA_NUM_FUA(){
        boolean resp = false;
        try
        {
            String sql = "EXEC CAJA_GENERAR_NUM_FUA ?";
            PreparedStatement cmd = getCn().prepareStatement(sql);
            cmd.setString(1, getId_documento());
            if(!cmd.execute())
            {
                resp = true;
            }
            cmd.close();
            getCn().close();
          
        }
        catch(Exception ex)
        {
            System.out.println("Error_eliminar Detalle: " + ex.getMessage());
        }
        return resp;
    }
    
    
    public boolean EliminarKARDEX_LA(){
        boolean resp = false;
        try
        {
            String sql = "EXEC CAJA_ELIMINAR_DESCUENTO_KARDEX_LA ?";
            PreparedStatement cmd = getCn().prepareStatement(sql);
            cmd.setInt(1, getIdDetalle());
            if(!cmd.execute())
            {
                resp = true;
            }
            cmd.close();
            getCn().close();
          
        }
        catch(Exception ex)
        {
            System.out.println("Error_eliminar KARDEX LA: " + ex.getMessage());
        }
        return resp;
    }
     
     

    public String codUsuario(String nombreUsuario)
    {
        String cod="";
        try
        {
            String sql = "SELECT USU_CODIGO FROM USUARIO WHERE Usu_Usuario = ?";
            PreparedStatement cmd = getCn().prepareStatement(sql);
            cmd.setString(1, nombreUsuario);
            ResultSet rs = cmd.executeQuery();
            if(rs.next())
            {
               cod = rs.getString(1);
            }
        }
        catch(Exception ex)
        {
            System.out.println("Error_codUsuario: " + ex.getMessage());
        }
        return cod;
    }
 
    public String ActoMedico(String nombreUsuario)
    {
        String cod="";
        try
        {
            String sql = "CAJA_ID_ACTOMEDICO ?";
            PreparedStatement cmd = getCn().prepareStatement(sql);
            cmd.setString(1, nombreUsuario);
            ResultSet rs = cmd.executeQuery();
            if(rs.next())
            {
               cod = rs.getString(1);
            }
        }
        catch(Exception ex)
        {
            System.out.println("Error Acto Medico: " + ex.getMessage());
        }
        return cod;
    }
 
    public String id(String nombreUsuario)
    {
        String cod="";
        try
        {
            String sql = "Caja_DocumentoCabecera_ID ?";
            PreparedStatement cmd = getCn().prepareStatement(sql);
            cmd.setString(1, nombreUsuario);
            ResultSet rs = cmd.executeQuery();
            if(rs.next())
            {
               cod = rs.getString(1);
            }
        }
        catch(Exception ex)
        {
            System.out.println("Error Id Documento: " + ex.getMessage());
        }
        return cod;
    }




    public String sinanulacion(){//muestra el codigo
        String id = "";
        try {
            String consulta = "exec Caja_NuevaVentaSinAnulacion";
            ResultSet r;
            r=con.Listar(consulta);
        if(r.next()){
               id = r.getString(1);
        }
        }catch(Exception ex){
            System.out.println("Error " + ex.getMessage());
        }
        return id;
    }

    public String codTipo(String tipo)
    {
        String cod="";
        try
        {
            String sql = "SELECT cod_tipo_documento \n" +
                        "FROM CAJA_TIPO_DOCUMENTO\n" +
                        "WHERE tipo_documento = ?";
            PreparedStatement cmd = getCn().prepareStatement(sql);
            cmd.setString(1, tipo);
            ResultSet rs = cmd.executeQuery();
            if(rs.next())
            {
               cod = rs.getString(1);
            }
        }
        catch(Exception ex)
        {
            System.out.println("Error_codDistrito: " + ex.getMessage());
        }
        return cod;
    }

    public String anular(String tipo)
    {
        String cod="";
        try
        {
            String sql = "SELECT cod_motiv_anu \n" +
                        "FROM CAJA_MOTIVO_ANULACION\n" +
                        "WHERE descripcion_anulacion = ?";
            PreparedStatement cmd = getCn().prepareStatement(sql);
            cmd.setString(1, tipo);
            ResultSet rs = cmd.executeQuery();
            if(rs.next())
            {
               cod = rs.getString(1);
            }
        }
        catch(Exception ex)
        {
            System.out.println("Error_codDistrito: " + ex.getMessage());
        }
        return cod;
    }

    public boolean modificarAnulacion(){
        boolean resp = false;
        try
        {
            String sql = "Exec CAJA_VENTA_CABECERA_ANULACION ?";
            PreparedStatement cmd = getCn().prepareStatement(sql);
            cmd.setString(1, getId_documento());
//            cmd.setString(2, getCod_motiv_anu());
//            cmd.setDouble(3, getDevolucion_doc());
//            cmd.setString(4, getCod_usu_anu());

            if(!cmd.execute())
            {
                resp = true;
            }
            cmd.close();
            getCn().close();
        }
        catch(Exception ex)
        {
          System.out.println("Error " + ex.getMessage());
        }
        return resp;
    }

    public void listarMedicos(String medico,String Servicio,JTable tabla){
    String consulta="";
        try {
            tabla.setModel(new DefaultTableModel());
            String titulos[]={"Código","Médico","Día","Mes","Año","Turno"};
            m=new DefaultTableModel(null,titulos);
            JTable p=new JTable(m);
            String fila[]=new String[6];
            //int index = cbxTipoBusqueda.getSelectedIndex();
            consulta="EXEC CAJA_LISTA_MEDICO_TURNO ?,?";
            PreparedStatement cmd = getCn().prepareStatement(consulta);
            cmd.setString(1, medico);
            cmd.setString(2, Servicio);
            ResultSet r= cmd.executeQuery();
            int c=1;
            while(r.next()){
                fila[0]=r.getString(1); 
                fila[1]=r.getString(2);
                fila[2]=r.getString(3);
                fila[3]=r.getString(4); 
                fila[4]=r.getString(5);
                fila[5]=r.getString(6);

                    m.addRow(fila);
                    c++;
            }
            tabla.setModel(m);
            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m);
            tabla.setRowSorter(elQueOrdena);
            tabla.setModel(m);
            formatoTablaMedico(tabla);
        } catch (Exception e) {
            System.out.println("Error: listar PREVENTA CEX: " + e.getMessage());
        }
    }

    public void listarMedicos1(String Servicio,JTable tabla){
    String consulta="";
        try {
            tabla.setModel(new DefaultTableModel());
            String titulos[]={"Código","Médico","Día","Mes","Año","Turno",};
            m=new DefaultTableModel(null,titulos);
            JTable p=new JTable(m);
            String fila[]=new String[6];
            //int index = cbxTipoBusqueda.getSelectedIndex();
            consulta="EXEC CAJA_LISTA_MEDICO_TURNO_TODO ?";
            PreparedStatement cmd = getCn().prepareStatement(consulta);
            cmd.setString(1, Servicio);
            ResultSet r= cmd.executeQuery();
            int c=1;
            while(r.next()){
                fila[0]=r.getString(1); 
                fila[1]=r.getString(2);
                fila[2]=r.getString(3);
                fila[3]=r.getString(4); 
                fila[4]=r.getString(5);
                fila[5]=r.getString(6);

                    m.addRow(fila);
                    c++;
            }
            tabla.setModel(m);
            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m);
            tabla.setRowSorter(elQueOrdena);
            tabla.setModel(m);
            formatoTablaMedico(tabla);
        } catch (Exception e) {
            System.out.println("Error: listar PREVENTA CEX: " + e.getMessage());
        }
    }
    public void listarMedicosPapeleta(String Servicio,JTable tabla){
    String consulta="";
        try {
            tabla.setModel(new DefaultTableModel());
            String titulos[]={"Código","Médico","Día","Mes","Año","Turno",};
            m=new DefaultTableModel(null,titulos);
            JTable p=new JTable(m);
            String fila[]=new String[6];
            //int index = cbxTipoBusqueda.getSelectedIndex();
            consulta="EXEC CAJA_LISTA_MEDICO_TURNO_PAPELETA ?";
            PreparedStatement cmd = getCn().prepareStatement(consulta);
            cmd.setString(1, Servicio);
            ResultSet r= cmd.executeQuery();
            int c=1;
            while(r.next()){
                fila[0]=r.getString(1); 
                fila[1]=r.getString(2);
                fila[2]=r.getString(3);
                fila[3]=r.getString(4); 
                fila[4]=r.getString(5);
                fila[5]=r.getString(6);

                    m.addRow(fila);
                    c++;
            }
            tabla.setModel(m);
            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m);
            tabla.setRowSorter(elQueOrdena);
            tabla.setModel(m);
            formatoTablaMedico(tabla);
        } catch (Exception e) {
            System.out.println("Error: listar PREVENTA CEX: " + e.getMessage());
        }
    }
    
    public void formatoTablaMedico(JTable tabla){
        tabla.getColumnModel().getColumn(0).setMinWidth(0);
        tabla.getColumnModel().getColumn(0).setMaxWidth(0); 
        tabla.getColumnModel().getColumn(1).setPreferredWidth(350);  
        tabla.getColumnModel().getColumn(2).setMinWidth(0);
        tabla.getColumnModel().getColumn(2).setMaxWidth(0); 
        tabla.getColumnModel().getColumn(3).setMinWidth(0);
        tabla.getColumnModel().getColumn(3).setMaxWidth(0); 
        tabla.getColumnModel().getColumn(4).setMinWidth(0);
        tabla.getColumnModel().getColumn(4).setMaxWidth(0); 
        tabla.getColumnModel().getColumn(5).setMinWidth(0);
        tabla.getColumnModel().getColumn(5).setMaxWidth(0); 
        
//        tabla.getColumnModel().getColumn(2).setPreferredWidth(50); 
//        tabla.getColumnModel().getColumn(3).setPreferredWidth(50); 
//        tabla.getColumnModel().getColumn(4).setPreferredWidth(50); 
//        tabla.getColumnModel().getColumn(5).setPreferredWidth(150); 
//        
  
        tabla.setRowHeight(40);
    }
    
    public void Preventamostrar(String parametro,JTable tabla){
    String consulta="";
        try {
            tabla.setModel(new DefaultTableModel());
            String titulos[]={"Nº Preventa","ID_H.C.","Modulo","CodNomen","Nomenclatura","Descripcion","Medico","Fecha","Hora"};
            m=new DefaultTableModel(null,titulos);
            JTable p=new JTable(m);
            String fila[]=new String[10];
            //int index = cbxTipoBusqueda.getSelectedIndex();
            consulta="exec Caja_Verificar_PreVenta ?";
            PreparedStatement cmd = getCn().prepareStatement(consulta);
            cmd.setString(1, parametro);;
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

                    m.addRow(fila);
                    c++;
            }
            tabla.setModel(m);
            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m);
            tabla.setRowSorter(elQueOrdena);
            tabla.setModel(m);
            formatoTablaMedico(tabla);
        } catch (Exception e) {
            System.out.println("Error: listar PREVENTA CEX: " + e.getMessage());
        }
    }
 
    
    public void ListarAsistentaSocial(JTable tabla){
    String consulta="";
        try {
            tabla.setModel(new DefaultTableModel());
            String titulos[]={"Apellidos y Nombres"};
            m=new DefaultTableModel(null,titulos);
            JTable p=new JTable(m);
            String fila[]=new String[1];
            //int index = cbxTipoBusqueda.getSelectedIndex();
            consulta="EXEC Caja_Asiste_Social_Listar";
            PreparedStatement cmd = getCn().prepareStatement(consulta);
            ResultSet r= cmd.executeQuery();
            int c=1;
            while(r.next()){
                fila[0]=r.getString(1); 

                    m.addRow(fila);
                    c++;
            }
            tabla.setModel(m);
            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m);
            tabla.setRowSorter(elQueOrdena);
            tabla.setModel(m);
            formatoTablaAsistente(tabla);
        } catch (Exception e) {
            System.out.println("Error: listar ASISTENTES: " + e.getMessage());
        }
    }
    
    public void formatoTablaAsistente(JTable tabla){

        tabla.setRowHeight(37);
    }
     
    public void BuscarCPT(String Texto,String FormaPago,JTable tabla){
    String consulta="";
        try {
            tabla.setModel(new DefaultTableModel());
            String titulos[]={"Nomeclatura","Descripcion","Precio","Forma de Pago","Decripcion Forma Pago","","","","","",""};
            m=new DefaultTableModel(null,titulos);
            JTable p=new JTable(m);
            String fila[]=new String[11];
            //int index = cbxTipoBusqueda.getSelectedIndex();
            consulta="exec Caja_NomenclaturaVentaBUSCAR ?,?";
            PreparedStatement cmd = getCn().prepareStatement(consulta);
            cmd.setString(1, Texto);
            cmd.setString(2, FormaPago);
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

                    m.addRow(fila);
                    c++;
            }
            tabla.setModel(m);
            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m);
            tabla.setRowSorter(elQueOrdena);
            tabla.setModel(m);
            formatoTablaCPT(tabla);
        } catch (Exception e) {
            System.out.println("Error: listar PREVENTA CEX: " + e.getMessage());
        }
    }
    public void formatoTablaCPT(JTable tabla){
        tabla.getColumnModel().getColumn(0).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(600);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(50);

        tabla.getColumnModel().getColumn(3).setMinWidth(0);
        tabla.getColumnModel().getColumn(3).setMaxWidth(0);
        tabla.getColumnModel().getColumn(4).setMinWidth(0);
        tabla.getColumnModel().getColumn(4).setMaxWidth(0);
        tabla.getColumnModel().getColumn(5).setMinWidth(0);
        tabla.getColumnModel().getColumn(5).setMaxWidth(0);
        tabla.getColumnModel().getColumn(6).setMinWidth(0);
        tabla.getColumnModel().getColumn(6).setMaxWidth(0);
        tabla.getColumnModel().getColumn(7).setMinWidth(0);
        tabla.getColumnModel().getColumn(7).setMaxWidth(0);
        tabla.getColumnModel().getColumn(8).setMinWidth(0);
        tabla.getColumnModel().getColumn(8).setMaxWidth(0);
        tabla.getColumnModel().getColumn(9).setMinWidth(0);
        tabla.getColumnModel().getColumn(9).setMaxWidth(0);
        tabla.getColumnModel().getColumn(10).setMinWidth(0);
        tabla.getColumnModel().getColumn(10).setMaxWidth(0);
        tabla.setRowHeight(40);
        
    }
     
    public void ListarConsultorios(int AR_ID,JTable tabla){
    String consulta="";
        try {
            tabla.setModel(new DefaultTableModel());
            String titulos[]={"ID","Dia","Hora Inicio","Hora Termino","Consultorio","Nº de Citas","Adicionales","Futuras","Turno","Médico","","","","","","","","","","","","",""};
            m=new DefaultTableModel(null,titulos);
            JTable p=new JTable(m);
            String fila[]=new String[23];
            //int index = cbxTipoBusqueda.getSelectedIndex();
            consulta="exec Caja_ConsultoriosExternosListar ?";
            PreparedStatement cmd = getCn().prepareStatement(consulta);
            cmd.setInt(1,AR_ID);
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
                        m.addRow(fila);
                        c++;
                }
            tabla.setModel(m);
            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m);
            tabla.setRowSorter(elQueOrdena);
            tabla.setModel(m);
            formatoTablaDetalle(tabla);
        } catch (Exception e) {
            System.out.println("Error: listarConsultorios CAJA: " + e.getMessage());
        }
    }
    
    public void ListarConsultoriosFUTURO(int AR_ID,JTable tabla){
    String consulta="";
        try {
            tabla.setModel(new DefaultTableModel());
            String titulos[]={"ID","Dia","Hora Inicio","Hora Termino","Consultorio","Nº de Citas","Adicionales","Futuras","Turno","Médico","","","","","","","","","","","","",""};
            m=new DefaultTableModel(null,titulos);
            JTable p=new JTable(m);
            String fila[]=new String[23];
            //int index = cbxTipoBusqueda.getSelectedIndex();
            consulta="exec Caja_ConsultoriosExternosListar_FUTURA ?";
            PreparedStatement cmd = getCn().prepareStatement(consulta);
            cmd.setInt(1,AR_ID);
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

                        m.addRow(fila);
                        c++;
                }
            tabla.setModel(m);
            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m);
            tabla.setRowSorter(elQueOrdena);
            tabla.setModel(m);
            formatoTablaDetalleFUTURA(tabla);
        } catch (Exception e) {
            System.out.println("Error: listarConsultorios FUTURO CAJA: " + e.getMessage());
        }
    }
    public void formatoTablaDetalleFUTURA(JTable tabla){
        tabla.getColumnModel().getColumn(0).setMinWidth(0);
        tabla.getColumnModel().getColumn(0).setMaxWidth(0);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(20);
        
        tabla.getColumnModel().getColumn(2).setPreferredWidth(50);
        
        tabla.getColumnModel().getColumn(3).setMinWidth(0);
        tabla.getColumnModel().getColumn(3).setMaxWidth(0);
        tabla.getColumnModel().getColumn(4).setMinWidth(0);
        tabla.getColumnModel().getColumn(4).setMaxWidth(0);
        tabla.getColumnModel().getColumn(5).setMinWidth(0);
        tabla.getColumnModel().getColumn(5).setMaxWidth(0);
        tabla.getColumnModel().getColumn(6).setMinWidth(0);
        tabla.getColumnModel().getColumn(6).setMaxWidth(0);
        tabla.getColumnModel().getColumn(7).setPreferredWidth(230);
        tabla.getColumnModel().getColumn(8).setMinWidth(0);
        tabla.getColumnModel().getColumn(8).setMaxWidth(0);
        tabla.getColumnModel().getColumn(9).setMinWidth(0);
        tabla.getColumnModel().getColumn(9).setMaxWidth(0);
        tabla.getColumnModel().getColumn(10).setMinWidth(0);
        tabla.getColumnModel().getColumn(10).setMaxWidth(0);
        tabla.getColumnModel().getColumn(11).setMinWidth(0);
        tabla.getColumnModel().getColumn(11).setMaxWidth(0);
        tabla.getColumnModel().getColumn(12).setMinWidth(0);
        tabla.getColumnModel().getColumn(12).setMaxWidth(0);
        tabla.getColumnModel().getColumn(13).setMinWidth(0);
        tabla.getColumnModel().getColumn(13).setMaxWidth(0);
        tabla.getColumnModel().getColumn(14).setMinWidth(0);
        tabla.getColumnModel().getColumn(14).setMaxWidth(0);
        tabla.getColumnModel().getColumn(15).setMinWidth(0);
        tabla.getColumnModel().getColumn(15).setMaxWidth(0);
        tabla.getColumnModel().getColumn(16).setMinWidth(0);
        tabla.getColumnModel().getColumn(16).setMaxWidth(0);
        tabla.getColumnModel().getColumn(17).setMinWidth(0);
        tabla.getColumnModel().getColumn(17).setMaxWidth(0);
        tabla.getColumnModel().getColumn(18).setMinWidth(0);
        tabla.getColumnModel().getColumn(18).setMaxWidth(0);
        tabla.getColumnModel().getColumn(19).setMinWidth(0);
        tabla.getColumnModel().getColumn(19).setMaxWidth(0);
        tabla.getColumnModel().getColumn(20).setMinWidth(0);
        tabla.getColumnModel().getColumn(20).setMaxWidth(0);
        tabla.getColumnModel().getColumn(21).setMinWidth(0);
        tabla.getColumnModel().getColumn(21).setMaxWidth(0);
        tabla.getColumnModel().getColumn(21).setMinWidth(0);
        tabla.getColumnModel().getColumn(21).setMaxWidth(0);
        tabla.getColumnModel().getColumn(22).setMinWidth(0);
        tabla.getColumnModel().getColumn(22).setMaxWidth(0);

//        COLUMNAS OCULTAS
//        TableColumn columna = tabla.getColumnModel().getColumn(0);
//            columna.setMaxWidth(0);
//            columna.setMinWidth(0);
//            columna.setPreferredWidth(0);
//            tabla.doLayout();
        tabla.setRowHeight(45);
    }
     public void formatoTablaDetalle(JTable tabla){
        tabla.getColumnModel().getColumn(0).setMinWidth(0);
        tabla.getColumnModel().getColumn(0).setMaxWidth(0);
        tabla.getColumnModel().getColumn(1).setMinWidth(0);
        tabla.getColumnModel().getColumn(1).setMaxWidth(0);
        tabla.getColumnModel().getColumn(3).setMinWidth(0);
        tabla.getColumnModel().getColumn(3).setMaxWidth(0);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(80);
//        tabla.getColumnModel().getColumn(3).setPreferredWidth(70);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(30);
        tabla.getColumnModel().getColumn(5).setPreferredWidth(30);
        tabla.getColumnModel().getColumn(7).setPreferredWidth(160);
        tabla.getColumnModel().getColumn(6).setMinWidth(0);
        tabla.getColumnModel().getColumn(6).setMaxWidth(0);
        tabla.getColumnModel().getColumn(8).setMinWidth(0);
        tabla.getColumnModel().getColumn(8).setMaxWidth(0);
        tabla.getColumnModel().getColumn(9).setMinWidth(0);
        tabla.getColumnModel().getColumn(9).setMaxWidth(0);
        tabla.getColumnModel().getColumn(10).setMinWidth(0);
        tabla.getColumnModel().getColumn(10).setMaxWidth(0);
        tabla.getColumnModel().getColumn(11).setMinWidth(0);
        tabla.getColumnModel().getColumn(11).setMaxWidth(0);
        tabla.getColumnModel().getColumn(12).setMinWidth(0);
        tabla.getColumnModel().getColumn(12).setMaxWidth(0);
        tabla.getColumnModel().getColumn(13).setMinWidth(0);
        tabla.getColumnModel().getColumn(13).setMaxWidth(0);
        tabla.getColumnModel().getColumn(14).setMinWidth(0);
        tabla.getColumnModel().getColumn(14).setMaxWidth(0);
        tabla.getColumnModel().getColumn(15).setMinWidth(0);
        tabla.getColumnModel().getColumn(15).setMaxWidth(0);
        tabla.getColumnModel().getColumn(16).setMinWidth(0);
        tabla.getColumnModel().getColumn(16).setMaxWidth(0);
        tabla.getColumnModel().getColumn(17).setMinWidth(0);
        tabla.getColumnModel().getColumn(17).setMaxWidth(0);
        tabla.getColumnModel().getColumn(18).setMinWidth(0);
        tabla.getColumnModel().getColumn(18).setMaxWidth(0);
        tabla.getColumnModel().getColumn(19).setMinWidth(0);
        tabla.getColumnModel().getColumn(19).setMaxWidth(0);
        tabla.getColumnModel().getColumn(20).setMinWidth(0);
        tabla.getColumnModel().getColumn(20).setMaxWidth(0);
        tabla.getColumnModel().getColumn(21).setMinWidth(0);
        tabla.getColumnModel().getColumn(21).setMaxWidth(0);
        tabla.getColumnModel().getColumn(22).setMinWidth(0);
        tabla.getColumnModel().getColumn(22).setMaxWidth(0);

   

//        COLUMNAS OCULTAS
//        TableColumn columna = tabla.getColumnModel().getColumn(0);
//            columna.setMaxWidth(0);
//            columna.setMinWidth(0);
//            columna.setPreferredWidth(0);
//            tabla.doLayout();
        tabla.setRowHeight(45);
    }
     
     
    public void reporteVentaLaRxEc(String id_documento,String TOTAL_FR,String farma) {
        try {
            Map parametros = new HashMap();
            parametros.put("doc",id_documento);
            parametros.put("TOTAL_FR",TOTAL_FR);
            parametros.put("farma",farma);
           JasperPrint informe = JasperFillManager.fillReport(getClass().getResourceAsStream("/Reportes/cajaCentral/LA_RX_EC_NO SIS.jasper"), parametros, con.conectar());   
            JasperPrintManager.printReport(informe, false);
            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, "ERROR GERMAN --------------------"+e.getMessage()+"ID   "+id_documento);
                Caja_Pagos.ErrorPrint.setUndecorated(true);
                Caja_Pagos.ErrorPrint.setVisible(true);
                
            }
    } 
    
//        public void reporteVentaLaRxEc(String ID){
//        try {
//            Map parametros = new HashMap();
//            parametros.put("ID", ID);
//            //E:\\HIMS_SIS\\PRUEBASIS\\src\\
//            //jrxml
//    String report = JasperCompileManager.compileReportToFile("E:\\HIMS_SIS\\PRUEBASIS\\src\\Reportes\\cajaCentral\\report1.jrxml");
//    JasperPrint jasperPrint = JasperFillManager.fillReport(report, parametros, con.conectar());
//    PrinterJob printerJob = PrinterJob.getPrinterJob();
//    PageFormat pageFormat = PrinterJob.getPrinterJob().defaultPage();
//    printerJob.defaultPage(pageFormat);
//    int selectedService = 0;
//    AttributeSet attributeSet = new HashPrintServiceAttributeSet(new PrinterName("Enviar a OneNote 16", null));
//    PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, attributeSet);
//    try {
//        printerJob.setPrintService(printService[selectedService]);
//    } catch (Exception e) {
//        System.out.println(e);
//    }
//    JRPrintServiceExporter exporter;
//    PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();
//    printRequestAttributeSet.add(MediaSizeName.NA_LETTER);
//    printRequestAttributeSet.add(new Copies(1));
//    // these are deprecated
//    exporter = new JRPrintServiceExporter();
//    exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
//    exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, printService[selectedService]);
//    exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET, printService[selectedService].getAttributes());
//    exporter.setParameter(JRPrintServiceExporterParameter.PRINT_REQUEST_ATTRIBUTE_SET, printRequestAttributeSet);
//    exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG, Boolean.FALSE);
//    exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.FALSE);
//    exporter.exportReport();
//
//} catch (JRException e) {
//    e.printStackTrace();
//}
//    }
//     
    
    public void reporteVentaLaRxEcSIS(String id_documento,String TOTAL_FR,String farma) {
        try {
            Map parametros = new HashMap();
            parametros.put("doc",id_documento);
            parametros.put("TOTAL_FR",TOTAL_FR);
            parametros.put("farma",farma);
            JasperPrint informe = JasperFillManager.fillReport(getClass().getResourceAsStream("/Reportes/cajaCentral/LA_RX_EC_SIS.jasper"), parametros, con.conectar());   
            JasperPrintManager.printReport(informe, false);
            } catch (Exception e) {
                Caja_Pagos.ErrorPrint.setUndecorated(true);
                Caja_Pagos.ErrorPrint.setVisible(true);
            }
    }
    
    public void reporteVentaConsultas(String id_documento) {
        try {
            Map parametros = new HashMap();
            parametros.put("doc",id_documento);
            JasperPrint informe = JasperFillManager.fillReport(getClass().getResourceAsStream("/Reportes/cajaCentral/TicketConsultorio - copia.jasper"), parametros, con.conectar());   
            JasperPrintManager.printReport(informe, false);
            } catch (Exception e) {
                System.out.println("error i "+e);
                
            }
    } 
    
    public void reporteVentaConsultasSIS(String id_documento) {
        try {
            Map parametros = new HashMap();
            parametros.put("doc",id_documento);
            JasperPrint informe = JasperFillManager.fillReport(getClass().getResourceAsStream("/Reportes/cajaCentral/TicketConsultorioSIS - copia.jasper"), parametros, con.conectar());   
            JasperPrintManager.printReport(informe, false);
            } catch (Exception e) {
               System.out.println("error i "+e);
                
            }
    }
    
    public void reporteALTA(String id_documento) {
        try {
            Map parametros = new HashMap();
            parametros.put("doc",id_documento);
            JasperPrint informe = JasperFillManager.fillReport(getClass().getResourceAsStream("/Reportes/cajaCentral/TicketLiquidacion.jasper"), parametros, con.conectar());   
            JasperPrintManager.printReport(informe, false);
            } catch (Exception e) {

                Caja_Pagos.ErrorPrint.setUndecorated(true);
                Caja_Pagos.ErrorPrint.setVisible(true);
                
            }
    } 
    
    public void ReporteFR_ANULADO(String id_documento) {
        try {
            Map parametros = new HashMap();
            parametros.put("doc",id_documento);
            JasperPrint informe = JasperFillManager.fillReport(getClass().getResourceAsStream("/Reportes/cajaCentral/FR_ANULADO.jasper"), parametros, con.conectar());   
            JasperPrintManager.printReport(informe, false);
            } catch (Exception e) {

                Caja_Pagos.ErrorPrint.setUndecorated(true);
                Caja_Pagos.ErrorPrint.setVisible(true);  
            }
    } 
    public void ReporteFR_PAGO(String id_documento) {
        try {
            Map parametros = new HashMap();
            parametros.put("doc",id_documento);
            JasperPrint informe = JasperFillManager.fillReport(getClass().getResourceAsStream("/Reportes/cajaCentral/FR_PAGO.jasper"), parametros, con.conectar());   
            JasperPrintManager.printReport(informe, false);
            } catch (Exception e) {

                Caja_Pagos.ErrorPrint.setUndecorated(true);
                Caja_Pagos.ErrorPrint.setVisible(true);  
            }
    } 
    
    
    public void reporteALTASIS(String id_documento) {
        try {
            Map parametros = new HashMap();
            parametros.put("doc",id_documento);
            JasperPrint informe = JasperFillManager.fillReport(getClass().getResourceAsStream("/Reportes/cajaCentral/TicketLiquidacionSIS.jasper"), parametros, con.conectar());   
            JasperPrintManager.printReport(informe, false);
            } catch (Exception e) {

                Caja_Pagos.ErrorPrint.setUndecorated(true);
                Caja_Pagos.ErrorPrint.setVisible(true);
                
            }
    } 
    public void reporteHOSPITALIZACION(String id_documento) {
        try {
            Map parametros = new HashMap();
            parametros.put("doc",id_documento);
            JasperPrint informe = JasperFillManager.fillReport(getClass().getResourceAsStream("/Reportes/cajaCentral/TicketHospitalizacion.jasper"), parametros, con.conectar());   
            JasperPrintManager.printReport(informe, false);
            } catch (Exception e) {
                Caja_Pagos.ErrorPrint.setUndecorated(true);
                Caja_Pagos.ErrorPrint.setVisible(true);
            }
    }
     
    public void reporteHOSPITALIZACIONSIS(String id_documento) {
        try {
            Map parametros = new HashMap();
            parametros.put("doc",id_documento);
            JasperPrint informe = JasperFillManager.fillReport(getClass().getResourceAsStream("/Reportes/cajaCentral/TicketHospitalizacionSIS.jasper"), parametros, con.conectar());   
            JasperPrintManager.printReport(informe, false);
            } catch (Exception e) {
                Caja_Pagos.ErrorPrint.setUndecorated(true);
                Caja_Pagos.ErrorPrint.setVisible(true);
            }
    }
     public void reporteFUA(String id_documento) {
        try {
            Map parametros = new HashMap();
            parametros.put("DNI", id_documento);
            System.out.println(id_documento);
            JasperPrint informe = JasperFillManager.fillReport(getClass().getResourceAsStream("/Reportes/cajaCentral/prueba.jasper"), parametros, con.conectar()); 
            JasperViewer ventanavisor = new JasperViewer(informe, false);
            JasperPrint informe1 = JasperFillManager.fillReport(getClass().getResourceAsStream("/Reportes/cajaCentral/report5.jasper"), parametros, con.conectar()); 
            JasperViewer ventanavisor1 = new JasperViewer(informe1, false);
            ventanavisor.setTitle("FUA");
            ventanavisor1.setTitle("FUA");
            ventanavisor.setVisible(true);
            ventanavisor1.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error_reporteDiario:"+e.getMessage());
        }
        } 
    public boolean ActualizarDNI(){
        boolean resp = false;
        try
        {
            String sql = "Exec CAJA_ACTUALIZAR_DNI ?,?";
            PreparedStatement cmd = getCn().prepareStatement(sql);
            cmd.setString(1, getId_hc());
            cmd.setInt(2, getDni());

            if(!cmd.execute())
            {
                resp = true;
            }
            cmd.close();
            getCn().close();
        }
        catch(Exception ex)
        {
          System.out.println("Error al actualizar el DNI " + ex.getMessage());
        }
        return resp;
    }
    
    public boolean ActualizarCitas()
        {
        boolean resp = false;
        try{
            String sql = "EXEC CAJA_ACTUALIZAR_CITAS ?,?,?";
            PreparedStatement cmd = getCn().prepareStatement(sql);
            cmd.setInt(1, getCA_ID());
            cmd.setInt(2, getCONTADOR_CITAS());
            cmd.setInt(3, getCITAS_CAJA());

            if(!cmd.execute())
            {
                resp = true;
            }
            cmd.close();
            getCn().close();
        }
        catch(Exception ex)
        {
            System.out.println("Error ACTUALIZAR CITAS: " + ex.getMessage());
        }
        return resp;
    }
     
    public boolean ActualizarCitasFuturas()
        {
        boolean resp = false;
        try{
            String sql = "EXEC CAJA_ACTUALIZAR_CITAS_FUTURA ?,?,?";
            PreparedStatement cmd = getCn().prepareStatement(sql);
            cmd.setInt(1, getCA_ID());
            cmd.setInt(2, getCONTADOR_CITAS());
            cmd.setInt(3, getCITAS_CAJA());

            if(!cmd.execute())
            {
                resp = true;
            }
            cmd.close();
            getCn().close();
        }
        catch(Exception ex)
        {
            System.out.println("ErrorCITAS FUTURAS : " + ex.getMessage());
        }
        return resp;
    }
    
    public boolean ActualizarCitasAdicionales()
        {
        boolean resp = false;
        try{
            String sql = "EXEC CAJA_ACTUALIZAR_CITAS_ADICIONAL ?,?,?";
            PreparedStatement cmd = getCn().prepareStatement(sql);
            cmd.setInt(1, getCA_ID());
            cmd.setInt(2, getCONTADOR_CITAS());
            cmd.setInt(3, getCITAS_CAJA());

            if(!cmd.execute())
            {
                resp = true;
            }
            cmd.close();
            getCn().close();
        }
        catch(Exception ex)
        {
            System.out.println("Error CITAS ADICIONALES : " + ex.getMessage());
        }
        return resp;
    }
     
    public void listarEmpresa(String Servicio ,JTable tabla){
    String consulta="";
        try {
            tabla.setModel(new DefaultTableModel());
            String titulos[]={"Codigo","Forma de Pago","Distrito","Representante","RUC","Direccion","Telefono","","","","","","",""};
            m=new DefaultTableModel(null,titulos);
            JTable p=new JTable(m);
            String fila[]=new String[14];
            //int index = cbxTipoBusqueda.getSelectedIndex();
            consulta="EXEC Caja_EmpresaJerarquia_LISTAR ?";
            PreparedStatement cmd = getCn().prepareStatement(consulta);
            cmd.setString(1, Servicio);
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

                    m.addRow(fila);
                    c++;
            }
            tabla.setModel(m);
            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m);
            tabla.setRowSorter(elQueOrdena);
            tabla.setModel(m);
            formatoTablaEmpresa(tabla);
        } catch (Exception e) {
            System.out.println("Error: listarEmpresa : " + e.getMessage());
        }
    }
    public void formatoTablaEmpresa(JTable tabla){
        tabla.getColumnModel().getColumn(0).setMinWidth(0);
        tabla.getColumnModel().getColumn(0).setMaxWidth(0); 
        tabla.getColumnModel().getColumn(1).setMinWidth(0);
        tabla.getColumnModel().getColumn(1).setMaxWidth(0); 
        tabla.getColumnModel().getColumn(2).setMinWidth(0);
        tabla.getColumnModel().getColumn(2).setMaxWidth(0); 
        tabla.getColumnModel().getColumn(3).setPreferredWidth(150); 
        tabla.getColumnModel().getColumn(4).setPreferredWidth(100); 
        tabla.getColumnModel().getColumn(5).setPreferredWidth(200); 
        tabla.getColumnModel().getColumn(6).setMinWidth(0);
        tabla.getColumnModel().getColumn(6).setMaxWidth(0); 
        tabla.getColumnModel().getColumn(7).setMinWidth(0);
        tabla.getColumnModel().getColumn(7).setMaxWidth(0); 
        tabla.getColumnModel().getColumn(8).setMinWidth(0);
        tabla.getColumnModel().getColumn(8).setMaxWidth(0); 
        tabla.getColumnModel().getColumn(9).setMinWidth(0);
        tabla.getColumnModel().getColumn(9).setMaxWidth(0); 
        tabla.getColumnModel().getColumn(10).setPreferredWidth(150); 
        tabla.getColumnModel().getColumn(11).setMinWidth(0);
        tabla.getColumnModel().getColumn(11).setMaxWidth(0); 
        tabla.getColumnModel().getColumn(12).setMinWidth(0);
        tabla.getColumnModel().getColumn(12).setMaxWidth(0); 
        tabla.getColumnModel().getColumn(13).setMinWidth(0);
        tabla.getColumnModel().getColumn(13).setMaxWidth(0); 
//        
  
        tabla.setRowHeight(40);
    }
      
    public void ReporteDiariocajaCabecera(String Usuario,Integer SESION,JTable tabla){
    String consulta="";
        try {
            tabla.setModel(new DefaultTableModel());
            String titulos[]={"Documento","Serie - Nº Documento","Forma de Pago","Paciente","HC","C","Estado","Descuento","Total","Fecha","Hora","Am","ID","VISIBLE"};
            m=new DefaultTableModel(null,titulos);
            JTable p=new JTable(m);
            String fila[]=new String[14];
            //int index = cbxTipoBusqueda.getSelectedIndex();
            consulta="EXEC CAJA_CONSULTAR_REPORTE_DIA_PC ?,?";
            PreparedStatement cmd = getCn().prepareStatement(consulta);
            cmd.setString(1, Usuario);
            cmd.setInt(2, SESION);
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

                    m.addRow(fila);
                    c++;
            }
            tabla.setModel(m);
            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m);
            tabla.setRowSorter(elQueOrdena);
            tabla.setModel(m);
            formatoTablaReporteCabecera(tabla);
        } catch (Exception e) {
            System.out.println("Error: listar REPORTE CABECERA" + e.getMessage());
        }
    }
    public void ReporteFechasCajaCabecera(String Usuario,int Desde, int Hasta,String des,JTable tabla){
    String consulta="";
        try {
            tabla.setModel(new DefaultTableModel());
            String titulos[]={"Documento","Serie - Nº Documento","Forma de Pago","Paciente","HC","C","Estado","Descuento","Total","Fecha","Hora","Am","ID","VISIBLE"};
            m=new DefaultTableModel(null,titulos);
            JTable p=new JTable(m);
            String fila[]=new String[14];
            //int index = cbxTipoBusqueda.getSelectedIndex();
            consulta="EXEC CAJA_CONSULTAR_REPORTE_FECHAS_PC ?,?,?,?";
            PreparedStatement cmd = getCn().prepareStatement(consulta);
            cmd.setString(1, Usuario);
            cmd.setInt(2, Desde);
            cmd.setInt(3, Hasta);
            cmd.setString(4, des);
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

                    m.addRow(fila);
                    c++;
            }
            tabla.setModel(m);
            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m);
            tabla.setRowSorter(elQueOrdena);
            tabla.setModel(m);
            formatoTablaReporteCabecera(tabla);
        } catch (Exception e) {
            System.out.println("Error: listar REPORTE FECHAS" + e.getMessage());
        }
    }
    public void ReporteFechasCajeros(int Desde, int Hasta,JTable tabla){
    String consulta="";
        try {
            tabla.setModel(new DefaultTableModel());
            String titulos[]={"Día","Nº de Ventas","Cod_usu","Cantidad en Soles","Fecha","Hospital","Imagen","Cajero","Usuario","Mes"};
            m=new DefaultTableModel(null,titulos);
            JTable p=new JTable(m);
            String fila[]=new String[10];
            //int index = cbxTipoBusqueda.getSelectedIndex();
            consulta="EXEC CAJA_REPORTE_MENSUAL_CAJEROS ?,?";
            PreparedStatement cmd = getCn().prepareStatement(consulta);
            cmd.setInt(1, Desde);
            cmd.setInt(2, Hasta);
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

                    m.addRow(fila);
                    c++;
            }
            tabla.setModel(m);
            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m);
            tabla.setRowSorter(elQueOrdena);
            tabla.setModel(m);
            formatoTablaReporteCajeros(tabla);
        } catch (Exception e) {
            System.out.println("Error: listar REPORTE CAJEROS" + e.getMessage());
        }
    }
      
    public void ReporteDiariocajaCabeceraCC(String Servicio,JTable tabla){
        String consulta="";
        try {
            tabla.setModel(new DefaultTableModel());
            String titulos[]={"Documento","Nº Documento","Forma de Pago","DNI","HC","C","Estado","Descuento","Total","Fecha","Hora","Am","ID","VISIBLE"};
            m=new DefaultTableModel(null,titulos);
            JTable p=new JTable(m);
            String fila[]=new String[14];
            //int index = cbxTipoBusqueda.getSelectedIndex();
            consulta="exec CAJA_CONSULTAR_ACTOMEDICODNI ?";
            PreparedStatement cmd = getCn().prepareStatement(consulta);
            cmd.setString(1, Servicio);
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

                    m.addRow(fila);
                    c++;
            }
            tabla.setModel(m);
            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m);
            tabla.setRowSorter(elQueOrdena);
            tabla.setModel(m);
            formatoTablaReporteCabecera(tabla);
        } catch (Exception e) {
            System.out.println("Error: listar CABECERA REPORTE" + e.getMessage());
        }
    }
      
    public void formatoTablaReporteCabecera(JTable tabla){

            tabla.getColumnModel().getColumn(0).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(200);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(150);
//            tabla.getColumnModel().getColumn(3).setMinWidth(0);
//            tabla.getColumnModel().getColumn(3).setMaxWidth(0);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(4).setMinWidth(0);
            tabla.getColumnModel().getColumn(4).setMaxWidth(0);
            tabla.getColumnModel().getColumn(5).setMinWidth(0);
            tabla.getColumnModel().getColumn(5).setMaxWidth(0);
            tabla.getColumnModel().getColumn(6).setPreferredWidth(170);
            tabla.getColumnModel().getColumn(7).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(8).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(9).setPreferredWidth(130);
            tabla.getColumnModel().getColumn(10).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(11).setMinWidth(0);
            tabla.getColumnModel().getColumn(11).setMaxWidth(0);
            tabla.getColumnModel().getColumn(12).setMinWidth(0);
            tabla.getColumnModel().getColumn(12).setMaxWidth(0);
            tabla.getColumnModel().getColumn(13).setMinWidth(0);
            tabla.getColumnModel().getColumn(13).setMaxWidth(0);
        
//        tabla.getColumnModel().getColumn(2).setPreferredWidth(50); 
//        tabla.getColumnModel().getColumn(3).setPreferredWidth(50); 
//        tabla.getColumnModel().getColumn(4).setPreferredWidth(50); 
//        tabla.getColumnModel().getColumn(5).setPreferredWidth(150); 
//        
  
        tabla.setRowHeight(40);
        
    }
    public void formatoTablaReporteCajeros(JTable tabla){

            tabla.getColumnModel().getColumn(0).setPreferredWidth(80);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(2).setMinWidth(0);
            tabla.getColumnModel().getColumn(2).setMaxWidth(0);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(80);
            tabla.getColumnModel().getColumn(4).setMinWidth(0);
            tabla.getColumnModel().getColumn(4).setMaxWidth(0);
            tabla.getColumnModel().getColumn(5).setMinWidth(0);
            tabla.getColumnModel().getColumn(5).setMaxWidth(0);
            tabla.getColumnModel().getColumn(6).setMinWidth(0);
            tabla.getColumnModel().getColumn(6).setMaxWidth(0);
            tabla.getColumnModel().getColumn(7).setPreferredWidth(300);
            tabla.getColumnModel().getColumn(8).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(9).setMinWidth(0);
            tabla.getColumnModel().getColumn(9).setMaxWidth(0);

        
//        tabla.getColumnModel().getColumn(2).setPreferredWidth(50); 
//        tabla.getColumnModel().getColumn(3).setPreferredWidth(50); 
//        tabla.getColumnModel().getColumn(4).setPreferredWidth(50); 
//        tabla.getColumnModel().getColumn(5).setPreferredWidth(150); 
//        
  
        tabla.setRowHeight(40);
        
    }
      
    public void ReporteDiariocajaDetalleCC(String Servicio,JTable tabla){
        String consulta="";
        try {
            tabla.setModel(new DefaultTableModel());
            String titulos[]={"CPT","Precio","Departamento / Área","Precio Unitario","Descuento","Total","Médico/Personal","Nº Atencion","Turno","doc"};
            m=new DefaultTableModel(null,titulos);
            JTable p=new JTable(m);
            String fila[]=new String[10];
            //int index = cbxTipoBusqueda.getSelectedIndex();
            consulta="exec CAJA_CONSULTAR_ACTOMEDICODNI_DET ?";
            PreparedStatement cmd = getCn().prepareStatement(consulta);
            cmd.setString(1, Servicio); ///bus1 esto se busca
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
//                fila[10]=r.getString(11);
//                fila[11]=r.getString(12);
//                fila[12]=r.getString(13);
//                fila[13]=r.getString(14);

                    m.addRow(fila);
                    c++;
            }
            tabla.setModel(m);
            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m);
            tabla.setRowSorter(elQueOrdena);
            tabla.setModel(m);
            formatoTablaDetalleReporte(tabla);
        } catch (Exception e) {
            System.out.println("Error: listar detalle REPORTE " + e.getMessage());
        }
    }
      
    public void formatoTablaDetalleReporte(JTable tabla){
        tabla.getColumnModel().getColumn(0).setPreferredWidth(430);
        tabla.getColumnModel().getColumn(1).setMinWidth(0);
        tabla.getColumnModel().getColumn(1).setMaxWidth(0);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(150);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(4).setMinWidth(0);
        tabla.getColumnModel().getColumn(4).setMaxWidth(0);
        tabla.getColumnModel().getColumn(5).setMinWidth(0);
        tabla.getColumnModel().getColumn(5).setMaxWidth(0);
//        tabla.getColumnModel().getColumn(4).setPreferredWidth(80);
//        tabla.getColumnModel().getColumn(5).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(6).setPreferredWidth(220);
        tabla.getColumnModel().getColumn(7).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(8).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(9).setMinWidth(0);
        tabla.getColumnModel().getColumn(9).setMaxWidth(0);
        
//        tabla.getColumnModel().getColumn(2).setPreferredWidth(50); 
//        tabla.getColumnModel().getColumn(3).setPreferredWidth(50); 
//        tabla.getColumnModel().getColumn(4).setPreferredWidth(50); 
//        tabla.getColumnModel().getColumn(5).setPreferredWidth(150); 
//        
  
        tabla.setRowHeight(40);
    }
    
    public void FORMAPAGO(String Servicio,JTable tabla){
        String consulta="";
        try {
            tabla.setModel(new DefaultTableModel());
            String titulos[]={null};
            m=new DefaultTableModel(null,titulos);
            JTable p=new JTable(m);
            String fila[]=new String[1];
            //int index = cbxTipoBusqueda.getSelectedIndex();
            consulta="exec CAJA_BUSCAR_JERARQUIASFP ?";
            PreparedStatement cmd = getCn().prepareStatement(consulta);
            cmd.setString(1, Servicio);
            ResultSet r= cmd.executeQuery();
            int c=1;
            while(r.next()){
                fila[0]=r.getString(1);
                    m.addRow(fila);
                    c++;
            }
            
            tabla.setModel(m);
            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m);
            tabla.setRowSorter(elQueOrdena);
            tabla.setModel(m);
            
//            tabla.setTableHeader(null);

        } catch (Exception e) {
            System.out.println("Error: listar CABECERA REPORTE" + e.getMessage());
        }
    }
      
      
      /////////////////////////////////////////////PREVENTAS
    public void CAJA_PREVENTAS_TBC(String Texto,JTable tabla){
    String consulta="";
        try {
            tabla.setModel(new DefaultTableModel());
            String titulos[]={"Fecha","Hora","Médico Solicitante","Forma de Pago","LA Solicitado","","","","","",""};
            m=new DefaultTableModel(null,titulos);
            JTable p=new JTable(m);
            String fila[]=new String[11];
            //int index = cbxTipoBusqueda.getSelectedIndex();
            consulta="exec CAJA_PREVENTAS_TBC ?";
            PreparedStatement cmd = getCn().prepareStatement(consulta);
            cmd.setString(1, Texto);
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

                        m.addRow(fila);
                        c++;
                }
            tabla.setModel(m);
            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m);
            tabla.setRowSorter(elQueOrdena);
            tabla.setModel(m);
            formatoPreventaTBC(tabla);
        } catch (Exception e) {
            System.out.println("Error: PREVENTA TBC: " + e.getMessage());
        }
    }
    public void formatoPreventaTBC(JTable tabla){
        tabla.getColumnModel().getColumn(0).setPreferredWidth(70);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(50);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(250);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(150);
        tabla.getColumnModel().getColumn(5).setMinWidth(0);
        tabla.getColumnModel().getColumn(5).setMaxWidth(0);
        tabla.getColumnModel().getColumn(6).setMinWidth(0);
        tabla.getColumnModel().getColumn(6).setMaxWidth(0);
        tabla.getColumnModel().getColumn(7).setMinWidth(0);
        tabla.getColumnModel().getColumn(7).setMaxWidth(0);
        tabla.getColumnModel().getColumn(8).setMinWidth(0);
        tabla.getColumnModel().getColumn(8).setMaxWidth(0);
        tabla.getColumnModel().getColumn(9).setMinWidth(0);
        tabla.getColumnModel().getColumn(9).setMaxWidth(0);
        tabla.getColumnModel().getColumn(10).setMinWidth(0);
        tabla.getColumnModel().getColumn(10).setMaxWidth(0);
        tabla.setRowHeight(40);
    }
      ////////////////////FR
    public void CAJA_PREVENTAS_FR(String Texto,JTable tabla){
    String consulta="";
        try {
            tabla.setModel(new DefaultTableModel());
            String titulos[]={"Forma Pago","DNI","Paciente","Fecha","id","Total","Quimico","Serie","Correlativo"};
            m=new DefaultTableModel(null,titulos);
            JTable p=new JTable(m);
            String fila[]=new String[9];
            //int index = cbxTipoBusqueda.getSelectedIndex();
            consulta="exec CAJA_PREVENTAS_FARMACIA_LOCAL ?";
            PreparedStatement cmd = getCn().prepareStatement(consulta);
            cmd.setString(1, Texto);
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
                        m.addRow(fila);
                        c++;
                }
            tabla.setModel(m);
            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m);
            tabla.setRowSorter(elQueOrdena);
            tabla.setModel(m);
            formatoPreventaFR(tabla);
        } catch (Exception e) {
            System.out.println("Error: PREVENTA FR: " + e.getMessage());
        }
    }
    public void formatoPreventaFR(JTable tabla){
        tabla.getColumnModel().getColumn(0).setPreferredWidth(70);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(50);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(250);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(4).setMinWidth(0);
        tabla.getColumnModel().getColumn(4).setMaxWidth(0);
        tabla.getColumnModel().getColumn(5).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(6).setMinWidth(0);
        tabla.getColumnModel().getColumn(6).setMaxWidth(0);
        tabla.getColumnModel().getColumn(7).setMinWidth(0);
        tabla.getColumnModel().getColumn(7).setMaxWidth(0);
        tabla.getColumnModel().getColumn(8).setMinWidth(0);
        tabla.getColumnModel().getColumn(8).setMaxWidth(0);
        tabla.setRowHeight(40);
    }
      
    public void CAJA_PREVENTAS_FR_DETALLE(String Texto,JTable tabla){
    String consulta="";
        try {
            tabla.setModel(new DefaultTableModel());
            String titulos[]={"ID_CAB","Descripción","Cantidad","Precio","estado","cod_precio","cod_nome_caja","descripcion_nomen_tipo","nomen_caja"};
            m=new DefaultTableModel(null,titulos);
            JTable p=new JTable(m);
            String fila[]=new String[9];
            //int index = cbxTipoBusqueda.getSelectedIndex();
            consulta="exec CAJA_PREVENTAS_FARMACIA_DETALLE_LOCAL ?";
            PreparedStatement cmd = getCn().prepareStatement(consulta);
            cmd.setString(1, Texto);
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
                        m.addRow(fila);
                        c++;
                }
            tabla.setModel(m);
            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m);
            tabla.setRowSorter(elQueOrdena);
            tabla.setModel(m);
            formatoPreventaFR_DETALLE(tabla);
        } catch (Exception e) {
            System.out.println("Error: PREVENTA FR DETALLE: " + e.getMessage());
        }
    }
    
    public void formatoPreventaFR_DETALLE(JTable tabla){
        tabla.getColumnModel().getColumn(0).setMinWidth(0);
        tabla.getColumnModel().getColumn(0).setMaxWidth(0);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(300);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(50);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(50);
        tabla.getColumnModel().getColumn(4).setMinWidth(0);
        tabla.getColumnModel().getColumn(4).setMaxWidth(0);
        tabla.getColumnModel().getColumn(5).setMinWidth(0);
        tabla.getColumnModel().getColumn(5).setMaxWidth(0);
        tabla.getColumnModel().getColumn(6).setMinWidth(0);
        tabla.getColumnModel().getColumn(6).setMaxWidth(0);
        tabla.getColumnModel().getColumn(7).setMinWidth(0);
        tabla.getColumnModel().getColumn(7).setMaxWidth(0);
        tabla.getColumnModel().getColumn(8).setMinWidth(0);
        tabla.getColumnModel().getColumn(8).setMaxWidth(0);
        tabla.setRowHeight(40);
    }
     
    public void ReporteFechasCajaCabeceraCC6(String Usuario,int Desde, int Hasta,String des,String CC6 ,JTable tabla){
    String consulta="";
        try {
            tabla.setModel(new DefaultTableModel());
            String titulos[]={"id__detalle","documento","Serie - Nº Documento","CPT","Cantidad","Precio","Total","Cuenta 6"};
            m=new DefaultTableModel(null,titulos);
            JTable p=new JTable(m);
            String fila[]=new String[8];
            //int index = cbxTipoBusqueda.getSelectedIndex();
            consulta="EXEC CAJA_REPORTE_FECHAS_CC6 ?,?,?,?,?";
            PreparedStatement cmd = getCn().prepareStatement(consulta);
            cmd.setString(1, Usuario);
            cmd.setInt(2, Desde);
            cmd.setInt(3, Hasta);
            cmd.setString(4, des);
            cmd.setString(5, CC6);
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


                    m.addRow(fila);
                    c++;
            }
            tabla.setModel(m);
            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m);
            tabla.setRowSorter(elQueOrdena);
            tabla.setModel(m);
            formatoTablaReporteCabeceraCC6(tabla);
        } catch (Exception e) {
            System.out.println("Error: listar REPORTE FECHAS CC6 " + e.getMessage());
        }
    }
    
    public void formatoTablaReporteCabeceraCC6(JTable tabla){
        tabla.getColumnModel().getColumn(0).setMinWidth(0);
        tabla.getColumnModel().getColumn(0).setMaxWidth(0);
        tabla.getColumnModel().getColumn(1).setMinWidth(0);
        tabla.getColumnModel().getColumn(1).setMaxWidth(0);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(120);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(350);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(60);
        tabla.getColumnModel().getColumn(5).setPreferredWidth(60);
        tabla.getColumnModel().getColumn(6).setPreferredWidth(60);
        tabla.getColumnModel().getColumn(7).setMinWidth(0);
        tabla.getColumnModel().getColumn(7).setMaxWidth(0);
      
        
//        tabla.getColumnModel().getColumn(2).setPreferredWidth(50); 
//        tabla.getColumnModel().getColumn(3).setPreferredWidth(50); 
//        tabla.getColumnModel().getColumn(4).setPreferredWidth(50); 
//        tabla.getColumnModel().getColumn(5).setPreferredWidth(150); 
//        
  
        tabla.setRowHeight(40);
        
    }
            
    public void CAJA_LIQUIDACION_ALTA(String Texto,JTable tabla){
    String consulta="";
        try {
            tabla.setModel(new DefaultTableModel());
            String titulos[]={"Documento","Fecha","Acto Médico","CPT","Área","Cantidad","Precio","Total","COD_NOMEN","ID","IDDET"};
            m=new DefaultTableModel(null,titulos);
            JTable p=new JTable(m);
            String fila[]=new String[11];
            //int index = cbxTipoBusqueda.getSelectedIndex();
            consulta="exec CAJA_CONSOLIDADO_CREDITO_HOSPITALARIO ?";
            PreparedStatement cmd = getCn().prepareStatement(consulta);
            cmd.setString(1, Texto);
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
                        m.addRow(fila);
                        c++;
                }
            tabla.setModel(m);
            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m);
            tabla.setRowSorter(elQueOrdena);
            tabla.setModel(m);
            formatoTablaLiquidacion(tabla);
        } catch (Exception e) {
            System.out.println("Error: LISTAR LIQUIDACION " + e.getMessage());
        }
    }
    
    public void CAJA_VERIFICAR_HOSPITALIZACION(String Texto,JTable tabla){
    String consulta="";
        try {
            tabla.setModel(new DefaultTableModel());
            String titulos[]={"ID"};
            m=new DefaultTableModel(null,titulos);
            JTable p=new JTable(m);
            String fila[]=new String[1];
            //int index = cbxTipoBusqueda.getSelectedIndex();
            consulta="exec CAJA_VERIFICAR_HOSPITALIZACION ?";
            PreparedStatement cmd = getCn().prepareStatement(consulta);
            cmd.setString(1, Texto);
            ResultSet r= cmd.executeQuery();
            int c=1;
            while(r.next()){
                    fila[0]=r.getString(1); 
                        m.addRow(fila);
                        c++;
                }
            tabla.setModel(m);
            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m);
            tabla.setRowSorter(elQueOrdena);
            tabla.setModel(m);
        } catch (Exception e) {
            System.out.println("Error: BUSCAR HOSPITALIZACION " + e.getMessage());
        }
    }
    public void formatoTablaLiquidacion(JTable tabla){

        tabla.getColumnModel().getColumn(0).setPreferredWidth(120);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(60);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(350);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(5).setPreferredWidth(60);
        tabla.getColumnModel().getColumn(6).setPreferredWidth(60);
        tabla.getColumnModel().getColumn(7).setPreferredWidth(60);
        tabla.getColumnModel().getColumn(8).setMinWidth(0);
        tabla.getColumnModel().getColumn(8).setMaxWidth(0);
        tabla.getColumnModel().getColumn(9).setMinWidth(0);
        tabla.getColumnModel().getColumn(9).setMaxWidth(0);
        tabla.getColumnModel().getColumn(10).setMinWidth(0);
        tabla.getColumnModel().getColumn(10).setMaxWidth(0);       
//        tabla.getColumnModel().getColumn(2).setPreferredWidth(50); 
//        tabla.getColumnModel().getColumn(3).setPreferredWidth(50); 
//        tabla.getColumnModel().getColumn(4).setPreferredWidth(50); 
//        tabla.getColumnModel().getColumn(5).setPreferredWidth(150); 
        tabla.setRowHeight(40);
        
    }  
//    public void ReporteDiario_fua(String ID){
//            
//    try{
//	    String dir= "/Reportes/cajaCentral/FUA.jrxml";
//	    JasperReport reporteJasper = JasperCompileManager.compileReport(dir);
//	    Map parametro = new HashMap();
//	    parametro.put("ID", ID);
//	    JasperPrint mostrarReporte = JasperFillManager.fillReport(reporteJasper,parametro, con.conectar());
////
//	   
////            JasperPrint mostrarReporte = JasperFillManager.fillReport(getClass().getResourceAsStream("/Reportes/cajaCentral/FUA.jasper"), parametro, con.conectar()); 
//
//	// ESTABLECE DATOS DE IMPRESORAS
//
//	    PrinterJob job = PrinterJob.getPrinterJob();
//	    PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
//	    int selectedService = 0;
//	    for(int i = 0; i < services.length;i++){
//	    if(services[i].getName().toUpperCase().contains("Hewlett-Packard HP LaserJet Professional P 1102w")){
//	    selectedService = i;
//	    }
//	    }
//	      job.setPrintService(services[selectedService]);
//	      PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();
//	      MediaSizeName mediaSizeName = MediaSize.findMedia(4,4,MediaPrintableArea.INCH);
//	      printRequestAttributeSet.add(mediaSizeName);
//	      printRequestAttributeSet.add(new Copies(1));
//	      JRPrintServiceExporter exporter;
//	      exporter = new JRPrintServiceExporter();
//	      exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, services[selectedService]);
//	    exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET, services[selectedService].getAttributes());
//	    exporter.setParameter(JRPrintServiceExporterParameter.PRINT_REQUEST_ATTRIBUTE_SET, printRequestAttributeSet);
//	    exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG, Boolean.FALSE);
//	    exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.FALSE);
//	    exporter.setParameter(JRExporterParameter.JASPER_PRINT, mostrarReporte);
//
//	    exporter.exportReport();
//
//    }catch(JRException ex){
//
//        JOptionPane.showMessageDialog(null, "Error de JREEXEPCION: " + ex);
//
// 
//
//    } catch (PrinterException ex) {
//
//        JOptionPane.showMessageDialog(null,"ERROR PRINTEREXCEPCION " + ex);
//
//    }
//
// 
//
//}
    
 
    
    public void FUA(String ID, String IM){
        try {
            Map parametros = new HashMap();
            parametros.put("ID", ID);
            //E:\\HIMS_SIS\\PRUEBASIS\\src\\
            //jrxml
            String report = JasperCompileManager.compileReportToFile("C:\\FUA\\FUA.jrxml");
            JasperPrint jasperPrint = JasperFillManager.fillReport(report, parametros, con.conectar());
            PrinterJob printerJob = PrinterJob.getPrinterJob();
            PageFormat pageFormat = PrinterJob.getPrinterJob().defaultPage();
            printerJob.defaultPage(pageFormat);
            int selectedService = 0;
            AttributeSet attributeSet = new HashPrintServiceAttributeSet(new PrinterName(IM, null));
            PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, attributeSet);
            try {
                printerJob.setPrintService(printService[selectedService]);
            } catch (Exception e) {
                System.out.println(e);
            }
            JRPrintServiceExporter exporter;
            PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();
            printRequestAttributeSet.add(MediaSizeName.NA_LETTER);
            printRequestAttributeSet.add(new Copies(1));
            // these are deprecated
            exporter = new JRPrintServiceExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, printService[selectedService]);
            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET, printService[selectedService].getAttributes());
            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_REQUEST_ATTRIBUTE_SET, printRequestAttributeSet);
            exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG, Boolean.FALSE);
            exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.FALSE);
            exporter.exportReport();

        } catch (JRException e) {
            e.printStackTrace();
        }
    }
     
    public Caja_NuevaVenta(){
        Conexion con = new Conexion();
        cn = con.conectar();
    }

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }

    public String getId_documento() {
        return id_documento;
    }

    public void setId_documento(String id_documento) {
        this.id_documento = id_documento;
    }

    public String getCod_tipo_documento() {
        return cod_tipo_documento;
    }

    public void setCod_tipo_documento(String cod_tipo_documento) {
        this.cod_tipo_documento = cod_tipo_documento;
    }

    public String getCod_jerar_forma_pago() {
        return cod_jerar_forma_pago;
    }

    public void setCod_jerar_forma_pago(String cod_jerar_forma_pago) {
        this.cod_jerar_forma_pago = cod_jerar_forma_pago;
    }

    public String getId_hc() {
        return id_hc;
    }

    public void setId_hc(String id_hc) {
        this.id_hc = id_hc;
    }

    public String getCod_motiv_anu() {
        return cod_motiv_anu;
    }

    public void setCod_motiv_anu(String cod_motiv_anu) {
        this.cod_motiv_anu = cod_motiv_anu;
    }

    public String getSerie_documento() {
        return serie_documento;
    }

    public void setSerie_documento(String serie_documento) {
        this.serie_documento = serie_documento;
    }

    public String getNum_documento() {
        return num_documento;
    }

    public void setNum_documento(String num_documento) {
        this.num_documento = num_documento;
    }

    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    public String getCod_usu() {
        return cod_usu;
    }

    public void setCod_usu(String cod_usu) {
        this.cod_usu = cod_usu;
    }

    public String getId_liquidacion() {
        return id_liquidacion;
    }

    public void setId_liquidacion(String id_liquidacion) {
        this.id_liquidacion = id_liquidacion;
    }

    public int getCorrelativo() {
        return Correlativo;
    }

    public void setCorrelativo(int Correlativo) {
        this.Correlativo = Correlativo;
    }

    public int getId_ActoMedico() {
        return Id_ActoMedico;
    }

    public void setId_ActoMedico(int Id_ActoMedico) {
        this.Id_ActoMedico = Id_ActoMedico;
    }

    public int getId_Cta_Abono() {
        return id_Cta_Abono;
    }

    public void setId_Cta_Abono(int id_Cta_Abono) {
        this.id_Cta_Abono = id_Cta_Abono;
    }

    public Double getDevolucion_doc() {
        return devolucion_doc;
    }

    public void setDevolucion_doc(Double devolucion_doc) {
        this.devolucion_doc = devolucion_doc;
    }

    public String getCod_usu_anu() {
        return cod_usu_anu;
    }

    public void setCod_usu_anu(String cod_usu_anu) {
        this.cod_usu_anu = cod_usu_anu;
    }
    
///////////////////////////////////////////////ACTO MEDICO

    public int getID_ACTOMEDICO1() {
        return ID_ACTOMEDICO1;
    }

    public void setID_ACTOMEDICO1(int ID_ACTOMEDICO1) {
        this.ID_ACTOMEDICO1 = ID_ACTOMEDICO1;
    }

    public int getNUM_ACTOMEDICO() {
        return NUM_ACTOMEDICO;
    }

    public void setNUM_ACTOMEDICO(int NUM_ACTOMEDICO) {
        this.NUM_ACTOMEDICO = NUM_ACTOMEDICO;
    }

    public String getFECHA_TERMINO() {
        return FECHA_TERMINO;
    }

    public void setFECHA_TERMINO(String FECHA_TERMINO) {
        this.FECHA_TERMINO = FECHA_TERMINO;
    }

    public String getDURACION() {
        return DURACION;
    }

    public void setDURACION(String DURACION) {
        this.DURACION = DURACION;
    }
    
    public Conexion getCon() {
        return con;
    }

    public void setCon(Conexion con) {
        this.con = con;
    }

    public int getCA_ID() {
        return CA_ID;
    }

    public void setCA_ID(int CA_ID) {
        this.CA_ID = CA_ID;
    }

    public int getCONTADOR_CITAS() {
        return CONTADOR_CITAS;
    }

    public void setCONTADOR_CITAS(int CONTADOR_CITAS) {
        this.CONTADOR_CITAS = CONTADOR_CITAS;
    }

    public int getCITAS_CAJA() {
        return CITAS_CAJA;
    }

    public void setCITAS_CAJA(int CITAS_CAJA) {
        this.CITAS_CAJA = CITAS_CAJA;
    }

    public String getESTADOP() {
        return ESTADOP;
    }

    public void setESTADOP(String ESTADOP) {
        this.ESTADOP = ESTADOP;
    }

    public String getCod_empre_jerar() {
        return cod_empre_jerar;
    }

    public void setCod_empre_jerar(String cod_empre_jerar) {
        this.cod_empre_jerar = cod_empre_jerar;
    }

    public String getUsu_Exoneracion() {
        return Usu_Exoneracion;
    }

    public void setUsu_Exoneracion(String Usu_Exoneracion) {
        this.Usu_Exoneracion = Usu_Exoneracion;
    }

    public String getPorcentaje_Exoneracion() {
        return porcentaje_Exoneracion;
    }

    public void setPorcentaje_Exoneracion(String porcentaje_Exoneracion) {
        this.porcentaje_Exoneracion = porcentaje_Exoneracion;
    }

    public double getDESCUENTO() {
        return DESCUENTO;
    }

    public void setDESCUENTO(double DESCUENTO) {
        this.DESCUENTO = DESCUENTO;
    }

    public double getTOTAL_DOCUUMENTO() {
        return TOTAL_DOCUUMENTO;
    }

    public void setTOTAL_DOCUUMENTO(double TOTAL_DOCUUMENTO) {
        this.TOTAL_DOCUUMENTO = TOTAL_DOCUUMENTO;
    }

    public int getIdDetalle() {
        return IdDetalle;
    }

    public void setIdDetalle(int IdDetalle) {
        this.IdDetalle = IdDetalle;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getEstadoVisibleAdmision() {
        return EstadoVisibleAdmision;
    }

    public void setEstadoVisibleAdmision(String EstadoVisibleAdmision) {
        this.EstadoVisibleAdmision = EstadoVisibleAdmision;
    }

    public int getId_Cod_det() {
        return Id_Cod_det;
    }

    public void setId_Cod_det(int Id_Cod_det) {
        this.Id_Cod_det = Id_Cod_det;
    }

    public int getID_SESION() {
        return ID_SESION;
    }

    public void setID_SESION(int ID_SESION) {
        this.ID_SESION = ID_SESION;
    }

    public String getFUA() {
        return FUA;
    }

    public void setFUA(String FUA) {
        this.FUA = FUA;
    }

    public double getIGV() {
        return IGV;
    }

    public void setIGV(double IGV) {
        this.IGV = IGV;
    }

    public double getSUBTOTAL() {
        return SUBTOTAL;
    }

    public void setSUBTOTAL(double SUBTOTAL) {
        this.SUBTOTAL = SUBTOTAL;
    }

    public double getREDONDEO() {
        return REDONDEO;
    }

    public void setREDONDEO(double REDONDEO) {
        this.REDONDEO = REDONDEO;
    }
    
    

}
