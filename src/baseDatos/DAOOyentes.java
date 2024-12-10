package baseDatos;
import aplicacion.*;
import java.sql.*;
import java.text.*;
public class DAOOyentes extends abstractDAO{
    public DAOOyentes (Connection conexion, aplicacion.fachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public Oyente validarUsuario(String nombre, String contrasena){
        Oyente resultado=null;
        Connection con;
        PreparedStatement stmUsuario=null;
        ResultSet rsOyente;

        con=this.getConexion();

        try {
            stmUsuario=con.prepareStatement("select nombre,contraseña,email,fechaNacimiento,tipoPlan,fechaPago,fechaVencimiento "+
                    "from oyente "+
                    "where nombre = ? and contraseña = ?");
            stmUsuario.setString(1, nombre);
            stmUsuario.setString(2, contrasena);
            rsOyente=stmUsuario.executeQuery();
            if (rsOyente.next())
            {
                resultado = new Oyente(rsOyente.getString("nombre"),rsOyente.getString("contraseña"),rsOyente.getString("email"),
                        rsOyente.getDate("fechaNacimiento"),rsOyente.getString("tipoPlan"),rsOyente.getDate("fechaPago"),
                        rsOyente.getDate("fechaVencimiento"));

            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
            try {stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }

    public void registrarOyente(String usuario, String correo, String contrasena, String fechaNacimiento){
        Connection con;
        PreparedStatement stmUsuario=null;

        con=this.getConexion();

        try {
            stmUsuario=con.prepareStatement("INSERT INTO OYENTE (nombre, contraseña, email, fechaNacimiento, tipoPlan, fechaPago, fechaVencimiento, cancion) " +
                    "VALUES (?, ?, ?, ?, (SELECT tipo FROM PLAN WHERE tipo = 'Basico'), null, null, null);");
            stmUsuario.setString(1, usuario);
            stmUsuario.setString(2, contrasena);
            stmUsuario.setString(3, correo);
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            try {
                java.util.Date fechaUtil = formatoFecha.parse(fechaNacimiento); // Convertir la cadena a java.util.Date
                java.sql.Date fechaSql = new java.sql.Date(fechaUtil.getTime()); // Convertir java.util.Date a java.sql.Date
                stmUsuario.setDate(4, fechaSql);
            } catch (ParseException e) {
                // Manejar la excepción si la cadena no está en el formato esperado
                this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            }

            stmUsuario.executeUpdate();

        } catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally{
            try {stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }


    }
}
