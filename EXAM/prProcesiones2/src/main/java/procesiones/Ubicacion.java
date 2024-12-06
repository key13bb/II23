package procesiones;


/**
 * Clase para representar ubicaciones de un recorrido procesional. Cada ubicación
 * incluirá información sobre el nombre de la ubicación (calle, lugar, o similar)
 * y el tiempo, en minutos, que trascurre desde la salida hasta que el desfiile
 * procesional llega a esa ubicación.
 */
public class Ubicacion {
	// Nombre de la ubicación
	private String nombre;
	
	// Tiempo en minutos que se invierte en llegar desde la salida hasta esta ubicación
	private int minutos;
	private int distancia;
	/**
	 * Constructor para crear ubicaciones a partir de su nombre, y de los minutos que
	 * se tarda en llegar desde la salida.
	 * @param nom	Nombre de la ubicación
	 * @param min	Tiempo (en minutos) desde la salida
	 */
	public Ubicacion(String nom, int min, int dist) {
		if (dist >= 0) {
			this.distancia = dist;
		} else {
			throw new ProcesionesException("La distancia no puede ser negativa");
		}
		setMinutos(min);
		nombre = nom;
	}
	
	/**
	 * Constructor para crear ubicaiones a partir de su nombre.
	 * Se supone que el tiempo desde la salida es 0.
	 * @param nom	Nombre de la ubicación.
	 */
	public Ubicacion(String nom) throws ProcesionesException {
		this(nom,0,0);
	}
	
	/**
	 * Método para obtener el nombre
	 * @return	Nombre de la ubicación
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Método para obtener los minutos desde la salida
	 * @return	Tiempo desde la salida
	 */
	public int getMinutos() {
		return minutos;
	}

	public int getDistancia() { return distancia; }

	public void setDistancia(int distancia) throws ProcesionesException {
		if (distancia >= 0) {
			this.distancia = distancia;
		} else {
			throw new ProcesionesException("La distancia no puede ser negativa");
		}
	}
	/**
	 * Método para cambiar los minutos que se tardan desde la salida.
	 * @param min	Nuevo tiempo, en minutos, para llegar a la ubicación.
	 */
	public void setMinutos(int min) {
		if (min < 0)
			throw new RuntimeException("El tiempo desde la salida debe ser positivo");
		minutos = min;
	}
	
	/**
	 * Representación textual de una ubicación dada por:
	 * 		nombre(minutos)
	 * El nombre de la ubicación seguido de los minutos entre paréntesis.
	 */
	public String toString(){
		return nombre + "(" + minutos + "', " + distancia + "m)";
	}

	@Override
	public boolean equals(Object object) {
		return object instanceof Ubicacion ubi &&
				ubi.nombre.equalsIgnoreCase(nombre);
	}

	@Override
	public int hashCode() {
		return nombre.hashCode();
	}
}
