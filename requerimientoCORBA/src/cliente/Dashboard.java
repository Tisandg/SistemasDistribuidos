/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Santiago Garcia Ch
 */
public class Dashboard extends javax.swing.JFrame {

    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        initComponents();
        contenedorInfoUsuario.setVisible(false);
        this.setLocationRelativeTo(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BarraPrograma = new javax.swing.JPanel();
        botonCerrar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        ContenedorDatosSesion = new javax.swing.JPanel();
        usuarioIniciado = new javax.swing.JLabel();
        contenedorGeneral = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        contenedorUsuariosConectados = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        listaRegistrados1 = new javax.swing.JList<>();
        contenedorUsuariosRegistrados = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaRegistrados = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        contenedorBienvenida = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textoBienvenida = new javax.swing.JTextArea();
        contenedorInfoUsuario = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        botonEditar = new javax.swing.JButton();
        botonDesactivar = new javax.swing.JButton();
        botonAceptar = new javax.swing.JButton();
        campoNombre = new javax.swing.JLabel();
        campoApellidos = new javax.swing.JLabel();
        campoLogin = new javax.swing.JLabel();
        contenedorReproductor = new javax.swing.JPanel();
        botonSelecionarCancion = new java.awt.Button();
        jLabel3 = new javax.swing.JLabel();
        botonReproducir = new javax.swing.JLabel();
        botonPausa = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BarraPrograma.setBackground(new java.awt.Color(32, 33, 35));
        BarraPrograma.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BarraPrograma.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonCerrar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        botonCerrar.setForeground(new java.awt.Color(57, 113, 177));
        botonCerrar.setText(" X ");
        botonCerrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonCerrarMouseClicked(evt);
            }
        });
        BarraPrograma.add(botonCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(723, 13, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(57, 113, 177));
        jLabel1.setText("Streaming Musica");
        BarraPrograma.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 15, -1, -1));

        getContentPane().add(BarraPrograma, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 50));

        ContenedorDatosSesion.setBackground(new java.awt.Color(0, 18, 50));
        ContenedorDatosSesion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ContenedorDatosSesion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usuarioIniciado.setForeground(new java.awt.Color(255, 255, 255));
        usuarioIniciado.setIcon(new javax.swing.ImageIcon("D:\\Santiago\\Imagenes\\iconos PNG\\usuario.png")); // NOI18N
        usuarioIniciado.setText("Usuario");
        ContenedorDatosSesion.add(usuarioIniciado, new org.netbeans.lib.awtextra.AbsoluteConstraints(626, 13, -1, -1));

        getContentPane().add(ContenedorDatosSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 760, 50));

        contenedorGeneral.setBackground(new java.awt.Color(32, 47, 90));
        contenedorGeneral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel11.setText("Usuarios conectados");

        listaRegistrados1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaRegistrados1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaRegistrados1MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(listaRegistrados1);

        javax.swing.GroupLayout contenedorUsuariosConectadosLayout = new javax.swing.GroupLayout(contenedorUsuariosConectados);
        contenedorUsuariosConectados.setLayout(contenedorUsuariosConectadosLayout);
        contenedorUsuariosConectadosLayout.setHorizontalGroup(
            contenedorUsuariosConectadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenedorUsuariosConectadosLayout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(67, 67, 67))
            .addGroup(contenedorUsuariosConectadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(contenedorUsuariosConectadosLayout.createSequentialGroup()
                    .addGap(60, 60, 60)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(61, Short.MAX_VALUE)))
        );
        contenedorUsuariosConectadosLayout.setVerticalGroup(
            contenedorUsuariosConectadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorUsuariosConectadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(266, Short.MAX_VALUE))
            .addGroup(contenedorUsuariosConectadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(contenedorUsuariosConectadosLayout.createSequentialGroup()
                    .addGap(57, 57, 57)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(36, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Usuarios conectados", contenedorUsuariosConectados);

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel5.setText("Usuarios registrados");

        listaRegistrados.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaRegistrados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaRegistradosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(listaRegistrados);

        jButton1.setText("Crear usuario");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        jLabel6.setText("Selecciona un usuario para ver su informacion");

        javax.swing.GroupLayout contenedorUsuariosRegistradosLayout = new javax.swing.GroupLayout(contenedorUsuariosRegistrados);
        contenedorUsuariosRegistrados.setLayout(contenedorUsuariosRegistradosLayout);
        contenedorUsuariosRegistradosLayout.setHorizontalGroup(
            contenedorUsuariosRegistradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorUsuariosRegistradosLayout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenedorUsuariosRegistradosLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(contenedorUsuariosRegistradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenedorUsuariosRegistradosLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(67, 67, 67))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenedorUsuariosRegistradosLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenedorUsuariosRegistradosLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addContainerGap())))
        );
        contenedorUsuariosRegistradosLayout.setVerticalGroup(
            contenedorUsuariosRegistradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorUsuariosRegistradosLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel5)
                .addGap(4, 4, 4)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Usuarios registrados", contenedorUsuariosRegistrados);

        contenedorGeneral.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 28, -1, 330));

        jLabel7.setText("Bienvenido");

        textoBienvenida.setBackground(new java.awt.Color(240, 240, 240));
        textoBienvenida.setColumns(20);
        textoBienvenida.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        textoBienvenida.setRows(5);
        textoBienvenida.setText("Selecciona un cancion y empieza\na compartir con tus usuarios\nsuscritos.\n\nDesde aqui podras crear un \nnuevo usuario, editar su \ninformacion y desactivar usuarios.");
        textoBienvenida.setAutoscrolls(false);
        textoBienvenida.setBorder(null);
        jScrollPane3.setViewportView(textoBienvenida);

        javax.swing.GroupLayout contenedorBienvenidaLayout = new javax.swing.GroupLayout(contenedorBienvenida);
        contenedorBienvenida.setLayout(contenedorBienvenidaLayout);
        contenedorBienvenidaLayout.setHorizontalGroup(
            contenedorBienvenidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorBienvenidaLayout.createSequentialGroup()
                .addGroup(contenedorBienvenidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contenedorBienvenidaLayout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jLabel7))
                    .addGroup(contenedorBienvenidaLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        contenedorBienvenidaLayout.setVerticalGroup(
            contenedorBienvenidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorBienvenidaLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        contenedorGeneral.add(contenedorBienvenida, new org.netbeans.lib.awtextra.AbsoluteConstraints(394, 48, 320, 310));

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel8.setText("Informacion usuario");

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel2.setText("Nombres:");

        jLabel9.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel9.setText("Apellidos");

        jLabel10.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel10.setText("Login");

        botonEditar.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        botonEditar.setText("Editar");
        botonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarActionPerformed(evt);
            }
        });

        botonDesactivar.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        botonDesactivar.setText("Desactivar");
        botonDesactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDesactivarActionPerformed(evt);
            }
        });

        botonAceptar.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        botonAceptar.setText("Aceptar");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contenedorInfoUsuarioLayout = new javax.swing.GroupLayout(contenedorInfoUsuario);
        contenedorInfoUsuario.setLayout(contenedorInfoUsuarioLayout);
        contenedorInfoUsuarioLayout.setHorizontalGroup(
            contenedorInfoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenedorInfoUsuarioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(110, 110, 110))
            .addGroup(contenedorInfoUsuarioLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(contenedorInfoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contenedorInfoUsuarioLayout.createSequentialGroup()
                        .addComponent(botonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonDesactivar)
                        .addGap(18, 18, 18)
                        .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(contenedorInfoUsuarioLayout.createSequentialGroup()
                        .addGroup(contenedorInfoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(contenedorInfoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(contenedorInfoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(campoApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(campoLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        contenedorInfoUsuarioLayout.setVerticalGroup(
            contenedorInfoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorInfoUsuarioLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(contenedorInfoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(contenedorInfoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(campoApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(contenedorInfoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(campoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(contenedorInfoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonEditar)
                    .addComponent(botonDesactivar)
                    .addComponent(botonAceptar))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        contenedorGeneral.add(contenedorInfoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(394, 58, 320, 300));

        getContentPane().add(contenedorGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 760, 380));

        contenedorReproductor.setBackground(new java.awt.Color(32, 33, 35));
        contenedorReproductor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        contenedorReproductor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonSelecionarCancion.setBackground(new java.awt.Color(126, 87, 194));
        botonSelecionarCancion.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        botonSelecionarCancion.setForeground(new java.awt.Color(255, 255, 255));
        botonSelecionarCancion.setLabel("Seleccionar cancion");
        botonSelecionarCancion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonSelecionarCancionMouseClicked(evt);
            }
        });
        contenedorReproductor.add(botonSelecionarCancion, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 20, -1, 32));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre cancion");
        contenedorReproductor.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(224, 20, 244, 32));

        botonReproducir.setIcon(new javax.swing.ImageIcon("D:\\Santiago\\Imagenes\\iconos PNG\\boton-de-reproduccion.png")); // NOI18N
        contenedorReproductor.add(botonReproducir, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 20, -1, -1));

        botonPausa.setIcon(new javax.swing.ImageIcon("D:\\Santiago\\Imagenes\\iconos PNG\\pausa.png")); // NOI18N
        contenedorReproductor.add(botonPausa, new org.netbeans.lib.awtextra.AbsoluteConstraints(562, 20, -1, -1));

        getContentPane().add(contenedorReproductor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, 760, 70));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCerrarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_botonCerrarMouseClicked

    private void botonSelecionarCancionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonSelecionarCancionMouseClicked
        // TODO add your handling code here:
        JFileChooser explorador = new JFileChooser();
        explorador.showOpenDialog(null);
    }//GEN-LAST:event_botonSelecionarCancionMouseClicked

    private void listaRegistradosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaRegistradosMouseClicked
        // TODO add your handling code here:
        if(listaRegistrados.isSelectionEmpty()){
            System.out.println("");
        }else{
            System.out.println("Se ha seleccionado un usuario registrados");
            contenedorBienvenida.setVisible(false);
            contenedorInfoUsuario.setVisible(true);
        }
    }//GEN-LAST:event_listaRegistradosMouseClicked

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        // TODO add your handling code here:
        contenedorInfoUsuario.setVisible(false);
        contenedorBienvenida.setVisible(true);
    }//GEN-LAST:event_botonAceptarActionPerformed

    private void listaRegistrados1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaRegistrados1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_listaRegistrados1MouseClicked

    private void botonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarActionPerformed
        // TODO add your handling code here:
        EditarDatos editar = new EditarDatos();
        editar.setVisible(true);
    }//GEN-LAST:event_botonEditarActionPerformed

    private void botonDesactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDesactivarActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(null, "Esta seguro que desea desactivar este usuario?", "Confirmar desactivacion", JOptionPane.YES_NO_OPTION) == 0){
            System.out.println("Ha confirmado la desactivacion del usuario");
        }else{
            System.out.println("Ha cancelado la desactivacion del usuairo");
        }

    }//GEN-LAST:event_botonDesactivarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        CrearUsuario crear = new CrearUsuario();
        crear.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BarraPrograma;
    private javax.swing.JPanel ContenedorDatosSesion;
    private javax.swing.JButton botonAceptar;
    private javax.swing.JLabel botonCerrar;
    private javax.swing.JButton botonDesactivar;
    private javax.swing.JButton botonEditar;
    private javax.swing.JLabel botonPausa;
    private javax.swing.JLabel botonReproducir;
    private java.awt.Button botonSelecionarCancion;
    private javax.swing.JLabel campoApellidos;
    private javax.swing.JLabel campoLogin;
    private javax.swing.JLabel campoNombre;
    private javax.swing.JPanel contenedorBienvenida;
    private javax.swing.JPanel contenedorGeneral;
    private javax.swing.JPanel contenedorInfoUsuario;
    private javax.swing.JPanel contenedorReproductor;
    private javax.swing.JPanel contenedorUsuariosConectados;
    private javax.swing.JPanel contenedorUsuariosRegistrados;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JList<String> listaRegistrados;
    private javax.swing.JList<String> listaRegistrados1;
    private javax.swing.JTextArea textoBienvenida;
    private javax.swing.JLabel usuarioIniciado;
    // End of variables declaration//GEN-END:variables
}