package star.key13bb
package prc6

import java.util.concurrent.*
import scala.util.Random

class Coche(C: Int) extends Thread {
	// CS-pasajero1: si el coche está lleno, un pasajero no puede subir al coche hasta que haya terminado
	// el viaje y se hayan bajado los pasajeros de la vuelta actual
	// CS-pasajero2: un pasajero que está en el coche no puede bajarse hasta que haya terminado el viaje
	// CS-coche: el coche espera a que se hayan subido C pasajeros para dar una vuelta
	private var numPas = 0
	// ...

	def nuevoPaseo(id: Int): Unit = {
		// el pasajero id quiere dar un paseo en la montaña rusa
		// ...
		log(s"El pasajero $id se sube al coche. Hay $numPas pasajeros.")
		// ...
		log(s"El pasajero $id se baja del coche. Hay $numPas pasajeros.")
		// ...
	}

	private def esperaLleno(): Unit = {
		// el coche espera a que se llene para dar un paseo
		// ...
		log(s"        Coche lleno!!! empieza el viaje....")
		// ...
	}

	private def finViaje(): Unit = {
		// el coche indica que se ha terminado el viaje
		// ...
		log(s"        Fin del viaje... :-(")
		// ...
	}

	override def run(): Unit = {
		while (true) {
			esperaLleno()
			Thread.sleep(Random.nextInt(Random.nextInt(500))) // el coche da una vuelta
			finViaje()
		}
	}
}

object Ejercicio4 {
	def main(args: Array[String]): Unit =

		val coche = new Coche(5)
		val pasajero = new Array[Thread](12)
		coche.start()
		for (i <- pasajero.indices)
			pasajero(i) = thread {
				while (true)
					Thread.sleep(Random.nextInt(500)) // el pasajero se da una vuelta por el parque
					coche.nuevoPaseo(i)
			}
}
