package sop_rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import sop_rmi.Jugador;

/**
 * @author Santiago Garcia
 * Clase que implementa la interfaz de UsuariosInt
 */
public class UsuariosImpl extends UnicastRemoteObject implements UsuariosInt{
    
    private final int maxNombre = 30;
    private final int maxApellido = 20;
    private final int maxLoginU = 10;
    private final int minClave = 8;
    private final int maxClave = 15;
    private Archivos manejadorArchivos;
    
    /*Guarda el login y la referencia del objeto*/
    private Hashtable<String,UsuarioCallBackInt> usuariosConectados;
    
    public UsuariosImpl() throws RemoteException
    {
        super(); //invoca al constructor de la clase base       
        this.manejadorArchivos = new Archivos();
        //this.usuariosConectados = new ArrayList<Usuario>();
        this.usuariosConectados = new Hashtable<String,UsuarioCallBackInt>();
    }
    
    public int validacionesRegistroUsuario(UsuarioCallBackImpl usuario){
        int errores = 0;
        if(usuario.getNombre().length() < 1){
            System.out.println("El nombre no puede estar vacio");
            errores++;
        }else if(usuario.getNombre().length() > maxNombre){
                System.out.println("El nombre no debe superar los "+maxNombre+" caracteres");
                errores++;
        }
        
        if(usuario.getApellido().length() < 1){
            System.out.println("El apellido no puede estar vacio");
            errores++;
        }
        else if(usuario.getApellido().length() > maxApellido)
        {
                System.out.println("El apellido no debe superar los "+maxApellido+" caracteres");
                errores++;
        }
        
        if(usuario.getLogin().length() < 1){
            System.out.println("El login no puede estar vacio");
            errores++;
        }
        else if(usuario.getLogin().length() > maxLoginU)
        {
                System.out.println("El login no debe superar los "+maxLoginU+" caracteres");
                errores++;
        }
        
        if(usuario.getClave().length() < 1){
            System.out.println("La contraseña no puede estar vacia");
            errores++;
        }
        else if(usuario.getClave().length() > maxClave || usuario.getClave().length() < minClave)
        {
                System.out.println("La clave no debe ser menor a "+minClave+" o mayor a "+maxClave+" caracteres");
                errores++;
        }
        
        return errores;
    }
    
    public int validacionesInicioAdmin(String login, String clave){
        int errores = 0;
        if(login.length() < 1){
            System.out.println("El login no puede estar vacio");
            errores++;
        }else{
            /*Se puede utilizar las constantes maxClave y minClave ya que tienen los mismo
            * valores de validacion para el login*/
            if(login.length() > maxClave || login.length() < minClave){
                System.out.println("El login no debe ser menor a "+minClave+" o mayor a "+maxClave+" caracteres");
                errores++;
            }
        }
        if(clave.length() < 1){
            System.out.println("La contraseña no puede estar vacia");
            errores++;
        }else{
            if(clave.length() > maxClave || clave.length() < minClave){
                System.out.println("La contraseña no debe ser menor a "+minClave+" o mayor a "+maxClave+" caracteres");
                errores++;
            }
        }
        return errores;
    }
    
    public int validacionesInicioUsuario(String login, String clave){
        int errores = 0;
        if(login.length() < 1){
            System.out.println("El login no puede estar vacio");
            errores++;
        }else{
            if(login.length() > maxLoginU){
                System.out.println("El login no debe superar los "+maxLoginU+" caracteres");
                errores++;
            }
        }
        
        if(clave.length() < 1){
            System.out.println("La contraseña no puede estar vacia");
            errores++;
        }else{
            if(clave.length() > maxClave || clave.length() < minClave){
                System.out.println("La contraseña no debe ser menor a "+minClave+" o mayor a "+maxClave+" caracteres");
                errores++;
            }
        }
        return errores;
    }
    
    
    @Override
    public synchronized boolean registrarse(UsuarioCallBackImpl nuevoUsuario) throws RemoteException {
        int validacion;
        /*Validamos los campos ingresados*/
        validacion = validacionesRegistroUsuario(nuevoUsuario);
        if(validacion != 0){
            System.out.println("Por favor, verifique los datos ingresados");
            return false;
        }else{
            /*Verificamos que no se ha registrado ese login
            * False ya que es un usuario*/
            if(manejadorArchivos.existeArchivo(nuevoUsuario.getLogin(),false)){
                System.out.println("El login ya existe. Intente con uno nuevo");
                return false;
            }else{
                /*Procedemos a registrar los datos en un archivos de texto*/
                System.out.println("Registrando usuario...");
                if(manejadorArchivos.crearArchivo(nuevoUsuario)){
                    System.out.println("El usuario ha sido registrado");
                    return true;
                }else{
                    System.out.println("Ocurrio un problema a la hora de crear el archivo del usuario");
                    return false;
                }
            }
        }
    }

    @Override
    public boolean iniciarSesion(String login, String clave, boolean admin) throws RemoteException 
    {
        /*Validamos la informacion ingresada*/
        int validaciones;
        if (admin) {
            validaciones = validacionesInicioAdmin(login,clave);
        }else{
            validaciones = validacionesInicioUsuario(login,clave);
        }
        if(validaciones != 0){
            System.out.println("Por favor, verifique los datos ingresados");
            return false;
        }else{
            /*Buscamos el archivo del usuario por el login*/
            if(manejadorArchivos.existeArchivo(login,admin)){
                /*Comprobamos la contraseña*/
                if(manejadorArchivos.compararDatos(login,clave,admin)){
                    /*Si no es administrador lo agregamos a la lista de usuarios conectados*/
                    if(admin == false){
                        UsuarioCallBackImpl auxiliar = consultarUsuario(login);
                        /*Apenas inicio, se marca como "no jugando"*/
                        auxiliar.setJugando(false);
                        usuariosConectados.put(login,auxiliar);
                    }
                    System.out.println("Sesion iniciada!");
                    return true;
                }else{
                    System.out.println("Los datos no coinciden");
                }
            }else{
                System.out.println("El usuario con login "+login+" no esta registrado");
            }
        }
        
        return false;
    }

    @Override
    public UsuarioCallBackImpl consultarUsuario(String login) throws RemoteException {
        System.out.println("Consultado usuario");
        /*False ya que es usuario*/
       if(manejadorArchivos.existeArchivo(login,false)){
            /*Comprobamos la contraseña*/
            UsuarioCallBackImpl consultado=new UsuarioCallBackImpl();
            consultado = manejadorArchivos.obtenerInfoUsuario(login);
            return consultado;
        }else{
            System.out.println("El usuario con login "+login+" no esta registrado");
            return null;
       } 
    }

    @Override
    public boolean modificarUsuario(UsuarioCallBackImpl u) throws RemoteException {
        System.out.println("Modificando Usuario");
        if(validacionesRegistroUsuario(u) == 0){
            /*El mismo metodos para crear sobreescribe la informacion del archivo*/
            if(manejadorArchivos.crearArchivo(u)){
                System.out.println("El usuario ha sido modificado");
                return true;
            }else{
                System.out.println("Ocurrio un problema a la hora de modificar el archivo del usuario");
                return false;
            }
        }else{
            System.out.println("No cumple con las validaciones");
            return false;
        }
    }

    @Override
    public boolean eliminarUsuario(String login) throws RemoteException {
        /*Suponiendo que el archivo se encuentra*/
        if(manejadorArchivos.eliminarArchivo(login)){
            System.out.println("El usuario "+login+" se ha eliminado exitosamente");
            return true;
        }else{
            System.out.println("El archivo del usuario "+login+"no se ha podio eliminar");
        }
        return false;
    }

    /*Funcion para obtener todos los usuarios registrados en el sistema
    * @return Lista con los login de usuarios registrados*/
    @Override
    public ArrayList<String> listarUsuarios() throws RemoteException 
    {
        System.out.println("Listando usuarios conectados");
        ArrayList<String> usuarios = new ArrayList<String>();
        Enumeration e = usuariosConectados.keys();
        String clave;
        while( e.hasMoreElements() ){
            clave =(String) e.nextElement();
            usuarios.add(clave);
        }
        return usuarios;
    }

    @Override
    public boolean salir(String login) throws RemoteException {
        usuariosConectados.remove(login);
        System.out.println("Usuario "+login+" ha cerrado sesion");
        return true;
    }
    
}
