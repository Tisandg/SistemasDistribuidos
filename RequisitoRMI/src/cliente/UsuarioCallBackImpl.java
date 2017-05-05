
package cliente;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import sop_rmi.Ficha;

/**
 *
 * @author Kevin Chantré
 */
public class UsuarioCallBackImpl extends UnicastRemoteObject implements UsuarioCallBackInt{

    Usuario_Interface usuario_Interface;
    
    public UsuarioCallBackImpl(Usuario_Interface usuario_interface )throws RemoteException{
        super();
        this.usuario_Interface = usuario_interface;
    }
    
    @Override
    public void enviarInvitacion(String login, String mensaje, int numeroFichas) throws RemoteException {
        usuario_Interface.Enviar_Invitacion(login, mensaje, numeroFichas);
    }

    @Override
    public void enviarMensaje(String login, String mensaje) throws RemoteException {
        
    }

    @Override
    public void enviarRespuestaInvitacion(String login, boolean respuesta) throws RemoteException {
        usuario_Interface.Resivir_respuesta_Invitacion(login, respuesta);
    }

    @Override
    public void iniciarJuego(ArrayList<Ficha> Fichas) throws RemoteException {
        usuario_Interface.IniciarJuego(Fichas);
    }
    
}
