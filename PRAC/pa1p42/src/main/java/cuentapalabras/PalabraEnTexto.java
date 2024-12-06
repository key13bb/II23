package cuentapalabras;

public class PalabraEnTexto {
    String palabra;
    int freq;

    public PalabraEnTexto(String palabra) {
        this.palabra = palabra.toUpperCase();
        this.freq = 1;
    }

    @Override
    public boolean equals(Object object) {
        boolean iguales = false;
        if (object instanceof PalabraEnTexto) {
            iguales = this.palabra.equals(((PalabraEnTexto) object).palabra);
        }
        return iguales;
    }

    @Override
    public String toString() {
        return palabra + ": " + freq;
    }

    @Override
    public int hashCode() {
        return palabra.hashCode();
    }

    public void incrementa() {
        freq++;
    }
}



























































