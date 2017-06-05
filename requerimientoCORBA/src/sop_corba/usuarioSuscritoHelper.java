package sop_corba;


/**
* sop_corba/usuarioSuscritoHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from C:/Users/HP/Desktop/Musica_CORBA/interface.idl
* domingo 4 de junio de 2017 01:36:39 PM COT
*/

abstract public class usuarioSuscritoHelper
{
  private static String  _id = "IDL:sop_corba/usuarioSuscrito:1.0";

  public static void insert (org.omg.CORBA.Any a, sop_corba.usuarioSuscrito that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static sop_corba.usuarioSuscrito extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  private static boolean __active = false;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      synchronized (org.omg.CORBA.TypeCode.class)
      {
        if (__typeCode == null)
        {
          if (__active)
          {
            return org.omg.CORBA.ORB.init().create_recursive_tc ( _id );
          }
          __active = true;
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [2];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[0] = new org.omg.CORBA.StructMember (
            "loginUsuario",
            _tcOf_members0,
            null);
          _tcOf_members0 = sop_corba.usuarioCallbackIntHelper.type ();
          _members0[1] = new org.omg.CORBA.StructMember (
            "objcllbck",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (sop_corba.usuarioSuscritoHelper.id (), "usuarioSuscrito", _members0);
          __active = false;
        }
      }
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static sop_corba.usuarioSuscrito read (org.omg.CORBA.portable.InputStream istream)
  {
    sop_corba.usuarioSuscrito value = new sop_corba.usuarioSuscrito ();
    value.loginUsuario = istream.read_string ();
    value.objcllbck = sop_corba.usuarioCallbackIntHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, sop_corba.usuarioSuscrito value)
  {
    ostream.write_string (value.loginUsuario);
    sop_corba.usuarioCallbackIntHelper.write (ostream, value.objcllbck);
  }

}