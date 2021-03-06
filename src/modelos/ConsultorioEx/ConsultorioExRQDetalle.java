/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.ConsultorioEx;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import servicios.Conexion;

/**
 *
 * @author PC02
 */
public class ConsultorioExRQDetalle {
    DefaultTableModel m;
    Conexion con = new Conexion();
    private Connection cn;
    private int id;
    private int rq_id;
    private int id_cie10;
    private String fecha_actu;
    private String hora_actu;
    private String nom_pc;
    private String estado;
    private String usuario;
    
    public boolean mantenimientoConsultorioExRQDetalle(String tipo)
        {
        boolean resp = false;
        try{
            String sql = "CONSULTORIO_EXT_RQ_DETALLE_MANTENIMIENTO ?,?,?,?,?";
            PreparedStatement cmd = getCn().prepareStatement(sql);
            cmd.setInt(1, getId());
            cmd.setInt(2, getRq_id());
            cmd.setInt(3, getId_cie10());
            cmd.setString(4, getUsuario());
            cmd.setString(5, tipo);
            if(!cmd.execute())
            {
                resp = true;
            }
            cmd.close();
        }
        catch(Exception ex)
        {
            System.out.println("Error: mantenimientoConsultorioExRQDetalle: " + ex.getMessage());
        }
        return resp;
    }
    
    public void formatoTablaDiagnosticos(JTable tabla){
        tabla.getColumnModel().getColumn(0).setPreferredWidth(50);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(60);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(350);
//        COLUMNAS OCULTAS
//        TableColumn columna = tabla.getColumnModel().getColumn(0);
//            columna.setMaxWidth(0);
//            columna.setMinWidth(0);
//            columna.setPreferredWidth(0);
//            tabla.doLayout();
        tabla.setRowHeight(30);
    }
    
    public void listarDiagnosticos(String id, JTable tabla){
    String consulta="";
        try {
                tabla.setModel(new DefaultTableModel());
                String titulos[]={"ID CIE 10","Código CIE 10","Diagnósticos"};
                m=new DefaultTableModel(null,titulos);
                JTable p=new JTable(m);
                String fila[]=new String[3];
                //int index = cbxTipoBusqueda.getSelectedIndex();
                consulta="EXEC CONSULTORIO_EXT_RQ_DETALLE_LISTAR ?";
                PreparedStatement cmd = getCn().prepareStatement(consulta);
                cmd.setString(1, id);
                ResultSet r= cmd.executeQuery();
                int c=1;
                while(r.next()){
                    fila[0]=r.getString(1); // id
                    fila[1]=r.getString(2); // dni
                    fila[2]=r.getString(3); // nhc
                        m.addRow(fila);
                        c++;
                }
            tabla.setModel(m);
            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m);
            tabla.setRowSorter(elQueOrdena);
            tabla.setModel(m);
            formatoTablaDiagnosticos(tabla);
        } catch (Exception e) {
            System.out.println("Error: listarDiagnosticos: " + e.getMessage());
        }
    }
    
    public void formatoTablaNomenclatura(JTable tabla){
        tabla.getColumnModel().getColumn(0).setPreferredWidth(50);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(60);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(350);
//        COLUMNAS OCULTAS
//        TableColumn columna = tabla.getColumnModel().getColumn(0);
//            columna.setMaxWidth(0);
//            columna.setMinWidth(0);
//            columna.setPreferredWidth(0);
//            tabla.doLayout();
        tabla.setRowHeight(30);
    }
    
    public void listarNomenclatura(String id, JTable tabla){
    String consulta="";
        try {
                tabla.setModel(new DefaultTableModel());
                String titulos[]={"ID","CPT","Nomenclatura"};
                m=new DefaultTableModel(null,titulos);
                JTable p=new JTable(m);
                String fila[]=new String[3];
                //int index = cbxTipoBusqueda.getSelectedIndex();
                consulta="EXEC CAJA_DETALLE_PREVENTA_LISTAR_CONSULTORIO_EXT_RQ ?";
                PreparedStatement cmd = getCn().prepareStatement(consulta);
                cmd.setString(1, id);
                ResultSet r= cmd.executeQuery();
                int c=1;
                while(r.next()){
                    fila[0]=r.getString(1); // id
                    fila[1]=r.getString(2); // dni
                    fila[2]=r.getString(3); // nhc
                        m.addRow(fila);
                        c++;
                }
            tabla.setModel(m);
            TableRowSorter<TableModel> elQueOrdena=new TableRowSorter<TableModel>(m);
            tabla.setRowSorter(elQueOrdena);
            tabla.setModel(m);
            formatoTablaNomenclatura(tabla);
        } catch (Exception e) {
            System.out.println("Error: listarNomenclatura: " + e.getMessage());
        }
    }
    
    public ConsultorioExRQDetalle()
    {
        Conexion con = new Conexion();
        cn = con.conectar();
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
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the rq_id
     */
    public int getRq_id() {
        return rq_id;
    }

    /**
     * @param rq_id the rq_id to set
     */
    public void setRq_id(int rq_id) {
        this.rq_id = rq_id;
    }

    /**
     * @return the id_cie10
     */
    public int getId_cie10() {
        return id_cie10;
    }

    /**
     * @param id_cie10 the id_cie10 to set
     */
    public void setId_cie10(int id_cie10) {
        this.id_cie10 = id_cie10;
    }

    /**
     * @return the fecha_actu
     */
    public String getFecha_actu() {
        return fecha_actu;
    }

    /**
     * @param fecha_actu the fecha_actu to set
     */
    public void setFecha_actu(String fecha_actu) {
        this.fecha_actu = fecha_actu;
    }

    /**
     * @return the hora_actu
     */
    public String getHora_actu() {
        return hora_actu;
    }

    /**
     * @param hora_actu the hora_actu to set
     */
    public void setHora_actu(String hora_actu) {
        this.hora_actu = hora_actu;
    }

    /**
     * @return the nom_pc
     */
    public String getNom_pc() {
        return nom_pc;
    }

    /**
     * @param nom_pc the nom_pc to set
     */
    public void setNom_pc(String nom_pc) {
        this.nom_pc = nom_pc;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
