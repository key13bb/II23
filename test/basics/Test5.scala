package star.key13bb
package basics

import org.junit.Test
import org.junit.jupiter.api.Assertions

class Test5:
	
	@Test
	def testMCD(): Unit =
		Assertions.assertEquals(3, Eje5.mcd(6, 9))
		Assertions.assertEquals(1, Eje5.mcd(7, 9))
		
	@Test
	def testMCM(): Unit = 
		Assertions.assertEquals(18, Eje5.mcm(6, 9))
		Assertions.assertEquals(63, Eje5.mcm(7, 9))