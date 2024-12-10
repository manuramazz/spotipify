package aplicacion;
import  baseDatos.*;
import  gui.*;

import java.util.List;

public class gestionPlaylist {
    fachadaGui fgui;
    fachadaBaseDatos fbd;

    public gestionPlaylist(fachadaGui fgui, fachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }

    public void registrarPlaylist(String nombre, String usuario) {
        fbd.registrarPlaylist(nombre,usuario);
    }

    public List<Playlist> buscarPlaylists(String terminoBusqueda){
        return fbd.buscarPlaylists(terminoBusqueda);
    }

    public List<Elemento> buscarPlaylistsUsuario(String nombreUsuario){
        return fbd.buscarPlaylistsUsuario(nombreUsuario);
    }
    public String buscarCreadorPlaylist(String nombrePlaylist) {
        return fbd.buscarCreadorPlaylist(nombrePlaylist);
    }
    public int buscarIDPlaylists(String terminoBusqueda,String usuario) {
        return fbd.buscarIDPlaylists(terminoBusqueda,usuario);
    }

    public List<Cancion> obtenerCancionesDePlaylist(String nombrePlaylist){
        return fbd.obtenerCancionesDePlaylist(nombrePlaylist);
    }
    public int buscarCancionEnPlaylists(int idcancion,int idplaylist) {
        return fbd.buscarCancionEnPlaylists(idcancion,idplaylist);
    }
    public void insertarCancionEnPlaylist(String nombreCancion,int IDPlaylist){
        fbd.insertarCancionEnPlaylist(nombreCancion,IDPlaylist);
    }
}