package gui;

import aplicacion.Elemento;

import java.util.ArrayList;
import java.util.List;

public class modeloTablaPlaylistUsuario extends javax.swing.table.AbstractTableModel {
    //tabla de dos columnas, una con el tipo de dato y otra con el nombre
    private List<Elemento> datos;

    public modeloTablaPlaylistUsuario(){
        this.datos=new ArrayList<Elemento>();
    }

    public String getColumnName(int col){
        String nombre="";

        switch (col){
            case 0: nombre= "Nombre"; break;
            case 1: nombre= "Canciones"; break;
            case 2: nombre= "Duración"; break;
        }
        return nombre;
    }

    public Class getColumnClass(int col){
        Class clase = null;

        switch (col){
            case 0: clase= String.class; break;
            case 1: clase= Integer.class; break;
            case 2: clase= Integer.class; break;
        }
        return clase;
    }

    @Override
    public Object getValueAt(int row, int col){
        Object resultado=null;

        switch (col){
            case 0: resultado= datos.get(row).getNombre(); break;
            case 1: resultado= datos.get(row).getCanciones(); break;
            case 2: resultado = datos.get(row).getDuracion();break;
        }
        return resultado;
    }


    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    public void setFilas(List<Elemento> elementos){
        this.datos=elementos;
        fireTableDataChanged();
    }
}
