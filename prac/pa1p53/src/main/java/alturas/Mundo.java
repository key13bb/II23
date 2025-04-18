package alturas;

import java.io.IOException;
import java.nio.file.Path;
import java.io.PrintWriter;
import java.util.*;

public class Mundo {

    public static <K,V> void presentaEnPW(PrintWriter pw, Map<K,V> map) {
        for (Map.Entry<K,V> e : map.entrySet()) {
            pw.println(e.getKey() + "\t" + e.getValue());
        }
    }

    public static <K,V> void presentaEnConsola(Map<K,V> map) {
        presentaEnPW(new PrintWriter(System.out,true),map);
    }

    private List<Pais> paises;

    public Mundo() {
        paises = new LinkedList<>();
    }

    public List<Pais> getPaises() {
        return paises;
    }

    public void cargar(String fich) throws IOException {
        paises.clear();
        try (Scanner sc = new Scanner(Path.of(fich))){
            while (sc.hasNextLine())  {
                String linea = sc.nextLine();
                cargarLinea(linea);
            }
        }
    }

    private void cargarLinea(String linea) {
        try (Scanner scPais  = new Scanner(linea)) {
            scPais.useDelimiter("\\s*,\\s*");
            scPais.useLocale(Locale.ENGLISH);
            Pais pais = new Pais(scPais.next(), scPais.next(), scPais.nextDouble());
            paises.add(pais);
        } catch (NoSuchElementException e) {
        }
    }

    public Map<String, Integer> numeroDePaisesPorContinente() {
        Map<String, Integer> map = new TreeMap<>();
        for (Pais pais : paises) {
            String continente = pais.getContinente();
            int np = map.getOrDefault(continente,0);
            map.put(continente, np+1);
        }
        return map;
    }

    public Map<Double, List<Pais>> paisesPorAltura() {
        Map<Double, List<Pais>> map = new TreeMap<>();
        for (Pais pais : paises) {
            double altura = pais.getAltura();
            double altura1Dec = (int)(altura*10)/10.0;

            List<Pais> list = map.get(altura1Dec);
            if (list == null) {
                list = new ArrayList<>();
                map.put(altura1Dec, list);
            }
            list.add(pais);
        }
        return map;
    }

    public SortedMap<String, SortedSet<Pais>> paisesPorContinente() {
        SortedMap<String, SortedSet<Pais>> map = new TreeMap<>();
        for (Pais pais : paises) {
            String continente = pais.getContinente();
            SortedSet<Pais> set = map.get(continente);
            if (set == null) {
                set = new TreeSet<>();
                map.put(continente, set);
            }
            set.add(pais);
        }
        return map;
    }

    public SortedMap<Character, SortedSet<Pais>> paisesPorInicial() {
        SortedMap<Character, SortedSet<Pais>> map = new TreeMap<>();
        for (Pais pais : paises) {
            char inicial = pais.getNombre().charAt(0);
            SortedSet<Pais> set = map.get(inicial);
            if (set == null) {
                set = new TreeSet<>();
                map.put(inicial, set);
            }
            set.add(pais);
        }
        return map;
    }

    public SortedMap<String, Double> mediaPorContinente() {
        SortedMap<String, SortedSet<Pais>> map =  this.paisesPorContinente();
        SortedMap<String, Double> medias = new TreeMap<>();
        for (Map.Entry<String, SortedSet<Pais>> e: map.entrySet()) {
            double suma =  0;
            if (e.getValue().size() > 0) {
                for (Pais pais: e.getValue()) {
                    suma += pais.getAltura();
                }
                suma = suma / e.getValue().size();
            }
            medias.put(e.getKey(), suma);
        }
        return medias;
    }

    public List<String> continentesConMasPaises() {
        Map<String, Integer> map = numeroDePaisesPorContinente();
        List<String> res = new LinkedList<>();
        Collection<Integer> values = map.values();
        if (values.size() > 0) {
            int maxValor = Collections.max(values);
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() == maxValor) {
                    res.add(entry.getKey());
                }
            }
        }
        return res;
    }

    public SortedSet<Pais> paisesOrdenadosPorAltura() {
        Comparator<Pais> ordenAltura = new CompAltura().thenComparing(new CompNombre());
        SortedSet<Pais> set = new TreeSet<>(ordenAltura);
        set.addAll(paises);
        return set;
    }

    public SortedMap<String, SortedSet<Pais>> paisesPorContinenteAltura() {
        SortedMap<String, SortedSet<Pais>> map = new TreeMap<>();
        for (Pais pais : paises) {
            String continente = pais.getContinente();
            SortedSet<Pais> set = map.get(continente);
            if (set == null) {
                set = new TreeSet<>(new CompAltura().thenComparing(Comparator.naturalOrder()));
                map.put(continente, set);
            }
            set.add(pais);
        }
        return map;
    }

    public SortedMap<String, SortedSet<Pais>> paisesPorContinenteAlturaDec() {
        SortedMap<String, SortedSet<Pais>> map = new TreeMap<>();
        for (Pais pais : paises) {
            String continente = pais.getContinente();
            SortedSet<Pais> set = map.get(continente);
            if (set == null) {
                set = new TreeSet<>(new CompAltura().thenComparing(new CompNombre()).reversed());
                map.put(continente, set);
            }
            set.add(pais);
        }
        return map;
    }

}