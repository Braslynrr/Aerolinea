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

        setMaximumSize(new java.awt.Dimension(1280, 720));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labeltittle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        labeltittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeltittle.setText("Elija su Destino");
        add(labeltittle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 791, 28));

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

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 113, 791, 292));

        fechasalida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(fechasalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 73, 131, -1));
        add(searchfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(644, 73, 90, -1));

        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(736, 72, -1, -1));

        idacombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(idacombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 73, 120, -1));

        regresocombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(regresocombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 73, 128, -1));

        jLabel1.setText("Vuelos de ida:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 52, -1, -1));

        jLabel2.setText("Vuelos de regreso:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 52, -1, -1));

        fecharegreso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(fecharegreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 73, 217, -1));

        jLabel3.setText("Fecha de salida:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(288, 52, -1, -1));

        jLabel4.setText("Fecha de regreso");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 52, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        this.setTable();
    }//GEN-LAST:event_buscarActionPerformed

    private void principaltableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_principaltableMouseClicked
        if (evt.getClickCount() == 2) {
            Viaje temp = model.tabletipo.getElement(principaltable.convertRowIndexToModel(principaltable.getSelectedRow()));
            dialogo = new JDialog(main, "Comprar Tiquetes", true);
            dialogo.setResizable(true);
            JPanel userview = controller.VenatanAñadir(temp);
            userview.setSize(950, 500);
            dialogo.getContentPane().add(userview);
            dialogo.pack();
            dialogo.setLocationRelativeTo(main);
            dialogo.setVisible(true);
        }
    }//GEN-LAST:event_principaltableMouseClicked

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
