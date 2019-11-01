package aerolinea.presentacion.avion;

import aerolinea.data.AvionDao;
import aerolinea.exceptions.IllegalOrphanException;
import aerolinea.exceptions.NonexistentEntityException;
import aerolinea.logic.Avion;
import aerolinea.logic.Modelo;
import aerolinea.presentacion.añadiravion.AñadirAvionAModel;
import aerolinea.presentacion.añadiravion.AñadirAvionController;
import aerolinea.presentacion.añadiravion.AñadirAvionView;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;

public class AvionController {
    AvionModel model;
    AvionView view;

    public AvionController(AvionModel model, AvionView view) {
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
    public TableModelAvion setTables()
    {
        if (view.searchfield.getText() == "")
        {
        model.tabletipo.setLista(Modelo.getInstance().GetListaAviones());
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
        AñadirAvionAModel avionmodel = new AñadirAvionAModel();
        AñadirAvionView avionview = new AñadirAvionView();
        AñadirAvionController avioncontroller = new AñadirAvionController(avionmodel,avionview, this);
            if (type == 1)
                {
                avionview.modificar.setEnabled(true);
                Avion temp = model.tabletipo.getElement(view.principaltable.convertRowIndexToModel(view.principaltable.getSelectedRow()));
                avioncontroller.setAvion(temp);
                }
            else
                avionview.añadir.setEnabled(true);
            return avionview;
   
    }

    
    public void Eliminar(Avion object) throws NonexistentEntityException, IllegalOrphanException
    {
        Modelo.getInstance().Eliminar(object);
        this.Update();
    }

    public void Update()
    {
        model.setUser();
    }

    public TableModelAvion searh(String search, int type) {
        
       model.tabletipo.setLista(Modelo.getInstance().SearchAvion(search, type));
            return model.tabletipo;    
            

    }
    
}
