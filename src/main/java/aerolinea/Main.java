package aerolinea;

import aerolinea.data.TipoAvionDao;
import aerolinea.data.UsuarioDao;
import aerolinea.logic.TipoAvion;
import aerolinea.logic.Usuario;
import aerolinea.presentacion.ventanaprincipal.VentanaPrincipalController;
import aerolinea.presentacion.ventanaprincipal.VentanaPrincipalModel;
import aerolinea.presentacion.ventanaprincipal.VentanaPrincipalView;

public class Main {
    
    public static void main(String[] args) 
    {
        Usuario tip= UsuarioDao.getInstance().findUsuario("0");
        System.out.println(tip.getNombre());
        VentanaPrincipalModel model = new VentanaPrincipalModel();
        VentanaPrincipalView view = new VentanaPrincipalView();
        VentanaPrincipalController controller = new VentanaPrincipalController(model,view);
        view.setVisible(true);
    }
}
