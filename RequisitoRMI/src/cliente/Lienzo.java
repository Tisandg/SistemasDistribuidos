
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
 * tamaño de las fichas (40*80) px
 * @author Kevin Chantré
 * 
 * tamaño del lienzo 1310 300
 * mitad 655
 * 635 * 635
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
    private Utilidades utilidades;
    private int Lado_Izq_Valido;
    private int Lado_Der_Valido;
    
    public Lienzo() {
        ListaFichas = new ArrayList<>();
        this.distancia_y_Arr = 110;
        this.distancia_y_Abj = 110;
        this.distancia_x_Izq = 635;
        this.distancia_x_Der = 635;
//        Fichas_Tablero f = new Fichas_Tablero(null, "/imagenes/6_6_v.png", new Point(624, 20));
//        ListaFichas.add(f);
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
    
    public Fichas_Tablero setFiha(Ficha ficha, String Lado){
        Fichas_Tablero NuevaFicha;
        Fichas_Tablero Aux;
        Point p = new Point(635, 110);
        String Imagen;
        String tipo;
        if(ListaFichas.isEmpty()){
            if(ficha.getId() != 27){
                return null;
            }else{
                NuevaFicha = new Fichas_Tablero(ficha, imagen(ficha, "_v"), p);
                ListaFichas.add(NuevaFicha);
                Lado_Izq_Valido = 6;
                Lado_Der_Valido = 6;
                return NuevaFicha;
            }
        }else{
            if(Lado.equals("Izquierda")){
                if(ficha.getLado_A() == Lado_Izq_Valido || ficha.getLado_B() == Lado_Izq_Valido){
                    if(ficha.getLado_A() == ficha.getLado_B()){
                        tipo = UbicacionFichaVertical_Izq();
                        Imagen = imagen(ficha, tipo);
                        NuevaFicha = new Fichas_Tablero(ficha, Imagen, ubicacion);
                        ListaFichas.add(NuevaFicha);                                
                        return NuevaFicha;
                    }else{
                        if(ficha.getLado_A() == Lado_Izq_Valido){                            
                            tipo = UbicacionFichaHorizontal_Izq();
                            Imagen = "/imagenes/"+Integer.toString(ficha.getLado_B())+"_"+Integer.toString(ficha.getLado_A())+tipo+".png";
                            NuevaFicha = new Fichas_Tablero(ficha, Imagen, ubicacion);
                            ListaFichas.add(NuevaFicha);
                            Lado_Izq_Valido = ficha.getLado_B();
                            return null;
                        }else{
                            tipo = UbicacionFichaHorizontal_Izq();
                            Imagen = "/imagenes/"+Integer.toString(ficha.getLado_A())+"_"+Integer.toString(ficha.getLado_B())+tipo+".png";
                            NuevaFicha = new Fichas_Tablero(ficha, Imagen, ubicacion);
                            ListaFichas.add(NuevaFicha);
                            Lado_Izq_Valido = ficha.getLado_A();
                            return NuevaFicha;
                        }
                    }
                }else{
                    System.out.println("La ficha no se puede colocar a la Izquierda");
                    return null;
                }
            }else{
                if(ficha.getLado_A() == Lado_Der_Valido || ficha.getLado_B() == Lado_Der_Valido){
                    if(ficha.getLado_A() == ficha.getLado_B()){
                        Imagen = utilidades.Buscar_Imagen(ficha);
                        NuevaFicha = new Fichas_Tablero(ficha, Imagen, ubicacion);
                        return NuevaFicha;
                    }else{
                        if(ficha.getLado_A() == Lado_Der_Valido){
                            Imagen = "/imagenes/"+Integer.toString(ficha.getLado_A())+"_"+Integer.toString(ficha.getLado_B())+"_h.png";
                            NuevaFicha = new Fichas_Tablero(ficha, Imagen, ubicacion);
                            return NuevaFicha;
                        }else{
                            Imagen = "/imagenes/"+Integer.toString(ficha.getLado_B())+"_"+Integer.toString(ficha.getLado_A())+"_h.png";
                            NuevaFicha = new Fichas_Tablero(ficha, Imagen, ubicacion);
                            return NuevaFicha;
                        }
                    }
                }else{
                    System.out.println("La ficha no se puede colocar a la Izquierda");
                    return null;
                }
            }
        }        
    }
    
    //==================================================
    
    public String UbicacionFichaVertical_Izq(){
        if(distancia_x_Izq > 90){
            distancia_x_Izq = distancia_x_Izq - 42;
            ubicacion = new Point(distancia_x_Izq, distancia_y_Arr);
            return "_v";
        }else{
            System.out.println("Sin espacio...!!");
            return UbicacionFichaHorizontal_Izq();
        }
    }

    public String UbicacionFicha_Izq_SinEspacio(int tam_vertical){
        if(distancia_y_Arr > 90){
            distancia_y_Arr = distancia_y_Arr - tam_vertical;
            ubicacion = new Point(distancia_x_Izq, distancia_y_Arr);
            return "_v";
        }else{
            ubicacion = new Point(distancia_x_Izq, distancia_y_Arr);
            return "_v";
        }      
    }
    
    
    public String UbicacionFichaHorizontal_Izq(){
        if(distancia_x_Izq > 90){
            distancia_x_Izq = distancia_x_Izq - 82;
            ubicacion = new Point(distancia_x_Izq, distancia_y_Arr+20);
            return "_h";
        }else{
            System.out.println("Sin espacio por la izquierda...!");
            return UbicacionFicha_Izq_SinEspacio(82);            
        }      
    }
    
    public Point UbicacionFichaHorizontal_Der(){
        
        return null;
    }

    public void ColocarFicha(Ficha ficha, String Lado){
        Fichas_Tablero NuevaFicha;
        Point p = new Point(625, 20);
        System.out.println("*************");
        System.out.println("ficha = "+ficha.getLado_A()+" - "+ficha.getLado_B()+" - "+ficha.getColocada());
        System.out.println("Imagen = "+"/imagenes/"+Integer.toString(ficha.getLado_A())+"_"+Integer.toString(ficha.getLado_B())+"_h.png");
        System.out.println("Point "+p.getX());
        System.out.println("Point "+p.getY());
        System.out.println("**************");
        NuevaFicha = new Fichas_Tablero(ficha, imagen(ficha, "_h"), p);
        ListaFichas.add(NuevaFicha);
    }
    
    public String imagen(Ficha ficha, String pos){
        String Img = "";
        Img = "/imagenes/"+Integer.toString(ficha.getLado_A())+"_"+Integer.toString(ficha.getLado_B())+pos+".png";
        return Img;
    } 
    
    
    public void ResibirFcha(Fichas_Tablero N_ficha){
        ListaFichas.add(N_ficha);
        System.out.println("Resiviendo Ficha de otro juador...!!");
    }

    public ArrayList<Fichas_Tablero> getListaFichas() {
        return ListaFichas;
    }
    
}
