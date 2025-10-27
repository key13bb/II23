package practicas.practica1;

public class ProblemaInversiones {
	
	public static int numInversiones(int[] v) {
		return numInv(v,0,v.length-1);
	}

	private static int numInv(int[] a, int prim, int ult) {
		int inversiones = 0;
		if (prim < ult) {
			int medio = (prim + ult) / 2;
			inversiones += numInv(a, prim, medio);
			inversiones += numInv(a, medio+1, ult);
			inversiones += mezclar(a, prim, medio, ult);
		}
		return inversiones;
	}

	private static int mezclar(int[] a, int prim, int medio, int ult) {
		int inversiones = 0;
		int i = prim;
		int j = medio + 1;
		int tam = ult - prim + 1; // Hay que añadir el indice 0
		int[] b = new int[tam];
		int k = 0;

		while (i <= medio && j <= ult) {
			if (a[i] > a[j]) {
				b[k++] = a[j++];
				inversiones += medio - i + 1;
			} else {
				b[k++] = a[i++];
			}
		}

		while (i <= medio) b[k++] = a[i++];
		while (j <= ult) b[k++] = a[j++];

		i = prim;
		k = 0;
		while (k < tam) {
			a[i++] = b[k++];
		}
		return inversiones;
	}
}
