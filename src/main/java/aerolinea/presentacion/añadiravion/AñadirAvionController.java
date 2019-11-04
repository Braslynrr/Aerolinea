package aerolinea.presentacion.añadiravion;

import aerolinea.data.AvionDao;
import aerolinea.logic.Avion;
import aerolinea.logic.Modelo;
import aerolinea.presentacion.avion.AvionController;

public class AñadirAvionController {

    AñadirAvionView view;
    AñadirAvionAModel model;
    AvionController pcontrol;
    
    public AñadirAvionController(AñadirAvionAModel model,AñadirAvionView view, AvionController pcontrol) {
        this.model = model;
        this.view = view;
        view.setModel(model);
        view.setController(this);
        this.pcontrol = pcontrol;
    }
    
    public void Añadir(Avion object) throws Exception
    {

        Modelo.getInstance().Añadir(object);
        model.setUser(object);
        pcontrol.Update();
    }
    
    public void Modifcar(Avion object) throws Exception
    {
        Modelo.getInstance().Modifcar(object);
        model.setUser(object);
        pcontrol.Update();
    }
    
     public void setAvion(Avion object)
    {
        view.codigofield.setText(object.getIdentificador());
        view.codigofield.setEnabled(false);

        
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
