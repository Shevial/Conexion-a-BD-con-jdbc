package javamysql;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conectar {
    //jdbc, servidor o localhost 127.0.0.1,nombre base de datos
    //cuidado con trabajar en root
    //clave nunca vacia
    public static final String URL = "jdbc:mysql://localhost:3306/prueba";
    public static final String USER = "root";
    public static final String CLAVE = "";
     
    public Connection getConexion(){
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, USER, CLAVE);
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return con;
    }
    
}