package aerolinea.presentacion.añadirvuelo;

import aerolinea.data.VueloDao;
import aerolinea.logic.Modelo;
import aerolinea.logic.Vuelo;
import aerolinea.presentacion.vuelo.VueloController;

public class AñadirVueloController {

    AñadirVueloView view;
    AñadirVueloModel model;
    VueloController pcontrol;
    
    public AñadirVueloController(AñadirVueloModel model,AñadirVueloView view, VueloController pcontrol) {
        this.model = model;
        this.view = view;
        view.setModel(model);
        view.setController(this);
        this.pcontrol = pcontrol;
    }
    
    public void Añadir(Vuelo object) throws Exception
    {
        Modelo.getInstance().Añadir(object);
        pcontrol.Update();
        model.setUser(object);
        
        
    }
    
    public void Modifcar(Vuelo object) throws Exception
    {
        Modelo.getInstance().Modifcar(object);
        model.setUser(object);
        pcontrol.Update();
    }
    
     public void ModificarVuelo(Vuelo object)
    {

        view.salidaspinner.setValue(object.getSalida());
        view.duracionspinner.setValue(object.getSalida());
        view.preciofield.setText(String.valueOf(object.getPrecio()));
        view.descuentofield.setText(String.valueOf(object.getDescuento()));
        view.origenCombo.setSelectedItem(object.getOrigen());
        view.destinocombo.setSelectedItem(object.getDestino());
        view.avioncombo.setSelectedItem(object.getAvion());
        
    }
    
    public void setvisible(boolean visible)
    {
        view.setVisible(visible);
    }
    
    public void OcultarDialogo()
    {
        pcontrol.OcutarDialogo();
    }
    
}
