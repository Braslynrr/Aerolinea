package aerolinea.presentacion.vuelo;

import aerolinea.presentacion.tipoavion.*;
import aerolinea.data.TipoAvionDao;
import aerolinea.logic.Modelo;
import aerolinea.logic.Vuelo;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

public class VueloModel extends Observable {
    TableModelVuelo tabletipo;
    Vector<String> combotipos;

    public VueloModel() {
        combotipos = new Vector<String>();
        InicializeTables();
        InicializeComboClases();
    }
     @Override
    public void addObserver(Observer o){
        super.addObserver(o);
        this.setChanged();
        this.notifyObservers();   
    }
    
    public void InicializeTables()
    {
   
    tabletipo = new TableModelVuelo(Modelo.getInstance().GetAllVuelo());
    
    }
    
    public void setUser()
    {
        this.setChanged();
        this.notifyObservers();
    }
    
    public void InicializeComboClases()
    {
        combotipos.add("Cualquiera");
        combotipos.add("Identificador");
        combotipos.add("Año");
        combotipos.add("Modelo");
        combotipos.add("Marca");
        combotipos.add("Asientos");
        combotipos.add("Filas");
  
    }
}
