package cuentapalabras;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ContadorPalabrasSig extends ContadorPalabras {
    private List<String> noSignificativas;
    public ContadorPalabrasSig() {
        super();
        noSignificativas = new ArrayList<>();
    }
    public void leeArrayNoSig(String[] palsNS) {
        eliminarNoSignificativas();
        for (String palabra : palsNS) {
            if (!(palabra.isEmpty() || palabra.isBlank())) {
                noSignificativas.add(palabra.trim().toUpperCase());
            }
        }
    }

    public void leeFicheroNoSig(String filNoSig, String del) throws IOException {
        eliminarNoSignificativas();
        Path path = Path.of(filNoSig);
        try (BufferedReader buffer = Files.newBufferedReader(path)) {
            String linea;
            while ((linea = buffer.readLine()) != null) {
                anyadePalabrasNoSignificativas(linea, del);
            }
        }
    }
    private void anyadePalabrasNoSignificativas(String linea, String del) {
        String[] palabras = linea.split(del);
        for (String pal : palabras) {
            if (!pal.trim().isEmpty()) {
                noSignificativas.add(pal.trim().toUpperCase());
            }
        }
    }
    private void eliminarNoSignificativas() {
        for(String pal : noSignificativas) {
            lista.remove(pal);
        }
    }
    protected void incluye(String pal) {
        if ((pal !="") && estaNoSig(pal) < 0) {
            super.incluye(pal);
        }
    }

    private int estaNoSig(String pal) {
        return noSignificativas.indexOf(pal.toUpperCase());
    }
}