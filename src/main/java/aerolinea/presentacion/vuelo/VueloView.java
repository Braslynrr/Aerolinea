
package aerolinea.presentacion.vuelo;

import aerolinea.data.VueloDao;
import aerolinea.presentacion.tipoavion.*;
import aerolinea.logic.Modelo;
import aerolinea.logic.TipoAvion;
import aerolinea.logic.Vuelo;
import aerolinea.presentacion.ventanaprincipal.VentanaPrincipalView;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class VueloView extends javax.swing.JPanel implements Observer {

    VueloController controller;
    VueloModel model;
    VentanaPrincipalView main;
    public JDialog dialogo;
     
    public VueloView(VentanaPrincipalView main) {
        initComponents();
        this.main = main;
        principaltable.setModel(new TableModelVuelo(Modelo.getInstance().GetAllVuelo()));
       
        dialogo = new JDialog(main," " ,true);
      
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labeltittle = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        principaltable = new javax.swing.JTable();
        añadir = new javax.swing.JButton();
        Eliminar = new javax.swing.JButton();
        searchfield = new javax.swing.JTextField();
        buscar = new javax.swing.JButton();
        origencombo = new javax.swing.JComboBox<>();
        destinocombo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        avioncombo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1280, 720));

        labeltittle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        labeltittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeltittle.setText("Administrar Vuelos");

        principaltable.setAutoCreateRowSorter(true);
        principaltable.setModel(new javax.swing.table.DefaultTableModel(
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
        principaltable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                principaltableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(principaltable);

        añadir.setText("Añadir");
        añadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirActionPerformed(evt);
            }
        });

        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });

        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        origencombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        origencombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                origencomboActionPerformed(evt);
            }
        });

        destinocombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Origen:");

        jLabel2.setText("Destino:");

        avioncombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Avion:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labeltittle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 791, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(añadir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(avioncombo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(origencombo, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(destinocombo, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(searchfield, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buscar))
                            .addComponent(jLabel2))
                        .addGap(29, 29, 29))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Eliminar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labeltittle, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(añadir)
                    .addComponent(searchfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscar)
                    .addComponent(origencombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(destinocombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(avioncombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Eliminar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void añadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirActionPerformed

       dialogo = new JDialog(main,"Añadir usuario",true);
       dialogo.setResizable(false);
       
       JPanel userview = controller.VenatanAñadir(0);
       
       dialogo.getContentPane().add(userview);
       dialogo.pack();
       dialogo.setLocationRelativeTo(main);
       dialogo.setVisible(true);

    }//GEN-LAST:event_añadirActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
            this.setTable();
            controller.updatecombos();
        avioncombo.setModel(new DefaultComboBoxModel(model.avion));
        origencombo.setModel(new DefaultComboBoxModel(model.origen));
        destinocombo.setModel(new DefaultComboBoxModel(model.destino));
    }//GEN-LAST:event_buscarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        Vuelo temp = model.tabletipo.getElement(principaltable.convertRowIndexToModel(principaltable.getSelectedRow()));
            try {
            controller.Eliminar(temp);
        } catch (Exception ex) {
//            Logger.getLogger(VueloView.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERROR: Alguna entidad necesita de este vuelo por lo que aun no puede ser eliminado.");
        }
    }//GEN-LAST:event_EliminarActionPerformed

    private void principaltableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_principaltableMouseClicked
        if (evt.getClickCount() == 2 )
       {
       dialogo = new JDialog(main,"Modificar",true);
       dialogo.setResizable(false);
       
       JPanel userview = controller.VenatanAñadir(1);
       
       dialogo.getContentPane().add(userview);
       dialogo.pack();
       dialogo.setLocationRelativeTo(main);
       dialogo.setVisible(true);
       }
    }//GEN-LAST:event_principaltableMouseClicked

    private void origencomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_origencomboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_origencomboActionPerformed

    
     public void setTable()
    {
        principaltable.setModel(controller.setTables());
    }
     
    public VueloController getController() {
        return controller;
    }

    public VueloModel getModel() {
        return model;
    }

    public void setController(VueloController controller) {
        this.controller = controller;
    }

    public void setModel(VueloModel model) {
        this.model = model;
        model.addObserver(this);
        avioncombo.setModel(new DefaultComboBoxModel(model.avion));
        origencombo.setModel(new DefaultComboBoxModel(model.origen));
        destinocombo.setModel(new DefaultComboBoxModel(model.destino));
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Eliminar;
    public javax.swing.JComboBox<String> avioncombo;
    public javax.swing.JButton añadir;
    public javax.swing.JButton buscar;
    public javax.swing.JComboBox<String> destinocombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labeltittle;
    public javax.swing.JComboBox<String> origencombo;
    public javax.swing.JTable principaltable;
    public javax.swing.JTextField searchfield;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
//        if (controller != null)
//        setTable();
        principaltable.setModel(new TableModelVuelo(Modelo.getInstance().GetAllVuelo()));
        if(controller != null)
            controller.updatecombos();
        avioncombo.setModel(new DefaultComboBoxModel(model.avion));
        origencombo.setModel(new DefaultComboBoxModel(model.origen));
        destinocombo.setModel(new DefaultComboBoxModel(model.destino));
//        controller.UpdateTable();

    }
}
