package sop_corba;


/**
* sop_corba/autenticacionUsuarioOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from C:/Users/HP/Desktop/Musica_CORBA/interface.idl
* martes 6 de junio de 2017 10:16:52 AM COT
*/

public interface autenticacionUsuarioOperations 
{
  boolean ingresar (String login, String clave);
  String[] obtenerUsuariosActivos ();
  boolean salir (String login);
} // interface autenticacionUsuarioOperations