package cliente;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author Kevin Chantré
 */

public interface UsuarioCallBackInt extends Remote{
    public void enviarInvitacion(String login, String mensaje, int numeroFichas) throws RemoteException;    
    public void enviarMensaje(String login, String mensaje) throws RemoteException;
    public void enviarRespuestaInvitacion(String login, boolean respuesta) throws RemoteException;
    
}
