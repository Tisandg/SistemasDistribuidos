
package servidor;
//import sop_corba.Usuario;
/**
 *
 * @author HP
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Usuario nuevo = new Usuario(5, "pepe", "cortizona", "pepe", "123", "", true);
        FuncionesAdministradorImpl obj = new FuncionesAdministradorImpl();
        obj.seleccionarAudio("C:\\Users\\HP\\Music\\ELECTRONICA\\02 Adele - Rolling In The Deep.mp3");
        //obj.registrarUsuario(nuevo);
        obj.EjecutarAudio();
        
    }
    
}
