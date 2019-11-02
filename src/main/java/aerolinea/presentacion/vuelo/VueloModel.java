package aerolinea.presentacion.vuelo;

import aerolinea.logic.Modelo;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

public class VueloModel extends Observable {

    public TableModelVuelo getTabletipo() {
        return tabletipo;
    }

    public void setTabletipo(TableModelVuelo tabletipo) {
        this.tabletipo = tabletipo;
    }

    public Vector<String> getCombotipos() {
        return combotipos;
    }

    public void setCombotipos(Vector<String> combotipos) {
        this.combotipos = combotipos;
    }
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
