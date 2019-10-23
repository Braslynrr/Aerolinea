/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.Usuario;

import aerolinea.logic.Usuario;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Admin2
 */
public class UsuarioModel extends Observable{
    Usuario user;
    public UsuarioModel() {
    }
    
    @Override
    public void addObserver(Observer o){
        super.addObserver(o);
        this.setChanged();
        this.notifyObservers();   
    }
}
