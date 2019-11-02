/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.SeleccionVuelo;

import aerolinea.logic.Vuelo;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Admin2
 */
public class SeleccionVueloModel extends Observable {
    Vuelo vuelo;

    public SeleccionVueloModel() {
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }
    
    
        
    @Override
    public void addObserver(Observer o){
        super.addObserver(o);
        this.setChanged();
        this.notifyObservers();   
    }
}
