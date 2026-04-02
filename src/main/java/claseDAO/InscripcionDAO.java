package claseDAO;

import java.sql.*;
import claseConexion.Conexion;
import java.time.LocalDate;

public class InscripcionDAO {
    
    //Insertar inscripcion
    public void insertarInscripcion(int idEstudiante, int idCurso, LocalDate fechaInscripcion) {
        String query = "INSERT INTO inscripciones (id_estudiante, id_curso, fecha_inscripcion) VALUES (?, ?, ?)";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, idEstudiante);
            ps.setInt(2, idCurso);
            ps.setDate(3, Date.valueOf(fechaInscripcion)); // Convierte LocalDate a java.sql.Date

            ps.executeUpdate();
            System.out.println("Inscripción registrada correctamente.");

        } catch (SQLException e) {
            System.out.println("ERROR al registrar inscripción.");
            e.printStackTrace();
        }
    }
    
    //Leer inscripciones
    public void leerInscripciones() {
        String query = "SELECT * FROM inscripciones";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int idInscripcion = rs.getInt("id_inscripcion");
                int idEstudiante = rs.getInt("id_estudiante");
                int idCurso = rs.getInt("id_curso");
                LocalDate fechaInscripcion = rs.getDate("fecha_inscripcion").toLocalDate(); // Convierte java.sql.Date a LocalDate

                System.out.println("ID Inscripción: " + idInscripcion);
                System.out.println("ID Estudiante: " + idEstudiante);
                System.out.println("ID Curso: " + idCurso);
                System.out.println("Fecha de Inscripción: " + fechaInscripcion);
                System.out.println();
            }

        } catch (SQLException e) {
            System.out.println("ERROR al leer inscripciones.");
            e.printStackTrace();
        }
    }
    
    //Actualizar inscripcion
    public void actualizarInscripcion(int idInscripcion, int idEstudiante, int idCurso, LocalDate fechaInscripcion) {
        String query = "UPDATE inscripciones SET id_estudiante=?, id_curso=?, fecha_inscripcion=? WHERE id_inscripcion=?";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, idEstudiante);
            ps.setInt(2, idCurso);
            ps.setDate(3, Date.valueOf(fechaInscripcion)); // Convierte LocalDate a java.sql.Date
            ps.setInt(4, idInscripcion);

            ps.executeUpdate();
            System.out.println("Inscripción actualizada correctamente.");

        } catch (SQLException e) {
            System.out.println("ERROR al actualizar inscripción.");
            e.printStackTrace();
        }
    }
    
    //Eliminar inscripcion
    public void eliminarInscripcion(int idInscripcion) {
        String query = "DELETE FROM inscripciones WHERE id_inscripcion=?";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, idInscripcion);

            ps.executeUpdate();
            System.out.println("Inscripción eliminada correctamente.");

        } catch (SQLException e) {
            System.out.println("ERROR al eliminar inscripción.");
            e.printStackTrace();
        }
    }
    
    
}
