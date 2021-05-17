/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primerparcial;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos
 */
public class Juez {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IAsfi asfi;
        String ci="11021654";
        String nombres="Juan Perez";
        String apellidos="Segovia";
        Scanner sc=new Scanner(System.in);
//        System.out.println("Introduzca el CI");
//        ci=sc.next();
//        System.out.println("Introduzca el Nombre");
//        nombres=sc.next();
//        System.out.println("Introduzca el Apellido");
//        apellidos=sc.next();
        
        try {
            asfi=(IAsfi)Naming.lookup("rmi://localhost/Asfi");
            ArrayList<Cuenta>cuentas =asfi.ConsultarCuentas(ci, nombres, apellidos);
            for (Cuenta cuenta:cuentas)
            {
                System.out.println(cuenta);
            }
                
            
            
            
            
            
        } catch (NotBoundException ex) {
            Logger.getLogger(Juez.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Juez.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(Juez.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        
    }
    
}
