/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteoperacionesjava;

/**
 *
 * @author Carlos
 */
public class ClienteOperacionesJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int a=5;
        int b=6;
        System.out.print(suma(a,b));
        
    }

    private static int suma(int a, int b) {
        clienteoperacionesjava.Operaciones service = new clienteoperacionesjava.Operaciones();
        clienteoperacionesjava.OperacionesSoap port = service.getOperacionesSoap();
        return port.suma(a, b);
    }
    
}
