package aerolinea.presentacion.tipoavion;

import aerolinea.data.TipoAvionDao;

public class TipoAvionController {
    TipoAvionModel model;
    TipoAvionView view;

    public TipoAvionController(TipoAvionModel model, TipoAvionView view) {
        this.model = model;
        this.view = view;
        view.setModel(model);
        view.setController(this);
//        UpdateTable();
    }
    
//    void UpdateTable()
//    {
//        if (model.tablemodel == null)
//        {
//            model.tablemodel = new TipoAvionTableModel(TipoAvionDao.getInstance().findTipoAvionEntities());
//        }
//        model.tablemodel.setLista(TipoAvionDao.getInstance().findTipoAvionEntities());
//    }
    
    
}
