import datos.Datos;
import datos.DatosException;

import java.util.Arrays;

public class PruebaDatos {
	public static void main(String[] args) {
		try {
			double min = Double.parseDouble(args[0]);
			double max = Double.parseDouble(args[1]);
			Datos datos = new Datos(Arrays.copyOfRange(args, 2, args.length), min, max);
			System.out.println(datos);
			try {
				datos.setRango("0;4");
				System.out.println(datos);
				datos.setRango("15 25");
				System.out.println(datos);
			} catch (DatosException datosException) {
				System.err.println(datosException.getMessage());
			}
		} catch (ArrayIndexOutOfBoundsException exception) {
			System.out.println("Error, no hay valores suficientes");
		} catch (NumberFormatException formatException) {
			System.out.println("Error, al convertir un valor a número real (" + formatException.getMessage() + ")");
		}
	}
}
