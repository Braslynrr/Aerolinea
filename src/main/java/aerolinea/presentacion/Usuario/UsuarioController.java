/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.Usuario;

public class UsuarioController {
    UsuarioModel model;
    UsuarioView view;

    public UsuarioController(UsuarioModel model, UsuarioView view) {
        this.model = model;
            this.view = view;
            view.setModel(model);
            view.setController(this);
    }
    

}
