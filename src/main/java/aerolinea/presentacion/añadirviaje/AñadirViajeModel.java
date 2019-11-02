package aerolinea.presentacion.añadirviaje ;

import aerolinea.logic.Ciudad;
import aerolinea.logic.Modelo;
import aerolinea.logic.Viaje;
import aerolinea.logic.Vuelo;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

public class AñadirViajeModel extends Observable{

    Viaje object;
    
    Vector <Vuelo> vueloida;
    Vector <Object> vueloregreso;
    
    
    public AñadirViajeModel() {
        object = new Viaje();
        vueloida = new Vector();
        vueloregreso= new Vector();
        this.UpdateListas();
    }
    
    public void setUser(Viaje object) {
        this.object = object;
        this.setChanged();
        this.notifyObservers();           
    }
    
     @Override
    public void addObserver(Observer o){
        super.addObserver(o);
        this.setChanged();
        this.notifyObservers();   
    }
    
    public void UpdateListas()
    {
//       paises = (Vector<Pais>) PaisDao.getInstance().findPaisEntities();
        vueloida = (Vector<Vuelo>) Modelo.getInstance().GetListaVuelos();
        
        
        List<Vuelo> auxiliar = Modelo.getInstance().GetListaVuelos();
        vueloregreso.add("Sin retorno");
        int cantidad = auxiliar.size();
        
        for(int i = 0; i< cantidad; i++)
        {
            vueloregreso.add(auxiliar.get(i));
        }
       
//        Vuelo nula = null;
//        vueloregreso.add(nula);
       
    }
    
    public Vector<Vuelo> getListaIda()
    {
        return vueloida;
    }
    
    public Vector<Object> getListaRegreso()
    {
        return vueloregreso;
    }
}
