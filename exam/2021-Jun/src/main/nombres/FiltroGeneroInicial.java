package main.nombres;

public class FiltroGeneroInicial implements Filtro {
    char genero;
    char inicial;
    public FiltroGeneroInicial(char genero, char inicial) {
        this.genero = genero;
        this.inicial = inicial;
    }

    @Override
    public boolean criterio(Nombre n) {
        boolean coincide = false;
        if (n.getGenero() == this.genero &&
            n.getNombre().startsWith(String.valueOf(this.inicial),1)) {
            coincide = true;
        }
        return coincide;
    }
}
