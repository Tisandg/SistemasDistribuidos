package sop_corba;


/**
* sop_corba/Interfaz_AdministradorHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from C:/Users/HP/Desktop/Musica_CORBA/interface.idl
* jueves 1 de junio de 2017 10:20:41 AM COT
*/

abstract public class Interfaz_AdministradorHelper
{
  private static String  _id = "IDL:sop_corba/Interfaz_Administrador:1.0";

  public static void insert (org.omg.CORBA.Any a, sop_corba.Interfaz_Administrador that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static sop_corba.Interfaz_Administrador extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (sop_corba.Interfaz_AdministradorHelper.id (), "Interfaz_Administrador");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static sop_corba.Interfaz_Administrador read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_Interfaz_AdministradorStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, sop_corba.Interfaz_Administrador value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static sop_corba.Interfaz_Administrador narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof sop_corba.Interfaz_Administrador)
      return (sop_corba.Interfaz_Administrador)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      sop_corba._Interfaz_AdministradorStub stub = new sop_corba._Interfaz_AdministradorStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static sop_corba.Interfaz_Administrador unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof sop_corba.Interfaz_Administrador)
      return (sop_corba.Interfaz_Administrador)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      sop_corba._Interfaz_AdministradorStub stub = new sop_corba._Interfaz_AdministradorStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}