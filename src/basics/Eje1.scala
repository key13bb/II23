package star.key13bb
package basics

object Eje1:
	def main(args: Array[String]): Unit =
		// Determinar si un año es bisiesto
		// Un año es bisiesto si es divisible por 4, excepto los años que son divisibles por 100 pero no por 400
		if (bisiesto(2024)) println("El año 2024 es bisiesto")
		else println("El año 2024 no es bisiesto")

	def bisiesto(year: Int): Boolean =
		if (year % 4 == 0)
			if (year % 100 == 0)
				if (year % 400 == 0) true
				else false
			else true
		else false