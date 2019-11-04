package aerolinea.presentacion.añadirpais;

import aerolinea.logic.Pais;
import aerolinea.presentacion.añadirtipoavion.*;
import aerolinea.logic.TipoAvion;
import aerolinea.presentacion.pais.PaisController;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AñadirPaisView extends javax.swing.JPanel implements Observer{

    AñadirPaisController controller;
    AñadirPaisAModel model;
    
    
    public AñadirPaisView() {
        initComponents();
        modificar.setEnabled(false);
        añadir.setEnabled(false);
    }

    public void setController(AñadirPaisController controller) {
        this.controller = controller;
    }

    public void setModel(AñadirPaisAModel model) {
        this.model = model;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Title = new javax.swing.JLabel();
        codigo = new javax.swing.JLabel();
        nombre = new javax.swing.JLabel();
        codigofield = new javax.swing.JTextField();
        nombrefield = new javax.swing.JTextField();
        añadir = new javax.swing.JButton();
        modificar = new javax.swing.JButton();

        Title.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText("Añadir/modificar Paises");

        codigo.setText("Codigo:");

        nombre.setText("Nombre:");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Title, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nombre)
                                    .addComponent(codigo))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(nombrefield, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(codigofield, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(añadir, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(modificar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(Title)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigo)
                    .addComponent(codigofield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre)
                    .addComponent(nombrefield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(añadir)
                    .addComponent(modificar))
                .addGap(19, 19, 19))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void añadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirActionPerformed

        Pais object = new Pais();
        
        if (!codigofield.getText().isEmpty())
        {
            object.setCodigo(codigofield.getText());
        }      
        if (!nombrefield.getText().isEmpty())
        {
            object.setNombre(nombrefield.getText());
        }
        
         
        
        try {
            controller.Añadir(object);
            controller.OcultarDialogo();
        } catch (Exception ex) {
//            Logger.getLogger(AñadirPaisView.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(null, "ERROR: Asegurese de haber llenado todos los espacios necesarios. O asegurese de que el codigo no sea repetido. ");
        } 
     
        
    }//GEN-LAST:event_añadirActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
      Pais object = new Pais();
        if (!codigofield.getText().isEmpty())
        {
            object.setCodigo(codigofield.getText());
        }      
        if (!nombrefield.getText().isEmpty())
        {
            object.setNombre(nombrefield.getText());
        }
        
        try {
            controller.Modifcar(object);
            controller.OcultarDialogo();
        } catch (Exception ex) {
//            Logger.getLogger(AñadirPaisView.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERROR: Asegurese de haber llenado todos los espacios necesarios.");
               
                        
        }
        
    }//GEN-LAST:event_modificarActionPerformed

    @Override
    public void update(Observable o, Object arg) {
       
        
    }


    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Title;
    public javax.swing.JButton añadir;
    private javax.swing.JLabel codigo;
    public javax.swing.JTextField codigofield;
    public javax.swing.JButton modificar;
    private javax.swing.JLabel nombre;
    public javax.swing.JTextField nombrefield;
    // End of variables declaration//GEN-END:variables
}
