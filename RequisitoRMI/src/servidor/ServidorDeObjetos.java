package servidor;

import java.rmi.RemoteException;
import sop_rmi.UsuariosImpl;
import sop_rmi.JugarImpl;
//import sop_rmi.UsuarioCallBackImpl;
/**
 * @author Santiago Garcia
 */
public class ServidorDeObjetos {
    
    public static void main(String args[]) throws RemoteException
    {
        int numPuertoRMIRegistry = 2020;
        String direccionIpRMIRegistry = "localhost";
        /*
        System.out.println("Cual es la dirección ip donde se encuentra  el rmiregistry ");
        direccionIpRMIRegistry = UtilidadesConsola.leerCadena();
        System.out.println("Cual es el número de puerto por el cual escucha el rmiregistry ");
        numPuertoRMIRegistry = UtilidadesConsola.leerEntero(); */
        try
        {
            UsuariosImpl objRemoto = new UsuariosImpl();            
            UtilidadesRMIServidor.ArrancarNS(2020);
            UtilidadesRMIServidor.RegistrarObjetoRemoto(objRemoto, direccionIpRMIRegistry, numPuertoRMIRegistry,"ServidorUsuarios");            
            
            System.out.println("Objeto remoto Usuarios Registrado, esperado peticiones ...");
        } catch (Exception e)
        {
            System.err.println("No se pudo Arrancar el NS o Registrar el objeto remoto");
        }
        try {
            JugarImpl ObjetoRemotoJuego = new JugarImpl();
            UtilidadesRMIServidor.RegistrarObjetoRemoto(ObjetoRemotoJuego, direccionIpRMIRegistry, numPuertoRMIRegistry,"ServidorJuego");            
            System.out.println("Objeto remoto Juego Registrado, esperado peticiones ...");
        } catch (Exception e) {
            System.err.println("No se pudo Registrar el objeto remoto <<ServidorJuego>>");
            System.out.println("Error " + e.getMessage());
            System.exit(0);
        }
//        
//        try {
//            UsuarioCallBackImpl bjRemotoCallback = new UsuarioCallBackImpl(null);
//        } catch (Exception e) {
//            System.err.println("No se pudo Registrar el objeto remoto <<ServidorUsuarioCallBack>>");
//        }
        
    }
}
