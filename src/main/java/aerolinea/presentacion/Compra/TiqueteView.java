/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.Compra;

import aerolinea.logic.Usuario;
import aerolinea.presentacion.ventanaprincipal.VentanaPrincipalView;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin2
 */
public class TiqueteView extends javax.swing.JPanel implements Observer {

    TiquetesController controller;
    VentanaPrincipalView main;

    public TiquetesController getController() {
        return controller;
    }

    public void setController(TiquetesController controller) {
        this.controller = controller;
    }

    public TiqueteView(VentanaPrincipalView main) {
        initComponents();
        Boolean xs = true;
        this.main = main;
        int x = this.Lavioncalculo.getX(), y = this.Lavioncalculo.getY();
        int Gw = this.Lavioncalculo.getWidth() / 20, Gh = this.Lavioncalculo.getHeight() / 8;
        JButton boton;
        int count;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 8; j++) {
                boton = new JButton();
                int F=i+1,A=j+1;
                boton.setText( F+ "-" +A );
                this.add(boton);
                boton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent evt) {
                        JButton p = (JButton) evt.getComponent();
                       int[] par = getPoint(p.getText());
                        ComprarTiquete(par[0],par[1], null);
                    }
                });
                boton.setSize(Gw, Gh);
                boton.setLocation(x + (Gw) * i, y + (Gh) * j);
                if (xs == true) {
                    boton.setBackground(Color.red);
                    xs = false;
                } else {
                    boton.setBackground(Color.GREEN);
                    xs = true;
                }
                this.setComponentZOrder(boton, 0);

            }

        }

    }

    public int[] getPoint(String point) {
        int[] par = new int[2];
        par[0] = 0;
        par[1] = 0;
        String aux = "";
        for (int i = 0; i < point.length()+1; i++) {
            if(point.length()<=i){
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
        System.out.println(fila + "-" + asiento);
        JOptionPane.showMessageDialog(null, "Se compra->" + fila + "-" + asiento);
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Lavioncalculo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Comprar Asientos");
        add(jLabel2);
        jLabel2.setBounds(90, 10, 300, 70);

        jButton1.setText("Comprar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(690, 650, 110, 30);

        jButton2.setText("Cancelar");
        add(jButton2);
        jButton2.setBounds(820, 650, 100, 30);
        add(jTextField1);
        jTextField1.setBounds(670, 30, 240, 30);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Nombre de la Persona");
        add(jLabel3);
        jLabel3.setBounds(490, 30, 180, 30);

        jLabel4.setText("Precio por asiento : ");
        add(jLabel4);
        jLabel4.setBounds(30, 80, 310, 30);
        add(Lavioncalculo);
        Lavioncalculo.setBounds(290, 360, 390, 100);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Avion.png"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(10, 210, 970, 400);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Lavioncalculo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable arg0, Object arg1) {

    }
}
