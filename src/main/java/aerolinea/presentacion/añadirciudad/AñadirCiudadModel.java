package aerolinea.presentacion.añadirciudad ;

import aerolinea.data.PaisDao;
import aerolinea.logic.Ciudad;
import aerolinea.presentacion.añadirpais.*;
import aerolinea.logic.Pais;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

public class AñadirCiudadModel extends Observable{

    Ciudad object;
    Vector<Pais> paises;
    public AñadirCiudadModel() {
        object = new Ciudad();
        UpdateLista();
    }
    
    public void UpdateLista()
    {
       paises = (Vector<Pais>) PaisDao.getInstance().findPaisEntities();
    }
    
    public Vector<Pais> getLista()
    {
        return paises;
    }
    
    public void setUser(Ciudad object) {
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
