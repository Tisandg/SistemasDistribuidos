package cliente;

import static javax.swing.GroupLayout.Alignment.CENTER;
import javax.swing.JOptionPane;
import sop_corba.Interfaz_Gestion;
import sop_corba.Usuario;

/**
 * @author Santiago Garcia Ch
 * Interfaz para crear usuario y editarlo. Se reunen en una misma interfaz 
 * ya que comparten los mismo elementos
 */

public class InterfazDatosUsuario extends javax.swing.JFrame {

    private Interfaz_Gestion gestion;
    private ClienteDeObjetos objc;
    private Dashboard tablero;
    private Usuario usuario;
    /*True si esta creando usuario. False si se esta editando*/
    private boolean modo;
    private String loginInicial;
    
    /**
     * Creates new form EditarDatos
     */
    public InterfazDatosUsuario(ClienteDeObjetos objc, Dashboard tab, boolean modo,String login) {
        initComponents();
        this.setLocationRelativeTo(this);
        this.objc = objc;
        this.tablero = tab;
        this.modo = modo;
        obtenerObjetosRemotos();
        ocultarMensajesValidaciones();
        if(modo){
            /*configurar elementos de la interfaz para crear usuario
             Ya que por defecto viene establecido con las configuraciones
             para crear el usuario, no hace falta modificar*/
        }else{
            /*configurar elementos de la interfaz para editar usuario*/
            this.titulo.setText("Editar usuario");
            this.textoInformacion.setText("Ingrese los nuevos valores en los campos que quiera editar");
            this.botonCrear.setLabel("Guardar");
            llenarCampos(login);
            this.loginInicial = login;
        }
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
        titulo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
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
        botonCrear = new java.awt.Button();
        botonCancelar = new java.awt.Button();
        textoInformacion = new javax.swing.JLabel();
        mensajeNombres = new javax.swing.JLabel();
        mensajeApellidos = new javax.swing.JLabel();
        mensajeLogin = new javax.swing.JLabel();
        mensajeClave = new javax.swing.JLabel();

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

        titulo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        titulo.setForeground(new java.awt.Color(57, 113, 177));
        titulo.setText("Crear usuario");

        javax.swing.GroupLayout contenedorEncabezadoLayout = new javax.swing.GroupLayout(contenedorEncabezado);
        contenedorEncabezado.setLayout(contenedorEncabezadoLayout);
        contenedorEncabezadoLayout.setHorizontalGroup(
            contenedorEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenedorEncabezadoLayout.createSequentialGroup()
                .addContainerGap(152, Short.MAX_VALUE)
                .addComponent(titulo)
                .addGap(118, 118, 118)
                .addComponent(botonCerrar)
                .addContainerGap())
        );
        contenedorEncabezadoLayout.setVerticalGroup(
            contenedorEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenedorEncabezadoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(contenedorEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonCerrar)
                    .addComponent(titulo))
                .addContainerGap())
        );

        getContentPane().add(contenedorEncabezado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 50));

        jPanel2.setBackground(new java.awt.Color(0, 18, 50));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(57, 113, 177));
        jLabel2.setText("Apellidos:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 108, -1, -1));

        campoApellidos.setBackground(new java.awt.Color(0, 18, 50));
        campoApellidos.setForeground(new java.awt.Color(255, 255, 255));
        campoApellidos.setBorder(null);
        jPanel2.add(campoApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 108, 224, 20));

        jLabel3.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(57, 113, 177));
        jLabel3.setText("Login:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 174, -1, -1));

        campoLogin.setBackground(new java.awt.Color(0, 18, 50));
        campoLogin.setForeground(new java.awt.Color(255, 255, 255));
        campoLogin.setBorder(null);
        jPanel2.add(campoLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 179, 218, 20));

        jLabel4.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(57, 113, 177));
        jLabel4.setText("Clave:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 241, -1, -1));

        campoClave.setBackground(new java.awt.Color(0, 18, 50));
        campoClave.setForeground(new java.awt.Color(255, 255, 255));
        campoClave.setBorder(null);
        jPanel2.add(campoClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 241, 219, 20));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 75, 221, -1));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 134, 224, -1));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 205, 218, -1));

        campoNombres.setBackground(new java.awt.Color(0, 18, 50));
        campoNombres.setForeground(new java.awt.Color(255, 255, 255));
        campoNombres.setBorder(null);
        jPanel2.add(campoNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 49, 224, 20));

        jLabel1.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(57, 113, 177));
        jLabel1.setText("Nombres:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 49, -1, -1));
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 267, 219, -1));

        botonCrear.setBackground(new java.awt.Color(126, 87, 194));
        botonCrear.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        botonCrear.setForeground(new java.awt.Color(255, 255, 255));
        botonCrear.setLabel("Crear usuario");
        botonCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearActionPerformed(evt);
            }
        });
        jPanel2.add(botonCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 313, -1, -1));

        botonCancelar.setBackground(new java.awt.Color(126, 87, 194));
        botonCancelar.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        botonCancelar.setForeground(new java.awt.Color(255, 255, 255));
        botonCancelar.setLabel("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(botonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 313, 94, -1));

        textoInformacion.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        textoInformacion.setForeground(new java.awt.Color(204, 204, 204));
        textoInformacion.setText("Ingrese los siguientes datos");
        jPanel2.add(textoInformacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 11, 380, -1));

        mensajeNombres.setForeground(new java.awt.Color(255, 0, 0));
        mensajeNombres.setText("Campo requerido");
        jPanel2.add(mensajeNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 88, 266, -1));

        mensajeApellidos.setForeground(new java.awt.Color(255, 0, 0));
        mensajeApellidos.setText("Campo requerido");
        jPanel2.add(mensajeApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 147, 266, -1));

        mensajeLogin.setForeground(new java.awt.Color(255, 0, 0));
        mensajeLogin.setText("Campo requerido");
        jPanel2.add(mensajeLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 213, 266, -1));

        mensajeClave.setForeground(new java.awt.Color(255, 0, 0));
        mensajeClave.setText("Campo requerido");
        jPanel2.add(mensajeClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 275, 266, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 420, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCerrarMouseClicked
        setVisible(false);
    }//GEN-LAST:event_botonCerrarMouseClicked

    private void botonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearActionPerformed
        /*Comprobamos los datos suminsitrados*/
        Validaciones validador = new Validaciones(this);
        String nombres = this.campoNombres.getText();
        String apellidos = this.campoApellidos.getText();
        String login = this.campoLogin.getText();
        String clave = this.campoClave.getText();
        ocultarMensajesValidaciones();
        if(validador.camposValidos(nombres, apellidos, login, clave)){
            boolean loginDisponible = false;
            /*Si cumplen con las validaciones pasamos a verificar 
            * que el login digitado no este usado*/
            if(modo){
                /*Modo creacion de usuarios*/
                if(gestion.exiteUsuario(login)){
                    JOptionPane.showMessageDialog(null, "Este login no esta disponible");
                }else{
                    System.out.println("Login disponible");
                    loginDisponible = true;
                }
            }else{
                /*Modo de edicion de usuario*/
                
                /*Para verificar que es el mismo usuario que tenia el anterior login*/
                if(gestion.exiteUsuario(login) && (loginInicial.equals(login) == false)){
                   JOptionPane.showMessageDialog(null, "Este login no esta disponible"); 
                }else{
                    System.out.println("El login esta disponible");
                    loginDisponible = true;
                }
            }
            if(loginDisponible){
                if(modo){
                    usuario = new Usuario();
                }
                
                usuario.setNombresUsuario(nombres);
                usuario.setApellidosUsuario(apellidos);
                usuario.setLoginUsuario(login);
                usuario.setClaveUsuario(clave);
                
                if(modo){
                    usuario.setDesactivado(false);
                    usuario.setImagenUsuario("defecto");
                    usuario.setPrivilegiosUsuario(false);
                }
                
                if(modo){
                    /*Modo crear usuario*/
                    System.out.println("registrando usuario");
                    if(gestion.registrarUsuario(usuario)){
                        ocultarMensajesValidaciones();
                        JOptionPane.showMessageDialog(null, "Se ha registrado el usuario correctamente");
                        System.out.println("Se ha registrado el usuario correctamente");
                        tablero.actualizarListaRegistrados();
                        setVisible(false);
                    }else{
                        JOptionPane.showMessageDialog(null, "Problemas al registrar el usuario");
                        System.out.println("Problemas al registrar el usuario");
                    }
                }else{
                    /*Modo de editar usuairo*/
                    System.out.println("Actualizando usuario");
                    if(gestion.actualizarUsuario(usuario, login)){
                        ocultarMensajesValidaciones();
                        JOptionPane.showMessageDialog(null, "Se han actualizado correctamente los datos");
                        System.out.println("Se han actualizado correctamente los datos");
                        if(tablero.isAdmin){
                            tablero.actualizarListaRegistrados();
                            Usuario u = gestion.consultarUsuario(usuario.getLoginUsuario());
                            tablero.actualizarPanelInfoUsuario(u);
                        }else{
                            tablero.actualizarLogin(usuario.loginUsuario);
                        }
                        
                        setVisible(false);
                    }else{
                        JOptionPane.showMessageDialog(null, "No se han actualizado los datos");
                        System.out.println("No se han actualizado los datos");
                    }
                }
            }
        }
    }//GEN-LAST:event_botonCrearActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_botonCancelarActionPerformed

    /*Metodos auxiliares*/
    public void modificarMensajeLogin(boolean visible, String mensaje){
        this.mensajeLogin.setVisible(visible);
        this.mensajeLogin.setText(mensaje);
    }
    
    public void modificarMensajeClave(boolean visible, String mensaje){
        this.mensajeClave.setVisible(visible);
        this.mensajeClave.setText(mensaje);
    }
    
    public void modificarMensajeNombres(boolean visible, String mensaje){
        this.mensajeNombres.setVisible(visible);
        this.mensajeNombres.setText(mensaje);
    }
    
    public void modificarMensajeApellidos(boolean visible, String mensaje){
        this.mensajeApellidos.setVisible(visible);
        this.mensajeApellidos.setText(mensaje);
    }
    
    public void llenarCampos(String login){
        usuario = gestion.consultarUsuario(login);
        /*Actualizamos los campos*/
        this.campoNombres.setText(usuario.getNombresUsuario());
        this.campoApellidos.setText(usuario.getApellidosUsuario());
        this.campoClave.setText(usuario.getClaveUsuario());
        this.campoLogin.setText(usuario.getLoginUsuario());
        System.out.println("id "+usuario.getIdUsuario());
        System.out.println("Campos llenados");
    }
    // < >
    
    
    public void ocultarMensajesValidaciones(){
        this.mensajeNombres.setVisible(false);
        this.mensajeApellidos.setVisible(false);
        this.mensajeClave.setVisible(false);
        this.mensajeLogin.setVisible(false);
    }
    
    public void obtenerObjetosRemotos(){
            gestion = (Interfaz_Gestion) objc.ObtenerServant("ServantGest");
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
            java.util.logging.Logger.getLogger(InterfazDatosUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazDatosUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazDatosUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazDatosUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearUsuario().setVisible(true);
            }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearUsuario().setVisible(true);
            }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearUsuario().setVisible(true);
            }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearUsuario().setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button botonCancelar;
    private javax.swing.JLabel botonCerrar;
    private java.awt.Button botonCrear;
    private javax.swing.JTextField campoApellidos;
    private javax.swing.JTextField campoClave;
    private javax.swing.JTextField campoLogin;
    private javax.swing.JTextField campoNombres;
    private javax.swing.JPanel contenedorEncabezado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel mensajeApellidos;
    private javax.swing.JLabel mensajeClave;
    private javax.swing.JLabel mensajeLogin;
    private javax.swing.JLabel mensajeNombres;
    private javax.swing.JLabel textoInformacion;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
