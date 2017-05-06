package sop_rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import cliente.UsuarioCallBackInt;
/**
 * @author Santiago Garcia
 * Contiene todos los metodos que permiten gestionar
 * los datos de los jugadores
 */

public interface UsuariosInt extends Remote{
    
    public boolean registrarse(Usuario nuevoUsuario)throws RemoteException;
    public boolean iniciarSesion(String login, String clave, boolean admin) throws RemoteException;
    public Usuario consultarUsuario(String login, boolean admin)throws RemoteException;
    public boolean modificarUsuario(Usuario u) throws RemoteException ;
    public boolean eliminarUsuario(String login) throws RemoteException;
    public ArrayList<String> listarUsuariosConectados(String login) throws RemoteException;
    public ArrayList<Usuario> listarUsuariosRegistrados() throws RemoteException;
    public boolean registrarReferenciaRemota(String login, UsuarioCallBackInt objRemoto) throws RemoteException;
    public boolean EnviarInvitacion(String loginOrigen,String loginDestino, String mensaje, int numeroFichas) throws RemoteException;
    public boolean establecerComunicacion(String loginOrigen, String loginDestino) throws RemoteException ;
    public boolean enviarMensaje(String loginOrigen,String loginDestino, String mensaje)throws RemoteException;
    public boolean enviarRespuestaInvitacion(String loginOrigen, String loginDestino, boolean respuesta) throws RemoteException;
    public boolean iniciarJuego(int numFichas, String LoginOrigeen, String LoginDestino) throws RemoteException;
    public boolean salir(String login) throws RemoteException;
    
}
