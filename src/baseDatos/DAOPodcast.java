package baseDatos;

import aplicacion.Podcast;

import java.sql.*;
import java.util.*;

public class DAOPodcast extends abstractDAO {
    public DAOPodcast(Connection conexion, aplicacion.fachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public List<Podcast> buscarPodcasts(String terminoBusqueda) {
        Connection con;
        PreparedStatement stmPodcast = null;
        ResultSet rsPodcast;
        List<Podcast> podcastsEncontrados = new ArrayList<>();

        con = this.getConexion();

        String sql = "SELECT r.IDPodcast,r.nombre FROM PODCAST r WHERE r.IDPodcast IN (SELECT p.IDPodcast FROM PARTICIPARPODCAST p WHERE p.IDArtista = ?)";
        try {
            stmPodcast = con.prepareStatement(sql);
            stmPodcast.setString(1,  terminoBusqueda);

            rsPodcast = stmPodcast.executeQuery();
            while (rsPodcast.next()) {
                int idPodcast = rsPodcast.getInt("IDPodcast");
                String nombre = rsPodcast.getString("nombre");

                Podcast podcast = new Podcast(idPodcast, nombre);
                // Agregar más campos al constructor de Podcast si es necesario

                podcastsEncontrados.add(podcast);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmPodcast.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return podcastsEncontrados;
    }
    public List<Podcast> buscarPodcastsPorNombre(String terminoBusqueda) {
        Connection con;
        PreparedStatement stmPodcast = null;
        ResultSet rsPodcast;
        List<Podcast> podcastsEncontrados = new ArrayList<>();

        con = this.getConexion();

        String sql = "SELECT r.IDPodcast,r.nombre FROM PODCAST r WHERE r.nombre LIKE ?";
        try {
            stmPodcast = con.prepareStatement(sql);
            stmPodcast.setString(1, "%" +terminoBusqueda+ "%");

            rsPodcast = stmPodcast.executeQuery();
            while (rsPodcast.next()) {
                int idPodcast = rsPodcast.getInt("IDPodcast");
                String nombre = rsPodcast.getString("nombre");

                Podcast podcast = new Podcast(idPodcast, nombre);
                // Agregar más campos al constructor de Podcast si es necesario

                podcastsEncontrados.add(podcast);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmPodcast.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return podcastsEncontrados;
    }
    public Podcast obtenerIDPodcast(String terminoBusqueda) {
        Connection con;
        PreparedStatement stmPodcast = null;
        ResultSet rsPodcast;
        Podcast podcastsEncontrados = null;

        con = this.getConexion();

        String sql = "SELECT * FROM PODCAST WHERE nombre = ?";
        try {
            stmPodcast = con.prepareStatement(sql);
            stmPodcast.setString(1,  terminoBusqueda);

            rsPodcast = stmPodcast.executeQuery();
            while (rsPodcast.next()) {
                int idPodcast = rsPodcast.getInt("IDPodcast");
                String nombre = rsPodcast.getString("nombre");

                podcastsEncontrados = new Podcast(idPodcast, nombre);
                // Agregar más campos al constructor de Podcast si es necesario
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmPodcast.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return podcastsEncontrados;
    }

    public String obtenerArtistaDePodcast(String nombrePodcast) {
        Connection con;
        PreparedStatement stmArtista = null;
        ResultSet rsArtista;
        String nombreArtista = null;
        int i = 23;
        con = this.getConexion();

        String sql = "SELECT a.nombreArtistico " +
                "FROM ARTISTA a " +
                "INNER JOIN PARTICIPARPODCAST pp ON a.nombre = pp.IDArtista " +
                "INNER JOIN PODCAST p ON pp.IDPodcast = p.IDPodcast " +
                "WHERE p.nombre = ?";
        try {
            stmArtista = con.prepareStatement(sql);
            stmArtista.setString(1, nombrePodcast);

            rsArtista = stmArtista.executeQuery();
            if (rsArtista.next()) {
                nombreArtista = rsArtista.getString("nombreArtistico");
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
    public String obtenerArtistasDePodcast(String nombrePodcast) {
        Connection con;
        PreparedStatement stmArtista = null;
        ResultSet rsArtista;
        String nombreArtista = null;
        int i = 23;
        con = this.getConexion();

        String sql = "SELECT a.nombreArtistico " +
                "FROM ARTISTA a " +
                "INNER JOIN PARTICIPARPODCAST pp ON a.nombre = pp.IDArtista " +
                "INNER JOIN PODCAST p ON pp.IDPodcast = p.IDPodcast " +
                "WHERE p.nombre = ?";
        try {
            stmArtista = con.prepareStatement(sql);
            stmArtista.setString(1, nombrePodcast);

            rsArtista = stmArtista.executeQuery();
            if (rsArtista.next()) {
                nombreArtista = rsArtista.getString("nombreArtistico");
            }
            while(rsArtista.next()) {
                nombreArtista += ","+rsArtista.getString("nombreArtistico");
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

    public void publicarPodcast(Podcast podcast, String idArtista) {
        Connection con = null;
        PreparedStatement stmPodcast = null;
        PreparedStatement stmParticiparPodcast = null;
        ResultSet rsUltimoIDPodcast = null;
        Statement stmtUltimoIDPodcast = null;

        try {
            con = this.getConexion();

            // Consulta para obtener el último ID de podcast
            String sqlUltimoIDPodcast = "SELECT MAX(IDPodcast) FROM PODCAST";

            // Obtener el último ID de podcast
            stmtUltimoIDPodcast = con.createStatement();
            rsUltimoIDPodcast = stmtUltimoIDPodcast.executeQuery(sqlUltimoIDPodcast);
            int ultimoIDPodcast = 0;
            if (rsUltimoIDPodcast.next()) {
                ultimoIDPodcast = rsUltimoIDPodcast.getInt(1);
            }

            // Incrementar el último ID de podcast para obtener un nuevo ID único
            int nuevoIDPodcast = ultimoIDPodcast + 1;

            // Consulta para insertar el podcast
            String sqlInsertPodcast = "INSERT INTO PODCAST (nombre, IDPodcast) VALUES (?, ?)";
            stmPodcast = con.prepareStatement(sqlInsertPodcast);
            stmPodcast.setString(1, podcast.getNombre());
            stmPodcast.setInt(2, nuevoIDPodcast);
            stmPodcast.executeUpdate();

            // Consulta para insertar en la tabla PARTICIPARPODCAST
            String sqlInsertParticiparPodcast = "INSERT INTO PARTICIPARPODCAST (IDPodcast, IDArtista) VALUES (?, ?)";
            stmParticiparPodcast = con.prepareStatement(sqlInsertParticiparPodcast);
            stmParticiparPodcast.setInt(1, nuevoIDPodcast);
            stmParticiparPodcast.setString(2, idArtista);
            stmParticiparPodcast.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (rsUltimoIDPodcast != null) {
                    rsUltimoIDPodcast.close();
                }
                if (stmtUltimoIDPodcast != null) {
                    stmtUltimoIDPodcast.close();
                }
                if (stmPodcast != null) {
                    stmPodcast.close();
                }
                if (stmParticiparPodcast != null) {
                    stmParticiparPodcast.close();
                }
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }


}