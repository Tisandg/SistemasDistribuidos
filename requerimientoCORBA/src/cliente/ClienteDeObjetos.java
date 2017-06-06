
package cliente;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import sop_corba.*;
/**
 *
 * @author Kevin Chantré
 */
public class ClienteDeObjetos {
    
    NamingContextExt refContextoNombrado;
    
    public ClienteDeObjetos(){
        this.refContextoNombrado = null;
    }
    
    public boolean iniciarORB(String args[]){
        try{
            System.out.println("1. Crea e inicia el ORB");
            ORB orb = ORB.init(args, null);
            System.out.println("2. Obtiene una referencia al servicio de nombrado por medio del orb");
            org.omg.CORBA.Object objRefNameService = orb.resolve_initial_references("NameService");
            
            System.out.println("3. Convierte la ref genérica a ref de NamingContextExt");
            refContextoNombrado = NamingContextExtHelper.narrow(objRefNameService);
            return true;
//            System.out.println("4. Resuelve la referencia del objeto en el N_S."); 
            
        }catch (Exception e) {
            System.out.println("ERROR : " + e) ;
            e.printStackTrace(System.out);
            return false;
	  }            
    }
    
    public org.omg.CORBA.Object seleccionarServicio(String identificadorServant){
        org.omg.CORBA.Object objRef= ObtenerServant(identificadorServant);
        org.omg.CORBA.Object objRefAux = null;
                
        if(objRef != null){
            switch(identificadorServant){
          
                case "ServantAdmin":
                    Interfaz_Administrador objAdmin = Interfaz_AdministradorHelper.narrow(objRef);
                    return objAdmin;

                case "ServantGest":
                    Interfaz_Gestion objGest = Interfaz_GestionHelper.narrow(objRef);
                    return objGest;

                case "ServantUserCallback":
                    usuarioCallbackInt objCallback = usuarioCallbackIntHelper.narrow(objRef);
                    return objCallback;
                
                case "ServantAuten":
                    autenticacionUsuario objAutent = autenticacionUsuarioHelper.narrow(objRef);
                    return objAutent;    
                    
                default:
                    System.out.println("Error:  Identificador no existente....");
                    return objRefAux;  
            }       
        }
        
        return objRefAux;
    }
    
    public org.omg.CORBA.Object ObtenerServant(String identificadorServant){
        try {            
            NameComponent [] path = new NameComponent[1];
            path[0] = new NameComponent();
            path[0].id = identificadorServant;
            path[0].kind = "tipoServicio";     
            
            org.omg.CORBA.Object objRef= refContextoNombrado.resolve(path);
            return objRef;
            
        } catch (Exception e) {
            System.out.println("ERROR : " + e) ;
            e.printStackTrace(System.out);
        }
        return null;
    }
    
}
