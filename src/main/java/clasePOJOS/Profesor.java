package clasePOJOS;

import java.time.LocalDate;

public class Profesor extends Usuario {

    public Profesor(int id, String nombre, String email, String password, LocalDate fechaRegistro) {
        super(id, nombre, email, password, Rol.PROFESOR, fechaRegistro);
    }
}
