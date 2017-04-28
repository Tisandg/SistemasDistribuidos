
package cliente;

import javax.swing.JOptionPane;
import sop_rmi.UsuariosInt;

/**
 *
 * @author Kevin Chantré
 */
public class Administrador_Interface extends javax.swing.JFrame {

    private static UsuariosInt objRemoto;
    int numPuertoRMIRegistry = 0;
    String direccionIpRMIRegistry = "";
    
    public Administrador_Interface(int numPuertoRMIRegistry, String direccionIpRMIRegistry) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.numPuertoRMIRegistry = numPuertoRMIRegistry;
        this.direccionIpRMIRegistry = direccionIpRMIRegistry;
        obtenerObjetoRemoto();
    }

    private Administrador_Interface() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menu_Administrador = new javax.swing.JFrame();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        Modificar_Datos_Usuario_btn = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        Estadisticas_btn = new javax.swing.JButton();
        Registrar_Usuario_btn = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        Autenticar_Administrador_btn = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();

        Menu_Administrador.setMaximumSize(new java.awt.Dimension(370, 360));
        Menu_Administrador.setMinimumSize(new java.awt.Dimension(370, 360));
        Menu_Administrador.setPreferredSize(new java.awt.Dimension(370, 360));

        jPanel4.setMinimumSize(new java.awt.Dimension(371, 361));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("Menú Administrador");

        Modificar_Datos_Usuario_btn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Modificar_Datos_Usuario_btn.setForeground(new java.awt.Color(0, 0, 153));
        Modificar_Datos_Usuario_btn.setText("Modificar Datos Usuario");
        Modificar_Datos_Usuario_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Modificar_Datos_Usuario_btnActionPerformed(evt);
            }
        });

        jButton14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton14.setText("Menu Principal");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        Estadisticas_btn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Estadisticas_btn.setForeground(new java.awt.Color(0, 0, 153));
        Estadisticas_btn.setText("Consultar Estadisticas");

        Registrar_Usuario_btn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Registrar_Usuario_btn.setForeground(new java.awt.Color(0, 0, 204));
        Registrar_Usuario_btn.setText("Registrar Usuario");
        Registrar_Usuario_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Registrar_Usuario_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Modificar_Datos_Usuario_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Estadisticas_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Registrar_Usuario_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(66, 66, 66)
                .addComponent(Registrar_Usuario_btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Modificar_Datos_Usuario_btn)
                .addGap(18, 18, 18)
                .addComponent(Estadisticas_btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(jButton14)
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout Menu_AdministradorLayout = new javax.swing.GroupLayout(Menu_Administrador.getContentPane());
        Menu_Administrador.getContentPane().setLayout(Menu_AdministradorLayout);
        Menu_AdministradorLayout.setHorizontalGroup(
            Menu_AdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Menu_AdministradorLayout.setVerticalGroup(
            Menu_AdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(430, 270));
        setMinimumSize(new java.awt.Dimension(430, 270));
        setPreferredSize(new java.awt.Dimension(430, 270));

        jPanel5.setMaximumSize(new java.awt.Dimension(430, 270));
        jPanel5.setMinimumSize(new java.awt.Dimension(430, 270));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("Autentificar Administrador");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 204));
        jLabel8.setText("Login");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 204));
        jLabel9.setText("Clave");

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(0, 0, 204));

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(0, 0, 204));

        Autenticar_Administrador_btn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Autenticar_Administrador_btn.setForeground(new java.awt.Color(0, 0, 153));
        Autenticar_Administrador_btn.setText("Ingresar");
        Autenticar_Administrador_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Autenticar_Administrador_btnActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton10.setForeground(new java.awt.Color(0, 0, 153));
        jButton10.setText("Regresar");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(95, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Autenticar_Administrador_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(jTextField4)
                    .addComponent(jTextField3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(47, 47, 47)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel9))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Autenticar_Administrador_btn)
                    .addComponent(jButton10))
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Autenticar_Administrador_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Autenticar_Administrador_btnActionPerformed
        // Se muestra el menu del administrador
        
        boolean sesion = false;
        if(jTextField3.getText().equals("") || jTextField4.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Espacios sin Lenar.....!!", "Error", JOptionPane.ERROR_MESSAGE);
        }else{

            String login = jTextField3.getText();
            String Clave = jTextField4.getText();
            try {
                sesion = objRemoto.iniciarSesion(login, Clave, true);
                if(sesion){
                    this.setVisible(false);
                    Menu_Administrador.setLocationRelativeTo(null);
                    Menu_Administrador.setResizable(false);
                    Menu_Administrador.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña Invalida. Inserte los datos nuevamente.....!!", "Error", JOptionPane.ERROR_MESSAGE);
                    jTextField3.setText("");
                    jTextField4.setText("");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Excepcion generada al invocar al método remoto .....!!", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

    }//GEN-LAST:event_Autenticar_Administrador_btnActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // Salir Autentificar Administrador
        this.setVisible(false);
        new Menu_Principal(numPuertoRMIRegistry, direccionIpRMIRegistry).setVisible(true);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void Modificar_Datos_Usuario_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Modificar_Datos_Usuario_btnActionPerformed
        // Modificar_Datos Usuarios Redirige a la pestaña de Edicion de usuario}
        Menu_Administrador.setVisible(false);
    }//GEN-LAST:event_Modificar_Datos_Usuario_btnActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // Regresa desde el menu del administrador al menu principal
        Menu_Administrador.setVisible(false);

    }//GEN-LAST:event_jButton14ActionPerformed

    private void Registrar_Usuario_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Registrar_Usuario_btnActionPerformed
        // Desde el menu del administrador redirecciona al menu de registro de un nuevo usuario
        Menu_Administrador.setVisible(false);

    }//GEN-LAST:event_Registrar_Usuario_btnActionPerformed

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
            java.util.logging.Logger.getLogger(Administrador_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administrador_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administrador_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administrador_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administrador_Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Autenticar_Administrador_btn;
    private javax.swing.JButton Estadisticas_btn;
    private javax.swing.JFrame Menu_Administrador;
    private javax.swing.JButton Modificar_Datos_Usuario_btn;
    private javax.swing.JButton Registrar_Usuario_btn;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton14;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables

    private void obtenerObjetoRemoto() {
        try {
            objRemoto = (UsuariosInt) UtilidadesRegistroC.obtenerObjRemoto(numPuertoRMIRegistry, direccionIpRMIRegistry, "ServidorUsuarios");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error. Obteniendo el objeto remoto ", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
