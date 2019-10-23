package aerolinea;

import aerolinea.presentacion.ventanaprincipal.VentanaPrincipalController;
import aerolinea.presentacion.ventanaprincipal.VentanaPrincipalModel;
import aerolinea.presentacion.ventanaprincipal.VentanaPrincipalView;

public class Main {
    
    public static void main(String[] args) 
    {
        VentanaPrincipalModel model = new VentanaPrincipalModel();
        VentanaPrincipalView view = new VentanaPrincipalView();
        VentanaPrincipalController controller = new VentanaPrincipalController(model,view);
        view.setVisible(true);
    }
}
