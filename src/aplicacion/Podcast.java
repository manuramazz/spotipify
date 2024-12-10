package aplicacion;

public class Podcast {
    private int idPodcast;
    private String nombre;

    // Constructor
    public Podcast(int idPodcast, String nombre) {
        this.idPodcast = idPodcast;
        this.nombre = nombre;
    }

    // Getters y setters
    public int getIdPodcast() {
        return idPodcast;
    }

    public void setIdPodcast(int idPodcast) {
        this.idPodcast = idPodcast;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método toString para representación de cadena
    @Override
    public String toString() {
        return nombre;
    }
}
