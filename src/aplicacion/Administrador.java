package aplicacion;

import java.sql.Date;

public class Administrador {
    private String nombre;
    private String contrasena;
    private String email;
    private Date fechaNacimiento;
    public Administrador(String nombre, String contrasena, String email, Date fechaNacimiento) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
    }
}
