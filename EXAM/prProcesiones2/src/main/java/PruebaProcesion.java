import procesiones.DistanciaMayor;
import procesiones.Procesion;
import procesiones.ProcesionesException;
import procesiones.TiempoMenor;

public class PruebaProcesion {

	public static void main(String[] args) {
		// Itinerario de la cofradía de los Estudiantes (sin la salida)
		String[] infoItinerario = { 
				"Mármoles#60#-100",
				"Tribuna#250#900",
				"Larios#270#1000",
				"Alameda#300#1500",
				"Molina Larios#330#1900",
				"Torre Sur#360#2100",
				"Catedral#390"
		};
		
		// Se crea una procesión con salida en "Casa Hermandad C/ Alcazabilla"
		Procesion estudiantes = new Procesion("Estudiantes", "Casa Hermandad C/ Alcazabilla");
					
		// Se agregan las ubicaciones del itinerario a la procesión 
		for(String infoUbicacion : infoItinerario) 
			try {
				estudiantes.agregarUbicacion(infoUbicacion);
			} catch (ProcesionesException pe) {
				System.err.println(pe.getMessage());
			}
		// Y se vuelca en pantalla el contenido de la procesión
		System.out.println(estudiantes);
		
		// Se muestran las ubicaciones con tiempo desde la salida menor o igual que 300 minutos
		System.out.println("Las ubicaciones con tiempo menor de 300 minutos son: ");
		System.out.println(estudiantes.seleccionarUbicaciones(new TiempoMenor(300)));
		
		// Se muestran las ubicaciones con distancia desde salida mayor o igual que 1000 metros
		System.out.println("Las ubicaciones con distancia mayor de 1000 metros son: ");
		System.out.println(estudiantes.seleccionarUbicaciones(new DistanciaMayor(1000)));
	}

	/* 
	
	SALIDA ESPERADA:
	
	Formato incorrecto (número negativo): Mármoles#60#-100
	Formato incorrecto (faltan datos): Catedral#390
	Estudiantes @ { Casa Hermandad C/ Alcazabilla(0', 0m) -> Tribuna(250', 900m) -> Larios(270', 1000m) -> Alameda(300', 1500m) -> Molina Larios(330', 1900m) -> Torre Sur(360', 2100m) }
	Las ubicaciones con tiempo menor de 300 minutos son: 
	[CASA HERMANDAD C/ ALCAZABILLA, TRIBUNA, LARIOS, ALAMEDA]
	Las ubicaciones con distancia mayor de 1000 metros son: 
	[LARIOS, ALAMEDA, MOLINA LARIOS, TORRE SUR]
	
	*/

}
