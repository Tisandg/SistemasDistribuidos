package sop_rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * @author Santiago Garcia
 * Contiene los metodos que permiten consultar las estadisticas 
 * de los juegos
 */

public interface EstadisticasInt extends Remote{
    
    public ArrayList<String> generarEstadisticas() throws RemoteException ;
    public boolean actualizarEstadisticas(String login1, String login2, String resultadoPartida) throws RemoteException ;
}
