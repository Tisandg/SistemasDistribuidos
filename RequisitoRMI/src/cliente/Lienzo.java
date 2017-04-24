
package cliente;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import java.util.ArrayList;
import java.awt.Point;
/**
 * Distancia entre fichas 3 pixeles
 * tamaño de las fichas (60*120) px
 * @author Kevin Chantré
 */
public class Lienzo extends JComponent{
    private ArrayList<Fichas_Tablero> fichas;
    private Point ubicacion;
    
    public Lienzo() {
        fichas = new ArrayList<>();
        Fichas_Tablero f = new Fichas_Tablero(27, "/imagenes/6_6_v.png", new Point(624, 20));
        fichas.add(f);
        Fichas_Tablero f1 = new Fichas_Tablero(20, "/imagenes/5_6_h.png", new Point(501, 50));
        Fichas_Tablero f2 = new Fichas_Tablero(20, "/imagenes/5_5_v.png", new Point(438, 20));
        Fichas_Tablero f3 = new Fichas_Tablero(20, "/imagenes/4_5_h.png", new Point(315, 50));
        fichas.add(f1);
        fichas.add(f2);
        fichas.add(f3);
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
