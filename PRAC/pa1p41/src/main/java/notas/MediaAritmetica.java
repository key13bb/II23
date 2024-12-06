package notas;

import java.util.List;

public class MediaAritmetica implements CalculoMedia{
    @Override
    public double calcula(List<Estudiante> estudiantes) throws EstudianteException {
        if (estudiantes.isEmpty()) {
            throw new EstudianteException("No hay estudiantes");
        }
        double suma = 0;
        for (Estudiante est : estudiantes) {
            suma = suma + est.getCalificacion();
        }
        return suma/estudiantes.size();
    }
}
