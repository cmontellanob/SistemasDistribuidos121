/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumnormi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos
 */
public class ServidorCRUDAlumno extends UnicastRemoteObject implements ICRUDAlumno  {

    public ServidorCRUDAlumno() throws RemoteException {
        super();
    }

    @Override

    public boolean insertar(Alumno alumno) throws RemoteException {
        System.out.println(alumno.getNombres());
        System.out.println(alumno.getApellidos());
        
        return true;
    }

    public static void main(String[] args) {
        try {
            ServidorCRUDAlumno servidor;
            LocateRegistry.createRegistry(1099); // registrar el servidor e rmi register
            servidor = new ServidorCRUDAlumno();
            Naming.bind("CRUDAlumno", servidor);
            System.out.println("El servidor esta listo\n");
        } catch (RemoteException ex) {
            Logger.getLogger(ServidorCRUDAlumno.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AlreadyBoundException ex) {
            Logger.getLogger(ServidorCRUDAlumno.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ServidorCRUDAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
