
package sop_rmi;

import javax.swing.JLabel;
import cliente.Cliente;
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
            while (Cliente.IniciaHilo) {                
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
        Cliente.segundo++;
        if(Cliente.segundo > 59){
           Cliente.segundo = 0;
           Cliente.minuto++;
           if(Cliente.minuto > 59){
               Cliente.minuto = 0;
               Cliente.Hora++;
               if(Cliente.Hora > 1){
                   JOptionPane.showMessageDialog(null, "A pasado 2 Hora...!!!");
               }
           }
        }
        if(Cliente.segundo < 10)
            textosegundos = "0"+Cliente.segundo;
        else
            textosegundos = ""+Cliente.segundo;
        
        if(Cliente.minuto < 10)
            textominutos = "0"+Cliente.minuto;
        else
            textominutos = ""+Cliente.minuto;
        
        if(Cliente.Hora < 10)
            textoHoras = "0"+Cliente.Hora;
        else
            textoHoras = ""+Cliente.Hora;
        
        String Reloj = textoHoras+" : "+textominutos+" : "+textosegundos;
        aux.setText(Reloj);
    }
}

