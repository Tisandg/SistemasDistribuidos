
package cliente;

/**
 *
 * @author Kevin Chantré
 */
public class Menu_Principal extends javax.swing.JFrame {

    int numPuertoRMIRegistry = 0;
    String direccionIpRMIRegistry = "";
    
    public Menu_Principal(int numPuertoRMIRegistry, String direccionIpRMIRegistry) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.numPuertoRMIRegistry = numPuertoRMIRegistry;
        this.direccionIpRMIRegistry = direccionIpRMIRegistry;
    }

    private Menu_Principal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Ingresar_Cliente = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Ingresar_Administrador = new javax.swing.JButton();
        Salir_Aplicacion = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(340, 350));
        setMinimumSize(new java.awt.Dimension(340, 350));
        setPreferredSize(new java.awt.Dimension(340, 350));

        jPanel1.setMaximumSize(new java.awt.Dimension(340, 350));
        jPanel1.setMinimumSize(new java.awt.Dimension(340, 350));
        jPanel1.setPreferredSize(new java.awt.Dimension(340, 350));

        Ingresar_Cliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Ingresar_Cliente.setForeground(new java.awt.Color(0, 0, 153));
        Ingresar_Cliente.setText("Usuario");
        Ingresar_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ingresar_ClienteActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("DOMINO RMI");

        Ingresar_Administrador.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Ingresar_Administrador.setForeground(new java.awt.Color(0, 0, 153));
        Ingresar_Administrador.setText("Administrador");
        Ingresar_Administrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ingresar_AdministradorActionPerformed(evt);
            }
        });

        Salir_Aplicacion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Salir_Aplicacion.setText("Salir");
        Salir_Aplicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Salir_AplicacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Salir_Aplicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ingresar_Administrador, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ingresar_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addComponent(Ingresar_Administrador)
                .addGap(18, 18, 18)
                .addComponent(Ingresar_Cliente)
                .addGap(57, 57, 57)
                .addComponent(Salir_Aplicacion)
                .addGap(66, 66, 66))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 361, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Ingresar_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ingresar_ClienteActionPerformed
        // Usuario
        this.setVisible(false);
        new Usuario_Interface(numPuertoRMIRegistry, direccionIpRMIRegistry).setVisible(true);
    }//GEN-LAST:event_Ingresar_ClienteActionPerformed

    private void Ingresar_AdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ingresar_AdministradorActionPerformed
        // Redireccion a la interfaz autentificar administrador
        this.setVisible(false);
        new Administrador_Interface(numPuertoRMIRegistry, direccionIpRMIRegistry).setVisible(true);
    }//GEN-LAST:event_Ingresar_AdministradorActionPerformed

    private void Salir_AplicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Salir_AplicacionActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_Salir_AplicacionActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Ingresar_Administrador;
    private javax.swing.JButton Ingresar_Cliente;
    private javax.swing.JToggleButton Salir_Aplicacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
