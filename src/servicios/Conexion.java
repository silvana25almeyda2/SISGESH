//OFICIAL
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;



/**
 *
 * @author Profe
 */
public class Conexion {
<<<<<<< HEAD

    static String servidor="localhost";
    static String puerto="1433";
    static String user="sa";
    static String password="sistemas";
    static String baseDatos="SISGESH_NET";
=======
    
     static String servidor="";
     static String puerto="";
     static String user="";
     static String password="";
     static String baseDatos="";
    public void leerTexto(String direccion){
        try {
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            String bfRead;
            int cont = 0;
            while((bfRead = bf.readLine()) != null){
                cont = cont + 1;
                if (cont ==1){
                    servidor = "" + bfRead + "";
                }
                if (cont ==2){
                    puerto = "" + bfRead + "";
                }
                if (cont ==3){
                    user = "" + bfRead + "";
                }
                if (cont ==4){
                    password = "" + bfRead + "";
                }
                if (cont ==5){
                    baseDatos = "" + bfRead + "";
                }
            }
        } catch (Exception e) {
            System.out.println("No se encontró el archivo");
        }
    }
    
>>>>>>> e9d8d6cc2bf077359bc7faafffb7a9325bb3310d
    Connection conexion=null;
       
     public Connection conectar(){
        try{
            leerTexto("C:\\Program Files\\SOFT\\conexion.txt");
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://"+servidor+":"+puerto+";"+"databaseName="+baseDatos
                    +";user="+user+";password="+password;
            conexion=DriverManager.getConnection(url);
//             System.out.println("Conexión exitosa");
        }
        catch(Exception ex)
        {   
            JOptionPane.showMessageDialog(null, "No se ha podido conectar al servidor");
            System.out.println("Error de conexion: " + ex.getMessage());
        }
        return conexion;
    }
     
     public ResultSet Listar(String cad){
        try {
            String url="jdbc:sqlserver://"+servidor+":"+puerto+";"+"databaseName="+baseDatos
                    +";user="+user+";password="+password;
            conexion=DriverManager.getConnection(url);
            
            PreparedStatement da=conexion.prepareStatement(cad);
            ResultSet tbl=da.executeQuery();
            return tbl;
        } catch (Exception e) {
            return null;
        }
    }
//
//     
//        public static void main(String[] args) throws SQLException {
//        Conexion conexion = new Conexion();
//        Connection con = conexion.conectar();
//        }

     }
