package prc5;

import java.io.*;
import java.net.*;

public class ServerTCP {
    public static void main(String[] args) throws IOException {
        int port = 54322;
        ServerSocket server = new ServerSocket(port, 50); // 50 es el tamaño de la cola
        while (true) {
            System.out.println("Esperando cliente...");
            Socket client = server.accept();
            BufferedReader in = new BufferedReader(new
                    InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            boolean activo = true;
            while (activo) {
                String line = in.readLine();
                if (line == null || line.equals("FINAL_MESSAGE")) {
                    out.println("FINAL_MESSAGE_OK");
                    activo = false;
                } else {
                    System.out.println("Recibido: " + line);
                    out.println("Echo: " + line); // sin cifrado
                }
            }
            in.close();
            out.close();
            client.close();
            System.out.println("Conexión cerrada.");
        }
    }
}