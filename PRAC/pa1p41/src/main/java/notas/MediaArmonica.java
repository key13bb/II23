package notas;

import java.util.ArrayList;
import java.util.List;

public class MediaArmonica implements CalculoMedia{
    @Override
    public double calcula(List<Estudiante> estudiantes) throws EstudianteException {
        if (estudiantes.isEmpty()) {
            throw new EstudianteException("No hay estudiantes");
        }
        List<Estudiante> aprobado = new ArrayList<>();
        int k = 0;
        for (Estudiante est : estudiantes) {
            if (est.getCalificacion() > 0) {
                aprobado.add(est);
                k++;
            }
        }
        if (k == 0) {
            throw new EstudianteException("No hay estudiantes");
        } else {
            double suma = 0;
            for (Estudiante ap : aprobado) {
                suma = suma + 1 / ap.getCalificacion();
            }
            return k / suma;
        }
    }
}
