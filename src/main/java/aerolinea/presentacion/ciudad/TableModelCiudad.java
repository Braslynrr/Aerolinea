package aerolinea.presentacion.ciudad;

import aerolinea.logic.Ciudad;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelCiudad extends AbstractTableModel {
    
     List <Ciudad> lista;

    public TableModelCiudad(List<Ciudad> lista) {
        this.lista = lista;
    }

    public List<Ciudad> getLista() {
        return lista;
    }

    public void setLista(List<Ciudad> lista) {
        this.lista = lista;
        this.fireTableStructureChanged();
    }
 
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Ciudad object = lista.get(rowIndex);
        switch(columnIndex){
            case 0: return object.getCodigo();
            case 1: return object.getNombre(); 
            case 2: return object.getPais().getNombre();
            default: return "";
        }
    }
    
    @Override    
    public String getColumnName(int columnIndex){
        switch(columnIndex){
            case 0: return "Codigo";
            case 1: return "Nombre";
            case 2: return "Pais";
            default: return "";
        }        
    }   
    public Ciudad getElement(int index)
    {
        return lista.get(index);
    }
    
}
