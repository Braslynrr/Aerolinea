package aerolinea.presentacion.añadirvuelo;

import aerolinea.logic.Avion;
import aerolinea.logic.Ciudad;
import aerolinea.logic.Vuelo;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JSpinner;

public class AñadirVueloView extends javax.swing.JPanel implements Observer{

    AñadirVueloController controller;
    AñadirVueloModel model;
    
    public AñadirVueloView() {
        initComponents();
        modificar.setEnabled(false);
        añadir.setEnabled(false);
        
    }

    public void setController(AñadirVueloController controller) {
        this.controller = controller;
    }

    public void setModel(AñadirVueloModel model) {
        this.model = model;
        model.addObserver(this);
        DefaultComboBoxModel modeldia = new DefaultComboBoxModel(model.dias);
        diacombobox.setModel( modeldia); 
        
        DefaultComboBoxModel newmodel = new DefaultComboBoxModel(model.getListaAviones());
       avioncombo.setModel( newmodel ); 
       
       DefaultComboBoxModel newmodelc = new DefaultComboBoxModel(model.getListaCiudad());
       origenCombo.setModel( newmodelc ); 
       
       DefaultComboBoxModel newmodelc2 = new DefaultComboBoxModel(model.getListaCiudad());
       destinocombo.setModel( newmodelc2 ); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Title = new javax.swing.JLabel();
        año = new javax.swing.JLabel();
        modelo = new javax.swing.JLabel();
        marca = new javax.swing.JLabel();
        asientos = new javax.swing.JLabel();
        preciofield = new javax.swing.JTextField();
        añadir = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        filas = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        diacombobox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        origenCombo = new javax.swing.JComboBox<>();
        destinocombo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        avioncombo = new javax.swing.JComboBox<>();
        salidaspinner = new javax.swing.JSpinner()
        {
            @Override
            public void setEditor(JComponent editor)
            {
                super.setEditor(editor);
                this.fireStateChanged();
            }
        }
        ;
        duracionspinner = new javax.swing.JSpinner()
        {
            @Override
            public void setEditor(JComponent editor)
            {
                super.setEditor(editor);
                this.fireStateChanged();
            }
        }
        ;
        descuentofield = new javax.swing.JTextField();

        Title.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText("Añadir/modificar vuelos");

        año.setText("Duracion:");

        modelo.setText("Precio total:");

        marca.setText("Descuento:");

        asientos.setText("Ciudad de destino:");

        preciofield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preciofieldActionPerformed(evt);
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

        filas.setText("Ciudad de origen:");

        jLabel1.setText("Dia de salida:");

        diacombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Hora de salida");

        origenCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        destinocombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        destinocombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destinocomboActionPerformed(evt);
            }
        });

        jLabel4.setText("Avion:");

        avioncombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        salidaspinner.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.HOUR));
        JSpinner.DateEditor edicion = new JSpinner.DateEditor(salidaspinner, "HH:mm:ss");
        edicion.getFormat().setTimeZone(TimeZone.getTimeZone("UTC"));
        salidaspinner.setEditor(edicion);

        duracionspinner.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(941332500000L), null, null, java.util.Calendar.HOUR));
        JSpinner.DateEditor duracioneditor = new JSpinner.DateEditor(duracionspinner, "HH:mm:ss");
        duracioneditor.getFormat().setTimeZone(TimeZone.getTimeZone("UTC"));
        duracionspinner.setEditor(duracioneditor);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(añadir, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(modificar)
                        .addGap(97, 97, 97))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(Title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(modelo)
                            .addComponent(año)
                            .addComponent(filas))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(preciofield, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(diacombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(origenCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(marca)
                                    .addComponent(asientos))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(destinocombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(salidaspinner)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(descuentofield, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 10, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(avioncombo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(33, 33, 33)
                                        .addComponent(jLabel3))
                                    .addComponent(duracionspinner, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(diacombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(salidaspinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(año)
                            .addComponent(duracionspinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(preciofield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(marca)
                                    .addComponent(descuentofield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(modelo))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(Title)))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filas)
                    .addComponent(origenCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(asientos)
                    .addComponent(destinocombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(añadir)
                            .addComponent(modificar))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(avioncombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3))
                        .addContainerGap(64, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void añadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirActionPerformed

        Vuelo vuelo = new Vuelo();
//        vuelo.setIdentificador(null);
        vuelo.setDia("");
        vuelo.setSalida((Date) salidaspinner.getValue());
         vuelo.setDuracion((Date) duracionspinner.getValue());
        vuelo.setPrecio(Double.valueOf(preciofield.getText()));
        vuelo.setDescuento(BigDecimal.valueOf(Double.valueOf(descuentofield.getText())));
        vuelo.setOrigen((Ciudad) origenCombo.getSelectedItem());
        vuelo.setDestino((Ciudad) destinocombo.getSelectedItem());
        vuelo.setAvion((Avion) avioncombo.getSelectedItem());
        try {
            controller.Añadir(vuelo);
        } catch (Exception ex) {
            Logger.getLogger(AñadirVueloView.class.getName()).log(Level.SEVERE, null, ex);
        }
        controller.OcultarDialogo();

    }//GEN-LAST:event_añadirActionPerformed

    private void preciofieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preciofieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_preciofieldActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed

        Vuelo vuelo = new Vuelo();
        vuelo.setDia("");
        vuelo.setSalida((Date) salidaspinner.getValue());
         vuelo.setDuracion((Date) duracionspinner.getValue());
        vuelo.setPrecio(Double.valueOf(preciofield.getText()));
        vuelo.setDescuento(BigDecimal.valueOf(Double.valueOf(descuentofield.getText())));
        vuelo.setOrigen((Ciudad) origenCombo.getSelectedItem());
        vuelo.setDestino((Ciudad) destinocombo.getSelectedItem());
        vuelo.setAvion((Avion) avioncombo.getSelectedItem());
        try {
            controller.Modifcar(vuelo);
        } catch (Exception ex) {
            Logger.getLogger(AñadirVueloView.class.getName()).log(Level.SEVERE, null, ex);
        }
        controller.OcultarDialogo();
    }//GEN-LAST:event_modificarActionPerformed

    private void destinocomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destinocomboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_destinocomboActionPerformed

    @Override
    public void update(Observable o, Object arg) {
       
       
        
    }


    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Title;
    private javax.swing.JLabel asientos;
    public javax.swing.JComboBox<String> avioncombo;
    public javax.swing.JButton añadir;
    private javax.swing.JLabel año;
    public javax.swing.JTextField descuentofield;
    public javax.swing.JComboBox<String> destinocombo;
    private javax.swing.JComboBox<String> diacombobox;
    public javax.swing.JSpinner duracionspinner;
    private javax.swing.JLabel filas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel marca;
    private javax.swing.JLabel modelo;
    public javax.swing.JButton modificar;
    public javax.swing.JComboBox<String> origenCombo;
    public javax.swing.JTextField preciofield;
    public javax.swing.JSpinner salidaspinner;
    // End of variables declaration//GEN-END:variables
}
