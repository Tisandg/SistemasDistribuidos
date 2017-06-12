
package servidor;

import sop_corba.usuarioCallbackIntOperations;

/**
 *
 * @author Kevin Chantre
 */
public class NotificarUsuario_Hilo extends Thread{
    
    String mensaje;
    
    public NotificarUsuario_Hilo(String notificacion){
        this.mensaje = notificacion;
    }
    
    public void run(){
        int i = 1;
        usuarioCallbackIntOperations objRemoto = null;
        while( FuncionesAdministradorImpl.usuarios_Suscritos.size() > i){
            if(!FuncionesAdministradorImpl.usuarios_Suscritos.get(i).isNotificado()){
                objRemoto = FuncionesAdministradorImpl.usuarios_Suscritos.get(i).getObjcllbck();
                FuncionesAdministradorImpl.usuarios_Suscritos.get(i).setNotificado(true);
                objRemoto.resibirMensaje(mensaje); 
            }       
            i++;
        }
        this.stop();
    }
    
}
