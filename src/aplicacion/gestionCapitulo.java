package aplicacion;
import baseDatos.*;
import gui.*;


import java.util.List;

public class gestionCapitulo {
    fachadaGui fgui;
    fachadaBaseDatos fbd;

    public gestionCapitulo(fachadaGui fgui, fachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }

    public void insertarCapitulo(Capitulo capitulo){
        fbd.insertarCapitulo(capitulo);
    }
    public void eliminarCapitulo(int IDCapitulo, int IDPodcast){
        fbd.eliminarCapitulo(IDCapitulo, IDPodcast);
    }
    public List<Capitulo> buscarCapitulosPodcast(int IDPodcast){
        return fbd.buscarCapitulosPodcast(IDPodcast);
    }
}