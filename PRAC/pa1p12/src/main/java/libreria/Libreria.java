package libreria;

import java.util.ArrayList;
import java.util.List;

/**
 * La clase Libreria (del paquete libreria) almacena múltiples 
 * instancias de la clase Libro en una lista.
 */
public class Libreria {	
	/**
	 * Lista que almacena los libros de la librería
	 */
	private List<Libro> libros;
	
	/** 
	 * Constructor sin argumentos que crea una librería con capacidad
	 * inicial, la que indica por defecto (8).
	 */
	public Libreria() {
		libros = new ArrayList<>();
	}
	
	/**
	 * Método que añade un libro a la librería con los datos (autor, título y precio)
	 * indicados en los argumentos. 
	 * Se invoca el método protegido anyadirLibro.
	 * @param a	Autor
	 * @param t	Título
	 * @param p	Precio
	 */
	public void addLibro(String a, String t, double p) {
		Libro lib=new Libro(a, t, p);
		anyadirLibro(lib);
	}
	
	/**
	 * Elimina de la lista el libro con autor y título dados por los argumentos.
	 * Si no existe el libro se lanza una excepción RuntimeException.
	 * @param a	Autor
	 * @param t	Título
	 */
	public void remLibro(String a, String t) {
		int pos = buscarLibro(a, t);
		if (pos == -1) 
			throw new RuntimeException("Libro no encontrado (" + a + ", " + t + ")");
		libros.remove(pos);
	}
	
	/**
	 * Devuelve el precio final del libro correspondiente al autor y título
	 * pasados como parámetros. Si el libro no existe en la librería,
	 * enconces se lanza una excepción RuntimeException.
	 * @param a	Autor	
	 * @param t Título
	 * @return	Precio base del libro
	 */
	public double getPrecioFinal(String a, String t) {
		int pos = buscarLibro(a,t);
		if (pos == -1) 
			throw new RuntimeException("Libro no encontrado (" + a + ", " + t + ")");
		return libros.get(pos).getPrecioFinal();
	}
	
	/**
	 * Representacion textual de una librería, dada por una secuencia separada por comas
	 * y encerrada entre corchetes, donde cada elemento es el libro que corresponda.
	 */
	public String toString() {
		return libros.toString();
	}
	
	/**
	 * Método protegido que añade a la lista el libro pasado como argumento
	 * si este no está, y que lo sustituye si ya está. 
	 * @param l	Libro a añadir a la lista
	 */
	protected void anyadirLibro(Libro l) {
		int pos = buscarLibro(l.getAutor(), l.getTitulo());
		if (pos >= 0) { // Si el libro ya estaba, se sustituye por el nuevo (el precio puede haber cambiado)
			libros.set(pos, l);
		} else { // Es necesario añadir el libro
			libros.add(l);
		}
	}

	/**
	 * Método auxiliar (privado) que devuelve la posición de la lista
	 * en la que se encuentra el libro con autor y título dados como
	 * argumentos. En caso de no existir ningún libro con ese título
	 * y autor, se devuelve -1.
	 * @param a	Autor del libro buscado
	 * @param t	Título del libro buscado
	 * @return	Posición que ocupa el libro en el array
	 */
	private int buscarLibro(String a, String t) {
		boolean encontrado = false;
		int i=0;
		while(! encontrado  && i < libros.size()) {
			Libro libro = libros.get(i);
			encontrado  = libro.getAutor().equalsIgnoreCase(a)
										&& libro.getTitulo().equalsIgnoreCase(t);
			i++;
		}
		return encontrado ? i-1 : -1;
	}
}
