package indices;

import java.io.PrintWriter;
import java.util.*;

public class IndiceContador extends IndiceAbstracto {

    SortedMap<String, Integer> indice;

    public IndiceContador() {
        super();
        indice = new TreeMap<>();
    }

    @Override
    public void resolver(String delimitadores) {
        indice.clear();
        for (String linea : texto) {
            try (Scanner sc = new Scanner(linea)) {
                sc.useDelimiter(delimitadores);
                while (sc.hasNext()) {
                    agregarPalabra(sc.next());
                }
            }
        }
    }

    private void agregarPalabra(String palabra) {
        if (!palabra.isEmpty()) {
            String clave = palabra.toLowerCase();
            indice.merge(clave, 1, Integer::sum);
        }
    }

    @Override
    public void presentarIndice(PrintWriter pw) {
        for (Map.Entry<String, Integer> e : indice.entrySet()) {
            pw.println(e.getKey() + "\t" + e.getValue());
        }
    }
}





















