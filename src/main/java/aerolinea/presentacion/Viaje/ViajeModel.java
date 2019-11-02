package aerolinea.presentacion.viaje;

import aerolinea.presentacion.vuelo.*;
import aerolinea.logic.Modelo;
import aerolinea.logic.Viaje;
import aerolinea.logic.Vuelo;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

public class ViajeModel extends Observable {
    TableModelViaje tabletipo;
    Vector<String> combotipos;
    Vector<Object> ida;
    Vector<Object> regreso;
    Vector<Object> fechasalida;
    Vector<Object> fecharegreso;

    public ViajeModel() {
        combotipos = new Vector<String>();
        ida = new Vector<Object>();
        regreso = new Vector<Object>();
        fechasalida = new Vector<Object>();
        fecharegreso = new Vector<Object>();
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
   
    tabletipo = new TableModelViaje(Modelo.getInstance().GetAllViaje());
    
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
        int aux = Modelo.getInstance().GetAllVuelo().size();
        
        List<Vuelo> aux2 = Modelo.getInstance().GetAllVuelo();
        List<Vuelo> aux3 = Modelo.getInstance().GetAllVuelo();
        
        String cualquiera = "Cualquiera";
        ida.add(cualquiera);
        regreso.add(cualquiera);  
        for(int i = 0; i< aux; i++ )
        {
            ida.add(aux2.get(i));
            regreso.add(aux2.get(i));
        }
        
        List<Viaje> auxvuelo = Modelo.getInstance().GetAllViaje();
        
       
        int cant = auxvuelo.size();
        fechasalida.add(cualquiera);
        fecharegreso.add(cualquiera);
        for(int i = 0; i< cant; i++ )
        {
            fechasalida.add(auxvuelo.get(i).getDsalida());
            fecharegreso.add(auxvuelo.get(i).getDregreso());
        }

    }
}
