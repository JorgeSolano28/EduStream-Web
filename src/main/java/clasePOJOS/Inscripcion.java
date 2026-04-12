package clasePOJOS;
import java.time.LocalDate;


public class Inscripcion {
    private int idInscripcion;
    private int idEstudiante;
    private int idCurso;
    private LocalDate fechaInscripcion;
    
    public Inscripcion(int idInscripcion, int idEstudiante, int idCurso, LocalDate fechaInscripcion ) {
        this.idInscripcion = idInscripcion;
        this.idEstudiante = idEstudiante;
        this.idCurso = idCurso;
        this.fechaInscripcion = fechaInscripcion;
    }

    
    //getters y setters uno junto a otro para facilitar la legibilidad y facilidad a la hora de hacer algún cambio******************************
    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    } 

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }


}
