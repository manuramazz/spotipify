package aplicacion;

import java.sql.Date;

public class Artista {
    private String nombre;
    private String contrasena;
    private String email;
    private Date fechaNacimiento;
    private String nombreArtistico;
    private String paisNacimiento;

    public Artista(String nombre, String contrasena, String email, Date fechaNacimiento, String nombreArtistico, String paisNacimiento) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.nombreArtistico = nombreArtistico;
        this.paisNacimiento = paisNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombreArtistico() {
        return nombreArtistico;
    }

    public void setNombreArtistico(String nombreArtistico) {
        this.nombreArtistico = nombreArtistico;
    }

    public String getPaisNacimiento() {
        return paisNacimiento;
    }

    public void setPaisNacimiento(String paisNacimiento) {
        this.paisNacimiento = paisNacimiento;
    }
}

