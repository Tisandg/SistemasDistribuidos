
package sop_rmi;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Kevin Chantré
 */
public interface TableroInt extends Serializable{
    public ArrayList<Ficha> getTablero();
    public int getExtremoIzq();
    public int getExtremoDer();
    public void setTablero(ArrayList<Ficha> tablero);
    public void setExtremoIzq(int extremoIzq);
    public void setExtremoDer(int extremoDer);    
}
