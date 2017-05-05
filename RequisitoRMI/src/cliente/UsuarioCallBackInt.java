package cliente;

import java.rmi.Remote;
import java.rmi.RemoteException;
<<<<<<< HEAD
import java.util.ArrayList;
import sop_rmi.Ficha;
=======
>>>>>>> origin/master

/**
 * @author Kevin Chantré
 */

public interface UsuarioCallBackInt extends Remote{
    public void enviarInvitacion(String login, String mensaje, int numeroFichas) throws RemoteException;    
    public void enviarMensaje(String login, String mensaje) throws RemoteException;
    public void enviarRespuestaInvitacion(String login, boolean respuesta) throws RemoteException;
<<<<<<< HEAD
    public void iniciarJuego(ArrayList<Ficha> Fichas) throws RemoteException;
=======
    
>>>>>>> origin/master
}
