package aerolinea.presentacion.pais;

import aerolinea.logic.Pais;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelPais extends AbstractTableModel{
    List <Pais> lista;

    public TableModelPais(List<Pais> lista) {
        this.lista = lista;
    }

    public List<Pais> getLista() {
        return lista;
    }

    public void setLista(List<Pais> lista) {
        this.lista = lista;
        this.fireTableStructureChanged();
    }
 
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pais object = lista.get(rowIndex);
        switch(columnIndex){
            case 0: return object.getCodigo();
            case 1: return object.getNombre();  
            default: return "";
        }
    }
    
    @Override    
    public String getColumnName(int columnIndex){
        switch(columnIndex){
            case 0: return "Codigo";
            case 1: return "Nombre";        
            default: return "";
        }        
    }   
    public Pais getElement(int index)
    {
        return lista.get(index);
    }
    
}
