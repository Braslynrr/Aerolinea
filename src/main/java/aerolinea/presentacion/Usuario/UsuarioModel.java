/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.Usuario;

import aerolinea.data.UsuarioDao;
import aerolinea.logic.Usuario;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin2
 */
public class UsuarioModel extends Observable {

    Usuario user;

    public UsuarioModel() {
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public Usuario FindUser(String codigo) {
        return aerolinea.data.UsuarioDao.getInstance().findUsuario(codigo);
    }

    public Boolean Access(String Codigo, String password) {
        user = aerolinea.data.UsuarioDao.getInstance().findUsuario(Codigo);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public boolean modificarUsuario(String codigo, String nombre, String apellido, String correo, String numero, String fnacimiento, String dir, String password) {
        user.setCodigo(codigo);
        user.setNombre(nombre);
        user.setApellido(apellido);
        user.setCorreoE(correo);
        user.setTelefono(numero);
        user.setFnacimiento(fnacimiento);
        user.setDireccion(dir);
        user.setPassword(password);
        try {
            aerolinea.data.UsuarioDao.getInstance().update(user);
            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }

    }

    public Boolean CrearUsuario(Usuario user) throws Exception {
        this.user = user;
        aerolinea.data.UsuarioDao.getInstance().create(user);
        return true;
    }

    public String[] Userdata() {
        String[] data = new String[9];
        data[0] = user.getCodigo();
        data[1] = user.getNombre();
        data[2] = user.getApellido();
        data[3] = user.getCorreoE();
        data[4] = user.getTelefono();
        data[5] = user.getFnacimiento();
        data[6] = user.getDireccion();
        data[7] = user.getPassword();
        return data;
    }

    public void comprobarAdmin() throws Exception {
        List<Usuario> list = UsuarioDao.getInstance().FindUsertype("A");
        if (list.size() == 0) {
            Usuario user = new Usuario();
            user.setCodigo("0");
            user.setNombre("Admin");
            user.setApellido("");
            user.setPassword("4dm1n");
            user.setTelefono("000-000000");
            user.setFnacimiento("00-00-0000");
            user.setDireccion("Mycompanydir");
            user.setCorreoE("Myempresa@empresa.com");
            user.setTipo("A");
            UsuarioDao.getInstance().create(user);
        }
    }

    public Boolean MakeAdmin(String code) {
        List<Usuario> list = UsuarioDao.getInstance().FindUser(code);
        if (list.size() != 0) {
            Usuario us =list.get(0);
            us.setTipo("A");
            System.out.println(us.getTipo());
            try {
                aerolinea.data.UsuarioDao.getInstance().update(us);
                return true;
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                return false;
            }
        }
        return false;
    }

    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        this.setChanged();
        this.notifyObservers();
    }
}
