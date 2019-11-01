package aerolinea.presentacion.añadirusuario ;

import aerolinea.logic.Usuario;
import java.util.Observable;
import java.util.Observer;

public class AñadirUsuarioModel extends Observable{

    Usuario user;
    public AñadirUsuarioModel() {
        user = new Usuario ();
    }
    
    public void setUser(Usuario user) {
        this.user = user;
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
