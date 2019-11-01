package aerolinea.presentacion.añadirmetododepago ;

import aerolinea.logic.MetodoPago;
import java.util.Observable;
import java.util.Observer;

public class AñadirPagoModel extends Observable{

    MetodoPago object;
    public AñadirPagoModel() {
        object = new MetodoPago();
    }
    
    public void setUser(MetodoPago object) {
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
