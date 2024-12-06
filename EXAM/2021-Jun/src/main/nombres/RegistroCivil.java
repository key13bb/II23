package main.nombres;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class RegistroCivil {

    String code;
    Nombre nombre;
    int year;
    int freq;

    public RegistroCivil(String estado, String file) {

    }

    public void leer() {

    }

    private void procesar(String file) throws IOException{
        Path path = Path.of(file);
        BufferedReader buffer = Files.newBufferedReader(path);
        String line = buffer.readLine();
        while (line != null) {

        }
    }

    private void agregar(Nombre nombre, int year, int freq) {

    }
}
