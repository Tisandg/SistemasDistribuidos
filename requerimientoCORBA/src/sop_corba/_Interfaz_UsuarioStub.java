package sop_corba;


/**
* sop_corba/_Interfaz_UsuarioStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from C:/Users/HP/Desktop/Musica_CORBA/interface.idl
* jueves 1 de junio de 2017 10:20:41 AM COT
*/

public class _Interfaz_UsuarioStub extends org.omg.CORBA.portable.ObjectImpl implements sop_corba.Interfaz_Usuario
{

  public boolean ingresoSistemaUsuario (String login, String clave)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("ingresoSistemaUsuario", true);
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
                return ingresoSistemaUsuario (login, clave        );
            } finally {
                _releaseReply ($in);
            }
  } // ingresoSistemaUsuario

  public boolean actualizarInformacion (sop_corba.Usuario objUsuario)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("actualizarInformacion", true);
                sop_corba.UsuarioHelper.write ($out, objUsuario);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return actualizarInformacion (objUsuario        );
            } finally {
                _releaseReply ($in);
            }
  } // actualizarInformacion

  public boolean suscribirse (String login, String clave)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("suscribirse", true);
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
                return suscribirse (login, clave        );
            } finally {
                _releaseReply ($in);
            }
  } // suscribirse

  public boolean eliminarSuscripcion (String login, String clave)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("eliminarSuscripcion", true);
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
                return eliminarSuscripcion (login, clave        );
            } finally {
                _releaseReply ($in);
            }
  } // eliminarSuscripcion

  public boolean notificacionAudio (String mensaje)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("notificacionAudio", true);
                $out.write_string (mensaje);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return notificacionAudio (mensaje        );
            } finally {
                _releaseReply ($in);
            }
  } // notificacionAudio

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:sop_corba/Interfaz_Usuario:1.0"};

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
} // class _Interfaz_UsuarioStub
