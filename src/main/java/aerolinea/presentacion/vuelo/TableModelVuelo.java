package aerolinea.presentacion.vuelo;

import aerolinea.logic.Modelo;
import aerolinea.logic.TipoAvion;
import aerolinea.logic.Vuelo;
import aerolinea.presentacion.avion.AvionController;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;
import javax.swing.table.AbstractTableModel;


public class TableModelVuelo extends AbstractTableModel {
    List <Vuelo> lista;

    public void setVuelo(VueloController vuelo) {
        this.vuelo = vuelo;
    }
    VueloController vuelo;
    
    
    public TableModelVuelo(List<Vuelo> lista) {
        this.lista = lista;
    }

    public List<Vuelo> getLista() {
        return lista;
    }

    public void setLista(List<Vuelo> lista) {
        this.lista = lista;
        this.fireTableStructureChanged();
    }
 
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 10;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        
        Vuelo object = lista.get(rowIndex);
//        if (vuelo != null)
//        vuelo.model.tabletipo.setLista(Modelo.getInstance().GetListaVuelos());
        switch(columnIndex){
            case 0: return object.getIdentificador();
            case 1: return object.getAvion().getIdentificador();
            case 2: return object.getOrigen().toString();
            case 3: return object.getDia();
            case 4: return formatter.format(object.getSalida());
            case 5: return object.getDestino().toString();
            
            case 6: if (object.getLlegada() != null)
                    return formatter.format(object.getLlegada());
            else
                return " ";
            case 7: return formatter.format(object.getDuracion());
            case 8: return object.getDescuento();
            case 9: return object.getPrecio();
            default: return "";
        }
    }
    
    @Override    
    public String getColumnName(int columnIndex){
        switch(columnIndex){
            case 0: return "Codigo";
            case 1: return "Avion";
            case 2: return "Origen";
            case 3: return "Dia";
            case 4: return "Salida";
            case 5: return "Destino";
            case 6: return "Llegada";
            case 7: return "Duracion";
            case 8: return "Descuento";
            case 9: return "Precio";
            default: return "";
        }        
    }   
    public Vuelo getElement(int index)
    {
        return lista.get(index);
    }
}
