package notas;

import java.util.Objects;

public class Estudiante {
    private String dni;
    private String nombre;
    private double calificacion = 0;
    public Estudiante(String dni, String nombre, double calificacion) throws EstudianteException {
        this.dni = dni;
        this.nombre = nombre;
        if (calificacion < 0) {
            throw new EstudianteException("Calificacion negativa");
        } else {
            this.calificacion = calificacion;
        }
    }
    public Estudiante(String dni, String nombre) throws EstudianteException {
        this.dni = dni;
        this.nombre = nombre;
    }
    public String getDni() {
        return dni;
    }
    public String getNombre() {
        return nombre;
    }
    public double getCalificacion() {
        return calificacion;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Estudiante est)
                && est.nombre.equals(nombre)
                && est.dni.equalsIgnoreCase(dni);
    }
    @Override
    public int hashCode() {
        return Objects.hash(dni.toLowerCase(), nombre);
    }
    @Override
    public String toString() {
        return getNombre() + " ( " + getDni() + " ) ";
    }
}


























