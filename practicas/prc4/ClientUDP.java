package prc4;

import java.io.IOException;
import java.util.Scanner;
import java.net.*;
import java.nio.charset.StandardCharsets;


/**
 *
 * @author <su nombre aquí>
 */

public class ClientUDP {
    public static void main(String[] args) throws IOException {
        // DATOS DEL SERVIDOR:
        //* FIJOS: coméntelos si los lee de la línea de comandos
        String serverName = "127.0.0.1"; //direccion local
        int serverPort = 54322;
        //* VARIABLES: descoméntelos si los lee de la línea de comandos
        //String serverName = args[0];
        //int serverPort = Integer.parseInt(args[1]);

        SocketAddress socketAddress = new InetSocketAddress(serverName, serverPort);
        DatagramSocket serviceSocket = new DatagramSocket(socketAddress);
        //* COMPLETAR: crear socket

        // INICIALIZA ENTRADA POR TECLADO
        Scanner stdIn = new Scanner(System.in, StandardCharsets.UTF_8);
        String userInput;
        System.out.println("Introduzca un texto a enviar que empiece con dígito (sin dígito inicial para acabar): ");
        userInput = stdIn.nextLine(); /*CADENA ALMACENADA EN userInput*/

        //* COMPLETAR: Comprobar si el usuario quiere terminar servicio
        while (true)
        {
            //* COMPLETAR: Crear datagrama con la cadena escrito en el cuerpo
            DatagramPacket packet = new DatagramPacket(userInput.getBytes(StandardCharsets.UTF_8), userInput.length());
            //* COMPLETAR: Enviar datagrama a traves del socket
            serviceSocket.send(packet);

            System.out.println("STATUS: Waiting for the reply");

            //* COMPLETAR: Crear e inicializar un datagrama VACIO para recibir la respuesta de máximo 400 bytes

            DatagramPacket response = new DatagramPacket(new byte[1024], 1024);
            //* COMPLETAR: Recibir datagrama de respuesta
            serviceSocket.receive(response);

            //* COMPLETAR: Extraer contenido del cuerpo del datagrama en variable line
            String line = response.getData().toString();

            System.out.println("echo: " + line);
            System.out.println("Introduzca un texto a enviar que empiece con dígito (sin dígito inicial para acabar): ");
            userInput = stdIn.nextLine();
        }

        //System.out.println("STATUS: Closing client");

        //* COMPLETAR Cerrar socket cliente

        //System.out.println("STATUS: closed");
    }
}
