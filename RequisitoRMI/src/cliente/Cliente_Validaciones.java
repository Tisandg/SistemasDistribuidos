
package cliente;

/**
 *
 * @author Kevin Chantré
 */
public class Cliente_Validaciones {
    
    public boolean Es_Numero(String cadena){
        int numero = 0;
	try{
            numero = Integer.parseInt(cadena);
	}catch(Exception e){
            return false;	
	}
            return true;
    }
}
