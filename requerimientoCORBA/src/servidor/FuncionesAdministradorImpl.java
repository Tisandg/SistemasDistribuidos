
package servidor;
import sop_corba.*;
import LogicaNegocio.UsuarioDAO;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Kevin Chantré
 */
public class FuncionesAdministradorImpl implements Interfaz_AdministradorOperations{
    
    private UsuarioDAO objUsuariosDAO;   
    private ArrayList<String> UsuariosSuscritos;
    private byte[] contenidoDelFichero;
    private File Archivo;
    private FileInputStream cancion;
    private BufferedInputStream theBIS;
    private byte[] buffer;
    private int leido;
    private ByteArrayOutputStream theBOS;
    
    
    public FuncionesAdministradorImpl(){
        objUsuariosDAO = new UsuarioDAO();
        UsuariosSuscritos = new ArrayList<>();
        contenidoDelFichero = null;
        cancion = null;
        theBIS = null;
        buffer = new byte[8 * 1024];
        leido = 0;
        theBOS = new ByteArrayOutputStream();
    }
    
    @Override
    public boolean ingresoSistemaAdministrador(String login, String clave) {
        System.out.println("Servidor: Ingreso al sistema Administrador....");
        return objUsuariosDAO.IngresoSistema(login, clave, true);
    }
    
    @Override
    public boolean registrarUsuario(Usuario N_Usuario) {
        System.out.println("Servidor : Registrar Usuario");
        return objUsuariosDAO.registrarUsuario(N_Usuario);
    }

    @Override
    public Usuario[] consultarUsuarios() {
        System.out.println("Servidor : Consultar Usuarios");
        ArrayList<Usuario> empl = objUsuariosDAO.consultarUsuarios();
        Usuario[] usuarios = new Usuario[empl.size()];
        empl.toArray(usuarios);
        return usuarios;
    }

    @Override
    public Usuario consultarUsuario(String login) {
        System.out.println("Servidor : Consultar Usuario");
        return objUsuariosDAO.consultarUsuario(login);
    }

    @Override
    public boolean exiteUsuario(String login) {
        System.out.println("Servidor : Existe Usuario");
        return objUsuariosDAO.ExisteUsuario(login);
    }

    @Override
    public boolean actualizarUsuario(Usuario objUsuario, String login) {
        System.out.println("Servidor : Actualizar Usuario");
        return objUsuariosDAO.actualizarUsuario(objUsuario, login);
    }

    @Override
    public boolean eliminarUsuario(String login) {
        System.out.println("Servidor : Eliminar Usuario");
        return objUsuariosDAO.eliminarUsuario(login);
    }

    @Override
    public byte[] enviarAudio() {       
        System.out.println("Servidor: Enviar Audio....");
        return contenidoDelFichero;
    }


    @Override
    public boolean EjecutarAudio() {
        int i = 0;
        while(contenidoDelFichero.length < i){
            
            i++;
        }
        return false;
    }

    @Override
    public boolean seleccionarAudio(String ruta) {
        //"C:\\Users\\HP\\Documents\\Universidad\\NetBeansProjects\\Sonido\\src\\Musica\\Sonido_1.mp3"
        Archivo = new File(ruta);
        try {
            cancion = new FileInputStream(Archivo);
            theBIS = new BufferedInputStream(cancion);
            
            while ((leido = theBIS.read(buffer)) >= 0) {
                    theBOS.write(buffer, 0, leido);
            }   
            contenidoDelFichero = theBOS.toByteArray();
            theBOS.reset();
            theBOS.close();
            return true;
        } catch (IOException e1) {
            e1.printStackTrace();
            return false;
        }
    }

    @Override
    public String[] obtenerSuscritos() {
        System.out.println("Servidor : Obtenersuscritos");
        ArrayList<String> list = objUsuariosDAO.obtenerSuscritos();
        String[] suscritos = new String[list.size()];
        list.toArray(suscritos);
        return suscritos;
    }
     
}
