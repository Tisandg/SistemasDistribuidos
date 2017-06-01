package sop_corba;


/**
* sop_corba/Interfaz_UsuarioPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from C:/Users/HP/Desktop/Musica_CORBA/interface.idl
* jueves 1 de junio de 2017 11:29:38 AM COT
*/

public abstract class Interfaz_UsuarioPOA extends org.omg.PortableServer.Servant
 implements sop_corba.Interfaz_UsuarioOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("ingresoSistemaUsuario", new java.lang.Integer (0));
    _methods.put ("actualizarInformacion", new java.lang.Integer (1));
    _methods.put ("suscribirse", new java.lang.Integer (2));
    _methods.put ("eliminarSuscripcion", new java.lang.Integer (3));
    _methods.put ("notificacionAudio", new java.lang.Integer (4));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // sop_corba/Interfaz_Usuario/ingresoSistemaUsuario
       {
         String login = in.read_string ();
         String clave = in.read_string ();
         boolean $result = false;
         $result = this.ingresoSistemaUsuario (login, clave);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 1:  // sop_corba/Interfaz_Usuario/actualizarInformacion
       {
         sop_corba.Usuario objUsuario = sop_corba.UsuarioHelper.read (in);
         boolean $result = false;
         $result = this.actualizarInformacion (objUsuario);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 2:  // sop_corba/Interfaz_Usuario/suscribirse
       {
         String login = in.read_string ();
         boolean $result = false;
         $result = this.suscribirse (login);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 3:  // sop_corba/Interfaz_Usuario/eliminarSuscripcion
       {
         String login = in.read_string ();
         boolean $result = false;
         $result = this.eliminarSuscripcion (login);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 4:  // sop_corba/Interfaz_Usuario/notificacionAudio
       {
         String mensaje = in.read_string ();
         boolean $result = false;
         $result = this.notificacionAudio (mensaje);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:sop_corba/Interfaz_Usuario:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Interfaz_Usuario _this() 
  {
    return Interfaz_UsuarioHelper.narrow(
    super._this_object());
  }

  public Interfaz_Usuario _this(org.omg.CORBA.ORB orb) 
  {
    return Interfaz_UsuarioHelper.narrow(
    super._this_object(orb));
  }


} // class Interfaz_UsuarioPOA
