package clasePOJOS;

import java.time.LocalDate;

//creación de clase Profesor para que sea específico a la hora de programar la web
//hereda de la clase abstracta usuario con super y de la clase Rol se trae el enum específico PROFESOR
//para evitar fallas de digitación o sintaxis en texto plano***********************************
public class Profesor extends Usuario {

    public Profesor(int id, String nombre, String email, String password, LocalDate fechaRegistro) {
        super(id, nombre, email, password, Rol.PROFESOR, fechaRegistro);
    }
}
