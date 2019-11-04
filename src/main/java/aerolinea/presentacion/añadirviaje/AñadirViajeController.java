package aerolinea.presentacion.añadirviaje;

import aerolinea.logic.Modelo;
import aerolinea.logic.Viaje;
import aerolinea.presentacion.tipoavion.TipoAvionController;
import aerolinea.presentacion.viaje.ViajeController;

public class AñadirViajeController {

    AñadirViajeView view;
    AñadirViajeModel model;
    ViajeController pcontrol;
    
    public AñadirViajeController(AñadirViajeModel model,AñadirViajeView view, ViajeController pcontrol) {
        this.model = model;
        this.view = view;
        view.setModel(model);
        view.setController(this);
        this.pcontrol = pcontrol;
    }
    
    public void Añadir(Viaje object) throws Exception
    {
        Modelo.getInstance().Añadir(object);
        model.setUser(object);
        pcontrol.Update();
    }
    
    public void Modifcar(Viaje object) throws Exception
    {
        Modelo.getInstance().Modifcar(object);
        model.setUser(object);
        pcontrol.Update();
    }
    
     public void ModificarVuelo(Viaje object)
    {
        view.idenfield.setText(object.getCodigo());
        view.idenfield.setEnabled(false);
        view.idacombo.setSelectedItem(object.getIda()); 
        view.salidaspinner.setValue(object.getDsalida());
        if(object.getRegreso() != null)
        {
        view.regresospinner.setValue(object.getDregreso());
        view.regresocombo.setSelectedItem(object.getRegreso());
        }
 
        
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
