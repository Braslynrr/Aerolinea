package aerolinea.presentacion.ventanaprincipal;

import java.util.Observable;
import java.util.Observer;


public class VentanaPrincipalModel extends Observable {

    public VentanaPrincipalModel() {
    }
    
    @Override
    public void addObserver(Observer o){
        super.addObserver(o);
        this.setChanged();
        this.notifyObservers();   
    }
}
