package aplicacion;

public class Playlist {
    private int idPlaylist;
    private String nombrePlaylist;
    private String creador;
    private String fechaCreacion;

    // Constructor
    public Playlist(int idPlaylist, String nombrePlaylist, String creador, String fechaCreacion) {
        this.idPlaylist = idPlaylist;
        this.nombrePlaylist = nombrePlaylist;
        this.creador = creador;
        this.fechaCreacion = fechaCreacion;
    }

    // Getters y setters
    public int getIdPlaylist() {
        return idPlaylist;
    }

    public void setIdPlaylist(int idPlaylist) {
        this.idPlaylist = idPlaylist;
    }

    public String getNombrePlaylist() {
        return nombrePlaylist;
    }

    public void setNombrePlaylist(String nombrePlaylist) {
        this.nombrePlaylist = nombrePlaylist;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    // Método toString para representación de cadena
    @Override
    public String toString() {
        return "Playlist{" +
                "idPlaylist=" + idPlaylist +
                ", nombrePlaylist='" + nombrePlaylist + '\'' +
                ", creador='" + creador + '\'' +
                ", fechaCreacion='" + fechaCreacion + '\'' +
                '}';
    }
}
