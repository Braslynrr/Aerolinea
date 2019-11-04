package aerolinea.presentacion.vuelo;

import aerolinea.data.VueloDao;
import aerolinea.exceptions.IllegalOrphanException;
import aerolinea.exceptions.NonexistentEntityException;
import aerolinea.logic.Avion;
import aerolinea.logic.Ciudad;
import aerolinea.logic.Modelo;
import aerolinea.logic.TipoAvion;
import aerolinea.logic.Vuelo;
import aerolinea.presentacion.añadirvuelo.AñadirVueloController;
import aerolinea.presentacion.añadirvuelo.AñadirVueloModel;
import aerolinea.presentacion.añadirvuelo.AñadirVueloView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;
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
//        UpdateTable();
    }
    
    public void OcutarDialogo()
    {
        view.dialogo.setVisible(false);
    }
    
    public TableModelVuelo setTables()
    {
        if (view.origencombo.getSelectedIndex() == 0 && view.destinocombo.getSelectedIndex() == 0 && view.avioncombo.getSelectedIndex() == 0 )
        {
        model.tabletipo.setLista(Modelo.getInstance().GetAllVuelo());
//        view.origencombo.setModel(new DefaultComboBoxModel(model.origen));
//        view.destinocombo.setModel(new DefaultComboBoxModel(model.destino));
        return model.tabletipo;  
        }
        else
        {
            return this.searh();
        }
            
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
            {
                avionview.añadir.setEnabled(true);
                avionview.codigofield.setEnabled(false);
            }
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

    public TableModelVuelo searh() 
    {
      ArrayList<Object> datos = new ArrayList<Object>();

        if (view.origencombo.getSelectedIndex() == 0)
            datos.add("");
        else
        {
            Ciudad aux = (Ciudad) view.origencombo.getSelectedItem();
            datos.add(aux.getCodigo());
        }
        if (view.destinocombo.getSelectedIndex() == 0)
             datos.add("");
        else
        {
            Ciudad aux2 = (Ciudad) view.destinocombo.getSelectedItem();
            datos.add(aux2.getCodigo());
        }
        if (view.avioncombo.getSelectedIndex() == 0)
            datos.add("");
        else
        {
            Avion aux3 = (Avion) view.avioncombo.getSelectedItem();
            datos.add(aux3.getIdentificador());
        }

        model.tabletipo.setLista(Modelo.getInstance().searchVuelos(datos));

        return model.tabletipo;
    }
    
    public void updatecombos()
    {
        model.UpdateIdaRegreso();
    }

    
    
}


