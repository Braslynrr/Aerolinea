package aerolinea.presentacion.vuelo;

import aerolinea.data.VueloDao;
import aerolinea.exceptions.IllegalOrphanException;
import aerolinea.exceptions.NonexistentEntityException;
import aerolinea.logic.Modelo;
import aerolinea.logic.TipoAvion;
import aerolinea.logic.Vuelo;
import aerolinea.presentacion.añadirvuelo.AñadirVueloController;
import aerolinea.presentacion.añadirvuelo.AñadirVueloModel;
import aerolinea.presentacion.añadirvuelo.AñadirVueloView;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;

public class VueloController {
    VueloModel model;
    VueloView view;
    

    public VueloController(VueloModel model, VueloView view) {
        this.model = model;
        this.view = view;
        view.setModel(model);
        view.setController(this);
        model.tabletipo.vuelo = this;
    }
    
    public void OcutarDialogo()
    {
        view.dialogo.setVisible(false);
    }
    
    public TableModelVuelo setTables()
    {
//        if (view.buscar.getText() == "")
//        {
        model.tabletipo.setLista(Modelo.getInstance().GetAllVuelo());
        view.searchcombo.setModel(new DefaultComboBoxModel(model.combotipos));
    
        return model.tabletipo;  
//        }
//        else
//        {
//            return this.searh(view.searchfield.getText(), view.searchcombo.getSelectedIndex());
//        }
            
    }
    
    public JPanel VenatanAñadir(int type)
    {
        AñadirVueloModel avionmodel = new AñadirVueloModel();
        AñadirVueloView avionview = new AñadirVueloView();
        AñadirVueloController avioncontroller = new AñadirVueloController(avionmodel,avionview,this);
            if (type == 1)
                {
                avionview.modificar.setEnabled(true);
                Vuelo temp = model.tabletipo.getElement(view.principaltable.convertRowIndexToModel(view.principaltable.getSelectedRow()));
                avioncontroller.ModificarVuelo(temp);
                }
            else
                avionview.añadir.setEnabled(true);
            return avionview;
   
    }

    
    public void Eliminar(Vuelo object) throws NonexistentEntityException, IllegalOrphanException
    {
        Modelo.getInstance().Eliminar(object);
//        TipoAvionDao.getInstance().destroy(object.getIdentificador());
       this.Update();
    }

    public void Update()
    {
        model.setUser();
    }

    public TableModelVuelo searh(String search, int type) 
    {
         model.tabletipo.setLista(VueloDao.getInstance().findVueloEntities());
         view.searchcombo.setModel(new DefaultComboBoxModel(model.combotipos));
            return model.tabletipo;

    }

    
    
}
