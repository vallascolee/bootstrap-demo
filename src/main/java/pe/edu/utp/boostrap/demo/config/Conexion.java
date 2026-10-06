
package pe.edu.utp.boostrap.demo.config;
 
import java.sql.*; 
 
public class Conexion { 
 
    public static Connection getConexion() 
throws Exception { 
Class.forName("com.mysql.cj.jdbc.Driver"); 
return DriverManager.getConnection( 
"jdbc:mysql://localhost:3306/tienda", 
"root", "12345678"); 
} 
}
