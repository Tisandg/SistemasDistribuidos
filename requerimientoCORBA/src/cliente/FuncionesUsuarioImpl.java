/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import LogicaNegocio.UsuarioDAO;
import sop_corba.Interfaz_UsuarioOperations;
import sop_corba.Usuario;
import servidor.FuncionesAdministradorImpl;
/**
 *
 * @author Kevin Chantré
 */
public class FuncionesUsuarioImpl implements Interfaz_UsuarioOperations{

    private UsuarioDAO objUsuariosDAO;
    private FuncionesAdministradorImpl objFucncionesAdministrador;
    
    public FuncionesUsuarioImpl(){
        
    }    
    
    @Override
    public boolean ingresoSistemaUsuario(String login, String clave) {
        System.out.println("Servidor : Ingreso sistema Usuario.....");
        return objUsuariosDAO.IngresoSistema(login, clave, false);
    }

    @Override
    public boolean actualizarInformacion(Usuario objUsuario) {
        System.out.println("Servidor : Actualizar Informacion de Usuario....");
        return objUsuariosDAO.actualizarUsuario(objUsuario, objUsuario.getLoginUsuario());
    }

    @Override
    public boolean suscribirse(String login, String clave) {
        System.out.println("Servidor : Suscribirse ...");
        
    }

    @Override
    public boolean eliminarSuscripcion(String login, String clave) {
        System.out.println("Servidor: Eliminar Suscripcion.....");
        return false;
    }

    @Override
    public boolean notificacionAudio(String mensaje) {
        System.out.println("Servidor: notificarAudio......");
        return false;
    }
    
}
