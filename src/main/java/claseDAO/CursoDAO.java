package claseDAO;

import java.sql.*;
import claseConexion.Conexion;

public class CursoDAO {

    
    //Insertar cursos
    public void insertarCurso(String nombreCurso, String descripcion, int idProfesor) {
        String query = "INSERT INTO cursos (nombre_curso, descripcion, id_profesor) VALUES (?, ?, ?)";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, nombreCurso);
            ps.setString(2, descripcion);
            ps.setInt(3, idProfesor);

            ps.executeUpdate();
            System.out.println("Curso insertado correctamente.");

        } catch (SQLException e) {
            System.out.println("ERROR al insertar curso.");
            e.printStackTrace();
        }
    }
    
    //Leer cursos
    public void leerCurso() {
        String query = "SELECT * FROM cursos";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int idCurso = rs.getInt("id_curso");
                String nombreCurso = rs.getString("nombre_curso");
                String descripcion = rs.getString("descripcion");
                int idProfesor = rs.getInt("id_profesor");

                System.out.println("ID Curso: " + idCurso);
                System.out.println("Nombre: " + nombreCurso);
                System.out.println("Descripción: " + descripcion);
                System.out.println("ID Profesor: " + idProfesor);
                System.out.println();
            }

        } catch (SQLException e) {
            System.out.println("ERROR al leer cursos.");
            e.printStackTrace();
        }
    }
    
    //Actualizar cursos
    public void actualizarCurso(int idCurso, String nombreCurso, String descripcion, int idProfesor) {
        String query = "UPDATE cursos SET nombre_curso=?, descripcion=?, id_profesor=? WHERE id_curso=?";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, nombreCurso);
            ps.setString(2, descripcion);
            ps.setInt(3, idProfesor);
            ps.setInt(4, idCurso);

            ps.executeUpdate();
            System.out.println("Curso actualizado correctamente.");

        } catch (SQLException e) {
            System.out.println("ERROR al actualizar curso.");
            e.printStackTrace();
        }
    }
    
    public void actualizarNombre(int id, String nuevoNombre) {
        String query = "UPDATE cursos SET nombre_curso=? WHERE id_curso=?";
        try (Connection conn = Conexion.getConexion(); 
                PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, nuevoNombre);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("Nombre actualizado correctamente");

        } catch (SQLException e) {
            System.out.println("ERROR al actualizar curso");
            e.printStackTrace();
        }
    }
    
    public void actualizarDescripcion(int id, String nuevaDescripcion) {
        String query = "UPDATE cursos SET descripcion=? WHERE id_curso=?";
        try (Connection conn = Conexion.getConexion(); 
                PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, nuevaDescripcion);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("Descripcion actualizada correctamente");

        } catch (SQLException e) {
            System.out.println("ERROR al actualizar descripcion");
            e.printStackTrace();
        }
    }
    
    public void actualizarIdProfesor(int id, String nuevoIdProfesor) {
        String query = "UPDATE cursos SET id_profesor=? WHERE id_curso=?";
        try (Connection conn = Conexion.getConexion(); 
                PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, nuevoIdProfesor);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("Descripcion actualizada correctamente");

        } catch (SQLException e) {
            System.out.println("ERROR al actualizar descripcion");
            e.printStackTrace();
        }
    }
    
    //Eliminar cursos
    public void eliminarCurso(int idCurso) {
        String query = "DELETE FROM cursos WHERE id_curso=?";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, idCurso);

            ps.executeUpdate();
            System.out.println("Curso eliminado correctamente.");

        } catch (SQLException e) {
            System.out.println("ERROR al eliminar curso.");
            e.printStackTrace();
        }
    }
    
    //para ver si el id del curso que buscamos existe en la bd
    public boolean buscarCurso(int id) {
        String query = "SELECT id_curso, nombre_curso, descripcion, id_profesor FROM cursos WHERE id_curso=?";

        try (Connection conn = Conexion.getConexion(); 
                PreparedStatement ps = conn.prepareStatement(query)){ 

            ps.setInt(1, id); 
            ResultSet rs = ps.executeQuery(); 

            if (rs.next()) {
                int idCurso = rs.getInt("id_curso");
                String nombreCurso = rs.getString("nombre_curso");
                String descripcion = rs.getString("descripcion");
                int idProfesor = rs.getInt("id_profesor");

                System.out.println();
                System.out.println("ID Curso: " + idCurso);
                System.out.println("Nombre: " + nombreCurso);
                System.out.println("Descripción: " + descripcion);
                System.out.println("ID Profesor: " + idProfesor);
                System.out.println();
                System.out.println();
                
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("ERROR al buscar curso por ese ID");
            e.printStackTrace();
            return false;
        }
    }
    
    
    
}
