package aerolinea.presentacion.añadirusuario;

import aerolinea.data.UsuarioDao;
import aerolinea.logic.Usuario;
import aerolinea.presentacion.Usuario.UsuarioController;

public class AñadirUsuarioController {

    AñadirUsuarioView view;
    AñadirUsuarioModel model;
    UsuarioController pcontrol;
    
    public AñadirUsuarioController(AñadirUsuarioModel model,AñadirUsuarioView view,UsuarioController pcontrol) {
        this.model = model;
        this.view = view;
        view.setModel(model);
        view.setController(this);
        this.pcontrol = pcontrol;
    }
    
    public void Añadir(Usuario object) throws Exception
    {
        UsuarioDao.getInstance().create(object);
        model.setUser(object);
//        pcontrol.Update();
    }
    
    public void Modifcar(Usuario object) throws Exception
    {
        UsuarioDao.getInstance().edit(object);
        model.setUser(object);
//        pcontrol.Update();
    }
    
    public void setvisible(boolean visible)
    {
        view.setVisible(visible);
    }
    
    public void setModifiedUser(Usuario object)
    {
        view.Idfield.setText(object.getCodigo());
        view.Idfield.setEnabled(false);
        view.nombrefield.setText(object.getNombre());
        view.apellidofield.setText(object.getApellido());
        view.contraseñafield.setText(object.getPassword());
        if (object.getTipo() == "Premiun")
        {
            view.Premiun.setSelected(true);
        }
       else
            view.standart.setSelected(true); 
    }
    
    public void OcultarDialogo()
    {
//        pcontrol.OcutarDialogo();
    }
    
}
