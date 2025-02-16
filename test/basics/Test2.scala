package star.key13bb
package basics

import org.junit.Test
import org.junit.jupiter.api.Assertions

class Test2:

	@Test
	def testGet(): Unit =
		val cuenta = new Eje2(1101.7)
		Assertions.assertEquals(1101.7, cuenta.getDinero)

	@Test
	def testDepositar(): Unit =
		val cuenta = new Eje2()
		cuenta.depositar(1101.3)
		Assertions.assertEquals(1101.3, cuenta.getDinero)

	@Test
	def testRetirarException(): Unit =
		val cuenta = new Eje2()
		cuenta.depositar(101.5)
		var exception: FondosInsuficientesException = null
		try cuenta.retirar(2000)
		catch case e: FondosInsuficientesException => exception = e

		cuenta.depositar(1001)
		cuenta.retirar(1)

		Assertions.assertEquals("No hay dinero suficiente", exception.getMessage)
		Assertions.assertEquals(1101.5, cuenta.getDinero)

	@Test
	def testString(): Unit =
		val cuenta = new Eje2(1101.1)
		Assertions.assertEquals("Hay un total de 1101.1 en su cuenta.", cuenta.toString)