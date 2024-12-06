package cuentapalabras;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class ContadorPalabras {
    List<PalabraEnTexto> lista;

    public ContadorPalabras() {
        this.lista = new ArrayList<>();
    }

    private int esta(String pal) {
        PalabraEnTexto palabra = new PalabraEnTexto(pal);
        return lista.indexOf(palabra);
    }

    protected void incluye(String pal) {
        if (!(pal.isEmpty() || pal.isBlank())) {
            if (esta(pal) > -1) {
                lista.get(esta(pal)).incrementa();
            } else {
                PalabraEnTexto palabra = new PalabraEnTexto(pal);
                lista.add(palabra);
            }
        }
    }

    private void incluyeTodas(String linea, String del) {
        String[] frase = linea.split(del);
        for (String palabra : frase) {
            incluye(palabra);
        }
    }

    public void incluyeTodas(String[] texto, String del) {
        for (String linea : texto) {
            incluyeTodas(linea, del);
        }
    }

    public void incluyeTodasFichero(String nomFich, String del) throws IOException {
        Path dir = Path.of(nomFich);
        try (BufferedReader buffer = Files.newBufferedReader(dir)) {
            String linea = buffer.readLine();
            while (linea != null) {
                incluyeTodas(linea, del);
                linea = buffer.readLine();
            }
        }
    }

    public PalabraEnTexto encuentra(String pal) {
        PalabraEnTexto palabra;
        if (esta(pal) == -1) {
            throw new NoSuchElementException("No existe la palabra " + pal);
        } else {
            palabra = lista.get(esta(pal));
        }
        return palabra;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(" - ", "[", "]");
        for (PalabraEnTexto palabra : lista) {
            joiner.add(palabra.toString());
        }
        return joiner.toString();
    }

    public void presentaPalabras(String fichero) throws FileNotFoundException {
        try (PrintWriter pw = new PrintWriter(fichero)) {
            presentaPalabras(pw);
        }
    }

    public void presentaPalabras(PrintWriter pw) {
        StringJoiner joiner = new StringJoiner("");
        for (PalabraEnTexto palabra : lista) {
            joiner.add(palabra.toString());
        }
        pw.println(joiner);
    }
}
