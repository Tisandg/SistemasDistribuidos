
package cliente;

import java.util.LinkedList;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author Kevin Chantré
 */
public class ReproductorAudio extends Thread {
    
    private byte[] paquete;
    public static LinkedList<InputStream> cola ;
 
    public ReproductorAudio(byte [] paquete){
        this.paquete = paquete;
        cola = new LinkedList<>();
    }
    
    public void run(){
        while(cola.size() > 0){
            Player player;           
            try {
                player = new Player(cola.getFirst());
                player.play();
            } catch (JavaLayerException ex) {
                Logger.getLogger(ReproductorAudio.class.getName()).log(Level.SEVERE, null, ex);
            }
                    
            cola.removeFirst();
        }
        this.stop();
    }
    
}
