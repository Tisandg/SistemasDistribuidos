
package cliente;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import java.util.ArrayList;
/**
 * @author Kevin Chantré
 */
public class Lienzo extends JComponent{
    ArrayList<Fichas_Tablero> fichas;
    
    public Lienzo() {
        fichas = new ArrayList<>();
    }
    
    public void paintComponent(Graphics g){
        Image imagenInterna = new ImageIcon(getClass().getResource("/imagenes/27.png")).getImage();
        g.drawImage (imagenInterna, 615, 20, this);
        
    }
  
}
