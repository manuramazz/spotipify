package aplicacion;
import baseDatos.*;
import gui.*;


import java.util.List;

public class gestionDiscograficas{
    fachadaGui fgui;
    fachadaBaseDatos fbd;

    public gestionDiscograficas(fachadaGui fgui, fachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }

    public int insertarDiscografica(String nombreDiscografica){
        return fbd.insertarDiscografica(nombreDiscografica);
    }
    public Discografica buscarDiscografica(String nombreDiscografica){
        return fbd.buscarDiscografica(nombreDiscografica);
    }
    public void eliminarDiscografica(int idDiscografica){
        fbd.eliminarDiscografica(idDiscografica);
    }

}
