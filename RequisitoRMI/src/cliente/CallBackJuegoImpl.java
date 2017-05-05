
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
    
<<<<<<< HEAD
    Tablero_Interface Tablero_Interface;
=======
    Tablero_Interface Tablero_Interface = new Tablero_Interface();
>>>>>>> origin/master
    
    public CallBackJuegoImpl(Tablero_Interface tablero_interface )throws RemoteException{
        super();
        this.Tablero_Interface = tablero_interface;
    }

<<<<<<< HEAD
    
    @Override
    public void enviarMensaje(String login, String mensaje) throws RemoteException {
        Tablero_Interface.enviarMensaje(login + ": " + mensaje);
=======
    @Override
    public void enviarFichasContrincante(ArrayList<Ficha> FichasContrincante) throws RemoteException {
        Tablero_Interface.Resivir_Fichas(FichasContrincante);
>>>>>>> origin/master
    }
}
