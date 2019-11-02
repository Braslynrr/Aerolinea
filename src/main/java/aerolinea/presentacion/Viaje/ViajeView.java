
package aerolinea.presentacion.viaje;
import aerolinea.data.ViajeDao;
import aerolinea.logic.Modelo;
import aerolinea.logic.Viaje;
import aerolinea.presentacion.ventanaprincipal.VentanaPrincipalView;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ViajeView extends javax.swing.JPanel implements Observer {

    ViajeController controller;
    ViajeModel model;
    VentanaPrincipalView main;
    public JDialog dialogo;
     
    public ViajeView(VentanaPrincipalView main) {
        initComponents();
        this.main = main;
        principaltable.setModel(new TableModelViaje(Modelo.getInstance().GetAllViaje()));
       
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
        fechasalida = new javax.swing.JComboBox<>();
        searchfield = new javax.swing.JTextField();
        buscar = new javax.swing.JButton();
        idacombo = new javax.swing.JComboBox<>();
        regresocombo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fecharegreso = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1280, 720));

        labeltittle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        labeltittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeltittle.setText("Administrar Viajes");

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

        fechasalida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        idacombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        regresocombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Vuelos de ida:");

        jLabel2.setText("Vuelos de regreso:");

        fecharegreso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Fecha de salida:");

        jLabel4.setText("Fecha de regreso");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(añadir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(idacombo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(40, 40, 40)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel2)
                                .addGap(43, 43, 43)
                                .addComponent(jLabel3)
                                .addGap(62, 62, 62)
                                .addComponent(jLabel4)
                                .addGap(0, 36, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(regresocombo, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fechasalida, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fecharegreso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchfield, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(buscar)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labeltittle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())))
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
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(añadir)
                    .addComponent(fechasalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscar)
                    .addComponent(idacombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(regresocombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fecharegreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
    }//GEN-LAST:event_buscarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        Viaje temp = model.tabletipo.getElement(principaltable.convertRowIndexToModel(principaltable.getSelectedRow()));
            try {
            controller.Eliminar(temp);
        } catch (Exception ex) {
            Logger.getLogger(ViajeView.class.getName()).log(Level.SEVERE, null, ex);
//              JOptionPane.showMessageDialog(null, "ERROR: Alguna entidad necesita de este viaje por lo que aun no se puede borrar..");
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

    
     public void setTable()
    {
        principaltable.setModel(controller.setTables());
    }
     
    public ViajeController getController() {
        return controller;
    }

    public ViajeModel getModel() {
        return model;
    }

    public void setController(ViajeController controller) {
        this.controller = controller;
    }

    public void setModel(ViajeModel model) {
        this.model = model;
        model.addObserver(this);
        fechasalida.setModel(new DefaultComboBoxModel(model.fechasalida));
        idacombo.setModel(new DefaultComboBoxModel(model.ida));
        regresocombo.setModel(new DefaultComboBoxModel(model.regreso));
        fecharegreso.setModel(new DefaultComboBoxModel(model.fecharegreso));
        
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Eliminar;
    public javax.swing.JButton añadir;
    public javax.swing.JButton buscar;
    public javax.swing.JComboBox<String> fecharegreso;
    public javax.swing.JComboBox<String> fechasalida;
    public javax.swing.JComboBox<String> idacombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labeltittle;
    public javax.swing.JTable principaltable;
    public javax.swing.JComboBox<String> regresocombo;
    public javax.swing.JTextField searchfield;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
//        if (controller != null)
//        setTable();
        principaltable.setModel(new TableModelViaje(ViajeDao.getInstance().findViajeEntities()));
//        controller.UpdateTable();
    }
}
