package sop_rmi;

import java.util.ArrayList;
import servidor.UtilidadesConsola;

/**
 * @author Santiago Garcia
 */

public class Jugador extends UsuarioCallBackImpl{
    
    private ArrayList<Ficha> misFichas;
    private int fichasRestantes;
    
    public void recibirFichas(ArrayList<Ficha> fichasDesdeServidor){
        this.misFichas = fichasDesdeServidor;
        this.fichasRestantes = misFichas.size();
        System.out.println("He recibido mis fichas");
    }

    public ArrayList<Ficha> getMisFichas() {
        return misFichas;
    }

    public void setMisFichas(ArrayList<Ficha> misFichas) {
        this.misFichas = misFichas;
    }

    public int getFichasRestantes() {
        return fichasRestantes;
    }

    public void setFichasRestantes(int fichasRestantes) {
        this.fichasRestantes = fichasRestantes;
    }

}
