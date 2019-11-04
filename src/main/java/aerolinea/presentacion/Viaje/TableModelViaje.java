package aerolinea.presentacion.viaje;

import aerolinea.logic.Viaje;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;
import javax.swing.table.AbstractTableModel;


public class TableModelViaje extends AbstractTableModel {
    List <Viaje> lista;
    
    
    ViajeController vuelo;
    public TableModelViaje(List<Viaje> lista) {
        this.lista = lista;
    }

    public List<Viaje> getLista() {
        return lista;
    }

    public void setLista(List<Viaje> lista) {
        this.lista = lista;
        this.fireTableStructureChanged();
    }
 
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YYYY");
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        
        Viaje object = lista.get(rowIndex);

        switch(columnIndex){
            case 0: return object.getCodigo();
            case 1: return formatter.format(object.getDsalida());
            case 2: return object.getIda().toString();
            case 3:if (object.getRegreso() == null)
                return "N/A";
            else 
                return formatter.format(object.getDregreso());
            case 4:  if (object.getRegreso() == null)
                return "N/A";
            else
                    return object.getRegreso().toString();  
            case 5: return object.getIda().getAvion().getTipoA().getFilas() * 
                    object.getIda().getAvion().getTipoA().getAsientos();
            
           
        }
        return null;
    }
    
    @Override    
    public String getColumnName(int columnIndex){
        switch(columnIndex){
            case 0: return "Codigo";
            case 1: return "Salida";
            case 2: return "Vuelo de ida";
            case 3: return "Regreso";
            case 4: return "Vuelo de regreo";  
            case 5: return "Cantidad de asientos";
            default: return "";
        }        
    }   
    public Viaje getElement(int index)
    {
        return lista.get(index);
    }
}
