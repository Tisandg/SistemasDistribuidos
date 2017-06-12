
package cliente;

import static cliente.Dashboard.colaPaquetes;
import static cliente.Dashboard.Reproduciendo;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author Kevin Chantré
 */
public class ReproductorAudio extends Thread {

    public ReproductorAudio(){
        
    }
    
    public void run(){
//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(ReproductorAudio.class.getName()).log(Level.SEVERE, null, ex);
//        }
        while(colaPaquetes.size() > 0){
            Player player;     
            try {
                player = new Player(colaPaquetes.getFirst());
                player.play();
            } catch (JavaLayerException ex) {
                Logger.getLogger(ReproductorAudio.class.getName()).log(Level.SEVERE, null, ex);
            }                      
            colaPaquetes.removeFirst();
        }
        
        Reproduciendo = false;
        this.stop();
    }
    
}
