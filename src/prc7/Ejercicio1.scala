package star.key13bb
package prc7

import java.util.concurrent.locks.ReentrantLock
import scala.util.Random

class Buffer(ncons: Int, tam: Int) {
	//ncons-número de consumidores
	//tam-tamaño del buffer
	private val buffer = new Array[Int](tam)
	private val slots = new Array.fill(tam)(Array.fill(ncons)(true))
	private val lock = new ReentrantLock()
	private val canProduce = lock.newCondition()
	private val canConsume = lock.newCondition()
	private var wIndex = 0;


	def nuevoDato(dato: Int): Unit = {
		lock.lock()
		try {
			while (!slots(wIndex).forAll(done => done)) {
				canProduce.await()
			}
			buffer(wIndex) = dato
			log(s"Productor almacena $dato: buffer=${buffer.mkString("[", ",", "]")}}")
			for (i <- slots(wIndex).indices) {
				slots(wIndex)(i) = false
			}
			wIndex = (wIndex+1) % tam
			canConsume.signalAll()
		} finally {
			lock.unlock()
		}
	}

	def extraerDato(id: Int): Int = {
		lock.lock()
		try
		log(s"Consumidor $id lee : buffer=${buffer.mkString("[", ",", "]")}")
		0
	}
}

object Ejercicio1 {

	def main(args: Array[String]): Unit = {
		val ncons = 4
		val tam = 3
		val nIter = 10
		val buffer = new Buffer(ncons, tam)
		val consumidor = new Array[Thread](ncons)
		for (i <- consumidor.indices)
			consumidor(i) = thread {
				for (j <- 0 until nIter)
					val dato = buffer.extraerDato(i)
					Thread.sleep(Random.nextInt(200))
			}
		val productor = thread {
			for (i <- 0 until nIter)
				Thread.sleep(Random.nextInt(50))
				buffer.nuevoDato(i + 1)
		}
	}
}
