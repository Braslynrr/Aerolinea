package aerolinea.presentacion.tipoavion;

import aerolinea.data.TipoAvionDao;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

public class TipoAvionModel extends Observable {
    TableModelTipoAvion tabletipo;
    Vector<String> combotipos;

    public TipoAvionModel() {
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
   
    tabletipo = new TableModelTipoAvion(TipoAvionDao.getInstance().findTipoAvionEntities());
    
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
