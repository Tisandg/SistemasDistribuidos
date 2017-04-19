
package cliente;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
/**
 *
 * @author Kevin Chantré
 */
public class Pintar_Fichas extends Canvas{

    public Pintar_Fichas() {
    
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(10, 10, 10, 10);
    }
    
}
