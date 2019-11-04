package aerolinea.presentacion.vuelo;

import aerolinea.data.CiudadDao;
import aerolinea.logic.Avion;
import aerolinea.logic.Ciudad;
import aerolinea.logic.Modelo;
import aerolinea.logic.Pais;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

public class VueloModel extends Observable {
    TableModelVuelo tabletipo;
    Vector<String> combotipos;
    Vector<Object> origen;
    Vector<Object> destino;
    Vector<Object> avion;

    public VueloModel() {
        combotipos = new Vector<String>();
        origen = new Vector<Object>();
        destino = new Vector<Object>();
        avion = new Vector<Object>();
        UpdateIdaRegreso();
        InicializeTables();
        InicializeComboClases();

    }
     @Override
    public void addObserver(Observer o){
        super.addObserver(o);
        this.setChanged();
        this.notifyObservers();   
    }
    
    public void InicializeTables()
    {
   
    tabletipo = new TableModelVuelo(Modelo.getInstance().GetAllVuelo());
    
    }
    
    public void setUser()
    {
        this.setChanged();
        this.notifyObservers();
    }
    
    public void InicializeComboClases()
    {
        combotipos.add("Cualquiera");
        combotipos.add("Identificador");
        combotipos.add("Año");
        combotipos.add("Modelo");
        combotipos.add("Marca");
        combotipos.add("Asientos");
        combotipos.add("Filas");
  
    }
    
    public void UpdateIdaRegreso()
    {
        if(!origen.isEmpty() || !avion.isEmpty() || !destino.isEmpty())
        {
            origen.clear();
            destino.clear();
            avion.clear();
        }
        int aux = Modelo.getInstance().GetAllCiudad().size();
        
        List<Ciudad> aux2 = Modelo.getInstance().GetAllCiudad();
        List<Ciudad> aux3 = Modelo.getInstance().GetAllCiudad();
        
        String cualquiera = "Cualquiera";
        origen.add(cualquiera);
        destino.add(cualquiera);  
        for(int i = 0; i< aux; i++ )
        {
            origen.add(aux2.get(i));
            destino.add(aux2.get(i));
        }
        
        avion.add(cualquiera);
        
        List<Avion> auxpais = Modelo.getInstance().GetAllAviones();
        int auxcant = auxpais.size();
        
        for(int i = 0; i< auxcant; i++ )
        {
            avion.add(auxpais.get(i));
        }


    }
}
