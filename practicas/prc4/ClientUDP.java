package prc4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress; // Importar InetAddress
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ClientUDP {
    public static void main(String[] args) throws IOException {
        String serverName = "127.0.0.1"; //direccion local
        int serverPort = 54322;
        //String serverName = args[0];
        //int serverPort = Integer.parseInt(args[1]);

        InetAddress serverAddress = InetAddress.getByName(serverName); // <--- CORRECCIÓN
        DatagramSocket serviceSocket = new DatagramSocket();
        Scanner stdIn = new Scanner(System.in, StandardCharsets.UTF_8);
        String userInput;
        System.out.println("Introduzca un texto a enviar que empiece con dígito (sin dígito inicial para acabar, o 'exit' para acabar): "); // Modificado el prompt para claridad
        userInput = stdIn.nextLine();
        while (!userInput.equalsIgnoreCase("exit"))
        {
            DatagramPacket packet = new DatagramPacket(userInput.getBytes(StandardCharsets.UTF_8),
                    userInput.length(),
                    serverAddress,
                    serverPort);
            serviceSocket.send(packet);
            System.out.println("STATUS: Waiting for the reply");
            DatagramPacket response = new DatagramPacket(new byte[1024], 1024);
            serviceSocket.receive(response);
            String line = new String(response.getData(), 0, response.getLength(), StandardCharsets.UTF_8);
            System.out.println("echo: " + line);
            System.out.println("Introduzca un texto a enviar que empiece con dígito ('exit' para acabar): ");
            userInput = stdIn.nextLine();
        }
        System.out.println("STATUS: Closing client");
        serviceSocket.close();
        System.out.println("STATUS: closed");
    }
}