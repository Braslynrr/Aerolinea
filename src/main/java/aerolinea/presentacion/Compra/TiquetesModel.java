/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.Compra;

import aerolinea.logic.Tiquete;
import java.util.Observable;
import java.util.Observer;

public class TiquetesModel extends Observable {
    int filas;
    int asiento;
    
    public TiquetesModel() {
    }

    public Tiquete getTiquete() {
        return tiquete;
    }

    public void setTiquete(Tiquete tiquete) {
        this.tiquete = tiquete;
    }

    Tiquete tiquete;

    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        this.setChanged();
        this.notifyObservers();
    }
}
