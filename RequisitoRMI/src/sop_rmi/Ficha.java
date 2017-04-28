package sop_rmi;

/**
 * @author Santiago Garcia
 */
public class Ficha implements FichaInt{
    
    private int id;
    private int lado_A;
    private int lado_B;
    private boolean estadoLado_A;
    private boolean estadoLado_B;
    private boolean colocada;
    
    public Ficha() {
    }

    public Ficha(int id, int lado_A, int lado_B) {
        this.id = id;
        this.lado_A = lado_A;
        this.lado_B = lado_B;
        this.estadoLado_A = false;
        this.estadoLado_B = false;
        this.colocada = false;
    } 

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public int getLado_A() {
        return this.lado_A;
    }

    @Override
    public int getLado_B() {
        return this.lado_B;
    }

    @Override
    public boolean getEstadoLado_A() {
        return estadoLado_A;
    }

    @Override
    public boolean getEstadoLado_B() {
        return estadoLado_B;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setLado_A(int lado_A) {
        this.lado_A = lado_A;
    }

    @Override
    public void setLado_B(int lado_B) {
        this.lado_B = lado_B;
    }

    @Override
    public void setEstadoLado_A(boolean estadoLado_A) {
        this.estadoLado_A = estadoLado_A;
    }

    @Override
    public void setEstadoLado_B(boolean estadoLado_B) {
        this.estadoLado_B = estadoLado_B;
    }

    @Override
    public boolean getColocada() {
        return this.colocada;
    }

    @Override
    public void setColocada(boolean colocada) {
        this.colocada = colocada;
    }
    
}
