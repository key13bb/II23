package star.key13bb
package basics

import org.junit.Test

class Test9:

	@Test
	def testMezclar(): Unit =
		val lista1 = List(1, 3, 5, 7, 9)
		val lista2 = List(2, 4, 6, 8, 10)
		val listaEsperada = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
		assert(Eje9.mezclarOrdenado(lista1, lista2) == listaEsperada)