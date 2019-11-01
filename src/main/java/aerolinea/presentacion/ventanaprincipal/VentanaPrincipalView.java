package aerolinea.presentacion.ventanaprincipal;

import aerolinea.data.Parse;
import aerolinea.logic.Usuario;
import aerolinea.presentacion.Usuario.UsuarioController;
import aerolinea.presentacion.Usuario.UsuarioModel;
import java.awt.Checkbox;
import java.awt.Event;
import java.awt.event.MouseAdapter;
import java.text.ParseException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class VentanaPrincipalView extends javax.swing.JFrame implements Observer {

    UsuarioModel Umodel;
    VentanaPrincipalModel model;
    VentanaPrincipalController controller;
    PrincipalUserController Ucontroller;

    public PrincipalUserController getUcontroller() {
        return Ucontroller;
    }

    public void setUcontroller(PrincipalUserController Ucontroller) {
        this.Ucontroller = Ucontroller;
    }

    public UsuarioModel getUModel() {
        return Umodel;
    }

    public void setUModel(UsuarioModel Model) {
        this.Umodel = Model;
    }

    public VentanaPrincipalView() {

//        TipoAvionView pv = new TipoAvionView();
//        TipoAvionModel mv = new TipoAvionModel();
//        TipoAvionController cv = new TipoAvionController(mv,pv);
        initComponents();
        Umodel = new UsuarioModel();
        this.Ucontroller = new PrincipalUserController(Umodel, this);
        this.IAdministrar.setVisible(false);
        this.IComprar.setVisible(false);
        this.ICompras.setVisible(false);
        this.Iperfil.setVisible(false);
        this.ISalir.setVisible(false);
        //this.setResizable(false);
    }

    public void setVisibleBlogin() {
        this.Blogin.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Lbienvenida = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        IAdministrar = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        IComprar = new javax.swing.JMenu();
        ICompras = new javax.swing.JMenu();
        Iperfil = new javax.swing.JMenu();
        Pmodificar = new javax.swing.JMenuItem();
        Pver = new javax.swing.JMenuItem();
        Icuenta = new javax.swing.JMenu();
        Blogin = new javax.swing.JMenuItem();
        Bregistrarse = new javax.swing.JMenuItem();
        ISalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(585, 435));
        getContentPane().setLayout(null);

        Lbienvenida.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(Lbienvenida);
        Lbienvenida.setBounds(170, 50, 270, 20);

        IAdministrar.setText("Administrar");

        jMenuItem1.setText("result");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        IAdministrar.add(jMenuItem1);

        jMenuBar1.add(IAdministrar);

        IComprar.setText("Comprar");
        jMenuBar1.add(IComprar);

        ICompras.setText("Compras");
        jMenuBar1.add(ICompras);

        Iperfil.setText("Perfil");

        Pmodificar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        Pmodificar.setText("Modificar");
        Pmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PmodificarActionPerformed(evt);
            }
        });
        Iperfil.add(Pmodificar);

        Pver.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        Pver.setText("Ver");
        Pver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PverActionPerformed(evt);
            }
        });
        Iperfil.add(Pver);

        jMenuBar1.add(Iperfil);

        Icuenta.setText("Cuenta");

        Blogin.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        Blogin.setText("Iniciar Sesion");
        Blogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BloginActionPerformed(evt);
            }
        });
        Icuenta.add(Blogin);

        Bregistrarse.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        Bregistrarse.setText("Registrarse");
        Bregistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BregistrarseActionPerformed(evt);
            }
        });
        Icuenta.add(Bregistrarse);

        ISalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        ISalir.setText("Salir");
        ISalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ISalirActionPerformed(evt);
            }
        });
        Icuenta.add(ISalir);

        jMenuBar1.add(Icuenta);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PmodificarActionPerformed
        try {
            MaskFormatter tel = new MaskFormatter("###-########");
            MaskFormatter fn = new MaskFormatter("##-##-####");
            String[] userd = this.Ucontroller.getuserdata();

            JLabel label = new JLabel();
            label.setText("Espacios con * Obligatorios");
            //codigo
            JTextField codigo = new JTextField();
            codigo.setText(userd[0]);
            codigo.setEditable(false);
            //Nombre
            JTextField nombre = new JTextField();
            nombre.setText(userd[1]);
            //apellido
            JTextField apellido = new JTextField();
            apellido.setText(userd[2]);
            //Correo
            JTextField correo = new JTextField();
            correo.setText(userd[3]);
            //Numero
            JFormattedTextField numero = new JFormattedTextField(tel);
            numero.setText(userd[4]);
            //Fnacimiento
            JFormattedTextField fnacimiento = new JFormattedTextField(fn);
            fnacimiento.setText(userd[5]);
            //Direcion
            JTextField direccion = new JTextField();
            direccion.setText(userd[6]);
            //password
            JPasswordField password = new JPasswordField();
            password.setText(userd[7]);
            Checkbox cb = new Checkbox();
            cb.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    if (cb.getState() == true) {
                        password.setEchoChar((char) 0);
                        password.setText(password.getText());
                    } else {
                        password.setEchoChar('*');
                        password.setText(password.getText());
                    }
                }

            });
            Object[] files = {
                "", label,
                "ID* : ", codigo,
                "Nombre :", nombre,
                "Apellido :", apellido,
                "Correo Electronico* :", correo,
                "Numero: ", numero,
                "Fecha de Nacimiento :", fnacimiento,
                "Direccion: ", direccion,
                "Mostrar Password", cb,
                "password* :", password
            };
            if (JOptionPane.showConfirmDialog(null, files, "Modificar", JOptionPane.OK_CANCEL_OPTION) == 0) {

                if (Parse.Aprove(password.getText(), Parse.CODIGOS)) {
                    if ( Parse.Aprove(correo.getText(), Parse.CORREO)) {
                        if (this.Ucontroller.modifyUser(codigo.getText(), nombre.getText(), apellido.getText(),correo.getText(), numero.getText(),fnacimiento.getText(),direccion.getText(), password.getText())) {
                            JOptionPane.showMessageDialog(null, "Modificado!");
                            this.Lbienvenida.setText("Bienvenido " + Umodel.getUser().toString());
                        } else {
                            JOptionPane.showMessageDialog(null, "Fallo!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Correo invalido");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Contraseña no aceptada");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Modificacion cancelada");
            }

        } catch (ParseException ex) {
            Logger.getLogger(VentanaPrincipalView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_PmodificarActionPerformed

    private void PverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PverActionPerformed
        String[] userd = this.Ucontroller.getuserdata();
        //Codigo
        JTextField codigo = new JTextField();
        codigo.setEditable(false);
        codigo.setText(userd[0]);
        //Nombre
        JTextField nombre = new JTextField();
        nombre.setText(userd[1]);
        nombre.setEditable(false);
        //Apellido
        JTextField apellido = new JTextField();
        apellido.setText(userd[2]);
        apellido.setEditable(false);
        //Correo
        JTextField correo = new JTextField();
        correo.setText(userd[3]);
        correo.setEditable(false);
        //Numero
        JTextField numero = new JTextField();
        numero.setText(userd[4]);
        numero.setEditable(false);
        //Fnacimiento
        JTextField fnacimiento = new JTextField();
        fnacimiento.setText(userd[5]);
        fnacimiento.setEditable(false);
        //Direccion
        JTextField direccion = new JTextField();
        direccion.setText(userd[6]);
        direccion.setEditable(false);
        //Password
        JPasswordField password = new JPasswordField();
        password.setText(userd[7]);
        Checkbox cb = new Checkbox();
        cb.setState(false);
        cb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (cb.getState() == false) {
                    password.setEchoChar('*');
                } else {
                    password.setEchoChar((char) 0);
                }
            }
        });

        password.setEditable(false);
        Object[] files = {
            "ID* : ", codigo,
            "Nombre :", nombre, "Apellido :", apellido,
            "Correo :", correo,
            "Numero telefonico", numero,
            "Direccion", direccion,
            "mostrar password", cb, "password* :", password
        };
        JOptionPane.showInternalConfirmDialog(null, files, "Perfil", JOptionPane.CLOSED_OPTION);
    }//GEN-LAST:event_PverActionPerformed

    private void BregistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BregistrarseActionPerformed
        try {
            MaskFormatter tel = new MaskFormatter("###-########");
            MaskFormatter fn = new MaskFormatter("##-##-####");

            JLabel label = new JLabel();
            label.setText("Espacios con * Obligatorios");
            JTextField codigo = new JTextField();
            JTextField nombre = new JTextField();
            JTextField apellido = new JTextField();
            JTextField correo = new JTextField();
            JFormattedTextField numero = new JFormattedTextField(tel);
            JFormattedTextField fnacimiento = new JFormattedTextField(fn);
            JTextField direccion = new JTextField();
            JTextField password = new JTextField();
            Object[] files = {
                "", label,
                "ID* : ", codigo,
                "Nombre :", nombre,
                "Apellido :", apellido,
                "Correo* :", correo,
                "numero :", numero,
                "Fecha de Nacimiento", fnacimiento,
                "Direccion", direccion,
                "password* :", password
            };
            if (JOptionPane.showConfirmDialog(null, files, "Registrarse", JOptionPane.OK_CANCEL_OPTION) == 0) {
                if (Parse.Aprove(codigo.getText(),Parse.CODIGOS)) {
                    if (this.Umodel.FindUser(codigo.getText()) == null) {
                        if (Parse.Aprove(password.getText(), Parse.CODIGOS)) {
                            if (Parse.Aprove(correo.getText(),Parse.CORREO)) {
                                try {
                                    this.Ucontroller.MakeUser(codigo.getText(), nombre.getText(), apellido.getText(), password.getText());
                                    JOptionPane.showMessageDialog(null, "Usuario creado");
                                } catch (Exception ex) {
                                    JOptionPane.showMessageDialog(null, "Insercion fallida " + ex.getMessage());
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Correo invalido");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Password invalida");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "ID Existente");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "ID Invalido");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Inscripcion cancelada");
            }
            files = null;

        } catch (ParseException ex) {
            Logger.getLogger(VentanaPrincipalView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_BregistrarseActionPerformed

    private void BloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BloginActionPerformed
        this.Blogin.setVisible(false);
        aerolinea.presentacion.Usuario.Login x = new aerolinea.presentacion.Usuario.Login();
        aerolinea.presentacion.Usuario.LoginController contr = new aerolinea.presentacion.Usuario.LoginController(Umodel, x);
        x.setSize(209, 139);
        x.setLocation(this.getWidth() - x.getWidth() - 15, this.getHeight() - x.getHeight() - 60);
        this.add(x);
        x.setAux(this);
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_BloginActionPerformed

    private void ISalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ISalirActionPerformed
        this.Lbienvenida.setText("");
        this.Blogin.setVisible(true);
        this.Umodel.setUser(null);
        this.Bregistrarse.setVisible(true);
        this.ISalir.setVisible(false);
    }//GEN-LAST:event_ISalirActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
         JTextField pa = new JTextField();
         JTextField to = new JTextField();
            Object[] files = {
                "Texto",pa,
                "tipo",to
            };
        JOptionPane.showMessageDialog(null,files);
        JOptionPane.showMessageDialog(null,Parse.Aprove(pa.getText(),Integer.valueOf(to.getText())));
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    public void setModel(VentanaPrincipalModel model) {
        this.model = model;
        model.addObserver(this);
    }

    public void setController(VentanaPrincipalController controller) {
        this.controller = controller;
    }

    public void EneablePermises(Usuario user) {
        this.Ucontroller = new PrincipalUserController(Umodel, this);
        this.Iperfil.setVisible(true);
        this.jMenuBar1.setVisible(true);
        this.IComprar.setVisible(true);
        this.ICompras.setVisible(true);
        this.Bregistrarse.setVisible(false);
        this.Blogin.setVisible(false);
        this.ISalir.setVisible(true);
        switch (user.getTipo()) {
            case 'A':
                this.IAdministrar.setVisible(true);
                break;
            case 'C':
                this.IAdministrar.setVisible(false);
                break;
        }
        this.Lbienvenida.setText("Bienvenido " + user.toString());
        this.Umodel.setUser(user);
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipalView().setVisible(true);
            }
        });
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Blogin;
    private javax.swing.JMenuItem Bregistrarse;
    private javax.swing.JMenu IAdministrar;
    private javax.swing.JMenu IComprar;
    private javax.swing.JMenu ICompras;
    private javax.swing.JMenuItem ISalir;
    private javax.swing.JMenu Icuenta;
    private javax.swing.JMenu Iperfil;
    private javax.swing.JLabel Lbienvenida;
    private javax.swing.JMenuItem Pmodificar;
    private javax.swing.JMenuItem Pver;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables
}
