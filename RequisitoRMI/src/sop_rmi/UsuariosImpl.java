package sop_rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import cliente.UsuarioCallBackInt;
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
    private ArrayList<UsuarioActivo> listadoUsuariosActivos;
<<<<<<< HEAD
    private final JugarImpl objJugar;
    private ArrayList<Ficha> FichasUsuario1;
    private ArrayList<Ficha> FichasUsuario2;
=======
    
>>>>>>> origin/master
    
    public UsuariosImpl() throws RemoteException
    {
        super(); //invoca al constructor de la clase base       
        this.manejadorArchivos = new Archivos();
        this.listadoUsuariosActivos = new ArrayList<>();
<<<<<<< HEAD
        this.objJugar = new JugarImpl();
        this.FichasUsuario1 = new ArrayList<>();
        this.FichasUsuario2 = new ArrayList<>();
=======
        
>>>>>>> origin/master
    }
    
    /*************************     Validaciones    ****************************/
    public boolean campoVacio(String dato){
        return (dato.length() < 1)?true:false;
    }
    
    public int validacionNombre(String nombre){
        if(nombre.length() > maxNombre){
            System.out.println("El nombre no debe superar los "+maxNombre+" caracteres");
            return 1;
        }
        return 0;
<<<<<<< HEAD
    }
    
    public int validacionApellido(String apellido){
        if(apellido.length() > maxApellido){
            System.out.println("El apellido no debe superar los "+maxApellido+" caracteres");
            return 1;
        }
        return 0;
    }
    
    public int validacionLoginUsuario(String login){
        if(login.length() > maxLoginU){
            System.out.println("El login no debe superar los "+maxLoginU+" caracteres");
            return 1;
        }
        return 0;
    }
    
    /*Se puede utilizar las constantes maxClave y minClave ya que tienen los mismo
    * valores de validacion para el login*/
    public int validacionLoginAdmin(String login){
        if(login.length() > maxClave || login.length() < minClave){
            System.out.println("El login no debe ser menor a "+minClave+" o mayor a "+maxClave+" caracteres");
            return 1;
        }
        return 0;
    }
    
    public int validacionClave(String clave){
        if(clave.length() > maxClave || clave.length() < minClave){
            System.out.println("La contraseña no debe ser menor a "+minClave+" o mayor a "+maxClave+" caracteres");
            return 1;
        }
        return 0;
    }
    
=======
    }
    
    public int validacionApellido(String apellido){
        if(apellido.length() > maxApellido){
            System.out.println("El apellido no debe superar los "+maxApellido+" caracteres");
            return 1;
        }
        return 0;
    }
    
    public int validacionLoginUsuario(String login){
        if(login.length() > maxLoginU){
            System.out.println("El login no debe superar los "+maxLoginU+" caracteres");
            return 1;
        }
        return 0;
    }
    
    /*Se puede utilizar las constantes maxClave y minClave ya que tienen los mismo
    * valores de validacion para el login*/
    public int validacionLoginAdmin(String login){
        if(login.length() > maxClave || login.length() < minClave){
            System.out.println("El login no debe ser menor a "+minClave+" o mayor a "+maxClave+" caracteres");
            return 1;
        }
        return 0;
    }
    
    public int validacionClave(String clave){
        if(clave.length() > maxClave || clave.length() < minClave){
            System.out.println("La contraseña no debe ser menor a "+minClave+" o mayor a "+maxClave+" caracteres");
            return 1;
        }
        return 0;
    }
    
>>>>>>> origin/master
    
    public int validacionesRegistroUsuario(Usuario usuario){
        int errores = 0;
        if(campoVacio(usuario.getNombre())){
            System.out.println("El nombre no puede estar vacio");
            errores++;
        }else{
            errores += validacionNombre(usuario.getNombre());
        } 
        
        if(campoVacio(usuario.getApellido())){
            System.out.println("El apellido no puede estar vacio");
<<<<<<< HEAD
=======
            errores++;
        }else{
            errores += validacionApellido(usuario.getApellido());
        }
        
        if(campoVacio(usuario.getLogin())){
            System.out.println("El login no puede estar vacio");
            errores++;
        }
        else{
            errores += validacionLoginUsuario(usuario.getLogin());
        }
        
        if(campoVacio(usuario.getClave())){
            System.out.println("La contraseña no puede estar vacia");
>>>>>>> origin/master
            errores++;
        }else{
            errores += validacionApellido(usuario.getApellido());
        }
        else{
            errores += validacionClave(usuario.getClave());
        }
        
<<<<<<< HEAD
        if(campoVacio(usuario.getLogin())){
            System.out.println("El login no puede estar vacio");
            errores++;
        }
        else{
            errores += validacionLoginUsuario(usuario.getLogin());
        }
        
        if(campoVacio(usuario.getClave())){
            System.out.println("La contraseña no puede estar vacia");
            errores++;
        }
        else{
            errores += validacionClave(usuario.getClave());
        }
        
=======
>>>>>>> origin/master
        return errores;
    }
    
    public int validacionesRegistroAdmin(Usuario usuario){
        int errores = 0;
        if(campoVacio(usuario.getNombre())){
            System.out.println("El nombre no puede estar vacio");
            errores++;
        }
        
        if(campoVacio(usuario.getApellido())){
            System.out.println("El apellido no puede estar vacio");
            errores++;
        }
        
        if(campoVacio(usuario.getLogin())){
            System.out.println("El login no puede estar vacio");
            errores++;
        }
        else{
            errores += validacionLoginAdmin(usuario.getLogin());
        }
        
        if(campoVacio(usuario.getClave())){
            System.out.println("La contraseña no puede estar vacia");
            errores++;
        }
        else{
            errores += validacionClave(usuario.getClave());
        }
        
        return errores;
    }
    
    public int validacionesInicioAdmin(String login, String clave){
        int errores = 0;
        if(campoVacio(login)){
            System.out.println("El login no puede estar vacio");
            errores++;
        }else{
            errores += validacionLoginAdmin(clave);
        }
        
        if(campoVacio(clave)){
            System.out.println("La contraseña no puede estar vacia");
            errores++;
        }else{
            errores += validacionClave(clave);
        }
        return errores;
    }
    
    public int validacionesInicioUsuario(String login, String clave){
        int errores = 0;
        if(campoVacio(login)){
            System.out.println("El login no puede estar vacio");
            errores++;
        }else{
            errores += validacionLoginUsuario(login);
        }
        
        if(campoVacio(clave)){
            System.out.println("La contraseña no puede estar vacia");
            errores++;
        }else{
            errores += validacionClave(clave);
        }
        return errores;
    } 
   
    @Override    
    public synchronized boolean registrarse(Usuario nuevoUsuario) throws RemoteException 
    {
        int validacion;
        System.out.println("Ingresando a la opcion de registro de usuario...\n");
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
                   
                    System.out.println("Sesion iniciada!");
                    return true;
                }
            }else{
                System.out.println("El usuario con login "+login+" no esta registrado");
            }
        }
        
        return false;
    }

    @Override
    public Usuario consultarUsuario(String login, boolean admin) throws RemoteException {
        /*False ya que es usuario*/
       if(manejadorArchivos.existeArchivo(login,admin)){
            /*Comprobamos la contraseña*/
            Usuario consultado=new Usuario();
            consultado = manejadorArchivos.obtenerInfoUsuario(login,admin);
            return consultado;
        }else{
            System.out.println("El usuario con login "+login+" no esta registrado");
            return null;
       } 
    }

    @Override
    public boolean modificarUsuario(Usuario u) throws RemoteException 
    {
        System.out.println("Modificando usuario");

        int resultado;
        if(u.GetAdmin()){
            resultado = validacionesRegistroAdmin(u);
        }else{
            resultado = validacionesRegistroUsuario(u);
        }
        
        if(resultado == 0){
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

    /*Funcion para obtener todos los usuarios que estan conectados en el sistema. 
    * En el listado no se incluye el usuario que realiza la invocacion
    * @param login del usuario que invoca este metodo
    * @return Lista con los login de usuarios registrados*/
    @Override
    public ArrayList<String> listarUsuariosConectados(String login) throws RemoteException
    {
        System.out.println("Consultado usuarios activos ...");
        ArrayList<String> listaUsuariosAct= new ArrayList();
        for(UsuarioActivo objUsuario: listadoUsuariosActivos)
        {
            if(!objUsuario.getLogin().equals(login) && objUsuario.isDisponible()){
                listaUsuariosAct.add(objUsuario.getLogin());   
            }
        }
        return listaUsuariosAct;
    }
    
    @Override
    public ArrayList<Usuario> listarUsuariosRegistrados() throws RemoteException {
        ArrayList<Usuario> usuariosRegistrados = Archivos.listarArchivosDirectorio();
        return usuariosRegistrados;
    }

    @Override
    public boolean salir(String login) throws RemoteException {
        
        System.out.println("Usuario "+login+" ha cerrado sesion");
        return true;
    }

    @Override
    public synchronized boolean registrarReferenciaRemota(String login, UsuarioCallBackInt objRemoto) throws RemoteException {
        System.out.println("Registrando referencia remota ...");
        boolean bandera=false;
        UsuarioActivo nuevoUsuario= new UsuarioActivo(login, objRemoto, true);
        bandera=listadoUsuariosActivos.add(nuevoUsuario);
        return bandera;
<<<<<<< HEAD
    }

    @Override
    public boolean EnviarInvitacion(String loginOrigen, String loginDestino, String mensaje, int numeroFichas) throws RemoteException {
        System.out.println("Enviando mensaje ...");
        boolean bandera=false;
        
        if(loginDestino.equals("")){
            String aux = buscandoPar(loginOrigen);
            if(aux != null){
                loginDestino = aux;
            }
        }
        UsuarioCallBackInt objUsuarioRemoto = null;
        for(UsuarioActivo objUsuario: listadoUsuariosActivos)
        {
            if (objUsuario.getLogin().equals(loginDestino) && objUsuario.getLoginPar().equals(loginOrigen)){
                objUsuarioRemoto=objUsuario.getObjRemotoUsuario();
                break;
            }
        }
        
        if (objUsuarioRemoto!=null)
        {
            objUsuarioRemoto.enviarInvitacion(loginOrigen, mensaje, numeroFichas);
            bandera=true;
        }
        return bandera;
    }
    
    public String buscandoPar(String login){
        System.out.println("Buscando par");
        for(UsuarioActivo objUsuario: listadoUsuariosActivos)
        {
            if(objUsuario.getLogin().equals(login)){
                System.out.println("El par es "+objUsuario.getLoginPar());
                return objUsuario.getLoginPar();
            }
        }
        return null;
    }

    @Override
    public boolean establecerComunicacion(String loginOrigen, String loginDestino) throws RemoteException {
        System.out.println("Sesion establecida para los dos usuarios");
        boolean bandera = false;
        int contador = 0;
        int tam = listadoUsuariosActivos.size();
        int i;
        for (i = 0; i < tam; i++) {
            if(listadoUsuariosActivos.get(i).getLogin().equals(loginOrigen)){
                listadoUsuariosActivos.get(i).setLoginPar(loginDestino);
                listadoUsuariosActivos.get(i).setDisponible(false);
                contador++;
            }
            if(listadoUsuariosActivos.get(i).getLogin().equals(loginDestino)){
                listadoUsuariosActivos.get(i).setLoginPar(loginOrigen);
                listadoUsuariosActivos.get(i).setDisponible(false);
                contador++;
            }
        }
        
        if(contador == 2){
            bandera = true;
        }
        return bandera;
    }

    @Override
    public boolean enviarRespuestaInvitacion(String loginOrigen, String loginDestino, boolean respuesta) throws RemoteException {
        System.out.println("Enviando mensaje de Respuesta a solicitud de ..."+loginDestino);
        boolean bandera=false;
        
        UsuarioCallBackInt objUsuarioRemoto = null;
        for(UsuarioActivo objUsuario: listadoUsuariosActivos)
        {
            if (objUsuario.getLogin().equals(loginDestino) && objUsuario.getLoginPar().equals(loginOrigen)){
                objUsuarioRemoto = objUsuario.getObjRemotoUsuario();
                break;
            }
        }
        
        if (objUsuarioRemoto!=null)
        {
            objUsuarioRemoto.enviarRespuestaInvitacion(loginOrigen, respuesta);
            bandera=true;
        }
        return bandera;       
    }
    
    @Override
    public boolean iniciarJuego(int numFichas, String LoginOrigeen, String LoginDestino) throws RemoteException {
        objJugar.repartirFichas(numFichas);
        FichasUsuario1 = objJugar.getFichasJugador1();
        FichasUsuario2 = objJugar.getFichasJugador2();
        UsuarioCallBackInt objUsuario1Remoto = null;
        UsuarioCallBackInt objUsuario2Remoto = null;
        boolean bandera = false; 
        for (int i = 0; i < listadoUsuariosActivos.size(); i++) {
            if(listadoUsuariosActivos.get(i).getLogin().equals(LoginOrigeen)){
                objUsuario1Remoto = listadoUsuariosActivos.get(i).getObjRemotoUsuario();
            }else{
                if(listadoUsuariosActivos.get(i).getLogin().equals(LoginDestino)){
                    objUsuario2Remoto = listadoUsuariosActivos.get(i).getObjRemotoUsuario();
                }
            }
        }
        if (objUsuario1Remoto!=null){
            objUsuario1Remoto.iniciarJuego(FichasUsuario1);
            if (objUsuario2Remoto!=null){
                objUsuario2Remoto.iniciarJuego(FichasUsuario2);
                bandera=true;
            }
        } 
        
=======
    }

    @Override
    public boolean EnviarInvitacion(String loginOrigen, String loginDestino, String mensaje, int numeroFichas) throws RemoteException {
        System.out.println("Enviando mensaje ...");
        boolean bandera=false;
        
        if(loginDestino.equals("")){
            String aux = buscandoPar(loginOrigen);
            if(aux != null){
                loginDestino = aux;
            }
        }
        UsuarioCallBackInt objUsuarioRemoto = null;
        for(UsuarioActivo objUsuario: listadoUsuariosActivos)
        {
            if (objUsuario.getLogin().equals(loginDestino) && objUsuario.getLoginPar().equals(loginOrigen)){
                objUsuarioRemoto=objUsuario.getObjRemotoUsuario();
                break;
            }
        }
        
        if (objUsuarioRemoto!=null)
        {
            objUsuarioRemoto.enviarInvitacion(loginOrigen, mensaje, numeroFichas);
            bandera=true;
        }
        return bandera;
    }
    
    public String buscandoPar(String login){
        System.out.println("Buscando par");
        for(UsuarioActivo objUsuario: listadoUsuariosActivos)
        {
            if(objUsuario.getLogin().equals(login)){
                System.out.println("El par es "+objUsuario.getLoginPar());
                return objUsuario.getLoginPar();
            }
        }
        return null;
    }

    @Override
    public boolean establecerComunicacion(String loginOrigen, String loginDestino) throws RemoteException {
        System.out.println("Sesion establecida para los dos usuarios");
        boolean bandera = false;
        int contador = 0;
        int tam = listadoUsuariosActivos.size();
        int i;
        for (i = 0; i < tam; i++) {
            if(listadoUsuariosActivos.get(i).getLogin().equals(loginOrigen)){
                listadoUsuariosActivos.get(i).setLoginPar(loginDestino);
                listadoUsuariosActivos.get(i).setDisponible(false);
                contador++;
            }
            if(listadoUsuariosActivos.get(i).getLogin().equals(loginDestino)){
                listadoUsuariosActivos.get(i).setLoginPar(loginOrigen);
                listadoUsuariosActivos.get(i).setDisponible(false);
                contador++;
            }
        }
        
        if(contador == 2){
            bandera = true;
        }
>>>>>>> origin/master
        return bandera;
    }

    @Override
<<<<<<< HEAD
    public boolean enviarMensaje(String loginOrigen, String loginDestino, String mensaje) throws RemoteException {
        System.out.println("Enviando mensaje ...");
        boolean bandera=false;
        
        if(loginDestino.equals("")){
            String aux = buscandoPar(loginOrigen);
            if(aux != null){
                loginDestino = aux;
            }
        }
=======
    public boolean enviarRespuestaInvitacion(String loginOrigen, String loginDestino, boolean respuesta) throws RemoteException {
        System.out.println("Enviando mensaje ...");
        boolean bandera=false;
        
>>>>>>> origin/master
        UsuarioCallBackInt objUsuarioRemoto = null;
        for(UsuarioActivo objUsuario: listadoUsuariosActivos)
        {
            if (objUsuario.getLogin().equals(loginDestino) && objUsuario.getLoginPar().equals(loginOrigen)){
<<<<<<< HEAD
                objUsuarioRemoto = objUsuario.getObjRemotoUsuario();
=======
                objUsuarioRemoto=objUsuario.getObjRemotoUsuario();
>>>>>>> origin/master
                break;
            }
        }
        
<<<<<<< HEAD
        if (objUsuarioRemoto!=null){
            objUsuarioRemoto.enviarMensaje(loginOrigen, mensaje);
            bandera=true;
        }
        return bandera;
    }
     
=======
        if (objUsuarioRemoto!=null)
        {
            objUsuarioRemoto.enviarRespuestaInvitacion(loginOrigen, respuesta);
            bandera=true;
        }
        return bandera;       
    }
>>>>>>> origin/master
    
}
