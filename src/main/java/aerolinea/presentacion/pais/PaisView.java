
package aerolinea.presentacion.pais;

import aerolinea.presentacion.tipoavion.*;
import aerolinea.Main;
import aerolinea.data.PaisDao;
import aerolinea.data.TipoAvionDao;
import aerolinea.logic.Modelo;
import aerolinea.logic.Pais;
import aerolinea.logic.TipoAvion;
import aerolinea.presentacion.ventanaprincipal.VentanaPrincipalView;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PaisView extends javax.swing.JPanel implements Observer {

    PaisController controller;
    PaisModel model;
    VentanaPrincipalView main;
    public JDialog dialogo;
     
    public PaisView(VentanaPrincipalView main) {
        initComponents();
        this.main = main;
        principaltable.setModel(new TableModelPais(Modelo.getInstance().GetAllPais()));
       
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
        searchcombo = new javax.swing.JComboBox<>();
        searchfield = new javax.swing.JTextField();
        buscar = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(1280, 720));

        labeltittle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        labeltittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeltittle.setText("Administrar Paises");

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

        searchcombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

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
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(añadir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 337, Short.MAX_VALUE)
                        .addComponent(searchcombo, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchfield, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buscar)
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
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(añadir)
                    .addComponent(searchcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Eliminar)
                .addContainerGap(15, Short.MAX_VALUE))
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
        Pais temp = model.tabletipo.getElement(principaltable.convertRowIndexToModel(principaltable.getSelectedRow()));
            try {
            controller.Eliminar(temp);
        } catch (Exception ex) {
//            Logger.getLogger(PaisView.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(null, "ERROR: Una ciudad depende de este pais, no es posible eliminarlo aun.");
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
     
    public PaisController getController() {
        return controller;
    }

    public PaisModel getModel() {
        return model;
    }

    public void setController(PaisController controller) {
        this.controller = controller;
    }

    public void setModel(PaisModel model) {
        this.model = model;
        model.addObserver(this);
        searchcombo.setModel(new DefaultComboBoxModel(model.combotipos));
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Eliminar;
    public javax.swing.JButton añadir;
    public javax.swing.JButton buscar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labeltittle;
    public javax.swing.JTable principaltable;
    public javax.swing.JComboBox<String> searchcombo;
    public javax.swing.JTextField searchfield;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        if (controller != null)
        setTable();

    }
}
