
package servidor;
import sop_corba.*;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Kevin Chantré
 */
public class FuncionesAdministradorImpl implements Interfaz_AdministradorOperations{
    
    public static ArrayList<usuarioSuscrito> usuarios_Suscritos;
    public static boolean Reproduciendo; 
    private byte[] contenidoDelFichero;
    private File Archivo;
    private FileInputStream cancion;
    private BufferedInputStream theBIS;
    private byte[] buffer;
    private int leido;
    private ByteArrayOutputStream theBOS;
    private String Mensaje;
    
    public FuncionesAdministradorImpl(){
        usuarios_Suscritos = new ArrayList<>();
        contenidoDelFichero = null;
        Reproduciendo = false;
        cancion = null;
        theBIS = null;
        buffer = new byte[8 * 1024];
        leido = 0;
        theBOS = new ByteArrayOutputStream();
        Mensaje = "";
    }

    public ArrayList<usuarioSuscrito> getUsuarios_Suscritos() {
        return usuarios_Suscritos;
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
    public void EjecutarAudio() {
        Estacion aud = new Estacion(contenidoDelFichero, this);
        aud.Dividir_Cancion();
        aud.start();
        
//        ReproductorAudio aud = new ReproductorAudio(contenidoDelFichero);
//        aud.Dividir_Cancion();
//        aud.start();
//        System.out.println("Impl continua ejecuacion....");
    }
    
    @Override
    public String[] obtenerSuscritos() {
        System.out.println("Servidor : Obtenersuscritos");           
        return suscritos();
    }

    @Override
    public synchronized boolean eliminarSuscripcion_Usuario(String loginUsuario) {
        System.out.println("Servidor :Eliminar Suscripcion");
        usuarioCallbackIntOperations objRemoto = null;
        int i = 0;
        while(usuarios_Suscritos.size() > i){
            if(usuarios_Suscritos.get(i).getLoginUsuario().equals(loginUsuario)){               
                usuarios_Suscritos.remove(i);
                objRemoto = usuarios_Suscritos.get(0).getObjcllbck();
                objRemoto.actualizarSuscritos(suscritos());
                return true;
            }
            i++;
        }
        return false;
    }

    @Override
    public synchronized boolean suscribir_Usuario(usuarioCallbackInt objcllbck, String loginUsuario) {
        System.out.println("Servidor : Agregar Suscripcion "+loginUsuario);
        usuarioSuscrito nuevoUsuario = new usuarioSuscrito(loginUsuario, objcllbck, false, false);
        usuarioCallbackIntOperations objRemoto = null;
        
        if(!usuarios_Suscritos.contains(nuevoUsuario)){
            usuarios_Suscritos.add(nuevoUsuario);
            objRemoto = usuarios_Suscritos.get(0).getObjcllbck();
            objRemoto.actualizarSuscritos(suscritos());
            if(Reproduciendo){
                objRemoto = objcllbck;
                objRemoto.resibirMensaje(Mensaje);
            }
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void enviarAudio(String loginUsuario, byte[] paquete) {
        System.out.println("Servidor : Enviar Audio......"+ loginUsuario);
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
            objRemoto.resibirAudio(paquete);
        }      
    }

    @Override
    public void notificarUsuarios(String mensaje) {
        System.out.println("Servidor : Notificar Usuarios......");
        this.Mensaje = mensaje;
        NotificarUsuario_Hilo notificar = new NotificarUsuario_Hilo(mensaje);       
        notificar.start();    
    }
    
    @Override
    public synchronized void AceptarPaquetes(String loginUsuario) {
        System.out.println("Servidor : Aceptar Paquetes de Audio......");
        int i = 0;
        while(usuarios_Suscritos.size() > i){
            if(usuarios_Suscritos.get(i).getLoginUsuario().equals(loginUsuario)){
                usuarios_Suscritos.get(i).setAceptaEscuchar(true);
                break;
            }
            i++;
        }
    }
    
    /*
    Metodo local encargado de retornar los usuarios actualente conectados a la aplicacion
    */
    public String [] suscritos(){
        ArrayList<String> list = new ArrayList<>();
        int i = 1;
        while(usuarios_Suscritos.size() > i){
            list.add(usuarios_Suscritos.get(i).getLoginUsuario());
            i++;
        }
        String[] suscritos = new String[list.size()];
        list.toArray(suscritos);
        
        return suscritos;
    }

    
     
}
