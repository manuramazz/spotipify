package baseDatos;

import aplicacion.Playlist;
import aplicacion.Cancion;
import aplicacion.Elemento;
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Date;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DAOPlaylist extends abstractDAO {
    public DAOPlaylist(Connection conexion, aplicacion.fachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public void registrarPlaylist(String nombre, String usuario) {
        Connection con;
        PreparedStatement stmPlaylist=null;

        con=this.getConexion();

        try {
            stmPlaylist=con.prepareStatement("INSERT INTO PLAYLIST (IDPlaylist, nombrePlaylist, fechaCreacion, IDOyente)\n" +
                    "VALUES (\n" +
                    "    (SELECT MAX(IDPlaylist) + 1 FROM PLAYLIST),\n" +
                    "    ?,\n" +
                    "    ?,\n" +
                    "    ?\n" +
                    ");");
            stmPlaylist.setString(1, nombre);
            LocalDate fechaActual = LocalDate.now();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String fechaFormateada = fechaActual.format(formato);
            Date fechaSql = Date.valueOf(fechaFormateada);
            stmPlaylist.setDate(2, fechaSql);
            stmPlaylist.setString(3, usuario);

            stmPlaylist.executeUpdate();

        } catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally{
            try {stmPlaylist.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
    public void insertarCancionEnPlaylist(String nombreCancion,int IDPlaylist) {
        Connection con;
        PreparedStatement stmPlaylist=null;

        con=this.getConexion();

        try {
            stmPlaylist=con.prepareStatement("INSERT INTO FORMARPARTE (IDCancion,IDPlaylist)\n" +
                    "VALUES ((select IDCancion from Cancion where nombre = ?),?);");
            stmPlaylist.setString(1, nombreCancion);
            stmPlaylist.setInt(2, IDPlaylist);

            stmPlaylist.executeUpdate();

        } catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally{
            try {stmPlaylist.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }

    public int buscarIDPlaylists(String terminoBusqueda,String usuario) {
        Connection con;
        PreparedStatement stmPlaylist = null;
        ResultSet rsPlaylist;
        List<Playlist> playlistsEncontradas = new ArrayList<>();
        int idPlaylist=0;
        con = this.getConexion();

        String sql = "SELECT IDPlaylist FROM PLAYLIST WHERE nombrePlaylist = ? and IDOyente = ?";
        try {
            stmPlaylist = con.prepareStatement(sql);
            stmPlaylist.setString(1, terminoBusqueda);
            stmPlaylist.setString(2, usuario);
            rsPlaylist = stmPlaylist.executeQuery();
            while (rsPlaylist.next()) {
                idPlaylist = rsPlaylist.getInt("IDPlaylist");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmPlaylist.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return idPlaylist;
    }
    public int buscarCancionEnPlaylists(int idcancion,int idplaylist) {
        Connection con;
        PreparedStatement stmPlaylist = null;
        ResultSet rsPlaylist;
        List<Playlist> playlistsEncontradas = new ArrayList<>();
        int idPlaylist=0;
        con = this.getConexion();
        int resultado = 0;

        String sql = "SELECT IDPlaylist,IDCancion FROM FORMARPARTE WHERE IDPlaylist = ? and IDCancion = ?";
        try {
            stmPlaylist = con.prepareStatement(sql);
            stmPlaylist.setInt(2, idcancion);
            stmPlaylist.setInt(1, idplaylist);
            rsPlaylist = stmPlaylist.executeQuery();
            while (rsPlaylist.next()) {
                resultado = 1;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmPlaylist.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }





    public List<Playlist> buscarPlaylists(String terminoBusqueda) {
        Connection con;
        PreparedStatement stmPlaylist = null;
        ResultSet rsPlaylist;
        List<Playlist> playlistsEncontradas = new ArrayList<>();

        con = this.getConexion();

        String sql = "SELECT * FROM PLAYLIST WHERE nombrePlaylist LIKE ?";
        try {
            stmPlaylist = con.prepareStatement(sql);
            stmPlaylist.setString(1, "%" + terminoBusqueda + "%");

            rsPlaylist = stmPlaylist.executeQuery();
            while (rsPlaylist.next()) {
                int idPlaylist = rsPlaylist.getInt("IDPlaylist");
                String nombrePlaylist = rsPlaylist.getString("nombrePlaylist");
                String creador = rsPlaylist.getString("IDOyente");
                String fechaCreacion = rsPlaylist.getString("fechaCreacion");

                Playlist playlist = new Playlist(idPlaylist, nombrePlaylist, creador, fechaCreacion);

                playlistsEncontradas.add(playlist);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmPlaylist.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return playlistsEncontradas;
    }

    public String buscarCreadorPlaylist(String nombrePlaylist) {
        Connection con;
        PreparedStatement stmPlaylist = null;
        ResultSet rsPlaylist;
        List<Playlist> playlistsEncontradas = new ArrayList<>();
        String res="";
        con = this.getConexion();

        String sql = "SELECT IDoyente FROM PLAYLIST WHERE nombrePlaylist = ?";
        try {
            stmPlaylist = con.prepareStatement(sql);
            stmPlaylist.setString(1, nombrePlaylist);

            rsPlaylist = stmPlaylist.executeQuery();
            while (rsPlaylist.next()) {
               res=rsPlaylist.getString("IDoyente");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmPlaylist.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return res;
    }

    public List<Elemento> buscarPlaylistsUsuario(String nombreUsuario) {
        Connection con;
        PreparedStatement stmPlaylist = null;
        ResultSet rsPlaylist;
        List<Elemento> playlistsEncontradas = new ArrayList<>();

        con = this.getConexion();

        String sql = "SELECT \n" +
                "    P.IDPlaylist,\n" +
                "    P.nombrePlaylist,\n" +
                "    COUNT(F.IDCancion) AS NumeroCanciones,\n" +
                "    TO_CHAR(INTERVAL '1 second' * SUM(EXTRACT(EPOCH FROM C.duracion)), 'HH24:MI:SS') AS DuracionTotal\n" +
                "FROM \n" +
                "    PLAYLIST P\n" +
                "LEFT JOIN \n" +
                "    FORMARPARTE F ON P.IDPlaylist = F.IDPlaylist\n" +
                "LEFT JOIN \n" +
                "    CANCION C ON F.IDCancion = C.IDCancion\n" +
                "WHERE \n" +
                "    P.IDOyente = ?\n" +
                "GROUP BY \n" +
                "    P.IDPlaylist, P.nombrePlaylist;";
        try {
            stmPlaylist = con.prepareStatement(sql);
            stmPlaylist.setString(1, nombreUsuario);

            rsPlaylist = stmPlaylist.executeQuery();
            while (rsPlaylist.next()) {
                String nombrePlaylist = rsPlaylist.getString("nombrePlaylist");
                int canciones = rsPlaylist.getInt("NumeroCanciones");
                String duracionTotal = rsPlaylist.getString("DuracionTotal");

                Elemento playlist = new Elemento(nombrePlaylist,canciones,duracionTotal);

                playlistsEncontradas.add(playlist);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmPlaylist.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return playlistsEncontradas;
    }

    public List<Cancion> obtenerCancionesDePlaylist(String nombrePlaylist) {
        Connection con = null;
        PreparedStatement stmCanciones = null;
        ResultSet rsCanciones = null;
        List<Cancion> cancionesDePlaylist = new ArrayList<>();

        try {
            con = this.getConexion();

            // Consulta para obtener las canciones de una playlist a partir del nombre de la playlist
            String sqlObtenerCanciones  = "SELECT c.* " +
                    "FROM CANCION c " +
                    "JOIN FORMARPARTE fp ON c.IDCancion = fp.IDCancion " +
                    "JOIN PLAYLIST p ON fp.IDPlaylist = p.IDPlaylist " +
                    "WHERE p.nombrePlaylist = ?";

            // Obtener las canciones de la playlist
            stmCanciones = con.prepareStatement(sqlObtenerCanciones);
            stmCanciones.setString(1, nombrePlaylist);
            rsCanciones = stmCanciones.executeQuery();

            // Iterar sobre los resultados y crear objetos de tipo Cancion
            while (rsCanciones.next()) {
                Cancion cancion = new Cancion(
                        rsCanciones.getString("nombre"),
                        rsCanciones.getInt("IDCancion"),
                        rsCanciones.getString("duracion"),
                        rsCanciones.getString("idioma"),
                        rsCanciones.getString("nombreGenero"),
                        rsCanciones.getBoolean("letra"),
                        rsCanciones.getInt("visualizaciones"),
                        rsCanciones.getInt("IDalbum"),
                        rsCanciones.getBoolean("explicito")
                );
                cancionesDePlaylist.add(cancion);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (rsCanciones != null) {
                    rsCanciones.close();
                }
                if (stmCanciones != null) {
                    stmCanciones.close();
                }
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

        return cancionesDePlaylist;
    }


}