package aerolinea.presentacion.pago;

import aerolinea.data.MetodoPagoDao;
import aerolinea.presentacion.tipoavion.*;
import aerolinea.data.TipoAvionDao;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

public class PagoModel extends Observable {
    TableModelPago tabletipo;
    Vector<String> combotipos;

    public PagoModel() {
        combotipos = new Vector<String>();
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
   
    tabletipo = new TableModelPago(MetodoPagoDao.getInstance().findMetodoPagoEntities());
    
    }
    
    public void setUser()
    {
        this.setChanged();
        this.notifyObservers();
    }
    
    public void InicializeComboClases()
    {
        combotipos.add("Cualquiera");
        combotipos.add("Codigo");
        combotipos.add("Descripcion");

  
    }
}
