/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.Compra;

import aerolinea.logic.MetodoPago;
import aerolinea.logic.Modelo;
import aerolinea.logic.Tiquete;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

public class TiquetesModel extends Observable {
    Tiquete tiquete;
    List<Tiquete> list;
    Vector<String> combotipos;
    
    public TiquetesModel() {
        combotipos = new Vector<String>();
        this.llenarcombo();
    }

    public Tiquete getTiquete() {
        return tiquete;
    }

    public void setTiquete(Tiquete tiquete) {
        this.tiquete = tiquete;
    }


    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        this.setChanged();
        this.notifyObservers();
    }
    
    
    public void ChargeTiquets(String codigo){
        list=null;
        list = new ArrayList<Tiquete>();
        List<Tiquete> aux=new ArrayList<Tiquete>();
        List<aerolinea.logic.Reserva> listareserva = aerolinea.data.ReservaDao.getInstance().getReservasViaje(codigo);
        for(int i=0;i<listareserva.size();i++){
           for(int j=0; j< listareserva.size();j++){
               aux= listareserva.get(j).getTiqueteList();
               for(int k=0;k<aux.size();k++){
                   list.add(aux.get(k));
               }
           }
        }
    }
    
    
    public void llenarcombo(){
        List<MetodoPago> pagos = Modelo.getInstance().GetAllMetodos();
        for(int i=0; i<pagos.size();i++){
            combotipos.add(pagos.get(i).getDescripcion());
        } 
    }

    public Boolean BuyTicket(int fila,int asiento ,String metodo){
        
        return true;
    }
            
            
            
    public Boolean findTicket(int fila, int asiento) {
        for(int i=0;i<list.size();i++){
            if(Integer.getInteger(list.get(i).getAsiento())==asiento && Integer.getInteger(list.get(i).getFila())==fila)
                return true;
        }
        return false;
    }

}
