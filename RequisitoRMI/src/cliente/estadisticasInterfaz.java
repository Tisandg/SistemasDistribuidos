package cliente;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sop_rmi.EstadisticasInt;

/**
 * @author Santiago Garcia Ch
 */
public class estadisticasInterfaz extends javax.swing.JFrame {

    private static EstadisticasInt objRemotoEstadisticas;
    private int numPuertoRMIRegistry;
    private String direccionIpRMIRegistry;
    private boolean admin;
    private String login;
    /**
     * Creates new form estadisticasInterfaz
     */
    public estadisticasInterfaz(int numPuertoRMIRegistry, String direccionIpRMIRegistry,String login, boolean admin) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.numPuertoRMIRegistry = numPuertoRMIRegistry;
        this.direccionIpRMIRegistry = direccionIpRMIRegistry;
        this.admin = admin;
        this.login = login;
        obtenerObjetoRemoto();
        try {
            mostrarEstadisticas();
        } catch (RemoteException ex) {
            Logger.getLogger(estadisticasInterfaz.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al generar las estadisticas");
        }
    }

    private estadisticasInterfaz() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonRegresar = new javax.swing.JButton();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelPartidasJugadas = new javax.swing.JLabel();
        jLabelPartidasEmpatadas = new javax.swing.JLabel();
        jLabelNumeroPJ = new javax.swing.JLabel();
        jLabelNumeroPE = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonRegresar.setText("Regresar");
        jButtonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegresarActionPerformed(evt);
            }
        });

        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Estadisticas Domino");

        jLabelPartidasJugadas.setText("Total partidas jugadas:");

        jLabelPartidasEmpatadas.setText("Total partidas empatadas:");

        jLabelNumeroPJ.setText("    ");

        jLabelNumeroPE.setText("    ");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Jugador", "Partidas Ganadas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelPartidasJugadas, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelNumeroPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabelPartidasEmpatadas, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelNumeroPE, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(jButtonRegresar)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPartidasEmpatadas, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNumeroPE)
                    .addComponent(jLabelPartidasJugadas, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNumeroPJ))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonRegresar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegresarActionPerformed
        this.setVisible(false);
        if(admin){
            Administrador_Interface admin = new Administrador_Interface(numPuertoRMIRegistry, direccionIpRMIRegistry);
            admin.mostrarMenu(login);
        }else{
            Usuario_Interface usuario = new Usuario_Interface(numPuertoRMIRegistry, direccionIpRMIRegistry);
            usuario.mostrarMenu(login);
        }
        
    }//GEN-LAST:event_jButtonRegresarActionPerformed

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
            java.util.logging.Logger.getLogger(estadisticasInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(estadisticasInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(estadisticasInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(estadisticasInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new estadisticasInterfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonRegresar;
    private javax.swing.JLabel jLabelNumeroPE;
    private javax.swing.JLabel jLabelNumeroPJ;
    private javax.swing.JLabel jLabelPartidasEmpatadas;
    private javax.swing.JLabel jLabelPartidasJugadas;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
    
    /* Metodos auxiliares*/
    
    private void obtenerObjetoRemoto() {
        try {
            objRemotoEstadisticas = (EstadisticasInt) UtilidadesRegistroC.obtenerObjRemoto(numPuertoRMIRegistry, direccionIpRMIRegistry, "ServidorEstadisticas");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error. Obteniendo el objeto remoto ", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void mostrarEstadisticas() throws RemoteException{
        ArrayList<String> estadisticas = objRemotoEstadisticas.generarEstadisticas();
        int tamArray = estadisticas.size();
        if(tamArray != 0){
            int indice = 0, i;
            jLabelNumeroPJ.setText(estadisticas.get(indice));
            indice++;
            jLabelNumeroPE.setText(estadisticas.get(indice));
            indice++;
            DefaultListModel modelLista = new DefaultListModel();
            DefaultTableModel modelTable = new DefaultTableModel();
            modelTable.addColumn("Jugador");
            modelTable.addColumn("Partidas Ganadas");
            
            for (i = indice; i < tamArray; i++) {
                String cadenaDividida[] = estadisticas.get(i).split(":");
                modelTable.addRow(cadenaDividida);
            }
            jTable1.setModel(modelTable);
        }else{
            System.out.println("No hay datos para generar estadisticas");
        }
        
    }

}
