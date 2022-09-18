package py.una.server.udp;

import java.net.*;

import py.una.bd.ClienteDAO;
import py.una.entidad.Cliente;
import py.una.entidad.ClienteJSON;

public class UDPServer {
	
	
    public static void main(String[] a){
        
        // Variables
        int puertoServidor = 9876;
        ClienteDAO pdao = new ClienteDAO();
        
        try {
            //1) Creamos el socket Servidor de Datagramas (UDP)
            DatagramSocket serverSocket = new DatagramSocket(puertoServidor);
			System.out.println("Servidor Sistemas Distribuidos - UDP ");
            System.out.println("Alumno: Lucas Gustavo Candia Solis ");
			
            //2) buffer de datos a enviar y recibir
            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[1024];

			
            //3) Servidor siempre esperando
            while (true) {

                receiveData = new byte[1024];

                DatagramPacket receivePacket =
                        new DatagramPacket(receiveData, receiveData.length);


                System.out.println("Esperando a algun cliente... ");

                // 4) Receive LLAMADA BLOQUEANTE
                serverSocket.receive(receivePacket);
				
				System.out.println("________________________________________________");
                System.out.println("Aceptamos un paquete");

                // Datos recibidos e Identificamos quien nos envio
                String datoRecibido = new String(receivePacket.getData());
                datoRecibido = datoRecibido.trim();
                System.out.println("DatoRecibido: " + datoRecibido );
                Cliente p = ClienteJSON.stringObjeto(datoRecibido);

                InetAddress IPAddress = receivePacket.getAddress();

                int port = receivePacket.getPort();

                System.out.println("De : " + IPAddress + ":" + port);
                System.out.println("Cliente Recibido : "+ p.getIdcliente()+ "  " + p.getCliente() + " " + p.getCotizacion());
                
                try {
                	pdao.insertar(p);
                	System.out.println("Cliente insertada exitosamente en la Base de datos");
                }catch(Exception e) {
                	System.out.println("Cliente NO insertada en la Base de datos, razón: " + e.getLocalizedMessage());
                }
                
                // Respondemos agregando a la persona una asignatura
               /* p.getAsignaturas().add("Algoritmos y Estructuras de datos 2");
                p.getAsignaturas().add("Redes de Computadoras 2");*/

                // Enviamos la respuesta inmediatamente a ese mismo cliente
                // Es no bloqueante
                sendData = ClienteJSON.objetoString(p).getBytes();
                DatagramPacket sendPacket =
                        new DatagramPacket(sendData, sendData.length, IPAddress,port);

                serverSocket.send(sendPacket);

            }

        } catch (Exception ex) {
        	ex.printStackTrace();
            System.exit(1);
        }

    }
}  

