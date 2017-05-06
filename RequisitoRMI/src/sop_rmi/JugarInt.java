package sop_rmi;

import cliente.CallBackJuegoInt;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import cliente.Fichas_Tablero;

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
    public boolean registrarReferenciaRemotaTablro(String login, CallBackJuegoInt objRemoto) throws RemoteException;
    public boolean enviarMensaje(String loginOrigen, String loginDestino, String mensaje) throws RemoteException;
    public boolean enviarFicha(String LoginDestino, Fichas_Tablero N_ficha) throws RemoteException;
}
