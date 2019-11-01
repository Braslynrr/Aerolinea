package aerolinea.presentacion.administrador;

import aerolinea.logic.Usuario;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelUsuario extends AbstractTableModel{
    
    List <Usuario> lista;

    public TableModelUsuario(List<Usuario> lista) {
        this.lista = lista;
    }

    public List<Usuario> getLista() {
        return lista;
    }

    public void setLista(List<Usuario> lista) {
        this.lista = lista;
        this.fireTableStructureChanged();
    }
 
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario object = lista.get(rowIndex);
        switch(columnIndex){
            case 0: return object.getCodigo();
            case 1: return object.getNombre();
            case 2: return object.getApellido();
            case 3: return object.getPassword();
            case 4: return object.getTipo();
            default: return "";
        }
    }
    
    @Override    
    public String getColumnName(int columnIndex){
        switch(columnIndex){
            case 0: return "ID";
            case 1: return "Nombre";
            case 2: return "Apellido";
            case 3: return "Password";
            case 4: return "Tipo";
            default: return "";
        }        
    }   
    
}
