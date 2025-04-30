package star.key13bb
package prc6

import java.util.concurrent.*
import scala.util.Random

class Cadena(n: Int) {
  // CS-empaquetador-i: espera hasta que hay productos de tipo i
  // CS-colocador: espera si hay n productos en la cadena
  private val tipo = Array.fill(3)(0) // el buffer
  private var cuentaTotal = 0
  private val esperaEnp = new Array[Semaphore](3)
  for (i <- tipo.indices) {
    esperaEnp(i) = Semaphore(1)
  }
  private val esperaCol = Semaphore(1) // CS- Colocalor
  private val mutex = Semaphore(1)
  
  def retirarProducto(p: Int): Unit = {
    esperaEnp(p).acquire()
    mutex.acquire()
    tipo(p) -= 1
    log(s"Empaquetador $p retira un producto. Quedan ${tipo.mkString("[",",","]")}")
    cuentaTotal += 1
    if (tipo(p) > 0) esperaEnp(p).release()
    if (tipo.sum == n-1) esperaCol.release()
    mutex.release()
  }
  
  def nuevoProducto(p:Int): Unit = {
    esperaCol.acquire()
    mutex.acquire()
    tipo(p) += 1
    log(s"Colocador pone un producto $p. Quedan ${tipo.mkString("[",",","]")}")
    log(s"Total de productos empaquetados $cuentaTotal")
    if (tipo(p) == 1) esperaEnp(p).release()
    if (tipo.sum() < n) esperaCol.release()
    mutex.release()
  }
}

object Ejercicio2 {
  def main(args:Array[String]): Unit = {
    val cadena = new Cadena(6)
    val empaquetador = new Array[Thread](3)
    for (i <- empaquetador.indices)
      empaquetador(i) = thread {
        while (true)
          cadena.retirarProducto(i)
          Thread.sleep(Random.nextInt(500)) // empaquetando
      }

    val colocador = thread {
      while (true)
        Thread.sleep(Random.nextInt(100)) // recogiendo el producto
        cadena.nuevoProducto(Random.nextInt(3))
    }
  }
}
