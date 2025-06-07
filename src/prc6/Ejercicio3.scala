package star.key13bb
package prc6

import java.util.concurrent.*
import scala.util.Random

object aseo {
	// CS-Cliente: Esperan si está el Equipo de Limpieza en el aseo
	// CS-EquipoLimpieza: Espera si hay clientes en el aseo
	val mutex = new Semaphore(1)
	var clientes = 0
	val aseo: Semaphore = new Semaphore(1)

	def entraCliente(id: Int): Unit = {
		mutex.acquire()
		try {
			clientes += 1
			log(s"Entra cliente $id. Hay $clientes clientes.")
			if (clientes == 1) {
				aseo.acquire()
			}
		} finally {
			mutex.release()
		}
	}

	def saleCliente(id: Int): Unit = {
		mutex.acquire()
		try {
			clientes -= 1
			log(s"Sale cliente $id. Hay $clientes clientes.")
			if (clientes == 0) {
				aseo.release()
			}
		} finally {
			mutex.release()
		}
	}

	def entraEquipoLimpieza(): Unit = {
		aseo.acquire()
		log(s"        Entra el equipo de limpieza.")
	}

	def saleEquipoLimpieza(): Unit = {
		aseo.release()
		log(s"        Sale el equipo de limpieza.")
	}
}

object Ejercicio3 {
	def main(args: Array[String]): Unit = {
		val cliente = new Array[Thread](10)
		for (i <- cliente.indices)
			cliente(i) = thread {
				while (true)
					Thread.sleep(Random.nextInt(500))
					aseo.entraCliente(i)
					Thread.sleep(Random.nextInt(50))
					aseo.saleCliente(i)
			}
		val equipoLimpieza = thread {
			while (true)
				Thread.sleep(Random.nextInt(500))
				aseo.entraEquipoLimpieza()
				Thread.sleep(Random.nextInt(100))
				aseo.saleEquipoLimpieza()
		}
	}
}
