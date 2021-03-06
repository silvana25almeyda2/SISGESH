/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.ConsultorioEx;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import servicios.Conexion;
import vista.ConsultorioEx.RegistroEmbarazoAtencionesP;
import vista.ConsultorioEx.RegistroEmbarazoEXF;

/**
 *
 * FORMULARIO DE ATENCIONES PRENATALES
 */
public class ConsultorioExtCarnetPerinatalAtencionPrenatal implements Serializable {
    private static final long serialVersionUID = 1L;
    DefaultTableModel m;
    Conexion con = new Conexion();
    private Connection cn;
    private int cpId;
    private int apId;
    private String apEdadSem;
    private String apPesoMadre;
    private String apTemp;
    private String apPa;
    private String apPm;
    private String apAu;
    private String apSit;
    private String apPres;
    private String apPosicion;
    private String apFcf;
    private String apMovFet;
    private String apProtei;
    private String apEdema;
    private String apRo;
    private String apExPezon;
    private String apIndicFierro;
    private String apIndicCalcio;
    private String apIndicAcFolico;
    private String apOrientConsej;
    private String apEgEco;
    private String apPerfilBio;
    private String apCita;
    private String apVisitDomic;
    private String apPlanParto;
    private String apEstabAtencion;
    private String apRespAtencion;
    private String apSis;
    private String apAtencion;
    private String fechaActu;
    private String horaActu;
    private String nomPc;
    private Character estado;
    private String codUsu;
    private int idActoMedico;

    public boolean mantenimientoConsultorioExtCarnetPerinatalAtencionPrenatal(String tipo)
        {
        boolean resp = false;
        try{
            String sql = "CONSULTORIO_EXT_MANTENIMIENTO_CARNET_PERINATAL_ATENCION_PRENATAL ?,?,?,?,?,?,?,?,?,?,"
                    + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
            PreparedStatement cmd = getCn().prepareStatement(sql);
            cmd.setInt(1, getApId());
            cmd.setInt(2, getCpId());
            cmd.setString(3, getApEdadSem());
            cmd.setString(4, getApPesoMadre());
            cmd.setString(5, getApTemp());
            cmd.setString(6, getApPa());
            cmd.setString(7, getApPm());
            cmd.setString(8, getApAu());
            cmd.setString(9, getApSit());
            cmd.setString(10, getApPres());
            cmd.setString(11, getApPosicion());
            cmd.setString(12, getApFcf());
            cmd.setString(13, getApMovFet());
            cmd.setString(14, getApProtei());
            cmd.setString(15, getApEdema());
            cmd.setString(16, getApRo());
            cmd.setString(17, getApExPezon());
            cmd.setString(18, getApIndicFierro());
            cmd.setString(19, getApIndicCalcio());
            cmd.setString(20, getApIndicAcFolico());
            cmd.setString(21, getApOrientConsej());
            cmd.setString(22, getApEgEco());
            cmd.setString(23, getApPerfilBio());
            cmd.setString(24, getApCita());
            cmd.setString(25, getApVisitDomic());
            cmd.setString(26, getApPlanParto());
            cmd.setString(27, getApEstabAtencion());
            cmd.setString(28, getApRespAtencion());
            cmd.setString(29, getApSis());
            cmd.setString(30, getCodUsu());
            cmd.setString(31, getApAtencion());
            cmd.setString(32, tipo);
            cmd.setInt(33, getIdActoMedico());
            if(!cmd.execute())
            {
                resp = true;
            }
            cmd.close();
        }
        catch(Exception ex)
        {
            System.out.println("Error: mantenimientoConsultorioExtCarnetPerinatalAtencionPrenatal: " + ex.getMessage());
        }
        return resp;
    }
    
    public String perinatalAtencionPrenatalID()
    {
        String cod="";
        try
        {
            String sql = "SELECT TOP 1 AP_ID\n" +
                        "FROM CONSULTORIO_EXT_CARNET_PERINATAL_ATENCION_PRENATAL \n" +
                        "WHERE NOM_PC = HOST_NAME()\n" +
                        "ORDER BY AP_ID DESC ";
            PreparedStatement cmd = getCn().prepareStatement(sql);
            ResultSet rs = cmd.executeQuery();
            if(rs.next())
            {
               cod = rs.getString(1);
            }
        }
        catch(Exception ex)
        {
            System.out.println("perinatalAtencionPrenatalID: " + ex.getMessage());
        }
        return cod;
    }   
    
    public void ConsultoriosExtAtencionPrenatalListar(String cp_id,String atencion){
        String consulta="";
        try {
            consulta="[CONSULTORIO_EXT_LISTAR_CARNET_PERINATAL_ATENCION_PRENATAL] ?,?";
            PreparedStatement cmd = getCn().prepareStatement(consulta);
            cmd.setString(1, cp_id);
            cmd.setString(2, atencion);
            ResultSet r= cmd.executeQuery();
            int c=1;
            while(r.next()){
                RegistroEmbarazoAtencionesP.lblMant.setText("U");
                RegistroEmbarazoAtencionesP.lblId.setText(r.getString(1)); 
                RegistroEmbarazoAtencionesP.txtEdad.setText(r.getString(3)); 
                RegistroEmbarazoAtencionesP.txtPesoMadre.setText(r.getString(4)); 
                RegistroEmbarazoAtencionesP.txtTemp.setText(r.getString(5)); 
                RegistroEmbarazoAtencionesP.txtPA.setText(r.getString(6)); 
                RegistroEmbarazoAtencionesP.txtPm.setText(r.getString(7)); 
                RegistroEmbarazoAtencionesP.txtAu.setText(r.getString(8)); 
                RegistroEmbarazoAtencionesP.txtSituacion.setText(r.getString(9)); 
                RegistroEmbarazoAtencionesP.txtPresentacion.setText(r.getString(10)); 
                RegistroEmbarazoAtencionesP.txtPosicion.setText(r.getString(11)); 
                RegistroEmbarazoAtencionesP.txtFcf.setText(r.getString(12)); 
                RegistroEmbarazoAtencionesP.txtMovFetal.setText(r.getString(13)); 
                RegistroEmbarazoAtencionesP.txtProteinuria.setText(r.getString(14)); 
                RegistroEmbarazoAtencionesP.txtEdema.setText(r.getString(15)); 
                RegistroEmbarazoAtencionesP.txtReflejo.setText(r.getString(16)); 
                RegistroEmbarazoAtencionesP.txtExamenP.setText(r.getString(17)); 
                RegistroEmbarazoAtencionesP.txtIndicFierro.setText(r.getString(18)); 
                RegistroEmbarazoAtencionesP.txtIndicCalcio.setText(r.getString(19)); 
                RegistroEmbarazoAtencionesP.txtIndicFolico.setText(r.getString(20)); 
                RegistroEmbarazoAtencionesP.txtOrient.setText(r.getString(21));
                RegistroEmbarazoAtencionesP.txtEco.setText(r.getString(22)); 
                RegistroEmbarazoAtencionesP.txtPerfilBiofisico.setText(r.getString(23)); 
                try {
                  if(r.getString(24).equals("")){
                  RegistroEmbarazoAtencionesP.dtCita.setDate(null);
                } else {
                    String fechaSeleccionadaejec = (String)(r.getString(24));
                    DateFormat dfoejec = new SimpleDateFormat("dd/MM/yyyy");
                    Date fechaejec = dfoejec.parse(fechaSeleccionadaejec);
                    RegistroEmbarazoAtencionesP.dtCita.setDate(fechaejec);
                }
                } catch (Exception e) {
                }
                RegistroEmbarazoAtencionesP.txtVisitDomic.setText(r.getString(25));  
                RegistroEmbarazoAtencionesP.txtPlanParto.setText(r.getString(26)); 
                RegistroEmbarazoAtencionesP.txtEstabAtencion.setText(r.getString(27)); 
                RegistroEmbarazoAtencionesP.txtResponAtencion.setText(r.getString(28));  
                RegistroEmbarazoAtencionesP.txtFUA.setText(r.getString(29)); 
                RegistroEmbarazoAtencionesP.lblIdActoMedico.setText(r.getString(36)); 
                RegistroEmbarazoAtencionesP.lblActoMedico.setText("Acto Médico de registro " + r.getString(38)); 
            }
            //
        } catch (Exception e) {
            System.out.println("Error: ConsultoriosExtAtencionPrenatalListar: " + e.getMessage());
        }
    }
    
    public void formatoTablaConsultorioExAtencionPrenatalAlertas(JTable tabla){
        tabla.getColumnModel().getColumn(0).setPreferredWidth(0);//
        tabla.getColumnModel().getColumn(1).setPreferredWidth(0);//
        tabla.getColumnModel().getColumn(2).setPreferredWidth(140);//
        tabla.getColumnModel().getColumn(3).setPreferredWidth(140);//
        tabla.getColumnModel().getColumn(4).setPreferredWidth(330);//
        tabla.getColumnModel().getColumn(5).setPreferredWidth(150);//
        tabla.getColumnModel().getColumn(6).setPreferredWidth(160);//
        tabla.getColumnModel().getColumn(7).setPreferredWidth(160);//
        tabla.getColumnModel().getColumn(8).setPreferredWidth(0);//
        tabla.getColumnModel().getColumn(9).setPreferredWidth(0);//
        tabla.getColumnModel().getColumn(10).setPreferredWidth(0);//
        tabla.getColumnModel().getColumn(11).setPreferredWidth(0);//
        tabla.getColumnModel().getColumn(12).setPreferredWidth(0);//
        tabla.getColumnModel().getColumn(13).setPreferredWidth(0);//
        TableColumn columna = tabla.getColumnModel().getColumn(0);
            columna.setMaxWidth(0);
            columna.setMinWidth(0);
            columna.setPreferredWidth(0);
            tabla.doLayout();
        TableColumn columna1 = tabla.getColumnModel().getColumn(1);
            columna1.setMaxWidth(0);
            columna1.setMinWidth(0);
            columna1.setPreferredWidth(0);
        TableColumn columna8 = tabla.getColumnModel().getColumn(8);
            columna8.setMaxWidth(0);
            columna8.setMinWidth(0);
            columna8.setPreferredWidth(0);
        TableColumn columna9 = tabla.getColumnModel().getColumn(9);
            columna9.setMaxWidth(0);
            columna9.setMinWidth(0);
            columna9.setPreferredWidth(0);
        TableColumn columna10 = tabla.getColumnModel().getColumn(10);
            columna10.setMaxWidth(0);
            columna10.setMinWidth(0);
            columna10.setPreferredWidth(0);
        TableColumn columna11 = tabla.getColumnModel().getColumn(11);
            columna11.setMaxWidth(0);
            columna11.setMinWidth(0);
            columna11.setPreferredWidth(0);
        TableColumn columna12 = tabla.getColumnModel().getColumn(12);
            columna12.setMaxWidth(0);
            columna12.setMinWidth(0);
            columna12.setPreferredWidth(0);
        TableColumn columna13 = tabla.getColumnModel().getColumn(13);
            columna13.setMaxWidth(0);
            columna13.setMinWidth(0);
            columna13.setPreferredWidth(0);
        tabla.doLayout();
        TableColumn columna14 = tabla.getColumnModel().getColumn(14);
            columna14.setMaxWidth(0);
            columna14.setMinWidth(0);
            columna14.setPreferredWidth(0);
        tabla.doLayout();
        tabla.setRowHeight(35);
    }
    
    public void consultorioExAtencionPrenatalAlertas(String busqueda,JTable tabla){
    String consulta="";
        try {
            tabla.setModel(new DefaultTableModel());
            String titulos[]={"ID","CP","DNI","Nº H.C.","Paciente","Edad","Cita","Mes",
            "","","","","","",""};
            m=new DefaultTableModel(null,titulos);
            JTable p=new JTable(m);
            String fila[]=new String[15];
            //int index = cbxTipoBusqueda.getSelectedIndex();
            consulta="EXEC [CONSULTORIO_EXT_CARNET_PERINATAL_ATENCION_PRENATAL_ALERTAS] ?";
            PreparedStatement cmd = getCn().prepareStatement(consulta);
            cmd.setString(1, busqueda);
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
                    m.addRow(fila);
                    c++;
            }
            tabla.setModel(m);
            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m);
            tabla.setRowSorter(elQueOrdena);
            tabla.setModel(m);
            formatoTablaConsultorioExAtencionPrenatalAlertas(tabla);
        } catch (Exception e) {
            System.out.println("Error: consultorioExAtencionPrenatalAlertas: " + e.getMessage());
        }
    }
    
    public String calculoAlertas(){
        String cod = "";
        try {
            String consulta = "EXEC CONSULTORIO_EXT_CARNET_PERINATAL_ATENCION_PRENATAL_CALCULO_ALERTAS";
            ResultSet r;
            r=con.Listar(consulta);
        if(r.next()){
               cod = r.getString(1);
        }
        }catch(Exception ex){
        }
        return cod;
    }
    
    public ConsultorioExtCarnetPerinatalAtencionPrenatal() {
        Conexion con = new Conexion();
        cn = con.conectar();
    }

    public ConsultorioExtCarnetPerinatalAtencionPrenatal(int apId) {
        this.apId = apId;
    }

    public int getApId() {
        return apId;
    }

    public void setApId(int apId) {
        this.apId = apId;
    }

    public String getApEdadSem() {
        return apEdadSem;
    }

    public void setApEdadSem(String apEdadSem) {
        this.apEdadSem = apEdadSem;
    }

    public String getApPesoMadre() {
        return apPesoMadre;
    }

    public void setApPesoMadre(String apPesoMadre) {
        this.apPesoMadre = apPesoMadre;
    }

    public String getApTemp() {
        return apTemp;
    }

    public void setApTemp(String apTemp) {
        this.apTemp = apTemp;
    }

    public String getApPa() {
        return apPa;
    }

    public void setApPa(String apPa) {
        this.apPa = apPa;
    }

    public String getApPm() {
        return apPm;
    }

    public void setApPm(String apPm) {
        this.apPm = apPm;
    }

    public String getApAu() {
        return apAu;
    }

    public void setApAu(String apAu) {
        this.apAu = apAu;
    }

    public String getApSit() {
        return apSit;
    }

    public void setApSit(String apSit) {
        this.apSit = apSit;
    }

    public String getApPres() {
        return apPres;
    }

    public void setApPres(String apPres) {
        this.apPres = apPres;
    }

    public String getApPosicion() {
        return apPosicion;
    }

    public void setApPosicion(String apPosicion) {
        this.apPosicion = apPosicion;
    }

    public String getApFcf() {
        return apFcf;
    }

    public void setApFcf(String apFcf) {
        this.apFcf = apFcf;
    }

    public String getApMovFet() {
        return apMovFet;
    }

    public void setApMovFet(String apMovFet) {
        this.apMovFet = apMovFet;
    }

    public String getApProtei() {
        return apProtei;
    }

    public void setApProtei(String apProtei) {
        this.apProtei = apProtei;
    }

    public String getApEdema() {
        return apEdema;
    }

    public void setApEdema(String apEdema) {
        this.apEdema = apEdema;
    }

    public String getApRo() {
        return apRo;
    }

    public void setApRo(String apRo) {
        this.apRo = apRo;
    }

    public String getApExPezon() {
        return apExPezon;
    }

    public void setApExPezon(String apExPezon) {
        this.apExPezon = apExPezon;
    }

    public String getApIndicFierro() {
        return apIndicFierro;
    }

    public void setApIndicFierro(String apIndicFierro) {
        this.apIndicFierro = apIndicFierro;
    }

    public String getApIndicCalcio() {
        return apIndicCalcio;
    }

    public void setApIndicCalcio(String apIndicCalcio) {
        this.apIndicCalcio = apIndicCalcio;
    }

    public String getApIndicAcFolico() {
        return apIndicAcFolico;
    }

    public void setApIndicAcFolico(String apIndicAcFolico) {
        this.apIndicAcFolico = apIndicAcFolico;
    }

    public String getApOrientConsej() {
        return apOrientConsej;
    }

    public void setApOrientConsej(String apOrientConsej) {
        this.apOrientConsej = apOrientConsej;
    }

    public String getApEgEco() {
        return apEgEco;
    }

    public void setApEgEco(String apEgEco) {
        this.apEgEco = apEgEco;
    }

    public String getApPerfilBio() {
        return apPerfilBio;
    }

    public void setApPerfilBio(String apPerfilBio) {
        this.apPerfilBio = apPerfilBio;
    }

    public String getApCita() {
        return apCita;
    }

    public void setApCita(String apCita) {
        this.apCita = apCita;
    }

    public String getApVisitDomic() {
        return apVisitDomic;
    }

    public void setApVisitDomic(String apVisitDomic) {
        this.apVisitDomic = apVisitDomic;
    }

    public String getApPlanParto() {
        return apPlanParto;
    }

    public void setApPlanParto(String apPlanParto) {
        this.apPlanParto = apPlanParto;
    }

    public String getApEstabAtencion() {
        return apEstabAtencion;
    }

    public void setApEstabAtencion(String apEstabAtencion) {
        this.apEstabAtencion = apEstabAtencion;
    }

    public String getApRespAtencion() {
        return apRespAtencion;
    }

    public void setApRespAtencion(String apRespAtencion) {
        this.apRespAtencion = apRespAtencion;
    }

    public String getApSis() {
        return apSis;
    }

    public void setApSis(String apSis) {
        this.apSis = apSis;
    }

    public String getApAtencion() {
        return apAtencion;
    }

    public void setApAtencion(String apAtencion) {
        this.apAtencion = apAtencion;
    }

    public String getFechaActu() {
        return fechaActu;
    }

    public void setFechaActu(String fechaActu) {
        this.fechaActu = fechaActu;
    }

    public String getHoraActu() {
        return horaActu;
    }

    public void setHoraActu(String horaActu) {
        this.horaActu = horaActu;
    }

    public String getNomPc() {
        return nomPc;
    }

    public void setNomPc(String nomPc) {
        this.nomPc = nomPc;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public String getCodUsu() {
        return codUsu;
    }

    public void setCodUsu(String codUsu) {
        this.codUsu = codUsu;
    }

    @Override
    public String toString() {
        return "modelos.ConsultorioEx.ConsultorioExtCarnetPerinatalAtencionPrenatal[ apId=" + apId + " ]";
    }

    /**
     * @return the cn
     */
    public Connection getCn() {
        return cn;
    }

    /**
     * @param cn the cn to set
     */
    public void setCn(Connection cn) {
        this.cn = cn;
    }

    /**
     * @return the cpId
     */
    public int getCpId() {
        return cpId;
    }

    /**
     * @param cpId the cpId to set
     */
    public void setCpId(int cpId) {
        this.cpId = cpId;
    }

    /**
     * @return the idActoMedico
     */
    public int getIdActoMedico() {
        return idActoMedico;
    }

    /**
     * @param idActoMedico the idActoMedico to set
     */
    public void setIdActoMedico(int idActoMedico) {
        this.idActoMedico = idActoMedico;
    }
    
}
