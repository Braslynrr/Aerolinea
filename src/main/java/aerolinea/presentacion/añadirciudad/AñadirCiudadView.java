package aerolinea.presentacion.añadirciudad;

import aerolinea.logic.Ciudad;
import aerolinea.logic.Pais;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class AñadirCiudadView extends javax.swing.JPanel implements Observer{

    AñadirCiudadController controller;
    AñadirCiudadModel model;
    
    public AñadirCiudadView() {
        initComponents();
        modificar.setEnabled(false);
        añadir.setEnabled(false);
    }

    public void setController(AñadirCiudadController controller) {
        this.controller = controller;
    }

    public void setModel(AñadirCiudadModel model) {
        this.model = model;
        model.addObserver(this);
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
        pais = new javax.swing.JLabel();
        paisescombobox = new javax.swing.JComboBox<>();

        Title.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText("Añadir/modificar Ciudades");

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

        pais.setText("Pais:");

        paisescombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Title, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nombre)
                                    .addComponent(codigo)
                                    .addComponent(pais))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(codigofield, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(paisescombobox, 0, 142, Short.MAX_VALUE)
                                    .addComponent(nombrefield)))))
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pais)
                    .addComponent(paisescombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(añadir)
                    .addComponent(modificar))
                .addGap(19, 19, 19))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void añadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirActionPerformed

        Ciudad object = new Ciudad();
        if(!codigofield.getText().isEmpty())
            object.setCodigo(codigofield.getText());
        if(!nombrefield.getText().isEmpty())
            object.setNombre(nombrefield.getText());
        object.setPais((Pais) paisescombobox.getSelectedItem());
        
        try {
            controller.Añadir(object);
            controller.OcultarDialogo();
        } catch (Exception ex) {
//            Logger.getLogger(AñadirCiudadView.class.getName()).log(Level.SEVERE, null, ex);
              JOptionPane.showMessageDialog(null, "ERROR: Asegurese de haber llenado todos los espacios necesarios. O que la llave priamria no este repetida.");
        }
    }//GEN-LAST:event_añadirActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
      Ciudad object = new Ciudad();
        object.setCodigo(codigofield.getText());
        if(!nombrefield.getText().isEmpty())
            object.setNombre(nombrefield.getText());
        object.setPais((Pais) paisescombobox.getSelectedItem());
        
        try {
            controller.Modifcar(object);
            controller.OcultarDialogo();
        } catch (Exception ex) {
//          Logger.getLogger(AñadirCiudadView.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERROR: Asegurese de haber llenado todos los espacios necesarios.");
        }
        
    }//GEN-LAST:event_modificarActionPerformed

    @Override
    public void update(Observable o, Object arg) {
       DefaultComboBoxModel newmodel = new DefaultComboBoxModel(model.getLista());
       paisescombobox.setModel( newmodel ); 
    }

    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Title;
    public javax.swing.JButton añadir;
    private javax.swing.JLabel codigo;
    public javax.swing.JTextField codigofield;
    public javax.swing.JButton modificar;
    private javax.swing.JLabel nombre;
    public javax.swing.JTextField nombrefield;
    private javax.swing.JLabel pais;
    public javax.swing.JComboBox<String> paisescombobox;
    // End of variables declaration//GEN-END:variables
}
