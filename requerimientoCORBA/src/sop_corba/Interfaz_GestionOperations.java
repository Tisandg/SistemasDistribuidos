package sop_corba;


/**
* sop_corba/Interfaz_GestionOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from C:/Users/HP/Desktop/Musica_CORBA/interface.idl
* martes 6 de junio de 2017 10:16:52 AM COT
*/

public interface Interfaz_GestionOperations 
{
  boolean registrarUsuario (sop_corba.Usuario N_Usuario);
  sop_corba.Usuario[] consultarUsuarios ();
  sop_corba.Usuario consultarUsuario (String login);
  boolean exiteUsuario (String login);
  boolean actualizarUsuario (sop_corba.Usuario objUsuario, String login);
  boolean eliminarUsuario (String login);
} // interface Interfaz_GestionOperations