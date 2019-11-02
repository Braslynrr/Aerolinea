/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.Compra;

import java.awt.Dialog;

/**
 *
 * @author Admin2
 */
public class TiquetesController {
    TiquetesModel model;
    TiqueteView view;
    Dialog dialogo;

    public void setDialogo(Dialog dialogo) {
        this.dialogo = dialogo;
    }
    
    public TiquetesController(TiquetesModel model, TiqueteView view) {
        this.model = model;
        this.view = view;
        view.setController(this);
        model.addObserver(view);
    }

    public void HideDialog(){
        dialogo.setVisible(false);
    }

    public TiquetesModel getModel() {
        return model;
    }

    public void setModel(TiquetesModel model) {
        this.model = model;
    }

    public TiqueteView getView() {
        return view;
    }

    public void setView(TiqueteView view) {
        this.view = view;
    }
    
    
}
