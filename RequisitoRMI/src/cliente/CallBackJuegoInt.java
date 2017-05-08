
package cliente;

import java.rmi.RemoteException;
import java.rmi.Remote;

/**
 *
 * @author Kevin Chantré
 */
public interface CallBackJuegoInt extends Remote{
    public void enviarMensaje(String login, String mensaje) throws RemoteException;
    public void enviarFicha(Lienzo Mi_Lienzo) throws RemoteException;
    public void Informar_Paso(String Mensaje) throws RemoteException;
}
