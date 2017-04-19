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
    private int estadoPartida;
    /*TRUE si es el turno del jugador1
    * FALSE si es del jugador2  */
    private boolean turno;
    private int contarJugadasPasadas;
    
    public JugarImpl() throws RemoteException
    {
        super(); //invoca al constructor de la clase base
        /*Cargamos todas las fichas del domino*/
        cargarTodasLasFichas();
        this.estadoPartida = 0;
    }

    @Override
    public void seleccionarJugador(String login1,String login2) throws RemoteException {
        this.jugador1.setLogin(login1);
        this.jugador2.setLogin(login2);
    }

    @Override
    public void empezarPartida() throws RemoteException {
        /*Buscamos quien tiene la ficha 6|6*/
        this.estadoPartida = 1;
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
    private void enviarFichasAJugadores(){
        jugador1.recibirFichas(this.fichasJugador1);
        jugador2.recibirFichas(this.fichasJugador2);
    }
    
    /*Imprime las fichas repartidas a los jugadores*/
    private void imprimirFichas(){
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
                Ficha ficha = new Ficha(id,i,j,false);
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
    private int quienInicia(){
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
        return tablero;
    }

    @Override
    public boolean enviarJugada(String jugador, Ficha ficha) throws RemoteException {
        //TODO Notificar al jugador que no es su turno
        if(turnoValido(jugador)){
            /*Comprobamos las condiciones del juego para saber si se pude seguir jugando
            * si ya hay un ganador o no*/
            
            if(ficha == null){
                //TODO debo notificarle al usuario que su oponente paso
                if(turno){
                    System.out.println("EL jugador 1 pasa");
                }else{
                    System.out.println("El jugador 2 pasa");
                }
                //Cambiamos el turno
                this.contarJugadasPasadas++;
                turno = !turno;
                return true;
            }else{
                if(contarJugadasPasadas != 0){
                    this.contarJugadasPasadas--;
                }
                /*Comprobamos que la ficha se puede jugar*/
                if(sePuedeJugar(ficha)){
                    /*Colocamos la ficha en el lado donde coincida*/
                    if(colocarFicha(ficha)){
                        System.out.println("La ficha ha sido colocada");
                        if(turno){
                            int posicionFicha = jugador1.getMisFichas().indexOf(ficha);
                            //marcamos la ficha como ocupada
                            jugador1.getMisFichas().get(posicionFicha).setEstado(true);
                            jugador1.setFichasRestantes(jugador1.getFichasRestantes()-1);
                            
                        }else{
                            int posicionFicha = jugador2.getMisFichas().indexOf(ficha);
                            //marcamos la ficha como ocupada
                            jugador2.setFichasRestantes(jugador2.getFichasRestantes()-1);
                            jugador2.getMisFichas().get(posicionFicha).setEstado(true);
                        }
                        //Cambiamos el turno
                        turno = !turno;
                        return true;
                    }else{
                        System.out.println("La ficha no ha podido ser colocada");
                    }
                }else{
                    //TODO notificar al jugador que su ficha es invalida
                    System.out.println("Ficha Invalida. No se puede colocar en los extremos");
                }
            }
        }
        return false;
    }
    
    private int condicionesPartida(){
        
        int condicion = 0;
        /*Cuando ambos jugadores no tienen fichas para jugar*/
        if(contarJugadasPasadas == 2){
            System.out.println("Ambos jugadores no puede seguir. Se ha terminado el juego");
            System.out.println("Haciendo conteo de puntos");
            int conteoJugador1 = contarPuntos(jugador1);
            int conteoJugador2 = contarPuntos(jugador2);
            System.out.println("Jugador "+jugador1.getLogin()+" tiene "+conteoJugador1+" puntos");
            System.out.println("Jugador "+jugador2.getLogin()+" tiene "+conteoJugador2+" puntos");
            if(conteoJugador1 == conteoJugador2){
                System.out.println("Hay empate!");
            }else{
                if(conteoJugador1 < conteoJugador2){
                    System.out.println("El jugador "+jugador1.getLogin()+" gana la partida");
                    condicion = 3;
                }else{
                    System.out.println("El jugador "+jugador2.getLogin()+" gana la partida");
                    condicion = 4;
                }
            }
        }
        
        if(jugador1.getFichasRestantes() == 0){
            System.out.println("El jugador "+jugador1.getLogin()+"  ha jugado todas sus fichas");
            condicion = 1;
        }
        if(jugador2.getFichasRestantes() == 0){
            System.out.println("El jugador "+jugador2.getLogin()+" ha jugado todas sus fichas");
            condicion = 2;
        }
            
        return condicion;
    }
    
    
    /*comprobar que sea el turno del usuario
    * @param login del usuario que quiere hacer la jugada
    * @return true si es su turno, de lo contrario false*/
    private boolean turnoValido(String login){
        if(turno){
            /*El jugador 2 esta realizando una jugada cuando es
            * el turno del jugador 1*/
            if(jugador1.getLogin().compareTo(login) != 0){
                String mensaje = "Es turno del jugador 1";
                System.out.println(mensaje);
                return false;
            }
        }else{
            /*El jugador 1 esta realizando una jugada cuando es
            * el turno del jugador 2*/
            if(jugador2.getLogin().compareTo(login) != 0){
                String mensaje = "Es turno del jugador 2";
                System.out.println(mensaje);
                return false;
            }
        }
        return true;
    }
    
    /*Metodo para comprobar si la ficha enviada por el jugador coincide en alguno 
      de sus lados con los extremos del tablero */
    private boolean sePuedeJugar(Ficha ficha){
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
    private boolean colocarFicha(Ficha ficha){
        boolean respuesta = false;
        if(tablero.getExtremoIzq() == ficha.getLado1()){
            //Establecemos el lado, que coincide con el extremo, como ocupado
            ficha.setEstadoLado1(true);
            tablero.getFichasJugadas().add(0, ficha);
            //Lado libre es el nuevo extremo izquierdo
            tablero.setExtremoIzq(ficha.getLado2());
            respuesta = true;
        }
        if(tablero.getExtremoIzq() == ficha.getLado2()){
            //Establecemos el lado, que coincide con el extremo, como ocupado
            ficha.setEstadoLado2(true);
            tablero.getFichasJugadas().add(0, ficha);
            //Lado libre es el nuevo extremo izquierdo
            tablero.setExtremoIzq(ficha.getLado1());
            respuesta = true;
        }
        if(tablero.getExtremoDer() == ficha.getLado1()){
            //Establecemos el lado, que coincide con el extremo, como ocupado
            ficha.setEstadoLado1(true);
            tablero.getFichasJugadas().add(ficha);
            //Lado libre es el nuevo extremo derecho
            tablero.setExtremoDer(ficha.getLado2());
            respuesta = true;
        }
        if(tablero.getExtremoDer() == ficha.getLado2()){
            //Establecemos el lado, que coincide con el extremo, como ocupado
            ficha.setEstadoLado2(true);
            tablero.getFichasJugadas().add(ficha);
            //Lado libre es el nuevo extremo derecho
            tablero.setExtremoDer(ficha.getLado1());
            respuesta = true;
        }
        return respuesta;
    }
    
    /*Hace conteo de las fichas que no han sido utilizadas por el jugador*/
    private int contarPuntos(Jugador jugador){
        int i;
        int conteo = 0;
        int tam = jugador.getMisFichas().size();
        for (i = 0; i < tam; i++) {
            if(jugador.getMisFichas().get(i).isEstado() == false){
                conteo = jugador.getMisFichas().get(i).getLado1() + 
                        jugador.getMisFichas().get(i).getLado2();
            }
        }
        return conteo;
    }
    
    
}
