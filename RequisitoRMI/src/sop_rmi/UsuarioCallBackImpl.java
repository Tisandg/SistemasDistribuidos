package sop_rmi;

import java.rmi.RemoteException;
import servidor.UtilidadesConsola;

/**
 * @author Santiago Garcia
 */

public class UsuarioCallBackImpl implements UsuarioCallBackInt{
    
    private String nombre;
    private String apellido;
    private String login;
    private String clave;
    
    /*True si es adminsitrador, de lo contrario False*/
    private boolean admin;
    
    /*True si esta en una partoda, de lo contrario False*/
    private boolean jugando;
    
    public boolean invitacionPartida(String jugadorQueInvita){
        System.out.println("El jugador "+jugadorQueInvita+" te invita a jugar una partida");
        System.out.println("Aceptas la partida?");
        System.out.println("1. Si        2. No");
        int leerEntero = UtilidadesConsola.leerEntero();
        if(leerEntero == 1){
            return true;
        }else{
            return false;
        }
    }
    
    @Override
    public void notificar(String login, String mensaje) throws RemoteException
    {
        System.out.println(login+": "+mensaje);
    }
    
    public UsuarioCallBackImpl(){}

    public UsuarioCallBackImpl(String nombre, String apellido, String login, String clave, boolean admin) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.login = login;
        this.clave = clave;
        this.admin = admin;
        this.jugando = false;
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

    public boolean isJugando() {
        return jugando;
    }

    public void setJugando(boolean jugando) {
        this.jugando = jugando;
    }
}
