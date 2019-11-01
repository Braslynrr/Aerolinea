package aerolinea.presentacion.ciudad;

import aerolinea.presentacion.avion.*;
import aerolinea.data.AvionDao;
import aerolinea.data.CiudadDao;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

public class CiudadModel extends Observable {
    TableModelCiudad tabletipo;
    Vector<String> combotipos;

    public CiudadModel() {
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
   
    tabletipo = new TableModelCiudad(CiudadDao.getInstance().findCiudadEntities());
    
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
        combotipos.add("Nombre");;
        combotipos.add("Pais");
  
    }
}
