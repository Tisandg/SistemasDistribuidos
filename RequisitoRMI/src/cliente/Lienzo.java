
package cliente;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import java.util.ArrayList;
import java.awt.Point;
import sop_rmi.Ficha;
/**
 * Distancia entre fichas 3 pixeles
 * tamaño de las fichas (60*120) px
 * @author Kevin Chantré
 * 
 * tamaño del lienzo 1310
 * mitad 655
 * 625 * 625
 * 
 * 
 * 
 */
public class Lienzo extends JComponent{
    private ArrayList<Fichas_Tablero> ListaFichas;
    private Point ubicacion;
    private int distancia_x_Izq;
    private int distancia_x_Der;
    private int distancia_y_Arr;
    private int distancia_y_Abj;
    private int distancia_y_Der;
    private Utilidades utilidades;
    private int Lado_Izq_Valido;
    private int Lado_Der_Valido;
    
    public Lienzo() {
        ListaFichas = new ArrayList<>();
        this.distancia_y_Arr = 20;
        this.distancia_x_Izq = 625;
        this.distancia_x_Der = 625;
        Fichas_Tablero f = new Fichas_Tablero(null, "/imagenes/6_6_v.png", new Point(624, 20));
        ListaFichas.add(f);
    }
    
    public void paintComponent(Graphics g){
        for (int i = 0; i < ListaFichas.size(); i++) {
            Pintar_Ficha(g, ListaFichas.get(i).getImagen(), ListaFichas.get(i).getUbicacion());
        }
  
    }
    
    public void Pintar_Ficha(Graphics g, String imagen, Point ubicacion){
        Image imagenInterna = new ImageIcon(getClass().getResource(imagen)).getImage();
        g.drawImage (imagenInterna, ubicacion.x, ubicacion.y, this);
    }

    public void setListaFichas(ArrayList<Fichas_Tablero> ListaFichas) {
        this.ListaFichas = ListaFichas;
    }
  //===================================================
    
    public boolean setFiha(Ficha ficha, String Lado){
        Fichas_Tablero NuevaFicha;
        Point p = new Point(625, 20);
        String Imagen;
        if(ListaFichas.isEmpty()){
            if(ficha.getId() != 27){
                return false;
            }else{
                NuevaFicha = new Fichas_Tablero(ficha, utilidades.Buscar_Imagen(ficha), p);
                ListaFichas.add(NuevaFicha);
                Lado_Izq_Valido = 6;
                Lado_Der_Valido = 6;
                return true;
            }
        }else{
            if(Lado.equals("Izquierdo")){
                if(ficha.getLado_A() == Lado_Izq_Valido || ficha.getLado_B() == Lado_Izq_Valido){
                    if(ficha.getLado_A() == ficha.getLado_B()){
                        Imagen = utilidades.Buscar_Imagen(ficha);
                        
                    }else{
                        if(ficha.getLado_A() == Lado_Izq_Valido){
                            Imagen = "/imagenes/"+Integer.toString(ficha.getLado_B())+"_"+Integer.toString(ficha.getLado_A())+"_h.png";
                        }else{
                            Imagen = "/imagenes/"+Integer.toString(ficha.getLado_A())+"_"+Integer.toString(ficha.getLado_B())+"_h.png";
                        }
                    }
                }else{
                    System.out.println("La ficha no se puede colocar a la Izquierda");
                    return false;
                }
            }else{
                if(ficha.getLado_A() == Lado_Der_Valido || ficha.getLado_B() == Lado_Der_Valido){
                    if(ficha.getLado_A() == ficha.getLado_B()){
                        Imagen = utilidades.Buscar_Imagen(ficha);
                        
                    }else{
                        if(ficha.getLado_A() == Lado_Der_Valido){
                            Imagen = "/imagenes/"+Integer.toString(ficha.getLado_A())+"_"+Integer.toString(ficha.getLado_B())+"_h.png";
                        }else{
                            Imagen = "/imagenes/"+Integer.toString(ficha.getLado_B())+"_"+Integer.toString(ficha.getLado_A())+"_h.png";
                        }
                    }
                }else{
                    System.out.println("La ficha no se puede colocar a la Izquierda");
                    return false;
                }
            }
        }        
    }
    
    //==================================================
    
    public int DistanciaFichaVertical(){
        
        return 0;
    }
    
    public int DistanciaFichaHorizontal(){
        
        return 0;
    }
    
}
