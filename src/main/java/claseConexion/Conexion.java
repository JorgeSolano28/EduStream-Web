package claseConexion;
import java.sql.*;


//creación de paquete conexion específico para la clase conexión, más legible y mejor en buenas prácticas
public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/edustream_db";
    private static final String USER = "root";
    private static final String PASS = "1234";
    
    public static Connection getConexion() throws SQLException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASS);
        }catch (ClassNotFoundException e){
            throw new SQLException("Driver MySQL no encontrado, agregar el archivo .jar?", e);
        }
    }
}