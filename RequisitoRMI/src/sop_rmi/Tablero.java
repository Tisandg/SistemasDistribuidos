package sop_rmi;

import java.util.ArrayList;

/**
 * @author Kevin Chantré
 */
public class Tablero implements TableroInt{
    
    private ArrayList<Ficha> tabelro;
    private int extremoIzq;
    private int extremoDer;

    public Tablero() {
        this.tabelro = new ArrayList<>();
        this.extremoIzq = -1;
        this.extremoDer = -1;
    }

    @Override
    public ArrayList<Ficha> getTablero() {
        return this.tabelro;
    }

    @Override
    public int getExtremoIzq() {
        return this.extremoIzq;
    }

    @Override
    public int getExtremoDer() {
        return this.extremoDer;
    }

    @Override
    public void setTablero(ArrayList<Ficha> tablero) {
        if(!tablero.isEmpty()){
            this.tabelro.clear();
            for (Ficha tablero1 : tablero) {
                this.tabelro.add(tablero1);
            }
        }
    }

    @Override
    public void setExtremoIzq(int extremoIzq) {
        this.extremoIzq = extremoIzq;
    }

    @Override
    public void setExtremoDer(int extremoDer) {
        this.extremoDer = extremoDer;
    }
    
}
