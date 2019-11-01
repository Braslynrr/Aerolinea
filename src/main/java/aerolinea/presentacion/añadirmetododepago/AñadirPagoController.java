package aerolinea.presentacion.añadirmetododepago;

import aerolinea.data.MetodoPagoDao;
import aerolinea.logic.MetodoPago;
import aerolinea.logic.Modelo;
import aerolinea.presentacion.pago.PagoController;

public class AñadirPagoController {

    AñadirPagoView view;
    AñadirPagoModel model;
    PagoController pcontrol;
    
    public AñadirPagoController(AñadirPagoModel model,AñadirPagoView view,PagoController pcontrol) {
        this.model = model;
        this.view = view;
        view.setModel(model);
        view.setController(this);
        this.pcontrol = pcontrol;
    }
    
    public void Añadir(MetodoPago object) throws Exception
    {
//        MetodoPagoDao.getInstance().create(object);
         Modelo.getInstance().Añadir(object);
        model.setUser(object);
        pcontrol.Update();
    }
    
    public void Modifcar(MetodoPago object) throws Exception
    {
//        MetodoPagoDao.getInstance().edit(object);
        Modelo.getInstance().Modifcar(object);
        model.setUser(object);
        pcontrol.Update();
    }
    
     public void setPago(MetodoPago object)
    {
        view.codigofield.setText(String.valueOf(object.getCodigo()));
        view.codigofield.setEnabled(false);
        view.descripcionfield.setText(object.getDescripcion());
        
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
