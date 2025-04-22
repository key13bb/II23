package star.key13bb
package basics

import org.junit.Test
import org.junit.jupiter.api.Assertions

class Test8:

	@Test
	def testGira(): Unit =
		Assertions.assertEquals(List(3, 4, 5, 1, 2), Eje8.gira(List(1, 2, 3, 4, 5), 2))