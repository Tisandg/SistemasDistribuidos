
package cliente;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

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

    @Override
    public void enviarFicha(Lienzo Mi_Lienzo) throws RemoteException{
        Tablero_Interface.ResivirFicha(Mi_Lienzo);
    }

    @Override
    public void Informar_Paso(String Mensaje) throws RemoteException {
        Tablero_Interface.Informar_Paso(Mensaje);
    }
}
