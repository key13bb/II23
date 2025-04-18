import notas.Asignatura;
import notas.Estudiante;
import notas.EstudianteException;

import java.util.List;

public class PruebaAsignatura {
    public static void main(String[] args) {
        try {
            String s1 = "12455666F;Lopez Perez, Pedro;6.7";
            String s2 = "33678999D;Merlo Gomez, Isabel;5.8";
            String s3 = "23555875G;Martinez Herrera, Lucia;9.1";
            String[] ests = {s1, s2, s3};
            Asignatura asgn = new Asignatura("PA1", ests);
            double media = asgn.getMedia();
            System.out.println("Media de calificaciones: " + media);
            List<Estudiante> est = asgn.getEstudiantes();
            for (Estudiante estd : est) {
                System.out.println(estd.getDni());
            }
            try {
                Estudiante e1 = new Estudiante("12455666F", "Lopez Lopez, Pedro",
                        6.7);
                System.out.println("Nombre: " + e1.getNombre() +
                        " Nota: " + asgn.getCalificacion(e1));
            } catch (EstudianteException e) {
                System.out.println("Error: "+e.getMessage());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}