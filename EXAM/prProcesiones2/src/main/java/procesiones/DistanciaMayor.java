package procesiones;

import java.util.ArrayList;
import java.util.List;

public class DistanciaMayor implements FiltradoUbicaciones {
    int distanciaMinima;

    public DistanciaMayor(int dm) {
        this.distanciaMinima = dm;
    }

    @Override
    public List<String> seleccionar(List<Ubicacion> ubicaciones) {
        List<String> lejanas = new ArrayList<>();
        for (Ubicacion u : ubicaciones) {
            if (u.getDistancia() >= distanciaMinima) {
                lejanas.add(u.getNombre().toUpperCase());
            }
        }
        return lejanas;
    }
}
