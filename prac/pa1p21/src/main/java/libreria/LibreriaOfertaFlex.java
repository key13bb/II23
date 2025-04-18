package libreria;

public class LibreriaOfertaFlex extends Libreria {
    private OfertaAutor oferta;

    public LibreriaOfertaFlex(OfertaAutor oferta){
        this.oferta = oferta;
    }

    public void setOferta(OfertaAutor nuevaOferta) {
        this.oferta = nuevaOferta;
    }

    public OfertaAutor getOferta(){
        return this.oferta;
    }

    @Override
    public void addLibro(String autor, String titulo, double precioBase) {
        Libro libro = new Libro(autor, titulo, precioBase);

        if (oferta.getDescuento(libro) > 0) {
            anyadirLibro(new LibroOferta(autor, titulo, precioBase, oferta.getDescuento(libro)));
        } else {
            anyadirLibro(new Libro(autor, titulo, precioBase));
        }
    }

    @Override
    public String toString() {
        return oferta.toString() + super.toString();
    }

    public String showPrecioFinal(String autor, String titulo) {
        return "PrecioFinal(" + autor + ", " + titulo + "): " + super.getPrecioFinal(autor, titulo);
    }

}
