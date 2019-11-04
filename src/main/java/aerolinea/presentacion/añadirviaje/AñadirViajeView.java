package aerolinea.presentacion.añadirviaje;

import aerolinea.logic.TipoAvion;
import aerolinea.logic.Viaje;
import aerolinea.logic.Vuelo;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;

public class AñadirViajeView extends javax.swing.JPanel implements Observer{

    AñadirViajeController controller;
    AñadirViajeModel model;
    
    public AñadirViajeView() {
        initComponents();
        modificar.setEnabled(false);
        añadir.setEnabled(false);
    }

    public void setController(AñadirViajeController controller) {
        this.controller = controller;
    }

    public void setModel(AñadirViajeModel model) {
        this.model = model;

        
       DefaultComboBoxModel newmodel = new DefaultComboBoxModel(model.getListaIda());
        idacombo.setModel( newmodel ); 
       
       DefaultComboBoxModel newmodelc = new DefaultComboBoxModel(model.getListaRegreso());
       regresocombo.setModel( newmodelc ); 
       
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Title = new javax.swing.JLabel();
        identificador = new javax.swing.JLabel();
        año = new javax.swing.JLabel();
        modelo = new javax.swing.JLabel();
        marca = new javax.swing.JLabel();
        añadir = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
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
        idacombo = new javax.swing.JComboBox<>();
        regresocombo = new javax.swing.JComboBox<>();
        regresospinner = new javax.swing.JSpinner()
        {
            @Override
            public void setEditor(JComponent editor)
            {
                super.setEditor(editor);
                this.fireStateChanged();
            }
        }

        ;
        jLabel1 = new javax.swing.JLabel();
        idenfield = new javax.swing.JTextField();

        Title.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText("Añadir/modificar vuelos programados");

        identificador.setText("Identificador:");

        año.setText("Fecha de salida:");

        modelo.setText("Vuelo de ida:");

        marca.setText("Fecha de regreso:");

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

        salidaspinner.setModel(new javax.swing.SpinnerDateModel());
        JSpinner.DateEditor salida = new JSpinner.DateEditor(salidaspinner, "EEEE yyyy-MM-dd");
        salida.getFormat().setTimeZone(TimeZone.getTimeZone("UTC"));
        salidaspinner.setEditor(salida);

        idacombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        regresocombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        regresospinner.setModel(new javax.swing.SpinnerDateModel());
        JSpinner.DateEditor regreso = new JSpinner.DateEditor(regresospinner, "EEEE yyyy-MM-dd");
        regreso.getFormat().setTimeZone(TimeZone.getTimeZone("UTC"));
        regresospinner.setEditor(regreso);

        jLabel1.setText("Viaje de regreso:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(identificador)
                            .addComponent(año)
                            .addComponent(marca)
                            .addComponent(modelo)
                            .addComponent(jLabel1))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(idenfield, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(regresocombo, 0, 140, Short.MAX_VALUE)
                            .addComponent(idacombo, 0, 140, Short.MAX_VALUE)
                            .addComponent(salidaspinner)
                            .addComponent(regresospinner))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
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
                    .addComponent(añadir)
                    .addComponent(idenfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(año)
                    .addComponent(salidaspinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(modelo)
                    .addComponent(idacombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(modificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(marca)
                    .addComponent(regresospinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(regresocombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void añadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirActionPerformed

        Viaje viaje = new Viaje();
        if(!idenfield.getText().isEmpty())
            viaje.setCodigo(idenfield.getText());
        if (regresocombo.getSelectedIndex() != 0 )
        {
            viaje.setDregreso((Date) regresospinner.getValue());
            viaje.setRegreso((Vuelo) regresocombo.getSelectedItem());
        }
        else
        {
            viaje.setDregreso(null);
            viaje.setRegreso(null);
        }
        viaje.setDsalida((Date) salidaspinner.getValue());
        viaje.setIda((Vuelo) idacombo.getSelectedItem());


        
        try {
            controller.Añadir(viaje);
            controller.OcultarDialogo();
        } catch (Exception ex) {
//            Logger.getLogger(AñadirViajeView.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERROR: Asegurese de insertar un codigo valido.");
        }
       

    }//GEN-LAST:event_añadirActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
      Viaje viaje = new Viaje();
        viaje.setCodigo(idenfield.getText());
        viaje.setDsalida((Date) salidaspinner.getValue());      
        viaje.setIda((Vuelo) idacombo.getSelectedItem());

        if (regresocombo.getSelectedIndex() != 0 )
        {
            viaje.setDregreso((Date) regresospinner.getValue());
            viaje.setRegreso((Vuelo) regresocombo.getSelectedItem());
        }
        else
        {
            viaje.setDregreso(null);
            viaje.setRegreso(null);
        }
        
        try {
            controller.Modifcar(viaje);
            controller.OcultarDialogo();
        } catch (Exception ex) {
            Logger.getLogger(AñadirViajeView.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_modificarActionPerformed

    @Override
    public void update(Observable o, Object arg) {
       
        
    }


    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Title;
    public javax.swing.JButton añadir;
    private javax.swing.JLabel año;
    public javax.swing.JComboBox<String> idacombo;
    public javax.swing.JTextField idenfield;
    private javax.swing.JLabel identificador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel marca;
    private javax.swing.JLabel modelo;
    public javax.swing.JButton modificar;
    public javax.swing.JComboBox<String> regresocombo;
    public javax.swing.JSpinner regresospinner;
    public javax.swing.JSpinner salidaspinner;
    // End of variables declaration//GEN-END:variables
}
