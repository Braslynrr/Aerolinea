package aerolinea.presentacion.SeleccionVuelo;

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

public class SelectView extends javax.swing.JPanel implements Observer {

    SelectController controller;
    SelectModel model;
    VentanaPrincipalView main;
    public JDialog dialogo;

    public SelectView(VentanaPrincipalView main) {
        initComponents();
        this.main = main;
        principaltable.setModel(new TableModelselect(Modelo.getInstance().GetAllViaje()));

        dialogo = new JDialog(main, " ", true);

    }

    public VentanaPrincipalView getMain() {
        return main;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labeltittle = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        principaltable = new javax.swing.JTable();
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(1280, 720));

        labeltittle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        labeltittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeltittle.setText("Elija su Destino");

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

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton2.setText("Reservas");
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
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(51, 51, 51)
                .addComponent(jLabel2)
                .addGap(43, 43, 43)
                .addComponent(jLabel3)
                .addGap(62, 62, 62)
                .addComponent(jLabel4))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(idacombo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(regresocombo, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(fechasalida, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(fecharegreso, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(searchfield, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(buscar))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 791, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(labeltittle, javax.swing.GroupLayout.PREFERRED_SIZE, 791, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labeltittle, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buscar)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idacombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(regresocombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fechasalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fecharegreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        this.setTable();
    }//GEN-LAST:event_buscarActionPerformed

    private void principaltableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_principaltableMouseClicked
        if (evt.getClickCount() == 2) {
            Viaje temp = model.tabletipo.getElement(principaltable.convertRowIndexToModel(principaltable.getSelectedRow()));
            dialogo = new JDialog(main, "Comprar Tiquetes", true);
            dialogo.setResizable(true);
            JPanel userview = controller.VenatanAñadir(temp,dialogo,0);
            userview.setSize(950, 500);
            dialogo.getContentPane().add(userview);
            dialogo.pack();
            dialogo.setSize(950, 600);
            dialogo.setLocationRelativeTo(main);
            dialogo.setVisible(true);
        }
    }//GEN-LAST:event_principaltableMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        controller.OcutarDialogo();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dialogo = new JDialog(main, "Reservas", true);
            dialogo.setResizable(true);
            JPanel userview = controller.VenatanAñadir(null,dialogo,1);
            userview.setSize(950, 500);
            dialogo.getContentPane().add(userview);
            dialogo.pack();
            dialogo.setLocationRelativeTo(main);
            dialogo.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    public void setTable() {
        principaltable.setModel(controller.setTables());
    }

    public SelectController getController() {
        return controller;
    }

    public SelectModel getModel() {
        return model;
    }

    public void setController(SelectController controller) {
        this.controller = controller;
    }

    public void setModel(SelectModel model) {
        this.model = model;
        model.addObserver(this);
        fechasalida.setModel(new DefaultComboBoxModel(model.fechasalida));
        idacombo.setModel(new DefaultComboBoxModel(model.ida));
        regresocombo.setModel(new DefaultComboBoxModel(model.regreso));
        fecharegreso.setModel(new DefaultComboBoxModel(model.fecharegreso));

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton buscar;
    public javax.swing.JComboBox<String> fecharegreso;
    public javax.swing.JComboBox<String> fechasalida;
    public javax.swing.JComboBox<String> idacombo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
        principaltable.setModel(new TableModelselect(ViajeDao.getInstance().findViajeEntities()));
//        controller.UpdateTable();
    }
}
