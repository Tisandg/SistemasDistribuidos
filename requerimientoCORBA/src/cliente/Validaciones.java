package cliente;

/**
 * @author Santiago Garcia Ch
 */

public class Validaciones {
    
    private InterfazDatosUsuario interfaz;
    
    public Validaciones(InterfazDatosUsuario crear){
        this.interfaz = crear;
    }

    public boolean camposValidos(String nombres, String apellidos, String login, String clave){
        boolean respuesta = false;
        
        if(camposVacios(nombres,apellidos,login,clave) == false){
            /*No hay  campos vacios, comprobamos el tamano de los valores*/
            if(tamanoCampos(nombres,apellidos,login,clave)){
                respuesta = true;
            }
        }
        return respuesta;
    }
    
    public boolean camposVacios(String nombres, String apellidos, String login, String clave){
        
        System.out.println("Comprobando campos vacios");
        
        boolean respuesta = false;
        if(nombres.equals("")){
            interfaz.modificarMensajeNombres(true, "Este campo es requerido");
            respuesta = true;
        }

        if(apellidos.equals("")){
            interfaz.modificarMensajeApellidos(true, "Este campo es requerido");
            respuesta = true;
        }
        
        if(clave.equals("")){
            interfaz.modificarMensajeClave(true, "Este campo es requerido");
            respuesta = true;
        }
        
        if(login.equals("")){
            interfaz.modificarMensajeLogin(true, "Este campo es requerido");
            respuesta = true;
        }
        if(respuesta){
            System.out.println("Hay campos vacios");
        }
        return respuesta;
    }
    
    public boolean tamanoCampos(String nombres, String apellidos, String login, String clave){
        
        System.out.println("Comprobando campos validos");
        
        boolean respuesta = true;
        if(login.length()<8 || login.length() > 15){
            respuesta = false;
            interfaz.modificarMensajeLogin(true, "Minimo 8 y maximo 15 caracteres");
        }

        if(clave.length()<8 || clave.length() > 15){
            respuesta = false;
            interfaz.modificarMensajeClave(true, "Minimo 8 y maximo 15 caracteres");
        }
        
        if(nombres.length() > 30){
            respuesta = false;
            interfaz.modificarMensajeNombres(true, "Maximo 30 caracteres");
        }
        
        if(apellidos.length() > 20){
            respuesta = false;
            interfaz.modificarMensajeApellidos(true, "Maximo 20 caracteres");
        }
        
        if(respuesta){
            System.out.println("Los campos son validos");
        }else{
            System.out.println("Los campos ingresados no son validos");
        }
        return respuesta;
    }
    
}
