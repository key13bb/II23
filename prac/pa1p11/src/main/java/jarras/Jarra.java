package jarras;

public class Jarra {
    private final int capacidad;
    private int contenido;

    public Jarra(int capacidad) {
        if(capacidad <= 0){
            throw new RuntimeException("E: No puedes crear jarras con capacidad negativa.");
        }
        this.capacidad = capacidad;
        this.contenido = 0;
    }

    public int capacidad() {
        return capacidad;
    }

    public int contenido() {
        return contenido;
    }

    public String toString() {
        return "J(" + capacidad() + ", " + contenido() + ")";
    }

    public void llena() {
        contenido = capacidad;
    }

    public void vacia() {
        contenido = 0;
    }

    public void llenaDesde(Jarra jarra) {
        if ((capacidad - contenido) < jarra.contenido) {
            jarra.contenido -= (capacidad - contenido);
            contenido = capacidad;
        } else {
            contenido += jarra.contenido;
            jarra.contenido = 0;
        }
    }
}
