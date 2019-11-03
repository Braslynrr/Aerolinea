/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.Compra;

import aerolinea.logic.Viaje;
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
        view.setModel(model);
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
    public void ChargeTickets(String code){
        model.ChargeTiquets(code);
    }
      
    public Boolean BuyTiquete(int fila,int asiento ,String nombre,String metodo,Viaje viaj){
        try{
            return model.buyTicket(fila, asiento, metodo,nombre,this.view.main.getUModel().getUser(),viaj);
        }catch(Exception ex){
            return false;
        }
     }
    
    public Boolean getTicket(int fila,int asiento){
       return model.findTicket(fila, asiento);
    }
    
    
}
