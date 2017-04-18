package sop_rmi;

/**
 * @author Santiago Garcia
 */
public class Ficha {
    
    private int id;
    private int lado1;
    private int lado2;
    private int estado;

    public Ficha() {
    }

    public Ficha(int id, int lado1, int lado2, int estado) {
        this.id = id;
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.estado = estado;
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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
}
