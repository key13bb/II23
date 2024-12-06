package jarras;
public class Mesa {
    public enum Posicion {Izquierda, Derecha}

    private final Jarra jarraIz, jarraDr;

    public Mesa(Jarra jarraIz, Jarra jarraDr) {
        if(jarraDr==jarraIz) { throw new RuntimeException("Las jarras son iguales"); }
        this.jarraIz = jarraIz;
        this.jarraDr = jarraDr;
    }

    public Mesa(int capIz, int capDr) {
        new Mesa(jarraIz = new Jarra(capIz),jarraDr = new Jarra(capDr));
    }
    public int capacidad(Posicion pos) {
        return switch (pos) {
            case Izquierda -> jarraIz.capacidad();
            case Derecha -> jarraDr.capacidad();
        };
    }
    public int contenido(Posicion pos) {
        return switch (pos) {
            case Izquierda -> jarraIz.contenido();
            case Derecha -> jarraDr.contenido();
        };
    }
    public void llena(Posicion pos) {
        switch (pos) {
            case Izquierda -> jarraIz.llena();
            case Derecha -> jarraDr.llena();
        }
    }
    public void vacia(Posicion pos) {
        switch (pos) {
            case Izquierda -> jarraIz.vacia();
            case Derecha -> jarraDr.vacia();
        }
    }
    public void llenaDesde(Posicion pos) {
        switch (pos) {
            case Izquierda -> jarraDr.llenaDesde(jarraIz);
            case Derecha -> jarraIz.llenaDesde(jarraDr);
        }
    }
    public String toString() {
        return "M(J(" + jarraIz.capacidad() + ", " + jarraIz.contenido() + "), J(" + jarraDr.capacidad() + ", " + jarraDr.contenido() + "))";
    }
}
