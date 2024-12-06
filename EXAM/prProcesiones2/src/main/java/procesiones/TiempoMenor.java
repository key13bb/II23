package procesiones;

import java.util.ArrayList;
import java.util.List;

public class TiempoMenor implements FiltradoUbicaciones {

    int tiempoMenor;
    public TiempoMenor (int tm) {
        this.tiempoMenor = tm;
    }

    @Override
    public List<String> seleccionar(List<Ubicacion> ubicaciones) {
        List<String> lejanas = new ArrayList<>();
        for (Ubicacion u : ubicaciones) {
            if (u.getDistancia() <= tiempoMenor) {
                lejanas.add(u.getNombre().toUpperCase());
            }
        }
        return lejanas;
    }
}
