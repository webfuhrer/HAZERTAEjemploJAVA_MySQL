/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionmysql;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Admin
 */
public class ConexionMySQL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     String usuario="root";
     String password="";
     String ruta_mysql="jdbc:mysql://localhost:3306/bd_hazerta3";
        try {
            Connection c=DriverManager.getConnection(ruta_mysql, usuario, password);
            Statement stmt=c.createStatement();
            String sql="SELECT * FROM alumnos   where edad>=18";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next())
            {
                String nombre=rs.getString("nombre");
                String apellido=rs.getString("apellido");
                int edad=rs.getInt("edad");
                System.out.println("REGISTRO: "+nombre+" "+apellido+" "+edad);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ConexionMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }
    
}
