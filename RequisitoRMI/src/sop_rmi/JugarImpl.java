package sop_rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Santiago Garcia
 */
public class JugarImpl extends UnicastRemoteObject implements JugarInt{

    private ArrayList<Ficha> fichasJugador1;
    private ArrayList<Ficha> fichasJugador2;
    private Jugador jugador1;
    private Jugador jugador2;
    private ArrayList<Ficha> fichasTotal;
    private Tablero tablero;
    private int estado;
    /*TRUE si es el turno del jugador1
    * FALSE si es del jugador2  */
    private boolean turno;
    
    public JugarImpl() throws RemoteException
    {
        super(); //invoca al constructor de la clase base
        /*Cargamos todas las fichas del domino*/
        cargarTodasLasFichas();
        this.estado = 0;
    }

    @Override
    public void seleccionarJugador(String login1,String login2) throws RemoteException {
        this.jugador1.setLogin(login1);
        this.jugador2.setLogin(login2);
    }

    @Override
    public void empezarPartida() throws RemoteException {
        /*Buscamos quien tiene la ficha 6|6*/
        System.out.println("EMPEZO LA PARTIDA");
        int quienInicia = quienInicia();
        if(quienInicia == 0){
            System.out.println("La ficha no ha sido repartida a ninguno de los jugadores");
        }else{
            if(quienInicia == 1){
                System.out.println("Inicia el jugador 1");
                turno = true;
            }else{
                System.out.println("Inicia el jugador 2");
                turno = false;
            }
        }
        
    }

    /* Funcion que me reparte las fichas al azar entre los dos jugadores de 
    *  la partida
    *  @param numero de fichas a jugar
    *  @return 
    */
    @Override
    public void repartirFichas(int tamano) throws RemoteException {
        System.out.println("Se estan repartiendo las fichas entre los jugadores");
        ArrayList<Integer> fichasValidas = seleccionarFichas(tamano);
        ArrayList<Integer> fichasSalidas = new ArrayList<Integer>();
        boolean turno = false;
        int contador = 0, aleatorio;
        Random rnd = new Random();
        while(contador < tamano){
            aleatorio = (int) (rnd.nextDouble() * tamano + 0);
            if(!fichasSalidas.contains( fichasValidas.get(aleatorio) )){
                fichasSalidas.add(aleatorio);
                if(turno){
                    fichasJugador1.add(fichasTotal.get(aleatorio));
                    turno = false;
                }else{
                    fichasJugador2.add(fichasTotal.get(aleatorio));
                    turno = true;
                }
                contador++;
            }
        }
        enviarFichasAJugadores();
        System.out.println("Fichas repartidas");
        imprimirFichas();
    }
    
    /*Envia la lista de fichas repartidas a cada jugador*/
    public void enviarFichasAJugadores(){
        jugador1.recibirFichas(this.fichasJugador1);
        jugador2.recibirFichas(this.fichasJugador2);
    }
    
    /*Imprime las fichas repartidas a los jugadores*/
    public void imprimirFichas(){
        int j,i;
        for ( j = 0; j < 2; j++) {
            System.out.println("Jugador "+(j+1)+":");
            int tam = fichasJugador1.size();
            for (i = 0; i < tam; i++) {
                System.out.println("["+fichasJugador1.get(i).getLado1()+"|"+fichasJugador2.get(i).getLado2()+" ]");
            }
            System.out.println();
        }
        
    }
    
    /*Carga todas las fichas del juego de domino en un array */
    private void cargarTodasLasFichas()throws RemoteException{
        int i = 0, j = 0;
        int id = 0;
	for(i=0; i<7; i++){
            for(j=i; j<7; j++){
                Ficha ficha = new Ficha(id,i,j,0);
                fichasTotal.add(ficha);
                id++;
            }
        }
    }
    
    /*Funcion para escoger al azar las fichas que se van a repartir.
    * Las selecciona de todas las fichas del domino
    * @param numero de fichas a jugar*/
    private ArrayList<Integer> seleccionarFichas(int tamano){
        int contador = 0;
        int aleatorio;
        ArrayList<Integer> fichasSeleccionadas = new ArrayList<Integer>();
        //Agregamos obligatoriamente la ficha 6|6
        fichasSeleccionadas.add(27);
        Random rnd = new Random();
        while(contador < tamano){
            aleatorio = (int) (rnd.nextDouble() * 28 + 0);
            if(!fichasSeleccionadas.contains(aleatorio)){
                fichasSeleccionadas.add(aleatorio);
            }
            contador++;
        }
        return fichasSeleccionadas;
    }
    
    /*Buscamos a cual de los jugadores le salio la fichas 6|6
    * @return 1 si el jugador 1 tiene la ficha
    *         2 si el jugador 2 tiene la ficha
    *         3 si nadie tiene la ficha                    */
    public int quienInicia(){
        int tam;
        tam = fichasJugador1.size();
        int i;
        for (i = 0; i < tam; i++) {
            if(fichasJugador1.get(i).getId() == 27){
                System.out.println("Inicia el jugador 1");
                return 1;
            }
            if(fichasJugador2.get(i).getId() == 27){
                System.out.println("Inicia el jugador 2");
                return 2;
            }
        }
        return 0;
    }

    @Override
    public Tablero estadoTablero() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean enviarJugada(String jugador, Ficha ficha) throws RemoteException {
        //TODO Notificar al jugador que no es su turno
        if(turno){
            /*El jugador 2 esta realizando una jugada cuando es
            * el turno del jugador 1*/
            if(jugador1.getLogin().compareTo(jugador) != 0){
                String mensaje = "Es turno del jugador 1";
                System.out.println(mensaje);
                return false;
            }
        }else{
            /*El jugador 1 esta realizando una jugada cuando es
            * el turno del jugador 2*/
            if(jugador2.getLogin().compareTo(jugador) != 0){
                String mensaje = "Es turno del jugador 2";
                System.out.println(mensaje);
                return false;
            }
        }
        if(ficha != null){
            //TODO debo notificarle al usuario que su oponente paso
            if(turno){
                System.out.println("EL jugador 1 pasa");
            }else{
                System.out.println("El jugador 2 pasa");
            }
            return true;
        }else{
            /*Comprobamos que la ficha se puede jugar*/
            if(sePuedeJugar(ficha)){
                if(colocarFicha(ficha)){
                
                }else{
                
                }
            }else{
                //TODO notificar al jugador que su ficha es invalida
                System.out.println("Ficha Invalida. No se puede colocar en los extremos");
            }
        }
        return true;
    }
    
    /*Metodo para comprobar si la ficha enviada por el jugador coincide en alguno 
      de sus lados con los extremos del tablero */
    public boolean sePuedeJugar(Ficha ficha){
        if(tablero.getFichasJugadas().size() == 0){
            if(ficha.getId() == 27){
                return true;
            }else{
                return false;
            }
        }else{
            if(ficha.getLado1() == tablero.getExtremoDer() || ficha.getLado1() == tablero.getExtremoIzq()
                || ficha.getLado2() == tablero.getExtremoDer() || ficha.getLado2() == tablero.getExtremoIzq()){
                return true;
            }else{
                return false;
            }
        }
        
    }
    public boolean colocarFicha(Ficha ficha){
        if(tablero.getExtremoIzq() == ficha.getLado1()){
        
        }
        if(tablero.getExtremoIzq() == ficha.getLado2()){
        
        }
        if(tablero.getExtremoDer() == ficha.getLado1()){
        
        }
        if(tablero.getExtremoDer() == ficha.getLado2()){
        
        }
        return true;
    }
    
    
}
