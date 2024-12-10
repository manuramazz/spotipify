package aplicacion;
import java.sql.*;

public class Oyente {
    private String nombre;
    private String contrasena;
    private String email;
    private Date fechaNacimiento;
    private String tipoPlan;
    private Date fechaPago,fechaVencimiento;
    private Cancion cancion;

    public Oyente(String nombre, String contrasena, String email, Date fechaNacimiento, String tipoPlan, Date fechaPago, Date fechaVencimiento) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoPlan = tipoPlan;
        this.fechaPago = fechaPago;
        this.fechaVencimiento=fechaVencimiento;
        this.cancion=null;
    }



}
