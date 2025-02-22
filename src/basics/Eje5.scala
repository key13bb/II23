package star.key13bb
package basics

import scala.annotation.tailrec

object Eje5:
	// Máximo común divisor y mínimo común múltiplo

	@tailrec
	def mcd(a: Int, b: Int): Int =
		if (b == 0) a
		else mcd(b, a % b)

	def mcm(a: Int, b: Int): Int =
		(a * b) / mcd(a, b)
