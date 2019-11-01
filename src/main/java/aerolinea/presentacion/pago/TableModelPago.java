package aerolinea.presentacion.pago;

import aerolinea.logic.MetodoPago;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelPago extends AbstractTableModel {

    List <MetodoPago> lista;

    public TableModelPago(List<MetodoPago> lista) {
        this.lista = lista;
    }

    public List<MetodoPago> getLista() {
        return lista;
    }

    public void setLista(List<MetodoPago> lista) {
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
        MetodoPago object = lista.get(rowIndex);
        switch(columnIndex){
            case 0: return object.getCodigo();
            case 1: return object.getDescripcion();  
            default: return "";
        }
    }
    
    @Override    
    public String getColumnName(int columnIndex){
        switch(columnIndex){
            case 0: return "Codigo";
            case 1: return "Descripcion";        
            default: return "";
        }        
    }   
    public MetodoPago getElement(int index)
    {
        return lista.get(index);
    }
}
