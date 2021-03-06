/*
    YAMILA ROCCA RUIZ
 */
package tablas;

import java.awt.Color;
import java.awt.Component;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import vista.ConsultorioEx.ConsultorioAsignacion;

public class FormatoTablaConsultorioExtAlertas extends DefaultTableCellRenderer{
 
    private Component componente;

    
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        componente = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        //Dar color a las HC con estado Salida
        //if(table.getValueAt(row, 6).equals("Salida")){
            //componente.setBackground(new Color(255,85,64));
        //}
        try {
         if(table.getValueAt(row, 14).equals("A")){/*YA ATENDIDO*/
            componente.setBackground(new Color(23,160,134));
        
   
        } else
          if(table.getValueAt(row, 14).equals(" ")){/*NO SE HA ATENDIDO*/
            componente.setBackground(new Color(232,76,61));
        
   
        }
//          else
//              if(table.getValueAt(row, 6).equals(fechaMañana())){/*POSTERIOR VERDE*/
//            componente.setBackground(new Color(50,151,219));
//        
//   
//        }
//          else
//       
//            componente.setBackground(new Color(41,127,184)); 
         
   
        } catch (Exception e) {
        }
        
        
        return componente;
    }
    
    public static String fechaActual(){
        java.sql.Date now = new java.sql.Date(System.currentTimeMillis());
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        return date.format(now);
    }
    public static String fechaAyer(){
Calendar calendar = Calendar.getInstance(); 
calendar.add(Calendar.DATE, -1); 
SimpleDateFormat tesedata = new SimpleDateFormat("dd/MM/yyyy"); 
String a;
a=tesedata.format(calendar.getTime());
//System.out.println(tesedata.format(calendar.getTime()));  
return a;
    }
    
     public static String fechaMañana(){
Calendar calendar = Calendar.getInstance(); 
calendar.add(Calendar.DATE, +1); 
SimpleDateFormat tesedata = new SimpleDateFormat("dd/MM/yyyy"); 
String a;
a=tesedata.format(calendar.getTime());
//System.out.println("la fecha de maña es"+tesedata.format(calendar.getTime()));  
return a;
    }
    
    
    
}
