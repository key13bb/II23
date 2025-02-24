package star.key13bb
package basics

import org.junit.Test
import org.junit.jupiter.api.Assertions

class Test3:

	@Test
	def testPalindromo(): Unit =
		Assertions.assertTrue(Eje3.palindromo("ADA"))
		Assertions.assertFalse(Eje3.palindromo("IPR"))