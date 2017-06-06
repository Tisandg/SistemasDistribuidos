
package servidor;

import LogicaNegocio.UsuarioDAO;
import java.util.ArrayList;
import sop_corba.Usuario;
import sop_corba.autenticacionUsuarioOperations;
/**
 *
 * @author HP
 */
public class AutentificacionUsuarioImpl implements autenticacionUsuarioOperations{

    private UsuarioDAO objUsuariosDAO;
    private ArrayList<String> UsuariosActivos;
    
    public AutentificacionUsuarioImpl(){
        objUsuariosDAO = new UsuarioDAO();
        UsuariosActivos = new ArrayList<>();
    }
    
    @Override
    public boolean ingresar(String login, String clave) {
        boolean autenticado = false;
        /*Primero, verificamos que el usuario existe*/
        boolean existe = objUsuariosDAO.ExisteUsuario(login);
        if(existe){
            System.out.println("Usuario existe, pasamos a comprobar los datos");
            boolean inicio = objUsuariosDAO.IngresoSistema(login, clave);
            if(inicio){
                System.out.println("El usuario se ha autenticado");
                autenticado = true;
                /*agregamos a la lista de usuarios activos*/
                UsuariosActivos.add(login);
            }else{
                System.out.println("Usuario o clave no coinciden. Vuelva a intentar");
            }
        }else{
            System.out.println("No hay un usuario registrado con ese login");
        }
        return autenticado;
    }

    @Override
    public boolean salir(String login) {
        /*Eliminamos en el arreglo de usuarios activos el login*/
        System.out.println("desconectando cliente");
        boolean registro = false;
        if(UsuariosActivos.contains(login)){
            registro = UsuariosActivos.remove(login);
        }
        if(registro){
            System.out.println("El usuario "+ login +" se ha desconectado");
        }else{
            System.out.println("El usuario "+ login +" no se ha desconectado");
        }
        return registro;
    }
    
    

    @Override
    public String[] obtenerUsuariosActivos() {
        System.out.println("Servidor : Consultar Usuarios Activos");       
        String[] usuarios = new String[UsuariosActivos.size()];
        UsuariosActivos.toArray(usuarios);
        return usuarios;
    }

    
}
