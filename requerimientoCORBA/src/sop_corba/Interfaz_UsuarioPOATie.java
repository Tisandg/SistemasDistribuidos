package sop_corba;


/**
* sop_corba/Interfaz_UsuarioPOATie.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from C:/Users/HP/Desktop/Musica_CORBA/interface.idl
* jueves 1 de junio de 2017 10:20:41 AM COT
*/

public class Interfaz_UsuarioPOATie extends Interfaz_UsuarioPOA
{

  // Constructors

  public Interfaz_UsuarioPOATie ( sop_corba.Interfaz_UsuarioOperations delegate ) {
      this._impl = delegate;
  }
  public Interfaz_UsuarioPOATie ( sop_corba.Interfaz_UsuarioOperations delegate , org.omg.PortableServer.POA poa ) {
      this._impl = delegate;
      this._poa      = poa;
  }
  public sop_corba.Interfaz_UsuarioOperations _delegate() {
      return this._impl;
  }
  public void _delegate (sop_corba.Interfaz_UsuarioOperations delegate ) {
      this._impl = delegate;
  }
  public org.omg.PortableServer.POA _default_POA() {
      if(_poa != null) {
          return _poa;
      }
      else {
          return super._default_POA();
      }
  }
  public boolean ingresoSistemaUsuario (String login, String clave)
  {
    return _impl.ingresoSistemaUsuario(login, clave);
  } // ingresoSistemaUsuario

  public boolean actualizarInformacion (sop_corba.Usuario objUsuario)
  {
    return _impl.actualizarInformacion(objUsuario);
  } // actualizarInformacion

  public boolean suscribirse (String login, String clave)
  {
    return _impl.suscribirse(login, clave);
  } // suscribirse

  public boolean eliminarSuscripcion (String login, String clave)
  {
    return _impl.eliminarSuscripcion(login, clave);
  } // eliminarSuscripcion

  public boolean notificacionAudio (String mensaje)
  {
    return _impl.notificacionAudio(mensaje);
  } // notificacionAudio

  private sop_corba.Interfaz_UsuarioOperations _impl;
  private org.omg.PortableServer.POA _poa;

} // class Interfaz_UsuarioPOATie
