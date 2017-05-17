/*
 
 */
package modelos.Programas;

import modelos.*;
import modelos.LABORATORIO.*;
import tablas.*;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class FormatoTablasSolic extends DefaultTableCellRenderer{
    private Component componente;
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        componente = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        //Dar color 
        //if(table.getValueAt(row, 6).equals("Salida")){
            //componente.setBackground(new Color(255,85,64));
        //}
        
        //Para dar Color-descomentar
        if(table.getValueAt(row, 37).equals("          ")||table.getValueAt(row, 34).equals("          ")){     
            componente.setBackground(new Color(224,196,141));
//          componente.setBackground(new Color(242,136,136));
            componente.setForeground(new Color(30,30,30));        
//            componente.setForeground(new Color(255,255,255));
        } else {
             componente.setBackground(new Color(255,255,255));
            componente.setForeground(new Color(30,30,30));
        }
        return componente;
    }
}
