package sop_corba;


/**
* sop_corba/_Interfaz_AdministradorStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from C:/Users/HP/Desktop/Musica_CORBA/interface.idl
* jueves 1 de junio de 2017 11:29:38 AM COT
*/

public class _Interfaz_AdministradorStub extends org.omg.CORBA.portable.ObjectImpl implements sop_corba.Interfaz_Administrador
{

  public boolean ingresoSistemaAdministrador (String login, String clave)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("ingresoSistemaAdministrador", true);
                $out.write_string (login);
                $out.write_string (clave);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return ingresoSistemaAdministrador (login, clave        );
            } finally {
                _releaseReply ($in);
            }
  } // ingresoSistemaAdministrador

  public boolean registrarUsuario (sop_corba.Usuario N_Usuario)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("registrarUsuario", true);
                sop_corba.UsuarioHelper.write ($out, N_Usuario);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return registrarUsuario (N_Usuario        );
            } finally {
                _releaseReply ($in);
            }
  } // registrarUsuario

  public sop_corba.Usuario[] consultarUsuarios ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("consultarUsuarios", true);
                $in = _invoke ($out);
                sop_corba.Usuario $result[] = sop_corba.Interfaz_AdministradorPackage.ListUsuariosHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return consultarUsuarios (        );
            } finally {
                _releaseReply ($in);
            }
  } // consultarUsuarios

  public sop_corba.Usuario consultarUsuario (String login)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("consultarUsuario", true);
                $out.write_string (login);
                $in = _invoke ($out);
                sop_corba.Usuario $result = sop_corba.UsuarioHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return consultarUsuario (login        );
            } finally {
                _releaseReply ($in);
            }
  } // consultarUsuario

  public boolean exiteUsuario (String login)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("exiteUsuario", true);
                $out.write_string (login);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return exiteUsuario (login        );
            } finally {
                _releaseReply ($in);
            }
  } // exiteUsuario

  public boolean actualizarUsuario (sop_corba.Usuario objUsuario, String login)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("actualizarUsuario", true);
                sop_corba.UsuarioHelper.write ($out, objUsuario);
                $out.write_string (login);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return actualizarUsuario (objUsuario, login        );
            } finally {
                _releaseReply ($in);
            }
  } // actualizarUsuario

  public boolean eliminarUsuario (String login)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("eliminarUsuario", true);
                $out.write_string (login);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return eliminarUsuario (login        );
            } finally {
                _releaseReply ($in);
            }
  } // eliminarUsuario

  public boolean seleccionarAudio (String ruta)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("seleccionarAudio", true);
                $out.write_string (ruta);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return seleccionarAudio (ruta        );
            } finally {
                _releaseReply ($in);
            }
  } // seleccionarAudio

  public boolean EjecutarAudio ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("EjecutarAudio", true);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return EjecutarAudio (        );
            } finally {
                _releaseReply ($in);
            }
  } // EjecutarAudio

  public byte[] enviarAudio ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("enviarAudio", true);
                $in = _invoke ($out);
                byte $result[] = sop_corba.Interfaz_AdministradorPackage.audioHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return enviarAudio (        );
            } finally {
                _releaseReply ($in);
            }
  } // enviarAudio

  public String[] obtenerSuscritos ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("obtenerSuscritos", true);
                $in = _invoke ($out);
                String $result[] = sop_corba.Interfaz_AdministradorPackage.ListUsuariosSuscritosHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return obtenerSuscritos (        );
            } finally {
                _releaseReply ($in);
            }
  } // obtenerSuscritos

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:sop_corba/Interfaz_Administrador:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _Interfaz_AdministradorStub
