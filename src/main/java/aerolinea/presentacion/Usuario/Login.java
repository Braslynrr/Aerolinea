/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.Usuario;

import aerolinea.presentacion.ventanaprincipal.VentanaPrincipalView;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin2
 */
public class Login extends javax.swing.JPanel implements Observer {

    VentanaPrincipalView aux;
    LoginController controller;
    UsuarioModel model;

    public Login() {
        initComponents();
    }

    public LoginController getController() {
        return controller;
    }

    public void setController(LoginController controller) {
        this.controller = controller;
    }

    public UsuarioModel getModel() {
        return model;
    }

    public void setModel(UsuarioModel model) {
        this.model = model;
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_ID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Blogin = new javax.swing.JButton();
        Avisos = new javax.swing.JLabel();
        TXT_password = new javax.swing.JPasswordField();
        BExit = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 255, 153));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Cuenta");
        add(jLabel1);
        jLabel1.setBounds(0, 0, 50, 24);

        txt_ID.setText("Usuario");
        add(txt_ID);
        txt_ID.setBounds(60, 40, 112, 20);

        jLabel2.setText("ID");
        add(jLabel2);
        jLabel2.setBounds(0, 35, 78, 24);

        jLabel3.setText("Password");
        add(jLabel3);
        jLabel3.setBounds(0, 62, 78, 63);

        Blogin.setBackground(new java.awt.Color(51, 51, 255));
        Blogin.setForeground(new java.awt.Color(255, 255, 255));
        Blogin.setText("Log in");
        Blogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BloginActionPerformed(evt);
            }
        });
        add(Blogin);
        Blogin.setBounds(137, 113, 70, 23);

        Avisos.setForeground(new java.awt.Color(255, 0, 51));
        add(Avisos);
        Avisos.setBounds(60, 0, 110, 30);

        TXT_password.setText("password");
        TXT_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_passwordActionPerformed(evt);
            }
        });
        add(TXT_password);
        TXT_password.setBounds(60, 80, 110, 20);

        BExit.setBackground(new java.awt.Color(255, 0, 51));
        BExit.setForeground(new java.awt.Color(255, 255, 255));
        BExit.setText("X");
        BExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BExitActionPerformed(evt);
            }
        });
        add(BExit);
        BExit.setBounds(170, 0, 40, 23);
    }// </editor-fold>//GEN-END:initComponents

    private void BloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BloginActionPerformed
        this.Avisos.setText("");
        try {
            if (this.controller.Acceso(this.txt_ID.getText(), this.TXT_password.getText())) {
                this.TXT_password.setText("password");
                this.txt_ID.setText("user");
                this.Avisos.setText("");
                //codigo
                aux.EneablePermises(model.user);
                aux.remove(this);
                aux.revalidate();
                aux.repaint();
            } else {
                this.Avisos.setText("Datos incorrectos");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }//GEN-LAST:event_BloginActionPerformed

    public void setAux(VentanaPrincipalView aux) {
        model.user = null;
        this.aux = aux;
    }


    private void BExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BExitActionPerformed
        this.TXT_password.setText("password");
        this.txt_ID.setText("user");
        this.Avisos.setText("");
        aux.setVisibleBlogin();
        this.setVisible(false);
    }//GEN-LAST:event_BExitActionPerformed

    private void TXT_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXT_passwordActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Avisos;
    private javax.swing.JButton BExit;
    private javax.swing.JButton Blogin;
    private javax.swing.JPasswordField TXT_password;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txt_ID;
    // End of variables declaration//GEN-END:variables

}
