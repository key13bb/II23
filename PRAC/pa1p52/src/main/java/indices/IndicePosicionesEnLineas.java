package indices;

import java.io.PrintWriter;
import java.util.*;

public class IndicePosicionesEnLineas extends IndiceAbstracto {

    protected SortedMap<String, SortedMap<Integer, SortedSet<Integer>>> indice;

    public IndicePosicionesEnLineas() {
        super();
        indice = new TreeMap<>();
    }

    @Override
    public void resolver(String delimitadores) {
        indice.clear();
        int lineaIndex = 0;
        for (String linea : texto) {
            lineaIndex ++;
            try (Scanner sc = new Scanner(linea)) {
                sc.useDelimiter(delimitadores);
                int posIndex = 0;
                while (sc.hasNext()) {
                    posIndex++;
                    agregarPalabra(sc.next(), lineaIndex, posIndex);
                }
            }
        }
    }

    private void agregarPalabra(String palabra, int linea, int pos) {
        if (!palabra.isEmpty()) {
            String clave = palabra.toLowerCase();
            if (!indice.containsKey(clave)) {  //Si no contiene clave, se crea una vacía y se repite el bucle
                indice.put(clave, new TreeMap<>());
                agregarPalabra(palabra, linea, pos);
            } else if (!indice.get(clave).containsKey(linea)) { //Si contiene la clave pero no contiene ninguna linea, se crea una línea vacía y se repite el bucle
                indice.get(clave).put(linea, new TreeSet<>());
                agregarPalabra(palabra, linea, pos);
            } else { //Si contiene la clave y la línea, pero no la posición, se añade.
                indice.get(clave).get(linea).add(pos);
            }
        }
    }

    @Override
    public void presentarIndice(PrintWriter pw) {
        for (String palabra : indice.keySet()) {
            pw.println(palabra);
            for (Integer n : indice.get(palabra).keySet()) {
                StringJoiner sj = new StringJoiner(",", "<", ">");
                for (Integer m : indice.get(palabra).get(n)) {
                    sj.add(Integer.toString(m));
                }
                pw.printf("%12d %s%n", n, sj);
            }
        }
    }
}
