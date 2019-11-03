/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.Compra;

import aerolinea.data.MetodoPagoDao;
import aerolinea.data.ReservaDao;
import aerolinea.data.TiqueteDao;
import aerolinea.logic.MetodoPago;
import aerolinea.logic.Modelo;
import aerolinea.logic.Reserva;
import aerolinea.logic.Tiquete;
import aerolinea.logic.Usuario;
import aerolinea.logic.Viaje;
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

    public void ChargeTiquets(String codigo) {
        list = null;
        list = new ArrayList<Tiquete>();
        List<Tiquete> aux = new ArrayList<Tiquete>();
        List<aerolinea.logic.Reserva> listareserva = aerolinea.data.ReservaDao.getInstance().getReservasViaje(codigo);
        for (int i = 0; i < listareserva.size(); i++) {
            for (int j = 0; j < listareserva.size(); j++) {
                aux = listareserva.get(j).getTiqueteList();
                for (int k = 0; k < aux.size(); k++) {
                    list.add(aux.get(k));
                }
            }
        }
    }

    public void llenarcombo() {
        List<MetodoPago> pagos = Modelo.getInstance().GetAllMetodos();
        for (int i = 0; i < pagos.size(); i++) {
            combotipos.add(pagos.get(i).getDescripcion());
        }
    }

    public Boolean buyTicket(int fila, int asiento, String metodo,String nombre, Usuario user, Viaje viaj) throws Exception {
        try{
            Tiquete nuevo;
        nuevo = new Tiquete();
        nuevo.setCodigo(TiqueteDao.getInstance().getTiqueteCount());
        nuevo.setFila(String.valueOf(fila));
        nuevo.setAsiento(String.valueOf(asiento));
        nuevo.setPersonaNombre(nombre);
        Reserva res = null;
        List<Reserva> reserva = ReservaDao.getInstance().getReservasViaje(user.getCodigo(), viaj.getCodigo());
        for (int i = 0; i < reserva.size(); i++) {
            if (reserva.get(i).getPago().getDescripcion().equals(metodo) && reserva.get(i).getViaje().getCodigo().equals(viaj.getCodigo())) {
                res = reserva.get(i);
            }
        }
        if (res != null) {
            nuevo.setReserva(res);
            TiqueteDao.getInstance().create(nuevo);
        } else {
            res=new Reserva();
            res.setCodigo(ReservaDao.getInstance().getReservaCount());
            res.setPago(MetodoPagoDao.getInstance().findByDescripcion(metodo).get(0));
            res.setUsuario(user);
            res.setViaje(viaj);
            ReservaDao.getInstance().create(res);
            nuevo.setReserva(res);
            TiqueteDao.getInstance().create(nuevo);
        }
        return true;
        }catch(Exception ex){
         System.out.println(ex.getMessage());
         return false;
        }
    }

    public Boolean findTicket(int fila, int asiento) {
        for (int i = 0; i < list.size(); i++) {
            if (Integer.getInteger(list.get(i).getAsiento()) == asiento && Integer.getInteger(list.get(i).getFila()) == fila) {
                return true;
            }
        }
        return false;
    }

}
