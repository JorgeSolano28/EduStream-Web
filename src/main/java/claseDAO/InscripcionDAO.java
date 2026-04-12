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
    
    
    //para actualizar el ID del estudiante en Inscripcion
    public void actualizarIdEstudiante(int idInscripcion, int nuevoIdEstudiante) {
        String query = "UPDATE inscripciones SET id_estudiante=? WHERE id_inscripcion=?";
        try (Connection conn = Conexion.getConexion(); 
                PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, nuevoIdEstudiante);
            ps.setInt(2, idInscripcion);
            ps.executeUpdate();
            System.out.println("ID de Estudiante actualizado correctamente");

        } catch (SQLException e) {
            System.out.println("ERROR al actualizar ID estudiante");
            e.printStackTrace();
        }
    }
    
    //para actualizar el ID del curso en Inscripcion
    public void actualizarIdCurso(int idInscripcion, int nuevoIdCurso) {
        String query = "UPDATE inscripciones SET id_curso=? WHERE id_inscripcion=?";
        try (Connection conn = Conexion.getConexion(); 
                PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, nuevoIdCurso);
            ps.setInt(2, idInscripcion);
            ps.executeUpdate();
            System.out.println("ID de Curso actualizado correctamente");

        } catch (SQLException e) {
            System.out.println("ERROR al actualizar ID Curso");
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
    
    
    //para buscar curso y nos muestre toda su informacion
    public void buscarCurso() {
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
            System.out.println("ERROR al leer cursos");
            e.printStackTrace();
        }
    }
    
    //para buscar curso pero por ID para la inscripcion 
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
