package aerolinea.presentacion.administrador;

import aerolinea.logic.Usuario;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

public class AdministradorModel extends Observable {

    Vector<String> comboclases;
    List<Usuario> user;

    public Vector<String> getComboclases() {
        return comboclases;
    }
    public AdministradorModel() {
        comboclases = new Vector<String>();
        InicializeComboClases();
    }
    
    @Override
    public void addObserver(Observer o){
        super.addObserver(o);
        this.setChanged();
        this.notifyObservers();   
    }
    
    public void setUser()
    {
        this.setChanged();
        this.notifyObservers();
    }
    
    public void InicializeComboClases()
    {
        comboclases.add("Tipo de Avion");
        comboclases.add("Pais");
        comboclases.add("Usuarios");
        comboclases.add("Metodos de pago");

    }
}


