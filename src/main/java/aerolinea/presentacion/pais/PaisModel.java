package aerolinea.presentacion.pais;

import aerolinea.data.PaisDao;
import aerolinea.presentacion.tipoavion.*;
import aerolinea.data.TipoAvionDao;
import aerolinea.logic.Modelo;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

public class PaisModel extends Observable {
    TableModelPais tabletipo;
    Vector<String> combotipos;

    public PaisModel() {
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
   
    tabletipo = new TableModelPais(Modelo.getInstance().GetAllPais());
    
    }
    
    public void setUser()
    {
        this.setChanged();
        this.notifyObservers();
    }
    
    public void InicializeComboClases()
    {
        combotipos.add("Cualquiera");
        combotipos.add("Codigo");
        combotipos.add("Nombre");
       
  
    }
}
