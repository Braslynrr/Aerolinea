/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.Usuario;
import aerolinea.logic.Usuario;

/**
 *
 * @author Admin2
 */
public class LoginController {
    UsuarioModel model;
    Login view;

    public LoginController(UsuarioModel model, Login view) {
       this.model = model;
        this.view = view;
        view.setModel(model);
        view.setController(this);
    }
            
    Boolean Acceso(String codigo,String password){
        this.model.setUser(aerolinea.data.UsuarioDao.getInstance().Access(codigo, password));  
        return this.model.getUser()!=null;
    }
    
    public Usuario FindUser(String codigo){
        return this.model.FindUser(codigo);
    }

}
