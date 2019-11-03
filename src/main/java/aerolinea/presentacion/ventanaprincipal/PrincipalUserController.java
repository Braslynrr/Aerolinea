/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.ventanaprincipal;

import aerolinea.data.UsuarioDao;
import aerolinea.logic.Usuario;
import aerolinea.presentacion.Usuario.UsuarioModel;
import java.util.List;
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
    
    
     public Usuario FindUser(String codigo){
        return model.FindUser(codigo);
     }
      
      
    public Boolean modifyUser(String codigo,String nombre,String apellido,String correo,String numero,String fnacimiento,String dir,String password){
       return this.model.modificarUsuario(codigo, nombre, apellido, correo, numero, fnacimiento, dir, password);
    }
    
     public void MakeUser(Usuario user) throws Exception{
            this.model.CrearUsuario(user);
    }
     
     
    public void comprobar(){
        try{
            model.comprobarAdmin();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
      
    }
    
    
    
    public Boolean MakeAdmin(String code){
        return model.MakeAdmin(code);
    }
    
}
