
package cliente;

import java.rmi.RemoteException;
import java.rmi.Remote;
import java.util.ArrayList;
import sop_rmi.Ficha;

/**
 *
 * @author Kevin Chantré
 */
public interface CallBackJuegoInt extends Remote{
    public void enviarMensaje(String login, String mensaje) throws RemoteException;
    
}
