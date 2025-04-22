package star.key13bb
package basics

import scala.annotation.tailrec

object Eje9:

	def mezclarOrdenado(lista1: List[Int], lista2: List[Int]): List[Int] =
		@tailrec
		def mezclarRecursivo(lista1: List[Int], lista2: List[Int], mezclada: List[Int]): List[Int] =
			(lista1, lista2) match
			case (Nil, _) => mezclada.reverse ++ lista2 // Si la primera lista está vacía, añade la segunda
			case (_, Nil) => mezclada.reverse ++ lista1 // Si la segunda lista está vacía, añade la primera
			case (cabeza1 :: cola1, cabeza2 :: cola2) =>
				if (cabeza1 < cabeza2)
					mezclarRecursivo(cola1, lista2, cabeza1 :: mezclada) // Añade el elemento de la primera lista
				else
					mezclarRecursivo(lista1, cola2, cabeza2 :: mezclada) // Añade el elemento de la segunda lista

		mezclarRecursivo(lista1, lista2, List.empty[Int])