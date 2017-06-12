
package servidor;

import cliente.Dashboard;
import sop_corba.*;
/**
 *
 * @author Kevin Chantre
 */
public class usuarioCallbackImpl implements usuarioCallbackIntOperations{

    Dashboard GUI;
    
    public usuarioCallbackImpl(){}
    
    public usuarioCallbackImpl(Dashboard Gui){
        this.GUI = Gui;
    }
    
    @Override
    public boolean resibirMensaje(String mensaje) {
        System.out.println("UsuarioCallback : recibir Mensaje......");
        GUI.recibir_Notificacion(mensaje);
        return true;
    }

    @Override
    public void resibirAudio(byte[] paquete) {
        System.out.println("UsuarioCallback : recibir paquete......");
        GUI.RecibirAudio(paquete);
    }

    @Override
    public void actualizarSuscritos(String[] ListUsuariosSuscritos) {
        System.out.println("UsuarioCallback : Actualizando Lista  Suscritos......");
        GUI.ActualizarSuscritos(ListUsuariosSuscritos);
    }

   
    
}
