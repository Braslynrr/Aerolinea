package aerolinea.presentacion.añadirciudad;

import aerolinea.data.CiudadDao;
import aerolinea.logic.Ciudad;
import aerolinea.logic.Modelo;
import aerolinea.presentacion.ciudad.CiudadController;

public class AñadirCiudadController {

    AñadirCiudadView view;
    AñadirCiudadModel model;
    CiudadController ccontrol;
    
    public AñadirCiudadController(AñadirCiudadModel model,AñadirCiudadView view, CiudadController ccontrol) {
        this.ccontrol = ccontrol;
        this.model = model;
        this.view = view;
        view.setModel(model);
        view.setController(this);
    }
    
    public void Añadir(Ciudad object) throws Exception
    {
//        CiudadDao.getInstance().create(object);
         Modelo.getInstance().Añadir(object);
        model.setUser(object);
        ccontrol.Update();
    }
    
    public void Modifcar(Ciudad object) throws Exception
    {
//        CiudadDao.getInstance().edit(object);
        Modelo.getInstance().Modifcar(object);
        model.setUser(object);
        ccontrol.Update();
    }
    
     public void setCiudad(Ciudad object)
    {
        view.codigofield.setText(object.getCodigo());
        view.codigofield.setEnabled(false);
        view.nombrefield.setText(object.getNombre());
        view.paisescombobox.setSelectedItem(object.getPais());
        
        
    }
    
    public void setvisible(boolean visible)
    {
        view.setVisible(visible);
    }
    
    public void OcultarDialogo()
    {
        ccontrol.OcutarDialogo();
    }
    
}
