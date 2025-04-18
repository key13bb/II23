package libreria;

import java.util.Arrays;

public class LibreriaOferta extends Libreria {
    private double descuento;
    private String[] biblioteca;
    public LibreriaOferta(double descuento, String[] biblioteca) {
        super();
        this.biblioteca = biblioteca;
        this.descuento = descuento;
    }

    public void setOferta(double descuento, String[] biblioteca) {
        this.biblioteca = biblioteca;
        this.descuento = descuento;
    }

    public String[] getOferta() {
        return this.biblioteca;
    }

    public double getDescuento() {
        return this.descuento;
    }

    public String precioFinal (String autor, String titulo) {
        return "PrecioFinal(" + autor + ", " + titulo + "): " + super.getPrecioFinal(autor, titulo);
    }

    @Override
    public void addLibro(String autor, String titulo, double precioBase) {
        int index = buscarAutorOferta(autor);

        if (index >= 0) {
            anyadirLibro(new LibroOferta(autor, titulo, precioBase, descuento));
        } else {
            anyadirLibro(new Libro(autor, titulo, precioBase));
        }
    }

    @Override
    public String toString() {
        return descuento + "%" + Arrays.toString(biblioteca) + super.toString();
    }

    private int buscarAutorOferta(String autor) {
        int x = -1;

        for (int i = 0; i < biblioteca.length; i++) {
            if(biblioteca[i].equalsIgnoreCase(autor)){
                x = i;
            }
        }

        return x;
    }

}