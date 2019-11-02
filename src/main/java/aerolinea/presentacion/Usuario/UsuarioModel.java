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
    
    public UsuarioModel() {
    }
    
    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
    public Usuario FindUser(String codigo){
        return aerolinea.data.UsuarioDao.getInstance().findUsuario(codigo);
    }
    
    public Boolean Access(String Codigo,String password){
        user=aerolinea.data.UsuarioDao.getInstance().findUsuario(Codigo);
        if(user!=null){
            if(user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
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
            aerolinea.data.UsuarioDao.getInstance().update(user);
            return true;
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }
        
    }
    public Boolean CrearUsuario(Usuario user) throws Exception{
        this.user=user;
        aerolinea.data.UsuarioDao.getInstance().create(user);
        return true;
    }
    
    public String[] Userdata(){
        String[] data=new String[9];
        data[0]=user.getCodigo();
        data[1]=user.getNombre();
        data[2]=user.getApellido();
        data[3]=user.getCorreoE();
        data[4]=user.getTelefono();
        data[5]=user.getFnacimiento();
        data[6]=user.getDireccion();
        data[7]=user.getPassword();
        return data;
    }
    
    
    
    @Override
    public void addObserver(Observer o){
        super.addObserver(o);
        this.setChanged();
        this.notifyObservers();   
    }
}
