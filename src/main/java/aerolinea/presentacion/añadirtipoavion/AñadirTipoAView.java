package aerolinea.presentacion.añadirtipoavion;

import aerolinea.logic.Avion;
import aerolinea.logic.TipoAvion;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AñadirTipoAView extends javax.swing.JPanel implements Observer{

    AñadirTipoAController controller;
    AñadirTipoAModel model;
    
    public AñadirTipoAView() {
        initComponents();
        modificar.setEnabled(false);
        añadir.setEnabled(false);
    }

    public void setController(AñadirTipoAController controller) {
        this.controller = controller;
    }

    public void setModel(AñadirTipoAModel model) {
        this.model = model;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Title = new javax.swing.JLabel();
        identificador = new javax.swing.JLabel();
        año = new javax.swing.JLabel();
        modelo = new javax.swing.JLabel();
        marca = new javax.swing.JLabel();
        asientos = new javax.swing.JLabel();
        idenfield = new javax.swing.JTextField();
        añofield = new javax.swing.JTextField();
        modelofield = new javax.swing.JTextField();
        marcafield = new javax.swing.JTextField();
        añadir = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        filas = new javax.swing.JLabel();
        filasspinner = new javax.swing.JSpinner();
        asientosspinner = new javax.swing.JSpinner();

        Title.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText("Añadir/modificar tipos de avion");

        identificador.setText("Identificador:");

        año.setText("Año:");

        modelo.setText("Modelo:");

        marca.setText("Marca:");

        asientos.setText("Asientos por fila:");

        modelofield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modelofieldActionPerformed(evt);
            }
        });

        marcafield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marcafieldActionPerformed(evt);
            }
        });

        añadir.setText("Añadir");
        añadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirActionPerformed(evt);
            }
        });

        modificar.setText("Modificar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        filas.setText("Filas:");

        filasspinner.setModel(new javax.swing.SpinnerNumberModel(5, 5, 15, 1));

        asientosspinner.setModel(new javax.swing.SpinnerNumberModel(4, 4, 6, 1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(asientos)
                            .addComponent(identificador)
                            .addComponent(año)
                            .addComponent(modelo)
                            .addComponent(marca))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(asientosspinner, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(filas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(filasspinner))
                            .addComponent(modelofield)
                            .addComponent(marcafield)
                            .addComponent(añofield)
                            .addComponent(idenfield))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(modificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(añadir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(35, 35, 35)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(Title)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(identificador)
                    .addComponent(idenfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(añadir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(año)
                    .addComponent(añofield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modelo)
                    .addComponent(modelofield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(marca)
                    .addComponent(marcafield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modificar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(asientos)
                    .addComponent(filas)
                    .addComponent(asientosspinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filasspinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void añadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirActionPerformed

        TipoAvion tipoavion = new TipoAvion();
        tipoavion.setAño(añofield.getText());
        tipoavion.setModelo(modelofield.getText());
        tipoavion.setIdentificador(idenfield.getText());
        tipoavion.setMarca(marcafield.getText());
        tipoavion.setFilas((Integer)filasspinner.getValue());
        tipoavion.setAsientos((Integer)asientosspinner.getValue());
        try {
            controller.Añadir(tipoavion);
        } catch (Exception ex) {
            Logger.getLogger(AñadirTipoAView.class.getName()).log(Level.SEVERE, null, ex);
        }
        controller.OcultarDialogo();

    }//GEN-LAST:event_añadirActionPerformed

    private void modelofieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modelofieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modelofieldActionPerformed

    private void marcafieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marcafieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_marcafieldActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
      TipoAvion object = new TipoAvion();
        object.setIdentificador(idenfield.getText());
        object.setMarca(marcafield.getText());
        object.setModelo(modelofield.getText());
        object.setAño(añofield.getText());
        object.setAsientos((Integer)asientosspinner.getValue());
        object.setFilas((Integer)filasspinner.getValue());
        
        try {
            controller.Modifcar(object);
        } catch (Exception ex) {
            Logger.getLogger(AñadirTipoAView.class.getName()).log(Level.SEVERE, null, ex);
        }
        controller.OcultarDialogo();
    }//GEN-LAST:event_modificarActionPerformed

    @Override
    public void update(Observable o, Object arg) {
       
        
    }


    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Title;
    private javax.swing.JLabel asientos;
    public javax.swing.JSpinner asientosspinner;
    public javax.swing.JButton añadir;
    private javax.swing.JLabel año;
    public javax.swing.JTextField añofield;
    private javax.swing.JLabel filas;
    public javax.swing.JSpinner filasspinner;
    public javax.swing.JTextField idenfield;
    private javax.swing.JLabel identificador;
    private javax.swing.JLabel marca;
    public javax.swing.JTextField marcafield;
    private javax.swing.JLabel modelo;
    public javax.swing.JTextField modelofield;
    public javax.swing.JButton modificar;
    // End of variables declaration//GEN-END:variables
}
