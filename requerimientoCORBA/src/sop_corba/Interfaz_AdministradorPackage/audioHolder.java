package sop_corba.Interfaz_AdministradorPackage;


/**
* sop_corba/Interfaz_AdministradorPackage/audioHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from C:/Users/HP/Desktop/Musica_CORBA/interface.idl
* domingo 4 de junio de 2017 01:36:39 PM COT
*/

public final class audioHolder implements org.omg.CORBA.portable.Streamable
{
  public byte value[] = null;

  public audioHolder ()
  {
  }

  public audioHolder (byte[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = sop_corba.Interfaz_AdministradorPackage.audioHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    sop_corba.Interfaz_AdministradorPackage.audioHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return sop_corba.Interfaz_AdministradorPackage.audioHelper.type ();
  }

}
