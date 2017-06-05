/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author Kevin chantre
 */
public class ReproductorAudio extends Thread{
    private byte [] mi_cancion;
    private int numBytes;
    private LinkedList<byte []> cola;
    private LinkedList<InputStream> cola2;
    
    public ReproductorAudio(byte[] cancion){       
        mi_cancion = new byte[cancion.length];
        System.arraycopy(cancion, 0, mi_cancion, 0, cancion.length);
        numBytes = 0;
        cola = new LinkedList<>();
        cola2 = new LinkedList<>();           
    }
    
    public void run(){
        Player player;
        while(cola.size() > 0){
            InputStream c = new ByteArrayInputStream(cola.getFirst());
            cola2.add(c);
            cola.removeFirst();
        }
        
        while(cola2.size() > 0){    
            try {
                player = new Player(cola2.getFirst());
                player.play(1000);               
            } catch (JavaLayerException ex) {
                Logger.getLogger(FuncionesAdministradorImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            cola2.removeFirst();
        }
    }
    
    public void Dividir_Cancion(){
        int numbyte = 160000;
        int pos = 0;
        for(int i = 160000; i < mi_cancion.length; i = i + numbyte){
            byte[] nuevo = new byte[numbyte];
            System.arraycopy(mi_cancion, pos, nuevo, 0, numbyte);
            cola.add(nuevo);
            pos = pos + 158000;
        }
    }
       
}
