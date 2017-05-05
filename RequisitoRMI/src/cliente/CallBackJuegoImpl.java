
package cliente;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.ArrayList;
import sop_rmi.Ficha;

/**
 *
 * @author Kevin Chantré
 */
public class CallBackJuegoImpl extends UnicastRemoteObject implements CallBackJuegoInt{
    
    Tablero_Interface Tablero_Interface;
    
    public CallBackJuegoImpl(Tablero_Interface tablero_interface )throws RemoteException{
        super();
        this.Tablero_Interface = tablero_interface;
    }

    
    @Override
    public void enviarMensaje(String login, String mensaje) throws RemoteException {
        Tablero_Interface.enviarMensaje(login + ": " + mensaje);
    }
}
