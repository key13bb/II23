package star.key13bb
package basics

import scala.annotation.tailrec

object Eje7:

	def repes[A](matriz: List[A]): List[A] =
		@tailrec
		def eliminarRecursivo(matriz: List[A], unicos: List[A]): List[A] = matriz match
			case cabeza :: cola =>
				if (unicos.contains(cabeza))
					eliminarRecursivo(cola, unicos) // El elemento ya existe, salta
				else
					eliminarRecursivo(cola, cabeza :: unicos) // Añade el elemento a unicos
			case Nil => unicos.reverse // Invierte la lista para mantener el orden original

		eliminarRecursivo(matriz, List.empty[A])