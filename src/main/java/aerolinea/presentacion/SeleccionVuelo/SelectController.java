package aerolinea.presentacion.SeleccionVuelo;

import aerolinea.data.ViajeDao;
import aerolinea.exceptions.IllegalOrphanException;
import aerolinea.exceptions.NonexistentEntityException;
import aerolinea.logic.Modelo;
import aerolinea.logic.Viaje;
import aerolinea.logic.Vuelo;
import aerolinea.presentacion.Compra.TiquetesModel;
import aerolinea.presentacion.Reserva.ReservaModel;
import aerolinea.presentacion.ventanaprincipal.VentanaPrincipalView;
import java.awt.Dialog;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.TimeZone;
import javax.swing.JPanel;

public class SelectController {

    SelectModel model;
    SelectView view;
    VentanaPrincipalView main;
    Dialog dialogo;

    public Dialog getDialogo() {
        return dialogo;
    }

    public void setDialogo(Dialog dialogo) {
        this.dialogo = dialogo;
    }

    public SelectController(SelectModel model, SelectView view) {
        this.model = model;
        this.view = view;
        view.setModel(model);
        view.setController(this);
        model.tabletipo.vuelo = this;
        model.addObserver(view);
        main = view.main;
    }

    public void OcutarDialogo() {
        dialogo.setVisible(false);
    }

    public TableModelselect setTables() {
        if (view.idacombo.getSelectedIndex() == 0 && view.regresocombo.getSelectedIndex() == 0 && view.fechasalida.getSelectedIndex() == 0 && view.fecharegreso.getSelectedIndex() == 0) {
            model.tabletipo.setLista(Modelo.getInstance().GetAllViaje());
//        view.fechasalida.setModel(new DefaultComboBoxModel(model.combotipos));
            return model.tabletipo;
        } else {

            return this.searh();
        }

    }
    
    
    public int cantTicketviaje(Viaje viaje){
       return this.model.camposcomprables(viaje);
    }

    public void Eliminar(Viaje object) throws NonexistentEntityException, IllegalOrphanException {
//        Modelo.getInstance().Eliminar(object);
        ViajeDao.getInstance().destroy(object.getCodigo());
        this.Update();
    }

    public void Update() {
        model.setUser();
    }

    public TableModelselect searh() {
        ArrayList<Object> datos = new ArrayList<Object>();

        SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));

        if (view.idacombo.getSelectedIndex() == 0) {
            datos.add("");
        } else {
            Vuelo aux = (Vuelo) view.idacombo.getSelectedItem();
            datos.add(aux.getIdentificador());
        }
        if (view.regresocombo.getSelectedIndex() == 0) {
            datos.add("");
        } else {
            Vuelo aux2 = (Vuelo) view.regresocombo.getSelectedItem();
            datos.add(aux2.getIdentificador());
        }
        if (view.fechasalida.getSelectedIndex() == 0) {
            datos.add("");
        } else {
            Date aux3 = (Date) view.fechasalida.getSelectedItem();
            datos.add(formatter.format(aux3));
        }
        if (view.fecharegreso.getSelectedIndex() == 0) {
            datos.add("");
        } else {
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

    JPanel VenatanAñadir(Viaje viaje, Dialog dialog, int type) {
        switch (type) {
            case 1:
                ReservaModel model1= new ReservaModel(main.getUModel().getUser().getCodigo());
                aerolinea.presentacion.Reserva.ReservaView view1=new aerolinea.presentacion.Reserva.ReservaView(main) ;
                aerolinea.presentacion.Reserva.ReservaController controller1= new aerolinea.presentacion.Reserva.ReservaController(model1, view1);
                controller1.setDialogo(dialog);
                return view1;
            default:
                TiquetesModel model = new TiquetesModel();
                aerolinea.presentacion.Compra.TiqueteView view = new aerolinea.presentacion.Compra.TiqueteView(main, viaje,type);
                aerolinea.presentacion.Compra.TiquetesController controller = new aerolinea.presentacion.Compra.TiquetesController(model, view,dialog);
                return view;
        }
        
    }

}
