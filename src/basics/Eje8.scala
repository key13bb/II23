package star.key13bb
package basics

import scala.annotation.tailrec

object Eje8:

	@tailrec
	def gira(lista: List[Int], n: Int): List[Int] =
		if (n == 0) lista
		else gira(lista.tail :+ lista.head, n - 1) // Añade el primer elemento al final de la lista
