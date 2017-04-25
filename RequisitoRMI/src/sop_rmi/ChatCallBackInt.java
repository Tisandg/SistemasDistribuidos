package sop_rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author Santiago Garcia
 * Contiene metodos que permiten chatear entre los jugadores
 * de una partida
 */

public interface ChatCallBackInt extends Remote{
    
    public void enviarMesaje(String mensaje, String login) throws RemoteException;
    
}
