
package cliente;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import sop_rmi.Ficha;
import sop_rmi.UsuariosInt;

/**
 *
 * @author Kevin Chantré
 */
public class Usuario_Interface extends javax.swing.JFrame {

    private static UsuariosInt ObjRemotoUsuario;
    int numPuertoRMIRegistry = 0;
    String direccionIpRMIRegistry = "";
    DefaultListModel modeloLista = new DefaultListModel();
    private String LoginContrincante;
    private int Numero_Fichas_Partida = 0;
    private static UsuarioCallBackInt objRemotoCallbk;
    private boolean AceptarInvitacion;
    
    public Usuario_Interface(int numPuertoRMIRegistry, String direccionIpRMIRegistry) {
        initComponents();
        LoginContrincante = "";
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.numPuertoRMIRegistry = numPuertoRMIRegistry;
        this.direccionIpRMIRegistry = direccionIpRMIRegistry;
        this.AceptarInvitacion = false;
        obtenerObjetoRemoto();
    }

    public Usuario_Interface() {
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menu_Juego = new javax.swing.JFrame();
        jPanel8 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        Empezar_Partida_btn = new javax.swing.JButton();
        Consultar_Estadisticas_btn = new javax.swing.JButton();
        Chat_Entre_Jugadores_btn = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        Menu_Principal_btn = new javax.swing.JButton();
        Usuario_Actual_Lb = new javax.swing.JLabel();
        Seleccionar_Jugador_Red = new javax.swing.JFrame();
        jPanel16 = new javax.swing.JPanel();
        Mostrar_Jugadores_Conectados = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel63 = new javax.swing.JLabel();
        Aceptar_Seleccion_De_Contrincante = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        Elegir_Numero_Fichas = new javax.swing.JFrame();
        jPanel17 = new javax.swing.JPanel();
        jComboBox3 = new javax.swing.JComboBox();
        Regresar_MenuJuego = new javax.swing.JButton();
        Seleccionar_NumeroFichas_btn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        Login_Usuario_JtextField = new javax.swing.JTextField();
        Autentificar_Usr = new javax.swing.JButton();
        Regresar_Menu_Principal = new javax.swing.JButton();
        Clave_Usuario_Jpassword = new javax.swing.JPasswordField();

        Menu_Juego.setMinimumSize(new java.awt.Dimension(350, 410));

        jPanel8.setMaximumSize(new java.awt.Dimension(350, 410));
        jPanel8.setMinimumSize(new java.awt.Dimension(350, 410));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 0, 0));
        jLabel18.setText(" Domino RMI");

        Empezar_Partida_btn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Empezar_Partida_btn.setForeground(new java.awt.Color(0, 0, 204));
        Empezar_Partida_btn.setText("Empezar Partida");
        Empezar_Partida_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Empezar_Partida_btnActionPerformed(evt);
            }
        });

        Consultar_Estadisticas_btn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Consultar_Estadisticas_btn.setForeground(new java.awt.Color(0, 0, 204));
        Consultar_Estadisticas_btn.setText("Consultar Estadisticas");

        Chat_Entre_Jugadores_btn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Chat_Entre_Jugadores_btn.setForeground(new java.awt.Color(0, 0, 204));
        Chat_Entre_Jugadores_btn.setText("Chat entre Jugadores");

        jButton26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton26.setText("Salir");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        Menu_Principal_btn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Menu_Principal_btn.setText("Menú Principal");
        Menu_Principal_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_Principal_btnActionPerformed(evt);
            }
        });

        Usuario_Actual_Lb.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Usuario_Actual_Lb.setForeground(new java.awt.Color(204, 0, 0));
        Usuario_Actual_Lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Usuario_Actual_Lb.setText("Usuario");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Empezar_Partida_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Consultar_Estadisticas_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                        .addComponent(Chat_Entre_Jugadores_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(Usuario_Actual_Lb, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(55, 55, 55))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(Menu_Principal_btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Usuario_Actual_Lb)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                .addComponent(Empezar_Partida_btn)
                .addGap(18, 18, 18)
                .addComponent(Consultar_Estadisticas_btn)
                .addGap(18, 18, 18)
                .addComponent(Chat_Entre_Jugadores_btn)
                .addGap(85, 85, 85)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Menu_Principal_btn)
                    .addComponent(jButton26))
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout Menu_JuegoLayout = new javax.swing.GroupLayout(Menu_Juego.getContentPane());
        Menu_Juego.getContentPane().setLayout(Menu_JuegoLayout);
        Menu_JuegoLayout.setHorizontalGroup(
            Menu_JuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        Menu_JuegoLayout.setVerticalGroup(
            Menu_JuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Seleccionar_Jugador_Red.setMinimumSize(new java.awt.Dimension(330, 360));

        jPanel16.setMaximumSize(new java.awt.Dimension(330, 360));
        jPanel16.setMinimumSize(new java.awt.Dimension(330, 360));

        Mostrar_Jugadores_Conectados.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Mostrar_Jugadores_Conectados.setForeground(new java.awt.Color(0, 0, 153));
        Mostrar_Jugadores_Conectados.setText("Mostrar Jugadores Conectados");
        Mostrar_Jugadores_Conectados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mostrar_Jugadores_ConectadosActionPerformed(evt);
            }
        });

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1Seleccionar_Usuario_Conectado_jlist(evt);
            }
        });
        jScrollPane6.setViewportView(jList1);

        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(153, 0, 0));
        jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel63.setText("Selecciona un Jugador de la Lista");

        Aceptar_Seleccion_De_Contrincante.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Aceptar_Seleccion_De_Contrincante.setForeground(new java.awt.Color(0, 0, 153));
        Aceptar_Seleccion_De_Contrincante.setText("Aceptar");
        Aceptar_Seleccion_De_Contrincante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Aceptar_Seleccion_De_ContrincanteActionPerformed(evt);
            }
        });

        jButton13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton13.setForeground(new java.awt.Color(0, 0, 153));
        jButton13.setText("Regresar");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Aceptar_Seleccion_De_Contrincante, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Mostrar_Jugadores_Conectados, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel63, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel63)
                .addGap(29, 29, 29)
                .addComponent(Mostrar_Jugadores_Conectados)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Aceptar_Seleccion_De_Contrincante)
                    .addComponent(jButton13))
                .addGap(53, 53, 53))
        );

        javax.swing.GroupLayout Seleccionar_Jugador_RedLayout = new javax.swing.GroupLayout(Seleccionar_Jugador_Red.getContentPane());
        Seleccionar_Jugador_Red.getContentPane().setLayout(Seleccionar_Jugador_RedLayout);
        Seleccionar_Jugador_RedLayout.setHorizontalGroup(
            Seleccionar_Jugador_RedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Seleccionar_Jugador_RedLayout.setVerticalGroup(
            Seleccionar_Jugador_RedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Elegir_Numero_Fichas.setMinimumSize(new java.awt.Dimension(370, 230));

        jPanel17.setMaximumSize(new java.awt.Dimension(370, 230));
        jPanel17.setMinimumSize(new java.awt.Dimension(370, 230));

        jComboBox3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBox3.setForeground(new java.awt.Color(0, 0, 153));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "N° Fichas", "16 Fichas", "18 Fichas", "20 Fichas", "22 Fichas", "24 Fichas", "26 Fichas", "28 Fichas"}));

        Regresar_MenuJuego.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Regresar_MenuJuego.setText("Cancelar");
        Regresar_MenuJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Regresar_MenuJuegoActionPerformed(evt);
            }
        });

        Seleccionar_NumeroFichas_btn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Seleccionar_NumeroFichas_btn.setForeground(new java.awt.Color(0, 0, 153));
        Seleccionar_NumeroFichas_btn.setText("Seleccionar");
        Seleccionar_NumeroFichas_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Seleccionar_NumeroFichas_btnActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Seleccione el numero de fichas con las cuales decea Jugar");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Seleccionar_NumeroFichas_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Regresar_MenuJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104))
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(55, 55, 55)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Seleccionar_NumeroFichas_btn))
                .addGap(29, 29, 29)
                .addComponent(Regresar_MenuJuego)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Elegir_Numero_FichasLayout = new javax.swing.GroupLayout(Elegir_Numero_Fichas.getContentPane());
        Elegir_Numero_Fichas.getContentPane().setLayout(Elegir_Numero_FichasLayout);
        Elegir_Numero_FichasLayout.setHorizontalGroup(
            Elegir_Numero_FichasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Elegir_Numero_FichasLayout.setVerticalGroup(
            Elegir_Numero_FichasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(430, 270));
        setMinimumSize(new java.awt.Dimension(430, 270));

        jPanel7.setMinimumSize(new java.awt.Dimension(431, 270));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 0, 0));
        jLabel15.setText("Autentificar Usuario");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 204));
        jLabel16.setText("Login");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 204));
        jLabel17.setText("Clave");

        Login_Usuario_JtextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Login_Usuario_JtextField.setForeground(new java.awt.Color(0, 0, 204));

        Autentificar_Usr.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Autentificar_Usr.setForeground(new java.awt.Color(0, 0, 153));
        Autentificar_Usr.setText("Ingresar");
        Autentificar_Usr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Autentificar_UsrActionPerformed(evt);
            }
        });

        Regresar_Menu_Principal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Regresar_Menu_Principal.setForeground(new java.awt.Color(0, 0, 153));
        Regresar_Menu_Principal.setText("Regresar");
        Regresar_Menu_Principal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Regresar_Menu_PrincipalActionPerformed(evt);
            }
        });

        Clave_Usuario_Jpassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Clave_Usuario_Jpassword.setForeground(new java.awt.Color(0, 0, 153));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Login_Usuario_JtextField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Clave_Usuario_Jpassword))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(Regresar_Menu_Principal, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Autentificar_Usr, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(63, 63, 63))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel15)
                .addGap(33, 33, 33)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Login_Usuario_JtextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(Clave_Usuario_Jpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Regresar_Menu_Principal)
                    .addComponent(Autentificar_Usr))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Autentificar_UsrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Autentificar_UsrActionPerformed
        // Autentificar Usuario
        String login = "";
        String clave = "";
        boolean inicio = false;
        if(Login_Usuario_JtextField.getText().equals("") || Clave_Usuario_Jpassword.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Espacios sin llenar.....!!", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            login = Login_Usuario_JtextField.getText();
            clave = Clave_Usuario_Jpassword.getText();

            try {
                inicio = ObjRemotoUsuario.iniciarSesion(login, clave, false);
                if(inicio){
                    objRemotoCallbk = new UsuarioCallBackImpl(this);
                    ObjRemotoUsuario.registrarReferenciaRemota(login, objRemotoCallbk);
                    this.setVisible(false);
                    Menu_Juego.setLocationRelativeTo(null);
                    Menu_Juego.setResizable(false);
                    Menu_Juego.setVisible(true);
                    Usuario_Actual_Lb.setText(login);
                }else{
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña Invalida. Inserte los datos nuevamente.....!!", "Error", JOptionPane.ERROR_MESSAGE);
                    Login_Usuario_JtextField.setText("");
                    Clave_Usuario_Jpassword.setText("");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Excepcion generada al invocar al método remoto <<Iniciar Sesion>>.....!!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_Autentificar_UsrActionPerformed

    private void Regresar_Menu_PrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Regresar_Menu_PrincipalActionPerformed
        // regresar al menu de usuario
        this.setVisible(false);
        new Menu_Principal(numPuertoRMIRegistry, direccionIpRMIRegistry).setVisible(true);
    }//GEN-LAST:event_Regresar_Menu_PrincipalActionPerformed

    private void Empezar_Partida_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Empezar_Partida_btnActionPerformed
        // Empezar Partida
        String msg = "Antes de empezar una partida debes relizar algunas configuraciones como: \n"
        + "\t Elegir un jugador en linea para enfrentarlo..\n"
        + "\t Determinar el numero de fichas con las cuales se Jugara \n"
        + "\nDeseas Continuar";
        if (JOptionPane.showConfirmDialog(null, msg, "CONFIRMAR",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            Menu_Juego.setVisible(false);
            Seleccionar_Jugador_Red.setLocationRelativeTo(null);
            Seleccionar_Jugador_Red.setResizable(false);
            Seleccionar_Jugador_Red.setVisible(true);
        }

    }//GEN-LAST:event_Empezar_Partida_btnActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton26ActionPerformed

    private void Menu_Principal_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_Principal_btnActionPerformed
        // Estando en menu de juego regresamos al menu principal
        Menu_Juego.setVisible(false);
        new Menu_Principal(numPuertoRMIRegistry, direccionIpRMIRegistry).setVisible(true);
    }//GEN-LAST:event_Menu_Principal_btnActionPerformed

    private void Mostrar_Jugadores_ConectadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mostrar_Jugadores_ConectadosActionPerformed
        // Muestra los usuarios conectados
        ArrayList<String> ListaUsuarios = new ArrayList<>();

        try {
            ListaUsuarios = ObjRemotoUsuario.listarUsuariosConectados(Usuario_Actual_Lb.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Excepcion generada al invocar al método remoto .....!!", "Error", JOptionPane.ERROR_MESSAGE);
        }

        if(!ListaUsuarios.isEmpty()){
            for (int i = 0; i < ListaUsuarios.size(); i++) {
                System.out.println("usuario : " + ListaUsuarios.get(i));
                modeloLista.addElement(ListaUsuarios.get(i));
            }
        }
        jList1.setModel(modeloLista);
    }//GEN-LAST:event_Mostrar_Jugadores_ConectadosActionPerformed

    private void jList1Seleccionar_Usuario_Conectado_jlist(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1Seleccionar_Usuario_Conectado_jlist
        // Seleccion del login del contrincante
        int index= jList1.getSelectedIndex();
        LoginContrincante = (String)modeloLista.getElementAt(index);
        jLabel63.setText("Seleccionaste a "+LoginContrincante);
    }//GEN-LAST:event_jList1Seleccionar_Usuario_Conectado_jlist

    private void Aceptar_Seleccion_De_ContrincanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Aceptar_Seleccion_De_ContrincanteActionPerformed
        // TODO add your handling code here:
        if(LoginContrincante.equals("")){
            JOptionPane.showMessageDialog(null, "Error. No has seleccionado a ningun gugador de la lista ", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Se almacenara a "+LoginContrincante+" como tu contrincante", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            try {
                ObjRemotoUsuario.establecerComunicacion(Usuario_Actual_Lb.getText(), LoginContrincante);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Excepcion generada al invocar al método remoto <<Establecer Comunicacion>>.....!!", "Error", JOptionPane.ERROR_MESSAGE);
            }   
            Seleccionar_Jugador_Red.setVisible(false);
            Elegir_Numero_Fichas.setLocationRelativeTo(null);
            Elegir_Numero_Fichas.setResizable(false);
            Elegir_Numero_Fichas.setVisible(true);
        }
    }//GEN-LAST:event_Aceptar_Seleccion_De_ContrincanteActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        if(LoginContrincante.equals("")){
            if (JOptionPane.showConfirmDialog(null, "No has Seleccionado ningun Usuario de la lista \n Realmente deseas regresar al menu de Juego", "CONFIRMAR",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                Seleccionar_Jugador_Red.setVisible(false);
                Menu_Juego.setLocationRelativeTo(null);
                Menu_Juego.setResizable(false);
                Menu_Juego.setVisible(true);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Se almacenara a "+LoginContrincante+" como tu contrincante", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            LoginContrincante = "";
            Seleccionar_Jugador_Red.setVisible(false);
            Menu_Juego.setLocationRelativeTo(null);
            Menu_Juego.setResizable(false);
            Menu_Juego.setVisible(true);
        }

    }//GEN-LAST:event_jButton13ActionPerformed

    private void Regresar_MenuJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Regresar_MenuJuegoActionPerformed
        // TODO add your handling code here:
        Elegir_Numero_Fichas.setVisible(false);
        Menu_Juego.setLocationRelativeTo(null);
        Menu_Juego.setResizable(false);
        Menu_Juego.setVisible(true);
    }//GEN-LAST:event_Regresar_MenuJuegoActionPerformed

    private void Seleccionar_NumeroFichas_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Seleccionar_NumeroFichas_btnActionPerformed
        // Configuramos la partida con el numero de fichas con las cuales queremos jugar
        //Se da inicio a la partida
        String NumeroFichas = jComboBox3.getSelectedItem().toString();
        boolean enviarInvitacion = false;
<<<<<<< HEAD
        boolean iniciaJuego = false;
=======
>>>>>>> origin/master
        if(NumeroFichas.equals("N° Fichas")){
            JOptionPane.showMessageDialog(null, "Debe seleccionar un numero de fichas .....!!", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            System.out.println("Fichas : "+NumeroFichas);
            String [] v = NumeroFichas.split(" ");
            Numero_Fichas_Partida = Integer.parseInt(v[0]);
            JOptionPane.showMessageDialog(null, "\tResumen \n\nJugaras contra "+LoginContrincante+"\ncada jugador iniciara con "+Numero_Fichas_Partida/2+" Fichas", "Resumen", JOptionPane.INFORMATION_MESSAGE);
            try {
                enviarInvitacion = ObjRemotoUsuario.EnviarInvitacion(Usuario_Actual_Lb.getText(), LoginContrincante, "Te reto a un DUUU..ELO...!!!", Numero_Fichas_Partida);
            } catch (Exception e) {
<<<<<<< HEAD
                JOptionPane.showMessageDialog(null, "Este es el Error"+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
=======
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
>>>>>>> origin/master
            }
            if(enviarInvitacion){
                if(AceptarInvitacion){
                    System.out.println("El usuario Acepto la invitacion...");
<<<<<<< HEAD
                    Elegir_Numero_Fichas.setVisible(false);                    
                    try {
                        iniciaJuego = ObjRemotoUsuario.iniciarJuego(Numero_Fichas_Partida, Usuario_Actual_Lb.getText(), LoginContrincante);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Excepcion generada al invocar al método remoto <<Iniciar Juego>>.....!!\n"+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    if(iniciaJuego)
                        System.out.println("Inia el Juego...!!!");
                    else
                        System.out.println("Error.. No es posible Inicar el juego...!");
=======
                    Elegir_Numero_Fichas.setVisible(false);
                    new Tablero_Interface(Usuario_Actual_Lb.getText(), LoginContrincante, Numero_Fichas_Partida, numPuertoRMIRegistry, direccionIpRMIRegistry, true).setVisible(true);                    
>>>>>>> origin/master
                }else{
                    JOptionPane.showMessageDialog(null, "El usuario "+LoginContrincante+" Rechazo la invitacion...!!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                }               
            }else{
                JOptionPane.showMessageDialog(null, "No fue posible enviar la Invitación \n Intenta Nuevamente", "Error", JOptionPane.ERROR_MESSAGE);
                Elegir_Numero_Fichas.setVisible(false);
                Menu_Juego.setLocationRelativeTo(null);
                Menu_Juego.setResizable(false);
                Menu_Juego.setVisible(true);
            }
            
        }
    }//GEN-LAST:event_Seleccionar_NumeroFichas_btnActionPerformed

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
            java.util.logging.Logger.getLogger(Usuario_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usuario_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usuario_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usuario_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Usuario_Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aceptar_Seleccion_De_Contrincante;
    private javax.swing.JButton Autentificar_Usr;
    private javax.swing.JButton Chat_Entre_Jugadores_btn;
    private javax.swing.JPasswordField Clave_Usuario_Jpassword;
    private javax.swing.JButton Consultar_Estadisticas_btn;
    private javax.swing.JFrame Elegir_Numero_Fichas;
    private javax.swing.JButton Empezar_Partida_btn;
    private javax.swing.JTextField Login_Usuario_JtextField;
    private javax.swing.JFrame Menu_Juego;
    private javax.swing.JButton Menu_Principal_btn;
    private javax.swing.JButton Mostrar_Jugadores_Conectados;
    private javax.swing.JButton Regresar_MenuJuego;
    private javax.swing.JButton Regresar_Menu_Principal;
    private javax.swing.JFrame Seleccionar_Jugador_Red;
    private javax.swing.JButton Seleccionar_NumeroFichas_btn;
    private javax.swing.JLabel Usuario_Actual_Lb;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton26;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane6;
    // End of variables declaration//GEN-END:variables

    private void obtenerObjetoRemoto() {
        try {
            ObjRemotoUsuario = (UsuariosInt) UtilidadesRegistroC.obtenerObjRemoto(numPuertoRMIRegistry, direccionIpRMIRegistry, "ServidorUsuarios");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error. Obteniendo el objeto remoto ", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void Enviar_Invitacion(String Login, String Mensaje, int numeroFichas){
        this.Numero_Fichas_Partida = numeroFichas;
<<<<<<< HEAD
        this.LoginContrincante = Login;
=======
>>>>>>> origin/master
        boolean respuesta = false;
        if (JOptionPane.showConfirmDialog(null, "El Usuario " + Login +" Dice : \n"+ Mensaje+" Con "+Numero_Fichas_Partida+" Fichas", "CONFIRMAR",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                respuesta = ObjRemotoUsuario.enviarRespuestaInvitacion(Usuario_Actual_Lb.getText(), Login, true);
<<<<<<< HEAD
                System.out.println("Acepto invitacion");
=======
>>>>>>> origin/master
            } catch (Exception e) {
                System.out.println("No fue posible responder a la Solicitud \n "+e.getMessage());
            }
            if(respuesta){
<<<<<<< HEAD
                System.out.println("Informacion mi Tablero : \n login actual = "+Usuario_Actual_Lb.getText()+"\n contrincante = "+Login);
                //new Tablero_Interface(Usuario_Actual_Lb.getText(), Login, Numero_Fichas_Partida, numPuertoRMIRegistry, direccionIpRMIRegistry, false).setVisible(true);
=======
                new Tablero_Interface(Usuario_Actual_Lb.getText(), Login, Numero_Fichas_Partida, numPuertoRMIRegistry, direccionIpRMIRegistry, false).setVisible(true);
>>>>>>> origin/master
            }
                
        }else{
            try {
                ObjRemotoUsuario.enviarRespuestaInvitacion(Usuario_Actual_Lb.getText(), Login, false);
<<<<<<< HEAD
                System.out.println("Rechaso invitacion");
=======
>>>>>>> origin/master
            } catch (Exception e) {
                System.out.println("No fue posible responder a la Solicitud \n "+e.getMessage());
            }
        }
    }
    
    public void Resivir_respuesta_Invitacion(String login, boolean Respuesta){
        if(Respuesta)
            this.AceptarInvitacion = true;
        else
            this.AceptarInvitacion = false;
    }
    
<<<<<<< HEAD
    public void IniciarJuego(ArrayList<Ficha> Fichas){
        Menu_Juego.setVisible(false);
        new Tablero_Interface(Usuario_Actual_Lb.getText(), LoginContrincante, Fichas, numPuertoRMIRegistry, direccionIpRMIRegistry).setVisible(true);
    }
    
=======
>>>>>>> origin/master
}
