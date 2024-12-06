package libreria;

public class OfertaPrecio implements OfertaFlex {
    double porcentaje;
    double umbral;

    public OfertaPrecio(double porcentaje, double umbral) {
        this.porcentaje = porcentaje;
        this.umbral = umbral;
    }

    @Override
    public double getDescuento(Libro libro) {
        double descuento = 0;
        if (libro.getPrecioBase() >= umbral) {
            descuento = porcentaje;
        }
        return descuento;
    }

    @Override
    public String toString() {
        return porcentaje + "%(" + umbral + ")";
    }

}
