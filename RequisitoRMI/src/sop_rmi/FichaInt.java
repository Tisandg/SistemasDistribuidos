
package sop_rmi;

import java.io.Serializable;

/**
 *
 * @author Kevin Chantré
 */
public interface FichaInt extends Serializable{
    public int getId();
    public int getLado_A();
    public int getLado_B();
    public boolean getEstadoLado_A();
    public boolean getEstadoLado_B();
    public boolean getColocada();
    public void setId(int id);
    public void setLado_A(int lado_A);
    public void setLado_B(int lado_B);
    public void setEstadoLado_A(boolean estadoLado_A);
    public void setEstadoLado_B(boolean estadoLado_B);
    public void setColocada(boolean colocada);
}
