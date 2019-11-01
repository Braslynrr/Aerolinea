package aerolinea.presentacion.añadirtipoavion;

import aerolinea.presentacion.añadirpais.*;
import aerolinea.data.PaisDao;
import aerolinea.data.TipoAvionDao;
import aerolinea.logic.Modelo;
import aerolinea.logic.Pais;
import aerolinea.logic.TipoAvion;
import aerolinea.presentacion.tipoavion.TipoAvionController;

public class AñadirTipoAController {

    AñadirTipoAView view;
    AñadirTipoAModel model;
    TipoAvionController pcontrol;
    
    public AñadirTipoAController(AñadirTipoAModel model,AñadirTipoAView view, TipoAvionController pcontrol) {
        this.model = model;
        this.view = view;
        view.setModel(model);
        view.setController(this);
        this.pcontrol = pcontrol;
    }
    
    public void Añadir(TipoAvion object) throws Exception
    {
        Modelo.getInstance().Añadir(object);
        model.setUser(object);
        pcontrol.Update();
    }
    
    public void Modifcar(TipoAvion object) throws Exception
    {
        Modelo.getInstance().Modifcar(object);
        model.setUser(object);
        pcontrol.Update();
    }
    
     public void ModificarTipoAvion(TipoAvion object)
    {
        view.idenfield.setText(object.getIdentificador());
        view.idenfield.setEnabled(false);
        view.añofield.setText(object.getAño());
        view.modelofield.setText(object.getModelo());
        view.marcafield.setText(object.getMarca());
        view.asientosspinner.setValue(object.getAsientos());
        view.filasspinner.setValue(object.getFilas());
        
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
