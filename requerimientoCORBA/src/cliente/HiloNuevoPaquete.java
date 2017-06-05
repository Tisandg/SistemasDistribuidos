/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 *
 * @author Kevin Chantré
 */
public class HiloNuevoPaquete extends Thread{

    private byte[] paquete;
    private InputStream paq;
    
    public HiloNuevoPaquete(byte [] paquete) {
        this.paquete = paquete;       
    }

    
    public void run(){
        paq = new ByteArrayInputStream(paquete);
        ReproductorAudio.cola.add(paq);
    }
}
