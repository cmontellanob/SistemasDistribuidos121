/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primerparcial;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class BancoBNB extends UnicastRemoteObject
        implements IBanco {

    public BancoBNB() throws RemoteException {
        super();
    }

    @Override
    public ArrayList<Cuenta> ObtenerSaldo(String ci, String nombres, String apellidos) throws RemoteException {
        ArrayList<Cuenta> aux = new ArrayList<Cuenta>();
        if (ci.equals("11021654") && nombres.equals("Juan Perez") && apellidos.equals("Segovia")) {
           aux.add(new Cuenta(Banco.BNB, "4657657", ci, nombres, apellidos, 5354.00));
        }
        return aux;
    }

    @Override
    public boolean CongelarMonto(Cuenta cuenta, double monto) throws RemoteException {
     boolean aux=false;
        if (cuenta.getCi().equals("11021654") && cuenta.getNombres().equals("Juan Perez") && cuenta.getApellidos().equals("Segovia"))   {
           aux=true;
        }
     return aux;   
    }
    public static void main(String[] args) {
        BancoBNB servidor;
        try {
            LocateRegistry.createRegistry(1099); // registrar el servidor e rmi register
            servidor = new BancoBNB();
            Naming.bind("Banco", servidor);
            System.out.println("El servidor esta listo\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
