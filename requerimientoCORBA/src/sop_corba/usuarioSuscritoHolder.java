package sop_corba;

/**
* sop_corba/usuarioSuscritoHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from C:/Users/HP/Desktop/Musica_CORBA/interface.idl
* domingo 4 de junio de 2017 01:36:39 PM COT
*/

public final class usuarioSuscritoHolder implements org.omg.CORBA.portable.Streamable
{
  public sop_corba.usuarioSuscrito value = null;

  public usuarioSuscritoHolder ()
  {
  }

  public usuarioSuscritoHolder (sop_corba.usuarioSuscrito initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = sop_corba.usuarioSuscritoHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    sop_corba.usuarioSuscritoHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return sop_corba.usuarioSuscritoHelper.type ();
  }

}
