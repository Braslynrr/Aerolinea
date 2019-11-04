/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.Reserva;

import aerolinea.logic.Modelo;
import aerolinea.logic.Reserva;
import aerolinea.logic.Tiquete;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ReservaModel extends Observable{
    Reserva reserva;
    aerolinea.presentacion.Reserva.TableModelReserva tabletipo;
    
    public ReservaModel(String user) {
        tabletipo = new TableModelReserva(Modelo.getInstance().SearchReserva(user, 0));
    }

   public void IniciaTabla(String search){
        tabletipo = new TableModelReserva(Modelo.getInstance().SearchReserva(search, 0));
   }
    public Reserva getReserva() {
        return reserva;
    }
    
    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
    
    @Override
    public void addObserver(Observer o){
        super.addObserver(o);
        this.setChanged();
        this.notifyObservers();   
    }
}
