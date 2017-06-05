
package servidor;

import java.util.LinkedList;

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
        if(FuncionesAdministradorImpl.usuarios_Suscritos.isEmpty()){
            System.out.println("Lista de Usuarios Suscritos vacia....");
        }
        while(cola.size() > 0){
            while(FuncionesAdministradorImpl.usuarios_Suscritos.size() > i){
                objFuncionesAdministrador.enviarAudio(FuncionesAdministradorImpl.usuarios_Suscritos.get(i).getLoginUsuario(), cola.getFirst());
                i++;
            }
            cola.removeFirst();
        }
        System.out.println("Termina");
        this.stop();
        System.out.println("Destruido");
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
