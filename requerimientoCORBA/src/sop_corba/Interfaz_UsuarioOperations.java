package sop_corba;


/**
* sop_corba/Interfaz_UsuarioOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from C:/Users/HP/Desktop/Musica_CORBA/interface.idl
* jueves 1 de junio de 2017 11:29:38 AM COT
*/

public interface Interfaz_UsuarioOperations 
{
  boolean ingresoSistemaUsuario (String login, String clave);
  boolean actualizarInformacion (sop_corba.Usuario objUsuario);
  boolean suscribirse (String login);
  boolean eliminarSuscripcion (String login);
  boolean notificacionAudio (String mensaje);
} // interface Interfaz_UsuarioOperations
