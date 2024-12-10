package aplicacion;
import baseDatos.*;
import gui.*;

import java.util.List;

public class gestionArtista {
    fachadaGui fgui;
    fachadaBaseDatos fbd;

    public gestionArtista(fachadaGui fgui, fachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }
    public String obtenerArtistasDePodcast(String nombrePodcast) {
        return fbd.obtenerArtistasDePodcast(nombrePodcast);
    }

    public Artista comprobarAutentificacionArtista(String nombre, String contrasena){
        Artista a;
        a=fbd.validarArtista(nombre, contrasena);
        return a;
    }

    public List<Artista> buscarArtistas(String terminoBusqueda){
        return fbd.buscarArtistas(terminoBusqueda);
    }

    public int obtenerIDArtistaPorNombre(String nombreArtista){
        return fbd.obtenerIDArtistaPorNombre(nombreArtista);
    }
    public List<Artista> buscarArtistasAutentificacion(String terminoBusqueda) {
        return fbd.buscarArtistasAutentificacion(terminoBusqueda);
    }

}
