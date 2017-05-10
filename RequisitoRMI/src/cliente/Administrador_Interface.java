
package cliente;

import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import sop_rmi.UsuariosInt;
import sop_rmi.Usuario;

/**
 *
 * @author Kevin Chantré
 */
public class Administrador_Interface extends javax.swing.JFrame {

    private static UsuariosInt ObjRemotoAdministrador;
    int numPuertoRMIRegistry = 0;
    String direccionIpRMIRegistry = "";
    private ArrayList<Usuario> ListaUsuariosRegistrados;
    DefaultListModel modeloLista;
    private String LoginSeleccion;
    private String loginAdmin;
    private boolean editandoAdmin;
    
    public Administrador_Interface(int numPuertoRMIRegistry, String direccionIpRMIRegistry) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.numPuertoRMIRegistry = numPuertoRMIRegistry;
        this.direccionIpRMIRegistry = direccionIpRMIRegistry;
        this.ListaUsuariosRegistrados = new ArrayList<>();
        modeloLista = new DefaultListModel();
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
        jButtonEditarPerfil = new javax.swing.JButton();
        Registro_Usuario = new javax.swing.JFrame();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        Registrar_Usuario = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        Operaciones_Sobre_Usuario = new javax.swing.JFrame();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        Modificar_Datos_Usuario_Funcion = new javax.swing.JButton();
        Eliminar_Usuario_Funcion = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        Modificar_Datos_Usuario = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Nombre_Usuario_Modificar_Label = new javax.swing.JLabel();
        Apellido_Usuario_Modificar_Label = new javax.swing.JLabel();
        Login_Usuario_Modificar_Label = new javax.swing.JLabel();
        Contraseña_Usuario_Modificar_Label = new javax.swing.JLabel();
        Nombre_Usuario_Modificar_JTextFiel = new javax.swing.JTextField();
        Apellido_Usuario_Modificar_JTextFiel = new javax.swing.JTextField();
        Login_Usuario_Mod = new javax.swing.JLabel();
        Contraseña_Usuario_Modificar_JTextFiel = new javax.swing.JTextField();
        Guardar_Cambios_Modificacion = new javax.swing.JButton();
        Cancelar_Modificacion_Datos_Usuario = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        Autenticar_Administrador_btn = new javax.swing.JButton();
        Regresar_M_Principal = new javax.swing.JButton();
        Clave_admin = new javax.swing.JPasswordField();

        Menu_Administrador.setMinimumSize(new java.awt.Dimension(370, 360));

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
        Estadisticas_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Estadisticas_btnActionPerformed(evt);
            }
        });

        Registrar_Usuario_btn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Registrar_Usuario_btn.setForeground(new java.awt.Color(0, 0, 204));
        Registrar_Usuario_btn.setText("Registrar Usuario");
        Registrar_Usuario_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Registrar_Usuario_btnActionPerformed(evt);
            }
        });

        jButtonEditarPerfil.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonEditarPerfil.setForeground(new java.awt.Color(0, 0, 153));
        jButtonEditarPerfil.setText("Modificar mi perfil");
        jButtonEditarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarPerfilActionPerformed(evt);
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
                    .addComponent(Registrar_Usuario_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonEditarPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(18, 18, 18)
                .addComponent(jButtonEditarPerfil)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
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

        Registro_Usuario.setMinimumSize(new java.awt.Dimension(382, 360));

        jPanel6.setMaximumSize(new java.awt.Dimension(382, 360));
        jPanel6.setMinimumSize(new java.awt.Dimension(382, 360));
        jPanel6.setPreferredSize(new java.awt.Dimension(382, 360));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 0, 0));
        jLabel10.setText("Registro Usuario");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 153));
        jLabel11.setText("Nombre");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 153));
        jLabel12.setText("Apellido");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 153));
        jLabel13.setText("Login");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 153));
        jLabel14.setText("Clave");

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(0, 0, 153));

        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(0, 0, 153));

        jTextField7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(0, 0, 153));

        jTextField8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField8.setForeground(new java.awt.Color(0, 0, 153));

        Registrar_Usuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Registrar_Usuario.setText("Registrar");
        Registrar_Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Registrar_UsuarioActionPerformed(evt);
            }
        });

        jButton17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton17.setText("Regresar");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(Registrar_Usuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(34, 34, 34))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel10)
                .addGap(40, 40, 40)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel13))
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel14))
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton17)
                    .addComponent(Registrar_Usuario))
                .addContainerGap(73, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Registro_UsuarioLayout = new javax.swing.GroupLayout(Registro_Usuario.getContentPane());
        Registro_Usuario.getContentPane().setLayout(Registro_UsuarioLayout);
        Registro_UsuarioLayout.setHorizontalGroup(
            Registro_UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Registro_UsuarioLayout.setVerticalGroup(
            Registro_UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Operaciones_Sobre_Usuario.setMinimumSize(new java.awt.Dimension(450, 440));

        jPanel7.setMaximumSize(new java.awt.Dimension(450, 440));
        jPanel7.setMinimumSize(new java.awt.Dimension(450, 440));
        jPanel7.setPreferredSize(new java.awt.Dimension(450, 440));

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = {  };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Seleccion_Usuario_evt(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Seleccione un Usuario de la Lista de Usuarios");

        Modificar_Datos_Usuario_Funcion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Modificar_Datos_Usuario_Funcion.setForeground(new java.awt.Color(0, 0, 153));
        Modificar_Datos_Usuario_Funcion.setText("Modificar Usuario");
        Modificar_Datos_Usuario_Funcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Modificar_Datos_Usuario_FuncionActionPerformed(evt);
            }
        });

        Eliminar_Usuario_Funcion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Eliminar_Usuario_Funcion.setForeground(new java.awt.Color(0, 0, 153));
        Eliminar_Usuario_Funcion.setText("Eliminar Usuario");
        Eliminar_Usuario_Funcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Eliminar_Usuario_FuncionActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Regresar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(110, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Modificar_Datos_Usuario_Funcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Eliminar_Usuario_Funcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Modificar_Datos_Usuario_Funcion)
                .addGap(18, 18, 18)
                .addComponent(Eliminar_Usuario_Funcion)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Operaciones_Sobre_UsuarioLayout = new javax.swing.GroupLayout(Operaciones_Sobre_Usuario.getContentPane());
        Operaciones_Sobre_Usuario.getContentPane().setLayout(Operaciones_Sobre_UsuarioLayout);
        Operaciones_Sobre_UsuarioLayout.setHorizontalGroup(
            Operaciones_Sobre_UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Operaciones_Sobre_UsuarioLayout.setVerticalGroup(
            Operaciones_Sobre_UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Modificar_Datos_Usuario.setMinimumSize(new java.awt.Dimension(358, 390));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Modificar Datos Usuario");

        Nombre_Usuario_Modificar_Label.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Nombre_Usuario_Modificar_Label.setText("Nombre");

        Apellido_Usuario_Modificar_Label.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Apellido_Usuario_Modificar_Label.setText("Apellido");

        Login_Usuario_Modificar_Label.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Login_Usuario_Modificar_Label.setText("Login");

        Contraseña_Usuario_Modificar_Label.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Contraseña_Usuario_Modificar_Label.setText("Contraseña");

        Nombre_Usuario_Modificar_JTextFiel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Apellido_Usuario_Modificar_JTextFiel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Login_Usuario_Mod.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Contraseña_Usuario_Modificar_JTextFiel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Guardar_Cambios_Modificacion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Guardar_Cambios_Modificacion.setForeground(new java.awt.Color(0, 0, 153));
        Guardar_Cambios_Modificacion.setText("Guardar Cambios");
        Guardar_Cambios_Modificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Guardar_Cambios_ModificacionActionPerformed(evt);
            }
        });

        Cancelar_Modificacion_Datos_Usuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Cancelar_Modificacion_Datos_Usuario.setForeground(new java.awt.Color(0, 0, 153));
        Cancelar_Modificacion_Datos_Usuario.setText("Cancelar");
        Cancelar_Modificacion_Datos_Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cancelar_Modificacion_Datos_UsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Contraseña_Usuario_Modificar_Label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Login_Usuario_Modificar_Label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Apellido_Usuario_Modificar_Label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Nombre_Usuario_Modificar_Label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Cancelar_Modificacion_Datos_Usuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Guardar_Cambios_Modificacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Nombre_Usuario_Modificar_JTextFiel)
                            .addComponent(Apellido_Usuario_Modificar_JTextFiel)
                            .addComponent(Login_Usuario_Mod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Contraseña_Usuario_Modificar_JTextFiel))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Nombre_Usuario_Modificar_Label)
                            .addComponent(Nombre_Usuario_Modificar_JTextFiel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(Apellido_Usuario_Modificar_Label))
                    .addComponent(Apellido_Usuario_Modificar_JTextFiel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Login_Usuario_Modificar_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Login_Usuario_Mod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Contraseña_Usuario_Modificar_JTextFiel)
                    .addComponent(Contraseña_Usuario_Modificar_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Guardar_Cambios_Modificacion)
                    .addComponent(Cancelar_Modificacion_Datos_Usuario))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Modificar_Datos_UsuarioLayout = new javax.swing.GroupLayout(Modificar_Datos_Usuario.getContentPane());
        Modificar_Datos_Usuario.getContentPane().setLayout(Modificar_Datos_UsuarioLayout);
        Modificar_Datos_UsuarioLayout.setHorizontalGroup(
            Modificar_Datos_UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Modificar_Datos_UsuarioLayout.setVerticalGroup(
            Modificar_Datos_UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(430, 270));

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
        jTextField3.setText("administrador");

        Autenticar_Administrador_btn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Autenticar_Administrador_btn.setForeground(new java.awt.Color(0, 0, 153));
        Autenticar_Administrador_btn.setText("Ingresar");
        Autenticar_Administrador_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Autenticar_Administrador_btnActionPerformed(evt);
            }
        });

        Regresar_M_Principal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Regresar_M_Principal.setForeground(new java.awt.Color(0, 0, 153));
        Regresar_M_Principal.setText("Regresar");
        Regresar_M_Principal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Regresar_M_PrincipalActionPerformed(evt);
            }
        });

        Clave_admin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Clave_admin.setText("12345678");

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
                    .addComponent(Regresar_M_Principal, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Autenticar_Administrador_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(jTextField3)
                    .addComponent(Clave_admin))
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
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(Clave_admin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Autenticar_Administrador_btn)
                    .addComponent(Regresar_M_Principal))
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
        if(jTextField3.getText().equals("") || Clave_admin.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Espacios sin Lenar.....!!", "Error", JOptionPane.ERROR_MESSAGE);
        }else{

            String login = jTextField3.getText();
            String Clave = Clave_admin.getText();
            try {
                sesion = ObjRemotoAdministrador.iniciarSesion(login, Clave, true);
                System.out.println("Autentificacion administrador:  "+sesion);
                if(sesion){
                    loginAdmin = login;
                    this.setVisible(false);
                    Menu_Administrador.setLocationRelativeTo(null);
                    Menu_Administrador.setResizable(false);
                    Menu_Administrador.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña Invalida. Inserte los datos nuevamente.....!!", "Error", JOptionPane.ERROR_MESSAGE);
                    jTextField3.setText("");
                    Clave_admin.setText("");
                }
            } catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "Excepcion generada al invocar al método remoto .....!!", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

    }//GEN-LAST:event_Autenticar_Administrador_btnActionPerformed

    private void Regresar_M_PrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Regresar_M_PrincipalActionPerformed
        // Salir Autentificar Administrador
        this.setVisible(false);
        new Menu_Principal(numPuertoRMIRegistry, direccionIpRMIRegistry).setVisible(true);
    }//GEN-LAST:event_Regresar_M_PrincipalActionPerformed

    private void Modificar_Datos_Usuario_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Modificar_Datos_Usuario_btnActionPerformed
        // Modificar_Datos Usuarios Redirige a la pestaña de Edicion de usuario
        if(Consultar_Usuarios_Registrados())
        {
            Menu_Administrador.setVisible(false);
            Operaciones_Sobre_Usuario.setLocationRelativeTo(null);
            Operaciones_Sobre_Usuario.setResizable(false);
            Operaciones_Sobre_Usuario.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "No Tienes ningun Usuario Registrado .....!!", "Error", JOptionPane.ERROR_MESSAGE);
        }   
    }//GEN-LAST:event_Modificar_Datos_Usuario_btnActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // Regresa desde el menu del administrador al menu principal
        Menu_Administrador.setVisible(false);
        new Menu_Principal(numPuertoRMIRegistry, direccionIpRMIRegistry).setVisible(true);
        
    }//GEN-LAST:event_jButton14ActionPerformed

    private void Registrar_Usuario_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Registrar_Usuario_btnActionPerformed
        // Desde el menu del administrador redirecciona al menu de registro de un nuevo usuario
        Menu_Administrador.setVisible(false);
        Registro_Usuario.setLocationRelativeTo(null);
        Registro_Usuario.setResizable(false);
        Registro_Usuario.setVisible(true);
    }//GEN-LAST:event_Registrar_Usuario_btnActionPerformed

    private void Estadisticas_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Estadisticas_btnActionPerformed
        Menu_Administrador.setVisible(false);
        new estadisticasInterfaz(numPuertoRMIRegistry, direccionIpRMIRegistry, loginAdmin,true).setVisible(true);
    }//GEN-LAST:event_Estadisticas_btnActionPerformed

    private void Registrar_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Registrar_UsuarioActionPerformed
        // Accion Registrar Usuario
        boolean registro;
        if(jTextField5.getText().equals("") || jTextField6.getText().equals("") || jTextField7.getText().equals("") || jTextField8.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Espacios sin llenar.....!!", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            String nombre =  jTextField5.getText();
            String apellido = jTextField6.getText();
            String login = jTextField7.getText();
            String clave = jTextField8.getText();
            try {
                Usuario nuevo = new Usuario(nombre, apellido, login, clave, false);
                registro = ObjRemotoAdministrador.registrarse(nuevo);
                if(registro){
                    JOptionPane.showMessageDialog(null, "El registro fue Exitoso .....!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                    Registro_Usuario.setVisible(false);
                    Menu_Administrador.setLocationRelativeTo(null);
                    Menu_Administrador.setResizable(false);
                    Menu_Administrador.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Usuario No registrado Intente nuevamente .....!!", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Excepcion generada al invocar al método remoto <<Registrar Usuario>>.....!!", "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println("Error "+e.getMessage());
            }

        }
    }//GEN-LAST:event_Registrar_UsuarioActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // dede el menu registro suario regresamos al menu de administrador
        Registro_Usuario.setVisible(false);
        Menu_Administrador.setLocationRelativeTo(null);
        Menu_Administrador.setResizable(false);
        Menu_Administrador.setVisible(true);
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Regresamos al menu del administrador
        Operaciones_Sobre_Usuario.setVisible(false);
        Menu_Administrador.setLocationRelativeTo(null);
        Menu_Administrador.setResizable(false);
        Menu_Administrador.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void Modificar_Datos_Usuario_FuncionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Modificar_Datos_Usuario_FuncionActionPerformed
        // TODO add your handling code here:
        if(!LoginSeleccion.equals("")){
            for (int i = 0; i < ListaUsuariosRegistrados.size(); i++) {
                if(ListaUsuariosRegistrados.get(i).getLogin().equals(LoginSeleccion)){
                    Nombre_Usuario_Modificar_JTextFiel.setText(ListaUsuariosRegistrados.get(i).getNombre());
                    Apellido_Usuario_Modificar_JTextFiel.setText(ListaUsuariosRegistrados.get(i).getApellido());
                    Login_Usuario_Mod.setText(ListaUsuariosRegistrados.get(i).getLogin());
                    Contraseña_Usuario_Modificar_JTextFiel.setText(ListaUsuariosRegistrados.get(i).getClave());
                }
            }
            Operaciones_Sobre_Usuario.setVisible(false);
            Modificar_Datos_Usuario.setLocationRelativeTo(null);
            Modificar_Datos_Usuario.setResizable(false);
            Modificar_Datos_Usuario.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar un usuario de la Lista .....!!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_Modificar_Datos_Usuario_FuncionActionPerformed
 
    private void Guardar_Cambios_ModificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Guardar_Cambios_ModificacionActionPerformed
        // TODO add your handling code here:
        boolean admin = editandoAdmin, modificado = false;
        if(Nombre_Usuario_Modificar_JTextFiel.getText().equals("") || Apellido_Usuario_Modificar_JTextFiel.getText().equals("") 
            || Contraseña_Usuario_Modificar_JTextFiel.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Espacios sin llenar.....!!", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            Usuario usr_actualizar = new Usuario(Nombre_Usuario_Modificar_JTextFiel.getText(), Apellido_Usuario_Modificar_JTextFiel.getText(), Login_Usuario_Mod.getText(), Contraseña_Usuario_Modificar_JTextFiel.getText(), admin);
            try {
                modificado = ObjRemotoAdministrador.modificarUsuario(usr_actualizar);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Excepcion generada al invocar al método remoto <<Modificar Usuario>>.....!!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            if(modificado){
                JOptionPane.showMessageDialog(null, "Los datos se han Actualizado Exitosamente .....!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                Modificar_Datos_Usuario.setVisible(false);
                /*Si estaba editando un administrador, volvemos al menu principal de admin*/
                if(editandoAdmin){
                    Menu_Administrador.setLocationRelativeTo(null);
                    Menu_Administrador.setResizable(false);
                    Menu_Administrador.setVisible(true);
                    editandoAdmin = false;
                }else{
                    Consultar_Usuarios_Registrados();
                    Operaciones_Sobre_Usuario.setLocationRelativeTo(null);
                    Operaciones_Sobre_Usuario.setResizable(false);
                    Operaciones_Sobre_Usuario.setVisible(true);
                }
            }else{
              JOptionPane.showMessageDialog(null, "No fue posible actualizar los datos \n Intente nuevamente .....!!", "Error", JOptionPane.ERROR_MESSAGE);  
            }
        }
    }//GEN-LAST:event_Guardar_Cambios_ModificacionActionPerformed

    private void Cancelar_Modificacion_Datos_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cancelar_Modificacion_Datos_UsuarioActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(null, "Al salir de la modificacion se perderan los datos no guardados...!!!\n\n\tDesea Continuar", "CONFIRMAR",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            Modificar_Datos_Usuario.setVisible(false);
            if(editandoAdmin){
                editandoAdmin = false;
                Menu_Administrador.setLocationRelativeTo(null);
                Menu_Administrador.setResizable(false);
                Menu_Administrador.setVisible(true);
            }else{
                Operaciones_Sobre_Usuario.setLocationRelativeTo(null);
                Operaciones_Sobre_Usuario.setResizable(false);
                Operaciones_Sobre_Usuario.setVisible(true);
                LoginSeleccion = "";
                jLabel1.setText("Seleccione un Usuario de la Lista de Usuarios");
            }
            
        }       
    }//GEN-LAST:event_Cancelar_Modificacion_Datos_UsuarioActionPerformed

    private void Eliminar_Usuario_FuncionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Eliminar_Usuario_FuncionActionPerformed
        // TODO add your handling code here:
        if(!LoginSeleccion.equals("")){
            boolean Eliminado = false;
            String UsuarioEliminar = " ***  Usuario Que Eliminaras  *** "; 
            for (int i = 0; i < ListaUsuariosRegistrados.size(); i++) {
                if(ListaUsuariosRegistrados.get(i).getLogin().equals(LoginSeleccion)){
                    UsuarioEliminar = UsuarioEliminar + "\nNombre : " + ListaUsuariosRegistrados.get(i).getNombre();
                    UsuarioEliminar = UsuarioEliminar + "\nApellido : " + ListaUsuariosRegistrados.get(i).getApellido();
                    UsuarioEliminar = UsuarioEliminar + "\nLogin : " + ListaUsuariosRegistrados.get(i).getLogin();

                    UsuarioEliminar = UsuarioEliminar + "\n\t Decea Continuar ? " ;
                }
            }
            if (JOptionPane.showConfirmDialog(null, UsuarioEliminar, "CONFIRMAR",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                try {
                    Eliminado = ObjRemotoAdministrador.eliminarUsuario(LoginSeleccion);                       
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Excepcion generada al invocar al método remoto <<Eliminar Usuario>>.....!!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                if(Eliminado){
                    JOptionPane.showMessageDialog(null, "Usuario Eliminado Exitosamente .....!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                    jLabel1.setText("Seleccione un Usuario de la Lista de Usuarios");
                    Consultar_Usuarios_Registrados();
                }else{
                    JOptionPane.showMessageDialog(null, "No fue posible eliminar el Usuario .....!!", "Error", JOptionPane.ERROR_MESSAGE);
                }  
            } 
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar un usuario de la Lista .....!!", "Error", JOptionPane.ERROR_MESSAGE);
        }        
    }//GEN-LAST:event_Eliminar_Usuario_FuncionActionPerformed

    private void Seleccion_Usuario_evt(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Seleccion_Usuario_evt
        // TODO add your handling code here:
        int index = jList1.getSelectedIndex();
        LoginSeleccion = (String)modeloLista.getElementAt(index);
        jLabel1.setText("Seleccionaste al Usuario : "+LoginSeleccion);       
    }//GEN-LAST:event_Seleccion_Usuario_evt

    private void jButtonEditarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarPerfilActionPerformed
        Usuario admin = new Usuario();
        try {
            admin = ObjRemotoAdministrador.consultarUsuario(loginAdmin, true);
        } catch (RemoteException ex) {
            System.out.println("Excepcion al obtener informacion del administador "+ex);
        }
        Nombre_Usuario_Modificar_JTextFiel.setText(admin.getNombre());
        Apellido_Usuario_Modificar_JTextFiel.setText(admin.getApellido());
        Login_Usuario_Mod.setText(admin.getLogin());
        Contraseña_Usuario_Modificar_JTextFiel.setText(admin.getClave());
        
        editandoAdmin = true;
        
        Menu_Administrador.setVisible(false);
        Modificar_Datos_Usuario.setLocationRelativeTo(null);
        Modificar_Datos_Usuario.setResizable(false);
        Modificar_Datos_Usuario.setVisible(true);
    }//GEN-LAST:event_jButtonEditarPerfilActionPerformed

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
    private javax.swing.JTextField Apellido_Usuario_Modificar_JTextFiel;
    private javax.swing.JLabel Apellido_Usuario_Modificar_Label;
    private javax.swing.JButton Autenticar_Administrador_btn;
    private javax.swing.JButton Cancelar_Modificacion_Datos_Usuario;
    private javax.swing.JPasswordField Clave_admin;
    private javax.swing.JTextField Contraseña_Usuario_Modificar_JTextFiel;
    private javax.swing.JLabel Contraseña_Usuario_Modificar_Label;
    private javax.swing.JButton Eliminar_Usuario_Funcion;
    private javax.swing.JButton Estadisticas_btn;
    private javax.swing.JButton Guardar_Cambios_Modificacion;
    private javax.swing.JLabel Login_Usuario_Mod;
    private javax.swing.JLabel Login_Usuario_Modificar_Label;
    private javax.swing.JFrame Menu_Administrador;
    private javax.swing.JFrame Modificar_Datos_Usuario;
    private javax.swing.JButton Modificar_Datos_Usuario_Funcion;
    private javax.swing.JButton Modificar_Datos_Usuario_btn;
    private javax.swing.JTextField Nombre_Usuario_Modificar_JTextFiel;
    private javax.swing.JLabel Nombre_Usuario_Modificar_Label;
    private javax.swing.JFrame Operaciones_Sobre_Usuario;
    private javax.swing.JButton Registrar_Usuario;
    private javax.swing.JButton Registrar_Usuario_btn;
    private javax.swing.JFrame Registro_Usuario;
    private javax.swing.JButton Regresar_M_Principal;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonEditarPerfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables

    private void obtenerObjetoRemoto() {
        try {
            ObjRemotoAdministrador = (UsuariosInt) UtilidadesRegistroC.obtenerObjRemoto(numPuertoRMIRegistry, direccionIpRMIRegistry, "ServidorUsuarios");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error. Obteniendo el objeto remoto ", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private boolean Consultar_Usuarios_Registrados(){
        jLabel1.setText("Seleccione un Usuario de la Lista de Usuarios");
        ListaUsuariosRegistrados.clear();
        modeloLista.clear();
        LoginSeleccion = "";
        
        try {
            ListaUsuariosRegistrados = ObjRemotoAdministrador.listarUsuariosRegistrados();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Excepcion generada al invocar al método remoto <<Listar Usuarios Registrados>>.....!!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        if(!ListaUsuariosRegistrados.isEmpty()){
            for (Usuario ListaUsuariosRegistrado : ListaUsuariosRegistrados) {
                modeloLista.addElement(ListaUsuariosRegistrado.getLogin());
            }
            jList1.setModel(modeloLista);
            return true;
        }else{
            return false;
        } 
    }
    
    public void mostrarMenu(String login){
        this.loginAdmin = login;
        this.setVisible(false);
        Menu_Administrador.setLocationRelativeTo(null);
        Menu_Administrador.setResizable(false);
        Menu_Administrador.setVisible(true);
    }
    
}
