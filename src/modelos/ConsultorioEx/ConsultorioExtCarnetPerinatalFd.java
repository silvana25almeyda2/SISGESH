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
import javax.swing.table.DefaultTableModel;
import servicios.Conexion;
import vista.ConsultorioEx.RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V;

public class ConsultorioExtCarnetPerinatalFd implements Serializable {
    private static final long serialVersionUID = 1L;

    DefaultTableModel m;
    Conexion con = new Conexion();
    private Connection cn;
    private int cpId;
    private int fdId;
    private String fdNCigarros;
    private String fdDroga;
    private String fechaActu;
    private String horaActu;
    private String nomPc;
    private Character estado;
    private String codUsu;
    private int idActoMedico;

    public boolean mantenimientoConsultorioExtCarnetPerinatalFd(String tipo)
        {
        boolean resp = false;
        try{
            String sql = "[CONSULTORIO_EXT_MANTENIMIENTO_CARNET_PERINATAL_FD] ?,?,?,?,?,?,?";
            PreparedStatement cmd = getCn().prepareStatement(sql);
            cmd.setInt(1, getFdId());
            cmd.setInt(2, getCpId());
            cmd.setString(3, getFdNCigarros());
            cmd.setString(4, getFdDroga());
            cmd.setString(5, getCodUsu());
            cmd.setString(6, tipo);
            cmd.setInt(7, getIdActoMedico());
            if(!cmd.execute())
            {
                resp = true;
            }
            cmd.close();
        }
        catch(Exception ex)
        {
            System.out.println("Error: mantenimientoConsultorioExtCarnetPerinatalFd: " + ex.getMessage());
        }
        return resp;
    }
    
    public String perinatalFdID()
    {
        String cod="";
        try
        {
            String sql = "SELECT TOP 1 FD_ID\n" +
                        "FROM CONSULTORIO_EXT_CARNET_PERINATAL_FD \n" +
                        "WHERE NOM_PC = HOST_NAME()\n" +
                        "ORDER BY FD_ID DESC ";
            PreparedStatement cmd = getCn().prepareStatement(sql);
            ResultSet rs = cmd.executeQuery();
            if(rs.next())
            {
               cod = rs.getString(1);
            }
        }
        catch(Exception ex)
        {
            System.out.println("perinatalFdID: " + ex.getMessage());
        }
        return cod;
    }   
    
    public void ConsultoriosExtFdListar(String cp_id){
        String consulta="";
        try {
            consulta="[CONSULTORIO_EXT_LISTAR_CARNET_PERINATAL_FD] ?";
            PreparedStatement cmd = getCn().prepareStatement(consulta);
            cmd.setString(1, cp_id);
            ResultSet r= cmd.executeQuery();
            int c=1;
            while(r.next()){
                RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.lblIdFd.setText(r.getString(1)); 
                RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.txtNCigarros.setText(r.getString(3)); 
                if(r.getString(4).equals("SI"))
                    RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.chkFdSi.setText("X"); 
                if(r.getString(4).equals("NO"))
                    RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.chkFdNo.setText("X"); 
                
                RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.lblIdActoMedico.setText(r.getString(5)); 
                RegistroEmbarazoPT_A_TS_F_D_FUM_H_E_V.lblActoMedico.setText("Acto Médico de registro " + r.getString(6)); 
            }
            //
        } catch (Exception e) {
            System.out.println("Error: ConsultoriosExtFdListar: " + e.getMessage());
        }
    }
    
    public ConsultorioExtCarnetPerinatalFd() {
        Conexion con = new Conexion();
        cn = con.conectar();
    }

    public ConsultorioExtCarnetPerinatalFd(int fdId) {
        this.fdId = fdId;
    }

    public int getFdId() {
        return fdId;
    }

    public void setFdId(int fdId) {
        this.fdId = fdId;
    }

    public String getFdNCigarros() {
        return fdNCigarros;
    }

    public void setFdNCigarros(String fdNCigarros) {
        this.fdNCigarros = fdNCigarros;
    }

    public String getFdDroga() {
        return fdDroga;
    }

    public void setFdDroga(String fdDroga) {
        this.fdDroga = fdDroga;
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
        return "modelos.ConsultorioEx.ConsultorioExtCarnetPerinatalFd[ fdId=" + fdId + " ]";
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
