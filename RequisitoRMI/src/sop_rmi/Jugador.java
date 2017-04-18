package sop_rmi;

import java.util.ArrayList;

/**
 * @author Santiago Garcia
 */

public class Jugador {
    
    private ArrayList<Ficha> misFichas;
    private String login;
    
    public void recibirFichas(ArrayList<Ficha> fichasDesdeServidor){
        this.misFichas = fichasDesdeServidor;
    }

    public ArrayList<Ficha> getMisFichas() {
        return misFichas;
    }

    public void setMisFichas(ArrayList<Ficha> misFichas) {
        this.misFichas = misFichas;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
    public void notificar(String mensaje){
        System.out.println(mensaje);
    }
    
}
