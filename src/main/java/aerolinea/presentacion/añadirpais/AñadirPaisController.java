package aerolinea.presentacion.añadirpais;

import aerolinea.data.PaisDao;
import aerolinea.data.TipoAvionDao;
import aerolinea.logic.Modelo;
import aerolinea.logic.Pais;
import aerolinea.logic.TipoAvion;
import aerolinea.presentacion.pais.PaisController;

public class AñadirPaisController {

    AñadirPaisView view;
    AñadirPaisAModel model;
    PaisController pcontrol;
    
    public AñadirPaisController(AñadirPaisAModel model,AñadirPaisView view, PaisController pcontrol) {
        this.pcontrol = pcontrol;
        this.model = model;
        this.view = view;
        view.setModel(model);
        view.setController(this);
    }
    
    public void Añadir(Pais object) throws Exception
    {
        Modelo.getInstance().Añadir(object);
        model.setUser(object);
        pcontrol.Update();
    }
    
    public void Modifcar(Pais object) throws Exception
    {
        Modelo.getInstance().Modifcar(object);
        model.setUser(object);
        pcontrol.Update();
    }
    
     public void setPais(Pais object)
    {
        view.codigofield.setText(object.getCodigo());
        view.codigofield.setEnabled(false);
        view.nombrefield.setText(object.getNombre());
        
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
