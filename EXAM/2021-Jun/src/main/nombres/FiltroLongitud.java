package main.nombres;

public class FiltroLongitud implements Filtro {
    int longitud;
    public FiltroLongitud(int longitud) {
        this.longitud = longitud;
    }

    @Override
    public boolean criterio(Nombre n) {
        return n.getNombre().length() == longitud;
    }
}
