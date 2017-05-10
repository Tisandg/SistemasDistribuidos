
package cliente;

import java.applet.AudioClip;
/**
 *
 * @author Kevin Chantré
 */
public class Fondo_Musical extends Thread{
    AudioClip Sonido;   
    public Fondo_Musical(){
        
    }
    
    public void run(){
        try {
            if (Tablero_Interface.IniciaJuego) {                                
                mi_play();
            }else{
                mi_play_stop();
            }
                
        } catch (Exception e) {
            System.out.println("Excepcion en el Hilo Que reproduce la musica : " + e.getMessage());
        }
    }
    
    
    private void mi_play(){    
        Sonido = java.applet.Applet.newAudioClip(getClass().getResource("/imagenes/Juego_Electro.wav"));
        Sonido.play();      
    }
    
    private void mi_play_stop(){
        Sonido.stop();
        this.destroy();
    }
    
}
