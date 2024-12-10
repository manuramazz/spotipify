package baseDatos;

import aplicacion.Cancion;
import aplicacion.Artista;
import java.sql.*;
import java.util.*;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DAOCancion extends abstractDAO {
    public DAOCancion(Connection conexion, aplicacion.fachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }


    public int comprobarValoracionCancion(int idcancion,String usuario) {
        Connection con;
        PreparedStatement stmPlaylist = null;
        ResultSet rsPlaylist;
        int idPlaylist=0;
        con = this.getConexion();
        int resultado = 0;

        String sql = "SELECT * FROM VALORAR WHERE IDOyente = ? and IDCancion = ?";
        try {
            stmPlaylist = con.prepareStatement(sql);
            stmPlaylist.setInt(2, idcancion);
            stmPlaylist.setString(1, usuario);
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


    public double mediaValoraciones(int idCancion, String usuario) {
        Connection con = null;
        PreparedStatement stmValor = null;
        ResultSet rsValor = null;
        double media = 0;

        try {
            con = this.getConexion();

            // Consulta para calcular la media de las valoraciones para una canción específica y un usuario dado
            String sql = "SELECT AVG(valor) AS media FROM VALORAR WHERE IDCancion = ? AND IDOyente = ?";
            stmValor = con.prepareStatement(sql);
            stmValor.setInt(1, idCancion);
            stmValor.setString(2, usuario);
            rsValor = stmValor.executeQuery();

            // Verificar si se encontraron valoraciones para la canción y el usuario dados
            if (rsValor.next()) {
                media = rsValor.getDouble("media");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (rsValor != null) {
                    rsValor.close();
                }
                if (stmValor != null) {
                    stmValor.close();
                }
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

        return media;
    }


    public List<Cancion> buscarCanciones(String terminoBusqueda) {
        Connection con;
        PreparedStatement stmCancion = null;
        ResultSet rsCancion;
        List<Cancion> cancionesEncontradas = new ArrayList<>();

        con = this.getConexion();

        String sql = "SELECT * FROM CANCION WHERE nombre like ?";
        try {
            stmCancion = con.prepareStatement(sql);
            stmCancion.setString(1, "%" + terminoBusqueda + "%");

            rsCancion = stmCancion.executeQuery();
            while (rsCancion.next()) {
                String nombre = rsCancion.getString("nombre");
                int idCancion = rsCancion.getInt("IDCancion");
                String duracion = rsCancion.getString("duracion");
                String idioma = rsCancion.getString("idioma");
                String nombreGenero = rsCancion.getString("nombreGenero");
                boolean letra = rsCancion.getBoolean("letra");
                int visualizaciones = rsCancion.getInt("visualizaciones");
                int IDAlbum = rsCancion.getInt("IDAlbum");
                boolean explicito = rsCancion.getBoolean("explicito");

                Cancion cancion = new Cancion(nombre, idCancion, duracion, idioma, nombreGenero, letra, visualizaciones, IDAlbum, explicito);
                cancionesEncontradas.add(cancion);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmCancion.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return cancionesEncontradas;
    }
    public List<Cancion> buscarCancionesEn(String terminoBusqueda) {
        Connection con;
        PreparedStatement stmCancion = null;
        ResultSet rsCancion;
        List<Cancion> cancionesEncontradas = new ArrayList<>();

        con = this.getConexion();

        String sql = "SELECT * FROM CANCION WHERE nombre = ?";
        try {
            stmCancion = con.prepareStatement(sql);
            stmCancion.setString(1, terminoBusqueda);

            rsCancion = stmCancion.executeQuery();
            while (rsCancion.next()) {
                String nombre = rsCancion.getString("nombre");
                int idCancion = rsCancion.getInt("IDCancion");
                String duracion = rsCancion.getString("duracion");
                String idioma = rsCancion.getString("idioma");
                String nombreGenero = rsCancion.getString("nombreGenero");
                boolean letra = rsCancion.getBoolean("letra");
                int visualizaciones = rsCancion.getInt("visualizaciones");
                int IDAlbum = rsCancion.getInt("IDAlbum");
                boolean explicito = rsCancion.getBoolean("explicito");

                Cancion cancion = new Cancion(nombre, idCancion, duracion, idioma, nombreGenero, letra, visualizaciones, IDAlbum, explicito);
                cancionesEncontradas.add(cancion);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmCancion.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return cancionesEncontradas;
    }

    public String obtenerArtistaDeCancion(String nombreCancion) {
        Connection con;
        PreparedStatement stmArtista = null;
        ResultSet rsArtista;
        String nombreArtista = null;

        con = this.getConexion();

        String sql = "SELECT a.nombreArtistico " +
                "FROM ARTISTA a " +
                "INNER JOIN COMPONER c ON a.nombre = c.IDArtista " +
                "INNER JOIN CANCION ca ON c.IDAlbum = ca.IDAlbum " +
                "WHERE ca.nombre = ?";
        try {
            stmArtista = con.prepareStatement(sql);
            stmArtista.setString(1, nombreCancion);

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


    public List<Artista> obtenerArtistasDeCancion(String nombreCancion) {
        Connection con;
        PreparedStatement stmArtista = null;
        ResultSet rsArtista;
        List<Artista>  artistas = new ArrayList<>();

        con = this.getConexion();

        String sql = "SELECT a.* " +
                "FROM ARTISTA a " +
                "INNER JOIN COMPONER c ON a.nombre = c.IDArtista " +
                "INNER JOIN CANCION ca ON c.IDAlbum = ca.IDAlbum " +
                "WHERE ca.nombre = ?";
        try {
            stmArtista = con.prepareStatement(sql);
            stmArtista.setString(1, nombreCancion);

            rsArtista = stmArtista.executeQuery();
            while (rsArtista.next()) {
                artistas.add(new Artista(rsArtista.getString("nombre"),rsArtista.getString("contraseña"),
                        rsArtista.getString("email"),rsArtista.getDate("fechaNacimiento"),
                        rsArtista.getString("nombreArtistico"),rsArtista.getString("paisNacimiento")));
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

    public void valorarCancion(String usuarioActual,int cancion,int valor){
        Connection con = null;
        PreparedStatement stmCancion = null;

        try {
            con = this.getConexion();

            // Consulta para insertar la canción
            String sqlCancion = "INSERT INTO VALORAR (IDOyente,IDCancion,valor) " +
                    "VALUES (?, ?, ?)";


            // Obtener el último ID de canción
                stmCancion = con.prepareStatement(sqlCancion);
                stmCancion.setString(1, usuarioActual);
                stmCancion.setInt(2, cancion);
                stmCancion.setInt(3,valor);

                stmCancion.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (stmCancion != null) {
                    stmCancion.close();
                }
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }


    public void publicarCancion(Cancion cancion, int IDAlbum) {
        Connection con = null;
        PreparedStatement stmCancion = null;
        Statement stmtUltimoIDCancion = null;
        ResultSet rsUltimoIDCancion = null;

        try {
            con = this.getConexion();

            // Consulta para insertar la canción
            String sqlCancion = "INSERT INTO CANCION (nombre, IDCancion, duracion, idioma, nombreGenero, letra, visualizaciones, IDAlbum, explicito) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            // Consulta para obtener el último ID de canción
            String sqlUltimoIDCancion = "SELECT MAX(IDCancion) FROM CANCION";
            Time tiempo=null;
            // Obtener el último ID de canción
            stmtUltimoIDCancion = con.createStatement();
            rsUltimoIDCancion = stmtUltimoIDCancion.executeQuery(sqlUltimoIDCancion);
            int ultimoIDCancion = 0;
            if (rsUltimoIDCancion.next()) {
                ultimoIDCancion = rsUltimoIDCancion.getInt(1);
                // Incrementar el último ID de canción para obtener un nuevo ID único
                int nuevoIDCancion = ultimoIDCancion + 1;
                SimpleDateFormat formato = new SimpleDateFormat("mm:ss");

                try {
                    Date date = formato.parse(cancion.getDuracion());
                    tiempo = new Time(date.getTime());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                // Insertar la canción
                stmCancion = con.prepareStatement(sqlCancion);
                stmCancion.setString(1, cancion.getNombre());
                stmCancion.setInt(2, nuevoIDCancion);
                stmCancion.setTime(3, tiempo);
                stmCancion.setString(4, cancion.getIdioma());
                stmCancion.setString(5, cancion.getNombreGenero());
                stmCancion.setBoolean(6, cancion.isLetra());
                stmCancion.setInt(7, cancion.getVisualizaciones());
                stmCancion.setInt(8, IDAlbum); // Utilizar el ID de álbum proporcionado
                stmCancion.setBoolean(9, cancion.isExplicito());

                stmCancion.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (rsUltimoIDCancion != null) {
                    rsUltimoIDCancion.close();
                }
                if (stmtUltimoIDCancion != null) {
                    stmtUltimoIDCancion.close();
                }
                if (stmCancion != null) {
                    stmCancion.close();
                }
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    public List<Cancion> obtenerUltimasCanciones(int numCanciones) {
        Connection con = null;
        PreparedStatement stmCanciones = null;
        ResultSet rsCanciones = null;
        List<Cancion> canciones = new ArrayList<>();

        try {
            con = this.getConexion();
            String sql = "SELECT * FROM CANCION WHERE IDCancion >= ((SELECT MAX(IDCancion) FROM CANCION) - ?) AND IDCancion <= (SELECT MAX(IDCancion) FROM CANCION) ORDER BY IDCancion DESC";
            stmCanciones = con.prepareStatement(sql);
            stmCanciones.setInt(1, numCanciones);
            rsCanciones = stmCanciones.executeQuery();

            while (rsCanciones.next()) {
                // Obtener los datos de la canción
                String nombre = rsCanciones.getString("nombre");
                int IDCancion = rsCanciones.getInt("IDCancion");
                String duracion = rsCanciones.getString("duracion");
                String idioma = rsCanciones.getString("idioma");
                String nombreGenero = rsCanciones.getString("nombreGenero");
                boolean letra = rsCanciones.getBoolean("letra");
                int visualizaciones = rsCanciones.getInt("visualizaciones");
                int IDalbum = rsCanciones.getInt("IDalbum");
                boolean explicito = rsCanciones.getBoolean("explicito");

                // Crear el objeto Cancion y añadirlo a la lista
                Cancion cancion = new Cancion(nombre, IDCancion, duracion, idioma, nombreGenero, letra, visualizaciones, IDalbum, explicito);
                canciones.add(cancion);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            // Cerrar recursos
            try {
                if (rsCanciones != null) rsCanciones.close();
                if (stmCanciones != null) stmCanciones.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return canciones;
    }


}

