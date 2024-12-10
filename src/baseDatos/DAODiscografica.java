package baseDatos;

import aplicacion.Discografica;

import java.sql.*;
import java.util.*;

public class DAODiscografica extends abstractDAO {
    public DAODiscografica(Connection conexion, aplicacion.fachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public Discografica buscarDiscografica(String nombreDiscografica) {
        Connection con = null;
        PreparedStatement stmDiscografica = null;
        ResultSet rsDiscografica = null;

        try {
            con = this.getConexion();

            // Consulta SQL para buscar una discográfica por su nombre
            String sqlBuscarDiscografica = "SELECT * FROM DISCOGRAFICA WHERE nombre = ?";

            // Preparar la consulta
            stmDiscografica = con.prepareStatement(sqlBuscarDiscografica);
            stmDiscografica.setString(1, nombreDiscografica); // Asignar el parámetro nombre

            // Ejecutar la consulta
            rsDiscografica = stmDiscografica.executeQuery();

            // Verificar si se encontró alguna discográfica
            if (rsDiscografica.next()) {
                // Construir y devolver el objeto Discografica
                int IDDiscografica = rsDiscografica.getInt("IDDiscografica");
                String nombre = rsDiscografica.getString("nombre");
                //String pais = rsDiscografica.getString("pais");
                return new Discografica(IDDiscografica, nombre);//, pais);
            } else {
                // Si no se encuentra ninguna discográfica, devolver null
                return null;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            return null; // Manejar la excepción y devolver null en caso de error
        } finally {
            // Cerrar recursos
            try {
                if (rsDiscografica != null) {
                    rsDiscografica.close();
                }
                if (stmDiscografica != null) {
                    stmDiscografica.close();
                }
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    public int insertarDiscografica(String nombreDiscografica) {
        Connection con = null;
        PreparedStatement stmDiscografica = null;
        ResultSet rsMaxID = null;
        int nuevoIDDiscografica = -1; // Valor por defecto en caso de error

        try {
            con = this.getConexion();

            // Consulta SQL para obtener el máximo ID de discográfica
            String sqlMaxID = "SELECT MAX(IDDiscografica) FROM DISCOGRAFICA";

            // Obtener el máximo ID de discográfica actual
            stmDiscografica = con.prepareStatement(sqlMaxID);
            rsMaxID = stmDiscografica.executeQuery();
            if (rsMaxID.next()) {
                nuevoIDDiscografica = rsMaxID.getInt(1) + 1;
            }

            // Consulta SQL para insertar una nueva discográfica
            String sqlInsertDiscografica = "INSERT INTO DISCOGRAFICA (IDDiscografica, nombre) VALUES (?, ?)";

            // Insertar la discográfica con el nuevo ID
            stmDiscografica = con.prepareStatement(sqlInsertDiscografica);
            stmDiscografica.setInt(1, nuevoIDDiscografica);
            stmDiscografica.setString(2, nombreDiscografica);
            stmDiscografica.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            return -1; // Si ocurre una excepción, devuelve un ID inválido
        } finally {
            try {
                if (rsMaxID != null) {
                    rsMaxID.close();
                }
                if (stmDiscografica != null) {
                    stmDiscografica.close();
                }
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

        // Devolver el nuevo ID de la discográfica creada
        return nuevoIDDiscografica;
    }

    public void eliminarDiscografica(int idDiscografica) {
        Connection con = null;
        PreparedStatement stmDiscografica = null;

        try {
            con = this.getConexion();

            // Consulta para eliminar la discográfica
            String sqlEliminarDiscografica = "DELETE FROM DISCOGRAFICA WHERE IDDiscografica = ?";

            // Eliminar la discográfica
            stmDiscografica = con.prepareStatement(sqlEliminarDiscografica);
            stmDiscografica.setInt(1, idDiscografica);
            stmDiscografica.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (stmDiscografica != null) {
                    stmDiscografica.close();
                }
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }


}
