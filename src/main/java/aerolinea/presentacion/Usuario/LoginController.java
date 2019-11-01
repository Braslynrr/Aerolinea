/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.Usuario;
import aerolinea.logic.Usuario;
import java.awt.Dialog;

/**
 *
 * @author Admin2
 */
public class LoginController {
    UsuarioModel model;
    Login view;
    Dialog dial;

    public Dialog getDial() {
        return dial;
    }

    public void setDial(Dialog dial) {
        this.dial = dial;
    }
    public LoginController(UsuarioModel model, Login view) {
       this.model = model;
        this.view = view;
        view.setModel(model);
        view.setController(this);
    }
            
    Boolean Acceso(String codigo,String password){
        return model.Access(codigo, password);
    }
    
    public void CloseDialog(){
        dial.setVisible(false);
    }
    
    
}
