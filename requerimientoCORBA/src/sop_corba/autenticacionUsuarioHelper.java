package sop_corba;


/**
* sop_corba/autenticacionUsuarioHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from C:/Users/HP/Desktop/Musica_CORBA/interface.idl
* s�bado 10 de junio de 2017 12:13:27 PM COT
*/

abstract public class autenticacionUsuarioHelper
{
  private static String  _id = "IDL:sop_corba/autenticacionUsuario:1.0";

  public static void insert (org.omg.CORBA.Any a, sop_corba.autenticacionUsuario that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static sop_corba.autenticacionUsuario extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (sop_corba.autenticacionUsuarioHelper.id (), "autenticacionUsuario");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static sop_corba.autenticacionUsuario read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_autenticacionUsuarioStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, sop_corba.autenticacionUsuario value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static sop_corba.autenticacionUsuario narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof sop_corba.autenticacionUsuario)
      return (sop_corba.autenticacionUsuario)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      sop_corba._autenticacionUsuarioStub stub = new sop_corba._autenticacionUsuarioStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static sop_corba.autenticacionUsuario unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof sop_corba.autenticacionUsuario)
      return (sop_corba.autenticacionUsuario)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      sop_corba._autenticacionUsuarioStub stub = new sop_corba._autenticacionUsuarioStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
