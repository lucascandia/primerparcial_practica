package py.una.server.udp;


import java.io.*;
import java.net.*;

import py.una.entidad.Cliente;
import py.una.entidad.ClienteJSON;

class UDPClient {

    public static void main(String a[]) throws Exception {

        // Datos necesario
        String direccionServidor = "127.0.0.1";

        if (a.length > 0) {
            direccionServidor = a[0];
        }

        int puertoServidor = 9876;
        
        try {

            BufferedReader inFromUser =
                    new BufferedReader(new InputStreamReader(System.in));

            DatagramSocket clientSocket = new DatagramSocket();

            InetAddress IPAddress = InetAddress.getByName(direccionServidor);
            System.out.println("Intentando conectar a = " + IPAddress + ":" + puertoServidor +  " via UDP...");

            System.out.println("Alumno: Lucas Gustavo Candia Solis ");

            byte[] sendData = new byte[1024];
            byte[] receiveData = new byte[1024];
            System.out.print("Ingrese el identificador del (Banco/Entidad): ");
            Long id = Long.valueOf(inFromUser.readLine());
            System.out.print("Ingrese el nombre de cliente(Banco/Entidad): ");
            String cliente = inFromUser.readLine();
            System.out.print("Ingrese la cotizacion: ");
            String cotizacion = inFromUser.readLine();
            
            Cliente p = new Cliente(id,  cliente, cotizacion);
            
            String datoPaquete = ClienteJSON.objetoString(p);
            sendData = datoPaquete.getBytes();

            System.out.println("Enviar " + datoPaquete + " al servidor. ("+ sendData.length + " bytes)");
            DatagramPacket sendPacket =
                    new DatagramPacket(sendData, sendData.length, IPAddress, puertoServidor);

            clientSocket.send(sendPacket);

            DatagramPacket receivePacket =
                    new DatagramPacket(receiveData, receiveData.length);

            System.out.println("Esperamos si viene la respuesta.");

            //Vamos a hacer una llamada BLOQUEANTE entonces establecemos un timeout maximo de espera
            clientSocket.setSoTimeout(10000);

            try {
                // ESPERAMOS LA RESPUESTA, BLOQUENTE
                clientSocket.receive(receivePacket);

                String respuesta = new String(receivePacket.getData());
                Cliente presp = ClienteJSON.stringObjeto(respuesta.trim());
                
                InetAddress returnIPAddress = receivePacket.getAddress();
                int port = receivePacket.getPort();

                System.out.println("Respuesta desde =  " + returnIPAddress + ":" + port);
               /* System.out.println("Asignaturas: ");
                
                for(String tmp: presp.getAsignaturas()) {
                	System.out.println(" -> " +tmp);
                }*/
                

            } catch (SocketTimeoutException ste) {

                System.out.println("TimeOut: El paquete udp se asume perdido.");
            }
            clientSocket.close();
        } catch (UnknownHostException ex) {
            System.err.println(ex);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
} 

