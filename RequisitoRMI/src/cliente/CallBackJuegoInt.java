
package cliente;

import java.rmi.RemoteException;
import java.rmi.Remote;
import cliente.Fichas_Tablero;

/**
 *
 * @author Kevin Chantré
 */
public interface CallBackJuegoInt extends Remote{
    public void enviarMensaje(String login, String mensaje) throws RemoteException;
    public void enviarFicha(Fichas_Tablero N_ficha) throws RemoteException;
}
