package aerolinea.presentacion.avion;

import aerolinea.logic.Avion;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelAvion extends AbstractTableModel{
        List <Avion> lista;


    public TableModelAvion(List<Avion> lista) {
        this.lista = lista;
       
    }

    public List<Avion> getLista() {
        return lista;
    }

    public void setLista(List<Avion> lista) {
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
        Avion object = lista.get(rowIndex);
        switch(columnIndex){
            case 0: return object.getIdentificador();
            case 1: return object.getTipoA().getMarca();
            case 2: return object.getTipoA().getModelo();
            case 3: return object.getTipoA().getAño();
            default: return "";
        }
    }
    
    @Override    
    public String getColumnName(int columnIndex){
        switch(columnIndex){
            case 0: return "Identificador";
            case 1: return "Marca";
            case 2: return "Modelo";
            case 3: return "Año";
            default: return "";
        }        
    }   
    public Avion getElement(int index)
    {
        return lista.get(index);
    }
}
