
package servidor;

import cliente.DashboardCliente;
import sop_corba.*;
/**
 *
 * @author Kevin Chantre
 */
public class usuarioCallbackImpl implements usuarioCallbackIntOperations{

    DashboardCliente GUI;
    
    public usuarioCallbackImpl(){}
    
    public usuarioCallbackImpl(DashboardCliente Gui){
        this.GUI = Gui;
    }
    
    @Override
    public boolean resibirMensaje(String loginUsuario, String mensaje) {
        System.out.println("UsuarioCallback : resibir Mensaje......");
        //
        return true;
    }

    @Override
    public void resibirAudio(String loginUsuario, byte[] paquete) {
        System.out.println("UsuarioCallback : resibir paquete......");
    }
    
}
