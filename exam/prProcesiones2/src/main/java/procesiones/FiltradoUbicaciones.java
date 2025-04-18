package procesiones;

import java.util.List;

public interface FiltradoUbicaciones {
    List<String> seleccionar(List<Ubicacion> ubicaciones);
}
