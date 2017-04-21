
package cliente;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import java.util.ArrayList;
import java.awt.Point;
/**
 * @author Kevin Chantré
 */
public class Lienzo extends JComponent{
    private ArrayList<Fichas_Tablero> fichas;
    private Point ubicacion;
    
    public Lienzo() {
        fichas = new ArrayList<>();
        Fichas_Tablero f = new Fichas_Tablero(27, "/imagenes/27.png", new Point(615, 20));
        fichas.add(f);
    }
    
    public void paintComponent(Graphics g){
        for (int i = 0; i < fichas.size(); i++) {
            Pintar_Ficha(g, fichas.get(i).getImagen(), fichas.get(i).getUbicacion());
        }
  
    }
    
    public void Pintar_Ficha(Graphics g, String imagen, Point ubicacion){
        Image imagenInterna = new ImageIcon(getClass().getResource(imagen)).getImage();
        g.drawImage (imagenInterna, ubicacion.x, ubicacion.y, this);
    }
    
    
}
