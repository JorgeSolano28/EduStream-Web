package clasePOJOS;
import java.time.LocalDate;


//Usuario como una clase abstracta para poder extender dos usuarios directamente **********************
public abstract class Usuario {
    protected int id;
    protected String nombre;
    protected String email;
    protected String password;
    protected Rol rol;
    protected LocalDate fechaRegistro;

    public Usuario(int id, String nombre, String email, String password, Rol rol, LocalDate fechaRegistro) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.rol = rol;
        this.fechaRegistro = fechaRegistro;
    }
    
    //getters y setters uno junto a otro para facilitar legibilidad y facilidad de cambios********************
public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getRol() {
        return rol;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
} 