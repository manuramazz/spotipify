package baseDatos;

public abstract class abstractDAO {
    private aplicacion.fachadaAplicacion fa;
    private java.sql.Connection conexion;


    protected java.sql.Connection getConexion(){
        return this.conexion;
    }

    protected void setConexion(java.sql.Connection conexion){
        this.conexion=conexion;
    }

    protected void setFachadaAplicacion(aplicacion.fachadaAplicacion fa){
        this.fa=fa;
    }

    protected aplicacion.fachadaAplicacion getFachadaAplicacion(){
        return fa;
    }


}
