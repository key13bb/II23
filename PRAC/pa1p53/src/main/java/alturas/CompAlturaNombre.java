package alturas;

import java.util.Comparator;

public class CompAlturaNombre implements Comparator<Pais> {
    public int compare(Pais p1, Pais p2) {
        int res = Double.compare(p1.getAltura(), p2.getAltura());
        if (res == 0) {
            res = p1.getNombre().compareToIgnoreCase(p2.getNombre());
        }
        return res;
    }
}