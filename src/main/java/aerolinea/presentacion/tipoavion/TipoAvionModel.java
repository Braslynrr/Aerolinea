package aerolinea.presentacion.tipoavion;

import java.util.Observable;
import java.util.Observer;

public class TipoAvionModel extends Observable {
    TipoAvionTableModel tablemodel;

    public TipoAvionModel() {
    }
     @Override
    public void addObserver(Observer o){
        super.addObserver(o);
        this.setChanged();
        this.notifyObservers();   
    }
}
