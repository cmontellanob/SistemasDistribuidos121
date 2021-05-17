/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primerparcial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.SocketException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos
 */
public class ServidorAsfi extends UnicastRemoteObject
        implements IAsfi {

    public ServidorAsfi() throws RemoteException {
        super();
    }

    @Override
    public ArrayList<Cuenta> ConsultarCuentas(String ci, String nombres, String apellidos) throws RemoteException {
        ArrayList<Cuenta> aux = new ArrayList<Cuenta>();
//         Llamar alBNB
        aux = CuentasBNB(ci, nombres, apellidos);

//         Llamar Banco Mercantil
        ArrayList<Cuenta> aux2 = CuentasMercantil(ci, nombres, apellidos);
//         Llamar BCP       
        for (Cuenta cuenta : aux2) {
            aux.add(cuenta);
        }
        
        ArrayList<Cuenta> aux3 = CuentasBCP(ci, nombres, apellidos);
//         Llamar BCP       
        for (Cuenta cuenta : aux3) {
            aux.add(cuenta);
        }
        
        

        return aux;
    }

    @Override
    public boolean RetenerMonto(Cuenta cuenta, double monto, String glosa) throws RemoteException {
    boolean aux=false;
        if (cuenta.getBanco()==Banco.BNB){
            aux=RetenerBNB(cuenta,monto);
        }
        if (cuenta.getBanco()==Banco.Banco_Mercantil){
            aux=RetenerMercantil(cuenta,monto);
        }
        if (cuenta.getBanco()==Banco.Banco_BCP){
            aux=RetenerBCP(cuenta,monto);
        }

        
    return aux;
    }

    private ArrayList<Cuenta> CuentasBNB(String ci, String nombres, String apellidos) {
        ArrayList<Cuenta> aux = new ArrayList<Cuenta>();
        IBanco banco;

        try {
            banco = (IBanco) Naming.lookup("rmi://localhost/Banco");
            aux = banco.ObtenerSaldo(ci, nombres, apellidos);

        } catch (NotBoundException ex) {
            Logger.getLogger(ServidorAsfi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ServidorAsfi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ServidorAsfi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aux;

    }

    private ArrayList<Cuenta> CuentasMercantil(String ci, String nombres, String apellidos) {
        ArrayList<Cuenta> aux = new ArrayList<Cuenta>();
        int port = 5001;
        try {
            Socket client = new Socket("localhost", port);
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));

            toServer.println("Buscar:" + ci + "-" + nombres + "-" + apellidos);
            String result = fromServer.readLine();
            if (!result.equals("")) {
                String[] cuentas = result.split(":");
                for (String c : cuentas) {
                    String[] datos = c.split("-");
                    double saldo = Double.valueOf(datos[1]);
                    Cuenta nueva = new Cuenta(Banco.Banco_Mercantil, datos[0], ci, nombres, apellidos, saldo);
                    aux.add(nueva);
                }

            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return aux;
    }

    private ArrayList<Cuenta> CuentasBCP(String ci, String nombres, String apellidos) {
        ArrayList<Cuenta> aux = new ArrayList<Cuenta>();
        int puerto = 6789;

        try {
            String dato = "Buscar:" + ci + "-" + nombres + "-" + apellidos;
            String ip = "localhost";
            DatagramSocket socketUDP = new DatagramSocket();
            byte[] mensaje = dato.getBytes();
            InetAddress hostServidor = InetAddress.getByName(ip);

            // Construimos un datagrama para enviar el mensaje al servidor
            DatagramPacket peticion
                    = new DatagramPacket(mensaje, dato.length(), hostServidor,
                            puerto);

            // Enviamos el datagrama
            socketUDP.send(peticion);

            // Construimos el DatagramPacket que contendrá la respuesta
            byte[] bufer = new byte[1000];
            DatagramPacket respuesta
                    = new DatagramPacket(bufer, bufer.length);
            socketUDP.receive(respuesta);

            // Enviamos la respuesta del servidor a la salida estandar
            String result = new String(respuesta.getData());
            if (!result.equals("")) {
                String[] cuentas = result.split(":");
                for (String c : cuentas) {
                    String[] datos = c.split("-");
                    double saldo = Double.valueOf(datos[1]);
                    Cuenta nueva = new Cuenta(Banco.Banco_BCP, datos[0], ci, nombres, apellidos, saldo);
                    aux.add(nueva);
                }

            }
            // Cerramos el socket
            socketUDP.close();

        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }

        return aux;
    }

    public static void main(String[] args) {
        ServidorAsfi servidor;
        try {
            //  LocateRegistry.createRegistry(1099); // registrar el servidor e rmi register
            servidor = new ServidorAsfi();
            Naming.bind("Asfi", servidor);
            System.out.println("El servidor esta listo\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean RetenerBNB(Cuenta cuenta, double monto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean RetenerMercantil(Cuenta cuenta, double monto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean RetenerBCP(Cuenta cuenta, double monto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
