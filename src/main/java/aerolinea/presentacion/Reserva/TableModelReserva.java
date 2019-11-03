package aerolinea.presentacion.Reserva;
import aerolinea.logic.Reserva;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelReserva extends AbstractTableModel{
        List <Reserva> lista;


    public TableModelReserva(List<Reserva> lista) {
        this.lista = lista;
       
    }

    public List<Reserva> getLista() {
        return lista;
    }

    public void setLista(List<Reserva> lista) {
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
        Reserva object = lista.get(rowIndex);
        switch(columnIndex){
            case 0: return object.getCodigo();
            case 1: return object.getUsuario();
            case 2: return object.getPago().getDescripcion();
            case 3: return object.getTiqueteList().size();
            case 4: return object.getViaje().getIda()+"-"+object.getViaje().getRegreso();
            default: return "";
        }
    }
    
    @Override    
    public String getColumnName(int columnIndex){
        switch(columnIndex){
            case 0: return "Codigo";
            case 1: return "Usuario";
            case 2: return "Metodo pago";
            case 3: return "Cantidad Tiquetes";
            case 4: return "Viaje";
            default: return "";
        }        
    }   
    public Reserva getElement(int index){
        return lista.get(index);
    }
}
