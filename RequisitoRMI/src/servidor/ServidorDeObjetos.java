package servidor;

import java.rmi.RemoteException;
import sop_rmi.Archivos;
import sop_rmi.Usuario;

/**
 * @author Santiago Garcia
 */
public class ServidorDeObjetos {
    
    public static void main(String args[]) throws RemoteException
    {
        Archivos archivo = new Archivos();
        Usuario u = new Usuario();
        u.setLogin("Tisan");
        u.setClave("clave");
        u.setNombre("Santiago");
        u.setApellido("Garcia Chicangana");
        System.out.println(archivo.crearArchivo(u));
        //System.out.println(archivo.eliminarArchivo("Tisan"));
        
        archivo.listarArchivosDirectorio();
        
    }
}
