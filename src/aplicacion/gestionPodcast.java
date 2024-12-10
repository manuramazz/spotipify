package aplicacion;

import baseDatos.fachadaBaseDatos;
import gui.fachadaGui;
import java.util.List;

public class gestionPodcast {
    fachadaGui fgui;
    fachadaBaseDatos fbd;

    public gestionPodcast(fachadaGui fgui, fachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }

    public List<Podcast> buscarPodcasts(String terminoBusqueda){
        return fbd.buscarPodcasts(terminoBusqueda);
    }
    public List<Podcast> buscarPodcastsPorNombre(String terminoBusqueda) {
        return fbd.buscarPodcastsPorNombre(terminoBusqueda);
    }

    public String obtenerArtistaDePodcast(String nombrePodcast){
        return fbd.obtenerArtistaDePodcast(nombrePodcast);
    }
    public Podcast obtenerIDPodcast(String terminoBusqueda) {
        return fbd.obtenerIDPodcast(terminoBusqueda);
    }

    public void publicarPodcast(Podcast podcast, String idArtista){
        fbd.publicarPodcast(podcast, idArtista);
    }
}
