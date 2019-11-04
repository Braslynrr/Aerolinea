package aerolinea.presentacion.pais;

import aerolinea.data.PaisDao;
import aerolinea.presentacion.tipoavion.*;
import aerolinea.data.TipoAvionDao;
import aerolinea.exceptions.IllegalOrphanException;
import aerolinea.exceptions.NonexistentEntityException;
import aerolinea.logic.Modelo;
import aerolinea.logic.Pais;
import aerolinea.logic.TipoAvion;
import aerolinea.presentacion.añadirpais.AñadirPaisAModel;
import aerolinea.presentacion.añadirpais.AñadirPaisController;
import aerolinea.presentacion.añadirpais.AñadirPaisView;
import aerolinea.presentacion.añadirtipoavion.AñadirTipoAController;
import aerolinea.presentacion.añadirtipoavion.AñadirTipoAModel;
import aerolinea.presentacion.añadirtipoavion.AñadirTipoAView;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;

public class PaisController {
    PaisModel model;
    PaisView view;

    public PaisController(PaisModel model, PaisView view) {
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
    public TableModelPais setTables()
    {
        if (view.buscar.getText() == "")
        {
        model.tabletipo.setLista(Modelo.getInstance().GetListaPais());
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
        AñadirPaisAModel paismodel = new AñadirPaisAModel();
        AñadirPaisView paisview = new AñadirPaisView();
        AñadirPaisController paiscontroller = new AñadirPaisController(paismodel,paisview,this);
            if (type == 1)
                {
                paisview.modificar.setEnabled(true);
                Pais temp = model.tabletipo.getElement(view.principaltable.convertRowIndexToModel(view.principaltable.getSelectedRow()));
                paiscontroller.setPais(temp);
                }
            else
                paisview.añadir.setEnabled(true);
            return paisview;
   
    }

    
    public void Eliminar(Pais object) throws NonexistentEntityException, IllegalOrphanException
    {
        Modelo.getInstance().Eliminar(object);
        this.Update();
    }

    public void Update()
    {
        model.setUser();
    }

    public TableModelPais searh(String search, int type) 
    {
         model.tabletipo.setLista(Modelo.getInstance().SearchPais(search, type));
            return model.tabletipo;

    }
    
}
