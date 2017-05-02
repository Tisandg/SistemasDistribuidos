
package sop_rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import cliente.Usuario_Interface;

/**
 *
 * @author Kevin Chantré
 */
public class UsuarioCallBackImpl extends UnicastRemoteObject implements UsuarioCallBackInt{

    Usuario_Interface usuario_Interface = new Usuario_Interface();
    
    public UsuarioCallBackImpl(Usuario_Interface usuario_interface )throws RemoteException{
        super();
        this.usuario_Interface = usuario_interface;
    }
    
    @Override
    public void enviarInvitacion(String login, String mensaje) throws RemoteException {
        usuario_Interface.Enviar_Invitacion(login, mensaje);
    }

    @Override
    public void enviarMensaje(String login, String mensaje) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
