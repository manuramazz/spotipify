package baseDatos;

import aplicacion.Album;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DAOAlbum extends abstractDAO {
    public DAOAlbum(Connection conexion, aplicacion.fachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public List<String> obtenerCancionesPorAlbum(String nombreAlbum, String artistaAlbum) {
        List<String> canciones = new ArrayList<>();
        Connection con = null;
        PreparedStatement stmCanciones = null,stmId;
        ResultSet rsCanciones = null,rsId;
        int id=0;
        try {
            con = getConexion();
            String sqlId = "SELECT IDAlbum FROM COMPONER WHERE IDArtista = (SELECT nombre from Artista where nombreArtistico = ?) " +
                    "AND IDAlbum IN (SELECT a.IDAlbum from ALBUM a WHERE a.nombre=?)\n";
            stmId = con.prepareStatement(sqlId);
            stmId.setString(1, artistaAlbum);
            stmId.setString(2, nombreAlbum);
            rsId = stmId.executeQuery();
            if (rsId.next()) {
                id=rsId.getInt("IDAlbum");
            }

            // Consulta para obtener todas las canciones de un álbum dado
            String sql = "SELECT nombre FROM CANCION " +
                    "WHERE IDAlbum = ?";
            stmCanciones = con.prepareStatement(sql);
            stmCanciones.setInt(1, id);
            rsCanciones = stmCanciones.executeQuery();

            // Iterar sobre el resultado y agregar el nombre de cada canción a la lista
            while (rsCanciones.next()) {
                canciones.add(rsCanciones.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            // Manejar la excepción apropiadamente
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

        return canciones;
    }

    public List<Album> buscarAlbumes(String terminoBusqueda) {
        Connection con;
        PreparedStatement stmAlbum = null;
        ResultSet rsAlbum;
        List<Album> albumesEncontrados = new ArrayList<>();

        con = this.getConexion();


        String sql = "SELECT * FROM ALBUM WHERE nombre LIKE ?";
        try {
            stmAlbum = con.prepareStatement(sql);
            stmAlbum.setString(1, "%" + terminoBusqueda + "%");

            rsAlbum = stmAlbum.executeQuery();
            while (rsAlbum.next()) {
                int idAlbum = rsAlbum.getInt("IDAlbum");
                String nombre = rsAlbum.getString("nombre");
                String tipo = rsAlbum.getString("tipo");
                int añoLanzamiento = rsAlbum.getInt("añoLanzamiento");
                int idDiscografica = rsAlbum.getInt("IDDiscografica"); // Suponiendo que hay un campo IDDiscografica en la tabla ALBUM

                Album album = new Album(idAlbum, nombre, tipo, añoLanzamiento, idDiscografica);
                albumesEncontrados.add(album);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmAlbum.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return albumesEncontrados;
    }

    public List<String> obtenerArtistaDeAlbum(String nombreAlbum) {
        Connection con;
        PreparedStatement stmArtista = null;
        ResultSet rsArtista;
        List<String> nombreArtista = new ArrayList<>();

        con = this.getConexion();

        String sql = "SELECT a.nombreArtistico " +
                "FROM ARTISTA a " +
                "INNER JOIN COMPONER c ON a.nombre = c.IDArtista " +
                "INNER JOIN ALBUM al ON c.IDAlbum = al.IDAlbum " +
                "WHERE al.nombre = ?";
        try {
            stmArtista = con.prepareStatement(sql);
            stmArtista.setString(1, nombreAlbum);

            rsArtista = stmArtista.executeQuery();
            while (rsArtista.next()) {
                nombreArtista.add(rsArtista.getString("nombreArtistico"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmArtista.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return nombreArtista;
    }

    public int obtenerIDnuevo() {
        Connection con;
        PreparedStatement stmArtista = null;
        ResultSet rsArtista;
        int ID = -1;

        con = this.getConexion();

        String sql = "SELECT MAX(IDAlbum) + 1 as numeroNuevo FROM ALBUM";
        try {
            stmArtista = con.prepareStatement(sql);

            rsArtista = stmArtista.executeQuery();
            if (rsArtista.next()) {
                ID = rsArtista.getInt("numeroNuevo");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (stmArtista != null) {
                    stmArtista.close();
                }
            }catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return ID;
    }



    public void registrarAlbum(Album album, int IDDiscografica, String IDArtista) {
        Connection con;
        PreparedStatement stmAlbum=null,stmComponer=null;

        con=this.getConexion();

        try {
            int IDAlbumNuevo = obtenerIDnuevo();
            stmAlbum=con.prepareStatement("INSERT INTO ALBUM (nombre, IDAlbum, tipo, añoLanzamiento, IDDiscografica) " +
                    "VALUES (?, ?, ?, ?, ?);");


            stmAlbum.setString(1, album.getNombre());
            stmAlbum.setInt(2, IDAlbumNuevo);
            stmAlbum.setString(3, album.getTipo());
            stmAlbum.setInt(4, album.getAñoLanzamiento());
            stmAlbum.setInt(5, IDDiscografica);
            stmAlbum.executeUpdate();


            // Consulta para insertar en la tabla COMPONER
            String sqlInsertComponer = "INSERT INTO COMPONER (IDAlbum, IDArtista) VALUES (?, ?)";

            // Insertar en la tabla COMPONER
            stmComponer = con.prepareStatement(sqlInsertComponer);
            stmComponer.setInt(1, IDAlbumNuevo);
            stmComponer.setString(2, IDArtista);
            stmComponer.executeUpdate();

        } catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally{
            try {stmAlbum.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }

    public void eliminarAlbum(int idAlbum) {
        Connection con = null;
        PreparedStatement stmAlbum = null;

        try {
            con = this.getConexion();

            // Consulta para eliminar el álbum
            String sqlEliminarAlbum = "DELETE FROM ALBUM WHERE IDAlbum = ?";

            // Eliminar el álbum
            stmAlbum = con.prepareStatement(sqlEliminarAlbum);
            stmAlbum.setInt(1, idAlbum);
            stmAlbum.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (stmAlbum != null) {
                    stmAlbum.close();
                }
                /*
                if (con != null) {
                    con.close();
                }*/
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }



}