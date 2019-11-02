/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.Reserva;


import javax.swing.JPanel;



public class ReservaController {
ReservaModel model;
ReservaView view;

    public ReservaController(ReservaModel mdoel, ReservaView view) {
        this.model = mdoel;
        this.view = view;
        view.setModel(model);
        view.setController(this);
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

    JPanel VenatanAñadir() {
       view.setSize(840, 500);
       return view;
    }


}
