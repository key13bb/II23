package libreria;

public class LibroOferta extends Libro {
    private final double oferta;

    public LibroOferta(String autor, String titulo, double precioBase, double oferta) {
        super(autor, titulo, precioBase);
        this.oferta = oferta;
    }

    public double getDescuento() {
        return oferta;
    }

    protected double getBaseImponible() {
        return (getPrecioBase() - (getPrecioBase()*getDescuento())/100);
    }

    public String toString() {
        return "(" + getAutor() + "; " + getTitulo() + "; " + getPrecioBase() + "; " + getDescuento() + " % ; " + getBaseImponible() + "; " + getIVA() + " % ; " + getPrecioFinal() + ")";
    }
}