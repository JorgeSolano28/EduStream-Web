package clasePOJOS;

import java.time.LocalDate;

public class Estudiante extends Usuario {

    public Estudiante(int id, String nombre, String email, String password, LocalDate fechaRegistro) {
        super(id, nombre, email, password, Rol.ESTUDIANTE, fechaRegistro);
    }
}
