
package cliente;

import java.awt.Point;
/**
 *
 * @author Kevin Chantré
 */
public class Fichas_Tablero {
    private int id_ficha;
    private String imagen;
    private Point ubicacion;
    
    public Fichas_Tablero(){
        
    }
    
    public Fichas_Tablero(int id_ficha, String imagen, Point ubicacion){
        this.id_ficha = id_ficha;
        this.imagen = imagen;
        this.ubicacion = ubicacion;
    }

    public int getId_ficha() {
        return id_ficha;
    }

    public String getImagen() {
        return imagen;
    }

    public Point getUbicacion() {
        return ubicacion;
    }
    
    
}
