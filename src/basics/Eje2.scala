package star.key13bb
package basics

class Eje2(var dinero: Double = 0.0):
	// Cajero automático. Para verificar, depositar y retirar dinero, siempre que haya fondos suficientes


	def getDinero: Double = dinero

	def depositar(cantidad: Double): Unit = dinero += cantidad

	def retirar(cantidad: Double): Unit =
		if (cantidad <= dinero) dinero -= cantidad
		else throw new FondosInsuficientesException("No hay dinero suficiente")

	override def toString: String = s"Hay un total de $dinero en su cuenta."