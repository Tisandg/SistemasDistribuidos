
package sop_rmi;

import cliente.CallBackJuegoInt;

/**
 *
 * @author Kevin Chantré
 */
public class TableroActivo {
    private String login;
    private CallBackJuegoInt ObjetoRemotoTablero;
    private boolean Activo;

    public TableroActivo(String login, CallBackJuegoInt ObjetoRemotoTablero, boolean Activo) {
        this.login = login;
        this.ObjetoRemotoTablero = ObjetoRemotoTablero;
        this.Activo = Activo;
    }

    public String getLogin() {
        return login;
    }

    public CallBackJuegoInt getObjetoRemotoTablero() {
        return ObjetoRemotoTablero;
    }

    public boolean isActivo() {
        return Activo;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setObjetoRemotoTablero(CallBackJuegoInt ObjetoRemotoTablero) {
        this.ObjetoRemotoTablero = ObjetoRemotoTablero;
    }

    public void setActivo(boolean Activo) {
        this.Activo = Activo;
    }
    
    
    
}
