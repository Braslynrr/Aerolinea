/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.Usuario;

import aerolinea.logic.Usuario;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin2
 */
public class UsuarioModel extends Observable{
    Usuario user;

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
    public UsuarioModel() {
    }
    
    public Usuario FindUser(String codigo){
        return aerolinea.data.UsuarioDao.getInstance().findUsuario(codigo); 
    }
    
    public String[] Userdata(){
        String[] list=new String[9];
        list[0]=user.getCodigo();
        list[1]=user.getNombre();
        list[2]=user.getApellido();
        list[3]=user.getCorreoE();
        list[4]=user.getTelefono();
        list[5]=user.getFnacimiento();
        list[6]=user.getDireccion();
        list[7]=user.getPassword();
        list[8]=""+user.getTipo();
        return list;
    }
    
    
    public boolean modificarUsuario(String codigo,String nombre,String apellido,String correo,String numero,String fnacimiento,String dir,String password){
        user.setCodigo(codigo);
        user.setNombre(nombre);
        user.setApellido(apellido);
        user.setCorreoE(correo);
        user.setTelefono(numero);
        user.setFnacimiento(fnacimiento);
        user.setDireccion(dir);
        user.setPassword(password);
        try{
            aerolinea.data.UsuarioDao.getInstance().edit(user);
            return true;
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }
        
    }
    public Boolean CrearUsuario(String codigo,String nombre,String apellido,String password) throws Exception{
        user=new Usuario();
        user.setCodigo(codigo);
        user.setNombre(nombre);
        user.setApellido(apellido);
        user.setPassword(password);
        user.setTipo('C');
        aerolinea.data.UsuarioDao.getInstance().create(user);
        return true;
    }
    @Override
    public void addObserver(Observer o){
        super.addObserver(o);
        this.setChanged();
        this.notifyObservers();   
    }
}
