package practicas.practica2;

import java.util.Arrays;

public class MainCambioMonedasLimitadas {
	public static void main (String [] args) {
		//Creamos la instancia del problema
		int m = 80;
		int [] d = {6,1,4};
		int [] q = {10,10,10};
		CambioMonedasLimitadas p = new CambioMonedasLimitadas(m,d,q);
		int numeroMinimoMonedas = p.resolverBottomUp();
		p.mostrarDatos();
		System.out.println("Solución: " + Arrays.toString(p.reconstruirSol()));
		System.out.println("Número de monedas: " + numeroMinimoMonedas);
	}
}
