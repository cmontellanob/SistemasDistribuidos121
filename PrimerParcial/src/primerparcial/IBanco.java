/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primerparcial;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public interface IBanco  extends Remote {
    ArrayList<Cuenta>ObtenerSaldo (String ci, String nombres, String apellidos) throws RemoteException;
    boolean CongelarMonto(Cuenta cuenta,double monto)throws RemoteException;
    
}
