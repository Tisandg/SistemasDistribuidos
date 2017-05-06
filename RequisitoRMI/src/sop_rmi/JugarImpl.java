package sop_rmi;

import cliente.CallBackJuegoImpl;
import cliente.CallBackJuegoInt;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Random;
import cliente.CallBackJuegoInt;
import cliente.Fichas_Tablero;
        
/**
 * @author Kevin Chantré
 */
public class JugarImpl extends UnicastRemoteObject implements JugarInt{

    private ArrayList<Ficha> fichasJugador1 ;
    private ArrayList<Ficha> fichasJugador2;
    private ArrayList<Ficha> fichasTotal = new ArrayList<>();
    private Jugador jugador1 = new Jugador();
    private Jugador jugador2 = new Jugador();;
    private Tablero tablero = new Tablero();
    private boolean estadoPartida = false;
    private ArrayList<TableroActivo> ListaTablerosActivos;
    
    /*Para saber si los jugadores de esta partida ya han sido seleccionados*/
    private boolean seleccionadosJugadores;
    
    /*TRUE si es el turno del jugador1
    * FALSE si es del jugador2  */
    private boolean turno;
    
    /*Contador para saber si ambos pasan*/
    private int contarJugadasPasadas;
    
    public JugarImpl() throws RemoteException
    {
        super(); //invoca al constructor de la clase base
        /*Cargamos todas las fichas del domino*/
        cargarTodasLasFichas();
        this.estadoPartida = false;
        this.seleccionadosJugadores = false;
        this.fichasJugador1 = new ArrayList<>();
        this.fichasJugador2 = new ArrayList<>();
        this.ListaTablerosActivos = new ArrayList<>();
    }

    @Override
    public boolean seleccionarJugador(Usuario usuarioQueInvita, Usuario usuarioAInvitar) throws RemoteException 
    {
        /*Comprobamos si el jugador a invitar no este en una partida*/
        if(usuarioAInvitar.GetJugando() == false){
            boolean respuesta = usuarioAInvitar.invitacionPartida(usuarioQueInvita.getLogin());
            if(respuesta){
                System.out.println("El jugador "+usuarioAInvitar.getLogin()+" ha aceptado la partida");
                /*Se establece la partida y los jugadores*/
                this.jugador1 = (Jugador) usuarioQueInvita;
                this.jugador2 = (Jugador) usuarioAInvitar;
                System.out.println("Se han establecido los jugadores de una partida");
                System.out.println("    "+usuarioQueInvita.getLogin()+" Vs "+usuarioAInvitar.getLogin());
                /*Notificamos a los usuarios*/
                usuarioQueInvita.notificar("El jugador "+usuarioAInvitar.getLogin()+" ha aceptado la partida");
                
                usuarioQueInvita.notificar("Se ha establecido una partida");
                usuarioAInvitar.notificar("Se ha establecido una partida");
                this.seleccionadosJugadores = true;
            }else{
                System.out.println("El jugador "+usuarioAInvitar.getLogin()+" no ha aceptado la partida");
                usuarioQueInvita.notificar("El jugador "+usuarioAInvitar.getLogin()+"no ha aceptado la partida");
            }
        }else{
            System.out.println("El jugador esta ocupado en una partida");
            
        }
        return false;
    }

    @Override
    public void empezarPartida() throws RemoteException 
    {
        /*Buscamos quien tiene la ficha 6|6*/
        this.estadoPartida = true;
        System.out.println("EMPEZO LA PARTIDA");
        int quienInicia = quienInicia();
        if(quienInicia == 0){
            System.out.println("La ficha no ha sido repartida a ninguno de los jugadores");
        }else{
            if(quienInicia == 1){
                System.out.println("Inicia el jugador 1");
                /*Notificacion al jugador 1 para que inicie*/
                jugador1.notificar("Inicias la partida. Coloca la ficha con doble 6");
                turno = true;
            }else{
                System.out.println("Inicia el jugador 2");
                /*Notificacion al jugador 2 para que inicie*/
                jugador2.notificar("Inicias la partida. Coloca la ficha con doble 6");
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
        ArrayList<Integer> fichasValidas = new ArrayList<>();
        ArrayList<Integer> fichasSalidas = new ArrayList<>();
        fichasValidas = seleccionarFichas(tamano);
        boolean turno = false;
        int contador = 0, aleatorio = 0, salir = 0;
        Random rnd = new Random();
        while(contador <= fichasValidas.size() && salir < 2){
            aleatorio = (int) (rnd.nextDouble() * (tamano) + 0);
            if(!fichasSalidas.contains(fichasValidas.get(aleatorio))){
                fichasSalidas.add(fichasValidas.get(aleatorio));
                if(turno){
                    fichasJugador1.add(fichasTotal.get(fichasValidas.get(aleatorio)));
                    turno = false;
                }else{
                    fichasJugador2.add(fichasTotal.get(fichasValidas.get(aleatorio)));
                    turno = true;
                }
                contador++;
            }
            if(contador == fichasValidas.size()){
               salir++; 
            }              
        }
        //enviarFichasAJugadores();
        System.out.println("Fichas repartidas");
        imprimirFichas();
    }
    
    /*Envia la lista de fichas repartidas a cada jugador*/
    private void enviarFichasAJugadores(){
        jugador1.recibirFichas(this.fichasJugador1);
        jugador2.recibirFichas(this.fichasJugador2);
        System.out.println("Fichas enviadas");
    }
    
    /*Imprime las fichas repartidas a los jugadores*/
    private void imprimirFichas(){
        int j;
        for ( j = 0; j < fichasTotal.size(); j++) {
            System.out.println("id = " +fichasTotal.get(j).getId());
            System.out.println(" [ "+fichasTotal.get(j).getLado_A()+" | "+fichasTotal.get(j).getLado_B()+" ]");
            System.out.println("__________________________________________________________");
        }      
    }
    
    private void Imprimir_Numeros(ArrayList<Integer> Lista){
        System.out.println("_____________Fichas Validas__________________");
        for (int i = 0; i < Lista.size(); i++) {
            System.out.println("Numero = "+Lista.get(i));           
        }
        System.out.println("_________________________________________");
    }
    
    /*Carga todas las fichas del juego de domino en un array */
    private void cargarTodasLasFichas()throws RemoteException{
        int i = 0, j = 0;
        int id = 0;
	for(i=0; i<7; i++){
            for(j=i; j<7; j++){
                Ficha ficha = new Ficha(id,i,j);
                fichasTotal.add(ficha);
                id++;
            }
        }
        imprimirFichas();
    }
    
    /*Funcion para escoger al azar las fichas que se van a repartir.
    * Las selecciona de todas las fichas del domino
    * @param numero de fichas a jugar*/
    private ArrayList<Integer> seleccionarFichas(int tamano){
        int contador = 0;
        int aleatorio = 0;
        ArrayList<Integer> fichasSeleccionadas = new ArrayList<>();
        //Agregamos obligatoriamente la ficha 6|6
        fichasSeleccionadas.add(27);
        Random rnd = new Random();
        while(contador < (tamano-1)){
            aleatorio = (int) (rnd.nextDouble() * 26 + 0);
            if(!fichasSeleccionadas.contains(aleatorio)){
                fichasSeleccionadas.add(aleatorio);
                contador++;
            }           
        }
        Imprimir_Numeros(fichasSeleccionadas);
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
                            jugador1.getMisFichas().get(posicionFicha).setColocada(true);
                            jugador1.setFichasRestantes(jugador1.getFichasRestantes()-1);
                            
                        }else{
                            int posicionFicha = jugador2.getMisFichas().indexOf(ficha);
                            //marcamos la ficha como ocupada
                            jugador2.setFichasRestantes(jugador2.getFichasRestantes()-1);
                            jugador2.getMisFichas().get(posicionFicha).setColocada(true);
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
    
    @Override
    public int condicionesPartida()
    {
        
        int condicion = 0;
        /*Cuando ambos jugadores no tienen fichas para jugar*/
        if(contarJugadasPasadas == 2){
            System.out.println("Ambos jugadores no puede seguir. Se ha terminado el juego");
            System.out.println("Haciendo conteo de puntos");
            
            /*Notificamos a ambos jugadores*/
            notificar(3,"No se pueden tirar mas fichas.\nHaciendo conteo de puntos");
            
            int conteoJugador1 = contarPuntos(jugador1);
            int conteoJugador2 = contarPuntos(jugador2);
            
            System.out.println("Jugador "+jugador1.getLogin()+" tiene "+conteoJugador1+" puntos");
            System.out.println("Jugador "+jugador2.getLogin()+" tiene "+conteoJugador2+" puntos");
            
            notificar(3,"Jugador "+jugador1.getLogin()+" tiene "+conteoJugador1+" puntos");
            notificar(3,"Jugador "+jugador2.getLogin()+" tiene "+conteoJugador2+" puntos");
            
            if(conteoJugador1 == conteoJugador2){
                System.out.println("Hay empate!");
                notificar(3,"Hay un empate!");
            }else{
                if(conteoJugador1 < conteoJugador2){
                    System.out.println("El jugador "+jugador1.getLogin()+" gana la partida");
                    notificar(2,"Has perdido la partida");
                    notificar(1,"Has ganado la partida. Felicitaciones!");
                    condicion = 3;
                }else{
                    System.out.println("El jugador "+jugador2.getLogin()+" gana la partida");
                    notificar(1,"Has perdido la partida");
                    notificar(2,"Has ganado la partida. Felicitaciones!");
                    condicion = 4;
                }
            }
        }
        if(jugador1.getFichasRestantes() == 0){
            System.out.println("El jugador "+jugador1.getLogin()+"  ha jugado todas sus fichas");
            notificar(1,"Has ganado la partida. Felicitaciones!");
            notificar(2,"Has perdido la partida. Tu oponente a jugado todas sus fichas");
            condicion = 1;
        }
        if(jugador2.getFichasRestantes() == 0){
            System.out.println("El jugador "+jugador2.getLogin()+" ha jugado todas sus fichas");
            notificar(2,"Has ganado la partida. Felicitaciones!");
            notificar(1,"Has perdido la partida. Tu oponente a jugado todas sus fichas");
            condicion = 2;
        }
        if(condicion != 0){
            /*Se ha acabado la partida*/
            this.estadoPartida = false;
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
                jugador2.notificar("Es turno del jugador 1");
                System.out.println(mensaje);
                return false;
            }
        }else{
            /*El jugador 1 esta realizando una jugada cuando es
            * el turno del jugador 2*/
            if(jugador2.getLogin().compareTo(login) != 0){
                String mensaje = "Es turno del jugador 2";
                jugador1.notificar("Es turno del jugador 2");
                System.out.println(mensaje);
                return false;
            }
        }
        return true;
    }
    
    /*Metodo para comprobar si la ficha enviada por el jugador coincide en alguno 
      de sus lados con los extremos del tablero */
    private boolean sePuedeJugar(Ficha ficha){
        if(tablero.getTablero().isEmpty()){
            if(ficha.getId() == 27){
                return true;
            }else{
                return false;
            }
        }else{
            if(ficha.getLado_A() == tablero.getExtremoDer() || ficha.getLado_A() == tablero.getExtremoIzq()
                || ficha.getLado_B() == tablero.getExtremoDer() || ficha.getLado_B() == tablero.getExtremoIzq()){
                return true;
            }else{
                return false;
            }
        }
        
    }
    private boolean colocarFicha(Ficha ficha){
        boolean respuesta = false;
        if(tablero.getExtremoIzq() == ficha.getLado_A()){
            //Establecemos el lado, que coincide con el extremo, como ocupado
            ficha.setEstadoLado_A(true);
            tablero.getTablero().add(0, ficha);
            //Lado libre es el nuevo extremo izquierdo
            tablero.setExtremoIzq(ficha.getLado_B());
            respuesta = true;
        }
        if(tablero.getExtremoIzq() == ficha.getLado_B()){
            //Establecemos el lado, que coincide con el extremo, como ocupado
            ficha.setEstadoLado_B(true);
            tablero.getTablero().add(0, ficha);
            //Lado libre es el nuevo extremo izquierdo
            tablero.setExtremoIzq(ficha.getLado_A());
            respuesta = true;
        }
        if(tablero.getExtremoDer() == ficha.getLado_A()){
            //Establecemos el lado, que coincide con el extremo, como ocupado
            ficha.setEstadoLado_A(true);
            tablero.getTablero().add(ficha);
            //Lado libre es el nuevo extremo derecho
            tablero.setExtremoDer(ficha.getLado_B());
            respuesta = true;
        }
        if(tablero.getExtremoDer() == ficha.getLado_B()){
            //Establecemos el lado, que coincide con el extremo, como ocupado
            ficha.setEstadoLado_B(true);
            tablero.getTablero().add(ficha);
            //Lado libre es el nuevo extremo derecho
            tablero.setExtremoDer(ficha.getLado_A());
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
            if(jugador.getMisFichas().get(i).getColocada() == false){
                conteo = jugador.getMisFichas().get(i).getLado_A() + 
                        jugador.getMisFichas().get(i).getLado_B();
            }
        }
        return conteo;
    }
    
    /*Funcion para notificar a los usuarios de la partida un mensaje
    * @param 1 para jugador1, 2 para jugador2, 3 para ambos
    * @param mensaje a enviar*/
    private void notificar(int opcion,String mensaje){
        switch(opcion){
            case 1:
                System.out.println("\nNotificando a jugador 1");
                jugador1.notificar(mensaje);
                break;
            case 2:
                System.out.println("\nNotificando a jugador 2");
                jugador2.notificar(mensaje);
                break;
            case 3:
                System.out.println("\nNotificando a ambos jugador");
                jugador1.notificar(mensaje);
                jugador2.notificar(mensaje);
                break;
        }
    }

    @Override
    public ArrayList<Ficha> getFichasJugador1() throws RemoteException {
        return this.fichasJugador1;
    }

    @Override
    public ArrayList<Ficha> getFichasJugador2() throws RemoteException {
        return fichasJugador2;
    }

    @Override
    public boolean registrarReferenciaRemotaTablro(String login, CallBackJuegoInt objRemoto) throws RemoteException {
        System.out.println("Registrando referencia remota Tablero...");
        boolean bandera=false;
        TableroActivo nuevoTablero= new TableroActivo(login, objRemoto, true);
        bandera = ListaTablerosActivos.add(nuevoTablero);
        return bandera;
    }
     @Override
    public boolean enviarMensaje(String loginOrigen, String loginDestino, String mensaje) throws RemoteException {
        System.out.println("Enviando mensaje ...");
        boolean bandera=false;
        CallBackJuegoInt objUsuarioRemoto = null;
        for(TableroActivo objUsuario: ListaTablerosActivos)
        {
            if (objUsuario.getLogin().equals(loginDestino)){
                objUsuarioRemoto = objUsuario.getObjetoRemotoTablero();
                break;
            }
        }
        
        if (objUsuarioRemoto!=null){
            objUsuarioRemoto.enviarMensaje(loginOrigen, mensaje);
            bandera=true;
        }
        return bandera;
    }

    @Override
    public boolean enviarFicha(String LoginDestino, Fichas_Tablero N_ficha) throws RemoteException {
        System.out.println("Enviando ficha ...");
        boolean bandera=false;
        CallBackJuegoInt objUsuarioRemoto = null;
        for(TableroActivo objUsuario: ListaTablerosActivos)
        {
            if (objUsuario.getLogin().equals(LoginDestino)){
                objUsuarioRemoto = objUsuario.getObjetoRemotoTablero();
                break;
            }
        }
        
        if (objUsuarioRemoto!=null){
            objUsuarioRemoto.enviarFicha(N_ficha);
            bandera=true;
        }
        return bandera;
    }
    
}
