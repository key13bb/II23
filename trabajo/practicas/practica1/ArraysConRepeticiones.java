package practicas.practica1;

public class ArraysConRepeticiones {

	//Precondición: hay un elemento repetido=> v.length >= 2
	public static int encuentraElem(int [] v) {
		return encuentraElem(v,0,v.length-1);
	}

	private static int encuentraElem(int[] v, int izq, int der) {
		int medio = (izq + der) / 2;
		if (izq == der) return v[izq];
		else if (v[der] - v[medio] < der - medio)  return encuentraElem(v, medio+1, der);
		else /*if (v[medio] - v[izq] < medio - izq) */ return encuentraElem(v, izq, medio);
	}
}
