/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.data;

/**
 *
 * @author Admin2
 */
public class UsuarioDao {
    
    private UsuarioDao() {
    }
    
    public static UsuarioDao getInstance() {
        return UsuarioDaoHolder.INSTANCE;
    }
    
    private static class UsuarioDaoHolder {

        private static final UsuarioDao INSTANCE = new UsuarioDao();
    }
}
