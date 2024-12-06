package libreria;

import java.util.Arrays;

public class OfertaAutor implements OfertaFlex{
    double descuento;
    String[] biblioteca;

    public OfertaAutor (double descuento, String[] biblioteca) {
        this.descuento = descuento;
        this.biblioteca = biblioteca;
    }

    @Override
    public double getDescuento(Libro libro) {
        double descuento = 0;

        if (buscarAutorOferta(libro.getAutor()) >= 0) {
            descuento = this.descuento;
        }
        return descuento;
    }

    public int buscarAutorOferta(String autor) {
        int index = -1;
        for (int i = 0; i < biblioteca.length; i++) {
            if(biblioteca[i].equalsIgnoreCase(autor)) {
                index = i;
            }
        }

        return index;
    }

    @Override
    public String toString() {
        return descuento + "%" + Arrays.toString(biblioteca);
    }
}
