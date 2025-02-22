package star.key13bb
package basics

import org.junit.Test
import org.junit.jupiter.api.Assertions

class Test4 {

	@Test
	def testPrimos(): Unit =
		Assertions.assertEquals(List(2, 3, 5, 7, 11), Eje4.primos(5))
}
