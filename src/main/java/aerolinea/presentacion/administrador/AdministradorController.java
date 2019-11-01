package aerolinea.presentacion.administrador;

import aerolinea.data.MetodoPagoDao;
import aerolinea.data.PaisDao;
import aerolinea.data.TipoAvionDao;
import aerolinea.data.UsuarioDao;
import aerolinea.logic.Usuario;
import javax.swing.table.TableModel;

public class AdministradorController {
    AdministradorModel model;
    AdministradorView view;

    public AdministradorController(AdministradorModel model, AdministradorView view) {
        this.model = model;
        this.view = view;
        view.setModel(model);
        view.setController(this);
//        UpdateTable();
    }
    
    
    public TableModel setTables(int index)
    {
        switch(index)
        {
            case 0: return new TableModelTipoAvion(TipoAvionDao.getInstance().findTipoAvionEntities());  
            case 1: return new TableModelPais(PaisDao.getInstance().findPaisEntities());  
            case 2: return new TableModelUsuario(UsuarioDao.getInstance().findUsuarioEntities());
            case 3: return new TableModelPago(MetodoPagoDao.getInstance().findMetodoPagoEntities());
        }
        return null;
    }
    
//    public void Update()
//    {
//        view.setTable(0);
//    }
    public void setUser()
    {
        model.setUser();
    }
}
