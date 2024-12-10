package gui;
import java.util.*;
import aplicacion.Elemento;

public class modeloTablaBuscar extends javax.swing.table.AbstractTableModel {
    //tabla de dos columnas, una con el tipo de dato y otra con el nombre
    private List<Elemento> datos;

    public modeloTablaBuscar(){
        this.datos=new java.util.ArrayList<Elemento>();
    }

    public String getColumnName(int col){
        String nombre="";

        switch (col){
            case 0: nombre= "Tipo"; break;
            case 1: nombre= "Nombre"; break;
        }
        return nombre;
    }

    public Class getColumnClass(int col){
        Class clase = null;

        switch (col){
            case 0: clase= java.lang.String.class; break;
            case 1: clase= java.lang.String.class; break;
        }
        return clase;
    }

    @Override
    public String getValueAt(int row, int col){
        String resultado=null;

        switch (col){
            case 0: resultado= datos.get(row).getTipo(); break;
            case 1: resultado= datos.get(row).getNombre(); break;
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

    public void setFilas(java.util.List<Elemento> elementos){
        this.datos=elementos;
        fireTableDataChanged();
    }
}
