package aerolinea.presentacion.añadirvuelo ;

import aerolinea.logic.Avion;
import aerolinea.logic.Ciudad;
import aerolinea.logic.Modelo;
import aerolinea.logic.Vuelo;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

public class AñadirVueloModel extends Observable{

    Vector <Ciudad> ciudades;
    Vector <Avion> aviones;
    Vector <String> dias;
    Vuelo object;
    public AñadirVueloModel() {
        object = new Vuelo();
        ciudades = new Vector();
        aviones = new Vector();
        dias = new Vector();
        this.InicializeDias();
        this.UpdateListas();
    }
    
    public void UpdateListas()
    {
//       paises = (Vector<Pais>) PaisDao.getInstance().findPaisEntities();
        ciudades = (Vector<Ciudad>) Modelo.getInstance().GetAllCiudad();
        aviones = (Vector<Avion>) Modelo.getInstance().GetListaAviones();
    }
    
    public Vector<Avion> getListaAviones()
    {
        return aviones;
    }
     public Vector<Ciudad> getListaCiudad()
    {
        return ciudades;
    }
    
    
    public void setUser(Vuelo object) {
        this.object = object;
        this.setChanged();
        this.notifyObservers();           
    }
    public void InicializeDias()
    {
        dias.add("Lunes");
        dias.add("Martes");
        dias.add("Mercoles");
        dias.add("Jueves");
        dias.add("Viernes");
        dias.add("Sabado");
        dias.add("Domingo");
    }
    
     @Override
    public void addObserver(Observer o){
        super.addObserver(o);
        this.setChanged();
        this.notifyObservers();   
    }
}
