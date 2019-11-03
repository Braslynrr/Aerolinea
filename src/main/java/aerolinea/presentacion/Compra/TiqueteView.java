/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.Compra;

import aerolinea.data.Parse;
import aerolinea.logic.Usuario;
import aerolinea.logic.Viaje;
import aerolinea.presentacion.ventanaprincipal.VentanaPrincipalView;
import com.mysql.cj.util.StringUtils;
import java.awt.Color;
import java.awt.MenuComponent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Admin2
 */
public class TiqueteView extends javax.swing.JPanel implements Observer {

    int TicketsTotales = 0;
    TiquetesController controller;
    VentanaPrincipalView main;
    TiquetesModel model;
    int[] fila;
    int[] asiento;
    List<String> metodo;
    List<String> nombre;

    public TiquetesModel getModel() {
        return model;
    }

    public void setModel(TiquetesModel model) {
        this.model = model;
        searchcombo.setModel(new DefaultComboBoxModel(model.combotipos));
    }
    Viaje viaje;
    Boolean bviaje;
    Object[] blist;

    public TiquetesController getController() {
        return controller;
    }

    public void setController(TiquetesController controller) {
        this.controller = controller;
        this.Cantickets();
    }

    public TiqueteView(VentanaPrincipalView main, Viaje viaje) {
        initComponents();
        this.main = main;
        this.viaje = viaje;
        bviaje = true;
        this.LabelPrecio.setText("Precio por asiento : " + viaje.getIda().getPrecio());
        if (viaje.getRegreso() == null) {
        } else {
            viaje.getReservaList();
            this.LabelPrecio.setText("Precio por asiento : " + viaje.getIda().getPrecio() + " y " + viaje.getRegreso().getPrecio());
        }
    }

    public void Cantickets() {
        JTextField ticks = new JTextField();
        Object[] files = {
            "Digite la cantidad de tickets que desea comprar ", ticks
        };
        if (JOptionPane.showConfirmDialog(null, files, "Cantidad de tiquetes", JOptionPane.OK_CANCEL_OPTION) == 0) {
            if (StringUtils.isStrictlyNumeric(ticks.getText()) == true) {
                this.TicketsTotales = Integer.parseInt(ticks.getText());
                if (this.TicketsTotales > 0) {
                    this.actualizarCampos();
                    this.Btickets.setVisible(false);
                    this.Bcomprar.setVisible(true);
                    fila = new int[this.TicketsTotales];
                    nombre = new ArrayList();
                    asiento = new int[this.TicketsTotales];
                    metodo = new ArrayList();
                } else {
                    this.Bcomprar.setVisible(false);
                }
            } else {
                this.Bcomprar.setVisible(false);
            }
        } else {
            this.Bcomprar.setVisible(false);
        }
    }

    public void actualizarCampos() {

        int x = this.Lavioncalculo.getX(), y = this.Lavioncalculo.getY();
        int Gw = 0, Gh = 0;
        int fil = 0, asin = 0;
        if (bviaje == true) {
            fil = viaje.getIda().getAvion().getTipoA().getFilas();
            asin = viaje.getIda().getAvion().getTipoA().getAsientos();
            Gw = this.Lavioncalculo.getWidth() / fil;
            Gh = this.Lavioncalculo.getHeight() / asin;
        } else {
            fil = viaje.getRegreso().getAvion().getTipoA().getFilas();
            asin = viaje.getRegreso().getAvion().getTipoA().getAsientos();
            Gw = this.Lavioncalculo.getWidth() / fil;
            Gh = this.Lavioncalculo.getHeight() / asin;
        }
        controller.ChargeTickets(viaje.getCodigo());
        int tam = fil * asin;
        blist = new Object[tam];
        tam = 0;
        JButton boton;
        for (int i = 0; i < fil; i++) {
            for (int j = 0; j < asin; j++) {
                boton = new JButton();
                int F = i + 1, A = j + 1;
                boton.setText(F + "-" + A);
                this.add(boton);
                boton.setSize(Gw, Gh);
                boton.setLocation(x + (Gw) * i, y + (Gh) * j);
                try {
                    if (controller.getTicket(F, A) == true) {
                        boton.setBackground(Color.red);
                        boton.setEnabled(false);
                    } else {
                        boton.setBackground(Color.GREEN);
                        boton.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent evt) {
                                JButton p = (JButton) evt.getComponent();
                                int[] par = getPoint(p.getText());
                                ComprarTiquete(par[0], par[1], main.getUModel().getUser(), p);
                            }
                        });
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                blist[tam++] = boton;
                this.setComponentZOrder(boton, 0);
            }

        }

    }

    public void limpiaAvion() {
        int max = viaje.getIda().getAvion().getTipoA().getFilas() * viaje.getIda().getAvion().getTipoA().getAsientos();
        for (int i = 0; i < max; i++) {
            this.remove((JButton) blist[i]);
            blist[i] = null;
        }
        this.repaint();
        blist = null;
    }

    public int[] getPoint(String point) {
        int[] par = new int[2];
        par[0] = 0;
        par[1] = 0;
        String aux = "";
        for (int i = 0; i < point.length() + 1; i++) {
            if (point.length() <= i) {
                par[1] = Integer.parseInt(aux);
                break;
            }
            if (point.charAt(i) != '-') {
                aux += point.charAt(i);
            } else {
                if (par[0] != 0) {
                    par[1] = Integer.parseInt(aux);
                } else {
                    par[0] = Integer.parseInt(aux);
                }
                aux = "";
            }
        }
        return par;
    }

    public void ComprarTiquete(int fila, int asiento, Usuario user, JButton btn) {
        if(this.nombre.size()==this.TicketsTotales){
            JOptionPane.showMessageDialog(null, "Numero propuesto de tickets alcanzado");
        }else{
        JTextField name = new JTextField();
        Object[] files = {
            "Digite el nombre ", name
        };
        if (JOptionPane.showConfirmDialog(null, files, "Nombre", JOptionPane.OK_CANCEL_OPTION) == 0) {
            if (Parse.Aprove(name.getText(), Parse.NOMBRES)) {
                btn.setEnabled(false);
                String metodo = (String) this.searchcombo.getSelectedItem();
                btn.removeAll();
                //se asigna el campo
                int index=this.nombre.size();
                this.fila[index]=fila;
                this.asiento[index]=asiento;
                this.metodo.add(metodo);
                this.nombre.add(name.getText());
                JOptionPane.showMessageDialog(null, "Asignado");
                if(this.nombre.size()==this.TicketsTotales){
                 this.Bcomprar.setVisible(true);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Nombre invalido");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Cancelado");
        }
        files=null;
        }

    }

    public void CompraTotal() {
        if (this.nombre.size() == this.TicketsTotales) {
            try {
                for (int i = 0; i < this.TicketsTotales; i++) {
                    controller.BuyTiquete(fila[i], asiento[i], metodo.get(i), nombre.get(i), viaje, main.getUModel().getUser());
                }
                JOptionPane.showMessageDialog(null, "Comprados");
                this.controller.HideDialog();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Fallo " + ex.getMessage());
            }

        } else {
            int def = this.TicketsTotales - fila.length;
            JOptionPane.showMessageDialog(null, "Faltan " + def + " tiquetes por comprar");
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        LabelPrecio = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Lavioncalculo = new javax.swing.JLabel();
        searchcombo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Btickets = new javax.swing.JButton();
        Bcomprar = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(982, 550));
        setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Comprar Asientos");
        add(jLabel2);
        jLabel2.setBounds(90, 10, 300, 70);

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(690, 500, 90, 30);

        LabelPrecio.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        LabelPrecio.setText("Precio por asiento : ");
        add(LabelPrecio);
        LabelPrecio.setBounds(30, 70, 310, 30);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Total a Pagar: ");
        add(jLabel3);
        jLabel3.setBounds(30, 110, 320, 21);
        add(Lavioncalculo);
        Lavioncalculo.setBounds(140, 260, 390, 100);

        searchcombo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        searchcombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(searchcombo);
        searchcombo.setBounds(680, 80, 230, 27);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Metodo de Pago");
        add(jLabel6);
        jLabel6.setBounds(510, 80, 150, 20);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Avion.png"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(30, 100, 610, 430);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Para comprar Ticket Click en un asiento!");
        add(jLabel4);
        jLabel4.setBounds(10, 504, 270, 30);

        Btickets.setText("Dar cantidad de Tickets");
        Btickets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BticketsActionPerformed(evt);
            }
        });
        add(Btickets);
        Btickets.setBounds(550, 20, 280, 30);

        Bcomprar.setText("Comprar");
        add(Bcomprar);
        Bcomprar.setBounds(790, 500, 90, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        controller.HideDialog();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void BticketsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BticketsActionPerformed
        this.Cantickets();
    }//GEN-LAST:event_BticketsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bcomprar;
    private javax.swing.JButton Btickets;
    private javax.swing.JLabel LabelPrecio;
    private javax.swing.JLabel Lavioncalculo;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JComboBox<String> searchcombo;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable arg0, Object arg1) {

    }
}
