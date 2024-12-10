package aplicacion;

public class Elemento {
    String nombre;
    String tipo;
    String artista;
    int canciones;
    String duracion;

    public Elemento(String nombre, String tipo){
        this.nombre=nombre;
        this.tipo=tipo;
    }
    public Elemento(String nombre, String artista,int e){
        this.nombre=nombre;
        this.artista=artista;
    }
    public Elemento(String nombre, int canciones,String duracion){
        this.nombre=nombre;
        this.canciones=canciones;
        this.duracion=duracion;
    }

    public int getCanciones() {
        return canciones;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setCanciones(int canciones) {
        this.canciones = canciones;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getNombre(){
        return nombre;
    }

    public String getTipo(){
        return tipo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public void setTipo(String tipo){
        this.tipo=tipo;
    }
}
