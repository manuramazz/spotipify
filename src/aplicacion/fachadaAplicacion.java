package aplicacion;

import gui.PasarCancionCallback;

import java.awt.*;
import java.util.List;

public class fachadaAplicacion {
    gui.fachadaGui fgui;
    baseDatos.fachadaBaseDatos fbd;

    //Atributos gestion
    gestionOyentes go;
    gestionArtista ga;
    gestionAdministrador gadmin;
    gestionPlaylist gp;
    gestionPodcast gpo;
    gestionAlbum gal;
    gestionCancion gc;
    gestionDiscograficas gd;
    gestionCapitulo gcap;

    public fachadaAplicacion(){
        fgui=new gui.fachadaGui(this);
        fbd= new baseDatos.fachadaBaseDatos(this);
        //inicializar gestiones
        go = new gestionOyentes(fgui,fbd);
        ga = new gestionArtista(fgui,fbd);
        gadmin = new gestionAdministrador(fgui,fbd);
        gp = new gestionPlaylist(fgui,fbd);
        gpo = new gestionPodcast(fgui, fbd);
        gal = new gestionAlbum(fgui, fbd);
        gc = new gestionCancion(fgui, fbd);
        gd = new gestionDiscograficas(fgui, fbd);
        gcap = new gestionCapitulo(fgui, fbd);

    }
    public static void main(String args[]) {

        fachadaAplicacion fa;
        fa= new fachadaAplicacion();
        fa.iniciaInterfazUsuario();

        /*String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        System.out.println("Fuentes disponibles en tu sistema:");
        for (String font : fonts) {
            System.out.println(font);
        }*/
    }

    //FUNCIONES GUI
    public void iniciaInterfazUsuario(){
        fgui.iniciaVista();
    }
    public void muestraAjustes(Frame owner){
        fgui.muestraAjustes(owner);
    }
    public void muestraCrearPlaylist(Frame owner, fachadaAplicacion fa, int op, String usuarioActual){
        fgui.muestraCrearPlaylist(owner,fa,op,usuarioActual);
    }
    public void muestraExcepcion(String e){
        fgui.muestraExcepcion(e);
    }
    public void muestraBuscar(int op, String usuarioActual){
        fgui.muestraBuscar(this,op, usuarioActual);
    }
    public void muestraPodcast(Podcast podcast, List<Capitulo> caps){
        fgui.muestraPodcast(podcast,caps);
    }

    public void muestraBiblioteca(int op, String usuarioActual) {
        fgui.muestraBiblioteca(op, usuarioActual);
    }
    public void muestraPrincipal(int op, String usuarioActual){
        fgui.muestraPrincipal(op, usuarioActual );
    }
    public void muestraPublicar(String usuarioActual) {
        fgui.muestraPublicar(usuarioActual);
    }
    public void muestraCancion(Cancion cancion,String usuarioActual) {
        fgui.muestraCancion(cancion,usuarioActual);
    }
    public void muestraAnadirCancion(String usuarioActual, int albumID,Frame owner, PasarCancionCallback callback){
        fgui.muestraAnadirCancion(usuarioActual,albumID,owner, callback);
    }
    public void muestraLista(List<Elemento> canciones, String titulo, String aritsta, String usuarioActual){
        fgui.muestraLista(canciones,titulo,aritsta,usuarioActual);
    }

    //FUNCIONES OYENTES
    public Oyente comprobarAutentificacionOyente(String nombre, String contrasena){
        return go.comprobarAutentificacionOyente(nombre, contrasena);
    }

    public void registrarOyente(String usuario, String correo, String contrasena, String fechaNacimiento) {
        go.registrarOyente(usuario, correo, contrasena, fechaNacimiento);
    }

    //FUNCIONES ARTISTAS
    public Artista comprobarAutentificacionArtista(String nombre, String contrasena){
        return  ga.comprobarAutentificacionArtista(nombre, contrasena);
    }
    public List<Artista> buscarArtistas(String terminoBusqueda){
        return ga.buscarArtistas(terminoBusqueda);
    }
    public List<Artista> buscarArtistasAutentificacion(String terminoBusqueda) {
        return ga.buscarArtistasAutentificacion(terminoBusqueda);
    }

    public int obtenerIDArtistaPorNombre(String nombreArtista){
        return ga.obtenerIDArtistaPorNombre(nombreArtista);
    }

    //FUNCIONES ADMIN
    public Administrador comprobarAutentificacionAdministrador(String nombre, String contrasena){
        return gadmin.comprobarAutentificacionAdministrador(nombre, contrasena);
    }
    public List<Administrador> buscarAdminAutentificacion(String terminoBusqueda) {
        return gadmin.buscarAdminAutentificacion(terminoBusqueda);
    }

    //FUNCIONES PLAYLIST
    public void registrarPlaylist(String nombre, String usuario) {
        gp.registrarPlaylist(nombre,usuario);
    }

    public String buscarCreadorPlaylist(String nombrePlaylist) {
        return gp.buscarCreadorPlaylist(nombrePlaylist);
    }
    public List<Playlist> buscarPlaylists(String terminoBusqueda){
        return gp.buscarPlaylists(terminoBusqueda);
    }

    public List<Elemento> buscarPlaylistsUsuario(String nombreUsuario){
        return gp.buscarPlaylistsUsuario(nombreUsuario);
    }
    public int buscarIDPlaylists(String terminoBusqueda,String usuario) {
        return gp.buscarIDPlaylists(terminoBusqueda,usuario);
    }
    public List<Cancion> obtenerCancionesDePlaylist(String nombrePlaylist){
        return gp.obtenerCancionesDePlaylist(nombrePlaylist);
    }
    public int buscarCancionEnPlaylists(int idcancion,int idplaylist) {
        return gp.buscarCancionEnPlaylists(idcancion,idplaylist);
    }
    public void insertarCancionEnPlaylist(String nombreCancion,int IDPlaylist){
        gp.insertarCancionEnPlaylist(nombreCancion,IDPlaylist);
    }

    //FUNCIONES CANCION
    public List<Cancion> buscarCanciones(String terminoBusqueda){
        return gc.buscarCanciones(terminoBusqueda);
    }
    public List<Cancion> buscarCancionesEn(String terminoBusqueda) {
        return gc.buscarCancionesEn(terminoBusqueda);
    }
    public void valorarCancion(String usuarioActual,int cancion,int valor){
        gc.valorarCancion(usuarioActual,cancion,valor);
    }
    public int comprobarValoracionCancion(int idcancion,String usuario) {
        return gc.comprobarValoracionCancion(idcancion,usuario);
    }
    public double mediaValoraciones(int idCancion, String usuario) {
        return gc.mediaValoraciones(idCancion,usuario);
    }

    public String obtenerArtistaDeCancion(String nombreCancion){
        return gc.obtenerArtistaDeCancion(nombreCancion);
    }
    public List<Artista> obtenerArtistasDeCancion(String nombreCancion) {
        return gc.obtenerArtistasDeCancion(nombreCancion);
    }
    public String obtenerArtistasDePodcast(String nombrePodcast) {
        return ga.obtenerArtistasDePodcast(nombrePodcast);
    }

    public void publicarCancion(Cancion cancion, int IDAlbum){
        gc.publicarCancion(cancion, IDAlbum);
    }
    public List<Cancion> obtenerUltimasCanciones(int numCanciones){
        return gc.obtenerUltimasCanciones(numCanciones);
    }


    //FUNCIONES ALBUM
    public List<Album> buscarAlbum(String terminoBusqueda){
        return gal.buscarAlbumes(terminoBusqueda);
    }

    public List<String> obtenerArtistaDeAlbum(String nombreAlbum){
        return gal.obtenerArtistaDeAlbum(nombreAlbum);
    }

    public int publicarAlbum(Album album, int IDDiscografica, String IDArtista){
        return gal.publicarAlbum(album, IDDiscografica, IDArtista);
    }
    public List<String> obtenerCancionesPorAlbum(String nombreAlbum, String artistaAlbum) {
        return gal.obtenerCancionesPorAlbum(nombreAlbum,artistaAlbum);
    }
    public int obtenerIDnuevo() {
        return gal.obtenerIDnuevo();
    }

    public void eliminarAlbum(int idAlbum){
        gal.eliminarAlbum(idAlbum);
    }

    //FUNCIONES PODCAST
    public List<Podcast> buscarPodcasts(String terminoBusqueda){
        return gpo.buscarPodcasts(terminoBusqueda);
    }
    public List<Podcast> buscarPodcastsPorNombre(String terminoBusqueda) {
        return gpo.buscarPodcastsPorNombre(terminoBusqueda);
    }
    public Podcast obtenerIDPodcast(String terminoBusqueda) {
        return gpo.obtenerIDPodcast(terminoBusqueda);
    }

    public String obtenerArtistaDePodcast(String nombrePodcast){
        return gpo.obtenerArtistaDePodcast(nombrePodcast);
    }

    public void publicarPodcast(Podcast podcast, String idArtista){
        gpo.publicarPodcast(podcast, idArtista);
    }

    //FUNCIONES DISCOGRAFICA
    public int insertarDiscografica(String nombreDiscografica){
        return gd.insertarDiscografica(nombreDiscografica);
    }
    public Discografica buscarDiscografica(String nombreDiscografica){
        return gd.buscarDiscografica(nombreDiscografica);
    }
    public void eliminarDiscografica(int idDiscografica){
        gd.eliminarDiscografica(idDiscografica);
    }

    //METODOS CAPITULO
    public void insertarCapitulo(Capitulo capitulo){
        gcap.insertarCapitulo(capitulo);
    }
    public void eliminarCapitulo(int IDCapitulo, int IDPodcast){
        gcap.eliminarCapitulo(IDCapitulo, IDPodcast);
    }
    public List<Capitulo> buscarCapitulosPodcast(int IDPodcast){
        return gcap.buscarCapitulosPodcast(IDPodcast);
    }
}
