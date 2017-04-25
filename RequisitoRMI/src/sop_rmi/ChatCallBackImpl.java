package sop_rmi;

import java.rmi.RemoteException;

/**
 * @author Santiago Garcia 
 */
public class ChatCallBackImpl implements ChatCallBackInt{

    @Override
    public void enviarMesaje(String mensaje, String login) throws RemoteException {
        System.out.println(login+": "+mensaje);
    }
    
    
}
