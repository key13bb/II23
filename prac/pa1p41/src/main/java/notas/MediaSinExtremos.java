package notas;

import java.util.ArrayList;
import java.util.List;

public class MediaSinExtremos implements CalculoMedia{
    private double min;
    private double max;
    public MediaSinExtremos(double n, double x) {
        this.min = n;
        this.max = x;
    }
    public double getMin() {
        return min;
    }
    public void setMin(double valor) {
    }
    public double getMax() {
        return max;
    }
    public void setMax(double valor) {
    }
    @Override
    public double calcula(List<Estudiante> estudiantes) throws EstudianteException {
        if (estudiantes.isEmpty()) {
            throw new EstudianteException("No hay estudiantes");
        }
        List<Estudiante> comprendido = new ArrayList<>();
        int k = 0;
        for (Estudiante est : estudiantes) {
            if (est.getCalificacion() >= min && est.getCalificacion() <= max) {
                comprendido.add(est);
                k++;
            }
        }
        if (k == 0) {
            throw new EstudianteException("No hay estudiantes");
        } else {
            double suma = 0;
            for (Estudiante cmp : comprendido) {
                suma = suma + cmp.getCalificacion();
            }
            return suma/k;
        }
    }
}
