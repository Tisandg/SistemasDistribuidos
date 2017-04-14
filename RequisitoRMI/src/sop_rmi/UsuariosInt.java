package sop_rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * @author Santiago Garcia
 * Contiene todos los metodos que permiten gestionar
 * los datos de los jugadores
 */

public interface UsuariosInt extends Remote{
    
    public boolean registrarse(Usuario nuevoUsuario)throws RemoteException;
    public boolean iniciarSesion(Usuario u)throws RemoteException;
    public Usuario consultarUsuario(String login)throws RemoteException;
    public boolean modificarJugador(Usuario u)throws RemoteException;
    public boolean eliminarJugador(String login)throws RemoteException;
    public ArrayList<Usuario> listarJugadores()throws RemoteException;
    public boolean salir(String login) throws RemoteException;
    
}
