package aerolinea.presentacion.ciudad;

import aerolinea.exceptions.IllegalOrphanException;
import aerolinea.exceptions.NonexistentEntityException;
import aerolinea.logic.Ciudad;
import aerolinea.logic.Modelo;
import aerolinea.presentacion.añadirciudad.AñadirCiudadController;
import aerolinea.presentacion.añadirciudad.AñadirCiudadModel;
import aerolinea.presentacion.añadirciudad.AñadirCiudadView;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;

public class CiudadController {
    CiudadModel model;
    CiudadView view;

    public CiudadController(CiudadModel model, CiudadView view) {
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
    public TableModelCiudad setTables()
    {
        if (view.searchfield.getText() == "")
        {
        model.tabletipo.setLista(Modelo.getInstance().GetListaCiudad());
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
        AñadirCiudadModel ciudadmodel = new AñadirCiudadModel();
        AñadirCiudadView ciudadview = new AñadirCiudadView();
        AñadirCiudadController ciudadcontroller = new AñadirCiudadController(ciudadmodel,ciudadview,this);
            if (type == 1)
                {
                ciudadview.modificar.setEnabled(true);
                Ciudad temp = model.tabletipo.getElement(view.principaltable.convertRowIndexToModel(view.principaltable.getSelectedRow()));
                ciudadcontroller.setCiudad(temp);
                }
            else
                ciudadview.añadir.setEnabled(true);
            return ciudadview;
   
    }

    
    public void Eliminar(Ciudad object) throws NonexistentEntityException, IllegalOrphanException
    {
        Modelo.getInstance().Eliminar(object);
        this.Update();
    }

    public void Update()
    {
        model.setUser();
    }

    public TableModelCiudad searh(String search, int type) {
         model.tabletipo.setLista(Modelo.getInstance().SearchCiudad(search, type));
            return model.tabletipo;
    }


    
    
}
