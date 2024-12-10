package aplicacion;

public class Discografica {
    private int IDDiscografica;
    private String nombre;
    //private String pais;

    public Discografica(int IDDiscografica, String nombre){//, String pais) {
        this.IDDiscografica = IDDiscografica;
        this.nombre = nombre;
        //this.pais = pais;
    }

    public int getIDDiscografica() {
        return IDDiscografica;
    }

    public void setIDDiscografica(int IDDiscografica) {
        this.IDDiscografica = IDDiscografica;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /*
    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }*/

    @Override
    public String toString() {
        return "Discografica{" +
                "IDDiscografica=" + IDDiscografica +
                ", nombre='" + nombre + '\'' +
                //", pais='" + pais + '\'' +
                '}';
    }


}

