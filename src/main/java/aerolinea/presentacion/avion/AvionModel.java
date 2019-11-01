package aerolinea.presentacion.avion;

import aerolinea.data.AvionDao;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

public class AvionModel extends Observable {
    TableModelAvion tabletipo;
    Vector<String> combotipos;

    public AvionModel() {
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
   
    tabletipo = new TableModelAvion(AvionDao.getInstance().findAvionEntities());
    
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
        combotipos.add("Marca");;
        combotipos.add("Modelo");
        combotipos.add("Año");
       
  
    }
}
