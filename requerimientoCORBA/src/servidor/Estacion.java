
package servidor;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kevin Chantré
 */
public class Estacion extends Thread{
    private byte [] mi_cancion;
    private LinkedList<byte []> cola;
    private FuncionesAdministradorImpl objFuncionesAdministrador;
    
    public Estacion(byte[] cancion, FuncionesAdministradorImpl obj){       
        mi_cancion = new byte[cancion.length];
        System.arraycopy(cancion, 0, mi_cancion, 0, cancion.length);
        cola = new LinkedList<>();  
        objFuncionesAdministrador = obj;
    }
    
    public void run(){
        int i = 0;
        FuncionesAdministradorImpl.Reproduciendo = true;
        while(cola.size() > 0){
            i = 1;
            while(FuncionesAdministradorImpl.usuarios_Suscritos.size() > i){               
                if(FuncionesAdministradorImpl.usuarios_Suscritos.get(i).isAceptaEscuchar()){
                    objFuncionesAdministrador.enviarAudio(FuncionesAdministradorImpl.usuarios_Suscritos.get(i).getLoginUsuario(), cola.getFirst());
                }
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Estacion.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            cola.removeFirst();
        }
        FuncionesAdministradorImpl.Reproduciendo = false;
        System.out.println("Termina");
        this.stop();
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
        System.out.println("Numero de paquetes ha enviar = "+ cola.size());
    }
}
