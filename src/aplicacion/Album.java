package aplicacion;

public class Album {
    private int idAlbum;
    private String nombre;
    private String tipo;
    private int añoLanzamiento;
    private int IDDiscografica; // Podrías usar un objeto Discografica en lugar de solo el nombre

    // Constructor
    public Album(int idAlbum, String nombre, String tipo, int añoLanzamiento, int IDDiscografica) {
        this.idAlbum = idAlbum;
        this.nombre = nombre;
        this.tipo = tipo;
        this.añoLanzamiento = añoLanzamiento;
        this.IDDiscografica = IDDiscografica;
    }

    // Getters y setters
    public int getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(int idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getAñoLanzamiento() {
        return añoLanzamiento;
    }

    public void setAñoLanzamiento(int añoLanzamiento) {
        this.añoLanzamiento = añoLanzamiento;
    }

    public int getIDDiscografica() {
        return IDDiscografica;
    }

    public void setIDDiscografica(int IDDiscografica) {
        this.IDDiscografica = IDDiscografica;
    }

    // Método toString para representación de cadena
    @Override
    public String toString() {
        return "Album{" +
                "idAlbum=" + idAlbum +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", añoLanzamiento=" + añoLanzamiento +
                ", nombreDiscografica='" + IDDiscografica + '\'' +
                '}';
    }
}
