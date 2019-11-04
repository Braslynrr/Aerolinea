package aerolinea.presentacion.pago;

import aerolinea.data.MetodoPagoDao;
import aerolinea.exceptions.IllegalOrphanException;
import aerolinea.exceptions.NonexistentEntityException;
import aerolinea.logic.MetodoPago;
import aerolinea.logic.Modelo;
import aerolinea.presentacion.añadirmetodopago.AñadirPagoController;
import aerolinea.presentacion.añadirmetodopago.AñadirPagoModel;
import aerolinea.presentacion.añadirmetodopago.AñadirPagoView;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;

public class PagoController {
    PagoModel model;
    PagoView view;

    public PagoController(PagoModel model, PagoView view) {
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
    public TableModelPago setTables()
    {
        if (view.searchfield.getText() == "")
        {
        model.tabletipo.setLista(Modelo.getInstance().GetListaMetodos());
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
        AñadirPagoModel pagomodel = new AñadirPagoModel();
        AñadirPagoView pagoview = new AñadirPagoView();
        AñadirPagoController pagocontroller = new AñadirPagoController(pagomodel,pagoview,this);
            if (type == 1)
                {
                pagoview.modificar.setEnabled(true);
                MetodoPago temp = model.tabletipo.getElement(view.principaltable.convertRowIndexToModel(view.principaltable.getSelectedRow()));
                pagocontroller.setPago(temp);
                }
            else
                pagoview.añadir.setEnabled(true);
            return pagoview;
   
    }

    
    public void Eliminar(MetodoPago object) throws NonexistentEntityException, IllegalOrphanException
    {
       Modelo.getInstance().Eliminar(object);
        this.Update();
    }

    public void Update()
    {
        model.setUser();
    }

    public TableModelPago searh(String search, int type) {
        model.tabletipo.setLista(Modelo.getInstance().SearchMetodo(search, type));
            return model.tabletipo;
    }
    
}
