package sop_rmi;

import servidor.UtilidadesConsola;

/**
 * @author Kevin Chantré
 */

public class Usuario implements UsuarioInt{
    
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
    
    public void notificar(String mensaje){
        System.out.println(mensaje);
    }
    
    public Usuario(){}

    public Usuario(String nombre, String apellido, String login, String clave, boolean admin) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.login = login;
        this.clave = clave;
        this.admin = admin;
        this.jugando = false;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public String getApellido() {
        return this.apellido;
    }

    @Override
    public String getLogin() {
        return this.login;
    }

    @Override
    public String getClave() {
        return this.clave;
    }

    @Override
    public boolean GetAdmin() {
        return this.admin;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public boolean equals(Object obj) {
        Usuario u = (Usuario) obj; 
        return this.login.equals(u.login);
    }

    @Override
    public void setJugando(boolean jugando) {
        this.jugando = jugando;
    }

    @Override
    public boolean GetJugando() {
        return this.jugando;
    }
 
}
