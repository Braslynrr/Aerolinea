package aerolinea.presentacion.tipoavion;

import aerolinea.logic.TipoAvion;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TipoAvionTableModel extends AbstractTableModel {
    List <TipoAvion> lista;

    public TipoAvionTableModel(List<TipoAvion> lista) {
        this.lista = lista;
    }

    public List<TipoAvion> getLista() {
        return lista;
    }

    public void setLista(List<TipoAvion> lista) {
        this.lista = lista;
        this.fireTableStructureChanged();
    }
 
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TipoAvion object = lista.get(rowIndex);
        switch(columnIndex){
            case 0: return object.getIdentificador();
            case 1: return object.getAño();
            case 2: return object.getModelo();
            case 3: return object.getMarca();
            default: return "";
        }
    }
    
    @Override    
    public String getColumnName(int columnIndex){
        switch(columnIndex){
            case 0: return "Identificador";
            case 1: return "Año";
            case 2: return "Modelo";
            case 3: return "Marca";
            default: return "";
        }        
    }   
}
