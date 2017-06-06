package sop_corba;


/**
* sop_corba/Interfaz_GestionPOATie.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from C:/Users/HP/Desktop/Musica_CORBA/interface.idl
* martes 6 de junio de 2017 10:16:52 AM COT
*/

public class Interfaz_GestionPOATie extends Interfaz_GestionPOA
{

  // Constructors

  public Interfaz_GestionPOATie ( sop_corba.Interfaz_GestionOperations delegate ) {
      this._impl = delegate;
  }
  public Interfaz_GestionPOATie ( sop_corba.Interfaz_GestionOperations delegate , org.omg.PortableServer.POA poa ) {
      this._impl = delegate;
      this._poa      = poa;
  }
  public sop_corba.Interfaz_GestionOperations _delegate() {
      return this._impl;
  }
  public void _delegate (sop_corba.Interfaz_GestionOperations delegate ) {
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
  public boolean registrarUsuario (sop_corba.Usuario N_Usuario)
  {
    return _impl.registrarUsuario(N_Usuario);
  } // registrarUsuario

  public sop_corba.Usuario[] consultarUsuarios ()
  {
    return _impl.consultarUsuarios();
  } // consultarUsuarios

  public sop_corba.Usuario consultarUsuario (String login)
  {
    return _impl.consultarUsuario(login);
  } // consultarUsuario

  public boolean exiteUsuario (String login)
  {
    return _impl.exiteUsuario(login);
  } // exiteUsuario

  public boolean actualizarUsuario (sop_corba.Usuario objUsuario, String login)
  {
    return _impl.actualizarUsuario(objUsuario, login);
  } // actualizarUsuario

  public boolean eliminarUsuario (String login)
  {
    return _impl.eliminarUsuario(login);
  } // eliminarUsuario

  private sop_corba.Interfaz_GestionOperations _impl;
  private org.omg.PortableServer.POA _poa;

} // class Interfaz_GestionPOATie