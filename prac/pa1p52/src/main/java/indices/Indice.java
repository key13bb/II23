package indices;

import java.io.PrintWriter;

public interface Indice {
    void agregarFrase(String frase);
    void resolver(String delimitadores);
    void presentarIndice(PrintWriter pw);
    default void presentarIndiceConsola() {
        try (PrintWriter pw = new PrintWriter(System.out, true)){
            presentarIndice(pw);
        }
    }
}
