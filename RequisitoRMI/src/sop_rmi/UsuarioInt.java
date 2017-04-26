
package sop_rmi;

import java.io.Serializable;

/**
 *
 * @author Kevin Chantré
 */
public interface UsuarioInt extends Serializable {
    public String getNombre();
    public String getApellido();
    public String getLogin();
    public String getClave();
    public boolean GetAdmin();
    public boolean GetJugando();
    public void setNombre(String nombre);
    public void setApellido(String apellido);
    public void setLogin(String login);
    public void setClave(String clave);
    public void setAdmin(boolean admin);
    public void setJugando(boolean jugando);
    
}
