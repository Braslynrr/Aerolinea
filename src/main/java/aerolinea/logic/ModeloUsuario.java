package aerolinea.logic;

import aerolinea.data.UsuarioDao;

import java.util.List;

/**
 *
 * @author Admin2
 */
public class ModeloUsuario {
    
    private ModeloUsuario() {
    }
    
    public static ModeloUsuario getInstance() {
        return ModeloUsuarioHolder.INSTANCE;
    }
    
    private static class ModeloUsuarioHolder {

        private static final ModeloUsuario INSTANCE = new ModeloUsuario();
    }
    
    public List<Usuario> Search(String code){
        return (List<Usuario>) UsuarioDao.getInstance().findUsuario(code);
    }
    
    
}
