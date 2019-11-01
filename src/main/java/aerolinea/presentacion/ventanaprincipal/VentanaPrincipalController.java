
package aerolinea.presentacion.ventanaprincipal;

import aerolinea.presentacion.tipoavion.TipoAvionModel;
import aerolinea.presentacion.tipoavion.TipoAvionView;

public class VentanaPrincipalController {
    VentanaPrincipalModel model;
    VentanaPrincipalView view;
    public VentanaPrincipalController(VentanaPrincipalModel model, VentanaPrincipalView view) {
        this.model = model;
        this.view = view;
        view.setModel(model);
        view.setController(this);
    }
    
    
}
