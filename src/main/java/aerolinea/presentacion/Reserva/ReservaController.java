/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.Reserva;

import aerolinea.presentacion.ventanaprincipal.VentanaPrincipalView;
import java.awt.Dialog;
import javax.swing.JPanel;

public class ReservaController {

    ReservaModel model;
    ReservaView view;
    VentanaPrincipalView main;

    public ReservaController(ReservaModel mdoel, ReservaView view) {
        this.model = mdoel;
        this.view = view;
        view.setModel(model);
        view.setController(this);
        main = view.main;
    }
    
    public ReservaModel getMdoel() {
        return model;
    }
    
    public void setModel(ReservaModel mdoel) {
        this.model = mdoel;
    }
    
    public ReservaView getView() {
        return view;
    }
    
    public void setView(ReservaView view) {
        this.view = view;
    }
    
    JPanel VenatanAñadir(Dialog dialog) {
        aerolinea.presentacion.SeleccionVuelo.SelectModel model = new aerolinea.presentacion.SeleccionVuelo.SelectModel();
        aerolinea.presentacion.SeleccionVuelo.SelectView view = new aerolinea.presentacion.SeleccionVuelo.SelectView(main);
        aerolinea.presentacion.SeleccionVuelo.SelectController controller = new aerolinea.presentacion.SeleccionVuelo.SelectController(model, view);
        controller.setDialogo(dialog);
        view.setSize(840, 500);
        return view;
    }
    
}
