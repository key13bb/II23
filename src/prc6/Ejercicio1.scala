package star.key13bb
package prc6

import java.util.concurrent.*
import scala.util.Random

object mediciones {
	// CS-Sensor-i: sensor i no puede volver a medir hasta que el trabajador no ha
	// terminado de procesar las medidas anteriores
	// CS-Trabajador: no puede realizar su tarea hasta que no están las
	// tres mediciones

	var numMed = 0
	var mutex = Semaphore(1)
	var esperaSensor: Array[Semaphore] = Array[Semaphore](Semaphore(3))

	for (i <- 0 to 2) {
		esperaSensor(i) = Semaphore(0)
	}
	var esperaTrab = Semaphore(0)

	def nuevaMedicion(id: Int): Unit = {
		mutex.acquire()
		numMed += 1
		log(s"Sensor $id almacena su medición")
		if (numMed == 3) esperaTrab.release()
		mutex.release()
		esperaSensor(id).acquire()
	}

	def leerMediciones(): Unit = {
		esperaTrab.acquire()
		mutex.acquire()
		log(s"El trabajador recoge las mediciones")
		numMed = 0
		mutex.release()
	}

	def finTarea(): Unit = {
		log(s"El trabajador ha terminado sus tareas")
		esperaSensor.foreach(_.release())
	}
}

object Ejercicio1 {
	def main(args: Array[String]): Unit =
		val sensor = new Array[Thread](3)

		for (i <- sensor.indices)
			sensor(i) = thread {
				while (true)
					Thread.sleep(Random.nextInt(100)) // midiendo
					mediciones.nuevaMedicion(i)
			}

		val trabajador = thread {
			while (true)
				mediciones.leerMediciones()
				Thread.sleep(Random.nextInt(100)) // realizando la tarea
				mediciones.finTarea()
		}
}
