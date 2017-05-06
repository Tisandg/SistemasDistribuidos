
package cliente;

import java.awt.Point;
import sop_rmi.Ficha;
/**
 *
 * @author Kevin Chantré
 */
public class Fichas_Tablero {
    private Ficha ficha;
    private String imagen;
    private Point ubicacion;
    
    public Fichas_Tablero(){
        
    }

    public Fichas_Tablero(Ficha ficha, String imagen, Point ubicacion) {
        this.ficha = ficha;
        this.ubicacion = ubicacion;
        this.imagen = imagen;
        System.out.println("Ficha Tablero = "+this.ficha.getLado_A() +" "+this.ficha.getLado_B());
    }

    public Ficha getFicha() {
        return ficha;
    }

    public Point getUbicacion() {
        return ubicacion;
    }

    public String getImagen() {
        return imagen;
    }
    
}
