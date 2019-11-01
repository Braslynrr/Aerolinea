/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.logic;

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
    
    
    
    
}
