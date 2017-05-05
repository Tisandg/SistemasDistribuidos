
package sop_rmi;

import cliente.UsuarioCallBackInt;
/**
 *
 * @author Kevin Chantré
 */
public class UsuarioActivo {
    
    private String login;
    private UsuarioCallBackInt objRemotoUsuario;
    public boolean disponible;
    private String loginPar;
    
    public UsuarioActivo(String login,UsuarioCallBackInt objRemotoUsuario, boolean disponible )
    {
        this.login=login;
        this.objRemotoUsuario=objRemotoUsuario;
        this.disponible = disponible;
    }

    public String getLogin() {
        return login;
    }

    public UsuarioCallBackInt getObjRemotoUsuario() {
        return objRemotoUsuario;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public String getLoginPar() {
        return loginPar;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setObjRemotoUsuario(UsuarioCallBackInt objRemotoUsuario) {
        this.objRemotoUsuario = objRemotoUsuario;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void setLoginPar(String loginPar) {
        this.loginPar = loginPar;
    }
   
}
