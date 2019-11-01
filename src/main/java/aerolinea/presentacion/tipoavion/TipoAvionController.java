package aerolinea.presentacion.tipoavion;

import aerolinea.data.TipoAvionDao;
import aerolinea.exceptions.IllegalOrphanException;
import aerolinea.exceptions.NonexistentEntityException;
import aerolinea.logic.Modelo;
import aerolinea.logic.TipoAvion;
import aerolinea.presentacion.añadirtipoavion.AñadirTipoAController;
import aerolinea.presentacion.añadirtipoavion.AñadirTipoAModel;
import aerolinea.presentacion.añadirtipoavion.AñadirTipoAView;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;

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
    
    public void OcutarDialogo()
    {
        view.dialogo.setVisible(false);
    }
    
    public TableModelTipoAvion setTables()
    {
        if (view.buscar.getText() == "")
        {
        model.tabletipo.setLista(Modelo.getInstance().GetLista());
        view.searchcombo.setModel(new DefaultComboBoxModel(model.combotipos));
        return model.tabletipo;  
        }
        else
        {
            return this.searh(view.searchfield.getText(), view.searchcombo.getSelectedIndex());
        }
            
    }
    
    public JPanel VenatanAñadir(int type)
    {
        AñadirTipoAModel avionmodel = new AñadirTipoAModel();
        AñadirTipoAView avionview = new AñadirTipoAView();
        AñadirTipoAController avioncontroller = new AñadirTipoAController(avionmodel,avionview,this);
            if (type == 1)
                {
                avionview.modificar.setEnabled(true);
                TipoAvion temp = model.tabletipo.getElement(view.principaltable.convertRowIndexToModel(view.principaltable.getSelectedRow()));
                avioncontroller.ModificarTipoAvion(temp);
                }
            else
                avionview.añadir.setEnabled(true);
            return avionview;
   
    }

    
    public void Eliminar(TipoAvion object) throws NonexistentEntityException, IllegalOrphanException
    {
        Modelo.getInstance().Eliminar(object);
//        TipoAvionDao.getInstance().destroy(object.getIdentificador());
       this.Update();
    }

    public void Update()
    {
        model.setUser();
    }

    public TableModelTipoAvion searh(String search, int type) 
    {
         model.tabletipo.setLista(Modelo.getInstance().Search(search, type));
            return model.tabletipo;

    }

    
    
}
