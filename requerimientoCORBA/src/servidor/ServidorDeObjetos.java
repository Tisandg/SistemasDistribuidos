package servidor;

import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;
import org.omg.CosNaming.NamingContextExt;

import sop_corba.*;

public class ServidorDeObjetos {

  public static void main(String args[]) {
    try{
        System.out.println("1. Crea e inicia el orb");
        String[] datos = new String[4];
        datos[0] = "-ORBInitialHost";
        datos[1] = "localhost";
        datos[2] = "-ORBInitialPort";
        datos[3] = "2020";
        ORB orb = ORB.init(datos, null);

        System.out.println("2. Obtiene la referencia al poa raiz, por medio del orb ");
        org.omg.CORBA.Object objPOA = null;
        objPOA = orb.resolve_initial_references("RootPOA");
        POA rootPOA = POAHelper.narrow(objPOA);

        System.out.println("3. Activa el POAManager");
        rootPOA.the_POAManager().activate();
               
        System.out.println("4. Crea el objeto servant");
        FuncionesAdministradorImpl ObjServant = new FuncionesAdministradorImpl();   
        
        System.out.println("5. Crea el objeto tie y se registra una referencia al objeto servant mediante el contructor");
        Interfaz_AdministradorPOATie objTIE= new Interfaz_AdministradorPOATie(ObjServant);

        System.out.println("6. Obtiene la referencia al orb ");
        Interfaz_Administrador referenciaORB = objTIE._this(orb);      
        
        System.out.println("7. Obtiene una referencia al servicio de nombrado por medio del orb");
        org.omg.CORBA.Object objRefNameService = orb.resolve_initial_references("NameService");

        System.out.println("8. Convierte la ref genérica a ref de NamingContextExt");
        NamingContextExt refContextoNombrado = NamingContextExtHelper.narrow(objRefNameService);

        System.out.println("9.Construir un contexto de nombres que identifica al servant");
        String identificadorServant = "ServantAdmin";

        NameComponent [] path = new NameComponent[1];
        path[0] = new NameComponent();
        path[0].id = identificadorServant;
        path[0].kind = "tipoServicio";     

        System.out.println("10.Realiza el binding de la referencia de objeto en el N_S");
        refContextoNombrado.rebind(path, referenciaORB);

//        
        System.out.println("4. Crea el objeto servant Gestion Impl");
        GestionImpl ObjServantGestion = new GestionImpl();   
        
        System.out.println("5. Crea el objeto tie y se registra una referencia al objeto servant mediante el contructor");
        Interfaz_GestionPOATie objTIE_Gestion = new Interfaz_GestionPOATie(ObjServantGestion);

        System.out.println("6. Obtiene la referencia al orb ");
        Interfaz_Gestion referenciaORB_Gestion = objTIE_Gestion._this(orb);

        System.out.println("9.Construir un contexto de nombres que identifica al servant");
        identificadorServant = "ServantGest";

        path = new NameComponent[1];
        path[0] = new NameComponent();
        path[0].id = identificadorServant;
        path[0].kind = "tipoServicio";     

        System.out.println("10.Realiza el binding de la referencia de objeto en el N_S");
        refContextoNombrado.rebind(path, referenciaORB_Gestion);
//   
//        
        System.out.println("4. Crea el objeto servant Usuarios Callback");
        usuarioCallbackImpl ObjServantCallback = new usuarioCallbackImpl();   
        
        System.out.println("5. Crea el objeto tie y se registra una referencia al objeto servant mediante el contructor");
        usuarioCallbackIntPOATie objTIE_UsuarioCallback = new usuarioCallbackIntPOATie(ObjServantCallback);

        System.out.println("6. Obtiene la referencia al orb ");
        usuarioCallbackInt referenciaORB_UsuarioCallback = objTIE_UsuarioCallback._this(orb);

        System.out.println("9.Construir un contexto de nombres que identifica al servant");
        identificadorServant = "ServantUserCallback";

        path = new NameComponent[1];
        path[0] = new NameComponent();
        path[0].id = identificadorServant;
        path[0].kind = "tipoServicio";     

        System.out.println("10.Realiza el binding de la referencia de objeto en el N_S");
        refContextoNombrado.rebind(path, referenciaORB_UsuarioCallback);
//
//        
        System.out.println("4. Crea el objeto servant Autenticacion");
        AutentificacionUsuarioImpl ObjServantAutenticacion = new AutentificacionUsuarioImpl();   
        
        System.out.println("5. Crea el objeto tie y se registra una referencia al objeto servant mediante el contructor");
        autenticacionUsuarioPOATie objTIE_Autenticacion = new autenticacionUsuarioPOATie(ObjServantAutenticacion);

        System.out.println("6. Obtiene la referencia al orb ");
        autenticacionUsuario referenciaORB_Autenticacion = objTIE_Autenticacion._this(orb);

        System.out.println("9.Construir un contexto de nombres que identifica al servant");
        identificadorServant = "ServantAuten";

        path = new NameComponent[1];
        path[0] = new NameComponent();
        path[0].id = identificadorServant;
        path[0].kind = "tipoServicio";     

        System.out.println("10.Realiza el binding de la referencia de objeto en el N_S");
        refContextoNombrado.rebind(path, referenciaORB_Autenticacion);
//   
        
        System.out.println("El Servidor esta listo y esperando ...");
        orb.run();
    } 
	
      catch (Exception e) {
        System.err.println("ERROR: " + e);
        e.printStackTrace(System.out);
      }
	  
      System.out.println("Servidor: Saliendo ...");
	
  }
}
