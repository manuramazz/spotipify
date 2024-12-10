package baseDatos;

import aplicacion.Cancion;
import aplicacion.Capitulo;
import aplicacion.Podcast;
import aplicacion.Artista;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class DAOCapitulo extends abstractDAO {

    public DAOCapitulo(Connection conexion, aplicacion.fachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public void insertarCapitulo(Capitulo capitulo) {
        Connection con = null;
        PreparedStatement stmCapitulo = null;

        try {
            con = getConexion();

            // Consulta para obtener el último ID de capítulo para el podcast dado
            String sqlUltimoIDCapitulo = "SELECT MAX(IDCapitulo) FROM Capitulo";
            PreparedStatement stmUltimoIDCapitulo = con.prepareStatement(sqlUltimoIDCapitulo);
            ResultSet rsUltimoIDCapitulo = stmUltimoIDCapitulo.executeQuery();

            int ultimoIDCapitulo = 0;
            if (rsUltimoIDCapitulo.next()) {
                ultimoIDCapitulo = rsUltimoIDCapitulo.getInt(1);
            }

            // Incrementar el último ID de capítulo para obtener un nuevo ID único
            int nuevoIDCapitulo = ultimoIDCapitulo + 1;
            SimpleDateFormat formato = new SimpleDateFormat("mm:ss");
            Time dur=null;
            try {
                Date date = formato.parse(capitulo.getDuracion());
                dur = new Time(date.getTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            // Consulta para insertar el capítulo
            String sqlInsertCapitulo = "INSERT INTO Capitulo (nombre, IDCapitulo, duracion, explicito, IDPodcast) " +
                    "VALUES (?, ?, ?, ?, ?)";

            // Insertar el capítulo
            stmCapitulo = con.prepareStatement(sqlInsertCapitulo);
            stmCapitulo.setString(1, capitulo.getNombre());
            stmCapitulo.setInt(2, nuevoIDCapitulo);
            stmCapitulo.setTime(3, dur);
            stmCapitulo.setBoolean(4, capitulo.isExplicito());
            stmCapitulo.setInt(5, capitulo.getIDPodcast());
            stmCapitulo.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (stmCapitulo != null) {
                    stmCapitulo.close();
                }
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    public void eliminarCapitulo(int IDCapitulo, int IDPodcast) {
        Connection con = null;
        PreparedStatement stmEliminarCapitulo = null;

        try {
            con = getConexion();

            // Consulta para eliminar el capítulo de un podcast concreto
            String sqlEliminarCapitulo = "DELETE FROM Capitulo WHERE IDCapitulo = ? AND IDPodcast = ?";

            // Eliminar el capítulo
            stmEliminarCapitulo = con.prepareStatement(sqlEliminarCapitulo);
            stmEliminarCapitulo.setInt(1, IDCapitulo);
            stmEliminarCapitulo.setInt(2, IDPodcast);
            stmEliminarCapitulo.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (stmEliminarCapitulo != null) {
                    stmEliminarCapitulo.close();
                }
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    public List<Capitulo> buscarCapitulosPodcast(int IDPodcast) {
        Connection con;
        PreparedStatement stmCapitulo = null;
        //PreparedStatement stmID = null;
        ResultSet rsCapitulo;
        //ResultSet rsID;
        List<Capitulo> capitulosEncontrados = new ArrayList<>();

        con = this.getConexion();

        //String sqlID = "SELECT IDPodcast FROM PODCAST WHERE nombre LIKE ?"
        /*stmId = con.prepareStatement(sqlId);
        stmId.setString(1, nombrePodcast);
        rsId = stmId.executeQuery();
        int id = 0;
        if (rsId.next()) {
            id=rsId.getInt("IDAlbum");
        }*/

        String sql = "SELECT * FROM CAPITULO WHERE IDPodcast = ?";
        try {
            stmCapitulo = con.prepareStatement(sql);
            //stmCapitulo.setInt(1, id);
            stmCapitulo.setInt(1, IDPodcast);

            rsCapitulo = stmCapitulo.executeQuery();
            while (rsCapitulo.next()) {
                String nombre = rsCapitulo.getString("nombre");
                int idCapitulo = rsCapitulo.getInt("IDCapitulo");
                String duracion = rsCapitulo.getString("duracion");
                //int IDPodcast = rsCapitulo.getInt("IDPodcast");
                boolean explicito = rsCapitulo.getBoolean("explicito");

                Capitulo capitulo = new Capitulo(nombre, idCapitulo, duracion, explicito, IDPodcast);
                capitulosEncontrados.add(capitulo);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmCapitulo.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return capitulosEncontrados;
    }

}
