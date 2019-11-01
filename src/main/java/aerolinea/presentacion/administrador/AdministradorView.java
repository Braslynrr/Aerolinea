
package aerolinea.presentacion.administrador;

import aerolinea.Main;
import aerolinea.data.PaisDao;
import aerolinea.data.TipoAvionDao;
import aerolinea.data.UsuarioDao;
import aerolinea.presentacion.añadirusuario.AñadirUsuarioController;
import aerolinea.presentacion.añadirusuario.AñadirUsuarioModel;
import aerolinea.presentacion.añadirusuario.AñadirUsuarioView;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;

public class AdministradorView extends javax.swing.JPanel implements Observer{

    AdministradorController controller = null;
    AdministradorModel model;
    Main main;
    int lastIndex = 0;
    
    
    public AdministradorView(Main main) {
        initComponents();
        this.main = main;
        principaltable.setModel(new TableModelTipoAvion(TipoAvionDao.getInstance().findTipoAvionEntities()));
    }
    
    public AdministradorController getController() {
        return controller;
    }

    public AdministradorModel getModel() {
        return model;
    }

    public void setController(AdministradorController controller) {
        this.controller = controller;
    }

    public void setModel(AdministradorModel model) {
        this.model = model;
        model.addObserver(this);
    }

    public void update(Observable o, Object arg) {
        DefaultComboBoxModel newmodel = new DefaultComboBoxModel(model.getComboclases());
        clasesbox.setModel( newmodel );  
        clasesbox.setSelectedIndex(lastIndex);
        if (controller != null)
        {
            setTable(clasesbox.getSelectedIndex());
        }
    }
    
    public void setTable(int clase)
    {
        principaltable.setModel(controller.setTables(clase));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        principaltable = new javax.swing.JTable();
        clasesbox = new javax.swing.JComboBox<>();
        VerBotton = new javax.swing.JButton();
        añadir = new javax.swing.JButton();
        buscar = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Administración");

        principaltable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        principaltable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        principaltable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                principaltableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(principaltable);

        clasesbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clasesboxActionPerformed(evt);
            }
        });

        VerBotton.setText("Ver");
        VerBotton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerBottonActionPerformed(evt);
            }
        });

        añadir.setText("Añadir");
        añadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirActionPerformed(evt);
            }
        });

        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        jButton1.setText("swap");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 745, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 16, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(clasesbox, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(VerBotton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(añadir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buscar)
                                .addGap(57, 57, 57)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(73, 73, 73))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clasesbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(VerBotton)
                    .addComponent(añadir)
                    .addComponent(buscar)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void clasesboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clasesboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clasesboxActionPerformed

    private void VerBottonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerBottonActionPerformed
        lastIndex = clasesbox.getSelectedIndex();
        this.setTable(lastIndex);
        
    }//GEN-LAST:event_VerBottonActionPerformed

    private void añadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirActionPerformed
       JDialog dialogo = new JDialog(main,"Añadir usuario",true);
       dialogo.setResizable(false);
       
       AñadirUsuarioView userview = new AñadirUsuarioView();
       AñadirUsuarioModel usermodel = new AñadirUsuarioModel();
       AñadirUsuarioController usercontroller = new AñadirUsuarioController(usermodel,userview);
       userview.añadir.setEnabled(true);
       
       dialogo.getContentPane().add(userview);
       dialogo.pack();
       dialogo.setLocationRelativeTo(main);
       dialogo.setVisible(true);
    }//GEN-LAST:event_añadirActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        
    }//GEN-LAST:event_buscarActionPerformed

    private void principaltableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_principaltableMouseClicked
       
     
    }//GEN-LAST:event_principaltableMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton VerBotton;
    private javax.swing.JButton añadir;
    private javax.swing.JButton buscar;
    private javax.swing.JComboBox<Object> clasesbox;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable principaltable;
    // End of variables declaration//GEN-END:variables
}
