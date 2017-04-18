package sop_rmi;

import java.util.ArrayList;

/**
 * @author Santiago Garcia
 */
public class Tablero {
    
    private ArrayList<Ficha> fichasJugadas;
    /*guardan los valores de los extremos de la fichas colocadas. Se supone
      que estan libres*/
    private int extremoIzq;
    private int extremoDer;

    public ArrayList<Ficha> getFichasJugadas() {
        return fichasJugadas;
    }

    public void setFichasJugadas(ArrayList<Ficha> fichasJugadas) {
        this.fichasJugadas = fichasJugadas;
    }

    public int getExtremoIzq() {
        return extremoIzq;
    }

    public void setExtremoIzq(int extremoIzq) {
        this.extremoIzq = extremoIzq;
    }

    public int getExtremoDer() {
        return extremoDer;
    }

    public void setExtremoDer(int extremoDer) {
        this.extremoDer = extremoDer;
    }
    
    
    
    
}
