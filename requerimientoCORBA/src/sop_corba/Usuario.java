package sop_corba;


/**
* sop_corba/Usuario.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from C:/Users/HP/Desktop/Musica_CORBA/interface.idl
* jueves 1 de junio de 2017 10:20:41 AM COT
*/

public final class Usuario implements org.omg.CORBA.portable.IDLEntity
{
  public int idUsuario = (int)0;
  public String nombresUsuario = null;
  public String apellidosUsuario = null;
  public String loginUsuario = null;
  public String claveUsuario = null;
  public String imagenUsuario = null;
  public boolean privilegiosUsuario = false;

  public Usuario ()
  {
  } // ctor

  public Usuario (int _idUsuario, String _nombresUsuario, String _apellidosUsuario, String _loginUsuario, String _claveUsuario, String _imagenUsuario, boolean _privilegiosUsuario)
  {
    idUsuario = _idUsuario;
    nombresUsuario = _nombresUsuario;
    apellidosUsuario = _apellidosUsuario;
    loginUsuario = _loginUsuario;
    claveUsuario = _claveUsuario;
    imagenUsuario = _imagenUsuario;
    privilegiosUsuario = _privilegiosUsuario;
  } // ctor

} // class Usuario