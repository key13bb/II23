package prc4;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author key13bb
 */
public class ServerUDP {
    public static String cifrar(String texto) {
        String resultado = "";
        //* COMPLETAR devolver texto cifrado usando el algoritmo de cifrado César solo para letras entre 'a' y 'z'
        resultado = "Tamaño del texto: " + texto.length();
        return resultado;
    }

    public static void main(String[] args) throws IOException {
        // DATOS DEL SERVIDOR
        //* FIJO: Si se lee de línea de comando debe comentarse
        int port = 54322; // puerto del servidor
        //* VARIABLE: Si se lee de línea de comando debe descomentarse
        // int port = Integer.parseInt(args[0]); // puerto del servidor

        // SOCKET
        DatagramSocket server = new DatagramSocket(port);

        //* COMPLETAR Crear e inicalizar el socket del servidor

        // Funcion PRINCIPAL del servidor
        while (true)
        {
            DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
            //* COMPLETAR: Crear e inicializar un datagrama VACIO para recibir la respuesta de máximo 400 bytes
            server.receive(packet);
            //* COMPLETAR: Recibir datagrama

            //* COMPLETAR: Obtener texto recibido
            String line = packet.getData().toString();

            //* COMPLETAR: Mostrar por pantalla la direccion socket (IP y puerto) del cliente y su texto

            System.out.println(server.getLocalAddress().toString() + ": " + server.getLocalPort());
            // Capitalizamos la linea
            line = cifrar(line);

            //* COMPLETAR: crear datagrama de respuesta
            DatagramPacket toSend = new DatagramPacket(new byte[1024], 1024);
            //* COMPLETAR: Enviar datagrama de respuesta
            toSend.setData(line.getBytes(StandardCharsets.UTF_8));
            server.send(toSend);
        } // Fin del bucle del servicio
    }

}
