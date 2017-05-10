
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
public class Lienzo extends JComponent implements LienzoInt{
    private ArrayList<Fichas_Tablero> ListaFichas;
    private Point ubicacion;
    private int distancia_x_Izq;
    private int distancia_x_Der;
    private int distancia_y_Arr;
    private int distancia_y_Abj;
    private int lado_Izq_Valido;
    private int lado_Der_Valido;
    
    public Lienzo() {
        ListaFichas = new ArrayList<>();
        this.distancia_y_Arr = 110;
        this.distancia_y_Abj = 110;
        this.distancia_x_Izq = 635;
        this.distancia_x_Der = 595;       
        this.lado_Izq_Valido = 0;
        this.lado_Der_Valido = 0;
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
                lado_Izq_Valido = 6;
                lado_Der_Valido = 6;
                return NuevaFicha;
            }
        }else{
            if(Lado.equals("Izquierda")){
                if(ficha.getLado_A() == lado_Izq_Valido || ficha.getLado_B() == lado_Izq_Valido){
                    if(ficha.getLado_A() == ficha.getLado_B()){
                        tipo = UbicacionFichaVertical_Izq();
                        Imagen = imagen(ficha, tipo);
                        NuevaFicha = new Fichas_Tablero(ficha, Imagen, ubicacion);
                        ListaFichas.add(NuevaFicha);                                
                        return NuevaFicha;
                    }else{
                        if(ficha.getLado_A() == lado_Izq_Valido){                            
                            tipo = UbicacionFichaHorizontal_Izq();
                            Imagen = "/imagenes/"+Integer.toString(ficha.getLado_B())+"_"+Integer.toString(ficha.getLado_A())+tipo+".png";
                            NuevaFicha = new Fichas_Tablero(ficha, Imagen, ubicacion);
                            ListaFichas.add(NuevaFicha);
                            lado_Izq_Valido = ficha.getLado_B();
                            return NuevaFicha;
                        }else{
                            tipo = UbicacionFichaHorizontal_Izq();
                            Imagen = "/imagenes/"+Integer.toString(ficha.getLado_A())+"_"+Integer.toString(ficha.getLado_B())+tipo+".png";
                            NuevaFicha = new Fichas_Tablero(ficha, Imagen, ubicacion);
                            ListaFichas.add(NuevaFicha);
                            lado_Izq_Valido = ficha.getLado_A();
                            return NuevaFicha;
                        }
                    }
                }else{
                    System.out.println("La ficha no se puede colocar a la Izquierda");
                    String Error = "Error";
                    NuevaFicha = new Fichas_Tablero(ficha, Error, ubicacion);
                    return NuevaFicha;
                }
            }else{
                if(ficha.getLado_A() == lado_Der_Valido || ficha.getLado_B() == lado_Der_Valido){
                    if(ficha.getLado_A() == ficha.getLado_B()){
                        tipo = UbicacionFichaVertical_Der();
                        Imagen = imagen(ficha, tipo);
                        NuevaFicha = new Fichas_Tablero(ficha, Imagen, ubicacion);
                        ListaFichas.add(NuevaFicha);                                
                        return NuevaFicha;
                    }else{
                        if(ficha.getLado_A() == lado_Der_Valido){
                            tipo = UbicacionFichaHorizontal_Der();
                            Imagen = "/imagenes/"+Integer.toString(ficha.getLado_A())+"_"+Integer.toString(ficha.getLado_B())+tipo+".png";
                            NuevaFicha = new Fichas_Tablero(ficha, Imagen, ubicacion);
                            ListaFichas.add(NuevaFicha);
                            lado_Der_Valido = ficha.getLado_B();
                            return NuevaFicha;
                        }else{
                            tipo = UbicacionFichaHorizontal_Der();
                            Imagen = "/imagenes/"+Integer.toString(ficha.getLado_B())+"_"+Integer.toString(ficha.getLado_A())+tipo+".png";
                            NuevaFicha = new Fichas_Tablero(ficha, Imagen, ubicacion);
                            ListaFichas.add(NuevaFicha);
                            lado_Der_Valido = ficha.getLado_A();
                            return NuevaFicha;
                        }
                    }
                }else{
                    System.out.println("La ficha no se puede colocar a la Derecha");
                    String Error = "Error";
                    NuevaFicha = new Fichas_Tablero(ficha, Error, ubicacion);
                    return NuevaFicha;
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
            distancia_x_Izq = distancia_x_Izq + 42;
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
    
    public String UbicacionFichaVertical_Der(){
        if(distancia_x_Der < 1220){
            distancia_x_Der = distancia_x_Der + 82;
            ubicacion = new Point(distancia_x_Der, distancia_y_Abj);
            distancia_x_Der = distancia_x_Der - 40;
            return "_v";
        }else{
            System.out.println("Sin espacio...!!");
            return UbicacionFichaHorizontal_Der();
        }
    }
    
    public String UbicacionFichaHorizontal_Der(){
        if(distancia_x_Der < 1138){
            distancia_x_Der = distancia_x_Der + 82;
            ubicacion = new Point(distancia_x_Der, distancia_y_Abj + 20);
            return "_h";
        }else{
            System.out.println("Sin espacio por la Derecha...!");
            return UbicacionFicha_Der_SinEspacio(82); 
        }
    }
    
    public String UbicacionFicha_Der_SinEspacio(int tam_vertical){
        if(distancia_y_Abj < 200){
            distancia_y_Abj = distancia_y_Abj + tam_vertical;
            ubicacion = new Point(distancia_x_Der+40, distancia_y_Abj);
            return "_v";
        }else{
            System.out.println("no funciona funcion sin espacio derecha...");
            ubicacion = new Point(distancia_x_Izq, distancia_y_Arr);
            return "_v";
        }         
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

    @Override
    public ArrayList<Fichas_Tablero> getListaFichas() {
        return this.ListaFichas;
    }

    @Override
    public Point getUbcacion() {
        return this.ubicacion;
    }

    @Override
    public int getDistancia_x_Izq() {
        return this.distancia_x_Izq;
    }

    @Override
    public int getDistancia_x_Der() {
        return this.distancia_x_Der;
    }

    @Override
    public int getDistancia_y_Arr() {
        return this.distancia_y_Arr;
    }

    @Override
    public int getDistancia_y_Abj() {
        return this.distancia_y_Abj;
    }

    @Override
    public int getLado_Izq_Valido() {
        return this.lado_Izq_Valido;
    }

    @Override
    public int getLado_Der_Valido() {
        return this.lado_Der_Valido;
    }

    @Override
    public void setUbicacion(Point ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public void setDistancia_x_Izq(int distancia_x_Izq) {
        this.distancia_x_Izq = distancia_x_Izq;
    }

    @Override
    public void setDistancia_x_Der(int distancia_x_Der) {
        this.distancia_x_Der = distancia_x_Der;
    }

    @Override
    public void setDistancia_y_Arr(int distancia_y_Arr) {
        this.distancia_y_Arr = distancia_y_Arr;
    }

    @Override
    public void setDistancia_y_Abj(int distancia_y_Abj) {
        this.distancia_y_Abj = distancia_y_Abj;
    }

    @Override
    public void setLado_Izq_Valido(int lado_Izq_Valido) {
        this.lado_Izq_Valido = lado_Izq_Valido;
    }

    @Override
    public void setLado_Der_Valido(int lado_Der_Valido) {
        this.lado_Der_Valido = lado_Der_Valido;
    }

    @Override
    public void setListaFichas(ArrayList<Fichas_Tablero> ListaFichas) {
        this.ListaFichas = ListaFichas;
    }

    @Override
    public int getCantidadFichasColocadas() {
        if(this.ListaFichas.isEmpty())
            return 0;
        else
            return this.ListaFichas.size();
    }
    
}
