package servidor;

import java.rmi.RemoteException;
import sop_rmi.Archivos;
import sop_rmi.Usuario;
import sop_rmi.UsuariosImpl;

/**
 * @author Santiago Garcia
 */
public class ServidorDeObjetos {
    
    public static void main(String args[]) throws RemoteException
    {
        int numPuertoRMIRegistry = 0;
        String direccionIpRMIRegistry = "";
        System.out.println("Cual es el la dirección ip donde se encuentra  el rmiregistry ");
        direccionIpRMIRegistry = UtilidadesConsola.leerCadena();
        System.out.println("Cual es el número de puerto por el cual escucha el rmiregistry ");
        numPuertoRMIRegistry = UtilidadesConsola.leerEntero(); 
        try
        {
            UsuariosImpl objRemoto = new UsuariosImpl();  
            UtilidadesRMIServidor.ArrancarNS(numPuertoRMIRegistry);
            UtilidadesRMIServidor.RegistrarObjetoRemoto(objRemoto, direccionIpRMIRegistry, numPuertoRMIRegistry,"ServidorUsuarios");            
            System.out.println("Objeto remoto registrado, esperado peticiones ...");
        } catch (Exception e)
        {
            System.err.println("No se pudo Arrancar el NS o Registrar el objeto remoto");
        }   
        
    }
}
