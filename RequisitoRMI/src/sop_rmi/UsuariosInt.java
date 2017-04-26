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
    public boolean iniciarSesion(String login, String clave, boolean admin) throws RemoteException;
    public Usuario consultarUsuario(String login)throws RemoteException;
    public boolean modificarUsuario(Usuario u)throws RemoteException;
    public boolean eliminarUsuario(String login)throws RemoteException;
    public ArrayList<String> listarUsuariosConectados(String login) throws RemoteException;
    public ArrayList<Usuario> listarUsuariosRegistrados() throws RemoteException;
    public boolean salir(String login) throws RemoteException;
    
}
