package javamysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ControlDatos {
    private Conectar conectar;
    private ModeloDatos modelo;
    private Connection con;
    
    public ControlDatos(){
        conectar = new Conectar();
        modelo = new ModeloDatos();
    }
    public void insertar(String nombre, int edad, String Curso){
        PreparedStatement ps;
        String sql;
        modelo.setNombre(nombre);
        modelo.setEdad(edad);
        modelo.setCurso(Curso);
        try{
            con = conectar.getConexion();
            sql = "insert into alumnos(nombre, edad, curso) values(?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, modelo.getNombre());
            ps.setInt(2, modelo.getEdad());
            ps.setString(3, modelo.getCurso());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se han insertado los datos");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }
    }
}