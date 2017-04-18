package sop_rmi;

/**
 * @author Santiago Garcia
 */
public class Ficha {
    
    private int id;
    private int lado1;
    private int lado2;
    private boolean estado;
    private boolean estadoLado1;
    private boolean estadoLado2;

    public Ficha() {
    }

    public Ficha(int id, int lado1, int lado2, boolean estado) {
        this.id = id;
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.estado = estado;
    }

    public boolean isEstadoLado1() {
        return estadoLado1;
    }

    public void setEstadoLado1(boolean estadoLado1) {
        this.estadoLado1 = estadoLado1;
    }

    public boolean isEstadoLado2() {
        return estadoLado2;
    }

    public void setEstadoLado2(boolean estadoLado2) {
        this.estadoLado2 = estadoLado2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLado1() {
        return lado1;
    }

    public void setLado1(int lado1) {
        this.lado1 = lado1;
    }

    public int getLado2() {
        return lado2;
    }

    public void setLado2(int lado2) {
        this.lado2 = lado2;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    
    
}
