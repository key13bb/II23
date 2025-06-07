package prc4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress; // Puede que necesites este import, aunque packet.getAddress() ya lo devuelve
import java.net.SocketException; // Para DatagramSocket
import java.nio.charset.StandardCharsets;

public class ServerUDP {
    public static String cifrar(String texto) {
        String resultado = "";
        StringBuilder sb = new StringBuilder();
        for (char c : texto.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                sb.append((char) ('a' + (c - 'a' + 1) % 26));
            } else if (c >= 'A' && c <= 'Z') {
                sb.append((char) ('A' + (c - 'A' + 1) % 26));
            }
            else {
                sb.append(c);
            }
        }
        resultado = sb.toString();
        return resultado;
    }

    public static void main(String[] args) throws IOException {
        int port = 54322;
        // int port = Integer.parseInt(args[0]); // puerto del servidor
        DatagramSocket server = null; // Inicializar a null para el bloque try-catch-finally

        try { // Usar un try-catch para manejar SocketException al crear el socket
            server = new DatagramSocket(port);
            System.out.println("STATUS: Servidor UDP iniciado en el puerto " + port);
            while (true)
            {
                DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
                server.receive(packet); // Este método bloquea hasta que recibe un paquete
                String receivedText = new String(packet.getData(), 0, packet.getLength(), StandardCharsets.UTF_8);
                InetAddress clientAddress = packet.getAddress();
                int clientPort = packet.getPort();

                System.out.println("Mensaje recibido de " + clientAddress.getHostAddress() + ":" + clientPort + " -> " + receivedText);
                String responseText = cifrar(receivedText);
                byte[] responseData = responseText.getBytes(StandardCharsets.UTF_8);
                DatagramPacket toSend = new DatagramPacket(responseData, responseData.length, clientAddress, clientPort);
                server.send(toSend);
                System.out.println("Respuesta enviada: " + responseText);
            }

        } catch (SocketException e) {
            System.err.println("Error de socket: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error de I/O: " + e.getMessage());
        } finally {
            if (server != null && !server.isClosed()) {
                System.out.println("STATUS: Cerrando servidor");
                server.close();
                System.out.println("STATUS: Servidor cerrado");
            }
        }
    }
}