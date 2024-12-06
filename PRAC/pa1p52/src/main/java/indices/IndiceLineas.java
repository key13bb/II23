package indices;

import java.io.PrintWriter;
import java.util.*;

public class IndiceLineas extends IndiceAbstracto {

    protected SortedMap<String, SortedSet<Integer>> indice;

    public IndiceLineas() {
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
                while (sc.hasNext()) {
                    agregarPalabra(sc.next(), lineaIndex);
                }
            }
        }
    }

    private void agregarPalabra(String palabra, int linea) {
        if (!palabra.isEmpty()) {
            String clave = palabra.toLowerCase();
            if (indice.containsKey(clave)) {
                indice.get(clave).add(linea);
            } else {
                indice.put(clave, new TreeSet<>());
                agregarPalabra(palabra, linea);
            }
        }
    }

    @Override
    public void presentarIndice(PrintWriter pw) {
        for (Map.Entry<String, SortedSet<Integer>> e : indice.entrySet()) {
            pw.println(e.getKey() + "\t");
            StringJoiner joiner = new StringJoiner(", ", "<", ">");
            for (Integer i : e.getValue()) {
                joiner.add(i.toString());
            }
            pw.print(joiner);
        }
    }
}



























