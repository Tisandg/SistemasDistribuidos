package cliente;

import java.rmi.RemoteException;
import sop_rmi.UsuariosInt;

public class ClienteDeObjetos
{
    public static void main(String[] args){

        UsuariosInt servidor;
        try{
            int numPuertoRMIRegistry = 0;
            String direccionIpRMIRegistry = "";
            System.out.println("Cual es el la dirección ip donde se encuentra  el rmiregistry ");
            direccionIpRMIRegistry = cliente.UtilidadesConsola.leerCadena();
            System.out.println("Cual es el número de puerto por el cual escucha el rmiregistry ");
            numPuertoRMIRegistry = cliente.UtilidadesConsola.leerEntero(); 

            servidor = (UsuariosInt) UtilidadesRegistroC.obtenerObjRemoto(numPuertoRMIRegistry,direccionIpRMIRegistry, "objetoUsuarios");

            //Si se inicia sesion se pasa a usar el objeto jugar
            
            //UsuarioCllbckImpl nuevoUsuario= new UsuarioCllbckImpl();
            //servidor.registrarUsuario((UsuarioCllbckInt) nuevoUsuario);

        }
        catch(Exception e)
        {
                System.out.println("No se pudo realizar la conexion...");
                System.out.println(e.getMessage());
        }

    }
	
}
