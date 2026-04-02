package clasePOJOS;

public class Curso {
    //Cambio de atributos más descriptivos
    //y se puede evitar redundancia, más legible************************************
    private int idCurso;
    private String nombreCurso;
    private String descripcion;
    private int idProfesor;
    
    //Cambio de constructores actualizados************************************
    public Curso(int idCurso, String nombreCurso, String descripcion, int idProfesor) {
        this.idCurso = idCurso;
        this.nombreCurso = nombreCurso;
        this.descripcion = descripcion;
        this.idProfesor = idProfesor;
    }

    //Cambio de getters y setters actualizados************************************
    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdProfesor() {
        return idProfesor;
    } 

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }


}
