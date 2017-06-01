package sop_corba;


/**
* sop_corba/Interfaz_AdministradorOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from C:/Users/HP/Desktop/Musica_CORBA/interface.idl
* jueves 1 de junio de 2017 10:20:41 AM COT
*/

public interface Interfaz_AdministradorOperations 
{
  boolean ingresoSistemaAdministrador (String login, String clave);
  boolean registrarUsuario (sop_corba.Usuario N_Usuario);
  sop_corba.Usuario[] consultarUsuarios ();
  sop_corba.Usuario consultarUsuario (String login);
  boolean exiteUsuario (String login);
  boolean actualizarUsuario (sop_corba.Usuario objUsuario, String login);
  boolean eliminarUsuario (String login);
  boolean seleccionarAudio (String ruta);
  boolean EjecutarAudio ();
  byte[] enviarAudio ();
  boolean suscripcionUsuario (String login);
  boolean EliminarSuscripcionUsuario (String login);
} // interface Interfaz_AdministradorOperations
