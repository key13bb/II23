package alturas;

import java.util.Comparator;

public class CompNombre implements Comparator<Pais> {
    public int compare(Pais p1, Pais p2) {
        return p1.getNombre().compareToIgnoreCase(p2.getNombre());
    }
}