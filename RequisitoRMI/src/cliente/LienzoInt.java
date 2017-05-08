
package cliente;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author Kevin Chantré
 */
public interface LienzoInt extends Serializable{
    public ArrayList<Fichas_Tablero> getListaFichas();
    public Point getUbcacion();
    public int getDistancia_x_Izq();
    public int getDistancia_x_Der();
    public int getDistancia_y_Arr();
    public int getDistancia_y_Abj();
    public int getLado_Izq_Valido();
    public int getLado_Der_Valido();
    public void setListaFichas(ArrayList<Fichas_Tablero> ListaFichas);
    public void setUbicacion(Point ubicacion);
    public void setDistancia_x_Izq(int distancia_x_Izq);
    public void setDistancia_x_Der(int distancia_x_Der);
    public void setDistancia_y_Arr(int distancia_y_Arr);
    public void setDistancia_y_Abj(int distancia_y_Abj);
    public void setLado_Izq_Valido(int lado_Izq_Valido);
    public void setLado_Der_Valido(int lado_Der_Valido);
    
}
