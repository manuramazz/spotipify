package gui;

import aplicacion.Elemento;

import java.util.ArrayList;
import java.util.List;

public class modeloTablaBuscarCanciones extends javax.swing.table.AbstractTableModel {
    //tabla de dos columnas, una con el tipo de dato y otra con el nombre
    private List<Elemento> datos;

    public modeloTablaBuscarCanciones(){
        this.datos=new ArrayList<Elemento>();
    }

    public String getColumnName(int col){
        String nombre="";

        switch (col){
            case 0: nombre= "Nombre"; break;
            case 1: nombre= "Artista"; break;
        }
        return nombre;
    }

    public Class getColumnClass(int col){
        Class clase = null;

        switch (col){
            case 0: clase= String.class; break;
            case 1: clase= String.class; break;
        }
        return clase;
    }

    @Override
    public String getValueAt(int row, int col){
        String resultado=null;

        switch (col){
            case 0: resultado= datos.get(row).getNombre(); break;
            case 1: resultado= datos.get(row).getArtista(); break;
        }
        return resultado;
    }


    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    public void setFilas(List<Elemento> elementos){
        this.datos=elementos;
        fireTableDataChanged();
    }
}
