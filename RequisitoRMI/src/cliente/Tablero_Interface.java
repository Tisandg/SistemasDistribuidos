
package cliente;

import java.applet.AudioClip;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import sop_rmi.Cronometro;
import sop_rmi.Ficha;
import sop_rmi.JugarInt;

/**
 *
 * @author Kevin Chantré
 */
public class Tablero_Interface extends javax.swing.JFrame {

    private static JugarInt objRemoto_Juego;
    private static CallBackJuegoInt objRemotoCallBackJuego;
    private boolean Anfitrion;
    Lienzo Mi_Lienzo;
    Utilidades utilidades;
    ArrayList<Ficha> Mis_Fichas;
    int numPuertoRMIRegistry = 0;
    String direccionIpRMIRegistry = "";
    String UsuarioActual;
    String UsuarioContrincante;
    int NumeroFichasPartida;
    public Cronometro miCronometro;
    public static int Hora = 0;
    public static int minuto = 0;
    public static int segundo = 0;
    public static boolean IniciaHilo = true;
    
    public Tablero_Interface(String UsuarioActual, String UsuarioContrincante, int NumeroFichasPartida,int numPuertoRMIRegistry, String direccionIpRMIRegistry, boolean Anfitrion) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.numPuertoRMIRegistry = numPuertoRMIRegistry;
        this.direccionIpRMIRegistry = direccionIpRMIRegistry;
        this.UsuarioActual = UsuarioActual;
        this.UsuarioContrincante = UsuarioContrincante;
        this.NumeroFichasPartida = NumeroFichasPartida;
        this.Mis_Fichas = new ArrayList<>();
        this.Mi_Lienzo = new Lienzo();
        this.utilidades = new Utilidades(NumeroFichasPartida/2);
        this.Anfitrion = Anfitrion;
        IniciarTablero();
    }

    public Tablero_Interface() {
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        Mi_Numero_Fichas_Label = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        Cronometro_Label = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton27 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        Ficha_1_Label = new javax.swing.JLabel();
        Ficha_2_Label = new javax.swing.JLabel();
        Ficha_3_Label = new javax.swing.JLabel();
        Ficha_4_Label = new javax.swing.JLabel();
        Ficha_5_Label = new javax.swing.JLabel();
        Ficha_6_Label = new javax.swing.JLabel();
        Ficha_7_Label = new javax.swing.JLabel();
        Ficha_8_Label = new javax.swing.JLabel();
        Ficha_9_Label = new javax.swing.JLabel();
        Ficha_10_Label = new javax.swing.JLabel();
        Ficha_11_Label = new javax.swing.JLabel();
        Ficha_12_Label = new javax.swing.JLabel();
        Ficha_13_Label = new javax.swing.JLabel();
        Ficha_14_Label = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        Usuario1_Lb = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        Usuario2_Lb = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1360, 760));
        setMinimumSize(new java.awt.Dimension(1360, 760));

        jPanel9.setMaximumSize(new java.awt.Dimension(1366, 747));
        jPanel9.setMinimumSize(new java.awt.Dimension(1366, 747));

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Cantidad de Fichas colocadas:       ");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Cantidad de Fichas que  aún quedan:    ");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Cantidad de puntos que suman las fichas que tienes:   ");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Es tu turno, Selecciona una ficha     ");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setText("0");

        Mi_Numero_Fichas_Label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Mi_Numero_Fichas_Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Mi_Numero_Fichas_Label.setText("14");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setText("0");

        jLabel59.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel59.setText("Tiempo Transcurrido  :  ");

        Cronometro_Label.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Cronometro_Label.setForeground(new java.awt.Color(0, 51, 204));
        Cronometro_Label.setText("00 : 00 : 00");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(18, 18, 18)
                        .addComponent(Mi_Numero_Fichas_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel23)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel59)
                        .addGap(18, 18, 18)
                        .addComponent(Cronometro_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(253, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel25))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel27))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel23))
                    .addComponent(Mi_Numero_Fichas_Label))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(Cronometro_Label))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("Chat con tu Contrincante");

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton27.setForeground(new java.awt.Color(0, 0, 153));
        jButton27.setText("Enviar");

        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel24)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                        .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel24)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jButton27))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel12.setMaximumSize(new java.awt.Dimension(1310, 272));
        jPanel12.setMinimumSize(new java.awt.Dimension(1310, 272));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel13.setMaximumSize(new java.awt.Dimension(1283, 168));
        jPanel13.setMinimumSize(new java.awt.Dimension(1283, 168));

        Ficha_1_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ninguna.png"))); // NOI18N
        Ficha_1_Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Ficha_1_LabelMouseClicked(evt);
            }
        });

        Ficha_2_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ninguna.png"))); // NOI18N
        Ficha_2_Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Ficha_2_LabelMouseClicked(evt);
            }
        });

        Ficha_3_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ninguna.png"))); // NOI18N
        Ficha_3_Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Ficha_3_LabelMouseClicked(evt);
            }
        });

        Ficha_4_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ninguna.png"))); // NOI18N

        Ficha_5_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ninguna.png"))); // NOI18N

        Ficha_6_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ninguna.png"))); // NOI18N

        Ficha_7_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ninguna.png"))); // NOI18N

        Ficha_8_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ninguna.png"))); // NOI18N

        Ficha_9_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ninguna.png"))); // NOI18N

        Ficha_10_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ninguna.png"))); // NOI18N

        Ficha_11_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ninguna.png"))); // NOI18N

        Ficha_12_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ninguna.png"))); // NOI18N

        Ficha_13_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ninguna.png"))); // NOI18N

        Ficha_14_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ninguna.png"))); // NOI18N

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("1");

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("2");

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("3");

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setText("4");

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("5");

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setText("6");

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("7");

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel52.setText("8");

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel53.setText("9");

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setText("10");

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel55.setText("11");

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel56.setText("12");

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel57.setText("13");

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel58.setText("14");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Ficha_1_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Ficha_2_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Ficha_3_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Ficha_4_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Ficha_5_Label)
                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Ficha_6_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Ficha_7_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Ficha_8_Label))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Ficha_9_Label))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Ficha_10_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Ficha_11_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Ficha_12_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Ficha_13_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Ficha_14_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(Ficha_14_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel58))
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel13Layout.createSequentialGroup()
                            .addComponent(Ficha_13_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel57))
                        .addGroup(jPanel13Layout.createSequentialGroup()
                            .addComponent(Ficha_11_Label)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel55))
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(Ficha_10_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel54))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(Ficha_9_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel53))
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel13Layout.createSequentialGroup()
                                    .addComponent(Ficha_7_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel51))
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addComponent(Ficha_6_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel50))
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addComponent(Ficha_5_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel49))
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addComponent(Ficha_4_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel48))
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(Ficha_8_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(Ficha_3_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(Ficha_12_Label)
                                            .addComponent(Ficha_1_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(Ficha_2_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel33)
                                                .addComponent(jLabel32)
                                                .addComponent(jLabel31))
                                            .addComponent(jLabel52)
                                            .addComponent(jLabel56))))))))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        Usuario1_Lb.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Usuario1_Lb.setForeground(new java.awt.Color(255, 0, 0));
        Usuario1_Lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Usuario1_Lb.setText("Usuario1");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 0, 0));
        jLabel29.setText("VS");

        Usuario2_Lb.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Usuario2_Lb.setForeground(new java.awt.Color(255, 0, 0));
        Usuario2_Lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Usuario2_Lb.setText("Usario2");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(501, 501, 501)
                        .addComponent(Usuario1_Lb, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Usuario2_Lb, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)
                                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 1300, Short.MAX_VALUE))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Usuario1_Lb)
                    .addComponent(jLabel29)
                    .addComponent(Usuario2_Lb))
                .addGap(3, 3, 3)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29))
        );

        jMenu1.setText("Menu");

        jMenuItem2.setText("Menú  de Juego");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem1.setText("Salir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ayuda");

        jMenuItem3.setText("Como Jugar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 739, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Una vez abandnes la partida, se perderan todos los avances \n¿Deseas salir?", "CONFIRMAR",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            IniciaHilo = false;
            this.setVisible(false);
            new Usuario_Interface(numPuertoRMIRegistry, direccionIpRMIRegistry).setVisible(true);
        }
            
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        IniciaHilo = false;
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // como Jugar
        //canvas1.repaint();

    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void Ficha_1_LabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Ficha_1_LabelMouseClicked
        // Al Clickear la ficha 1
        Ficha_1_Label.enable(false);
        System.out.println("clickeaste aqui");
    }//GEN-LAST:event_Ficha_1_LabelMouseClicked

    private void Ficha_2_LabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Ficha_2_LabelMouseClicked
        // Al Clickear la ficha 2
    }//GEN-LAST:event_Ficha_2_LabelMouseClicked

    private void Ficha_3_LabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Ficha_3_LabelMouseClicked
        // Al Clickear la ficha 3
    }//GEN-LAST:event_Ficha_3_LabelMouseClicked

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
            java.util.logging.Logger.getLogger(Tablero_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tablero_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tablero_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tablero_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tablero_Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cronometro_Label;
    private javax.swing.JLabel Ficha_10_Label;
    private javax.swing.JLabel Ficha_11_Label;
    private javax.swing.JLabel Ficha_12_Label;
    private javax.swing.JLabel Ficha_13_Label;
    private javax.swing.JLabel Ficha_14_Label;
    private javax.swing.JLabel Ficha_1_Label;
    private javax.swing.JLabel Ficha_2_Label;
    private javax.swing.JLabel Ficha_3_Label;
    private javax.swing.JLabel Ficha_4_Label;
    private javax.swing.JLabel Ficha_5_Label;
    private javax.swing.JLabel Ficha_6_Label;
    private javax.swing.JLabel Ficha_7_Label;
    private javax.swing.JLabel Ficha_8_Label;
    private javax.swing.JLabel Ficha_9_Label;
    private javax.swing.JLabel Mi_Numero_Fichas_Label;
    private javax.swing.JLabel Usuario1_Lb;
    private javax.swing.JLabel Usuario2_Lb;
    private javax.swing.JButton jButton27;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables

    private void IniciarHiloCronometro() {   
        if(IniciaHilo == true){
            System.out.println("Inicia el Hilo del Cronometro.....\n");
            miCronometro = new Cronometro(Cronometro_Label);
            miCronometro.start();   
        }
    }
    
    private void mi_play(){
        AudioClip Sonido;
        Sonido = java.applet.Applet.newAudioClip(getClass().getResource("/imagenes/switch-3.wav"));
        Sonido.play();
    }
    
    private void ObtenerObjetoRemoto(){
        try {
            objRemoto_Juego = (JugarInt) UtilidadesRegistroC.obtenerObjRemoto(numPuertoRMIRegistry, direccionIpRMIRegistry, "ServidorJuego");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error. No se podido obtener la referencia al Objeto Remoto <<ServidorJuego>>", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void IniciarTablero(){
        IniciarHiloCronometro();
        Usuario1_Lb.setText(UsuarioActual);
        Usuario2_Lb.setText(UsuarioContrincante);
        Mi_Numero_Fichas_Label.setText(Integer.toString(NumeroFichasPartida/2));
        ObtenerObjetoRemoto();
        ArrayList<Ficha> Sus_Fichas = new ArrayList<>();
        try {
            objRemoto_Juego.registrarReferenciaRemotaTablro(UsuarioActual, null);
        } catch (Exception e) {
            
        }
        if(Anfitrion){
            try {
                objRemoto_Juego.repartirFichas(NumeroFichasPartida);
                try {
                    Mis_Fichas = objRemoto_Juego.getFichasJugador1();
                    Sus_Fichas = objRemoto_Juego.getFichasJugador2();
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error. Invocando la operacion Remota << Obtenr Mis Fichas >> ", "Error", JOptionPane.ERROR_MESSAGE);
                    System.out.println("Error = "+e.getMessage());
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error. Invocando la operacion Remota << Repartir Fichas >> ", "Error", JOptionPane.ERROR_MESSAGE);            
                System.out.println("Error = "+e.getMessage());
            }
        }
        
        
//        if(!Mis_Fichas.isEmpty()){
//            for (int i = 0; i < Mis_Fichas.size(); i++) {
//                System.out.println("Ficha "+i+" Lado A = "+Mis_Fichas.get(i).getLado_A());
//                System.out.println("Ficha "+i+" Lado B = "+Mis_Fichas.get(i).getLado_B());
//                System.out.println("_______________________________________________________________");
//            }
//        }else{
//            JOptionPane.showMessageDialog(null, "Error. No has resivido ninguna Ficha", "Error", JOptionPane.ERROR_MESSAGE);
//        }
//        
//        if(!Sus_Fichas.isEmpty()){
//            System.out.println("#############################################################");
//            for (int i = 0; i < Mis_Fichas.size(); i++) {
//                System.out.println("Ficha "+i+" Lado A = "+Sus_Fichas.get(i).getLado_A());
//                System.out.println("Ficha "+i+" Lado B = "+Sus_Fichas.get(i).getLado_B());
//                System.out.println("_______________________________________________________________");
//            }
//        }else{
//            JOptionPane.showMessageDialog(null, "Error. No has resivido ninguna Ficha", "Error", JOptionPane.ERROR_MESSAGE);
//        }
        
        Pintar_Mis_Fichas();
               
    }
    
    public void Resivir_Fichas(ArrayList<Ficha> Mis_Fichas){
        this.Mis_Fichas = Mis_Fichas;
        Pintar_Mis_Fichas();
    }
    
    private void Pintar_Mis_Fichas(){
        Ficha_1_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource(utilidades.Buscar_Imagen(Mis_Fichas.get(0)))));
        Ficha_2_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource(utilidades.Buscar_Imagen(Mis_Fichas.get(1)))));
        Ficha_3_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource(utilidades.Buscar_Imagen(Mis_Fichas.get(2)))));
        Ficha_4_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource(utilidades.Buscar_Imagen(Mis_Fichas.get(3)))));
        Ficha_5_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource(utilidades.Buscar_Imagen(Mis_Fichas.get(4)))));
        Ficha_6_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource(utilidades.Buscar_Imagen(Mis_Fichas.get(5)))));
        Ficha_7_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource(utilidades.Buscar_Imagen(Mis_Fichas.get(6)))));
        Ficha_8_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource(utilidades.Buscar_Imagen(Mis_Fichas.get(7)))));
        if(Mis_Fichas.size() == 9){
            Ficha_9_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource(utilidades.Buscar_Imagen(Mis_Fichas.get(8)))));
            if(Mis_Fichas.size() == 10){
                Ficha_10_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource(utilidades.Buscar_Imagen(Mis_Fichas.get(9)))));                
                if(Mis_Fichas.size() > 11){
                    Ficha_11_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource(utilidades.Buscar_Imagen(Mis_Fichas.get(10)))));              
                    if(Mis_Fichas.size() > 12){
                        Ficha_12_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource(utilidades.Buscar_Imagen(Mis_Fichas.get(11)))));              
                        if(Mis_Fichas.size() > 13){
                            Ficha_13_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource(utilidades.Buscar_Imagen(Mis_Fichas.get(12)))));              
                            if(Mis_Fichas.size() > 14){
                                Ficha_14_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource(utilidades.Buscar_Imagen(Mis_Fichas.get(13)))));              
                            }
                        }
                    }
                }
            }
            
        }
    }
    
}
