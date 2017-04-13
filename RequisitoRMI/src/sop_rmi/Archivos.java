package sop_rmi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * @author Santiago Garcia
 */
public class Archivos {
    
    private File archivo = null;
    private FileReader fr = null; // este no lee las lineas completas
    private BufferedReader br = null; //este si tiene los metodos para hacer lo anterior
    
    private FileWriter fichero;
    private PrintWriter pw;
    
    public Archivos(){
        this.archivo = null;
        this.fr = null;
        this.br = null;
        this.fichero = null;
        this.pw = null;
    }
    
    public Usuario obtenerInfoUsuario(String login){
        Usuario usuario = new Usuario();
        try {
           // Apertura del fichero y creacion de BufferedReader para poder
           // hacer una lectura comoda (disponer del metodo readLine()).
           archivo = new File ("./Usuarios/usuario_"+login+".txt");
           fr = new FileReader (archivo);
           br = new BufferedReader(fr);

           // Lectura del fichero
           String linea;
           int i;
           for (i = 0; i < 4; i++) {
             linea=br.readLine();
             if( linea != null){
                if(i == 0) usuario.setLogin(linea);
                if(i == 1) usuario.setClave(linea);
                if(i == 2) usuario.setNombre(linea);
                if(i == 3) usuario.setApellido(linea);
             }
           }
           usuario.setAdmin(false);
        }
        catch(Exception e){
           //e.printStackTrace();
            System.out.println("El archivo no ha sido encontrado");
        }finally{
           // En el finally cerramos el fichero, para asegurarnos
           // que se cierra tanto si todo va bien como si salta 
           // una excepcion.
           try{                    
                if( null != fr ){   
                   fr.close();     
                }                  
           }catch (Exception e2){ 
                e2.printStackTrace();
           }
        }
        return usuario;
    }
    
    public void leerArchivo(){

        try {
           // Apertura del fichero y creacion de BufferedReader para poder
           // hacer una lectura comoda (disponer del metodo readLine()).
           archivo = new File ("./Usuarios/usuario_1.txt");
           fr = new FileReader (archivo);
           br = new BufferedReader(fr);

           // Lectura del fichero
           String linea;
           while((linea=br.readLine())!=null){
               System.out.println(linea);
           }
        }
        catch(Exception e){
           //e.printStackTrace();
            System.out.println("El archivo no ha sido encontrado");
        }finally{
           // En el finally cerramos el fichero, para asegurarnos
           // que se cierra tanto si todo va bien como si salta 
           // una excepcion.
           try{                    
                if( null != fr ){   
                   fr.close();     
                }                  
           }catch (Exception e2){ 
                e2.printStackTrace();
           }
        }
    }
    
    public boolean crearArchivo(Usuario usuario){
        boolean escribio = false;
        try
        {
            /* ../PRUEBA.txt  =  Asi escribe fuera de la carpeta(con 2 puntos)
            * con un punto dentro de la carpeta*/
            fichero = new FileWriter("./Usuarios/usuario_"+usuario.getLogin()+".txt");
            pw = new PrintWriter(fichero);
            
            /*Escribimos los datos de nuestro objeto en el txt*/
            pw.println(usuario.getLogin());
            pw.println(usuario.getClave());
            pw.println(usuario.getNombre());
            pw.println(usuario.getApellido());
            escribio = true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
        return escribio;
    }
    
    public boolean existeArchivo(String login){
        String ruta = "./Usuarios/usuario_"+login+".txt";
        boolean esta = false;
        try {
            //Abrimos el fichero e intentamos leerlo
            archivo = new File ("./Usuarios/usuario_1.txt");
            fr = new FileReader (archivo);
            System.out.println("Se ha encontrado un archivo con el login ingresado");
            esta = true;
        }
        catch(Exception e){
           //e.printStackTrace();
            System.out.println("No se ha encontrado un archivo con el login ingresado");
            esta = false;
        }finally{
           // En el finally cerramos el fichero, para asegurarnos
           // que se cierra tanto si todo va bien como si salta 
           // una excepcion.
           try{                    
                if( null != fr ){   
                   fr.close();     
                } 
           }catch (Exception e2){ 
                e2.printStackTrace();
           }
        }
        return esta;
    }
    
    public boolean compararDatos(String login,String clave){
        boolean respuesta = false;
        try {
           // Apertura del fichero y creacion de BufferedReader para poder
           // hacer una lectura comoda (disponer del metodo readLine()).
           archivo = new File ("./Usuarios/usuario_"+login+".txt");
           fr = new FileReader (archivo);
           br = new BufferedReader(fr);

           // Lectura del fichero
           String linea;
           int i;
           for (i = 0; i < 4; i++) {
             linea=br.readLine();
             if( linea != null){
                if(i == 1){
                    if(linea.compareTo(clave) == 0){
                        respuesta = true;
                    }
                } 
             }
           }
           /*Comparamos la contraseña*/
           
        }
        catch(Exception e){
           //e.printStackTrace();
            System.out.println("El archivo no ha sido encontrado");
        }finally{
           // En el finally cerramos el fichero, para asegurarnos
           // que se cierra tanto si todo va bien como si salta 
           // una excepcion.
           try{                    
                if( null != fr ){   
                   fr.close();     
                }                  
           }catch (Exception e2){ 
                e2.printStackTrace();
           }
        }
        return respuesta;
    }
    
    public boolean eliminarArchivo(String login){
        File fichero = new File("./Usuarios/usuario_"+login+".txt");
        if (fichero.delete()){
            System.out.println("El fichero ha sido borrado satisfactoriamente");
            return true;
        }else{
            System.out.println("El fichero no puede ser borrado");
        }
        return false;
    }
    
    public ArrayList<Usuario> listarArchivosDirectorio(){
        String sDirectorio = "./Usuarios";
        File f = new File(sDirectorio);
        if (f.exists()){ 
            File[] ficheros = f.listFiles();
            ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
            int i;
            int tam = ficheros.length;
            for (i=0; i < tam ; i++){
                String nombre = ficheros[i].getName();
                System.out.println(nombre);
                String[] partido = nombre.split("_");
                String auxiliar = partido[1];
                String[] login = auxiliar.split(".txt");
                //System.out.println("login: "+login[0]);
                usuarios.add(obtenerInfoUsuario(login[0]));
            }
            return usuarios;
        }else {
            System.out.println("El directorio no existe");
        }
        return null;
    }
}
