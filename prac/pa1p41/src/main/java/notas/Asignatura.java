package notas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Asignatura {
    private String nombre;
    private List<Estudiante> estudiantes;
    private List<String> errores;
    public Asignatura(String n, String[] ests) {
        estudiantes = new ArrayList<>();
        errores = new ArrayList<>();
        this.nombre = n;
        procesarEstudiantes(ests);
    }
    public double getCalificacion(Estudiante e) throws EstudianteException {
        int pos = buscarEstudiante(e);
        if (pos<0) {
            throw new EstudianteException("Estudiante " + e.getNombre() + " (" + e.getDni() + ") no se encuentra");
        } else {
            return estudiantes.get(pos).getCalificacion();
        }
    }

    public double getMedia() throws EstudianteException {
        if (estudiantes.isEmpty()) {
            throw new EstudianteException("No hay estudiantes");
        }
        double suma = 0;
        for (Estudiante e : estudiantes) {
            suma = suma + e.getCalificacion();
        }
        return suma/estudiantes.size();
    }
    public String getNombre() {
        return nombre;
    }
    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }
    public List<String> getErrores() {
        return errores;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String name = getNombre();
        sb.append(name);
        sb.append(": { ");
        sb.append(estudiantes).append(", ").append(errores);
        sb.append(" }");
        return sb.toString();
    }
    private void procesarEstudiantes(String[] ests) {
        for (String s : ests) {
            String[] partes = s.split(";");
            if (partes.length == 3) {
                String dni = partes[0];
                String nombre = partes[1];
                String notaStr = partes[2];
                try {
                    double nota = Double.parseDouble(notaStr);
                    estudiantes.add(new Estudiante(dni, nombre, nota));
                } catch (NumberFormatException e) {
                    errores.add("ERROR. Calificación no numérica: " + s);
                } catch (EstudianteException e) {
                    errores.add("ERROR. " + e.getMessage() + ": " + s);
                }
            } else {
                errores.add("ERROR. Faltan datos: " + s);
            }
        }
    }
    private void procesarEstudiantesScanner(String[] ests) {
        for (String s : ests) {
            Scanner sc = new Scanner(s);
            sc.useDelimiter(";");
            List<String> partes = new ArrayList<>();
            while (sc.hasNext()) {
                partes.add(sc.next());
            }
            if (partes.size() == 3) {
                String dni = partes.get(0);
                String nm = partes.get(1);
                String notaStr = partes.get(2);
                try {
                    double nota = Double.parseDouble(notaStr);
                    estudiantes.add(new Estudiante(dni, nm, nota));
                } catch (NumberFormatException e) {
                    errores.add("ERROR. Calificación no numérica: " + s);
                } catch (EstudianteException e) {
                    errores.add("ERROR. " + e.getMessage() + ": " + s);
                }
            } else {
                errores.add("ERROR. Faltan datos: " + s);
            }
            sc.close();
        }
    }
    private int buscarEstudiante(Estudiante est) {
        int pos = -1;
        for (int i=0; i<estudiantes.size() && pos==-1; i++) {
            if (est.getNombre().equalsIgnoreCase(estudiantes.get(i).getNombre())
                    && est.getDni().equalsIgnoreCase(estudiantes.get(i).getDni())) {
                pos = i;
            }
        }
        return pos;
    }
}