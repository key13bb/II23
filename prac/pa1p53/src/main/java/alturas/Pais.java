package alturas;

import java.util.Objects;

public class Pais implements Comparable<Pais> {
    private String nombre;
    private String continente;
    private double altura;

    public Pais(String nombre, String continente, double altura) {
        this.nombre = nombre;
        this.continente = continente;
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContinente() {
        return continente;
    }

    public double getAltura() {
        return altura;
    }

    @Override
    public boolean equals(Object o) {
        boolean ok = false;
        if (o instanceof Pais) {
            Pais other = (Pais)o;
            ok = this.getNombre().equals(other.getNombre());
        }
        return ok;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getNombre());
    }

    @Override
    public int compareTo(Pais p) {
        return this.getNombre().compareTo(p.getNombre());
    }

    @Override
    public String toString() {
        return "Pais(" + getNombre() + ", " + getContinente() + ", "  + getAltura() + ")";
    }
}