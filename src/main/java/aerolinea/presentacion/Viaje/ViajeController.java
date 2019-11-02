package aerolinea.presentacion.viaje;

import aerolinea.data.TipoAvionDao;
import aerolinea.data.ViajeDao;
import aerolinea.exceptions.IllegalOrphanException;
import aerolinea.exceptions.NonexistentEntityException;
import aerolinea.logic.Modelo;
import aerolinea.logic.Viaje;
import aerolinea.logic.Vuelo;
import aerolinea.presentacion.añadirviaje.AñadirViajeController;
import aerolinea.presentacion.añadirviaje.AñadirViajeModel;
import aerolinea.presentacion.añadirviaje.AñadirViajeView;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.TimeZone;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;

public class ViajeController {
    ViajeModel model;
    ViajeView view;
    

    public ViajeController(ViajeModel model, ViajeView view) {
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
    
    public TableModelViaje setTables()
    {
        if (view.idacombo.getSelectedIndex() ==0 && view.regresocombo.getSelectedIndex() ==0 && view.fechasalida.getSelectedIndex() ==0 && view.fecharegreso.getSelectedIndex() ==0)
        {
        model.tabletipo.setLista(Modelo.getInstance().GetAllViaje());
//        view.fechasalida.setModel(new DefaultComboBoxModel(model.combotipos));
        return model.tabletipo;  
        }
        else
        {

            return this.searh();
        }
            
    }
    
    public JPanel VenatanAñadir(int type)
    {
        AñadirViajeModel viajemodel = new AñadirViajeModel();
        AñadirViajeView viajeview = new AñadirViajeView();
        AñadirViajeController viajecontroller = new AñadirViajeController(viajemodel,viajeview,this);
            if (type == 1)
                {
                viajeview.modificar.setEnabled(true);
                Viaje temp = model.tabletipo.getElement(view.principaltable.convertRowIndexToModel(view.principaltable.getSelectedRow()));
                viajecontroller.ModificarVuelo(temp);
                
                }
            else
            {
                viajeview.añadir.setEnabled(true);

            }
            return viajeview;

   
    }

    
    public void Eliminar(Viaje object) throws NonexistentEntityException, IllegalOrphanException
    {
//        Modelo.getInstance().Eliminar(object);
       ViajeDao.getInstance().destroy(object.getCodigo());
       this.Update();
    }

    public void Update()
    {
        model.setUser();
    }

    public TableModelViaje searh() 
    {
        ArrayList<Object> datos = new ArrayList<Object>();
        
        SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        
        
        if (view.idacombo.getSelectedIndex() == 0)
            datos.add("");
        else
        {
            Vuelo aux = (Vuelo) view.idacombo.getSelectedItem();
            datos.add(aux.getIdentificador());
        }
        if (view.regresocombo.getSelectedIndex() == 0)
             datos.add("");
        else
        {
            Vuelo aux2 = (Vuelo) view.regresocombo.getSelectedItem();
            datos.add(aux2.getIdentificador());
        }
        if (view.fechasalida.getSelectedIndex() == 0)
            datos.add("");
        else
        {
            Date aux3 = (Date) view.fechasalida.getSelectedItem();
            datos.add(formatter.format(aux3));
        }
        if (view.fecharegreso.getSelectedIndex() == 0)
            datos.add("");
        else
        {
            Date aux4 = (Date) view.fechasalida.getSelectedItem();
            datos.add(formatter.format(aux4));
        }
        
        
        System.out.println(datos.get(0));
        System.out.println(datos.get(1));
        System.out.println(datos.get(2).toString());
        System.out.println(datos.get(3));
        
        
        
//       model.tabletipo.setLista(ViajeDao.getInstance().findViajeEntities());
        model.tabletipo.setLista(Modelo.getInstance().searchViajes(datos));
//         view.fechasalida.setModel(new DefaultComboBoxModel((Vector) model.tabletipo.lista));
            return model.tabletipo;

    }

    
    
}


