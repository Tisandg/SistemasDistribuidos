package sop_corba;


/**
* sop_corba/UsuarioHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from C:/Users/HP/Desktop/Musica_CORBA/interface.idl
* s�bado 10 de junio de 2017 12:13:27 PM COT
*/

abstract public class UsuarioHelper
{
  private static String  _id = "IDL:sop_corba/Usuario:1.0";

  public static void insert (org.omg.CORBA.Any a, sop_corba.Usuario that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static sop_corba.Usuario extract (org.omg.CORBA.Any a)
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
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [8];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[0] = new org.omg.CORBA.StructMember (
            "idUsuario",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[1] = new org.omg.CORBA.StructMember (
            "nombresUsuario",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[2] = new org.omg.CORBA.StructMember (
            "apellidosUsuario",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[3] = new org.omg.CORBA.StructMember (
            "loginUsuario",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[4] = new org.omg.CORBA.StructMember (
            "claveUsuario",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[5] = new org.omg.CORBA.StructMember (
            "imagenUsuario",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_boolean);
          _members0[6] = new org.omg.CORBA.StructMember (
            "privilegiosUsuario",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_boolean);
          _members0[7] = new org.omg.CORBA.StructMember (
            "desactivado",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (sop_corba.UsuarioHelper.id (), "Usuario", _members0);
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

  public static sop_corba.Usuario read (org.omg.CORBA.portable.InputStream istream)
  {
    sop_corba.Usuario value = new sop_corba.Usuario ();
    value.idUsuario = istream.read_long ();
    value.nombresUsuario = istream.read_string ();
    value.apellidosUsuario = istream.read_string ();
    value.loginUsuario = istream.read_string ();
    value.claveUsuario = istream.read_string ();
    value.imagenUsuario = istream.read_string ();
    value.privilegiosUsuario = istream.read_boolean ();
    value.desactivado = istream.read_boolean ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, sop_corba.Usuario value)
  {
    ostream.write_long (value.idUsuario);
    ostream.write_string (value.nombresUsuario);
    ostream.write_string (value.apellidosUsuario);
    ostream.write_string (value.loginUsuario);
    ostream.write_string (value.claveUsuario);
    ostream.write_string (value.imagenUsuario);
    ostream.write_boolean (value.privilegiosUsuario);
    ostream.write_boolean (value.desactivado);
  }

}
