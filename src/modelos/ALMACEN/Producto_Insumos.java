/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.ALMACEN;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import servicios.Conexion;

/**
 *
 * @author PC-SISTEMA
 */
public class Producto_Insumos {
      private Connection cn;
      private String cod_produc;
      private String unidad_medida;
      private int cantidad_medida;
      private int cod_unidad;
      
     public Producto_Insumos()
    {
        Conexion con = new Conexion();
        cn = con.conectar();
    }
     
 public boolean ASIGNAR_UNIDAD_MEDIDA_MODIFICAR()
        {
        boolean resp = false;
        try
        {
            String sql = "exec ASIGNAR_UNIDAD_MEDIDA_MODIFICAR ?,?";
            PreparedStatement cmd = getCn().prepareStatement(sql);
            cmd.setString(1, getCod_produc());
            cmd.setInt(2, getCantidad_medida());
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
         
          public boolean Unidad_Medida_guardar()
        {
        boolean resp = false;
        try
        {
            String sql = "exec sp_UNIDAD_MEDIDA_insertar ?";
            PreparedStatement cmd = getCn().prepareStatement(sql);
            cmd.setString(1, getUnidad_medida());
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
           public int Unidad_Medida_ver(String nombre)
    {
        int resultado=0;
        try
        {
            String sql = "SELECT * FROM ALMACEN_UNIDAD_MEDIDA where unidad_medida=? AND estado_unidad_med='A'";
            PreparedStatement cmd = getCn().prepareStatement(sql);
            cmd.setString(1, nombre);
            ResultSet rs = cmd.executeQuery();
            for (int i=0; rs.next (); i++)
            {
               resultado++;
            }
            
            cmd.close();
            getCn().close();
        }
        catch(Exception ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }
        return resultado;
    }
          
 public boolean ASIGNAR_UNIDAD_MEDIDA()
        {
        boolean resp = false;
        try
        {
            String sql = "exec ASIGNAR_UNIDAD_MEDIDA ?,?";
            PreparedStatement cmd = getCn().prepareStatement(sql);
            cmd.setString(1, getCod_produc());
            cmd.setInt(2, getCod_unidad());
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
     * @return the cantidad_medida
     */
    public int getCantidad_medida() {
        return cantidad_medida;
    }

    /**
     * @param cantidad_medida the cantidad_medida to set
     */
    public void setCantidad_medida(int cantidad_medida) {
        this.cantidad_medida = cantidad_medida;
    }

    /**
     * @return the cod_produc
     */
    public String getCod_produc() {
        return cod_produc;
    }

    /**
     * @param cod_produc the cod_produc to set
     */
    public void setCod_produc(String cod_produc) {
        this.cod_produc = cod_produc;
    }

    /**
     * @return the cod_unidad
     */
    public int getCod_unidad() {
        return cod_unidad;
    }

    /**
     * @param cod_unidad the cod_unidad to set
     */
    public void setCod_unidad(int cod_unidad) {
        this.cod_unidad = cod_unidad;
    }

    /**
     * @return the unidad_medida
     */
    public String getUnidad_medida() {
        return unidad_medida;
    }

    /**
     * @param unidad_medida the unidad_medida to set
     */
    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }
    
}
