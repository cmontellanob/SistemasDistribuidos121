/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumnormi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos
 */
public class ClienteCRUDAlumno {

    public static void main(String[] args) {

        ICRUDAlumno crudAlumno;
        Scanner sc = new Scanner(System.in);
        Carrera carrera = new Carrera(111, "Ing. en Ciencias de la Computación");
        System.out.println("Nombres: ");
        String nombres = sc.next();
        System.out.println("Apellidos: ");
        String apellidos = sc.next();
        System.out.println("Edad:");
        int edad = sc.nextInt();
        Alumno alumno=new Alumno(nombres, apellidos, edad, carrera);
        try {
            crudAlumno=(ICRUDAlumno)Naming.lookup("rmi://localhost/CRUDAlumno");
            
            
            crudAlumno.insertar(alumno);
            
            
            
            
        } catch (NotBoundException ex) {
            Logger.getLogger(ClienteCRUDAlumno.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClienteCRUDAlumno.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ClienteCRUDAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
