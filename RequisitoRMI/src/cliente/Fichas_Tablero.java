
package cliente;

import java.awt.Point;
import sop_rmi.Ficha;
/**
 *
 * @author Kevin Chantré
 */
public class Fichas_Tablero implements Fichas_TableroInt {
    private Ficha ficha;
    private String imagen;
    private Point ubicacion;
    
    public Fichas_Tablero() {
        
    }

    public Fichas_Tablero(Ficha ficha, String imagen, Point ubicacion) {
        this.ficha = ficha;
        this.ubicacion = ubicacion;
        this.imagen = imagen;
        System.out.println("Ficha Tablero = "+this.ficha.getLado_A() +" "+this.ficha.getLado_B());
    }

    @Override
    public Ficha getFicha() {
        return this.ficha;
    }

    @Override
    public String getImagen() {
        return this.imagen;
    }

    @Override
    public Point getUbicacion() {
        return this.ubicacion;
    }

    @Override
    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    @Override
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public void setUbicacion(Point ubicacion) {
        this.ubicacion = ubicacion;
    }
      
}
