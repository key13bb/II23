package practicas.practica1;

public class KesimoElemento {

	public static int buscarKesimo(int[] a, int k) {
		return buscarKesimo(a, k, 0, a.length - 1);
	}

	private static int buscarKesimo(int[] v, int k, int ini, int fin) {
		if (ini < fin) {
			int p = partir(v, ini, fin);
			if (k < p) return buscarKesimo(v, k, ini, p-1);
			else if (k > p) return buscarKesimo(v, k, p+1, fin);
			// else el elemento ya se ha encontrado y se devuelve el valor
		}
		return v[k];
	}

	private static int partir(int[] v, int ini, int fin) {
		int pivote = v[ini];
		int i = ini+1;
		int j = fin;

		do {
			while ((i<=j) && (v[i] <= pivote)) i++;
			while ((i<=j) && (v[j] > pivote)) j--;
			if (i<j) intercambiar(v, i, j);
		} while (i <= j);

		intercambiar(v, ini, j);
		return j;
	}

	private static void intercambiar(int[] v, int a, int b) {
		int aux = v[a];
		v[a] = v[b];
		v[b] = aux;
	}

}
