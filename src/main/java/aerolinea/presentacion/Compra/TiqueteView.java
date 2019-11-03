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
import java.awt.Color;
import java.awt.MenuComponent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin2
 */
public class TiqueteView extends javax.swing.JPanel implements Observer {

    TiquetesController controller;
    VentanaPrincipalView main;
    TiquetesModel model;

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
        this.actualizarCampos();
    }

    public TiqueteView(VentanaPrincipalView main, Viaje viaje) {
        initComponents();
        this.main = main;
        this.viaje = viaje;
        bviaje = true;
        this.LabelPrecio.setText("Precio por asiento : "+viaje.getIda().getPrecio());
        if (viaje.getRegreso() == null) {
            Bviaje2.setEnabled(false);
        } else {
            Bviaje2.setEnabled(true);
            viaje.getReservaList();
            this.LabelPrecio.setText("Precio por asiento : "+viaje.getIda().getPrecio()+" y "+viaje.getRegreso().getPrecio());
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
        tam=0;
        JButton boton;
        for (int i = 0; i < fil; i++) {
            for (int j = 0; j < asin; j++) {
                boton = new JButton();
                int F = i + 1, A = j + 1;
                boton.setText(F + "-" + A);
                this.add(boton);
                boton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent evt) {
                        JButton p = (JButton) evt.getComponent();
                        int[] par = getPoint(p.getText());
                        ComprarTiquete(par[0], par[1], null);
                    }
                });
                boton.setSize(Gw, Gh);
                boton.setLocation(x + (Gw) * i, y + (Gh) * j);
                try {
                    if (controller.getTicket(F, A) == true) {
                        boton.setBackground(Color.red);
                        boton.setEnabled(false);
                    } else {
                        boton.setBackground(Color.GREEN);
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                blist[tam++] = boton;
                this.setComponentZOrder(boton, 0);
            }

        }

    }
    
    public void limpiaAvion(){
        int max= viaje.getIda().getAvion().getTipoA().getFilas() *  viaje.getIda().getAvion().getTipoA().getAsientos();
        for(int i=0 ; i<max;i++){
            this.remove((JButton) blist[i]);
            blist[i]=null;
        }
        this.repaint();
        blist=null;
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

    public void ComprarTiquete(int fila, int asiento, Usuario user) {
        if(Parse.Aprove(this.jTextField1.getText(), Parse.PALABRAS)){
            
            
        }else{
            JOptionPane.showMessageDialog(null,"Nombre invalido");
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
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        LabelPrecio = new javax.swing.JLabel();
        Lavioncalculo = new javax.swing.JLabel();
        Bviaje1 = new javax.swing.JButton();
        Bviaje2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        searchcombo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(982, 550));
        setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Comprar Asientos");
        add(jLabel2);
        jLabel2.setBounds(90, 10, 300, 70);

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(870, 510, 100, 30);
        add(jTextField1);
        jTextField1.setBounds(670, 30, 240, 30);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Nombre de la Persona");
        add(jLabel3);
        jLabel3.setBounds(490, 30, 180, 30);

        LabelPrecio.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        LabelPrecio.setText("Precio por asiento : ");
        add(LabelPrecio);
        LabelPrecio.setBounds(30, 70, 310, 30);
        add(Lavioncalculo);
        Lavioncalculo.setBounds(140, 280, 390, 100);

        Bviaje1.setText("Viaje 1");
        Bviaje1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bviaje1ActionPerformed(evt);
            }
        });
        add(Bviaje1);
        Bviaje1.setBounds(710, 250, 170, 50);

        Bviaje2.setText("Viaje 2");
        Bviaje2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bviaje2ActionPerformed(evt);
            }
        });
        add(Bviaje2);
        Bviaje2.setBounds(710, 340, 170, 50);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Vuelos del viaje");
        add(jLabel5);
        jLabel5.setBounds(720, 190, 180, 30);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Avion.png"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(20, 120, 610, 430);

        searchcombo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        searchcombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(searchcombo);
        searchcombo.setBounds(680, 80, 230, 27);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Metodo de Pago");
        add(jLabel6);
        jLabel6.setBounds(510, 80, 150, 20);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void Bviaje1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bviaje1ActionPerformed
        this.limpiaAvion();
        bviaje=true;
        this.actualizarCampos();
    }//GEN-LAST:event_Bviaje1ActionPerformed

    private void Bviaje2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bviaje2ActionPerformed
        this.limpiaAvion();
        bviaje=true;
        this.actualizarCampos();
    }//GEN-LAST:event_Bviaje2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bviaje1;
    private javax.swing.JButton Bviaje2;
    private javax.swing.JLabel LabelPrecio;
    private javax.swing.JLabel Lavioncalculo;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JComboBox<String> searchcombo;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable arg0, Object arg1) {

    }
}
