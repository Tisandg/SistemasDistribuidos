
package cliente;

import java.rmi.RemoteException;
import java.rmi.Remote;
import java.util.ArrayList;
import sop_rmi.Ficha;

/**
 *
 * @author Kevin Chantré
 */
public interface CallBackJuegoInt extends Remote{
    public void enviarFichasContrincante(ArrayList<Ficha> FichasContrincante) throws RemoteException;
}
