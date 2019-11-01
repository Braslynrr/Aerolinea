package aerolinea.presentacion.añadirusuario;

import aerolinea.data.UsuarioDao;
import aerolinea.logic.Usuario;

public class AñadirUsuarioController {

    AñadirUsuarioView view;
    AñadirUsuarioModel model;
    
    public AñadirUsuarioController(AñadirUsuarioModel model,AñadirUsuarioView view) {
        this.model = model;
        this.view = view;
        view.setModel(model);
        view.setController(this);
    }
    
    public void Añadir(Usuario user) throws Exception
    {
        UsuarioDao.getInstance().create(user);
        model.setUser(user);
        aerolinea.Main.Controller_Admin.setUser();
    }
    
    public void setvisible(boolean visible)
    {
        view.setVisible(visible);
    }
    
}
