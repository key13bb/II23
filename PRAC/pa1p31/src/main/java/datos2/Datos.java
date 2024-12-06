package datos2;

import java.util.ArrayList;

public class Datos {
    double max;
    double min;
    private final ArrayList<String> errores;
    private final ArrayList<Double> datos;

    public Datos(String[] dato, double min, double max) {
        this.max = max;
        this.min = min;

        errores = new ArrayList<>();
        datos = new ArrayList<>();

        for (String index : dato) {
            try {
                datos.add(Double.parseDouble(index));
            } catch (NumberFormatException exception) {
                errores.add(index);
            }
        }
    }

    public double calcMedia() throws DatosException {
        double suma = 0;
        double elementos = 0;

        for (Double index : datos) {
            if ((index >= min) && (index <= max)) {
                suma += index;
                elementos++;
            }
        }
        if (elementos == 0) {
            throw new DatosException("No hay datos en el rango especificado");
        }
        return suma/elementos;
    }

    public double calcDesvTipica() throws DatosException {
        double desviacion = 0;
        int elementos = 0;

        for (Double index : datos) {
            if ((index >= min) && (index <= max)) {
                desviacion += Math.pow(index - calcMedia(), 2);
                elementos++;
            }
        }
        desviacion = Math.sqrt(((double) 1 /elementos)*desviacion);
        if (elementos == 0) {
            throw new DatosException("No hay datos en el rango especificado");
        }
        return desviacion;
    }

    public void setRango(String word) throws DatosException {
        String[] parts = word.split(";");
        try {
            min = Double.parseDouble(parts[0]);
            max = Double.parseDouble(parts[1]);
        } catch (Exception exception) {
            throw new DatosException("Error en los datos al establecer el rango");
        }
    }

    public ArrayList<Double> getDatos() {
        return datos;
    }

    public ArrayList<String> getErrores() {
        return errores;
    }

    @Override
    public String toString() {
        String goodReturn = "Min: " + min + ", Max: " + max + ", " + datos + ", " + errores;
        try {
            goodReturn += ", Media: " + calcMedia() + ", DesvTipica: " + calcDesvTipica();
        } catch (Exception exception) {
            goodReturn += ", Media: ERROR, DesvTipica: ERROR";
        }
        return goodReturn;
    }


}
