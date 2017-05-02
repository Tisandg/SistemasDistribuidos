
package sop_rmi;

import javax.swing.JLabel;
import cliente.Tablero_Interface;
import javax.swing.JOptionPane;
/**
 *
 * @author Kevin Chantre
 */
public class Cronometro extends Thread{

    JLabel aux;
    public Cronometro(JLabel cronometro) {
        this.aux = cronometro;
    }
    
    public void run(){
        try {
            while (Tablero_Interface.IniciaHilo) {                
                Thread.sleep(1000);
                EjecutarHiloCronometro();
            }
        } catch (Exception e) {
            System.out.println("Excepcion en el Hilo : " + e.getMessage());
        }
    }

    private void EjecutarHiloCronometro() {
        String textosegundos = "";
        String textominutos = "";
        String textoHoras = "";
        
        //System.out.println("Nombre del Hilo Actual : "+ Thread.currentThread().getName());
        Tablero_Interface.segundo++;
        if(Tablero_Interface.segundo > 59){
           Tablero_Interface.segundo = 0;
           Tablero_Interface.minuto++;
           if(Tablero_Interface.minuto > 59){
               Tablero_Interface.minuto = 0;
               Tablero_Interface.Hora++;
               if(Tablero_Interface.Hora > 1){
                   JOptionPane.showMessageDialog(null, "A pasado 2 Hora...!!!");
               }
           }
        }
        if(Tablero_Interface.segundo < 10)
            textosegundos = "0"+Tablero_Interface.segundo;
        else
            textosegundos = ""+Tablero_Interface.segundo;
        
        if(Tablero_Interface.minuto < 10)
            textominutos = "0"+Tablero_Interface.minuto;
        else
            textominutos = ""+Tablero_Interface.minuto;
        
        if(Tablero_Interface.Hora < 10)
            textoHoras = "0"+Tablero_Interface.Hora;
        else
            textoHoras = ""+Tablero_Interface.Hora;
        
        String Reloj = textoHoras+" : "+textominutos+" : "+textosegundos;
        aux.setText(Reloj);
    }
}

