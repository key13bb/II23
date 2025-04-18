package procesiones;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Procesion {
    private String cofradia;
    private List<Ubicacion> itinerario = new ArrayList<>();

    public Procesion(String cof, String salida) {
        this.cofradia = cof;
        Ubicacion ubic = new Ubicacion(salida);
        itinerario.add(ubic);
    }

    public String getCofradia() { return cofradia; }

    public void agregarUbicacion(String infoUbicacion) {
        String[] splited = infoUbicacion.split("#");

        int minutos = 0;
        try {
            minutos = Integer.parseInt(splited[1]);
        } catch (Exception e) {/* Bruh */}

        if (splited.length <3) {
            throw new ProcesionesException("Formato incorrecto (faltan datos): " + infoUbicacion);
        } else if (minutos == 0) {
            throw new ProcesionesException("Formato incorrecto (dato no numérico): " + infoUbicacion);
        } else if ((Integer.parseInt(splited[1]) < 0) || (Integer.parseInt(splited[2]) < 0)) {
            throw new ProcesionesException("Formato incorrecto (número negativo): " + infoUbicacion);
        } else {
            itinerario.add(new Ubicacion(splited[0], Integer.parseInt(splited[1]), Integer.parseInt(splited[2])));
        }
    }

    public List<String> ubicacionesLejanas(int distancia) {
        List<String> ubic = new ArrayList<>();
        for (Ubicacion u : itinerario) {
            if (u.getDistancia() > distancia) { ubic.add(u.getNombre()); }
        }
        return ubic;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(" -> ", cofradia + " @ { ", " }");
        for (Ubicacion u : itinerario) {
            joiner.add(u.toString());
        }
        return joiner.toString();
    }

    public List<String> seleccionarUbicaciones(FiltradoUbicaciones filtro) {
        return filtro.seleccionar(itinerario);
    }
}
