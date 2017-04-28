package sop_rmi;

/**
 * @author Santiago Garica
 */
public class datosEstadisticas {
    
    /*Login del jugador*/
    private String login;
    /*Contador de veces que aparece*/
    private int contador;

    public datosEstadisticas(String login, int contador){
        this.login = login;
        this.contador = contador;
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
    
    
    
}
