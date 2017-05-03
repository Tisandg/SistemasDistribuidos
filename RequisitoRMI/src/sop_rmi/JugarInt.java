package sop_rmi;

import cliente.CallBackJuegoInt;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * @author Santiago Garcia
 * Contiene todos los metodos que permiten seccionar un jugador en red,
 * configurar partida y ejecutar partida
 */

public interface JugarInt extends Remote{
    
    public boolean seleccionarJugador(Usuario usuarioQueInvita, Usuario usuarioAInvitar) throws RemoteException; 
    public void empezarPartida() throws RemoteException;
    public void repartirFichas(int tamano) throws RemoteException;
    public boolean enviarJugada(String jugador, Ficha ficha) throws RemoteException;
    public Tablero estadoTablero() throws RemoteException;
    public int condicionesPartida() throws RemoteException;
    public ArrayList<Ficha> getFichasJugador1()throws RemoteException;
    public ArrayList<Ficha> getFichasJugador2()throws RemoteException;
    public boolean EnviarFichasContrincante(String loginOrigen, String loginDestino, ArrayList<Ficha> FichasContrincante)throws RemoteException;
    public boolean registrarReferenciaRemotaTablro(String login, CallBackJuegoInt objRemoto) throws RemoteException;
}
