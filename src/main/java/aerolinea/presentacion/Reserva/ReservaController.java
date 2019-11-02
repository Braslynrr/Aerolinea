/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.Reserva;



public class ReservaController {
ReservaModel model;
ReservaView view;

    public ReservaController(ReservaModel mdoel, ReservaView view) {
        this.model = mdoel;
        this.view = view;
        view.setController(this);
    }

    public ReservaModel getMdoel() {
        return model;
    }

    public void setMdoel(ReservaModel mdoel) {
        this.model = mdoel;
    }

    public ReservaView getView() {
        return view;
    }

    public void setView(ReservaView view) {
        this.view = view;
    }


}
