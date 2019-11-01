/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.ventanaprincipal;

import aerolinea.logic.Usuario;
import aerolinea.presentacion.Usuario.UsuarioModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin2
 */
public class PrincipalUserController {
    UsuarioModel model;
    VentanaPrincipalView view;
    public PrincipalUserController(UsuarioModel model, VentanaPrincipalView view) {
        this.model = model;
        this.view = view;
        view.setUModel(model);
        view.setUcontroller(this);
    }
    
      public String[] getuserdata(){
         return model.Userdata();
      }
    
    
    public Boolean modifyUser(String codigo,String nombre,String apellido,String correo,String numero,String fnacimiento,String dir,String password){
       return this.model.modificarUsuario(codigo, nombre, apellido, correo, numero, fnacimiento, dir, password);
    }
    
     public void MakeUser(String codigo,String nombre,String apellido,String password) throws Exception{
            this.model.CrearUsuario(codigo, nombre, apellido, password);
    }
    
}
