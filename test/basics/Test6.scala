package star.key13bb
package basics

import org.junit.Test
import org.junit.jupiter.api.Assertions

class Test6:

	@Test
	def segundoTest(): Unit =
		val array = Array(1, 2, 3, 4, 5)
		val result = Eje6.segundo(array)
		Assertions.assertEquals(4, result)