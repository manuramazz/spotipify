package baseDatos;

import aplicacion.Artista;
import aplicacion.Oyente;
import aplicacion.Playlist;

import java.sql.Date;
import java.util.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOArtistas extends abstractDAO {
    public DAOArtistas (Connection conexion, aplicacion.fachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public Artista validarArtista(String nombre, String contrasena){
        Artista resultado=null;
        Connection con;
        PreparedStatement stmUsuario=null;
        ResultSet rsOyente;

        con=this.getConexion();

        try {
            stmUsuario=con.prepareStatement("select nombre,contraseña,email,fechaNacimiento,nombreArtistico,paisNacimiento "+
                    "from artista "+
                    "where nombre = ? and contraseña = ?");
            stmUsuario.setString(1, nombre);
            stmUsuario.setString(2, contrasena);
            rsOyente=stmUsuario.executeQuery();
            if (rsOyente.next())
            {
                resultado = new Artista(rsOyente.getString("nombre"),rsOyente.getString("contraseña"),rsOyente.getString("email"),
                        rsOyente.getDate("fechaNacimiento"),rsOyente.getString("nombreArtistico"),rsOyente.getString("paisNacimiento"));

            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
            try {stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }

    public String obtenerArtistasDePodcast(String nombrePodcast) {
        Connection con;
        PreparedStatement stmArtista = null;
        ResultSet rsArtista;
        String  artistas = "";

        con = this.getConexion();

        String sql = "SELECT a.* " +
                "FROM ARTISTA a " +
                "INNER JOIN PARTICIPARPODCAST c ON a.nombre = c.IDArtista " +
                "INNER JOIN PODCAST p ON c.IDPodcast = p.IDPodcast " +
                "WHERE p.nombre = ?";
        try {
            stmArtista = con.prepareStatement(sql);
            stmArtista.setString(1, nombrePodcast);

            rsArtista = stmArtista.executeQuery();
            if (rsArtista.next()) {
                artistas += rsArtista.getString("nombreArtistico");
            }
            while (rsArtista.next()) {
                artistas += ","+rsArtista.getString("nombreArtistico");
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
        return artistas;
    }



    public List<Artista> buscarArtistas(String terminoBusqueda) {
        Connection con;
        PreparedStatement stmArtista=null;
        ResultSet rsArtista;
        List<Artista> artistasEncontrados = new ArrayList<>();

        con = this.getConexion();

        String sql = "SELECT * FROM ARTISTA WHERE nombreArtistico LIKE ?";
        try {
            stmArtista = con.prepareStatement(sql);
            stmArtista.setString(1, "%" + terminoBusqueda + "%");

            rsArtista = stmArtista.executeQuery();
            while (rsArtista.next()) {
                String nombre = rsArtista.getString("nombre");
                String contraseña = rsArtista.getString("contraseña");
                String email = rsArtista.getString("email");
                Date fechaNacimiento  = rsArtista.getDate("fechaNacimiento");
                String nombreArtistico = rsArtista.getString("nombreArtistico");
                String paisNacimiento = rsArtista.getString("paisNacimiento");


                Artista artista = new Artista(nombre, contraseña, email, fechaNacimiento, nombreArtistico, paisNacimiento);

                artistasEncontrados.add(artista);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
            try {stmArtista.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return artistasEncontrados;
    }

    public List<Artista> buscarArtistasAutentificacion(String terminoBusqueda) {
        Connection con;
        PreparedStatement stmArtista=null;
        ResultSet rsArtista;
        List<Artista> artistasEncontrados = new ArrayList<>();

        con = this.getConexion();

        String sql = "SELECT * FROM ARTISTA WHERE nombre = ?";
        try {
            stmArtista = con.prepareStatement(sql);
            stmArtista.setString(1, terminoBusqueda);

            rsArtista = stmArtista.executeQuery();
            while (rsArtista.next()) {
                String nombre = rsArtista.getString("nombre");
                String contraseña = rsArtista.getString("contraseña");
                String email = rsArtista.getString("email");
                Date fechaNacimiento  = rsArtista.getDate("fechaNacimiento");
                String nombreArtistico = rsArtista.getString("nombreArtistico");
                String paisNacimiento = rsArtista.getString("paisNacimiento");


                Artista artista = new Artista(nombre, contraseña, email, fechaNacimiento, nombreArtistico, paisNacimiento);

                artistasEncontrados.add(artista);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
            try {stmArtista.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return artistasEncontrados;
    }

    public List<Artista> buscarArtistasMismoGenero(String nombreArtista) {
        Connection con;
        PreparedStatement stmArtistas = null;
        ResultSet rsArtistas;
        List<Artista> artistasEncontrados = new ArrayList<>();

        con = this.getConexion();

        String sql = "SELECT a.* FROM ARTISTA a " +
                "INNER JOIN PARTICIPARGÉNERO pg ON a.nombre = pg.IDArtista " +
                "INNER JOIN PARTICIPARGÉNERO pg2 ON pg.nombreGenero = pg2.nombreGenero " +
                "WHERE pg2.IDArtista = ?";

        try {
            stmArtistas = con.prepareStatement(sql);
            stmArtistas.setString(1, nombreArtista);

            rsArtistas = stmArtistas.executeQuery();
            while (rsArtistas.next()) {
                String nombre = rsArtistas.getString("nombre");
                String contraseña = rsArtistas.getString("contraseña");
                String email = rsArtistas.getString("email");
                Date fechaNacimiento  = rsArtistas.getDate("fechaNacimiento");
                String nombreArtistico = rsArtistas.getString("nombreArtistico");
                String paisNacimiento = rsArtistas.getString("paisNacimiento");

                Artista artista = new Artista(nombre, contraseña, email, fechaNacimiento, nombreArtistico, paisNacimiento);
                artistasEncontrados.add(artista);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmArtistas.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return artistasEncontrados;
    }

    public int obtenerIDArtistaPorNombre(String nombreArtista) {
        Connection con = null;
        PreparedStatement stmArtista = null;
        ResultSet rsArtista = null;
        int idArtista = -1;

        try {
            con = this.getConexion();

            // Consulta SQL para obtener el ID del artista por su nombre
            String sqlObtenerIDArtista = "SELECT nombre, IDArtista FROM ARTISTA WHERE nombre = ?";

            // Preparar la consulta
            stmArtista = con.prepareStatement(sqlObtenerIDArtista);
            stmArtista.setString(1, nombreArtista); // Asignar el parámetro nombre

            // Ejecutar la consulta
            rsArtista = stmArtista.executeQuery();

            // Verificar si se encontró algún artista
            if (rsArtista.next()) {
                // Obtener el ID del artista encontrado
                idArtista = rsArtista.getInt("IDArtista");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (rsArtista != null) {
                    rsArtista.close();
                }
                if (stmArtista != null) {
                    stmArtista.close();
                }
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return idArtista;
    }

}
