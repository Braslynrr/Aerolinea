/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.Reserva;

import aerolinea.logic.Modelo;
import aerolinea.presentacion.ventanaprincipal.VentanaPrincipalView;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 *
 * @author Admin2
 */
public class ReservaView extends javax.swing.JPanel implements Observer {

    ReservaController controller;
    ReservaModel model;
    VentanaPrincipalView main;
    public JDialog dialogo;
    
    public ReservaController getController() {
        return controller;
    }

    public void setController(ReservaController controller) {
        this.controller = controller;
    }

    public ReservaView(VentanaPrincipalView main) {
        initComponents();
        this.main = main;
        this.TablaReserva.setModel(new TableModelReserva(Modelo.getInstance().SearchReserva(main.getUModel().getUser().getCodigo(), 0)));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TablaReserva = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        TablaReserva.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TablaReserva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaReservaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaReserva);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Reservas");

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(390, 390, 390)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 3, 3))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    this.controller.ocultardilog();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void TablaReservaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaReservaMouseClicked
      if(evt.getClickCount()==2){
          
          
      }
    }//GEN-LAST:event_TablaReservaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaReserva;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable arg0, Object arg1) {
        if (controller != null) {
           this.TablaReserva.setModel(new TableModelReserva(Modelo.getInstance().GetAllReserva()));
        }
    }

    public ReservaModel getModel() {
        return model;
    }

    
    public void updateTable(){
        this.TablaReserva.setModel(new TableModelReserva(Modelo.getInstance().SearchReserva(main.getUModel().getUser().getCodigo(),0)));
    }
    public void setModel(ReservaModel model) {
        this.model = model;
        model.addObserver(this);
    }
}



