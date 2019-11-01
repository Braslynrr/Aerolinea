package aerolinea.presentacion.añadirtipoavion ;

import aerolinea.presentacion.añadirpais.*;
import aerolinea.logic.Pais;
import aerolinea.logic.TipoAvion;
import java.util.Observable;
import java.util.Observer;

public class AñadirTipoAModel extends Observable{

    TipoAvion object;
    public AñadirTipoAModel() {
        object = new TipoAvion();
    }
    
    public void setUser(TipoAvion object) {
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
