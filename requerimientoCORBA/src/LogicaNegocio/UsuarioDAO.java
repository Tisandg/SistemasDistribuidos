
package LogicaNegocio;

import sop_corba.Usuario;
import Datos.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lenovo!
 */
public class UsuarioDAO {
    
    public boolean registrarUsuario(Usuario usuario) 
    {
        ConexionBD conex= new ConexionBD();
        int valor=conex.conectar();
        System.out.println("valor cone:" + valor);
        int resultado=-1;
        try {            
            PreparedStatement sentencia = null;
            String consulta = "insert into usuario(usuario.nombresUsuario,usuario.apellidosUsuario,usuario.loginUsuario,usuario.claveUsuario,usuario.imagenUsuario,usuario.privilegiosUsuario) values(?,?,?,?,?,?)";
            sentencia = conex.getConnection().prepareStatement(consulta);
            sentencia.setString(1, usuario.getNombresUsuario());
            sentencia.setString(2, usuario.getApellidosUsuario());
            sentencia.setString(3, usuario.getLoginUsuario());
            sentencia.setString(4, usuario.getClaveUsuario());
            sentencia.setString(5, usuario.getImagenUsuario());
            sentencia.setBoolean(6, usuario.isPrivilegiosUsuario());
            resultado = sentencia.executeUpdate(); 
            sentencia.close();
            conex.desconectar();

        } catch (SQLException e) {
                  System.out.println("error en la inserción: "+e.getMessage());         
        }
        
        if (resultado!=1)        
            return false;        
        else
            return true;
    }
    
    
    public ArrayList<Usuario> consultarUsuarios()
    {
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        ConexionBD conex= new ConexionBD();
        conex.conectar();
        try {            
            PreparedStatement sentencia = null;
            String consulta = "select * from usuario";
            sentencia = conex.getConnection().prepareStatement(consulta);            
            ResultSet res = sentencia.executeQuery();
            while(res.next()){
                Usuario objUsuario= new Usuario();
                objUsuario.setIdUsuario(res.getInt("idUsuario"));
                objUsuario.setNombresUsuario(res.getString("nombresUsuario"));
                objUsuario.setApellidosUsuario(res.getString("apellidosUsuario"));
                objUsuario.setLoginUsuario(res.getString("loginUsuario"));
                objUsuario.setClaveUsuario(res.getString("claveUsuario"));
                objUsuario.setImagenUsuario(res.getString("imagenUsuario"));
                objUsuario.setPrivilegiosUsuario(res.getBoolean("privilegiosUsuario"));
                usuarios.add(objUsuario);
            }
            sentencia.close();
            conex.desconectar();

        } catch (SQLException e) {
                  System.out.println("error en la inserción: "+e.getMessage());         
        }       
        return usuarios;
    }
    
    
    public Usuario consultarUsuario(String loginUsuario)
    {
        Usuario objUsuario = new Usuario();
        ConexionBD conex= new ConexionBD();
        conex.conectar();
        int resultado=-1;
        try {            
            PreparedStatement sentencia = null;
            String consulta = "select usuario.nombresUsuario, usuario.apellidosUsuario, usuario.loginUsuario, usuario.claveUsuario, usuario.imagenUsuario, usuario.privilegiosUsuario  from usuario where usuario.loginUsuario=?";
            sentencia = conex.getConnection().prepareStatement(consulta);            
            sentencia.setString(1, loginUsuario);
            ResultSet res = sentencia.executeQuery();
            while(res.next()){
                objUsuario = new Usuario();
                //objUsuario.setIdUsuario(res.getInt("idUsuario"));
                objUsuario.setNombresUsuario(res.getString("nombresUsuario"));
                objUsuario.setApellidosUsuario(res.getString("apellidosUsuario"));
                objUsuario.setLoginUsuario(res.getString("loginUsuario"));
                objUsuario.setClaveUsuario(res.getString("claveUsuario"));
                objUsuario.setImagenUsuario(res.getString("imagenUsuario"));
                objUsuario.setPrivilegiosUsuario(res.getBoolean("privilegiosUsuario"));
            }
            sentencia.close();
            conex.desconectar();

        } catch (SQLException e) {
                  System.out.println("error en la consulta de un empleado: "+e.getMessage());         
        }
        
        return objUsuario;
    }
    
    public boolean actualizarUsuario(Usuario objUsuario, String loginUsuario)
    {
        ConexionBD conex= new ConexionBD();
        conex.conectar();
        int resultado=-1;
        try {            
            PreparedStatement sentencia = null;
            String consulta = "update usuario set usuario.nombresUsuario=?,"
                                                 + "usuario.apellidosUsuario=?,"
                                                 + "usuario.claveUsuario=?,"
                                                 + "usuario.idUsuario=?"
                                                 + "usuario.imagenUsuario=?"
                                                 + "usuario.privilegiosUsuario=?"
                                                 + "where usuario.loginUsuario=?";
            sentencia = conex.getConnection().prepareStatement(consulta);
            sentencia.setString(1, objUsuario.getNombresUsuario());
            sentencia.setString(2, objUsuario.getApellidosUsuario());
            sentencia.setString(3, objUsuario.getClaveUsuario());
            sentencia.setInt(4, objUsuario.getIdUsuario());
            sentencia.setString(5, objUsuario.getImagenUsuario());
            sentencia.setBoolean(6, objUsuario.isPrivilegiosUsuario());
            sentencia.setString(7, loginUsuario);
            resultado = sentencia.executeUpdate(); 
            sentencia.close();
            conex.desconectar();

        } catch (SQLException e) {
                  System.out.println("error en la actualización: "+e.getMessage());         
        }
        
        if (resultado!=1)        
            return false;        
        else
            return true;
    }
    
    public boolean eliminarUsuario(String loginUsuario){
        ConexionBD conex= new ConexionBD();
        conex.conectar();
        int resultado=-1;
        try {            
            PreparedStatement sentencia = null;
            String consulta = "delete from usuario where usuario.loginUsuario=?";
            sentencia = conex.getConnection().prepareStatement(consulta);            
            sentencia.setString(1, loginUsuario);
            resultado = sentencia.executeUpdate(); 
            sentencia.close();
            conex.desconectar();

        } catch (SQLException e) {
                  System.out.println("error en la eliminación: "+e.getMessage());         
        }
        
        if (resultado!=1)        
            return false;        
        else
            return true;
    }
    
    public boolean ExisteUsuario(String loginUsuario){
        ConexionBD conex= new ConexionBD();
        conex.conectar();
        try {            
            PreparedStatement sentencia = null;
            String consulta = "select usuario.NombresUsuario, usuario.ApellidosUsuario, usuario.loginUsuario from usuario where usuario.loginUsuario=?";
            sentencia = conex.getConnection().prepareStatement(consulta);            
            sentencia.setString(1, loginUsuario);
            ResultSet res = sentencia.executeQuery();
            while(res.next()){
                if(res.getString("loginUsuario").equals(""))
                    return false;
                else
                    return true;
            }
            sentencia.close();
            conex.desconectar();

        } catch (SQLException e) {
                  System.out.println("error en la consulta de un empleado: "+e.getMessage());         
        }       
        return false;
        
    }
    
    public boolean IngresoSistema(String login, String clave){
        ConexionBD conex= new ConexionBD();
        conex.conectar();
        try {
            PreparedStatement sentencia = null;
            String consulta = "select * from usuario where usuario.loginUsuario=? and usuario.claveUsuario=?";
            sentencia = conex.getConnection().prepareStatement(consulta);            
            sentencia.setString(1, login);
            sentencia.setString(2, clave);
            ResultSet res = sentencia.executeQuery();
            
            while(res.next()){
                if(res.getString("loginUsuario").equals(""))
                    return false;
                else
                    return true;
            }
            sentencia.close();
            conex.desconectar();
            
        } catch (Exception e) {
            
        }
        
        return false;
    }
    
    public boolean suscribirse(String login){
        ConexionBD conex= new ConexionBD();
        int valor=conex.conectar();
        System.out.println("valor cone:" + valor);
        int resultado=-1;
        try {            
            PreparedStatement sentencia = null;
            String consulta = "insert into suscrito (suscrito.login) VALUES (?)";
            sentencia = conex.getConnection().prepareStatement(consulta);
            sentencia.setString(1, login);
            resultado = sentencia.executeUpdate(); 
            sentencia.close();
            conex.desconectar();

        } catch (SQLException e) {
                  System.out.println("error en la inserción: "+e.getMessage());         
        }
        
        if (resultado!=1)        
            return false;        
        else
            return true;
    }
    
    public boolean EliminarSuscripcion(String login){
        ConexionBD conex= new ConexionBD();
        conex.conectar();
        int resultado=-1;
        try {            
            PreparedStatement sentencia = null;
            String consulta = "delete from suscrito where suscrito.login=?";
            sentencia = conex.getConnection().prepareStatement(consulta);            
            sentencia.setString(1, login);
            resultado = sentencia.executeUpdate(); 
            sentencia.close();
            conex.desconectar();

        } catch (SQLException e) {
                  System.out.println("error en la eliminación: "+e.getMessage());         
        }
        
        if (resultado!=1)        
            return false;        
        else
            return true;
    }
    
    public ArrayList<String> obtenerSuscritos(){
        ArrayList<String> suscritos = new ArrayList<>();
        ConexionBD conex= new ConexionBD();
        conex.conectar();
        try {            
            PreparedStatement sentencia = null;
            String consulta = "select * from suscrito";
            sentencia = conex.getConnection().prepareStatement(consulta);            
            ResultSet res = sentencia.executeQuery();
            while(res.next()){                
                suscritos.add(res.getString("login"));
            }
            sentencia.close();
            conex.desconectar();

        } catch (SQLException e) {
                  System.out.println("error en la inserción: "+e.getMessage());         
        }       
        return suscritos;      
    }
    
    
}
