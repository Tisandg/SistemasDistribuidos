
package servidor;

import LogicaNegocio.UsuarioDAO;
import java.util.ArrayList;
import sop_corba.Interfaz_GestionOperations;
import sop_corba.Usuario;
/**
 *
 * @author Kevin Chantré
 */
public class GestionImpl implements Interfaz_GestionOperations{

    private UsuarioDAO objUsuariosDAO;
    
    public GestionImpl(){
        objUsuariosDAO = new UsuarioDAO();
    }

    @Override
    public boolean registrarUsuario(Usuario N_Usuario) {
        System.out.println("Servidor Gestion : registrarUsuario....");
        return objUsuariosDAO.registrarUsuario(N_Usuario);
    }

    @Override
    public Usuario[] consultarUsuarios() {
        System.out.println("Servidor Gestion : Consultar Usuarios");
        ArrayList<Usuario> empl = objUsuariosDAO.consultarUsuarios();
        Usuario[] usuarios = new Usuario[empl.size()];
        empl.toArray(usuarios);
        return usuarios;
    }

    @Override
    public Usuario consultarUsuario(String login) {
        System.out.println("Servidor Gestion : Consultar Usuario");
        return objUsuariosDAO.consultarUsuario(login);
    }

    @Override
    public boolean exiteUsuario(String login) {
        System.out.println("Servidor Gestion : Existe Usuario");
        return objUsuariosDAO.ExisteUsuario(login);
    }

    @Override
    public boolean actualizarUsuario(Usuario objUsuario, String login) {
        System.out.println("Servidor Gestion : Actualizar Usuario");
        return objUsuariosDAO.actualizarUsuario(objUsuario, login);
    }

    @Override
    public boolean eliminarUsuario(String login) {
        System.out.println("Servidor : Desactivar Usuario "+login);
        return objUsuariosDAO.eliminarUsuario(login);
    }
    
}
