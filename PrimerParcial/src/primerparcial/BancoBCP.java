/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primerparcial;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author Carlos
 */
public class BancoBCP {

    public static void main(String args[]) {
        int port = 6789;
        try {
            String respuesta="";
            DatagramSocket socketUDP = new DatagramSocket(port);
            byte[] bufer = new byte[1000];

            while (true) {
                // Construimos el DatagramPacket para recibir peticiones
                DatagramPacket peticion
                        = new DatagramPacket(bufer, bufer.length);

                // Leemos una petición del DatagramSocket
                socketUDP.receive(peticion);

                String linea =new String(peticion.getData());

                String[] separado = linea.split(":");
                String[] datos = separado[1].split("-");
                if (separado[0].equals("Buscar")) {
                    String ci = datos[0];
                    String nombres = datos[1];
                    String apellidos = datos[2];

                    if (ci.equals("11021654") && nombres.equals("Juan Perez") && apellidos.equals("Segovia")) {
                        respuesta = "657654:5000";
                    } else {
                        respuesta = "";
                    }

                }
                if (separado[0].equals("Congelar")) {
                    String cuenta = datos[0];
                    String monto = datos[1];
                    if (cuenta.equals("657654")) {
                        respuesta = "SI:657654";
                    } else {
                        respuesta = "No-no";
                    }

                }
                
                // Construimos el DatagramPacket para enviar la respuesta
                DatagramPacket result
                        = new DatagramPacket(respuesta.getBytes(), respuesta.length(),
                                peticion.getAddress(), peticion.getPort());

                // Enviamos la respuesta, que es un eco
                socketUDP.send(result);
            }

        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
    }

}
