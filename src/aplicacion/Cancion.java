package aplicacion;

public class Cancion {
    private String nombre;
    private int IDCancion;
    private String duracion;
    private String idioma;
    private String nombreGenero;
    private boolean letra;
    private int visualizaciones;
    private int IDalbum;
    private boolean explicito;

    // Constructor
    public Cancion(String nombre, int IDCancion, String duracion, String idioma, String nombreGenero,
                   boolean letra, int visualizaciones, int IDalbum, boolean explicito) {
        this.nombre = nombre;
        this.IDCancion = IDCancion;
        this.duracion = duracion;
        this.idioma = idioma;
        this.nombreGenero = nombreGenero;
        this.letra = letra;
        this.visualizaciones = visualizaciones;
        this.IDalbum = IDalbum;
        this.explicito = explicito;
    }
    // Getters y Setters (si son necesarios)
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getIDCancion() {
        return IDCancion;
    }
    public void setIDCancion(int IDCancion) {
        this.IDCancion = IDCancion;
    }
    public String getDuracion() {
        return duracion;
    }
    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
    public String getIdioma() {
        return idioma;
    }
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
    public String getNombreGenero() {
        return nombreGenero;
    }
    public void setNombreGenero(String nombreGenero) {
        this.nombreGenero = nombreGenero;
    }
    public boolean isLetra() {
        return letra;
    }
    public void setLetra(boolean letra) {
        this.letra = letra;
    }
    public int getVisualizaciones() {
        return visualizaciones;
    }
    public void setVisualizaciones(int visualizaciones) {
        this.visualizaciones = visualizaciones;
    }
    public int getIDalbum() {
        return IDalbum;
    }
    public void setIDalbum(int IDalbum) {
        this.IDalbum = IDalbum;
    }
    public boolean isExplicito() {
        return explicito;
    }
    public void setExplicito(boolean explicito) {
        this.explicito = explicito;
    }
}
