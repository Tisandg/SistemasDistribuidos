package sop_corba;


/**
* sop_corba/Usuario.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from C:/Users/HP/Desktop/Musica_CORBA/interface.idl
* martes 6 de junio de 2017 10:16:52 AM COT
*/

public final class Usuario implements org.omg.CORBA.portable.IDLEntity
{
  public int idUsuario = (int)0;
  public String nombresUsuario = null;
  public String apellidosUsuario = null;
  public String loginUsuario = null;
  public String claveUsuario = null;
  public String imagenUsuario = null;
  public boolean privilegiosUsuario = false;
  public boolean desactivado = false;

  public Usuario ()
  {
  } // ctor

  public Usuario (int _idUsuario, String _nombresUsuario, String _apellidosUsuario, String _loginUsuario, String _claveUsuario, String _imagenUsuario, boolean _privilegiosUsuario, boolean _desactivado)
  {
    idUsuario = _idUsuario;
    nombresUsuario = _nombresUsuario;
    apellidosUsuario = _apellidosUsuario;
    loginUsuario = _loginUsuario;
    claveUsuario = _claveUsuario;
    imagenUsuario = _imagenUsuario;
    privilegiosUsuario = _privilegiosUsuario;
    desactivado = _desactivado;
  } // ctor

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNombresUsuario() {
        return nombresUsuario;
    }

    public String getApellidosUsuario() {
        return apellidosUsuario;
    }

    public String getLoginUsuario() {
        return loginUsuario;
    }

    public String getClaveUsuario() {
        return claveUsuario;
    }

    public String getImagenUsuario() {
        return imagenUsuario;
    }

    public boolean isPrivilegiosUsuario() {
        return privilegiosUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNombresUsuario(String nombresUsuario) {
        this.nombresUsuario = nombresUsuario;
    }

    public void setApellidosUsuario(String apellidosUsuario) {
        this.apellidosUsuario = apellidosUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    public void setClaveUsuario(String claveUsuario) {
        this.claveUsuario = claveUsuario;
    }

    public void setImagenUsuario(String imagenUsuario) {
        this.imagenUsuario = imagenUsuario;
    }

    public void setPrivilegiosUsuario(boolean privilegiosUsuario) {
        this.privilegiosUsuario = privilegiosUsuario;
    }

    public boolean isDesactivado() {
        return desactivado;
    }

    public void setDesactivado(boolean desactivado) {
        this.desactivado = desactivado;
    }

} // class Usuario
