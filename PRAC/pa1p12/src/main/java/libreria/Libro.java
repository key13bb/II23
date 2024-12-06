package libreria;

/** 
 * La clase Libro (del paquete libreria) contiene información 
 * sobre un determinado libro, tal como el nombre del autor, 
 * el título, y el precio base. Además, también posee información 
 * sobre el porcentaje de IVA que se aplica para calcular su precio final. 
 * El porcentaje de IVA a aplicar es el mismo y es compartido por
 *  todos los libros, siendo su valor inicial el 10.%0
 */
public class Libro {
	/**
	 * Variable de clase que representa el porcentaje de IVA (por defecto es el 10%)
	 */
	static private double porcIVA=10.0;
	
	/**
	 * Autor del libro
	 */
	private String autor;
	
	/**
	 * Título del libro
	 */
	private String titulo;
	
	/**
	 * Precio base imponible del libro
	 */
	private double precioBase;
	
	/**
	 * Constructor para crear un libro
	 * @param a	Autor
	 * @param t	Título
	 * @param p	Precio
	 */
	public Libro(String a, String t, double p) {
		if (p<0) throw new RuntimeException("El precio no puede ser negativo");
		autor=a;
		titulo=t;
		precioBase=p;
	}
	
	/**
	 * Devuelve el autor del libro
	 * @return	Autor del libro
	 */
	public String getAutor() {
		return autor;
	}
	
	/**
	 * Devuelve el título del libro
	 * @return	Título del libro
	 */
	public String getTitulo(){
		return titulo;
	}
	
	/**
	 * Devuelve el precio base del libro
	 * @return	Base imponible del libro
	 */
	protected double getBaseImponible(){
		return precioBase;
	}
	
	/**
	 * Devuelve el precio base del libro
	 * @return	Base imponible del libro
	 */
	public double getPrecioBase(){
		return precioBase;
	}
	
	/**
	 * Método de clase para obtener el IVA
	 * @return	Porcentaje de IVA
	 */
	static public double getIVA(){
		return porcIVA;
	}
	
	/**
	 * Método de clase para cambiar el IVA
	 * @param iva	Nuevo IVA	
	 */
	static public void setIVA(double iva){
		porcIVA = iva;
	}
	
	/**
	 * Devuelve el precio total, tras aplicar el IVA a la base imponible
	 * @return	Precio total del libro
	 */
	public double getPrecioFinal(){
		return getBaseImponible()+getBaseImponible()*(porcIVA/100);
	}
	
	/**
	 * Dos libros son iguales cuando sus autores y sus títulos coinciden (independientemtne de mayúsculas y minúsculas),
	 * sin tener en cuenta los precios base.
	 */
	public boolean equals(Object obj) {
		boolean esLibro = obj instanceof Libro;
		Libro libro = esLibro ? (Libro) obj : null;
		return esLibro && autor.equalsIgnoreCase(libro.autor) && titulo.equalsIgnoreCase(libro.titulo);
	}
	
	/**
	 * Redefinición de hashCode acorde a la redefinición de equals.
	 */
	public int hashCode() {
		return autor.toUpperCase().hashCode() + titulo.toUpperCase().hashCode();
	}
	
	/** 
	 * Representación textual de un libro:
	 * 		(autor; título; precioBase; porcIVA%; precioFinal)
	 */
	public String toString(){
		return "("+autor+"; "+titulo+"; "+precioBase+"; "+porcIVA+"%; "+ getPrecioFinal() +")";
	}
	
}
