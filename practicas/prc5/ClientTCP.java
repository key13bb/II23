package prc5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientTCP {
    public static void main(String[] args) throws IOException {
        String serverName = "127.0.0.1";
        int serverPort = 54322;
        Socket serviceSocket = new Socket(serverName, serverPort);
        PrintWriter out = new PrintWriter(serviceSocket.getOutputStream(), true); // Enviar
        BufferedReader in = new BufferedReader(new
                InputStreamReader(serviceSocket.getInputStream())); // Recibir server
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in)); // Obtener el texto por teclado
        String userInput;
        System.out.println("Introduce mensaje (termina con texto sin dígito inicial):");
        userInput = stdIn.readLine();
        while (Character.isDigit(userInput.charAt(0))) {
            out.println(userInput);
            String respuesta = in.readLine();
            System.out.println("Respuesta: " + respuesta);
            System.out.println("Introduce otro mensaje:");
            userInput = stdIn.readLine();
        }
        out.println("FINAL_MESSAGE");
        String respuesta = in.readLine();
        if ("FINAL_MESSAGE_OK".equals(respuesta)) {
            in.close();
            out.close();
            serviceSocket.close();
            System.out.println("Conexión cerrada correctamente.");
        } else {
            System.out.println("Error al cerrar conexión.");
        }
    }
}