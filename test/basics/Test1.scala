package star.key13bb
package basics

import org.junit.Test
import org.junit.jupiter.api.Assertions

class Test1:

	@Test
	def testBisiesto(): Unit =
		Assertions.assertTrue(Eje1.bisiesto(2024))
		Assertions.assertFalse(Eje1.bisiesto(2021))
		Assertions.assertFalse(Eje1.bisiesto(1900))
		Assertions.assertTrue(Eje1.bisiesto(2000))
