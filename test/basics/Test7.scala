package star.key13bb
package basics

import org.junit.Test
import org.junit.jupiter.api.Assertions

class Test7:

	@Test
	def testRepetidos(): Unit =
		val lista = List(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
		val esperado = List(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
		Assertions.assertEquals(esperado.head, Eje7.repes(lista(1)))