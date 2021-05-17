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
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Carlos
 */
public class BancoMercantil {

    public static void main(String[] args) {
        int port = 5001; 
        String respuesta=""; 
       while(true)
       {           
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Se inicio el servidor");
            Socket client;
            PrintStream toClient;       
            client = server.accept(); //conexion
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
            System.out.println("Cliente se conecto");
            String linea=fromClient.readLine();
            String[] separado=linea.split(":");
            String[] datos=separado[1].split("-");
            if (separado[0].equals("Buscar"))
            {
                String ci=datos[0];
                String nombres=datos[1];
                String apellidos=datos[2];
                respuesta="";
                
            }
            if (separado[0].equals("Congelar"))
            {
                respuesta="No-no";
                
            }
            
            toClient = new PrintStream(client.getOutputStream()); 
            toClient.println(respuesta);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

       }
    }
}
