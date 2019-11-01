package aerolinea.presentacion.añadirusuario;

import aerolinea.logic.Usuario;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AñadirUsuarioView extends javax.swing.JPanel implements Observer{

    AñadirUsuarioController controller;
    AñadirUsuarioModel model;
    
    public AñadirUsuarioView() {
        initComponents();
        modificar.setEnabled(false);
        añadir.setEnabled(false);
    }

    public void setController(AñadirUsuarioController controller) {
        this.controller = controller;
    }

    public void setModel(AñadirUsuarioModel model) {
        this.model = model;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Title = new javax.swing.JLabel();
        ID = new javax.swing.JLabel();
        Nombre = new javax.swing.JLabel();
        Apellido = new javax.swing.JLabel();
        Contraseña = new javax.swing.JLabel();
        tipousuario = new javax.swing.JLabel();
        standart = new javax.swing.JCheckBox();
        Premiun = new javax.swing.JCheckBox();
        Idfield = new javax.swing.JTextField();
        nombrefield = new javax.swing.JTextField();
        apellidofield = new javax.swing.JTextField();
        contraseñafield = new javax.swing.JTextField();
        añadir = new javax.swing.JButton();
        modificar = new javax.swing.JButton();

        Title.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText("Anadir un usuario");

        ID.setText("ID");

        Nombre.setText("Nombre");

        Apellido.setText("Apellido");

        Contraseña.setText("Contraseña");

        tipousuario.setText("Tipo de usuario");

        standart.setText("Standart");

        Premiun.setText("Premiun");

        añadir.setText("Añadir");
        añadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirActionPerformed(evt);
            }
        });

        modificar.setText("Modificar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tipousuario)
                            .addComponent(ID)
                            .addComponent(Nombre)
                            .addComponent(Apellido)
                            .addComponent(Contraseña))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(standart)
                                .addGap(10, 10, 10)
                                .addComponent(Premiun))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(contraseñafield, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                                .addComponent(apellidofield, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nombrefield, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Idfield, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(añadir)
                .addGap(83, 83, 83)
                .addComponent(modificar)
                .addContainerGap(101, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(Title)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ID)
                    .addComponent(Idfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nombre)
                    .addComponent(nombrefield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Apellido)
                    .addComponent(apellidofield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Contraseña)
                    .addComponent(contraseñafield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipousuario)
                    .addComponent(standart)
                    .addComponent(Premiun))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(añadir)
                    .addComponent(modificar))
                .addContainerGap(21, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void añadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirActionPerformed

        Usuario usuario = new Usuario();
        usuario.setNombre(nombrefield.getText());
        usuario.setApellido(apellidofield.getText());
        usuario.setCodigo(Idfield.getText());
        usuario.setPassword(contraseñafield.getText());
        usuario.setTipo(standart.isSelected() ? "A": "C");
        try {
            controller.Añadir(usuario);
        } catch (Exception ex) {
            Logger.getLogger(AñadirUsuarioView.class.getName()).log(Level.SEVERE, null, ex);
        }
  
//        aerolinea.Main.Controller_Admin.updateTable();
    }//GEN-LAST:event_añadirActionPerformed

    @Override
    public void update(Observable o, Object arg) {
       
        
    }


    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Apellido;
    private javax.swing.JLabel Contraseña;
    private javax.swing.JLabel ID;
    private javax.swing.JTextField Idfield;
    private javax.swing.JLabel Nombre;
    private javax.swing.JCheckBox Premiun;
    private javax.swing.JLabel Title;
    private javax.swing.JTextField apellidofield;
    public javax.swing.JButton añadir;
    private javax.swing.JTextField contraseñafield;
    private javax.swing.JButton modificar;
    private javax.swing.JTextField nombrefield;
    private javax.swing.JCheckBox standart;
    private javax.swing.JLabel tipousuario;
    // End of variables declaration//GEN-END:variables
}
