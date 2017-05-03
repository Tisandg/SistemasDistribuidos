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
    
    private static File archivo = null;
    private static FileReader fr = null; // este no lee las lineas completas
    private static BufferedReader br = null; //este si tiene los metodos para hacer lo anterior
    
    private FileWriter fichero;
    private PrintWriter pw;
    
    public Archivos(){
        this.archivo = null;
        this.fr = null;
        this.br = null;
        this.fichero = null;
        this.pw = null;
    }
    
    public static Usuario obtenerInfoUsuario(String login, boolean admin){
        String ruta;
        if(admin){
            ruta = "./Administrador/usuario_admin.txt";
        }else{
            ruta = "./Usuarios/usuario_"+login+".txt";
        }  
        Usuario usuario = obtenerInfoUsuario(login, ruta);
        usuario.setAdmin(admin);
        return usuario;
        
    }
    
    public static Usuario obtenerInfoUsuario(String login,String ruta){
        Usuario usuario = new Usuario();
        try {
           // Apertura del fichero y creacion de BufferedReader para poder
           // hacer una lectura comoda (disponer del metodo readLine()).
           archivo = new File (ruta);
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
    
    /* Funcion para leer el contenido de un archivo 
    * @param ruta del archivo a leer
    * @return Array de las lineas leidas*/
    public ArrayList<String> leerArchivo(String ruta){

        ArrayList<String> lineasLeidas = new ArrayList<String>();
        try {
           // Apertura del fichero y creacion de BufferedReader para poder
           // hacer una lectura comoda (disponer del metodo readLine()).
           archivo = new File (ruta);
           fr = new FileReader (archivo);
           br = new BufferedReader(fr);
           
            System.out.println("Leyendo lineas del archivo de la ruta '"+ruta+"'");
           // Lectura del fichero
           String linea;
           while((linea=br.readLine())!=null){
               lineasLeidas.add(linea);
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
        return lineasLeidas;
    }
    
    /*Funcion para escribir informacion en un determinado archivo de texto.
    * Escribira al final del archivo.
    * @param ruta del archivo en el que se va a escribir
    * @param texto a escribir
    * @return true o false si realizo o no la escritura*/
    public boolean escribirEnArchivo(String ruta, String texto){
        boolean respuesta = false; 
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            /*parametro true para que escribe al final del archivo*/
            fichero = new FileWriter(ruta,true);
            pw = new PrintWriter(fichero);
            pw.println("\n"+texto);
            respuesta = true;
            
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
        return respuesta;
    }
    public boolean crearArchivo(Usuario usuario){
        String ruta;
        if(usuario.GetAdmin()){
            ruta = "./Administrador/usuario_admin.txt";
        }else{
            ruta = "./Usuarios/usuario_"+usuario.getLogin()+".txt";
        }  
        return crearArchivo(usuario,ruta);
    }
    
    public boolean crearArchivo(Usuario usuario,String ruta){
        boolean escribio = false;
        try
        {
            /* ../PRUEBA.txt  =  Asi escribe fuera de la carpeta(con 2 puntos)
            * con un punto dentro de la carpeta*/
            fichero = new FileWriter(ruta);
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
    
    /*Funcion para comprobar que no halla un archivo registrado con el
    * login ingresado
    * @param login a buscar
    * @param boolean para saber si es un administrador
    * @return boolean que indica si hay o no un archivo registrado con el login*/
    public boolean existeArchivo(String login, boolean esAdmin){
        String ruta;
        if(esAdmin){
            ruta = "./Administrador/usuario_admin.txt";
        }else{
            ruta = "./Usuarios/usuario_"+login+".txt";
        }
        return existeArchivo(ruta);
    }
    
    private boolean existeArchivo(String ruta){
        boolean esta = false;
        try {
            //Abrimos el fichero e intentamos leerlo
            archivo = new File (ruta);
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
    
    /* Funcion para comparar el login y la contraseña ingresados con los datos
    *  registrados en el archivo del usuario
    *  @param String con el login del usuario
    *  @param String con la lave del usuario
    *  @param boolean para saber si es admin
    *  @return true si los datos coinciden, de lo contrario false
    */
    public boolean compararDatos(String login,String clave, boolean esAdmin){
        String ruta;
        if(esAdmin){
            ruta = "./Administrador/usuario_admin.txt";
            return compararDatos(login,clave,ruta);
        }else{
            ruta = "./Usuarios/usuario_"+login+".txt";
            return compararDatos(login,clave,ruta);
        }   
    }
    private boolean compararDatos(String login,String clave,String ruta){
        boolean respuesta = false;
        try {
           // Apertura del fichero y creacion de BufferedReader para poder
           // hacer una lectura comoda (disponer del metodo readLine()).
            System.out.println("Ruta - clave "+ruta+" "+clave);
           archivo = new File (ruta);
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
    
    /* Funcion que recoore el directorio "usuarios" para saber cuantos hay
    *  registrados.
    *  @return Lista de usuarios registrados  */
    public static ArrayList<Usuario> listarArchivosDirectorio(){
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
                usuarios.add(obtenerInfoUsuario(login[0], false) );
            }
            return usuarios;
        }else {
            System.out.println("El directorio no existe");
        }
        return null;
    }
}
