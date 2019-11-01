package aerolinea.presentacion.añadirpais ;

import aerolinea.logic.Pais;
import java.util.Observable;
import java.util.Observer;

public class AñadirPaisAModel extends Observable{

    Pais object;
    public AñadirPaisAModel() {
        object = new Pais();
    }
    
    public void setUser(Pais object) {
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
