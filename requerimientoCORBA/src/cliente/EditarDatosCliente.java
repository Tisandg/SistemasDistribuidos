package cliente;

import sop_corba.Interfaz_Gestion;
import sop_corba.Usuario;

/**
 *
 * @author Santiago Garcia Ch
 */
public class EditarDatosCliente extends javax.swing.JFrame {

    private String login;
    private Usuario usuario;
    private Interfaz_Gestion gestion;
    private DashboardCliente tablero;
    /**
     * Creates new form EditarDatos
     */
    public EditarDatosCliente(String login, DashboardCliente tablero) {
        initComponents();
        this.setLocationRelativeTo(this);
        this.login = login;
        obtenerObjetosRemotos();
        llenarCampos();
        this.tablero = tablero;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenedorEncabezado = new javax.swing.JPanel();
        botonCerrar = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        panelInformacion = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        campoApellidos = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        campoLogin = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        campoClave = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        campoNombres = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        botonGuardar = new java.awt.Button();
        botonCancelar = new java.awt.Button();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(32, 47, 90));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        contenedorEncabezado.setBackground(new java.awt.Color(32, 33, 35));
        contenedorEncabezado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        botonCerrar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        botonCerrar.setForeground(new java.awt.Color(57, 113, 177));
        botonCerrar.setText(" X ");
        botonCerrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonCerrarMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(57, 113, 177));
        jLabel5.setText("Editando usuario");

        javax.swing.GroupLayout contenedorEncabezadoLayout = new javax.swing.GroupLayout(contenedorEncabezado);
        contenedorEncabezado.setLayout(contenedorEncabezadoLayout);
        contenedorEncabezadoLayout.setHorizontalGroup(
            contenedorEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenedorEncabezadoLayout.createSequentialGroup()
                .addContainerGap(112, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(108, 108, 108)
                .addComponent(botonCerrar)
                .addContainerGap())
        );
        contenedorEncabezadoLayout.setVerticalGroup(
            contenedorEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenedorEncabezadoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(contenedorEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonCerrar)
                    .addComponent(jLabel5))
                .addContainerGap())
        );

        getContentPane().add(contenedorEncabezado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 50));

        panelInformacion.setBackground(new java.awt.Color(0, 18, 50));

        jLabel2.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(57, 113, 177));
        jLabel2.setText("Apellidos:");

        campoApellidos.setBackground(new java.awt.Color(0, 18, 50));
        campoApellidos.setForeground(new java.awt.Color(255, 255, 255));
        campoApellidos.setBorder(null);

        jLabel3.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(57, 113, 177));
        jLabel3.setText("Login:");

        campoLogin.setBackground(new java.awt.Color(0, 18, 50));
        campoLogin.setForeground(new java.awt.Color(255, 255, 255));
        campoLogin.setBorder(null);

        jLabel4.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(57, 113, 177));
        jLabel4.setText("Contraseña:");

        campoClave.setBackground(new java.awt.Color(0, 18, 50));
        campoClave.setForeground(new java.awt.Color(255, 255, 255));
        campoClave.setBorder(null);

        campoNombres.setBackground(new java.awt.Color(0, 18, 50));
        campoNombres.setForeground(new java.awt.Color(255, 255, 255));
        campoNombres.setBorder(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(57, 113, 177));
        jLabel1.setText("Nombres:");

        botonGuardar.setBackground(new java.awt.Color(126, 87, 194));
        botonGuardar.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        botonGuardar.setForeground(new java.awt.Color(255, 255, 255));
        botonGuardar.setLabel("Guardar");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        botonCancelar.setBackground(new java.awt.Color(126, 87, 194));
        botonCancelar.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        botonCancelar.setForeground(new java.awt.Color(255, 255, 255));
        botonCancelar.setLabel("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Ingrese los nuevos valores en los campos que quiera editar");

        javax.swing.GroupLayout panelInformacionLayout = new javax.swing.GroupLayout(panelInformacion);
        panelInformacion.setLayout(panelInformacionLayout);
        panelInformacionLayout.setHorizontalGroup(
            panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInformacionLayout.createSequentialGroup()
                .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInformacionLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelInformacionLayout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(panelInformacionLayout.createSequentialGroup()
                                    .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelInformacionLayout.createSequentialGroup()
                                            .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel2)
                                                .addComponent(jLabel3))
                                            .addGap(22, 22, 22))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInformacionLayout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addGap(18, 18, 18)))
                                    .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(campoNombres, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                                        .addComponent(jSeparator2)
                                        .addComponent(campoApellidos)
                                        .addGroup(panelInformacionLayout.createSequentialGroup()
                                            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                                            .addGap(6, 6, 6))
                                        .addComponent(jSeparator3)
                                        .addComponent(campoLogin)))
                                .addGroup(panelInformacionLayout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator4)
                                        .addComponent(campoClave))))))
                    .addGroup(panelInformacionLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel6)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        panelInformacionLayout.setVerticalGroup(
            panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInformacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInformacionLayout.createSequentialGroup()
                        .addComponent(campoNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(panelInformacionLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(campoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19)
                .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(campoClave, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        getContentPane().add(panelInformacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 400, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCerrarMouseClicked
        setVisible(false);
    }//GEN-LAST:event_botonCerrarMouseClicked

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        // TODO add your handling code here:
        usuario.setNombresUsuario(this.campoNombres.getText());
        usuario.setApellidosUsuario(this.campoApellidos.getText());
        usuario.setClaveUsuario(this.campoClave.getText());
        usuario.setLoginUsuario(this.campoLogin.getText());
        if(gestion.actualizarUsuario(usuario, login)){
            System.out.println("Se han actualizado correctamente los datos");
            tablero.actualizarInformacion(usuario.getLoginUsuario());
            setVisible(false);
        }else{
            System.out.println("No se han actualizado los datos");
        }
        
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_botonCancelarActionPerformed

    public void obtenerObjetosRemotos(){
        String direccion = conexion.DireccionIP;
        int puerto = conexion.NumeroPuerto;

        ClienteDeObjetos objc = new ClienteDeObjetos();
        String[] datos = new String[4];
        datos[0] = "-ORBInitialHost";
        datos[1] = conexion.DireccionIP;
        datos[2] = "-ORBInitialPort";
        datos[3] = Integer.toString(conexion.NumeroPuerto);

        if(objc.iniciarORB(datos)){
            /*Comprobamos los datos*/
            gestion = (Interfaz_Gestion) objc.ObtenerServant("ServantGest");
        }else{
            System.out.println("Error. No fue posible iniciar el ORB.....");
        }
    }
    
    public void llenarCampos(){
        usuario = gestion.consultarUsuario(login);
        /*Actualizamos los campos*/
        this.campoNombres.setText(usuario.getNombresUsuario());
        this.campoApellidos.setText(usuario.getApellidosUsuario());
        this.campoClave.setText(usuario.getClaveUsuario());
        this.campoLogin.setText(usuario.getLoginUsuario());
        System.out.println("id "+usuario.getIdUsuario());
        System.out.println("Campos llenados");
    }
    
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
            java.util.logging.Logger.getLogger(EditarDatosCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarDatosCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarDatosCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarDatosCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarDatos("").setVisible(true);
            }
        })*/;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button botonCancelar;
    private javax.swing.JLabel botonCerrar;
    private java.awt.Button botonGuardar;
    private javax.swing.JTextField campoApellidos;
    private javax.swing.JTextField campoClave;
    private javax.swing.JTextField campoLogin;
    private javax.swing.JTextField campoNombres;
    private javax.swing.JPanel contenedorEncabezado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JPanel panelInformacion;
    // End of variables declaration//GEN-END:variables
}
