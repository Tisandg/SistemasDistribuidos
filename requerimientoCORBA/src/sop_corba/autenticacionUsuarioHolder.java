package sop_corba;

/**
* sop_corba/autenticacionUsuarioHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from C:/Users/HP/Desktop/Musica_CORBA/interface.idl
* martes 6 de junio de 2017 10:16:52 AM COT
*/

public final class autenticacionUsuarioHolder implements org.omg.CORBA.portable.Streamable
{
  public sop_corba.autenticacionUsuario value = null;

  public autenticacionUsuarioHolder ()
  {
  }

  public autenticacionUsuarioHolder (sop_corba.autenticacionUsuario initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = sop_corba.autenticacionUsuarioHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    sop_corba.autenticacionUsuarioHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return sop_corba.autenticacionUsuarioHelper.type ();
  }

}
