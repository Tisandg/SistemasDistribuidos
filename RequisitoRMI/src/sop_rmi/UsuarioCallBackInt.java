package sop_rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author Santiago Garcia
 * Contiene metodos que permiten chatear entre los jugadores
 * de una partida
 */

public interface UsuarioCallBackInt extends Remote{
    
    public void notificar(String login, String mensaje) throws RemoteException;
    
}
