package main.nombres;

import java.util.Objects;

public class Nombre {
    String nombre;
    char genero;

    public Nombre(String nombre, char genero) throws RegistroCivilException {
        switch (genero) {
            case 'f', 'F' -> genero = 'F';
            case 'm', 'M' -> genero = 'M';
            default -> throw new RegistroCivilException("Sólo se puede poner 'F' o 'M' como género");
        }
        if (nombre.isEmpty() || nombre.isBlank()) { throw new RegistroCivilException("El nombre no puede estar vacío ni tomar el valor null"); }
        else { this.nombre = nombre; }
   }

    public char getGenero() {
        return genero;
    }
    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Nombre nombre0) &&
                nombre0.nombre.equalsIgnoreCase(nombre) &&
                nombre0.genero == genero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, genero);
    }

    public int compareTo(Nombre comparacion) {
        int result = nombre.compareToIgnoreCase(comparacion.nombre);
        if (result == 0) {
            result = Character.compare(genero,comparacion.genero);
        }
        return result;
    }

    @Override
    public String toString() {
        return "(" + nombre + ", " + genero + ")";
    }
}