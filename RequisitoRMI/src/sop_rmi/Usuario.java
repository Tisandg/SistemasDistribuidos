package sop_rmi;

/**
 * @author Santiago Garcia
 */

public class Usuario {
    
    private String nombre;
    private String apellido;
    private String login;
    private String clave;
    /*TRUE si es adminsitrador*/
    private boolean admin;
    
    public Usuario(){}

    public Usuario(String nombre, String apellido, String login, String clave, boolean admin) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.login = login;
        this.clave = clave;
        this.admin = admin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    
}
