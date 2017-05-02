
package cliente;

import sop_rmi.Ficha;
/**
 *
 * @author Kevin Chantré
 */
public class Utilidades {
    private String carpeta;
    private String extension;
    public String Imagen;
    public int numeroMaxFichas;
    public int contador;
    
    public Utilidades(int numeroMaxFichas) {
        this.carpeta = "/imagenes/";
        this.extension = ".png";
        this.Imagen = "";
        this.numeroMaxFichas = numeroMaxFichas;
        this.contador = 0;
    }
    
    public Utilidades(){
        
    }
   
    public boolean Es_Numero(String cadena){
        int numero = 0;
	try{
            numero = Integer.parseInt(cadena);
	}catch(Exception e){
            return false;	
	}
            return true;
    }
    
    public String Buscar_Imagen(Ficha Nueva_Ficha){
        if(numeroMaxFichas >= contador ){
            String nombre_Imagen = Integer.toString(Nueva_Ficha.getLado_A())+"_"+Integer.toString(Nueva_Ficha.getLado_B())+"_v";
            Imagen = carpeta+nombre_Imagen+extension;
            contador++;
            return Imagen; 
        }else{
            Imagen = "/imagenes/ninguna.png";
            return Imagen; 
        }   
    }
    
}
