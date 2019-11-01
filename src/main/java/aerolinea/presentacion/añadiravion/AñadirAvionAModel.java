package aerolinea.presentacion.añadiravion ;

import aerolinea.data.AvionDao;
import aerolinea.data.TipoAvionDao;
import aerolinea.logic.Avion;
import aerolinea.logic.TipoAvion;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

public class AñadirAvionAModel extends Observable{

    Vector<TipoAvion> listatipoaviones;
    Avion object;
    public AñadirAvionAModel() {
        object = new Avion();
        listatipoaviones = new Vector<TipoAvion>();
        UpdateLista();
    }
    
    public void UpdateLista()
    {
       listatipoaviones = (Vector<TipoAvion>) TipoAvionDao.getInstance().findTipoAvionEntities();
    }
    
    public Vector<TipoAvion> getLista()
    {
        return listatipoaviones;
    }
    
    public void getElement(int index)
    {
        listatipoaviones.get(index);
    }
    
    public void setUser(Avion object) {
        this.object = object;
        this.setChanged();
        this.notifyObservers();           
    }
    
     @Override
    public void addObserver(Observer o){
        super.addObserver(o);
        this.setChanged();
        this.notifyObservers();   
    }
}
