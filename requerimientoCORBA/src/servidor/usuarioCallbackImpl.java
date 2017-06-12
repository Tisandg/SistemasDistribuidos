
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
    public boolean resibirMensaje(String loginUsuario, String mensaje) {
        System.out.println("UsuarioCallback : recibir Mensaje......");
        //
        return true;
    }

    @Override
    public void resibirAudio(String loginUsuario, byte[] paquete) {
        System.out.println("UsuarioCallback : recibir paquete......");
    }
    
}
