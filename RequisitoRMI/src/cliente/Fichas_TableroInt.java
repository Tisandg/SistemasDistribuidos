
package cliente;

import java.awt.Point;
import java.io.Serializable;
import sop_rmi.Ficha;
/**
 *
 * @author Kevin Chantré
 */
public interface Fichas_TableroInt extends Serializable {
    public Ficha getFicha();
    public String getImagen();
    public Point getUbicacion();
    public void setFicha(Ficha ficha);
    public void setImagen(String imagen);
    public void setUbicacion(Point ubicacion);
}
