
package claseDAO;
import java.sql.*;
import claseConexion.Conexion;
import clasePOJOS.Estudiante;
import clasePOJOS.Profesor;
import clasePOJOS.Rol;
import clasePOJOS.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    
    //Insertar usuario
    public void insertarUsuario(String nombre, String email, String password, Rol rol) {
        String query = "INSERT INTO usuarios(nombre,email,password,rol) VALUES (?,?,?,?)";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, nombre);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setString(4, rol.name()); // "ESTUDIANTE" o "PROFESOR"*************

            ps.executeUpdate();
            System.out.println("Nuevo usuario insertado correctamente");

        } catch (SQLException e) {
            System.out.println("ERROR al insertar nuevo usuario");
            e.printStackTrace();
        }
    }
    
    //Leer usuario
    public void leerUsuario() {
        String query = "SELECT * FROM usuarios";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id_usuario");
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");
                String rol = rs.getString("rol");

                System.out.println("Id de Usuario: " + id);
                System.out.println("Nombre: " + nombre);
                System.out.println("Email: " + email);
                System.out.println("Rol: " + rol);
                System.out.println();
            }

        } catch (SQLException e) {
            System.out.println("ERROR al leer usuarios");
            e.printStackTrace();
        }
    }
    
    //Actualizar usuario
    public void actualizarUsuario(int id, String nombre, String email, String password, String rol) {
        String query = "UPDATE usuarios SET nombre=?, email=?, password=?, rol=? WHERE id_usuario=?";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, nombre);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setString(4, rol);
            ps.setInt(5, id);

            ps.executeUpdate();
            System.out.println("Dato actualizado correctamente");

        } catch (SQLException e) {
            System.out.println("ERROR al actualizar dato");
            e.printStackTrace();
        }
    }
    
    public void actualizarNombre(int id, String nuevoNombre) {
        String query = "UPDATE usuarios SET nombre=? WHERE id_usuario=?";
        try (Connection conn = Conexion.getConexion(); 
                PreparedStatement ps = conn.prepareStatement(query)){

            ps.setString(1, nuevoNombre);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("Nombre actualizado correctamente");

        } catch (SQLException e) {
            System.out.println("ERROR al actualizar nombre de usuario");
            e.printStackTrace();
        }
    }
    
    public void actualizarEmail(int id, String nuevoEmail) {
        String query = "UPDATE usuarios SET email=? WHERE id_usuario=?";
        try (Connection conn = Conexion.getConexion(); 
                PreparedStatement ps = conn.prepareStatement(query)){

            ps.setString(1, nuevoEmail);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("Email actualizado correctamente");

        } catch (SQLException e) {
            System.out.println("ERROR al actualizar email de usuario");
            e.printStackTrace();
        }
    }
    
    public void actualizarPassword(int id, String nuevoPassword) {
        String query = "UPDATE usuarios SET password=? WHERE id_usuario=?";
        try (Connection conn = Conexion.getConexion(); 
                PreparedStatement ps = conn.prepareStatement(query)){

            ps.setString(1, nuevoPassword);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("Password actualizado correctamente");

        } catch (SQLException e) {
            System.out.println("ERROR al actualizar password de usuario");
            e.printStackTrace();
        }
    }
    
   public void actualizarRol(int id, Rol nuevoRol) {
        String query = "UPDATE usuarios SET rol=? WHERE id_usuario=?";
        try (Connection conn = Conexion.getConexion(); 
                PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, nuevoRol.name());
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("Rol actualizado correctamente");

        } catch (SQLException e) {
            System.out.println("ERROR al actualizar rol de usuario");
            e.printStackTrace();
        }
    }
    
    
    //Eliminar usuario
    public void eliminarUsuario(int id) {
        String query = "DELETE FROM usuarios WHERE id_usuario=?";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, id);

            ps.executeUpdate();
            System.out.println("Dato eliminado correctamente");

        } catch (SQLException e) {
            System.out.println("ERROR al eliminar dato");
            e.printStackTrace();
        }
    }
    
    //para ver si el id del usuario que buscamos existe en la bd
    public boolean buscarUsuario(int id) {
        String query = "SELECT id_usuario, nombre, email, rol FROM usuarios WHERE id_usuario=?";

        try (Connection conn = Conexion.getConexion(); 
                PreparedStatement ps = conn.prepareStatement(query)){ 

            ps.setInt(1, id); 
            ResultSet rs = ps.executeQuery(); 

            if (rs.next()) {
                int idUsuario = rs.getInt("id_usuario");
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");
                String rol = rs.getString("rol");

                System.out.println();
                System.out.println("Id de Usuario: " + idUsuario);
                System.out.println("Nombre: " + nombre);
                System.out.println("Email: " + email);
                System.out.println("Rol: " + rol);
                System.out.println();

                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("ERROR al buscar usuario por ese ID");
            e.printStackTrace();
            return false;
        }
          
    }
    
    
    //para buscar usuario que solo sea ESTUDIANTE
    public void buscarEstudiante() {
        String query = "SELECT * FROM usuarios WHERE rol = 'ESTUDIANTE'";

        try (Connection conn = Conexion.getConexion(); 
                PreparedStatement ps = conn.prepareStatement(query); 
                ResultSet rs = ps.executeQuery()){

            while (rs.next()) {
                int id = rs.getInt("id_usuario");
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");
                String rol = rs.getString("rol");

                System.out.println("Id de Usuario: " + id);
                System.out.println("Nombre: " + nombre);
                System.out.println("Email: " + email);
                System.out.println("Rol: " + rol);
                System.out.println();
            }

        } catch (SQLException e) {
            System.out.println("ERROR al leer usuarios");
            e.printStackTrace();
        }
    }
    
    //==============================================================================
    //Métdos para la parte web directamente
    //==============================================================================
    
    public List<Usuario> listarUsuarios() {
    List<Usuario> lista = new ArrayList<>();
    String query = "SELECT * FROM usuarios";

    try (Connection conn = Conexion.getConexion();
         PreparedStatement ps = conn.prepareStatement(query);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            String rol = rs.getString("rol");
            Usuario u;

            if (rol.equals("PROFESOR")) {
                u = new Profesor(
                    rs.getInt("id_usuario"),
                    rs.getString("nombre"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getTimestamp("fecha_registro").toLocalDateTime().toLocalDate()
                );
            } else {
                u = new Estudiante(
                    rs.getInt("id_usuario"),
                    rs.getString("nombre"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getTimestamp("fecha_registro").toLocalDateTime().toLocalDate()
                );
            }
            lista.add(u);
        }

    } catch (SQLException e) {
        System.out.println("ERROR al listar usuarios");
        e.printStackTrace();
    }

    return lista;
    }
    
}