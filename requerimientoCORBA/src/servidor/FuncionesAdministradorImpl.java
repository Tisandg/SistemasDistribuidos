
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
    public static ArrayList<usuarioSuscrito> usuarios_Suscritos;
    private byte[] contenidoDelFichero;
    private File Archivo;
    private FileInputStream cancion;
    private BufferedInputStream theBIS;
    private byte[] buffer;
    private int leido;
    private ByteArrayOutputStream theBOS;
    
    
    public FuncionesAdministradorImpl(){
        objUsuariosDAO = new UsuarioDAO();
        usuarios_Suscritos = new ArrayList<>();
        contenidoDelFichero = null;
        cancion = null;
        theBIS = null;
        buffer = new byte[8 * 1024];
        leido = 0;
        theBOS = new ByteArrayOutputStream();
    }

    public ArrayList<usuarioSuscrito> getUsuarios_Suscritos() {
        return usuarios_Suscritos;
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
    public boolean seleccionarAudio(String ruta) {       
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
    public boolean EjecutarAudio() {
        Estacion aud = new Estacion(contenidoDelFichero, this);
        aud.Dividir_Cancion();
        aud.start();
        System.out.println("Impl continua ejecuacion....");
        return false;
    }
    
    @Override
    public String[] obtenerSuscritos() {
        System.out.println("Servidor : Obtenersuscritos");     
        ArrayList<String> list = new ArrayList<>();
        int i = 0;
        while(usuarios_Suscritos.size() > i){
            list.add(usuarios_Suscritos.get(i).getLoginUsuario());
            i++;
        }
        String[] suscritos = new String[list.size()];
        list.toArray(suscritos);
        return suscritos;
    }

    @Override
    public boolean eliminarSuscripcion_Usuario(String loginUsuario) {
        System.out.println("Servidor : Eliminar Suscripcion");
        int i = 0;
        while(usuarios_Suscritos.size() > i){
            if(usuarios_Suscritos.get(i).getLoginUsuario().equals(loginUsuario)){
                usuarios_Suscritos.remove(i);
                return true;
            }
            i++;
        }
        return false;
    }

    @Override
    public boolean suscribir_Usuario(usuarioCallbackInt objcllbck, String loginUsuario) {
        System.out.println("Servidor : Agragar Suscripcion");
        usuarioSuscrito nuevoUsuario = new usuarioSuscrito(loginUsuario, objcllbck);
        if(!usuarios_Suscritos.contains(nuevoUsuario)){
            usuarios_Suscritos.add(nuevoUsuario);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void enviarAudio(String loginUsuario, byte[] paquete) {
        System.out.println("Servidor : Enviar Audio......");
        int i = 0;
        usuarioCallbackIntOperations objRemoto = null; 
        while(usuarios_Suscritos.size() > i){
            if(usuarios_Suscritos.get(i).getLoginUsuario().equals(loginUsuario)){
                objRemoto = usuarios_Suscritos.get(i).getObjcllbck();
                break;
            }
            i++;
        }
        if(objRemoto != null){
            objRemoto.resibirAudio(loginUsuario, paquete);
        }      
    }

    @Override
    public void notificarUsuario(String loginUsuario, String mensaje) {
        System.out.println("Servidor : Notificar Usuario......");
        int i = 0;
        usuarioCallbackIntOperations objRemoto = null; 
        while(usuarios_Suscritos.size() > i){
            if(usuarios_Suscritos.get(i).getLoginUsuario().equals(loginUsuario)){
                objRemoto = usuarios_Suscritos.get(i).getObjcllbck();
                break;
            }
            i++;
        }
        if(objRemoto != null){
            objRemoto.resibirMensaje(loginUsuario, mensaje);
        }
    }
     
}
