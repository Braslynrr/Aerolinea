package aerolinea.presentacion.ventanaprincipal;

import aerolinea.data.Parse;
import aerolinea.logic.Usuario;
import aerolinea.presentacion.Reserva.ReservaController;
import aerolinea.presentacion.Reserva.ReservaModel;
import aerolinea.presentacion.Reserva.ReservaView;
import aerolinea.presentacion.Usuario.UsuarioModel;
import aerolinea.presentacion.avion.AvionController;
import aerolinea.presentacion.avion.AvionModel;
import aerolinea.presentacion.avion.AvionView;
import aerolinea.presentacion.añadirviaje.AñadirViajeModel;
import aerolinea.presentacion.ciudad.CiudadController;
import aerolinea.presentacion.ciudad.CiudadModel;
import aerolinea.presentacion.ciudad.CiudadView;
import aerolinea.presentacion.pago.PagoController;
import aerolinea.presentacion.pago.PagoModel;
import aerolinea.presentacion.pago.PagoView;
import aerolinea.presentacion.pais.PaisController;
import aerolinea.presentacion.pais.PaisModel;
import aerolinea.presentacion.pais.PaisView;
import aerolinea.presentacion.tipoavion.TipoAvionController;
import aerolinea.presentacion.tipoavion.TipoAvionModel;
import aerolinea.presentacion.tipoavion.TipoAvionView;
import aerolinea.presentacion.viaje.ViajeController;
import aerolinea.presentacion.viaje.ViajeModel;
import aerolinea.presentacion.viaje.ViajeView;
import aerolinea.presentacion.vuelo.VueloController;
import aerolinea.presentacion.vuelo.VueloModel;
import aerolinea.presentacion.vuelo.VueloView;
import java.awt.CardLayout;
import java.awt.Checkbox;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.text.ParseException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class VentanaPrincipalView extends javax.swing.JFrame implements Observer {

    VentanaPrincipalView main;
    PrincipalUserController Ucontroller;
    UsuarioModel Umodel;
    VentanaPrincipalModel model;
    VentanaPrincipalController controller;
    CardLayout windows;
    Container container;
    public static aerolinea.presentacion.tipoavion.TipoAvionController Controller_Admin;
    public static aerolinea.presentacion.avion.AvionController Controller_Avion;
    public static aerolinea.presentacion.pago.PagoController Controller_Pago;

    public VentanaPrincipalView() {
        initComponents();

        Umodel = new UsuarioModel();
        this.Ucontroller = new PrincipalUserController(Umodel, this);
        this.IAdministrar.setVisible(false);
        this.IComprar.setVisible(false);
        this.ICompras.setVisible(false);
        this.Iperfil.setVisible(false);
        this.ISalir.setVisible(false);

        windows = new CardLayout();
        container = this.getContentPane();
        container.setLayout(windows);

        TipoAvionModel tmodel = new TipoAvionModel();
        TipoAvionView tview = new TipoAvionView(this);
        TipoAvionController tcontroller = new TipoAvionController(tmodel, tview);
        Controller_Admin = tcontroller;

        AvionModel amodel = new AvionModel();
        AvionView aview = new AvionView(this);
        AvionController acontroller = new AvionController(amodel, aview);
        Controller_Avion = acontroller;

        PagoModel pmodel = new PagoModel();
        PagoView pview = new PagoView(this);
        PagoController pcontroller = new PagoController(pmodel, pview);
        Controller_Pago = pcontroller;

        PaisModel pamodel = new PaisModel();
        PaisView paview = new PaisView(this);
        PaisController pacontroller = new PaisController(pamodel, paview);

        CiudadModel cmodel = new CiudadModel();
        CiudadView cview = new CiudadView(this);
        CiudadController ccontroller = new CiudadController(cmodel, cview);

        VueloModel vmodel = new VueloModel();
        VueloView vview = new VueloView(this);
        VueloController vcontroller = new VueloController(vmodel, vview);

        ReservaModel rmodel = new ReservaModel();
        ReservaView rview = new ReservaView(this);
        ReservaController rcontroller = new ReservaController(rmodel, rview);

        ViajeModel vimodel = new ViajeModel();
        ViajeView viview = new ViajeView(this);
        ViajeController vicontroller = new ViajeController(vimodel, viview);

        this.addWindow(tview, "tipoavion");
        this.addWindow(aview, "avion");
        this.addWindow(pview, "pago");
        this.addWindow(paview, "Pais");
        this.addWindow(cview, "ciudad");
        this.addWindow(vview, "Vuelos");
        this.addWindow(rview, "reserva");
        this.addWindow(viview, "viaje");
        this.add(new Main(this), "Main");
        this.iniciarComponentes();
        this.swapWindow("Main");
    }

    public void iniciarComponentes() {
        this.setTitle("Proyecto_Programacion_3");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void setVisibleBlogin() {
        this.Blogin.setVisible(true);
    }

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

    public void swapWindow(String window) {
        windows.show(container, window);
    }

    public void addWindow(JPanel window, String name) {
        container.add(window);
        windows.addLayoutComponent(window, name);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        IAdministrar = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        IComprar = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        ICompras = new javax.swing.JMenu();
        jMenuItem14 = new javax.swing.JMenuItem();
        Iperfil = new javax.swing.JMenu();
        Pmodificar = new javax.swing.JMenuItem();
        Pver = new javax.swing.JMenuItem();
        Icuenta = new javax.swing.JMenu();
        Blogin = new javax.swing.JMenuItem();
        Bregistrarse = new javax.swing.JMenuItem();
        ISalir = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        MBienvenido = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(585, 435));
        getContentPane().setLayout(null);

        IAdministrar.setText("Administrar");

        jMenuItem1.setText("Tipo avion");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        IAdministrar.add(jMenuItem1);

        jMenuItem2.setText("Aviones");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        IAdministrar.add(jMenuItem2);

        jMenuItem3.setText("Ciudades");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        IAdministrar.add(jMenuItem3);

        jMenuItem4.setText("Paises");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        IAdministrar.add(jMenuItem4);

        jMenuItem5.setText("Metodos de Pago");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        IAdministrar.add(jMenuItem5);

        jMenuItem6.setText("Vuelos");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        IAdministrar.add(jMenuItem6);

        jMenuItem8.setText("Viajes");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        IAdministrar.add(jMenuItem8);

        jMenuBar1.add(IAdministrar);

        IComprar.setText("Consulta");

        jMenuItem13.setText("Viajes");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        IComprar.add(jMenuItem13);

        jMenuBar1.add(IComprar);

        ICompras.setText("Compras");

        jMenuItem14.setText("Compras");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        ICompras.add(jMenuItem14);

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

        jMenu1.setText("Informacion");

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem7.setText("About");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuBar1.add(jMenu1);
        jMenuBar1.add(MBienvenido);

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
                    if (Parse.Aprove(correo.getText(), Parse.CORREO)) {
                        if (this.Ucontroller.modifyUser(codigo.getText(), nombre.getText(), apellido.getText(), correo.getText(), numero.getText(), fnacimiento.getText(), direccion.getText(), password.getText())) {
                            JOptionPane.showMessageDialog(null, "Modificado!");
                            this.MBienvenido.setText("Bienvenido " + Umodel.getUser().toString());
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
                if (cb.getState() == true) {
                    password.setEchoChar((char) 0);
                    password.setText(password.getText());
                } else {
                    password.setEchoChar('*');
                    password.setText(password.getText());
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
                if (Parse.Aprove(codigo.getText(), Parse.CODIGOS)) {
                    if (this.Ucontroller.FindUser(codigo.getText()) == null) {
                        if (Parse.Aprove(password.getText(), Parse.CODIGOS)) {
                            if (Parse.Aprove(correo.getText(), Parse.CORREO)) {
                                try {
                                    Usuario user = new Usuario();
                                    user.setCodigo(codigo.getText());
                                    user.setNombre(nombre.getText());
                                    user.setApellido(apellido.getText());
                                    user.setCorreoE(correo.getText());
                                    user.setTelefono(numero.getText());
                                    user.setFnacimiento(fnacimiento.getText());
                                    user.setDireccion(direccion.getText());
                                    user.setPassword(password.getText());
                                    user.setTipo("C");
                                    this.Ucontroller.MakeUser(user);
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
        aerolinea.presentacion.Usuario.Login log = new aerolinea.presentacion.Usuario.Login();
        aerolinea.presentacion.Usuario.LoginController contr = new aerolinea.presentacion.Usuario.LoginController(Umodel, log);
        log.setAux(this);
        JDialog dialogo;
        dialogo = new JDialog(this, "Iniciar Sesion", true);
        dialogo.setResizable(false);
        JPanel userview = log;
        contr.setDial(dialogo);
        dialogo.getContentPane().add(log);
        dialogo.pack();
        dialogo.setSize(255, 195);
        dialogo.setLocationRelativeTo(this);
        dialogo.setVisible(true);
    }//GEN-LAST:event_BloginActionPerformed

    private void ISalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ISalirActionPerformed
        this.MBienvenido.setText("");
        this.Umodel.setUser(null);
        this.Bregistrarse.setVisible(true);
        this.Blogin.setVisible(true);
        this.ISalir.setVisible(false);
        this.IAdministrar.setVisible(false);
        this.IComprar.setVisible(false);
        this.ICompras.setVisible(false);
        this.Iperfil.setVisible(false);
        this.swapWindow("Main");
    }//GEN-LAST:event_ISalirActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.swapWindow("tipoavion");
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        this.swapWindow("avion");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        this.swapWindow("ciudad");
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        this.swapWindow("Pais");
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        this.swapWindow("pago");
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        this.swapWindow("Vuelos");
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        JOptionPane dialog = new JOptionPane();

        JLabel label = new JLabel("<html><center>Sistema de administracion, aerolinea.<br>" + "Programación III. Escuela de Informática. Universidad Nacional.<br>" + "Creado por Mario Arguello y Braslyn Rodriguez.</center></html>");

        Object[] options = {"Aceptar"};

        dialog.showOptionDialog(this, label, "Acerca de", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        this.swapWindow("reserva");
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        this.swapWindow("Tiquete");
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        this.swapWindow("viaje");
    }//GEN-LAST:event_jMenuItem8ActionPerformed

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
            case "A":
                this.IAdministrar.setVisible(true);
                break;
            case "C":
                this.IAdministrar.setVisible(false);
                break;
        }
        this.MBienvenido.setText("Bienvenido " + user.toString());
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
    private javax.swing.JMenu MBienvenido;
    private javax.swing.JMenuItem Pmodificar;
    private javax.swing.JMenuItem Pver;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    // End of variables declaration//GEN-END:variables
}
