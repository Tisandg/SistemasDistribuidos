package sop_rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * @author Santiago Garcia
 * Contiene todos los metodos que permiten seccionar un jugador en red,
 * configurar partida y ejecutar partida
 */

public interface JugarInt extends Remote{
    
    public void seleccionarJugador(String login) throws RemoteException;
    public void empezarPartida() throws RemoteException;
    public ArrayList<Ficha> repartirFichas(int tamano) throws RemoteException;
    public boolean enviarJugada(Ficha ficha) throws RemoteException;
    public Tablero estadoTablero() throws RemoteException;
    
}
