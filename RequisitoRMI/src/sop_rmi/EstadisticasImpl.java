package sop_rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;

/**
 * @author Santiago Garcia
 * implementacion de EstadisticasInt
 */
public class EstadisticasImpl extends UnicastRemoteObject implements EstadisticasInt{

    private Archivos archivo;
    private String ruta ;

    
    public EstadisticasImpl() throws RemoteException{
        super();
        this.archivo = new Archivos();
        
        /*Ruta por defecto en nuestro sistema*/
        this.ruta = "./Estadisticas/estadisticas.txt";
    }
    
    /*Funcion para generar las estadisticas del juego. Se cuenta cuantas partidas
    * en total se han jugado, cuantos empates se han hecho,y que jugadores han ganado.
    * Los jugadores se muestran de mayor a menor segun el numero de partidas ganadas
    * Estas estadisticas se generan apartir del archivo de texto 'estadisticas.txt'
    * @return ArrayList de String donde estan las estadisticas del juego*/
    @Override
    public ArrayList<String> generarEstadisticas() throws RemoteException 
    {
        ArrayList<String> lineasLeidas = archivo.leerArchivo(ruta);
        if(lineasLeidas.size() == 0){
            return null;
        }
        
        /*Lista de jugadores con su respectivo contador de partidas ganadas*/
        ArrayList<datosEstadisticas> jugadores = new ArrayList<datosEstadisticas>();
        
        ArrayList<String> loginsLeidos = new ArrayList<String>();
        ArrayList<String> loginsContados = new ArrayList<String>();
        int totalPartidas = 0;
        int empates = 0;
        int contadorAux, indice, resultado;
        int i, j, tamLineas = lineasLeidas.size();
        String[] lineaDividida;
        
        for (i = 0; i < tamLineas; i++) {
            
            lineaDividida = lineasLeidas.get(i).split(";");
            resultado = -1;
            
            if(lineaDividida[2].equals("1")){
                resultado = 0;

            }
            if(lineaDividida[2].equals("2")){
                resultado = 1;

            }
            if(resultado != -1){
                /*hay un ganador*/
                indice = loginsLeidos.indexOf(lineaDividida[resultado]);
                if(indice != -1 ){    
                    /*ya esta el login*/
                    int encontrado =buscarObjeto(jugadores,lineaDividida[resultado]);
                    if(encontrado != -1){
                        datosEstadisticas dato = jugadores.get(encontrado);
                        dato.setContador(dato.getContador()+1);
                        jugadores.set(encontrado, dato);
                    }
                }else{
                    /*Si no esta, se agrega*/
                    loginsLeidos.add(lineaDividida[resultado]);
                    jugadores.add(new datosEstadisticas(lineaDividida[resultado],1));
                }
            }
            
            if(lineaDividida[2].equals("0")){
                empates++;
            }
            totalPartidas++;
        }
        
        /*Ordenamos el array jugadores por su contador de partidas ganadas,
        * de mayor a menor*/
        i = 0;
        ArrayList<Integer> contadores = new ArrayList<Integer>();
        int tamJugadores = jugadores.size();
        for (i = 0; i < tamJugadores; i++) {
            contadores.add(jugadores.get(i).getContador());
        }
        contadores = ordenarArrayEnteros(contadores);
        for (i = 0; i <tamJugadores; i++) {
            contadorAux = contadores.get(i);
            for (j = 0; j < tamJugadores; j++) {
                if(jugadores.get(j).getContador() == contadorAux && (loginsContados.contains(jugadores.get(j).getLogin()) == false) ){
                    loginsContados.add(jugadores.get(j).getLogin());
                }
            }
        }
        ArrayList<String> resultadosEstadisticas = new ArrayList<String>();
        resultadosEstadisticas.add("Total partidas jugadas hasta el momento: "+totalPartidas);
        resultadosEstadisticas.add("Total de empates: "+empates);
        resultadosEstadisticas.add("Imprimiendo ganadores de mayor a menor: ");
        
        for ( i = 0; i < tamJugadores; i++) {
            resultadosEstadisticas.add(""+(i+1)+". "+loginsContados.get(i)+":"+contadores.get(i));
        }

        return resultadosEstadisticas;
    }

    /*Actualizamos el archivos de estadisticas con el resultado de una partida
    * @param login del jugador 1
    * @param login del jugador 2
    * @param numero, en formato texto, que indica el resultado de la partida
    * @return true si se actualizo correctamente*/
    @Override
    public boolean actualizarEstadisticas(String login1, String login2, String resultadoPartida) throws RemoteException 
    {
        /*Formato para guardar el resultado de las partidas*/
        String texto = login1+";"+login2+";"+resultadoPartida;
        
        boolean respuesta = archivo.escribirEnArchivo(ruta, texto);
        return respuesta;
    }
    
    /*************************  Metodos auxiliares ******************************/
    
    /*Ordenar un arrayList de enteros de mayor a menor
    * @param array de enteros
    * @return array de enteros ordenado */
    public ArrayList<Integer> ordenarArrayEnteros(ArrayList<Integer> array){
        Comparator<Integer> comparador = Collections.reverseOrder();
        Collections.sort(array, comparador);
        return array;
    }
    
    /*Funcion para buscar un objeto datosEstadistica dentro del array, comparando
    * por el login
    * @param array de datosEstadisticas
    * @param Login a buscar 
    * @return si esta, se devuelve la posicion del archivo, de lo contrario -1*/
    public int buscarObjeto(ArrayList<datosEstadisticas> array, String login){
        int i, tam = array.size();
        for (i = 0; i < tam; i++) {
            if(array.get(i).getLogin().equals(login)){
                return i;
            }
        }
        return -1;
    }
}
