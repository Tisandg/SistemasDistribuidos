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
    private ArrayList<Ficha> fichasTotal;
    private Tablero tablero;
    
    public JugarImpl() throws RemoteException
    {
        super(); //invoca al constructor de la clase base
        /*Cargamos todas las fichas del domino*/
        cargarTodasLasFichas();
    }

    @Override
    public void seleccionarJugador(String login) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void empezarPartida() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Ficha> repartirFichas(int tamano) throws RemoteException {
        
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
        //donde les retorno el array de fichas?
        return null;    
    }
    
    private void cargarTodasLasFichas()throws RemoteException{
        int i = 0, j = 0;
	for(i=0; i<7; i++){
            for(j=i; j<7; j++){
                Ficha ficha = new Ficha(i,j,0);
                fichasTotal.add(ficha);
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

    @Override
    public Tablero estadoTablero() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean enviarJugada(Ficha ficha) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
